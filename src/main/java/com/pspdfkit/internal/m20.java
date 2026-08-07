package com.pspdfkit.internal;

import android.content.Context;
import com.facebook.imageutils.JfifUtil;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeDataToSign;
import com.pspdfkit.internal.jni.NativeDataToSignResult;
import com.pspdfkit.internal.jni.NativeDigitalSignatureBinaryResult;
import com.pspdfkit.internal.jni.NativeDigitalSignatureCreationError;
import com.pspdfkit.internal.jni.NativeDigitalSignatureCreationResult;
import com.pspdfkit.internal.jni.NativeDigitalSignatureCreator;
import com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata;
import com.pspdfkit.internal.jni.NativeDigitalSignatureResult;
import com.pspdfkit.internal.jni.NativeDigitalSignatureType;
import com.pspdfkit.internal.jni.NativeFormField;
import com.pspdfkit.internal.jni.NativeHashAlgorithm;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativePKCS7Creator;
import com.pspdfkit.internal.jni.NativeX509Certificate;
import com.pspdfkit.signatures.DigitalSignatureMetadata;
import com.pspdfkit.signatures.DigitalSignatureType;
import com.pspdfkit.signatures.HashAlgorithm;
import com.pspdfkit.signatures.KeyFileHelpersKt;
import com.pspdfkit.signatures.SignerOptions;
import com.pspdfkit.signatures.SigningConfiguration;
import com.pspdfkit.signatures.timestamp.TimestampData;
import com.pspdfkit.utils.Response;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes3.dex */
public final class m20 {
    public static final m20 a = new m20();

