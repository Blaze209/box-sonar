package com.yubico.yubikit.piv;

import com.yubico.yubikit.core.keys.EllipticCurveValues;
import com.yubico.yubikit.core.keys.PrivateKeyValues;
import com.yubico.yubikit.core.keys.PublicKeyValues;
import java.security.Key;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAKey;
import javax.annotation.Nonnull;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'RSA1024' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes3.dex */
public final class KeyType {
    private static final /* synthetic */ KeyType[] $VALUES = $values();
    public static final KeyType ECCP256;
    public static final KeyType ECCP384;
    public static final KeyType RSA1024;
    public static final KeyType RSA2048;
    public final KeyParams params;
    public final byte value;

    public enum Algorithm {
        RSA,
        EC
    }

    private static /* synthetic */ KeyType[] $values() {
        return new KeyType[]{RSA1024, RSA2048, ECCP256, ECCP384};
    }

    public static KeyType valueOf(String str) {
        return (KeyType) Enum.valueOf(KeyType.class, str);
    }

    public static KeyType[] values() {
        return (KeyType[]) $VALUES.clone();
    }

    static {
        RSA1024 = new KeyType("RSA1024", 0, (byte) 6, new RsaKeyParams(1024));
        RSA2048 = new KeyType("RSA2048", 1, (byte) 7, new RsaKeyParams(2048));
        ECCP256 = new KeyType("ECCP256", 2, (byte) 17, new EcKeyParams(EllipticCurveValues.SECP256R1));
        ECCP384 = new KeyType("ECCP384", 3, (byte) 20, new EcKeyParams(EllipticCurveValues.SECP384R1));
    }

    private KeyType(String str, int i, byte b, KeyParams keyParams) {
        super(str, i);
        this.value = b;
        this.params = keyParams;
    }

    public static KeyType fromValue(int i) {
        for (KeyType keyType : values()) {
            if (keyType.value == i) {
                return keyType;
            }
        }
        throw new IllegalArgumentException("Not a valid KeyType:" + i);
    }

    public static KeyType fromKeyParams(PrivateKeyValues privateKeyValues) {
        int i = 0;
        if (privateKeyValues instanceof PrivateKeyValues.Rsa) {
            KeyType[] keyTypeArrValues = values();
            int length = keyTypeArrValues.length;
            while (i < length) {
                KeyType keyType = keyTypeArrValues[i];
                if ((keyType.params instanceof RsaKeyParams) && privateKeyValues.getBitLength() == keyType.params.bitLength) {
                    return keyType;
                }
                i++;
            }
        } else if (privateKeyValues instanceof PrivateKeyValues.Ec) {
            KeyType[] keyTypeArrValues2 = values();
            int length2 = keyTypeArrValues2.length;
            while (i < length2) {
                KeyType keyType2 = keyTypeArrValues2[i];
                if ((keyType2.params instanceof EcKeyParams) && ((PrivateKeyValues.Ec) privateKeyValues).getCurveParams() == ((EcKeyParams) keyType2.params).ellipticCurveValues) {
                    return keyType2;
                }
                i++;
            }
        }
        throw new IllegalArgumentException("Unsupported key type");
    }

    public static KeyType fromKey(Key key) {
        EllipticCurveValues curveParams;
        int i = 0;
        if (key instanceof RSAKey) {
            KeyType[] keyTypeArrValues = values();
            int length = keyTypeArrValues.length;
            while (i < length) {
                KeyType keyType = keyTypeArrValues[i];
                if (keyType.params.algorithm == Algorithm.RSA && keyType.params.bitLength == ((RSAKey) key).getModulus().bitLength()) {
                    return keyType;
                }
                i++;
            }
        } else {
            if (key instanceof ECPublicKey) {
                curveParams = ((PublicKeyValues.Ec) PublicKeyValues.fromPublicKey((ECPublicKey) key)).getCurveParams();
            } else if (key instanceof ECPrivateKey) {
                curveParams = ((PrivateKeyValues.Ec) PrivateKeyValues.fromPrivateKey((ECPrivateKey) key)).getCurveParams();
            } else {
                throw new IllegalArgumentException("Unsupported key type");
            }
            KeyType[] keyTypeArrValues2 = values();
            int length2 = keyTypeArrValues2.length;
            while (i < length2) {
                KeyType keyType2 = keyTypeArrValues2[i];
                KeyParams keyParams = keyType2.params;
                if ((keyParams instanceof EcKeyParams) && ((EcKeyParams) keyParams).ellipticCurveValues == curveParams) {
                    return keyType2;
                }
                i++;
            }
        }
        throw new IllegalArgumentException("Unsupported key type");
    }

    public static abstract class KeyParams {

        @Nonnull
        public final Algorithm algorithm;
        public final int bitLength;

        private KeyParams(Algorithm algorithm, int i) {
            this.algorithm = algorithm;
            this.bitLength = i;
        }
    }

    public static final class RsaKeyParams extends KeyParams {
        private RsaKeyParams(int i) {
            super(Algorithm.RSA, i);
        }
    }

    public static final class EcKeyParams extends KeyParams {
        private final EllipticCurveValues ellipticCurveValues;

        private EcKeyParams(EllipticCurveValues ellipticCurveValues) {
            super(Algorithm.EC, ellipticCurveValues.getBitLength());
            this.ellipticCurveValues = ellipticCurveValues;
        }

        EllipticCurveValues getCurveParams() {
            return this.ellipticCurveValues;
        }
    }
}
