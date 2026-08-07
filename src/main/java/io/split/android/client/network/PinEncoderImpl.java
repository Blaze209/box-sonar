package io.split.android.client.network;

import io.split.android.client.utils.logger.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes4.dex */
class PinEncoderImpl implements PinEncoder {
    PinEncoderImpl() {
    }

    @Override // io.split.android.client.network.PinEncoder
    public byte[] encodeCertPin(String algorithm, byte[] encodedPublicKey) {
        algorithm.hashCode();
        if (algorithm.equals("sha256")) {
            return sha256Hash(encodedPublicKey);
        }
        if (algorithm.equals("sha1")) {
            return sha1Hash(encodedPublicKey);
        }
        return new byte[0];
    }

    private static byte[] sha256Hash(byte[] encoded) {
        MessageDigest digest = getDigest("SHA-256");
        if (digest != null) {
            return digest.digest(encoded);
        }
        return new byte[0];
    }

    private static byte[] sha1Hash(byte[] encoded) {
        MessageDigest digest = getDigest("SHA-1");
        if (digest != null) {
            return digest.digest(encoded);
        }
        return new byte[0];
    }

    private static MessageDigest getDigest(String algorithm) {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            Logger.e("Error getting " + algorithm + " MessageDigest: " + e.getMessage());
            return null;
        }
    }
}
