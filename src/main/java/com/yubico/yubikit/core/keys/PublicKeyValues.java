package com.yubico.yubikit.core.keys;

import com.google.common.base.Ascii;
import com.yubico.yubikit.core.application.BadResponseException;
import com.yubico.yubikit.core.fido.CtapException;
import com.yubico.yubikit.core.util.ByteUtils;
import com.yubico.yubikit.core.util.StringUtils;
import com.yubico.yubikit.core.util.Tlv;
import com.yubico.yubikit.core.util.Tlvs;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PublicKeyValues {
    private static final byte[] OID_ECDSA = {CtapException.ERR_NO_OPERATION_PENDING, -122, 72, -50, 61, 2, 1};
    private static final byte[] OID_RSA_ENCRYPTION = {CtapException.ERR_NO_OPERATION_PENDING, -122, 72, -122, -9, Ascii.CR, 1, 1, 1};
    protected final int bitLength;

    public abstract byte[] getEncoded();

    public abstract PublicKey toPublicKey() throws InvalidKeySpecException, NoSuchAlgorithmException;

    protected PublicKeyValues(int i) {
        this.bitLength = i;
    }

    public final int getBitLength() {
        return this.bitLength;
    }

    public static PublicKeyValues fromPublicKey(PublicKey publicKey) {
        if (publicKey instanceof RSAPublicKey) {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) publicKey;
            return new Rsa(rSAPublicKey.getModulus(), rSAPublicKey.getPublicExponent());
        }
        try {
            Map<Integer, byte[]> mapDecodeMap = Tlvs.decodeMap(Tlvs.unpackValue(48, publicKey.getEncoded()));
            List<Tlv> listDecodeList = Tlvs.decodeList(mapDecodeMap.get(48));
            byte[] value = listDecodeList.get(0).getValue();
            byte[] bArr = mapDecodeMap.get(3);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 1, bArr.length);
            if (Arrays.equals(OID_ECDSA, value)) {
                return Ec.fromEncodedPoint(EllipticCurveValues.fromOid(listDecodeList.get(1).getValue()), bArrCopyOfRange);
            }
            for (EllipticCurveValues ellipticCurveValues : Arrays.asList(EllipticCurveValues.Ed25519, EllipticCurveValues.X25519)) {
                if (Arrays.equals(ellipticCurveValues.getOid(), value)) {
                    return new Cv25519(ellipticCurveValues, bArrCopyOfRange);
                }
            }
            throw new IllegalStateException();
        } catch (BadResponseException e) {
            throw new RuntimeException(e);
        }
    }

    public static class Cv25519 extends PublicKeyValues {
        private final byte[] bytes;
        private final EllipticCurveValues ellipticCurveValues;

        public Cv25519(EllipticCurveValues ellipticCurveValues, byte[] bArr) {
            super(ellipticCurveValues.getBitLength());
            if (ellipticCurveValues != EllipticCurveValues.Ed25519 && ellipticCurveValues != EllipticCurveValues.X25519) {
                throw new IllegalArgumentException("InvalidCurve");
            }
            this.ellipticCurveValues = ellipticCurveValues;
            this.bytes = Arrays.copyOf(bArr, bArr.length);
        }

        public EllipticCurveValues getCurveParams() {
            return this.ellipticCurveValues;
        }

        public byte[] getBytes() {
            byte[] bArr = this.bytes;
            return Arrays.copyOf(bArr, bArr.length);
        }

        @Override // com.yubico.yubikit.core.keys.PublicKeyValues
        public byte[] getEncoded() {
            return new Tlv(48, Tlvs.encodeList(Arrays.asList(new Tlv(48, new Tlv(6, this.ellipticCurveValues.getOid()).getBytes()), new Tlv(3, ByteBuffer.allocate(this.bytes.length + 1).put((byte) 0).put(this.bytes).array())))).getBytes();
        }

        @Override // com.yubico.yubikit.core.keys.PublicKeyValues
        public PublicKey toPublicKey() throws InvalidKeySpecException, NoSuchAlgorithmException {
            return KeyFactory.getInstance(this.ellipticCurveValues.name()).generatePublic(new X509EncodedKeySpec(getEncoded()));
        }

        public String toString() {
            return "PublicKeyValues.Cv25519{curve=" + this.ellipticCurveValues.name() + ", publicKey=" + StringUtils.bytesToHex(this.bytes) + ", bitLength=" + this.bitLength + AbstractJsonLexerKt.END_OBJ;
        }
    }

    public static class Ec extends PublicKeyValues {
        private final EllipticCurveValues ellipticCurveValues;
        private final BigInteger x;
        private final BigInteger y;

        public Ec(EllipticCurveValues ellipticCurveValues, BigInteger bigInteger, BigInteger bigInteger2) {
            super(ellipticCurveValues.getBitLength());
            if (ellipticCurveValues == EllipticCurveValues.Ed25519 || ellipticCurveValues == EllipticCurveValues.X25519) {
                throw new IllegalArgumentException("InvalidCurve");
            }
            this.ellipticCurveValues = ellipticCurveValues;
            this.x = bigInteger;
            this.y = bigInteger2;
        }

        public EllipticCurveValues getCurveParams() {
            return this.ellipticCurveValues;
        }

        public BigInteger getX() {
            return this.x;
        }

        public BigInteger getY() {
            return this.y;
        }

        public byte[] getEncodedPoint() {
            int iCeil = (int) Math.ceil(((double) this.ellipticCurveValues.getBitLength()) / 8.0d);
            return ByteBuffer.allocate((iCeil * 2) + 1).put((byte) 4).put(ByteUtils.intToLength(this.x, iCeil)).put(ByteUtils.intToLength(this.y, iCeil)).array();
        }

        @Override // com.yubico.yubikit.core.keys.PublicKeyValues
        public byte[] getEncoded() {
            byte[] encodedPoint = getEncodedPoint();
            return new Tlv(48, Tlvs.encodeList(Arrays.asList(new Tlv(48, Tlvs.encodeList(Arrays.asList(new Tlv(6, PublicKeyValues.OID_ECDSA), new Tlv(6, this.ellipticCurveValues.getOid())))), new Tlv(3, ByteBuffer.allocate(encodedPoint.length + 1).put((byte) 0).put(encodedPoint).array())))).getBytes();
        }

        @Override // com.yubico.yubikit.core.keys.PublicKeyValues
        public ECPublicKey toPublicKey() throws InvalidKeySpecException, NoSuchAlgorithmException {
            return (ECPublicKey) KeyFactory.getInstance("EC").generatePublic(new X509EncodedKeySpec(getEncoded()));
        }

        public String toString() {
            return "PublicKeyValues.Ec{curve=" + this.ellipticCurveValues.name() + ", x=" + this.x + ", y=" + this.y + ", bitLength=" + this.bitLength + AbstractJsonLexerKt.END_OBJ;
        }

        public static Ec fromEncodedPoint(EllipticCurveValues ellipticCurveValues, byte[] bArr) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            if (byteBufferWrap.get() != 4) {
                throw new IllegalArgumentException("Only uncompressed public keys are supported");
            }
            byte[] bArr2 = new byte[(bArr.length - 1) / 2];
            byteBufferWrap.get(bArr2);
            BigInteger bigInteger = new BigInteger(1, bArr2);
            byteBufferWrap.get(bArr2);
            return new Ec(ellipticCurveValues, bigInteger, new BigInteger(1, bArr2));
        }
    }

    public static class Rsa extends PublicKeyValues {
        private final BigInteger modulus;
        private final BigInteger publicExponent;

        public Rsa(BigInteger bigInteger, BigInteger bigInteger2) {
            super(bigInteger.bitLength());
            this.modulus = bigInteger;
            this.publicExponent = bigInteger2;
        }

        public BigInteger getModulus() {
            return this.modulus;
        }

        public BigInteger getPublicExponent() {
            return this.publicExponent;
        }

        @Override // com.yubico.yubikit.core.keys.PublicKeyValues
        public byte[] getEncoded() {
            byte[] bytes = new Tlv(48, Tlvs.encodeList(Arrays.asList(new Tlv(2, this.modulus.toByteArray()), new Tlv(2, this.publicExponent.toByteArray())))).getBytes();
            return new Tlv(48, Tlvs.encodeList(Arrays.asList(new Tlv(48, Tlvs.encodeList(Arrays.asList(new Tlv(6, PublicKeyValues.OID_RSA_ENCRYPTION), new Tlv(5, new byte[0])))), new Tlv(3, ByteBuffer.allocate(bytes.length + 1).put((byte) 0).put(bytes).array())))).getBytes();
        }

        @Override // com.yubico.yubikit.core.keys.PublicKeyValues
        public RSAPublicKey toPublicKey() throws InvalidKeySpecException, NoSuchAlgorithmException {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(this.modulus, this.publicExponent));
        }

        public String toString() {
            return "PublicKeyValues.Rsa{modulus=" + this.modulus + ", publicExponent=" + this.publicExponent + ", bitLength=" + this.bitLength + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
