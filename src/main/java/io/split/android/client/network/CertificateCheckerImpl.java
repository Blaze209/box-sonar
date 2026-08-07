package io.split.android.client.network;

import io.split.android.client.utils.Base64Util;
import io.split.android.client.utils.logger.Logger;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes4.dex */
class CertificateCheckerImpl implements CertificateChecker {
    private final Base64Encoder mBase64Encoder;
    private final ChainCleaner mChainCleaner;
    private final Map<String, Set<CertificatePin>> mConfiguredPins;
    private final CertificatePinningFailureListener mFailureListener;
    private final PinEncoder mPinEncoder;

    CertificateCheckerImpl(CertificatePinningConfiguration certificatePinningConfiguration, X509TrustManager trustManager) {
        this(certificatePinningConfiguration.getPins(), certificatePinningConfiguration.getFailureListener(), new ChainCleanerImpl(trustManager), new DefaultBase64Encoder(), new PinEncoderImpl());
    }

    CertificateCheckerImpl(Map<String, Set<CertificatePin>> configuredPins, CertificatePinningFailureListener failureListener, ChainCleaner chainCleaner, Base64Encoder base64Encoder, PinEncoder pinEncoder) {
        this.mConfiguredPins = configuredPins == null ? new HashMap<>() : configuredPins;
        this.mFailureListener = failureListener;
        this.mChainCleaner = chainCleaner;
        this.mBase64Encoder = base64Encoder;
        this.mPinEncoder = pinEncoder;
    }

    @Override // io.split.android.client.network.CertificateChecker
    public synchronized void checkPins(HttpsURLConnection httpsConnection) throws SSLPeerUnverifiedException {
        String host = httpsConnection.getURL().getHost();
        Set<CertificatePin> pinsForHost = CertificateCheckerHelper.getPinsForHost(host, this.mConfiguredPins);
        if (pinsForHost == null || pinsForHost.isEmpty()) {
            Logger.d("No certificate pins configured for " + host + ". Skipping pinning verification.");
            return;
        }
        try {
            List<X509Certificate> listClean = this.mChainCleaner.clean(host, httpsConnection.getServerCertificates());
            for (X509Certificate x509Certificate : listClean) {
                for (CertificatePin certificatePin : pinsForHost) {
                    if (Arrays.equals(this.mPinEncoder.encodeCertPin(certificatePin.getAlgorithm(), x509Certificate.getPublicKey().getEncoded()), certificatePin.getPin())) {
                        Logger.v("Certificate pinning verification successful for " + host);
                        return;
                    }
                }
            }
            try {
                CertificatePinningFailureListener certificatePinningFailureListener = this.mFailureListener;
                if (certificatePinningFailureListener != null) {
                    certificatePinningFailureListener.onCertificatePinningFailure(host, listClean);
                }
            } catch (Exception e) {
                Logger.w("Exception occurred executing certificate pinning failure listener: " + e.getLocalizedMessage());
            }
            throw new SSLPeerUnverifiedException("Certificate pinning verification failed for host: " + host + ". Chain:\n" + certificateChainInfo(listClean));
        } catch (Exception unused) {
            throw new SSLPeerUnverifiedException("Error cleaning certificate chain for host: " + host);
        }
    }

    private String certificateChainInfo(List<X509Certificate> cleanCertificates) {
        StringBuilder sb = new StringBuilder();
        for (X509Certificate x509Certificate : cleanCertificates) {
            sb.append(x509Certificate.getSubjectDN().getName()).append(" - sha256/").append(this.mBase64Encoder.encode(this.mPinEncoder.encodeCertPin("sha256", x509Certificate.getPublicKey().getEncoded())));
        }
        return sb.toString();
    }

    private static class DefaultBase64Encoder implements Base64Encoder {
        private DefaultBase64Encoder() {
        }

        @Override // io.split.android.client.network.Base64Encoder
        public String encode(String value) {
            return Base64Util.encode(value);
        }

        @Override // io.split.android.client.network.Base64Encoder
        public String encode(byte[] bytes) {
            return Base64Util.encode(bytes);
        }
    }
}
