package com.box.android.workers;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import com.box.android.application.BoxApplication;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.usecases.observability.MetricsUseCase;
import com.box.android.domain.utils.result.Result;
import com.box.android.exceptions.NullBoxApplicationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: MetricsUploadWorker.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0096@¢\u0006\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/workers/MetricsUploadWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "metricsInteractor", "Lcom/box/android/domain/usecases/observability/MetricsUseCase;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/box/android/domain/usecases/observability/MetricsUseCase;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "Lcom/box/android/observability/WorkManagerResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Scheduler", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MetricsUploadWorker extends CoroutineWorker {
    private static final String WORKER_NAME = "com.box.android.workers.MetricsUploadWorker";
    private final MetricsUseCase metricsInteractor;

    /* JADX INFO: renamed from: Scheduler, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetricsUploadWorker(Context context, WorkerParameters workerParameters, MetricsUseCase metricsInteractor) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        Intrinsics.checkNotNullParameter(metricsInteractor, "metricsInteractor");
        this.metricsInteractor = metricsInteractor;
    }

    /* JADX INFO: renamed from: com.box.android.workers.MetricsUploadWorker$Scheduler, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MetricsUploadWorker.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/box/android/workers/MetricsUploadWorker$Scheduler;", "", "<init>", "()V", "WORKER_NAME", "", "schedule", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void schedule() {
            try {
                Context applicationContext = BoxApplication.getInstance().getApplicationContext();
                OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) MetricsUploadWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 5L, TimeUnit.MINUTES).build();
                WorkManager.Companion companion = WorkManager.INSTANCE;
                if (applicationContext == null) {
                    return;
                }
                companion.getInstance(applicationContext).enqueueUniqueWork(MetricsUploadWorker.WORKER_NAME, ExistingWorkPolicy.KEEP, oneTimeWorkRequestBuild);
            } catch (NullBoxApplicationException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.box.android.workers.MetricsUploadWorker$doWork$2, reason: invalid class name */
    /* JADX INFO: compiled from: MetricsUploadWorker.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroidx/work/ListenableWorker$Result;", "Lcom/box/android/observability/WorkManagerResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.workers.MetricsUploadWorker$doWork$2", f = "MetricsUploadWorker.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MetricsUploadWorker.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = MetricsUploadWorker.this.metricsInteractor.uploadMetrics(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.Error error = (Result) obj;
            if (error instanceof Result.Success) {
                error = new Result.Success(ListenableWorker.Result.success());
            } else if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(error instanceof Result.Success)) {
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                error = new Result.Error(DomainErrorKt.isNetworkConnectionError((DomainError) ((Result.Error) error).getValue()) ? ListenableWorker.Result.retry() : ListenableWorker.Result.failure());
            }
            Object obj2 = com.box.android.domain.utils.result.ResultKt.get(error);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.work.ListenableWorker.Result");
            return (ListenableWorker.Result) obj2;
        }
    }

    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }
}
