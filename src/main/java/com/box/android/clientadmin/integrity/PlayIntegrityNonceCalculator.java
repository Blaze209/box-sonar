package com.box.android.clientadmin.integrity;

import java.math.BigInteger;
import java.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: PlayIntegrityNonceCalculator.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Lcom/box/android/clientadmin/integrity/PlayIntegrityNonceCalculator;", "", "<init>", "()V", "calculate", "", "uniqueValue", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlayIntegrityNonceCalculator {
    public static final int $stable = 0;
    private static final int NONCE_PRIME_NUMBER = 853;

    public final String calculate(String uniqueValue) {
        Intrinsics.checkNotNullParameter(uniqueValue, "uniqueValue");
        BigInteger bigInteger;
        try {
            bigInteger = new BigInteger(uniqueValue);
        } catch (NumberFormatException e) {
            return "";
        }
        BigInteger bigIntegerValueOf = BigInteger.valueOf(NONCE_PRIME_NUMBER);
        Intrinsics.checkNotNullExpressionValue(bigIntegerValueOf, "valueOf(...)");
        String string = bigInteger.multiply(bigIntegerValueOf).toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        String strEncodeToString = encoder.encodeToString(bytes);
        Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(...)");
        return strEncodeToString;
    }
}
