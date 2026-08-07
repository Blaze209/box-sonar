package com.box.android.browse.activities;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.activity.compose.ComponentActivityKt;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.box.android.browse.R;
import com.box.android.browse.cpl.itempicker.ItemPickerReducer;
import com.box.android.browse.cpl.itempicker.ItemPickerScreenKt;
import com.box.android.browse.cpl.itempicker.ItemPickerViewModel;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.coreservices.jobmanager.dao.BoxUploadFile;
import com.box.android.coreservices.jobmanager.dao.UploadModelBoxFile;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.models.BoxStaticUploadModel;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.Store;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.lifecycle.HiltViewModelExtensions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: UploadToFolderActivity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\b\u0007\u0018\u0000 V2\u00020\u0001:\u0001VB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u00104\u001a\u0004\u0018\u000105H\u0014¢\u0006\u0002\u00106J\u0012\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\b\u0010;\u001a\u00020<H\u0016J\u0006\u0010=\u001a\u000208J\b\u0010>\u001a\u000208H\u0002J\u0010\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020AH\u0002J\b\u0010F\u001a\u000208H\u0016J\b\u0010G\u001a\u000208H\u0016J8\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020C2\u0006\u0010M\u001a\u00020C2\u0016\u0010N\u001a\u0012\u0012\u0004\u0012\u00020P0Oj\b\u0012\u0004\u0012\u00020P`QH\u0002J\u0010\u0010T\u001a\u0002082\u0006\u0010U\u001a\u00020CH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010.\u001a\u00020/8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b0\u00101R\u0014\u0010B\u001a\u00020C8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bD\u0010ER\u000e\u0010R\u001a\u00020SX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W²\u0006\n\u0010X\u001a\u00020YX\u008a\u0084\u0002"}, d2 = {"Lcom/box/android/browse/activities/UploadToFolderActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "mHandler", "Landroid/os/Handler;", "mBoxFolderApi", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "getMBoxFolderApi", "()Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "setMBoxFolderApi", "(Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;)V", "mBoxFileApi", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;", "getMBoxFileApi", "()Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;", "setMBoxFileApi", "(Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFile;)V", "mLocalItemService", "Lcom/box/android/domain/services/ILocalItemService;", "getMLocalItemService", "()Lcom/box/android/domain/services/ILocalItemService;", "setMLocalItemService", "(Lcom/box/android/domain/services/ILocalItemService;)V", "mBaseModelController", "Lcom/box/android/coreservices/modelcontroller/IBaseModelController;", "getMBaseModelController", "()Lcom/box/android/coreservices/modelcontroller/IBaseModelController;", "setMBaseModelController", "(Lcom/box/android/coreservices/modelcontroller/IBaseModelController;)V", "jobSource", "Lcom/box/android/domain/usecases/jobs/JobTags$JobSource;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "setIntentServices", "(Lcom/box/android/coreservices/services/IntentServices;)V", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "mSelectedFolder", "Lcom/box/androidsdk/content/models/BoxFolder;", "itemPickerViewModel", "Lcom/box/android/browse/cpl/itempicker/ItemPickerViewModel;", "getItemPickerViewModel", "()Lcom/box/android/browse/cpl/itempicker/ItemPickerViewModel;", "itemPickerViewModel$delegate", "Lkotlin/Lazy;", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "onBoxCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "amplitudeSetCurrentPage", "", "setupUI", "setupItemPickerUI", "onInviteCollaborators", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "toolbarSubtitle", "", "getToolbarSubtitle", "()Ljava/lang/String;", "onBoxResume", "onDestroy", "createFileNameConflictAlert", "Landroidx/appcompat/app/AlertDialog;", "context", "Landroid/app/Activity;", "warningTitle", "warningMessage", "nameConflictFiles", "Ljava/util/ArrayList;", "Lcom/box/android/coreservices/jobmanager/dao/UploadModelBoxFile;", "Lkotlin/collections/ArrayList;", "mPartialErrorListener", "Landroid/content/DialogInterface$OnDismissListener;", "tryUpload", "folderId", "Companion", "browse_generalProdRelease", "state", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class UploadToFolderActivity extends Hilt_UploadToFolderActivity {
    private static final String EXTRA_DISABLE_FILES = "extraShowOnlyFolders";
    private static final String EXTRA_EVENT_CODE = "extraEventCode";
    private static final String EXTRA_FOLDER = "extraFolder";
    private static final int MAX_UPLOAD_ERRORS_TO_DISPLAY = 5;
    private static final int MAX_UPLOAD_FILE_NAME_DISPLAY_LENGTH = 10;

    @Inject
    public IntentServices intentServices;

    /* JADX INFO: renamed from: itemPickerViewModel$delegate, reason: from kotlin metadata */
    private final Lazy itemPickerViewModel;
    private JobTags.JobSource jobSource;

    @Inject
    public IBaseModelController mBaseModelController;

    @Inject
    public BoxExtendedApiFile mBoxFileApi;

    @Inject
    public BoxExtendedApiFolder mBoxFolderApi;
    private final Handler mHandler = new Handler();

    @Inject
    public ILocalItemService mLocalItemService;
    private final DialogInterface.OnDismissListener mPartialErrorListener;
    private BoxFolder mSelectedFolder;

    @Inject
    public IUserContextManager userContextManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final Intent getLaunchIntent(Context context, String str, JobTags.JobSource jobSource) {
        return INSTANCE.getLaunchIntent(context, str, jobSource);
    }

    @Override // com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity
    public boolean amplitudeSetCurrentPage() {
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public UploadToFolderActivity() {
        final UploadToFolderActivity uploadToFolderActivity = this;
        final Function0<CreationExtras> function0 = new Function0<CreationExtras>() { // from class: com.box.android.browse.activities.UploadToFolderActivity$special$$inlined$viewModelsWithArgs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras defaultViewModelCreationExtras = uploadToFolderActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "<get-defaultViewModelCreationExtras>(...)");
                final UploadToFolderActivity uploadToFolderActivity2 = this;
                return HiltViewModelExtensions.withCreationCallback(defaultViewModelCreationExtras, new Function1<ViewModelAssistedFactory<ItemPickerViewModel>, ViewModel>() { // from class: com.box.android.browse.activities.UploadToFolderActivity$special$$inlined$viewModelsWithArgs$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final ViewModel invoke(ViewModelAssistedFactory<ItemPickerViewModel> factory) {
                        Intrinsics.checkNotNullParameter(factory, "factory");
                        Bundle bundle = new Bundle();
                        bundle.putString(ItemPickerViewModel.STARTING_FOLDER_ID_VM_KEY, "0");
                        bundle.putBoolean(ItemPickerViewModel.DISABLE_NON_FOLDER_ITEMS_VM_KEY, true);
                        bundle.putString("title", uploadToFolderActivity2.getToolbarSubtitle());
                        bundle.putInt(ItemPickerViewModel.SELECT_BUTTON_NAME_VM_KEY, R.string.upload_here);
                        return factory.create(bundle);
                    }
                });
            }
        };
        this.itemPickerViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ItemPickerViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.browse.activities.UploadToFolderActivity$special$$inlined$viewModelsWithArgs$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return uploadToFolderActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.browse.activities.UploadToFolderActivity$special$$inlined$viewModelsWithArgs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return uploadToFolderActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.browse.activities.UploadToFolderActivity$special$$inlined$viewModelsWithArgs$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? uploadToFolderActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
        this.mPartialErrorListener = new DialogInterface.OnDismissListener() { // from class: com.box.android.browse.activities.UploadToFolderActivity$$ExternalSyntheticLambda0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                UploadToFolderActivity.mPartialErrorListener$lambda$0(this.f$0, dialogInterface);
            }
        };
    }

    public final BoxExtendedApiFolder getMBoxFolderApi() {
        BoxExtendedApiFolder boxExtendedApiFolder = this.mBoxFolderApi;
        if (boxExtendedApiFolder != null) {
            return boxExtendedApiFolder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBoxFolderApi");
        return null;
    }

    public final void setMBoxFolderApi(BoxExtendedApiFolder boxExtendedApiFolder) {
        Intrinsics.checkNotNullParameter(boxExtendedApiFolder, "<set-?>");
        this.mBoxFolderApi = boxExtendedApiFolder;
    }

    public final BoxExtendedApiFile getMBoxFileApi() {
        BoxExtendedApiFile boxExtendedApiFile = this.mBoxFileApi;
        if (boxExtendedApiFile != null) {
            return boxExtendedApiFile;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBoxFileApi");
        return null;
    }

    public final void setMBoxFileApi(BoxExtendedApiFile boxExtendedApiFile) {
        Intrinsics.checkNotNullParameter(boxExtendedApiFile, "<set-?>");
        this.mBoxFileApi = boxExtendedApiFile;
    }

    public final ILocalItemService getMLocalItemService() {
        ILocalItemService iLocalItemService = this.mLocalItemService;
        if (iLocalItemService != null) {
            return iLocalItemService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mLocalItemService");
        return null;
    }

    public final void setMLocalItemService(ILocalItemService iLocalItemService) {
        Intrinsics.checkNotNullParameter(iLocalItemService, "<set-?>");
        this.mLocalItemService = iLocalItemService;
    }

    public final IBaseModelController getMBaseModelController() {
        IBaseModelController iBaseModelController = this.mBaseModelController;
        if (iBaseModelController != null) {
            return iBaseModelController;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBaseModelController");
        return null;
    }

    public final void setMBaseModelController(IBaseModelController iBaseModelController) {
        Intrinsics.checkNotNullParameter(iBaseModelController, "<set-?>");
        this.mBaseModelController = iBaseModelController;
    }

    public final IntentServices getIntentServices() {
        IntentServices intentServices = this.intentServices;
        if (intentServices != null) {
            return intentServices;
        }
        Intrinsics.throwUninitializedPropertyAccessException("intentServices");
        return null;
    }

    public final void setIntentServices(IntentServices intentServices) {
        Intrinsics.checkNotNullParameter(intentServices, "<set-?>");
        this.intentServices = intentServices;
    }

    public final IUserContextManager getUserContextManager() {
        IUserContextManager iUserContextManager = this.userContextManager;
        if (iUserContextManager != null) {
            return iUserContextManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userContextManager");
        return null;
    }

    public final void setUserContextManager(IUserContextManager iUserContextManager) {
        Intrinsics.checkNotNullParameter(iUserContextManager, "<set-?>");
        this.userContextManager = iUserContextManager;
    }

    private final ItemPickerViewModel getItemPickerViewModel() {
        return (ItemPickerViewModel) this.itemPickerViewModel.getValue();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle savedInstanceState) {
        this.mSelectedFolder = null;
        if (getIntent() != null) {
            this.mSelectedFolder = (BoxFolder) getIntent().getSerializableExtra("extraFolder");
            this.jobSource = (JobTags.JobSource) getIntent().getSerializableExtra(EXTRA_EVENT_CODE);
        }
        super.onBoxCreate(savedInstanceState);
        setupUI();
    }

    public final void setupUI() {
        BoxFolder boxFolder = this.mSelectedFolder;
        if (boxFolder == null) {
            setupItemPickerUI();
            return;
        }
        Intrinsics.checkNotNull(boxFolder);
        String id = boxFolder.getUserId();
        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
        tryUpload(id);
    }

    private final void setupItemPickerUI() {
        ComponentActivityKt.setContent$default(this, null, ComposableLambdaKt.composableLambdaInstance(-563728101, true, new Function2() { // from class: com.box.android.browse.activities.UploadToFolderActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return UploadToFolderActivity.setupItemPickerUI$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setupItemPickerUI$lambda$0(UploadToFolderActivity uploadToFolderActivity, Composer composer, int i) {
        String strBoxIdOrNull;
        ComposerKt.sourceInformation(composer, "C103@4002L29,107@4238L23,108@4289L8,104@4044L267:UploadToFolderActivity.kt#hm5pfm");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-563728101, i, -1, "com.box.android.browse.activities.UploadToFolderActivity.setupItemPickerUI.<anonymous> (UploadToFolderActivity.kt:103)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(uploadToFolderActivity.getItemPickerViewModel().getStore().getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
            Store<ItemPickerReducer.State, ItemPickerReducer.Action> store = uploadToFolderActivity.getItemPickerViewModel().getStore();
            boolean enabled = uploadToFolderActivity.mFeatureFlips.getMainScreenRedesign().getEnabled();
            ComposerKt.sourceInformationMarkerStart(composer, -576816302, "CC(remember):UploadToFolderActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(uploadToFolderActivity);
            UploadToFolderActivity$setupItemPickerUI$1$1$1 uploadToFolderActivity$setupItemPickerUI$1$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || uploadToFolderActivity$setupItemPickerUI$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                uploadToFolderActivity$setupItemPickerUI$1$1$1RememberedValue = new UploadToFolderActivity$setupItemPickerUI$1$1$1(uploadToFolderActivity);
                composer.updateRememberedValue(uploadToFolderActivity$setupItemPickerUI$1$1$1RememberedValue);
            }
            KFunction kFunction = (KFunction) uploadToFolderActivity$setupItemPickerUI$1$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -576814685, "CC(remember):UploadToFolderActivity.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(uploadToFolderActivity);
            UploadToFolderActivity$setupItemPickerUI$1$2$1 uploadToFolderActivity$setupItemPickerUI$1$2$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance2 || uploadToFolderActivity$setupItemPickerUI$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                uploadToFolderActivity$setupItemPickerUI$1$2$1RememberedValue = new UploadToFolderActivity$setupItemPickerUI$1$2$1(uploadToFolderActivity);
                composer.updateRememberedValue(uploadToFolderActivity$setupItemPickerUI$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ItemPickerScreenKt.ItemPickerScreen(store, (Function1) kFunction, (Function0) ((KFunction) uploadToFolderActivity$setupItemPickerUI$1$2$1RememberedValue), enabled, composer, 0, 0);
            ItemModel selectedItem = setupItemPickerUI$lambda$0$0(stateCollectAsStateWithLifecycle).getSelectedItem();
            if (selectedItem != null && (strBoxIdOrNull = selectedItem.boxIdOrNull()) != null) {
                uploadToFolderActivity.tryUpload(strBoxIdOrNull);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onInviteCollaborators(FolderModel folder) {
        UploadToFolderActivity uploadToFolderActivity = this;
        startActivity(getIntentServices().inviteCollaboratorsActivityIntent(uploadToFolderActivity, FolderModelMapper.toBoxFolder$default(FolderModelMapper.INSTANCE, folder, false, 1, null), getUserContextManager().getBoxSession(uploadToFolderActivity)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getToolbarSubtitle() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(CommonBoxUtil.plural(R.array.Upload_n_files_to, BoxStaticUploadModel.getUploadList().size()), Arrays.copyOf(new Object[]{Integer.valueOf(BoxStaticUploadModel.getUploadList().size())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        if (BoxStaticUploadModel.getUploadList().size() == 0) {
            finish();
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        BoxStaticUploadModel.clearUploads();
        super.onMAMDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AlertDialog createFileNameConflictAlert(final Activity context, String warningTitle, String warningMessage, final ArrayList<UploadModelBoxFile> nameConflictFiles) {
        MaterialAlertDialogBuilder positiveButton = new MaterialAlertDialogBuilder(context).setTitle((CharSequence) warningTitle).setMessage((CharSequence) warningMessage).setNegativeButton(R.string.save_as_new, new DialogInterface.OnClickListener() { // from class: com.box.android.browse.activities.UploadToFolderActivity$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UploadToFolderActivity.createFileNameConflictAlert$lambda$0(nameConflictFiles, this, context, dialogInterface, i);
            }
        }).setNeutralButton(R.string.Skip, new DialogInterface.OnClickListener() { // from class: com.box.android.browse.activities.UploadToFolderActivity$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UploadToFolderActivity.createFileNameConflictAlert$lambda$1(nameConflictFiles, this, context, dialogInterface, i);
            }
        }).setPositiveButton(R.string.LS_Upload_as_New_V, new DialogInterface.OnClickListener() { // from class: com.box.android.browse.activities.UploadToFolderActivity$$ExternalSyntheticLambda4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                UploadToFolderActivity.createFileNameConflictAlert$lambda$2(nameConflictFiles, this, context, dialogInterface, i);
            }
        });
        Intrinsics.checkNotNullExpressionValue(positiveButton, "setPositiveButton(...)");
        positiveButton.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.box.android.browse.activities.UploadToFolderActivity$$ExternalSyntheticLambda5
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                UploadToFolderActivity.createFileNameConflictAlert$lambda$3(context, dialogInterface);
            }
        });
        AlertDialog alertDialogCreate = positiveButton.create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        return alertDialogCreate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createFileNameConflictAlert$lambda$0(ArrayList arrayList, UploadToFolderActivity uploadToFolderActivity, Activity activity, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        BoxStaticUploadModel.renameConflictingFiles(arrayList);
        BoxStaticUploadModel.doUpload(BoxUploadFile.ConflictResolution.RENAME, uploadToFolderActivity.getMBaseModelController(), uploadToFolderActivity.getMBoxFileApi(), uploadToFolderActivity.mUserContextManager, uploadToFolderActivity.jobSource, uploadToFolderActivity.getMLocalItemService());
        activity.setResult(-1);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createFileNameConflictAlert$lambda$1(ArrayList arrayList, UploadToFolderActivity uploadToFolderActivity, Activity activity, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            UploadModelBoxFile uploadModelBoxFile = (UploadModelBoxFile) next;
            if (uploadModelBoxFile.isExistingNameConflict()) {
                uploadModelBoxFile.setEnabledStatus(false);
            }
        }
        BoxStaticUploadModel.doUpload(BoxUploadFile.ConflictResolution.SKIP, uploadToFolderActivity.getMBaseModelController(), uploadToFolderActivity.getMBoxFileApi(), uploadToFolderActivity.mUserContextManager, uploadToFolderActivity.jobSource, uploadToFolderActivity.getMLocalItemService());
        activity.setResult(-1);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createFileNameConflictAlert$lambda$2(ArrayList arrayList, UploadToFolderActivity uploadToFolderActivity, Activity activity, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            UploadModelBoxFile uploadModelBoxFile = (UploadModelBoxFile) next;
            if (uploadModelBoxFile.isExistingNameConflict()) {
                uploadModelBoxFile.setOverwriteExisting(true);
            }
        }
        BoxStaticUploadModel.doUpload(BoxUploadFile.ConflictResolution.UPLOAD_NEW_VERSION, uploadToFolderActivity.getMBaseModelController(), uploadToFolderActivity.getMBoxFileApi(), uploadToFolderActivity.mUserContextManager, uploadToFolderActivity.jobSource, uploadToFolderActivity.getMLocalItemService());
        activity.setResult(-1);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createFileNameConflictAlert$lambda$3(Activity activity, DialogInterface dialogInterface) {
        activity.setResult(0);
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPartialErrorListener$lambda$0(UploadToFolderActivity uploadToFolderActivity, DialogInterface dialogInterface) {
        Iterator<UploadModelBoxFile> it = BoxStaticUploadModel.getUploadList().iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().isEnabled()) {
                z = true;
            }
        }
        if (z) {
            BoxStaticUploadModel.doUpload(BoxUploadFile.ConflictResolution.FAIL, uploadToFolderActivity.getMBaseModelController(), uploadToFolderActivity.getMBoxFileApi(), uploadToFolderActivity.mUserContextManager, uploadToFolderActivity.jobSource, uploadToFolderActivity.getMLocalItemService());
        } else {
            uploadToFolderActivity.finish();
        }
    }

    private final void tryUpload(String folderId) {
        showSpinner();
        try {
            BoxStaticUploadModel.setCurrentUploadFolder(folderId, getMBoxFolderApi(), getMBaseModelController());
        } catch (Exception e) {
            String name = getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            BoxLogUtils.logException(name, e);
        }
        new UploadToFolderActivity$tryUpload$t$1(this).start();
    }

    /* JADX INFO: compiled from: UploadToFolderActivity.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0002J$\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/box/android/browse/activities/UploadToFolderActivity$Companion;", "", "<init>", "()V", "EXTRA_EVENT_CODE", "", "EXTRA_FOLDER", "EXTRA_DISABLE_FILES", "MAX_UPLOAD_FILE_NAME_DISPLAY_LENGTH", "", "MAX_UPLOAD_ERRORS_TO_DISPLAY", "createFileErrorAlert", "Landroidx/appcompat/app/AlertDialog;", "context", "Landroid/app/Activity;", "warningTitle", "warningMessage", "getLaunchIntent", "Landroid/content/Intent;", "Landroid/content/Context;", "folderIdToUploadTo", "jobSource", "Lcom/box/android/domain/usecases/jobs/JobTags$JobSource;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final AlertDialog createFileErrorAlert(Activity context, String warningTitle, String warningMessage) {
            AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(context).setTitle((CharSequence) warningTitle).setMessage((CharSequence) warningMessage).setIcon(android.R.drawable.ic_dialog_alert).setNegativeButton(R.string.button_ok, new DialogInterface.OnClickListener() { // from class: com.box.android.browse.activities.UploadToFolderActivity$Companion$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).create();
            Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
            return alertDialogCreate;
        }

        @JvmStatic
        public final Intent getLaunchIntent(Context context, String folderIdToUploadTo, JobTags.JobSource jobSource) {
            Intrinsics.checkNotNullParameter(jobSource, "jobSource");
            Intent intent = new Intent(context, (Class<?>) UploadToFolderActivity.class);
            intent.putExtra(UploadToFolderActivity.EXTRA_DISABLE_FILES, true);
            intent.putExtra(UploadToFolderActivity.EXTRA_EVENT_CODE, jobSource);
            if (folderIdToUploadTo != null) {
                intent.putExtra("extraFolder", BoxFolder.createFromId(folderIdToUploadTo));
            }
            return intent;
        }
    }

    private static final ItemPickerReducer.State setupItemPickerUI$lambda$0$0(State<ItemPickerReducer.State> state) {
        return state.getValue();
    }
}
