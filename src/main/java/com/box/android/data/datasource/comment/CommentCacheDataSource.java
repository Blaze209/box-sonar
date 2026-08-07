package com.box.android.data.datasource.comment;

import com.box.android.data.datasource.CacheError;
import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.annotations.CommentEntity;
import com.box.android.data.persistence.annotations.FileActivityEntity;
import com.box.android.data.persistence.comment.CommentDao;
import com.box.android.data.user.UserData;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
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
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CommentCacheDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ*\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@¢\u0006\u0002\u0010\u0015J\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u0010\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/datasource/comment/CommentCacheDataSource;", "", "userData", "Lcom/box/android/data/user/UserData;", "<init>", "(Lcom/box/android/data/user/UserData;)V", "saveReply", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/datasource/CacheError;", "replyEntity", "Lcom/box/android/data/persistence/annotations/CommentEntity;", "(Lcom/box/android/data/persistence/annotations/CommentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveComment", "fileActivityEntity", "Lcom/box/android/data/persistence/annotations/FileActivityEntity;", "commentEntity", "(Lcom/box/android/data/persistence/annotations/FileActivityEntity;Lcom/box/android/data/persistence/annotations/CommentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteComment", "commentId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateComment", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommentCacheDataSource {
    private static final Companion Companion = new Companion(null);
    private static final String LOGTAG = "CommentCacheDataSource";
    private UserData userData;

    /* JADX INFO: renamed from: com.box.android.data.datasource.comment.CommentCacheDataSource$deleteComment$1, reason: invalid class name */
    /* JADX INFO: compiled from: CommentCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.comment.CommentCacheDataSource", f = "CommentCacheDataSource.kt", i = {0, 0, 0}, l = {80}, m = "deleteComment", n = {"commentId", "databaseResult", "database"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentCacheDataSource.this.deleteComment(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.comment.CommentCacheDataSource$saveComment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.comment.CommentCacheDataSource", f = "CommentCacheDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {59}, m = "saveComment", n = {"fileActivityEntity", "commentEntity", "$this$flatMap$iv", "boxDatabase", "$i$f$flatMap", "$i$a$-flatMap-CommentCacheDataSource$saveComment$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C11341 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C11341(Continuation<? super C11341> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentCacheDataSource.this.saveComment(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.comment.CommentCacheDataSource$saveReply$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.comment.CommentCacheDataSource", f = "CommentCacheDataSource.kt", i = {0, 0, 0}, l = {33}, m = "saveReply", n = {"replyEntity", "databaseResult", "database"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C11351 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11351(Continuation<? super C11351> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentCacheDataSource.this.saveReply(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.comment.CommentCacheDataSource$updateComment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CommentCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.comment.CommentCacheDataSource", f = "CommentCacheDataSource.kt", i = {0, 0, 0}, l = {105}, m = "updateComment", n = {"commentEntity", "databaseResult", "database"}, s = {"L$0", "L$1", "L$2"}, v = 1)
    static final class C11361 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11361(Continuation<? super C11361> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CommentCacheDataSource.this.updateComment(null, this);
        }
    }

    @Inject
    public CommentCacheDataSource(UserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        this.userData = userData;
    }

    /* JADX INFO: compiled from: CommentCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/datasource/comment/CommentCacheDataSource$Companion;", "", "<init>", "()V", "LOGTAG", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object saveReply(CommentEntity commentEntity, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C11351 c11351;
        if (continuation instanceof C11351) {
            c11351 = (C11351) continuation;
            if ((c11351.label & Integer.MIN_VALUE) != 0) {
                c11351.label -= Integer.MIN_VALUE;
            } else {
                c11351 = new C11351(continuation);
            }
        } else {
            c11351 = new C11351(continuation);
        }
        Object obj = c11351.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11351.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    CommentDao commentDao = boxDatabase2.commentDao();
                    c11351.L$0 = SpillingKt.nullOutSpilledVariable(commentEntity);
                    c11351.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11351.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11351.label = 1;
                    if (commentDao.insertComment(commentEntity, c11351) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(LOGTAG, "Error saving reply to cache " + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(((Result.Error) boxDatabase).getValue());
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Result.Success(Unit.INSTANCE);
        } catch (Exception unused) {
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object saveComment(FileActivityEntity fileActivityEntity, CommentEntity commentEntity, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C11341 c11341;
        Result.Error error;
        if (continuation instanceof C11341) {
            c11341 = (C11341) continuation;
            if ((c11341.label & Integer.MIN_VALUE) != 0) {
                c11341.label -= Integer.MIN_VALUE;
            } else {
                c11341 = new C11341(continuation);
            }
        } else {
            c11341 = new C11341(continuation);
        }
        Object obj = c11341.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11341.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    CommentCacheDataSource$saveComment$2$1 commentCacheDataSource$saveComment$2$1 = new CommentCacheDataSource$saveComment$2$1(boxDatabase, fileActivityEntity, commentEntity, null);
                    c11341.L$0 = SpillingKt.nullOutSpilledVariable(fileActivityEntity);
                    c11341.L$1 = SpillingKt.nullOutSpilledVariable(commentEntity);
                    c11341.L$2 = SpillingKt.nullOutSpilledVariable(error);
                    c11341.L$3 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11341.I$0 = 0;
                    c11341.I$1 = 0;
                    c11341.label = 1;
                    if (boxDatabase.withTransactionWrapper(commentCacheDataSource$saveComment$2$1, c11341) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!(error instanceof Result.Success)) {
                    if (error instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(LOGTAG, "Error while saving comment : " + ((CacheError) ((Result.Error) error).getValue()));
                }
                return error;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11341.I$1;
            int i3 = c11341.I$0;
            ResultKt.throwOnFailure(obj);
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception unused) {
            error = new Result.Error(CacheError.SaveError.INSTANCE);
        }
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e(LOGTAG, "Error while saving comment : " + ((CacheError) ((Result.Error) error).getValue()));
        }
        return error;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteComment(String str, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
            if (boxDatabase instanceof Result.Success) {
                BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(boxDatabase2, str, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                anonymousClass1.label = 1;
                if (boxDatabase2.withTransactionWrapper(anonymousClass2, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (!(boxDatabase instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                Result.Error error = (Result.Error) boxDatabase;
                BoxLogUtils.e(LOGTAG, "Error deleting comment from cache " + error.getValue());
                return new Result.Error(error.getValue());
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return new Result.Success(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.comment.CommentCacheDataSource$deleteComment$2, reason: invalid class name */
    /* JADX INFO: compiled from: CommentCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.comment.CommentCacheDataSource$deleteComment$2", f = "CommentCacheDataSource.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $commentId;
        final /* synthetic */ BoxDatabase $database;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BoxDatabase boxDatabase, String str, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$database = boxDatabase;
            this.$commentId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$database, this.$commentId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.$database.commentDao().deleteComment(this.$commentId);
                this.label = 1;
                if (this.$database.fileActivityDao().cleanupComments(this) == coroutine_suspended) {
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

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object updateComment(CommentEntity commentEntity, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C11361 c11361;
        if (continuation instanceof C11361) {
            c11361 = (C11361) continuation;
            if ((c11361.label & Integer.MIN_VALUE) != 0) {
                c11361.label -= Integer.MIN_VALUE;
            } else {
                c11361 = new C11361(continuation);
            }
        } else {
            c11361 = new C11361(continuation);
        }
        Object obj = c11361.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11361.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    CommentDao commentDao = boxDatabase2.commentDao();
                    c11361.L$0 = SpillingKt.nullOutSpilledVariable(commentEntity);
                    c11361.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11361.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c11361.label = 1;
                    if (commentDao.insertComment(commentEntity, c11361) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(LOGTAG, "Error saving comment update to cache " + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(((Result.Error) boxDatabase).getValue());
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return new Result.Success(Unit.INSTANCE);
        } catch (Exception unused) {
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
    }
}
