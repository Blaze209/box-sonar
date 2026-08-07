package com.box.android.navigation;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.R;
import com.box.android.activities.MainPhone;
import com.box.android.base.analytics.NavigationAnalyticsUtils;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.base.presentation.activities.NotificationPermissionRationaleActivity;
import com.box.android.base.presentation.fragments.TabLayoutFragment;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.utilities.EdgeToEdgeUtils;
import com.box.android.browse.cpl.browse.BrowseFragment;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.browse.cpl.helpers.ItemsFilter;
import com.box.android.browse.cpl.recents.RecentsReducerKt;
import com.box.android.browse.fragments.BoxBrowseFragment;
import com.box.android.browse.fragments.BoxSearchFragment;
import com.box.android.browse.fragments.SearchFragment;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.browse.views.AppSearchView;
import com.box.android.collections.presentation.fragments.CollectionsTabFragment;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.common.utilities.RationaleScreenHelper;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.navigation.NavigationBrowseToolbarHelper;
import com.box.android.cpl.navigation.NavigationReducer;
import com.box.android.cpl.navigation.NavigationViewModel;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.fragments.NavigationTabFragment;
import com.box.android.fragments.NotificationsTasksTabFragment;
import com.box.android.hubs.presentation.HubsFragment;
import com.box.android.localrepo.LocalAutoContentUploadInformation;
import com.box.android.routers.NavigationRouter;
import com.box.android.updates.UpdatesManager;
import com.box.android.updates.proposal.AppUpdateProposalSnackbarExtensionKt;
import com.box.android.vm.InboxBadgeVM;
import com.box.android.workers.AutoUploadWorkerDispatcher;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
public class Navigation extends Hilt_Navigation {
    public static final String EXTRA_NAV_TARGET = "extraNavTarget";
    public static final String LAST_USED_TAB_KEY = "LAST_USED_TAB";

    @Inject
    protected CopyOrMoveHelper copyOrMoveHelper;

