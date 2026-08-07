package com.box.android.coreservices.jobmanager.jobs;

import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.android.coreservices.jobmanager.tasks.OfflinePreviewTask;
import com.box.android.coreservices.jobmanager.tasks.OfflineTask;
import com.box.android.coreservices.jobmanager.tasks.PrepareOfflineTask;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import com.box.android.coreservices.services.NotificationServices;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.domain.identity.IExecutorPool;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.item.FileModelKt;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSharedLinkSession;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes9.dex */
public class OfflineBoxJob extends BoxItemTransferJob {
    public static final String TRY_DOWNLOAD_ORIGINAL = "mTryDownloadOriginal";
    public static final String TYPE = "offlineJob";
    protected transient boolean mShouldShowErrorDialog;

    public OfflineBoxJob() {
    }

    public OfflineBoxJob(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJobCollection boxJobCollection, BoxItem boxItem, boolean z, NotificationServices notificationServices) {
        super(TYPE, moCoContainer, boxJobCollection, boxItem);
        long jCurrentTimeMillis = System.currentTimeMillis();
        setTryDownloadOriginal(z);
        this.mShouldShowErrorDialog = false;
        BoxSharedLinkSession boxSharedLinkSession = (BoxSharedLinkSession) this.mMoCoContainer.getUserContextManager().getBoxSession(ApplicationProvider.getApplication());
        String sharedLink = boxSharedLinkSession.getSharedLink();
        String password = boxSharedLinkSession.getPassword();
        List<BoxTask> arrayList = new ArrayList<>(1);
        if (boxItem instanceof BoxFile) {
            if (SupportedFileExtensions.INSTANCE.isBoxNoteExtension(CommonBoxUtil.getFileExtension(boxItem.getName(), ""))) {
                notificationServices.displayToast(R.string.box_notes_cannot_be_saved_offline, ApplicationProvider.application);
            } else if (hasOffliningPermission(boxItem)) {
                BoxModelOfflineManager.setFileOfflineUserSavedBlocking((BoxFile) boxItem, true, moCoContainer.getUserContextManager());
            }
            addApplicableTasks((BoxFile) boxItem, arrayList, sharedLink, password);
        } else if (boxItem instanceof BoxFolder) {
            BoxFolder boxFolder = (BoxFolder) boxItem;
            PrepareOfflineTask prepareOfflineTask = new PrepareOfflineTask(moCoContainer, this, boxFolder);
            prepareOfflineTask.setSharedLink(sharedLink);
            prepareOfflineTask.setSharedLinkPassword(password);
            prepareOfflineTask.saveToLevelDB();
            arrayList.add(prepareOfflineTask);
            if (hasOffliningPermission(boxFolder)) {
                BoxModelOfflineManager.setFolderOfflineSavedStartedBlocking(boxFolder, true, jCurrentTimeMillis, moCoContainer.getUserContextManager());
            }
        }
        addTasks(arrayList);
    }

    private boolean hasOffliningPermission(BoxItem boxItem) {
        return boxItem == null || boxItem.getPermissions().contains(BoxItem.Permission.CAN_DOWNLOAD) || isPreviewOnlyOffliningEnabled();
    }

    public boolean getTryDownloadOriginal() {
        return ((Boolean) this.mProperties.get(TRY_DOWNLOAD_ORIGINAL)).booleanValue();
    }

    public void setTryDownloadOriginal(boolean z) {
        this.mProperties.put(TRY_DOWNLOAD_ORIGINAL, Boolean.valueOf(z));
    }

