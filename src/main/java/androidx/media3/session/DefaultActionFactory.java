package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes8.dex */
final class DefaultActionFactory implements MediaNotification.ActionFactory {
    private final MediaSessionService service;

    public static KeyEvent getKeyEvent(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null || !extras.containsKey("android.intent.extra.KEY_EVENT")) {
            return null;
        }
        return (KeyEvent) extras.getParcelable("android.intent.extra.KEY_EVENT");
    }

    public DefaultActionFactory(MediaSessionService mediaSessionService) {
        this.service = mediaSessionService;
    }

    @Override // androidx.media3.session.MediaNotification.ActionFactory
    public NotificationCompat.Action createMediaAction(MediaSession mediaSession, IconCompat iconCompat, CharSequence charSequence, int i) {
        return new NotificationCompat.Action(iconCompat, charSequence, createMediaActionPendingIntent(mediaSession, i));
    }

    @Override // androidx.media3.session.MediaNotification.ActionFactory
    public NotificationCompat.Action createCustomAction(MediaSession mediaSession, IconCompat iconCompat, CharSequence charSequence, String str, Bundle bundle) {
        MediaSessionService mediaSessionService = this.service;
        return new NotificationCompat.Action(iconCompat, charSequence, new CustomCommandPendingIntentBuilder(mediaSessionService, mediaSessionService.getClass(), new SessionCommand(str, bundle)).setSessionId(mediaSession.getId()).build());
    }

    @Override // androidx.media3.session.MediaNotification.ActionFactory
    public NotificationCompat.Action createCustomActionFromCustomCommandButton(MediaSession mediaSession, CommandButton commandButton) {
        Preconditions.checkArgument(commandButton.sessionCommand != null && commandButton.sessionCommand.commandCode == 0);
        SessionCommand sessionCommand = (SessionCommand) Preconditions.checkNotNull(commandButton.sessionCommand);
        IconCompat iconCompatCreateWithResource = IconCompat.createWithResource(this.service, commandButton.iconResId);
        CharSequence charSequence = commandButton.displayName;
        MediaSessionService mediaSessionService = this.service;
        return new NotificationCompat.Action(iconCompatCreateWithResource, charSequence, new CustomCommandPendingIntentBuilder(mediaSessionService, mediaSessionService.getClass(), sessionCommand).setSessionId(mediaSession.getId()).build());
    }

    @Override // androidx.media3.session.MediaNotification.ActionFactory
    public PendingIntent createMediaActionPendingIntent(MediaSession mediaSession, int i) {
        MediaSessionService mediaSessionService = this.service;
        return new PlaybackPendingIntentBuilder(mediaSessionService, i, mediaSessionService.getClass()).setStartAsForegroundService(!mediaSession.getPlayer().getPlayWhenReady()).setSessionId(mediaSession.getId()).build();
    }

    @Override // androidx.media3.session.MediaNotification.ActionFactory
    public PendingIntent createNotificationDismissalIntent(MediaSession mediaSession) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(MediaNotification.NOTIFICATION_DISMISSED_EVENT_KEY, true);
        MediaSessionService mediaSessionService = this.service;
        return new PlaybackPendingIntentBuilder(mediaSessionService, 3, mediaSessionService.getClass()).setSessionId(mediaSession.getId()).setExtras(bundle).build();
    }

    public boolean isMediaAction(Intent intent) {
        return "android.intent.action.MEDIA_BUTTON".equals(intent.getAction());
    }

    public boolean isCustomAction(Intent intent) {
        return "androidx.media3.session.CUSTOM_NOTIFICATION_ACTION".equals(intent.getAction());
    }

    public String getCustomAction(Intent intent) {
        Bundle extras = intent.getExtras();
        Object obj = extras != null ? extras.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION") : null;
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public Bundle getCustomActionExtras(Intent intent) {
        Bundle extras = intent.getExtras();
        Object obj = extras != null ? extras.get("androidx.media3.session.EXTRAS_KEY_CUSTOM_NOTIFICATION_ACTION_EXTRAS") : null;
        return obj instanceof Bundle ? (Bundle) obj : Bundle.EMPTY;
    }
}
