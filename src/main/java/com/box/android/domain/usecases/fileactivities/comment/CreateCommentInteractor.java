package com.box.android.domain.usecases.fileactivities.comment;

import com.box.android.domain.controller.ICommentsController;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.annotations.CommentContent;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.services.ICommentService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxComment;
import com.box.androidsdk.content.requests.BoxResponse;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: CreateCommentInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@¢\u0006\u0002\u0010\u0018J*\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0086@¢\u0006\u0002\u0010\u001cJ$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!J$\u0010#\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u00172\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!J,\u0010%\u001a\u0010\u0012\f\u0012\n &*\u0004\u0018\u00010\"0\"0!2\u0006\u0010\u001f\u001a\u00020\u00172\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/box/android/domain/usecases/fileactivities/comment/CreateCommentInteractor;", "", "commentService", "Lcom/box/android/domain/services/ICommentService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "commentController", "Lcom/box/android/domain/controller/ICommentsController;", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/services/ICommentService;Lcom/box/android/domain/services/IdMappingService;Lcom/box/android/domain/controller/ICommentsController;Lcom/box/android/domain/services/IRemoteItemService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", PasskeyWebListener.CREATE_UNIQUE_KEY, "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/annotations/FileActivityModel$CommentModel;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "message", "", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createV2", "content", "Lcom/box/android/domain/models/annotations/CommentContent;", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/models/annotations/CommentContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLegacy", "", "fileId", "onCompletedListener", "Lcom/box/androidsdk/content/BoxFutureTask$OnCompletedListener;", "Lcom/box/androidsdk/content/models/BoxComment;", "createLegacyTagged", "taggedMessage", "createListenerWithCaching", "kotlin.jvm.PlatformType", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CreateCommentInteractor {
    private final ICommentsController commentController;
    private final ICommentService commentService;
    private final CoroutineScope coroutineScope;
    private final IdMappingService idMappingService;
    private final IRemoteItemService itemService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.fileactivities.comment.CreateCommentInteractor$create$1, reason: invalid class name */
    /* JADX INFO: compiled from: CreateCommentInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.fileactivities.comment.CreateCommentInteractor", f = "CreateCommentInteractor.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {34, 35, 36}, m = PasskeyWebListener.CREATE_UNIQUE_KEY, n = {"itemId", "message", "itemId", "message", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-CreateCommentInteractor$create$2", "itemId", "message", "$this$flatMap$iv", "it", "$this$onSuccess$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-CreateCommentInteractor$create$2", "$i$f$onSuccess", "$i$a$-onSuccess-CreateCommentInteractor$create$2$1"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateCommentInteractor.this.create(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.fileactivities.comment.CreateCommentInteractor$createV2$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CreateCommentInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.fileactivities.comment.CreateCommentInteractor", f = "CreateCommentInteractor.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {41, 42, 43}, m = "createV2", n = {"itemId", "content", "itemId", "content", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-CreateCommentInteractor$createV2$2", "itemId", "content", "$this$flatMap$iv", "it", "$this$onSuccess$iv", "comment", "$i$f$flatMap", "$i$a$-flatMap-CreateCommentInteractor$createV2$2", "$i$f$onSuccess", "$i$a$-onSuccess-CreateCommentInteractor$createV2$2$1"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class C16331 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C16331(Continuation<? super C16331> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CreateCommentInteractor.this.createV2(null, null, this);
        }
    }

    @Inject
    public CreateCommentInteractor(ICommentService commentService, IdMappingService idMappingService, ICommentsController commentController, IRemoteItemService itemService, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(commentService, "commentService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(commentController, "commentController");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.commentService = commentService;
        this.idMappingService = idMappingService;
        this.commentController = commentController;
        this.itemService = itemService;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(coroutineDispatcher);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:33:0x0110  */
    /* JADX WARN: Code duplicated, block: B:36:0x0115  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object create(ItemId itemId, String str, Continuation<? super Result<FileActivityModel.CommentModel, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        ItemId.Remote remote;
        Result result;
        ItemId itemId2;
        String str2;
        int i;
        int i2;
        Result result2;
        IRemoteItemService iRemoteItemService;
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
        Object remoteIdOrError = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        if (i3 != 0) {
            if (i3 == 1) {
                str = (String) anonymousClass1.L$1;
                itemId = (ItemId) anonymousClass1.L$0;
                ResultKt.throwOnFailure(remoteIdOrError);
            } else {
                if (i3 != 2) {
                    if (i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i4 = anonymousClass1.I$3;
                    int i5 = anonymousClass1.I$2;
                    int i6 = anonymousClass1.I$1;
                    int i7 = anonymousClass1.I$0;
                    Result result3 = (Result) anonymousClass1.L$4;
                    ResultKt.throwOnFailure(remoteIdOrError);
                    return result3;
                }
                i = anonymousClass1.I$1;
                i2 = anonymousClass1.I$0;
                remote = (ItemId.Remote) anonymousClass1.L$3;
                result = (Result) anonymousClass1.L$2;
                str2 = (String) anonymousClass1.L$1;
                itemId2 = (ItemId) anonymousClass1.L$0;
                ResultKt.throwOnFailure(remoteIdOrError);
            }
            result2 = (Result) remoteIdOrError;
            if (result2 instanceof Result.Success) {
                FileActivityModel.CommentModel commentModel = (FileActivityModel.CommentModel) ((Result.Success) result2).getValue();
                iRemoteItemService = this.itemService;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(result);
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(remote);
                anonymousClass1.L$4 = result2;
                anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(commentModel);
                anonymousClass1.I$0 = i2;
                anonymousClass1.I$1 = i;
                anonymousClass1.I$2 = 0;
                anonymousClass1.I$3 = 0;
                anonymousClass1.label = 3;
                if (iRemoteItemService.updateCacheItemFromRemote(itemId2, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (!(result2 instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return result2;
        }
        ResultKt.throwOnFailure(remoteIdOrError);
        IdMappingService idMappingService = this.idMappingService;
        anonymousClass1.L$0 = itemId;
        anonymousClass1.L$1 = str;
        anonymousClass1.label = 1;
        remoteIdOrError = idMappingService.getRemoteIdOrError(itemId, anonymousClass1);
        if (remoteIdOrError != coroutine_suspended) {
        }
        return coroutine_suspended;
        Result result4 = (Result) remoteIdOrError;
        if (result4 instanceof Result.Success) {
            remote = (ItemId.Remote) ((Result.Success) result4).getValue();
            ICommentService iCommentService = this.commentService;
            String boxId = remote.getBoxId();
            anonymousClass1.L$0 = itemId;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(result4);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(remote);
            anonymousClass1.I$0 = 0;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 2;
            Object objCreateComment = iCommentService.createComment(boxId, str, anonymousClass1);
            if (objCreateComment != coroutine_suspended) {
                result = result4;
                remoteIdOrError = objCreateComment;
                itemId2 = itemId;
                str2 = str;
                i = 0;
                i2 = 0;
                result2 = (Result) remoteIdOrError;
                if (result2 instanceof Result.Success) {
                    FileActivityModel.CommentModel commentModel2 = (FileActivityModel.CommentModel) ((Result.Success) result2).getValue();
                    iRemoteItemService = this.itemService;
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(result);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(remote);
                    anonymousClass1.L$4 = result2;
                    anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(commentModel2);
                    anonymousClass1.I$0 = i2;
                    anonymousClass1.I$1 = i;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.I$3 = 0;
                    anonymousClass1.label = 3;
                    if (iRemoteItemService.updateCacheItemFromRemote(itemId2, anonymousClass1) == coroutine_suspended) {
                    }
                } else if (!(result2 instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                return result2;
            }
            return coroutine_suspended;
        }
        if (result4 instanceof Result.Error) {
            return result4;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:33:0x010c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0111  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createV2(ItemId itemId, CommentContent commentContent, Continuation<? super Result<FileActivityModel.CommentModel, ? extends DomainError>> continuation) {
        C16331 c16331;
        ItemId.Remote remote;
        Result result;
        ItemId itemId2;
        CommentContent commentContent2;
        int i;
        int i2;
        Result result2;
        IRemoteItemService iRemoteItemService;
        if (continuation instanceof C16331) {
            c16331 = (C16331) continuation;
            if ((c16331.label & Integer.MIN_VALUE) != 0) {
                c16331.label -= Integer.MIN_VALUE;
            } else {
                c16331 = new C16331(continuation);
            }
        } else {
            c16331 = new C16331(continuation);
        }
        Object remoteIdOrError = c16331.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c16331.label;
        if (i3 != 0) {
            if (i3 == 1) {
                commentContent = (CommentContent) c16331.L$1;
                itemId = (ItemId) c16331.L$0;
                ResultKt.throwOnFailure(remoteIdOrError);
            } else {
                if (i3 != 2) {
                    if (i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    int i4 = c16331.I$3;
                    int i5 = c16331.I$2;
                    int i6 = c16331.I$1;
                    int i7 = c16331.I$0;
                    Result result3 = (Result) c16331.L$4;
                    ResultKt.throwOnFailure(remoteIdOrError);
                    return result3;
                }
                i = c16331.I$1;
                i2 = c16331.I$0;
                remote = (ItemId.Remote) c16331.L$3;
                result = (Result) c16331.L$2;
                commentContent2 = (CommentContent) c16331.L$1;
                itemId2 = (ItemId) c16331.L$0;
                ResultKt.throwOnFailure(remoteIdOrError);
            }
            result2 = (Result) remoteIdOrError;
            if (result2 instanceof Result.Success) {
                FileActivityModel.CommentModel commentModel = (FileActivityModel.CommentModel) ((Result.Success) result2).getValue();
                iRemoteItemService = this.itemService;
                c16331.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                c16331.L$1 = SpillingKt.nullOutSpilledVariable(commentContent2);
                c16331.L$2 = SpillingKt.nullOutSpilledVariable(result);
                c16331.L$3 = SpillingKt.nullOutSpilledVariable(remote);
                c16331.L$4 = result2;
                c16331.L$5 = commentModel;
                c16331.I$0 = i2;
                c16331.I$1 = i;
                c16331.I$2 = 0;
                c16331.I$3 = 0;
                c16331.label = 3;
                if (iRemoteItemService.updateCacheItemFromRemote(itemId2, c16331) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (!(result2 instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            return result2;
        }
        ResultKt.throwOnFailure(remoteIdOrError);
        IdMappingService idMappingService = this.idMappingService;
        c16331.L$0 = itemId;
        c16331.L$1 = commentContent;
        c16331.label = 1;
        remoteIdOrError = idMappingService.getRemoteIdOrError(itemId, c16331);
        if (remoteIdOrError != coroutine_suspended) {
        }
        return coroutine_suspended;
        Result result4 = (Result) remoteIdOrError;
        if (result4 instanceof Result.Success) {
            remote = (ItemId.Remote) ((Result.Success) result4).getValue();
            ICommentService iCommentService = this.commentService;
            String boxId = remote.getBoxId();
            c16331.L$0 = itemId;
            c16331.L$1 = SpillingKt.nullOutSpilledVariable(commentContent);
            c16331.L$2 = SpillingKt.nullOutSpilledVariable(result4);
            c16331.L$3 = SpillingKt.nullOutSpilledVariable(remote);
            c16331.I$0 = 0;
            c16331.I$1 = 0;
            c16331.label = 2;
            Object objCreateCommentV2 = iCommentService.createCommentV2(boxId, commentContent, c16331);
            if (objCreateCommentV2 != coroutine_suspended) {
                result = result4;
                remoteIdOrError = objCreateCommentV2;
                itemId2 = itemId;
                commentContent2 = commentContent;
                i = 0;
                i2 = 0;
                result2 = (Result) remoteIdOrError;
                if (result2 instanceof Result.Success) {
                    FileActivityModel.CommentModel commentModel2 = (FileActivityModel.CommentModel) ((Result.Success) result2).getValue();
                    iRemoteItemService = this.itemService;
                    c16331.L$0 = SpillingKt.nullOutSpilledVariable(itemId2);
                    c16331.L$1 = SpillingKt.nullOutSpilledVariable(commentContent2);
                    c16331.L$2 = SpillingKt.nullOutSpilledVariable(result);
                    c16331.L$3 = SpillingKt.nullOutSpilledVariable(remote);
                    c16331.L$4 = result2;
                    c16331.L$5 = commentModel2;
                    c16331.I$0 = i2;
                    c16331.I$1 = i;
                    c16331.I$2 = 0;
                    c16331.I$3 = 0;
                    c16331.label = 3;
                    if (iRemoteItemService.updateCacheItemFromRemote(itemId2, c16331) == coroutine_suspended) {
                    }
                } else if (!(result2 instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                return result2;
            }
            return coroutine_suspended;
        }
        if (result4 instanceof Result.Error) {
            return result4;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void createLegacy(String fileId, String message, BoxFutureTask.OnCompletedListener<BoxComment> onCompletedListener) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(onCompletedListener, "onCompletedListener");
        this.commentController.addComment(fileId, message, createListenerWithCaching(fileId, onCompletedListener));
    }

    public final void createLegacyTagged(String fileId, String taggedMessage, BoxFutureTask.OnCompletedListener<BoxComment> onCompletedListener) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(taggedMessage, "taggedMessage");
        Intrinsics.checkNotNullParameter(onCompletedListener, "onCompletedListener");
        this.commentController.addTaggedComment(fileId, taggedMessage, createListenerWithCaching(fileId, onCompletedListener));
    }

    private final BoxFutureTask.OnCompletedListener<BoxComment> createListenerWithCaching(final String fileId, final BoxFutureTask.OnCompletedListener<BoxComment> listener) {
        return new BoxFutureTask.OnCompletedListener() { // from class: com.box.android.domain.usecases.fileactivities.comment.CreateCommentInteractor$$ExternalSyntheticLambda0
            @Override // com.box.androidsdk.content.BoxFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                CreateCommentInteractor.createListenerWithCaching$lambda$0(this.f$0, listener, fileId, boxResponse);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createListenerWithCaching$lambda$0(CreateCommentInteractor createCommentInteractor, BoxFutureTask.OnCompletedListener onCompletedListener, String str, BoxResponse boxResponse) {
        if (boxResponse != null && boxResponse.isSuccess()) {
            BuildersKt__Builders_commonKt.launch$default(createCommentInteractor.coroutineScope, null, null, new CreateCommentInteractor$createListenerWithCaching$1$1(str, createCommentInteractor, null), 3, null);
        }
        onCompletedListener.onCompleted(boxResponse);
    }
}
