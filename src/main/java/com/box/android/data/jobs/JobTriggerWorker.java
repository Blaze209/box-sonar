package com.box.android.data.jobs;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.box.android.domain.identity.IUserContextManager;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0016\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/jobs/JobTriggerWorker;", "Landroidx/work/CoroutineWorker;", "jobService", "Lcom/box/android/data/jobs/JobService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "boxApiPrivate", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;", "appContext", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "<init>", "(Lcom/box/android/data/jobs/JobService;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "getJobService", "()Lcom/box/android/data/jobs/JobService;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "getBoxApiPrivate", "()Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;", "setBoxApiPrivate", "(Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobTriggerWorker extends CoroutineWorker {
    private BoxApiPrivate boxApiPrivate;
    private final JobService jobService;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobTriggerWorker$doWork$1, reason: invalid class name */
    /* JADX INFO: compiled from: Job.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobTriggerWorker", f = "Job.kt", i = {}, l = {123}, m = "doWork", n = {}, s = {}, v = 1)
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
            return JobTriggerWorker.this.doWork(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobTriggerWorker(JobService jobService, IUserContextManager userContextManager, BoxApiPrivate boxApiPrivate, Context appContext, WorkerParameters workerParameters) {
        super(appContext, workerParameters);
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(boxApiPrivate, "boxApiPrivate");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        this.jobService = jobService;
        this.userContextManager = userContextManager;
        this.boxApiPrivate = boxApiPrivate;
    }

    public final JobService getJobService() {
        return this.jobService;
    }

    public final IUserContextManager getUserContextManager() {
        return this.userContextManager;
    }

    public final BoxApiPrivate getBoxApiPrivate() {
        return this.boxApiPrivate;
    }

    public final void setBoxApiPrivate(BoxApiPrivate boxApiPrivate) {
        Intrinsics.checkNotNullParameter(boxApiPrivate, "<set-?>");
        this.boxApiPrivate = boxApiPrivate;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            JobHelper jobHelper = JobHelper.INSTANCE;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            JobService jobService = this.jobService;
            IUserContextManager iUserContextManager = this.userContextManager;
            BoxApiPrivate boxApiPrivate = this.boxApiPrivate;
            BoxAuthentication boxAuthentication = BoxAuthentication.getInstance();
            Intrinsics.checkNotNullExpressionValue(boxAuthentication, "getInstance(...)");
            anonymousClass2.label = 1;
            if (jobHelper.triggerNextJob(applicationContext, jobService, iUserContextManager, boxApiPrivate, boxAuthentication, anonymousClass2) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        ListenableWorker.Result resultSuccess = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(resultSuccess, "success(...)");
        return resultSuccess;
    }
}
