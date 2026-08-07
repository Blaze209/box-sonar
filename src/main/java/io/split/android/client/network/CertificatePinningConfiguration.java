package io.split.android.client.network;

import io.split.android.client.utils.Base64Util;
import io.split.android.client.utils.logger.Logger;
import java.io.InputStream;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class CertificatePinningConfiguration {
    private final CertificatePinningFailureListener mFailureListener;
    private final Map<String, Set<CertificatePin>> mPins;

    private CertificatePinningConfiguration() {
        this(new Builder());
    }

    private CertificatePinningConfiguration(Map<String, Set<CertificatePin>> pins, CertificatePinningFailureListener failureListener) {
        this.mPins = pins;
        this.mFailureListener = failureListener;
    }

    private CertificatePinningConfiguration(Builder builder) {
        this((Map<String, Set<CertificatePin>>) builder.mPins, builder.mFailureListener);
    }

    public Map<String, Set<CertificatePin>> getPins() {
        return this.mPins;
    }

    public CertificatePinningFailureListener getFailureListener() {
        return this.mFailureListener;
    }

    public static Builder builder() {
        return new Builder();
    }

    static Builder builder(Base64Decoder base64Decoder, PinEncoder pinEncoder) {
        return new Builder(base64Decoder, pinEncoder);
    }

    public static class Builder {
        private final Base64Decoder mBase64Decoder;
        private CertificatePinningFailureListener mFailureListener;
        private final PinEncoder mPinEncoder;
        private final Map<String, Set<CertificatePin>> mPins;

        private Builder() {
            this(new DefaultBase64Decoder(), new PinEncoderImpl());
        }

        Builder(Base64Decoder base64Decoder, PinEncoder pinEncoder) {
            this.mPins = new LinkedHashMap();
            this.mBase64Decoder = base64Decoder;
            this.mPinEncoder = pinEncoder;
        }

        public Builder addPin(String host, String pin) {
            if (host == null || host.trim().isEmpty()) {
                Logger.e("Host cannot be null or empty. Ignoring entry");
                return this;
            }
            if (pin == null || pin.trim().isEmpty()) {
                Logger.e("Pin cannot be null or empty. Ignoring entry for host " + host);
                return this;
            }
            String[] strArrSplit = pin.split("/", 2);
            if (strArrSplit.length != 2) {
                Logger.e("Pin must be in the form \"[algorithm]/[hash]\". Ignoring entry for host " + host);
                return this;
            }
            String str = strArrSplit[1];
            String str2 = strArrSplit[0];
            if (!str2.equalsIgnoreCase("sha256") && !str2.equalsIgnoreCase("sha1")) {
                Logger.e("Invalid algorithm. Must be sha256 or sha1. Ignoring entry for host " + host);
                return this;
            }
            getInitializedPins(host).add(new CertificatePin(this.mBase64Decoder.decode(str), str2));
            return this;
        }

        public Builder addPin(String host, InputStream inputStream) {
            if (host == null || host.trim().isEmpty()) {
                Logger.e("Host cannot be null or empty. Ignoring entry");
                return this;
            }
            if (inputStream == null) {
                Logger.e("InputStream cannot be null. Ignoring entry for host " + host);
            }
            Set<CertificatePin> initializedPins = getInitializedPins(host);
            Set<CertificatePin> pinsFromInputStream = CertificateCheckerHelper.getPinsFromInputStream(inputStream, this.mPinEncoder);
            if (pinsFromInputStream.isEmpty()) {
                Logger.e("No pins found in input stream. Ignoring entry for host " + host);
                return this;
            }
            initializedPins.addAll(pinsFromInputStream);
            return this;
        }

        public Builder failureListener(CertificatePinningFailureListener failureListener) {
            if (failureListener == null) {
                Logger.w("Failure listener cannot be null");
                return this;
            }
            this.mFailureListener = failureListener;
            return this;
        }

        void addPins(String host, Set<CertificatePin> pins) {
            if (host == null || host.trim().isEmpty()) {
                Logger.e("Host cannot be null or empty. Ignoring entry");
                return;
            }
            if (pins == null || pins.isEmpty()) {
                Logger.e("Pins cannot be null or empty. Ignoring entry for host " + host);
                return;
            }
            HashSet hashSet = new HashSet();
            for (CertificatePin certificatePin : pins) {
                if (certificatePin == null) {
                    Logger.e("Pin cannot be null. Ignoring entry for host " + host);
                } else if (!certificatePin.getAlgorithm().equalsIgnoreCase("sha256") && !certificatePin.getAlgorithm().equalsIgnoreCase("sha1")) {
                    Logger.e("Invalid algorithm. Must be sha256 or sha1. Ignoring entry for host " + host);
                } else {
                    hashSet.add(certificatePin);
                }
            }
            if (hashSet.isEmpty()) {
                return;
            }
            this.mPins.put(host, hashSet);
        }

        public CertificatePinningConfiguration build() {
            return new CertificatePinningConfiguration(this);
        }

        private Set<CertificatePin> getInitializedPins(String host) {
            Set<CertificatePin> set = this.mPins.get(host);
            if (set != null) {
                return set;
            }
            HashSet hashSet = new HashSet();
            this.mPins.put(host, hashSet);
            return hashSet;
        }

        private static class DefaultBase64Decoder implements Base64Decoder {
            private DefaultBase64Decoder() {
            }

            @Override // io.split.android.client.network.Base64Decoder
            public byte[] decode(String base64) {
                return Base64Util.bytesDecode(base64);
            }
        }
    }
}
