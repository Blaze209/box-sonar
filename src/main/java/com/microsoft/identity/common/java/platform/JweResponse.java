package com.microsoft.identity.common.java.platform;

import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.base64.Base64Flags;
import com.microsoft.identity.common.java.base64.Base64Util;
import com.microsoft.identity.common.java.jwt.AbstractJwtRequest;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.util.StringUtil;
import io.opentelemetry.api.trace.Span;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public class JweResponse {
    private static final int LENGTH_OF_VALID_JWE = 4;
    private static final String TAG = "JweResponse";
    private String mAAD;
    private String mAuthenticationTag;
    private String mEncryptedKey;
    private String mIv;
    private JweHeader mJweHeader;
    private String mPayload;

    public static class JweHeader {
        private final String mAlgorithm;
        private final String mContext;
        private final String mEncryptionAlgorithm;
        private final String mKeyID;
        private final String mKeyUse;
        private final String mType;
        private final String mX509Certificate;
        private final String mX509CertificateThumbprint;

        public static class JweHeaderBuilder {
            private String algorithm;
            private String context;
            private String encryptionAlgorithm;
            private String keyID;
            private String keyUse;
            private String type;
            private String x509Certificate;
            private String x509CertificateThumbprint;

            JweHeaderBuilder() {
            }

            public JweHeaderBuilder algorithm(String str) {
                this.algorithm = str;
                return this;
            }

            public JweHeader build() {
                return new JweHeader(this.algorithm, this.type, this.x509CertificateThumbprint, this.x509Certificate, this.keyID, this.keyUse, this.encryptionAlgorithm, this.context);
            }

            public JweHeaderBuilder context(String str) {
                this.context = str;
                return this;
            }

            public JweHeaderBuilder encryptionAlgorithm(String str) {
                this.encryptionAlgorithm = str;
                return this;
            }

            public JweHeaderBuilder keyID(String str) {
                this.keyID = str;
                return this;
            }

            public JweHeaderBuilder keyUse(String str) {
                this.keyUse = str;
                return this;
            }

            public String toString() {
                return "JweResponse.JweHeader.JweHeaderBuilder(algorithm=" + this.algorithm + ", type=" + this.type + ", x509CertificateThumbprint=" + this.x509CertificateThumbprint + ", x509Certificate=" + this.x509Certificate + ", keyID=" + this.keyID + ", keyUse=" + this.keyUse + ", encryptionAlgorithm=" + this.encryptionAlgorithm + ", context=" + this.context + ")";
            }

            public JweHeaderBuilder type(String str) {
                this.type = str;
                return this;
            }

            public JweHeaderBuilder x509Certificate(String str) {
                this.x509Certificate = str;
                return this;
            }

            public JweHeaderBuilder x509CertificateThumbprint(String str) {
                this.x509CertificateThumbprint = str;
                return this;
            }
        }

        JweHeader(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
            this.mAlgorithm = str;
            this.mType = str2;
            this.mX509CertificateThumbprint = str3;
            this.mX509Certificate = str4;
            this.mKeyID = str5;
            this.mKeyUse = str6;
            this.mEncryptionAlgorithm = str7;
            this.mContext = str8;
        }

        public static JweHeaderBuilder builder() {
            return new JweHeaderBuilder();
        }

        protected boolean canEqual(Object obj) {
            return obj instanceof JweHeader;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof JweHeader)) {
                return false;
            }
            JweHeader jweHeader = (JweHeader) obj;
            if (!jweHeader.canEqual(this)) {
                return false;
            }
            String algorithm = getAlgorithm();
            String algorithm2 = jweHeader.getAlgorithm();
            if (algorithm != null ? !algorithm.equals(algorithm2) : algorithm2 != null) {
                return false;
            }
            String type = getType();
            String type2 = jweHeader.getType();
            if (type != null ? !type.equals(type2) : type2 != null) {
                return false;
            }
            String x509CertificateThumbprint = getX509CertificateThumbprint();
            String x509CertificateThumbprint2 = jweHeader.getX509CertificateThumbprint();
            if (x509CertificateThumbprint != null ? !x509CertificateThumbprint.equals(x509CertificateThumbprint2) : x509CertificateThumbprint2 != null) {
                return false;
            }
            String x509Certificate = getX509Certificate();
            String x509Certificate2 = jweHeader.getX509Certificate();
            if (x509Certificate != null ? !x509Certificate.equals(x509Certificate2) : x509Certificate2 != null) {
                return false;
            }
            String keyID = getKeyID();
            String keyID2 = jweHeader.getKeyID();
            if (keyID != null ? !keyID.equals(keyID2) : keyID2 != null) {
                return false;
            }
            String keyUse = getKeyUse();
            String keyUse2 = jweHeader.getKeyUse();
            if (keyUse != null ? !keyUse.equals(keyUse2) : keyUse2 != null) {
                return false;
            }
            String encryptionAlgorithm = getEncryptionAlgorithm();
            String encryptionAlgorithm2 = jweHeader.getEncryptionAlgorithm();
            if (encryptionAlgorithm != null ? !encryptionAlgorithm.equals(encryptionAlgorithm2) : encryptionAlgorithm2 != null) {
                return false;
            }
            String context = getContext();
            String context2 = jweHeader.getContext();
            return context != null ? context.equals(context2) : context2 == null;
        }

        public int hashCode() {
            String algorithm = getAlgorithm();
            int iHashCode = algorithm == null ? 43 : algorithm.hashCode();
            String type = getType();
            int iHashCode2 = ((iHashCode + 59) * 59) + (type == null ? 43 : type.hashCode());
            String x509CertificateThumbprint = getX509CertificateThumbprint();
            int iHashCode3 = (iHashCode2 * 59) + (x509CertificateThumbprint == null ? 43 : x509CertificateThumbprint.hashCode());
            String x509Certificate = getX509Certificate();
            int iHashCode4 = (iHashCode3 * 59) + (x509Certificate == null ? 43 : x509Certificate.hashCode());
            String keyID = getKeyID();
            int iHashCode5 = (iHashCode4 * 59) + (keyID == null ? 43 : keyID.hashCode());
            String keyUse = getKeyUse();
            int iHashCode6 = (iHashCode5 * 59) + (keyUse == null ? 43 : keyUse.hashCode());
            String encryptionAlgorithm = getEncryptionAlgorithm();
            int i = iHashCode6 * 59;
            int iHashCode7 = encryptionAlgorithm == null ? 43 : encryptionAlgorithm.hashCode();
            String context = getContext();
            return ((i + iHashCode7) * 59) + (context != null ? context.hashCode() : 43);
        }

        public String getAlgorithm() {
            return this.mAlgorithm;
        }

        public String getType() {
            return this.mType;
        }

        public String getX509CertificateThumbprint() {
            return this.mX509CertificateThumbprint;
        }

        public String getX509Certificate() {
            return this.mX509Certificate;
        }

        public String getKeyID() {
            return this.mKeyID;
        }

        public String getKeyUse() {
            return this.mKeyUse;
        }

        public String getEncryptionAlgorithm() {
            return this.mEncryptionAlgorithm;
        }

        public String getContext() {
            return this.mContext;
        }
    }

    public JweHeader getJweHeader() {
        return this.mJweHeader;
    }

    public byte[] getEncryptedKey() {
        return Base64Util.decode("Encrypted key is not base64 url-encoded", this.mEncryptedKey, Base64Flags.URL_SAFE);
    }

    public byte[] getIv() {
        return Base64Util.decode("IV not base64 url-encoded.", this.mIv, Base64Flags.URL_SAFE);
    }

    public byte[] getPayload() {
        return Base64Util.decode("Payload is not base64 url-encoded.", this.mPayload, Base64Flags.URL_SAFE);
    }

    public byte[] getAuthenticationTag() {
        String str = this.mAuthenticationTag;
        if (str != null) {
            return Base64Util.decode("Tag is not base64 url-encoded", str, Base64Flags.URL_SAFE);
        }
        return null;
    }

    public byte[] getAAD() {
        return this.mAAD.getBytes(AuthenticationConstants.CHARSET_ASCII);
    }

    public static JweResponse parseJwe(String str) throws JSONException {
        if (str == null) {
            throw new NullPointerException("jwe is marked non-null but is null");
        }
        Span spanCurrent = SpanExtension.current();
        JweResponse jweResponse = new JweResponse();
        String[] strArrSplit = str.split("\\.");
        spanCurrent.setAttribute(AttributeName.jwt_valid.name(), strArrSplit.length >= 4);
        if (strArrSplit.length < 4) {
            throw new IllegalArgumentException("Invalid JWE");
        }
        String str2 = strArrSplit[0];
        jweResponse.mEncryptedKey = strArrSplit[1];
        jweResponse.mIv = strArrSplit[2];
        jweResponse.mPayload = strArrSplit[3];
        jweResponse.mAAD = str2;
        if (strArrSplit.length > 4) {
            jweResponse.mAuthenticationTag = strArrSplit[4];
        }
        JSONObject jSONObject = new JSONObject(StringUtil.fromByteArray(Base64Util.decode("Header is not base url-encoded", str2, Base64Flags.URL_SAFE)));
        spanCurrent.setAttribute(AttributeName.jwt_alg.name(), jSONObject.optString("alg"));
        jweResponse.mJweHeader = JweHeader.builder().algorithm(jSONObject.optString("alg")).type(jSONObject.optString("typ")).x509CertificateThumbprint(jSONObject.optString("x5t")).x509Certificate(jSONObject.optString("x5c")).keyID(jSONObject.optString("kid")).keyUse(jSONObject.optString("use")).encryptionAlgorithm(jSONObject.optString("enc")).context(jSONObject.optString(AbstractJwtRequest.ClaimNames.CTX)).build();
        return jweResponse;
    }
}
