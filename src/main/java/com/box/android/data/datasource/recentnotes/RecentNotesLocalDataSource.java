package com.box.android.data.datasource.recentnotes;

import com.box.android.data.datasource.CacheError;
import com.box.android.data.persistence.BoxDatabase;
import com.box.android.data.persistence.recentnotes.RecentNoteDao;
import com.box.android.data.persistence.recentnotes.RecentNoteEntity;
import com.box.android.data.user.UserData;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: RecentNotesLocalDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0004\u0012\u00020\u000b0\b0\u0007J(\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0002\u0010\u000fJ(\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086@¢\u0006\u0002\u0010\u000fJ)\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u00020\u000b0\b\"\u0004\b\u0000\u0010\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0014H\u0082\bJ#\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\b2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014H\u0082\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/data/datasource/recentnotes/RecentNotesLocalDataSource;", "", "userData", "Lcom/box/android/data/user/UserData;", "<init>", "(Lcom/box/android/data/user/UserData;)V", "observeRecentNoteEntries", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/persistence/recentnotes/RecentNoteEntity;", "Lcom/box/android/data/datasource/CacheError;", "replaceAllRecentNotesEntries", "", "notes", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveRecentNotesEntries", "catchingReadErrors", "R", "block", "Lkotlin/Function0;", "catchingSaveErrors", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentNotesLocalDataSource {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String TAG = "RecentNotesLocalDataSource";
    private final UserData userData;

    /* JADX INFO: renamed from: com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource$replaceAllRecentNotesEntries$1, reason: invalid class name */
    /* JADX INFO: compiled from: RecentNotesLocalDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource", f = "RecentNotesLocalDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {39}, m = "replaceAllRecentNotesEntries", n = {"notes", "$this$flatMap$iv", "db", "this_$iv", "$i$f$flatMap", "$i$a$-flatMap-RecentNotesLocalDataSource$replaceAllRecentNotesEntries$2", "$i$f$catchingSaveErrors", "$i$f$resultOf", "$i$a$-catchingSaveErrors-RecentNotesLocalDataSource$replaceAllRecentNotesEntries$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
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
            return RecentNotesLocalDataSource.this.replaceAllRecentNotesEntries(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource$saveRecentNotesEntries$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RecentNotesLocalDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource", f = "RecentNotesLocalDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {48}, m = "saveRecentNotesEntries", n = {"notes", "$this$flatMap$iv", "db", "this_$iv", "$i$f$flatMap", "$i$a$-flatMap-RecentNotesLocalDataSource$saveRecentNotesEntries$2", "$i$f$catchingSaveErrors", "$i$f$resultOf", "$i$a$-catchingSaveErrors-RecentNotesLocalDataSource$saveRecentNotesEntries$2$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2", "I$3", "I$4"}, v = 1)
    static final class C12121 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C12121(Continuation<? super C12121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RecentNotesLocalDataSource.this.saveRecentNotesEntries(null, this);
        }
    }

    @Inject
    public RecentNotesLocalDataSource(UserData userData) {
        Intrinsics.checkNotNullParameter(userData, "userData");
        this.userData = userData;
    }

    public final Flow<Result<List<RecentNoteEntity>, CacheError>> observeRecentNoteEntries() {
        Object objFlowOf;
        Result.Error error;
        Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
        if (boxDatabase instanceof Result.Success) {
            try {
                final Flow<List<RecentNoteEntity>> flowObserveAll = ((BoxDatabase) ((Result.Success) boxDatabase).getValue()).recentNoteDao().observeAll();
                error = new Result.Success(FlowKt.m16356catch(new Flow<Result<? extends List<? extends RecentNoteEntity>, ? extends CacheError>>() { // from class: com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource$observeRecentNoteEntries$lambda$0$0$$inlined$map$1

                    /* JADX INFO: renamed from: com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource$observeRecentNoteEntries$lambda$0$0$$inlined$map$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    public static final class AnonymousClass2<T> implements FlowCollector {
                        final /* synthetic */ FlowCollector $this_unsafeFlow;

                        /* JADX INFO: renamed from: com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource$observeRecentNoteEntries$lambda$0$0$$inlined$map$1$2$1, reason: invalid class name */
                        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                        @DebugMetadata(c = "com.box.android.data.datasource.recentnotes.RecentNotesLocalDataSource$observeRecentNoteEntries$lambda$0$0$$inlined$map$1$2", f = "RecentNotesLocalDataSource.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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
                    public Object collect(FlowCollector<? super Result<? extends List<? extends RecentNoteEntity>, ? extends CacheError>> flowCollector, Continuation continuation) {
                        Object objCollect = flowObserveAll.collect(new AnonymousClass2(flowCollector), continuation);
                        return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                    }
                }, new RecentNotesLocalDataSource$observeRecentNoteEntries$1$1$2(null)));
            } catch (Exception e) {
                error = new Result.Error(e);
            }
            if (!(error instanceof Result.Success)) {
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                BoxLogUtils.e(TAG, "Failed to read recent notes cache", (Exception) ((Result.Error) error).getValue());
                error = new Result.Error(CacheError.ReadError.INSTANCE);
            }
            boxDatabase = error;
        } else if (!(boxDatabase instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        if (boxDatabase instanceof Result.Success) {
            objFlowOf = ((Result.Success) boxDatabase).getValue();
        } else if (boxDatabase instanceof Result.Error) {
            objFlowOf = FlowKt.flowOf(new Result.Error((CacheError) ((Result.Error) boxDatabase).getValue()));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return (Flow) objFlowOf;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object replaceAllRecentNotesEntries(List<RecentNoteEntity> list, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
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
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    RecentNotesLocalDataSource$replaceAllRecentNotesEntries$2$1$1 recentNotesLocalDataSource$replaceAllRecentNotesEntries$2$1$1 = new RecentNotesLocalDataSource$replaceAllRecentNotesEntries$2$1$1(boxDatabase2, list, null);
                    anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(this);
                    anonymousClass1.I$0 = 0;
                    anonymousClass1.I$1 = 0;
                    anonymousClass1.I$2 = 0;
                    anonymousClass1.I$3 = 0;
                    anonymousClass1.I$4 = 0;
                    anonymousClass1.label = 1;
                    if (boxDatabase2.withTransactionWrapper(recentNotesLocalDataSource$replaceAllRecentNotesEntries$2$1$1, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (boxDatabase instanceof Result.Error) {
                        return boxDatabase;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$4;
                int i3 = anonymousClass1.I$3;
                int i4 = anonymousClass1.I$2;
                int i5 = anonymousClass1.I$1;
                int i6 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(obj);
            }
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        BoxLogUtils.e(TAG, "Failed to save recent note entries", (Exception) ((Result.Error) error).getValue());
        return new Result.Error(CacheError.SaveError.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object saveRecentNotesEntries(List<RecentNoteEntity> list, Continuation<? super Result<Unit, ? extends CacheError>> continuation) {
        C12121 c12121;
        Result.Error error;
        if (continuation instanceof C12121) {
            c12121 = (C12121) continuation;
            if ((c12121.label & Integer.MIN_VALUE) != 0) {
                c12121.label -= Integer.MIN_VALUE;
            } else {
                c12121 = new C12121(continuation);
            }
        } else {
            c12121 = new C12121(continuation);
        }
        Object obj = c12121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12121.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Result<BoxDatabase, CacheError> boxDatabase = this.userData.getBoxDatabase();
                if (boxDatabase instanceof Result.Success) {
                    BoxDatabase boxDatabase2 = (BoxDatabase) ((Result.Success) boxDatabase).getValue();
                    RecentNoteDao recentNoteDao = boxDatabase2.recentNoteDao();
                    c12121.L$0 = SpillingKt.nullOutSpilledVariable(list);
                    c12121.L$1 = SpillingKt.nullOutSpilledVariable(boxDatabase);
                    c12121.L$2 = SpillingKt.nullOutSpilledVariable(boxDatabase2);
                    c12121.L$3 = SpillingKt.nullOutSpilledVariable(this);
                    c12121.I$0 = 0;
                    c12121.I$1 = 0;
                    c12121.I$2 = 0;
                    c12121.I$3 = 0;
                    c12121.I$4 = 0;
                    c12121.label = 1;
                    if (recentNoteDao.upsertAll(list, c12121) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (boxDatabase instanceof Result.Error) {
                        return boxDatabase;
                    }
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c12121.I$4;
                int i3 = c12121.I$3;
                int i4 = c12121.I$2;
                int i5 = c12121.I$1;
                int i6 = c12121.I$0;
                ResultKt.throwOnFailure(obj);
            }
            error = new Result.Success(Unit.INSTANCE);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        BoxLogUtils.e(TAG, "Failed to save recent note entries", (Exception) ((Result.Error) error).getValue());
        return new Result.Error(CacheError.SaveError.INSTANCE);
    }

    /* JADX INFO: compiled from: RecentNotesLocalDataSource.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/datasource/recentnotes/RecentNotesLocalDataSource$Companion;", "", "<init>", "()V", "TAG", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final <R> Result<R, CacheError> catchingReadErrors(Function0<? extends R> block) {
        Result.Error error;
        try {
            error = new Result.Success(block.invoke());
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(TAG, "Failed to read recent notes cache", (Exception) ((Result.Error) error).getValue());
            return new Result.Error(CacheError.ReadError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final Result<Unit, CacheError> catchingSaveErrors(Function0<Unit> block) {
        Result.Error error;
        try {
            error = new Result.Success(block.invoke());
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (error instanceof Result.Error) {
            BoxLogUtils.e(TAG, "Failed to save recent note entries", (Exception) ((Result.Error) error).getValue());
            return new Result.Error(CacheError.SaveError.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
