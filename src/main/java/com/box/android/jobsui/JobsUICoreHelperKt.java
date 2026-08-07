package com.box.android.jobsui;

import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.JobInfo;
import com.box.android.domain.models.JobInfoKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: JobsUICoreHelper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a6\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00040\u00032\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0006H\u0087@¢\u0006\u0002\u0010\t\u001a\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0007H\u0002¨\u0006\f"}, d2 = {"mapJobInfoStatusForUI", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/box/android/jobsui/JobStatusUIState;", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/models/JobInfo$Status;", "decodeError", "Lkotlin/Function1;", "Lcom/box/android/domain/models/DomainError;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDefaultErrorText", "error", "jobsui_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class JobsUICoreHelperKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String getDefaultErrorText(DomainError domainError) {
        if (domainError instanceof DomainError.CustomError) {
            return ((DomainError.CustomError) domainError).getMessage();
        }
        if (domainError instanceof DomainError.APIRequestError) {
            if (StringsKt.contains$default((CharSequence) ((DomainError.APIRequestError) domainError).getMessage(), (CharSequence) "accept custom terms of service", false, 2, (Object) null)) {
                return CommonBoxUtil.LS(R.string.job_item_error_type_terms_of_service);
            }
            return CommonBoxUtil.LS(R.string.job_item_error_type_generic_exception);
        }
        return CommonBoxUtil.LS(R.string.job_item_error_type_generic_exception);
    }

    public static final Object mapJobInfoStatusForUI(final Flow<? extends JobInfo.Status> flow, final Function1<? super DomainError, String> function1, Continuation<? super StateFlow<JobStatusUIState>> continuation) {
        return FlowKt.stateIn(new Flow<JobStatusUIState>() { // from class: com.box.android.jobsui.JobsUICoreHelperKt$mapJobInfoStatusForUI$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super JobStatusUIState> flowCollector, Continuation continuation2) {
                Object objCollect = flow.collect(new AnonymousClass2(flowCollector, function1), continuation2);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.jobsui.JobsUICoreHelperKt$mapJobInfoStatusForUI$$inlined$map$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ Function1 $decodeError$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.jobsui.JobsUICoreHelperKt$mapJobInfoStatusForUI$$inlined$map$1$2$1, reason: invalid class name */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.jobsui.JobsUICoreHelperKt$mapJobInfoStatusForUI$$inlined$map$1$2", f = "JobsUICoreHelper.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
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

                public AnonymousClass2(FlowCollector flowCollector, Function1 function1) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$decodeError$inlined = function1;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                public final Object emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    JobStatusUIState jobStatusUIState;
                    String defaultErrorText;
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
                        JobInfo.Status status = (JobInfo.Status) obj;
                        if (status instanceof JobInfo.Status.Running) {
                            JobInfo.Progress progress = ((JobInfo.Status.Running) status).getProgress();
                            jobStatusUIState = new JobStatusUIState(progress != null ? Boxing.boxFloat(JobInfoKt.progressInPercents(progress)) : null, status, null, 4, null);
                        } else if (status instanceof JobInfo.Status.Failed) {
                            Function1 function1 = this.$decodeError$inlined;
                            if (function1 == null || (defaultErrorText = (String) function1.invoke(((JobInfo.Status.Failed) status).getError())) == null) {
                                defaultErrorText = JobsUICoreHelperKt.getDefaultErrorText(((JobInfo.Status.Failed) status).getError());
                            }
                            jobStatusUIState = new JobStatusUIState(Boxing.boxFloat(1.0f), status, defaultErrorText);
                        } else if (status instanceof JobInfo.Status.Succeeded) {
                            jobStatusUIState = new JobStatusUIState(Boxing.boxFloat(1.0f), status, null, 4, null);
                        } else {
                            jobStatusUIState = new JobStatusUIState(Boxing.boxFloat(0.0f), status, null, 4, null);
                        }
                        anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                        anonymousClass1.I$0 = 0;
                        anonymousClass1.label = 1;
                        if (flowCollector.emit(jobStatusUIState, anonymousClass1) == coroutine_suspended) {
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
        }, CoroutineScopeKt.CoroutineScope(continuation.get$context()), continuation);
    }
}
