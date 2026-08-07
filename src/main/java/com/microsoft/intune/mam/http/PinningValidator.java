package com.microsoft.intune.mam.http;

import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes3.dex */
public class PinningValidator implements CertChainValidator {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(PinningValidator.class);
    private final String mHashAlgorithm;
    private final String[] mValidHashes;

    public PinningValidator(String[] strArr, String str) {
        this.mValidHashes = strArr;
        this.mHashAlgorithm = str;
    }

    @Override // com.microsoft.intune.mam.http.CertChainValidator
    public void validateChain(X509Certificate[] x509CertificateArr) throws CertificateException {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            MAMLogger mAMLogger = LOGGER;
            mAMLogger.info("certificate subject name: " + x509Certificate.getSubjectDN().getName(), new Object[0]);
            try {
                String publicKeyHash = CertPinningUtils.getPublicKeyHash(x509Certificate, this.mHashAlgorithm);
                mAMLogger.info("SPKI hash: " + publicKeyHash, new Object[0]);
                if (hasMatch(publicKeyHash)) {
                    mAMLogger.info("cert matches pin", new Object[0]);
                    return;
                }
            } catch (NoSuchAlgorithmException e) {
                LOGGER.error(MAMInterfaceError.CERT_PINNING_PUBLIC_KEY_HASH_CALCULATION_FAILED, "couldn't calculate certificate public key hash", e);
                throw new CertificateException("certificate chain failed additional Intune validation", e);
            }
        }
        handleValidationFailure(x509CertificateArr);
    }

    protected void handleValidationFailure(X509Certificate[] x509CertificateArr) throws CertificateException {
        LOGGER.error(MAMInterfaceError.CERT_PINNING_NO_MATCH, "no matching pin for certificate chain", new Object[0]);
        throw new CertificateException("certificate chain failed additional Intune validation");
    }

    private boolean hasMatch(String str) {
        for (String str2 : this.mValidHashes) {
            if (MessageDigest.isEqual(str.getBytes(), str2.getBytes())) {
                return true;
            }
        }
        return false;
    }
}
