package com.box.android.domain.usecases.fileactivities.comment;

import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CreateCommentInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.domain.usecases.fileactivities.comment.CreateCommentInteractor$createListenerWithCaching$1$1", f = "CreateCommentInteractor.kt", i = {0, 0, 0, 0}, l = {62}, m = "invokeSuspend", n = {"$this$launch", "$this$invokeSuspend_u24lambda_u240", "itemId", "$i$a$-runCatching-CreateCommentInteractor$createListenerWithCaching$1$1$1"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
final class CreateCommentInteractor$createListenerWithCaching$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $fileId;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ CreateCommentInteractor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CreateCommentInteractor$createListenerWithCaching$1$1(String str, CreateCommentInteractor createCommentInteractor, Continuation<? super CreateCommentInteractor$createListenerWithCaching$1$1> continuation) {
        super(2, continuation);
        this.$fileId = str;
        this.this$0 = createCommentInteractor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CreateCommentInteractor$createListenerWithCaching$1$1 createCommentInteractor$createListenerWithCaching$1$1 = new CreateCommentInteractor$createListenerWithCaching$1$1(this.$fileId, this.this$0, continuation);
        createCommentInteractor$createListenerWithCaching$1$1.L$0 = obj;
        return createCommentInteractor$createListenerWithCaching$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CreateCommentInteractor$createListenerWithCaching$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = this.$fileId;
                CreateCommentInteractor createCommentInteractor = this.this$0;
                Result.Companion companion = Result.INSTANCE;
                ItemId.Remote remote = new ItemId.Remote(str, ItemType.FILE);
                this.L$0 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$1 = SpillingKt.nullOutSpilledVariable(coroutineScope);
                this.L$2 = SpillingKt.nullOutSpilledVariable(remote);
                this.I$0 = 0;
                this.label = 1;
                obj = createCommentInteractor.itemService.updateCacheItemFromRemote(remote, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.m14780constructorimpl((com.box.android.domain.utils.result.Result) obj);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m14780constructorimpl(ResultKt.createFailure(th));
        }
        return Unit.INSTANCE;
    }
}
