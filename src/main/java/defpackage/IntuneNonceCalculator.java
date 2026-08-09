package defpackage;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: IntuneNonceCalculator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"LIntuneNonceCalculator;", "", "<init>", "()V", "NONCE_PRIME_NUMBER", "", "calculateNonceFromEmail", "", "email", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IntuneNonceCalculator {
    public static final IntuneNonceCalculator INSTANCE = new IntuneNonceCalculator();
    private static final int NONCE_PRIME_NUMBER = 797;
    private static final java.security.SecureRandom SECURE_RANDOM = new java.security.SecureRandom();

    private IntuneNonceCalculator() {
    }

    public final String calculateNonceFromEmail(String email) throws NoSuchAlgorithmException {
        BigInteger bigInteger;
        if (email != null) {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = email.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            bigInteger = new BigInteger(1, messageDigest.digest(bytes));
        } else {
            byte[] bArr = new byte[16];
            SECURE_RANDOM.nextBytes(bArr);
            bigInteger = new BigInteger(1, bArr);
        }
        BigInteger bigIntegerValueOf = BigInteger.valueOf(NONCE_PRIME_NUMBER);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        String string = bigInteger.multiply(bigIntegerValueOf).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes2 = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        String strEncodeToString = encoder.encodeToString(bytes2);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}
