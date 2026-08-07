package com.yubico.yubikit.piv;

import external.sdk.pendo.io.mozilla.javascript.Token;

/* JADX INFO: loaded from: classes3.dex */
public enum Slot {
    AUTHENTICATION(Token.LET, ObjectId.AUTHENTICATION),
    SIGNATURE(Token.SETCONST, ObjectId.SIGNATURE),
    KEY_MANAGEMENT(Token.SETCONSTVAR, ObjectId.KEY_MANAGEMENT),
    CARD_AUTH(Token.ARRAYCOMP, ObjectId.CARD_AUTH),
    RETIRED1(130, ObjectId.RETIRED1),
    RETIRED2(Token.LABEL, ObjectId.RETIRED2),
    RETIRED3(Token.TARGET, ObjectId.RETIRED3),
    RETIRED4(Token.LOOP, ObjectId.RETIRED4),
    RETIRED5(134, ObjectId.RETIRED5),
    RETIRED6(135, ObjectId.RETIRED6),
    RETIRED7(136, ObjectId.RETIRED7),
    RETIRED8(Token.SCRIPT, ObjectId.RETIRED8),
    RETIRED9(138, ObjectId.RETIRED9),
    RETIRED10(139, ObjectId.RETIRED10),
    RETIRED11(140, ObjectId.RETIRED11),
    RETIRED12(Token.SETELEM_OP, ObjectId.RETIRED12),
    RETIRED13(Token.LOCAL_BLOCK, ObjectId.RETIRED13),
    RETIRED14(Token.SET_REF_OP, ObjectId.RETIRED14),
    RETIRED15(Token.DOTDOT, ObjectId.RETIRED15),
    RETIRED16(Token.COLONCOLON, ObjectId.RETIRED16),
    RETIRED17(Token.XML, ObjectId.RETIRED17),
    RETIRED18(Token.DOTQUERY, ObjectId.RETIRED18),
    RETIRED19(Token.XMLATTR, ObjectId.RETIRED19),
    RETIRED20(Token.XMLEND, ObjectId.RETIRED20),
    ATTESTATION(249, ObjectId.ATTESTATION);

    public final int objectId;
    public final int value;

    Slot(int i, int i2) {
        this.value = i;
        this.objectId = i2;
    }

    public String getStringAlias() {
        return Integer.toString(this.value, 16);
    }

    public static Slot fromValue(int i) {
        for (Slot slot : values()) {
            if (slot.value == i) {
                return slot;
            }
        }
        throw new IllegalArgumentException("Not a valid Slot :" + i);
    }

    public static Slot fromStringAlias(String str) {
        return fromValue(Integer.parseInt(str, 16));
    }
}
