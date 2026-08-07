package androidx.webkit.internal;

import androidx.webkit.JavaScriptExecutionException;
import androidx.webkit.JavaScriptReplyProxy;
import androidx.webkit.WebViewOutcomeReceiver;
import java.lang.reflect.InvocationHandler;
import java.util.Objects;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.ExecuteJavaScriptCallbackBoundaryInterface;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: loaded from: classes9.dex */
public class JavaScriptReplyProxyImpl extends JavaScriptReplyProxy {
    private final JsReplyProxyBoundaryInterface mBoundaryInterface;

    /* JADX INFO: Access modifiers changed from: private */
    public int toErrorType(int i) {
        return i != 1 ? 0 : 1;
    }

    public JavaScriptReplyProxyImpl(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.mBoundaryInterface = jsReplyProxyBoundaryInterface;
    }

    public static JavaScriptReplyProxyImpl forInvocationHandler(InvocationHandler invocationHandler) {
        final JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface = (JsReplyProxyBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(JsReplyProxyBoundaryInterface.class, invocationHandler);
        return (JavaScriptReplyProxyImpl) jsReplyProxyBoundaryInterface.getOrCreatePeer(new Callable() { // from class: androidx.webkit.internal.JavaScriptReplyProxyImpl$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return JavaScriptReplyProxyImpl.lambda$forInvocationHandler$0(jsReplyProxyBoundaryInterface);
            }
        });
    }

    static /* synthetic */ Object lambda$forInvocationHandler$0(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) throws Exception {
        return new JavaScriptReplyProxyImpl(jsReplyProxyBoundaryInterface);
    }

    @Override // androidx.webkit.JavaScriptReplyProxy
    public void postMessage(String str) {
        if (WebViewFeatureInternal.WEB_MESSAGE_LISTENER.isSupportedByWebView()) {
            this.mBoundaryInterface.postMessage(str);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.JavaScriptReplyProxy
    public void postMessage(byte[] bArr) {
        Objects.requireNonNull(bArr, "ArrayBuffer must be non-null");
        if (WebViewFeatureInternal.WEB_MESSAGE_ARRAY_BUFFER.isSupportedByWebView()) {
            this.mBoundaryInterface.postMessageWithPayload(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessagePayloadAdapter(bArr)));
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.JavaScriptReplyProxy
    public void executeJavaScript(String str, final WebViewOutcomeReceiver<String, JavaScriptExecutionException> webViewOutcomeReceiver) {
        if (WebViewFeatureInternal.JS_INJECTION_IN_FRAME_AND_WORLD.isSupportedByWebView()) {
            this.mBoundaryInterface.executeJavaScript(str, webViewOutcomeReceiver == null ? null : BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new ExecuteJavaScriptCallbackBoundaryInterface() { // from class: androidx.webkit.internal.JavaScriptReplyProxyImpl.1
                @Override // org.chromium.support_lib_boundary.ExecuteJavaScriptCallbackBoundaryInterface
                public void onSuccess(String str2) {
                    webViewOutcomeReceiver.onResult(str2);
                }

                @Override // org.chromium.support_lib_boundary.ExecuteJavaScriptCallbackBoundaryInterface
                public void onFailure(int i, String str2) {
                    webViewOutcomeReceiver.onError(new JavaScriptExecutionException(JavaScriptReplyProxyImpl.this.toErrorType(i), str2));
                }
            }));
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
