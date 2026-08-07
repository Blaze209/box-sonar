package androidx.webkit.internal;

import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.ServiceWorkerController;
import android.webkit.WebStorage;
import androidx.webkit.CustomHeader;
import androidx.webkit.PrefetchCache;
import androidx.webkit.PrefetchException;
import androidx.webkit.Profile;
import androidx.webkit.SpeculativeLoadingConfig;
import androidx.webkit.SpeculativeLoadingParameters;
import androidx.webkit.WebViewOutcomeReceiver;
import java.lang.reflect.InvocationHandler;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.OriginMatchedHeaderBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: loaded from: classes9.dex */
public class ProfileImpl implements Profile {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ProfileBoundaryInterface mProfileImpl;

    ProfileImpl(ProfileBoundaryInterface profileBoundaryInterface) {
        this.mProfileImpl = profileBoundaryInterface;
    }

    @Override // androidx.webkit.Profile
    public String getName() {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return this.mProfileImpl.getName();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public CookieManager getCookieManager() throws IllegalStateException {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return this.mProfileImpl.getCookieManager();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public WebStorage getWebStorage() throws IllegalStateException {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return this.mProfileImpl.getWebStorage();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public PrefetchCache getPrefetchCache() {
        if (WebViewFeatureInternal.PREFETCH_CACHE.isSupportedByWebView()) {
            return new PrefetchCache(this.mProfileImpl);
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public GeolocationPermissions getGeolocationPermissions() throws IllegalStateException {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return this.mProfileImpl.getGeoLocationPermissions();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public ServiceWorkerController getServiceWorkerController() throws IllegalStateException {
        if (WebViewFeatureInternal.MULTI_PROFILE.isSupportedByWebView()) {
            return this.mProfileImpl.getServiceWorkerController();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public void prefetchUrlAsync(String str, CancellationSignal cancellationSignal, Executor executor, SpeculativeLoadingParameters speculativeLoadingParameters, WebViewOutcomeReceiver<Void, PrefetchException> webViewOutcomeReceiver) {
        if (WebViewFeatureInternal.PROFILE_URL_PREFETCH.isSupportedByWebView()) {
            this.mProfileImpl.prefetchUrl(str, cancellationSignal, executor == null ? new ProfileImpl$$ExternalSyntheticLambda0(new Handler(Looper.getMainLooper())) : executor, BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SpeculativeLoadingParametersAdapter(speculativeLoadingParameters)), PrefetchOperationCallbackAdapter.buildInvocationHandler(webViewOutcomeReceiver));
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public void prefetchUrlAsync(String str, CancellationSignal cancellationSignal, Executor executor, WebViewOutcomeReceiver<Void, PrefetchException> webViewOutcomeReceiver) {
        if (WebViewFeatureInternal.PROFILE_URL_PREFETCH.isSupportedByWebView()) {
            if (executor == null) {
                executor = new ProfileImpl$$ExternalSyntheticLambda0(new Handler(Looper.getMainLooper()));
            }
            this.mProfileImpl.prefetchUrl(str, cancellationSignal, executor, PrefetchOperationCallbackAdapter.buildInvocationHandler(webViewOutcomeReceiver));
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public void setSpeculativeLoadingConfig(SpeculativeLoadingConfig speculativeLoadingConfig) {
        if (WebViewFeatureInternal.SPECULATIVE_LOADING_CONFIG.isSupportedByWebView()) {
            this.mProfileImpl.setSpeculativeLoadingConfig(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new SpeculativeLoadingConfigAdapter(speculativeLoadingConfig)));
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public void setMaxPrerenders(Integer num) {
        if (WebViewFeatureInternal.SET_MAX_PRERENDERS.isSupportedByWebView()) {
            if (num != null && num.intValue() < 1) {
                throw new IllegalArgumentException("maxPrerenders should be greater than or equal to 1");
            }
            this.mProfileImpl.setMaxPrerenders(num);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public void warmUpRendererProcess() {
        if (WebViewFeatureInternal.WARM_UP_RENDERER_PROCESS.isSupportedByWebView()) {
            this.mProfileImpl.warmUpRendererProcess();
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public void setOriginMatchedHeader(String str, String str2, Set<String> set) {
        if (WebViewFeatureInternal.ORIGIN_MATCHED_HEADERS.isSupportedByWebView()) {
            this.mProfileImpl.setOriginMatchedHeader(str, str2, set);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public boolean hasOriginMatchedHeader(String str) {
        if (WebViewFeatureInternal.ORIGIN_MATCHED_HEADERS.isSupportedByWebView()) {
            return this.mProfileImpl.hasOriginMatchedHeader(str);
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public void clearOriginMatchedHeader(String str) {
        if (WebViewFeatureInternal.ORIGIN_MATCHED_HEADERS.isSupportedByWebView()) {
            this.mProfileImpl.clearOriginMatchedHeader(str);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public void clearAllOriginMatchedHeaders() {
        if (WebViewFeatureInternal.ORIGIN_MATCHED_HEADERS.isSupportedByWebView()) {
            this.mProfileImpl.clearAllOriginMatchedHeaders();
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public void addCustomHeader(CustomHeader customHeader) {
        if (WebViewFeatureInternal.CUSTOM_REQUEST_HEADERS.isSupportedByWebView()) {
            this.mProfileImpl.addOriginMatchedHeader(customHeader.getName(), customHeader.getValue(), customHeader.getRules());
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public boolean hasCustomHeader(String str) {
        if (WebViewFeatureInternal.CUSTOM_REQUEST_HEADERS.isSupportedByWebView()) {
            return this.mProfileImpl.hasOriginMatchedHeader(str);
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public Set<CustomHeader> getCustomHeaders() {
        if (WebViewFeatureInternal.CUSTOM_REQUEST_HEADERS.isSupportedByWebView()) {
            return getCustomHeadersInternal(null, null);
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public Set<CustomHeader> getCustomHeaders(String str) {
        if (WebViewFeatureInternal.CUSTOM_REQUEST_HEADERS.isSupportedByWebView()) {
            return getCustomHeadersInternal(str, null);
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public Set<CustomHeader> getCustomHeaders(String str, String str2) {
        if (WebViewFeatureInternal.CUSTOM_REQUEST_HEADERS.isSupportedByWebView()) {
            return getCustomHeadersInternal(str, str2);
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    private Set<CustomHeader> getCustomHeadersInternal(String str, String str2) {
        HashSet hashSet = new HashSet();
        Iterator<InvocationHandler> it = this.mProfileImpl.getOriginMatchedHeaders(str, str2).iterator();
        while (it.hasNext()) {
            OriginMatchedHeaderBoundaryInterface originMatchedHeaderBoundaryInterface = (OriginMatchedHeaderBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(OriginMatchedHeaderBoundaryInterface.class, it.next());
            hashSet.add(new CustomHeader(originMatchedHeaderBoundaryInterface.getName(), originMatchedHeaderBoundaryInterface.getValue(), originMatchedHeaderBoundaryInterface.getRules()));
        }
        return hashSet;
    }

    @Override // androidx.webkit.Profile
    public void clearCustomHeader(String str) {
        if (WebViewFeatureInternal.CUSTOM_REQUEST_HEADERS.isSupportedByWebView()) {
            this.mProfileImpl.clearOriginMatchedHeader(str, null);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public void clearCustomHeader(String str, String str2) {
        if (WebViewFeatureInternal.CUSTOM_REQUEST_HEADERS.isSupportedByWebView()) {
            this.mProfileImpl.clearOriginMatchedHeader(str, str2);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public void clearAllCustomHeaders() {
        if (WebViewFeatureInternal.CUSTOM_REQUEST_HEADERS.isSupportedByWebView()) {
            this.mProfileImpl.clearAllOriginMatchedHeaders();
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public void preconnect(String str) {
        if (WebViewFeatureInternal.PRECONNECT.isSupportedByWebView()) {
            this.mProfileImpl.preconnect(str);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Override // androidx.webkit.Profile
    public void addQuicHints(Set<String> set) {
        if (WebViewFeatureInternal.ADD_QUIC_HINTS_V1.isSupportedByWebView()) {
            this.mProfileImpl.addQuicHints(set);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
