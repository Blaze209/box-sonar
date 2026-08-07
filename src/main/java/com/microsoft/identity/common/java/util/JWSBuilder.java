package com.microsoft.identity.common.java.util;

import com.box.android.data.datasource.auth.AuthenticationRemoteDataSource;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.base64.Base64Util;
import com.microsoft.identity.common.java.challengehandlers.IDeviceCertificate;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.logging.Logger;
import java.security.cert.CertificateEncodingException;

/* JADX INFO: loaded from: classes14.dex */
public class JWSBuilder {
    protected static final String JWS_HEADER_ALG = "RS256";
    protected static final long SECONDS_MS = 1000;
    private static final String SIGNING_ALGORITHM = "SHA256withRSA";
    private static final String TAG = "JWSBuilder";

    static final class Claims {

        @SerializedName("aud")
        private String mAudience;

        @SerializedName("iat")
        private long mIssueAt;

        @SerializedName("nonce")
        private String mNonce;

        private Claims() {
        }
    }

    protected long getCurrentTimeInSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    protected String encodeUrlSafeString(byte[] bArr) {
        return Base64Util.encodeUrlSafeString(bArr);
    }

    static final class JwsHeader {

        @SerializedName("alg")
        private String mAlgorithm;

        @SerializedName("x5c")
        private String[] mCert;

        @SerializedName("typ")
        private String mType;

        private JwsHeader() {
        }
    }

    public String generateSignedJWT(String str, String str2, IDeviceCertificate iDeviceCertificate) throws ClientException {
        if (str == null) {
            throw new NullPointerException("nonce is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("audience is marked non-null but is null");
        }
        if (iDeviceCertificate == null) {
            throw new NullPointerException("deviceCert is marked non-null but is null");
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException("nonce is an empty string.");
        }
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("audience is an empty string.");
        }
        Gson gson = new Gson();
        Claims claims = new Claims();
        claims.mNonce = str;
        claims.mAudience = str2;
        claims.mIssueAt = getCurrentTimeInSeconds();
        JwsHeader jwsHeader = new JwsHeader();
        jwsHeader.mAlgorithm = "RS256";
        jwsHeader.mType = AuthenticationRemoteDataSource.JWT_TOKEN_TYPE_NAME;
        try {
            jwsHeader.mCert = new String[1];
            jwsHeader.mCert[0] = Base64Util.encodeToStringNoWrap(iDeviceCertificate.getX509().getEncoded());
            String json = gson.toJson(jwsHeader);
            String json2 = gson.toJson(claims);
            Logger.verbose("JWSBuilder:generateSignedJWT", "Generate client certificate challenge response JWS Header. ");
            String str3 = encodeUrlSafeString(StringUtil.toByteArray(json)) + "." + encodeUrlSafeString(StringUtil.toByteArray(json2));
            return str3 + "." + encodeUrlSafeString(iDeviceCertificate.sign(StringUtil.toByteArray(str3)));
        } catch (CertificateEncodingException e) {
            throw new ClientException(ErrorStrings.CERTIFICATE_ENCODING_ERROR, "Certificate encoding error", e);
        }
    }
}
