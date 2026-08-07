package com.box.android.preview.previewtype.audio;

import android.content.ComponentName;
import android.content.Context;
import androidx.media3.session.MediaSession;
import androidx.media3.session.SessionToken;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AudioPlayerService.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/box/android/preview/previewtype/audio/AudioPlayerService;", "Landroidx/media3/session/MediaSessionService;", "<init>", "()V", "mediaSession", "Landroidx/media3/session/MediaSession;", "audioPlayerManager", "Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "getAudioPlayerManager", "()Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;", "setAudioPlayerManager", "(Lcom/box/android/preview/previewtype/audio/Media3AudioPlayerManager;)V", "onGetSession", "controllerInfo", "Landroidx/media3/session/MediaSession$ControllerInfo;", "onCreate", "", "onDestroy", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class AudioPlayerService extends Hilt_AudioPlayerService {

    @Inject
    public Media3AudioPlayerManager audioPlayerManager;
    private MediaSession mediaSession;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public final Media3AudioPlayerManager getAudioPlayerManager() {
        Media3AudioPlayerManager media3AudioPlayerManager = this.audioPlayerManager;
        if (media3AudioPlayerManager != null) {
            return media3AudioPlayerManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("audioPlayerManager");
        return null;
    }

    public final void setAudioPlayerManager(Media3AudioPlayerManager media3AudioPlayerManager) {
        Intrinsics.checkNotNullParameter(media3AudioPlayerManager, "<set-?>");
        this.audioPlayerManager = media3AudioPlayerManager;
    }

    @Override // androidx.media3.session.MediaSessionService
    public MediaSession onGetSession(MediaSession.ControllerInfo controllerInfo) {
        Intrinsics.checkNotNullParameter(controllerInfo, "controllerInfo");
        return this.mediaSession;
    }

    @Override // com.box.android.preview.previewtype.audio.Hilt_AudioPlayerService, androidx.media3.session.MediaSessionService, androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        AudioPlayerService audioPlayerService = this;
        this.mediaSession = getAudioPlayerManager().createMediaSession(audioPlayerService);
        getAudioPlayerManager().registerUserChangeReceiver(audioPlayerService, new Function0() { // from class: com.box.android.preview.previewtype.audio.AudioPlayerService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AudioPlayerService.onCreate$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(AudioPlayerService audioPlayerService) {
        audioPlayerService.pauseAllPlayersAndStopSelf();
        return Unit.INSTANCE;
    }

    @Override // androidx.media3.session.MediaSessionService, androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        MediaSession mediaSession = this.mediaSession;
        if (mediaSession != null) {
            mediaSession.getPlayer().release();
            mediaSession.release();
            this.mediaSession = null;
        }
        getAudioPlayerManager().unregisterUserChangeReceiver(this);
        getAudioPlayerManager().clearMediaSession();
        super.onDestroy();
    }

    /* JADX INFO: compiled from: AudioPlayerService.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/previewtype/audio/AudioPlayerService$Companion;", "", "<init>", "()V", "createSessionToken", "Landroidx/media3/session/SessionToken;", "context", "Landroid/content/Context;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SessionToken createSessionToken(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new SessionToken(context, new ComponentName(context, (Class<?>) AudioPlayerService.class));
        }
    }
}
