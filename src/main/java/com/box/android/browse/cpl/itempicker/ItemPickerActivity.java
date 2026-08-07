package com.box.android.browse.cpl.itempicker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ComponentActivityKt;
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
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.base.presentation.utilities.EdgeToEdgeUtils;
import com.box.android.browse.R;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.ViewModelAssistedFactory;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.Store;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.mappers.WebLinkModelMapper;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.WebLinkModel;
import com.box.androidsdk.content.utils.BoxLogUtils;
import dagger.hilt.android.AndroidEntryPoint;
import dagger.hilt.android.lifecycle.HiltViewModelExtensions;
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
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: ItemPickerActivity.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014¢\u0006\u0002\u0010\u001cJ\u0012\u0010\u001d\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0015J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006$²\u0006\n\u0010%\u001a\u00020&X\u008a\u0084\u0002"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "setIntentServices", "(Lcom/box/android/coreservices/services/IntentServices;)V", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "getUserContextManager", "()Lcom/box/android/domain/identity/IUserContextManager;", "setUserContextManager", "(Lcom/box/android/domain/identity/IUserContextManager;)V", "vm", "Lcom/box/android/browse/cpl/itempicker/ItemPickerViewModel;", "getVm", "()Lcom/box/android/browse/cpl/itempicker/ItemPickerViewModel;", "vm$delegate", "Lkotlin/Lazy;", "onInviteCollaborators", "", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "getActivityLayoutId", "", "()Ljava/lang/Integer;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setSelectedItemInResultAndFinish", "item", "Lcom/box/android/domain/models/item/ItemModel;", "Companion", "browse_generalProdRelease", "state", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;"}, k = 1, mv = {2, 2, 0}, xi = 48)
@AndroidEntryPoint
public final class ItemPickerActivity extends Hilt_ItemPickerActivity {
    private static final String DISABLE_NON_FOLDER_ITEMS_KEY = "disable_non_folder_items_key";
    public static final String EXTRA_FILE = "extraFile";
    public static final String EXTRA_FOLDER = "extraFolder";
    public static final String EXTRA_WEB_LINK = "extraWebLink";
    private static final String LOG_TAG = "ItemPickerActivity";
    private static final String MULTI_SELECT_KEY = "multi_select_key";
    private static final String STARTING_FOLDER_ID_KEY = "starting_folder_key";
    private static final String TITLE_KEY = "title_key";

    @Inject
    public IntentServices intentServices;

    @Inject
    public IUserContextManager userContextManager;

    /* JADX INFO: renamed from: vm$delegate, reason: from kotlin metadata */
    private final Lazy vm;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @JvmStatic
    public static final Intent getLaunchIntent(Context context) {
        return INSTANCE.getLaunchIntent(context);
    }

    @JvmStatic
    public static final Intent getLaunchIntent(Context context, String str) {
        return INSTANCE.getLaunchIntent(context, str);
    }

    @JvmStatic
    public static final Intent getLaunchIntent(Context context, String str, boolean z) {
        return INSTANCE.getLaunchIntent(context, str, z);
    }

    @JvmStatic
    public static final Intent getLaunchIntent(Context context, String str, boolean z, boolean z2) {
        return INSTANCE.getLaunchIntent(context, str, z, z2);
    }

