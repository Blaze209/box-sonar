package com.box.android.capture;

import androidx.lifecycle.Observer;
import com.box.android.base.databinding.FragmentItemListingBinding;
import com.box.android.base.presentation.fragments.BaseListingAbstractFragment;
import com.box.android.base.presentation.presenters.BaseListingPresenter;
import com.box.android.base.vm.BaseListingViewModel;
import com.box.android.capture.cpl.CaptureReducer;
import com.box.android.capture.viewmodel.CaptureHistoryViewModel;
import com.box.android.capture.viewmodel.CaptureViewModel;
import com.box.android.common.utilities.ErrorEvent;
import com.box.android.common.utilities.SingleEventObserver;
import com.box.android.data.jobs.JobWorker;
import com.box.android.domain.jobs.JobId;
import com.box.android.domain.models.CaptureHistoryModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.PermissionsModel;
import com.box.android.domain.utils.result.Result;
import com.pspdfkit.BuildConfig;
import java.util.List;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;

/* JADX INFO: compiled from: CaptureHistoryPresenter.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00030\u0001B'\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010\u001cJ\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0096@¢\u0006\u0002\u0010\u001cJ\b\u0010 \u001a\u00020!H\u0014J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003H\u0014J\b\u0010\"\u001a\u00020#H\u0014J\u0014\u0010$\u001a\u00020\u00182\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&J\u0006\u0010'\u001a\u00020\u0018J\u000e\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*J\u001a\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00060"}, d2 = {"Lcom/box/android/capture/CaptureHistoryPresenter;", "Lcom/box/android/base/presentation/presenters/BaseListingPresenter;", "Lcom/box/android/domain/models/CaptureHistoryModel;", "Lcom/box/android/base/presentation/fragments/BaseListingAbstractFragment;", "Lcom/box/android/base/databinding/FragmentItemListingBinding;", BuildConfig.FLAVOR, "Lcom/box/android/capture/CaptureHistoryFragment;", "captureHistoryViewModel", "Lcom/box/android/capture/viewmodel/CaptureHistoryViewModel;", "captureViewModel", "Lcom/box/android/capture/viewmodel/CaptureViewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lcom/box/android/capture/CaptureHistoryFragment;Lcom/box/android/capture/viewmodel/CaptureHistoryViewModel;Lcom/box/android/capture/viewmodel/CaptureViewModel;Lkotlinx/coroutines/CoroutineScope;)V", "getFragment", "()Lcom/box/android/capture/CaptureHistoryFragment;", "getCaptureHistoryViewModel", "()Lcom/box/android/capture/viewmodel/CaptureHistoryViewModel;", "getCaptureViewModel", "()Lcom/box/android/capture/viewmodel/CaptureViewModel;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "onViewCreate", "", "isContentAvailable", "", "refresh", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchItems", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/DomainError;", "getViewModel", "Lcom/box/android/base/vm/BaseListingViewModel;", "getRefreshEventName", "", "deleteCaptureHistoryItems", "selectedItems", "", "retryAllFailedJobs", "updateUploadFolder", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "retryJob", JobWorker.JOB_ID_PARAM, "Lcom/box/android/domain/jobs/JobId;", "itemId", "Lcom/box/android/domain/models/ItemId;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureHistoryPresenter extends BaseListingPresenter<CaptureHistoryModel, BaseListingAbstractFragment<CaptureHistoryModel, FragmentItemListingBinding>> {
    public static final int $stable = 8;
    private final CaptureHistoryViewModel captureHistoryViewModel;
    private final CaptureViewModel captureViewModel;
    private final CaptureHistoryFragment fragment;
    private final CoroutineScope scope;

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    public Object fetchItems(Continuation<? super Result<Boolean, ? extends DomainError>> continuation) {
        return null;
    }

    public CaptureHistoryPresenter(CaptureHistoryFragment fragment, CaptureHistoryViewModel captureHistoryViewModel, CaptureViewModel captureViewModel, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(captureHistoryViewModel, "captureHistoryViewModel");
        Intrinsics.checkNotNullParameter(captureViewModel, "captureViewModel");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.fragment = fragment;
        this.captureHistoryViewModel = captureHistoryViewModel;
        this.captureViewModel = captureViewModel;
        this.scope = scope;
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    public final CaptureHistoryFragment getFragment() {
        return this.fragment;
    }

    public final CaptureHistoryViewModel getCaptureHistoryViewModel() {
        return this.captureHistoryViewModel;
    }

    public final CaptureViewModel getCaptureViewModel() {
        return this.captureViewModel;
    }

    public final CoroutineScope getScope() {
        return this.scope;
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    public void onViewCreate() {
        this.captureHistoryViewModel.getUploadedFiles().observe(this.fragment.getViewLifecycleOwner(), new Observer() { // from class: com.box.android.capture.CaptureHistoryPresenter$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CaptureHistoryPresenter.onViewCreate$lambda$0(this.f$0, (List) obj);
            }
        });
        this.captureHistoryViewModel.getPendingJobs().observe(this.fragment.getViewLifecycleOwner(), new Observer() { // from class: com.box.android.capture.CaptureHistoryPresenter$$ExternalSyntheticLambda1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CaptureHistoryPresenter.onViewCreate$lambda$1(this.f$0, (List) obj);
            }
        });
        this.captureHistoryViewModel.getErrorLiveData().observe(this.fragment.getViewLifecycleOwner(), new SingleEventObserver(new Function1() { // from class: com.box.android.capture.CaptureHistoryPresenter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CaptureHistoryPresenter.onViewCreate$lambda$2(this.f$0, (ErrorEvent) obj);
            }
        }));
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AnonymousClass4(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreate$lambda$0(CaptureHistoryPresenter captureHistoryPresenter, List list) {
        CaptureHistoryFragment captureHistoryFragment = captureHistoryPresenter.fragment;
        Intrinsics.checkNotNull(list);
        captureHistoryFragment.updateUploadedFiles(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreate$lambda$1(CaptureHistoryPresenter captureHistoryPresenter, List list) {
        CaptureHistoryFragment captureHistoryFragment = captureHistoryPresenter.fragment;
        Intrinsics.checkNotNull(list);
        captureHistoryFragment.updatePendingFiles(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreate$lambda$2(CaptureHistoryPresenter captureHistoryPresenter, ErrorEvent errorEvent) {
        CaptureHistoryFragment captureHistoryFragment = captureHistoryPresenter.fragment;
        Intrinsics.checkNotNull(errorEvent);
        captureHistoryFragment.handleError(errorEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.capture.CaptureHistoryPresenter$onViewCreate$4, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureHistoryPresenter.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.CaptureHistoryPresenter$onViewCreate$4", f = "CaptureHistoryPresenter.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CaptureHistoryPresenter.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<CaptureReducer.State> state = CaptureHistoryPresenter.this.getCaptureViewModel().getStore().getState();
                final CaptureHistoryPresenter captureHistoryPresenter = CaptureHistoryPresenter.this;
                this.label = 1;
                if (state.collect(new FlowCollector() { // from class: com.box.android.capture.CaptureHistoryPresenter.onViewCreate.4.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((CaptureReducer.State) obj2, (Continuation<? super Unit>) continuation);
                    }

                    /* JADX WARN: Code duplicated, block: B:11:0x0023  */
                    public final Object emit(CaptureReducer.State state2, Continuation<? super Unit> continuation) {
                        boolean z;
                        FolderModel selectedFolder = state2.getSelectedFolder();
                        boolean z2 = true;
                        if ((selectedFolder != null ? selectedFolder.getPermissions() : null) != null) {
                            PermissionsModel permissions = state2.getSelectedFolder().getPermissions();
                            Intrinsics.checkNotNull(permissions);
                            if (permissions.getCanUpload()) {
                                z = false;
                            } else {
                                z = true;
                            }
                        } else {
                            z = false;
                        }
                        CaptureHistoryFragment fragment = captureHistoryPresenter.getFragment();
                        if (state2.getFolderError() == null && !z) {
                            z2 = false;
                        }
                        fragment.updateChangeFolderBanner(z2);
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

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    public boolean isContentAvailable() {
        return (this.captureHistoryViewModel.getUploadedFiles().getValue() == null || this.captureHistoryViewModel.getPendingJobs().getValue() == null) ? false : true;
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    public Object refresh(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    protected BaseListingViewModel getViewModel() {
        return this.captureHistoryViewModel;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    public BaseListingAbstractFragment<CaptureHistoryModel, FragmentItemListingBinding> getFragment() {
        return this.fragment;
    }

    @Override // com.box.android.base.presentation.presenters.BaseListingPresenter
    protected String getRefreshEventName() {
        return "";
    }

    public final void deleteCaptureHistoryItems(Set<CaptureHistoryModel> selectedItems) {
        Intrinsics.checkNotNullParameter(selectedItems, "selectedItems");
        if (selectedItems.isEmpty()) {
            return;
        }
        this.captureHistoryViewModel.deleteCaptureHistoryItems(selectedItems);
    }

    public final void retryAllFailedJobs() {
        ItemId itemId;
        FolderModel selectedFolder = this.captureViewModel.getStore().getState().getValue().getSelectedFolder();
        if (selectedFolder != null && (itemId = selectedFolder.getItemId()) != null) {
            this.captureHistoryViewModel.changeFolderForNonRunningJobsAndRetry(itemId);
        } else {
            this.captureHistoryViewModel.retryAllFailedJobs();
        }
    }

    public final void updateUploadFolder(FolderModel folder) {
        Intrinsics.checkNotNullParameter(folder, "folder");
        this.captureViewModel.getStore().send(new CaptureReducer.Action.UpdateFolder(folder));
        this.captureHistoryViewModel.changeFolderForNonRunningJobsAndRetry(folder.getItemId());
    }

    public static /* synthetic */ void retryJob$default(CaptureHistoryPresenter captureHistoryPresenter, JobId jobId, ItemId itemId, int i, Object obj) {
        if ((i & 2) != 0) {
            itemId = null;
        }
        captureHistoryPresenter.retryJob(jobId, itemId);
    }

    public final void retryJob(JobId jobId, ItemId itemId) {
        ItemId itemId2;
        Intrinsics.checkNotNullParameter(jobId, "jobId");
        if (itemId != null) {
            FolderModel selectedFolder = this.captureViewModel.getStore().getState().getValue().getSelectedFolder();
            if (selectedFolder != null && (itemId2 = selectedFolder.getItemId()) != null) {
                this.captureHistoryViewModel.changeParentFolderOfJobAndRetry(jobId, itemId, itemId2);
                return;
            } else {
                this.captureHistoryViewModel.retryJob(jobId);
                return;
            }
        }
        this.captureHistoryViewModel.retryJob(jobId);
    }
}
