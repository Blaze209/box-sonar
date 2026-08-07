package com.box.android.coreservices.jobmanager;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.jobmanager.dao.JobManagerMap;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.DeleteBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.ExportBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.OfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobcollections.RemoveOfflineBoxJobCollection;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.android.coreservices.modelcontroller.IMoCoAdminSettings;
import com.box.android.coreservices.modelcontroller.IMoCoBatchOperations;
import com.box.android.coreservices.modelcontroller.IMoCoBoxTransfers;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.coreservices.utilities.JobEnqueuedListener;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponentListener;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.metrics.Gen204MoveCopyEventLogger;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.services.IRemoteItemService;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollaboration;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiWeblink;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes9.dex */
@Singleton
public class JobManager implements IUserContextComponentListener {
    private static final String EXTRA_LAST_SAVED_JOB_MANAGER_VERSION = "com.box.android.lastSavedJobManagerVersion";
    private static final String JOB_MANAGER_CONTEXT_COMPONENT_NAME = "com.box.android.jobManager";
    private static final int MESSAGE_POST_INTERVAL_MILLIS = 400;
    private static final String TAG = "JobManager";
    private static AtomicLong idSalt = new AtomicLong();
    protected BoxExtendedApiCollaboration mApiCollaboration;
    protected BoxApiPrivate mApiPrivate;
    protected IBaseModelController mBaseModelController;
    protected BoxExtendedApiWeblink mBookmarkApi;
    private String mContextId;
    protected BoxExtendedApiFile mFileApi;
    protected BoxExtendedApiFolder mFolderApi;
    private final IntentServices mIntentServices;
    private final IRemoteItemService mItemService;
    protected IMoCoAdminSettings mMoCoAdminSettings;
    protected IMoCoBatchOperations mMoCoBatchOperations;
    protected IMoCoBoxTransfers mMoCoBoxTransfers;
    private final MoCoContainerBuilder.MoCoContainer mMoCoContainer;
    private final Gen204MoveCopyEventLogger mMoveCopyEventLogger;
    private IJobManagerNotificationCenter mNotificationCenter;
    protected NotificationServices mNotificationServices;
    protected IUserContextManager mUserContextManager;
    private JobEnqueuedListener jobEnqueuedListener = null;
    private JobCollectionList mJobCollectionList = new JobCollectionList();
    private final JobManagerMap mJobManagerMap = new JobManagerMap();
    private final HandlerThread MESSAGE_LOOPER = new HandlerThread("JobManagerHandlerThread");
    BytesTrackingProgressReporter mTransfersProgressReporter = new BytesTrackingProgressReporter(OfflineBoxJobCollection.class, ExportBoxJobCollection.class);
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    Handler handler = new Handler(Looper.getMainLooper());
    private final ProgressReporter.JobProgressListener overallProgressListener = new ProgressReporter.JobProgressListener() { // from class: com.box.android.coreservices.jobmanager.JobManager.2
        @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
        public void onError(ProgressReporter progressReporter, Exception exc) {
        }

        @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
        public void onPaused(ProgressReporter progressReporter) {
        }

        @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
        public void onProgressUpdated(ProgressReporter progressReporter, ProgressReporter.ProgressType progressType, long j, long j2) {
        }

        @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
        public void onStarted(ProgressReporter progressReporter) {
        }

        @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
        public void onCompleted(ProgressReporter progressReporter) {
            if (progressReporter instanceof BoxJobCollection) {
                BoxJobCollection boxJobCollection = (BoxJobCollection) progressReporter;
                if (!boxJobCollection.hasError()) {
                    JobManager.this.mJobManagerMap.removeAllInCollection(boxJobCollection);
                    if (boxJobCollection.shouldDisplayCompleteTransferToast()) {
                        JobManager.this.mNotificationServices.displayToast(boxJobCollection.getTitle(), ApplicationProvider.getApplication().getApplicationContext());
                    }
                    if (boxJobCollection.shouldAutoClear()) {
                        boxJobCollection.cancel();
                        return;
                    }
                    return;
                }
                if (boxJobCollection.shouldDisplayCompleteTransferToast()) {
                    JobManager.this.mNotificationServices.displayToast(boxJobCollection.getErrorText(), ApplicationProvider.getApplication().getApplicationContext());
                }
            }
        }

        @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.JobProgressListener
        public void onTaskAdded(BoxTask boxTask) {
            JobManager.this.mJobManagerMap.put(boxTask);
        }
    };

