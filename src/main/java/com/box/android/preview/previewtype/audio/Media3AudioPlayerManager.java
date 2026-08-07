package com.box.android.preview.previewtype.audio;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.common.Tracks;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaSession;
import androidx.media3.session.SessionToken;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.coreservices.modelcontroller.messages.BoxSwitchUserMessage;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewSource;
import com.box.android.preview.integration.media3.Media3DataSourceFactory;
import com.box.android.preview.preview.PreviewActivity;
import com.box.android.preview.previewtype.audio.helper.AudioMediaItemCreator;
import com.box.android.preview.previewtype.audio.helper.CoverArtExtractor;
import com.box.android.preview.previewtype.audio.listener.MediaSessionPlayerListener;
import com.box.android.preview.previewtype.audio.model.AudioTrack;
import com.box.androidsdk.content.models.BoxSession;
import com.google.common.util.concurrent.ListenableFuture;
import com.microsoft.intune.mam.client.app.MAMPendingIntent;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.guava.ListenableFutureKt;

/* JADX INFO: compiled from: Media3AudioPlayerManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Singleton
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001DB)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010$\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&J\u001c\u0010'\u001a\u00020(2\u0006\u0010%\u001a\u00020&2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020(0*J\u000e\u0010+\u001a\u00020(2\u0006\u0010%\u001a\u00020&J\u0006\u0010,\u001a\u00020(J4\u0010-\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u000203H\u0086@¢\u0006\u0002\u00104J\u000e\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u001eJ \u00107\u001a\u00020(2\u0006\u0010%\u001a\u00020&2\u0006\u00108\u001a\u0002092\u0006\u00102\u001a\u000203H\u0002J&\u0010:\u001a\u00020(2\u0006\u0010%\u001a\u00020&2\f\u0010.\u001a\b\u0012\u0004\u0012\u0002000/2\u0006\u00102\u001a\u000203H\u0002J\b\u0010;\u001a\u00020(H\u0002J\u0018\u0010<\u001a\u00020=2\u0006\u0010%\u001a\u00020&2\u0006\u0010>\u001a\u00020?H\u0002J\u0010\u0010@\u001a\u0004\u0018\u00010A2\u0006\u0010B\u001a\u00020CR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u0011@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\f\u001a\u0004\u0018\u00010\u0019@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"8F¢\u0006\u0006\u001a\u0004\b!\u0010#¨\u0006E"}, d2 = {"Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "media3DataSourceFactory", "Lcom/box/android/preview/integration/media3/Media3DataSourceFactory;", "mediaItemCreator", "Lcom/box/android/preview/previewtype/audio/helper/AudioMediaItemCreator;", "coverArtExtractor", "Lcom/box/android/preview/previewtype/audio/helper/CoverArtExtractor;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/preview/integration/media3/Media3DataSourceFactory;Lcom/box/android/preview/previewtype/audio/helper/AudioMediaItemCreator;Lcom/box/android/preview/previewtype/audio/helper/CoverArtExtractor;)V", "value", "Landroid/content/BroadcastReceiver;", "userChangeReceiver", "getUserChangeReceiver", "()Landroid/content/BroadcastReceiver;", "Landroidx/media3/session/MediaSession;", "mediaSession", "getMediaSession", "()Landroidx/media3/session/MediaSession;", "Landroidx/media3/common/Player$Listener;", "mediaSessionPlayerListener", "getMediaSessionPlayerListener", "()Landroidx/media3/common/Player$Listener;", "Landroidx/media3/session/MediaController;", "mediaController", "getMediaController", "()Landroidx/media3/session/MediaController;", "currentItemId", "", "getCurrentItemId", "()Ljava/lang/String;", "isPlaying", "", "()Z", "createMediaSession", "context", "Landroid/content/Context;", "registerUserChangeReceiver", "", "onChange", "Lkotlin/Function0;", "unregisterUserChangeReceiver", "clearMediaSession", "initializeMediaController", "playlist", "", "Lcom/box/android/preview/previewtype/audio/model/AudioTrack;", "initialAudioTrack", "initialPreviewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "(Landroid/content/Context;Ljava/util/List;Lcom/box/android/preview/previewtype/audio/model/AudioTrack;Lcom/box/android/domain/models/preview/PreviewSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "seekToItemInPlaylist", "mediaId", "setMediaSessionActivity", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "setMediaSessionPlayerListener", "removeMediaSessionPlayerListener", "setupExoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "boxSession", "Lcom/box/android/coreservices/models/CustomBoxSession;", "getCoverArt", "Landroid/graphics/Bitmap;", "tracks", "Landroidx/media3/common/Tracks;", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Media3AudioPlayerManager {
    private static final AudioAttributes musicAudioAttributes;
    private static final List<String> userChangeActions;
    private final CoverArtExtractor coverArtExtractor;
    private final Media3DataSourceFactory media3DataSourceFactory;
    private MediaController mediaController;
    private final AudioMediaItemCreator mediaItemCreator;
    private MediaSession mediaSession;
    private Player.Listener mediaSessionPlayerListener;
    private BroadcastReceiver userChangeReceiver;
    private final IUserContextManager userContextManager;
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.box.android.preview.previewtype.audio.Media3AudioPlayerManager$initializeMediaController$1, reason: invalid class name */
    /* JADX INFO: compiled from: Media3AudioPlayerManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.previewtype.audio.Media3AudioPlayerManager", f = "Media3AudioPlayerManager.kt", i = {0, 0, 0, 0, 0}, l = {105}, m = "initializeMediaController", n = {"context", "playlist", "initialAudioTrack", "initialPreviewSource", "sessionToken"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return Media3AudioPlayerManager.this.initializeMediaController(null, null, null, null, this);
        }
    }

    @Inject
    public Media3AudioPlayerManager(IUserContextManager userContextManager, Media3DataSourceFactory media3DataSourceFactory, AudioMediaItemCreator mediaItemCreator, CoverArtExtractor coverArtExtractor) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(media3DataSourceFactory, "media3DataSourceFactory");
        Intrinsics.checkNotNullParameter(mediaItemCreator, "mediaItemCreator");
        Intrinsics.checkNotNullParameter(coverArtExtractor, "coverArtExtractor");
        this.userContextManager = userContextManager;
        this.media3DataSourceFactory = media3DataSourceFactory;
        this.mediaItemCreator = mediaItemCreator;
        this.coverArtExtractor = coverArtExtractor;
    }

    public final BroadcastReceiver getUserChangeReceiver() {
        return this.userChangeReceiver;
    }

    public final MediaSession getMediaSession() {
        return this.mediaSession;
    }

    public final Player.Listener getMediaSessionPlayerListener() {
        return this.mediaSessionPlayerListener;
    }

    public final MediaController getMediaController() {
        return this.mediaController;
    }

    public final String getCurrentItemId() {
        MediaItem currentMediaItem;
        MediaController mediaController = this.mediaController;
        if (mediaController == null || (currentMediaItem = mediaController.getCurrentMediaItem()) == null) {
            return null;
        }
        return currentMediaItem.mediaId;
    }

    public final boolean isPlaying() {
        Player player;
        MediaSession mediaSession = this.mediaSession;
        return (mediaSession == null || (player = mediaSession.getPlayer()) == null || !player.isPlaying()) ? false : true;
    }

    public final MediaSession createMediaSession(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BoxSession boxSession = this.userContextManager.getBoxSession(context);
        Intrinsics.checkNotNull(boxSession, "null cannot be cast to non-null type com.box.android.coreservices.models.CustomBoxSession");
        MediaSession mediaSessionBuild = new MediaSession.Builder(context, setupExoPlayer(context, (CustomBoxSession) boxSession)).build();
        Intrinsics.checkNotNullExpressionValue(mediaSessionBuild, "build(...)");
        this.mediaSession = mediaSessionBuild;
        return mediaSessionBuild;
    }

    public final void registerUserChangeReceiver(Context context, final Function0<Unit> onChange) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onChange, "onChange");
        if (this.userChangeReceiver == null) {
            this.userChangeReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.preview.previewtype.audio.Media3AudioPlayerManager.registerUserChangeReceiver.1
                @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
                public void onMAMReceive(Context context2, Intent intent) {
                    String action;
                    if (intent == null || (action = intent.getAction()) == null) {
                        return;
                    }
                    Function0<Unit> function0 = onChange;
                    if (Media3AudioPlayerManager.userChangeActions.contains(action)) {
                        function0.invoke();
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            Iterator<T> it = userChangeActions.iterator();
            while (it.hasNext()) {
                intentFilter.addAction((String) it.next());
            }
            LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
            BroadcastReceiver broadcastReceiver = this.userChangeReceiver;
            Intrinsics.checkNotNull(broadcastReceiver);
            localBroadcastManager.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public final void unregisterUserChangeReceiver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BroadcastReceiver broadcastReceiver = this.userChangeReceiver;
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
            this.userChangeReceiver = null;
        }
    }

    public final void clearMediaSession() {
        removeMediaSessionPlayerListener();
        this.mediaSession = null;
        this.mediaSessionPlayerListener = null;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object initializeMediaController(Context context, List<AudioTrack> list, AudioTrack audioTrack, PreviewSource previewSource, Continuation<? super MediaController> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwait = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwait);
            SessionToken sessionTokenCreateSessionToken = AudioPlayerService.INSTANCE.createSessionToken(context);
            ListenableFuture<MediaController> listenableFutureBuildAsync = new MediaController.Builder(context, sessionTokenCreateSessionToken).buildAsync();
            Intrinsics.checkNotNullExpressionValue(listenableFutureBuildAsync, "buildAsync(...)");
            anonymousClass1.L$0 = context;
            anonymousClass1.L$1 = list;
            anonymousClass1.L$2 = audioTrack;
            anonymousClass1.L$3 = previewSource;
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(sessionTokenCreateSessionToken);
            anonymousClass1.label = 1;
            objAwait = ListenableFutureKt.await(listenableFutureBuildAsync, anonymousClass1);
            if (objAwait == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            previewSource = (PreviewSource) anonymousClass1.L$3;
            audioTrack = (AudioTrack) anonymousClass1.L$2;
            list = (List) anonymousClass1.L$1;
            context = (Context) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objAwait);
        }
        Intrinsics.checkNotNullExpressionValue(objAwait, "await(...)");
        MediaController mediaController = (MediaController) objAwait;
        setMediaSessionActivity(context, audioTrack.getFileModel(), previewSource);
        setMediaSessionPlayerListener(context, list, previewSource);
        MediaItem currentMediaItem = mediaController.getCurrentMediaItem();
        boolean zAreEqual = Intrinsics.areEqual(currentMediaItem != null ? currentMediaItem.mediaId : null, audioTrack.getFileModel().getItemId().toString());
        List<AudioTrack> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (AudioTrack audioTrack2 : list2) {
            arrayList.add(this.mediaItemCreator.create(audioTrack2.getUri(), audioTrack2.getFileModel()));
        }
        ArrayList arrayList2 = arrayList;
        int i2 = 0;
        IntRange intRangeUntil = RangesKt.until(0, mediaController.getMediaItemCount());
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeUntil, 10));
        Iterator<Integer> it = intRangeUntil.iterator();
        while (it.hasNext()) {
            arrayList3.add(mediaController.getMediaItemAt(((IntIterator) it).nextInt()));
        }
        ArrayList arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        Iterator it2 = arrayList4.iterator();
        while (it2.hasNext()) {
            arrayList5.add(((MediaItem) it2.next()).mediaId);
        }
        ArrayList arrayList6 = arrayList5;
        ArrayList arrayList7 = arrayList2;
        ArrayList arrayList8 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList7, 10));
        Iterator it3 = arrayList7.iterator();
        while (it3.hasNext()) {
            arrayList8.add(((MediaItem) it3.next()).mediaId);
        }
        if (!Intrinsics.areEqual(arrayList6, arrayList8)) {
            Iterator<MediaItem> it4 = arrayList2.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    i2 = -1;
                    break;
                }
                if (Intrinsics.areEqual(it4.next().mediaId, currentMediaItem != null ? currentMediaItem.mediaId : null)) {
                    break;
                }
                i2++;
            }
            mediaController.setMediaItems(arrayList2, i2, i2 != -1 ? mediaController.getCurrentPosition() : 0L);
            mediaController.prepare();
        }
        if (!zAreEqual) {
            mediaController.seekTo(list.indexOf(audioTrack), 0L);
            mediaController.play();
        }
        this.mediaController = mediaController;
        return mediaController;
    }

    public final void seekToItemInPlaylist(String mediaId) {
        Intrinsics.checkNotNullParameter(mediaId, "mediaId");
        MediaController mediaController = this.mediaController;
        if (mediaController == null) {
            return;
        }
        int mediaItemCount = mediaController.getMediaItemCount();
        for (int i = 0; i < mediaItemCount; i++) {
            MediaItem mediaItemAt = mediaController.getMediaItemAt(i);
            Intrinsics.checkNotNullExpressionValue(mediaItemAt, "getMediaItemAt(...)");
            if (Intrinsics.areEqual(mediaItemAt.mediaId, mediaId)) {
                MediaItem currentMediaItem = mediaController.getCurrentMediaItem();
                if (!Intrinsics.areEqual(currentMediaItem != null ? currentMediaItem.mediaId : null, mediaId)) {
                    mediaController.seekToDefaultPosition(i);
                    return;
                }
            }
        }
    }

    private final void setMediaSessionActivity(Context context, FileModel fileModel, PreviewSource initialPreviewSource) {
        MediaSession mediaSession = this.mediaSession;
        if (mediaSession != null) {
            mediaSession.setSessionActivity(MAMPendingIntent.getActivity(context, 0, PreviewActivity.Companion.getIntent$default(PreviewActivity.INSTANCE, new IPreviewLauncher.NavigationData(context, fileModel, new PreviewSource.AudioNotification(initialPreviewSource), null, null, false, false, 120, null), null, 2, null), 201326592));
        }
    }

    private final void setMediaSessionPlayerListener(final Context context, List<AudioTrack> playlist, final PreviewSource initialPreviewSource) {
        Player player;
        removeMediaSessionPlayerListener();
        MediaSessionPlayerListener mediaSessionPlayerListener = new MediaSessionPlayerListener(playlist, new Function1() { // from class: com.box.android.preview.previewtype.audio.Media3AudioPlayerManager$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Media3AudioPlayerManager.setMediaSessionPlayerListener$lambda$0(this.f$0, context, initialPreviewSource, (AudioTrack) obj);
            }
        });
        this.mediaSessionPlayerListener = mediaSessionPlayerListener;
        MediaSession mediaSession = this.mediaSession;
        if (mediaSession == null || (player = mediaSession.getPlayer()) == null) {
            return;
        }
        player.addListener(mediaSessionPlayerListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setMediaSessionPlayerListener$lambda$0(Media3AudioPlayerManager media3AudioPlayerManager, Context context, PreviewSource previewSource, AudioTrack audioTrack) {
        Intrinsics.checkNotNullParameter(audioTrack, "audioTrack");
        media3AudioPlayerManager.setMediaSessionActivity(context, audioTrack.getFileModel(), previewSource);
        return Unit.INSTANCE;
    }

    private final void removeMediaSessionPlayerListener() {
        MediaSession mediaSession;
        Player player;
        Player.Listener listener = this.mediaSessionPlayerListener;
        if (listener == null || (mediaSession = this.mediaSession) == null || (player = mediaSession.getPlayer()) == null) {
            return;
        }
        player.removeListener(listener);
    }

    private final ExoPlayer setupExoPlayer(Context context, CustomBoxSession boxSession) {
        ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(context).setMediaSourceFactory(new ProgressiveMediaSource.Factory(this.media3DataSourceFactory.createFactory(boxSession))).build();
        Intrinsics.checkNotNullExpressionValue(exoPlayerBuild, "build(...)");
        exoPlayerBuild.setAudioAttributes(musicAudioAttributes, true);
        return exoPlayerBuild;
    }

    public final Bitmap getCoverArt(Tracks tracks) {
        Intrinsics.checkNotNullParameter(tracks, "tracks");
        return this.coverArtExtractor.getCoverArt(tracks);
    }

    static {
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(1).setContentType(2).build();
        Intrinsics.checkNotNullExpressionValue(audioAttributesBuild, "build(...)");
        musicAudioAttributes = audioAttributesBuild;
        userChangeActions = CollectionsKt.listOf((Object[]) new String[]{BoxSwitchUserMessage.ACTION_SWITCHED_USER, BoxSwitchUserMessage.ACTION_DESTROYED_USER});
    }
}
