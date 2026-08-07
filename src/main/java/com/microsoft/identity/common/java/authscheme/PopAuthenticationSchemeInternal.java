package com.microsoft.identity.common.java.authscheme;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.crypto.IDevicePopManager;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.util.IClockSkewManager;
import java.net.URL;

/* JADX INFO: loaded from: classes14.dex */
public class PopAuthenticationSchemeInternal extends TokenAuthenticationScheme implements IPoPAuthenticationSchemeParams {
    public static final String SCHEME_POP = "PoP";
    private static final long serialVersionUID = 788393037295696358L;

    @SerializedName(SerializedNames.CLIENT_CLAIMS)
    private String mClientClaims;
    private transient IClockSkewManager mClockSkewManager;

    @SerializedName(SerializedNames.HTTP_METHOD)
    private String mHttpMethod;

    @SerializedName("nonce")
    private String mNonce;
    private transient IDevicePopManager mPopManager;

    @SerializedName("url")
    private URL mUrl;

    public static final class SerializedNames {
        public static final String CLIENT_CLAIMS = "client_claims";
        public static final String HTTP_METHOD = "http_method";
        public static final String KID = "kid";
        public static final String NONCE = "nonce";
        public static final String URL = "url";
    }

    public static abstract class PopAuthenticationSchemeInternalBuilder<C extends PopAuthenticationSchemeInternal, B extends PopAuthenticationSchemeInternalBuilder<C, B>> extends TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder<C, B> {
        private String clientClaims;
        private IClockSkewManager clockSkewManager;
        private String httpMethod;
        private String nonce;
        private IDevicePopManager popManager;
        private URL url;

        @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public abstract C build();

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public abstract B self();

        private static void $fillValuesFromInstanceIntoBuilder(PopAuthenticationSchemeInternal popAuthenticationSchemeInternal, PopAuthenticationSchemeInternalBuilder<?, ?> popAuthenticationSchemeInternalBuilder) {
            popAuthenticationSchemeInternalBuilder.clockSkewManager(popAuthenticationSchemeInternal.mClockSkewManager);
            popAuthenticationSchemeInternalBuilder.httpMethod(popAuthenticationSchemeInternal.mHttpMethod);
            popAuthenticationSchemeInternalBuilder.url(popAuthenticationSchemeInternal.mUrl);
            popAuthenticationSchemeInternalBuilder.nonce(popAuthenticationSchemeInternal.mNonce);
            popAuthenticationSchemeInternalBuilder.clientClaims(popAuthenticationSchemeInternal.mClientClaims);
            popAuthenticationSchemeInternalBuilder.popManager(popAuthenticationSchemeInternal.mPopManager);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder
        public B $fillValuesFrom(C c) {
            super.$fillValuesFrom(c);
            $fillValuesFromInstanceIntoBuilder((PopAuthenticationSchemeInternal) c, (PopAuthenticationSchemeInternalBuilder<?, ?>) this);
            return (B) self();
        }

        public B clientClaims(String str) {
            this.clientClaims = str;
            return (B) self();
        }

        public B clockSkewManager(IClockSkewManager iClockSkewManager) {
            this.clockSkewManager = iClockSkewManager;
            return (B) self();
        }

        public B httpMethod(String str) {
            this.httpMethod = str;
            return (B) self();
        }

        public B nonce(String str) {
            this.nonce = str;
            return (B) self();
        }

        public B popManager(IDevicePopManager iDevicePopManager) {
            this.popManager = iDevicePopManager;
            return (B) self();
        }

        @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public String toString() {
            return "PopAuthenticationSchemeInternal.PopAuthenticationSchemeInternalBuilder(super=" + super.toString() + ", clockSkewManager=" + this.clockSkewManager + ", httpMethod=" + this.httpMethod + ", url=" + this.url + ", nonce=" + this.nonce + ", clientClaims=" + this.clientClaims + ", popManager=" + this.popManager + ")";
        }

        public B url(URL url) {
            this.url = url;
            return (B) self();
        }
    }

    private static final class PopAuthenticationSchemeInternalBuilderImpl extends PopAuthenticationSchemeInternalBuilder<PopAuthenticationSchemeInternal, PopAuthenticationSchemeInternalBuilderImpl> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeInternal.PopAuthenticationSchemeInternalBuilder, com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public PopAuthenticationSchemeInternalBuilderImpl self() {
            return this;
        }

        private PopAuthenticationSchemeInternalBuilderImpl() {
        }

        @Override // com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeInternal.PopAuthenticationSchemeInternalBuilder, com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme.TokenAuthenticationSchemeBuilder, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme.AbstractAuthenticationSchemeBuilder
        public PopAuthenticationSchemeInternal build() {
            return new PopAuthenticationSchemeInternal(this);
        }
    }

    protected PopAuthenticationSchemeInternal(PopAuthenticationSchemeInternalBuilder<?, ?> popAuthenticationSchemeInternalBuilder) {
        super(popAuthenticationSchemeInternalBuilder);
        this.mClockSkewManager = ((PopAuthenticationSchemeInternalBuilder) popAuthenticationSchemeInternalBuilder).clockSkewManager;
        this.mHttpMethod = ((PopAuthenticationSchemeInternalBuilder) popAuthenticationSchemeInternalBuilder).httpMethod;
        this.mUrl = ((PopAuthenticationSchemeInternalBuilder) popAuthenticationSchemeInternalBuilder).url;
        this.mNonce = ((PopAuthenticationSchemeInternalBuilder) popAuthenticationSchemeInternalBuilder).nonce;
        this.mClientClaims = ((PopAuthenticationSchemeInternalBuilder) popAuthenticationSchemeInternalBuilder).clientClaims;
        this.mPopManager = ((PopAuthenticationSchemeInternalBuilder) popAuthenticationSchemeInternalBuilder).popManager;
    }

