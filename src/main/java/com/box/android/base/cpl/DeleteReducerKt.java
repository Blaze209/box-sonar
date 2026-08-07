package com.box.android.base.cpl;

import com.box.android.domain.models.ItemId;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"createDeleteReducer", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer;", "deleteEnvironment", "Lcom/box/android/base/cpl/DeleteEnvironment;", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeleteReducerKt {

    /* JADX INFO: renamed from: com.box.android.base.cpl.DeleteReducerKt$createDeleteReducer$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeleteReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/box/android/domain/models/ItemId;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.cpl.DeleteReducerKt$createDeleteReducer$1", f = "DeleteReducer.kt", i = {0}, l = {9}, m = "invokeSuspend", n = {"it"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ItemId, Continuation<? super Unit>, Object> {
        final /* synthetic */ DeleteEnvironment $deleteEnvironment;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DeleteEnvironment deleteEnvironment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$deleteEnvironment = deleteEnvironment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$deleteEnvironment, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ItemId itemId, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(itemId, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ItemId itemId = (ItemId) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
                this.label = 1;
                if (this.$deleteEnvironment.getLocalItemService().deleteFile(itemId, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final ItemActionConfirmationReducer createDeleteReducer(DeleteEnvironment deleteEnvironment) {
        Intrinsics.checkNotNullParameter(deleteEnvironment, "deleteEnvironment");
        return new ItemActionConfirmationReducer(new AnonymousClass1(deleteEnvironment, null));
    }
}
