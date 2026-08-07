package com.box.android.coreservices.jobmanager.jobs;

import android.content.res.Resources;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.R;
import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobcollections.BoxJobCollection;
import com.box.android.coreservices.jobmanager.tasks.BoxRetryWorker;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxItemJob extends BoxJob implements JobItem.BoxItemJobItem {
    public static final String BOX_ITEM_ID = "mBoxItemId";
    public static final String BOX_NUM_AUTOMATIC_RETRY = "mAutoNumTries";
    public static final String BOX_NUM_TRIES = "mNumTries";
    public static final String BOX_TRIGGERED_AT = "mTriggeredAt";
    public static final String COLLECTION_ID = "collectionId";
    public static final int MAX_TRIES = 4;
    public static final String RESOURCE_TYPE = "mResourceType";
    public static final String WORKMANAGER_TAG_RETRY = "BoxItemJob";
    private transient BoxItem mBoxItem;

    public boolean canRetryJobOnFailure() {
        return false;
    }

    protected BoxItemJob(String str, MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJobCollection boxJobCollection, BoxItem boxItem) {
        super(str, JobManager.generateId(), moCoContainer, boxJobCollection);
        if (boxItem != null) {
            this.mBoxItem = boxItem;
            setBoxItemId(boxItem.getUserId());
            setResourceType(boxItem.getType());
        }
        setNumTries(0);
        setAutoNumTries(0);
        setTriggeredAtTime(-1L);
    }

    @Override // com.box.android.coreservices.jobmanager.jobs.BoxJob
    public void init(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJobCollection boxJobCollection) {
        super.init(moCoContainer, boxJobCollection);
        if (this.mBoxItem == null && StringUtils.isNotBlank(getBoxItemId())) {
            try {
                if (getResourceType().equalsIgnoreCase("file")) {
                    this.mBoxItem = (BoxItem) moCoContainer.getBaseModelController().performLocal(moCoContainer.getFileApi().getInfoRequest(getBoxItemId()), null).get().getResult();
                } else if (getResourceType().equalsIgnoreCase("folder")) {
                    this.mBoxItem = (BoxItem) moCoContainer.getBaseModelController().performLocal(moCoContainer.getFolderApi().getInfoRequest(getBoxItemId()), null).get().getResult();
                } else if (getResourceType().equalsIgnoreCase(BoxBookmark.TYPE)) {
                    this.mBoxItem = (BoxItem) moCoContainer.getBaseModelController().performLocal(moCoContainer.getWeblinkApi().getInfoRequest(getBoxItemId()), null).get().getResult();
                }
            } catch (InterruptedException e) {
                BoxLogUtils.logException(e);
                Thread.currentThread().interrupt();
            } catch (ExecutionException e2) {
                BoxLogUtils.logException(e2);
            }
        }
    }

    protected BoxItemJob() {
    }

    public String getBoxItemId() {
        return (String) this.mProperties.get(BOX_ITEM_ID);
    }

    public void setBoxItemId(String str) {
        this.mProperties.put(BOX_ITEM_ID, str);
    }

    public void setNumTries(int i) {
        this.mProperties.put(BOX_NUM_TRIES, Integer.valueOf(i));
    }

    public int getNumTries() {
        return ((Integer) this.mProperties.get(BOX_NUM_TRIES)).intValue();
    }

    public void setAutoNumTries(int i) {
        this.mProperties.put(BOX_NUM_AUTOMATIC_RETRY, Integer.valueOf(i));
    }

    public int getAutoNumTries() {
        return ((Integer) this.mProperties.getOrDefault(BOX_NUM_AUTOMATIC_RETRY, 0)).intValue();
    }

    public void setTriggeredAtTime(long j) {
        this.mProperties.put(BOX_TRIGGERED_AT, Long.valueOf(j));
    }

    public long getTriggeredAtTime() {
        return ((Long) this.mProperties.get(BOX_TRIGGERED_AT)).longValue();
    }

    public String getResourceType() {
        return (String) this.mProperties.get(RESOURCE_TYPE);
    }

    public void setResourceType(String str) {
        this.mProperties.put(RESOURCE_TYPE, str);
    }

    public void incrementNumTries() {
        setNumTries(getNumTries() + 1);
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.JobItem, com.box.android.coreservices.jobmanager.JobItemJsonEntity, com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals(BOX_ITEM_ID)) {
            setBoxItemId(value.asString());
            return;
        }
        if (name.equals(RESOURCE_TYPE)) {
            setResourceType(value.asString());
            return;
        }
        if (name.equals(BOX_NUM_TRIES)) {
            setNumTries(value.asInt());
            return;
        }
        if (name.equals(BOX_NUM_AUTOMATIC_RETRY)) {
            setAutoNumTries(value.asInt());
        } else if (name.equals(BOX_TRIGGERED_AT)) {
            setTriggeredAtTime(value.asLong());
        } else {
            super.parseJSONMember(member);
        }
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public String getTitle() {
        BoxItem boxItem = this.mBoxItem;
        if (boxItem == null) {
            return "";
        }
        return boxItem.getName();
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem
    public String getDescription() {
        if (isPaused()) {
            if (getProgress(ProgressReporter.ProgressType.PERCENTAGE) == -4) {
                return CommonBoxUtil.LS(R.string.Pausing_dot_dot_dot);
            }
            return CommonBoxUtil.LS(R.string.Paused);
        }
        JobItem.JobItemState currentState = getCurrentState();
        if (currentState == JobItem.JobItemState.QUEUED) {
            return CommonBoxUtil.LS(R.string.Queued);
        }
        if (currentState == JobItem.JobItemState.COMPLETED) {
            return CommonBoxUtil.LS(R.string.Done);
        }
        return getInProgressDescription();
    }

    private String getInProgressDescription() {
        long progress = getProgress(ProgressReporter.ProgressType.PERCENTAGE);
        if (progress == 100) {
            return CommonBoxUtil.LS(R.string.Done);
        }
        Resources resources = ApplicationProvider.getApplication().getResources();
        int i = R.string.x_percentage;
        if (progress < 0) {
            progress = 0;
        }
        return resources.getString(i, Long.valueOf(progress), "%");
    }

    protected String getErrorString(JobItem.JobItemState jobItemState) {
        if (this.mFailedJobItems.size() > 1 || (this.mFailedJobItems.size() == 1 && jobItemState == JobItem.JobItemState.EXECUTING)) {
            if (isRetrying()) {
                return ApplicationProvider.getApplication().getResources().getString(R.string.job_interrupted_retrying);
            }
            return CommonBoxUtil.pluralFormat(R.array.N_errors, this.mFailedJobItems.size());
        }
        if (this.mFailedJobItems.size() == 1) {
            if (isRetrying()) {
                return ApplicationProvider.getApplication().getResources().getString(R.string.job_interrupted_retrying);
            }
            try {
                return ((BoxTask) this.mFailedJobItems.iterator().next()).getErrorText();
            } catch (NoSuchElementException unused) {
                return "";
            }
        }
        return "";
    }

    public int getNumFailedTasks() {
        return this.mFailedJobItems.size();
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem.BoxItemJobItem
    public String getItemId() {
        return getBoxItemId();
    }

    public BoxItem getBoxItem() {
        return this.mBoxItem;
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public String getErrorText() {
        return getErrorString(getCurrentState());
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    protected void reportError(ProgressReporter progressReporter, Exception exc) {
        if (getNumTries() < 4 && canRetryJobOnFailure()) {
            retryJob();
        } else {
            setRetrying(false);
            WorkManager.getInstance(ApplicationProvider.getApplication()).cancelAllWorkByTag(WORKMANAGER_TAG_RETRY);
        }
        super.reportError(progressReporter, exc);
    }

    protected void retryJob() {
        setAutoNumTries(getAutoNumTries() + 1);
        WorkManager.getInstance(ApplicationProvider.getApplication()).enqueue(getWorkRequestWithConstraints(this.mParentJobCollection.getId()));
        setRetrying(true);
    }

    protected boolean hasTransientError(JobItem jobItem) {
        if (!(jobItem instanceof BoxTask)) {
            return false;
        }
        BoxTask boxTask = (BoxTask) jobItem;
        return boxTask.hasError() && JobItem.ErrorType.LOST_CONNECTION == boxTask.getErrorType();
    }

    @Override // com.box.android.coreservices.jobmanager.jobs.BoxJob, com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.JobItem
    public boolean restart(boolean z) {
        if (getNumTries() == 0) {
            setTriggeredAtTime(System.currentTimeMillis());
        }
        if (z) {
            incrementNumTries();
        }
        return super.restart(z);
    }

    private static WorkRequest getWorkRequestWithConstraints(String str) {
        OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder((Class<? extends ListenableWorker>) BoxRetryWorker.class);
        builder.addTag(WORKMANAGER_TAG_RETRY);
        builder.setInitialDelay(10L, TimeUnit.SECONDS);
        Constraints.Builder builder2 = new Constraints.Builder();
        builder2.setRequiredNetworkType(NetworkType.CONNECTED);
        builder.setConstraints(builder2.build());
        Data.Builder builder3 = new Data.Builder();
        builder3.putString(COLLECTION_ID, str);
        builder.setInputData(builder3.build());
        return builder.build();
    }
}
