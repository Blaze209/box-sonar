package sdk.pendo.io.views.custom.videoplayer.common;

import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import sdk.pendo.io.views.custom.videoplayer.youtube.PendoYoutubePlayer;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/views/custom/videoplayer/common/VideoPlayerView;", "", "setAspectRatio", "", ViewProps.ASPECT_RATIO, "", "setAutoPlay", PendoYoutubePlayer.AUTOPLAY_PARAMETER, "", "setImageWidthInPercents", "width", "", "setVideoId", "videoId", "setVideoUrl", "videoUrl", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface VideoPlayerView {
    void setAspectRatio(String aspectRatio);

    void setAutoPlay(boolean autoplay);

    void setImageWidthInPercents(int width);

    void setVideoId(String videoId);

    void setVideoUrl(String videoUrl);
}
