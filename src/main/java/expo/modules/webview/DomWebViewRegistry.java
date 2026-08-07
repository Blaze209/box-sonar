package expo.modules.webview;

import androidx.collection.ArrayMap;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DomWebViewRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007J\u0012\u0010\r\u001a\u00060\u0006j\u0002`\u00072\u0006\u0010\u000e\u001a\u00020\u000bJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\u0010\f\u001a\u00060\u0006j\u0002`\u0007J\u0006\u0010\u0010\u001a\u00020\u0011R\u001e\u0010\u0004\u001a\u0012\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\u0006j\u0002`\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/webview/DomWebViewRegistry;", "", "<init>", "()V", "registry", "Landroidx/collection/ArrayMap;", "", "Lexpo/modules/webview/WebViewId;", "Lexpo/modules/webview/WeakDomWebViewRef;", "nextWebViewId", PasskeyWebListener.GET_UNIQUE_KEY, "Lexpo/modules/webview/DomWebView;", "webViewId", "add", "webView", "remove", "reset", "", "expo-dom-webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DomWebViewRegistry {
    private static int nextWebViewId;
    public static final DomWebViewRegistry INSTANCE = new DomWebViewRegistry();
    private static final ArrayMap<Integer, WeakDomWebViewRef> registry = new ArrayMap<>();

    private DomWebViewRegistry() {
    }

    public final synchronized DomWebView get(int webViewId) {
        WeakDomWebViewRef weakDomWebViewRef;
        WeakReference<DomWebView> ref;
        weakDomWebViewRef = registry.get(Integer.valueOf(webViewId));
        return (weakDomWebViewRef == null || (ref = weakDomWebViewRef.getRef()) == null) ? null : ref.get();
    }

    public final synchronized int add(DomWebView webView) {
        int i;
        Intrinsics.checkNotNullParameter(webView, "webView");
        i = nextWebViewId;
        registry.put(Integer.valueOf(i), new WeakDomWebViewRef(new WeakReference(webView)));
        nextWebViewId++;
        return i;
    }

    public final synchronized DomWebView remove(int webViewId) {
        WeakDomWebViewRef weakDomWebViewRefRemove;
        WeakReference<DomWebView> ref;
        weakDomWebViewRefRemove = registry.remove(Integer.valueOf(webViewId));
        return (weakDomWebViewRefRemove == null || (ref = weakDomWebViewRefRemove.getRef()) == null) ? null : ref.get();
    }

    public final synchronized void reset() {
        registry.clear();
        nextWebViewId = 0;
    }
}
