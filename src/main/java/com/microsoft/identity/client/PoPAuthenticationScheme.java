package com.microsoft.identity.client;

import com.microsoft.identity.common.java.authscheme.IPoPAuthenticationSchemeParams;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeInternal;
import java.net.URL;

/* JADX INFO: loaded from: classes14.dex */
public class PoPAuthenticationScheme extends AuthenticationScheme implements IPoPAuthenticationSchemeParams {
    private final String mClientClaims;
    private final HttpMethod mHttpMethod;
    private final String mNonce;
    private final URL mUrl;

    private PoPAuthenticationScheme(HttpMethod httpMethod, URL url, String str, String str2) {
        super(PopAuthenticationSchemeInternal.SCHEME_POP);
        this.mHttpMethod = httpMethod;
        this.mUrl = url;
        this.mNonce = str;
        this.mClientClaims = str2;
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override // com.microsoft.identity.common.java.authscheme.IPoPAuthenticationSchemeParams
    public String getHttpMethod() {
        HttpMethod httpMethod = this.mHttpMethod;
        if (httpMethod != null) {
            return httpMethod.name();
        }
        return null;
    }

    @Override // com.microsoft.identity.common.java.authscheme.IPoPAuthenticationSchemeParams
    public URL getUrl() {
        return this.mUrl;
    }

    @Override // com.microsoft.identity.common.java.authscheme.IPoPAuthenticationSchemeParams
    public String getClientClaims() {
        return this.mClientClaims;
    }

    @Override // com.microsoft.identity.common.java.authscheme.INonced
    public String getNonce() {
        return this.mNonce;
    }

    public static class Builder {
        private String mClientClaims;
        private HttpMethod mHttpMethod;
        private String mNonce;
        private URL mUrl;

        private Builder() {
        }

        public Builder withUrl(URL url) {
            this.mUrl = url;
            return this;
        }

        public Builder withHttpMethod(HttpMethod httpMethod) {
            this.mHttpMethod = httpMethod;
            return this;
        }

        public Builder withNonce(String str) {
            this.mNonce = str;
            return this;
        }

        public Builder withClientClaims(String str) {
            this.mClientClaims = str;
            return this;
        }

        public PoPAuthenticationScheme build() {
            if (this.mUrl == null) {
                throw new IllegalArgumentException("PoP authentication scheme param must not be null: URL");
            }
            return new PoPAuthenticationScheme(this.mHttpMethod, this.mUrl, this.mNonce, this.mClientClaims);
        }
    }
}
