package androidx.media3.session;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.media3.common.Player;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.microsoft.intune.mam.client.app.MAMNotificationManagement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes8.dex */
final class MediaNotificationManager implements Handler.Callback {
    private static final int MSG_USER_ENGAGED_TIMEOUT = 1;
    static final String SELF_INTENT_UID_KEY = "androidx.media3.session.intent.uid";
    private static final int SHUTDOWN_NOTIFICATION_ID = 20938;
    private static final String TAG = "MediaNtfMng";
    private final MediaNotification.ActionFactory actionFactory;
    private final Map<MediaSession, ControllerInfo> controllerMap;
    private boolean isUserEngaged;
    private boolean isUserEngagedTimeoutEnabled;
    private MediaNotification mediaNotification;
    private MediaNotification.Provider mediaNotificationProvider;
    private final MediaSessionService mediaSessionService;
    private final NotificationManager notificationManager;
    int showNotificationForIdlePlayerMode;
    private final Intent startSelfIntent;
    private final String startSelfIntentUid;
    private boolean startedInForeground;
    private int totalNotificationCount;
    private long userEngagedTimeoutMs;
    private final Handler mainHandler = Util.createHandler(Looper.getMainLooper(), this);
    private final Executor mainExecutor = new Executor() { // from class: androidx.media3.session.MediaNotificationManager$$ExternalSyntheticLambda2
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f$0.m10775lambda$new$0$androidxmedia3sessionMediaNotificationManager(runnable);
        }
    };

    public MediaNotificationManager(MediaSessionService mediaSessionService, MediaNotification.Provider provider, MediaNotification.ActionFactory actionFactory) {
        this.mediaSessionService = mediaSessionService;
        this.mediaNotificationProvider = provider;
        this.actionFactory = actionFactory;
        this.notificationManager = (NotificationManager) Preconditions.checkNotNull((NotificationManager) mediaSessionService.getSystemService("notification"));
        Intent intent = new Intent(mediaSessionService, mediaSessionService.getClass());
        this.startSelfIntent = intent;
        String string = UUID.randomUUID().toString();
        this.startSelfIntentUid = string;
        intent.putExtra(SELF_INTENT_UID_KEY, string);
        this.controllerMap = new HashMap();
        this.startedInForeground = false;
        this.isUserEngagedTimeoutEnabled = true;
        this.userEngagedTimeoutMs = 600000L;
        this.showNotificationForIdlePlayerMode = 3;
    }

    /* JADX INFO: renamed from: lambda$new$0$androidx-media3-session-MediaNotificationManager, reason: not valid java name */
    /* synthetic */ void m10775lambda$new$0$androidxmedia3sessionMediaNotificationManager(Runnable runnable) {
        Util.postOrRun(this.mainHandler, runnable);
    }

    String getStartSelfIntentUid() {
        return this.startSelfIntentUid;
    }

    public void addSession(final MediaSession mediaSession) {
        if (this.controllerMap.containsKey(mediaSession)) {
            return;
        }
        final MediaControllerListener mediaControllerListener = new MediaControllerListener(this.mediaSessionService, mediaSession);
        Bundle bundle = new Bundle();
        bundle.putBoolean(MediaController.KEY_MEDIA_NOTIFICATION_CONTROLLER_FLAG, true);
        final ListenableFuture<MediaController> listenableFutureBuildAsync = new MediaController.Builder(this.mediaSessionService, mediaSession.getToken()).setConnectionHints(bundle).setListener(mediaControllerListener).setApplicationLooper(Looper.getMainLooper()).buildAsync();
        this.controllerMap.put(mediaSession, new ControllerInfo(listenableFutureBuildAsync));
        listenableFutureBuildAsync.addListener(new Runnable() { // from class: androidx.media3.session.MediaNotificationManager$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10774x67573ed4(listenableFutureBuildAsync, mediaControllerListener, mediaSession);
            }
        }, this.mainExecutor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: lambda$addSession$1$androidx-media3-session-MediaNotificationManager, reason: not valid java name */
    /* synthetic */ void m10774x67573ed4(ListenableFuture listenableFuture, MediaControllerListener mediaControllerListener, MediaSession mediaSession) {
        try {
            MediaController mediaController = (MediaController) listenableFuture.get(0L, TimeUnit.MILLISECONDS);
            mediaControllerListener.onConnected(shouldShowNotification(mediaSession));
            mediaController.addListener(mediaControllerListener);
        } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException unused) {
            this.mediaSessionService.removeSession(mediaSession);
        }
    }

    public void removeSession(MediaSession mediaSession) {
        ControllerInfo controllerInfoRemove = this.controllerMap.remove(mediaSession);
        if (controllerInfoRemove != null) {
            MediaController.releaseFuture(controllerInfoRemove.controllerFuture);
        }
    }

    public void onCustomAction(final MediaSession mediaSession, final String str, final Bundle bundle) {
        final MediaController connectedControllerForSession = getConnectedControllerForSession(mediaSession);
        if (connectedControllerForSession == null) {
            return;
        }
        Util.postOrRun(new Handler(mediaSession.getPlayer().getApplicationLooper()), new Runnable() { // from class: androidx.media3.session.MediaNotificationManager$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10777x54793c21(mediaSession, str, bundle, connectedControllerForSession);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$onCustomAction$3$androidx-media3-session-MediaNotificationManager, reason: not valid java name */
    /* synthetic */ void m10777x54793c21(MediaSession mediaSession, final String str, final Bundle bundle, final MediaController mediaController) {
        if (this.mediaNotificationProvider.handleCustomCommand(mediaSession, str, bundle)) {
            return;
        }
        this.mainExecutor.execute(new Runnable() { // from class: androidx.media3.session.MediaNotificationManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10776x62cf9602(mediaController, str, bundle);
            }
        });
    }

    public void setMediaNotificationProvider(MediaNotification.Provider provider) {
        this.mediaNotificationProvider = provider;
    }

    public void updateNotification(final MediaSession mediaSession, final boolean z) {
        if (!this.mediaSessionService.isSessionAdded(mediaSession) || !shouldShowNotification(mediaSession)) {
            removeNotification();
            return;
        }
        final int i = this.totalNotificationCount + 1;
        this.totalNotificationCount = i;
        final ImmutableList<CommandButton> mediaButtonPreferences = ((MediaController) Preconditions.checkNotNull(getConnectedControllerForSession(mediaSession))).getMediaButtonPreferences();
        final MediaNotification.Provider.Callback callback = new MediaNotification.Provider.Callback() { // from class: androidx.media3.session.MediaNotificationManager$$ExternalSyntheticLambda5
            @Override // androidx.media3.session.MediaNotification.Provider.Callback
            public final void onNotificationChanged(MediaNotification mediaNotification) {
                this.f$0.m10779xb22eb051(i, mediaSession, mediaNotification);
            }
        };
        Util.postOrRun(new Handler(mediaSession.getPlayer().getApplicationLooper()), new Runnable() { // from class: androidx.media3.session.MediaNotificationManager$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10781x9581fc8f(mediaSession, mediaButtonPreferences, callback, z);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$updateNotification$5$androidx-media3-session-MediaNotificationManager, reason: not valid java name */
    /* synthetic */ void m10779xb22eb051(final int i, final MediaSession mediaSession, final MediaNotification mediaNotification) {
        this.mainExecutor.execute(new Runnable() { // from class: androidx.media3.session.MediaNotificationManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10778xc0850a32(i, mediaSession, mediaNotification);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$updateNotification$7$androidx-media3-session-MediaNotificationManager, reason: not valid java name */
    /* synthetic */ void m10781x9581fc8f(final MediaSession mediaSession, ImmutableList immutableList, MediaNotification.Provider.Callback callback, final boolean z) {
        final MediaNotification mediaNotificationCreateNotification = this.mediaNotificationProvider.createNotification(mediaSession, immutableList, this.actionFactory, callback);
        Preconditions.checkState(mediaNotificationCreateNotification.notificationId != SHUTDOWN_NOTIFICATION_ID, "notification ID 20938 is already used internally.");
        this.mainExecutor.execute(new Runnable() { // from class: androidx.media3.session.MediaNotificationManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m10780xa3d85670(mediaSession, mediaNotificationCreateNotification, z);
            }
        });
    }

    public boolean isStartedInForeground() {
        return this.startedInForeground;
    }

    public void setUserEngagedTimeoutMs(long j) {
        this.userEngagedTimeoutMs = j;
    }

    public void setShowNotificationForIdlePlayer(int i) {
        this.showNotificationForIdlePlayerMode = i;
        List<MediaSession> sessions = this.mediaSessionService.getSessions();
        for (int i2 = 0; i2 < sessions.size(); i2++) {
            this.mediaSessionService.onUpdateNotificationInternal(sessions.get(i2), false);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        List<MediaSession> sessions = this.mediaSessionService.getSessions();
        for (int i = 0; i < sessions.size(); i++) {
            this.mediaSessionService.onUpdateNotificationInternal(sessions.get(i), false);
        }
        return true;
    }

    boolean shouldRunInForeground(boolean z) {
        boolean zIsAnySessionUserEngaged = isAnySessionUserEngaged(z);
        boolean z2 = this.isUserEngagedTimeoutEnabled && this.userEngagedTimeoutMs > 0;
        if (this.isUserEngaged && !zIsAnySessionUserEngaged && z2) {
            this.mainHandler.sendEmptyMessageDelayed(1, this.userEngagedTimeoutMs);
        } else if (zIsAnySessionUserEngaged) {
            this.mainHandler.removeMessages(1);
        }
        this.isUserEngaged = zIsAnySessionUserEngaged;
        return zIsAnySessionUserEngaged || this.mainHandler.hasMessages(1);
    }

    private boolean isAnySessionUserEngaged(boolean z) {
        List<MediaSession> sessions = this.mediaSessionService.getSessions();
        for (int i = 0; i < sessions.size(); i++) {
            MediaController connectedControllerForSession = getConnectedControllerForSession(sessions.get(i));
            if (connectedControllerForSession != null && ((connectedControllerForSession.getPlayWhenReady() || z) && (connectedControllerForSession.getPlaybackState() == 3 || connectedControllerForSession.getPlaybackState() == 2))) {
                return true;
            }
        }
        return false;
    }

    void disableUserEngagedTimeout() {
        this.isUserEngagedTimeoutEnabled = false;
        if (this.mainHandler.hasMessages(1)) {
            this.mainHandler.removeMessages(1);
            List<MediaSession> sessions = this.mediaSessionService.getSessions();
            for (int i = 0; i < sessions.size(); i++) {
                this.mediaSessionService.onUpdateNotificationInternal(sessions.get(i), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onNotificationUpdated, reason: merged with bridge method [inline-methods] */
    public void m10778xc0850a32(int i, MediaSession mediaSession, MediaNotification mediaNotification) {
        if (i == this.totalNotificationCount) {
            m10780xa3d85670(mediaSession, mediaNotification, shouldRunInForeground(false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNotificationDismissed(MediaSession mediaSession) {
        ControllerInfo controllerInfo = this.controllerMap.get(mediaSession);
        if (controllerInfo != null) {
            controllerInfo.wasNotificationDismissed = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateNotificationInternal, reason: merged with bridge method [inline-methods] */
    public void m10780xa3d85670(MediaSession mediaSession, MediaNotification mediaNotification, boolean z) {
        mediaNotification.notification.extras.putParcelable(NotificationCompat.EXTRA_MEDIA_SESSION, mediaSession.getPlatformToken());
        this.mediaNotification = mediaNotification;
        if (z) {
            startForeground(mediaNotification);
        } else {
            MAMNotificationManagement.notify(this.notificationManager, mediaNotification.notificationId, mediaNotification.notification);
            Util.stopForeground(this.mediaSessionService, false);
        }
    }

    private void removeNotification() {
        Util.stopForeground(this.mediaSessionService, true);
        MediaNotification mediaNotification = this.mediaNotification;
        if (mediaNotification != null) {
            this.notificationManager.cancel(mediaNotification.notificationId);
            this.totalNotificationCount++;
            this.mediaNotification = null;
        }
    }

    private boolean shouldShowNotification(MediaSession mediaSession) {
        MediaController connectedControllerForSession = getConnectedControllerForSession(mediaSession);
        if (connectedControllerForSession == null || connectedControllerForSession.getCurrentTimeline().isEmpty()) {
            return false;
        }
        ControllerInfo controllerInfo = (ControllerInfo) Preconditions.checkNotNull(this.controllerMap.get(mediaSession));
        if (connectedControllerForSession.getPlaybackState() != 1) {
            controllerInfo.wasNotificationDismissed = false;
            controllerInfo.hasBeenPrepared = true;
            return true;
        }
        int i = this.showNotificationForIdlePlayerMode;
        if (i == 1) {
            return !controllerInfo.wasNotificationDismissed;
        }
        if (i == 2) {
            return false;
        }
        if (i == 3) {
            return !controllerInfo.wasNotificationDismissed && controllerInfo.hasBeenPrepared;
        }
        throw new IllegalStateException();
    }

    private MediaController getConnectedControllerForSession(MediaSession mediaSession) {
        ControllerInfo controllerInfo = this.controllerMap.get(mediaSession);
        if (controllerInfo == null || !controllerInfo.controllerFuture.isDone()) {
            return null;
        }
        try {
            return (MediaController) Futures.getDone(controllerInfo.controllerFuture);
        } catch (ExecutionException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: sendCustomCommandIfCommandIsAvailable, reason: merged with bridge method [inline-methods] */
    public void m10776x62cf9602(MediaController mediaController, final String str, Bundle bundle) {
        SessionCommand next;
        UnmodifiableIterator<SessionCommand> it = mediaController.getAvailableSessionCommands().commands.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (next.commandCode == 0 && next.customAction.equals(str)) {
                break;
            }
        }
        if (next != null || CommandButton.isPredefinedCustomCommandButtonCode(str)) {
            Futures.addCallback(mediaController.sendCustomCommand(new SessionCommand(str, bundle), bundle), new FutureCallback<SessionResult>() { // from class: androidx.media3.session.MediaNotificationManager.1
                @Override // com.google.common.util.concurrent.FutureCallback
                public void onSuccess(SessionResult sessionResult) {
                }

                @Override // com.google.common.util.concurrent.FutureCallback
                public void onFailure(Throwable th) {
                    Log.w(MediaNotificationManager.TAG, "custom command " + str + " produced an error: " + th.getMessage(), th);
                }
            }, MoreExecutors.directExecutor());
        }
    }

    Pair<Integer, Notification> createShutdownNotification(Context context) {
        MediaNotification.Provider.NotificationChannelInfo notificationChannelInfo = this.mediaNotificationProvider.getNotificationChannelInfo();
        Util.ensureNotificationChannel(this.notificationManager, notificationChannelInfo.getId(), notificationChannelInfo.getName());
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, notificationChannelInfo.getId());
        if (Build.VERSION.SDK_INT >= 31) {
            builder.setForegroundServiceBehavior(2);
        }
        return new Pair<>(Integer.valueOf(SHUTDOWN_NOTIFICATION_ID), builder.setOnlyAlertOnce(true).setSmallIcon(R.drawable.media3_notification_small_icon).setVisibility(-1).setOngoing(false).build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class MediaControllerListener implements MediaController.Listener, Player.Listener {
        private final MediaSessionService mediaSessionService;
        private final MediaSession session;

        public MediaControllerListener(MediaSessionService mediaSessionService, MediaSession mediaSession) {
            this.mediaSessionService = mediaSessionService;
            this.session = mediaSession;
        }

        public void onConnected(boolean z) {
            if (z) {
                this.mediaSessionService.onUpdateNotificationInternal(this.session, false);
            }
        }

        @Override // androidx.media3.session.MediaController.Listener
        public void onMediaButtonPreferencesChanged(MediaController mediaController, List<CommandButton> list) {
            this.mediaSessionService.onUpdateNotificationInternal(this.session, false);
        }

        @Override // androidx.media3.session.MediaController.Listener
        public void onAvailableSessionCommandsChanged(MediaController mediaController, SessionCommands sessionCommands) {
            this.mediaSessionService.onUpdateNotificationInternal(this.session, false);
        }

        @Override // androidx.media3.session.MediaController.Listener
        public ListenableFuture<SessionResult> onCustomCommand(MediaController mediaController, SessionCommand sessionCommand, Bundle bundle) {
            int i;
            if (sessionCommand.customAction.equals(MediaNotification.NOTIFICATION_DISMISSED_EVENT_KEY)) {
                MediaNotificationManager.this.onNotificationDismissed(this.session);
                i = 0;
            } else {
                i = -6;
            }
            return Futures.immediateFuture(new SessionResult(i));
        }

        @Override // androidx.media3.session.MediaController.Listener
        public void onDisconnected(MediaController mediaController) {
            if (this.mediaSessionService.isSessionAdded(this.session)) {
                this.mediaSessionService.removeSession(this.session);
            }
            this.mediaSessionService.onUpdateNotificationInternal(this.session, false);
        }

        @Override // androidx.media3.common.Player.Listener
        public void onEvents(Player player, Player.Events events) {
            if (events.containsAny(4, 5, 14, 0)) {
                this.mediaSessionService.onUpdateNotificationInternal(this.session, false);
            }
        }
    }

    private void startForeground(MediaNotification mediaNotification) {
        ContextCompat.startForegroundService(this.mediaSessionService, this.startSelfIntent);
        Util.setForegroundServiceNotification(this.mediaSessionService, mediaNotification.notificationId, mediaNotification.notification, 2, "mediaPlayback");
        this.startedInForeground = true;
    }

    private static final class ControllerInfo {
        public final ListenableFuture<MediaController> controllerFuture;
        public boolean hasBeenPrepared;
        public boolean wasNotificationDismissed;

        public ControllerInfo(ListenableFuture<MediaController> listenableFuture) {
            this.controllerFuture = listenableFuture;
        }
    }
}
