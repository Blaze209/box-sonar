package com.box.android.data.jobs;

import android.content.Context;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: JobHelper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ>\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0016J6\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/jobs/JobHelper;", "", "<init>", "()V", "createUser", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "boxAuthentication", "Lcom/box/androidsdk/content/auth/BoxAuthentication;", "boxApiPrivate", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;", "appContext", "Landroid/content/Context;", "tag", "", "executeJob", "jobID", "Lcom/box/android/domain/jobs/JobId;", "applicationContext", "jobService", "Lcom/box/android/data/jobs/JobService;", "(Lcom/box/android/domain/jobs/JobId;Landroid/content/Context;Lcom/box/android/data/jobs/JobService;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;Lcom/box/androidsdk/content/auth/BoxAuthentication;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "triggerNextJob", "(Landroid/content/Context;Lcom/box/android/data/jobs/JobService;Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxApiPrivate;Lcom/box/androidsdk/content/auth/BoxAuthentication;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JobHelper {
    public static final JobHelper INSTANCE = new JobHelper();

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobHelper$executeJob$1, reason: invalid class name */
    /* JADX INFO: compiled from: JobHelper.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobHelper", f = "JobHelper.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {44, 46, 48}, m = "executeJob", n = {"jobID", "applicationContext", "jobService", "userContextManager", "boxApiPrivate", "boxAuthentication", "jobID", "applicationContext", "jobService", "userContextManager", "boxApiPrivate", "boxAuthentication", "job", "jobID", "applicationContext", "jobService", "userContextManager", "boxApiPrivate", "boxAuthentication", "job", "e"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JobHelper.this.executeJob(null, null, null, null, null, null, this);
        }
    }

    private JobHelper() {
    }

    public final void createUser(IUserContextManager userContextManager, BoxAuthentication boxAuthentication, BoxApiPrivate boxApiPrivate, Context appContext, String tag) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(boxAuthentication, "boxAuthentication");
        Intrinsics.checkNotNullParameter(boxApiPrivate, "boxApiPrivate");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(tag, "tag");
        String lastAuthenticatedUserId = boxAuthentication.getLastAuthenticatedUserId(appContext);
        Intrinsics.checkNotNull(lastAuthenticatedUserId);
        if (StringsKt.isBlank(lastAuthenticatedUserId) || userContextManager.hasValidUserId() || userContextManager.isSwitchingOrDestroyingUser()) {
            return;
        }
        try {
            userContextManager.createUser(lastAuthenticatedUserId, boxApiPrivate);
        } catch (IUserContextComponent.UserContextComponentCreationException e) {
            BoxLogUtils.e(tag, e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x011c, code lost:
    
        if (r8.start(r3) == r10) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0169, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r2, r12, r3) == r10) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object executeJob(com.box.android.domain.jobs.JobId r16, android.content.Context r17, com.box.android.data.jobs.JobService r18, com.box.android.domain.identity.IUserContextManager r19, com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate r20, com.box.androidsdk.content.auth.BoxAuthentication r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.data.jobs.JobHelper.executeJob(com.box.android.domain.jobs.JobId, android.content.Context, com.box.android.data.jobs.JobService, com.box.android.domain.identity.IUserContextManager, com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate, com.box.androidsdk.content.auth.BoxAuthentication, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.data.jobs.JobHelper$executeJob$2, reason: invalid class name */
    /* JADX INFO: compiled from: JobHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.jobs.JobHelper$executeJob$2", f = "JobHelper.kt", i = {0}, l = {54}, m = "invokeSuspend", n = {"domainError"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Exception $e;
        final /* synthetic */ JobId $jobID;
        final /* synthetic */ JobService $jobService;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Exception exc, JobService jobService, JobId jobId, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$e = exc;
            this.$jobService = jobService;
            this.$jobID = jobId;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$e, this.$jobService, this.$jobID, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DomainError.UnknownError unknownError;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$e instanceof CancellationException) {
                    unknownError = new DomainError.JobCancelledError("JobHelper Exception Handled");
                } else {
                    unknownError = new DomainError.UnknownError("executeJob " + ExceptionsKt.stackTraceToString(this.$e));
                }
                this.L$0 = SpillingKt.nullOutSpilledVariable(unknownError);
                this.label = 1;
                if (this.$jobService.jobFailed(this.$jobID, null, unknownError, this) == coroutine_suspended) {
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

    public final Object triggerNextJob(Context context, JobService jobService, IUserContextManager iUserContextManager, BoxApiPrivate boxApiPrivate, BoxAuthentication boxAuthentication, Continuation<? super Unit> continuation) {
        createUser(iUserContextManager, boxAuthentication, boxApiPrivate, context, ExtensionsKt.getTAG(this));
        Object objRunNextJob = jobService.runNextJob(continuation);
        return objRunNextJob == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objRunNextJob : Unit.INSTANCE;
    }
}