    public interface JobManagerFilter {
        boolean accept(BoxJobCollection boxJobCollection);

        boolean accept(BoxJob boxJob);

        boolean accept(BoxTask boxTask);
    }

    public void setJobEnqueuedListener(JobEnqueuedListener jobEnqueuedListener) {
        this.jobEnqueuedListener = jobEnqueuedListener;
    }

    public static String generateId() {
        return System.currentTimeMillis() + "_" + idSalt.incrementAndGet();
    }

    @Inject
    public JobManager(IMoCoBoxTransfers iMoCoBoxTransfers, BoxExtendedApiFile boxExtendedApiFile, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiWeblink boxExtendedApiWeblink, IBaseModelController iBaseModelController, IUserContextManager iUserContextManager, IMoCoBatchOperations iMoCoBatchOperations, IMoCoAdminSettings iMoCoAdminSettings, BoxApiPrivate boxApiPrivate, BoxExtendedApiCollaboration boxExtendedApiCollaboration, NotificationServices notificationServices, IRemoteItemService iRemoteItemService, IntentServices intentServices, IJobManagerNotificationCenter iJobManagerNotificationCenter, Gen204MoveCopyEventLogger gen204MoveCopyEventLogger) {
        this.mMoCoBoxTransfers = iMoCoBoxTransfers;
        this.mFileApi = boxExtendedApiFile;
        this.mFolderApi = boxExtendedApiFolder;
        this.mBookmarkApi = boxExtendedApiWeblink;
        this.mBaseModelController = iBaseModelController;
        this.mUserContextManager = iUserContextManager;
        this.mMoCoBatchOperations = iMoCoBatchOperations;
        this.mMoCoAdminSettings = iMoCoAdminSettings;
        this.mApiCollaboration = boxExtendedApiCollaboration;
        this.mNotificationServices = notificationServices;
        this.mMoCoContainer = new MoCoContainerBuilder().setFileApi(this.mFileApi).setMocoTransfers(this.mMoCoBoxTransfers).setFolderApi(this.mFolderApi).setBookmarkApi(this.mBookmarkApi).setMocoBatchOperations(this.mMoCoBatchOperations).setBaseModelController(this.mBaseModelController).setContextManager(this.mUserContextManager).setMoCoAdminSettings(this.mMoCoAdminSettings).setPrivateApi(this.mApiPrivate).setCollabApi(this.mApiCollaboration).setMessageHandler(createMessageHandler()).build();
        this.mItemService = iRemoteItemService;
        this.mIntentServices = intentServices;
        this.mNotificationCenter = iJobManagerNotificationCenter;
        this.mUserContextManager.addUserContextListener(JOB_MANAGER_CONTEXT_COMPONENT_NAME, this);
        this.mMoveCopyEventLogger = gen204MoveCopyEventLogger;
    }

    @Override // com.box.android.domain.identity.IUserContextComponentListener
    public void onCreate(String str) {
        String str2 = this.mContextId;
        if (str2 == null || !str2.equals(str)) {
            this.mContextId = str;
            migrateJobManagerDataIfNeeded(this.mUserContextManager);
            JobCollectionList jobCollectionList = (JobCollectionList) this.mUserContextManager.getCurrentContext().getKVStore().getBoxPersistableObject(this.mUserContextManager.getCurrentContext().getKVStore().keyNamer().getKey(JobItemJsonEntity.SCHEME, JobCollectionList.TYPE, "0"));
            this.mJobCollectionList = jobCollectionList;
            if (jobCollectionList != null) {
                try {
                    jobCollectionList.init(this.mMoCoContainer, this.overallProgressListener, this);
                } catch (Exception e) {
                    BoxLogUtils.logException(TAG, "Cannot init mJobCollectionList, data are corrupted", e);
                    this.mJobCollectionList = null;
                }
            }
            if (this.mJobCollectionList == null) {
                JobCollectionList jobCollectionList2 = new JobCollectionList(this.mMoCoContainer, this.overallProgressListener, this);
                this.mJobCollectionList = jobCollectionList2;
                jobCollectionList2.saveToLevelDB();
            }
            this.mJobCollectionList.setListModifiedListener(getTransfersReporter());
        }
    }

