package com.microsoft.intune.mam.http;

import com.microsoft.intune.mam.client.telemetry.TelemetryLogger;
import com.microsoft.intune.mam.client.telemetry.events.TrackedOccurrence;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.lang.reflect.Array;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes3.dex */
class MAMTrustManagerHelper extends PinningValidator {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMTrustManagerHelper.class);
    private final String mPackageName;
    private final TelemetryLogger mTelemetryLogger;

    MAMTrustManagerHelper(KnownClouds knownClouds, TelemetryLogger telemetryLogger, String str) {
        super(knownClouds.getIntermediateCertHashes(), knownClouds.getHashAlgorithm());
        this.mTelemetryLogger = telemetryLogger;
        this.mPackageName = str;
    }

    @Override // com.microsoft.intune.mam.http.PinningValidator, com.microsoft.intune.mam.http.CertChainValidator
    public void validateChain(X509Certificate[] x509CertificateArr) throws CertificateException {
        int length = Array.getLength(x509CertificateArr);
        for (int i = 1; i < length; i++) {
            X509Certificate x509Certificate = x509CertificateArr[i];
            X509Certificate x509Certificate2 = x509CertificateArr[i - 1];
            try {
                x509Certificate2.verify(x509Certificate.getPublicKey());
            } catch (Exception unused) {
                logCertificateError(TrackedOccurrence.SSL_CERT_VALIDATION_FAILED_WRONG_PUBLIC_KEY, x509Certificate2);
                throw new CertificateException("Unable to verify certificate.");
            }
        }
        if (length < 2) {
            handleValidationFailure(x509CertificateArr);
        }
        super.validateChain(x509CertificateArr);
        LOGGER.fine("cert validated", new Object[0]);
    }

    @Override // com.microsoft.intune.mam.http.PinningValidator
    protected void handleValidationFailure(X509Certificate[] x509CertificateArr) throws CertificateException {
        logCertificateChainError(TrackedOccurrence.SSL_CERT_VALIDATION_FAILED_MSIT_CERT_NOT_FOUND, x509CertificateArr);
        throw new CertificateException("Unable to verify certificate.");
    }

    private void logCertificateError(TrackedOccurrence trackedOccurrence, X509Certificate x509Certificate) {
        this.mTelemetryLogger.logTrackedOccurrence(this.mPackageName, trackedOccurrence, x509Certificate == null ? "empty" : x509Certificate.getSubjectDN().getName());
    }

    private void logCertificateChainError(TrackedOccurrence trackedOccurrence, X509Certificate[] x509CertificateArr) {
        if (Array.getLength(x509CertificateArr) == 0) {
            this.mTelemetryLogger.logTrackedOccurrence(this.mPackageName, trackedOccurrence, "no certs in chain");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            sb.append(x509Certificate.getSubjectDN().getName());
            sb.append(" -> ");
        }
        this.mTelemetryLogger.logTrackedOccurrence(this.mPackageName, trackedOccurrence, sb.toString());
    }
}
