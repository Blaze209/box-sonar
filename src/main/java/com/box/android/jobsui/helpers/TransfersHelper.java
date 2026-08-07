package com.box.android.jobsui.helpers;

import android.view.View;
import androidx.lifecycle.ViewModelKt;
import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer;
import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressViewModel;
import com.box.android.base.presentation.presenters.TransferMenuPresenterV2;
import java.util.concurrent.CancellationException;
import javax.inject.Inject;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: TransfersHelper.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/box/android/jobsui/helpers/TransfersHelper;", "", "<init>", "()V", "progressView", "Lcom/box/android/base/presentation/presenters/TransferMenuPresenterV2$TransferMenuProgressView;", "transferMenuPresenter", "Lcom/box/android/base/presentation/presenters/TransferMenuPresenterV2;", "collectorJob", "Lkotlinx/coroutines/Job;", "register", "", "jobsProgressViewModel", "Lcom/box/android/base/presentation/components/topbar/component/jobsprogress/JobsProgressViewModel;", "view", "Landroid/view/View;", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class TransfersHelper {
    public static final int $stable = 8;
    private Job collectorJob;
    private TransferMenuPresenterV2.TransferMenuProgressView progressView;
    private TransferMenuPresenterV2 transferMenuPresenter;

    @Inject
    public TransfersHelper() {
    }

    public final void register(JobsProgressViewModel jobsProgressViewModel, View view) {
        Intrinsics.checkNotNullParameter(jobsProgressViewModel, "jobsProgressViewModel");
        Intrinsics.checkNotNullParameter(view, "view");
        Job job = this.collectorJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        jobsProgressViewModel.getStore().send(JobsProgressReducer.Action.Load.INSTANCE);
        jobsProgressViewModel.getStore().send(JobsProgressReducer.Action.InitProgressIndication.INSTANCE);
        TransferMenuPresenterV2.TransferMenuProgressView transferMenuProgressView = new TransferMenuPresenterV2.TransferMenuProgressView(view);
        this.progressView = transferMenuProgressView;
        TransferMenuPresenterV2 transferMenuPresenterV2 = this.transferMenuPresenter;
        if (transferMenuPresenterV2 == null) {
            TransferMenuPresenterV2.TransferMenuProgressView transferMenuProgressView2 = this.progressView;
            if (transferMenuProgressView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressView");
                transferMenuProgressView2 = null;
            }
            this.transferMenuPresenter = new TransferMenuPresenterV2(transferMenuProgressView2);
        } else if (transferMenuPresenterV2 != null) {
            transferMenuPresenterV2.setTransferProgressView(transferMenuProgressView);
        }
        this.collectorJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(jobsProgressViewModel), null, null, new AnonymousClass1(jobsProgressViewModel, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.jobsui.helpers.TransfersHelper$register$1, reason: invalid class name */
    /* JADX INFO: compiled from: TransfersHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.jobsui.helpers.TransfersHelper$register$1", f = "TransfersHelper.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobsProgressViewModel $jobsProgressViewModel;
        int label;
        final /* synthetic */ TransfersHelper this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(JobsProgressViewModel jobsProgressViewModel, TransfersHelper transfersHelper, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$jobsProgressViewModel = jobsProgressViewModel;
            this.this$0 = transfersHelper;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$jobsProgressViewModel, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.jobsui.helpers.TransfersHelper$register$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TransfersHelper.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        static final class C01761<T> implements FlowCollector {
            final /* synthetic */ TransfersHelper this$0;

            /* JADX INFO: renamed from: com.box.android.jobsui.helpers.TransfersHelper$register$1$1$WhenMappings */
            /* JADX INFO: compiled from: TransfersHelper.kt */
            @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
            public static final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[JobsProgressReducer.JobsCollectiveStatus.values().length];
                    try {
                        iArr[JobsProgressReducer.JobsCollectiveStatus.ERROR.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[JobsProgressReducer.JobsCollectiveStatus.DONE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[JobsProgressReducer.JobsCollectiveStatus.IN_PROGRESS.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            C01761(TransfersHelper transfersHelper) {
                this.this$0 = transfersHelper;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0014  */
            /* JADX WARN: Code restructure failed: missing block: B:46:0x00c3, code lost:
            
                if (r7.updateStatus(r2, r0) == r1) goto L47;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer.State r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
                /*
                    Method dump skipped, instruction units count: 204
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.box.android.jobsui.helpers.TransfersHelper.AnonymousClass1.C01761.emit(com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer$State, kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                return emit((JobsProgressReducer.State) obj, (Continuation<? super Unit>) continuation);
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$jobsProgressViewModel.getStore().getState().collect(new C01761(this.this$0), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            throw new KotlinNothingValueException();
        }
    }
}
