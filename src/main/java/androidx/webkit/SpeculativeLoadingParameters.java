package androidx.webkit;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes9.dex */
public final class SpeculativeLoadingParameters {
    private final Map<String, String> mAdditionalHeaders;
    private final NoVarySearchHeader mExpectedNoVarySearchHeader;
    private final boolean mIsJavaScriptEnabled;
    private final Integer mVariationsId;

    private SpeculativeLoadingParameters(Map<String, String> map, NoVarySearchHeader noVarySearchHeader, boolean z, Integer num) {
        this.mAdditionalHeaders = map;
        this.mExpectedNoVarySearchHeader = noVarySearchHeader;
        this.mIsJavaScriptEnabled = z;
        this.mVariationsId = num;
    }

    public Map<String, String> getAdditionalHeaders() {
        return this.mAdditionalHeaders;
    }

    public NoVarySearchHeader getExpectedNoVarySearchData() {
        return this.mExpectedNoVarySearchHeader;
    }

    public boolean isJavaScriptEnabled() {
        return this.mIsJavaScriptEnabled;
    }

    public Integer getVariationsId() {
        return this.mVariationsId;
    }

    public static final class Builder {
        private final Map<String, String> mAdditionalHeaders = new HashMap();
        private NoVarySearchHeader mExpectedNoVarySearchHeader = null;
        private boolean mIsJavaScriptEnabled = false;
        private Integer mVariationsId = null;

        public SpeculativeLoadingParameters build() {
            return new SpeculativeLoadingParameters(this.mAdditionalHeaders, this.mExpectedNoVarySearchHeader, this.mIsJavaScriptEnabled, this.mVariationsId);
        }

        public Builder addAdditionalHeader(String str, String str2) {
            this.mAdditionalHeaders.put(str, str2);
            return this;
        }

        public Builder addAdditionalHeaders(Map<String, String> map) {
            this.mAdditionalHeaders.putAll(map);
            return this;
        }

        public Builder setExpectedNoVarySearchData(NoVarySearchHeader noVarySearchHeader) {
            this.mExpectedNoVarySearchHeader = noVarySearchHeader;
            return this;
        }

        public Builder setJavaScriptEnabled(boolean z) {
            this.mIsJavaScriptEnabled = z;
            return this;
        }

        public Builder setVariationsId(Integer num) {
            this.mVariationsId = num;
            return this;
        }
    }
}
