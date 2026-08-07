package androidx.webkit;

import androidx.webkit.internal.WebSettingsAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;

/* JADX INFO: loaded from: classes9.dex */
public class BackForwardCacheSettings {
    private final WebSettingsAdapter mAdapter;

    BackForwardCacheSettings(WebSettingsAdapter webSettingsAdapter) {
        this.mAdapter = webSettingsAdapter;
    }

    public long getTimeoutSeconds() {
        if (WebViewFeatureInternal.BACK_FORWARD_CACHE_SETTINGS_EXPERIMENTAL_V3.isSupportedByWebView()) {
            return this.mAdapter.getBackForwardCacheTimeoutSeconds();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public void setTimeoutSeconds(long j) {
        if (WebViewFeatureInternal.BACK_FORWARD_CACHE_SETTINGS_EXPERIMENTAL_V3.isSupportedByWebView()) {
            this.mAdapter.setBackForwardCacheTimeoutSeconds(j);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public int getMaxPagesInCache() {
        if (WebViewFeatureInternal.BACK_FORWARD_CACHE_SETTINGS_EXPERIMENTAL_V3.isSupportedByWebView()) {
            return this.mAdapter.getBackForwardCacheMaxPagesInCache();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public void setMaxPagesInCache(int i) {
        if (WebViewFeatureInternal.BACK_FORWARD_CACHE_SETTINGS_EXPERIMENTAL_V3.isSupportedByWebView()) {
            this.mAdapter.setBackForwardCacheMaxPagesInCache(i);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public boolean isKeepForwardEntriesEnabled() {
        if (WebViewFeatureInternal.BACK_FORWARD_CACHE_SETTINGS_EXPERIMENTAL_V4.isSupportedByWebView()) {
            return this.mAdapter.getBackForwardCacheKeepForwardEntries();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public void setKeepForwardEntriesEnabled(boolean z) {
        if (WebViewFeatureInternal.BACK_FORWARD_CACHE_SETTINGS_EXPERIMENTAL_V4.isSupportedByWebView()) {
            this.mAdapter.setBackForwardCacheKeepForwardEntries(z);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
