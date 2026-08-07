package androidx.webkit;

import android.webkit.WebView;
import java.util.Objects;

/* JADX INFO: loaded from: classes9.dex */
public class JavaScriptExecutionWorld {
    public static final String PAGE_WORLD_NAME = "";
    private final String mName;
    private final WebView mWebView;

    public JavaScriptExecutionWorld(String str, WebView webView) {
        this.mName = str;
        this.mWebView = webView;
    }

    String getName() {
        return this.mName;
    }

    void checkWebviewRegistration(WebView webView) {
        if (this.mWebView != webView) {
            throw new IllegalArgumentException("The world is not associated with the webview");
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof JavaScriptExecutionWorld) {
            JavaScriptExecutionWorld javaScriptExecutionWorld = (JavaScriptExecutionWorld) obj;
            if (Objects.equals(this.mName, javaScriptExecutionWorld.mName) && Objects.equals(this.mWebView, javaScriptExecutionWorld.mWebView)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.mName, this.mWebView);
    }
}
