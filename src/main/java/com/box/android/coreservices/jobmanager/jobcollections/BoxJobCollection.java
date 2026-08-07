package com.box.android.coreservices.jobmanager.jobcollections;

import android.os.Looper;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.jobmanager.JobCollectionList;
import com.box.android.coreservices.jobmanager.JobItemJsonEntity;
import com.box.android.coreservices.jobmanager.JobManager;
import com.box.android.coreservices.jobmanager.ParentJobItem;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxJobCollection extends ParentJobItem {
    public static final String LOCAL_NOTIFICATION_ID = "mLocalNotificationId";
    private transient boolean isCancelled;
    private transient JobCollectionList mJobCollectionList;
    private final transient CopyOnWriteArrayList<BoxJob> mJobs;
    protected transient MoCoContainerBuilder.MoCoContainer mMoCoContainer;

    protected abstract int getCompletedTitleResId();

    protected abstract int getErrorTextResId();

    protected abstract int getInProgressTitleResId();

    public boolean shouldAppearInNotifCenter() {
        return false;
    }

    public boolean shouldDisplayStartTransferToast() {
        return true;
    }

    protected BoxJobCollection() {
        this.mJobs = new CopyOnWriteArrayList<>();
    }

    protected BoxJobCollection(String str, MoCoContainerBuilder.MoCoContainer moCoContainer, JobCollectionList jobCollectionList) {
        super(str, JobManager.generateId());
        this.mJobs = new CopyOnWriteArrayList<>();
        init(moCoContainer, jobCollectionList);
    }

    public void init(MoCoContainerBuilder.MoCoContainer moCoContainer, JobCollectionList jobCollectionList) {
        super.init(moCoContainer.getBaseModelController().getKeyValueStore());
        this.mMoCoContainer = moCoContainer;
        this.mJobCollectionList = jobCollectionList;
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public String getTitle() {
        if (!getJobs().isEmpty() && (getJobs().get(0) instanceof BoxItemJob)) {
            String title = getJobs().get(0).getTitle();
            int size = getJobs().size() - 1;
            return String.format(CommonBoxUtil.plural(isSuccessfullyCompleted() ? getCompletedTitleResId() : getInProgressTitleResId(), size), title, Integer.valueOf(size));
        }
        return "";
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem
    public boolean isRetrying() {
        Iterator<BoxJob> it = getJobs().iterator();
        while (it.hasNext()) {
            if (it.next().isRetrying()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public String getErrorText() {
        return CommonBoxUtil.pluralFormat(getErrorTextResId(), this.mFailedJobItems.size());
    }

    public int getLocalNotificationId() {
        return ((Integer) this.mProperties.get(LOCAL_NOTIFICATION_ID)).intValue();
    }

    public void setLocalNotificationId(int i) {
        this.mProperties.put(LOCAL_NOTIFICATION_ID, Integer.valueOf(i));
    }

    public void addJobs(List<BoxJob> list) {
        addJobs(list, true);
    }

    public void addJobs(List<BoxJob> list, boolean z) {
        for (BoxJob boxJob : list) {
            this.mJobs.add(boxJob);
            boxJob.init(this.mMoCoContainer, this);
            addListenerToChild(boxJob);
        }
        if (z) {
            addJobIds(list);
            saveToLevelDB();
        } else {
            addChildren(list);
        }
    }

    public List<BoxJob> getJobs() {
        return this.mJobs;
    }

    public BoxJob getJob(String str) {
        for (BoxJob boxJob : this.mJobs) {
            if (boxJob.getId().equals(str)) {
                return boxJob;
            }
        }
        return null;
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter
    public ProgressReporter.ProgressType[] getSupportedProgressTypes() {
        return new ProgressReporter.ProgressType[]{ProgressReporter.ProgressType.NUM_TASKS, ProgressReporter.ProgressType.BYTES, ProgressReporter.ProgressType.PERCENTAGE};
    }

    public void addJobIds(List<BoxJob> list) {
        addChildTypedIds(list);
    }

    public List<JobItemJsonEntity.TypedId> getJobTypedIds() {
        return getChildTypedIds();
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem
    public List<BoxJob> getChildJobItems() {
        return this.mJobs;
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.JobItem
    public void cancel() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            BoxLogUtils.i("BoxJobCollection.cancel", "cancel from main thread");
        }
        this.isCancelled = true;
        this.mJobCollectionList.removeJobCollection(this);
        super.cancel();
    }

    public void removeJob(BoxJob boxJob) {
        removeChildJobItem(boxJob);
        if (this.mJobs.isEmpty()) {
            cancel();
        } else {
            if (this.isCancelled) {
                return;
            }
            saveToLevelDB();
        }
    }

    @Override // com.box.android.coreservices.jobmanager.ParentJobItem, com.box.android.coreservices.jobmanager.JobItem, com.box.android.coreservices.jobmanager.JobItemJsonEntity, com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals(LOCAL_NOTIFICATION_ID)) {
            setLocalNotificationId(value.asInt());
        } else {
            super.parseJSONMember(member);
        }
    }

    public boolean shouldAutoClear() {
        return !shouldAppearInNotifCenter();
    }

    public boolean shouldDisplayCompleteTransferToast() {
        return hasError();
    }
}