    @Inject
    protected IntentServices intentServices;
    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.box.android.navigation.Navigation$$ExternalSyntheticLambda1
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$0((ActivityResult) obj);
        }
    });
    private AppBarLayout mAppBarLayout;

    @Inject
    protected NavigationBottomBar mBottomBarHelper;
    private String mCurrentUser;
    private NavigationTarget mInitialNavTarget;

    @Inject
    protected ILocalItemService mLocalItemService;
    private BoxFragmentInterface mSnackbarDisplayFragment;
    protected Toolbar mToolbar;

    @Inject
    protected NavigationBrowseToolbarHelper navigationBrowseToolbarHelper;
    private NavigationRouter router;

    @Inject
    protected UpdatesManager updatesManager;
    private NavigationViewModel viewModel;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ActivityResult activityResult) {
        this.viewModel.getStore().send(NavigationReducer.Action.ChildScreenClosed.INSTANCE);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(null);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        initializeViewModelForRootFolder();
        if (!getResources().getBoolean(R.bool.is7inchOrLarger)) {
            setRequestedOrientation(1);
        }
        this.mAppBarLayout = (AppBarLayout) findViewById(R.id.htab_appbar);
        this.mBottomBarHelper.initialize((BottomNavigationView) findViewById(R.id.bottom_navigation));
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        this.mToolbar = toolbar;
        setSupportActionBar(toolbar);
        this.mSearchView = (AppSearchView) findViewById(R.id.search_view);
        InboxBadgeVM inboxBadgeVM = (InboxBadgeVM) new ViewModelProvider(this).get(InboxBadgeVM.class);
        inboxBadgeVM.getCombinedBadgeData().observe(this, new Observer() { // from class: com.box.android.navigation.Navigation$$ExternalSyntheticLambda2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                this.f$0.lambda$onBoxCreate$1((InboxBadgeVM.BadgeData) obj);
            }
        });
        inboxBadgeVM.fetchBadgeData();
        setupFabMenu();
        setupRecentSearch();
        handleFirstNavigation();
        setupAddFabListener();
        setupEdgeToEdge();
        this.updatesManager.handleUpdateProposal(this);
        AppUpdateProposalSnackbarExtensionKt.registerForUpdateDownloadedSnackbar(this.appUpdateProposalManager, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBoxCreate$1(InboxBadgeVM.BadgeData badgeData) {
        boolean z = false;
        int i = badgeData != null ? badgeData.count : 0;
        if (badgeData != null && badgeData.hasMore) {
            z = true;
        }
        this.mBottomBarHelper.updateCombinedBadgeCount(i, z);
    }

    private void initializeViewModelForRootFolder() {
        this.router = new NavigationRouter(this, this.launcher, this.mItemActionHandler, this.copyOrMoveHelper, this.intentServices, this.mUserContextManager);
        NavigationViewModel navigationViewModel = (NavigationViewModel) new ViewModelProvider(this).get(NavigationViewModel.class);
        this.viewModel = navigationViewModel;
        this.router.initNavigation(navigationViewModel);
    }

    private void setupFabMenu() {
        this.mFabHelper.initializeFabFolderModel(getFabMenu(), getFabMenuContainer(), new Function0() { // from class: com.box.android.navigation.Navigation$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$setupFabMenu$2();
            }
        }, new Navigation$$ExternalSyntheticLambda5(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ FolderModel lambda$setupFabMenu$2() {
        return this.viewModel.getStore().getState().getValue().getBrowseState().getCurrentlyVisibleFolder();
    }

    @Override // com.box.android.activities.MainParent
    protected Unit sendBrowseAction(BrowseReducer.Action action) {
        NavigationViewModel navigationViewModel = this.viewModel;
        if (navigationViewModel == null) {
            return null;
        }
        navigationViewModel.getStore().send(new NavigationReducer.Action.NavigationBrowseAction(action));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.android.activities.MainParent
    /* JADX INFO: renamed from: getCurrentlyVisibleFolder */
    public BoxFolder lambda$showFabMenu$7() {
        return FolderModelMapper.INSTANCE.toBoxFolder(this.viewModel.getStore().getState().getValue().getBrowseState().getCurrentlyVisibleFolder(), false);
    }

    private void updateToolbar(int i) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        if (i == R.id.action_inbox) {
            supportActionBar.setTitle(R.string.Inbox);
        } else if (i == R.id.action_collections) {
            supportActionBar.setTitle(R.string.Collections);
        } else if (i == R.id.action_search) {
            supportActionBar.setTitle("");
        } else if (i == R.id.action_hubs) {
            supportActionBar.setTitle(R.string.hubs);
        } else {
            supportActionBar.setTitle(R.string.box_browsesdk_title);
        }
        ViewCompat.setElevation(this.mAppBarLayout, 0.0f);
    }

    private NavigationTarget getLastUsedTab() {
        return this.mBottomBarHelper.getLastUsedTab();
    }

    private void saveLastUsedTab(NavigationTarget navigationTarget) {
        SharedPreferences.Editor editorEdit = this.mUserContextManager.getUserSharedPrefs().edit();
        editorEdit.putString(LAST_USED_TAB_KEY, navigationTarget.name());
        editorEdit.apply();
    }

    private void switchToLastTab(NavigationTarget navigationTarget) {
        if (navigationTarget == null) {
            navigationTarget = NavigationTarget.ALL_FILES;
        }
        switchToFragment(createFragment(navigationTarget, false), navigationTarget.name());
        this.mBottomBarHelper.setSelected(navigationTarget);
    }

    private void handleFirstNavigation() {
        NavigationTarget lastUsedTab = getLastUsedTab();
        if (getCurrentFragment() == null) {
            switchToLastTab(lastUsedTab);
        } else {
            restoreAssociatedViews();
        }
        handleInitialNavigationTarget();
        this.mCurrentUser = this.mUserContextManager.getCurrentContextId();
    }

    private void handleInitialNavigationTarget() {
        NavigationTarget navigationTarget = this.mInitialNavTarget;
        if (navigationTarget == null) {
            return;
        }
        if (navigationTarget.isFromBrowse()) {
            updateTabPosition(NavigationTabFragment.class, NavigationTarget.ALL_FILES.name());
        } else if (this.mInitialNavTarget.isFromInbox()) {
            updateTabPosition(NotificationsTasksTabFragment.class, NavigationTarget.INBOX.name());
        } else if (this.mInitialNavTarget.isFromCollections()) {
            updateTabPosition(CollectionsTabFragment.class, NavigationTarget.COLLECTIONS.name());
        } else {
            setTargetFragment(this.mInitialNavTarget, null);
        }
        this.mBottomBarHelper.setSelected(this.mInitialNavTarget);
        this.mInitialNavTarget = null;
    }

    private <T extends TabLayoutFragment> void updateTabPosition(Class<T> cls, String str) {
        TabLayoutFragment tabLayoutFragment = (TabLayoutFragment) getFragmentInstance(cls, str);
        if (tabLayoutFragment != null) {
            tabLayoutFragment.changeTabPosition(NavigationTarget.getNavigationTabAdapterPos(this.mInitialNavTarget));
        }
    }

    private void setupEdgeToEdge() {
        EdgeToEdgeUtils.INSTANCE.setInsets(findViewById(R.id.coordinator_layout), new EdgeToEdgeUtils.OnInsetsAppliedListener() { // from class: com.box.android.navigation.Navigation$$ExternalSyntheticLambda3
            @Override // com.box.android.base.presentation.utilities.EdgeToEdgeUtils.OnInsetsAppliedListener
            public final void onInsetsApplied(View view, Insets insets, WindowInsetsCompat windowInsetsCompat) {
                this.f$0.lambda$setupEdgeToEdge$3(view, insets, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupEdgeToEdge$3(View view, Insets insets, WindowInsetsCompat windowInsetsCompat) {
        View viewFindViewById = view.findViewById(R.id.bottom_navigation);
        viewFindViewById.setPadding(viewFindViewById.getPaddingLeft(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingRight(), insets.bottom);
        View viewFindViewById2 = view.findViewById(R.id.fab_menu_container);
        viewFindViewById2.setPadding(viewFindViewById2.getPaddingLeft(), viewFindViewById2.getPaddingTop(), viewFindViewById2.getPaddingRight(), insets.bottom);
        view.findViewById(R.id.snackbar_container).setPadding(viewFindViewById2.getPaddingLeft(), viewFindViewById2.getPaddingTop(), viewFindViewById2.getPaddingRight(), insets.bottom);
        View viewFindViewById3 = view.findViewById(R.id.add_fab_container);
        viewFindViewById3.setPadding(viewFindViewById3.getPaddingLeft(), viewFindViewById3.getPaddingTop(), viewFindViewById3.getPaddingRight(), getResources().getDimensionPixelSize(R.dimen.fab_add_bottom_padding) + insets.bottom);
        View viewFindViewById4 = view.findViewById(R.id.filesfragmentembedded1);
        if (viewFindViewById4 != null) {
            ViewCompat.dispatchApplyWindowInsets(viewFindViewById4, windowInsetsCompat);
        }
    }

    private void setTargetFragment(NavigationTarget navigationTarget, Bundle bundle) {
        if (navigationTarget.isInstanceOfFragment(getCurrentFragment())) {
            return;
        }
        try {
            Fragment newFragmentInstance = navigationTarget.getNewFragmentInstance();
            if (bundle != null) {
                newFragmentInstance.setArguments(bundle);
            }
            switchToFragment(newFragmentInstance, navigationTarget.name());
            restoreAssociatedViews();
        } catch (Exception unused) {
            BoxLogUtils.w("Could not create an instance of a fragment for " + navigationTarget.name());
        }
    }

    private <T extends Fragment> T getFragmentInstance(Class<T> cls, String str, Bundle bundle) {
        if (cls.isInstance(getCurrentFragment())) {
            return (T) getCurrentFragment();
        }
        T t = null;
        try {
            T tNewInstance = cls.newInstance();
            if (bundle != null) {
                try {
                    tNewInstance.setArguments(bundle);
                } catch (Exception unused) {
                    t = tNewInstance;
                    BoxLogUtils.w("Could not create an instance of the fragment " + cls.toString());
                    return t;
                }
            }
            switchToFragment(tNewInstance, str);
            return tNewInstance;
        } catch (Exception unused2) {
        }
    }

    private <T extends Fragment> T getFragmentInstance(Class<T> cls, String str) {
        return (T) getFragmentInstance(cls, str, null);
    }

    private void restoreAssociatedViews() {
        updateToolbar(NavigationTarget.getBottomBarMenuIdByFragment(getCurrentFragment()));
    }

    private void setupSearchViewInToolbar() {
        this.mToolbar.setVisibility(8);
        findViewById(R.id.searchLayout).setVisibility(0);
        this.mSearchView.setSearchTerm("");
        this.mSearchView.setIconified(false);
        this.mSearchView.setFilteringIcon(null);
        this.mSearchView.setOnBoxSearchListener(new AppSearchViewListenerImpl());
    }

    private <T extends Fragment & BoxFragmentInterface> void switchToFragment(Fragment fragment, String str) {
        if (fragment != null) {
            executePendingFragmentTransactions();
            FragmentTransaction fragmentTransactionBeginTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransactionBeginTransaction.replace(R.id.filesfragmentembedded1, fragment, str);
            fragmentTransactionBeginTransaction.commitAllowingStateLoss();
            executePendingFragmentTransactions();
            amplitudeSetCurrentPage();
            setupAddFab();
        }
    }

    /* JADX INFO: renamed from: com.box.android.navigation.Navigation$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$box$android$navigation$NavigationTarget;

        static {
            int[] iArr = new int[NavigationTarget.values().length];
            $SwitchMap$com$box$android$navigation$NavigationTarget = iArr;
            try {
                iArr[NavigationTarget.ALL_FILES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$box$android$navigation$NavigationTarget[NavigationTarget.SEARCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$box$android$navigation$NavigationTarget[NavigationTarget.HUBS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$box$android$navigation$NavigationTarget[NavigationTarget.NOTIFICATIONS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$box$android$navigation$NavigationTarget[NavigationTarget.INBOX.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$box$android$navigation$NavigationTarget[NavigationTarget.COLLECTIONS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private Fragment createFragment(NavigationTarget navigationTarget, boolean z) {
        switch (AnonymousClass1.$SwitchMap$com$box$android$navigation$NavigationTarget[navigationTarget.ordinal()]) {
            case 1:
                Bundle bundle = new Bundle();
                bundle.putBoolean("click_from_browse", z);
                Fragment newFragmentInstance = navigationTarget.getNewFragmentInstance();
                newFragmentInstance.setArguments(bundle);
                return newFragmentInstance;
            case 2:
                getFabMenu().setVisibility(8);
                return getBoxSearchFragment();
            case 3:
                getFabMenu().setVisibility(8);
                return navigationTarget.getNewFragmentInstance();
            case 4:
            case 5:
            case 6:
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean(CollectionsTabFragment.EXTRA_CLICK_FROM_COLLECTIONS, z);
                getFabMenu().setVisibility(8);
                Fragment newFragmentInstance2 = navigationTarget.getNewFragmentInstance();
                newFragmentInstance2.setArguments(bundle2);
                return newFragmentInstance2;
            default:
                return null;
        }
    }

    private <T extends Fragment & BoxFragmentInterface> void setBottomBarListeners() {
        this.mBottomBarHelper.setItemSelectedListener(new NavigationBarView.OnItemSelectedListener() { // from class: com.box.android.navigation.Navigation$$ExternalSyntheticLambda0
            @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
            public final boolean onNavigationItemSelected(MenuItem menuItem) {
                return this.f$0.lambda$setBottomBarListeners$4(menuItem);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$setBottomBarListeners$4(MenuItem menuItem) {
        NavigationTarget navigationTargetDetermineTargetTab = determineTargetTab(menuItem);
        if (navigationTargetDetermineTargetTab != null) {
            switchToTargetTab(navigationTargetDetermineTargetTab);
        } else {
            handleSameTabClick();
        }
        updateToolbar(menuItem.getItemId());
        return true;
    }

    private NavigationTarget determineTargetTab(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_browse) {
            if (getCurrentFragment() instanceof NavigationTabFragment) {
                return null;
            }
            logBrowseTabTriggered();
            return NavigationTarget.ALL_FILES;
        }
        if (itemId == R.id.action_search) {
            if (getCurrentFragment() instanceof SearchFragment) {
                return null;
            }
            logSearchTriggered(BoxAnalyticsParams.CTA_PAGE_LOCATION_BOTTOM);
            return NavigationTarget.SEARCH;
        }
        if (itemId == R.id.action_hubs) {
            if (getCurrentFragment() instanceof HubsFragment) {
                return null;
            }
            return NavigationTarget.HUBS;
        }
        if (itemId == R.id.action_inbox) {
            if (getCurrentFragment() instanceof NotificationsTasksTabFragment) {
                return null;
            }
            return NavigationTarget.INBOX;
        }
        if (itemId != R.id.action_collections || (getCurrentFragment() instanceof CollectionsTabFragment)) {
            return null;
        }
        return NavigationTarget.COLLECTIONS;
    }

    private void logBrowseTabTriggered() {
        BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_PAGE_LOCATION_BOTTOM).logEvent(BoxAnalyticsParams.EVENT_BROWSE_TAB_TRIGGERED);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void switchToTargetTab(NavigationTarget navigationTarget) {
        Fragment fragmentCreateFragment = createFragment(navigationTarget, true);
        switchToFragment(fragmentCreateFragment, navigationTarget.name());
        NavigationViewModel navigationViewModel = this.viewModel;
        if (navigationViewModel != null && fragmentCreateFragment != 0) {
            navigationViewModel.getStore().send(new NavigationReducer.Action.TabChanged(((BoxFragmentInterface) fragmentCreateFragment).getType()));
        }
        saveLastUsedTab(navigationTarget);
    }

    private void handleSameTabClick() {
        Fragment fragment = (Fragment) getCurrentVisibleFragment();
        if (fragment instanceof SearchFragment) {
            initSearchViewToolbar();
        } else if ((fragment instanceof BoxBrowseFragment) && fragment.isResumed()) {
            ((BoxBrowseFragment) getCurrentVisibleFragment()).scrollToTop();
        }
    }

    private void initSearchViewToolbar() {
        setupSearchViewInToolbar();
        loadRecentSearch();
    }

    private BoxSearchFragment getBoxSearchFragment() {
        initSearchViewToolbar();
        return new SearchFragment.Builder(this.mUserContextManager.getBoxSession(this), "", BoxFolder.createFromId("0")).build();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation_activity_menu, menu);
        if (this.viewModel != null) {
            this.navigationBrowseToolbarHelper.onCreateOptionsMenu(menu, getMenuInflater(), this.viewModel.getStore());
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override // com.box.android.activities.MainParent, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        if (getCurrentVisibleFragment() instanceof BrowseFragment) {
            this.mFabHelper.initializeFab(getFabMenu(), getFabMenuContainer(), new Function0() { // from class: com.box.android.navigation.Navigation$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$showFabMenu$7();
                }
            }, new Navigation$$ExternalSyntheticLambda5(this));
        }
        this.mBottomBarHelper.refresh();
        setBottomBarListeners();
        if (RationaleScreenHelper.INSTANCE.shouldShowRationale(RationaleScreenHelper.NOTIFICATION_RATIONALE)) {
            startActivity(new Intent(this, (Class<?>) NotificationPermissionRationaleActivity.class));
        }
    }

    public void refreshNavigationBarHubsButtonVisibility() {
        this.mBottomBarHelper.refresh();
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity
    public boolean amplitudeSetCurrentPage() {
        boolean zAmplitudeSetCurrentPage = super.amplitudeSetCurrentPage();
        BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
        eventPropertyBuilderCreateEventBuilder.setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION);
        if (!zAmplitudeSetCurrentPage) {
            if (getCurrentFragment() instanceof NavigationTabFragment) {
                amplitudeSetCurrentPageAndLog(eventPropertyBuilderCreateEventBuilder, getCurrentFragment().getAmplitudePageName());
                return true;
            }
            if (getCurrentVisibleFragment() instanceof BoxFragmentInterface) {
                amplitudeSetCurrentPageAndLog(eventPropertyBuilderCreateEventBuilder, getCurrentVisibleFragment().getAmplitudePageName());
                return true;
            }
        }
        return zAmplitudeSetCurrentPage;
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxInitialize(Bundle bundle) {
        super.onBoxInitialize(bundle);
        if (bundle != null) {
            this.mInitialNavTarget = (NavigationTarget) bundle.getSerializable(EXTRA_NAV_TARGET);
        } else if (getIntent() != null) {
            this.mInitialNavTarget = (NavigationTarget) getIntent().getSerializableExtra(EXTRA_NAV_TARGET);
            handleFirstNavigation();
        }
        runAutoContentUpload();
    }

    private void runAutoContentUpload() {
        if (this.mUserContextManager.getCurrentContext() != null) {
            LocalAutoContentUploadInformation localAutoContentUploadInformation = (LocalAutoContentUploadInformation) this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION);
            if (localAutoContentUploadInformation.isSyncEnabled()) {
                AutoUploadWorkerDispatcher.INSTANCE.setupAutoUpload(localAutoContentUploadInformation, this.mLocalItemService);
            }
        }
    }

    @Override // com.box.android.activities.MainParent, com.box.android.browse.fragments.BoxBrowseFragment.OnItemClickListener
    public void onItemClick(BoxItem boxItem) {
        super.onItemClick(boxItem);
        if (boxItem instanceof BoxFolder) {
            Intent intent = new Intent();
            intent.setClass(this, MainPhone.class);
            intent.setFlags(335544320);
            intent.putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, boxItem.getUserId());
            startActivity(intent);
            BoxAmplitudeAnalytics.createEventBuilder().setBoxItem(boxItem).setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaTarget(BoxAnalyticsParams.PAGE_NAME_FOLDER).setCtaPageLocation("body").setContentOwnershipType(NavigationAnalyticsUtils.calculateContentOwnership(boxItem, this.mBaseMoco, this.mBoxExtendedApiFolder, this.mUserContextManager)).setPageExperience(BoxAnalyticsParams.PAGE_EXPERIENCE_POPULATED).setTimeOnPage().logEvent(BoxAnalyticsParams.EVENT_SELECT_FOLDER_CTA_TRIGGERED);
        }
    }

    @Override // com.box.android.activities.MainParent
    protected void handleMenuClick(int i, BottomSheetAttributes.BottomSheetMenuCompletionDialog bottomSheetMenuCompletionDialog, BoxItem boxItem) {
        if (i == R.id.shared_links) {
            filterRecentItemsBy(ItemsFilter.SharedLinks.INSTANCE);
            return;
        }
        if (i == R.id.box_notes) {
            filterRecentItemsBy(ItemsFilter.BoxNotes.INSTANCE);
        } else if (i == R.id.all_recents) {
            filterRecentItemsBy(ItemsFilter.AllRecents.INSTANCE);
        } else {
            super.handleMenuClick(i, bottomSheetMenuCompletionDialog, boxItem);
        }
    }

    private void filterRecentItemsBy(ItemsFilter itemsFilter) {
        this.viewModel.getStore().send(new NavigationReducer.Action.NavigationRecentsAction(RecentsReducerKt.updateRecentsFilter(itemsFilter)));
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.fragments.IMainParent
    public BoxFragmentInterface getCurrentVisibleFragment() {
        BoxFragmentInterface currentFragment = getCurrentFragment();
        return currentFragment instanceof TabLayoutFragment ? ((TabLayoutFragment) currentFragment).getCurrentFragment() : currentFragment;
    }

    private BoxFragmentInterface getCurrentFragment() {
        if (!this.mUserContextManager.getCurrentContextId().equals(this.mCurrentUser)) {
            return null;
        }
        ActivityResultCaller activityResultCallerFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.filesfragmentembedded1);
        if (activityResultCallerFindFragmentById instanceof BoxFragmentInterface) {
            return (BoxFragmentInterface) activityResultCallerFindFragmentById;
        }
        return null;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(R.layout.layout_main_navigation);
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public void onActionModeCreated(ActionMode.Callback callback) {
        super.onActionModeCreated(callback);
        if (getCurrentFragment() instanceof NavigationTabFragment) {
            ((NavigationTabFragment) getCurrentFragment()).togglePaging(false);
        }
        this.mBottomBarHelper.hide();
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public void onActionModeDestroyed(ActionMode.Callback callback) {
        super.onActionModeDestroyed(callback);
        if (getCurrentFragment() instanceof NavigationTabFragment) {
            ((NavigationTabFragment) getCurrentFragment()).togglePaging(true);
        }
        this.mBottomBarHelper.show();
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public Snackbar displaySnackbar(BoxFragmentInterface boxFragmentInterface, int i, int i2, View.OnClickListener onClickListener) {
        if (getCurrentVisibleFragment() != boxFragmentInterface) {
            return null;
        }
        return super.displaySnackbar(boxFragmentInterface, i, i2, onClickListener);
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity, com.box.android.base.presentation.fragments.IMainParent
    public Snackbar displaySnackbar(int i, int i2, View.OnClickListener onClickListener) {
        this.mSnackbarDisplayFragment = getCurrentVisibleFragment();
        return super.displaySnackbar(i, i2, onClickListener);
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public Snackbar displaySnackbar(int i, int i2, View.OnClickListener onClickListener, int i3) {
        this.mSnackbarDisplayFragment = getCurrentVisibleFragment();
        return super.displaySnackbar(i, i2, onClickListener, i3);
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public Snackbar displaySnackbar(String str, int i, View.OnClickListener onClickListener) {
        this.mSnackbarDisplayFragment = getCurrentVisibleFragment();
        return super.displaySnackbar(str, i, onClickListener);
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public Snackbar displaySnackbar(String str, int i, View.OnClickListener onClickListener, int i2) {
        this.mSnackbarDisplayFragment = getCurrentVisibleFragment();
        return super.displaySnackbar(str, i, onClickListener, i2);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public void dismissOutdatedSnackbar(BoxFragmentInterface boxFragmentInterface) {
        if (this.mSnackbarDisplayFragment == null || boxFragmentInterface.getClass().equals(this.mSnackbarDisplayFragment.getClass())) {
            return;
        }
        dismissSnackbar();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public void dismissSnackbar(BoxFragmentInterface boxFragmentInterface) {
        if (this.mSnackbarDisplayFragment == null || !boxFragmentInterface.getClass().equals(this.mSnackbarDisplayFragment.getClass())) {
            return;
        }
        dismissSnackbar();
    }

    public static Intent createInstance(Context context, NavigationTarget navigationTarget) {
        Intent intent = new Intent(context, (Class<?>) Navigation.class);
        intent.putExtra(EXTRA_NAV_TARGET, navigationTarget);
        intent.addFlags(131072);
        return intent;
    }

    private class AppSearchViewListenerImpl implements AppSearchView.AppSearchViewListener {
        @Override // com.box.android.base.presentation.views.BoxSearchView.OnBoxSearchListener
        public void onSearchCollapsed() {
        }

        private AppSearchViewListenerImpl() {
        }

        @Override // com.box.android.browse.views.AppSearchView.AppSearchViewListener
        public void onFilterIconClicked() {
            Navigation.this.launchFilterSearchResultsActivity();
        }

        @Override // com.box.android.base.presentation.views.BoxSearchView.OnBoxSearchListener
        public void onSearchExpanded() {
            Navigation.this.mSearchActionLogHelper.clearSession();
        }

        @Override // com.box.android.base.presentation.views.BoxSearchView.OnBoxSearchListener
        public void onQueryTextChange(String str) {
            Navigation.this.mRecentSearchesListView.setVisibility(8);
            SearchFragment searchFragment = (SearchFragment) Navigation.this.getSupportFragmentManager().findFragmentByTag(NavigationTarget.SEARCH.name());
            if (searchFragment != null) {
                searchFragment.search(str);
            }
            Navigation.this.logSearchAction(str);
        }

        @Override // com.box.android.base.presentation.views.BoxSearchView.OnBoxSearchListener
        public void onQueryTextSubmit(String str) {
            Navigation.this.hideKeyboard();
        }
    }
}
