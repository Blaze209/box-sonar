package com.box.android.navigationmodernization;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.box.android.R;
import com.box.android.auth.AuthenticationActivity;
import com.box.android.base.presentation.BoxPresentationUtils;
import com.box.android.base.presentation.activities.BoxFragmentActivity;
import com.box.android.base.presentation.activities.CreatePincodeActivity;
import com.box.android.base.presentation.activities.NotificationPermissionRationaleActivity;
import com.box.android.base.presentation.fragments.BaseFTUX;
import com.box.android.base.presentation.message.BoxMessageDispatcher;
import com.box.android.base.presentation.utilities.IItemMoreActionsHandler;
import com.box.android.clientadmin.BoxAdminSettingsProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.common.utilities.IntentConstants;
import com.box.android.common.utilities.RationaleScreenHelper;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.jobcollections.OfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.RemoveOfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.OfflineBoxJob;
import com.box.android.coreservices.jobmanager.jobs.RemoveOfflineBoxJob;
import com.box.android.coreservices.jobmanager.tasks.OfflinePreviewTask;
import com.box.android.coreservices.jobmanager.tasks.OfflineTask;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
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
import com.box.android.domain.configuration.IBoxAccountSettings;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.sqlitetables.BoxRecentItemSQLData;
import com.box.android.domain.localrepo.sqlitetables.BoxSqlQueryManager;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.offline.IOfflineStateStorage;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IOfflineFilesPolicyEnforcer;
import com.box.android.fragments.AutoUploadUtils;
import com.box.android.localrepo.LocalAutoContentUploadInformation;
import com.box.android.navigationmodernization.homescreen.helpers.FTUXMessageReceiverHelper;
import com.box.android.preview.previewtype.boxnote.BoxNotesWebviewAssetCache;
import com.box.android.workers.AutoUploadWorkerDispatcher;
import com.box.androidsdk.content.BoxApiUser;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxExtendedApiPreview;
import com.box.androidsdk.content.auth.BoxAuthentication;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.models.BoxRecentItem;
import com.box.androidsdk.content.requests.BoxFilePreviewRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestBatch;
import com.box.androidsdk.content.requests.BoxRequestRecentItems;
import com.box.androidsdk.content.requests.BoxRequestsBookmark;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.androidsdk.content.requests.BoxRequestsSearch;
import com.box.androidsdk.content.requests.BoxRequestsUser;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.dao.BoxAdminSettings;
import com.box.boxandroidlibv2private.dao.BoxFeatures;
import com.box.boxandroidlibv2private.model.BoxIteratorBoxRecentFiles;
import com.box.boxandroidlibv2private.model.BoxRecentBoxFile;
import com.box.boxandroidlibv2private.requests.BoxFileNotificationMute;
import com.box.boxandroidlibv2private.requests.BoxRequestCreateBoxNote;
import com.box.boxandroidlibv2private.requests.BoxRequestDeleteCollaboration;
import com.box.boxandroidlibv2private.requests.BoxRequestGetFeatures;
import com.box.boxandroidlibv2private.requests.BoxRequestGetPushNotifications;
import com.box.boxandroidlibv2private.requests.BoxRequestLocalRecentItems;
import com.box.boxandroidlibv2private.requests.BoxRequestStorePushNotification;
import com.box.boxandroidlibv2private.requests.BoxRequestUploadFile;
import com.box.boxandroidlibv2private.requests.BoxRequestUploadNewVersionFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiRecentItems;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import java.lang.ref.WeakReference;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: MainBaseActivity.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0088\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020o2\b\u0010q\u001a\u0004\u0018\u00010rH\u0014J\u0012\u0010s\u001a\u00020m2\b\u0010t\u001a\u0004\u0018\u00010uH\u0014J\u0012\u0010v\u001a\u00020m2\b\u0010t\u001a\u0004\u0018\u00010uH\u0014J\b\u0010w\u001a\u00020mH\u0014J\b\u0010x\u001a\u00020mH\u0016J\b\u0010y\u001a\u00020mH\u0016J\u000f\u0010z\u001a\u0004\u0018\u00010oH\u0014¢\u0006\u0002\u0010{J\b\u0010|\u001a\u00020}H\u0016J\u0015\u0010~\u001a\u00020m2\u000b\u0010\u007f\u001a\u0007\u0012\u0002\b\u00030\u0080\u0001H\u0014J8\u0010\u0081\u0001\u001a\u00020m2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u000e\u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u00020m0\u0085\u00012\u0015\u0010\u0086\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u0088\u0001\u0012\u0004\u0012\u00020m0\u0087\u0001J\u0012\u0010\u0089\u0001\u001a\u00020m2\u0007\u0010\u008a\u0001\u001a\u00020iH\u0002J'\u0010\u008b\u0001\u001a\u00020m2\n\b\u0002\u0010\u008c\u0001\u001a\u00030\u008d\u00012\n\b\u0002\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0001¢\u0006\u0003\b\u0090\u0001J\u0016\u0010\u0091\u0001\u001a\u00020e2\u000b\u0010\u007f\u001a\u0007\u0012\u0002\b\u00030\u0092\u0001H\u0002J\u0013\u0010\u0093\u0001\u001a\u00020m2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0014J\u0014\u0010\u0096\u0001\u001a\u00020m2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010rH\u0014J\t\u0010\u0097\u0001\u001a\u00020eH\u0014J\t\u0010\u0098\u0001\u001a\u00020mH\u0002J\t\u0010\u0099\u0001\u001a\u00020mH\u0002J\t\u0010\u009a\u0001\u001a\u00020mH\u0002J\u0012\u0010\u009b\u0001\u001a\u00020m2\u0007\u0010\u009c\u0001\u001a\u00020eH\u0002J\t\u0010\u009d\u0001\u001a\u00020mH\u0002R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u00104\u001a\u0002058\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010@\u001a\u00020A8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010F\u001a\u00020G8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u0010L\u001a\u00020M8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001e\u0010R\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001e\u0010X\u001a\u00020Y8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001b\u0010^\u001a\u00020_8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\b`\u0010aR\u000e\u0010d\u001a\u00020eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010g\u001a\n\u0012\u0004\u0012\u00020i\u0018\u00010hX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020kX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u009e\u0001"}, d2 = {"Lcom/box/android/navigationmodernization/MainBaseActivity;", "Lcom/box/android/base/presentation/activities/BoxFragmentActivity;", "<init>", "()V", "itemMoreActionsHandlerFactory", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler$Factory;", "getItemMoreActionsHandlerFactory", "()Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler$Factory;", "setItemMoreActionsHandlerFactory", "(Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler$Factory;)V", "jobManager", "Lcom/box/android/coreservices/jobmanager/JobManager;", "getJobManager", "()Lcom/box/android/coreservices/jobmanager/JobManager;", "setJobManager", "(Lcom/box/android/coreservices/jobmanager/JobManager;)V", "jobService", "Lcom/box/android/domain/services/IJobService;", "getJobService", "()Lcom/box/android/domain/services/IJobService;", "setJobService", "(Lcom/box/android/domain/services/IJobService;)V", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "getIntentServices", "()Lcom/box/android/coreservices/services/IntentServices;", "setIntentServices", "(Lcom/box/android/coreservices/services/IntentServices;)V", "apiPreviewPrivate", "Lcom/box/androidsdk/content/BoxExtendedApiPreview;", "getApiPreviewPrivate", "()Lcom/box/androidsdk/content/BoxExtendedApiPreview;", "setApiPreviewPrivate", "(Lcom/box/androidsdk/content/BoxExtendedApiPreview;)V", "boxMessageDispatcher", "Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "getBoxMessageDispatcher", "()Lcom/box/android/base/presentation/message/BoxMessageDispatcher;", "setBoxMessageDispatcher", "(Lcom/box/android/base/presentation/message/BoxMessageDispatcher;)V", "ftuxMessageReceiverHelper", "Lcom/box/android/navigationmodernization/homescreen/helpers/FTUXMessageReceiverHelper;", "getFtuxMessageReceiverHelper", "()Lcom/box/android/navigationmodernization/homescreen/helpers/FTUXMessageReceiverHelper;", "setFtuxMessageReceiverHelper", "(Lcom/box/android/navigationmodernization/homescreen/helpers/FTUXMessageReceiverHelper;)V", "offlineStateStorage", "Lcom/box/android/domain/offline/IOfflineStateStorage;", "getOfflineStateStorage", "()Lcom/box/android/domain/offline/IOfflineStateStorage;", "setOfflineStateStorage", "(Lcom/box/android/domain/offline/IOfflineStateStorage;)V", "offlineMigrationService", "Lcom/box/android/data/persistence/offline/OfflineMigrationService;", "getOfflineMigrationService", "()Lcom/box/android/data/persistence/offline/OfflineMigrationService;", "setOfflineMigrationService", "(Lcom/box/android/data/persistence/offline/OfflineMigrationService;)V", "boxAdminSettingsProvider", "Lcom/box/android/clientadmin/BoxAdminSettingsProvider;", "getBoxAdminSettingsProvider", "()Lcom/box/android/clientadmin/BoxAdminSettingsProvider;", "setBoxAdminSettingsProvider", "(Lcom/box/android/clientadmin/BoxAdminSettingsProvider;)V", "adminSettingsModelController", "Lcom/box/android/coreservices/modelcontroller/IMoCoAdminSettings;", "getAdminSettingsModelController", "()Lcom/box/android/coreservices/modelcontroller/IMoCoAdminSettings;", "setAdminSettingsModelController", "(Lcom/box/android/coreservices/modelcontroller/IMoCoAdminSettings;)V", "boxApiUser", "Lcom/box/androidsdk/content/BoxApiUser;", "getBoxApiUser", "()Lcom/box/androidsdk/content/BoxApiUser;", "setBoxApiUser", "(Lcom/box/androidsdk/content/BoxApiUser;)V", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "getLocalItemService", "()Lcom/box/android/domain/services/ILocalItemService;", "setLocalItemService", "(Lcom/box/android/domain/services/ILocalItemService;)V", "boxAccountSettings", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "getBoxAccountSettings", "()Lcom/box/android/domain/configuration/IBoxAccountSettings;", "setBoxAccountSettings", "(Lcom/box/android/domain/configuration/IBoxAccountSettings;)V", "offlineFilesPolicyEnforcer", "Lcom/box/android/domain/services/IOfflineFilesPolicyEnforcer;", "getOfflineFilesPolicyEnforcer", "()Lcom/box/android/domain/services/IOfflineFilesPolicyEnforcer;", "setOfflineFilesPolicyEnforcer", "(Lcom/box/android/domain/services/IOfflineFilesPolicyEnforcer;)V", "itemMoreActionsHandler", "Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "getItemMoreActionsHandler", "()Lcom/box/android/base/presentation/utilities/IItemMoreActionsHandler;", "itemMoreActionsHandler$delegate", "Lkotlin/Lazy;", "shouldUpdateFilePreviews", "", "navigateOnResume", "adminSettingsTask", "Lcom/box/android/coreservices/modelcontroller/BoxFutureTask;", "Lcom/box/android/coreservices/modelcontroller/messages/BoxAdminSettingsMessage;", "ftuxMessageReceiver", "Landroid/content/BroadcastReceiver;", "handleOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBoxCreate", "savedInstanceState", "Landroid/os/Bundle;", "onBoxInitialize", "onBoxStart", "onBoxResume", "onPause", "getActivityLayoutId", "()Ljava/lang/Integer;", "getIntentFilter", "Landroid/content/IntentFilter;", "processBoxMessage", "message", "Lcom/box/android/coreservices/modelcontroller/messages/BoxMessage;", "checkFileExistsAndLaunch", "file", "Lcom/box/androidsdk/content/models/BoxFile;", "onErrorHappened", "Lkotlin/Function0;", "performItemClick", "Lkotlin/Function1;", "Lcom/box/android/domain/models/item/ItemModel;", "onFetchedClientSettings", "intent", "enforceOfflineFilesPolicy", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "enforceOfflineFilesPolicy$box_generalProdRelease", "handlePendingOfflinePreviews", "Lcom/box/android/coreservices/modelcontroller/messages/BoxResponseMessage;", "onSwitchedUser", NotificationCompat.CATEGORY_MESSAGE, "Lcom/box/android/coreservices/modelcontroller/messages/BoxSwitchUserMessage;", "handleOnNewIntent", "onDifferentUserAccessed", "cleanActivity", "onCleanedCompleted", "recreateActivity", "refreshUserSettingsIfNecessary", "forceRefresh", "runAutoContentUpload", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class MainBaseActivity extends BoxFragmentActivity {
    public static final int $stable = 8;

    @Inject
    public IMoCoAdminSettings adminSettingsModelController;
    private BoxFutureTask<BoxAdminSettingsMessage> adminSettingsTask;

    @Inject
    public BoxExtendedApiPreview apiPreviewPrivate;

    @Inject
    public IBoxAccountSettings boxAccountSettings;

    @Inject
    public BoxAdminSettingsProvider boxAdminSettingsProvider;

    @Inject
    public BoxApiUser boxApiUser;

    @Inject
    public BoxMessageDispatcher boxMessageDispatcher;

    @Inject
    public FTUXMessageReceiverHelper ftuxMessageReceiverHelper;

    @Inject
    public IntentServices intentServices;

    @Inject
    public IItemMoreActionsHandler.Factory itemMoreActionsHandlerFactory;

    @Inject
    public JobManager jobManager;

    @Inject
    public IJobService jobService;

    @Inject
    public ILocalItemService localItemService;
    private boolean navigateOnResume;

    @Inject
    public IOfflineFilesPolicyEnforcer offlineFilesPolicyEnforcer;

    @Inject
    public OfflineMigrationService offlineMigrationService;

    @Inject
    public IOfflineStateStorage offlineStateStorage;
    private boolean shouldUpdateFilePreviews;

    /* JADX INFO: renamed from: itemMoreActionsHandler$delegate, reason: from kotlin metadata */
    private final Lazy itemMoreActionsHandler = LazyKt.lazy(new Function0() { // from class: com.box.android.navigationmodernization.MainBaseActivity$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MainBaseActivity.itemMoreActionsHandler_delegate$lambda$0(this.f$0);
        }
    });
    private final BroadcastReceiver ftuxMessageReceiver = new MAMBroadcastReceiver() { // from class: com.box.android.navigationmodernization.MainBaseActivity$ftuxMessageReceiver$1
        @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
        public void onMAMReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.this$0.getFtuxMessageReceiverHelper().handleOnReceive(intent, this.this$0);
        }
    };

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected Integer getActivityLayoutId() {
        return null;
    }

    public final IItemMoreActionsHandler.Factory getItemMoreActionsHandlerFactory() {
        IItemMoreActionsHandler.Factory factory = this.itemMoreActionsHandlerFactory;
        if (factory != null) {
            return factory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemMoreActionsHandlerFactory");
        return null;
    }

    public final void setItemMoreActionsHandlerFactory(IItemMoreActionsHandler.Factory factory) {
        Intrinsics.checkNotNullParameter(factory, "<set-?>");
        this.itemMoreActionsHandlerFactory = factory;
    }

    public final JobManager getJobManager() {
        JobManager jobManager = this.jobManager;
        if (jobManager != null) {
            return jobManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jobManager");
        return null;
    }

    public final void setJobManager(JobManager jobManager) {
        Intrinsics.checkNotNullParameter(jobManager, "<set-?>");
        this.jobManager = jobManager;
    }

    public final IJobService getJobService() {
        IJobService iJobService = this.jobService;
        if (iJobService != null) {
            return iJobService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jobService");
        return null;
    }

    public final void setJobService(IJobService iJobService) {
        Intrinsics.checkNotNullParameter(iJobService, "<set-?>");
        this.jobService = iJobService;
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

    public final BoxExtendedApiPreview getApiPreviewPrivate() {
        BoxExtendedApiPreview boxExtendedApiPreview = this.apiPreviewPrivate;
        if (boxExtendedApiPreview != null) {
            return boxExtendedApiPreview;
        }
        Intrinsics.throwUninitializedPropertyAccessException("apiPreviewPrivate");
        return null;
    }

    public final void setApiPreviewPrivate(BoxExtendedApiPreview boxExtendedApiPreview) {
        Intrinsics.checkNotNullParameter(boxExtendedApiPreview, "<set-?>");
        this.apiPreviewPrivate = boxExtendedApiPreview;
    }

    public final BoxMessageDispatcher getBoxMessageDispatcher() {
        BoxMessageDispatcher boxMessageDispatcher = this.boxMessageDispatcher;
        if (boxMessageDispatcher != null) {
            return boxMessageDispatcher;
        }
        Intrinsics.throwUninitializedPropertyAccessException("boxMessageDispatcher");
        return null;
    }

    public final void setBoxMessageDispatcher(BoxMessageDispatcher boxMessageDispatcher) {
        Intrinsics.checkNotNullParameter(boxMessageDispatcher, "<set-?>");
        this.boxMessageDispatcher = boxMessageDispatcher;
    }

    public final FTUXMessageReceiverHelper getFtuxMessageReceiverHelper() {
        FTUXMessageReceiverHelper fTUXMessageReceiverHelper = this.ftuxMessageReceiverHelper;
        if (fTUXMessageReceiverHelper != null) {
            return fTUXMessageReceiverHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("ftuxMessageReceiverHelper");
        return null;
    }

    public final void setFtuxMessageReceiverHelper(FTUXMessageReceiverHelper fTUXMessageReceiverHelper) {
        Intrinsics.checkNotNullParameter(fTUXMessageReceiverHelper, "<set-?>");
        this.ftuxMessageReceiverHelper = fTUXMessageReceiverHelper;
    }

    public final IOfflineStateStorage getOfflineStateStorage() {
        IOfflineStateStorage iOfflineStateStorage = this.offlineStateStorage;
        if (iOfflineStateStorage != null) {
            return iOfflineStateStorage;
        }
        Intrinsics.throwUninitializedPropertyAccessException("offlineStateStorage");
        return null;
    }

    public final void setOfflineStateStorage(IOfflineStateStorage iOfflineStateStorage) {
        Intrinsics.checkNotNullParameter(iOfflineStateStorage, "<set-?>");
        this.offlineStateStorage = iOfflineStateStorage;
    }

    public final OfflineMigrationService getOfflineMigrationService() {
        OfflineMigrationService offlineMigrationService = this.offlineMigrationService;
        if (offlineMigrationService != null) {
            return offlineMigrationService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("offlineMigrationService");
        return null;
    }

    public final void setOfflineMigrationService(OfflineMigrationService offlineMigrationService) {
        Intrinsics.checkNotNullParameter(offlineMigrationService, "<set-?>");
        this.offlineMigrationService = offlineMigrationService;
    }

    public final BoxAdminSettingsProvider getBoxAdminSettingsProvider() {
        BoxAdminSettingsProvider boxAdminSettingsProvider = this.boxAdminSettingsProvider;
        if (boxAdminSettingsProvider != null) {
            return boxAdminSettingsProvider;
        }
        Intrinsics.throwUninitializedPropertyAccessException("boxAdminSettingsProvider");
        return null;
    }

    public final void setBoxAdminSettingsProvider(BoxAdminSettingsProvider boxAdminSettingsProvider) {
        Intrinsics.checkNotNullParameter(boxAdminSettingsProvider, "<set-?>");
        this.boxAdminSettingsProvider = boxAdminSettingsProvider;
    }

    public final IMoCoAdminSettings getAdminSettingsModelController() {
        IMoCoAdminSettings iMoCoAdminSettings = this.adminSettingsModelController;
        if (iMoCoAdminSettings != null) {
            return iMoCoAdminSettings;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adminSettingsModelController");
        return null;
    }

    public final void setAdminSettingsModelController(IMoCoAdminSettings iMoCoAdminSettings) {
        Intrinsics.checkNotNullParameter(iMoCoAdminSettings, "<set-?>");
        this.adminSettingsModelController = iMoCoAdminSettings;
    }

    public final BoxApiUser getBoxApiUser() {
        BoxApiUser boxApiUser = this.boxApiUser;
        if (boxApiUser != null) {
            return boxApiUser;
        }
        Intrinsics.throwUninitializedPropertyAccessException("boxApiUser");
        return null;
    }

    public final void setBoxApiUser(BoxApiUser boxApiUser) {
        Intrinsics.checkNotNullParameter(boxApiUser, "<set-?>");
        this.boxApiUser = boxApiUser;
    }

    public final ILocalItemService getLocalItemService() {
        ILocalItemService iLocalItemService = this.localItemService;
        if (iLocalItemService != null) {
            return iLocalItemService;
        }
        Intrinsics.throwUninitializedPropertyAccessException("localItemService");
        return null;
    }

    public final void setLocalItemService(ILocalItemService iLocalItemService) {
        Intrinsics.checkNotNullParameter(iLocalItemService, "<set-?>");
        this.localItemService = iLocalItemService;
    }

    public final IBoxAccountSettings getBoxAccountSettings() {
        IBoxAccountSettings iBoxAccountSettings = this.boxAccountSettings;
        if (iBoxAccountSettings != null) {
            return iBoxAccountSettings;
        }
        Intrinsics.throwUninitializedPropertyAccessException("boxAccountSettings");
        return null;
    }

    public final void setBoxAccountSettings(IBoxAccountSettings iBoxAccountSettings) {
        Intrinsics.checkNotNullParameter(iBoxAccountSettings, "<set-?>");
        this.boxAccountSettings = iBoxAccountSettings;
    }

    public final IOfflineFilesPolicyEnforcer getOfflineFilesPolicyEnforcer() {
        IOfflineFilesPolicyEnforcer iOfflineFilesPolicyEnforcer = this.offlineFilesPolicyEnforcer;
        if (iOfflineFilesPolicyEnforcer != null) {
            return iOfflineFilesPolicyEnforcer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("offlineFilesPolicyEnforcer");
        return null;
    }

    public final void setOfflineFilesPolicyEnforcer(IOfflineFilesPolicyEnforcer iOfflineFilesPolicyEnforcer) {
        Intrinsics.checkNotNullParameter(iOfflineFilesPolicyEnforcer, "<set-?>");
        this.offlineFilesPolicyEnforcer = iOfflineFilesPolicyEnforcer;
    }

    protected final IItemMoreActionsHandler getItemMoreActionsHandler() {
        return (IItemMoreActionsHandler) this.itemMoreActionsHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IItemMoreActionsHandler itemMoreActionsHandler_delegate$lambda$0(MainBaseActivity mainBaseActivity) {
        return mainBaseActivity.getItemMoreActionsHandlerFactory().create(mainBaseActivity);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnActivityResult(int requestCode, int resultCode, Intent data) {
        super.handleOnActivityResult(requestCode, resultCode, data);
        getItemMoreActionsHandler().handleMoreActionsResult(requestCode, resultCode, data);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxCreate(Bundle savedInstanceState) {
        super.onBoxCreate(savedInstanceState);
        if (this.mFeatureFlips.getMigrateOfflineInfoToDb().getEnabled()) {
            BoxModelOfflineManager.setOfflineStorage(getOfflineStateStorage());
            getOfflineMigrationService().migrateToRoom();
        }
        enforceOfflineFilesPolicy$box_generalProdRelease$default(this, null, null, 3, null);
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxInitialize(Bundle savedInstanceState) {
        super.onBoxInitialize(savedInstanceState);
        BoxNotesWebviewAssetCache.getInstance(this.mConfigManager).syncCachedFilesListIfNecessary(this.mUserContextManager);
        refreshUserSettingsIfNecessary(true);
        if (this.mGlobalSettings.isFirstTimeUser()) {
            this.mGlobalSettings.setFirstTimeUser(false);
        }
        runAutoContentUpload();
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onBoxStart() {
        super.onBoxStart();
        this.shouldUpdateFilePreviews = true;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    public void onBoxResume() {
        super.onBoxResume();
        getItemMoreActionsHandler().registerMoreActionsHandler();
        refreshUserSettingsIfNecessary(false);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BaseFTUX.EXTRA_ACTION_SHOW_FTUX);
        intentFilter.addAction(BaseFTUX.EXTRA_ACTION_POSITIVE_CLICK);
        MainBaseActivity mainBaseActivity = this;
        LocalBroadcastManager.getInstance(mainBaseActivity).registerReceiver(this.ftuxMessageReceiver, intentFilter);
        if (RationaleScreenHelper.INSTANCE.shouldShowRationale(RationaleScreenHelper.NOTIFICATION_RATIONALE)) {
            startActivity(new Intent(mainBaseActivity, (Class<?>) NotificationPermissionRationaleActivity.class));
        }
        if (this.navigateOnResume) {
            onBoxInitialize(null);
            this.navigateOnResume = false;
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMPause() {
        super.onMAMPause();
        getItemMoreActionsHandler().unregisterMoreActionsHandler();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.ftuxMessageReceiver);
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
        Intrinsics.checkNotNull(intentFilter);
        return intentFilter;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void processBoxMessage(BoxMessage<?> message) {
        Intrinsics.checkNotNullParameter(message, "message");
        super.processBoxMessage(message);
        if (message instanceof BoxAdminSettingsMessage) {
            onFetchedClientSettings((BoxAdminSettingsMessage) message);
            return;
        }
        if (message instanceof BoxResponseMessage) {
            BoxResponseMessage<?> boxResponseMessage = (BoxResponseMessage) message;
            if (handlePendingOfflinePreviews(boxResponseMessage)) {
                return;
            }
            if (this.shouldUpdateFilePreviews && boxResponseMessage.wasSuccessful() && boxResponseMessage.isRemote()) {
                this.shouldUpdateFilePreviews = false;
                this.mBaseMoco.performLocal(new BoxRequestLocalRecentItems(this.mBoxSession, BoxExtendedApiRecentItems.FILTER.OFFLINE));
            }
        }
        getBoxMessageDispatcher().dispatch(message);
    }

    public final void checkFileExistsAndLaunch(BoxFile file, final Function0<Unit> onErrorHappened, final Function1<? super ItemModel, Unit> performItemClick) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(onErrorHappened, "onErrorHappened");
        Intrinsics.checkNotNullParameter(performItemClick, "performItemClick");
        final WeakReference weakReference = new WeakReference(this);
        showSpinner();
        IBaseModelController iBaseModelController = this.mBaseMoco;
        BoxRequestsFile.GetFileInfo infoRequest = this.mBoxExtendedApiFile.getInfoRequest(file.getUserId());
        Intrinsics.checkNotNullExpressionValue(infoRequest, "getInfoRequest(...)");
        iBaseModelController.performRemote(infoRequest).addOnCompletedListener(new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.navigationmodernization.MainBaseActivity$$ExternalSyntheticLambda1
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                MainBaseActivity.checkFileExistsAndLaunch$lambda$0(weakReference, this, onErrorHappened, performItemClick, boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkFileExistsAndLaunch$lambda$0(WeakReference weakReference, MainBaseActivity mainBaseActivity, final Function0 function0, final Function1 function1, final BoxResponse boxResponse) {
        MainBaseActivity mainBaseActivity2 = (MainBaseActivity) weakReference.get();
        if (mainBaseActivity2 != null) {
            mainBaseActivity2.dismissSpinnerSynchronous();
            if (boxResponse.isSuccess() && !SdkUtils.isBlank(((BoxFile) boxResponse.getResult()).getName())) {
                mainBaseActivity2.runOnUiThread(new Runnable() { // from class: com.box.android.navigationmodernization.MainBaseActivity$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        MainBaseActivity.checkFileExistsAndLaunch$lambda$0$0(function1, boxResponse);
                    }
                });
                return;
            }
            if (boxResponse.getException() instanceof BoxException) {
                Exception exception = boxResponse.getException();
                Intrinsics.checkNotNull(exception, "null cannot be cast to non-null type com.box.androidsdk.content.BoxException");
                if (((BoxException) exception).getErrorType() == BoxException.ErrorType.NETWORK_ERROR) {
                    BoxPresentationUtils.displayToast(R.string.box_browsesdk_network_error, mainBaseActivity, new String[0]);
                    return;
                }
            }
            mainBaseActivity2.runOnUiThread(new Runnable() { // from class: com.box.android.navigationmodernization.MainBaseActivity$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    function0.invoke();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkFileExistsAndLaunch$lambda$0$0(Function1 function1, BoxResponse boxResponse) {
        FileModelMapper fileModelMapper = FileModelMapper.INSTANCE;
        BoxObject result = boxResponse.getResult();
        Intrinsics.checkNotNullExpressionValue(result, "getResult(...)");
        function1.invoke(FileModelMapper.toFileModel$default(fileModelMapper, (BoxFile) result, false, 1, null));
    }

    private final void onFetchedClientSettings(BoxAdminSettingsMessage intent) {
        if (intent.wasSuccessful()) {
            BoxAdminSettings payload = intent.getPayload();
            boolean zIsHubsGalleryEnabled = getBoxAccountSettings().isHubsGalleryEnabled();
            boolean zIsAxCenterEnabled = getBoxAccountSettings().isAxCenterEnabled();
            BoxAccountManager.updateAllowSaveForOfflineSetting(this.mNotificationServices, payload, this.mUserContextManager, getJobManager(), getJobService());
            BoxAccountManager.updateRequiredMinimumVersionSetting(payload, getUserSharedPrefs());
            BoxAccountManager.updateRequiresPasscodeLockSetting(payload, getUserSharedPrefs());
            BoxAccountManager.updateSimpleBooleanMobileSettings(payload, this.mUserContextManager);
            if ((zIsHubsGalleryEnabled != payload.isHubsGalleryEnabled() || zIsAxCenterEnabled != payload.isAxCenterInWebEnabled()) && !CommonBoxUtil.isRunningAutomatedTest()) {
                recreate();
            }
        }
        if (showIntuneAuth()) {
            return;
        }
        if (BoxAccountManager.isPasscodeAdminRequired(getUserSharedPrefs()) && !CreatePincodeActivity.userHasSetPincode(this.mUserContextManager)) {
            CreatePincodeActivity.startActivity(CommonBoxUtil.LS(R.string.Your_administrator_has_required_a_passcode_be_set));
        }
        BoxAccountManager.checkMinimumVersion(this.mNotificationServices, getIntentServices(), 1, getUserSharedPrefs());
    }

    public static /* synthetic */ void enforceOfflineFilesPolicy$box_generalProdRelease$default(MainBaseActivity mainBaseActivity, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enforceOfflineFilesPolicy");
        }
        if ((i & 1) != 0) {
            coroutineScope = LifecycleOwnerKt.getLifecycleScope(mainBaseActivity);
        }
        if ((i & 2) != 0) {
            coroutineDispatcher = Dispatchers.getIO();
        }
        mainBaseActivity.enforceOfflineFilesPolicy$box_generalProdRelease(coroutineScope, coroutineDispatcher);
    }

    public final void enforceOfflineFilesPolicy$box_generalProdRelease(CoroutineScope scope, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        BuildersKt__Builders_commonKt.launch$default(scope, dispatcher, null, new MainBaseActivity$enforceOfflineFilesPolicy$1(this, null), 2, null);
    }

    private final boolean handlePendingOfflinePreviews(BoxResponseMessage<?> message) {
        if (Intrinsics.areEqual(message.getAction(), BoxRequestLocalRecentItems.class.getName())) {
            BoxRequest request = message.getRequest();
            Intrinsics.checkNotNull(request, "null cannot be cast to non-null type com.box.boxandroidlibv2private.requests.BoxRequestLocalRecentItems");
            BoxRequestLocalRecentItems boxRequestLocalRecentItems = (BoxRequestLocalRecentItems) request;
            BoxIteratorBoxRecentFiles boxIteratorBoxRecentFiles = (BoxIteratorBoxRecentFiles) message.getResponse().getResult();
            if (boxIteratorBoxRecentFiles != null && boxRequestLocalRecentItems.getFilter() == BoxExtendedApiRecentItems.FILTER.OFFLINE) {
                BoxSqlQueryManager queryManager = this.mUserContextManager.getCurrentContext().getSQLHelper().getQueryManager();
                BoxRequestBatch boxRequestBatch = new BoxRequestBatch();
                Iterator<BoxItem> it = boxIteratorBoxRecentFiles.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    BoxItem next = it.next();
                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type com.box.boxandroidlibv2private.model.BoxRecentBoxFile");
                    BoxRecentBoxFile boxRecentBoxFile = (BoxRecentBoxFile) next;
                    BoxRequestsFile.FilePreviewed filePreviewedRequest = getApiPreviewPrivate().getFilePreviewedRequest(boxRecentBoxFile.getUserId());
                    Intrinsics.checkNotNull(filePreviewedRequest, "null cannot be cast to non-null type com.box.androidsdk.content.requests.BoxFilePreviewRequest");
                    BoxFilePreviewRequest boxFilePreviewRequest = (BoxFilePreviewRequest) filePreviewedRequest;
                    BoxRecentItem recentItem = boxRecentBoxFile.getRecentItem();
                    boxFilePreviewRequest.setPreviewTime(recentItem != null ? recentItem.getInteractedAt() : null);
                    BoxRecentItem recentItem2 = boxRecentBoxFile.getRecentItem();
                    boxFilePreviewRequest.setInteractionSharedLink(recentItem2 != null ? recentItem2.getInteractionSharedLink() : null);
                    boxRequestBatch.addRequest(boxFilePreviewRequest);
                    BoxRecentItemSQLData boxRecentItemSQLData = new BoxRecentItemSQLData(boxRecentBoxFile.getRecentItem());
                    boxRecentItemSQLData.setOffline(false);
                    try {
                        queryManager.update(boxRecentItemSQLData);
                    } catch (SQLException e) {
                        String name = getClass().getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        BoxLogUtils.logException(name, e);
                    }
                }
                this.mBaseMoco.performRemote(boxRequestBatch);
                return true;
            }
        }
        return false;
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void onSwitchedUser(BoxSwitchUserMessage msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (StringUtils.isEmpty(msg.getSwitchToUserId())) {
            startActivity(AuthenticationActivity.INSTANCE.createSwitchUserIntent(this));
            finish();
        } else {
            super.onSwitchedUser(msg);
            recreateActivity();
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected void handleOnNewIntent(Intent intent) {
        setIntent(intent);
        if (isDifferentUserAccessed()) {
            onDifferentUserAccessed();
            recreateActivity();
        } else {
            this.navigateOnResume = true;
        }
    }

    @Override // com.box.android.base.presentation.activities.BoxFragmentActivity
    protected boolean onDifferentUserAccessed() {
        cleanActivity();
        return true;
    }

    private final void cleanActivity() {
        this.adminSettingsTask = null;
        onCleanedCompleted();
    }

    private final void onCleanedCompleted() {
        if (!isDifferentUserAccessed() || this.mUserContextManager.isSwitchingToNewUser()) {
            return;
        }
        setActivityUserId(this.mUserContextManager.getCurrentContextId());
        try {
            getIntent().putExtra(IntentConstants.EXTRA_INIT_FOLDER_ID, "0");
            if (hasAuthentication()) {
                onBoxInitialize(null);
                onBoxResume();
            } else {
                finish();
            }
        } catch (Exception unused) {
            finish();
        }
    }

    private final void recreateActivity() {
        getViewModelStore().clear();
        recreate();
    }

    private final void refreshUserSettingsIfNecessary(boolean forceRefresh) {
        BoxFutureTask<BoxAdminSettingsMessage> boxFutureTask;
        boolean z = this.mUserContextManager.getUserInfo() == null || getBoxAdminSettingsProvider().shouldUpdateAdminSettings();
        BoxFutureTask<BoxAdminSettingsMessage> boxFutureTask2 = this.adminSettingsTask;
        if (boxFutureTask2 == null || boxFutureTask2.isDone() || (boxFutureTask = this.adminSettingsTask) == null || boxFutureTask.isCancelled()) {
            if (forceRefresh) {
                BoxAccountManager.migrateAdminSettings(getUserSharedPrefs());
                this.adminSettingsTask = getAdminSettingsModelController().getAdminSettingsRemote();
            } else {
                this.adminSettingsTask = getAdminSettingsModelController().getAdminSettingsIfNeeded();
            }
            if (z || forceRefresh) {
                IBaseModelController iBaseModelController = this.mBaseMoco;
                BoxRequestsUser.GetUserInfo userInfoRequest = getBoxApiUser().getUserInfoRequest(this.mUserContextManager.getCurrentContextId());
                String[] strArr = BoxAuthentication.MINIMUM_USER_FIELDS;
                BoxRequestsUser.GetUserInfo fields = userInfoRequest.setFields((String[]) Arrays.copyOf(strArr, strArr.length));
                Intrinsics.checkNotNullExpressionValue(fields, "setFields(...)");
                iBaseModelController.performRemote(fields);
                IBaseModelController iBaseModelController2 = this.mBaseMoco;
                BoxRequestGetFeatures featuresRequest = this.mBoxApiPrivate.getFeaturesRequest();
                Intrinsics.checkNotNullExpressionValue(featuresRequest, "getFeaturesRequest(...)");
                iBaseModelController2.performRemote(featuresRequest).addOnCompletedListener(new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.navigationmodernization.MainBaseActivity$$ExternalSyntheticLambda2
                    @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
                    public final void onCompleted(BoxResponse boxResponse) {
                        MainBaseActivity.refreshUserSettingsIfNecessary$lambda$0(this.f$0, boxResponse);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void refreshUserSettingsIfNecessary$lambda$0(MainBaseActivity mainBaseActivity, BoxResponse boxResponse) {
        if (boxResponse.isSuccess()) {
            boolean zHasAutoContentUpload = ((BoxFeatures) boxResponse.getResult()).hasAutoContentUpload();
            IUserContextManager mUserContextManager = mainBaseActivity.mUserContextManager;
            Intrinsics.checkNotNullExpressionValue(mUserContextManager, "mUserContextManager");
            AutoUploadUtils.setAutoContentUploadFeatureAvailable(zHasAutoContentUpload, mUserContextManager);
        }
    }

    private final void runAutoContentUpload() {
        if (this.mUserContextManager.getCurrentContext() != null) {
            IUserContextComponent userContextComponent = this.mUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_AUTO_CONTENT_UPLOAD_INFORMATION);
            Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.localrepo.LocalAutoContentUploadInformation");
            LocalAutoContentUploadInformation localAutoContentUploadInformation = (LocalAutoContentUploadInformation) userContextComponent;
            if (localAutoContentUploadInformation.isSyncEnabled()) {
                AutoUploadWorkerDispatcher.INSTANCE.setupAutoUpload(localAutoContentUploadInformation, getLocalItemService());
            }
        }
    }
}
