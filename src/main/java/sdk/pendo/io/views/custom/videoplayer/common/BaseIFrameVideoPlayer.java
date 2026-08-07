package sdk.pendo.io.views.custom.videoplayer.common;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.box.android.activities.addcontent.CreateDocumentTaskActivity;
import com.facebook.react.uimanager.ViewProps;
import com.google.common.base.Ascii;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import com.microsoft.identity.common.java.jwt.AbstractJwtRequest;
import com.microsoft.intune.mam.client.widget.MAMWebView;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.StringUtils;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.custom.videoplayer.youtube.PendoYoutubePlayer;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 V2\u00020\u00012\u00020\u0002:\u0001VB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u00020\u0004H\u0004J\u001c\u00106\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001072\u0006\u00109\u001a\u00020\u0010H\u0002J\u001a\u0010:\u001a\u0004\u0018\u00010\u00062\u0006\u0010;\u001a\u00020\u00062\u0006\u0010<\u001a\u00020\u0006H\u0004J\b\u0010=\u001a\u00020>H\u0014J\b\u0010?\u001a\u00020>H\u0014J\u0018\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\u00102\u0006\u0010B\u001a\u00020\u0010H\u0014J\u0006\u0010C\u001a\u00020>J\u0006\u0010D\u001a\u00020>J\u0012\u0010E\u001a\u0004\u0018\u00010\u00062\u0006\u0010;\u001a\u00020\u0006H\u0004J\u0010\u0010F\u001a\u00020>2\u0006\u0010G\u001a\u00020\u0006H\u0016J\u0010\u0010H\u001a\u00020>2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010I\u001a\u00020>2\u0006\u0010J\u001a\u00020\u0010H\u0016J\u0012\u0010K\u001a\u00020>2\b\u00108\u001a\u0004\u0018\u000107H\u0016J\u0010\u0010L\u001a\u00020>2\u0006\u0010M\u001a\u00020\u0006H\u0016J\u0010\u0010(\u001a\u00020>2\u0006\u0010$\u001a\u00020\u0006H\u0016J\b\u0010N\u001a\u00020>H$J\u0010\u0010O\u001a\u00020\u00062\u0006\u0010P\u001a\u00020QH\u0004J\u0006\u0010R\u001a\u00020>J\u001e\u0010S\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010T2\u0006\u0010G\u001a\u00020\u0006H\u0002J\u0010\u0010U\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u0010H\u0002R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u0014\u0010\u001b\u001a\u00020\u001cX\u0094\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020\u0010X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014¨\u0006W"}, d2 = {"Lsdk/pendo/io/views/custom/videoplayer/common/BaseIFrameVideoPlayer;", "Landroid/widget/FrameLayout;", "Lsdk/pendo/io/views/custom/videoplayer/common/VideoPlayerView;", "context", "Landroid/content/Context;", "logTag", "", "(Landroid/content/Context;Ljava/lang/String;)V", "TAG", PendoYoutubePlayer.AUTOPLAY_PARAMETER, "", "getAutoplay", "()Z", "setAutoplay", "(Z)V", "heightRatio", "", "getHeightRatio", "()I", "setHeightRatio", "(I)V", "imageWidthPercents", "getImageWidthPercents", "setImageWidthPercents", "<set-?>", "isPlaying", "setPlaying", "mainThreadHandler", "Landroid/os/Handler;", "getMainThreadHandler", "()Landroid/os/Handler;", "videoIdValue", "getVideoIdValue", "()Ljava/lang/String;", "setVideoIdValue", "(Ljava/lang/String;)V", "videoUrl", "Ljava/net/URL;", "getVideoUrl", "()Ljava/net/URL;", "setVideoUrl", "(Ljava/net/URL;)V", "webView", "Landroid/webkit/WebView;", "getWebView", "()Landroid/webkit/WebView;", "setWebView", "(Landroid/webkit/WebView;)V", "widthRatio", "getWidthRatio", "setWidthRatio", "findActivityFromContext", "Landroid/app/Activity;", AbstractJwtRequest.ClaimNames.CTX, "getLayoutParamsRespectingImgWidthPercents", "Landroid/view/ViewGroup$LayoutParams;", SerializedNames.PARAMS, "imgWidthPercents", "getVerifiedDecodedHtmlFromBase64Asset", CreateDocumentTaskActivity.EXTRA_ASSET_NAME, "expectedSha384Hex", "onAttachedToWindow", "", "onDetachedFromWindow", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "pauseVideo", "playVideo", "readAssetText", "setAspectRatio", ViewProps.ASPECT_RATIO, "setAutoPlay", "setImageWidthInPercents", "width", "setLayoutParams", "setVideoId", "videoId", "setupWebViewWithIFrame", "sha384Hex", "bytes", "", "stopVideo", "validateAndSetAspectRatio", "Lkotlin/Pair;", "validateAndSetImageWidthPercents", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class BaseIFrameVideoPlayer extends FrameLayout implements VideoPlayerView {
    public static final int HEIGHT_DEFAULT_RATIO = 9;
    private static final String JS_CMD_PAUSE_VIDEO = "javascript:pauseVideo()";
    private static final String JS_CMD_PLAY_VIDEO = "javascript:playVideo()";
    private static final String JS_CMD_STOP_VIDEO = "javascript:stopVideo()";
    public static final int WIDTH_DEFAULT_RATIO = 16;
    private final String TAG;
    private boolean autoplay;
    private int heightRatio;
    private int imageWidthPercents;
    private boolean isPlaying;
    private final Handler mainThreadHandler;
    private String videoIdValue;
    private URL videoUrl;
    private WebView webView;
    private int widthRatio;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseIFrameVideoPlayer(Context context, String logTag) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        this.TAG = "BaseIFrameVideoPlayer_" + logTag;
        this.webView = new MAMWebView(context);
        this.mainThreadHandler = new Handler(Looper.getMainLooper());
        this.videoIdValue = "";
        this.widthRatio = 16;
        this.heightRatio = 9;
        this.webView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(this.webView);
        setClipToPadding(true);
        setClipChildren(true);
    }

    private final ViewGroup.LayoutParams getLayoutParamsRespectingImgWidthPercents(ViewGroup.LayoutParams params, int imgWidthPercents) {
        return imgWidthPercents > 0 ? new LinearLayout.LayoutParams(-1, -2) : params;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pauseVideo$lambda$2(BaseIFrameVideoPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.webView.loadUrl(JS_CMD_PAUSE_VIDEO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void playVideo$lambda$1(BaseIFrameVideoPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.webView.loadUrl(JS_CMD_PLAY_VIDEO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void stopVideo$lambda$3(BaseIFrameVideoPlayer this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.webView.loadUrl(JS_CMD_STOP_VIDEO);
    }

    private final Pair<Integer, Integer> validateAndSetAspectRatio(String aspectRatio) {
        String[] strArr = (String[]) StringsKt.split$default((CharSequence) aspectRatio, new String[]{":"}, false, 0, 6, (Object) null).toArray(new String[0]);
        try {
            if (strArr.length != 2) {
                throw new Exception("Invalid aspect ratio format");
            }
            int i = Integer.parseInt(strArr[0]);
            int i2 = Integer.parseInt(strArr[1]);
            if (i <= 0 || i2 <= 0) {
                throw new Exception("Aspect ratio values must be positive integers");
            }
            return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
        } catch (Exception e) {
            PendoLogger.d(this.TAG, "validateAndSetAspectRatio -> aspectRatio = " + aspectRatio + " -> " + e.getMessage());
            return null;
        }
    }

    private final int validateAndSetImageWidthPercents(int width) {
        if (width > 100) {
            PendoLogger.d(this.TAG, "validateAndSetImageWidthPercents -> The image width percents out of range " + width);
            return 100;
        }
        if (width >= 0) {
            return width;
        }
        PendoLogger.d(this.TAG, "validateAndSetImageWidthPercents -> The image width percents out of range " + width);
        return 0;
    }

    protected final Activity findActivityFromContext(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        while (ctx instanceof ContextWrapper) {
            if (ctx instanceof Activity) {
                return (Activity) ctx;
            }
            ctx = ((ContextWrapper) ctx).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(ctx, "getBaseContext(...)");
        }
        return null;
    }

    protected final boolean getAutoplay() {
        return this.autoplay;
    }

    protected final int getHeightRatio() {
        return this.heightRatio;
    }

    protected final int getImageWidthPercents() {
        return this.imageWidthPercents;
    }

    protected Handler getMainThreadHandler() {
        return this.mainThreadHandler;
    }

    protected final String getVerifiedDecodedHtmlFromBase64Asset(String assetName, String expectedSha384Hex) {
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        Intrinsics.checkNotNullParameter(expectedSha384Hex, "expectedSha384Hex");
        String assetText = readAssetText(assetName);
        if (assetText == null) {
            PendoLogger.d(this.TAG, "Failed to read asset: " + assetName);
            return null;
        }
        try {
            byte[] bArrDecode = Base64.decode(StringsKt.trim((CharSequence) StringsKt.replace$default(StringsKt.replace$default(assetText, "\n", "", false, 4, (Object) null), StringUtils.CR, "", false, 4, (Object) null)).toString(), 0);
            Intrinsics.checkNotNull(bArrDecode);
            String strSha384Hex = sha384Hex(bArrDecode);
            if (StringsKt.isBlank(expectedSha384Hex)) {
                PendoLogger.d(this.TAG, "Computed HTML SHA-384: " + strSha384Hex + " (set expectedSha384Hex to enforce)");
            } else if (!StringsKt.equals(strSha384Hex, expectedSha384Hex, true)) {
                PendoLogger.d(this.TAG, "HTML SHA-384 mismatch. expected=" + expectedSha384Hex + " actual=" + strSha384Hex + ". Aborting load.");
                return null;
            }
            try {
                return new String(bArrDecode, Charsets.UTF_8);
            } catch (Throwable th) {
                PendoLogger.d(this.TAG, "UTF-8 decode failed: " + th.getMessage());
                return null;
            }
        } catch (Throwable th2) {
            PendoLogger.d(this.TAG, "Base64 decode failed: " + th2.getMessage());
            return null;
        }
    }

    protected final String getVideoIdValue() {
        return this.videoIdValue;
    }

    protected final URL getVideoUrl() {
        return this.videoUrl;
    }

    protected final WebView getWebView() {
        return this.webView;
    }

    protected final int getWidthRatio() {
        return this.widthRatio;
    }

    /* JADX INFO: renamed from: isPlaying, reason: from getter */
    public final boolean getIsPlaying() {
        return this.isPlaying;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setupWebViewWithIFrame();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            this.webView.stopLoading();
        } catch (Throwable unused) {
        }
        try {
            this.webView.loadUrl("about:blank");
        } catch (Throwable unused2) {
        }
        try {
            this.webView.clearHistory();
        } catch (Throwable unused3) {
        }
        try {
            this.webView.setWebViewClient(new WebViewClient());
        } catch (Throwable unused4) {
        }
        try {
            this.webView.destroy();
        } catch (Throwable unused5) {
        }
        try {
            removeView(this.webView);
        } catch (Throwable unused6) {
        }
        MAMWebView mAMWebView = new MAMWebView(getContext());
        this.webView = mAMWebView;
        try {
            addView(mAMWebView);
        } catch (Throwable unused7) {
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int i = this.imageWidthPercents;
        if (i > 0 && size > 0) {
            size = (size * i) / 100;
        }
        int i2 = this.widthRatio;
        int iMin = i2 > 0 ? (this.heightRatio * size) / i2 : 0;
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            iMin = Math.min(size2, iMin);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, iMin), 1073741824);
        setMeasuredDimension(size, Math.max(0, iMin));
        if (getChildCount() > 0) {
            getChildAt(0).measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        }
    }

    public final void pauseVideo() {
        if (this.isPlaying) {
            getMainThreadHandler().post(new Runnable() { // from class: sdk.pendo.io.views.custom.videoplayer.common.BaseIFrameVideoPlayer$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    BaseIFrameVideoPlayer.pauseVideo$lambda$2(this.f$0);
                }
            });
        }
    }

    public final void playVideo() {
        getMainThreadHandler().post(new Runnable() { // from class: sdk.pendo.io.views.custom.videoplayer.common.BaseIFrameVideoPlayer$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BaseIFrameVideoPlayer.playVideo$lambda$1(this.f$0);
            }
        });
    }

    protected final String readAssetText(String assetName) {
        Intrinsics.checkNotNullParameter(assetName, "assetName");
        try {
            InputStream inputStreamOpen = getContext().getAssets().open(assetName);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
            Reader inputStreamReader = new InputStreamReader(inputStreamOpen, Charsets.UTF_8);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            try {
                String text = TextStreamsKt.readText(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, null);
                return text;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedReader, th);
                    throw th2;
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // sdk.pendo.io.views.custom.videoplayer.common.VideoPlayerView
    public void setAspectRatio(String aspectRatio) {
        Intrinsics.checkNotNullParameter(aspectRatio, "aspectRatio");
        Pair<Integer, Integer> pairValidateAndSetAspectRatio = validateAndSetAspectRatio(aspectRatio);
        if (pairValidateAndSetAspectRatio != null) {
            this.widthRatio = pairValidateAndSetAspectRatio.getFirst().intValue();
            this.heightRatio = pairValidateAndSetAspectRatio.getSecond().intValue();
        }
    }

    @Override // sdk.pendo.io.views.custom.videoplayer.common.VideoPlayerView
    public void setAutoPlay(boolean autoplay) {
        this.autoplay = autoplay;
    }

    protected final void setAutoplay(boolean z) {
        this.autoplay = z;
    }

    protected final void setHeightRatio(int i) {
        this.heightRatio = i;
    }

    @Override // sdk.pendo.io.views.custom.videoplayer.common.VideoPlayerView
    public void setImageWidthInPercents(int width) {
        this.imageWidthPercents = validateAndSetImageWidthPercents(width);
    }

    protected final void setImageWidthPercents(int i) {
        this.imageWidthPercents = i;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        super.setLayoutParams(getLayoutParamsRespectingImgWidthPercents(params, this.imageWidthPercents));
    }

    protected final void setPlaying(boolean z) {
        this.isPlaying = z;
    }

    @Override // sdk.pendo.io.views.custom.videoplayer.common.VideoPlayerView
    public void setVideoId(String videoId) {
        Intrinsics.checkNotNullParameter(videoId, "videoId");
        this.videoIdValue = videoId;
    }

    protected final void setVideoIdValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoIdValue = str;
    }

    @Override // sdk.pendo.io.views.custom.videoplayer.common.VideoPlayerView
    public void setVideoUrl(String videoUrl) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        try {
            this.videoUrl = new URL(videoUrl);
            PendoLogger.d(this.TAG, "setVideoUrl -> " + videoUrl);
        } catch (MalformedURLException unused) {
            PendoLogger.d(this.TAG, "setVideoUrl -> wrong parameter " + videoUrl);
        }
    }

    protected final void setWebView(WebView webView) {
        Intrinsics.checkNotNullParameter(webView, "<set-?>");
        this.webView = webView;
    }

    protected final void setWidthRatio(int i) {
        this.widthRatio = i;
    }

    protected abstract void setupWebViewWithIFrame();

    protected final String sha384Hex(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        byte[] bArrDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_384).digest(bytes);
        StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
        Intrinsics.checkNotNull(bArrDigest);
        for (byte b : bArrDigest) {
            String string = Integer.toString((b & 255) >>> 4, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            sb.append(string);
            String string2 = Integer.toString(b & Ascii.SI, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string2, "toString(this, checkRadix(radix))");
            sb.append(string2);
        }
        String string3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        return string3;
    }

    public final void stopVideo() {
        getMainThreadHandler().post(new Runnable() { // from class: sdk.pendo.io.views.custom.videoplayer.common.BaseIFrameVideoPlayer$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                BaseIFrameVideoPlayer.stopVideo$lambda$3(this.f$0);
            }
        });
    }

    protected final void setVideoUrl(URL url) {
        this.videoUrl = url;
    }
}
