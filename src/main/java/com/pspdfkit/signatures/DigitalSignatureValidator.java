package com.pspdfkit.signatures;

import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.jni.NativeDocumentSignatureValidator;
import com.pspdfkit.internal.jni.NativeKeyStore;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativeSignatureValidationResult;
import com.pspdfkit.internal.t8;
import io.reactivex.rxjava3.core.Single;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/pspdfkit/signatures/DigitalSignatureValidator;", "", "<init>", "()V", "validateSignature", "Lcom/pspdfkit/signatures/DigitalSignatureValidationResult;", "digitalSignatureInfo", "Lcom/pspdfkit/signatures/DigitalSignatureInfo;", "validateSignatureAsync", "Lio/reactivex/rxjava3/core/Single;", "checkCertificateRevocationState", "", "disableCertificateRevocationCheck", "", "setupCertificateRevocationChecking", "signatureInfo", "validator", "Lcom/pspdfkit/internal/jni/NativeDocumentSignatureValidator;", "keyStore", "Lcom/pspdfkit/internal/jni/NativeKeyStore;", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DigitalSignatureValidator {
    public static final DigitalSignatureValidator INSTANCE = new DigitalSignatureValidator();
    private static boolean checkCertificateRevocationState = true;
    public static final int $stable = 8;

    private DigitalSignatureValidator() {
    }

    private final void setupCertificateRevocationChecking(DigitalSignatureInfo signatureInfo, NativeDocumentSignatureValidator validator, NativeKeyStore keyStore) {
        if (checkCertificateRevocationState) {
            validator.setCertificateRevocationResponses(t8.a(signatureInfo.getDocumentInternal().y, CollectionsKt.emptyList(), keyStore));
        }
    }

    @JvmStatic
    public static final DigitalSignatureValidationResult validateSignature(DigitalSignatureInfo digitalSignatureInfo) {
        digitalSignatureInfo.getClass();
        DigitalSignatureValidationResult digitalSignatureValidationResultBlockingGet = INSTANCE.validateSignatureAsync(digitalSignatureInfo).blockingGet();
        digitalSignatureValidationResultBlockingGet.getClass();
        return digitalSignatureValidationResultBlockingGet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DigitalSignatureValidationResult validateSignatureAsync$lambda$0(DigitalSignatureInfo digitalSignatureInfo) {
        NativeDocumentSignatureValidator nativeDocumentSignatureValidatorCreate = NativeDocumentSignatureValidator.create(digitalSignatureInfo.getFormField());
        nativeDocumentSignatureValidatorCreate.getClass();
        NativeKeyStore nativeKeystore = TrustedKeyStore.toNativeKeystore();
        INSTANCE.setupCertificateRevocationChecking(digitalSignatureInfo, nativeDocumentSignatureValidatorCreate, nativeKeystore);
        NativeSignatureValidationResult nativeSignatureValidationResultVerifyDocument = nativeDocumentSignatureValidatorCreate.verifyDocument(nativeKeystore);
        nativeSignatureValidationResultVerifyDocument.getClass();
        return new DigitalSignatureValidationResult(nativeSignatureValidationResultVerifyDocument, digitalSignatureInfo.getFormField().documentModifiedSinceSignature());
    }

    public final void disableCertificateRevocationCheck() {
        checkCertificateRevocationState = false;
    }

    public final Single<DigitalSignatureValidationResult> validateSignatureAsync(final DigitalSignatureInfo digitalSignatureInfo) {
        digitalSignatureInfo.getClass();
        if (!ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
            throw new InvalidNutrientLicenseException("Validating signatures of a PDF document requires the digital signature feature in your license.");
        }
        Single<DigitalSignatureValidationResult> singleFromCallable = Single.fromCallable(new Callable() { // from class: com.pspdfkit.signatures.DigitalSignatureValidator$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DigitalSignatureValidator.validateSignatureAsync$lambda$0(digitalSignatureInfo);
            }
        });
        singleFromCallable.getClass();
        return singleFromCallable;
    }
}
