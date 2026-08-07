package expo.modules.webview;

import android.webkit.JavascriptInterface;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomWebViewBridge.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lexpo/modules/webview/DomWebViewBridge;", "", "webView", "Lexpo/modules/webview/DomWebView;", "<init>", "(Lexpo/modules/webview/DomWebView;)V", "eval", "", SerializedNames.PARAMS, "expo-dom-webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DomWebViewBridge {
    private final DomWebView webView;

    public DomWebViewBridge(DomWebView webView) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        this.webView = webView;
    }

    @JavascriptInterface
    public final String eval(String params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return this.webView.evalSync(params);
    }
}
