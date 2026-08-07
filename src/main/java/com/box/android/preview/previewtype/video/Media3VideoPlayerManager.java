package com.box.android.preview.previewtype.video;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.ui.PlayerControlView;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.R;
import com.box.android.cpl.Store;
import java.net.URI;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Media3VideoPlayerManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\"\u0010\u0016\u001a\u00020\u00172\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/box/android/preview/previewtype/video/Media3VideoPlayerManager;", "", "context", "Landroid/content/Context;", "videoMediaSourceFactory", "Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;", "<init>", "(Landroid/content/Context;Lcom/box/android/preview/previewtype/video/VideoMediaSourceFactory;)V", "createGestureDetector", "Landroid/view/GestureDetector;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$State;", "Lcom/box/android/preview/previewtype/video/VideoPreviewReducer$Action;", "createPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "url", "Ljava/net/URI;", "isWatermarked", "", "createMediaSource", "Landroidx/media3/exoplayer/source/MediaSource;", "playerViewSetup", "", "playerView", "Landroidx/media3/ui/PlayerView;", "handleLifecycle", "player", "lifecycle", "Landroidx/lifecycle/Lifecycle$Event;", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Media3VideoPlayerManager {
    private static final AudioAttributes videoAudioAttributes;
    private final Context context;
    private final VideoMediaSourceFactory videoMediaSourceFactory;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: Media3VideoPlayerManager.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Media3VideoPlayerManager(Context context, VideoMediaSourceFactory videoMediaSourceFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(videoMediaSourceFactory, "videoMediaSourceFactory");
        this.context = context;
        this.videoMediaSourceFactory = videoMediaSourceFactory;
    }

    public final GestureDetector createGestureDetector(Context context, final Store<VideoPreviewReducer.State, VideoPreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(store, "store");
        return new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.box.android.preview.previewtype.video.Media3VideoPlayerManager.createGestureDetector.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent e) {
                Intrinsics.checkNotNullParameter(e, "e");
                store.send(VideoPreviewReducer.Action.VideoClicked.INSTANCE);
                return true;
            }
        });
    }

    public final ExoPlayer createPlayer(URI url, boolean isWatermarked) {
        Intrinsics.checkNotNullParameter(url, "url");
        ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(this.context).build();
        Intrinsics.checkNotNullExpressionValue(exoPlayerBuild, "build(...)");
        exoPlayerBuild.setMediaSource(createMediaSource(url, isWatermarked));
        exoPlayerBuild.prepare();
        exoPlayerBuild.setAudioAttributes(videoAudioAttributes, true);
        return exoPlayerBuild;
    }

    public final MediaSource createMediaSource(URI url, boolean isWatermarked) {
        Intrinsics.checkNotNullParameter(url, "url");
        MediaItem mediaItemFromUri = MediaItem.fromUri(url.toString());
        Intrinsics.checkNotNullExpressionValue(mediaItemFromUri, "fromUri(...)");
        MediaSource mediaSourceCreateMediaSource = this.videoMediaSourceFactory.createMediaSourceFactory(mediaItemFromUri, isWatermarked).createMediaSource(mediaItemFromUri);
        Intrinsics.checkNotNullExpressionValue(mediaSourceCreateMediaSource, "createMediaSource(...)");
        return mediaSourceCreateMediaSource;
    }

    public final void playerViewSetup(Store<VideoPreviewReducer.State, VideoPreviewReducer.Action> store, final PlayerView playerView) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(playerView, "playerView");
        playerView.setShowNextButton(false);
        playerView.setShowPreviousButton(false);
        playerView.setShowBuffering(1);
        Context context = playerView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final GestureDetector gestureDetectorCreateGestureDetector = createGestureDetector(context, store);
        playerView.setOnTouchListener(new View.OnTouchListener() { // from class: com.box.android.preview.previewtype.video.Media3VideoPlayerManager$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return Media3VideoPlayerManager.playerViewSetup$lambda$0$0(playerView, gestureDetectorCreateGestureDetector, view, motionEvent);
            }
        });
        final PlayerControlView playerControlView = (PlayerControlView) playerView.findViewById(R.id.exo_controller);
        final TextView textView = (TextView) playerControlView.findViewById(R.id.exo_position);
        final TextView textView2 = (TextView) playerControlView.findViewById(R.id.exo_duration);
        playerControlView.setProgressUpdateListener(new PlayerControlView.ProgressUpdateListener() { // from class: com.box.android.preview.previewtype.video.Media3VideoPlayerManager$$ExternalSyntheticLambda1
            @Override // androidx.media3.ui.PlayerControlView.ProgressUpdateListener
            public final void onProgressUpdate(long j, long j2) {
                Media3VideoPlayerManager.playerViewSetup$lambda$0$1$0(textView, playerControlView, textView2, j, j2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean playerViewSetup$lambda$0$0(PlayerView playerView, GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        if (playerView.isControllerFullyVisible()) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playerViewSetup$lambda$0$1$0(TextView textView, PlayerControlView playerControlView, TextView textView2, long j, long j2) {
        if (textView != null) {
            textView.setText(VideoTimeFormatter.INSTANCE.formatTime(j));
        }
        Player player = playerControlView.getPlayer();
        if (player != null) {
            long duration = player.getDuration();
            if (textView2 != null) {
                textView2.setText(VideoTimeFormatter.INSTANCE.formatTime(duration));
            }
        }
    }

    public final void handleLifecycle(ExoPlayer player, Lifecycle.Event lifecycle) {
        Intrinsics.checkNotNullParameter(player, "player");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        int i = WhenMappings.$EnumSwitchMapping$0[lifecycle.ordinal()];
        if (i == 1) {
            player.pause();
        } else {
            if (i != 2) {
                return;
            }
            player.release();
        }
    }

    /* JADX INFO: compiled from: Media3VideoPlayerManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/preview/previewtype/video/Media3VideoPlayerManager$Companion;", "", "<init>", "()V", "videoAudioAttributes", "Landroidx/media3/common/AudioAttributes;", "getVideoAudioAttributes", "()Landroidx/media3/common/AudioAttributes;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AudioAttributes getVideoAudioAttributes() {
            return Media3VideoPlayerManager.videoAudioAttributes;
        }
    }

    static {
        AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
        Intrinsics.checkNotNullExpressionValue(audioAttributesBuild, "build(...)");
        videoAudioAttributes = audioAttributesBuild;
    }
}
