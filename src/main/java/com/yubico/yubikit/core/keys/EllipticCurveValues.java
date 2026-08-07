package com.yubico.yubikit.core.keys;

import com.google.common.base.Ascii;
import com.yubico.yubikit.core.fido.CtapException;
import com.yubico.yubikit.core.util.StringUtils;
import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public enum EllipticCurveValues {
    SECP256R1(256, new byte[]{CtapException.ERR_NO_OPERATION_PENDING, -122, 72, -50, 61, 3, 1, 7}),
    SECP256K1(256, new byte[]{CtapException.ERR_UNSUPPORTED_OPTION, -127, 4, 0, 10}),
    SECP384R1(384, new byte[]{CtapException.ERR_UNSUPPORTED_OPTION, -127, 4, 0, CtapException.ERR_INVALID_CREDENTIAL}),
    SECP521R1(521, new byte[]{CtapException.ERR_UNSUPPORTED_OPTION, -127, 4, 0, CtapException.ERR_USER_ACTION_PENDING}),
    BrainpoolP256R1(256, new byte[]{CtapException.ERR_UNSUPPORTED_OPTION, CtapException.ERR_OPERATION_PENDING, 3, 3, 2, 8, 1, 1, 7}),
    BrainpoolP384R1(384, new byte[]{CtapException.ERR_UNSUPPORTED_OPTION, CtapException.ERR_OPERATION_PENDING, 3, 3, 2, 8, 1, 1, 11}),
    BrainpoolP512R1(512, new byte[]{CtapException.ERR_UNSUPPORTED_OPTION, CtapException.ERR_OPERATION_PENDING, 3, 3, 2, 8, 1, 1, Ascii.CR}),
    X25519(256, new byte[]{CtapException.ERR_UNSUPPORTED_OPTION, 101, 110}),
    Ed25519(256, new byte[]{CtapException.ERR_UNSUPPORTED_OPTION, 101, 112});

    private final int bitLength;
    private final byte[] oid;

    EllipticCurveValues(int i, byte[] bArr) {
        this.bitLength = i;
        this.oid = bArr;
    }

    public int getBitLength() {
        return this.bitLength;
    }

    byte[] getOid() {
        byte[] bArr = this.oid;
        return Arrays.copyOf(bArr, bArr.length);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "EllipticCurveValues{name=" + name() + ", bitLength=" + this.bitLength + ", oid=" + StringUtils.bytesToHex(this.oid) + AbstractJsonLexerKt.END_OBJ;
    }

    public static EllipticCurveValues fromOid(byte[] bArr) {
        for (EllipticCurveValues ellipticCurveValues : values()) {
            if (Arrays.equals(bArr, ellipticCurveValues.oid)) {
                return ellipticCurveValues;
            }
        }
        throw new IllegalArgumentException("Not a supported EllipticCurve");
    }
}
