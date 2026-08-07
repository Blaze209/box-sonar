package com.box.android.browse.cpl.browse;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.box.android.activities.addcontent.CreateDocumentTaskActivity;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.base.presentation.views.menu.SortSheetFragment;
import com.box.android.browse.R;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.databinding.GenericComposeViewBinding;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxSwitchUserMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.ScopesStore;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.configuration.IFeatureFlip;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.ItemIdKt;
import com.box.android.domain.models.item.FolderModel;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItemDelete;
import com.box.androidsdk.content.utils.BoxLogUtils;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: BrowseFragment.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0017J\b\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0017H\u0016J\u0016\u0010!\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#H\u0017J\u0016\u0010$\u001a\u00020\u001a2\f\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010#H\u0017J\u0014\u0010%\u001a\u0004\u0018\u00010\u00172\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020\u001aH\u0016J\b\u0010*\u001a\u00020\u001aH\u0016J\b\u0010+\u001a\u00020\u0017H\u0016R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/box/android/base/presentation/BoxFragmentInterface;", "<init>", "()V", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", TtmlNode.RUBY_CONTAINER, "Landroid/view/ViewGroup;", "createNewDocument", "folderModel", "Lcom/box/android/domain/models/item/FolderModel;", CreateDocumentTaskActivity.EXTRA_ASSET_NAME, "", "onResume", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "openSortingMenu", "getType", "", "getGenericId", "updateFragment", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "shouldUpdateFragment", "getTitle", "context", "Landroid/content/Context;", "updateFromRemote", "onBackPressed", "isFloatingMenuAvailable", "getAmplitudePageName", "Companion", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BrowseFragment extends Fragment implements BoxFragmentInterface {
    private static final String STORE_KEY = "storeKey";
    private Store<BrowseReducer.State, BrowseReducer.Action> store;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final String[] SUCCESS_MESSAGES_TO_TRIGGER_UPDATE = {Controller.ACTION_SORT_PREFERENCES_CHANGED, Controller.ACTION_DELETED_FOLDER, Controller.ACTION_REMOVE_OFFLINE_ITEM, Controller.ACTION_ADD_OFFLINE_ITEM, Controller.ACTION_ADD_OFFLINE_ITEM_ALL_FINISHED, Controller.ACTION_MADE_FILE_AVAILABLE_OFFLINE};
    private static final String[] MESSAGES_TO_TRIGGER_UPDATE = {BoxSwitchUserMessage.ACTION_SWITCHED_USER};

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public int getType() {
        return 2;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean isFloatingMenuAvailable() {
        return true;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public void updateFromRemote() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        Bundle arguments = getArguments();
        Store<BrowseReducer.State, BrowseReducer.Action> store = null;
        String string = arguments != null ? arguments.getString("storeKey") : null;
        if (string != null) {
            Store<BrowseReducer.State, BrowseReducer.Action> storeRequireStore = ScopesStore.INSTANCE.requireStore(string);
            this.store = storeRequireStore;
            if (storeRequireStore == null) {
                Intrinsics.throwUninitializedPropertyAccessException("store");
            } else {
                store = storeRequireStore;
            }
            store.send(new BrowseReducer.Action.InitializeFolder(false));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FeatureFlips featureFlips;
        IFeatureFlip mainScreenRedesign;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final boolean enabled = false;
        GenericComposeViewBinding genericComposeViewBindingInflate = GenericComposeViewBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(genericComposeViewBindingInflate, "inflate(...)");
        ComposeView composeView = genericComposeViewBindingInflate.composeView;
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        FragmentActivity activity = getActivity();
        final BoxFragmentActivity boxFragmentActivity = activity instanceof BoxFragmentActivity ? (BoxFragmentActivity) activity : null;
        if (boxFragmentActivity != null && (featureFlips = boxFragmentActivity.mFeatureFlips) != null && (mainScreenRedesign = featureFlips.getMainScreenRedesign()) != null) {
            enabled = mainScreenRedesign.getEnabled();
        }
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-340700430, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseFragment$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BrowseFragment.onCreateView$lambda$0$0(boxFragmentActivity, this, enabled, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        ConstraintLayout root = genericComposeViewBindingInflate.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0(final BoxFragmentActivity boxFragmentActivity, final BrowseFragment browseFragment, final boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C82@3821L581,82@3812L590:BrowseFragment.kt#89mwni");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-340700430, i, -1, "com.box.android.browse.cpl.browse.BrowseFragment.onCreateView.<anonymous>.<anonymous> (BrowseFragment.kt:82)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1800749639, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseFragment$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseFragment.onCreateView$lambda$0$0$0(boxFragmentActivity, browseFragment, z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreateView$lambda$0$0$0(BoxFragmentActivity boxFragmentActivity, BrowseFragment browseFragment, boolean z, Composer composer, int i) {
        IBoxAccountSettings iBoxAccountSettings;
        FeatureFlips featureFlips;
        IFeatureFlip boxAiCenterForPreviewAndMultidoc;
        ComposerKt.sourceInformation(composer, "C90@4343L19,86@4097L287:BrowseFragment.kt#89mwni");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1800749639, i, -1, "com.box.android.browse.cpl.browse.BrowseFragment.onCreateView.<anonymous>.<anonymous>.<anonymous> (BrowseFragment.kt:83)");
            }
            boolean z2 = (boxFragmentActivity == null || (iBoxAccountSettings = boxFragmentActivity.mBoxAccountSettings) == null || !iBoxAccountSettings.isAxCenterEnabled() || (featureFlips = boxFragmentActivity.mFeatureFlips) == null || (boxAiCenterForPreviewAndMultidoc = featureFlips.getBoxAiCenterForPreviewAndMultidoc()) == null || !boxAiCenterForPreviewAndMultidoc.getEnabled()) ? false : true;
            Store<BrowseReducer.State, BrowseReducer.Action> store = browseFragment.store;
            if (store == null) {
                Intrinsics.throwUninitializedPropertyAccessException("store");
                store = null;
            }
            Store<BrowseReducer.State, BrowseReducer.Action> store2 = store;
            ComposerKt.sourceInformationMarkerStart(composer, -351400486, "CC(remember):BrowseFragment.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(browseFragment);
            BrowseFragment$onCreateView$1$1$1$1$1 browseFragment$onCreateView$1$1$1$1$1RememberedValue = composer.rememberedValue();
            if (zChangedInstance || browseFragment$onCreateView$1$1$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                browseFragment$onCreateView$1$1$1$1$1RememberedValue = new BrowseFragment$onCreateView$1$1$1$1$1(browseFragment);
                composer.updateRememberedValue(browseFragment$onCreateView$1$1$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BrowseFragmentKt.BrowseFragmentContent(store2, z, z2, (Function2) ((KFunction) browseFragment$onCreateView$1$1$1$1$1RememberedValue), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void createNewDocument(FolderModel folderModel, String assetName) {
        ItemId itemId = folderModel.getItemId();
        ItemId.Remote remote = itemId instanceof ItemId.Remote ? (ItemId.Remote) itemId : null;
        if (remote == null) {
            BoxLogUtils.e("Can't create file inside folder with local id, folder id = " + folderModel.getItemId());
            return;
        }
        FragmentActivity activity = getActivity();
        BoxFragmentActivity boxFragmentActivity = activity instanceof BoxFragmentActivity ? (BoxFragmentActivity) activity : null;
        if (boxFragmentActivity == null) {
            return;
        }
        IntentServices intentServices = boxFragmentActivity.mIntentServices;
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
        requireActivity().startActivity(intentServices.createDocumentTaskIntent(fragmentActivityRequireActivity, remote.getBoxId(), assetName));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Store<BrowseReducer.State, BrowseReducer.Action> store = this.store;
        Store<BrowseReducer.State, BrowseReducer.Action> store2 = null;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
            store = null;
        }
        store.send(new BrowseReducer.Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(ItemsListReducer.Action.RefreshFeatureBannerVisibility.INSTANCE)));
        Store<BrowseReducer.State, BrowseReducer.Action> store3 = this.store;
        if (store3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
        } else {
            store2 = store3;
        }
        store2.send(new BrowseReducer.Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(ItemsListReducer.Action.ScreenUpdated.INSTANCE)));
    }

    @Override // androidx.fragment.app.Fragment
    @Deprecated(message = "Deprecated in Java")
    public boolean onOptionsItemSelected(MenuItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (getActivity() == null) {
            return false;
        }
        int itemId = item.getItemId();
        if (itemId == R.id.folder_sort) {
            openSortingMenu();
            return true;
        }
        Store<BrowseReducer.State, BrowseReducer.Action> store = null;
        if (itemId == R.id.more_actions) {
            Store<BrowseReducer.State, BrowseReducer.Action> store2 = this.store;
            if (store2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("store");
            } else {
                store = store2;
            }
            store.send(BrowseReducer.Action.ShowFolderActions.INSTANCE);
            return true;
        }
        if (itemId == R.id.multi_select) {
            Store<BrowseReducer.State, BrowseReducer.Action> store3 = this.store;
            if (store3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("store");
            } else {
                store = store3;
            }
            store.send(new BrowseReducer.Action.ChildActionableItemsListAction(ActionableItemsListReducer.Action.StartMultiSelectMode.INSTANCE));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private final void openSortingMenu() {
        SortSheetFragment.newInstance(getActivity()).showAndHideSoftInput(getActivity(), requireView().getWindowToken());
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getGenericId() {
        Store<BrowseReducer.State, BrowseReducer.Action> store = this.store;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
            store = null;
        }
        return ((BrowseReducer.State) StoreKt.stateValue(store)).getCurrentFolderId().getBoxId();
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public void updateFragment(BoxMessage<?> message) {
        BoxItem item;
        if (message == null) {
            return;
        }
        Store<BrowseReducer.State, BrowseReducer.Action> store = null;
        if (message.wasSuccessful()) {
            String action = message.getAction();
            if (Intrinsics.areEqual(action, Controller.ACTION_SORT_PREFERENCES_CHANGED)) {
                Store<BrowseReducer.State, BrowseReducer.Action> store2 = this.store;
                if (store2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("store");
                    store2 = null;
                }
                store2.send(BrowseReducer.Action.SortPreferencesChanged.INSTANCE);
            } else if (Intrinsics.areEqual(action, Controller.ACTION_DELETED_FOLDER)) {
                if ((message instanceof BoxResponseMessage ? (BoxResponseMessage) message : null) != null) {
                    BoxRequest request = ((BoxResponseMessage) message).getRequest();
                    BoxRequestItemDelete boxRequestItemDelete = request instanceof BoxRequestItemDelete ? (BoxRequestItemDelete) request : null;
                    if (boxRequestItemDelete != null && (item = boxRequestItemDelete.getItem()) != null) {
                        Store<BrowseReducer.State, BrowseReducer.Action> store3 = this.store;
                        if (store3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("store");
                            store3 = null;
                        }
                        String id = item.getUserId();
                        Intrinsics.checkNotNullExpressionValue(id, "getId(...)");
                        store3.send(new BrowseReducer.Action.FolderDeleted(ItemIdKt.toFolderRemoteId(id)));
                    }
                }
            } else if (Intrinsics.areEqual(action, Controller.ACTION_REMOVE_OFFLINE_ITEM) || Intrinsics.areEqual(action, Controller.ACTION_MADE_FILE_AVAILABLE_OFFLINE) || Intrinsics.areEqual(action, Controller.ACTION_ADD_OFFLINE_ITEM) || Intrinsics.areEqual(action, Controller.ACTION_ADD_OFFLINE_ITEM_ALL_FINISHED)) {
                Store<BrowseReducer.State, BrowseReducer.Action> store4 = this.store;
                if (store4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("store");
                    store4 = null;
                }
                store4.send(BrowseReducer.Action.LoadItems.INSTANCE);
            }
        }
        if (Intrinsics.areEqual(message.getAction(), BoxSwitchUserMessage.ACTION_SWITCHED_USER)) {
            Store<BrowseReducer.State, BrowseReducer.Action> store5 = this.store;
            if (store5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("store");
            } else {
                store = store5;
            }
            store.send(BrowseReducer.Action.LoadItems.INSTANCE);
        }
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    @Deprecated(message = "Deprecated in Java")
    public boolean shouldUpdateFragment(BoxMessage<?> message) {
        if (message == null) {
            return false;
        }
        return (message.wasSuccessful() && ArraysKt.contains(SUCCESS_MESSAGES_TO_TRIGGER_UPDATE, message.getAction())) || ArraysKt.contains(MESSAGES_TO_TRIGGER_UPDATE, message.getAction());
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getTitle(Context context) {
        if (context != null) {
            return context.getString(R.string.files);
        }
        return null;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public boolean onBackPressed() {
        Store<BrowseReducer.State, BrowseReducer.Action> store = this.store;
        if (store == null) {
            Intrinsics.throwUninitializedPropertyAccessException("store");
            store = null;
        }
        store.send(BrowseReducer.Action.CloseScreen.INSTANCE);
        return true;
    }

    @Override // com.box.android.base.presentation.BoxFragmentInterface
    public String getAmplitudePageName() {
        return BoxAnalyticsParams.PAGE_NAME_FOLDER;
    }

    /* JADX INFO: compiled from: BrowseFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006R\u001e\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/browse/cpl/browse/BrowseFragment$Companion;", "", "<init>", "()V", "SUCCESS_MESSAGES_TO_TRIGGER_UPDATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "MESSAGES_TO_TRIGGER_UPDATE", "STORE_KEY", "getInstance", "Lcom/box/android/browse/cpl/browse/BrowseFragment;", "storeKey", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BrowseFragment getInstance(String storeKey) {
            Intrinsics.checkNotNullParameter(storeKey, "storeKey");
            Bundle bundleBundleOf = BundleKt.bundleOf(TuplesKt.to("storeKey", storeKey));
            BrowseFragment browseFragment = new BrowseFragment();
            browseFragment.setArguments(bundleBundleOf);
            return browseFragment;
        }
    }
}
