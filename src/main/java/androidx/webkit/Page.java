package androidx.webkit;

import java.lang.reflect.InvocationHandler;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebViewPageBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: loaded from: classes9.dex */
public final class Page {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final WebViewPageBoundaryInterface mPageImpl;

    private Page(WebViewPageBoundaryInterface webViewPageBoundaryInterface) {
        this.mPageImpl = webViewPageBoundaryInterface;
    }

    public static Page forInvocationHandler(InvocationHandler invocationHandler) {
        final WebViewPageBoundaryInterface webViewPageBoundaryInterface = (WebViewPageBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewPageBoundaryInterface.class, invocationHandler);
        return (Page) Objects.requireNonNull(webViewPageBoundaryInterface.getOrCreatePeer(new Callable() { // from class: androidx.webkit.Page$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return Page.lambda$forInvocationHandler$0(webViewPageBoundaryInterface);
            }
        }));
    }

    static /* synthetic */ Object lambda$forInvocationHandler$0(WebViewPageBoundaryInterface webViewPageBoundaryInterface) throws Exception {
        return new Page(webViewPageBoundaryInterface);
    }

    public String getUrl() {
        return this.mPageImpl.getUrl();
    }
}
