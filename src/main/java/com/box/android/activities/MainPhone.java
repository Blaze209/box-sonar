package com.box.android.activities;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.IntentCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.DialogNavigator;
import androidx.navigation.fragment.FragmentNavigator;
import com.box.android.R;
import com.box.android.adapters.NavigationBarAdapter;
import com.box.android.adapters.listitems.NavigationBarItem;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.utilities.EdgeToEdgeUtils;
import com.box.android.base.presentation.views.BoxSearchView;
import com.box.android.browse.cpl.browse.BrowseFragment;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.browse.cpl.offlined.OfflinedFragment;
import com.box.android.browse.cpl.recents.RecentsFragment;
import com.box.android.browse.fragments.BoxBrowseFragment;
import com.box.android.browse.fragments.BoxSearchFragment;
import com.box.android.browse.fragments.SearchFragment;
import com.box.android.browse.models.BoxSearchFilters;
import com.box.android.browse.utilities.BrowseFragmentFactory;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.browse.views.AppSearchView;
import com.box.android.collections.presentation.fragments.CollectionItemsFragment;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.GenericSavedStateViewModelFactory;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.coreservices.models.CustomBoxSession;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.mainphone.MainPhoneBrowseToolbarHelper;
import com.box.android.cpl.mainphone.MainPhoneReducer;
import com.box.android.cpl.mainphone.MainPhoneViewModel;
import com.box.android.cpl.mainphone.MainPhoneViewModelKt;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.search.SearchMode;
import com.box.android.jobsui.JobsUIActivity;
import com.box.android.routers.MainPhoneRouter;
import com.box.android.updates.proposal.AppUpdateProposalSnackbarExtensionKt;
import com.box.androidsdk.content.BoxCache;
import com.box.androidsdk.content.BoxConfig;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSearchItem;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public class MainPhone extends Hilt_MainPhone implements DefaultHardwareBackBtnHandler {
    private static final String EXTRA_IS_SEARCHVIEW_EXPANDED = "extraIsSearchViewExpanded";
    private static final String EXTRA_LAST_USED_BUNDLE = "extraLastUsedBundle";
    private static final int PROGRESS_SHOW_DELAY = 1000;

    @Inject
    protected BrowseFragmentFactory browseFragmentFactory;

    @Inject
    protected CopyOrMoveHelper copyOrMoveHelper;
    private boolean filePickerMode;

    @Inject
    protected IntentServices intentServices;
    private boolean isUnifiedSearchEnabled;
    private boolean mIsRedesignEnabled;
    private Bundle mLastLoadedBundle;
    private NavigationBarAdapter mNavigationAdapter;
    private Spinner mNavigationSpinner;
    private MenuItem mSearchViewMenuItem;
    private Toolbar mToolbar;

    @Inject
    protected MainPhoneBrowseToolbarHelper mainPhoneBrowseToolbarHelper;

    @Inject
    protected MainPhoneViewModel.Factory mainPhoneViewModelFactory;
    private NavHostController navHostController;
    private ConstraintLayout navigationLayout;
    private ProgressBar navigationProgressBar;
    private TextView navigationSpinnerPlaceholderView;
    private MainPhoneRouter router;
    private MainPhoneViewModel viewModel;
    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.box.android.activities.MainPhone.1
        @Override // androidx.activity.result.ActivityResultCallback
        public void onActivityResult(ActivityResult activityResult) {
            if (MainPhone.this.viewModel != null) {
                MainPhone.this.viewModel.getStore().send(new MainPhoneReducer.Action.BrowseNestedAction(BrowseReducer.Action.ChildScreenClosed.INSTANCE));
            }
        }
    });
    private final ActivityResultLauncher<Intent> searchLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.box.android.activities.MainPhone$$ExternalSyntheticLambda9
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.handleSearchResult((ActivityResult) obj);
        }
    });
    private boolean mIsSearchViewExpanded = false;
    private Runnable navigationProgressShower = new Runnable() { // from class: com.box.android.activities.MainPhone.2
        @Override // java.lang.Runnable
        public void run() {
            MainPhone.this.mNavigationSpinner.setVisibility(8);
            MainPhone.this.navigationProgressBar.setVisibility(0);
        }
    };

    public int getMainLayout() {
        return R.layout.main_phone;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        if (bundle != null) {
            getIntent().putParcelableArrayListExtra(IntentConstants.EXTRA_INIT_STATE, bundle.getParcelableArrayList(IntentConstants.EXTRA_INIT_STATE));
        }
        super.onMAMCreate(null);
    }

    private NavHostController getNavHostController() {
        NavHostController navHostController = this.navHostController;
        if (navHostController != null) {
            return navHostController;
        }
        this.navHostController = new NavHostController(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        supportFragmentManager.setFragmentFactory(this.browseFragmentFactory);
        this.navHostController.getNavigatorProvider().addNavigator(new FragmentNavigator(this, supportFragmentManager, R.id.filesfragmentembedded1));
        this.navHostController.getNavigatorProvider().addNavigator(new DialogNavigator());
        this.navHostController.setGraph(R.navigation.nav_graph);
        return this.navHostController;
    }

    private void initializeNavigationComponents() {
        String string = getIntent().getExtras().getString(IntentConstants.EXTRA_INIT_FOLDER_ID);
        String string2 = getIntent().getExtras().getString(IntentConstants.EXTRA_ITEM_NAME);
        String string3 = getIntent().getExtras().getString(IntentConstants.EXTRA_INIT_COLLECTION_ID);
        this.filePickerMode = getIntent().getExtras().getBoolean(IntentConstants.EXTRA_FILE_PICKER_MODE, false);
        ArrayList<? extends Parcelable> parcelableArrayList = getIntent().getExtras().getParcelableArrayList(IntentConstants.EXTRA_INIT_STATE);
        if (string == null && string3 == null) {
            return;
        }
        this.router = new MainPhoneRouter(this.mItemActionHandler, this, this.copyOrMoveHelper, this.intentServices, this.mUserContextManager, this.launcher, this.mFeatureFlips, this.filePickerMode);
        Bundle bundle = new Bundle();
        bundle.putString(MainPhoneReducer.BROWSE_INITIAL_FOLDER_ID, string);
        bundle.putString(MainPhoneReducer.BROWSE_INITIAL_FOLDER_NAME, string2);
        bundle.putString(MainPhoneReducer.BROWSE_INITIAL_COLLECTION_ID, string3);
        bundle.putParcelableArrayList(MainPhoneViewModelKt.RESTORE_STATE_KEY, parcelableArrayList);
        this.viewModel = (MainPhoneViewModel) new ViewModelProvider(this, new GenericSavedStateViewModelFactory(this.mainPhoneViewModelFactory, this, bundle)).get(MainPhoneViewModel.class);
        this.router.initNavigation(getNavHostController(), this.viewModel.getStore());
        this.router.initBackNavigationHandler(this.viewModel.getStore(), this.mIsRedesignEnabled ? null : getFabMenu(), new Function0() { // from class: com.box.android.activities.MainPhone$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(this.f$0.tryCollapseSearch());
            }
        });
        if (this.mIsRedesignEnabled) {
            getFabMenuContainer().setVisibility(8);
            return;
        }
        this.mFabHelper.initializeFabFolderModel(getFabMenu(), getFabMenuContainer(), new Function0() { // from class: com.box.android.activities.MainPhone$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f$0.lambda$initializeNavigationComponents$0();
            }
        }, new Function1() { // from class: com.box.android.activities.MainPhone$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.sendBrowseAction((BrowseReducer.Action) obj);
            }
        });
        if (this.filePickerMode) {
            return;
        }
        toggleFab(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ FolderModel lambda$initializeNavigationComponents$0() {
        return this.viewModel.getStore().getState().getValue().getCurrentlyVisibleFolder();
    }

    @Override // com.box.android.activities.MainParent
    protected Unit sendBrowseAction(BrowseReducer.Action action) {
        MainPhoneViewModel mainPhoneViewModel = this.viewModel;
        if (mainPhoneViewModel == null) {
            return null;
        }
        mainPhoneViewModel.getStore().send(new MainPhoneReducer.Action.ForBrowse(action));
        return null;
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        this.mIsRedesignEnabled = this.mFeatureFlips.getMainScreenRedesign().getEnabled();
        this.isUnifiedSearchEnabled = this.mFeatureFlips.getUnifiedSearch().getEnabled();
        initializeNavigationComponents();
        restoreSavedState(bundle);
        setupRecentSearch();
        setupToolbar();
        setupEdgeToEdge();
        AppUpdateProposalSnackbarExtensionKt.registerForUpdateDownloadedSnackbar(this.appUpdateProposalManager, this);
    }

    private void restoreSavedState(Bundle bundle) {
        if (bundle != null) {
            this.mIsSearchViewExpanded = bundle.getBoolean(EXTRA_IS_SEARCHVIEW_EXPANDED);
            this.mLastLoadedBundle = bundle.getBundle(EXTRA_LAST_USED_BUNDLE);
        }
    }

    private void setupToolbar() {
        if (this.mIsRedesignEnabled) {
            findViewById(R.id.htab_appbar).setBackgroundColor(CommonBoxUtil.getColorFromAttribute(this, R.attr.contentBackground));
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.main_toolbar_container);
        if (viewGroup == null) {
            return;
        }
        LayoutInflater.from(this).inflate(this.mIsRedesignEnabled ? R.layout.toolbar_with_nav : R.layout.toolbar_with_nav_legacy, viewGroup, true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.mainToolbar);
        this.mToolbar = toolbar;
        if (toolbar == null) {
            return;
        }
        setSupportActionBar(toolbar);
        initNavigationControls();
        observeHierarchyUpdates();
        setupNavigationSpinner();
    }

    private void initNavigationControls() {
        this.mNavigationSpinner = (Spinner) this.mToolbar.findViewById(R.id.spinner_nav);
        this.navigationProgressBar = (ProgressBar) this.mToolbar.findViewById(R.id.navigation_progress_bar);
        this.navigationSpinnerPlaceholderView = (TextView) this.mToolbar.findViewById(R.id.breadcrumb_placeholder_view);
        this.navigationLayout = (ConstraintLayout) this.mToolbar.findViewById(R.id.spinner_layout);
    }

    private void observeHierarchyUpdates() {
        MainPhoneViewModel mainPhoneViewModel = this.viewModel;
        if (mainPhoneViewModel == null) {
            return;
        }
        this.mainPhoneBrowseToolbarHelper.observeHierarchyUpdates(mainPhoneViewModel.getStore(), new Function1() { // from class: com.box.android.activities.MainPhone$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$observeHierarchyUpdates$2((List) obj);
            }
        }, new Function1() { // from class: com.box.android.activities.MainPhone$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f$0.lambda$observeHierarchyUpdates$3((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$observeHierarchyUpdates$2(final List list) {
        this.mNavigationSpinner.post(new Runnable() { // from class: com.box.android.activities.MainPhone$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$observeHierarchyUpdates$1(list);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$observeHierarchyUpdates$3(Boolean bool) {
        handleHierarchyRefreshingState(bool.booleanValue());
        return Unit.INSTANCE;
    }

    private void handleHierarchyRefreshingState(boolean z) {
        if (this.mIsSearchViewExpanded || this.navigationProgressBar == null) {
            return;
        }
        if (z) {
            this.navigationSpinnerPlaceholderView.setVisibility(0);
            this.mNavigationSpinner.postDelayed(this.navigationProgressShower, 1000L);
        } else {
            this.mNavigationSpinner.removeCallbacks(this.navigationProgressShower);
            this.mNavigationSpinner.setVisibility(0);
            this.navigationSpinnerPlaceholderView.setVisibility(8);
            this.navigationProgressBar.setVisibility(8);
        }
    }

    private void setupNavigationSpinner() {
        NavigationBarAdapter navigationBarAdapter = new NavigationBarAdapter(this, new ArrayList(), this.mFeatureFlips);
        this.mNavigationAdapter = navigationBarAdapter;
        this.mNavigationSpinner.setAdapter((SpinnerAdapter) navigationBarAdapter);
        this.mNavigationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.box.android.activities.MainPhone.3
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                MainPhone.this.handleNavigationItemSelected(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNavigationItemSelected(int i) {
        NavigationBarItem item = this.mNavigationAdapter.getItem(i);
        if (item.getType() == 2 || item.getType() == 3) {
            if (item.getType() == 3 || item.getId().equals("0")) {
                navigateToAllFiles();
                return;
            } else {
                navigateToFolder(BoxFolder.createFromIdAndName(item.getId(), item.getName()));
                return;
            }
        }
        if (item.getType() == 6) {
            onMyCollectionsTabClick();
        }
    }

    @Override // com.box.android.activities.MainParent
    protected void setupRecentSearch() {
        super.setupRecentSearch();
        if (this.mIsSearchViewExpanded) {
            loadRecentSearch();
        }
    }

    private void refreshNavigationBarItems() {
        this.viewModel.getStore().send(MainPhoneReducer.Action.RefreshHierarchy.INSTANCE);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public boolean showNonActionItems() {
        return this.mSearchView == null || !isSearchExpanded();
    }

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        return this.router.onSupportNavigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tryCollapseSearch() {
        if (clearSearch()) {
            return true;
        }
        if (!this.mIsSearchViewExpanded) {
            return false;
        }
        this.mSearchView.setIconified(true);
        return true;
    }

    private void setToolbarColorAndIcon() {
        this.mRecentSearchesListView.setVisibility(!isSearchExpanded() || this.mSearchView.getQuery().length() != 0 ? 8 : 0);
        if (this.mRecentSearches == null || this.mRecentSearches.size() == 0) {
            this.mRecentSearchesHeader.setVisibility(8);
            this.mRecentSearchesFooter.setVisibility(8);
        } else {
            this.mRecentSearchesHeader.setVisibility(0);
            this.mRecentSearchesFooter.setVisibility(0);
        }
        displayHomeAsUp();
        if (isSearchExpanded()) {
            Toolbar toolbar = this.mToolbar;
            if (toolbar != null) {
                toolbar.setBackgroundResource(R.drawable.toolbar_search_background);
                this.mToolbar.setNavigationIcon((Drawable) null);
                return;
            }
            return;
        }
        Toolbar toolbar2 = this.mToolbar;
        if (toolbar2 != null) {
            toolbar2.setBackgroundColor(CommonBoxUtil.getColorFromAttribute(toolbar2.getContext(), R.attr.topBarBackground));
        }
        if (this.mRecentSearchesListView != null) {
            this.mRecentSearchesListView.setVisibility(8);
        }
    }

    private void displayHomeAsUp() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public void onItemClick(BoxItem boxItem, boolean z) {
        if (getCurrentVisibleFragment() instanceof SearchFragment) {
            this.mBrowseController.addToRecentSearches(this, this.mUserContextManager.getUserInfo(), ((SearchFragment) getCurrentVisibleFragment()).getSearchQuery());
            if (boxItem instanceof BoxFolder) {
                hideKeyboard();
            }
        }
        super.onItemClick(boxItem);
        if (boxItem instanceof BoxSearchItem) {
            this.mIsSearchViewExpanded = false;
        } else if (boxItem instanceof BoxFolder) {
            logOnUserSessionError();
            this.mIsSearchViewExpanded = false;
            this.mItemActionHandler.onItemClick(boxItem, z, null, null);
        }
    }

    private void logOnUserSessionError() {
        try {
            if (this.mUserContextManager.getBoxSession(this).getUserId() != null) {
            } else {
                throw new RuntimeException("no user id , activity = " + this);
            }
        } catch (Exception e) {
            if (this.mUserContextManager.getBoxSession(this).getUserId() == null) {
                BoxLogUtils.e(MainPhone.class.getName(), e);
                if (((CustomBoxSession) this.mUserContextManager.getBoxSession(this)).getDebuggingException() != null) {
                    BoxLogUtils.e(MainPhone.class.getName(), ((CustomBoxSession) this.mUserContextManager.getBoxSession(this)).getDebuggingException());
                }
            }
        }
    }

    @Override // com.box.android.activities.MainParent, com.box.android.browse.fragments.BoxBrowseFragment.OnItemClickListener
    public void onItemClick(BoxItem boxItem) {
        onItemClick(boxItem, true);
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity
    public boolean amplitudeSetCurrentPage() {
        boolean zAmplitudeSetCurrentPage = super.amplitudeSetCurrentPage();
        BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
        eventPropertyBuilderCreateEventBuilder.setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION);
        if (this.mIsSearchViewExpanded) {
            amplitudeSetCurrentPageAndLog(eventPropertyBuilderCreateEventBuilder, BoxAnalyticsParams.PAGE_NAME_SEARCH);
            return true;
        }
        if (zAmplitudeSetCurrentPage || !(getCurrentVisibleFragment() instanceof BoxFragmentInterface)) {
            return zAmplitudeSetCurrentPage;
        }
        amplitudeSetCurrentPageAndLog(eventPropertyBuilderCreateEventBuilder, getCurrentVisibleFragment().getAmplitudePageName());
        return true;
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(this.mIsRedesignEnabled ? R.menu.folder_activity_menu : R.menu.folder_activity_menu_legacy, menu);
        this.mSearchViewMenuItem = menu.findItem(R.id.folder_search_menu_item);
        Fragment fragment = (Fragment) getCurrentVisibleFragment();
        this.mSearchView = (AppSearchView) this.mSearchViewMenuItem.getActionView();
        this.mSearchView.setFilterButtonVisible(!this.mIsRedesignEnabled);
        this.mSearchViewMenuItem.setVisible(isSearchAvailable());
        this.mSearchViewMenuItem.setEnabled(isSearchAvailable());
        setupSearchView();
        if (fragment instanceof SearchFragment) {
            this.mSearchView.setSearchTerm(((SearchFragment) getCurrentVisibleFragment()).getSearchQuery());
        }
        this.mSearchView.setOnBoxSearchListener(new AppSearchViewListenerImpl());
        setToolbarColorAndIcon();
        this.mainPhoneBrowseToolbarHelper.onCreateOptionsMenu(menu, getMenuInflater(), this.viewModel.getStore());
        return super.onCreateOptionsMenu(menu);
    }

    private String getCurrentFolderName() {
        BoxFragmentInterface currentVisibleFragment = getCurrentVisibleFragment();
        if (currentVisibleFragment instanceof SearchFragment) {
            return ((SearchFragment) currentVisibleFragment).getParentFolder().getName();
        }
        return ((MainPhoneReducer.State) StoreKt.stateValue(this.viewModel.getStore())).getCurrentlyVisibleFolderName();
    }

    private void setupSearchView() {
        BoxSearchFilters searchFilters;
        if (this.mIsSearchViewExpanded) {
            this.mSearchView.setIconified(false);
            this.mSearchView.setFilterButtonVisible(!this.mIsRedesignEnabled);
            if ((getCurrentVisibleFragment() instanceof SearchFragment) && (searchFilters = ((SearchFragment) getCurrentVisibleFragment()).getSearchFilters()) != null && searchFilters.anyFiltersSet()) {
                this.mSearchView.setFilteringIcon(searchFilters);
            }
            this.mSearchView.setQueryHint(String.format(getResources().getString(R.string.search_hint), getCurrentFolderName()));
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return Integer.valueOf(getMainLayout());
    }

    /* JADX WARN: Code duplicated, block: B:12:0x006d  */
    protected void initializeFirstNavigation() {
        String string;
        int i;
        String string2;
        if (getIntent() == null || getIntent().getExtras() == null) {
            string = null;
            i = 1;
            string2 = null;
        } else {
            String[] strArr = {IntentConstants.EXTRA_INIT_FOLDER_ID, IntentConstants.EXTRA_ITEM_NAME, IntentConstants.EXTRA_INIT_NAV_DRAWER_ITEM_ID, IntentConstants.EXTRA_INIT_COLLECTION_ID};
            Bundle bundle = this.mLastLoadedBundle;
            if (bundle == null || !CommonBoxUtil.compareBundles(bundle, getIntent().getExtras(), strArr)) {
                string = getIntent().getExtras().getString(IntentConstants.EXTRA_INIT_FOLDER_ID);
                i = getIntent().getExtras().getInt(IntentConstants.EXTRA_INIT_NAV_DRAWER_ITEM_ID, 1);
                string2 = getIntent().getExtras().getString(IntentConstants.EXTRA_INIT_COLLECTION_ID);
                this.mLastLoadedBundle = CommonBoxUtil.copyBundle(getIntent().getExtras(), strArr);
            } else {
                string = null;
                i = 1;
                string2 = null;
            }
        }
        if (i != 1) {
            if (i == 10) {
                navigateToTransfer();
                finish();
            }
        } else if (string != null || string2 != null) {
            this.router.initNavigation(getNavHostController(), this.viewModel.getStore());
        } else if (this.mFragmentManager.getBackStackEntryCount() == 0 && this.mFragmentManager.findFragmentById(R.id.filesfragmentembedded1) == null) {
            onItemClick(BoxFolder.createFromId("0"), false);
        }
        getWindow().setSoftInputMode(3);
    }

    private boolean isSearchAvailable() {
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.filesfragmentembedded1);
        if ((fragmentFindFragmentById instanceof RecentsFragment) || (fragmentFindFragmentById instanceof OfflinedFragment)) {
            return false;
        }
        return (fragmentFindFragmentById instanceof SearchFragment) || (fragmentFindFragmentById instanceof BrowseFragment);
    }

    @Override // com.box.android.activities.MainParent
    protected boolean shouldFabBeVisible(BoxFragmentInterface boxFragmentInterface) {
        return (boxFragmentInterface == null || this.mIsRedesignEnabled || !boxFragmentInterface.isFloatingMenuAvailable() || this.mIsSearchViewExpanded) ? false : true;
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxInitialize(Bundle bundle) {
        super.onBoxInitialize(bundle);
        initializeFirstNavigation();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMSaveInstanceState(Bundle bundle) {
        bundle.putBoolean(EXTRA_IS_SEARCHVIEW_EXPANDED, this.mIsSearchViewExpanded);
        bundle.putBundle(EXTRA_LAST_USED_BUNDLE, this.mLastLoadedBundle);
        MainPhoneViewModel mainPhoneViewModel = this.viewModel;
        if (mainPhoneViewModel != null) {
            bundle.putParcelableArrayList(IntentConstants.EXTRA_INIT_STATE, mainPhoneViewModel.getBrowsingHierarchy());
        }
        super.onMAMSaveInstanceState(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            keyEvent.startTracking();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setNavigationBarItems, reason: merged with bridge method [inline-methods] */
    public synchronized void lambda$observeHierarchyUpdates$1(List<NavigationBarItem> list) {
        this.navigationLayout.setVisibility(0);
        if (list != null && list.size() > 0) {
            if (getSupportActionBar() == null) {
                return;
            }
            if (list.size() == 1) {
                this.mNavigationSpinner.setVisibility(8);
                this.navigationLayout.setVisibility(8);
                getSupportActionBar().setTitle(list.get(0).getName());
                getSupportActionBar().setDisplayShowTitleEnabled(true);
                return;
            }
            if (isSearchExpanded()) {
                this.mNavigationSpinner.setVisibility(8);
            } else {
                this.mNavigationSpinner.setVisibility(0);
            }
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            this.mNavigationAdapter.setNavigationList(list);
            this.mNavigationSpinner.setSelection(list.size() - 1);
            return;
        }
        Spinner spinner = this.mNavigationSpinner;
        if (spinner != null) {
            spinner.setVisibility(8);
        }
    }

    @Override // com.box.android.activities.MainParent, androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        super.onBackStackChanged();
        refreshScreenState();
        updateFab();
    }

    @Override // com.box.android.activities.MainParent
    public void onScreenResume() {
        super.onScreenResume();
        refreshScreenState();
    }

    private void updateFab() {
        if (getCurrentVisibleFragment() == null || this.mIsRedesignEnabled) {
            return;
        }
        setupFab();
    }

    private void refreshScreenState() {
        BoxFragmentInterface currentVisibleFragment = getCurrentVisibleFragment();
        if (currentVisibleFragment != null) {
            if (isSearchExpanded() && !(currentVisibleFragment instanceof SearchFragment)) {
                clearSearch();
            }
            if (this.mSearchView != null && (currentVisibleFragment instanceof SearchFragment)) {
                this.mSearchView.setIconified(false);
                this.mSearchView.setFilterButtonVisible(!this.mIsRedesignEnabled);
            }
            if (getSupportActionBar() != null) {
                if ((currentVisibleFragment instanceof BrowseFragment) || (currentVisibleFragment instanceof CollectionItemsFragment)) {
                    refreshNavigationBarItems();
                } else {
                    this.mNavigationSpinner.setVisibility(8);
                    getSupportActionBar().setDisplayShowTitleEnabled(true);
                    getSupportActionBar().setTitle(currentVisibleFragment.getTitle(this));
                    displayHomeAsUp();
                }
            }
            if (currentVisibleFragment instanceof CollectionItemsFragment) {
                dismissSnackbar();
            }
        }
        invalidateOptionsMenu();
    }

    @Override // com.box.android.activities.MainParent, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public boolean onMAMPrepareOptionsMenu(Menu menu) {
        if (isSearchExpanded()) {
            return true;
        }
        return super.onMAMPrepareOptionsMenu(menu);
    }

    @Override // com.box.android.activities.MainParent, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (isSearchExpanded() && menuItem.getItemId() == 16908332) {
            this.mSearchView.setIconified(true);
            return true;
        }
        if (menuItem.getItemId() == R.id.transfers_menu_item) {
            navigateToTransfer();
            return true;
        }
        this.mainPhoneBrowseToolbarHelper.onOptionsItemSelected(menuItem, this.viewModel.getStore(), this);
        return super.onOptionsItemSelected(menuItem);
    }

    private void navigateToTransfer() {
        Intent intent = new Intent(this, (Class<?>) JobsUIActivity.class);
        intent.setFlags(335544320);
        startActivity(intent);
    }

    private boolean clearSearch() {
        MenuItem menuItem = this.mSearchViewMenuItem;
        if (menuItem == null || this.mIsSearchViewExpanded) {
            return false;
        }
        BoxSearchView boxSearchView = (BoxSearchView) MenuItemCompat.getActionView(menuItem);
        if (!this.mSearchView.isExpanded()) {
            return false;
        }
        boxSearchView.onActionViewCollapsed();
        boxSearchView.setIconified(true);
        return true;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        getSupportFragmentManager().removeOnBackStackChangedListener(this);
        this.mToolbar = null;
        super.onMAMDestroy();
    }

    @Override // com.box.android.activities.MainParent
    protected void launchSearchFolder(String str, BoxSearchFilters boxSearchFilters) {
        BoxFolder boxFolderLambda$showFabMenu$7 = lambda$showFabMenu$7();
        Bundle bundle = new Bundle();
        bundle.putString(BoxBrowseFragment.ARG_USER_ID, this.mUserContextManager.getBoxSession(this).getUserId());
        bundle.putString(BoxSearchFragment.OUT_QUERY, str);
        bundle.putSerializable(BoxSearchFragment.EXTRA_PARENT_FOLDER, boxFolderLambda$showFabMenu$7);
        bundle.putSerializable(BoxSearchFragment.EXTRA_SEARCH_FILTERS, boxSearchFilters);
        bundle.putBoolean(BoxSearchFragment.EXTRA_IS_REDESIGNED, this.mIsRedesignEnabled);
        getNavHostController().navigate(R.id.searchFragment, bundle);
        if (this.mSearchView != null) {
            this.mSearchView.setFilteringIcon(boxSearchFilters);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.android.activities.MainParent
    /* JADX INFO: renamed from: getCurrentlyVisibleFolder */
    public BoxFolder lambda$showFabMenu$7() {
        return FolderModelMapper.INSTANCE.toBoxFolder(((MainPhoneReducer.State) StoreKt.stateValue(this.viewModel.getStore())).getCurrentlyVisibleFolder(), false);
    }

    @Override // com.box.android.activities.MainParent
    public void navigateToFolder(BoxFolder boxFolder) {
        this.viewModel.getStore().send(new MainPhoneReducer.Action.NavigateToFolder(FolderModelMapper.INSTANCE.toFolderModel(boxFolder, true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSearchResult(ActivityResult activityResult) {
        if (activityResult.getResultCode() != -1 || activityResult.getData() == null) {
            return;
        }
        FileModel fileModel = (FileModel) IntentCompat.getParcelableExtra(activityResult.getData(), IntentConstants.EXTRA_PICKED_FILE, FileModel.class);
        if (fileModel != null) {
            returnPickedFileToCaller(fileModel);
            return;
        }
        String stringExtra = activityResult.getData().getStringExtra(IntentConstants.EXTRA_INIT_FOLDER_ID);
        if (stringExtra != null) {
            navigateToFolder(BoxFolder.createFromIdAndName(stringExtra, activityResult.getData().getStringExtra(IntentConstants.EXTRA_ITEM_NAME)));
        }
    }

    private void returnPickedFileToCaller(FileModel fileModel) {
        final BoxFile boxFile = FileModelMapper.INSTANCE.toBoxFile(fileModel, false);
        new Thread(new Runnable() { // from class: com.box.android.activities.MainPhone$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$returnPickedFileToCaller$5(boxFile);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$returnPickedFileToCaller$5(final BoxFile boxFile) {
        final boolean zCachePickedFileForDownload = cachePickedFileForDownload(boxFile);
        runOnUiThread(new Runnable() { // from class: com.box.android.activities.MainPhone$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$returnPickedFileToCaller$4(boxFile, zCachePickedFileForDownload);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onPickedFileCached, reason: merged with bridge method [inline-methods] */
    public void lambda$returnPickedFileToCaller$4(BoxFile boxFile, boolean z) {
        if (isFinishing() || isDestroyed()) {
            return;
        }
        if (z) {
            this.mItemActionHandler.onItemPicked(boxFile);
        } else {
            BoxPresentationUtils.displayToast(R.string.err_unknown, this, new String[0]);
        }
    }

    private boolean cachePickedFileForDownload(BoxFile boxFile) {
        BoxCache cache = BoxConfig.getCache();
        if (cache == null) {
            BoxLogUtils.e("Cannot return picked file: SDK cache is unavailable");
            return false;
        }
        try {
            cache.saveItem(boxFile, false);
            return true;
        } catch (Exception e) {
            BoxLogUtils.logException(e);
            return false;
        }
    }

    @Override // com.box.android.activities.MainParent, com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public Snackbar displaySnackbar(int i, int i2, @Nullable View.OnClickListener onClickListener, int i3) {
        View viewFindViewById = findViewById(R.id.snackbar_container);
        viewFindViewById.setVisibility(0);
        String strLS = CommonBoxUtil.LS(i);
        if ((viewFindViewById.getParent() instanceof View) && ((View) viewFindViewById.getParent()).getAlpha() == 0.0f) {
            BoxPresentationUtils.displayToast(strLS, this);
        }
        this.mSnackBar = BoxPresentationUtils.displaySnackBar(this, viewFindViewById, strLS, i2, onClickListener, i3);
        if (!this.mIsRedesignEnabled) {
            this.mSnackBar.addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() { // from class: com.box.android.activities.MainPhone.4
                @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
                public void onShown(Snackbar snackbar) {
                    super.onShown(snackbar);
                    MainPhone.this.updateFabMargin();
                }

                @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
                public void onDismissed(Snackbar snackbar, int i4) {
                    super.onDismissed(snackbar, i4);
                    MainPhone.this.updateFabMargin();
                }
            });
        }
        return this.mSnackBar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateBreadcrumbsView() {
        if (this.navigationProgressBar != null) {
            if (this.viewModel.getStore().getState().getValue().getHierarchyRefreshing()) {
                this.mNavigationSpinner.setVisibility(8);
                this.navigationSpinnerPlaceholderView.setVisibility(0);
                this.navigationProgressBar.setVisibility(0);
            } else {
                this.mNavigationSpinner.setVisibility(0);
                this.navigationSpinnerPlaceholderView.setVisibility(8);
                this.navigationProgressBar.setVisibility(8);
            }
        }
    }

    private void setupEdgeToEdge() {
        if (this.mIsRedesignEnabled) {
            int colorFromAttribute = CommonBoxUtil.getColorFromAttribute(this, R.attr.contentBackground);
            findViewById(R.id.coordinator_layout).setBackgroundColor(colorFromAttribute);
            EdgeToEdgeUtils.INSTANCE.enableAutoEdgeToEdge(this, colorFromAttribute);
        }
        EdgeToEdgeUtils.INSTANCE.setInsets(findViewById(R.id.coordinator_layout), new EdgeToEdgeUtils.OnInsetsAppliedListener() { // from class: com.box.android.activities.MainPhone$$ExternalSyntheticLambda1
            @Override // com.box.android.base.presentation.utilities.EdgeToEdgeUtils.OnInsetsAppliedListener
            public final void onInsetsApplied(View view, Insets insets, WindowInsetsCompat windowInsetsCompat) {
                this.f$0.lambda$setupEdgeToEdge$6(view, insets, windowInsetsCompat);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupEdgeToEdge$6(View view, Insets insets, WindowInsetsCompat windowInsetsCompat) {
        if (!this.mIsRedesignEnabled) {
            View viewFindViewById = view.findViewById(R.id.fab_menu_container);
            viewFindViewById.setPadding(viewFindViewById.getPaddingLeft(), viewFindViewById.getPaddingTop(), viewFindViewById.getPaddingRight(), insets.bottom);
        }
        View viewFindViewById2 = view.findViewById(R.id.filesfragmentembedded1);
        if (viewFindViewById2 != null) {
            ViewCompat.dispatchApplyWindowInsets(viewFindViewById2, windowInsetsCompat);
        }
    }

    @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
    public void invokeDefaultOnBackPressed() {
        getOnBackPressedDispatcher().onBackPressed();
    }

    private class AppSearchViewListenerImpl implements AppSearchView.AppSearchViewListener {
        private AppSearchViewListenerImpl() {
        }

        @Override // com.box.android.browse.views.AppSearchView.AppSearchViewListener
        public void onFilterIconClicked() {
            MainPhone.this.launchFilterSearchResultsActivity();
        }

        @Override // com.box.android.base.presentation.views.BoxSearchView.OnBoxSearchListener
        public void onSearchExpanded() {
            if (MainPhone.this.isUnifiedSearchEnabled) {
                FolderModel currentlyVisibleFolder = ((MainPhoneReducer.State) StoreKt.stateValue(MainPhone.this.viewModel.getStore())).getCurrentlyVisibleFolder();
                if (currentlyVisibleFolder != null) {
                    Intent intentSearchActivityIntent = MainPhone.this.intentServices.searchActivityIntent(MainPhone.this, new SearchMode.Files(currentlyVisibleFolder));
                    intentSearchActivityIntent.putExtra(IntentConstants.EXTRA_RETURN_FOLDER_TO_CALLER, true);
                    intentSearchActivityIntent.putExtra("ai_center_enabled", !MainPhone.this.filePickerMode);
                    if (MainPhone.this.filePickerMode) {
                        intentSearchActivityIntent.putExtra(IntentConstants.EXTRA_RETURN_FILE_TO_CALLER, true);
                    }
                    MainPhone.this.searchLauncher.launch(intentSearchActivityIntent);
                    MainPhone.this.mSearchView.setIconified(true);
                    BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.SEARCH_OPENED_LOCATION_FOLDER).setCtaTarget(BoxAnalyticsParams.PAGE_NAME_SEARCH).logEvent(BoxAnalyticsParams.EVENT_BROWSE_SEARCH_OPENED);
                    return;
                }
                return;
            }
            if (!MainPhone.this.mIsSearchViewExpanded) {
                MainPhone.this.logSearchTriggered(BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP);
            }
            MainPhone.this.mIsSearchViewExpanded = true;
            MainPhone.this.invalidateOptionsMenu();
            MainPhone.this.mNavigationSpinner.setVisibility(8);
            MainPhone.this.navigationProgressBar.setVisibility(8);
            MainPhone.this.navigationSpinnerPlaceholderView.setVisibility(8);
            if (MainPhone.this.getCurrentVisibleFragment() instanceof SearchFragment) {
                return;
            }
            if (MainPhone.this.mIsRedesignEnabled) {
                MainPhone.this.sendBrowseAction(new BrowseReducer.Action.ChangeFabVisibility(false));
            } else {
                MainPhone.this.getFabMenu().hideMenuButton(true);
            }
            MainPhone.this.loadRecentSearch();
            MainPhone.this.amplitudeSetCurrentPage();
            MainPhone.this.mSearchActionLogHelper.clearSession();
        }

        @Override // com.box.android.base.presentation.views.BoxSearchView.OnBoxSearchListener
        public void onSearchCollapsed() {
            MainPhone.this.mIsSearchViewExpanded = false;
            MainPhone.this.invalidateOptionsMenu();
            MainPhone.this.mNavigationSpinner.setVisibility(0);
            MainPhone.this.invalidateBreadcrumbsView();
            MainPhone.this.mToolbar.setNavigationIcon(R.drawable.ic_toolbar_back_btn);
            if (MainPhone.this.getCurrentVisibleFragment() instanceof SearchFragment) {
                MainPhone.this.getSupportFragmentManager().popBackStack();
            }
            if (MainPhone.this.mIsRedesignEnabled) {
                MainPhone.this.sendBrowseAction(new BrowseReducer.Action.ChangeFabVisibility(true));
            } else {
                MainPhone.this.getFabMenu().showMenuButton(true);
            }
            MainPhone.this.amplitudeSetCurrentPage();
        }

        @Override // com.box.android.base.presentation.views.BoxSearchView.OnBoxSearchListener
        public void onQueryTextChange(String str) {
            if (!TextUtils.isEmpty(str) || (MainPhone.this.getCurrentVisibleFragment() instanceof SearchFragment)) {
                MainPhone.this.mRecentSearchesListView.setVisibility(8);
                if (!(MainPhone.this.getCurrentVisibleFragment() instanceof SearchFragment)) {
                    MainPhone.this.launchSearchFolder(str, null);
                } else {
                    ((SearchFragment) MainPhone.this.getCurrentVisibleFragment()).search(str);
                }
                MainPhone.this.logSearchAction(str);
            }
        }

        @Override // com.box.android.base.presentation.views.BoxSearchView.OnBoxSearchListener
        public void onQueryTextSubmit(String str) {
            MainPhone.this.hideKeyboard();
        }
    }
}
