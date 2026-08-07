package com.yubico.yubikit.piv;

/* JADX INFO: loaded from: classes3.dex */
public class ObjectId {
    public static final int ATTESTATION = 6291201;
    public static final int AUTHENTICATION = 6275333;
    public static final int CAPABILITY = 6275335;
    public static final int CARD_AUTH = 6275329;
    public static final int CHUID = 6275330;
    public static final int DISCOVERY = 126;
    public static final int FACIAL = 6275336;
    public static final int FINGERPRINTS = 6275331;
    public static final int IRIS = 6275361;
    public static final int KEY_HISTORY = 6275340;
    public static final int KEY_MANAGEMENT = 6275339;
    public static final int PIVMAN_DATA = 6291200;
    public static final int PIVMAN_PROTECTED_DATA = 6275337;
    public static final int PRINTED = 6275337;
    public static final int RETIRED1 = 6275341;
    public static final int RETIRED10 = 6275350;
    public static final int RETIRED11 = 6275351;
    public static final int RETIRED12 = 6275352;
    public static final int RETIRED13 = 6275353;
    public static final int RETIRED14 = 6275354;
    public static final int RETIRED15 = 6275355;
    public static final int RETIRED16 = 6275356;
    public static final int RETIRED17 = 6275357;
    public static final int RETIRED18 = 6275358;
    public static final int RETIRED19 = 6275359;
    public static final int RETIRED2 = 6275342;
    public static final int RETIRED20 = 6275360;
    public static final int RETIRED3 = 6275343;
    public static final int RETIRED4 = 6275344;
    public static final int RETIRED5 = 6275345;
    public static final int RETIRED6 = 6275346;
    public static final int RETIRED7 = 6275347;
    public static final int RETIRED8 = 6275348;
    public static final int RETIRED9 = 6275349;
    public static final int SECURITY = 6275334;
    public static final int SIGNATURE = 6275338;

    public static byte[] getBytes(int i) {
        if (i == 126) {
            return new byte[]{126};
        }
        return new byte[]{(byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private ObjectId() {
        throw new IllegalStateException();
    }
}
