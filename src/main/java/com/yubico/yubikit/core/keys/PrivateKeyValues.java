package com.yubico.yubikit.core.keys;

import com.yubico.yubikit.core.application.BadResponseException;
import com.yubico.yubikit.core.fido.CtapException;
import com.yubico.yubikit.core.util.Tlv;
import com.yubico.yubikit.core.util.Tlvs;
import java.math.BigInteger;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.security.auth.DestroyFailedException;
import javax.security.auth.Destroyable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PrivateKeyValues implements Destroyable {
    private static final byte[] OID_ECDSA = {CtapException.ERR_NO_OPERATION_PENDING, -122, 72, -50, 61, 2, 1};
    final int bitLength;
    private boolean destroyed = false;

    protected PrivateKeyValues(int i) {
        this.bitLength = i;
    }

    public final int getBitLength() {
        return this.bitLength;
    }

    @Override // javax.security.auth.Destroyable
    public final boolean isDestroyed() {
        return this.destroyed;
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() throws DestroyFailedException {
        this.destroyed = true;
    }

    public static PrivateKeyValues fromPrivateKey(PrivateKey privateKey) {
        if (!(privateKey instanceof RSAPrivateKey)) {
            try {
                Map<Integer, byte[]> mapDecodeMap = Tlvs.decodeMap(Tlvs.unpackValue(48, privateKey.getEncoded()));
                List<Tlv> listDecodeList = Tlvs.decodeList(mapDecodeMap.get(48));
                byte[] value = listDecodeList.get(0).getValue();
                if (Arrays.equals(OID_ECDSA, value)) {
                    return new Ec(EllipticCurveValues.fromOid(listDecodeList.get(1).getValue()), Tlvs.decodeList(Tlvs.unpackValue(48, mapDecodeMap.get(4))).get(1).getValue());
                }
                for (EllipticCurveValues ellipticCurveValues : Arrays.asList(EllipticCurveValues.Ed25519, EllipticCurveValues.X25519)) {
                    if (Arrays.equals(ellipticCurveValues.getOid(), value)) {
                        return new Ec(ellipticCurveValues, Tlvs.unpackValue(4, mapDecodeMap.get(4)));
                    }
                }
                throw new IllegalArgumentException("Unsupported private key type");
            } catch (BadResponseException unused) {
            }
        } else {
            return Rsa.fromRsaPrivateKey((RSAPrivateKey) privateKey);
        }
    }

    public static class Ec extends PrivateKeyValues {
        private final EllipticCurveValues ellipticCurveValues;
        private final byte[] secret;

        protected Ec(EllipticCurveValues ellipticCurveValues, byte[] bArr) {
            super(ellipticCurveValues.getBitLength());
            this.ellipticCurveValues = ellipticCurveValues;
            this.secret = Arrays.copyOf(bArr, bArr.length);
        }

        public EllipticCurveValues getCurveParams() {
            return this.ellipticCurveValues;
        }

        public byte[] getSecret() {
            byte[] bArr = this.secret;
            return Arrays.copyOf(bArr, bArr.length);
        }

        @Override // com.yubico.yubikit.core.keys.PrivateKeyValues, javax.security.auth.Destroyable
        public void destroy() throws DestroyFailedException {
            Arrays.fill(this.secret, (byte) 0);
            super.destroy();
        }

        public String toString() {
            return "PrivateKeyValues.Ec{curve=" + this.ellipticCurveValues.name() + ", bitLength=" + this.bitLength + ", destroyed=" + isDestroyed() + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static class Rsa extends PrivateKeyValues {

        @Nullable
        private BigInteger crtCoefficient;
        private final BigInteger modulus;

        @Nullable
        private BigInteger primeExponentP;

        @Nullable
        private BigInteger primeExponentQ;
        private BigInteger primeP;
        private BigInteger primeQ;
        private final BigInteger publicExponent;

        public String toString() {
            return "PrivateKeyValues.Rsa{modulus=" + this.modulus + ", publicExponent=" + this.publicExponent + ", bitLength=" + this.bitLength + ", hasCrtValues=" + (this.crtCoefficient != null) + ", destroyed=" + isDestroyed() + AbstractJsonLexerKt.END_OBJ;
        }

        protected Rsa(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, @Nullable BigInteger bigInteger5, @Nullable BigInteger bigInteger6, @Nullable BigInteger bigInteger7) {
            super(bigInteger.bitLength());
            this.modulus = bigInteger;
            this.publicExponent = bigInteger2;
            this.primeP = bigInteger3;
            this.primeQ = bigInteger4;
            this.primeExponentP = bigInteger5;
            this.primeExponentQ = bigInteger6;
            this.crtCoefficient = bigInteger7;
            if (bigInteger5 == null || bigInteger6 == null || bigInteger7 == null) {
                if (bigInteger5 != null || bigInteger6 != null || bigInteger7 != null) {
                    throw new IllegalArgumentException("All CRT values must either be present or omitted");
                }
            }
        }

        public BigInteger getModulus() {
            return this.modulus;
        }

        public BigInteger getPublicExponent() {
            return this.publicExponent;
        }

        public BigInteger getPrimeP() {
            return this.primeP;
        }

        public BigInteger getPrimeQ() {
            return this.primeQ;
        }

        @Nullable
        public BigInteger getPrimeExponentP() {
            return this.primeExponentP;
        }

        @Nullable
        public BigInteger getPrimeExponentQ() {
            return this.primeExponentQ;
        }

        @Nullable
        public BigInteger getCrtCoefficient() {
            return this.crtCoefficient;
        }

        @Override // com.yubico.yubikit.core.keys.PrivateKeyValues, javax.security.auth.Destroyable
        public void destroy() throws DestroyFailedException {
            this.primeP = BigInteger.ZERO;
            this.primeQ = BigInteger.ZERO;
            this.primeExponentP = null;
            this.primeExponentQ = null;
            this.crtCoefficient = null;
            super.destroy();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static Rsa fromRsaPrivateKey(RSAPrivateKey rSAPrivateKey) {
            List<BigInteger> pkcs8RsaKeyValues;
            if (rSAPrivateKey instanceof RSAPrivateCrtKey) {
                RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) rSAPrivateKey;
                pkcs8RsaKeyValues = Arrays.asList(rSAPrivateCrtKey.getModulus(), rSAPrivateCrtKey.getPublicExponent(), rSAPrivateCrtKey.getPrivateExponent(), rSAPrivateCrtKey.getPrimeP(), rSAPrivateCrtKey.getPrimeQ(), rSAPrivateCrtKey.getPrimeExponentP(), rSAPrivateCrtKey.getPrimeExponentQ(), rSAPrivateCrtKey.getCrtCoefficient());
            } else if ("PKCS#8".equals(rSAPrivateKey.getFormat())) {
                pkcs8RsaKeyValues = parsePkcs8RsaKeyValues(rSAPrivateKey.getEncoded());
            } else {
                throw new IllegalArgumentException("Unsupported private key encoding");
            }
            if (pkcs8RsaKeyValues.get(1).intValue() != 65537) {
                throw new IllegalArgumentException("Unsupported RSA public exponent");
            }
            return new Rsa(pkcs8RsaKeyValues.get(0), pkcs8RsaKeyValues.get(1), pkcs8RsaKeyValues.get(3), pkcs8RsaKeyValues.get(4), pkcs8RsaKeyValues.get(5), pkcs8RsaKeyValues.get(6), pkcs8RsaKeyValues.get(7));
        }

        static List<BigInteger> parsePkcs8RsaKeyValues(byte[] bArr) {
            try {
                List<Tlv> listDecodeList = Tlvs.decodeList(Tlvs.decodeMap(Tlvs.decodeMap(Tlvs.unpackValue(48, bArr)).get(4)).get(48));
                ArrayList arrayList = new ArrayList();
                Iterator<Tlv> it = listDecodeList.iterator();
                while (it.hasNext()) {
                    arrayList.add(new BigInteger(it.next().getValue()));
                }
                if (((BigInteger) arrayList.remove(0)).intValue() == 0) {
                    return arrayList;
                }
                throw new IllegalArgumentException("Expected value 0");
            } catch (BadResponseException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }
}