    @DebugMetadata(c = "com.pspdfkit.internal.signatures.SigningManagerInternal", f = "SigningManagerInternal.kt", i = {0, 0, 0, 0, 0}, l = {250}, m = "embedPKCS7Signature", n = {"context", "signerOptions", "signedData", "certificates", "nativeCertificates"}, nl = {251}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"}, v = 2)
    public static final class a extends ContinuationImpl {
        public Object a;
        public SignerOptions b;
        public byte[] c;
        public Object d;
        public List e;
        public /* synthetic */ Object f;
        public int h;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return m20.this.a(null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.signatures.SigningManagerInternal", f = "SigningManagerInternal.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {202, 208, JfifUtil.MARKER_EOI}, m = "embedSignature", n = {"context", "signerOptions", "signedData", "unsignedData", "hashAlgorithm", "certificates", "nativeCertificates", "context", "signerOptions", "signedData", "unsignedData", "hashAlgorithm", "certificates", "nativeCertificates", "metadata", "nativeDigitalSignatureCreator", "nativeDataProvider", "signatureFormField", "it", "$i$a$-let-SigningManagerInternal$embedSignature$timestampCoroutineScope$1", "context", "signerOptions", "signedData", "unsignedData", "hashAlgorithm", "certificates", "nativeCertificates", "metadata", "nativeDigitalSignatureCreator", "nativeDataProvider", "signatureFormField", "timestampCoroutineScope"}, nl = {203, 207, 218}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11"}, v = 2)
    public static final class b extends ContinuationImpl {
        public Object a;
        public Object b;
        public Object c;
        public Object d;
        public HashAlgorithm e;
        public Object f;
        public Object g;
        public Object h;
        public NativeDigitalSignatureCreator i;
        public DataProviderShim j;
        public NativeFormField k;
        public Object l;
        public NativeDigitalSignatureType m;
        public byte[] n;
        public byte[] o;
        public ArrayList p;
        public /* synthetic */ Object q;
        public int s;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.q = obj;
            this.s |= Integer.MIN_VALUE;
            return m20.this.a(null, null, null, null, null, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.signatures.SigningManagerInternal", f = "SigningManagerInternal.kt", i = {0, 0, 0, 0}, l = {Token.METHOD}, m = "getDataToSign", n = {"context", "signerOptions", "x509Certificates", "nativeCertificates"}, nl = {Token.ARROW}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 2)
    public static final class c extends ContinuationImpl {
        public Object a;
        public SignerOptions b;
        public Object c;
        public List d;
        public /* synthetic */ Object e;
        public int g;

        public c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return m20.this.a(null, null, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.signatures.SigningManagerInternal", f = "SigningManagerInternal.kt", i = {0, 0, 0, 0, 0, 0}, l = {283}, m = "signWithBasicSignature", n = {"context", "signingConfiguration", "unsignedData", "hashAlgorithm", "certificates", "nativeCertificates"}, nl = {282}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 2)
    public static final class d extends ContinuationImpl {
        public Object a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public /* synthetic */ Object g;
        public int i;

        public d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return m20.this.a((Context) null, (SigningConfiguration) null, (byte[]) null, (HashAlgorithm) null, this);
        }
    }

    @DebugMetadata(c = "com.pspdfkit.internal.signatures.SigningManagerInternal", f = "SigningManagerInternal.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {326}, m = "signWithCAdESSignature", n = {"context", "signingConfiguration", "unsignedData", "hashAlgorithm", "certificates", "nativeCertificates", "cadesAttributesToSign", "resultWithCadesAttributesToSign"}, nl = {325}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 2)
    public static final class e extends ContinuationImpl {
        public Object a;
        public Object b;
        public Object c;
        public Object d;
        public Object e;
        public Object f;
        public Object g;
        public Object h;
        public /* synthetic */ Object i;
        public int k;

        public e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.k |= Integer.MIN_VALUE;
            return m20.this.b(null, null, null, null, this);
        }
    }

    public static NativeDigitalSignatureCreator a(List list, NativeDigitalSignatureMetadata nativeDigitalSignatureMetadata) {
        list.getClass();
        NativeDigitalSignatureCreationResult nativeDigitalSignatureCreationResultCreate = NativeDigitalSignatureCreator.create(new ArrayList(list), nativeDigitalSignatureMetadata);
        nativeDigitalSignatureCreationResultCreate.getClass();
        if (nativeDigitalSignatureCreationResultCreate.getHasError()) {
            NativeDigitalSignatureCreationError error = nativeDigitalSignatureCreationResultCreate.getError();
            throw new RuntimeException(error != null ? error.getErrorMessage() : null);
        }
        NativeDigitalSignatureCreator value = nativeDigitalSignatureCreationResultCreate.getValue();
        if (value != null) {
            return value;
        }
        NativeDigitalSignatureCreationError error2 = nativeDigitalSignatureCreationResultCreate.getError();
        throw new RuntimeException(error2 != null ? error2.getErrorMessage() : null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(Context context, SigningConfiguration signingConfiguration, byte[] bArr, HashAlgorithm hashAlgorithm, Continuation<? super Response<byte[]>> continuation) throws CertificateEncodingException {
        e eVar;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i = eVar.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                eVar.k = i - Integer.MIN_VALUE;
            } else {
                eVar = new e(continuation);
            }
        } else {
            eVar = new e(continuation);
        }
        e eVar2 = eVar;
        Object objA = eVar2.i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = eVar2.k;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objA);
            if (!ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
                throw new InvalidNutrientLicenseException("Signing form fields requires digital signature feature in your license!");
            }
            List<X509Certificate> certificates = signingConfiguration.getCertificates();
            List listA = j20.a(certificates);
            NativeDigitalSignatureBinaryResult nativeDigitalSignatureBinaryResultCreateCadesAttributesToSign = NativePKCS7Creator.createCadesAttributesToSign(bArr, mr.a(hashAlgorithm), (NativeX509Certificate) CollectionsKt.first(listA));
            nativeDigitalSignatureBinaryResultCreateCadesAttributesToSign.getClass();
            if (nativeDigitalSignatureBinaryResultCreateCadesAttributesToSign.getHasError()) {
                NativeDigitalSignatureCreationError error = nativeDigitalSignatureBinaryResultCreateCadesAttributesToSign.getError();
                throw new RuntimeException(error != null ? error.getErrorMessage() : null);
            }
            byte[] value = nativeDigitalSignatureBinaryResultCreateCadesAttributesToSign.getValue();
            if (value == null) {
                NativeDigitalSignatureCreationError error2 = nativeDigitalSignatureBinaryResultCreateCadesAttributesToSign.getError();
                throw new RuntimeException(error2 != null ? error2.getErrorMessage() : null);
            }
            DigitalSignatureType digitalSignatureType = DigitalSignatureType.CADES;
            eVar2.a = SpillingKt.nullOutSpilledVariable(context);
            eVar2.b = SpillingKt.nullOutSpilledVariable(signingConfiguration);
            eVar2.c = SpillingKt.nullOutSpilledVariable(bArr);
            eVar2.d = SpillingKt.nullOutSpilledVariable(hashAlgorithm);
            eVar2.e = SpillingKt.nullOutSpilledVariable(certificates);
            eVar2.f = SpillingKt.nullOutSpilledVariable(listA);
            eVar2.g = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureBinaryResultCreateCadesAttributesToSign);
            eVar2.h = SpillingKt.nullOutSpilledVariable(value);
            eVar2.k = 1;
            objA = a(context, digitalSignatureType, signingConfiguration, value, listA, hashAlgorithm, eVar2);
            if (objA == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objA);
        }
        return new Response.Success((byte[]) objA);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Context context, SignerOptions signerOptions, Continuation<? super Response<? extends Pair<byte[], ? extends HashAlgorithm>>> continuation) throws CertificateEncodingException {
        c cVar;
        List list;
        KeyStore.PrivateKeyEntry privateKeyEntry;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i = cVar.g;
            if ((i & Integer.MIN_VALUE) != 0) {
                cVar.g = i - Integer.MIN_VALUE;
            } else {
                cVar = new c(continuation);
            }
        } else {
            cVar = new c(continuation);
        }
        Object objA = cVar.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = cVar.g;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objA);
                List<X509Certificate> certificates = signerOptions.getCertificates();
                if (certificates.isEmpty() && ((privateKeyEntry = signerOptions.getPrivateKeyEntry()) == null || (certificates = KeyFileHelpersKt.getX509Certificates(privateKeyEntry)) == null)) {
                    certificates = CollectionsKt.emptyList();
                }
                List listA = j20.a(certificates);
                if (ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
                    cVar.a = SpillingKt.nullOutSpilledVariable(context);
                    cVar.b = signerOptions;
                    cVar.c = SpillingKt.nullOutSpilledVariable(certificates);
                    cVar.d = listA;
                    cVar.g = 1;
                    objA = xq.a(context, signerOptions, listA, cVar);
                    if (objA == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list = listA;
                } else {
                    throw new InvalidNutrientLicenseException("Signing form fields requires digital signature feature in your license!");
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = cVar.d;
                signerOptions = cVar.b;
                ResultKt.throwOnFailure(objA);
            }
            NativeDigitalSignatureCreator nativeDigitalSignatureCreatorA = a(list, (NativeDigitalSignatureMetadata) objA);
            DataProviderShim dataProviderShim = new DataProviderShim(signerOptions.getOutputDataProvider());
            NativeFormField nativeFormField = signerOptions.getSignatureFormField().getInternal().getNativeFormField();
            nativeFormField.getClass();
            NativeDigitalSignatureResult nativeDigitalSignatureResultPrepareSignature = nativeDigitalSignatureCreatorA.prepareSignature(nativeFormField, dataProviderShim);
            nativeDigitalSignatureResultPrepareSignature.getClass();
            if (nativeDigitalSignatureResultPrepareSignature.getHasError()) {
                NativeDigitalSignatureCreationError error = nativeDigitalSignatureResultPrepareSignature.getError();
                throw new RuntimeException(error != null ? error.getErrorMessage() : null);
            }
            NativeDataToSignResult dataToSign = nativeDigitalSignatureCreatorA.getDataToSign(nativeFormField.getFQN(), dataProviderShim);
            dataToSign.getClass();
            if (dataToSign.getHasError()) {
                NativeDigitalSignatureCreationError error2 = dataToSign.getError();
                throw new RuntimeException(error2 != null ? error2.getErrorMessage() : null);
            }
            NativeDataToSign value = dataToSign.getValue();
            if (value != null) {
                NativeHashAlgorithm hashAlgorithm = value.getSignerOptions().getHashAlgorithm();
                hashAlgorithm.getClass();
                return new Response.Success(new Pair(value.getData(), mr.a(hashAlgorithm)));
            }
            throw new RuntimeException("Data to sign is null");
        } catch (Exception e2) {
            return new Response.Error(e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0198 A[Catch: Exception -> 0x0265, TryCatch #0 {Exception -> 0x0265, blocks: (B:14:0x0063, B:47:0x01e7, B:49:0x01f0, B:51:0x020d, B:53:0x0215, B:55:0x021b, B:56:0x021e, B:57:0x021f, B:59:0x0225, B:61:0x022d, B:63:0x0233, B:64:0x0236, B:65:0x0237, B:67:0x0248, B:69:0x0250, B:71:0x0256, B:72:0x0259, B:73:0x025a, B:19:0x0098, B:39:0x0174, B:41:0x018a, B:43:0x0198, B:22:0x00b8, B:31:0x0104, B:33:0x0128, B:35:0x012e, B:25:0x00bf, B:27:0x00cb, B:75:0x025d, B:76:0x0264), top: B:80:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:46:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:48:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:51:0x020d A[Catch: Exception -> 0x0265, TryCatch #0 {Exception -> 0x0265, blocks: (B:14:0x0063, B:47:0x01e7, B:49:0x01f0, B:51:0x020d, B:53:0x0215, B:55:0x021b, B:56:0x021e, B:57:0x021f, B:59:0x0225, B:61:0x022d, B:63:0x0233, B:64:0x0236, B:65:0x0237, B:67:0x0248, B:69:0x0250, B:71:0x0256, B:72:0x0259, B:73:0x025a, B:19:0x0098, B:39:0x0174, B:41:0x018a, B:43:0x0198, B:22:0x00b8, B:31:0x0104, B:33:0x0128, B:35:0x012e, B:25:0x00bf, B:27:0x00cb, B:75:0x025d, B:76:0x0264), top: B:80:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0215 A[Catch: Exception -> 0x0265, TryCatch #0 {Exception -> 0x0265, blocks: (B:14:0x0063, B:47:0x01e7, B:49:0x01f0, B:51:0x020d, B:53:0x0215, B:55:0x021b, B:56:0x021e, B:57:0x021f, B:59:0x0225, B:61:0x022d, B:63:0x0233, B:64:0x0236, B:65:0x0237, B:67:0x0248, B:69:0x0250, B:71:0x0256, B:72:0x0259, B:73:0x025a, B:19:0x0098, B:39:0x0174, B:41:0x018a, B:43:0x0198, B:22:0x00b8, B:31:0x0104, B:33:0x0128, B:35:0x012e, B:25:0x00bf, B:27:0x00cb, B:75:0x025d, B:76:0x0264), top: B:80:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:54:0x021a  */
    /* JADX WARN: Code duplicated, block: B:57:0x021f A[Catch: Exception -> 0x0265, TryCatch #0 {Exception -> 0x0265, blocks: (B:14:0x0063, B:47:0x01e7, B:49:0x01f0, B:51:0x020d, B:53:0x0215, B:55:0x021b, B:56:0x021e, B:57:0x021f, B:59:0x0225, B:61:0x022d, B:63:0x0233, B:64:0x0236, B:65:0x0237, B:67:0x0248, B:69:0x0250, B:71:0x0256, B:72:0x0259, B:73:0x025a, B:19:0x0098, B:39:0x0174, B:41:0x018a, B:43:0x0198, B:22:0x00b8, B:31:0x0104, B:33:0x0128, B:35:0x012e, B:25:0x00bf, B:27:0x00cb, B:75:0x025d, B:76:0x0264), top: B:80:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0225 A[Catch: Exception -> 0x0265, TryCatch #0 {Exception -> 0x0265, blocks: (B:14:0x0063, B:47:0x01e7, B:49:0x01f0, B:51:0x020d, B:53:0x0215, B:55:0x021b, B:56:0x021e, B:57:0x021f, B:59:0x0225, B:61:0x022d, B:63:0x0233, B:64:0x0236, B:65:0x0237, B:67:0x0248, B:69:0x0250, B:71:0x0256, B:72:0x0259, B:73:0x025a, B:19:0x0098, B:39:0x0174, B:41:0x018a, B:43:0x0198, B:22:0x00b8, B:31:0x0104, B:33:0x0128, B:35:0x012e, B:25:0x00bf, B:27:0x00cb, B:75:0x025d, B:76:0x0264), top: B:80:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:61:0x022d A[Catch: Exception -> 0x0265, TryCatch #0 {Exception -> 0x0265, blocks: (B:14:0x0063, B:47:0x01e7, B:49:0x01f0, B:51:0x020d, B:53:0x0215, B:55:0x021b, B:56:0x021e, B:57:0x021f, B:59:0x0225, B:61:0x022d, B:63:0x0233, B:64:0x0236, B:65:0x0237, B:67:0x0248, B:69:0x0250, B:71:0x0256, B:72:0x0259, B:73:0x025a, B:19:0x0098, B:39:0x0174, B:41:0x018a, B:43:0x0198, B:22:0x00b8, B:31:0x0104, B:33:0x0128, B:35:0x012e, B:25:0x00bf, B:27:0x00cb, B:75:0x025d, B:76:0x0264), top: B:80:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:62:0x0232  */
    /* JADX WARN: Code duplicated, block: B:65:0x0237 A[Catch: Exception -> 0x0265, TryCatch #0 {Exception -> 0x0265, blocks: (B:14:0x0063, B:47:0x01e7, B:49:0x01f0, B:51:0x020d, B:53:0x0215, B:55:0x021b, B:56:0x021e, B:57:0x021f, B:59:0x0225, B:61:0x022d, B:63:0x0233, B:64:0x0236, B:65:0x0237, B:67:0x0248, B:69:0x0250, B:71:0x0256, B:72:0x0259, B:73:0x025a, B:19:0x0098, B:39:0x0174, B:41:0x018a, B:43:0x0198, B:22:0x00b8, B:31:0x0104, B:33:0x0128, B:35:0x012e, B:25:0x00bf, B:27:0x00cb, B:75:0x025d, B:76:0x0264), top: B:80:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0248 A[Catch: Exception -> 0x0265, TryCatch #0 {Exception -> 0x0265, blocks: (B:14:0x0063, B:47:0x01e7, B:49:0x01f0, B:51:0x020d, B:53:0x0215, B:55:0x021b, B:56:0x021e, B:57:0x021f, B:59:0x0225, B:61:0x022d, B:63:0x0233, B:64:0x0236, B:65:0x0237, B:67:0x0248, B:69:0x0250, B:71:0x0256, B:72:0x0259, B:73:0x025a, B:19:0x0098, B:39:0x0174, B:41:0x018a, B:43:0x0198, B:22:0x00b8, B:31:0x0104, B:33:0x0128, B:35:0x012e, B:25:0x00bf, B:27:0x00cb, B:75:0x025d, B:76:0x0264), top: B:80:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0250 A[Catch: Exception -> 0x0265, TryCatch #0 {Exception -> 0x0265, blocks: (B:14:0x0063, B:47:0x01e7, B:49:0x01f0, B:51:0x020d, B:53:0x0215, B:55:0x021b, B:56:0x021e, B:57:0x021f, B:59:0x0225, B:61:0x022d, B:63:0x0233, B:64:0x0236, B:65:0x0237, B:67:0x0248, B:69:0x0250, B:71:0x0256, B:72:0x0259, B:73:0x025a, B:19:0x0098, B:39:0x0174, B:41:0x018a, B:43:0x0198, B:22:0x00b8, B:31:0x0104, B:33:0x0128, B:35:0x012e, B:25:0x00bf, B:27:0x00cb, B:75:0x025d, B:76:0x0264), top: B:80:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0255  */
    /* JADX WARN: Code duplicated, block: B:73:0x025a A[Catch: Exception -> 0x0265, TryCatch #0 {Exception -> 0x0265, blocks: (B:14:0x0063, B:47:0x01e7, B:49:0x01f0, B:51:0x020d, B:53:0x0215, B:55:0x021b, B:56:0x021e, B:57:0x021f, B:59:0x0225, B:61:0x022d, B:63:0x0233, B:64:0x0236, B:65:0x0237, B:67:0x0248, B:69:0x0250, B:71:0x0256, B:72:0x0259, B:73:0x025a, B:19:0x0098, B:39:0x0174, B:41:0x018a, B:43:0x0198, B:22:0x00b8, B:31:0x0104, B:33:0x0128, B:35:0x012e, B:25:0x00bf, B:27:0x00cb, B:75:0x025d, B:76:0x0264), top: B:80:0x002b }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    public final Object a(Context context, SignerOptions signerOptions, byte[] bArr, byte[] bArr2, HashAlgorithm hashAlgorithm, Continuation<? super Response> continuation) {
        b bVar;
        byte[] bArr3;
        Context context2;
        List list;
        HashAlgorithm hashAlgorithm2;
        SignerOptions signerOptions2;
        List<X509Certificate> list2;
        byte[] bArr4;
        DataProviderShim dataProviderShim;
        List<X509Certificate> list3;
        byte[] bArr5;
        NativeDigitalSignatureCreator nativeDigitalSignatureCreator;
        byte[] bArr6;
        HashAlgorithm hashAlgorithm3;
        SignerOptions signerOptions3;
        NativeDigitalSignatureMetadata nativeDigitalSignatureMetadata;
        Deferred deferred;
        NativeFormField nativeFormField;
        TimestampData timestampData;
        List list4;
        NativeFormField nativeFormField2;
        Context context3;
        byte[] bArr7;
        DataProviderShim dataProviderShim2;
        SignerOptions signerOptions4;
        NativeDigitalSignatureCreator nativeDigitalSignatureCreator2;
        NativeDigitalSignatureType type;
        ArrayList arrayList;
        byte[] bArr8;
        ArrayList arrayList2;
        HashAlgorithm hashAlgorithm4;
        byte[] bArr9;
        DataProviderShim dataProviderShim3;
        NativeDigitalSignatureType nativeDigitalSignatureType;
        NativeDigitalSignatureBinaryResult nativeDigitalSignatureBinaryResultCreateSignature;
        byte[] value;
        NativeDigitalSignatureResult nativeDigitalSignatureResultFinishSignature;
        NativeDigitalSignatureCreationError error;
        String errorMessage;
        NativeDigitalSignatureCreationError error2;
        String errorMessage2;
        NativeDigitalSignatureCreationError error3;
        String errorMessage3;
        if (continuation instanceof b) {
            bVar = (b) continuation;
            int i = bVar.s;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.s = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(continuation);
            }
        } else {
            bVar = new b(continuation);
        }
        Object objAwait = bVar.q;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bVar.s;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objAwait);
                if (ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
                    List<X509Certificate> listA = s20.a(signerOptions, "embedSignature");
                    List listA2 = j20.a(listA);
                    bVar.a = context;
                    bVar.b = signerOptions;
                    bArr3 = bArr;
                    bVar.c = bArr3;
                    bVar.d = bArr2;
                    bVar.e = hashAlgorithm;
                    bVar.f = SpillingKt.nullOutSpilledVariable(listA);
                    bVar.g = listA2;
                    bVar.s = 1;
                    Object objA = xq.a(context, signerOptions, listA2, bVar);
                    if (objA != coroutine_suspended) {
                        context2 = context;
                        list = listA2;
                        hashAlgorithm2 = hashAlgorithm;
                        signerOptions2 = signerOptions;
                        list2 = listA;
                        objAwait = objA;
                        bArr4 = bArr2;
                    }
                    return coroutine_suspended;
                }
                throw new InvalidNutrientLicenseException("Signing form fields requires digital signature feature in your license!");
            }
            if (i2 == 1) {
                list = (List) bVar.g;
                list2 = (List) bVar.f;
                hashAlgorithm2 = bVar.e;
                bArr4 = (byte[]) bVar.d;
                bArr3 = (byte[]) bVar.c;
                signerOptions2 = (SignerOptions) bVar.b;
                context2 = (Context) bVar.a;
                ResultKt.throwOnFailure(objAwait);
            } else {
                if (i2 == 2) {
                    nativeFormField2 = bVar.k;
                    dataProviderShim2 = bVar.j;
                    nativeDigitalSignatureCreator2 = bVar.i;
                    nativeDigitalSignatureMetadata = (NativeDigitalSignatureMetadata) bVar.h;
                    list4 = (List) bVar.g;
                    list3 = (List) bVar.f;
                    hashAlgorithm3 = bVar.e;
                    bArr7 = (byte[]) bVar.d;
                    bArr6 = (byte[]) bVar.c;
                    signerOptions4 = (SignerOptions) bVar.b;
                    context3 = (Context) bVar.a;
                    ResultKt.throwOnFailure(objAwait);
                    deferred = (Deferred) objAwait;
                    nativeFormField = nativeFormField2;
                    list = list4;
                    nativeDigitalSignatureCreator = nativeDigitalSignatureCreator2;
                    signerOptions3 = signerOptions4;
                    dataProviderShim = dataProviderShim2;
                    bArr5 = bArr7;
                    context2 = context3;
                    type = nativeDigitalSignatureMetadata.getType();
                    list.getClass();
                    arrayList = new ArrayList(list);
                    if (deferred != null) {
                        bVar.a = SpillingKt.nullOutSpilledVariable(context2);
                        bVar.b = SpillingKt.nullOutSpilledVariable(signerOptions3);
                        bVar.c = SpillingKt.nullOutSpilledVariable(bArr6);
                        bVar.d = SpillingKt.nullOutSpilledVariable(bArr5);
                        bVar.e = hashAlgorithm3;
                        bVar.f = SpillingKt.nullOutSpilledVariable(list3);
                        bVar.g = SpillingKt.nullOutSpilledVariable(list);
                        bVar.h = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureMetadata);
                        bVar.i = nativeDigitalSignatureCreator;
                        bVar.j = dataProviderShim;
                        bVar.k = nativeFormField;
                        bVar.l = SpillingKt.nullOutSpilledVariable(deferred);
                        bVar.m = type;
                        bVar.n = bArr6;
                        bVar.o = bArr5;
                        bVar.p = arrayList;
                        bVar.s = 3;
                        objAwait = deferred.await(bVar);
                        if (objAwait != coroutine_suspended) {
                            arrayList2 = arrayList;
                            hashAlgorithm4 = hashAlgorithm3;
                            bArr9 = bArr6;
                            dataProviderShim3 = dataProviderShim;
                            nativeDigitalSignatureType = type;
                        }
                        return coroutine_suspended;
                    }
                    bArr8 = null;
                    NativeDigitalSignatureType nativeDigitalSignatureType2 = type;
                    nativeDigitalSignatureBinaryResultCreateSignature = NativePKCS7Creator.createSignature(nativeDigitalSignatureType2, bArr6, bArr5, arrayList, bArr8, mr.a(hashAlgorithm3));
                    nativeDigitalSignatureBinaryResultCreateSignature.getClass();
                    if (nativeDigitalSignatureBinaryResultCreateSignature.getHasError()) {
                        error3 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                        if (error3 != null) {
                            errorMessage3 = error3.getErrorMessage();
                        } else {
                            errorMessage3 = null;
                        }
                        throw new RuntimeException(errorMessage3);
                    }
                    value = nativeDigitalSignatureBinaryResultCreateSignature.getValue();
                    if (value == null) {
                        error2 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                        if (error2 != null) {
                            errorMessage2 = error2.getErrorMessage();
                        } else {
                            errorMessage2 = null;
                        }
                        throw new RuntimeException(errorMessage2);
                    }
                    nativeDigitalSignatureResultFinishSignature = nativeDigitalSignatureCreator.finishSignature(nativeFormField.getFQN(), value, dataProviderShim);
                    nativeDigitalSignatureResultFinishSignature.getClass();
                    if (nativeDigitalSignatureResultFinishSignature.getHasError()) {
                        return Response.SuccessEmpty.INSTANCE;
                    }
                    error = nativeDigitalSignatureResultFinishSignature.getError();
                    if (error != null) {
                        errorMessage = error.getErrorMessage();
                    } else {
                        errorMessage = null;
                    }
                    throw new RuntimeException(errorMessage);
                }
                if (i2 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                arrayList2 = bVar.p;
                bArr5 = bVar.o;
                bArr9 = bVar.n;
                nativeDigitalSignatureType = bVar.m;
                nativeFormField = bVar.k;
                dataProviderShim3 = bVar.j;
                nativeDigitalSignatureCreator = bVar.i;
                hashAlgorithm4 = bVar.e;
                ResultKt.throwOnFailure(objAwait);
            }
            bArr8 = (byte[]) objAwait;
            arrayList = arrayList2;
            bArr6 = bArr9;
            type = nativeDigitalSignatureType;
            dataProviderShim = dataProviderShim3;
            hashAlgorithm3 = hashAlgorithm4;
            NativeDigitalSignatureType nativeDigitalSignatureType3 = type;
            nativeDigitalSignatureBinaryResultCreateSignature = NativePKCS7Creator.createSignature(nativeDigitalSignatureType3, bArr6, bArr5, arrayList, bArr8, mr.a(hashAlgorithm3));
            nativeDigitalSignatureBinaryResultCreateSignature.getClass();
            if (nativeDigitalSignatureBinaryResultCreateSignature.getHasError()) {
                error3 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                if (error3 != null) {
                    errorMessage3 = error3.getErrorMessage();
                } else {
                    errorMessage3 = null;
                }
                throw new RuntimeException(errorMessage3);
            }
            value = nativeDigitalSignatureBinaryResultCreateSignature.getValue();
            if (value == null) {
                error2 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                if (error2 != null) {
                    errorMessage2 = error2.getErrorMessage();
                } else {
                    errorMessage2 = null;
                }
                throw new RuntimeException(errorMessage2);
            }
            nativeDigitalSignatureResultFinishSignature = nativeDigitalSignatureCreator.finishSignature(nativeFormField.getFQN(), value, dataProviderShim);
            nativeDigitalSignatureResultFinishSignature.getClass();
            if (nativeDigitalSignatureResultFinishSignature.getHasError()) {
                return Response.SuccessEmpty.INSTANCE;
            }
            error = nativeDigitalSignatureResultFinishSignature.getError();
            if (error != null) {
                errorMessage = error.getErrorMessage();
            } else {
                errorMessage = null;
            }
            throw new RuntimeException(errorMessage);
            NativeDigitalSignatureMetadata nativeDigitalSignatureMetadata2 = (NativeDigitalSignatureMetadata) objAwait;
            NativeDigitalSignatureCreator nativeDigitalSignatureCreatorA = a(list, nativeDigitalSignatureMetadata2);
            dataProviderShim = new DataProviderShim(signerOptions2.getOutputDataProvider());
            NativeFormField nativeFormField3 = signerOptions2.getSignatureFormField().getInternal().getNativeFormField();
            nativeFormField3.getClass();
            DigitalSignatureMetadata metadata = signerOptions2.getMetadata();
            if (metadata != null && (timestampData = metadata.getTimestampData()) != null) {
                bVar.a = SpillingKt.nullOutSpilledVariable(context2);
                bVar.b = SpillingKt.nullOutSpilledVariable(signerOptions2);
                bVar.c = bArr3;
                bVar.d = bArr4;
                bVar.e = hashAlgorithm2;
                bVar.f = SpillingKt.nullOutSpilledVariable(list2);
                bVar.g = list;
                bVar.h = nativeDigitalSignatureMetadata2;
                bVar.i = nativeDigitalSignatureCreatorA;
                bVar.j = dataProviderShim;
                bVar.k = nativeFormField3;
                bVar.l = SpillingKt.nullOutSpilledVariable(timestampData);
                bVar.s = 2;
                Object objCoroutineScope = CoroutineScopeKt.coroutineScope(new q20(timestampData, bArr3, context2, null), bVar);
                if (objCoroutineScope != coroutine_suspended) {
                    byte[] bArr10 = bArr4;
                    list4 = list;
                    nativeFormField2 = nativeFormField3;
                    context3 = context2;
                    bArr7 = bArr10;
                    byte[] bArr11 = bArr3;
                    list3 = list2;
                    dataProviderShim2 = dataProviderShim;
                    signerOptions4 = signerOptions2;
                    hashAlgorithm3 = hashAlgorithm2;
                    nativeDigitalSignatureCreator2 = nativeDigitalSignatureCreatorA;
                    bArr6 = bArr11;
                    nativeDigitalSignatureMetadata = nativeDigitalSignatureMetadata2;
                    objAwait = objCoroutineScope;
                    deferred = (Deferred) objAwait;
                    nativeFormField = nativeFormField2;
                    list = list4;
                    nativeDigitalSignatureCreator = nativeDigitalSignatureCreator2;
                    signerOptions3 = signerOptions4;
                    dataProviderShim = dataProviderShim2;
                    bArr5 = bArr7;
                    context2 = context3;
                    type = nativeDigitalSignatureMetadata.getType();
                    list.getClass();
                    arrayList = new ArrayList(list);
                    if (deferred != null) {
                        bVar.a = SpillingKt.nullOutSpilledVariable(context2);
                        bVar.b = SpillingKt.nullOutSpilledVariable(signerOptions3);
                        bVar.c = SpillingKt.nullOutSpilledVariable(bArr6);
                        bVar.d = SpillingKt.nullOutSpilledVariable(bArr5);
                        bVar.e = hashAlgorithm3;
                        bVar.f = SpillingKt.nullOutSpilledVariable(list3);
                        bVar.g = SpillingKt.nullOutSpilledVariable(list);
                        bVar.h = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureMetadata);
                        bVar.i = nativeDigitalSignatureCreator;
                        bVar.j = dataProviderShim;
                        bVar.k = nativeFormField;
                        bVar.l = SpillingKt.nullOutSpilledVariable(deferred);
                        bVar.m = type;
                        bVar.n = bArr6;
                        bVar.o = bArr5;
                        bVar.p = arrayList;
                        bVar.s = 3;
                        objAwait = deferred.await(bVar);
                        if (objAwait != coroutine_suspended) {
                            arrayList2 = arrayList;
                            hashAlgorithm4 = hashAlgorithm3;
                            bArr9 = bArr6;
                            dataProviderShim3 = dataProviderShim;
                            nativeDigitalSignatureType = type;
                            bArr8 = (byte[]) objAwait;
                            arrayList = arrayList2;
                            bArr6 = bArr9;
                            type = nativeDigitalSignatureType;
                            dataProviderShim = dataProviderShim3;
                            hashAlgorithm3 = hashAlgorithm4;
                        }
                    } else {
                        bArr8 = null;
                    }
                    NativeDigitalSignatureType nativeDigitalSignatureType4 = type;
                    nativeDigitalSignatureBinaryResultCreateSignature = NativePKCS7Creator.createSignature(nativeDigitalSignatureType4, bArr6, bArr5, arrayList, bArr8, mr.a(hashAlgorithm3));
                    nativeDigitalSignatureBinaryResultCreateSignature.getClass();
                    if (nativeDigitalSignatureBinaryResultCreateSignature.getHasError()) {
                        error3 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                        if (error3 != null) {
                            errorMessage3 = error3.getErrorMessage();
                        } else {
                            errorMessage3 = null;
                        }
                        throw new RuntimeException(errorMessage3);
                    }
                    value = nativeDigitalSignatureBinaryResultCreateSignature.getValue();
                    if (value == null) {
                        error2 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                        if (error2 != null) {
                            errorMessage2 = error2.getErrorMessage();
                        } else {
                            errorMessage2 = null;
                        }
                        throw new RuntimeException(errorMessage2);
                    }
                    nativeDigitalSignatureResultFinishSignature = nativeDigitalSignatureCreator.finishSignature(nativeFormField.getFQN(), value, dataProviderShim);
                    nativeDigitalSignatureResultFinishSignature.getClass();
                    if (nativeDigitalSignatureResultFinishSignature.getHasError()) {
                        return Response.SuccessEmpty.INSTANCE;
                    }
                    error = nativeDigitalSignatureResultFinishSignature.getError();
                    if (error != null) {
                        errorMessage = error.getErrorMessage();
                    } else {
                        errorMessage = null;
                    }
                    throw new RuntimeException(errorMessage);
                }
            } else {
                byte[] bArr12 = bArr3;
                list3 = list2;
                bArr5 = bArr4;
                nativeDigitalSignatureCreator = nativeDigitalSignatureCreatorA;
                bArr6 = bArr12;
                SignerOptions signerOptions5 = signerOptions2;
                hashAlgorithm3 = hashAlgorithm2;
                signerOptions3 = signerOptions5;
                nativeDigitalSignatureMetadata = nativeDigitalSignatureMetadata2;
                deferred = null;
                nativeFormField = nativeFormField3;
                type = nativeDigitalSignatureMetadata.getType();
                list.getClass();
                arrayList = new ArrayList(list);
                if (deferred != null) {
                    bVar.a = SpillingKt.nullOutSpilledVariable(context2);
                    bVar.b = SpillingKt.nullOutSpilledVariable(signerOptions3);
                    bVar.c = SpillingKt.nullOutSpilledVariable(bArr6);
                    bVar.d = SpillingKt.nullOutSpilledVariable(bArr5);
                    bVar.e = hashAlgorithm3;
                    bVar.f = SpillingKt.nullOutSpilledVariable(list3);
                    bVar.g = SpillingKt.nullOutSpilledVariable(list);
                    bVar.h = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureMetadata);
                    bVar.i = nativeDigitalSignatureCreator;
                    bVar.j = dataProviderShim;
                    bVar.k = nativeFormField;
                    bVar.l = SpillingKt.nullOutSpilledVariable(deferred);
                    bVar.m = type;
                    bVar.n = bArr6;
                    bVar.o = bArr5;
                    bVar.p = arrayList;
                    bVar.s = 3;
                    objAwait = deferred.await(bVar);
                    if (objAwait != coroutine_suspended) {
                        arrayList2 = arrayList;
                        hashAlgorithm4 = hashAlgorithm3;
                        bArr9 = bArr6;
                        dataProviderShim3 = dataProviderShim;
                        nativeDigitalSignatureType = type;
                        bArr8 = (byte[]) objAwait;
                        arrayList = arrayList2;
                        bArr6 = bArr9;
                        type = nativeDigitalSignatureType;
                        dataProviderShim = dataProviderShim3;
                        hashAlgorithm3 = hashAlgorithm4;
                    }
                } else {
                    bArr8 = null;
                }
                NativeDigitalSignatureType nativeDigitalSignatureType5 = type;
                nativeDigitalSignatureBinaryResultCreateSignature = NativePKCS7Creator.createSignature(nativeDigitalSignatureType5, bArr6, bArr5, arrayList, bArr8, mr.a(hashAlgorithm3));
                nativeDigitalSignatureBinaryResultCreateSignature.getClass();
                if (nativeDigitalSignatureBinaryResultCreateSignature.getHasError()) {
                    error3 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                    if (error3 != null) {
                        errorMessage3 = error3.getErrorMessage();
                    } else {
                        errorMessage3 = null;
                    }
                    throw new RuntimeException(errorMessage3);
                }
                value = nativeDigitalSignatureBinaryResultCreateSignature.getValue();
                if (value == null) {
                    error2 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                    if (error2 != null) {
                        errorMessage2 = error2.getErrorMessage();
                    } else {
                        errorMessage2 = null;
                    }
                    throw new RuntimeException(errorMessage2);
                }
                nativeDigitalSignatureResultFinishSignature = nativeDigitalSignatureCreator.finishSignature(nativeFormField.getFQN(), value, dataProviderShim);
                nativeDigitalSignatureResultFinishSignature.getClass();
                if (nativeDigitalSignatureResultFinishSignature.getHasError()) {
                    return Response.SuccessEmpty.INSTANCE;
                }
                error = nativeDigitalSignatureResultFinishSignature.getError();
                if (error != null) {
                    errorMessage = error.getErrorMessage();
                } else {
                    errorMessage = null;
                }
                throw new RuntimeException(errorMessage);
            }
            return coroutine_suspended;
        } catch (Exception e2) {
            return new Response.Error(e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Context context, SignerOptions signerOptions, byte[] bArr, Continuation<? super Response> continuation) {
        a aVar;
        List list;
        KeyStore.PrivateKeyEntry privateKeyEntry;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i = aVar.h;
            if ((i & Integer.MIN_VALUE) != 0) {
                aVar.h = i - Integer.MIN_VALUE;
            } else {
                aVar = new a(continuation);
            }
        } else {
            aVar = new a(continuation);
        }
        Object objA = aVar.f;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = aVar.h;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objA);
                if (ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
                    List<X509Certificate> certificates = signerOptions.getCertificates();
                    if (certificates.isEmpty() && ((privateKeyEntry = signerOptions.getPrivateKeyEntry()) == null || (certificates = KeyFileHelpersKt.getX509Certificates(privateKeyEntry)) == null)) {
                        certificates = CollectionsKt.emptyList();
                    }
                    List listA = j20.a(certificates);
                    aVar.a = SpillingKt.nullOutSpilledVariable(context);
                    aVar.b = signerOptions;
                    aVar.c = bArr;
                    aVar.d = SpillingKt.nullOutSpilledVariable(certificates);
                    aVar.e = listA;
                    aVar.h = 1;
                    objA = xq.a(context, signerOptions, listA, aVar);
                    if (objA == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    list = listA;
                } else {
                    throw new InvalidNutrientLicenseException("Signing form fields requires digital signature feature in your license!");
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                list = aVar.e;
                bArr = aVar.c;
                signerOptions = aVar.b;
                ResultKt.throwOnFailure(objA);
            }
            NativeDigitalSignatureCreator nativeDigitalSignatureCreatorA = a(list, (NativeDigitalSignatureMetadata) objA);
            DataProviderShim dataProviderShim = new DataProviderShim(signerOptions.getOutputDataProvider());
            NativeFormField nativeFormField = signerOptions.getSignatureFormField().getInternal().getNativeFormField();
            nativeFormField.getClass();
            NativeDigitalSignatureResult nativeDigitalSignatureResultFinishSignature = nativeDigitalSignatureCreatorA.finishSignature(nativeFormField.getFQN(), bArr, dataProviderShim);
            nativeDigitalSignatureResultFinishSignature.getClass();
            if (!nativeDigitalSignatureResultFinishSignature.getHasError()) {
                return Response.SuccessEmpty.INSTANCE;
            }
            NativeDigitalSignatureCreationError error = nativeDigitalSignatureResultFinishSignature.getError();
            throw new RuntimeException(error != null ? error.getErrorMessage() : null);
        } catch (Exception e2) {
            return new Response.Error(e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Context context, SigningConfiguration signingConfiguration, byte[] bArr, HashAlgorithm hashAlgorithm, Continuation<? super Response<byte[]>> continuation) {
        d dVar;
        if (continuation instanceof d) {
            dVar = (d) continuation;
            int i = dVar.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                dVar.i = i - Integer.MIN_VALUE;
            } else {
                dVar = new d(continuation);
            }
        } else {
            dVar = new d(continuation);
        }
        d dVar2 = dVar;
        Object objA = dVar2.g;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = dVar2.i;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(objA);
                if (ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
                    List<X509Certificate> certificates = signingConfiguration.getCertificates();
                    List listA = j20.a(certificates);
                    DigitalSignatureType digitalSignatureType = DigitalSignatureType.BASIC;
                    dVar2.a = SpillingKt.nullOutSpilledVariable(context);
                    dVar2.b = SpillingKt.nullOutSpilledVariable(signingConfiguration);
                    dVar2.c = SpillingKt.nullOutSpilledVariable(bArr);
                    dVar2.d = SpillingKt.nullOutSpilledVariable(hashAlgorithm);
                    dVar2.e = SpillingKt.nullOutSpilledVariable(certificates);
                    dVar2.f = SpillingKt.nullOutSpilledVariable(listA);
                    dVar2.i = 1;
                    objA = a(context, digitalSignatureType, signingConfiguration, bArr, listA, hashAlgorithm, dVar2);
                    if (objA == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    throw new InvalidNutrientLicenseException("Signing form fields requires digital signature feature in your license!");
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objA);
            }
            return new Response.Success((byte[]) objA);
        } catch (Exception e2) {
            return new Response.Error(e2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Function3 function3, byte[] bArr, PrivateKey privateKey, String str, ContinuationImpl continuationImpl) {
        o20 o20Var;
        if (continuationImpl instanceof o20) {
            o20Var = (o20) continuationImpl;
            int i = o20Var.g;
            if ((i & Integer.MIN_VALUE) != 0) {
                o20Var.g = i - Integer.MIN_VALUE;
            } else {
                o20Var = new o20(this, continuationImpl);
            }
        } else {
            o20Var = new o20(this, continuationImpl);
        }
        Object objCoroutineScope = o20Var.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = o20Var.g;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objCoroutineScope);
            p20 p20Var = new p20(function3, privateKey, str, bArr, null);
            o20Var.a = SpillingKt.nullOutSpilledVariable(function3);
            o20Var.b = SpillingKt.nullOutSpilledVariable(bArr);
            o20Var.c = SpillingKt.nullOutSpilledVariable(privateKey);
            o20Var.d = SpillingKt.nullOutSpilledVariable(str);
            o20Var.g = 1;
            objCoroutineScope = CoroutineScopeKt.coroutineScope(p20Var, o20Var);
            if (objCoroutineScope == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objCoroutineScope);
        }
        objCoroutineScope.getClass();
        return objCoroutineScope;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0137 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0139  */
    /* JADX WARN: Code duplicated, block: B:36:0x013c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0142  */
    /* JADX WARN: Code duplicated, block: B:41:0x014e  */
    /* JADX WARN: Code duplicated, block: B:44:0x018b  */
    /* JADX WARN: Code duplicated, block: B:46:0x0190  */
    /* JADX WARN: Code duplicated, block: B:49:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:51:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:54:0x01be  */
    /* JADX WARN: Code duplicated, block: B:56:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:58:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:61:0x01d4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    public final Object a(Context context, DigitalSignatureType digitalSignatureType, SigningConfiguration signingConfiguration, byte[] bArr, List list, HashAlgorithm hashAlgorithm, ContinuationImpl continuationImpl) {
        n20 n20Var;
        m20 m20Var;
        SigningConfiguration signingConfiguration2;
        List list2;
        HashAlgorithm hashAlgorithm2;
        byte[] bArr2;
        DigitalSignatureType digitalSignatureType2;
        Context context2;
        byte[] bArr3;
        byte[] bArr4;
        byte[] bArr5;
        Deferred deferred;
        HashAlgorithm hashAlgorithm3;
        TimestampData timestampData;
        DigitalSignatureType digitalSignatureType3;
        SigningConfiguration signingConfiguration3;
        Context context3;
        byte[] bArr6;
        List list3;
        HashAlgorithm hashAlgorithm4;
        int i;
        NativeDigitalSignatureType nativeDigitalSignatureType;
        ArrayList arrayList;
        byte[] bArr7;
        ArrayList arrayList2;
        NativeDigitalSignatureBinaryResult nativeDigitalSignatureBinaryResultCreateSignature;
        byte[] value;
        if (continuationImpl instanceof n20) {
            n20Var = (n20) continuationImpl;
            int i2 = n20Var.o;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                n20Var.o = i2 - Integer.MIN_VALUE;
                m20Var = this;
            } else {
                m20Var = this;
                n20Var = new n20(m20Var, continuationImpl);
            }
        } else {
            m20Var = this;
            n20Var = new n20(m20Var, continuationImpl);
        }
        n20 n20Var2 = n20Var;
        Object objCoroutineScope = n20Var2.m;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = n20Var2.o;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objCoroutineScope);
            PrivateKey privateKey = signingConfiguration.getPrivateKey();
            String strName = hashAlgorithm.name();
            n20Var2.a = context;
            n20Var2.b = digitalSignatureType;
            signingConfiguration2 = signingConfiguration;
            n20Var2.c = signingConfiguration2;
            n20Var2.d = bArr;
            list2 = list;
            n20Var2.e = list2;
            hashAlgorithm2 = hashAlgorithm;
            n20Var2.f = hashAlgorithm2;
            n20Var2.o = 1;
            Object objA = m20Var.a((Function3) null, bArr, privateKey, strName, n20Var2);
            if (objA != coroutine_suspended) {
                bArr2 = bArr;
                digitalSignatureType2 = digitalSignatureType;
                context2 = context;
                objCoroutineScope = objA;
            }
            return coroutine_suspended;
        }
        if (i3 == 1) {
            HashAlgorithm hashAlgorithm5 = n20Var2.f;
            List list4 = (List) n20Var2.e;
            bArr2 = (byte[]) n20Var2.d;
            SigningConfiguration signingConfiguration4 = (SigningConfiguration) n20Var2.c;
            digitalSignatureType2 = (DigitalSignatureType) n20Var2.b;
            context2 = (Context) n20Var2.a;
            ResultKt.throwOnFailure(objCoroutineScope);
            hashAlgorithm2 = hashAlgorithm5;
            list2 = list4;
            signingConfiguration2 = signingConfiguration4;
        } else {
            if (i3 == 2) {
                bArr3 = (byte[]) n20Var2.g;
                hashAlgorithm4 = n20Var2.f;
                list3 = (List) n20Var2.e;
                bArr6 = (byte[]) n20Var2.d;
                signingConfiguration3 = (SigningConfiguration) n20Var2.c;
                digitalSignatureType3 = (DigitalSignatureType) n20Var2.b;
                context3 = (Context) n20Var2.a;
                ResultKt.throwOnFailure(objCoroutineScope);
                deferred = (Deferred) objCoroutineScope;
                HashAlgorithm hashAlgorithm6 = hashAlgorithm4;
                bArr4 = bArr3;
                bArr5 = bArr6;
                hashAlgorithm3 = hashAlgorithm6;
                Context context4 = context3;
                signingConfiguration2 = signingConfiguration3;
                digitalSignatureType2 = digitalSignatureType3;
                context2 = context4;
                list2 = list3;
                digitalSignatureType2.getClass();
                i = j20.a.a[digitalSignatureType2.ordinal()];
                if (i == 1) {
                    nativeDigitalSignatureType = NativeDigitalSignatureType.CADES;
                } else if (i == 2) {
                    nativeDigitalSignatureType = NativeDigitalSignatureType.BASIC;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                list2.getClass();
                arrayList = new ArrayList(list2);
                if (deferred != null) {
                    n20Var2.a = SpillingKt.nullOutSpilledVariable(context2);
                    n20Var2.b = SpillingKt.nullOutSpilledVariable(digitalSignatureType2);
                    n20Var2.c = SpillingKt.nullOutSpilledVariable(signingConfiguration2);
                    n20Var2.d = SpillingKt.nullOutSpilledVariable(bArr5);
                    n20Var2.e = SpillingKt.nullOutSpilledVariable(list2);
                    n20Var2.f = hashAlgorithm3;
                    n20Var2.g = SpillingKt.nullOutSpilledVariable(bArr4);
                    n20Var2.h = SpillingKt.nullOutSpilledVariable(deferred);
                    n20Var2.i = nativeDigitalSignatureType;
                    n20Var2.j = bArr4;
                    n20Var2.k = bArr5;
                    n20Var2.l = arrayList;
                    n20Var2.o = 3;
                    objCoroutineScope = deferred.await(n20Var2);
                    if (objCoroutineScope != coroutine_suspended) {
                        arrayList2 = arrayList;
                    }
                    return coroutine_suspended;
                }
                bArr7 = null;
                nativeDigitalSignatureBinaryResultCreateSignature = NativePKCS7Creator.createSignature(nativeDigitalSignatureType, bArr4, bArr5, arrayList, bArr7, mr.a(hashAlgorithm3));
                nativeDigitalSignatureBinaryResultCreateSignature.getClass();
                if (nativeDigitalSignatureBinaryResultCreateSignature.getHasError()) {
                    NativeDigitalSignatureCreationError error = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                    throw new RuntimeException(error != null ? error.getErrorMessage() : null);
                }
                value = nativeDigitalSignatureBinaryResultCreateSignature.getValue();
                if (value == null) {
                    return value;
                }
                NativeDigitalSignatureCreationError error2 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                throw new RuntimeException(error2 != null ? error2.getErrorMessage() : null);
            }
            if (i3 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            arrayList2 = n20Var2.l;
            bArr5 = n20Var2.k;
            bArr4 = n20Var2.j;
            nativeDigitalSignatureType = n20Var2.i;
            hashAlgorithm3 = n20Var2.f;
            ResultKt.throwOnFailure(objCoroutineScope);
        }
        bArr7 = (byte[]) objCoroutineScope;
        arrayList = arrayList2;
        nativeDigitalSignatureBinaryResultCreateSignature = NativePKCS7Creator.createSignature(nativeDigitalSignatureType, bArr4, bArr5, arrayList, bArr7, mr.a(hashAlgorithm3));
        nativeDigitalSignatureBinaryResultCreateSignature.getClass();
        if (nativeDigitalSignatureBinaryResultCreateSignature.getHasError()) {
            NativeDigitalSignatureCreationError error3 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
            throw new RuntimeException(error3 != null ? error3.getErrorMessage() : null);
        }
        value = nativeDigitalSignatureBinaryResultCreateSignature.getValue();
        if (value == null) {
            return value;
        }
        NativeDigitalSignatureCreationError error4 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
        throw new RuntimeException(error4 != null ? error4.getErrorMessage() : null);
        bArr3 = (byte[]) objCoroutineScope;
        DigitalSignatureMetadata metadata = signingConfiguration2.getMetadata();
        if (metadata != null && (timestampData = metadata.getTimestampData()) != null) {
            n20Var2.a = SpillingKt.nullOutSpilledVariable(context2);
            n20Var2.b = digitalSignatureType2;
            n20Var2.c = SpillingKt.nullOutSpilledVariable(signingConfiguration2);
            n20Var2.d = bArr2;
            n20Var2.e = list2;
            n20Var2.f = hashAlgorithm2;
            n20Var2.g = bArr3;
            n20Var2.h = SpillingKt.nullOutSpilledVariable(timestampData);
            n20Var2.o = 2;
            objCoroutineScope = CoroutineScopeKt.coroutineScope(new q20(timestampData, bArr3, context2, null), n20Var2);
            if (objCoroutineScope != coroutine_suspended) {
                Context context5 = context2;
                digitalSignatureType3 = digitalSignatureType2;
                signingConfiguration3 = signingConfiguration2;
                context3 = context5;
                bArr6 = bArr2;
                list3 = list2;
                hashAlgorithm4 = hashAlgorithm2;
                deferred = (Deferred) objCoroutineScope;
                HashAlgorithm hashAlgorithm7 = hashAlgorithm4;
                bArr4 = bArr3;
                bArr5 = bArr6;
                hashAlgorithm3 = hashAlgorithm7;
                Context context6 = context3;
                signingConfiguration2 = signingConfiguration3;
                digitalSignatureType2 = digitalSignatureType3;
                context2 = context6;
                list2 = list3;
                digitalSignatureType2.getClass();
                i = j20.a.a[digitalSignatureType2.ordinal()];
                if (i == 1) {
                    nativeDigitalSignatureType = NativeDigitalSignatureType.CADES;
                } else if (i == 2) {
                    nativeDigitalSignatureType = NativeDigitalSignatureType.BASIC;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                list2.getClass();
                arrayList = new ArrayList(list2);
                if (deferred != null) {
                    n20Var2.a = SpillingKt.nullOutSpilledVariable(context2);
                    n20Var2.b = SpillingKt.nullOutSpilledVariable(digitalSignatureType2);
                    n20Var2.c = SpillingKt.nullOutSpilledVariable(signingConfiguration2);
                    n20Var2.d = SpillingKt.nullOutSpilledVariable(bArr5);
                    n20Var2.e = SpillingKt.nullOutSpilledVariable(list2);
                    n20Var2.f = hashAlgorithm3;
                    n20Var2.g = SpillingKt.nullOutSpilledVariable(bArr4);
                    n20Var2.h = SpillingKt.nullOutSpilledVariable(deferred);
                    n20Var2.i = nativeDigitalSignatureType;
                    n20Var2.j = bArr4;
                    n20Var2.k = bArr5;
                    n20Var2.l = arrayList;
                    n20Var2.o = 3;
                    objCoroutineScope = deferred.await(n20Var2);
                    if (objCoroutineScope != coroutine_suspended) {
                        arrayList2 = arrayList;
                        bArr7 = (byte[]) objCoroutineScope;
                        arrayList = arrayList2;
                    }
                } else {
                    bArr7 = null;
                }
                nativeDigitalSignatureBinaryResultCreateSignature = NativePKCS7Creator.createSignature(nativeDigitalSignatureType, bArr4, bArr5, arrayList, bArr7, mr.a(hashAlgorithm3));
                nativeDigitalSignatureBinaryResultCreateSignature.getClass();
                if (nativeDigitalSignatureBinaryResultCreateSignature.getHasError()) {
                    NativeDigitalSignatureCreationError error5 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                    throw new RuntimeException(error5 != null ? error5.getErrorMessage() : null);
                }
                value = nativeDigitalSignatureBinaryResultCreateSignature.getValue();
                if (value == null) {
                    return value;
                }
                NativeDigitalSignatureCreationError error6 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                throw new RuntimeException(error6 != null ? error6.getErrorMessage() : null);
            }
        } else {
            bArr4 = bArr3;
            bArr5 = bArr2;
            deferred = null;
            hashAlgorithm3 = hashAlgorithm2;
            digitalSignatureType2.getClass();
            i = j20.a.a[digitalSignatureType2.ordinal()];
            if (i == 1) {
                nativeDigitalSignatureType = NativeDigitalSignatureType.CADES;
            } else if (i == 2) {
                nativeDigitalSignatureType = NativeDigitalSignatureType.BASIC;
            } else {
                throw new NoWhenBranchMatchedException();
            }
            list2.getClass();
            arrayList = new ArrayList(list2);
            if (deferred != null) {
                n20Var2.a = SpillingKt.nullOutSpilledVariable(context2);
                n20Var2.b = SpillingKt.nullOutSpilledVariable(digitalSignatureType2);
                n20Var2.c = SpillingKt.nullOutSpilledVariable(signingConfiguration2);
                n20Var2.d = SpillingKt.nullOutSpilledVariable(bArr5);
                n20Var2.e = SpillingKt.nullOutSpilledVariable(list2);
                n20Var2.f = hashAlgorithm3;
                n20Var2.g = SpillingKt.nullOutSpilledVariable(bArr4);
                n20Var2.h = SpillingKt.nullOutSpilledVariable(deferred);
                n20Var2.i = nativeDigitalSignatureType;
                n20Var2.j = bArr4;
                n20Var2.k = bArr5;
                n20Var2.l = arrayList;
                n20Var2.o = 3;
                objCoroutineScope = deferred.await(n20Var2);
                if (objCoroutineScope != coroutine_suspended) {
                    arrayList2 = arrayList;
                    bArr7 = (byte[]) objCoroutineScope;
                    arrayList = arrayList2;
                }
            } else {
                bArr7 = null;
            }
            nativeDigitalSignatureBinaryResultCreateSignature = NativePKCS7Creator.createSignature(nativeDigitalSignatureType, bArr4, bArr5, arrayList, bArr7, mr.a(hashAlgorithm3));
            nativeDigitalSignatureBinaryResultCreateSignature.getClass();
            if (nativeDigitalSignatureBinaryResultCreateSignature.getHasError()) {
                NativeDigitalSignatureCreationError error7 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                throw new RuntimeException(error7 != null ? error7.getErrorMessage() : null);
            }
            value = nativeDigitalSignatureBinaryResultCreateSignature.getValue();
            if (value == null) {
                return value;
            }
            NativeDigitalSignatureCreationError error8 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
            throw new RuntimeException(error8 != null ? error8.getErrorMessage() : null);
        }
        return coroutine_suspended;
    }
}
