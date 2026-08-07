package com.box.android.services;

import androidx.datastore.preferences.core.Preferences;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: JobsNotificationService.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.services.JobsNotificationService$knownFailedJobs$2$1", f = "JobsNotificationService.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class JobsNotificationService$knownFailedJobs$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Set<String>>, Object> {
    int label;
    final /* synthetic */ JobsNotificationService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    JobsNotificationService$knownFailedJobs$2$1(JobsNotificationService jobsNotificationService, Continuation<? super JobsNotificationService$knownFailedJobs$2$1> continuation) {
        super(2, continuation);
        this.this$0 = jobsNotificationService;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new JobsNotificationService$knownFailedJobs$2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Set<String>> continuation) {
        return ((JobsNotificationService$knownFailedJobs$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                JobsNotificationService jobsNotificationService = this.this$0;
                this.label = 1;
                obj = FlowKt.first(jobsNotificationService.getJobNotificationDataStore(jobsNotificationService.getContext()).getData(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Object obj2 = ((Preferences) obj).get(this.this$0.getKnownFailedJobsKey());
            Intrinsics.checkNotNull(obj2);
            return CollectionsKt.toMutableSet((Iterable) obj2);
        } catch (Exception unused) {
            return new LinkedHashSet();
        }
    }
}
