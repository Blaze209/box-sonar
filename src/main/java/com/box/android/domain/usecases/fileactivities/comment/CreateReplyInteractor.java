package com.box.android.domain.usecases.fileactivities.comment;

import com.box.android.domain.services.ICommentService;
import com.box.android.domain.services.IdMappingService;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CreateReplyInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/usecases/fileactivities/comment/CreateReplyInteractor;", "", "commentService", "Lcom/box/android/domain/services/ICommentService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/domain/services/ICommentService;Lcom/box/android/domain/services/IdMappingService;)V", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/annotations/FileActivityModel$CommentModel;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "parentIdModel", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "message", "", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/models/annotations/FileActivityIdModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateReplyInteractor {
    private final ICommentService commentService;
    private final IdMappingService idMappingService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.fileactivities.comment.CreateReplyInteractor$create$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateReplyInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.fileactivities.comment.CreateReplyInteractor", f = "CreateReplyInteractor.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {21, 22}, m = PasskeyWebListener.CREATE_UNIQUE_KEY, n = {"itemId", "parentIdModel", "message", "itemId", "parentIdModel", "message", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-CreateReplyInteractor$create$2"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateReplyInteractor.this.create(null, null, null, this);
        }
    }

    @Inject
    public CreateReplyInteractor(ICommentService commentService, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(commentService, "commentService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.commentService = commentService;
        this.idMappingService = idMappingService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b5, code lost:
    
        if (r9 == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object create(com.box.android.domain.models.ItemId r6, com.box.android.domain.models.annotations.FileActivityIdModel r7, java.lang.String r8, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.annotations.FileActivityModel.CommentModel, ? extends com.box.android.domain.models.DomainError>> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.box.android.domain.usecases.fileactivities.comment.CreateReplyInteractor.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            com.box.android.domain.usecases.fileactivities.comment.CreateReplyInteractor$create$1 r0 = (com.box.android.domain.usecases.fileactivities.comment.CreateReplyInteractor.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.box.android.domain.usecases.fileactivities.comment.CreateReplyInteractor$create$1 r0 = new com.box.android.domain.usecases.fileactivities.comment.CreateReplyInteractor$create$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5f
            if (r2 == r4) goto L4d
            if (r2 != r3) goto L45
            int r5 = r0.I$1
            int r5 = r0.I$0
            java.lang.Object r5 = r0.L$4
            com.box.android.domain.models.ItemId$Remote r5 = (com.box.android.domain.models.ItemId.Remote) r5
            java.lang.Object r5 = r0.L$3
            com.box.android.domain.utils.result.Result r5 = (com.box.android.domain.utils.result.Result) r5
            java.lang.Object r5 = r0.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r0.L$1
            com.box.android.domain.models.annotations.FileActivityIdModel r5 = (com.box.android.domain.models.annotations.FileActivityIdModel) r5
            java.lang.Object r5 = r0.L$0
            com.box.android.domain.models.ItemId r5 = (com.box.android.domain.models.ItemId) r5
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lb8
        L45:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L4d:
            java.lang.Object r6 = r0.L$2
            r8 = r6
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r6 = r0.L$1
            r7 = r6
            com.box.android.domain.models.annotations.FileActivityIdModel r7 = (com.box.android.domain.models.annotations.FileActivityIdModel) r7
            java.lang.Object r6 = r0.L$0
            com.box.android.domain.models.ItemId r6 = (com.box.android.domain.models.ItemId) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L77
        L5f:
            kotlin.ResultKt.throwOnFailure(r9)
            com.box.android.domain.services.IdMappingService r9 = r5.idMappingService
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r2
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r4
            java.lang.Object r9 = r9.getRemoteIdOrError(r6, r0)
            if (r9 != r1) goto L77
            goto Lb7
        L77:
            com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
            boolean r2 = r9 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto Lbb
            r2 = r9
            com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
            java.lang.Object r2 = r2.getValue()
            com.box.android.domain.models.ItemId$Remote r2 = (com.box.android.domain.models.ItemId.Remote) r2
            com.box.android.domain.services.ICommentService r5 = r5.commentService
            java.lang.String r4 = r2.getBoxId()
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
            r0.L$0 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$1 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$2 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$3 = r6
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$4 = r6
            r6 = 0
            r0.I$0 = r6
            r0.I$1 = r6
            r0.label = r3
            java.lang.Object r9 = r5.createReply(r4, r7, r8, r0)
            if (r9 != r1) goto Lb8
        Lb7:
            return r1
        Lb8:
            com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
            return r9
        Lbb:
            boolean r5 = r9 instanceof com.box.android.domain.utils.result.Result.Error
            if (r5 == 0) goto Lc0
            return r9
        Lc0:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.fileactivities.comment.CreateReplyInteractor.create(com.box.android.domain.models.ItemId, com.box.android.domain.models.annotations.FileActivityIdModel, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
