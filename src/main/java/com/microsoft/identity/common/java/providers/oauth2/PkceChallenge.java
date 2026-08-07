package com.microsoft.identity.common.java.providers.oauth2;

import com.box.androidsdk.content.auth.OAuthWebView;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.base64.Base64Util;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes14.dex */
public final class PkceChallenge implements Serializable {
    private static final String CHALLENGE_SHA256 = "S256";
    private static final int CODE_VERIFIER_BYTE_SIZE = 32;
    private static final String DIGEST_ALGORITHM = "SHA-256";
    private static final String ISO_8859_1 = "ISO_8859_1";
    private static final long serialVersionUID = 8549806628675994235L;

    @SerializedName(OAuthWebView.CODE_CHALLENGE)
    private final String mCodeChallenge;

    @SerializedName("code_challenge_method")
    private final String mCodeChallengeMethod = CHALLENGE_SHA256;
    private final transient String mCodeVerifier;

    public String getCodeVerifier() {
        return this.mCodeVerifier;
    }

    public String getCodeChallenge() {
        return this.mCodeChallenge;
    }

    public String getCodeChallengeMethod() {
        return this.mCodeChallengeMethod;
    }

    private PkceChallenge(String str, String str2) {
        this.mCodeVerifier = str;
        this.mCodeChallenge = str2;
    }

    public static PkceChallenge newPkceChallenge() {
        String strGenerateCodeVerifier = generateCodeVerifier(null);
        return new PkceChallenge(strGenerateCodeVerifier, generateCodeVerifierChallenge(strGenerateCodeVerifier));
    }

    static String generateCodeVerifier(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[32];
            new SecureRandom().nextBytes(bArr);
        }
        return Base64Util.encodeUrlSafeString(bArr);
    }

    static String generateCodeVerifierChallenge(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(ISO_8859_1));
            return Base64Util.encodeUrlSafeString(messageDigest.digest());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("Every implementation of the Java platform is required to support ISO-8859-1.Consult the release documentation for your implementation.", e);
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException("Failed to generate the code verifier challenge", e2);
        }
    }
}