    @JvmStatic
    public static final Intent getLaunchIntent(Context context, String str, boolean z, boolean z2, String str2) {
        return INSTANCE.getLaunchIntent(context, str, z, z2, str2);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public ItemPickerActivity() {
        final ItemPickerActivity itemPickerActivity = this;
        final Function0<CreationExtras> function0 = new Function0<CreationExtras>() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerActivity$special$$inlined$viewModelsWithArgs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras defaultViewModelCreationExtras = itemPickerActivity.getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "<get-defaultViewModelCreationExtras>(...)");
                final ItemPickerActivity itemPickerActivity2 = this;
                return HiltViewModelExtensions.withCreationCallback(defaultViewModelCreationExtras, new Function1<ViewModelAssistedFactory<ItemPickerViewModel>, ViewModel>() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerActivity$special$$inlined$viewModelsWithArgs$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final ViewModel invoke(ViewModelAssistedFactory<ItemPickerViewModel> factory) {
                        Intrinsics.checkNotNullParameter(factory, "factory");
                        Bundle bundle = new Bundle();
                        bundle.putString(ItemPickerViewModel.STARTING_FOLDER_ID_VM_KEY, itemPickerActivity2.getIntent().getStringExtra("starting_folder_key"));
                        bundle.putBoolean(ItemPickerViewModel.DISABLE_NON_FOLDER_ITEMS_VM_KEY, itemPickerActivity2.getIntent().getBooleanExtra("disable_non_folder_items_key", false));
                        bundle.putString("title", itemPickerActivity2.getIntent().getStringExtra("title_key"));
                        return factory.create(bundle);
                    }
                });
            }
        };
        this.vm = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ItemPickerViewModel.class), new Function0<ViewModelStore>() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerActivity$special$$inlined$viewModelsWithArgs$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return itemPickerActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerActivity$special$$inlined$viewModelsWithArgs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return itemPickerActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerActivity$special$$inlined$viewModelsWithArgs$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function1 = function0;
                return (function1 == null || (creationExtras = (CreationExtras) function1.invoke()) == null) ? itemPickerActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
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

    private final ItemPickerViewModel getVm() {
        return (ItemPickerViewModel) this.vm.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onInviteCollaborators(FolderModel folder) {
        ItemPickerActivity itemPickerActivity = this;
        startActivity(getIntentServices().inviteCollaboratorsActivityIntent(itemPickerActivity, FolderModelMapper.toBoxFolder$default(FolderModelMapper.INSTANCE, folder, false, 1, null), getUserContextManager().getBoxSession(itemPickerActivity)));
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(bundle);
        ItemPickerActivity itemPickerActivity = this;
        EdgeToEdgeUtils.INSTANCE.enableDarkEdgeToEdge(itemPickerActivity);
        if (!getResources().getBoolean(R.bool.is7inchOrLarger)) {
            setRequestedOrientation(1);
        }
        ComponentActivityKt.setContent$default(itemPickerActivity, null, ComposableLambdaKt.composableLambdaInstance(1950045891, true, new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ItemPickerActivity.onCreate$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
            }
        }), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$0(ItemPickerActivity itemPickerActivity, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C73@3150L29,76@3284L23,77@3335L8,74@3192L250:ItemPickerActivity.kt#oru6qt");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1950045891, i, -1, "com.box.android.browse.cpl.itempicker.ItemPickerActivity.onCreate.<anonymous> (ItemPickerActivity.kt:73)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(itemPickerActivity.getVm().getStore().getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer, 0, 7);
            Store<ItemPickerReducer.State, ItemPickerReducer.Action> store = itemPickerActivity.getVm().getStore();
            ComposerKt.sourceInformationMarkerStart(composer, 1388365850, "CC(remember):ItemPickerActivity.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(itemPickerActivity);
            ItemPickerActivity$onCreate$1$1$1 itemPickerActivity$onCreate$1$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || itemPickerActivity$onCreate$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                itemPickerActivity$onCreate$1$1$1RememberedValue = new ItemPickerActivity$onCreate$1$1$1(itemPickerActivity);
                composer.updateRememberedValue(itemPickerActivity$onCreate$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Function1 function1 = (Function1) ((KFunction) itemPickerActivity$onCreate$1$1$1RememberedValue);
            ComposerKt.sourceInformationMarkerStart(composer, 1388367467, "CC(remember):ItemPickerActivity.kt#9igjgp");
            boolean zChangedInstance2 = composer.changedInstance(itemPickerActivity);
            ItemPickerActivity$onCreate$1$2$1 itemPickerActivity$onCreate$1$2$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance2 || itemPickerActivity$onCreate$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                itemPickerActivity$onCreate$1$2$1RememberedValue = new ItemPickerActivity$onCreate$1$2$1(itemPickerActivity);
                composer.updateRememberedValue(itemPickerActivity$onCreate$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ItemPickerScreenKt.ItemPickerScreen(store, function1, (Function0) ((KFunction) itemPickerActivity$onCreate$1$2$1RememberedValue), itemPickerActivity.mFeatureFlips.getMainScreenRedesign().getEnabled(), composer, 0, 0);
            ItemModel selectedItem = onCreate$lambda$0$0(stateCollectAsStateWithLifecycle).getSelectedItem();
            if (selectedItem != null) {
                itemPickerActivity.setSelectedItemInResultAndFinish(selectedItem);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private final void setSelectedItemInResultAndFinish(ItemModel item) {
        Intent intent = new Intent();
        if (item instanceof FolderModel) {
            FolderModelMapper folderModelMapper = FolderModelMapper.INSTANCE;
            FolderModel folderModel = (FolderModel) item;
            String strLS = CommonBoxUtil.LS(R.string.files);
            if (!Intrinsics.areEqual(folderModel.getItemId(), ItemId.INSTANCE.getROOT_ITEM_ID())) {
                strLS = null;
            }
            if (strLS == null) {
                strLS = folderModel.getName();
            }
            Intrinsics.checkNotNullExpressionValue(intent.putExtra(EXTRA_FOLDER, FolderModelMapper.toBoxFolder$default(folderModelMapper, FolderModel.copy$default(folderModel, null, strLS, false, false, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 524285, null), false, 1, null)), "putExtra(...)");
        } else if (item instanceof FileModel) {
            Intrinsics.checkNotNullExpressionValue(intent.putExtra(EXTRA_FILE, FileModelMapper.toBoxFile$default(FileModelMapper.INSTANCE, (FileModel) item, false, 1, null)), "putExtra(...)");
        } else if (item instanceof WebLinkModel) {
            Intrinsics.checkNotNullExpressionValue(intent.putExtra(EXTRA_WEB_LINK, WebLinkModelMapper.toBoxBookmark$default(WebLinkModelMapper.INSTANCE, (WebLinkModel) item, false, 1, null)), "putExtra(...)");
        } else {
            BoxLogUtils.e(LOG_TAG, "Unexpected else branch");
            Unit unit = Unit.INSTANCE;
        }
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: compiled from: ItemPickerActivity.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/browse/cpl/itempicker/ItemPickerActivity$Companion;", "", "<init>", "()V", "LOG_TAG", "", "STARTING_FOLDER_ID_KEY", "DISABLE_NON_FOLDER_ITEMS_KEY", "MULTI_SELECT_KEY", "TITLE_KEY", "EXTRA_FILE", "EXTRA_FOLDER", "EXTRA_WEB_LINK", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "startingFolderId", "disableNonFolderItems", "", "darkMode", "title", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Intent getLaunchIntent(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return getLaunchIntent$default(this, context, null, false, false, null, 30, null);
        }

        @JvmStatic
        public final Intent getLaunchIntent(Context context, String startingFolderId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(startingFolderId, "startingFolderId");
            return getLaunchIntent$default(this, context, startingFolderId, false, false, null, 28, null);
        }

        @JvmStatic
        public final Intent getLaunchIntent(Context context, String startingFolderId, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(startingFolderId, "startingFolderId");
            return getLaunchIntent$default(this, context, startingFolderId, z, false, null, 24, null);
        }

        @JvmStatic
        public final Intent getLaunchIntent(Context context, String startingFolderId, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(startingFolderId, "startingFolderId");
            return getLaunchIntent$default(this, context, startingFolderId, z, z2, null, 16, null);
        }

        private Companion() {
        }

        public static /* synthetic */ Intent getLaunchIntent$default(Companion companion, Context context, String str, boolean z, boolean z2, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str = "0";
            }
            String str3 = str;
            boolean z3 = (i & 4) != 0 ? false : z;
            boolean z4 = (i & 8) != 0 ? false : z2;
            if ((i & 16) != 0) {
                str2 = null;
            }
            return companion.getLaunchIntent(context, str3, z3, z4, str2);
        }

        @JvmStatic
        public final Intent getLaunchIntent(Context context, String startingFolderId, boolean disableNonFolderItems, boolean darkMode, String title) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(startingFolderId, "startingFolderId");
            Intent intent = new Intent(context, (Class<?>) ItemPickerActivity.class);
            intent.putExtra(ItemPickerActivity.STARTING_FOLDER_ID_KEY, startingFolderId);
            intent.putExtra(ItemPickerActivity.DISABLE_NON_FOLDER_ITEMS_KEY, disableNonFolderItems);
            intent.putExtra(BoxFragmentActivity.EXTRA_FORCE_DARK_MODE, darkMode);
            intent.putExtra(ItemPickerActivity.TITLE_KEY, title);
            return intent;
        }
    }

    private static final ItemPickerReducer.State onCreate$lambda$0$0(State<ItemPickerReducer.State> state) {
        return state.getValue();
    }
}
