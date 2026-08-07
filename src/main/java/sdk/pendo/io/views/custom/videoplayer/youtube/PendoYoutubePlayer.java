package sdk.pendo.io.views.custom.videoplayer.youtube;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
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
import org.json.JSONObject;
import sdk.pendo.io.R;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.custom.videoplayer.common.BaseIFrameVideoPlayer;
import sdk.pendo.io.views.custom.videoplayer.common.IFrameApi;
import sdk.pendo.io.views.custom.videoplayer.common.PendoFullscreenClient;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0003J\b\u0010\u000f\u001a\u00020\fH\u0015R\u0014\u0010\u0005\u001a\u00020\u0006X\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/views/custom/videoplayer/youtube/PendoYoutubePlayer;", "Lsdk/pendo/io/views/custom/videoplayer/common/BaseIFrameVideoPlayer;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mainThreadHandler", "Landroid/os/Handler;", "getMainThreadHandler", "()Landroid/os/Handler;", "generatePlayerOptions", "", "loadVideo", "", "videoId", "setupClientAndChrome", "setupWebViewWithIFrame", "Companion", "IFrameJavaScriptInterface", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PendoYoutubePlayer extends BaseIFrameVideoPlayer {
    public static final String AUTOPLAY_PARAMETER = "autoplay";
    public static final String BASE_URL = "https://appassets.androidplatform.net";
    public static final String CC_LOAD_POLICY_PARAMETER = "cc_load_policy";
    public static final String CONTROLS_PARAMETER = "controls";
    public static final String ENABLEJSAPI_PARAMETER = "enablejsapi";
    private static final String EXPECTED_YOUTUBE_HTML_TEMPLATE_SHA384 = "2e427ee67b3aae2aa33c2a128a090e9e94db3dfd368e39427cbd112c6495374c4ab063b9d5b9f1db52c72212a174604a";
    public static final String FS_PARAMETER = "fs";
    public static final String HOST = "www.youtube.com";
    public static final String IFRAME_FILE = "pendo_youtube_iframe_api";
    public static final String IFRAME_PARAMETERS_PLACEHOLDER = "<<injectedPlayerVars>>";
    public static final String IV_LOAD_POLICY_PARAMETER = "iv_load_policy";
    public static final String JAVASCRIPT_INTERFACE_NAME = "PendoSDK";
    public static final String MODESTBRANDING_PARAMETER = "modestbranding";
    public static final String ORIGIN_PARAMETER = "origin";
    public static final String PLAYER_PLAYING = "PLAYING";
    public static final String REL_PARAMETER = "rel";
    public static final String SHOWINFO_PARAMETER = "showinfo";
    public static final String TAG = "PendoYoutubePlayer";
    private final Handler mainThreadHandler;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0017J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H\u0017J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0017J\b\u0010\f\u001a\u00020\u0004H\u0017J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0007H\u0017J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0017J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0007H\u0017J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0007H\u0017J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0007H\u0017J\b\u0010\u0016\u001a\u00020\u0004H\u0017¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/views/custom/videoplayer/youtube/PendoYoutubePlayer$IFrameJavaScriptInterface;", "Lsdk/pendo/io/views/custom/videoplayer/common/IFrameApi;", "(Lsdk/pendo/io/views/custom/videoplayer/youtube/PendoYoutubePlayer;)V", "onApiChange", "", "onError", "error", "", "onPlaybackQualityChange", "quality", "onPlaybackRateChange", "rate", "onReady", "onStateChange", "state", "onVideoCurrentTime", "seconds", "onVideoDuration", "onVideoId", "videoId", "onVideoLoadedFraction", "fraction", "onYouTubeIFrameAPIReady", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class IFrameJavaScriptInterface implements IFrameApi {
        public IFrameJavaScriptInterface() {
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onApiChange() {
            PendoLogger.d(PendoYoutubePlayer.TAG, "onApiChange");
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onError(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            PendoLogger.e(PendoYoutubePlayer.TAG, "Error occurred while playing video error: " + error + " url =" + PendoYoutubePlayer.this.getVideoUrl());
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onPlaybackQualityChange(String quality) {
            Intrinsics.checkNotNullParameter(quality, "quality");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onPlaybackQualityChange " + quality);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onPlaybackRateChange(String rate) {
            Intrinsics.checkNotNullParameter(rate, "rate");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onPlaybackRateChange " + rate);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onReady() {
            PendoLogger.d(PendoYoutubePlayer.TAG, "onReady");
            PendoYoutubePlayer pendoYoutubePlayer = PendoYoutubePlayer.this;
            pendoYoutubePlayer.loadVideo(pendoYoutubePlayer.getVideoIdValue());
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onStateChange(String state) {
            Intrinsics.checkNotNullParameter(state, "state");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onStateChange " + state);
            PendoYoutubePlayer.this.setPlaying(Intrinsics.areEqual(state, "PLAYING"));
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onVideoCurrentTime(String seconds) {
            Intrinsics.checkNotNullParameter(seconds, "seconds");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onVideoCurrentTime " + seconds);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onVideoDuration(String seconds) {
            Intrinsics.checkNotNullParameter(seconds, "seconds");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onVideoDuration " + seconds);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onVideoId(String videoId) {
            Intrinsics.checkNotNullParameter(videoId, "videoId");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onVideoId " + videoId);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onVideoLoadedFraction(String fraction) {
            Intrinsics.checkNotNullParameter(fraction, "fraction");
            PendoLogger.d(PendoYoutubePlayer.TAG, "onVideoLoadedFraction " + fraction);
        }

        @Override // sdk.pendo.io.views.custom.videoplayer.common.IFrameApi
        @JavascriptInterface
        public void onYouTubeIFrameAPIReady() {
            PendoLogger.d(PendoYoutubePlayer.TAG, "onYouTubeIFrameAPIReady");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PendoYoutubePlayer(Context context) {
        super(context, TAG);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
        PendoLogger.d(TAG, "init: creating WebView instance");
    }

    private final String generatePlayerOptions() {
        String string = new JSONObject().put(AUTOPLAY_PARAMETER, 0).put(CONTROLS_PARAMETER, 1).put(ENABLEJSAPI_PARAMETER, 1).put(FS_PARAMETER, 1).put("origin", BASE_URL).put(REL_PARAMETER, 0).put(SHOWINFO_PARAMETER, 0).put(IV_LOAD_POLICY_PARAMETER, 3).put(MODESTBRANDING_PARAMETER, 0).put(CC_LOAD_POLICY_PARAMETER, 0).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadVideo(String videoId) {
        StringBuilder sbAppend;
        String str;
        if (getAutoplay()) {
            sbAppend = new StringBuilder("javascript:loadVideo('").append(videoId);
            str = "', 0.0)";
        } else {
            sbAppend = new StringBuilder("javascript:cueVideo('").append(videoId);
            str = "')";
        }
        final String string = sbAppend.append(str).toString();
        getMainThreadHandler().post(new Runnable() { // from class: sdk.pendo.io.views.custom.videoplayer.youtube.PendoYoutubePlayer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PendoYoutubePlayer.loadVideo$lambda$1(this.f$0, string);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadVideo$lambda$1(PendoYoutubePlayer this$0, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        this$0.getWebView().loadUrl(url);
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
    protected Handler getMainThreadHandler() {
        return this.mainThreadHandler;
    }

    @Override // sdk.pendo.io.views.custom.videoplayer.common.BaseIFrameVideoPlayer
    protected void setupWebViewWithIFrame() {
        WebSettings settings = getWebView().getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setCacheMode(2);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccess(false);
        settings.setDomStorageEnabled(false);
        getWebView().setWebViewClient(new WebViewClient() { // from class: sdk.pendo.io.views.custom.videoplayer.youtube.PendoYoutubePlayer.setupWebViewWithIFrame.2
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                PendoLogger.d(PendoYoutubePlayer.TAG, "onPageFinished: url=" + url);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (url == null || StringsKt.startsWith$default(url, PendoYoutubePlayer.BASE_URL, false, 2, (Object) null) || StringsKt.startsWith$default(url, "https://www.youtube.com", false, 2, (Object) null)) {
                    return;
                }
                if (view != null) {
                    view.stopLoading();
                }
                PendoLogger.d(PendoYoutubePlayer.TAG, "Stop loading page " + url);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                super.onReceivedHttpError(view, request, errorResponse);
                PendoLogger.e(PendoYoutubePlayer.TAG, "onReceivedHttpError: url=" + (request != null ? request.getUrl() : null) + " status=" + (errorResponse != null ? Integer.valueOf(errorResponse.getStatusCode()) : null) + " reason=" + (errorResponse != null ? errorResponse.getReasonPhrase() : null));
            }

            @Override // android.webkit.WebViewClient
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                return null;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return true;
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                PendoLogger.d(PendoYoutubePlayer.TAG, "shouldOverrideUrlLoading(String): url=" + url + " -> true");
                return true;
            }
        });
        getWebView().addJavascriptInterface(new IFrameJavaScriptInterface(), "PendoSDK");
        setupClientAndChrome();
        String verifiedDecodedHtmlFromBase64Asset = getVerifiedDecodedHtmlFromBase64Asset(IFRAME_FILE, EXPECTED_YOUTUBE_HTML_TEMPLATE_SHA384);
        if (verifiedDecodedHtmlFromBase64Asset == null) {
            return;
        }
        String strReplace$default = StringsKt.replace$default(verifiedDecodedHtmlFromBase64Asset, IFRAME_PARAMETERS_PLACEHOLDER, generatePlayerOptions(), false, 4, (Object) null);
        PendoLogger.d(TAG, "Loading embedded Youtube HTML (from Base64 asset) with baseUrl=https://appassets.androidplatform.net and videoId=" + getVideoIdValue());
        getWebView().loadDataWithBaseURL(BASE_URL, strReplace$default, "text/html", "utf-8", null);
    }
}
