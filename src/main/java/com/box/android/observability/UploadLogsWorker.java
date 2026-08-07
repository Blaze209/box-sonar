package com.box.android.observability;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import com.box.android.application.BoxApplication;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.usecases.observability.UploadLogsUseCase;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadLogsWorker.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\f\u001a\u00060\rj\u0002`\u000eH\u0096@¢\u0006\u0002\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/observability/UploadLogsWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "uploadLogsInteractor", "Lcom/box/android/domain/usecases/observability/UploadLogsUseCase;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Lcom/box/android/domain/usecases/observability/UploadLogsUseCase;)V", "getAppContext", "()Landroid/content/Context;", "doWork", "Landroidx/work/ListenableWorker$Result;", "Lcom/box/android/observability/WorkManagerResult;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Scheduler", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadLogsWorker extends CoroutineWorker {
    private final Context appContext;
    private final UploadLogsUseCase uploadLogsInteractor;

    /* JADX INFO: renamed from: Scheduler, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: renamed from: com.box.android.observability.UploadLogsWorker$doWork$1, reason: invalid class name */
    /* JADX INFO: compiled from: UploadLogsWorker.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.observability.UploadLogsWorker", f = "UploadLogsWorker.kt", i = {}, l = {33}, m = "doWork", n = {}, s = {}, v = 1)
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
            return UploadLogsWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UploadLogsWorker(Context appContext, WorkerParameters workerParams, UploadLogsUseCase uploadLogsInteractor) {
        super(appContext, workerParams);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        Intrinsics.checkNotNullParameter(uploadLogsInteractor, "uploadLogsInteractor");
        this.appContext = appContext;
        this.uploadLogsInteractor = uploadLogsInteractor;
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // androidx.work.CoroutineWorker
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
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
        Object objUploadLogs = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objUploadLogs);
            BoxLogUtils.i(ExtensionsKt.getTAG(this), "Upload worker started");
            UploadLogsUseCase uploadLogsUseCase = this.uploadLogsInteractor;
            String logTag = ObservabilitySettingsManager.INSTANCE.getLogTag();
            anonymousClass1.label = 1;
            objUploadLogs = uploadLogsUseCase.uploadLogs(logTag, anonymousClass1);
            if (objUploadLogs == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objUploadLogs);
        }
        Result.Error error = (Result) objUploadLogs;
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
        if (error instanceof Result.Success) {
            if (this.uploadLogsInteractor.areAllLogsNotUploaded()) {
                INSTANCE.schedule();
            }
        } else if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        Object obj = com.box.android.domain.utils.result.ResultKt.get(error);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.work.ListenableWorker.Result");
        return (ListenableWorker.Result) obj;
    }

    /* JADX INFO: renamed from: com.box.android.observability.UploadLogsWorker$Scheduler, reason: from kotlin metadata */
    /* JADX INFO: compiled from: UploadLogsWorker.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/observability/UploadLogsWorker$Scheduler;", "", "<init>", "()V", "schedule", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void schedule() {
            Context applicationContext = BoxApplication.getInstance().getApplicationContext();
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) UploadLogsWorker.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 5L, TimeUnit.MINUTES).build();
            WorkManager.Companion companion = WorkManager.INSTANCE;
            Intrinsics.checkNotNull(applicationContext);
            companion.getInstance(applicationContext).enqueue(oneTimeWorkRequestBuild);
        }
    }
}
