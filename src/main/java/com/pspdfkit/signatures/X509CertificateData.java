package com.pspdfkit.signatures;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001Bo\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\n\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\f\u0010\u001aR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001d¨\u0006\u001f"}, d2 = {"Lcom/pspdfkit/signatures/X509CertificateData;", "", "publicKey", "Lcom/pspdfkit/signatures/PublicKey;", "issuerCn", "", "issuerDn", "subjectCn", "subjectDn", "serialNumber", "isSelfSigned", "", "isCaCertificate", "validFrom", "Ljava/util/Date;", "validUntil", "<init>", "(Lcom/pspdfkit/signatures/PublicKey;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/Date;Ljava/util/Date;)V", "getPublicKey", "()Lcom/pspdfkit/signatures/PublicKey;", "getIssuerCn", "()Ljava/lang/String;", "getIssuerDn", "getSubjectCn", "getSubjectDn", "getSerialNumber", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getValidFrom", "()Ljava/util/Date;", "getValidUntil", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class X509CertificateData {
    public static final int $stable = 8;
    private final Boolean isCaCertificate;
    private final Boolean isSelfSigned;
    private final String issuerCn;
    private final String issuerDn;
    private final PublicKey publicKey;
    private final String serialNumber;
    private final String subjectCn;
    private final String subjectDn;
    private final Date validFrom;
    private final Date validUntil;

    public X509CertificateData(PublicKey publicKey, String str, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, Date date, Date date2) {
        this.publicKey = publicKey;
        this.issuerCn = str;
        this.issuerDn = str2;
        this.subjectCn = str3;
        this.subjectDn = str4;
        this.serialNumber = str5;
        this.isSelfSigned = bool;
        this.isCaCertificate = bool2;
        this.validFrom = date;
        this.validUntil = date2;
    }

    public final String getIssuerCn() {
        return this.issuerCn;
    }

    public final String getIssuerDn() {
        return this.issuerDn;
    }

    public final PublicKey getPublicKey() {
        return this.publicKey;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final String getSubjectCn() {
        return this.subjectCn;
    }

    public final String getSubjectDn() {
        return this.subjectDn;
    }

    public final Date getValidFrom() {
        return this.validFrom;
    }

    public final Date getValidUntil() {
        return this.validUntil;
    }

    /* JADX INFO: renamed from: isCaCertificate, reason: from getter */
    public final Boolean getIsCaCertificate() {
        return this.isCaCertificate;
    }

    /* JADX INFO: renamed from: isSelfSigned, reason: from getter */
    public final Boolean getIsSelfSigned() {
        return this.isSelfSigned;
    }

    public /* synthetic */ X509CertificateData(PublicKey publicKey, String str, String str2, String str3, String str4, String str5, Boolean bool, Boolean bool2, Date date, Date date2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(publicKey, str, str2, str3, str4, str5, (i & 64) != 0 ? Boolean.FALSE : bool, (i & 128) != 0 ? Boolean.FALSE : bool2, date, date2);
    }
}
