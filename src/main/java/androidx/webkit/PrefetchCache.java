package androidx.webkit;

import androidx.webkit.internal.WebViewFeatureInternal;
import org.chromium.support_lib_boundary.ProfileBoundaryInterface;

/* JADX INFO: loaded from: classes9.dex */
public final class PrefetchCache {
    private final ProfileBoundaryInterface mProfileImpl;

    public PrefetchCache(ProfileBoundaryInterface profileBoundaryInterface) {
        this.mProfileImpl = profileBoundaryInterface;
    }

    public void setMaxPrefetches(Integer num) {
        if (WebViewFeatureInternal.PREFETCH_CACHE.isSupportedByWebView()) {
            if (num != null && num.intValue() < 1) {
                throw new IllegalArgumentException("maxPrefetches should be greater than or equal to 1");
            }
            this.mProfileImpl.setMaxPrefetches(num);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public void setPrefetchTtlSeconds(Integer num) {
        if (WebViewFeatureInternal.PREFETCH_CACHE.isSupportedByWebView()) {
            if (num != null && num.intValue() < 1) {
                throw new IllegalArgumentException("prefetchTtlSeconds should be greater than or equal to 1");
            }
            this.mProfileImpl.setPrefetchTtlSeconds(num);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
