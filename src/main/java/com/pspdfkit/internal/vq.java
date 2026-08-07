package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.signatures.ltv.MetadataWithLtvKt", f = "MetadataWithLtv.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {64}, m = "getMetaDataWithLtv", n = {"context", "signerOptions", "nativeCertificates", "rootCertificates", "$this$getMetaDataWithLtv_u24lambda_u241", "revocationResponses", "$i$a$-apply-MetadataWithLtvKt$getMetaDataWithLtv$2"}, nl = {66}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0"}, v = 2)
public final class vq extends ContinuationImpl {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public NativeDigitalSignatureMetadata e;
    public Object f;
    public Object g;
    public NativeDigitalSignatureMetadata h;
    public /* synthetic */ Object i;
    public int j;

    public vq(ContinuationImpl continuationImpl) {
        super(continuationImpl);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.i = obj;
        this.j |= Integer.MIN_VALUE;
        return xq.a(null, null, null, this);
    }
}