    @Override // com.box.android.coreservices.jobmanager.jobs.BoxItemJob, com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.JobItem, com.box.android.coreservices.jobmanager.JobItemJsonEntity, com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals(TRY_DOWNLOAD_ORIGINAL)) {
            setTryDownloadOriginal(value.asBoolean());
        } else {
            super.parseJSONMember(member);
        }
    }

    public void addApplicableTasks(BoxFile boxFile, List<BoxTask> list, String str, String str2) {
        if (isWatermarkedVideo(boxFile)) {
            BoxModelOfflineManager.setFileOfflineUserSavedBlocking(boxFile, false, this.mMoCoContainer.getUserContextManager());
            this.mShouldShowErrorDialog = true;
            return;
        }
        if (SupportedFileExtensions.INSTANCE.isBoxNoteExtension(CommonBoxUtil.getFileExtension(boxFile.getName(), ""))) {
            BoxModelOfflineManager.setFileOfflineUserSavedBlocking(boxFile, false, this.mMoCoContainer.getUserContextManager());
            this.mShouldShowErrorDialog = true;
            return;
        }
        if (!CoreServiceUtils.canOfflineFile(boxFile, this.mMoCoContainer.getUserContextManager().getUserSharedPrefs())) {
            this.mShouldShowErrorDialog = true;
        }
        if (shouldDownloadOriginal(boxFile)) {
            OfflineTask offlineTask = new OfflineTask(this.mMoCoContainer, this, boxFile, true);
            offlineTask.setSharedLink(str);
            offlineTask.setSharedLinkPassword(str2);
            offlineTask.saveToLevelDB();
            list.add(offlineTask);
        }
        if (shouldDownloadPreview(boxFile)) {
            OfflinePreviewTask offlinePreviewTask = new OfflinePreviewTask(this.mMoCoContainer, this, boxFile, true);
            offlinePreviewTask.setSharedLink(str);
            offlinePreviewTask.setSharedLinkPassword(str2);
            offlinePreviewTask.saveToLevelDB();
            list.add(offlinePreviewTask);
        }
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
    public void onError(ProgressReporter progressReporter, Exception exc) {
        if (exc instanceof BoxException) {
            BoxException boxException = (BoxException) exc;
            if (boxException.getAsBoxError() != null && boxException.getAsBoxError().getStatus().intValue() == 202) {
                scheduleTaskForExecution((BoxTask) progressReporter);
                return;
            }
        }
        super.onError(progressReporter, exc);
    }

    public boolean shouldDownloadPreview(BoxFile boxFile) {
        return SupportedFileExtensions.INSTANCE.isSupportedExtension(CommonBoxUtil.getFileExtension(boxFile.getName(), ""));
    }

    public boolean isWatermarkedVideo(BoxFile boxFile) {
        return FileModelKt.isWatermarkedVideo(FileModelMapper.INSTANCE.toFileModel(boxFile, false));
    }

    public boolean shouldDownloadOriginal(BoxFile boxFile) {
        return (getTryDownloadOriginal() || !SupportedFileExtensions.INSTANCE.isSupportedExtension(CommonBoxUtil.getFileExtension(boxFile.getName(), ""))) && !(!boxFile.getPermissions().contains(BoxItem.Permission.CAN_DOWNLOAD) && shouldDownloadPreview(boxFile));
    }

    protected boolean isPreviewOnlyOffliningEnabled() {
        return BoxAccountManager.isMobilePreviewOnlyOffliningEnabled(this.mMoCoContainer.getUserContextManager().getUserSharedPrefs());
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    protected void reportStarted(ProgressReporter progressReporter) {
        MoCoContainerBuilder.MoCoContainer moCoContainer = this.mMoCoContainer;
        this.mMoCoContainer.broadcastJobStatus(MoCoContainerBuilder.MoCoContainer.createStatusMessage(this, getBoxItem()));
        super.reportStarted(progressReporter);
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
    public void onCompleted(ProgressReporter progressReporter) {
        if (!hasError() && this.mCompletedJobItems.size() == getChildJobItems().size() - 1) {
            if (getBoxItem() instanceof BoxFolder) {
                BoxModelOfflineManager.setFolderOfflineSavedCompletedBlocking((BoxFolder) getBoxItem(), true, this.mMoCoContainer.getUserContextManager());
            } else if (getBoxItem() instanceof BoxFile) {
                BoxModelOfflineManager.setFileOfflineSavedCompletedBlocking((BoxFile) getBoxItem(), true, this.mMoCoContainer.getUserContextManager());
            }
        }
        super.onCompleted(progressReporter);
    }

    @Override // com.box.android.coreservices.jobmanager.jobs.BoxItemTransferJob, com.box.android.coreservices.jobmanager.JobItem
    protected void reportCompleted(ProgressReporter progressReporter) {
        MoCoContainerBuilder.MoCoContainer moCoContainer = this.mMoCoContainer;
        this.mMoCoContainer.broadcastJobStatus(MoCoContainerBuilder.MoCoContainer.createStatusMessage(this, getBoxItem()));
        super.reportCompleted(progressReporter);
    }

    @Override // com.box.android.coreservices.jobmanager.jobs.BoxJob
    protected ThreadPoolExecutor getExecutor(BoxTask boxTask) {
        if (boxTask instanceof OfflinePreviewTask) {
            return ((IExecutorPool) this.mMoCoContainer.getUserContextManager().getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.EXECUTOR_POOL)).getOfflinePreviewExecutor();
        }
        return super.getExecutor(boxTask);
    }

    public boolean shouldShowErrorDialog() {
        return this.mShouldShowErrorDialog;
    }
}
