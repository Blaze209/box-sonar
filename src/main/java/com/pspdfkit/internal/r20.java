package com.pspdfkit.internal;

import android.content.Context;
import com.facebook.common.util.UriUtil;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.internal.document.DataProviderShim;
import com.pspdfkit.internal.jni.NativeDataToSign;
import com.pspdfkit.internal.jni.NativeDataToSignResult;
import com.pspdfkit.internal.jni.NativeDigitalSignatureBinaryResult;
import com.pspdfkit.internal.jni.NativeDigitalSignatureCreationError;
import com.pspdfkit.internal.jni.NativeDigitalSignatureCreator;
import com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata;
import com.pspdfkit.internal.jni.NativeDigitalSignatureResult;
import com.pspdfkit.internal.jni.NativeDigitalSignatureType;
import com.pspdfkit.internal.jni.NativeFormField;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.jni.NativePKCS7Creator;
import com.pspdfkit.signatures.DigitalSignatureMetadata;
import com.pspdfkit.signatures.SignerOptions;
import com.pspdfkit.signatures.timestamp.TimestampData;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.signatures.SigningManagerInternal$signDocument$1", f = "SigningManagerInternal.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, l = {79, 92, 105, 114}, m = "invokeSuspend", n = {"$this$launch", "certificates", "nativeCertificates", "$this$launch", "certificates", "nativeCertificates", "metadata", "nativeDigitalSignatureCreator", "nativeDataProvider", "signatureFormField", UriUtil.LOCAL_RESOURCE_SCHEME, "nativeDataToSignResult", "unsignedData", "hashAlgorithm", "$this$launch", "certificates", "nativeCertificates", "metadata", "nativeDigitalSignatureCreator", "nativeDataProvider", "signatureFormField", UriUtil.LOCAL_RESOURCE_SCHEME, "nativeDataToSignResult", "unsignedData", "hashAlgorithm", "finalSignedData", "it", "$i$a$-let-SigningManagerInternal$signDocument$1$timestampCoroutineScope$1", "$this$launch", "certificates", "nativeCertificates", "metadata", "nativeDigitalSignatureCreator", "nativeDataProvider", "signatureFormField", UriUtil.LOCAL_RESOURCE_SCHEME, "nativeDataToSignResult", "unsignedData", "hashAlgorithm", "finalSignedData", "timestampCoroutineScope"}, nl = {80, 91, 104, 115}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12"}, v = 2)
public final class r20 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public Object a;
    public Object b;
    public Object c;
    public NativeDigitalSignatureCreator d;
    public DataProviderShim e;
    public NativeFormField f;
    public Object g;
    public Object h;
    public NativeDataToSign i;
    public Object j;
    public Object k;
    public Object l;
    public NativeDigitalSignatureType m;
    public byte[] n;
    public byte[] o;
    public ArrayList p;
    public int q;
    public /* synthetic */ Object r;
    public final /* synthetic */ SignerOptions s;
    public final /* synthetic */ Context t;
    public final /* synthetic */ Function3<byte[], String, Continuation<? super byte[]>, Object> u;
    public final /* synthetic */ Function0<Unit> v;
    public final /* synthetic */ Function1<Throwable, Unit> w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public r20(SignerOptions signerOptions, Context context, Function3<? super byte[], ? super String, ? super Continuation<? super byte[]>, ? extends Object> function3, Function0<Unit> function0, Function1<? super Throwable, Unit> function1, Continuation<? super r20> continuation) {
        super(2, continuation);
        this.s = signerOptions;
        this.t = context;
        this.u = function3;
        this.v = function0;
        this.w = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        r20 r20Var = new r20(this.s, this.t, this.u, this.v, this.w, continuation);
        r20Var.r = obj;
        return r20Var;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((r20) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0269 A[Catch: Exception -> 0x033b, TryCatch #0 {Exception -> 0x033b, blocks: (B:9:0x004b, B:74:0x02bf, B:77:0x02d2, B:79:0x02e7, B:81:0x02ef, B:83:0x02f5, B:84:0x02f8, B:85:0x02f9, B:87:0x0303, B:89:0x0306, B:91:0x0313, B:93:0x031b, B:95:0x0321, B:96:0x0324, B:97:0x0325, B:14:0x0086, B:65:0x0240, B:68:0x0253, B:70:0x0269, B:17:0x00b3, B:57:0x01e3, B:59:0x01ed, B:61:0x01f3, B:20:0x00c7, B:29:0x0105, B:31:0x0137, B:33:0x013f, B:35:0x0145, B:36:0x0148, B:37:0x0149, B:39:0x015a, B:41:0x0162, B:43:0x0168, B:44:0x016b, B:45:0x016c, B:47:0x0172, B:49:0x018f, B:51:0x0197, B:53:0x019d, B:98:0x032b, B:99:0x0332, B:23:0x00d2, B:25:0x00de, B:100:0x0333, B:101:0x033a), top: B:106:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:76:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:79:0x02e7 A[Catch: Exception -> 0x033b, TryCatch #0 {Exception -> 0x033b, blocks: (B:9:0x004b, B:74:0x02bf, B:77:0x02d2, B:79:0x02e7, B:81:0x02ef, B:83:0x02f5, B:84:0x02f8, B:85:0x02f9, B:87:0x0303, B:89:0x0306, B:91:0x0313, B:93:0x031b, B:95:0x0321, B:96:0x0324, B:97:0x0325, B:14:0x0086, B:65:0x0240, B:68:0x0253, B:70:0x0269, B:17:0x00b3, B:57:0x01e3, B:59:0x01ed, B:61:0x01f3, B:20:0x00c7, B:29:0x0105, B:31:0x0137, B:33:0x013f, B:35:0x0145, B:36:0x0148, B:37:0x0149, B:39:0x015a, B:41:0x0162, B:43:0x0168, B:44:0x016b, B:45:0x016c, B:47:0x0172, B:49:0x018f, B:51:0x0197, B:53:0x019d, B:98:0x032b, B:99:0x0332, B:23:0x00d2, B:25:0x00de, B:100:0x0333, B:101:0x033a), top: B:106:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x02ef A[Catch: Exception -> 0x033b, TryCatch #0 {Exception -> 0x033b, blocks: (B:9:0x004b, B:74:0x02bf, B:77:0x02d2, B:79:0x02e7, B:81:0x02ef, B:83:0x02f5, B:84:0x02f8, B:85:0x02f9, B:87:0x0303, B:89:0x0306, B:91:0x0313, B:93:0x031b, B:95:0x0321, B:96:0x0324, B:97:0x0325, B:14:0x0086, B:65:0x0240, B:68:0x0253, B:70:0x0269, B:17:0x00b3, B:57:0x01e3, B:59:0x01ed, B:61:0x01f3, B:20:0x00c7, B:29:0x0105, B:31:0x0137, B:33:0x013f, B:35:0x0145, B:36:0x0148, B:37:0x0149, B:39:0x015a, B:41:0x0162, B:43:0x0168, B:44:0x016b, B:45:0x016c, B:47:0x0172, B:49:0x018f, B:51:0x0197, B:53:0x019d, B:98:0x032b, B:99:0x0332, B:23:0x00d2, B:25:0x00de, B:100:0x0333, B:101:0x033a), top: B:106:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:85:0x02f9 A[Catch: Exception -> 0x033b, TryCatch #0 {Exception -> 0x033b, blocks: (B:9:0x004b, B:74:0x02bf, B:77:0x02d2, B:79:0x02e7, B:81:0x02ef, B:83:0x02f5, B:84:0x02f8, B:85:0x02f9, B:87:0x0303, B:89:0x0306, B:91:0x0313, B:93:0x031b, B:95:0x0321, B:96:0x0324, B:97:0x0325, B:14:0x0086, B:65:0x0240, B:68:0x0253, B:70:0x0269, B:17:0x00b3, B:57:0x01e3, B:59:0x01ed, B:61:0x01f3, B:20:0x00c7, B:29:0x0105, B:31:0x0137, B:33:0x013f, B:35:0x0145, B:36:0x0148, B:37:0x0149, B:39:0x015a, B:41:0x0162, B:43:0x0168, B:44:0x016b, B:45:0x016c, B:47:0x0172, B:49:0x018f, B:51:0x0197, B:53:0x019d, B:98:0x032b, B:99:0x0332, B:23:0x00d2, B:25:0x00de, B:100:0x0333, B:101:0x033a), top: B:106:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x0303 A[Catch: Exception -> 0x033b, TryCatch #0 {Exception -> 0x033b, blocks: (B:9:0x004b, B:74:0x02bf, B:77:0x02d2, B:79:0x02e7, B:81:0x02ef, B:83:0x02f5, B:84:0x02f8, B:85:0x02f9, B:87:0x0303, B:89:0x0306, B:91:0x0313, B:93:0x031b, B:95:0x0321, B:96:0x0324, B:97:0x0325, B:14:0x0086, B:65:0x0240, B:68:0x0253, B:70:0x0269, B:17:0x00b3, B:57:0x01e3, B:59:0x01ed, B:61:0x01f3, B:20:0x00c7, B:29:0x0105, B:31:0x0137, B:33:0x013f, B:35:0x0145, B:36:0x0148, B:37:0x0149, B:39:0x015a, B:41:0x0162, B:43:0x0168, B:44:0x016b, B:45:0x016c, B:47:0x0172, B:49:0x018f, B:51:0x0197, B:53:0x019d, B:98:0x032b, B:99:0x0332, B:23:0x00d2, B:25:0x00de, B:100:0x0333, B:101:0x033a), top: B:106:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0306 A[Catch: Exception -> 0x033b, TryCatch #0 {Exception -> 0x033b, blocks: (B:9:0x004b, B:74:0x02bf, B:77:0x02d2, B:79:0x02e7, B:81:0x02ef, B:83:0x02f5, B:84:0x02f8, B:85:0x02f9, B:87:0x0303, B:89:0x0306, B:91:0x0313, B:93:0x031b, B:95:0x0321, B:96:0x0324, B:97:0x0325, B:14:0x0086, B:65:0x0240, B:68:0x0253, B:70:0x0269, B:17:0x00b3, B:57:0x01e3, B:59:0x01ed, B:61:0x01f3, B:20:0x00c7, B:29:0x0105, B:31:0x0137, B:33:0x013f, B:35:0x0145, B:36:0x0148, B:37:0x0149, B:39:0x015a, B:41:0x0162, B:43:0x0168, B:44:0x016b, B:45:0x016c, B:47:0x0172, B:49:0x018f, B:51:0x0197, B:53:0x019d, B:98:0x032b, B:99:0x0332, B:23:0x00d2, B:25:0x00de, B:100:0x0333, B:101:0x033a), top: B:106:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0313 A[Catch: Exception -> 0x033b, TryCatch #0 {Exception -> 0x033b, blocks: (B:9:0x004b, B:74:0x02bf, B:77:0x02d2, B:79:0x02e7, B:81:0x02ef, B:83:0x02f5, B:84:0x02f8, B:85:0x02f9, B:87:0x0303, B:89:0x0306, B:91:0x0313, B:93:0x031b, B:95:0x0321, B:96:0x0324, B:97:0x0325, B:14:0x0086, B:65:0x0240, B:68:0x0253, B:70:0x0269, B:17:0x00b3, B:57:0x01e3, B:59:0x01ed, B:61:0x01f3, B:20:0x00c7, B:29:0x0105, B:31:0x0137, B:33:0x013f, B:35:0x0145, B:36:0x0148, B:37:0x0149, B:39:0x015a, B:41:0x0162, B:43:0x0168, B:44:0x016b, B:45:0x016c, B:47:0x0172, B:49:0x018f, B:51:0x0197, B:53:0x019d, B:98:0x032b, B:99:0x0332, B:23:0x00d2, B:25:0x00de, B:100:0x0333, B:101:0x033a), top: B:106:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x031b A[Catch: Exception -> 0x033b, TryCatch #0 {Exception -> 0x033b, blocks: (B:9:0x004b, B:74:0x02bf, B:77:0x02d2, B:79:0x02e7, B:81:0x02ef, B:83:0x02f5, B:84:0x02f8, B:85:0x02f9, B:87:0x0303, B:89:0x0306, B:91:0x0313, B:93:0x031b, B:95:0x0321, B:96:0x0324, B:97:0x0325, B:14:0x0086, B:65:0x0240, B:68:0x0253, B:70:0x0269, B:17:0x00b3, B:57:0x01e3, B:59:0x01ed, B:61:0x01f3, B:20:0x00c7, B:29:0x0105, B:31:0x0137, B:33:0x013f, B:35:0x0145, B:36:0x0148, B:37:0x0149, B:39:0x015a, B:41:0x0162, B:43:0x0168, B:44:0x016b, B:45:0x016c, B:47:0x0172, B:49:0x018f, B:51:0x0197, B:53:0x019d, B:98:0x032b, B:99:0x0332, B:23:0x00d2, B:25:0x00de, B:100:0x0333, B:101:0x033a), top: B:106:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0320  */
    /* JADX WARN: Code duplicated, block: B:97:0x0325 A[Catch: Exception -> 0x033b, TryCatch #0 {Exception -> 0x033b, blocks: (B:9:0x004b, B:74:0x02bf, B:77:0x02d2, B:79:0x02e7, B:81:0x02ef, B:83:0x02f5, B:84:0x02f8, B:85:0x02f9, B:87:0x0303, B:89:0x0306, B:91:0x0313, B:93:0x031b, B:95:0x0321, B:96:0x0324, B:97:0x0325, B:14:0x0086, B:65:0x0240, B:68:0x0253, B:70:0x0269, B:17:0x00b3, B:57:0x01e3, B:59:0x01ed, B:61:0x01f3, B:20:0x00c7, B:29:0x0105, B:31:0x0137, B:33:0x013f, B:35:0x0145, B:36:0x0148, B:37:0x0149, B:39:0x015a, B:41:0x0162, B:43:0x0168, B:44:0x016b, B:45:0x016c, B:47:0x0172, B:49:0x018f, B:51:0x0197, B:53:0x019d, B:98:0x032b, B:99:0x0332, B:23:0x00d2, B:25:0x00de, B:100:0x0333, B:101:0x033a), top: B:106:0x0011 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object objA;
        List<X509Certificate> list;
        List list2;
        NativeDigitalSignatureMetadata nativeDigitalSignatureMetadata;
        Object objA2;
        List list3;
        DataProviderShim dataProviderShim;
        List<X509Certificate> list4;
        NativeDigitalSignatureCreator nativeDigitalSignatureCreator;
        String str;
        NativeDataToSign nativeDataToSign;
        NativeDigitalSignatureResult nativeDigitalSignatureResult;
        NativeDataToSignResult nativeDataToSignResult;
        NativeFormField nativeFormField;
        byte[] bArr;
        DigitalSignatureMetadata metadata;
        NativeDataToSign nativeDataToSign2;
        Deferred deferred;
        NativeFormField nativeFormField2;
        NativeDigitalSignatureResult nativeDigitalSignatureResult2;
        NativeDataToSignResult nativeDataToSignResult2;
        String str2;
        TimestampData timestampData;
        Object objCoroutineScope;
        NativeDigitalSignatureResult nativeDigitalSignatureResult3;
        NativeDataToSign nativeDataToSign3;
        NativeDigitalSignatureType type;
        String str3;
        byte[] data;
        NativeDataToSignResult nativeDataToSignResult3;
        ArrayList arrayList;
        byte[] bArr2;
        NativeDigitalSignatureType nativeDigitalSignatureType;
        ArrayList arrayList2;
        NativeFormField nativeFormField3;
        DataProviderShim dataProviderShim2;
        byte[] bArr3;
        Object objAwait;
        byte[] bArr4;
        ArrayList arrayList3;
        NativeDigitalSignatureType nativeDigitalSignatureType2;
        NativeFormField nativeFormField4;
        DataProviderShim dataProviderShim3;
        NativeDigitalSignatureBinaryResult nativeDigitalSignatureBinaryResultCreateSignature;
        String fqn;
        byte[] value;
        NativeDigitalSignatureResult nativeDigitalSignatureResultFinishSignature;
        NativeDigitalSignatureCreationError error;
        String errorMessage;
        NativeDigitalSignatureCreationError error2;
        String errorMessage2;
        CoroutineScope coroutineScope = (CoroutineScope) this.r;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.q;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!ar.b().a(NativeLicenseFeatures.DIGITAL_SIGNATURES)) {
                    throw new InvalidNutrientLicenseException("Signing form fields requires digital signature feature in your license!");
                }
                List<X509Certificate> listA = s20.a(this.s, "signDocument");
                List listA2 = j20.a(listA);
                Context context = this.t;
                SignerOptions signerOptions = this.s;
                this.r = coroutineScope;
                this.a = SpillingKt.nullOutSpilledVariable(listA);
                this.b = listA2;
                this.q = 1;
                objA = xq.a(context, signerOptions, listA2, this);
                if (objA != coroutine_suspended) {
                    list = listA;
                    list2 = listA2;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                List list5 = (List) this.b;
                List<X509Certificate> list6 = (List) this.a;
                ResultKt.throwOnFailure(obj);
                list2 = list5;
                list = list6;
                objA = obj;
            } else {
                if (i == 2) {
                    String str4 = (String) this.j;
                    NativeDataToSign nativeDataToSign4 = this.i;
                    NativeDataToSignResult nativeDataToSignResult4 = (NativeDataToSignResult) this.h;
                    NativeDigitalSignatureResult nativeDigitalSignatureResult4 = (NativeDigitalSignatureResult) this.g;
                    NativeFormField nativeFormField5 = this.f;
                    dataProviderShim = this.e;
                    nativeDigitalSignatureCreator = this.d;
                    nativeDigitalSignatureMetadata = (NativeDigitalSignatureMetadata) this.c;
                    list3 = (List) this.b;
                    list4 = (List) this.a;
                    ResultKt.throwOnFailure(obj);
                    nativeFormField = nativeFormField5;
                    nativeDigitalSignatureResult = nativeDigitalSignatureResult4;
                    nativeDataToSignResult = nativeDataToSignResult4;
                    nativeDataToSign = nativeDataToSign4;
                    str = str4;
                    objA2 = obj;
                    bArr = (byte[]) objA2;
                    metadata = this.s.getMetadata();
                    if (metadata != null || (timestampData = metadata.getTimestampData()) == null) {
                        String str5 = str;
                        nativeDataToSign2 = nativeDataToSign;
                        deferred = null;
                        nativeFormField2 = nativeFormField;
                        nativeDigitalSignatureResult2 = nativeDigitalSignatureResult;
                        nativeDataToSignResult2 = nativeDataToSignResult;
                        str2 = str5;
                        nativeDataToSign3 = nativeDataToSign2;
                        type = nativeDigitalSignatureMetadata.getType();
                        str3 = str2;
                        data = nativeDataToSign3.getData();
                        list3.getClass();
                        nativeDataToSignResult3 = nativeDataToSignResult2;
                        arrayList = new ArrayList(list3);
                        if (deferred != null) {
                            this.r = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.a = SpillingKt.nullOutSpilledVariable(list4);
                            this.b = SpillingKt.nullOutSpilledVariable(list3);
                            this.c = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureMetadata);
                            this.d = nativeDigitalSignatureCreator;
                            this.e = dataProviderShim;
                            this.f = nativeFormField2;
                            this.g = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureResult2);
                            this.h = SpillingKt.nullOutSpilledVariable(nativeDataToSignResult3);
                            this.i = nativeDataToSign3;
                            this.j = SpillingKt.nullOutSpilledVariable(str3);
                            this.k = SpillingKt.nullOutSpilledVariable(bArr);
                            this.l = SpillingKt.nullOutSpilledVariable(deferred);
                            this.m = type;
                            this.n = bArr;
                            this.o = data;
                            this.p = arrayList;
                            this.q = 4;
                            objAwait = deferred.await(this);
                            if (objAwait != coroutine_suspended) {
                                bArr4 = bArr;
                                arrayList3 = arrayList;
                                nativeDigitalSignatureType2 = type;
                                nativeFormField4 = nativeFormField2;
                                dataProviderShim3 = dataProviderShim;
                            }
                        } else {
                            bArr2 = bArr;
                            nativeDigitalSignatureType = type;
                            arrayList2 = arrayList;
                            nativeFormField3 = nativeFormField2;
                            dataProviderShim2 = dataProviderShim;
                            bArr3 = null;
                        }
                        nativeDigitalSignatureBinaryResultCreateSignature = NativePKCS7Creator.createSignature(nativeDigitalSignatureType, bArr2, data, arrayList2, bArr3, nativeDataToSign3.getSignerOptions().getHashAlgorithm());
                        nativeDigitalSignatureBinaryResultCreateSignature.getClass();
                        if (nativeDigitalSignatureBinaryResultCreateSignature.getHasError()) {
                            error2 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                            if (error2 != null) {
                                errorMessage2 = error2.getErrorMessage();
                            } else {
                                errorMessage2 = null;
                            }
                            throw new RuntimeException(errorMessage2);
                        }
                        fqn = nativeFormField3.getFQN();
                        value = nativeDigitalSignatureBinaryResultCreateSignature.getValue();
                        if (value == null) {
                            return Unit.INSTANCE;
                        }
                        nativeDigitalSignatureResultFinishSignature = nativeDigitalSignatureCreator.finishSignature(fqn, value, dataProviderShim2);
                        nativeDigitalSignatureResultFinishSignature.getClass();
                        if (!nativeDigitalSignatureResultFinishSignature.getHasError()) {
                            this.v.invoke();
                            return Unit.INSTANCE;
                        }
                        error = nativeDigitalSignatureResultFinishSignature.getError();
                        if (error != null) {
                            errorMessage = error.getErrorMessage();
                        } else {
                            errorMessage = null;
                        }
                        throw new RuntimeException(errorMessage);
                    }
                    Context context2 = this.t;
                    String str6 = str;
                    this.r = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.a = SpillingKt.nullOutSpilledVariable(list4);
                    this.b = list3;
                    this.c = nativeDigitalSignatureMetadata;
                    this.d = nativeDigitalSignatureCreator;
                    this.e = dataProviderShim;
                    this.f = nativeFormField;
                    this.g = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureResult);
                    this.h = SpillingKt.nullOutSpilledVariable(nativeDataToSignResult);
                    this.i = nativeDataToSign;
                    this.j = SpillingKt.nullOutSpilledVariable(str6);
                    this.k = bArr;
                    this.l = SpillingKt.nullOutSpilledVariable(timestampData);
                    this.q = 3;
                    nativeDataToSign2 = nativeDataToSign;
                    objCoroutineScope = CoroutineScopeKt.coroutineScope(new q20(timestampData, bArr, context2, null), this);
                    if (objCoroutineScope != coroutine_suspended) {
                        nativeDigitalSignatureResult3 = nativeDigitalSignatureResult;
                        nativeDataToSignResult2 = nativeDataToSignResult;
                        str2 = str6;
                        deferred = (Deferred) objCoroutineScope;
                        nativeFormField2 = nativeFormField;
                        nativeDigitalSignatureResult2 = nativeDigitalSignatureResult3;
                        nativeDataToSign3 = nativeDataToSign2;
                        type = nativeDigitalSignatureMetadata.getType();
                        str3 = str2;
                        data = nativeDataToSign3.getData();
                        list3.getClass();
                        nativeDataToSignResult3 = nativeDataToSignResult2;
                        arrayList = new ArrayList(list3);
                        if (deferred != null) {
                            this.r = SpillingKt.nullOutSpilledVariable(coroutineScope);
                            this.a = SpillingKt.nullOutSpilledVariable(list4);
                            this.b = SpillingKt.nullOutSpilledVariable(list3);
                            this.c = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureMetadata);
                            this.d = nativeDigitalSignatureCreator;
                            this.e = dataProviderShim;
                            this.f = nativeFormField2;
                            this.g = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureResult2);
                            this.h = SpillingKt.nullOutSpilledVariable(nativeDataToSignResult3);
                            this.i = nativeDataToSign3;
                            this.j = SpillingKt.nullOutSpilledVariable(str3);
                            this.k = SpillingKt.nullOutSpilledVariable(bArr);
                            this.l = SpillingKt.nullOutSpilledVariable(deferred);
                            this.m = type;
                            this.n = bArr;
                            this.o = data;
                            this.p = arrayList;
                            this.q = 4;
                            objAwait = deferred.await(this);
                            if (objAwait != coroutine_suspended) {
                                bArr4 = bArr;
                                arrayList3 = arrayList;
                                nativeDigitalSignatureType2 = type;
                                nativeFormField4 = nativeFormField2;
                                dataProviderShim3 = dataProviderShim;
                            }
                        } else {
                            bArr2 = bArr;
                            nativeDigitalSignatureType = type;
                            arrayList2 = arrayList;
                            nativeFormField3 = nativeFormField2;
                            dataProviderShim2 = dataProviderShim;
                            bArr3 = null;
                        }
                        nativeDigitalSignatureBinaryResultCreateSignature = NativePKCS7Creator.createSignature(nativeDigitalSignatureType, bArr2, data, arrayList2, bArr3, nativeDataToSign3.getSignerOptions().getHashAlgorithm());
                        nativeDigitalSignatureBinaryResultCreateSignature.getClass();
                        if (nativeDigitalSignatureBinaryResultCreateSignature.getHasError()) {
                            error2 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                            if (error2 != null) {
                                errorMessage2 = error2.getErrorMessage();
                            } else {
                                errorMessage2 = null;
                            }
                            throw new RuntimeException(errorMessage2);
                        }
                        fqn = nativeFormField3.getFQN();
                        value = nativeDigitalSignatureBinaryResultCreateSignature.getValue();
                        if (value == null) {
                            return Unit.INSTANCE;
                        }
                        nativeDigitalSignatureResultFinishSignature = nativeDigitalSignatureCreator.finishSignature(fqn, value, dataProviderShim2);
                        nativeDigitalSignatureResultFinishSignature.getClass();
                        if (!nativeDigitalSignatureResultFinishSignature.getHasError()) {
                            this.v.invoke();
                            return Unit.INSTANCE;
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
                }
                if (i == 3) {
                    bArr = (byte[]) this.k;
                    String str7 = (String) this.j;
                    NativeDataToSign nativeDataToSign5 = this.i;
                    NativeDataToSignResult nativeDataToSignResult5 = (NativeDataToSignResult) this.h;
                    NativeDigitalSignatureResult nativeDigitalSignatureResult5 = (NativeDigitalSignatureResult) this.g;
                    nativeFormField = this.f;
                    dataProviderShim = this.e;
                    nativeDigitalSignatureCreator = this.d;
                    nativeDigitalSignatureMetadata = (NativeDigitalSignatureMetadata) this.c;
                    list3 = (List) this.b;
                    list4 = (List) this.a;
                    ResultKt.throwOnFailure(obj);
                    nativeDataToSign2 = nativeDataToSign5;
                    nativeDigitalSignatureResult3 = nativeDigitalSignatureResult5;
                    nativeDataToSignResult2 = nativeDataToSignResult5;
                    str2 = str7;
                    objCoroutineScope = obj;
                    deferred = (Deferred) objCoroutineScope;
                    nativeFormField2 = nativeFormField;
                    nativeDigitalSignatureResult2 = nativeDigitalSignatureResult3;
                    nativeDataToSign3 = nativeDataToSign2;
                    type = nativeDigitalSignatureMetadata.getType();
                    str3 = str2;
                    data = nativeDataToSign3.getData();
                    list3.getClass();
                    nativeDataToSignResult3 = nativeDataToSignResult2;
                    arrayList = new ArrayList(list3);
                    if (deferred != null) {
                        this.r = SpillingKt.nullOutSpilledVariable(coroutineScope);
                        this.a = SpillingKt.nullOutSpilledVariable(list4);
                        this.b = SpillingKt.nullOutSpilledVariable(list3);
                        this.c = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureMetadata);
                        this.d = nativeDigitalSignatureCreator;
                        this.e = dataProviderShim;
                        this.f = nativeFormField2;
                        this.g = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureResult2);
                        this.h = SpillingKt.nullOutSpilledVariable(nativeDataToSignResult3);
                        this.i = nativeDataToSign3;
                        this.j = SpillingKt.nullOutSpilledVariable(str3);
                        this.k = SpillingKt.nullOutSpilledVariable(bArr);
                        this.l = SpillingKt.nullOutSpilledVariable(deferred);
                        this.m = type;
                        this.n = bArr;
                        this.o = data;
                        this.p = arrayList;
                        this.q = 4;
                        objAwait = deferred.await(this);
                        if (objAwait != coroutine_suspended) {
                            bArr4 = bArr;
                            arrayList3 = arrayList;
                            nativeDigitalSignatureType2 = type;
                            nativeFormField4 = nativeFormField2;
                            dataProviderShim3 = dataProviderShim;
                        }
                        return coroutine_suspended;
                    }
                    bArr2 = bArr;
                    nativeDigitalSignatureType = type;
                    arrayList2 = arrayList;
                    nativeFormField3 = nativeFormField2;
                    dataProviderShim2 = dataProviderShim;
                    bArr3 = null;
                    nativeDigitalSignatureBinaryResultCreateSignature = NativePKCS7Creator.createSignature(nativeDigitalSignatureType, bArr2, data, arrayList2, bArr3, nativeDataToSign3.getSignerOptions().getHashAlgorithm());
                    nativeDigitalSignatureBinaryResultCreateSignature.getClass();
                    if (nativeDigitalSignatureBinaryResultCreateSignature.getHasError()) {
                        error2 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                        if (error2 != null) {
                            errorMessage2 = error2.getErrorMessage();
                        } else {
                            errorMessage2 = null;
                        }
                        throw new RuntimeException(errorMessage2);
                    }
                    fqn = nativeFormField3.getFQN();
                    value = nativeDigitalSignatureBinaryResultCreateSignature.getValue();
                    if (value == null) {
                        return Unit.INSTANCE;
                    }
                    nativeDigitalSignatureResultFinishSignature = nativeDigitalSignatureCreator.finishSignature(fqn, value, dataProviderShim2);
                    nativeDigitalSignatureResultFinishSignature.getClass();
                    if (!nativeDigitalSignatureResultFinishSignature.getHasError()) {
                        this.v.invoke();
                        return Unit.INSTANCE;
                    }
                    error = nativeDigitalSignatureResultFinishSignature.getError();
                    if (error != null) {
                        errorMessage = error.getErrorMessage();
                    } else {
                        errorMessage = null;
                    }
                    throw new RuntimeException(errorMessage);
                }
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                arrayList3 = this.p;
                byte[] bArr5 = this.o;
                bArr4 = this.n;
                NativeDigitalSignatureType nativeDigitalSignatureType3 = this.m;
                NativeDataToSign nativeDataToSign6 = this.i;
                nativeFormField4 = this.f;
                dataProviderShim3 = this.e;
                NativeDigitalSignatureCreator nativeDigitalSignatureCreator2 = this.d;
                ResultKt.throwOnFailure(obj);
                nativeDigitalSignatureCreator = nativeDigitalSignatureCreator2;
                nativeDataToSign3 = nativeDataToSign6;
                nativeDigitalSignatureType2 = nativeDigitalSignatureType3;
                data = bArr5;
                objAwait = obj;
            }
            DataProviderShim dataProviderShim4 = dataProviderShim3;
            bArr2 = bArr4;
            dataProviderShim2 = dataProviderShim4;
            arrayList2 = arrayList3;
            bArr3 = (byte[]) objAwait;
            nativeFormField3 = nativeFormField4;
            nativeDigitalSignatureType = nativeDigitalSignatureType2;
            nativeDigitalSignatureBinaryResultCreateSignature = NativePKCS7Creator.createSignature(nativeDigitalSignatureType, bArr2, data, arrayList2, bArr3, nativeDataToSign3.getSignerOptions().getHashAlgorithm());
            nativeDigitalSignatureBinaryResultCreateSignature.getClass();
            if (nativeDigitalSignatureBinaryResultCreateSignature.getHasError()) {
                error2 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                if (error2 != null) {
                    errorMessage2 = error2.getErrorMessage();
                } else {
                    errorMessage2 = null;
                }
                throw new RuntimeException(errorMessage2);
            }
            fqn = nativeFormField3.getFQN();
            value = nativeDigitalSignatureBinaryResultCreateSignature.getValue();
            if (value == null) {
                return Unit.INSTANCE;
            }
            nativeDigitalSignatureResultFinishSignature = nativeDigitalSignatureCreator.finishSignature(fqn, value, dataProviderShim2);
            nativeDigitalSignatureResultFinishSignature.getClass();
            if (!nativeDigitalSignatureResultFinishSignature.getHasError()) {
                this.v.invoke();
                return Unit.INSTANCE;
            }
            error = nativeDigitalSignatureResultFinishSignature.getError();
            if (error != null) {
                errorMessage = error.getErrorMessage();
            } else {
                errorMessage = null;
            }
            throw new RuntimeException(errorMessage);
            nativeDigitalSignatureMetadata = (NativeDigitalSignatureMetadata) objA;
            m20 m20Var = m20.a;
            NativeDigitalSignatureCreator nativeDigitalSignatureCreatorA = m20.a(list2, nativeDigitalSignatureMetadata);
            DataProviderShim dataProviderShim5 = new DataProviderShim(this.s.getOutputDataProvider());
            NativeFormField nativeFormField6 = this.s.getSignatureFormField().getInternal().getNativeFormField();
            nativeFormField6.getClass();
            NativeDigitalSignatureResult nativeDigitalSignatureResultPrepareSignature = nativeDigitalSignatureCreatorA.prepareSignature(nativeFormField6, dataProviderShim5);
            nativeDigitalSignatureResultPrepareSignature.getClass();
            if (nativeDigitalSignatureResultPrepareSignature.getHasError()) {
                NativeDigitalSignatureCreationError error3 = nativeDigitalSignatureResultPrepareSignature.getError();
                throw new RuntimeException(error3 != null ? error3.getErrorMessage() : null);
            }
            NativeDataToSignResult dataToSign = nativeDigitalSignatureCreatorA.getDataToSign(nativeFormField6.getFQN(), dataProviderShim5);
            dataToSign.getClass();
            if (dataToSign.getHasError()) {
                NativeDigitalSignatureCreationError error4 = dataToSign.getError();
                throw new RuntimeException(error4 != null ? error4.getErrorMessage() : null);
            }
            NativeDataToSign value2 = dataToSign.getValue();
            if (value2 == null) {
                throw new RuntimeException("Data to sign is null");
            }
            String strName = value2.getSignerOptions().getHashAlgorithm().name();
            Function3<byte[], String, Continuation<? super byte[]>, Object> function3 = this.u;
            byte[] data2 = value2.getData();
            data2.getClass();
            PrivateKey privateKey = this.s.getPrivateKey();
            if (privateKey == null) {
                KeyStore.PrivateKeyEntry privateKeyEntry = this.s.getPrivateKeyEntry();
                privateKey = privateKeyEntry != null ? privateKeyEntry.getPrivateKey() : null;
            }
            this.r = SpillingKt.nullOutSpilledVariable(coroutineScope);
            this.a = SpillingKt.nullOutSpilledVariable(list);
            this.b = list2;
            this.c = nativeDigitalSignatureMetadata;
            this.d = nativeDigitalSignatureCreatorA;
            this.e = dataProviderShim5;
            this.f = nativeFormField6;
            this.g = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureResultPrepareSignature);
            this.h = SpillingKt.nullOutSpilledVariable(dataToSign);
            this.i = value2;
            this.j = SpillingKt.nullOutSpilledVariable(strName);
            this.q = 2;
            objA2 = m20Var.a(function3, data2, privateKey, strName, this);
            if (objA2 != coroutine_suspended) {
                list3 = list2;
                dataProviderShim = dataProviderShim5;
                list4 = list;
                nativeDigitalSignatureCreator = nativeDigitalSignatureCreatorA;
                str = strName;
                nativeDataToSign = value2;
                nativeDigitalSignatureResult = nativeDigitalSignatureResultPrepareSignature;
                nativeDataToSignResult = dataToSign;
                nativeFormField = nativeFormField6;
                bArr = (byte[]) objA2;
                metadata = this.s.getMetadata();
                if (metadata != null) {
                }
                String str8 = str;
                nativeDataToSign2 = nativeDataToSign;
                deferred = null;
                nativeFormField2 = nativeFormField;
                nativeDigitalSignatureResult2 = nativeDigitalSignatureResult;
                nativeDataToSignResult2 = nativeDataToSignResult;
                str2 = str8;
                nativeDataToSign3 = nativeDataToSign2;
                type = nativeDigitalSignatureMetadata.getType();
                str3 = str2;
                data = nativeDataToSign3.getData();
                list3.getClass();
                nativeDataToSignResult3 = nativeDataToSignResult2;
                arrayList = new ArrayList(list3);
                if (deferred != null) {
                    this.r = SpillingKt.nullOutSpilledVariable(coroutineScope);
                    this.a = SpillingKt.nullOutSpilledVariable(list4);
                    this.b = SpillingKt.nullOutSpilledVariable(list3);
                    this.c = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureMetadata);
                    this.d = nativeDigitalSignatureCreator;
                    this.e = dataProviderShim;
                    this.f = nativeFormField2;
                    this.g = SpillingKt.nullOutSpilledVariable(nativeDigitalSignatureResult2);
                    this.h = SpillingKt.nullOutSpilledVariable(nativeDataToSignResult3);
                    this.i = nativeDataToSign3;
                    this.j = SpillingKt.nullOutSpilledVariable(str3);
                    this.k = SpillingKt.nullOutSpilledVariable(bArr);
                    this.l = SpillingKt.nullOutSpilledVariable(deferred);
                    this.m = type;
                    this.n = bArr;
                    this.o = data;
                    this.p = arrayList;
                    this.q = 4;
                    objAwait = deferred.await(this);
                    if (objAwait != coroutine_suspended) {
                        bArr4 = bArr;
                        arrayList3 = arrayList;
                        nativeDigitalSignatureType2 = type;
                        nativeFormField4 = nativeFormField2;
                        dataProviderShim3 = dataProviderShim;
                        DataProviderShim dataProviderShim6 = dataProviderShim3;
                        bArr2 = bArr4;
                        dataProviderShim2 = dataProviderShim6;
                        arrayList2 = arrayList3;
                        bArr3 = (byte[]) objAwait;
                        nativeFormField3 = nativeFormField4;
                        nativeDigitalSignatureType = nativeDigitalSignatureType2;
                    }
                } else {
                    bArr2 = bArr;
                    nativeDigitalSignatureType = type;
                    arrayList2 = arrayList;
                    nativeFormField3 = nativeFormField2;
                    dataProviderShim2 = dataProviderShim;
                    bArr3 = null;
                }
                nativeDigitalSignatureBinaryResultCreateSignature = NativePKCS7Creator.createSignature(nativeDigitalSignatureType, bArr2, data, arrayList2, bArr3, nativeDataToSign3.getSignerOptions().getHashAlgorithm());
                nativeDigitalSignatureBinaryResultCreateSignature.getClass();
                if (nativeDigitalSignatureBinaryResultCreateSignature.getHasError()) {
                    error2 = nativeDigitalSignatureBinaryResultCreateSignature.getError();
                    if (error2 != null) {
                        errorMessage2 = error2.getErrorMessage();
                    } else {
                        errorMessage2 = null;
                    }
                    throw new RuntimeException(errorMessage2);
                }
                fqn = nativeFormField3.getFQN();
                value = nativeDigitalSignatureBinaryResultCreateSignature.getValue();
                if (value == null) {
                    return Unit.INSTANCE;
                }
                nativeDigitalSignatureResultFinishSignature = nativeDigitalSignatureCreator.finishSignature(fqn, value, dataProviderShim2);
                nativeDigitalSignatureResultFinishSignature.getClass();
                if (!nativeDigitalSignatureResultFinishSignature.getHasError()) {
                    this.v.invoke();
                    return Unit.INSTANCE;
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
        } catch (Exception e) {
            this.w.invoke(e);
        }
    }
}
