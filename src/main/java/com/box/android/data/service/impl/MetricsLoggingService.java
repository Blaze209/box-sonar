package com.box.android.data.service.impl;

import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.logging.MetricsCacheDataSource;
import com.box.android.data.datasource.logging.MetricsRemoteDataSource;
import com.box.android.data.mappers.observability.MetricsEntityDTOMapper;
import com.box.android.data.mappers.observability.MetricsModelEntityMapper;
import com.box.android.data.persistence.logging.MetricsEntity;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.IGenericError;
import com.box.android.domain.models.observability.Gen204Event;
import com.box.android.domain.services.IMetricsLoggingService;
import com.box.android.domain.utils.result.Result;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: MetricsLoggingService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096@¢\u0006\u0002\u0010\u0012J\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0087@¢\u0006\u0002\u0010\u0015J,\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0096@¢\u0006\u0002\u0010\u001bJ\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u000f0\rH\u0096@¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/box/android/data/service/impl/MetricsLoggingService;", "Lcom/box/android/domain/services/IMetricsLoggingService;", "metricsCacheDataSource", "Lcom/box/android/data/datasource/logging/MetricsCacheDataSource;", "metricsRemoteDataSource", "Lcom/box/android/data/datasource/logging/MetricsRemoteDataSource;", "metricsEntityDTOMapper", "Lcom/box/android/data/mappers/observability/MetricsEntityDTOMapper;", "<init>", "(Lcom/box/android/data/datasource/logging/MetricsCacheDataSource;Lcom/box/android/data/datasource/logging/MetricsRemoteDataSource;Lcom/box/android/data/mappers/observability/MetricsEntityDTOMapper;)V", "uploadMutex", "Lkotlinx/coroutines/sync/Mutex;", SemanticAttributes.DbSystemValues.CACHE, "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "genericEvent", "Lcom/box/android/domain/models/observability/Gen204Event;", "(Lcom/box/android/domain/models/observability/Gen204Event;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "entity", "Lcom/box/android/data/persistence/logging/MetricsEntity;", "(Lcom/box/android/data/persistence/logging/MetricsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_UPLOAD_JOB, "deleteOnFailureForUserId", "", "deleteOnFailureForAllUsers", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCount", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetricsLoggingService implements IMetricsLoggingService {
    private final MetricsCacheDataSource metricsCacheDataSource;
    private final MetricsEntityDTOMapper metricsEntityDTOMapper;
    private final MetricsRemoteDataSource metricsRemoteDataSource;
    private final Mutex uploadMutex;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.MetricsLoggingService$cache$2, reason: invalid class name */
    /* JADX INFO: compiled from: MetricsLoggingService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.MetricsLoggingService", f = "MetricsLoggingService.kt", i = {0}, l = {33}, m = SemanticAttributes.DbSystemValues.CACHE, n = {"entity"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetricsLoggingService.this.cache((MetricsEntity) null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.MetricsLoggingService$getCount$1, reason: invalid class name */
    /* JADX INFO: compiled from: MetricsLoggingService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.MetricsLoggingService", f = "MetricsLoggingService.kt", i = {}, l = {70}, m = "getCount", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetricsLoggingService.this.getCount(this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.service.impl.MetricsLoggingService$upload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MetricsLoggingService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.MetricsLoggingService", f = "MetricsLoggingService.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}, l = {79, 40, 54, 57, 60, 62}, m = BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_UPLOAD_JOB, n = {"deleteOnFailureForUserId", "$this$withLock_u24default$iv", "deleteOnFailureForAllUsers", "$i$f$withLock", "deleteOnFailureForUserId", "$this$withLock_u24default$iv", "deleteOnFailureForAllUsers", "$i$f$withLock", "$i$a$-withLock$default-MetricsLoggingService$upload$2", "deleteOnFailureForUserId", "$this$withLock_u24default$iv", "$this$flatMap$iv", "metricsEntityList", "aggregatedList", "deleteOnFailureForAllUsers", "$i$f$withLock", "$i$a$-withLock$default-MetricsLoggingService$upload$2", "$i$f$flatMap", "$i$a$-flatMap-MetricsLoggingService$upload$2$1", "deleteOnFailureForUserId", "$this$withLock_u24default$iv", "$this$flatMap$iv", "metricsEntityList", "$this$onSuccess$iv", "it", "aggregatedList", "deleteOnFailureForAllUsers", "$i$f$withLock", "$i$a$-withLock$default-MetricsLoggingService$upload$2", "$i$f$flatMap", "$i$a$-flatMap-MetricsLoggingService$upload$2$1", "$i$f$onSuccess", "$i$a$-onSuccess-MetricsLoggingService$upload$2$1$1", "deleteOnFailureForUserId", "$this$withLock_u24default$iv", "$this$flatMap$iv", "metricsEntityList", "$this$onError$iv", "it", "aggregatedList", "deleteOnFailureForAllUsers", "$i$f$withLock", "$i$a$-withLock$default-MetricsLoggingService$upload$2", "$i$f$flatMap", "$i$a$-flatMap-MetricsLoggingService$upload$2$1", "$i$f$onError", "$i$a$-onError-MetricsLoggingService$upload$2$1$2", "deleteOnFailureForUserId", "$this$withLock_u24default$iv", "$this$flatMap$iv", "metricsEntityList", "$this$onError$iv", "it", "aggregatedList", "deleteOnFailureForAllUsers", "$i$f$withLock", "$i$a$-withLock$default-MetricsLoggingService$upload$2", "$i$f$flatMap", "$i$a$-flatMap-MetricsLoggingService$upload$2$1", "$i$f$onError", "$i$a$-onError-MetricsLoggingService$upload$2$1$2"}, s = {"L$0", "L$1", "Z$0", "I$0", "L$0", "L$1", "Z$0", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "I$0", "I$1", "I$2", "I$3", "I$4", "I$5"}, v = 1)
    static final class C14691 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        int I$5;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C14691(Continuation<? super C14691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MetricsLoggingService.this.upload(null, false, this);
        }
    }

    @Inject
    public MetricsLoggingService(MetricsCacheDataSource metricsCacheDataSource, MetricsRemoteDataSource metricsRemoteDataSource, MetricsEntityDTOMapper metricsEntityDTOMapper) {
        Intrinsics.checkNotNullParameter(metricsCacheDataSource, "metricsCacheDataSource");
        Intrinsics.checkNotNullParameter(metricsRemoteDataSource, "metricsRemoteDataSource");
        Intrinsics.checkNotNullParameter(metricsEntityDTOMapper, "metricsEntityDTOMapper");
        this.metricsCacheDataSource = metricsCacheDataSource;
        this.metricsRemoteDataSource = metricsRemoteDataSource;
        this.metricsEntityDTOMapper = metricsEntityDTOMapper;
        this.uploadMutex = MutexKt.Mutex$default(false, 1, null);
    }

    @Override // com.box.android.domain.services.IMetricsLoggingService
    public Object cache(Gen204Event gen204Event, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return cache(MetricsModelEntityMapper.INSTANCE.toEntity(gen204Event), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object cache(MetricsEntity metricsEntity, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        AnonymousClass2 anonymousClass2;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        Object objSave = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSave);
            MetricsCacheDataSource metricsCacheDataSource = this.metricsCacheDataSource;
            anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(metricsEntity);
            anonymousClass2.label = 1;
            objSave = metricsCacheDataSource.save(metricsEntity, anonymousClass2);
            if (objSave == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objSave);
        }
        Result result = (Result) objSave;
        if (result instanceof Result.Success) {
            ((Result.Success) result).getValue();
            return new Result.Success(Unit.INSTANCE);
        }
        if (result instanceof Result.Error) {
            return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (IGenericError) ((Result.Error) result).getValue(), null, 2, null));
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:101:0x039e A[Catch: all -> 0x008b, TRY_LEAVE, TryCatch #2 {all -> 0x008b, blocks: (B:14:0x0086, B:96:0x0394, B:99:0x039a, B:101:0x039e, B:104:0x03b9, B:105:0x03be), top: B:115:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:104:0x03b9 A[Catch: all -> 0x008b, TRY_ENTER, TryCatch #2 {all -> 0x008b, blocks: (B:14:0x0086, B:96:0x0394, B:99:0x039a, B:101:0x039e, B:104:0x03b9, B:105:0x03be), top: B:115:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x03bf A[Catch: all -> 0x0101, TRY_ENTER, TryCatch #0 {all -> 0x0101, blocks: (B:29:0x00fd, B:43:0x0156, B:45:0x015c, B:47:0x016b, B:48:0x0177, B:49:0x0185, B:51:0x018b, B:53:0x019e, B:54:0x01a8, B:55:0x01ae, B:56:0x01c1, B:58:0x01c7, B:59:0x025c, B:93:0x038f, B:106:0x03bf, B:107:0x03c4), top: B:112:0x00fd }] */
    /* JADX WARN: Code duplicated, block: B:120:0x01a8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x014e  */
    /* JADX WARN: Code duplicated, block: B:45:0x015c A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:29:0x00fd, B:43:0x0156, B:45:0x015c, B:47:0x016b, B:48:0x0177, B:49:0x0185, B:51:0x018b, B:53:0x019e, B:54:0x01a8, B:55:0x01ae, B:56:0x01c1, B:58:0x01c7, B:59:0x025c, B:93:0x038f, B:106:0x03bf, B:107:0x03c4), top: B:112:0x00fd }] */
    /* JADX WARN: Code duplicated, block: B:47:0x016b A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:29:0x00fd, B:43:0x0156, B:45:0x015c, B:47:0x016b, B:48:0x0177, B:49:0x0185, B:51:0x018b, B:53:0x019e, B:54:0x01a8, B:55:0x01ae, B:56:0x01c1, B:58:0x01c7, B:59:0x025c, B:93:0x038f, B:106:0x03bf, B:107:0x03c4), top: B:112:0x00fd }] */
    /* JADX WARN: Code duplicated, block: B:48:0x0177 A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:29:0x00fd, B:43:0x0156, B:45:0x015c, B:47:0x016b, B:48:0x0177, B:49:0x0185, B:51:0x018b, B:53:0x019e, B:54:0x01a8, B:55:0x01ae, B:56:0x01c1, B:58:0x01c7, B:59:0x025c, B:93:0x038f, B:106:0x03bf, B:107:0x03c4), top: B:112:0x00fd }] */
    /* JADX WARN: Code duplicated, block: B:51:0x018b A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:29:0x00fd, B:43:0x0156, B:45:0x015c, B:47:0x016b, B:48:0x0177, B:49:0x0185, B:51:0x018b, B:53:0x019e, B:54:0x01a8, B:55:0x01ae, B:56:0x01c1, B:58:0x01c7, B:59:0x025c, B:93:0x038f, B:106:0x03bf, B:107:0x03c4), top: B:112:0x00fd }] */
    /* JADX WARN: Code duplicated, block: B:53:0x019e A[Catch: all -> 0x0101, TryCatch #0 {all -> 0x0101, blocks: (B:29:0x00fd, B:43:0x0156, B:45:0x015c, B:47:0x016b, B:48:0x0177, B:49:0x0185, B:51:0x018b, B:53:0x019e, B:54:0x01a8, B:55:0x01ae, B:56:0x01c1, B:58:0x01c7, B:59:0x025c, B:93:0x038f, B:106:0x03bf, B:107:0x03c4), top: B:112:0x00fd }] */
    /* JADX WARN: Code duplicated, block: B:58:0x01c7 A[Catch: all -> 0x0101, LOOP:1: B:56:0x01c1->B:58:0x01c7, LOOP_END, TryCatch #0 {all -> 0x0101, blocks: (B:29:0x00fd, B:43:0x0156, B:45:0x015c, B:47:0x016b, B:48:0x0177, B:49:0x0185, B:51:0x018b, B:53:0x019e, B:54:0x01a8, B:55:0x01ae, B:56:0x01c1, B:58:0x01c7, B:59:0x025c, B:93:0x038f, B:106:0x03bf, B:107:0x03c4), top: B:112:0x00fd }] */
    /* JADX WARN: Code duplicated, block: B:62:0x028d  */
    /* JADX WARN: Code duplicated, block: B:65:0x029e A[Catch: all -> 0x00ec, TryCatch #3 {all -> 0x00ec, blocks: (B:24:0x00de, B:63:0x0298, B:65:0x029e, B:68:0x02e3, B:91:0x0389, B:92:0x038e), top: B:116:0x00de }] */
    /* JADX WARN: Code duplicated, block: B:67:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:68:0x02e3 A[Catch: all -> 0x00ec, TRY_LEAVE, TryCatch #3 {all -> 0x00ec, blocks: (B:24:0x00de, B:63:0x0298, B:65:0x029e, B:68:0x02e3, B:91:0x0389, B:92:0x038e), top: B:116:0x00de }] */
    /* JADX WARN: Code duplicated, block: B:73:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:74:0x02ef A[Catch: all -> 0x00bd, TryCatch #4 {all -> 0x00bd, blocks: (B:19:0x00b8, B:71:0x02e9, B:74:0x02ef, B:76:0x02f3, B:78:0x02fe, B:84:0x0342, B:89:0x0383, B:90:0x0388), top: B:117:0x00b8 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x02f3 A[Catch: all -> 0x00bd, TryCatch #4 {all -> 0x00bd, blocks: (B:19:0x00b8, B:71:0x02e9, B:74:0x02ef, B:76:0x02f3, B:78:0x02fe, B:84:0x0342, B:89:0x0383, B:90:0x0388), top: B:117:0x00b8 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x02fe A[Catch: all -> 0x00bd, TryCatch #4 {all -> 0x00bd, blocks: (B:19:0x00b8, B:71:0x02e9, B:74:0x02ef, B:76:0x02f3, B:78:0x02fe, B:84:0x0342, B:89:0x0383, B:90:0x0388), top: B:117:0x00b8 }] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x033a  */
    /* JADX WARN: Code duplicated, block: B:83:0x0340 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x0342 A[Catch: all -> 0x00bd, TryCatch #4 {all -> 0x00bd, blocks: (B:19:0x00b8, B:71:0x02e9, B:74:0x02ef, B:76:0x02f3, B:78:0x02fe, B:84:0x0342, B:89:0x0383, B:90:0x0388), top: B:117:0x00b8 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x0383 A[Catch: all -> 0x00bd, TryCatch #4 {all -> 0x00bd, blocks: (B:19:0x00b8, B:71:0x02e9, B:74:0x02ef, B:76:0x02f3, B:78:0x02fe, B:84:0x0342, B:89:0x0383, B:90:0x0388), top: B:117:0x00b8 }] */
    /* JADX WARN: Code duplicated, block: B:91:0x0389 A[Catch: all -> 0x00ec, TRY_ENTER, TryCatch #3 {all -> 0x00ec, blocks: (B:24:0x00de, B:63:0x0298, B:65:0x029e, B:68:0x02e3, B:91:0x0389, B:92:0x038e), top: B:116:0x00de }] */
    /* JADX WARN: Code duplicated, block: B:93:0x038f A[Catch: all -> 0x0101, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0101, blocks: (B:29:0x00fd, B:43:0x0156, B:45:0x015c, B:47:0x016b, B:48:0x0177, B:49:0x0185, B:51:0x018b, B:53:0x019e, B:54:0x01a8, B:55:0x01ae, B:56:0x01c1, B:58:0x01c7, B:59:0x025c, B:93:0x038f, B:106:0x03bf, B:107:0x03c4), top: B:112:0x00fd }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0398  */
    /* JADX WARN: Code duplicated, block: B:99:0x039a A[Catch: all -> 0x008b, TryCatch #2 {all -> 0x008b, blocks: (B:14:0x0086, B:96:0x0394, B:99:0x039a, B:101:0x039e, B:104:0x03b9, B:105:0x03be), top: B:115:0x0086 }] */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x037c, code lost:
    
        if (r0.deleteMetricsOfAllUsers(r2) == r3) goto L86;
     */
    @Override // com.box.android.domain.services.IMetricsLoggingService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object upload(java.lang.String r75, boolean r76, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r77) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 992
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.service.impl.MetricsLoggingService.upload(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IMetricsLoggingService
    public Object getCount(Continuation<? super Result<Integer, ? extends DomainError>> continuation) {
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
        Object metricsCount = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(metricsCount);
            MetricsCacheDataSource metricsCacheDataSource = this.metricsCacheDataSource;
            anonymousClass1.label = 1;
            metricsCount = metricsCacheDataSource.getMetricsCount(anonymousClass1);
            if (metricsCount == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(metricsCount);
        }
        Result result = (Result) metricsCount;
        if (result instanceof Result.Success) {
            return result;
        }
        if (!(result instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(DomainErrorMapper.toDomainError$default(DomainErrorMapper.INSTANCE, (CacheError) ((Result.Error) result).getValue(), null, 2, null));
    }
}
