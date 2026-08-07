package com.yubico.yubikit.piv;

import androidx.work.WorkInfo;
import com.yubico.yubikit.core.Version;
import com.yubico.yubikit.core.application.ApplicationNotAvailableException;
import com.yubico.yubikit.core.application.ApplicationSession;
import com.yubico.yubikit.core.application.BadResponseException;
import com.yubico.yubikit.core.application.Feature;
import com.yubico.yubikit.core.keys.PrivateKeyValues;
import com.yubico.yubikit.core.keys.PublicKeyValues;
import com.yubico.yubikit.core.smartcard.Apdu;
import com.yubico.yubikit.core.smartcard.ApduException;
import com.yubico.yubikit.core.smartcard.ApduFormat;
import com.yubico.yubikit.core.smartcard.AppId;
import com.yubico.yubikit.core.smartcard.SmartCardConnection;
import com.yubico.yubikit.core.smartcard.SmartCardProtocol;
import com.yubico.yubikit.core.util.ByteUtils;
import com.yubico.yubikit.core.util.RandomUtils;
import com.yubico.yubikit.core.util.StringUtils;
import com.yubico.yubikit.core.util.Tlv;
import com.yubico.yubikit.core.util.Tlvs;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes3.dex */
public class PivSession extends ApplicationSession<PivSession> {
    private static final int INDEX_PIN_POLICY = 0;
    private static final int INDEX_RETRIES_REMAINING = 1;
    private static final int INDEX_RETRIES_TOTAL = 0;
    private static final int INDEX_TOUCH_POLICY = 1;
    private static final byte INS_ATTEST = -7;
    private static final byte INS_AUTHENTICATE = -121;
    private static final byte INS_CHANGE_REFERENCE = 36;
    private static final byte INS_GENERATE_ASYMMETRIC = 71;
    private static final byte INS_GET_DATA = -53;
    private static final byte INS_GET_METADATA = -9;
    private static final byte INS_GET_SERIAL = -8;
    private static final byte INS_GET_VERSION = -3;
    private static final byte INS_IMPORT_KEY = -2;
    private static final byte INS_PUT_DATA = -37;
    private static final byte INS_RESET = -5;
    private static final byte INS_RESET_RETRY = 44;
    private static final byte INS_SET_MGMKEY = -1;
    private static final byte INS_SET_PIN_RETRIES = -6;
    private static final byte INS_VERIFY = 32;
    private static final byte ORIGIN_GENERATED = 1;
    private static final byte ORIGIN_IMPORTED = 2;
    private static final int PIN_LEN = 8;
    private static final byte PIN_P2 = -128;
    private static final byte PUK_P2 = -127;
    private static final int SLOT_CARD_MANAGEMENT = 155;
    private static final int TAG_AUTH_CHALLENGE = 129;
    private static final int TAG_AUTH_EXPONENTIATION = 133;
    private static final int TAG_AUTH_RESPONSE = 130;
    private static final int TAG_AUTH_WITNESS = 128;
    private static final int TAG_CERTIFICATE = 112;
    private static final int TAG_CERT_INFO = 113;
    private static final int TAG_DYN_AUTH = 124;
    private static final int TAG_GEN_ALGORITHM = 128;
    private static final int TAG_LRC = 254;
    private static final int TAG_METADATA_ALGO = 1;
    private static final int TAG_METADATA_IS_DEFAULT = 5;
    private static final int TAG_METADATA_ORIGIN = 3;
    private static final int TAG_METADATA_POLICY = 2;
    private static final int TAG_METADATA_PUBLIC_KEY = 4;
    private static final int TAG_METADATA_RETRIES = 6;
    private static final int TAG_OBJ_DATA = 83;
    private static final int TAG_OBJ_ID = 92;
    private static final int TAG_PIN_POLICY = 170;
    private static final int TAG_TOUCH_POLICY = 171;
    private int currentPinAttempts = 3;
    private int maxPinAttempts = 3;
    private final SmartCardProtocol protocol;
    private final Version version;
    public static final Feature<PivSession> FEATURE_P384 = new Feature.Versioned("Curve P384", 4, 0, 0);
    public static final Feature<PivSession> FEATURE_USAGE_POLICY = new Feature.Versioned("PIN/Touch Policy", 4, 0, 0);
    public static final Feature<PivSession> FEATURE_TOUCH_CACHED = new Feature.Versioned("Cached Touch Policy", 4, 3, 0);
    public static final Feature<PivSession> FEATURE_ATTESTATION = new Feature.Versioned("Attestation", 4, 3, 0);
    public static final Feature<PivSession> FEATURE_SERIAL = new Feature.Versioned("Serial Number", 5, 0, 0);
    public static final Feature<PivSession> FEATURE_METADATA = new Feature.Versioned("Metadata", 5, 3, 0);
    public static final Feature<PivSession> FEATURE_AES_KEY = new Feature.Versioned("AES Management Key", 5, 4, 0);
    public static final Feature<PivSession> FEATURE_RSA_GENERATION = new Feature<PivSession>("RSA key generation") { // from class: com.yubico.yubikit.piv.PivSession.1
        @Override // com.yubico.yubikit.core.application.Feature
        public boolean isSupportedBy(Version version) {
            return version.isLessThan(4, 2, 6) || version.isAtLeast(4, 3, 5);
        }
    };
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) PivSession.class);

    public PivSession(SmartCardConnection smartCardConnection) throws ApplicationNotAvailableException, IOException, ApduException {
        SmartCardProtocol smartCardProtocol = new SmartCardProtocol(smartCardConnection);
        this.protocol = smartCardProtocol;
        smartCardProtocol.select(AppId.PIV);
        Version versionFromBytes = Version.fromBytes(smartCardProtocol.sendAndReceive(new Apdu(0, -3, 0, 0, (byte[]) null)));
        this.version = versionFromBytes;
        smartCardProtocol.enableWorkarounds(versionFromBytes);
        if (smartCardConnection.isExtendedLengthApduSupported() && versionFromBytes.isAtLeast(4, 0, 0)) {
            smartCardProtocol.setApduFormat(ApduFormat.EXTENDED);
        }
        com.yubico.yubikit.core.internal.Logger.debug(logger, "PIV session initialized (version={})", versionFromBytes);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.protocol.close();
    }

    @Override // com.yubico.yubikit.core.application.ApplicationSession
    public Version getVersion() {
        return this.version;
    }

    public int getSerialNumber() throws IOException, ApduException {
        require(FEATURE_SERIAL);
        return ByteBuffer.wrap(this.protocol.sendAndReceive(new Apdu(0, -8, 0, 0, (byte[]) null))).getInt();
    }

    public void reset() throws IOException, ApduException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Preparing PIV reset");
        blockPin();
        blockPuk();
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Sending reset");
        this.protocol.sendAndReceive(new Apdu(0, -5, 0, 0, (byte[]) null));
        this.currentPinAttempts = 3;
        this.maxPinAttempts = 3;
        com.yubico.yubikit.core.internal.Logger.info(logger2, "PIV application data reset performed");
    }

    public void authenticate(ManagementKeyType managementKeyType, byte[] bArr) throws BadResponseException, IOException, ApduException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Authenticating with key type: {}", managementKeyType);
        if (bArr.length != managementKeyType.keyLength) {
            throw new IllegalArgumentException(String.format("Management Key must be %d bytes", Integer.valueOf(managementKeyType.keyLength)));
        }
        byte[] bArrUnpackValue = Tlvs.unpackValue(128, Tlvs.unpackValue(124, this.protocol.sendAndReceive(new Apdu(0, -121, managementKeyType.value, 155, new Tlv(124, new Tlv(128, null).getBytes()).getBytes()))));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, managementKeyType.cipherName);
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Cipher cipher = Cipher.getInstance(managementKeyType.cipherName + "/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            linkedHashMap.put(128, cipher.doFinal(bArrUnpackValue));
            byte[] randomBytes = RandomUtils.getRandomBytes(managementKeyType.challengeLength);
            linkedHashMap.put(129, randomBytes);
            byte[] bArrUnpackValue2 = Tlvs.unpackValue(130, Tlvs.unpackValue(124, this.protocol.sendAndReceive(new Apdu(0, -121, managementKeyType.value, 155, new Tlv(124, Tlvs.encodeMap(linkedHashMap)).getBytes()))));
            cipher.init(1, secretKeySpec);
            byte[] bArrDoFinal = cipher.doFinal(randomBytes);
            if (MessageDigest.isEqual(bArrUnpackValue2, bArrDoFinal)) {
                return;
            }
            com.yubico.yubikit.core.internal.Logger.trace(logger2, "Expected response: {} and actual response {}", StringUtils.bytesToHex(bArrDoFinal), StringUtils.bytesToHex(bArrUnpackValue2));
            throw new BadResponseException("Calculated response for challenge is incorrect");
        } catch (InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public byte[] sign(Slot slot, KeyType keyType, byte[] bArr, Signature signature) throws BadResponseException, NoSuchAlgorithmException, IOException, ApduException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Signing data with key in slot {} of type {} using algorithm {}", slot, keyType, signature);
        return usePrivateKey(slot, keyType, Padding.pad(keyType, bArr, signature), false);
    }

    public byte[] rawSignOrDecrypt(Slot slot, KeyType keyType, byte[] bArr) throws BadResponseException, IOException, ApduException {
        int i = keyType.params.bitLength / 8;
        if (bArr.length > i) {
            if (keyType.params.algorithm == KeyType.Algorithm.EC) {
                bArr = Arrays.copyOf(bArr, i);
            } else {
                throw new IllegalArgumentException("Payload too large for key");
            }
        } else if (bArr.length < i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, i - bArr.length, bArr.length);
            bArr = bArr2;
        }
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Decrypting data with key in slot {} of type {}", slot, keyType);
        return usePrivateKey(slot, keyType, bArr, false);
    }

    @Deprecated
    public byte[] decrypt(Slot slot, byte[] bArr, Cipher cipher) throws BadPaddingException, BadResponseException, NoSuchPaddingException, NoSuchAlgorithmException, IOException, ApduException {
        KeyType keyType;
        int length = bArr.length;
        if (length == 128) {
            keyType = KeyType.RSA1024;
        } else if (length == 256) {
            keyType = KeyType.RSA2048;
        } else {
            throw new IllegalArgumentException("Invalid length of ciphertext");
        }
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Decrypting data with key in slot {} of type {}", slot, keyType);
        return Padding.unpad(usePrivateKey(slot, keyType, bArr, false), cipher);
    }

    @Deprecated
    public byte[] calculateSecret(Slot slot, ECPublicKey eCPublicKey) throws BadResponseException, IOException, ApduException {
        return calculateSecret(slot, eCPublicKey.getW());
    }

    public byte[] calculateSecret(Slot slot, ECPoint eCPoint) throws BadResponseException, IOException, ApduException {
        KeyType keyType = eCPoint.getAffineX().bitLength() > 256 ? KeyType.ECCP384 : KeyType.ECCP256;
        byte[] encodedPoint = new PublicKeyValues.Ec(((KeyType.EcKeyParams) keyType.params).getCurveParams(), eCPoint.getAffineX(), eCPoint.getAffineY()).getEncodedPoint();
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Performing key agreement with key in slot {} of type {}", slot, keyType);
        return usePrivateKey(slot, keyType, encodedPoint, true);
    }

    private byte[] usePrivateKey(Slot slot, KeyType keyType, byte[] bArr, boolean z) throws BadResponseException, IOException, ApduException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(130, null);
        linkedHashMap.put(Integer.valueOf(z ? 133 : 129), bArr);
        try {
            return Tlvs.unpackValue(130, Tlvs.unpackValue(124, this.protocol.sendAndReceive(new Apdu(0, -121, keyType.value, slot.value, new Tlv(124, Tlvs.encodeMap(linkedHashMap)).getBytes()))));
        } catch (ApduException e) {
            if (27264 == e.getSw()) {
                throw new ApduException(e.getSw(), String.format(Locale.ROOT, "Make sure that %s key is generated on slot %02X", keyType.name(), Integer.valueOf(slot.value)));
            }
            throw e;
        }
    }

    public void setManagementKey(ManagementKeyType managementKeyType, byte[] bArr, boolean z) throws IOException, ApduException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Setting management key of type: {}", managementKeyType);
        if (managementKeyType != ManagementKeyType.TDES) {
            require(FEATURE_AES_KEY);
        }
        if (z) {
            require(FEATURE_USAGE_POLICY);
        }
        if (bArr.length != managementKeyType.keyLength) {
            throw new IllegalArgumentException(String.format("Management key must be %d bytes", Integer.valueOf(managementKeyType.keyLength)));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(managementKeyType.value);
        byteArrayOutputStream.write(new Tlv(155, bArr).getBytes());
        this.protocol.sendAndReceive(new Apdu(0, -1, 255, z ? TAG_LRC : 255, byteArrayOutputStream.toByteArray()));
        com.yubico.yubikit.core.internal.Logger.info(logger2, "Management key set");
    }

    public void verifyPin(char[] cArr) throws IOException, ApduException, InvalidPinException {
        try {
            com.yubico.yubikit.core.internal.Logger.debug(logger, "Verifying PIN");
            this.protocol.sendAndReceive(new Apdu(0, 32, 0, WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT, pinBytes(cArr)));
            this.currentPinAttempts = this.maxPinAttempts;
        } catch (ApduException e) {
            int retriesFromCode = getRetriesFromCode(e.getSw());
            if (retriesFromCode >= 0) {
                this.currentPinAttempts = retriesFromCode;
                throw new InvalidPinException(retriesFromCode);
            }
            throw e;
        }
    }

    public int getPinAttempts() throws IOException, ApduException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Getting PIN attempts");
        if (supports(FEATURE_METADATA)) {
            return getPinMetadata().getAttemptsRemaining();
        }
        try {
            this.protocol.sendAndReceive(new Apdu(0, 32, 0, WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT, (byte[]) null));
            com.yubico.yubikit.core.internal.Logger.debug(logger2, "Using cached value, may be incorrect");
            return this.currentPinAttempts;
        } catch (ApduException e) {
            int retriesFromCode = getRetriesFromCode(e.getSw());
            if (retriesFromCode >= 0) {
                this.currentPinAttempts = retriesFromCode;
                com.yubico.yubikit.core.internal.Logger.debug(logger, "Using value from empty verify");
                return retriesFromCode;
            }
            throw e;
        }
    }

    public void changePin(char[] cArr, char[] cArr2) throws IOException, ApduException, InvalidPinException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Changing PIN");
        changeReference((byte) 36, (byte) -128, cArr, cArr2);
        com.yubico.yubikit.core.internal.Logger.info(logger2, "New PIN set");
    }

    public void changePuk(char[] cArr, char[] cArr2) throws IOException, ApduException, InvalidPinException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Changing PUK");
        changeReference((byte) 36, PUK_P2, cArr, cArr2);
        com.yubico.yubikit.core.internal.Logger.info(logger2, "New PUK set");
    }

    public void unblockPin(char[] cArr, char[] cArr2) throws IOException, ApduException, InvalidPinException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Using PUK to set new PIN");
        changeReference((byte) 44, (byte) -128, cArr, cArr2);
        com.yubico.yubikit.core.internal.Logger.info(logger2, "New PIN set");
    }

    public void setPinAttempts(int i, int i2) throws IOException, ApduException {
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Setting PIN/PUK attempts ({}, {})", Integer.valueOf(i), Integer.valueOf(i2));
        this.protocol.sendAndReceive(new Apdu(0, -6, i, i2, (byte[]) null));
        this.maxPinAttempts = i;
        this.currentPinAttempts = i;
        com.yubico.yubikit.core.internal.Logger.info(logger2, "PIN/PUK attempts set");
    }

    public PinMetadata getPinMetadata() throws IOException, ApduException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Getting PIN metadata");
        return getPinPukMetadata((byte) -128);
    }

    public PinMetadata getPukMetadata() throws IOException, ApduException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Getting PUK metadata");
        return getPinPukMetadata(PUK_P2);
    }

    private PinMetadata getPinPukMetadata(byte b) throws IOException, ApduException {
        require(FEATURE_METADATA);
        Map<Integer, byte[]> mapDecodeMap = Tlvs.decodeMap(this.protocol.sendAndReceive(new Apdu(0, -9, 0, b, (byte[]) null)));
        byte[] bArr = mapDecodeMap.get(6);
        return new PinMetadata(mapDecodeMap.get(5)[0] != 0, bArr[0], bArr[1]);
    }

    public ManagementKeyMetadata getManagementKeyMetadata() throws IOException, ApduException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Getting management key metadata");
        require(FEATURE_METADATA);
        Map<Integer, byte[]> mapDecodeMap = Tlvs.decodeMap(this.protocol.sendAndReceive(new Apdu(0, -9, 0, 155, (byte[]) null)));
        return new ManagementKeyMetadata(mapDecodeMap.containsKey(1) ? ManagementKeyType.fromValue(mapDecodeMap.get(1)[0]) : ManagementKeyType.TDES, mapDecodeMap.get(5)[0] != 0, TouchPolicy.fromValue(mapDecodeMap.get(2)[1]));
    }

    public SlotMetadata getSlotMetadata(Slot slot) throws IOException, ApduException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Getting metadata for slot {}", slot);
        require(FEATURE_METADATA);
        Map<Integer, byte[]> mapDecodeMap = Tlvs.decodeMap(this.protocol.sendAndReceive(new Apdu(0, -9, 0, slot.value, (byte[]) null)));
        byte[] bArr = mapDecodeMap.get(2);
        return new SlotMetadata(KeyType.fromValue(mapDecodeMap.get(1)[0]), PinPolicy.fromValue(bArr[0]), TouchPolicy.fromValue(bArr[1]), mapDecodeMap.get(3)[0] == 1, mapDecodeMap.get(4));
    }

    public X509Certificate getCertificate(Slot slot) throws BadResponseException, IOException, ApduException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Reading certificate in slot {}", slot);
        Map<Integer, byte[]> mapDecodeMap = Tlvs.decodeMap(getObject(slot.objectId));
        byte[] bArr = mapDecodeMap.get(113);
        byte[] bArrDecompress = mapDecodeMap.get(112);
        if (bArr != null && bArr.length > 0 && bArr[0] != 0) {
            try {
                bArrDecompress = GzipUtils.decompress(bArrDecompress);
            } catch (IOException e) {
                throw new BadResponseException("Failed to decompress certificate", e);
            }
        }
        try {
            return parseCertificate(bArrDecompress);
        } catch (CertificateException e2) {
            throw new BadResponseException("Failed to parse certificate: ", e2);
        }
    }

    public void putCertificate(Slot slot, X509Certificate x509Certificate, boolean z) throws IOException, ApduException {
        byte[] bArr = {z ? (byte) 1 : (byte) 0};
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Storing {}certificate in slot {}", z ? "compressed " : "", slot);
        try {
            byte[] encoded = x509Certificate.getEncoded();
            if (z) {
                encoded = GzipUtils.compress(encoded);
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(112, encoded);
            linkedHashMap.put(113, bArr);
            linkedHashMap.put(Integer.valueOf(TAG_LRC), null);
            putObject(slot.objectId, Tlvs.encodeMap(linkedHashMap));
        } catch (CertificateEncodingException e) {
            throw new IllegalArgumentException("Failed to get encoded version of certificate", e);
        }
    }

    public void putCertificate(Slot slot, X509Certificate x509Certificate) throws IOException, ApduException {
        putCertificate(slot, x509Certificate, false);
    }

    public X509Certificate attestKey(Slot slot) throws BadResponseException, IOException, ApduException {
        require(FEATURE_ATTESTATION);
        try {
            byte[] bArrSendAndReceive = this.protocol.sendAndReceive(new Apdu(0, -7, slot.value, 0, (byte[]) null));
            com.yubico.yubikit.core.internal.Logger.debug(logger, "Attested key in slot {}", slot);
            return parseCertificate(bArrSendAndReceive);
        } catch (ApduException e) {
            if (27264 == e.getSw()) {
                throw new ApduException(e.getSw(), String.format(Locale.ROOT, "Make sure that key is generated on slot %02X", Integer.valueOf(slot.value)));
            }
            throw e;
        } catch (CertificateException e2) {
            throw new BadResponseException("Failed to parse certificate", e2);
        }
    }

    public void deleteCertificate(Slot slot) throws IOException, ApduException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Deleting certificate in slot {}", slot);
        putObject(slot.objectId, null);
    }

    static PublicKeyValues parsePublicKeyFromDevice(KeyType keyType, byte[] bArr) {
        Map<Integer, byte[]> mapDecodeMap = Tlvs.decodeMap(bArr);
        if (keyType.params.algorithm == KeyType.Algorithm.RSA) {
            return new PublicKeyValues.Rsa(new BigInteger(1, mapDecodeMap.get(129)), new BigInteger(1, mapDecodeMap.get(130)));
        }
        if (!(keyType.params instanceof KeyType.EcKeyParams)) {
            throw new IllegalArgumentException("Unsupported key type");
        }
        return PublicKeyValues.Ec.fromEncodedPoint(((KeyType.EcKeyParams) keyType.params).getCurveParams(), mapDecodeMap.get(134));
    }

    public void checkKeySupport(KeyType keyType, PinPolicy pinPolicy, TouchPolicy touchPolicy, boolean z) {
        if (this.version.major == 0) {
            return;
        }
        if (keyType == KeyType.ECCP384) {
            require(FEATURE_P384);
        }
        if (pinPolicy != PinPolicy.DEFAULT || touchPolicy != TouchPolicy.DEFAULT) {
            require(FEATURE_USAGE_POLICY);
            if (touchPolicy == TouchPolicy.CACHED) {
                require(FEATURE_TOUCH_CACHED);
            }
        }
        if (z && keyType.params.algorithm == KeyType.Algorithm.RSA) {
            require(FEATURE_RSA_GENERATION);
        }
        if (this.version.isAtLeast(4, 4, 0) && this.version.isLessThan(4, 5, 0)) {
            if (keyType == KeyType.RSA1024) {
                throw new UnsupportedOperationException("RSA 1024 is not supported on YubiKey FIPS");
            }
            if (pinPolicy == PinPolicy.NEVER) {
                throw new UnsupportedOperationException("PinPolicy.NEVER is not allowed on YubiKey FIPS");
            }
        }
    }

    public PublicKeyValues generateKeyValues(Slot slot, KeyType keyType, PinPolicy pinPolicy, TouchPolicy touchPolicy) throws BadResponseException, IOException, ApduException {
        checkKeySupport(keyType, pinPolicy, touchPolicy, true);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(128, new byte[]{keyType.value});
        if (pinPolicy != PinPolicy.DEFAULT) {
            linkedHashMap.put(170, new byte[]{(byte) pinPolicy.value});
        }
        if (touchPolicy != TouchPolicy.DEFAULT) {
            linkedHashMap.put(Integer.valueOf(TAG_TOUCH_POLICY), new byte[]{(byte) touchPolicy.value});
        }
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Generating key with pin_policy={}, touch_policy={}", pinPolicy, touchPolicy);
        byte[] bArrSendAndReceive = this.protocol.sendAndReceive(new Apdu(0, 71, 0, slot.value, new Tlv(-84, Tlvs.encodeMap(linkedHashMap)).getBytes()));
        com.yubico.yubikit.core.internal.Logger.info(logger2, "Private key generated in slot {} of type {}", slot, keyType);
        return parsePublicKeyFromDevice(keyType, Tlvs.unpackValue(32585, bArrSendAndReceive));
    }

    @Deprecated
    public PublicKey generateKey(Slot slot, KeyType keyType, PinPolicy pinPolicy, TouchPolicy touchPolicy) throws BadResponseException, IOException, ApduException {
        try {
            return generateKeyValues(slot, keyType, pinPolicy, touchPolicy).toPublicKey();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public KeyType putKey(Slot slot, PrivateKeyValues privateKeyValues, PinPolicy pinPolicy, TouchPolicy touchPolicy) throws IOException, ApduException {
        KeyType keyTypeFromKeyParams = KeyType.fromKeyParams(privateKeyValues);
        checkKeySupport(keyTypeFromKeyParams, pinPolicy, touchPolicy, false);
        KeyType.KeyParams keyParams = keyTypeFromKeyParams.params;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = AnonymousClass2.$SwitchMap$com$yubico$yubikit$piv$KeyType$Algorithm[keyParams.algorithm.ordinal()];
        if (i == 1) {
            int i2 = (keyParams.bitLength / 8) / 2;
            PrivateKeyValues.Rsa rsa = (PrivateKeyValues.Rsa) privateKeyValues;
            linkedHashMap.put(1, ByteUtils.intToLength(rsa.getPrimeP(), i2));
            linkedHashMap.put(2, ByteUtils.intToLength(rsa.getPrimeQ(), i2));
            linkedHashMap.put(3, ByteUtils.intToLength((BigInteger) Objects.requireNonNull(rsa.getPrimeExponentP()), i2));
            linkedHashMap.put(4, ByteUtils.intToLength((BigInteger) Objects.requireNonNull(rsa.getPrimeExponentQ()), i2));
            linkedHashMap.put(5, ByteUtils.intToLength((BigInteger) Objects.requireNonNull(rsa.getCrtCoefficient()), i2));
        } else if (i == 2) {
            linkedHashMap.put(6, ((PrivateKeyValues.Ec) privateKeyValues).getSecret());
        }
        if (pinPolicy != PinPolicy.DEFAULT) {
            linkedHashMap.put(170, new byte[]{(byte) pinPolicy.value});
        }
        if (touchPolicy != TouchPolicy.DEFAULT) {
            linkedHashMap.put(Integer.valueOf(TAG_TOUCH_POLICY), new byte[]{(byte) touchPolicy.value});
        }
        Logger logger2 = logger;
        com.yubico.yubikit.core.internal.Logger.debug(logger2, "Importing key with pin_policy={}, touch_policy={}", pinPolicy, touchPolicy);
        this.protocol.sendAndReceive(new Apdu(0, -2, keyTypeFromKeyParams.value, slot.value, Tlvs.encodeMap(linkedHashMap)));
        com.yubico.yubikit.core.internal.Logger.info(logger2, "Private key imported in slot {} of type {}", slot, keyTypeFromKeyParams);
        return keyTypeFromKeyParams;
    }

    /* JADX INFO: renamed from: com.yubico.yubikit.piv.PivSession$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$yubico$yubikit$piv$KeyType$Algorithm;

        static {
            int[] iArr = new int[KeyType.Algorithm.values().length];
            $SwitchMap$com$yubico$yubikit$piv$KeyType$Algorithm = iArr;
            try {
                iArr[KeyType.Algorithm.RSA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$yubico$yubikit$piv$KeyType$Algorithm[KeyType.Algorithm.EC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Deprecated
    public KeyType putKey(Slot slot, PrivateKey privateKey, PinPolicy pinPolicy, TouchPolicy touchPolicy) throws IOException, ApduException {
        return putKey(slot, PrivateKeyValues.fromPrivateKey(privateKey), pinPolicy, touchPolicy);
    }

    public byte[] getObject(int i) throws BadResponseException, IOException, ApduException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Reading data from object slot {}", Integer.toString(i, 16));
        return Tlvs.unpackValue(83, this.protocol.sendAndReceive(new Apdu(0, -53, 63, 255, new Tlv(92, ObjectId.getBytes(i)).getBytes())));
    }

    public void putObject(int i, @Nullable byte[] bArr) throws IOException, ApduException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Writing data to object slot {}", Integer.toString(i, 16));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(92, ObjectId.getBytes(i));
        linkedHashMap.put(83, bArr);
        this.protocol.sendAndReceive(new Apdu(0, -37, 63, 255, Tlvs.encodeMap(linkedHashMap)));
    }

    private X509Certificate parseCertificate(byte[] bArr) throws CertificateException {
        return (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr));
    }

    private void changeReference(byte b, byte b2, char[] cArr, char[] cArr2) throws IOException, ApduException, InvalidPinException {
        byte b3;
        byte[] bArrPinBytes = pinBytes(cArr, cArr2);
        try {
            try {
                b3 = b2;
                try {
                    this.protocol.sendAndReceive(new Apdu(0, b, 0, b3, bArrPinBytes));
                    Arrays.fill(bArrPinBytes, (byte) 0);
                } catch (ApduException e) {
                    e = e;
                    ApduException apduException = e;
                    int retriesFromCode = getRetriesFromCode(apduException.getSw());
                    if (retriesFromCode >= 0) {
                        if (b3 == -128) {
                            this.currentPinAttempts = retriesFromCode;
                        }
                        throw new InvalidPinException(retriesFromCode);
                    }
                    throw apduException;
                }
            } catch (ApduException e2) {
                e = e2;
                b3 = b2;
            }
        } catch (Throwable th) {
            Arrays.fill(bArrPinBytes, (byte) 0);
            throw th;
        }
    }

    private void blockPin() throws IOException, ApduException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Verify PIN with invalid attempts until blocked");
        int pinAttempts = getPinAttempts();
        while (pinAttempts > 0) {
            try {
                verifyPin(new char[0]);
            } catch (InvalidPinException e) {
                pinAttempts = e.getAttemptsRemaining();
            }
        }
        com.yubico.yubikit.core.internal.Logger.debug(logger, "PIN is blocked");
    }

    private void blockPuk() throws IOException, ApduException {
        com.yubico.yubikit.core.internal.Logger.debug(logger, "Verify PUK with invalid attempts until blocked");
        int attemptsRemaining = 1;
        while (attemptsRemaining > 0) {
            try {
                changeReference((byte) 44, (byte) -128, new char[0], new char[0]);
            } catch (InvalidPinException e) {
                attemptsRemaining = e.getAttemptsRemaining();
            }
        }
        com.yubico.yubikit.core.internal.Logger.debug(logger, "PUK is blocked");
    }

    private static byte[] pinBytes(char[] cArr) {
        ByteBuffer byteBufferEncode = StandardCharsets.UTF_8.encode(CharBuffer.wrap(cArr));
        try {
            int iLimit = byteBufferEncode.limit() - byteBufferEncode.position();
            if (iLimit > 8) {
                throw new IllegalArgumentException("PIN/PUK must be no longer than 8 bytes");
            }
            byte[] bArrCopyOf = Arrays.copyOf(byteBufferEncode.array(), 8);
            Arrays.fill(bArrCopyOf, iLimit, 8, (byte) -1);
            Arrays.fill(byteBufferEncode.array(), (byte) 0);
            return bArrCopyOf;
        } catch (Throwable th) {
            Arrays.fill(byteBufferEncode.array(), (byte) 0);
            throw th;
        }
    }

    private static byte[] pinBytes(char[] cArr, char[] cArr2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArrPinBytes = pinBytes(cArr);
        byte[] bArrPinBytes2 = pinBytes(cArr2);
        try {
            try {
                byteArrayOutputStream.write(bArrPinBytes);
                byteArrayOutputStream.write(bArrPinBytes2);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Arrays.fill(bArrPinBytes, (byte) 0);
                Arrays.fill(bArrPinBytes2, (byte) 0);
                return byteArray;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            Arrays.fill(bArrPinBytes, (byte) 0);
            Arrays.fill(bArrPinBytes2, (byte) 0);
            throw th;
        }
    }

    private int getRetriesFromCode(int i) {
        if (i == 27011) {
            return 0;
        }
        if (this.version.isLessThan(1, 0, 4)) {
            if (i < 25344 || i > 25599) {
                return -1;
            }
            return i & 255;
        }
        if (i < 25536 || i > 25551) {
            return -1;
        }
        return i & 15;
    }
}