    private Handler createMessageHandler() {
        this.MESSAGE_LOOPER.start();
        return new Handler(this.MESSAGE_LOOPER.getLooper()) { // from class: com.box.android.coreservices.jobmanager.JobManager.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                CoreServiceUtils.broadcastIntent(JobManager.this.mUserContextManager, (BoxMessage) message.obj);
                try {
                    Thread.sleep(400L);
                } catch (InterruptedException e) {
                    BoxLogUtils.e(JobManager.JOB_MANAGER_CONTEXT_COMPONENT_NAME, e);
                    Thread.currentThread().interrupt();
                }
            }
        };
    }

    public BoxJobCollection getJobCollection(String str) {
        for (BoxJobCollection boxJobCollection : getAllJobCollections()) {
            if (boxJobCollection.getId().equals(str)) {
                return boxJobCollection;
            }
        }
        return null;
    }

    public boolean restartCollectionOnFailure(BoxJobCollection boxJobCollection) {
        if (boxJobCollection == null || !boxJobCollection.hasError()) {
            return true;
        }
        if (boxJobCollection.shouldAppearInNotifCenter()) {
            this.mNotificationCenter.addInProgressJobCollection(boxJobCollection);
        }
        return boxJobCollection.restart(true);
    }

    public void offlineItems(Collection<BoxItem> collection, boolean z) {
        addJobCollection(new OfflineBoxJobCollection(this.mMoCoContainer, this.mJobCollectionList, this.mNotificationServices, collection, z));
    }

    public void removeOfflineItems(Collection<BoxItem> collection) {
        addJobCollection(new RemoveOfflineBoxJobCollection(this.mMoCoContainer, this.mJobCollectionList, collection, this));
    }

    public void exportFile(BoxFile boxFile, String str, boolean z) {
        addJobCollection(new ExportBoxJobCollection(this.mMoCoContainer, this.mJobCollectionList, boxFile, this.mIntentServices, this.mNotificationServices, this.mFolderApi, this.mMoCoBoxTransfers, boxFile.getName(), str, z));
    }

    public void exportFile(FileModel fileModel, String str, boolean z) {
        exportFile(FileModelMapper.INSTANCE.toBoxFile(fileModel, false), str, z);
    }

    public void exportItems(Collection<BoxItem> collection, String str) {
        addJobCollection(new ExportBoxJobCollection(this.mMoCoContainer, this.mIntentServices, this.mNotificationServices, this.mFolderApi, this.mMoCoBoxTransfers, this.mJobCollectionList, collection, str));
    }

    public void exportFiles(Collection<FileModel> collection, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator<FileModel> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(FileModelMapper.INSTANCE.toBoxFile(it.next(), false));
        }
        exportItems(arrayList, str);
    }

    public void deleteItem(BoxItem boxItem) {
        deleteItem(boxItem, null);
    }

    public void deleteItem(BoxItem boxItem, ProgressReporter.ProgressListener progressListener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(boxItem);
        deleteItems(arrayList, progressListener);
    }

    public void deleteItems(Collection<BoxItem> collection, ProgressReporter.ProgressListener progressListener) {
        DeleteBoxJobCollection deleteBoxJobCollection = new DeleteBoxJobCollection(this.mMoCoContainer, this.mJobCollectionList, collection, this);
        if (progressListener != null) {
            deleteBoxJobCollection.addProgressListener(progressListener);
        }
        addJobCollection(deleteBoxJobCollection);
    }

    private void addJobCollection(BoxJobCollection boxJobCollection) {
        addJobCollection(boxJobCollection, true);
        JobEnqueuedListener jobEnqueuedListener = this.jobEnqueuedListener;
        if (jobEnqueuedListener != null) {
            jobEnqueuedListener.reportJobEnqueued(boxJobCollection);
        }
    }

    public void addJobCollection(final BoxJobCollection boxJobCollection, final boolean z) {
        if (this.mJobCollectionList == null) {
            return;
        }
        this.executorService.execute(new Runnable() { // from class: com.box.android.coreservices.jobmanager.JobManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addJobCollection$1(boxJobCollection, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addJobCollection$1(final BoxJobCollection boxJobCollection, final boolean z) {
        this.mJobCollectionList.removeChildJobItem(boxJobCollection);
        this.mJobCollectionList.addJobCollection(boxJobCollection, z);
        this.mJobManagerMap.addAllTasksInCollection(boxJobCollection);
        if (!boxJobCollection.isSuccessfullyCompleted()) {
            if (this.mNotificationCenter != null && boxJobCollection.shouldAppearInNotifCenter()) {
                this.mNotificationCenter.addInProgressJobCollection(boxJobCollection);
            }
            if (z) {
                boxJobCollection.restart(false);
                if (boxJobCollection.shouldDisplayStartTransferToast()) {
                    this.mNotificationServices.displayToast(boxJobCollection.getTitle(), ApplicationProvider.getApplication().getApplicationContext());
                }
            } else if (boxJobCollection.getCurrentState() != JobItem.JobItemState.COMPLETED) {
                boxJobCollection.pause();
            }
        }
        this.handler.post(new Runnable() { // from class: com.box.android.coreservices.jobmanager.JobManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$addJobCollection$0(boxJobCollection, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addJobCollection$0(BoxJobCollection boxJobCollection, boolean z) {
        if (boxJobCollection.isSuccessfullyCompleted() && z) {
            this.overallProgressListener.onCompleted(boxJobCollection);
        }
    }

    public List<BoxJobCollection> getAllJobCollections() {
        JobCollectionList jobCollectionList = this.mJobCollectionList;
        return jobCollectionList == null ? new ArrayList() : jobCollectionList.getChildJobItems();
    }

    public JobCollectionList getJobCollectionList() {
        return this.mJobCollectionList;
    }

    public void filter(JobManagerFilter jobManagerFilter) {
        for (BoxJobCollection boxJobCollection : getAllJobCollections()) {
            if (jobManagerFilter.accept(boxJobCollection)) {
                for (BoxJob boxJob : boxJobCollection.getChildJobItems()) {
                    if (jobManagerFilter.accept(boxJob)) {
                        Iterator<BoxTask> it = boxJob.getChildJobItems().iterator();
                        while (it.hasNext()) {
                            jobManagerFilter.accept(it.next());
                        }
                    }
                }
            }
        }
    }

    public JobManagerMap getJobManagerMap() {
        return this.mJobManagerMap;
    }

    @Override // com.box.android.domain.identity.IUserContextComponentListener
    public void onSoftDestroy() {
        cleanup();
    }

    @Override // com.box.android.domain.identity.IUserContextComponentListener
    public void onHardDestroy() {
        cleanup();
    }

    private void cleanup() {
        JobCollectionList jobCollectionList = this.mJobCollectionList;
        if (jobCollectionList != null) {
            for (BoxJobCollection boxJobCollection : jobCollectionList.getJobCollections()) {
                if (boxJobCollection.getCurrentState() == JobItem.JobItemState.EXECUTING || boxJobCollection.getCurrentState() == JobItem.JobItemState.QUEUED) {
                    boxJobCollection.pause();
                }
            }
        }
        IJobManagerNotificationCenter iJobManagerNotificationCenter = this.mNotificationCenter;
        if (iJobManagerNotificationCenter != null) {
            iJobManagerNotificationCenter.shutdown();
            this.mNotificationCenter = null;
        }
        this.mJobCollectionList = null;
        this.mTransfersProgressReporter.onCollectionsCleared();
        this.mContextId = null;
        this.mJobManagerMap.clear();
    }

    public BytesTrackingProgressReporter getTransfersReporter() {
        return this.mTransfersProgressReporter;
    }

    public void migrateJobManagerDataIfNeeded(IUserContextManager iUserContextManager) {
        SharedPreferences sharedPreferences = ((ILocalSharedPreferences) iUserContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_SHARED_PREFERENCES)).getSharedPreferences();
        if (sharedPreferences.getInt(EXTRA_LAST_SAVED_JOB_MANAGER_VERSION, 0) < CommonBoxUtil.getCurrentVersionNumber()) {
            iUserContextManager.getCurrentContext().getKVStore().clearAllByScheme(JobItemJsonEntity.SCHEME);
            sharedPreferences.edit().putInt(EXTRA_LAST_SAVED_JOB_MANAGER_VERSION, CommonBoxUtil.getCurrentVersionNumber()).apply();
        }
    }

    public static class BytesTrackingProgressReporter extends ParentJobItem implements JobCollectionList.ListModifiedListener {
        private final transient CopyOnWriteArrayList<BoxJobCollection> mJobCollections = new CopyOnWriteArrayList<>();
        final HashSet<Class> mAcceptedCollections = new HashSet<>();

        @Override // com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.JobItemJsonEntity
        @Deprecated
        public void deleteFromLevelDB() {
        }

        @Override // com.box.android.coreservices.jobmanager.ParentJobItem
        @Deprecated
        public String getDescription() {
            return null;
        }

        @Override // com.box.android.coreservices.jobmanager.JobItem
        @Deprecated
        public String getErrorText() {
            return null;
        }

        @Override // com.box.android.coreservices.jobmanager.JobItem
        @Deprecated
        public String getTitle() {
            return null;
        }

        @Override // com.box.android.coreservices.jobmanager.JobItemJsonEntity
        @Deprecated
        public void saveToLevelDB() {
        }

        public BytesTrackingProgressReporter(Class... clsArr) {
            for (Class cls : clsArr) {
                this.mAcceptedCollections.add(cls);
            }
        }

        protected void addJobCollection(BoxJobCollection boxJobCollection) {
            if ((this.mAcceptedCollections.size() <= 0 || this.mAcceptedCollections.contains(boxJobCollection.getClass())) && !boxJobCollection.isSuccessfullyCompleted()) {
                for (ProgressReporter.ProgressType progressType : boxJobCollection.getSupportedProgressTypes()) {
                    if (progressType.equals(ProgressReporter.ProgressType.BYTES)) {
                        this.mJobCollections.add(boxJobCollection);
                        addListenerToChild(boxJobCollection);
                        addChild(boxJobCollection);
                        return;
                    }
                }
            }
        }

        @Override // com.box.android.coreservices.jobmanager.JobItem
        @Deprecated
        public JobItem.ErrorType getErrorType() {
            return super.getErrorType();
        }

        @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter
        public ProgressReporter.ProgressType[] getSupportedProgressTypes() {
            return new ProgressReporter.ProgressType[]{ProgressReporter.ProgressType.BYTES, ProgressReporter.ProgressType.PERCENTAGE};
        }

        @Override // com.box.android.coreservices.jobmanager.ParentJobItem
        public List<? extends JobItem> getChildJobItems() {
            return this.mJobCollections;
        }

        @Override // com.box.android.coreservices.jobmanager.ParentJobItem
        protected void updateProgress(ProgressReporter progressReporter, ProgressReporter.ProgressType progressType, long j, long j2) {
            super.updateProgress(progressReporter, progressType, j, j2);
        }

        @Override // com.box.android.coreservices.jobmanager.JobCollectionList.ListModifiedListener
        public void onCollectionAdded(BoxJobCollection boxJobCollection) {
            if (this.mAcceptedCollections.size() <= 0 || this.mAcceptedCollections.contains(boxJobCollection.getClass())) {
                removeChildJobItem(boxJobCollection);
                addJobCollection(boxJobCollection);
            }
        }

        @Override // com.box.android.coreservices.jobmanager.JobCollectionList.ListModifiedListener
        public void onCollectionRemoved(BoxJobCollection boxJobCollection) {
            removeChildJobItem(boxJobCollection);
        }

        @Override // com.box.android.coreservices.jobmanager.JobCollectionList.ListModifiedListener
        public void onCollectionsCleared() {
            this.mAcceptedCollections.clear();
        }

        @Override // com.box.android.coreservices.jobmanager.JobCollectionList.ListModifiedListener
        public void onCollectionError(BoxJobCollection boxJobCollection) {
            reportError(boxJobCollection, null);
        }

        public boolean isInProgress() {
            for (JobItem jobItem : getChildJobItems()) {
                if (jobItem.getCurrentState() == JobItem.JobItemState.EXECUTING || jobItem.getCurrentState() == JobItem.JobItemState.QUEUED) {
                    return true;
                }
            }
            return false;
        }
    }
}
