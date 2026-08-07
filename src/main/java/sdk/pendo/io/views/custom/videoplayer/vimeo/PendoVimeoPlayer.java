package sdk.pendo.io.views.custom.videoplayer.vimeo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.R;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.custom.videoplayer.common.BaseIFrameVideoPlayer;
import sdk.pendo.io.views.custom.videoplayer.common.IFrameApi;
import sdk.pendo.io.views.custom.videoplayer.common.PendoFullscreenClient;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0002\b\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0003J\b\u0010\u0007\u001a\u00020\u0006H\u0015¨\u0006\n"}, d2 = {"Lsdk/pendo/io/views/custom/videoplayer/vimeo/PendoVimeoPlayer;", "Lsdk/pendo/io/views/custom/videoplayer/common/BaseIFrameVideoPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "setupClientAndChrome", "", "setupWebViewWithIFrame", "Companion", "IFrameJavaScriptInterface", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PendoVimeoPlayer extends BaseIFrameVideoPlayer {
    public static final String BASE_URL = "https://cdn.pendo.io/sdk-vimeo-player/player.html?videoUrl=";
    public static final String JAVASCRIPT_INTERFACE_NAME = "PendoSDK";
    public static final String PLAYER_PLAYING = "PLAYING";
    public static final String TAG = "PendoVimeoPlayer";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0017J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0017J\b\u0010\f\u001a\u00020\u0004H\u0017J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007H\u0017J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0017J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0017J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007H\u0017J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0007H\u0017J\b\u0010\u0016\u001a\u00020\u0004H\u0017¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/views/custom/videoplayer/vimeo/PendoVimeoPlayer$IFrameJavaScriptInterface;", "Lsdk/pendo/io/views/custom/videoplayer/common/IFrameApi;", "(Lsdk/pendo/io/views/custom/videoplayer/vimeo/PendoVimeoPlayer;)V", "onApiChange", "", "onError", "error", "", "onPlaybackQualityChange", "quality", "onPlaybackRateChange", "rate", "onReady", "onStateChange", "state", "onVideoCurrentTime", "seconds", "onVideoDuration", "onVideoId", "videoId", "onVideoLoadedFraction", "fraction", "onYouTubeIFrameAPIReady", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class IFrameJavaScriptInterface implements IFrameApi {
        public IFrameJavaScriptInterface() {
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onApiChange() {
            PendoLogger.d(PendoVimeoPlayer.TAG, "onApiChange");
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onError(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            PendoLogger.d(PendoVimeoPlayer.TAG, "onError " + error);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onPlaybackQualityChange(String quality) {
            Intrinsics.checkNotNullParameter(quality, "quality");
            PendoLogger.d(PendoVimeoPlayer.TAG, "onPlaybackQualityChange " + quality);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onPlaybackRateChange(String rate) {
            Intrinsics.checkNotNullParameter(rate, "rate");
            PendoLogger.d(PendoVimeoPlayer.TAG, "onPlaybackRateChange " + rate);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onReady() {
            PendoLogger.d(PendoVimeoPlayer.TAG, "onReady");
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onStateChange(String state) {
            Intrinsics.checkNotNullParameter(state, "state");
            PendoLogger.d(PendoVimeoPlayer.TAG, "onStateChange " + state);
            PendoVimeoPlayer.this.setPlaying(Intrinsics.areEqual(state, "PLAYING"));
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onVideoCurrentTime(String seconds) {
            Intrinsics.checkNotNullParameter(seconds, "seconds");
            PendoLogger.d(PendoVimeoPlayer.TAG, "onVideoCurrentTime " + seconds);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onVideoDuration(String seconds) {
            Intrinsics.checkNotNullParameter(seconds, "seconds");
            PendoLogger.d(PendoVimeoPlayer.TAG, "onVideoDuration " + seconds);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onVideoId(String videoId) {
            Intrinsics.checkNotNullParameter(videoId, "videoId");
            PendoLogger.d(PendoVimeoPlayer.TAG, "onVideoId " + videoId);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onVideoLoadedFraction(String fraction) {
            Intrinsics.checkNotNullParameter(fraction, "fraction");
            PendoLogger.d(PendoVimeoPlayer.TAG, "onVideoLoadedFraction " + fraction);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onYouTubeIFrameAPIReady() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendoVimeoPlayer(Context context) {
        super(context, TAG);
        Intrinsics.checkNotNullParameter(context, "context");
        PendoLogger.d(TAG, "init: creating WebView instance");
    }

    private final void setupClientAndChrome() {
        ViewGroup viewGroup;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Activity activityFindActivityFromContext = findActivityFromContext(context);
        if (activityFindActivityFromContext == null || (viewGroup = (ViewGroup) activityFindActivityFromContext.findViewById(R.id.insert_visual_container)) == null) {
            viewGroup = activityFindActivityFromContext != null ? (ViewGroup) activityFindActivityFromContext.findViewById(R.id.pendo_view_pager_container) : null;
        }
        getWebView().setWebChromeClient(new PendoFullscreenClient(viewGroup, this));
    }

    @Override // sdk.pendo.io.views.custom.videoplayer.common.BaseIFrameVideoPlayer
    protected void setupWebViewWithIFrame() {
        PendoLogger.d(TAG, "setupWebViewWithIFrame: configuring WebView settings");
        WebSettings settings = getWebView().getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setCacheMode(2);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        settings.setDomStorageEnabled(false);
        getWebView().setWebViewClient(new WebViewClient() { // from class: sdk.pendo.io.views.custom.videoplayer.vimeo.PendoVimeoPlayer.setupWebViewWithIFrame.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                PendoLogger.d(PendoVimeoPlayer.TAG, "onPageFinished: url=" + url);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                PendoLogger.d(PendoVimeoPlayer.TAG, "onPageStarted: url=" + url);
                if (url == null || StringsKt.startsWith$default(url, PendoVimeoPlayer.BASE_URL, false, 2, (Object) null)) {
                    return;
                }
                if (view != null) {
                    view.stopLoading();
                }
                PendoLogger.d(PendoVimeoPlayer.TAG, "Stop loading page " + url);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                PendoLogger.e(PendoVimeoPlayer.TAG, "onReceivedHttpError: url=" + (request != null ? request.getUrl() : null) + " status=" + (errorResponse != null ? Integer.valueOf(errorResponse.getStatusCode()) : null) + " reason=" + (errorResponse != null ? errorResponse.getReasonPhrase() : null));
            }
        });
        PendoLogger.d(TAG, "Adding JavascriptInterface -> PendoSDK");
        getWebView().addJavascriptInterface(new IFrameJavaScriptInterface(), "PendoSDK");
        setupClientAndChrome();
        getWebView().loadUrl(BASE_URL + getVideoUrl());
    }
}
