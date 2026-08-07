package com.pspdfkit.signatures;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.pspdfkit.R;
import com.pspdfkit.internal.j20;
import com.pspdfkit.internal.jni.NativeCertificateChainValidationStatus;
import com.pspdfkit.internal.jni.NativeCertificateValidationStatus;
import com.pspdfkit.internal.jni.NativeDocumentIntegrityStatus;
import com.pspdfkit.internal.jni.NativeSignatureValidationInformation;
import com.pspdfkit.internal.jni.NativeSignatureValidationProblem;
import com.pspdfkit.internal.jni.NativeSignatureValidationResult;
import com.pspdfkit.internal.jni.NativeSignatureValidationStatus;
import com.pspdfkit.internal.jni.NativeTimestampInformation;
import com.pspdfkit.internal.jni.NativeX509Certificate;
import com.pspdfkit.internal.no;
import com.pspdfkit.internal.nv;
import com.pspdfkit.internal.uw;
import com.pspdfkit.signatures.timestamp.TimestampInformation;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class DigitalSignatureValidationResult implements Parcelable {
    public static final Parcelable.Creator<DigitalSignatureValidationResult> CREATOR = new Parcelable.Creator<DigitalSignatureValidationResult>() { // from class: com.pspdfkit.signatures.DigitalSignatureValidationResult.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DigitalSignatureValidationResult createFromParcel(Parcel parcel) {
            return new DigitalSignatureValidationResult(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DigitalSignatureValidationResult[] newArray(int i) {
            return new DigitalSignatureValidationResult[i];
        }
    };
    private final String certificateChainValidationErrorMessage;
    private final CertificateStatus certificateChainValidationStatus;
    private final DocumentIntegrityStatus documentIntegrityStatus;
    private final String hashAlgorithm;
    private final Boolean isLtv;
    private String padesSignatureLevel;
    private final List<ValidationProblem> problems;
    private final String signatureAlgorithm;
    private String signatureType;
    private final X509CertificateData signingCertificate;
    private final ValidationStatus status;
    private final TimestampInformation timestampStatus;
    private final boolean wasModifiedSinceSignature;

    /* JADX INFO: renamed from: com.pspdfkit.signatures.DigitalSignatureValidationResult$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus;
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$internal$jni$NativeDocumentIntegrityStatus;
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$internal$jni$NativeSignatureValidationProblem;
        static final /* synthetic */ int[] $SwitchMap$com$pspdfkit$internal$jni$NativeSignatureValidationStatus;

        static {
            int[] iArr = new int[NativeCertificateValidationStatus.values().length];
            $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus = iArr;
            try {
                iArr[NativeCertificateValidationStatus.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.OK_BUT_SELF_SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.OK_BUT_COULD_NOT_CHECK_REVOCATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.UNTRUSTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.EXPIRED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.EXPIRED_NO_POE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.EXPIRED_BUT_VALID_IN_THE_PAST.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.NOT_YET_VALID.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.NOT_YET_VALID_NO_POE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.INVALID.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.REVOKED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.REVOKED_NO_POE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.REVOKED_BUT_VALID_IN_THE_PAST.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.FAILED_RETRIEVE_SIGNATURE_CONTENTS.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[NativeCertificateValidationStatus.GENERAL_VALIDATION_PROBLEM.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            int[] iArr2 = new int[NativeDocumentIntegrityStatus.values().length];
            $SwitchMap$com$pspdfkit$internal$jni$NativeDocumentIntegrityStatus = iArr2;
            try {
                iArr2[NativeDocumentIntegrityStatus.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeDocumentIntegrityStatus[NativeDocumentIntegrityStatus.TAMPERED_DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeDocumentIntegrityStatus[NativeDocumentIntegrityStatus.FAILED_RETRIEVE_SIGNATURE_CONTENTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeDocumentIntegrityStatus[NativeDocumentIntegrityStatus.FAILED_RETRIEVE_BYTE_RANGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeDocumentIntegrityStatus[NativeDocumentIntegrityStatus.FAILED_COMPUTE_DIGEST.ordinal()] = 5;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeDocumentIntegrityStatus[NativeDocumentIntegrityStatus.FAILED_RETRIEVE_SIGNING_CERTIFICATE.ordinal()] = 6;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeDocumentIntegrityStatus[NativeDocumentIntegrityStatus.FAILED_RETRIEVE_PUBLIC_KEY.ordinal()] = 7;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeDocumentIntegrityStatus[NativeDocumentIntegrityStatus.FAILED_ENCRYPTION_PADDING.ordinal()] = 8;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeDocumentIntegrityStatus[NativeDocumentIntegrityStatus.FAILED_UNSUPPORTED_SIGNATURE_TYPE.ordinal()] = 9;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeDocumentIntegrityStatus[NativeDocumentIntegrityStatus.TAMPERED_OR_INVALID_TIMESTAMP.ordinal()] = 10;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeDocumentIntegrityStatus[NativeDocumentIntegrityStatus.GENERAL_FAILURE.ordinal()] = 11;
            } catch (NoSuchFieldError unused26) {
            }
            int[] iArr3 = new int[NativeSignatureValidationProblem.values().length];
            $SwitchMap$com$pspdfkit$internal$jni$NativeSignatureValidationProblem = iArr3;
            try {
                iArr3[NativeSignatureValidationProblem.UNTRUSTED_CERTIFICATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeSignatureValidationProblem[NativeSignatureValidationProblem.CERTIFICATE_CHAIN_FAILURE.ordinal()] = 2;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeSignatureValidationProblem[NativeSignatureValidationProblem.DOCUMENT_INTEGRITY_FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeSignatureValidationProblem[NativeSignatureValidationProblem.SELF_SIGNED.ordinal()] = 4;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeSignatureValidationProblem[NativeSignatureValidationProblem.COULD_NOT_CHECK_REVOCATION_STATUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused31) {
            }
            int[] iArr4 = new int[NativeSignatureValidationStatus.values().length];
            $SwitchMap$com$pspdfkit$internal$jni$NativeSignatureValidationStatus = iArr4;
            try {
                iArr4[NativeSignatureValidationStatus.VALID.ordinal()] = 1;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeSignatureValidationStatus[NativeSignatureValidationStatus.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                $SwitchMap$com$pspdfkit$internal$jni$NativeSignatureValidationStatus[NativeSignatureValidationStatus.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused34) {
            }
        }
    }

    public enum CertificateStatus {
        OK,
        OK_BUT_SELF_SIGNED,
        OK_BUT_REVOCATION_CHECK_FAILED,
        OK_BUT_NOT_CHECKED_AGAINST_CA,
        EXPIRED,
        EXPIRED_NO_POE,
        EXPIRED_BUT_VALID_IN_THE_PAST,
        NOT_YET_VALID,
        NOT_YET_VALID_NO_POE,
        INVALID,
        REVOKED,
        REVOKED_NO_POE,
        REVOKED_BUT_VALID_IN_THE_PAST,
        FAILED_RETRIEVE_SIGNATURE_CONTENTS,
        GENERAL_VALIDATION_PROBLEM;

        public String getLocalizedDescription(Context context) {
            uw.a(context, "context", null);
            switch (this) {
                case OK:
                case OK_BUT_SELF_SIGNED:
                case OK_BUT_REVOCATION_CHECK_FAILED:
                case OK_BUT_NOT_CHECKED_AGAINST_CA:
                    return null;
                case EXPIRED:
                case EXPIRED_NO_POE:
                case EXPIRED_BUT_VALID_IN_THE_PAST:
                    return no.a(context, R.string.pspdf__digital_signature_certificate_status_expired, null);
                case NOT_YET_VALID:
                case NOT_YET_VALID_NO_POE:
                    return no.a(context, R.string.pspdf__digital_signature_certificate_not_yet_valid, null);
                case INVALID:
                    return no.a(context, R.string.pspdf__digital_signature_certificate_invalid, null);
                case REVOKED:
                case REVOKED_NO_POE:
                case REVOKED_BUT_VALID_IN_THE_PAST:
                    return no.a(context, R.string.pspdf__digital_signature_certificate_revoked, null);
                case FAILED_RETRIEVE_SIGNATURE_CONTENTS:
                    return no.a(context, R.string.pspdf__digital_signature_certificate_failed_retrieve_signature_contents, null);
                case GENERAL_VALIDATION_PROBLEM:
                    return no.a(context, R.string.pspdf__digital_signature_certificate_general_validation_problem, null);
                default:
                    throw new IncompatibleClassChangeError();
            }
        }
    }

    public enum DocumentIntegrityStatus {
        OK,
        TAMPERED_DOCUMENT,
        FAILED_RETRIEVE_SIGNATURE_CONTENTS,
        FAILED_RETRIEVE_BYTE_RANGE,
        FAILED_COMPUTE_DIGEST,
        FAILED_RETRIEVE_SIGNING_CERTIFICATE,
        FAILED_RETRIEVE_PUBLIC_KEY,
        FAILED_ENCRYPTION_PADDING,
        FAILED_UNSUPPORTED_SIGNATURE_TYPE,
        FAILED_TAMPERED_OR_INVALID_TIMESTAMP,
        GENERAL_FAILURE;

        public String getLocalizedDescription(Context context) {
            uw.a(context, "context", null);
            switch (this) {
                case OK:
                case TAMPERED_DOCUMENT:
                    return null;
                case FAILED_RETRIEVE_SIGNATURE_CONTENTS:
                    return no.a(context, R.string.pspdf__digital_signature_failed_retrieve_signature_contents, null);
                case FAILED_RETRIEVE_BYTE_RANGE:
                    return no.a(context, R.string.pspdf__digital_signature_failed_retrieve_byte_range, null);
                case FAILED_COMPUTE_DIGEST:
                    return no.a(context, R.string.pspdf__digital_signature_failed_compute_digest, null);
                case FAILED_RETRIEVE_SIGNING_CERTIFICATE:
                    return no.a(context, R.string.pspdf__digital_signature_failed_retrieve_signing_certificate, null);
                case FAILED_RETRIEVE_PUBLIC_KEY:
                    return no.a(context, R.string.pspdf__digital_signature_failed_retrieve_public_key, null);
                case FAILED_ENCRYPTION_PADDING:
                    return no.a(context, R.string.pspdf__digital_signature_failed_encryption_padding, null);
                case FAILED_UNSUPPORTED_SIGNATURE_TYPE:
                    return no.a(context, R.string.pspdf__digital_signature_unsupported_signature, null);
                case FAILED_TAMPERED_OR_INVALID_TIMESTAMP:
                    return no.a(context, R.string.pspdf__digital_signature_invalid_timestamp, null);
                case GENERAL_FAILURE:
                    return no.a(context, R.string.pspdf__digital_signature_general_failure, null);
                default:
                    throw new IncompatibleClassChangeError();
            }
        }
    }

    public enum ValidationProblem {
        EMPTY_TRUSTED_KEYSTORE,
        CERTIFICATE_CHAIN_FAILURE,
        DOCUMENT_INTEGRITY_FAILURE,
        SELF_SIGNED,
        COULD_NOT_CHECK_REVOCATION_STATUS;

        public String getLocalizedDescription(Context context) {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return no.a(context, R.string.pspdf__digital_signature_error_certificate_chain_not_provided, null);
            }
            if (iOrdinal == 1) {
                return no.a(context, R.string.pspdf__digital_signature_error_certificate_chain_invalid, null);
            }
            if (iOrdinal == 2) {
                return no.a(context, R.string.pspdf__digital_signature_error_integrity_check, null);
            }
            if (iOrdinal == 3) {
                return no.a(context, R.string.pspdf__digital_signature_integrity_self_signed, null);
            }
            if (iOrdinal == 4) {
                return no.a(context, R.string.pspdf__digital_signature_cant_check_cert_revocation_status, null);
            }
            throw new IncompatibleClassChangeError();
        }
    }

    public DigitalSignatureValidationResult(NativeSignatureValidationResult nativeSignatureValidationResult, boolean z) {
        ValidationStatus validationStatus;
        DocumentIntegrityStatus documentIntegrityStatus;
        CertificateStatus certificateStatus;
        ValidationProblem validationProblem;
        this.signatureType = "";
        this.padesSignatureLevel = "";
        int i = AnonymousClass2.$SwitchMap$com$pspdfkit$internal$jni$NativeSignatureValidationStatus[nativeSignatureValidationResult.getStatus().ordinal()];
        if (i == 1) {
            validationStatus = ValidationStatus.VALID;
        } else if (i == 2) {
            validationStatus = ValidationStatus.ERROR;
        } else {
            if (i != 3) {
                throw new IncompatibleClassChangeError();
            }
            validationStatus = ValidationStatus.WARNING;
        }
        if (validationStatus == ValidationStatus.ERROR && shouldDemoteValidationErrorToValidationWarning(nativeSignatureValidationResult)) {
            this.status = ValidationStatus.WARNING;
        } else {
            this.status = validationStatus;
        }
        this.wasModifiedSinceSignature = z;
        this.problems = new ArrayList(nativeSignatureValidationResult.getErrors().size());
        ArrayList<NativeSignatureValidationProblem> errors = nativeSignatureValidationResult.getErrors();
        int size = errors.size();
        int i2 = 0;
        while (i2 < size) {
            NativeSignatureValidationProblem nativeSignatureValidationProblem = errors.get(i2);
            i2++;
            int i3 = AnonymousClass2.$SwitchMap$com$pspdfkit$internal$jni$NativeSignatureValidationProblem[nativeSignatureValidationProblem.ordinal()];
            if (i3 == 1) {
                validationProblem = ValidationProblem.EMPTY_TRUSTED_KEYSTORE;
            } else if (i3 == 2) {
                validationProblem = ValidationProblem.CERTIFICATE_CHAIN_FAILURE;
            } else if (i3 == 3) {
                validationProblem = ValidationProblem.DOCUMENT_INTEGRITY_FAILURE;
            } else if (i3 == 4) {
                validationProblem = ValidationProblem.SELF_SIGNED;
            } else {
                if (i3 != 5) {
                    throw new IncompatibleClassChangeError();
                }
                validationProblem = ValidationProblem.COULD_NOT_CHECK_REVOCATION_STATUS;
            }
            this.problems.add(validationProblem);
        }
        switch (AnonymousClass2.$SwitchMap$com$pspdfkit$internal$jni$NativeDocumentIntegrityStatus[nativeSignatureValidationResult.getDocumentIntegrityStatus().ordinal()]) {
            case 1:
                documentIntegrityStatus = DocumentIntegrityStatus.OK;
                break;
            case 2:
                documentIntegrityStatus = DocumentIntegrityStatus.TAMPERED_DOCUMENT;
                break;
            case 3:
                documentIntegrityStatus = DocumentIntegrityStatus.FAILED_RETRIEVE_SIGNATURE_CONTENTS;
                break;
            case 4:
                documentIntegrityStatus = DocumentIntegrityStatus.FAILED_RETRIEVE_BYTE_RANGE;
                break;
            case 5:
                documentIntegrityStatus = DocumentIntegrityStatus.FAILED_COMPUTE_DIGEST;
                break;
            case 6:
                documentIntegrityStatus = DocumentIntegrityStatus.FAILED_RETRIEVE_SIGNING_CERTIFICATE;
                break;
            case 7:
                documentIntegrityStatus = DocumentIntegrityStatus.FAILED_RETRIEVE_PUBLIC_KEY;
                break;
            case 8:
                documentIntegrityStatus = DocumentIntegrityStatus.FAILED_ENCRYPTION_PADDING;
                break;
            case 9:
                documentIntegrityStatus = DocumentIntegrityStatus.FAILED_UNSUPPORTED_SIGNATURE_TYPE;
                break;
            case 10:
                documentIntegrityStatus = DocumentIntegrityStatus.FAILED_TAMPERED_OR_INVALID_TIMESTAMP;
                break;
            case 11:
                documentIntegrityStatus = DocumentIntegrityStatus.GENERAL_FAILURE;
                break;
            default:
                throw new IncompatibleClassChangeError();
        }
        this.documentIntegrityStatus = documentIntegrityStatus;
        TimestampInformation timestampInformation = null;
        NativeCertificateChainValidationStatus certificateChainValidationStatus = nativeSignatureValidationResult.getSignatureInformation() != null ? nativeSignatureValidationResult.getSignatureInformation().getCertificateChainValidationStatus() : null;
        if (certificateChainValidationStatus != null) {
            switch (AnonymousClass2.$SwitchMap$com$pspdfkit$internal$jni$NativeCertificateValidationStatus[certificateChainValidationStatus.getOverallStatus().ordinal()]) {
                case 1:
                    certificateStatus = CertificateStatus.OK;
                    break;
                case 2:
                    certificateStatus = CertificateStatus.OK_BUT_SELF_SIGNED;
                    break;
                case 3:
                    certificateStatus = CertificateStatus.OK_BUT_REVOCATION_CHECK_FAILED;
                    break;
                case 4:
                    certificateStatus = CertificateStatus.OK_BUT_NOT_CHECKED_AGAINST_CA;
                    break;
                case 5:
                    certificateStatus = CertificateStatus.EXPIRED;
                    break;
                case 6:
                    certificateStatus = CertificateStatus.EXPIRED_NO_POE;
                    break;
                case 7:
                    certificateStatus = CertificateStatus.EXPIRED_BUT_VALID_IN_THE_PAST;
                    break;
                case 8:
                    certificateStatus = CertificateStatus.NOT_YET_VALID;
                    break;
                case 9:
                    certificateStatus = CertificateStatus.NOT_YET_VALID_NO_POE;
                    break;
                case 10:
                    certificateStatus = CertificateStatus.INVALID;
                    break;
                case 11:
                    certificateStatus = CertificateStatus.REVOKED;
                    break;
                case 12:
                    certificateStatus = CertificateStatus.REVOKED_NO_POE;
                    break;
                case 13:
                    certificateStatus = CertificateStatus.REVOKED_BUT_VALID_IN_THE_PAST;
                    break;
                case 14:
                    certificateStatus = CertificateStatus.FAILED_RETRIEVE_SIGNATURE_CONTENTS;
                    break;
                case 15:
                    certificateStatus = CertificateStatus.GENERAL_VALIDATION_PROBLEM;
                    break;
                default:
                    throw new IncompatibleClassChangeError();
            }
            this.certificateChainValidationStatus = certificateStatus;
            this.certificateChainValidationErrorMessage = certificateChainValidationStatus.getRawErrorMessage();
        } else {
            this.certificateChainValidationStatus = null;
            this.certificateChainValidationErrorMessage = null;
        }
        NativeSignatureValidationInformation signatureInformation = nativeSignatureValidationResult.getSignatureInformation();
        String strName = signatureInformation.getSignatureType().name();
        Locale locale = Locale.ROOT;
        this.signatureType = strName.toUpperCase(locale);
        if (signatureInformation.getPadesSignatureLevel() != null) {
            this.padesSignatureLevel = signatureInformation.getPadesSignatureLevel().name().toUpperCase(locale);
        }
        this.signingCertificate = j20.a(signatureInformation.getSigningCertificate());
        if (signatureInformation.getTimestampStatus() != null) {
            NativeTimestampInformation timestampStatus = signatureInformation.getTimestampStatus();
            if (timestampStatus != null) {
                NativeX509Certificate signingCertificate = timestampStatus.getSigningCertificate();
                signingCertificate.getClass();
                timestampInformation = new TimestampInformation(j20.a(signingCertificate), timestampStatus.getTrustedDate());
            }
            this.timestampStatus = timestampInformation;
        } else {
            this.timestampStatus = null;
        }
        this.signatureAlgorithm = signatureInformation.getSignatureAlgorithm().name().toUpperCase(locale);
        this.hashAlgorithm = signatureInformation.getHashAlgorithm().name().toUpperCase(locale);
        this.isLtv = Boolean.valueOf(signatureInformation.isLtv());
    }

    private boolean shouldDemoteValidationErrorToValidationWarning(NativeSignatureValidationResult nativeSignatureValidationResult) {
        if (nativeSignatureValidationResult.getDocumentIntegrityStatus() != NativeDocumentIntegrityStatus.OK || nativeSignatureValidationResult.getSignatureInformation() == null) {
            return false;
        }
        NativeCertificateValidationStatus nativeCertificateValidationStatus = NativeCertificateValidationStatus.UNTRUSTED;
        NativeCertificateChainValidationStatus certificateChainValidationStatus = nativeSignatureValidationResult.getSignatureInformation().getCertificateChainValidationStatus();
        NativeCertificateValidationStatus overallStatus = certificateChainValidationStatus != null ? certificateChainValidationStatus.getOverallStatus() : nativeCertificateValidationStatus;
        return overallStatus == NativeCertificateValidationStatus.OK || overallStatus == NativeCertificateValidationStatus.OK_BUT_SELF_SIGNED || overallStatus == nativeCertificateValidationStatus;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCertificateChainValidationErrorMessage() {
        return this.certificateChainValidationErrorMessage;
    }

    public CertificateStatus getCertificateChainValidationStatus() {
        return this.certificateChainValidationStatus;
    }

    public DocumentIntegrityStatus getDocumentIntegrityStatus() {
        return this.documentIntegrityStatus;
    }

    public String getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public String getPadesSignatureLevel() {
        return this.padesSignatureLevel;
    }

    public List<ValidationProblem> getProblems() {
        return this.problems;
    }

    public String getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public String getSignatureType() {
        return this.signatureType;
    }

    public X509CertificateData getSigningCertificate() {
        return this.signingCertificate;
    }

    public TimestampInformation getTimestampStatus() {
        return this.timestampStatus;
    }

    public ValidationStatus getValidationStatus() {
        return this.status;
    }

    public String toString() {
        return nv.a(new StringBuilder("DigitalSignatureValidationResult{status=").append(this.status).append(", problems=").append(this.problems).append(", documentIntegrityStatus=").append(this.documentIntegrityStatus).append(", certificateChainValidationStatus=").append(this.certificateChainValidationStatus).append(", certificateChainValidationErrorMessage='"), this.certificateChainValidationErrorMessage, "'}");
    }

    public boolean wasDocumentModified() {
        return this.wasModifiedSinceSignature;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.status.ordinal());
        parcel.writeList(this.problems);
        parcel.writeInt(this.documentIntegrityStatus.ordinal());
        CertificateStatus certificateStatus = this.certificateChainValidationStatus;
        parcel.writeInt(certificateStatus == null ? -1 : certificateStatus.ordinal());
        parcel.writeString(this.certificateChainValidationErrorMessage);
        parcel.writeByte(this.wasModifiedSinceSignature ? (byte) 1 : (byte) 0);
        parcel.writeString(this.signatureAlgorithm);
        parcel.writeString(this.hashAlgorithm);
        parcel.writeByte(this.isLtv.booleanValue() ? (byte) 1 : (byte) 0);
    }

    public DigitalSignatureValidationResult(ValidationStatus validationStatus, List<ValidationProblem> list, DocumentIntegrityStatus documentIntegrityStatus, CertificateStatus certificateStatus, String str, boolean z, boolean z2) {
        this.signatureType = "";
        this.padesSignatureLevel = "";
        this.status = validationStatus;
        this.problems = list;
        this.documentIntegrityStatus = documentIntegrityStatus;
        this.certificateChainValidationStatus = certificateStatus;
        this.certificateChainValidationErrorMessage = str;
        this.wasModifiedSinceSignature = z;
        this.isLtv = Boolean.valueOf(z2);
        this.signatureAlgorithm = "";
        this.hashAlgorithm = "";
        this.signingCertificate = null;
        this.timestampStatus = null;
    }

    public DigitalSignatureValidationResult(Parcel parcel) {
        this.signatureType = "";
        this.padesSignatureLevel = "";
        this.status = ValidationStatus.values()[parcel.readInt()];
        ArrayList arrayList = new ArrayList();
        this.problems = arrayList;
        parcel.readList(arrayList, ValidationProblem.class.getClassLoader());
        this.documentIntegrityStatus = DocumentIntegrityStatus.values()[parcel.readInt()];
        this.certificateChainValidationStatus = CertificateStatus.values()[parcel.readInt()];
        this.certificateChainValidationErrorMessage = parcel.readString();
        this.wasModifiedSinceSignature = parcel.readByte() != 0;
        this.signatureAlgorithm = parcel.readString();
        this.hashAlgorithm = parcel.readString();
        this.isLtv = Boolean.valueOf(parcel.readByte() != 0);
        this.signingCertificate = null;
        this.timestampStatus = null;
    }
}
