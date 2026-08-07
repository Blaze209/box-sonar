package com.pspdfkit.ui.signatures;

import com.pspdfkit.signatures.Signature;
import com.pspdfkit.signatures.storage.SignatureStorage;
import com.pspdfkit.utils.PdfLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.pspdfkit.ui.signatures.SignaturePickerFragment$InternalListener$onSignatureCreated$1", f = "SignaturePickerFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
public final class SignaturePickerFragment$InternalListener$onSignatureCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $shouldStoreSignature;
    final /* synthetic */ Signature $signature;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SignaturePickerFragment this$0;
    final /* synthetic */ SignaturePickerFragment.InternalListener this$1;

    /* JADX INFO: renamed from: com.pspdfkit.ui.signatures.SignaturePickerFragment$InternalListener$onSignatureCreated$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.ui.signatures.SignaturePickerFragment$InternalListener$onSignatureCreated$1$1", f = "SignaturePickerFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $shouldStoreSignature;
        final /* synthetic */ Signature $signature;
        int label;
        final /* synthetic */ SignaturePickerFragment.InternalListener this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z, Signature signature, SignaturePickerFragment.InternalListener internalListener, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$shouldStoreSignature = z;
            this.$signature = signature;
            this.this$0 = internalListener;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$shouldStoreSignature, this.$signature, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (this.$shouldStoreSignature) {
                PdfLog.d("Nutri.SignPickerFrag", "Successfully added signature to the signature storage: " + this.$signature, new Object[0]);
            }
            this.this$0.onSignaturePicked(this.$signature);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignaturePickerFragment$InternalListener$onSignatureCreated$1(boolean z, SignaturePickerFragment signaturePickerFragment, Signature signature, SignaturePickerFragment.InternalListener internalListener, Continuation<? super SignaturePickerFragment$InternalListener$onSignatureCreated$1> continuation) {
        super(2, continuation);
        this.$shouldStoreSignature = z;
        this.this$0 = signaturePickerFragment;
        this.$signature = signature;
        this.this$1 = internalListener;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SignaturePickerFragment$InternalListener$onSignatureCreated$1 signaturePickerFragment$InternalListener$onSignatureCreated$1 = new SignaturePickerFragment$InternalListener$onSignatureCreated$1(this.$shouldStoreSignature, this.this$0, this.$signature, this.this$1, continuation);
        signaturePickerFragment$InternalListener$onSignatureCreated$1.L$0 = obj;
        return signaturePickerFragment$InternalListener$onSignatureCreated$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        SignatureStorage signatureStorage;
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            if (this.$shouldStoreSignature && (signatureStorage = this.this$0.getSignatureStorage()) != null) {
                signatureStorage.addSignature(this.$signature);
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new AnonymousClass1(this.$shouldStoreSignature, this.$signature, this.this$1, null), 2, null);
        } catch (Exception e) {
            PdfLog.e("Nutri.SignPickerFrag", e, "Failed to add signature to the signature storage.", new Object[0]);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SignaturePickerFragment$InternalListener$onSignatureCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
