package com.box.android.domain.usecases.fileactivities.comment;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.services.ICommentService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.result.Result;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteCommentInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/android/domain/usecases/fileactivities/comment/DeleteCommentInteractor;", "", "commentService", "Lcom/box/android/domain/services/ICommentService;", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "<init>", "(Lcom/box/android/domain/services/ICommentService;Lcom/box/android/domain/services/IRemoteItemService;)V", "delete", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "commentId", "", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteV2", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeleteCommentInteractor {
    private final ICommentService commentService;
    private final IRemoteItemService itemService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.fileactivities.comment.DeleteCommentInteractor$delete$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeleteCommentInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.fileactivities.comment.DeleteCommentInteractor", f = "DeleteCommentInteractor.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {16, 17}, m = "delete", n = {"itemId", "commentId", "itemId", "commentId", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-DeleteCommentInteractor$delete$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeleteCommentInteractor.this.delete(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.fileactivities.comment.DeleteCommentInteractor$deleteV2$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeleteCommentInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.fileactivities.comment.DeleteCommentInteractor", f = "DeleteCommentInteractor.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {21, 22}, m = "deleteV2", n = {"itemId", "commentId", "itemId", "commentId", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-DeleteCommentInteractor$deleteV2$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C16341 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C16341(Continuation<? super C16341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeleteCommentInteractor.this.deleteV2(null, null, this);
        }
    }

    @Inject
    public DeleteCommentInteractor(ICommentService commentService, IRemoteItemService itemService) {
        Intrinsics.checkNotNullParameter(commentService, "commentService");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        this.commentService = commentService;
        this.itemService = itemService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object delete(ItemId itemId, String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objDeleteComment = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeleteComment);
            ICommentService iCommentService = this.commentService;
            anonymousClass1.L$0 = itemId;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.label = 1;
            objDeleteComment = iCommentService.deleteComment(str, anonymousClass1);
            if (objDeleteComment != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$1;
            int i3 = anonymousClass1.I$0;
            Result result = (Result) anonymousClass1.L$2;
            ResultKt.throwOnFailure(objDeleteComment);
            return result;
        }
        str = (String) anonymousClass1.L$1;
        itemId = (ItemId) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objDeleteComment);
        Result result2 = (Result) objDeleteComment;
        if (result2 instanceof Result.Success) {
            Unit unit = (Unit) ((Result.Success) result2).getValue();
            IRemoteItemService iRemoteItemService = this.itemService;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$2 = result2;
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(unit);
            anonymousClass1.I$0 = 0;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 2;
            if (iRemoteItemService.updateCacheItemFromRemote(itemId, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (!(result2 instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return result2;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteV2(ItemId itemId, String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C16341 c16341;
        if (continuation instanceof C16341) {
            c16341 = (C16341) continuation;
            if ((c16341.label & Integer.MIN_VALUE) != 0) {
                c16341.label -= Integer.MIN_VALUE;
            } else {
                c16341 = new C16341(continuation);
            }
        } else {
            c16341 = new C16341(continuation);
        }
        Object objDeleteCommentV2 = c16341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c16341.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeleteCommentV2);
            ICommentService iCommentService = this.commentService;
            c16341.L$0 = itemId;
            c16341.L$1 = SpillingKt.nullOutSpilledVariable(str);
            c16341.label = 1;
            objDeleteCommentV2 = iCommentService.deleteCommentV2(str, c16341);
            if (objDeleteCommentV2 != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c16341.I$1;
            int i3 = c16341.I$0;
            Result result = (Result) c16341.L$2;
            ResultKt.throwOnFailure(objDeleteCommentV2);
            return result;
        }
        str = (String) c16341.L$1;
        itemId = (ItemId) c16341.L$0;
        ResultKt.throwOnFailure(objDeleteCommentV2);
        Result result2 = (Result) objDeleteCommentV2;
        if (result2 instanceof Result.Success) {
            Unit unit = (Unit) ((Result.Success) result2).getValue();
            IRemoteItemService iRemoteItemService = this.itemService;
            c16341.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            c16341.L$1 = SpillingKt.nullOutSpilledVariable(str);
            c16341.L$2 = result2;
            c16341.L$3 = SpillingKt.nullOutSpilledVariable(unit);
            c16341.I$0 = 0;
            c16341.I$1 = 0;
            c16341.label = 2;
            if (iRemoteItemService.updateCacheItemFromRemote(itemId, c16341) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (!(result2 instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return result2;
    }
}
