package com.box.android.data.datasource.comment;

import com.box.android.data.api.models.UserMiniDTO;
import com.box.android.data.api.models.annotations.CommentDTO;
import com.box.android.data.api.models.annotations.FileActivityPermissionsDTO;
import com.box.android.data.api.models.annotations.ReferenceDTO;
import com.box.android.data.api.models.annotations.Status;
import com.box.android.data.api.models.comment.CommentV2RequestDTO;
import com.box.android.data.api.models.comment.CommentV2ResponseDTO;
import com.box.android.data.api.models.comment.CreateCommentDTO;
import com.box.android.data.api.models.comment.UpdateCommentDTO;
import com.box.android.data.api.models.items.mini.ItemIdDTO;
import com.box.android.data.api.requests.AnnotationsRequest;
import com.box.android.data.api.requests.CommentRequest;
import com.box.android.data.api.requests.CommentV2Request;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.models.annotations.CommentContent;
import com.box.android.domain.models.annotations.FileActivityType;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.squareup.moshi.Moshi;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Date;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0013J*\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J2\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u001bJ6\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u001d\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0086@¢\u0006\u0002\u0010 J\"\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u001d\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010#J*\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u001d\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010#J\f\u0010&\u001a\u00020\u000e*\u00020'H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/box/android/data/datasource/comment/CommentRemoteDataSource;", "", "annotationRequest", "Lcom/box/android/data/api/requests/AnnotationsRequest;", "commentRequest", "Lcom/box/android/data/api/requests/CommentRequest;", "commentsV2Request", "Lcom/box/android/data/api/requests/CommentV2Request;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/AnnotationsRequest;Lcom/box/android/data/api/requests/CommentRequest;Lcom/box/android/data/api/requests/CommentV2Request;Lcom/squareup/moshi/Moshi;)V", "createComment", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/annotations/CommentDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "fileID", "", "message", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCommentV2", "content", "Lcom/box/android/domain/models/annotations/CommentContent;", "(Ljava/lang/String;Lcom/box/android/domain/models/annotations/CommentContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createReply", "parentActivityIdModel", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "(Lcom/box/android/domain/models/annotations/FileActivityIdModel;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateComment", "commentID", "status", "Lcom/box/android/data/api/models/annotations/Status;", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/annotations/Status;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteComment", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCommentV2", "deleteCommentV2", "toCommentDTO", "Lcom/box/android/data/api/models/comment/CommentV2ResponseDTO;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommentRemoteDataSource {
    private static final String LOGTAG = "CommentRemoteDataSource";
    private final AnnotationsRequest annotationRequest;
    private final CommentRequest commentRequest;
    private final CommentV2Request commentsV2Request;
    private final Moshi moshi;

    /* JADX INFO: compiled from: CommentRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FileActivityType.values().length];
            try {
                iArr[FileActivityType.COMMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FileActivityType.ANNOTATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FileActivityType.VERSIONS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.comment.CommentRemoteDataSource$createComment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommentRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.comment.CommentRemoteDataSource", f = "CommentRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {47}, m = "createComment", n = {"fileID", "message", "$i$f$resultOf", "$i$a$-resultOf-CommentRemoteDataSource$createComment$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
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
            return CommentRemoteDataSource.this.createComment(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.comment.CommentRemoteDataSource$createCommentV2$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.comment.CommentRemoteDataSource", f = "CommentRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {69}, m = "createCommentV2", n = {"fileID", "content", "message", "taggedMessage", "$i$f$resultOf", "$i$a$-resultOf-CommentRemoteDataSource$createCommentV2$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C11371 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C11371(Continuation<? super C11371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentRemoteDataSource.this.createCommentV2(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.comment.CommentRemoteDataSource$createReply$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.comment.CommentRemoteDataSource", f = "CommentRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {86, 92}, m = "createReply", n = {"parentActivityIdModel", "fileID", "message", "$i$f$resultOf", "$i$a$-resultOf-CommentRemoteDataSource$createReply$2", "parentActivityIdModel", "fileID", "message", "$i$f$resultOf", "$i$a$-resultOf-CommentRemoteDataSource$createReply$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C11381 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11381(Continuation<? super C11381> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentRemoteDataSource.this.createReply(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.comment.CommentRemoteDataSource$deleteComment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.comment.CommentRemoteDataSource", f = "CommentRemoteDataSource.kt", i = {0, 0, 0}, l = {Token.LABEL}, m = "deleteComment", n = {"commentID", "$i$f$resultOf", "$i$a$-resultOf-CommentRemoteDataSource$deleteComment$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C11391 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11391(Continuation<? super C11391> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentRemoteDataSource.this.deleteComment(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.comment.CommentRemoteDataSource$deleteCommentV2$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.comment.CommentRemoteDataSource", f = "CommentRemoteDataSource.kt", i = {0, 0, 0}, l = {Token.LAST_TOKEN}, m = "deleteCommentV2", n = {"commentID", "$i$f$resultOf", "$i$a$-resultOf-CommentRemoteDataSource$deleteCommentV2$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C11401 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C11401(Continuation<? super C11401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentRemoteDataSource.this.deleteCommentV2(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.comment.CommentRemoteDataSource$updateComment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.comment.CommentRemoteDataSource", f = "CommentRemoteDataSource.kt", i = {0, 0, 0, 0, 0}, l = {115}, m = "updateComment", n = {"commentID", "message", "status", "$i$f$resultOf", "$i$a$-resultOf-CommentRemoteDataSource$updateComment$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C11411 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11411(Continuation<? super C11411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentRemoteDataSource.this.updateComment(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.comment.CommentRemoteDataSource$updateCommentV2$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.comment.CommentRemoteDataSource", f = "CommentRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {150}, m = "updateCommentV2", n = {"commentID", "content", "message", "taggedMessage", "$i$f$resultOf", "$i$a$-resultOf-CommentRemoteDataSource$updateCommentV2$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C11421 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C11421(Continuation<? super C11421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentRemoteDataSource.this.updateCommentV2(null, null, this);
        }
    }

    @Inject
    public CommentRemoteDataSource(AnnotationsRequest annotationRequest, CommentRequest commentRequest, CommentV2Request commentsV2Request, Moshi moshi) {
        Intrinsics.checkNotNullParameter(annotationRequest, "annotationRequest");
        Intrinsics.checkNotNullParameter(commentRequest, "commentRequest");
        Intrinsics.checkNotNullParameter(commentsV2Request, "commentsV2Request");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.annotationRequest = annotationRequest;
        this.commentRequest = commentRequest;
        this.commentsV2Request = commentsV2Request;
        this.moshi = moshi;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createComment(String str, String str2, Continuation<? super Result<CommentDTO, ? extends RemoteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
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
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateComment);
                CommentRequest commentRequest = this.commentRequest;
                CreateCommentDTO createCommentDTO = new CreateCommentDTO(str2);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                objCreateComment = commentRequest.createComment(str, createCommentDTO, anonymousClass1);
                if (objCreateComment == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(objCreateComment);
            }
            error = new Result.Success((CommentDTO) objCreateComment);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception while creating comment", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createCommentV2(String str, CommentContent commentContent, Continuation<? super Result<CommentDTO, ? extends RemoteError>> continuation) {
        C11371 c11371;
        Result.Error error;
        Pair pair;
        if (continuation instanceof C11371) {
            c11371 = (C11371) continuation;
            if ((c11371.label & Integer.MIN_VALUE) != 0) {
                c11371.label -= Integer.MIN_VALUE;
            } else {
                c11371 = new C11371(continuation);
            }
        } else {
            c11371 = new C11371(continuation);
        }
        C11371 c11372 = c11371;
        Object objCreateComment$default = c11372.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11372.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objCreateComment$default);
                if (commentContent instanceof CommentContent.Message) {
                    pair = TuplesKt.to(((CommentContent.Message) commentContent).getMessage(), null);
                } else {
                    if (!(commentContent instanceof CommentContent.TaggedMessage)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    pair = TuplesKt.to(null, ((CommentContent.TaggedMessage) commentContent).getTaggedMessage());
                }
                String str2 = (String) pair.component1();
                String str3 = (String) pair.component2();
                CommentV2Request commentV2Request = this.commentsV2Request;
                CommentV2RequestDTO commentV2RequestDTO = new CommentV2RequestDTO(str2, str3, new ItemIdDTO(str, ItemType.FILE));
                c11372.L$0 = str;
                c11372.L$1 = SpillingKt.nullOutSpilledVariable(commentContent);
                c11372.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                c11372.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                c11372.I$0 = 0;
                c11372.I$1 = 0;
                c11372.label = 1;
                objCreateComment$default = CommentV2Request.createComment$default(commentV2Request, commentV2RequestDTO, null, c11372, 2, null);
                if (objCreateComment$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11372.I$1;
                int i3 = c11372.I$0;
                str = (String) c11372.L$0;
                ResultKt.throwOnFailure(objCreateComment$default);
            }
            error = new Result.Success((CommentV2ResponseDTO) objCreateComment$default);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            error = new Result.Success(toCommentDTO((CommentV2ResponseDTO) ((Result.Success) error).getValue()));
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception while creating comment (V2, fileId=" + str + ")", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d3, code lost:
    
        if (r10 == r1) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object createReply(com.box.android.domain.models.annotations.FileActivityIdModel r7, java.lang.String r8, java.lang.String r9, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.data.api.models.annotations.CommentDTO, ? extends com.box.android.data.datasource.errors.RemoteError>> r10) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.datasource.comment.CommentRemoteDataSource.createReply(com.box.android.domain.models.annotations.FileActivityIdModel, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateComment(String str, String str2, Status status, Continuation<? super Result<CommentDTO, ? extends RemoteError>> continuation) {
        C11411 c11411;
        Result.Error error;
        if (continuation instanceof C11411) {
            c11411 = (C11411) continuation;
            if ((c11411.label & Integer.MIN_VALUE) != 0) {
                c11411.label -= Integer.MIN_VALUE;
            } else {
                c11411 = new C11411(continuation);
            }
        } else {
            c11411 = new C11411(continuation);
        }
        Object objUpdateComment = c11411.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11411.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objUpdateComment);
                CommentRequest commentRequest = this.commentRequest;
                UpdateCommentDTO updateCommentDTO = new UpdateCommentDTO(str2, status != null ? status.getValue() : null);
                c11411.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11411.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c11411.L$2 = SpillingKt.nullOutSpilledVariable(status);
                c11411.I$0 = 0;
                c11411.I$1 = 0;
                c11411.label = 1;
                objUpdateComment = commentRequest.updateComment(str, updateCommentDTO, c11411);
                if (objUpdateComment == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11411.I$1;
                int i3 = c11411.I$0;
                ResultKt.throwOnFailure(objUpdateComment);
            }
            error = new Result.Success((CommentDTO) objUpdateComment);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception while updating a comment", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteComment(String str, Continuation<? super Result<Unit, ? extends RemoteError>> continuation) {
        C11391 c11391;
        Result.Error error;
        if (continuation instanceof C11391) {
            c11391 = (C11391) continuation;
            if ((c11391.label & Integer.MIN_VALUE) != 0) {
                c11391.label -= Integer.MIN_VALUE;
            } else {
                c11391 = new C11391(continuation);
            }
        } else {
            c11391 = new C11391(continuation);
        }
        Object obj = c11391.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11391.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CommentRequest commentRequest = this.commentRequest;
                c11391.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11391.I$0 = 0;
                c11391.I$1 = 0;
                c11391.label = 1;
                if (commentRequest.deleteComment(str, c11391) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11391.I$1;
                int i3 = c11391.I$0;
                ResultKt.throwOnFailure(obj);
            }
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception while deleting a comment", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:52:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:54:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:56:0x012d  */
    /* JADX WARN: Code duplicated, block: B:58:0x0133  */
    /* JADX WARN: Code duplicated, block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r15v7, types: [java.lang.StringBuilder] */
    public final Object updateCommentV2(String str, CommentContent commentContent, Continuation<? super Result<CommentDTO, ? extends RemoteError>> continuation) {
        C11421 c11421;
        Exception exc;
        ?? r13;
        Result.Error error;
        ?? r14;
        Pair pair;
        if (continuation instanceof C11421) {
            c11421 = (C11421) continuation;
            if ((c11421.label & Integer.MIN_VALUE) != 0) {
                c11421.label -= Integer.MIN_VALUE;
            } else {
                c11421 = new C11421(continuation);
            }
        } else {
            c11421 = new C11421(continuation);
        }
        C11421 c11422 = c11421;
        Object objUpdateComment$default = c11422.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11422.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objUpdateComment$default);
                try {
                    try {
                        if (commentContent instanceof CommentContent.Message) {
                            pair = TuplesKt.to(((CommentContent.Message) commentContent).getMessage(), null);
                        } else {
                            if (!(commentContent instanceof CommentContent.TaggedMessage)) {
                                throw new NoWhenBranchMatchedException();
                            }
                            pair = TuplesKt.to(null, ((CommentContent.TaggedMessage) commentContent).getTaggedMessage());
                        }
                        String str2 = (String) pair.component1();
                        String str3 = (String) pair.component2();
                        CommentV2Request commentV2Request = this.commentsV2Request;
                        CommentV2RequestDTO commentV2RequestDTO = new CommentV2RequestDTO(str2, str3, null, 4, null);
                        c11422.L$0 = str;
                        c11422.L$1 = SpillingKt.nullOutSpilledVariable(commentContent);
                        c11422.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                        c11422.L$3 = SpillingKt.nullOutSpilledVariable(str3);
                        c11422.I$0 = 0;
                        c11422.I$1 = 0;
                        c11422.label = 1;
                        objUpdateComment$default = CommentV2Request.updateComment$default(commentV2Request, str, commentV2RequestDTO, null, c11422, 4, null);
                        if (objUpdateComment$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        str = str;
                    } catch (Exception e) {
                        exc = e;
                        r13 = 1;
                        error = new Result.Error(exc);
                        r14 = r13;
                    }
                } catch (Exception e2) {
                    e = e2;
                    exc = e;
                    r13 = str;
                    error = new Result.Error(exc);
                    r14 = r13;
                    if (error instanceof Result.Success) {
                        error = new Result.Success(toCommentDTO((CommentV2ResponseDTO) ((Result.Success) error).getValue()));
                    } else if (!(error instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (error instanceof Result.Success) {
                        return error;
                    }
                    if (error instanceof Result.Error) {
                        Exception exc2 = (Exception) ((Result.Error) error).getValue();
                        BoxLogUtils.e(LOGTAG, "Exception while updating comment (V2, commentId=" + r14 + ")", exc2);
                        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc2, this.moshi));
                    }
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11422.I$1;
                int i3 = c11422.I$0;
                String str4 = (String) c11422.L$0;
                ResultKt.throwOnFailure(objUpdateComment$default);
                str = str4;
            }
            error = new Result.Success((CommentV2ResponseDTO) objUpdateComment$default);
            r14 = str;
        } catch (Exception e3) {
            e = e3;
        }
        if (error instanceof Result.Success) {
            error = new Result.Success(toCommentDTO((CommentV2ResponseDTO) ((Result.Success) error).getValue()));
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc3 = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception while updating comment (V2, commentId=" + r14 + ")", exc3);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc3, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteCommentV2(String str, Continuation<? super Result<Unit, ? extends RemoteError>> continuation) {
        C11401 c11401;
        Result.Error error;
        if (continuation instanceof C11401) {
            c11401 = (C11401) continuation;
            if ((c11401.label & Integer.MIN_VALUE) != 0) {
                c11401.label -= Integer.MIN_VALUE;
            } else {
                c11401 = new C11401(continuation);
            }
        } else {
            c11401 = new C11401(continuation);
        }
        Object obj = c11401.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11401.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CommentV2Request commentV2Request = this.commentsV2Request;
                c11401.L$0 = str;
                c11401.I$0 = 0;
                c11401.I$1 = 0;
                c11401.label = 1;
                if (commentV2Request.deleteComment(str, c11401) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11401.I$1;
                int i3 = c11401.I$0;
                str = (String) c11401.L$0;
                ResultKt.throwOnFailure(obj);
            }
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            Exception exc = (Exception) ((Result.Error) error).getValue();
            BoxLogUtils.e(LOGTAG, "Exception while deleting comment (V2, commentId=" + str + ")", exc);
            return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException(exc, this.moshi));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final CommentDTO toCommentDTO(CommentV2ResponseDTO commentV2ResponseDTO) {
        String id = commentV2ResponseDTO.getId();
        String type = commentV2ResponseDTO.getType();
        UserMiniDTO createdBy = commentV2ResponseDTO.getCreatedBy();
        Date createdAt = commentV2ResponseDTO.getCreatedAt();
        Date modifiedAt = commentV2ResponseDTO.getModifiedAt();
        String message = commentV2ResponseDTO.getMessage();
        String taggedMessage = commentV2ResponseDTO.getTaggedMessage();
        ItemIdDTO item = commentV2ResponseDTO.getItem();
        return new CommentDTO(id, type, message, null, taggedMessage, 0, createdAt, createdBy, modifiedAt, null, new FileActivityPermissionsDTO(commentV2ResponseDTO.getPermissions().getCanDelete(), commentV2ResponseDTO.getPermissions().getCanEdit(), false, false, commentV2ResponseDTO.getPermissions().getCanReply(), 12, null), item != null ? new ReferenceDTO(item.getId(), item.getType().getValue()) : null, null, 552, null);
    }
}