    public static PopAuthenticationSchemeInternalBuilder<?, ?> builder() {
        return new PopAuthenticationSchemeInternalBuilderImpl();
    }

    public PopAuthenticationSchemeInternalBuilder<?, ?> toBuilder() {
        return new PopAuthenticationSchemeInternalBuilderImpl().$fillValuesFrom(this);
    }

    @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme
    protected boolean canEqual(Object obj) {
        return obj instanceof PopAuthenticationSchemeInternal;
    }

    @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PopAuthenticationSchemeInternal)) {
            return false;
        }
        PopAuthenticationSchemeInternal popAuthenticationSchemeInternal = (PopAuthenticationSchemeInternal) obj;
        if (!popAuthenticationSchemeInternal.canEqual(this) || !super.equals(obj)) {
            return false;
        }
        String httpMethod = getHttpMethod();
        String httpMethod2 = popAuthenticationSchemeInternal.getHttpMethod();
        if (httpMethod != null ? !httpMethod.equals(httpMethod2) : httpMethod2 != null) {
            return false;
        }
        URL url = getUrl();
        URL url2 = popAuthenticationSchemeInternal.getUrl();
        if (url != null ? !url.equals(url2) : url2 != null) {
            return false;
        }
        String nonce = getNonce();
        String nonce2 = popAuthenticationSchemeInternal.getNonce();
        if (nonce != null ? !nonce.equals(nonce2) : nonce2 != null) {
            return false;
        }
        String clientClaims = getClientClaims();
        String clientClaims2 = popAuthenticationSchemeInternal.getClientClaims();
        return clientClaims != null ? clientClaims.equals(clientClaims2) : clientClaims2 == null;
    }

    @Override // com.microsoft.identity.common.java.authscheme.TokenAuthenticationScheme, com.microsoft.identity.common.java.authscheme.AbstractAuthenticationScheme
    public int hashCode() {
        int iHashCode = super.hashCode();
        String httpMethod = getHttpMethod();
        int iHashCode2 = (iHashCode * 59) + (httpMethod == null ? 43 : httpMethod.hashCode());
        URL url = getUrl();
        int iHashCode3 = (iHashCode2 * 59) + (url == null ? 43 : url.hashCode());
        String nonce = getNonce();
        int i = iHashCode3 * 59;
        int iHashCode4 = nonce == null ? 43 : nonce.hashCode();
        String clientClaims = getClientClaims();
        return ((i + iHashCode4) * 59) + (clientClaims != null ? clientClaims.hashCode() : 43);
    }

    PopAuthenticationSchemeInternal() {
        super(SCHEME_POP);
    }

    public PopAuthenticationSchemeInternal(IClockSkewManager iClockSkewManager, IDevicePopManager iDevicePopManager, String str, URL url, String str2, String str3) {
        super(SCHEME_POP);
        if (iClockSkewManager == null) {
            throw new NullPointerException("clockSkewManager is marked non-null but is null");
        }
        if (iDevicePopManager == null) {
            throw new NullPointerException("popManager is marked non-null but is null");
        }
        if (url == null) {
            throw new NullPointerException("url is marked non-null but is null");
        }
        this.mClockSkewManager = iClockSkewManager;
        this.mPopManager = iDevicePopManager;
        this.mHttpMethod = str;
        this.mUrl = url;
        this.mNonce = str2;
        this.mClientClaims = str3;
    }

    public PopAuthenticationSchemeInternal(IDevicePopManager iDevicePopManager, String str, URL url, String str2, String str3) {
        super(SCHEME_POP);
        if (iDevicePopManager == null) {
            throw new NullPointerException("popManager is marked non-null but is null");
        }
        if (url == null) {
            throw new NullPointerException("url is marked non-null but is null");
        }
        this.mClockSkewManager = null;
        this.mPopManager = iDevicePopManager;
        this.mHttpMethod = str;
        this.mUrl = url;
        this.mNonce = str2;
        this.mClientClaims = str3;
    }

    @Override // com.microsoft.identity.common.java.authscheme.ITokenAuthenticationSchemeInternal
    public String getAccessTokenForScheme(String str) throws ClientException {
        if (str == null) {
            throw new NullPointerException("accessToken is marked non-null but is null");
        }
        IClockSkewManager iClockSkewManager = this.mClockSkewManager;
        if (iClockSkewManager == null) {
            throw new RuntimeException("IClockSkewManager not initialized.");
        }
        return this.mPopManager.mintSignedAccessToken(getHttpMethod(), iClockSkewManager.getAdjustedReferenceTime().getTime() / 1000, getUrl(), str, getNonce(), getClientClaims());
    }

    public void setClockSkewManager(IClockSkewManager iClockSkewManager) {
        if (iClockSkewManager == null) {
            throw new NullPointerException("clockSkewManager is marked non-null but is null");
        }
        this.mClockSkewManager = iClockSkewManager;
    }

    public void setDevicePopManager(IDevicePopManager iDevicePopManager) {
        if (iDevicePopManager == null) {
            throw new NullPointerException("devicePopManager is marked non-null but is null");
        }
        this.mPopManager = iDevicePopManager;
    }

    @Override // com.microsoft.identity.common.java.authscheme.IPoPAuthenticationSchemeParams
    public String getHttpMethod() {
        return this.mHttpMethod;
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
}
