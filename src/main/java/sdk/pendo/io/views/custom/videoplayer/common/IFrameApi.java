package sdk.pendo.io.views.custom.videoplayer.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0006H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0006H&J\b\u0010\u0015\u001a\u00020\u0003H&¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/views/custom/videoplayer/common/IFrameApi;", "", "onApiChange", "", "onError", "error", "", "onPlaybackQualityChange", "quality", "onPlaybackRateChange", "rate", "onReady", "onStateChange", "state", "onVideoCurrentTime", "seconds", "onVideoDuration", "onVideoId", "videoId", "onVideoLoadedFraction", "fraction", "onYouTubeIFrameAPIReady", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IFrameApi {
    void onApiChange();

    void onError(String error);

    void onPlaybackQualityChange(String quality);

    void onPlaybackRateChange(String rate);

    void onReady();

    void onStateChange(String state);

    void onVideoCurrentTime(String seconds);

    void onVideoDuration(String seconds);

    void onVideoId(String videoId);

    void onVideoLoadedFraction(String fraction);

    void onYouTubeIFrameAPIReady();
}
