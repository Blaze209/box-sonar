package com.pspdfkit.signatures.timestamp;

import com.pspdfkit.signatures.X509CertificateData;
import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/pspdfkit/signatures/timestamp/TimestampInformation;", "", "signingCertificate", "Lcom/pspdfkit/signatures/X509CertificateData;", "trustedDate", "Ljava/util/Date;", "<init>", "(Lcom/pspdfkit/signatures/X509CertificateData;Ljava/util/Date;)V", "getSigningCertificate", "()Lcom/pspdfkit/signatures/X509CertificateData;", "getTrustedDate", "()Ljava/util/Date;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TimestampInformation {
    public static final int $stable = 8;
    private final X509CertificateData signingCertificate;
    private final Date trustedDate;

    public TimestampInformation(X509CertificateData x509CertificateData, Date date) {
        this.signingCertificate = x509CertificateData;
        this.trustedDate = date;
    }

    public final X509CertificateData getSigningCertificate() {
        return this.signingCertificate;
    }

    public final Date getTrustedDate() {
        return this.trustedDate;
    }
}
