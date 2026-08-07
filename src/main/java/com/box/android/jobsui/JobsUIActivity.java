package com.box.android.jobsui;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.activity.compose.ComponentActivityKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.base.cpl.IPreviewLauncher;
import com.box.android.base.presentation.utilities.EdgeToEdgeUtils;
import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.Store;
import com.box.android.domain.models.preview.PreviewSource;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: JobsUIActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u000f\u0010\"\u001a\u0004\u0018\u00010#H\u0014¢\u0006\u0002\u0010$R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006%"}, d2 = {"Lcom/box/android/jobsui/JobsUIActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "itemActionHandlerFactory", "Lcom/box/android/base/presentation/utilities/IItemActionHandler$Factory;", "getItemActionHandlerFactory", "()Lcom/box/android/base/presentation/utilities/IItemActionHandler$Factory;", "setItemActionHandlerFactory", "(Lcom/box/android/base/presentation/utilities/IItemActionHandler$Factory;)V", "appIntentServices", "Lcom/box/android/coreservices/services/IntentServices;", "getAppIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "setAppIntentServices", "(Lcom/box/android/coreservices/services/IntentServices;)V", "previewHelper", "Lcom/box/android/base/cpl/IPreviewLauncher;", "getPreviewHelper", "()Lcom/box/android/base/cpl/IPreviewLauncher;", "setPreviewHelper", "(Lcom/box/android/base/cpl/IPreviewLauncher;)V", "itemActionHandler", "Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "jobsVM", "Lcom/box/android/jobsui/JobsUIViewModel;", "getJobsVM", "()Lcom/box/android/jobsui/JobsUIViewModel;", "jobsVM$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "jobsui_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class JobsUIActivity extends Hilt_JobsUIActivity {
    public static final int $stable = 8;

    @Inject
    public IntentServices appIntentServices;
    private IItemActionHandler itemActionHandler;

    @Inject
    public IItemActionHandler.Factory itemActionHandlerFactory;

    /* JADX INFO: renamed from: jobsVM$delegate, reason: from kotlin metadata */
    private final Lazy jobsVM;

    @Inject
    public IPreviewLauncher previewHelper;

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public JobsUIActivity() {
        final JobsUIActivity jobsUIActivity = this;
        final Function0 function0 = null;
        this.jobsVM = new ViewModelLazy(Reflection.getOrCreateKotlinClass(JobsUIViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.jobsui.JobsUIActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return jobsUIActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.jobsui.JobsUIActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return jobsUIActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.jobsui.JobsUIActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? jobsUIActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    public final IItemActionHandler.Factory getItemActionHandlerFactory() {
        IItemActionHandler.Factory factory = this.itemActionHandlerFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemActionHandlerFactory");
        return null;
    }

    public final void setItemActionHandlerFactory(IItemActionHandler.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.itemActionHandlerFactory = factory;
    }

    public final IntentServices getAppIntentServices() {
        IntentServices intentServices = this.appIntentServices;
        if (intentServices != null) {
            return intentServices;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appIntentServices");
        return null;
    }

    public final void setAppIntentServices(IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(intentServices, "<set-?>");
        this.appIntentServices = intentServices;
    }

    public final IPreviewLauncher getPreviewHelper() {
        IPreviewLauncher iPreviewLauncher = this.previewHelper;
        if (iPreviewLauncher != null) {
            return iPreviewLauncher;
        }
        Intrinsics.throwUninitializedPropertyAccessException("previewHelper");
        return null;
    }

    public final void setPreviewHelper(IPreviewLauncher iPreviewLauncher) {
        Intrinsics.checkNotNullParameter(iPreviewLauncher, "<set-?>");
        this.previewHelper = iPreviewLauncher;
    }

    private final JobsUIViewModel getJobsVM() {
        return (JobsUIViewModel) this.jobsVM.getValue();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        this.itemActionHandler = getItemActionHandlerFactory().create(this);
        OnBackPressedDispatcherKt.addCallback$default(getOnBackPressedDispatcher(), this, false, new Function1() { // from class: com.box.android.jobsui.JobsUIActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return JobsUIActivity.onCreate$lambda$0(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
        if (this.mFeatureFlips.getMainScreenRedesign().getEnabled()) {
            EdgeToEdge.enable$default(this, null, null, 3, null);
        } else {
            EdgeToEdgeUtils.INSTANCE.enableDarkEdgeToEdge(this);
        }
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(714068297, true, new Function2() { // from class: com.box.android.jobsui.JobsUIActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return JobsUIActivity.onCreate$lambda$1(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(JobsUIActivity jobsUIActivity, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        if (jobsUIActivity.getJobsVM().getStore().getState().getValue().isActionMode()) {
            jobsUIActivity.getJobsVM().getStore().send(JobsReducer.Action.ExitActionMode.INSTANCE);
        } else {
            jobsUIActivity.getJobsVM().getStore().send(JobsReducer.Action.CloseScreen.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(final JobsUIActivity jobsUIActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C53@1806L12,54@1855L1035,51@1724L1265:JobsUIActivity.kt#6w6mzd");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(714068297, i, -1, "com.box.android.jobsui.JobsUIActivity.onCreate.<anonymous> (JobsUIActivity.kt:51)");
            }
            Store<JobsReducer.State, JobsReducer.Action> store = jobsUIActivity.getJobsVM().getStore();
            ComposerKt.sourceInformationMarkerStart(composer, -975130859, "CC(remember):JobsUIActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(jobsUIActivity);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.jobsui.JobsUIActivity$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return JobsUIActivity.onCreate$lambda$1$0$0(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -975128268, "CC(remember):JobsUIActivity.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(jobsUIActivity);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.jobsui.JobsUIActivity$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return JobsUIActivity.onCreate$lambda$1$1$0(this.f$0, (JobPreview) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            JobListingScreenKt.JobsUIScreen(store, function0, (Function1) objRememberedValue2, jobsUIActivity.mFeatureFlips.getMainScreenRedesign().getEnabled(), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1$0$0(JobsUIActivity jobsUIActivity) {
        jobsUIActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1$1$0(JobsUIActivity jobsUIActivity, JobPreview jobPreview) {
        IItemActionHandler iItemActionHandler;
        IItemActionHandler iItemActionHandler2;
        if (jobPreview == null) {
            return Unit.INSTANCE;
        }
        if (jobPreview instanceof JobPreview.BoxPreview) {
            IItemActionHandler iItemActionHandler3 = jobsUIActivity.itemActionHandler;
            if (iItemActionHandler3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemActionHandler");
                iItemActionHandler2 = null;
            } else {
                iItemActionHandler2 = iItemActionHandler3;
            }
            IItemActionHandler.onItemClick$default(iItemActionHandler2, ((JobPreview.BoxPreview) jobPreview).getFileModel(), false, PreviewSource.Transfers.INSTANCE, 2, null);
        } else if (jobPreview instanceof JobPreview.PendingItemPreview) {
            JobPreview.PendingItemPreview pendingItemPreview = (JobPreview.PendingItemPreview) jobPreview;
            if (pendingItemPreview.getFileModel() != null) {
                IPreviewLauncher.launchPreview$default(jobsUIActivity.getPreviewHelper(), new IPreviewLauncher.NavigationData(jobsUIActivity, pendingItemPreview.getFileModel(), PreviewSource.Transfers.INSTANCE, null, null, false, false, 120, null), null, null, 6, null);
            }
        } else {
            if (!(jobPreview instanceof JobPreview.FolderPreview)) {
                throw new NoWhenBranchMatchedException();
            }
            IItemActionHandler iItemActionHandler4 = jobsUIActivity.itemActionHandler;
            if (iItemActionHandler4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemActionHandler");
                iItemActionHandler = null;
            } else {
                iItemActionHandler = iItemActionHandler4;
            }
            IItemActionHandler.onItemClick$default(iItemActionHandler, ((JobPreview.FolderPreview) jobPreview).getFolder(), false, null, 6, null);
        }
        return Unit.INSTANCE;
    }
}
