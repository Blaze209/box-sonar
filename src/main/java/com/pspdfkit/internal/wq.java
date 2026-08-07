package com.pspdfkit.internal;

import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.jni.NativeDigitalSignatureMetadata;
import com.pspdfkit.internal.jni.NativeDocument;
import com.pspdfkit.internal.jni.NativeKeyStore;
import com.pspdfkit.internal.jni.NativeX509Certificate;
import com.pspdfkit.signatures.SignerOptions;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "com.pspdfkit.internal.signatures.ltv.MetadataWithLtvKt$getMetaDataWithLtv$2$revocationResponses$1", f = "MetadataWithLtv.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class wq extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    public final /* synthetic */ SignerOptions a;
    public final /* synthetic */ List<NativeX509Certificate> b;
    public final /* synthetic */ NativeDigitalSignatureMetadata c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public wq(SignerOptions signerOptions, List<? extends NativeX509Certificate> list, NativeDigitalSignatureMetadata nativeDigitalSignatureMetadata, Continuation<? super wq> continuation) {
        super(2, continuation);
        this.a = signerOptions;
        this.b = list;
        this.c = nativeDigitalSignatureMetadata;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new wq(this.a, this.b, this.c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((wq) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        PdfDocument document = this.a.getSignatureFormField().getSignatureInfo().getDocument();
        document.getClass();
        NativeDocument nativeDocument = ((lm) document).y;
        List<NativeX509Certificate> list = this.b;
        NativeKeyStore trustedKeyStore = this.c.getTrustedKeyStore();
        trustedKeyStore.getClass();
        return t8.a(nativeDocument, list, trustedKeyStore);
    }
}
