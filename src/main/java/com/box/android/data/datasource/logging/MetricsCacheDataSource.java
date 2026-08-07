package com.box.android.data.datasource.logging;

import com.box.android.data.datasource.CacheError;
import com.box.android.data.persistence.BoxObservabilityDatabase;
import com.box.android.data.persistence.ObservabilityDatabaseProvider;
import com.box.android.data.persistence.logging.MetricsDao;
import com.box.android.data.persistence.logging.MetricsEntity;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.auth.OAuthActivity;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsCacheDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fJ \u0010\r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e\u0012\u0004\u0012\u00020\u000f0\u0007H\u0086@¢\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0007H\u0086@¢\u0006\u0002\u0010\u0010J(\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH\u0086@¢\u0006\u0002\u0010\u0016J\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0086@¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u0007H\u0086@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/box/android/data/datasource/logging/MetricsCacheDataSource;", "", "observabilityDatabaseProvider", "Lcom/box/android/data/persistence/ObservabilityDatabaseProvider;", "<init>", "(Lcom/box/android/data/persistence/ObservabilityDatabaseProvider;)V", "save", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/data/datasource/CacheError$SaveError;", "metricsEntity", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "(Lcom/box/android/data/persistence/logging/MetricsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllMetricLogs", "", "Lcom/box/android/data/datasource/CacheError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetricsCount", "", "deleteMetrics", "Lcom/box/android/data/datasource/CacheError$DeleteError;", "metricsEntityList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMetricsOfUser", OAuthActivity.USER_ID, "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMetricsOfAllUsers", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetricsCacheDataSource {
    private final ObservabilityDatabaseProvider observabilityDatabaseProvider;

    /* JADX INFO: renamed from: com.box.android.data.datasource.logging.MetricsCacheDataSource$deleteMetrics$1, reason: invalid class name */
    /* JADX INFO: compiled from: MetricsCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.logging.MetricsCacheDataSource", f = "MetricsCacheDataSource.kt", i = {0, 0, 0}, l = {51}, m = "deleteMetrics", n = {"metricsEntityList", "$i$f$resultOf", "$i$a$-resultOf-MetricsCacheDataSource$deleteMetrics$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetricsCacheDataSource.this.deleteMetrics(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.logging.MetricsCacheDataSource$deleteMetricsOfAllUsers$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MetricsCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.logging.MetricsCacheDataSource", f = "MetricsCacheDataSource.kt", i = {0, 0}, l = {62}, m = "deleteMetricsOfAllUsers", n = {"$i$f$resultOf", "$i$a$-resultOf-MetricsCacheDataSource$deleteMetricsOfAllUsers$2"}, s = {"I$0", "I$1"}, v = 1)
    static final class C12061 extends ContinuationImpl {
        int I$0;
        int I$1;
        int label;
        /* synthetic */ Object result;

        C12061(Continuation<? super C12061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetricsCacheDataSource.this.deleteMetricsOfAllUsers(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.logging.MetricsCacheDataSource$deleteMetricsOfUser$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MetricsCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.logging.MetricsCacheDataSource", f = "MetricsCacheDataSource.kt", i = {0, 0, 0}, l = {55}, m = "deleteMetricsOfUser", n = {OAuthActivity.USER_ID, "$i$f$resultOf", "$i$a$-resultOf-MetricsCacheDataSource$deleteMetricsOfUser$2"}, s = {"L$0", "I$0", "I$1"}, v = 1)
    static final class C12071 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C12071(Continuation<? super C12071> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetricsCacheDataSource.this.deleteMetricsOfUser(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.logging.MetricsCacheDataSource$getAllMetricLogs$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MetricsCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.logging.MetricsCacheDataSource", f = "MetricsCacheDataSource.kt", i = {0, 0}, l = {36}, m = "getAllMetricLogs", n = {"$i$f$resultOf", "$i$a$-resultOf-MetricsCacheDataSource$getAllMetricLogs$2"}, s = {"I$0", "I$1"}, v = 1)
    static final class C12081 extends ContinuationImpl {
        int I$0;
        int I$1;
        int label;
        /* synthetic */ Object result;

        C12081(Continuation<? super C12081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetricsCacheDataSource.this.getAllMetricLogs(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.logging.MetricsCacheDataSource$getMetricsCount$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MetricsCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.logging.MetricsCacheDataSource", f = "MetricsCacheDataSource.kt", i = {0, 0}, l = {43}, m = "getMetricsCount", n = {"$i$f$resultOf", "$i$a$-resultOf-MetricsCacheDataSource$getMetricsCount$2"}, s = {"I$0", "I$1"}, v = 1)
    static final class C12091 extends ContinuationImpl {
        int I$0;
        int I$1;
        int label;
        /* synthetic */ Object result;

        C12091(Continuation<? super C12091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetricsCacheDataSource.this.getMetricsCount(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.logging.MetricsCacheDataSource$save$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MetricsCacheDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.logging.MetricsCacheDataSource", f = "MetricsCacheDataSource.kt", i = {0, 0}, l = {23}, m = "save", n = {"metricsEntity", "database"}, s = {"L$0", "L$1"}, v = 1)
    static final class C12101 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C12101(Continuation<? super C12101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetricsCacheDataSource.this.save(null, this);
        }
    }

    @Inject
    public MetricsCacheDataSource(ObservabilityDatabaseProvider observabilityDatabaseProvider) {
        Intrinsics.checkNotNullParameter(observabilityDatabaseProvider, "observabilityDatabaseProvider");
        this.observabilityDatabaseProvider = observabilityDatabaseProvider;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object save(MetricsEntity metricsEntity, Continuation<? super Result<Unit, CacheError.SaveError>> continuation) {
        C12101 c12101;
        if (continuation instanceof C12101) {
            c12101 = (C12101) continuation;
            if ((c12101.label & Integer.MIN_VALUE) != 0) {
                c12101.label -= Integer.MIN_VALUE;
            } else {
                c12101 = new C12101(continuation);
            }
        } else {
            c12101 = new C12101(continuation);
        }
        Object obj = c12101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12101.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BoxObservabilityDatabase observabilityDatabase = this.observabilityDatabaseProvider.getObservabilityDatabase();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(observabilityDatabase, metricsEntity, null);
                c12101.L$0 = SpillingKt.nullOutSpilledVariable(metricsEntity);
                c12101.L$1 = SpillingKt.nullOutSpilledVariable(observabilityDatabase);
                c12101.label = 1;
                if (observabilityDatabase.withTransactionWrapper(anonymousClass2, c12101) == coroutine_suspended) {
                    return coroutine_suspended;
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

    /* JADX INFO: renamed from: com.box.android.data.datasource.logging.MetricsCacheDataSource$save$2, reason: invalid class name */
    /* JADX INFO: compiled from: MetricsCacheDataSource.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.logging.MetricsCacheDataSource$save$2", f = "MetricsCacheDataSource.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ BoxObservabilityDatabase $database;
        final /* synthetic */ MetricsEntity $metricsEntity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BoxObservabilityDatabase boxObservabilityDatabase, MetricsEntity metricsEntity, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$database = boxObservabilityDatabase;
            this.$metricsEntity = metricsEntity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.$database, this.$metricsEntity, continuation);
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
                this.label = 1;
                if (this.$database.metricsLogDao().insertLog(this.$metricsEntity, this) == coroutine_suspended) {
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

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getAllMetricLogs(Continuation<? super Result<? extends List<MetricsEntity>, ? extends CacheError>> continuation) {
        C12081 c12081;
        Result.Error error;
        if (continuation instanceof C12081) {
            c12081 = (C12081) continuation;
            if ((c12081.label & Integer.MIN_VALUE) != 0) {
                c12081.label -= Integer.MIN_VALUE;
            } else {
                c12081 = new C12081(continuation);
            }
        } else {
            c12081 = new C12081(continuation);
        }
        Object allLogs = c12081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12081.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(allLogs);
                MetricsDao metricsDaoMetricsLogDao = this.observabilityDatabaseProvider.getObservabilityDatabase().metricsLogDao();
                c12081.I$0 = 0;
                c12081.I$1 = 0;
                c12081.label = 1;
                allLogs = metricsDaoMetricsLogDao.getAllLogs(c12081);
                if (allLogs == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c12081.I$1;
                int i3 = c12081.I$0;
                ResultKt.throwOnFailure(allLogs);
            }
            error = new Result.Success((List) allLogs);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(CacheError.ReadError.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getMetricsCount(Continuation<? super Result<Integer, ? extends CacheError>> continuation) {
        C12091 c12091;
        Result.Error error;
        if (continuation instanceof C12091) {
            c12091 = (C12091) continuation;
            if ((c12091.label & Integer.MIN_VALUE) != 0) {
                c12091.label -= Integer.MIN_VALUE;
            } else {
                c12091 = new C12091(continuation);
            }
        } else {
            c12091 = new C12091(continuation);
        }
        Object count = c12091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12091.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(count);
                MetricsDao metricsDaoMetricsLogDao = this.observabilityDatabaseProvider.getObservabilityDatabase().metricsLogDao();
                c12091.I$0 = 0;
                c12091.I$1 = 0;
                c12091.label = 1;
                count = metricsDaoMetricsLogDao.getCount(c12091);
                if (count == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c12091.I$1;
                int i3 = c12091.I$0;
                ResultKt.throwOnFailure(count);
            }
            error = new Result.Success(Boxing.boxInt(((Number) count).intValue()));
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(CacheError.ReadError.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteMetrics(List<MetricsEntity> list, Continuation<? super Result<Unit, CacheError.DeleteError>> continuation) {
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
                MetricsDao metricsDaoMetricsLogDao = this.observabilityDatabaseProvider.getObservabilityDatabase().metricsLogDao();
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(list);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                if (metricsDaoMetricsLogDao.deleteMetrics(list, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
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
        return new Result.Error(CacheError.DeleteError.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteMetricsOfUser(String str, Continuation<? super Result<Unit, CacheError.DeleteError>> continuation) {
        C12071 c12071;
        Result.Error error;
        if (continuation instanceof C12071) {
            c12071 = (C12071) continuation;
            if ((c12071.label & Integer.MIN_VALUE) != 0) {
                c12071.label -= Integer.MIN_VALUE;
            } else {
                c12071 = new C12071(continuation);
            }
        } else {
            c12071 = new C12071(continuation);
        }
        Object obj = c12071.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12071.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MetricsDao metricsDaoMetricsLogDao = this.observabilityDatabaseProvider.getObservabilityDatabase().metricsLogDao();
                c12071.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c12071.I$0 = 0;
                c12071.I$1 = 0;
                c12071.label = 1;
                if (metricsDaoMetricsLogDao.deleteMetricsByUserId(str, c12071) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c12071.I$1;
                int i3 = c12071.I$0;
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
        return new Result.Error(CacheError.DeleteError.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteMetricsOfAllUsers(Continuation<? super Result<Unit, CacheError.DeleteError>> continuation) {
        C12061 c12061;
        Result.Error error;
        if (continuation instanceof C12061) {
            c12061 = (C12061) continuation;
            if ((c12061.label & Integer.MIN_VALUE) != 0) {
                c12061.label -= Integer.MIN_VALUE;
            } else {
                c12061 = new C12061(continuation);
            }
        } else {
            c12061 = new C12061(continuation);
        }
        Object obj = c12061.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c12061.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MetricsDao metricsDaoMetricsLogDao = this.observabilityDatabaseProvider.getObservabilityDatabase().metricsLogDao();
                c12061.I$0 = 0;
                c12061.I$1 = 0;
                c12061.label = 1;
                if (metricsDaoMetricsLogDao.deleteMetricsByUserIdNotNullOrEmpty(c12061) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c12061.I$1;
                int i3 = c12061.I$0;
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
        return new Result.Error(CacheError.DeleteError.INSTANCE);
    }
}
