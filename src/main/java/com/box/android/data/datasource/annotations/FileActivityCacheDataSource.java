package com.box.android.data.datasource.annotations;

import androidx.paging.DataSource;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.annotations.CommentEntity;
import com.box.android.data.persistence.annotations.FileActivityDao;
import com.box.android.data.persistence.annotations.FileActivityEntities;
import com.box.android.data.user.UserData;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: FileActivityCacheDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\f\u001a\u00020\rJ&\u0010\u000e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0010\u0012\u0004\u0012\u00020\u000b0\u00070\u000f2\u0006\u0010\f\u001a\u00020\rJ(\u0010\u0011\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0010\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\u0013\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0014J:\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000b0\u00072\u001e\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00100\u00180\u0010H\u0086@¢\u0006\u0002\u0010\u0019J*\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001dH\u0086@¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u000b0\u00072\u0006\u0010\u001b\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/box/android/data/datasource/annotations/FileActivityCacheDataSource;", "", "userData", "Lcom/box/android/data/user/UserData;", "<init>", "(Lcom/box/android/data/user/UserData;)V", "activity", "Lcom/box/android/domain/utils/result/Result;", "Landroidx/paging/DataSource$Factory;", "", "Lcom/box/android/data/persistence/annotations/FileActivityEntities;", "Lcom/box/android/data/datasource/CacheError;", "fileID", "", "activities", "Lkotlinx/coroutines/flow/Flow;", "", "replies", "Lcom/box/android/data/persistence/annotations/CommentEntity;", "activityID", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveActivitiesWithReplies", "", "activitiesWithReplies", "Lkotlin/Pair;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteActivity", "fileId", "fetchedBefore", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "incrementOrderNumber", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileActivityCacheDataSource {
    private static final Companion Companion = new Companion(null);
    private static final String LOGTAG = "FileActivityCacheDataSource";
    private UserData userData;

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.FileActivityCacheDataSource$deleteActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: FileActivityCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.FileActivityCacheDataSource", f = "FileActivityCacheDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {123}, m = "deleteActivity", n = {"fileId", "fetchedBefore", "$this$flatMap$iv", "database", "$i$f$flatMap", "$i$a$-flatMap-FileActivityCacheDataSource$deleteActivity$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
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
            return FileActivityCacheDataSource.this.deleteActivity(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.FileActivityCacheDataSource$replies$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActivityCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.FileActivityCacheDataSource", f = "FileActivityCacheDataSource.kt", i = {0, 0}, l = {61}, m = "replies", n = {"activityID", "databaseResult"}, s = {"L$0", "L$1"}, v = 1)
    static final class C11111 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C11111(Continuation<? super C11111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActivityCacheDataSource.this.replies(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.FileActivityCacheDataSource$saveActivitiesWithReplies$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FileActivityCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.annotations.FileActivityCacheDataSource", f = "FileActivityCacheDataSource.kt", i = {0, 0, 0, 0, 0}, l = {83}, m = "saveActivitiesWithReplies", n = {"activitiesWithReplies", "$this$flatMap$iv", "database", "$i$f$flatMap", "$i$a$-flatMap-FileActivityCacheDataSource$saveActivitiesWithReplies$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C11121 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11121(Continuation<? super C11121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileActivityCacheDataSource.this.saveActivitiesWithReplies(null, this);
        }
    }

    @Inject
    public FileActivityCacheDataSource(UserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        this.userData = userData;
    }

    /* JADX INFO: compiled from: FileActivityCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/datasource/annotations/FileActivityCacheDataSource$Companion;", "", "<init>", "()V", "LOGTAG", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final Result<DataSource.Factory<Integer, FileActivityEntities>, CacheError> activity(String fileID) {
        Intrinsics.checkNotNullParameter(fileID, "fileID");
        Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
        if (boxDatabase instanceof Result.Success) {
            return new Result.Success(((BoxDatabase) ((Result.Success) boxDatabase).getValue()).fileActivityDao().getActivities(fileID));
        }
        if (!(boxDatabase instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Result.Error error = (Result.Error) boxDatabase;
        BoxLogUtils.e(LOGTAG, "Error while fetching activities " + error.getValue());
        return new Result.Error(error.getValue());
    }

    public final Flow<Result<List<FileActivityEntities>, CacheError>> activities(String fileID) {
        Intrinsics.checkNotNullParameter(fileID, "fileID");
        try {
            Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
            if (boxDatabase instanceof Result.Success) {
                final Flow<List<FileActivityEntities>> activitiesV2 = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).fileActivityDao().getActivitiesV2(fileID);
                return new Flow<Result.Success<? extends List<? extends FileActivityEntities>>>() { // from class: com.box.android.data.datasource.annotations.FileActivityCacheDataSource$activities$$inlined$map$1

                    /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.FileActivityCacheDataSource$activities$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.box.android.data.datasource.annotations.FileActivityCacheDataSource$activities$$inlined$map$1$2$1, reason: invalid class name */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.data.datasource.annotations.FileActivityCacheDataSource$activities$$inlined$map$1$2", f = "FileActivityCacheDataSource.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                        public static final class AnonymousClass1 extends ContinuationImpl {
                            int I$0;
                            Object L$0;
                            Object L$1;
                            Object L$2;
                            Object L$3;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(Continuation continuation) {
                                super(continuation);
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(FlowCollector flowCollector) {
                            this.$this_unsafeFlow = flowCollector;
                        }

                        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public final Object emit(Object obj, Continuation continuation) {
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
                            Object obj2 = anonymousClass1.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = anonymousClass1.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj2);
                                FlowCollector flowCollector = this.$this_unsafeFlow;
                                Result.Success success = new Result.Success((List) obj);
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(success, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                if (i != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                int i2 = anonymousClass1.I$0;
                                Object obj3 = anonymousClass1.L$2;
                                Object obj4 = anonymousClass1.L$0;
                                ResultKt.throwOnFailure(obj2);
                            }
                            return Unit.INSTANCE;
                        }
                    }

                    @Override // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector<? super Result.Success<? extends List<? extends FileActivityEntities>>> flowCollector, Continuation continuation) {
                        Object objCollect = activitiesV2.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                };
            }
            if (!(boxDatabase instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e(LOGTAG, "Error while fetching activities " + ((Result.Error) boxDatabase).getValue());
            return FlowKt.flowOf(new Result.Error(CacheError.ReadError.INSTANCE));
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error reading fileActivities", e);
            return FlowKt.flowOf(new Result.Error(CacheError.ReadError.INSTANCE));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object replies(String str, Continuation<? super Result<? extends List<CommentEntity>, ? extends CacheError>> continuation) {
        C11111 c11111;
        if (continuation instanceof C11111) {
            c11111 = (C11111) continuation;
            if ((c11111.label & Integer.MIN_VALUE) != 0) {
                c11111.label -= Integer.MIN_VALUE;
            } else {
                c11111 = new C11111(continuation);
            }
        } else {
            c11111 = new C11111(continuation);
        }
        Object repliesForFileActivity = c11111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11111.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(repliesForFileActivity);
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    FileActivityDao fileActivityDao = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).fileActivityDao();
                    c11111.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    c11111.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11111.label = 1;
                    repliesForFileActivity = fileActivityDao.getRepliesForFileActivity(str, c11111);
                    if (repliesForFileActivity == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!(boxDatabase instanceof Result.Error)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(LOGTAG, "Error fetching db while fetching replies " + ((Result.Error) boxDatabase).getValue());
                    return new Result.Error(CacheError.ReadError.INSTANCE);
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(repliesForFileActivity);
            }
            return new Result.Success(repliesForFileActivity);
        } catch (Exception e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error reading replies", e);
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009d  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object saveActivitiesWithReplies(List<? extends Pair<FileActivityEntities, ? extends List<CommentEntity>>> list, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C11121 c11121;
        Result.Error error;
        if (continuation instanceof C11121) {
            c11121 = (C11121) continuation;
            if ((c11121.label & Integer.MIN_VALUE) != 0) {
                c11121.label -= Integer.MIN_VALUE;
            } else {
                c11121 = new C11121(continuation);
            }
        } else {
            c11121 = new C11121(continuation);
        }
        Object obj = c11121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11121.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    FileActivityCacheDataSource$saveActivitiesWithReplies$2$1 fileActivityCacheDataSource$saveActivitiesWithReplies$2$1 = new FileActivityCacheDataSource$saveActivitiesWithReplies$2$1(list, boxDatabase, null);
                    c11121.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    c11121.L$1 = SpillingKt.nullOutSpilledVariable(error);
                    c11121.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c11121.I$0 = 0;
                    c11121.I$1 = 0;
                    c11121.label = 1;
                    if (boxDatabase.withTransactionWrapper(fileActivityCacheDataSource$saveActivitiesWithReplies$2$1, c11121) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!(error instanceof Result.Success)) {
                    if (error instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(LOGTAG, "Error while saving activities : " + ((CacheError) ((Result.Error) error).getValue()));
                }
                return error;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = c11121.I$1;
            int i3 = c11121.I$0;
            ResultKt.throwOnFailure(obj);
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception unused) {
            error = new Result.Error(CacheError.SaveError.INSTANCE);
        }
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e(LOGTAG, "Error while saving activities : " + ((CacheError) ((Result.Error) error).getValue()));
        }
        return error;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:32:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteActivity(String str, Date date, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                error = this.userData.getBoxDatabase();
                if (error instanceof Result.Success) {
                    BoxDatabase boxDatabase = (BoxDatabase) ((Result.Success) error).getValue();
                    FileActivityCacheDataSource$deleteActivity$2$1 fileActivityCacheDataSource$deleteActivity$2$1 = new FileActivityCacheDataSource$deleteActivity$2$1(boxDatabase, str, date, null);
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(date);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(error);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.label = 1;
                    if (boxDatabase.withTransactionWrapper(fileActivityCacheDataSource$deleteActivity$2$1, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                if (!(error instanceof Result.Success)) {
                    if (error instanceof Result.Error) {
                        throw new NoWhenBranchMatchedException();
                    }
                    BoxLogUtils.e(LOGTAG, "Error while deleting activities : " + ((CacheError) ((Result.Error) error).getValue()));
                }
                return error;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$1;
            int i3 = anonymousClass1.I$0;
            ResultKt.throwOnFailure(obj);
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception unused) {
            error = new Result.Error(CacheError.DeleteError.INSTANCE);
        }
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e(LOGTAG, "Error while deleting activities : " + ((CacheError) ((Result.Error) error).getValue()));
        }
        return error;
    }

    public final Result<Unit, CacheError> incrementOrderNumber(String fileId) {
        Result error;
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Result boxDatabase = this.userData.getBoxDatabase();
        if (boxDatabase instanceof Result.Success) {
            try {
                ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).fileActivityDao().incrementOrderNumber(fileId);
                error = new Result.Success(Unit.INSTANCE);
            } catch (Exception unused) {
                error = new Result.Error(CacheError.SaveError.INSTANCE);
            }
            boxDatabase = error;
        } else if (!(boxDatabase instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (boxDatabase instanceof Result.Success) {
            return boxDatabase;
        }
        if (boxDatabase instanceof Result.Error) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Error incrementing order number " + ((CacheError) ((Result.Error) boxDatabase).getValue()));
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
