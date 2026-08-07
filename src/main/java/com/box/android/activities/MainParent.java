package com.box.android.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.R;
import com.box.android.activities.settings.SettingsActivity;
import com.box.android.application.BoxBaseApplication;
import com.box.android.auth.AuthenticationActivity;
import com.box.android.base.analytics.UploadAnalyticsUtils;
import com.box.android.base.presentation.BoxFragmentInterface;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.base.presentation.activities.CreatePincodeActivity;
import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressReducer;
import com.box.android.base.presentation.components.topbar.component.jobsprogress.JobsProgressViewModel;
import com.box.android.base.presentation.fragments.BaseFTUX;
import com.box.android.base.presentation.fragments.BottomSheetMenuFragment;
import com.box.android.base.presentation.fragments.IMainParent;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.utilities.AddFabHelper;
import com.box.android.base.presentation.utilities.EdgeToEdgeUtils;
import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.base.presentation.utilities.ItemActionHandlerProvider;
import com.box.android.base.presentation.views.menu.PushNotificationSheetFragment;
import com.box.android.browse.activities.FilterSearchResultsActivity;
import com.box.android.browse.adapters.BoxRecentSearchAdapter;
import com.box.android.browse.cpl.browse.BrowseFragment;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.browse.cpl.browse.fab.UploadHelper;
import com.box.android.browse.cpl.helpers.FabHelper;
import com.box.android.browse.cpl.offlined.OfflinedFragment;
import com.box.android.browse.cpl.recents.RecentsFragment;
import com.box.android.browse.fragments.BoxBrowseFragment;
import com.box.android.browse.fragments.BoxSearchFragment;
import com.box.android.browse.fragments.SearchFragment;
import com.box.android.browse.models.BoxSearchFilters;
import com.box.android.browse.views.AppSearchView;
import com.box.android.clientadmin.BoxAdminSettingsProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.Connectivity;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.common.utilities.OSPermissionUtils;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.jobcollections.OfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.RemoveOfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.OfflineBoxJob;
import com.box.android.coreservices.jobmanager.jobs.RemoveOfflineBoxJob;
import com.box.android.coreservices.jobmanager.tasks.OfflinePreviewTask;
import com.box.android.coreservices.jobmanager.tasks.OfflineTask;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.IMoCoAdminSettings;
import com.box.android.coreservices.modelcontroller.messages.BoxAdminSettingsMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxFileTransferServiceMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxResponseMessage;
import com.box.android.coreservices.modelcontroller.messages.BoxSwitchUserMessage;
import com.box.android.coreservices.modelcontroller.messages.Controller;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.data.persistence.offline.OfflineMigrationService;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.controller.IBrowseController;
import com.box.android.domain.localrepo.IBoxStorage;
import com.box.android.domain.localrepo.sqlitetables.BoxRecentItemSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxSqlQueryManager;
import com.box.android.domain.mappers.FolderModelMapper;
import com.box.android.domain.offline.IOfflineStateStorage;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IOfflineFilesPolicyEnforcer;
import com.box.android.domain.usecases.jobs.JobTags;
import com.box.android.fragments.AutoUploadUtils;
import com.box.android.fragments.NavigationTabFragment;
import com.box.android.fragments.boxitem.PushNotificationsFragment;
import com.box.android.jobsui.helpers.TransfersHelper;
import com.box.android.navigation.Navigation;
import com.box.android.navigationmodernization.homescreen.helpers.FTUXMessageReceiverHelper;
import com.box.android.preview.previewtype.boxnote.BoxNotesWebviewAssetCache;
import com.box.android.updates.proposal.AppUpdateProposalManager;
import com.box.android.utilities.BoxFragmentToPreviewSourceMapper;
import com.box.androidsdk.content.BoxApiUser;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxExtendedApiPreview;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSearchItem;
import com.box.androidsdk.content.requests.BoxFilePreviewRequest;
import com.box.androidsdk.content.requests.BoxRequestBatch;
import com.box.androidsdk.content.requests.BoxRequestRecentItems;
import com.box.androidsdk.content.requests.BoxRequestsBookmark;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.views.BoxAvatarView;
import com.box.boxandroidlibv2private.dao.BoxAdminSettings;
import com.box.boxandroidlibv2private.dao.BoxFeatures;
import com.box.boxandroidlibv2private.model.BoxIteratorBoxRecentFiles;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.box.boxandroidlibv2private.model.BoxRecentBoxFile;
import com.box.boxandroidlibv2private.requests.BoxFileNotificationMute;
import com.box.boxandroidlibv2private.requests.BoxRequestCreateBoxNote;
import com.box.boxandroidlibv2private.requests.BoxRequestDeleteCollaboration;
import com.box.boxandroidlibv2private.requests.BoxRequestGetPushNotifications;
import com.box.boxandroidlibv2private.requests.BoxRequestLocalRecentItems;
import com.box.boxandroidlibv2private.requests.BoxRequestStorePushNotification;
import com.box.boxandroidlibv2private.requests.BoxRequestUploadFile;
import com.box.boxandroidlibv2private.requests.BoxRequestUploadNewVersionFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiRecentItems;
import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import java.lang.ref.WeakReference;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public abstract class MainParent extends BoxFragmentActivity implements BoxBrowseFragment.OnItemClickListener, ItemActionHandlerProvider, FragmentManager.OnBackStackChangedListener, SearchFragment.AppSearchListener, IMainParent {
    static HashSet<Integer> menuItemsNotRequiringNetwork;

    @Inject
    protected AppUpdateProposalManager appUpdateProposalManager;

    @Inject
    protected BoxAdminSettingsProvider boxAdminSettingsProvider;

    @Inject
    protected FTUXMessageReceiverHelper ftuxMessageReceiverHelper;

    @Inject
    protected ILocalItemService localItemService;

    @Inject
    protected IMoCoAdminSettings mAdminSettingsModelController;

    @Inject
    protected BoxExtendedApiPreview mApiPreviewPrivate;

    @Inject
    protected BoxApiUser mBoxApiUser;

    @Inject
    protected IBrowseController mBrowseController;
    protected FabHelper mFabHelper;

    @Inject
    protected FabHelper.Factory mFabHelperFactory;
    private FloatingActionMenu mFloatingMenu;
    protected FragmentManager mFragmentManager;

    @Inject
    protected IntentServices mIntentServices;
    protected IItemActionHandler mItemActionHandler;

    @Inject
    protected IItemActionHandler.Factory mItemActionHandlerFactory;

    @Inject
    protected JobManager mJobManager;

    @Inject
    protected IJobService mJobService;
    private JobsProgressViewModel mJobsProgressViewModel;
    protected boolean mNavigateOnResume;

    @Inject
    protected IOfflineFilesPolicyEnforcer mOfflineFilesPolicyEnforcer;

    @Inject
    OfflineMigrationService mOfflineMigrationService;

    @Inject
    IOfflineStateStorage mOfflineStateStorage;
    protected ArrayList<String> mRecentSearches;
    protected BoxRecentSearchAdapter mRecentSearchesAdapter;
    protected View mRecentSearchesFooter;
    protected View mRecentSearchesHeader;
    protected ListView mRecentSearchesListView;

    @Inject
    protected SearchFragment.SearchActionLogHelper mSearchActionLogHelper;
    protected AppSearchView mSearchView;
    protected Snackbar mSnackBar;

    @Inject
    protected TransfersHelper mTransfersHelper;

    @Inject
    protected UploadHelper mUploadHelper;
    private boolean shouldUpdateFilePreviews = false;
    private ActivityResultLauncher<Intent> storagePermissionLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback() { // from class: com.box.android.activities.MainParent$$ExternalSyntheticLambda3
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            this.f$0.lambda$new$0((ActivityResult) obj);
        }
    });
    private final BroadcastReceiver mActionBarFragmentReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.activities.MainParent.1
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            if (Objects.equals(intent.getAction(), BottomSheetMenuFragment.EXTRA_ACTION_BOX_MENU_ITEM_SET)) {
                intent.setExtrasClassLoader(getClass().getClassLoader());
                MainParent.this.handleMenuClick(intent.getIntExtra(BottomSheetMenuFragment.EXTRA_BOX_MENU_ITEM_ID, 0), (BottomSheetAttributes.BottomSheetMenuCompletionDialog) intent.getSerializableExtra(BottomSheetMenuFragment.EXTRA_BOX_MENU_ITEM_DIALOG_TYPE), (BoxItem) intent.getSerializableExtra(BottomSheetMenuFragment.EXTRA_BOX_ITEM));
            }
        }
    };
    private final BroadcastReceiver mFtuxReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.activities.MainParent.2
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            MainParent.this.ftuxMessageReceiverHelper.handleOnReceive(intent, MainParent.this);
        }
    };
    private BoxFutureTask<BoxAdminSettingsMessage> mAdminSettingsTask = null;
    private final AtomicBoolean mCleaningActivity = new AtomicBoolean(false);
    private final AtomicBoolean mShouldCleanActivity = new AtomicBoolean(false);
    private AtomicBoolean mFabShouldBeShowing = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: getCurrentlyVisibleFolder, reason: merged with bridge method [inline-methods] */
    public abstract BoxFolder lambda$showFabMenu$7();

    protected void launchSearchFolder(String str, BoxSearchFilters boxSearchFilters) {
    }

    protected Unit sendBrowseAction(BrowseReducer.Action action) {
        return null;
    }

    @Override // com.box.android.base.presentation.activities.Hilt_BoxFragmentActivity, androidx.activity.ComponentActivity, androidx.lifecycle.HasDefaultViewModelProviderFactory
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return super.getDefaultViewModelProviderFactory();
    }

    static {
        HashSet<Integer> hashSet = new HashSet<>();
        menuItemsNotRequiringNetwork = hashSet;
        hashSet.add(Integer.valueOf(R.id.menu_remove_offline));
        menuItemsNotRequiringNetwork.add(Integer.valueOf(R.id.folder_batch_remove_offline));
        menuItemsNotRequiringNetwork.add(Integer.valueOf(R.id.folder_sort));
        menuItemsNotRequiringNetwork.add(Integer.valueOf(R.id.sort_by_name));
        menuItemsNotRequiringNetwork.add(Integer.valueOf(R.id.sort_by_date));
        menuItemsNotRequiringNetwork.add(Integer.valueOf(R.id.sort_by_size));
        menuItemsNotRequiringNetwork.add(Integer.valueOf(R.id.folder_batch_deselect));
        menuItemsNotRequiringNetwork.add(Integer.valueOf(R.id.folder_batch_select));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ActivityResult activityResult) {
        if (OSPermissionUtils.INSTANCE.hasStoragePermission(true)) {
            displaySnackbar(R.string.Please_retry_operation_after_grant_permission, 0, (View.OnClickListener) null, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideKeyboard() {
        if (this.mSearchView != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchView.getWindowToken(), 0);
        }
    }

    @Override // com.box.android.base.presentation.utilities.ItemActionHandlerProvider
    public IItemActionHandler provideItemActionHandler() {
        return this.mItemActionHandler;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxCreate(Bundle bundle) {
        super.onBoxCreate(bundle);
        this.mItemActionHandler = this.mItemActionHandlerFactory.create(this);
        this.mFabHelper = this.mFabHelperFactory.create(this);
        this.mBaseMoco.performLocal(this.mBoxApiPrivate.getPushNotificationsRequest());
        this.mJobsProgressViewModel = (JobsProgressViewModel) new ViewModelProvider(this).get(JobsProgressViewModel.class);
        EdgeToEdgeUtils.INSTANCE.enableDarkEdgeToEdge(this);
        if (this.mFeatureFlips.getMigrateOfflineInfoToDb().getEnabled()) {
            BoxModelOfflineManager.setOfflineStorage(this.mOfflineStateStorage);
            this.mOfflineMigrationService.migrateToRoom();
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BottomSheetMenuFragment.EXTRA_ACTION_BOX_MENU_ITEM_SET);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.mActionBarFragmentReceiver, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction(BaseFTUX.EXTRA_ACTION_SHOW_FTUX);
        intentFilter2.addAction(BaseFTUX.EXTRA_ACTION_POSITIVE_CLICK);
        LocalBroadcastManager.getInstance(this).registerReceiver(this.mFtuxReceiver, intentFilter2);
        this.mItemActionHandler.registerItemActionHandler();
        if (this.mNavigateOnResume) {
            onBoxInitialize(null);
            this.mNavigateOnResume = false;
        } else {
            onScreenResume();
        }
        JobsProgressViewModel jobsProgressViewModel = this.mJobsProgressViewModel;
        if (jobsProgressViewModel != null) {
            jobsProgressViewModel.getStore().send(JobsProgressReducer.Action.Load.INSTANCE);
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxStart() {
        super.onBoxStart();
        this.shouldUpdateFilePreviews = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (iArr.length > 0 && iArr[0] == 0) {
            handlePermissionGranted();
        } else {
            handlePermissionDenied(i, strArr);
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    private void handlePermissionGranted() {
        dismissSnackbar();
        BoxPresentationUtils.displayToast(R.string.Please_retry_operation_after_grant_permission, this, new String[0]);
    }

    private void handlePermissionDenied(int i, String[] strArr) {
        boolean zShouldShowPermissionDialog = shouldShowPermissionDialog(strArr);
        if (i == 204) {
            if (zShouldShowPermissionDialog) {
                showPermissionDialog(R.string.Please_grant_permission_in_settings, true);
                return;
            } else {
                displaySnackbar(R.string.Upload_failed_please_grant_storage_permission, 0, (View.OnClickListener) null, -2);
                return;
            }
        }
        if (zShouldShowPermissionDialog) {
            showPermissionDialog(R.string.Please_grant_permission_in_settings, false);
        } else {
            displaySnackbar(R.string.Please_grant_permission_in_order_to_perform_this_operation, 0, (View.OnClickListener) null);
        }
    }

    private void showPermissionDialog(int i, final boolean z) {
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this);
        materialAlertDialogBuilder.setMessage(i);
        materialAlertDialogBuilder.setTitle(R.string.job_item_error_type_permission);
        materialAlertDialogBuilder.setPositiveButton(R.string.account_settings, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.MainParent$$ExternalSyntheticLambda7
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$showPermissionDialog$1(z, dialogInterface, i2);
            }
        });
        materialAlertDialogBuilder.setNegativeButton(R.string.dismiss, new DialogInterface.OnClickListener() { // from class: com.box.android.activities.MainParent.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showPermissionDialog$1(boolean z, DialogInterface dialogInterface, int i) {
        String str;
        Intent intent = new Intent();
        if (z) {
            str = "android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION";
        } else {
            str = "android.settings.APPLICATION_DETAILS_SETTINGS";
        }
        intent.setAction(str);
        intent.setData(Uri.fromParts("package", getPackageName(), null));
        if (z) {
            this.storagePermissionLauncher.launch(intent);
        } else {
            startActivity(intent);
        }
        dialogInterface.dismiss();
    }

    private boolean shouldShowPermissionDialog(String[] strArr) {
        if (strArr != null) {
            for (String str : strArr) {
                if (!shouldShowRequestPermissionRationale(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMPause() {
        super.onMAMPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mActionBarFragmentReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mFtuxReceiver);
        this.mItemActionHandler.unregisterItemActionHandler();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void processBoxMessage(BoxMessage<?> boxMessage) {
        super.processBoxMessage(boxMessage);
        if (boxMessage instanceof BoxAdminSettingsMessage) {
            onFetchedClientSettings((BoxAdminSettingsMessage) boxMessage);
            return;
        }
        if (boxMessage instanceof BoxResponseMessage) {
            BoxResponseMessage boxResponseMessage = (BoxResponseMessage) boxMessage;
            if (handlePendingOfflinePreviews(boxResponseMessage)) {
                return;
            }
            if (this.shouldUpdateFilePreviews && boxResponseMessage.wasSuccessful() && boxResponseMessage.isRemote()) {
                this.shouldUpdateFilePreviews = false;
                this.mBaseMoco.performLocal(new BoxRequestLocalRecentItems(this.mBoxSession, BoxExtendedApiRecentItems.FILTER.OFFLINE));
            }
        }
        updateAllFragmentsWithMessage(boxMessage);
    }

    private boolean handlePendingOfflinePreviews(BoxResponseMessage boxResponseMessage) {
        if (boxResponseMessage.getAction().equals(BoxRequestLocalRecentItems.class.getName())) {
            BoxRequestLocalRecentItems boxRequestLocalRecentItems = (BoxRequestLocalRecentItems) boxResponseMessage.getRequest();
            BoxIteratorBoxRecentFiles<BoxRecentBoxFile> boxIteratorBoxRecentFiles = (BoxIteratorBoxRecentFiles) boxResponseMessage.getResponse().getResult();
            if (boxIteratorBoxRecentFiles != null && boxRequestLocalRecentItems.getFilter() == BoxExtendedApiRecentItems.FILTER.OFFLINE) {
                BoxSqlQueryManager queryManager = this.mUserContextManager.getCurrentContext().getSQLHelper().getQueryManager();
                BoxRequestBatch boxRequestBatch = new BoxRequestBatch();
                for (BoxRecentBoxFile boxRecentBoxFile : boxIteratorBoxRecentFiles) {
                    BoxFilePreviewRequest boxFilePreviewRequest = (BoxFilePreviewRequest) this.mApiPreviewPrivate.getFilePreviewedRequest(boxRecentBoxFile.getUserId());
                    boxFilePreviewRequest.setPreviewTime(boxRecentBoxFile.getRecentItem().getInteractedAt());
                    boxFilePreviewRequest.setInteractionSharedLink(boxRecentBoxFile.getRecentItem().getInteractionSharedLink());
                    boxRequestBatch.addRequest(boxFilePreviewRequest);
                    BoxRecentItemSQLData boxRecentItemSQLData = new BoxRecentItemSQLData(boxRecentBoxFile.getRecentItem());
                    boxRecentItemSQLData.setOffline(false);
                    try {
                        queryManager.update(boxRecentItemSQLData);
                    } catch (SQLException e) {
                        BoxLogUtils.logException(getClass().getName(), e);
                    }
                }
                this.mBaseMoco.performRemote(boxRequestBatch);
                return true;
            }
        }
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxInitialize(Bundle bundle) {
        super.onBoxInitialize(bundle);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.mFragmentManager = supportFragmentManager;
        supportFragmentManager.addOnBackStackChangedListener(this);
        BoxNotesWebviewAssetCache.getInstance(this.mConfigManager).syncCachedFilesListIfNecessary(this.mUserContextManager);
        refreshUserSettingsIfNecessary(getClass().equals(Navigation.class));
        if (this.mGlobalSettings.isFirstTimeUser()) {
            this.mGlobalSettings.setFirstTimeUser(false);
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnActivityResult(int i, int i2, Intent intent) {
        super.handleOnActivityResult(i, i2, intent);
        if (i2 != -1) {
            handleNonOkResult();
            return;
        }
        if (this.mItemActionHandler.handleActivityResult(i, i2, intent)) {
            return;
        }
        if (i == 115) {
            handleSearchFilters(intent);
        } else if (i == 304) {
            doUpload(intent, JobTags.JobSource.FAB_FILE);
        } else {
            if (i != 307) {
                return;
            }
            doUpload(intent, JobTags.JobSource.FAB_FOLDER);
        }
    }

    private void handleNonOkResult() {
        UploadAnalyticsUtils.logUploadFlowCancelCtaEvent("os");
    }

    private void handleSearchFilters(Intent intent) {
        BoxSearchFilters boxSearchFilters = (BoxSearchFilters) intent.getSerializableExtra(BoxSearchFragment.EXTRA_SEARCH_FILTERS);
        Fragment fragment = (Fragment) getCurrentVisibleFragment();
        if (fragment instanceof SearchFragment) {
            ((SearchFragment) fragment).applyFilters(boxSearchFilters);
            AppSearchView appSearchView = this.mSearchView;
            if (appSearchView != null) {
                appSearchView.setFilteringIcon(boxSearchFilters);
                return;
            }
            return;
        }
        launchSearchFolder("", boxSearchFilters);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void launchFilterSearchResultsActivity() {
        startActivityForResult(FilterSearchResultsActivity.newFilterSearchResultsIntent(this, getCurrentVisibleFragment() instanceof SearchFragment ? ((SearchFragment) getCurrentVisibleFragment()).getSearchFilters() : null), 115);
    }

    public void doUpload(Intent intent, JobTags.JobSource jobSource) {
        BoxFolder boxFolderLambda$showFabMenu$7 = lambda$showFabMenu$7();
        if (intent == null || boxFolderLambda$showFabMenu$7 == null) {
            return;
        }
        this.mUploadHelper.doUpload(FolderModelMapper.INSTANCE.toFolderModel(boxFolderLambda$showFabMenu$7, true), intent, jobSource, this);
    }

    private void refreshUserSettingsIfNecessary() {
        refreshUserSettingsIfNecessary(false);
    }

    private void refreshUserSettingsIfNecessary(boolean z) {
        boolean z2 = this.mUserContextManager.getUserInfo() == null || this.boxAdminSettingsProvider.shouldUpdateAdminSettings();
        BoxFutureTask<BoxAdminSettingsMessage> boxFutureTask = this.mAdminSettingsTask;
        if (boxFutureTask == null || boxFutureTask.isDone() || this.mAdminSettingsTask.isCancelled()) {
            if (z) {
                BoxAccountManager.migrateAdminSettings(getUserSharedPrefs());
                this.mAdminSettingsTask = this.mAdminSettingsModelController.getAdminSettingsRemote();
            } else {
                this.mAdminSettingsTask = this.mAdminSettingsModelController.getAdminSettingsIfNeeded();
            }
            if (z2 || z) {
                this.mBaseMoco.performRemote(this.mBoxApiUser.getUserInfoRequest(this.mUserContextManager.getCurrentContextId()).setFields(BoxAuthentication.MINIMUM_USER_FIELDS));
                this.mBaseMoco.performRemote(this.mBoxApiPrivate.getFeaturesRequest()).addOnCompletedListener(new BoxAppFutureTask.OnCompletedListener<BoxFeatures>() { // from class: com.box.android.activities.MainParent.4
                    @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
                    public void onCompleted(BoxResponse<BoxFeatures> boxResponse) {
                        if (boxResponse.isSuccess()) {
                            AutoUploadUtils.setAutoContentUploadFeatureAvailable(((BoxFeatures) boxResponse.getResult()).hasAutoContentUpload(), MainParent.this.mUserContextManager);
                        }
                    }
                });
            }
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnNewIntent(Intent intent) {
        setIntent(intent);
        if (isDifferentUserAccessed()) {
            onDifferentUserAccessed();
        } else {
            this.mNavigateOnResume = true;
        }
    }

    protected void cleanActivity() {
        this.mCleaningActivity.set(true);
        this.mAdminSettingsTask = null;
        try {
            executePendingFragmentTransactions();
            while (getSupportFragmentManager().popBackStackImmediate()) {
            }
            onCleanedCompleted();
        } catch (Exception e) {
            BoxLogUtils.logException(e);
        }
        this.mCleaningActivity.set(false);
    }

    protected void setShouldCleanActivity(boolean z) {
        this.mShouldCleanActivity.set(z);
    }

    protected void onCleanedCompleted() {
        setShouldCleanActivity(false);
        if (!isDifferentUserAccessed() || this.mUserContextManager.isSwitchingToNewUser()) {
            return;
        }
        setActivityUserId(this.mUserContextManager.getCurrentContextId());
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.activities.MainParent$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onCleanedCompleted$2();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCleanedCompleted$2() {
        try {
            getIntent().putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, "0");
            if (hasAuthentication()) {
                onBoxInitialize(null);
                onBoxResume();
                setupFab();
                return;
            }
            finish();
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean onDifferentUserAccessed() {
        setShouldCleanActivity(true);
        cleanActivity();
        return true;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onSwitchedUser(BoxSwitchUserMessage boxSwitchUserMessage) {
        if (StringUtils.isEmpty(boxSwitchUserMessage.getSwitchToUserId())) {
            startActivity(AuthenticationActivity.INSTANCE.createSwitchUserIntent(this));
            finish();
        } else {
            super.onSwitchedUser(boxSwitchUserMessage);
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public IntentFilter getIntentFilter() {
        IntentFilter intentFilter = super.getIntentFilter();
        intentFilter.addAction(Controller.ACTION_DELETED_ITEMS);
        intentFilter.addAction(Controller.ACTION_REMOVED_OFFLINE_ITEMS);
        intentFilter.addAction(Controller.ACTION_SEARCHED);
        intentFilter.addAction(Controller.ACTION_DELETED_COLLABORATION_SELF);
        intentFilter.addAction(Controller.ACTION_FETCHED_EVENTS_RECENTS);
        intentFilter.addAction(Controller.ACTION_FETCHED_RECENTS);
        intentFilter.addAction(Controller.ACTION_FETCHED_EVENT_UPDATES);
        intentFilter.addAction(Controller.ACTION_SORT_PREFERENCES_CHANGED);
        intentFilter.addAction(Controller.ACTION_FETCHED_OFFLINE_FOLDER_ITEMS);
        intentFilter.addAction(BoxAdminSettingsMessage.ACTION_FETCHED_CLIENT_SETTINGS);
        intentFilter.addAction(BoxFileTransferServiceMessage.ACTION_QUEUE_CHANGED);
        intentFilter.addAction(Controller.ACTION_MADE_FILE_AVAILABLE_OFFLINE);
        intentFilter.addAction(OfflineBoxJobCollection.class.getName());
        intentFilter.addAction(OfflineBoxJob.class.getName());
        intentFilter.addAction(OfflineTask.class.getName());
        intentFilter.addAction(OfflinePreviewTask.class.getName());
        intentFilter.addAction(RemoveOfflineBoxJobCollection.class.getName());
        intentFilter.addAction(RemoveOfflineBoxJob.class.getName());
        intentFilter.addAction(BoxRequestsFile.GetFileInfo.class.getName());
        intentFilter.addAction(BoxRequestsBookmark.GetBookmarkInfo.class.getName());
        intentFilter.addAction(BoxRequestsFolder.GetFolderInfo.class.getName());
        intentFilter.addAction(BoxRequestsFolder.GetFolderWithAllItems.class.getName());
        intentFilter.addAction(BoxRequestsSearch.Search.class.getName());
        intentFilter.addAction(BoxRequestsFolder.GetCollaborations.class.getName());
        intentFilter.addAction(BoxRequestsFolder.CopyFolder.class.getName());
        intentFilter.addAction(BoxRequestsFolder.UpdateFolder.class.getName());
        intentFilter.addAction(BoxRequestsFolder.DeleteFolder.class.getName());
        intentFilter.addAction(BoxRequestsFile.UploadFile.class.getName());
        intentFilter.addAction(BoxRequestsFile.CopyFile.class.getName());
        intentFilter.addAction(BoxRequestsFile.DeleteFile.class.getName());
        intentFilter.addAction(BoxRequestsFile.UpdateFile.class.getName());
        intentFilter.addAction(BoxRequestsBookmark.UpdateBookmark.class.getName());
        intentFilter.addAction(BoxRequestsBookmark.DeleteBookmark.class.getName());
        intentFilter.addAction(BoxRequestsBookmark.CopyBookmark.class.getName());
        intentFilter.addAction(BoxRequestUploadFile.class.getName());
        intentFilter.addAction(BoxRequestsFile.CommitUploadSession.class.getName());
        intentFilter.addAction(BoxRequestUploadNewVersionFile.class.getName());
        intentFilter.addAction(BoxRequestCreateBoxNote.class.getName());
        intentFilter.addAction(BoxRequestsFolder.CreateFolder.class.getName());
        intentFilter.addAction(BoxFilePreviewRequest.class.getName());
        intentFilter.addAction(BoxRequestRecentItems.GetRecentItems.class.getName());
        intentFilter.addAction(BoxRequestLocalRecentItems.class.getName());
        intentFilter.addAction(BoxRequestDeleteCollaboration.class.getName());
        intentFilter.addAction(BoxRequestGetPushNotifications.class.getName());
        intentFilter.addAction(BoxRequestStorePushNotification.class.getName());
        intentFilter.addAction(BoxFileNotificationMute.RemoveFileMute.class.getName());
        return intentFilter;
    }

    public void onFetchedClientSettings(BoxAdminSettingsMessage boxAdminSettingsMessage) {
        if (boxAdminSettingsMessage.wasSuccessful()) {
            BoxAdminSettings payload = boxAdminSettingsMessage.getPayload();
            BoxAccountManager.updateAllowSaveForOfflineSetting(this.mNotificationServices, payload, this.mUserContextManager, this.mJobManager, this.mJobService);
            BoxAccountManager.updateRequiredMinimumVersionSetting(payload, getUserSharedPrefs());
            BoxAccountManager.updateRequiresPasscodeLockSetting(payload, getUserSharedPrefs());
            BoxAccountManager.updateSimpleBooleanMobileSettings(payload, this.mUserContextManager);
            enforceOfflineFilesPolicy(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO());
            if (this instanceof Navigation) {
                ((Navigation) this).refreshNavigationBarHubsButtonVisibility();
            }
        }
        if (showIntuneAuth()) {
            return;
        }
        if (BoxAccountManager.isPasscodeAdminRequired(getUserSharedPrefs()) && !CreatePincodeActivity.userHasSetPincode(this.mUserContextManager)) {
            CreatePincodeActivity.startActivity(CommonBoxUtil.LS(R.string.Your_administrator_has_required_a_passcode_be_set));
        }
        BoxAccountManager.checkMinimumVersion(this.mNotificationServices, this.mIntentServices, 1, getUserSharedPrefs());
    }

    void enforceOfflineFilesPolicy(CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher) {
        BuildersKt.launch(coroutineScope, coroutineDispatcher, CoroutineStart.DEFAULT, new Function2() { // from class: com.box.android.activities.MainParent$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return this.f$0.lambda$enforceOfflineFilesPolicy$3((CoroutineScope) obj, (Continuation) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$enforceOfflineFilesPolicy$3(CoroutineScope coroutineScope, final Continuation continuation) {
        try {
            return this.mOfflineFilesPolicyEnforcer.enforce(new Continuation<Unit>() { // from class: com.box.android.activities.MainParent.5
                @Override // kotlin.coroutines.Continuation
                /* JADX INFO: renamed from: getContext */
                public CoroutineContext get$context() {
                    return continuation.get$context();
                }

                @Override // kotlin.coroutines.Continuation
                public void resumeWith(Object obj) {
                    continuation.resumeWith(obj);
                }
            });
        } catch (Exception e) {
            BoxLogUtils.e("MainParent", "Error enforcing offline files policy", e);
            return Unit.INSTANCE;
        }
    }

    public void updateAllFragmentsWithMessage(BoxMessage<?> boxMessage) {
        boolean z = false;
        int i = 0;
        for (ActivityResultCaller activityResultCaller : getSupportFragmentManager().getFragments()) {
            if (activityResultCaller instanceof BoxFragmentInterface) {
                BoxFragmentInterface boxFragmentInterface = (BoxFragmentInterface) activityResultCaller;
                if (boxFragmentInterface.shouldUpdateFragment(boxMessage)) {
                    boxFragmentInterface.updateFragment(boxMessage);
                }
                z = true;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        BoxLogUtils.i("MainParent.updateAllFragmentsWithMessage", "non BoxFragmentInterface " + i);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        if (i == 108 && menu != null) {
            BoxAmplitudeAnalytics.sendAnalyticsEventForOptions(BoxAnalyticsParams.PAGE_NAME_OVERFLOW_MENU, BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP);
        }
        return super.onMenuOpened(i, menu);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public boolean onMAMPrepareOptionsMenu(Menu menu) {
        View actionView;
        View actionView2;
        final MenuItem menuItemFindItem = menu.findItem(R.id.account_settings_menu_item);
        if (!this.mUserContextManager.hasValidUserId()) {
            BoxLogUtils.e("MainParent.onPrepareOptionsMenu", "Attempting to prepare options menu without a valid user id");
        }
        IBoxStorage previewStorage = this.mUserContextManager.getPreviewStorage();
        if (menuItemFindItem != null && previewStorage != null && (actionView2 = menuItemFindItem.getActionView()) != null) {
            actionView2.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.MainParent.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    MainParent.this.onOptionsItemSelected(menuItemFindItem);
                }
            });
            ((BoxAvatarView) actionView2.findViewById(R.id.avatar_view)).loadUser(this.mUserContextManager.getUserInfo(), previewStorage.getAvatarController());
        }
        final MenuItem menuItemFindItem2 = menu.findItem(R.id.transfers_menu_item);
        if (menuItemFindItem2 != null && (actionView = menuItemFindItem2.getActionView()) != null) {
            actionView.setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.MainParent$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.lambda$onPrepareOptionsMenu$4(menuItemFindItem2, view);
                }
            });
            this.mTransfersHelper.register(this.mJobsProgressViewModel, actionView);
        }
        return super.onMAMPrepareOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onPrepareOptionsMenu$4(MenuItem menuItem, View view) {
        onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.account_settings_menu_item) {
            startActivity(SettingsActivity.getStartIntent(this));
            BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP).setCtaTarget(BoxAnalyticsParams.PAGE_NAME_SETTINGS).logEvent(BoxAnalyticsParams.EVENT_SETTINGS_CLICKED);
            return true;
        }
        if (menuItem.getItemId() == R.id.transfers_menu_item) {
            Intent intent = new Intent(BoxBaseApplication.getInstance(), (Class<?>) MainPhone.class);
            intent.setFlags(805306368);
            intent.putExtra(IntentConstants.EXTRA_INIT_NAV_DRAWER_ITEM_ID, 10);
            startActivity(intent);
            BoxAmplitudeAnalytics.createEventBuilder().setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION).setCtaPageLocation(BoxAnalyticsParams.CTA_PAGE_LOCATION_TOP).setCtaTarget(BoxAnalyticsParams.PAGE_NAME_TRANSFERS).logEvent(BoxAnalyticsParams.EVENT_TRANSFER_CLICKED);
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void navigateToAllFiles() {
        navigateToTarget(IntentServices.NavigationIntentTarget.ALL_FILES);
    }

    public void onMyCollectionsTabClick() {
        navigateToTarget(IntentServices.NavigationIntentTarget.COLLECTIONS);
    }

    private void navigateToTarget(IntentServices.NavigationIntentTarget navigationIntentTarget) {
        boolean enabled = this.mFeatureFlips.getMainScreenRedesign().getEnabled();
        Intent intentNavigationActivityIntent = this.mIntentServices.navigationActivityIntent(this, enabled, navigationIntentTarget);
        if (enabled) {
            intentNavigationActivityIntent.setFlags(268468224);
            finish();
            startActivity(intentNavigationActivityIntent);
        } else {
            startActivity(intentNavigationActivityIntent);
            finish();
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxSpinnerDialogFragmentActivity
    public boolean amplitudeSetCurrentPage() {
        BoxAmplitudeAnalytics.EventPropertyBuilder eventPropertyBuilderCreateEventBuilder = BoxAmplitudeAnalytics.createEventBuilder();
        BottomSheetMenuFragment bottomSheetFragmentIfShowing = getBottomSheetFragmentIfShowing();
        if (bottomSheetFragmentIfShowing != null) {
            amplitudeSetCurrentPageAndLog(eventPropertyBuilderCreateEventBuilder.setFlow(bottomSheetFragmentIfShowing.getAmplitudeFlow()), bottomSheetFragmentIfShowing.getAmplitudePageName());
            return true;
        }
        if (!isFabShowing()) {
            return false;
        }
        amplitudeSetCurrentPageAndLog(eventPropertyBuilderCreateEventBuilder.setFlow(BoxAnalyticsParams.FLOW_UPLOAD), BoxAnalyticsParams.PAGE_NAME_FAB);
        return true;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public void showBottomSheet(BoxItem boxItem) {
        showBottomSheet(boxItem, BottomSheetAttributes.BottomSheetMenuType.AddRemoveCollectionItems.INSTANCE);
    }

    public void showBottomSheet(BoxItem boxItem, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType) {
        if (isFinishing()) {
            return;
        }
        DialogInterface.OnShowListener onShowListener = new DialogInterface.OnShowListener() { // from class: com.box.android.activities.MainParent$$ExternalSyntheticLambda11
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                this.f$0.lambda$showBottomSheet$5(dialogInterface);
            }
        };
        if (boxItem instanceof BoxPushNotification) {
            BoxAmplitudeAnalytics.sendAnalyticsEventForOptions(BoxAnalyticsParams.PAGE_NAME_MORE_OPTIONS_PUSH_NOTIFICATION, BoxAnalyticsParams.CTA_PAGE_LOCATION_LIST_ITEM);
            PushNotificationSheetFragment.newInstance(this, (BoxPushNotification) boxItem).setOnShowListener(onShowListener).show(getSupportFragmentManager(), BottomSheetMenuFragment.TAG);
        } else {
            this.mItemActionHandler.showBottomSheet(boxItem, bottomSheetMenuType, determineLaunchContext(), onShowListener, Collections.EMPTY_LIST);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBottomSheet$5(DialogInterface dialogInterface) {
        amplitudeSetCurrentPage();
    }

    private BottomSheetAttributes.LaunchContext determineLaunchContext() {
        BoxFragmentInterface currentVisibleFragment = getCurrentVisibleFragment();
        if (currentVisibleFragment instanceof NavigationTabFragment) {
            BoxFragmentInterface currentFragment = ((NavigationTabFragment) currentVisibleFragment).getCurrentFragment();
            if (currentFragment instanceof RecentsFragment) {
                return BottomSheetAttributes.LaunchContext.BrowseRecents.INSTANCE;
            }
            if (currentFragment instanceof OfflinedFragment) {
                return BottomSheetAttributes.LaunchContext.BrowseOfflined.INSTANCE;
            }
            return BottomSheetAttributes.LaunchContext.BrowseAllFiles.INSTANCE;
        }
        return BottomSheetAttributes.LaunchContext.Default.INSTANCE;
    }

    public BottomSheetMenuFragment getBottomSheetFragmentIfShowing() {
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag(BottomSheetMenuFragment.TAG);
        if (!(fragmentFindFragmentByTag instanceof BottomSheetMenuFragment)) {
            return null;
        }
        BottomSheetMenuFragment bottomSheetMenuFragment = (BottomSheetMenuFragment) fragmentFindFragmentByTag;
        if (bottomSheetMenuFragment.getDialog() == null || !bottomSheetMenuFragment.getDialog().isShowing()) {
            return null;
        }
        return bottomSheetMenuFragment;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public FloatingActionMenu getFabMenu() {
        return (FloatingActionMenu) findViewById(R.id.fab_menu);
    }

    public RelativeLayout getFabMenuContainer() {
        return (RelativeLayout) findViewById(R.id.fab_menu_container);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public synchronized void toggleFab(boolean z) {
        toggleFab(z, true);
    }

    private synchronized void toggleFab(boolean z, final boolean z2) {
        boolean z3 = this.mFabShouldBeShowing.getAndSet(z) != z;
        this.mFloatingMenu = getFabMenu();
        if (z || z3) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.box.android.activities.MainParent$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$toggleFab$6(z2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: updateFabVisibility, reason: merged with bridge method [inline-methods] */
    public void lambda$toggleFab$6(boolean z) {
        if (this.mFloatingMenu == null) {
            return;
        }
        if (this.mFabShouldBeShowing.get()) {
            showFabMenu(z);
        } else {
            hideFabMenu(z);
        }
    }

    private void showFabMenu(boolean z) {
        BoxFragmentInterface currentVisibleFragment = getCurrentVisibleFragment();
        if (currentVisibleFragment != null && (currentVisibleFragment instanceof BrowseFragment)) {
            this.mFabHelper.initializeFab(getFabMenu(), getFabMenuContainer(), new Function0() { // from class: com.box.android.activities.MainParent$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return this.f$0.lambda$showFabMenu$7();
                }
            }, new Function1() { // from class: com.box.android.activities.MainParent$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return this.f$0.sendBrowseAction((BrowseReducer.Action) obj);
                }
            });
            this.mFloatingMenu.setVisibility(0);
            this.mFloatingMenu.showMenuButton(z);
            this.mFloatingMenu.setClickable(true);
        }
    }

    private void hideFabMenu(boolean z) {
        this.mFloatingMenu.setClickable(false);
        this.mFloatingMenu.hideMenuButton(z);
    }

    protected boolean isFabShowing() {
        FloatingActionMenu floatingActionMenu = this.mFloatingMenu;
        return floatingActionMenu != null && floatingActionMenu.isOpened();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002f  */
    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity, com.box.android.base.presentation.fragments.IMainParent
    public synchronized void setupFab() {
        boolean zShouldFabBeVisible;
        BoxFragmentInterface currentVisibleFragment;
        if (getCurrentVisibleFragment() == null) {
            zShouldFabBeVisible = false;
        } else {
            if (getCurrentVisibleFragment() instanceof NavigationTabFragment) {
                currentVisibleFragment = ((NavigationTabFragment) getCurrentVisibleFragment()).getCurrentFragment();
            } else {
                currentVisibleFragment = getCurrentVisibleFragment() instanceof BoxFragmentInterface ? getCurrentVisibleFragment() : null;
            }
            if (currentVisibleFragment != null) {
                zShouldFabBeVisible = shouldFabBeVisible(currentVisibleFragment);
            } else {
                zShouldFabBeVisible = false;
            }
        }
        toggleFab(zShouldFabBeVisible);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FloatingActionButton getAddFab() {
        return (FloatingActionButton) findViewById(R.id.add_fab);
    }

    private View getAddFabContainer() {
        return findViewById(R.id.add_fab_container);
    }

    private void showAddFab() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.box.android.activities.MainParent$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$showAddFab$8();
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAddFab$8() {
        getAddFabContainer().setVisibility(0);
    }

    private void hideAddFab() {
        getAddFabContainer().setVisibility(8);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public void setupAddFab() {
        BoxFragmentInterface currentVisibleFragment = getCurrentVisibleFragment();
        if ((currentVisibleFragment instanceof AddFabHelper) && ((AddFabHelper) currentVisibleFragment).isAddFabAvailable()) {
            showAddFab();
        } else {
            hideAddFab();
        }
    }

    public void setupAddFabListener() {
        getAddFab().setOnClickListener(new View.OnClickListener() { // from class: com.box.android.activities.MainParent$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.lambda$setupAddFabListener$9(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupAddFabListener$9(View view) {
        BoxFragmentInterface currentVisibleFragment = getCurrentVisibleFragment();
        if (currentVisibleFragment instanceof AddFabHelper) {
            ((AddFabHelper) currentVisibleFragment).onAddFabClicked();
        }
    }

    protected boolean isSearchExpanded() {
        AppSearchView appSearchView = this.mSearchView;
        return appSearchView != null && appSearchView.isExpanded();
    }

    protected boolean shouldFabBeVisible(BoxFragmentInterface boxFragmentInterface) {
        if (boxFragmentInterface == null) {
            return false;
        }
        return boxFragmentInterface.isFloatingMenuAvailable();
    }

    protected void updateFabMargin() {
        new Handler().post(new Runnable() { // from class: com.box.android.activities.MainParent.7
            @Override // java.lang.Runnable
            public void run() {
                if (MainParent.this.mFloatingMenu != null) {
                    ViewGroup.LayoutParams layoutParams = MainParent.this.mFloatingMenu.getLayoutParams();
                    if (layoutParams instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
                        layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, MainParent.this.getFabBottomMargin());
                        MainParent.this.mFloatingMenu.setLayoutParams(layoutParams2);
                    }
                }
                FloatingActionButton addFab = MainParent.this.getAddFab();
                if (addFab != null) {
                    ViewGroup.LayoutParams layoutParams3 = addFab.getLayoutParams();
                    if (layoutParams3 instanceof RelativeLayout.LayoutParams) {
                        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) layoutParams3;
                        layoutParams4.setMargins(layoutParams4.leftMargin, layoutParams4.topMargin, layoutParams4.rightMargin, MainParent.this.getFabBottomMargin());
                        addFab.setLayoutParams(layoutParams4);
                    }
                }
            }
        });
    }

    protected int getFabBottomMargin() {
        Snackbar snackbar = this.mSnackBar;
        if (snackbar == null || snackbar.getView() == null || !this.mSnackBar.isShownOrQueued()) {
            return 0;
        }
        return this.mSnackBar.getView().getHeight();
    }

    protected void executePendingFragmentTransactions() {
        runOnUiThread(new Runnable() { // from class: com.box.android.activities.MainParent.8
            @Override // java.lang.Runnable
            public void run() {
                FragmentManager supportFragmentManager = MainParent.this.getSupportFragmentManager();
                if (supportFragmentManager != null) {
                    try {
                        supportFragmentManager.executePendingTransactions();
                    } catch (Exception e) {
                        BoxLogUtils.logException(e);
                    }
                }
            }
        });
    }

    @Override // com.box.android.base.presentation.fragments.IMainParent
    public BoxFragmentInterface getCurrentVisibleFragment() {
        ActivityResultCaller activityResultCallerFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.filesfragmentembedded1);
        if (activityResultCallerFindFragmentById instanceof BoxFragmentInterface) {
            return (BoxFragmentInterface) activityResultCallerFindFragmentById;
        }
        return null;
    }

    public void onScreenResume() {
        logAmplitudeCurrentPage();
    }

    @Override // androidx.fragment.app.FragmentManager.OnBackStackChangedListener
    public void onBackStackChanged() {
        logAmplitudeCurrentPage();
    }

    private void logAmplitudeCurrentPage() {
        if (getCurrentVisibleFragment() != null) {
            amplitudeSetCurrentPage();
        }
    }

    @Override // com.box.android.browse.fragments.BoxBrowseFragment.OnItemClickListener
    public void onItemClick(BoxItem boxItem) {
        if (getCurrentVisibleFragment() instanceof SearchFragment) {
            this.mBrowseController.addToRecentSearches(this, this.mUserContextManager.getUserInfo(), ((SearchFragment) getCurrentVisibleFragment()).getSearchQuery());
        }
        refreshUserSettingsIfNecessary();
        if (boxItem instanceof BoxPushNotification) {
            startActivity(NotificationInterceptorActivity.getNotificationClickIntent((BoxPushNotification) boxItem));
            return;
        }
        boolean z = boxItem instanceof BoxSearchItem;
        if (z || (boxItem instanceof BoxFile) || (boxItem instanceof BoxBookmark)) {
            if (z) {
                BoxSearchItem boxSearchItem = (BoxSearchItem) boxItem;
                if (boxSearchItem.getItem() instanceof BoxFolder) {
                    navigateToFolder((BoxFolder) boxSearchItem.getItem());
                    return;
                }
            }
            this.mItemActionHandler.onItemClick(boxItem, true, null, BoxFragmentToPreviewSourceMapper.INSTANCE.map(getCurrentVisibleFragment()));
        }
    }

    public void navigateToFolder(BoxFolder boxFolder) {
        this.mItemActionHandler.onItemClick(boxFolder, true, null, null);
    }

    public void checkFileExistsAndLaunch(BoxFile boxFile, final Runnable runnable) {
        final WeakReference weakReference = new WeakReference(this);
        showSpinner();
        this.mBaseMoco.performRemote(this.mBoxExtendedApiFile.getInfoRequest(boxFile.getUserId())).addOnCompletedListener(new BoxAppFutureTask.OnCompletedListener<BoxFile>() { // from class: com.box.android.activities.MainParent.9
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse<BoxFile> boxResponse) {
                MainParent mainParent = (MainParent) weakReference.get();
                if (mainParent != null) {
                    mainParent.dismissSpinnerSynchronous();
                    if (boxResponse.isSuccess() && !SdkUtils.isBlank(((BoxFile) boxResponse.getResult()).getName())) {
                        mainParent.onItemClick((BoxItem) boxResponse.getResult());
                    } else if ((boxResponse.getException() instanceof BoxException) && ((BoxException) boxResponse.getException()).getErrorType() == BoxException.ErrorType.NETWORK_ERROR) {
                        BoxPresentationUtils.displayToast(R.string.box_browsesdk_network_error, MainParent.this, new String[0]);
                    } else {
                        mainParent.runOnUiThread(runnable);
                    }
                }
            }
        });
    }

    protected void setupRecentSearch() {
        this.mRecentSearchesHeader = getLayoutInflater().inflate(R.layout.box_browsesdk_recent_searches_header, (ViewGroup) null);
        this.mRecentSearchesFooter = getLayoutInflater().inflate(R.layout.box_browsesdk_recent_searches_footer, (ViewGroup) null);
        ListView listView = (ListView) findViewById(R.id.recentSearchesListView);
        this.mRecentSearchesListView = listView;
        listView.addHeaderView(this.mRecentSearchesHeader, null, false);
        this.mRecentSearchesListView.addFooterView(this.mRecentSearchesFooter, null, false);
        this.mRecentSearchesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.box.android.activities.MainParent.10
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String item = MainParent.this.mRecentSearchesAdapter.getItem(i - MainParent.this.mRecentSearchesListView.getHeaderViewsCount());
                MainParent.this.mSearchActionLogHelper.setRecentClicked(item);
                MainParent.this.mSearchView.setSearchTerm(item);
            }
        });
        this.mRecentSearchesListView.setVisibility(8);
    }

    @Override // com.box.android.browse.fragments.SearchFragment.AppSearchListener
    public void loadRecentSearch() {
        this.mRecentSearches = this.mBrowseController.getRecentSearches(this, this.mUserContextManager.getUserInfo());
        BoxRecentSearchAdapter boxRecentSearchAdapter = new BoxRecentSearchAdapter(this, this.mRecentSearches, new BoxRecentSearchAdapter.BoxRecentSearchListener() { // from class: com.box.android.activities.MainParent.11
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.box.android.browse.adapters.BoxRecentSearchAdapter.BoxRecentSearchListener
            public void onCloseClicked(int i) {
                MainParent.this.mRecentSearches.clear();
                ArrayList<String> arrayList = MainParent.this.mRecentSearches;
                IBrowseController iBrowseController = MainParent.this.mBrowseController;
                MainParent mainParent = MainParent.this;
                arrayList.addAll(iBrowseController.deleteFromRecentSearches(mainParent, mainParent.mUserContextManager.getBoxSession(MainParent.this).getUser(), i));
                MainParent.this.mRecentSearchesAdapter.notifyDataSetChanged();
                if (MainParent.this.mRecentSearches.size() == 0) {
                    MainParent.this.mRecentSearchesHeader.setVisibility(8);
                    MainParent.this.mRecentSearchesFooter.setVisibility(8);
                }
            }
        });
        this.mRecentSearchesAdapter = boxRecentSearchAdapter;
        this.mRecentSearchesListView.setAdapter((ListAdapter) boxRecentSearchAdapter);
        if (this.mRecentSearches.size() > 0) {
            this.mRecentSearchesListView.setVisibility(0);
        } else {
            this.mRecentSearchesListView.setVisibility(8);
        }
    }

    protected void handleMenuClick(int i, BottomSheetAttributes.BottomSheetMenuCompletionDialog bottomSheetMenuCompletionDialog, BoxItem boxItem) {
        if (i == 0 || menuItemHasConnectivityProblemCheckAndAlert(i)) {
            return;
        }
        if (i == R.id.android_provider) {
            handleAndroidProvider();
            return;
        }
        if (i == R.id.android_folder_provider) {
            handleAndroidFolderProvider();
            return;
        }
        if (i == R.id.unmute_menu) {
            handleUnmuteMenu(boxItem);
            return;
        }
        if (i == R.id.menu_notification_collaborations) {
            handleNotificationCollaborations();
            return;
        }
        if (i == R.id.menu_notification_comments) {
            handleNotificationComments();
        } else if (i == R.id.menu_notification_updates) {
            handleNotificationUpdates();
        } else if (i == R.id.menu_notification_show_all) {
            handleNotificationShowAll();
        }
    }

    private void handleAndroidProvider() {
        try {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", new String[]{"*/*"});
            startActivityForResult(intent, 304);
        } catch (Exception e) {
            BoxLogUtils.logException(getClass().getName(), e);
        }
    }

    private void handleAndroidFolderProvider() {
        try {
            startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), 307);
        } catch (Exception e) {
            BoxLogUtils.logException(getClass().getName(), e);
        }
    }

    private void handleUnmuteMenu(BoxItem boxItem) {
        BoxPushNotification boxPushNotification = (BoxPushNotification) boxItem;
        this.mBaseMoco.performLocal(this.mBoxExtendedApiFile.removeMuteNotificationCategory(boxPushNotification.getTargetResourceId(), boxPushNotification.getNotifType().getMuteCollectionType()));
        BoxAnalytics.INSTANCE.trackEvent(BoxAnalyticsParams.CATEGORY_PUSH_NOTIFICATIONS, BoxAnalyticsParams.ACTION_NOTIFICATION_UNBLOCKED, boxPushNotification.getNotifType().name());
    }

    private void handleNotificationCollaborations() {
        BoxFragmentInterface currentVisibleFragment = getCurrentVisibleFragment();
        if (currentVisibleFragment instanceof PushNotificationsFragment) {
            ((PushNotificationsFragment) currentVisibleFragment).setEventFilterType(BoxPushNotification.PushNotifType.COLLAB_INVITE_COLLABORATOR.name());
        }
    }

    private void handleNotificationComments() {
        BoxFragmentInterface currentVisibleFragment = getCurrentVisibleFragment();
        if (currentVisibleFragment instanceof PushNotificationsFragment) {
            ((PushNotificationsFragment) currentVisibleFragment).setEventFilterType(BoxPushNotification.PushNotifType.COMMENT_CREATE.name());
        }
    }

    private void handleNotificationUpdates() {
        BoxFragmentInterface currentVisibleFragment = getCurrentVisibleFragment();
        if (currentVisibleFragment instanceof PushNotificationsFragment) {
            ((PushNotificationsFragment) currentVisibleFragment).setEventFilterType(BoxRequestGetPushNotifications.EVENT_TYPE_UPLOADS_AND_ITEM_MODIFIED);
        }
    }

    private void handleNotificationShowAll() {
        BoxFragmentInterface currentVisibleFragment = getCurrentVisibleFragment();
        if (currentVisibleFragment instanceof PushNotificationsFragment) {
            ((PushNotificationsFragment) currentVisibleFragment).setEventFilterType(null);
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public void onActionModeCreated(ActionMode.Callback callback) {
        super.onActionModeCreated(callback);
        toggleFab(false);
        toggleActionModeStatusBar(true);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public void onActionModeDestroyed(ActionMode.Callback callback) {
        super.onActionModeDestroyed(callback);
        toggleFab(getCurrentVisibleFragment().isFloatingMenuAvailable());
        toggleActionModeStatusBar(false);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode actionMode) {
        super.onSupportActionModeStarted(actionMode);
        if (this.mFeatureFlips.getMainScreenRedesign().getEnabled()) {
            return;
        }
        getWindow().getDecorView().post(new Runnable() { // from class: com.box.android.activities.MainParent$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$onSupportActionModeStarted$10();
            }
        });
    }

    private void toggleActionModeStatusBar(boolean z) {
        if (this.mFeatureFlips.getMainScreenRedesign().getEnabled()) {
            return;
        }
        findViewById(R.id.coordinator_layout).setBackgroundColor(CommonBoxUtil.getColorFromAttribute(this, z ? R.attr.topBarActionModeBackgroundOldHomeScreen : R.attr.topBarBackground));
        WindowCompat.getInsetsController(getWindow(), getWindow().getDecorView()).setAppearanceLightStatusBars(z && isLightModeEnabled());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: applyOldDesignActionModeStyle, reason: merged with bridge method [inline-methods] */
    public void lambda$onSupportActionModeStarted$10() {
        ActionBarContextView actionBarContextViewFindActionBarContextView;
        View decorView = getWindow().getDecorView();
        if ((decorView instanceof ViewGroup) && (actionBarContextViewFindActionBarContextView = findActionBarContextView((ViewGroup) decorView)) != null) {
            actionBarContextViewFindActionBarContextView.setBackground(ContextCompat.getDrawable(this, R.drawable.action_mode_background));
        }
    }

    private ActionBarContextView findActionBarContextView(ViewGroup viewGroup) {
        ActionBarContextView actionBarContextViewFindActionBarContextView;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ActionBarContextView) {
                return (ActionBarContextView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (actionBarContextViewFindActionBarContextView = findActionBarContextView((ViewGroup) childAt)) != null) {
                return actionBarContextViewFindActionBarContextView;
            }
        }
        return null;
    }

    protected boolean menuItemHasConnectivityProblemCheckAndAlert(int i) {
        if (menuItemsNotRequiringNetwork.contains(Integer.valueOf(i)) || Connectivity.isConnected()) {
            return false;
        }
        BoxPresentationUtils.displayToast(R.string.err_conn1, this, new String[0]);
        return true;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public Snackbar displaySnackbar(BoxFragmentInterface boxFragmentInterface, int i, int i2, View.OnClickListener onClickListener) {
        return displaySnackbar(CommonBoxUtil.LS(i), i2, onClickListener);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity, com.box.android.base.presentation.fragments.IMainParent
    public Snackbar displaySnackbar(int i, int i2, View.OnClickListener onClickListener) {
        return displaySnackbar(CommonBoxUtil.LS(i), i2, onClickListener);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public Snackbar displaySnackbar(int i, int i2, View.OnClickListener onClickListener, int i3) {
        return displaySnackbar(CommonBoxUtil.LS(i), i2, onClickListener, i3);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public Snackbar displaySnackbar(String str, int i, View.OnClickListener onClickListener) {
        return displaySnackbar(str, i, onClickListener, -2);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity
    public Snackbar displaySnackbar(String str, int i, View.OnClickListener onClickListener, int i2) {
        View viewFindViewById = findViewById(R.id.snackbar_container);
        viewFindViewById.setVisibility(0);
        if ((viewFindViewById.getParent() instanceof View) && ((View) viewFindViewById.getParent()).getAlpha() == 0.0f) {
            BoxPresentationUtils.displayToast(str, this);
        }
        Snackbar snackbarDisplaySnackBar = BoxPresentationUtils.displaySnackBar(this, viewFindViewById, str, i, onClickListener, i2);
        this.mSnackBar = snackbarDisplaySnackBar;
        snackbarDisplaySnackBar.addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() { // from class: com.box.android.activities.MainParent.12
            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            public void onShown(Snackbar snackbar) {
                super.onShown(snackbar);
                MainParent.this.updateFabMargin();
            }

            @Override // com.google.android.material.snackbar.BaseTransientBottomBar.BaseCallback
            public void onDismissed(Snackbar snackbar, int i3) {
                super.onDismissed(snackbar, i3);
                MainParent.this.updateFabMargin();
            }
        });
        return this.mSnackBar;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, com.box.android.base.presentation.fragments.IBoxFragmentActivity, com.box.android.base.presentation.fragments.IMainParent
    public void dismissSnackbar() {
        Snackbar snackbar = this.mSnackBar;
        if (snackbar != null) {
            snackbar.dismiss();
        }
    }

    protected void logSearchTriggered(String str) {
        BoxAmplitudeAnalytics.SearchEventPropertyBuilder searchEventPropertyBuilderCreateSearchEventBuilder = BoxAmplitudeAnalytics.createSearchEventBuilder();
        searchEventPropertyBuilderCreateSearchEventBuilder.setFlow(BoxAnalyticsParams.FLOW_FILE_NAVIGATION);
        searchEventPropertyBuilderCreateSearchEventBuilder.setCtaTarget(BoxAnalyticsParams.PAGE_NAME_SEARCH);
        searchEventPropertyBuilderCreateSearchEventBuilder.setCtaPageLocation(str);
        searchEventPropertyBuilderCreateSearchEventBuilder.logTriggered();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void logSearchAction(String str) {
        if (this.mSearchActionLogHelper.isSearchLogged()) {
            return;
        }
        if (this.mSearchActionLogHelper.isQueryRecentClicked(str)) {
            this.mSearchActionLogHelper.logRecentAction();
        } else {
            this.mSearchActionLogHelper.logTypingAction();
        }
    }
}
