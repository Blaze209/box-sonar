package org.jose4j.jwe.kdf;

import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import org.jose4j.lang.ByteUtil;
import org.jose4j.lang.HashUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class ConcatKeyDerivationFunction {
    private static final Logger log = LoggerFactory.getLogger((Class<?>) ConcatKeyDerivationFunction.class);
    private int digestLength;
    private MessageDigest messageDigest;

    private boolean traceLog() {
        return false;
    }

    public ConcatKeyDerivationFunction(String str) {
        this.messageDigest = HashUtil.getMessageDigest(str);
        init();
    }

    public ConcatKeyDerivationFunction(String str, String str2) {
        this.messageDigest = HashUtil.getMessageDigest(str, str2);
        init();
    }

    private void init() {
        this.digestLength = ByteUtil.bitLength(this.messageDigest.getDigestLength());
        if (traceLog()) {
            log.trace("Hash Algorithm: {} with hashlen: {} bits", this.messageDigest.getAlgorithm(), Integer.valueOf(this.digestLength));
        }
    }

    public byte[] kdf(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        if (traceLog()) {
            StringBuilder sb = new StringBuilder("KDF:\n  z: ");
            sb.append(ByteUtil.toDebugString(bArr)).append("\n  keydatalen: ");
            sb.append(i);
            sb.append("  algorithmId: ").append(ByteUtil.toDebugString(bArr2)).append("\n  partyUInfo: ");
            sb.append(ByteUtil.toDebugString(bArr3)).append("\n  partyVInfo: ");
            sb.append(ByteUtil.toDebugString(bArr4)).append("\n  suppPubInfo: ");
            sb.append(ByteUtil.toDebugString(bArr5)).append("\n  suppPrivInfo: ");
            sb.append(ByteUtil.toDebugString(bArr6));
            log.trace(sb.toString());
        }
        return kdf(bArr, i, ByteUtil.concat(bArr2, bArr3, bArr4, bArr5, bArr6));
    }

    public byte[] kdf(byte[] bArr, int i, byte[] bArr2) {
        long reps = getReps(i);
        if (traceLog()) {
            Logger logger = log;
            logger.trace("reps: {}", String.valueOf(reps));
            logger.trace("otherInfo: {}", ByteUtil.toDebugString(bArr2));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i2 = 1; i2 <= reps; i2++) {
            byte[] bytes = ByteUtil.getBytes(i2);
            if (traceLog()) {
                Logger logger2 = log;
                logger2.trace("rep {} hashing ", Integer.valueOf(i2));
                logger2.trace(" counter: {}", ByteUtil.toDebugString(bytes));
                logger2.trace(" z: {}", ByteUtil.toDebugString(bArr));
                logger2.trace(" otherInfo: {}", ByteUtil.toDebugString(bArr2));
            }
            this.messageDigest.update(bytes);
            this.messageDigest.update(bArr);
            this.messageDigest.update(bArr2);
            byte[] bArrDigest = this.messageDigest.digest();
            if (traceLog()) {
                log.trace(" k({}): {}", Integer.valueOf(i2), ByteUtil.toDebugString(bArrDigest));
            }
            byteArrayOutputStream.write(bArrDigest, 0, bArrDigest.length);
        }
        int iByteLength = ByteUtil.byteLength(i);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (traceLog()) {
            log.trace("derived key material: {}", ByteUtil.toDebugString(byteArray));
        }
        if (byteArray.length != iByteLength) {
            byteArray = ByteUtil.subArray(byteArray, 0, iByteLength);
            if (traceLog()) {
                log.trace("first {} bits of derived key material: {}", Integer.valueOf(i), ByteUtil.toDebugString(byteArray));
            }
        }
        if (traceLog()) {
            log.trace("final derived key material: {}", ByteUtil.toDebugString(byteArray));
        }
        return byteArray;
    }

    long getReps(int i) {
        return (int) Math.ceil(i / this.digestLength);
    }
}
