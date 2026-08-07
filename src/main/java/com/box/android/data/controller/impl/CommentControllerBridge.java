package com.box.android.data.controller.impl;

import com.box.android.domain.controller.ICommentControllerBridge;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.services.IdMappingService;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxIteratorCollaborators;
import com.box.androidsdk.content.requests.BoxResponse;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentControllerBridge.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/data/controller/impl/CommentControllerBridge;", "Lcom/box/android/domain/controller/ICommentControllerBridge;", "legacyCommentsController", "Lcom/box/android/data/controller/impl/LegacyCommentsController;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/data/controller/impl/LegacyCommentsController;Lcom/box/android/domain/services/IdMappingService;)V", "fetchCollaboratorsSync", "Lcom/box/androidsdk/content/requests/BoxResponse;", "Lcom/box/androidsdk/content/models/BoxIteratorCollaborators;", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommentControllerBridge implements ICommentControllerBridge {
    private final IdMappingService idMappingService;
    private final LegacyCommentsController legacyCommentsController;

    /* JADX INFO: renamed from: com.box.android.data.controller.impl.CommentControllerBridge$fetchCollaboratorsSync$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommentControllerBridge.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.controller.impl.CommentControllerBridge", f = "CommentControllerBridge.kt", i = {0, 1, 1}, l = {19, 26}, m = "fetchCollaboratorsSync", n = {"itemId", "itemId", "remoteId"}, s = {"L$0", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentControllerBridge.this.fetchCollaboratorsSync(null, this);
        }
    }

    @Inject
    public CommentControllerBridge(LegacyCommentsController legacyCommentsController, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(legacyCommentsController, "legacyCommentsController");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.legacyCommentsController = legacyCommentsController;
        this.idMappingService = idMappingService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.controller.ICommentControllerBridge
    public Object fetchCollaboratorsSync(ItemId itemId, Continuation<? super BoxResponse<BoxIteratorCollaborators>> continuation) {
        AnonymousClass1 anonymousClass1;
        String boxId;
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
        Object remoteId = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remoteId);
            IdMappingService idMappingService = this.idMappingService;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            anonymousClass1.label = 1;
            remoteId = idMappingService.getRemoteId(itemId, anonymousClass1);
            if (remoteId != coroutine_suspended) {
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(remoteId);
            return remoteId;
        }
        itemId = (ItemId) anonymousClass1.L$0;
        ResultKt.throwOnFailure(remoteId);
        ItemId.Remote remote = (ItemId.Remote) remoteId;
        if (remote == null || (boxId = remote.getBoxId()) == null) {
            return new BoxResponse(null, new NoSuchFieldException(), null);
        }
        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
        anonymousClass1.L$1 = boxId;
        anonymousClass1.label = 2;
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(anonymousClass2));
        final SafeContinuation safeContinuation2 = safeContinuation;
        this.legacyCommentsController.fetchCollaborators(BoxFile.createFromId(boxId), new BoxFutureTask.OnCompletedListener() { // from class: com.box.android.data.controller.impl.CommentControllerBridge$fetchCollaboratorsSync$2$1
            @Override // com.box.androidsdk.content.BoxFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse<BoxIteratorCollaborators> boxResponse) {
                Continuation<BoxResponse<BoxIteratorCollaborators>> continuation2 = safeContinuation2;
                Result.Companion companion = Result.INSTANCE;
                continuation2.resumeWith(Result.m14780constructorimpl(boxResponse));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(anonymousClass2);
        }
        return orThrow == coroutine_suspended ? coroutine_suspended : orThrow;
    }
}
