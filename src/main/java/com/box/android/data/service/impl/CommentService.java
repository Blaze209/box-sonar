package com.box.android.data.service.impl;

import com.box.android.data.api.models.annotations.CommentDTO;
import com.box.android.data.api.models.annotations.CommentSourceDTO;
import com.box.android.data.api.models.annotations.FileActivityDTO;
import com.box.android.data.api.models.annotations.Status;
import com.box.android.data.datasource.annotations.FileActivityCacheDataSource;
import com.box.android.data.datasource.comment.CommentCacheDataSource;
import com.box.android.data.datasource.comment.CommentRemoteDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.mappers.annotation.CommentDTODomainMapper;
import com.box.android.data.mappers.annotation.CommentDTOEntityMapper;
import com.box.android.data.mappers.annotation.FileActivityDTOEntityMapper;
import com.box.android.data.persistence.annotations.CommentEntity;
import com.box.android.data.persistence.annotations.FileActivityEntity;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.annotations.CommentContent;
import com.box.android.domain.models.annotations.FileActivityIdModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.services.ICommentService;
import com.box.android.domain.utils.result.Result;
import external.sdk.pendo.io.mozilla.javascript.Token;
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

/* JADX INFO: compiled from: CommentService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u0017J*\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ2\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010\u001fJ>\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010!\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010$J\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010!\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010'J2\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010)J\"\u0010*\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010!\u001a\u00020\u0015H\u0096@¢\u0006\u0002\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/box/android/data/service/impl/CommentService;", "Lcom/box/android/domain/services/ICommentService;", "commentRemoteDataSource", "Lcom/box/android/data/datasource/comment/CommentRemoteDataSource;", "commentCacheDataSource", "Lcom/box/android/data/datasource/comment/CommentCacheDataSource;", "commentDTOEntityMapper", "Lcom/box/android/data/mappers/annotation/CommentDTOEntityMapper;", "commentDTODomainMapper", "Lcom/box/android/data/mappers/annotation/CommentDTODomainMapper;", "fileActivityDTOEntityMapper", "Lcom/box/android/data/mappers/annotation/FileActivityDTOEntityMapper;", "fileActivitiesCacheDataSource", "Lcom/box/android/data/datasource/annotations/FileActivityCacheDataSource;", "<init>", "(Lcom/box/android/data/datasource/comment/CommentRemoteDataSource;Lcom/box/android/data/datasource/comment/CommentCacheDataSource;Lcom/box/android/data/mappers/annotation/CommentDTOEntityMapper;Lcom/box/android/data/mappers/annotation/CommentDTODomainMapper;Lcom/box/android/data/mappers/annotation/FileActivityDTOEntityMapper;Lcom/box/android/data/datasource/annotations/FileActivityCacheDataSource;)V", "createComment", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/annotations/FileActivityModel$CommentModel;", "Lcom/box/android/domain/models/DomainError;", "fileId", "", "message", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCommentV2", "content", "Lcom/box/android/domain/models/annotations/CommentContent;", "(Ljava/lang/String;Lcom/box/android/domain/models/annotations/CommentContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createReply", "parentIdModel", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "(Ljava/lang/String;Lcom/box/android/domain/models/annotations/FileActivityIdModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateComment", "commentId", "status", "Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/annotations/FileActivityModel$Status;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteComment", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCommentV2", "(Ljava/lang/String;Lcom/box/android/domain/models/annotations/CommentContent;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCommentV2", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommentService implements ICommentService {
    private final CommentCacheDataSource commentCacheDataSource;
    private final CommentDTODomainMapper commentDTODomainMapper;
    private final CommentDTOEntityMapper commentDTOEntityMapper;
    private final CommentRemoteDataSource commentRemoteDataSource;
    private final FileActivityCacheDataSource fileActivitiesCacheDataSource;
    private final FileActivityDTOEntityMapper fileActivityDTOEntityMapper;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CommentService$createComment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommentService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CommentService", f = "CommentService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {49, 63}, m = "createComment", n = {"fileId", "message", "fileId", "message", "$this$map$iv", "it", "fileActivityDTO", "fileActivityEntity", "commentEntity", "$i$f$map", "$i$a$-map-CommentService$createComment$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentService.this.createComment(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CommentService$createCommentV2$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CommentService", f = "CommentService.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {74, 88}, m = "createCommentV2", n = {"fileId", "content", "fileId", "content", "$this$map$iv", "it", "fileActivityDTO", "fileActivityEntity", "commentEntity", "$i$f$map", "$i$a$-map-CommentService$createCommentV2$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class C14111 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C14111(Continuation<? super C14111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentService.this.createCommentV2(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CommentService$createReply$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CommentService", f = "CommentService.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {102, 108}, m = "createReply", n = {"fileId", "parentIdModel", "message", "fileId", "parentIdModel", "message", "$this$map$iv", "it", "commentEntity", "$i$f$map", "$i$a$-map-CommentService$createReply$2"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class C14121 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C14121(Continuation<? super C14121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentService.this.createReply(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CommentService$deleteComment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CommentService", f = "CommentService.kt", i = {0, 1, 1, 1, 1, 1}, l = {139, Token.SETELEM_OP}, m = "deleteComment", n = {"commentId", "commentId", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-CommentService$deleteComment$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C14131 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C14131(Continuation<? super C14131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentService.this.deleteComment(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CommentService$deleteCommentV2$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CommentService", f = "CommentService.kt", i = {0, 1, 1, 1, 1, 1}, l = {169, 171}, m = "deleteCommentV2", n = {"commentId", "commentId", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-CommentService$deleteCommentV2$2"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C14141 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C14141(Continuation<? super C14141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentService.this.deleteCommentV2(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CommentService$updateComment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CommentService", f = "CommentService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {122, 129}, m = "updateComment", n = {"commentId", "message", "status", "fileId", "commentId", "message", "status", "fileId", "$this$map$iv", "it", "commentEntity", "$i$f$map", "$i$a$-map-CommentService$updateComment$3"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1"}, v = 1)
    static final class C14151 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C14151(Continuation<? super C14151> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentService.this.updateComment(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.CommentService$updateCommentV2$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.CommentService", f = "CommentService.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {Token.SET, Token.LETEXPR}, m = "updateCommentV2", n = {"commentId", "content", "fileId", "commentId", "content", "fileId", "$this$map$iv", "it", "commentEntity", "$i$f$map", "$i$a$-map-CommentService$updateCommentV2$2"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class C14161 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C14161(Continuation<? super C14161> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentService.this.updateCommentV2(null, null, null, this);
        }
    }

    @Inject
    public CommentService(CommentRemoteDataSource commentRemoteDataSource, CommentCacheDataSource commentCacheDataSource, CommentDTOEntityMapper commentDTOEntityMapper, CommentDTODomainMapper commentDTODomainMapper, FileActivityDTOEntityMapper fileActivityDTOEntityMapper, FileActivityCacheDataSource fileActivitiesCacheDataSource) {
        Intrinsics.checkNotNullParameter(commentRemoteDataSource, "commentRemoteDataSource");
        Intrinsics.checkNotNullParameter(commentCacheDataSource, "commentCacheDataSource");
        Intrinsics.checkNotNullParameter(commentDTOEntityMapper, "commentDTOEntityMapper");
        Intrinsics.checkNotNullParameter(commentDTODomainMapper, "commentDTODomainMapper");
        Intrinsics.checkNotNullParameter(fileActivityDTOEntityMapper, "fileActivityDTOEntityMapper");
        Intrinsics.checkNotNullParameter(fileActivitiesCacheDataSource, "fileActivitiesCacheDataSource");
        this.commentRemoteDataSource = commentRemoteDataSource;
        this.commentCacheDataSource = commentCacheDataSource;
        this.commentDTOEntityMapper = commentDTOEntityMapper;
        this.commentDTODomainMapper = commentDTODomainMapper;
        this.fileActivityDTOEntityMapper = fileActivityDTOEntityMapper;
        this.fileActivitiesCacheDataSource = fileActivitiesCacheDataSource;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00f2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:33:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:35:0x011e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ICommentService
    public Object createComment(String str, String str2, Continuation<? super Result<FileActivityModel.CommentModel, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Success success;
        String str3;
        CommentDTO commentDTO;
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
        Object objCreateComment = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCreateComment);
            CommentRemoteDataSource commentRemoteDataSource = this.commentRemoteDataSource;
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.label = 1;
            objCreateComment = commentRemoteDataSource.createComment(str, str2, anonymousClass1);
            if (objCreateComment != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            str2 = (String) anonymousClass1.L$1;
            str = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objCreateComment);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$1;
            int i3 = anonymousClass1.I$0;
            commentDTO = (CommentDTO) anonymousClass1.L$3;
            str3 = (String) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objCreateComment);
        }
        success = new Result.Success(this.commentDTODomainMapper.toDomain(commentDTO));
        str = str3;
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Unknown error while posting comment for file " + str));
        success = (Result) objCreateComment;
        if (success instanceof Result.Success) {
            CommentDTO commentDTO2 = (CommentDTO) ((Result.Success) success).getValue();
            this.fileActivitiesCacheDataSource.incrementOrderNumber(str);
            FileActivityDTO.CommentActivityDTO commentActivityDTO = new FileActivityDTO.CommentActivityDTO(new CommentSourceDTO(commentDTO2));
            FileActivityEntity entity = this.fileActivityDTOEntityMapper.toEntity(commentActivityDTO, str, 0);
            CommentEntity entity2 = this.commentDTOEntityMapper.toEntity(commentDTO2, str);
            CommentCacheDataSource commentCacheDataSource = this.commentCacheDataSource;
            anonymousClass1.L$0 = str;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(success);
            anonymousClass1.L$3 = commentDTO2;
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(commentActivityDTO);
            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(entity);
            anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(entity2);
            anonymousClass1.I$0 = 0;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 2;
            if (commentCacheDataSource.saveComment(entity, entity2, anonymousClass1) != coroutine_suspended) {
                str3 = str;
                commentDTO = commentDTO2;
                success = new Result.Success(this.commentDTODomainMapper.toDomain(commentDTO));
                str = str3;
            }
            return coroutine_suspended;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Unknown error while posting comment for file " + str));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00f2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:33:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:35:0x011e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ICommentService
    public Object createCommentV2(String str, CommentContent commentContent, Continuation<? super Result<FileActivityModel.CommentModel, ? extends DomainError>> continuation) {
        C14111 c14111;
        Result.Success success;
        String str2;
        CommentDTO commentDTO;
        if (continuation instanceof C14111) {
            c14111 = (C14111) continuation;
            if ((c14111.label & Integer.MIN_VALUE) != 0) {
                c14111.label -= Integer.MIN_VALUE;
            } else {
                c14111 = new C14111(continuation);
            }
        } else {
            c14111 = new C14111(continuation);
        }
        Object objCreateCommentV2 = c14111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14111.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCreateCommentV2);
            CommentRemoteDataSource commentRemoteDataSource = this.commentRemoteDataSource;
            c14111.L$0 = str;
            c14111.L$1 = SpillingKt.nullOutSpilledVariable(commentContent);
            c14111.label = 1;
            objCreateCommentV2 = commentRemoteDataSource.createCommentV2(str, commentContent, c14111);
            if (objCreateCommentV2 != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            commentContent = (CommentContent) c14111.L$1;
            str = (String) c14111.L$0;
            ResultKt.throwOnFailure(objCreateCommentV2);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c14111.I$1;
            int i3 = c14111.I$0;
            commentDTO = (CommentDTO) c14111.L$3;
            str2 = (String) c14111.L$0;
            ResultKt.throwOnFailure(objCreateCommentV2);
        }
        success = new Result.Success(this.commentDTODomainMapper.toDomain(commentDTO));
        str = str2;
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Unknown error while posting comment for file " + str));
        success = (Result) objCreateCommentV2;
        if (success instanceof Result.Success) {
            CommentDTO commentDTO2 = (CommentDTO) ((Result.Success) success).getValue();
            this.fileActivitiesCacheDataSource.incrementOrderNumber(str);
            FileActivityDTO.CommentActivityDTO commentActivityDTO = new FileActivityDTO.CommentActivityDTO(new CommentSourceDTO(commentDTO2));
            FileActivityEntity entity = this.fileActivityDTOEntityMapper.toEntity(commentActivityDTO, str, 0);
            CommentEntity entity2 = this.commentDTOEntityMapper.toEntity(commentDTO2, str);
            CommentCacheDataSource commentCacheDataSource = this.commentCacheDataSource;
            c14111.L$0 = str;
            c14111.L$1 = SpillingKt.nullOutSpilledVariable(commentContent);
            c14111.L$2 = SpillingKt.nullOutSpilledVariable(success);
            c14111.L$3 = commentDTO2;
            c14111.L$4 = SpillingKt.nullOutSpilledVariable(commentActivityDTO);
            c14111.L$5 = SpillingKt.nullOutSpilledVariable(entity);
            c14111.L$6 = SpillingKt.nullOutSpilledVariable(entity2);
            c14111.I$0 = 0;
            c14111.I$1 = 0;
            c14111.label = 2;
            if (commentCacheDataSource.saveComment(entity, entity2, c14111) != coroutine_suspended) {
                str2 = str;
                commentDTO = commentDTO2;
                success = new Result.Success(this.commentDTODomainMapper.toDomain(commentDTO));
                str = str2;
            }
            return coroutine_suspended;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Unknown error while posting comment for file " + str));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00db A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:35:0x0107  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ICommentService
    public Object createReply(String str, FileActivityIdModel fileActivityIdModel, String str2, Continuation<? super Result<FileActivityModel.CommentModel, ? extends DomainError>> continuation) {
        C14121 c14121;
        Result.Success success;
        String str3;
        CommentDTO commentDTO;
        if (continuation instanceof C14121) {
            c14121 = (C14121) continuation;
            if ((c14121.label & Integer.MIN_VALUE) != 0) {
                c14121.label -= Integer.MIN_VALUE;
            } else {
                c14121 = new C14121(continuation);
            }
        } else {
            c14121 = new C14121(continuation);
        }
        Object objCreateReply = c14121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14121.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCreateReply);
            CommentRemoteDataSource commentRemoteDataSource = this.commentRemoteDataSource;
            c14121.L$0 = str;
            c14121.L$1 = SpillingKt.nullOutSpilledVariable(fileActivityIdModel);
            c14121.L$2 = SpillingKt.nullOutSpilledVariable(str2);
            c14121.label = 1;
            objCreateReply = commentRemoteDataSource.createReply(fileActivityIdModel, str, str2, c14121);
            if (objCreateReply != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            str2 = (String) c14121.L$2;
            fileActivityIdModel = (FileActivityIdModel) c14121.L$1;
            str = (String) c14121.L$0;
            ResultKt.throwOnFailure(objCreateReply);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c14121.I$1;
            int i3 = c14121.I$0;
            commentDTO = (CommentDTO) c14121.L$4;
            str3 = (String) c14121.L$0;
            ResultKt.throwOnFailure(objCreateReply);
        }
        success = new Result.Success(this.commentDTODomainMapper.toDomain(commentDTO));
        str = str3;
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Unknown error while posting comment for file " + str));
        success = (Result) objCreateReply;
        if (success instanceof Result.Success) {
            CommentDTO commentDTO2 = (CommentDTO) ((Result.Success) success).getValue();
            CommentEntity entity = this.commentDTOEntityMapper.toEntity(commentDTO2, str);
            CommentCacheDataSource commentCacheDataSource = this.commentCacheDataSource;
            c14121.L$0 = str;
            c14121.L$1 = SpillingKt.nullOutSpilledVariable(fileActivityIdModel);
            c14121.L$2 = SpillingKt.nullOutSpilledVariable(str2);
            c14121.L$3 = SpillingKt.nullOutSpilledVariable(success);
            c14121.L$4 = commentDTO2;
            c14121.L$5 = SpillingKt.nullOutSpilledVariable(entity);
            c14121.I$0 = 0;
            c14121.I$1 = 0;
            c14121.label = 2;
            if (commentCacheDataSource.saveReply(entity, c14121) != coroutine_suspended) {
                str3 = str;
                commentDTO = commentDTO2;
                success = new Result.Success(this.commentDTODomainMapper.toDomain(commentDTO));
                str = str3;
            }
            return coroutine_suspended;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Unknown error while posting comment for file " + str));
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00f8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:37:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:39:0x0124  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ICommentService
    public Object updateComment(String str, String str2, FileActivityModel.Status status, String str3, Continuation<? super Result<FileActivityModel.CommentModel, ? extends DomainError>> continuation) {
        C14151 c14151;
        Result.Success success;
        String str4;
        CommentDTO commentDTO;
        if (continuation instanceof C14151) {
            c14151 = (C14151) continuation;
            if ((c14151.label & Integer.MIN_VALUE) != 0) {
                c14151.label -= Integer.MIN_VALUE;
            } else {
                c14151 = new C14151(continuation);
            }
        } else {
            c14151 = new C14151(continuation);
        }
        Object objUpdateComment = c14151.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14151.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUpdateComment);
            CommentRemoteDataSource commentRemoteDataSource = this.commentRemoteDataSource;
            Status statusValueOf = status != null ? Status.valueOf(status.toString()) : null;
            c14151.L$0 = str;
            c14151.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c14151.L$2 = SpillingKt.nullOutSpilledVariable(status);
            c14151.L$3 = str3;
            c14151.label = 1;
            objUpdateComment = commentRemoteDataSource.updateComment(str, str2, statusValueOf, c14151);
            if (objUpdateComment != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            str3 = (String) c14151.L$3;
            status = (FileActivityModel.Status) c14151.L$2;
            str2 = (String) c14151.L$1;
            str = (String) c14151.L$0;
            ResultKt.throwOnFailure(objUpdateComment);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c14151.I$1;
            int i3 = c14151.I$0;
            commentDTO = (CommentDTO) c14151.L$5;
            str4 = (String) c14151.L$0;
            ResultKt.throwOnFailure(objUpdateComment);
        }
        success = new Result.Success(this.commentDTODomainMapper.toDomain(commentDTO));
        str = str4;
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Unknown error while updating comment " + str));
        success = (Result) objUpdateComment;
        if (success instanceof Result.Success) {
            CommentDTO commentDTO2 = (CommentDTO) ((Result.Success) success).getValue();
            CommentEntity entity = this.commentDTOEntityMapper.toEntity(commentDTO2, str3);
            CommentCacheDataSource commentCacheDataSource = this.commentCacheDataSource;
            c14151.L$0 = str;
            c14151.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            c14151.L$2 = SpillingKt.nullOutSpilledVariable(status);
            c14151.L$3 = SpillingKt.nullOutSpilledVariable(str3);
            c14151.L$4 = SpillingKt.nullOutSpilledVariable(success);
            c14151.L$5 = commentDTO2;
            c14151.L$6 = SpillingKt.nullOutSpilledVariable(entity);
            c14151.I$0 = 0;
            c14151.I$1 = 0;
            c14151.label = 2;
            if (commentCacheDataSource.updateComment(entity, c14151) != coroutine_suspended) {
                str4 = str;
                commentDTO = commentDTO2;
                success = new Result.Success(this.commentDTODomainMapper.toDomain(commentDTO));
                str = str4;
            }
            return coroutine_suspended;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Unknown error while updating comment " + str));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0091 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x0092  */
    /* JADX WARN: Code duplicated, block: B:33:0x0096  */
    /* JADX WARN: Code duplicated, block: B:35:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ICommentService
    public Object deleteComment(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C14131 c14131;
        Result result;
        Result result2;
        if (continuation instanceof C14131) {
            c14131 = (C14131) continuation;
            if ((c14131.label & Integer.MIN_VALUE) != 0) {
                c14131.label -= Integer.MIN_VALUE;
            } else {
                c14131 = new C14131(continuation);
            }
        } else {
            c14131 = new C14131(continuation);
        }
        Object objDeleteComment = c14131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14131.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeleteComment);
            CommentRemoteDataSource commentRemoteDataSource = this.commentRemoteDataSource;
            c14131.L$0 = str;
            c14131.label = 1;
            objDeleteComment = commentRemoteDataSource.deleteComment(str, c14131);
            if (objDeleteComment != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            str = (String) c14131.L$0;
            ResultKt.throwOnFailure(objDeleteComment);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c14131.I$1;
            int i3 = c14131.I$0;
            result2 = (Result) c14131.L$1;
            str = (String) c14131.L$0;
            ResultKt.throwOnFailure(objDeleteComment);
        }
        result = result2;
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) result).getValue(), "Unknown error while deleting comment " + str));
        result = (Result) objDeleteComment;
        if (result instanceof Result.Success) {
            Unit unit = (Unit) ((Result.Success) result).getValue();
            CommentCacheDataSource commentCacheDataSource = this.commentCacheDataSource;
            c14131.L$0 = str;
            c14131.L$1 = result;
            c14131.L$2 = SpillingKt.nullOutSpilledVariable(unit);
            c14131.I$0 = 0;
            c14131.I$1 = 0;
            c14131.label = 2;
            if (commentCacheDataSource.deleteComment(str, c14131) != coroutine_suspended) {
                result2 = result;
                result = result2;
            }
            return coroutine_suspended;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) result).getValue(), "Unknown error while deleting comment " + str));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00d7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:33:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:35:0x0109  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ICommentService
    public Object updateCommentV2(String str, CommentContent commentContent, String str2, Continuation<? super Result<FileActivityModel.CommentModel, ? extends DomainError>> continuation) {
        C14161 c14161;
        Result.Success success;
        String str3;
        CommentDTO commentDTO;
        if (continuation instanceof C14161) {
            c14161 = (C14161) continuation;
            if ((c14161.label & Integer.MIN_VALUE) != 0) {
                c14161.label -= Integer.MIN_VALUE;
            } else {
                c14161 = new C14161(continuation);
            }
        } else {
            c14161 = new C14161(continuation);
        }
        Object objUpdateCommentV2 = c14161.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14161.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUpdateCommentV2);
            CommentRemoteDataSource commentRemoteDataSource = this.commentRemoteDataSource;
            c14161.L$0 = str;
            c14161.L$1 = SpillingKt.nullOutSpilledVariable(commentContent);
            c14161.L$2 = str2;
            c14161.label = 1;
            objUpdateCommentV2 = commentRemoteDataSource.updateCommentV2(str, commentContent, c14161);
            if (objUpdateCommentV2 != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            str2 = (String) c14161.L$2;
            commentContent = (CommentContent) c14161.L$1;
            str = (String) c14161.L$0;
            ResultKt.throwOnFailure(objUpdateCommentV2);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c14161.I$1;
            int i3 = c14161.I$0;
            commentDTO = (CommentDTO) c14161.L$4;
            str3 = (String) c14161.L$0;
            ResultKt.throwOnFailure(objUpdateCommentV2);
        }
        success = new Result.Success(this.commentDTODomainMapper.toDomain(commentDTO));
        str = str3;
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Unknown error while updating comment " + str + " using V2 API"));
        success = (Result) objUpdateCommentV2;
        if (success instanceof Result.Success) {
            CommentDTO commentDTO2 = (CommentDTO) ((Result.Success) success).getValue();
            CommentEntity entity = this.commentDTOEntityMapper.toEntity(commentDTO2, str2);
            CommentCacheDataSource commentCacheDataSource = this.commentCacheDataSource;
            c14161.L$0 = str;
            c14161.L$1 = SpillingKt.nullOutSpilledVariable(commentContent);
            c14161.L$2 = SpillingKt.nullOutSpilledVariable(str2);
            c14161.L$3 = SpillingKt.nullOutSpilledVariable(success);
            c14161.L$4 = commentDTO2;
            c14161.L$5 = SpillingKt.nullOutSpilledVariable(entity);
            c14161.I$0 = 0;
            c14161.I$1 = 0;
            c14161.label = 2;
            if (commentCacheDataSource.updateComment(entity, c14161) != coroutine_suspended) {
                str3 = str;
                commentDTO = commentDTO2;
                success = new Result.Success(this.commentDTODomainMapper.toDomain(commentDTO));
                str = str3;
            }
            return coroutine_suspended;
        }
        if (!(success instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (success instanceof Result.Success) {
            return success;
        }
        if (success instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) success).getValue(), "Unknown error while updating comment " + str + " using V2 API"));
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0091 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:31:0x0092  */
    /* JADX WARN: Code duplicated, block: B:33:0x0096  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.ICommentService
    public Object deleteCommentV2(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        C14141 c14141;
        Result result;
        Result result2;
        if (continuation instanceof C14141) {
            c14141 = (C14141) continuation;
            if ((c14141.label & Integer.MIN_VALUE) != 0) {
                c14141.label -= Integer.MIN_VALUE;
            } else {
                c14141 = new C14141(continuation);
            }
        } else {
            c14141 = new C14141(continuation);
        }
        Object objDeleteCommentV2 = c14141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c14141.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeleteCommentV2);
            CommentRemoteDataSource commentRemoteDataSource = this.commentRemoteDataSource;
            c14141.L$0 = str;
            c14141.label = 1;
            objDeleteCommentV2 = commentRemoteDataSource.deleteCommentV2(str, c14141);
            if (objDeleteCommentV2 != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            str = (String) c14141.L$0;
            ResultKt.throwOnFailure(objDeleteCommentV2);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c14141.I$1;
            int i3 = c14141.I$0;
            result2 = (Result) c14141.L$1;
            str = (String) c14141.L$0;
            ResultKt.throwOnFailure(objDeleteCommentV2);
        }
        result = result2;
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) result).getValue(), "Unknown error while deleting comment " + str + " using V2 API"));
        result = (Result) objDeleteCommentV2;
        if (result instanceof Result.Success) {
            Unit unit = (Unit) ((Result.Success) result).getValue();
            CommentCacheDataSource commentCacheDataSource = this.commentCacheDataSource;
            c14141.L$0 = str;
            c14141.L$1 = result;
            c14141.L$2 = SpillingKt.nullOutSpilledVariable(unit);
            c14141.I$0 = 0;
            c14141.I$1 = 0;
            c14141.label = 2;
            if (commentCacheDataSource.deleteComment(str, c14141) != coroutine_suspended) {
                result2 = result;
                result = result2;
            }
            return coroutine_suspended;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (result instanceof Result.Success) {
            return result;
        }
        if (result instanceof Result.Error) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.INSTANCE.toDomainError((RemoteError) ((Result.Error) result).getValue(), "Unknown error while deleting comment " + str + " using V2 API"));
    }
}
