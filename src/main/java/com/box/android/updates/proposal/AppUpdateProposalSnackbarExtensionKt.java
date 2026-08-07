package com.box.android.updates.proposal;

import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.updates.R;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: AppUpdateProposalSnackbarExtension.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0004H\u0002\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¨\u0006\b"}, d2 = {"registerForUpdateDownloadedSnackbar", "", "Lcom/box/android/updates/proposal/AppUpdateProposalManager;", "activity", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "showDownloadingInProgressSnackbar", "showDownloadCompleteSnackbar", "manager", "app-updates_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AppUpdateProposalSnackbarExtensionKt {

    /* JADX INFO: renamed from: com.box.android.updates.proposal.AppUpdateProposalSnackbarExtensionKt$registerForUpdateDownloadedSnackbar$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppUpdateProposalSnackbarExtension.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.updates.proposal.AppUpdateProposalSnackbarExtensionKt$registerForUpdateDownloadedSnackbar$1", f = "AppUpdateProposalSnackbarExtension.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BoxFragmentActivity $activity;
        final /* synthetic */ AppUpdateProposalManager $this_registerForUpdateDownloadedSnackbar;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BoxFragmentActivity boxFragmentActivity, AppUpdateProposalManager appUpdateProposalManager, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = boxFragmentActivity;
            this.$this_registerForUpdateDownloadedSnackbar = appUpdateProposalManager;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$activity, this.$this_registerForUpdateDownloadedSnackbar, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.updates.proposal.AppUpdateProposalSnackbarExtensionKt$registerForUpdateDownloadedSnackbar$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: AppUpdateProposalSnackbarExtension.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.updates.proposal.AppUpdateProposalSnackbarExtensionKt$registerForUpdateDownloadedSnackbar$1$1", f = "AppUpdateProposalSnackbarExtension.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ BoxFragmentActivity $activity;
            final /* synthetic */ AppUpdateProposalManager $this_registerForUpdateDownloadedSnackbar;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01911(AppUpdateProposalManager appUpdateProposalManager, BoxFragmentActivity boxFragmentActivity, Continuation<? super C01911> continuation) {
                super(2, continuation);
                this.$this_registerForUpdateDownloadedSnackbar = appUpdateProposalManager;
                this.$activity = boxFragmentActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01911 c01911 = new C01911(this.$this_registerForUpdateDownloadedSnackbar, this.$activity, continuation);
                c01911.L$0 = obj;
                return c01911;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.box.android.updates.proposal.AppUpdateProposalSnackbarExtensionKt$registerForUpdateDownloadedSnackbar$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: AppUpdateProposalSnackbarExtension.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.updates.proposal.AppUpdateProposalSnackbarExtensionKt$registerForUpdateDownloadedSnackbar$1$1$1", f = "AppUpdateProposalSnackbarExtension.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class C01921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ BoxFragmentActivity $activity;
                final /* synthetic */ AppUpdateProposalManager $this_registerForUpdateDownloadedSnackbar;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01921(AppUpdateProposalManager appUpdateProposalManager, BoxFragmentActivity boxFragmentActivity, Continuation<? super C01921> continuation) {
                    super(2, continuation);
                    this.$this_registerForUpdateDownloadedSnackbar = appUpdateProposalManager;
                    this.$activity = boxFragmentActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01921(this.$this_registerForUpdateDownloadedSnackbar, this.$activity, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        SharedFlow<Unit> updateDownloadingEventFlow = this.$this_registerForUpdateDownloadedSnackbar.getUpdateDownloadingEventFlow();
                        final BoxFragmentActivity boxFragmentActivity = this.$activity;
                        this.label = 1;
                        if (updateDownloadingEventFlow.collect(new FlowCollector() { // from class: com.box.android.updates.proposal.AppUpdateProposalSnackbarExtensionKt.registerForUpdateDownloadedSnackbar.1.1.1.1
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                                return emit((Unit) obj2, (Continuation<? super Unit>) continuation);
                            }

                            public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                                AppUpdateProposalSnackbarExtensionKt.showDownloadingInProgressSnackbar(boxFragmentActivity);
                                return Unit.INSTANCE;
                            }
                        }, this) == coroutine_suspended) {
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

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C01921(this.$this_registerForUpdateDownloadedSnackbar, this.$activity, null), 3, null);
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass2(this.$this_registerForUpdateDownloadedSnackbar, this.$activity, null), 3, null);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            /* JADX INFO: renamed from: com.box.android.updates.proposal.AppUpdateProposalSnackbarExtensionKt$registerForUpdateDownloadedSnackbar$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: AppUpdateProposalSnackbarExtension.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
            @DebugMetadata(c = "com.box.android.updates.proposal.AppUpdateProposalSnackbarExtensionKt$registerForUpdateDownloadedSnackbar$1$1$2", f = "AppUpdateProposalSnackbarExtension.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {}, v = 1)
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ BoxFragmentActivity $activity;
                final /* synthetic */ AppUpdateProposalManager $this_registerForUpdateDownloadedSnackbar;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(AppUpdateProposalManager appUpdateProposalManager, BoxFragmentActivity boxFragmentActivity, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.$this_registerForUpdateDownloadedSnackbar = appUpdateProposalManager;
                    this.$activity = boxFragmentActivity;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.$this_registerForUpdateDownloadedSnackbar, this.$activity, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        StateFlow<Boolean> updateDownloadedStateFlow = this.$this_registerForUpdateDownloadedSnackbar.getUpdateDownloadedStateFlow();
                        final BoxFragmentActivity boxFragmentActivity = this.$activity;
                        final AppUpdateProposalManager appUpdateProposalManager = this.$this_registerForUpdateDownloadedSnackbar;
                        this.label = 1;
                        if (updateDownloadedStateFlow.collect(new FlowCollector() { // from class: com.box.android.updates.proposal.AppUpdateProposalSnackbarExtensionKt.registerForUpdateDownloadedSnackbar.1.1.2.1
                            @Override // kotlinx.coroutines.flow.FlowCollector
                            public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                                return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                            }

                            public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                                if (z) {
                                    AppUpdateProposalSnackbarExtensionKt.showDownloadCompleteSnackbar(boxFragmentActivity, appUpdateProposalManager);
                                }
                                return Unit.INSTANCE;
                            }
                        }, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(this.$activity, Lifecycle.State.STARTED, new C01911(this.$this_registerForUpdateDownloadedSnackbar, this.$activity, null), this) == coroutine_suspended) {
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

    public static final void registerForUpdateDownloadedSnackbar(AppUpdateProposalManager appUpdateProposalManager, BoxFragmentActivity activity) {
        Intrinsics.checkNotNullParameter(appUpdateProposalManager, "<this>");
        Intrinsics.checkNotNullParameter(activity, "activity");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(activity), null, null, new AnonymousClass1(activity, appUpdateProposalManager, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDownloadingInProgressSnackbar(BoxFragmentActivity boxFragmentActivity) {
        boxFragmentActivity.displaySnackbar(R.string.app_update_proposal_downloading_message, 0, (View.OnClickListener) null, -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showDownloadCompleteSnackbar(BoxFragmentActivity boxFragmentActivity, final AppUpdateProposalManager appUpdateProposalManager) {
        boxFragmentActivity.displaySnackbar(R.string.app_update_proposal_downloaded_message, R.string.app_update_proposal_downloaded_restart_action, new View.OnClickListener() { // from class: com.box.android.updates.proposal.AppUpdateProposalSnackbarExtensionKt$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                appUpdateProposalManager.completeUpdate();
            }
        });
    }
}
