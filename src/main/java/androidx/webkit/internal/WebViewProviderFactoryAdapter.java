package androidx.webkit.internal;

import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewOutcomeReceiver;
import androidx.webkit.WebViewStartUpConfig;
import androidx.webkit.WebViewStartUpResult;
import androidx.webkit.WebViewStartupException;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewBuilderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: loaded from: classes9.dex */
public class WebViewProviderFactoryAdapter implements WebViewProviderFactory {
    final WebViewProviderFactoryBoundaryInterface mImpl;

    public WebViewProviderFactoryAdapter(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.mImpl = webViewProviderFactoryBoundaryInterface;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public WebViewBuilderBoundaryInterface getWebViewBuilder() {
        return (WebViewBuilderBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewBuilderBoundaryInterface.class, this.mImpl.getWebViewBuilder());
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderBoundaryInterface.class, this.mImpl.createWebView(webView));
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebkitToCompatConverterBoundaryInterface.class, this.mImpl.getWebkitToCompatConverter());
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(StaticsBoundaryInterface.class, this.mImpl.getStatics());
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public String[] getWebViewFeatures() {
        return this.mImpl.getSupportedFeatures();
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public ServiceWorkerControllerBoundaryInterface getServiceWorkerController() {
        return (ServiceWorkerControllerBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ServiceWorkerControllerBoundaryInterface.class, this.mImpl.getServiceWorkerController());
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public TracingControllerBoundaryInterface getTracingController() {
        return (TracingControllerBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(TracingControllerBoundaryInterface.class, this.mImpl.getTracingController());
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public ProxyControllerBoundaryInterface getProxyController() {
        return (ProxyControllerBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ProxyControllerBoundaryInterface.class, this.mImpl.getProxyController());
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public DropDataContentProviderBoundaryInterface getDropDataProvider() {
        return (DropDataContentProviderBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(DropDataContentProviderBoundaryInterface.class, this.mImpl.getDropDataProvider());
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public ProfileStoreBoundaryInterface getProfileStore() {
        return (ProfileStoreBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ProfileStoreBoundaryInterface.class, this.mImpl.getProfileStore());
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    @Deprecated
    public void startUpWebView(WebViewStartUpConfig webViewStartUpConfig, final WebViewCompat.WebViewStartUpCallback webViewStartUpCallback) {
        this.mImpl.startUpWebView(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebViewStartUpConfigAdapter(webViewStartUpConfig)), BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebViewStartUpCallbackAdapter(new WebViewCompat.WebViewStartUpCallback() { // from class: androidx.webkit.internal.WebViewProviderFactoryAdapter$$ExternalSyntheticLambda6
            @Override // androidx.webkit.WebViewCompat.WebViewStartUpCallback
            public final void onSuccess(WebViewStartUpResult webViewStartUpResult) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.webkit.internal.WebViewProviderFactoryAdapter$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        webViewStartUpCallback.onSuccess(webViewStartUpResult);
                    }
                });
            }
        })));
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public void startUpWebView(final WebViewStartUpConfig webViewStartUpConfig, final WebViewOutcomeReceiver<WebViewStartUpResult, WebViewStartupException> webViewOutcomeReceiver) {
        WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface = this.mImpl;
        Objects.requireNonNull(webViewStartUpConfig);
        webViewProviderFactoryBoundaryInterface.startUpWebView(new Consumer() { // from class: androidx.webkit.internal.WebViewProviderFactoryAdapter$$ExternalSyntheticLambda2
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                webViewStartUpConfig.accept((BiConsumer) obj);
            }
        }, new Consumer() { // from class: androidx.webkit.internal.WebViewProviderFactoryAdapter$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                WebViewProviderFactoryAdapter.lambda$startUpWebView$3(webViewOutcomeReceiver, (Consumer) obj);
            }
        }, new Consumer() { // from class: androidx.webkit.internal.WebViewProviderFactoryAdapter$$ExternalSyntheticLambda4
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                WebViewProviderFactoryAdapter.lambda$startUpWebView$5(webViewOutcomeReceiver, (Consumer) obj);
            }
        });
    }

    static /* synthetic */ void lambda$startUpWebView$3(final WebViewOutcomeReceiver webViewOutcomeReceiver, Consumer consumer) {
        final WebViewStartupResultImpl webViewStartupResultImpl = new WebViewStartupResultImpl(consumer);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.webkit.internal.WebViewProviderFactoryAdapter$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                webViewOutcomeReceiver.onResult(webViewStartupResultImpl);
            }
        });
    }

    static /* synthetic */ void lambda$startUpWebView$5(final WebViewOutcomeReceiver webViewOutcomeReceiver, Consumer consumer) {
        final WebViewStartupException webViewStartupExceptionBuildException = WebViewStartupExceptionBuilder.buildException(consumer);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: androidx.webkit.internal.WebViewProviderFactoryAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                webViewOutcomeReceiver.onError(webViewStartupExceptionBuildException);
            }
        });
    }
}
