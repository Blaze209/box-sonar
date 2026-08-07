package com.pspdfkit.ui.signatures;

import com.pspdfkit.signatures.Signature;
import com.pspdfkit.signatures.storage.SignatureStorage;
import com.pspdfkit.utils.PdfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.pspdfkit.ui.signatures.SignaturePickerFragment$InternalListener$onSignaturesDeleted$1", f = "SignaturePickerFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class SignaturePickerFragment$InternalListener$onSignaturesDeleted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Signature> $signatures;
    int label;
    final /* synthetic */ SignaturePickerFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignaturePickerFragment$InternalListener$onSignaturesDeleted$1(SignaturePickerFragment signaturePickerFragment, List<Signature> list, Continuation<? super SignaturePickerFragment$InternalListener$onSignaturesDeleted$1> continuation) {
        super(2, continuation);
        this.this$0 = signaturePickerFragment;
        this.$signatures = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SignaturePickerFragment$InternalListener$onSignaturesDeleted$1(this.this$0, this.$signatures, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            SignatureStorage signatureStorage = this.this$0.getSignatureStorage();
            if (signatureStorage != null) {
                signatureStorage.removeSignatures(this.$signatures);
            }
            PdfLog.d("Nutri.SignPickerFrag", "Successfully removed signatures from the signature storage: " + this.$signatures, new Object[0]);
        } catch (Exception e) {
            PdfLog.e("Nutri.SignPickerFrag", e, "Failed to remove signatures from the signature storage: " + this.$signatures, new Object[0]);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SignaturePickerFragment$InternalListener$onSignaturesDeleted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
