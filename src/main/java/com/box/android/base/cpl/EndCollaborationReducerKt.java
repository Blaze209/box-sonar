package com.box.android.base.cpl;

import com.box.android.domain.models.ItemId;
import com.box.android.domain.services.ILocalItemService;
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

/* JADX INFO: compiled from: EndCollaborationReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"createEndCollaborationReducer", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer;", "endCollaborationEnvironment", "Lcom/box/android/base/cpl/EndCollaborationEnvironment;", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class EndCollaborationReducerKt {

    /* JADX INFO: renamed from: com.box.android.base.cpl.EndCollaborationReducerKt$createEndCollaborationReducer$1, reason: invalid class name */
    /* JADX INFO: compiled from: EndCollaborationReducer.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "itemId", "Lcom/box/android/domain/models/ItemId;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.cpl.EndCollaborationReducerKt$createEndCollaborationReducer$1", f = "EndCollaborationReducer.kt", i = {0}, l = {10}, m = "invokeSuspend", n = {"itemId"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<ItemId, Continuation<? super Unit>, Object> {
        final /* synthetic */ EndCollaborationEnvironment $endCollaborationEnvironment;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EndCollaborationEnvironment endCollaborationEnvironment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$endCollaborationEnvironment = endCollaborationEnvironment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$endCollaborationEnvironment, continuation);
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
                ILocalItemService localItemService = this.$endCollaborationEnvironment.getLocalItemService();
                String currentContextId = this.$endCollaborationEnvironment.getUserContextManager().getCurrentContextId();
                Intrinsics.checkNotNullExpressionValue(currentContextId, "getCurrentContextId(...)");
                this.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
                this.label = 1;
                if (localItemService.deleteCollaboration(itemId, currentContextId, this) == coroutine_suspended) {
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

    public static final ItemActionConfirmationReducer createEndCollaborationReducer(EndCollaborationEnvironment endCollaborationEnvironment) {
        Intrinsics.checkNotNullParameter(endCollaborationEnvironment, "endCollaborationEnvironment");
        return new ItemActionConfirmationReducer(new AnonymousClass1(endCollaborationEnvironment, null));
    }
}
