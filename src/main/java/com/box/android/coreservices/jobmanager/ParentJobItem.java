package com.box.android.coreservices.jobmanager;

import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.tasks.BoxTask;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes9.dex */
public abstract class ParentJobItem extends JobItem implements ProgressReporter.JobProgressListener {
    public static final String CHILD_TYPED_ID_STRINGS = "mChildTypedIdStrings";
    public static final String IS_CANCELLED = "mIsCancelled";
    public static final String IS_PAUSED = "mIsPaused";
    protected transient Set<JobItem> mCompletedJobItems;
    protected transient Set<JobItem> mExecutingJobItems;
    protected transient Set<JobItem> mFailedJobItems;
    private transient boolean mRetrying;
    private transient long[] max;
    private transient long[] progress;

    public abstract List<? extends JobItem> getChildJobItems();

    public abstract String getDescription();

    protected ParentJobItem() {
        this.mExecutingJobItems = new HashSet();
        this.mFailedJobItems = new HashSet();
        this.mCompletedJobItems = new HashSet();
        this.progress = new long[ProgressReporter.ProgressType.values().length];
        this.max = new long[ProgressReporter.ProgressType.values().length];
        this.mRetrying = false;
        initializeProgress();
    }

    protected ParentJobItem(String str, String str2) {
        super(str, str2);
        this.mExecutingJobItems = new HashSet();
        this.mFailedJobItems = new HashSet();
        this.mCompletedJobItems = new HashSet();
        this.progress = new long[ProgressReporter.ProgressType.values().length];
        this.max = new long[ProgressReporter.ProgressType.values().length];
        this.mRetrying = false;
        initializeProgress();
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
    public void onStarted(ProgressReporter progressReporter) {
        JobItem.JobItemState currentState = getCurrentState();
        if (progressReporter instanceof JobItem) {
            this.mExecutingJobItems.add((JobItem) progressReporter);
            this.mCompletedJobItems.remove(progressReporter);
        }
        if (currentState != JobItem.JobItemState.EXECUTING) {
            reportStarted(progressReporter);
        }
    }

    private void initializeProgress() {
        int i = 0;
        while (true) {
            long[] jArr = this.max;
            if (i >= jArr.length) {
                return;
            }
            this.progress[i] = -1;
            jArr[i] = -1;
            i++;
        }
    }

    protected void addListenerToChild(JobItem jobItem) {
        jobItem.addProgressListener(this);
        initProgress(jobItem);
        addChild(jobItem);
    }

    public void setRetrying(boolean z) {
        this.mRetrying = z;
    }

    public boolean isRetrying() {
        return this.mRetrying;
    }

    protected void initProgress(JobItem jobItem) {
        JobItem jobItem2 = jobItem;
        int length = ProgressReporter.ProgressType.values().length;
        boolean[] zArr = new boolean[length];
        ProgressReporter.ProgressType[] supportedProgressTypes = jobItem2.getSupportedProgressTypes();
        int length2 = supportedProgressTypes.length;
        int i = 0;
        while (i < length2) {
            ProgressReporter.ProgressType progressType = supportedProgressTypes[i];
            long max = jobItem2.getMax(progressType);
            long progress = jobItem2.getProgress(progressType);
            updateProgress(jobItem2, progressType, progress, max);
            if (progress != -1) {
                zArr[progressType.ordinal()] = true;
            }
            i++;
            jobItem2 = jobItem;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (zArr[i2]) {
                this.max[i2] = -1;
            }
        }
        this.max[ProgressReporter.ProgressType.PERCENTAGE.ordinal()] = 100;
    }

    public List<String> getChildTypedIdStrings() {
        if (this.mProperties.get(CHILD_TYPED_ID_STRINGS) == null) {
            setChildTypedIdStrings(new CopyOnWriteArrayList());
        }
        return (List) this.mProperties.get(CHILD_TYPED_ID_STRINGS);
    }

    public void setChildTypedIdStrings(List<String> list) {
        this.mProperties.put(CHILD_TYPED_ID_STRINGS, list);
    }

    public boolean isPaused() {
        if (this.mProperties.get(IS_PAUSED) != null) {
            return ((Boolean) this.mProperties.get(IS_PAUSED)).booleanValue();
        }
        return false;
    }

    public void setIsPaused(boolean z) {
        this.mProperties.put(IS_PAUSED, Boolean.valueOf(z));
    }

    public boolean isCancelled() {
        if (this.mProperties.get(IS_CANCELLED) != null) {
            return ((Boolean) this.mProperties.get(IS_CANCELLED)).booleanValue();
        }
        return false;
    }

    public void setIsCancelled(boolean z) {
        this.mProperties.put(IS_CANCELLED, Boolean.valueOf(z));
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem, com.box.android.coreservices.jobmanager.JobItemJsonEntity, com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals(CHILD_TYPED_ID_STRINGS)) {
            ArrayList arrayList = new ArrayList();
            Iterator<JsonValue> it = value.asArray().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().asString());
            }
            setChildTypedIdStrings(arrayList);
            return;
        }
        if (name.equals(IS_PAUSED)) {
            setIsPaused(value.asBoolean());
        } else if (name.equals(IS_CANCELLED)) {
            setIsCancelled(value.asBoolean());
        } else {
            super.parseJSONMember(member);
        }
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
    public void onCompleted(ProgressReporter progressReporter) {
        JobItem.JobItemState currentState = getCurrentState();
        if (progressReporter instanceof JobItem) {
            JobItem jobItem = (JobItem) progressReporter;
            this.mExecutingJobItems.remove(jobItem);
            this.mCompletedJobItems.add(jobItem);
            if (!jobItem.hasError()) {
                this.mFailedJobItems.remove(jobItem);
            }
        }
        if (currentState != JobItem.JobItemState.COMPLETED && getCurrentState() == JobItem.JobItemState.COMPLETED) {
            reportCompleted(progressReporter);
        }
        if (isFullyPaused()) {
            if (this.mExecutingJobItems.size() < 1 && this.mFailedJobItems.size() < 1) {
                reportCompleted(progressReporter);
            } else {
                reportPaused(progressReporter);
            }
        }
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
    public void onError(ProgressReporter progressReporter, Exception exc) {
        JobItem.JobItemState currentState = getCurrentState();
        if (progressReporter instanceof JobItem) {
            this.mExecutingJobItems.remove(progressReporter);
            if (exc != null && !(exc instanceof InterruptedException) && !(exc.getCause() instanceof InterruptedException)) {
                JobItem jobItem = (JobItem) progressReporter;
                this.mFailedJobItems.add(jobItem);
                this.mCompletedJobItems.add(jobItem);
            }
        }
        reportError(progressReporter, exc);
        if (currentState == JobItem.JobItemState.COMPLETED || getCurrentState() != JobItem.JobItemState.COMPLETED) {
            return;
        }
        reportCompleted(progressReporter);
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
    public void onPaused(ProgressReporter progressReporter) {
        this.mExecutingJobItems.remove(progressReporter);
        if (isFullyPaused()) {
            reportPaused(progressReporter);
        }
    }

    private boolean isFullyPaused() {
        return isPaused() && this.mExecutingJobItems.isEmpty();
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.JobProgressListener
    public void onTaskAdded(BoxTask boxTask) {
        reportTaskAdded(boxTask);
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public JobItem.JobItemState getCurrentState() {
        if (isCancelled()) {
            return JobItem.JobItemState.CANCELLED;
        }
        if (this.mExecutingJobItems.size() < 1 && this.mFailedJobItems.size() < 1 && this.mCompletedJobItems.size() == getChildJobItems().size()) {
            return JobItem.JobItemState.COMPLETED;
        }
        if (isPaused()) {
            return JobItem.JobItemState.PAUSED;
        }
        if (!this.mExecutingJobItems.isEmpty()) {
            return JobItem.JobItemState.EXECUTING;
        }
        if (this.mCompletedJobItems.size() == getChildJobItems().size()) {
            return JobItem.JobItemState.COMPLETED;
        }
        return JobItem.JobItemState.QUEUED;
    }

    protected void addChildren(List<? extends JobItem> list) {
        Iterator<? extends JobItem> it = list.iterator();
        while (it.hasNext()) {
            addChild(it.next());
        }
    }

    public void addChild(JobItem jobItem) {
        JobItem.JobItemState currentState = jobItem.getCurrentState();
        if (currentState == JobItem.JobItemState.EXECUTING) {
            this.mExecutingJobItems.add(jobItem);
        } else if (currentState == JobItem.JobItemState.COMPLETED) {
            this.mCompletedJobItems.add(jobItem);
        }
        if (jobItem.hasError()) {
            this.mFailedJobItems.add(jobItem);
        }
    }

    @Override // com.box.android.coreservices.jobmanager.JobItemJsonEntity
    public void deleteFromLevelDB() {
        super.deleteFromLevelDB();
        List<? extends JobItem> childJobItems = getChildJobItems();
        if (childJobItems != null) {
            Iterator<? extends JobItem> it = childJobItems.iterator();
            while (it.hasNext()) {
                it.next().deleteFromLevelDB();
            }
        }
    }

    protected void addChildTypedIds(List<? extends JobItem> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<? extends JobItem> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getTypedId());
        }
        getChildTypedIdStrings().addAll(arrayList);
    }

    protected List<JobItemJsonEntity.TypedId> getChildTypedIds() {
        List<String> childTypedIdStrings = getChildTypedIdStrings();
        ArrayList arrayList = new ArrayList(childTypedIdStrings.size());
        for (String str : childTypedIdStrings) {
            if (str != null) {
                arrayList.add(JobItemJsonEntity.TypedId.splitTypeAndIdFromTypedId(str));
            }
        }
        return arrayList;
    }

    protected void removeChildJobItem(JobItem jobItem) {
        List<? extends JobItem> childJobItems = getChildJobItems();
        if (childJobItems != null) {
            childJobItems.remove(jobItem);
        }
        this.mExecutingJobItems.remove(jobItem);
        this.mFailedJobItems.remove(jobItem);
        this.mCompletedJobItems.remove(jobItem);
        getChildTypedIdStrings().remove(jobItem.getTypedId());
    }

    private boolean childIdsHasNull() {
        Iterator<String> it = getChildTypedIdStrings().iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                return true;
            }
        }
        return false;
    }

    protected void updateProgress(ProgressReporter progressReporter, ProgressReporter.ProgressType progressType, long j, long j2) {
        long max;
        if (progressType == ProgressReporter.ProgressType.PERCENTAGE) {
            return;
        }
        if (j2 != 0) {
            this.max[progressType.ordinal()] = -1;
        }
        if (this.progress[progressType.ordinal()] >= 0) {
            long[] jArr = this.progress;
            int iOrdinal = progressType.ordinal();
            jArr[iOrdinal] = jArr[iOrdinal] + j;
        }
        if (progressType != ProgressReporter.ProgressType.BYTES) {
            if (progressType == ProgressReporter.ProgressType.NUM_FILES) {
                for (ProgressReporter.ProgressType progressType2 : getSupportedProgressTypes()) {
                    if (progressType2 == ProgressReporter.ProgressType.BYTES) {
                        return;
                    }
                }
                if (this.max[progressType.ordinal()] == -1 || this.max[progressType.ordinal()] == 0) {
                    return;
                }
                this.progress[ProgressReporter.ProgressType.PERCENTAGE.ordinal()] = (this.progress[progressType.ordinal()] * 100) / this.max[progressType.ordinal()];
                return;
            }
            return;
        }
        if (this.max[progressType.ordinal()] == -1) {
            List<? extends JobItem> childJobItems = getChildJobItems();
            if (childJobItems != null) {
                if (childJobItems.size() == 0) {
                    this.progress[ProgressReporter.ProgressType.BYTES.ordinal()] = -1;
                    this.progress[ProgressReporter.ProgressType.PERCENTAGE.ordinal()] = 0;
                    max = -1;
                } else {
                    max = 0;
                }
                for (JobItem jobItem : getChildJobItems()) {
                    if (!jobItem.isSuccessfullyCompleted()) {
                        if (jobItem.getMax(progressType) == -1) {
                            this.progress[ProgressReporter.ProgressType.BYTES.ordinal()] = -1;
                            this.progress[ProgressReporter.ProgressType.PERCENTAGE.ordinal()] = 0;
                            max = -1;
                            break;
                        } else {
                            if (this.progress[ProgressReporter.ProgressType.BYTES.ordinal()] == -1) {
                                this.progress[ProgressReporter.ProgressType.BYTES.ordinal()] = j;
                            }
                            max += jobItem.getMax(progressType);
                        }
                    }
                }
            } else {
                max = 0;
            }
            this.max[progressType.ordinal()] = max;
        }
        if (this.max[progressType.ordinal()] == -1 || this.max[progressType.ordinal()] <= 0) {
            return;
        }
        long j3 = this.max[progressType.ordinal()];
        if (j3 == 0) {
            j3 = 1;
        }
        this.progress[ProgressReporter.ProgressType.PERCENTAGE.ordinal()] = (this.progress[progressType.ordinal()] * 100) / j3;
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.ProgressListener
    public void onProgressUpdated(ProgressReporter progressReporter, ProgressReporter.ProgressType progressType, long j, long j2) {
        updateProgress(progressReporter, progressType, j, j2);
        reportProgressUpdated(progressReporter, progressType, j, j2);
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter
    public long getProgress(ProgressReporter.ProgressType progressType) {
        if (isPaused() && this.mExecutingJobItems.size() > 0) {
            return -4L;
        }
        long j = this.progress[progressType.ordinal()];
        if (j != -1 || this.mExecutingJobItems.size() <= 0) {
            return j;
        }
        return -4L;
    }

    @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter
    public long getMax(ProgressReporter.ProgressType progressType) {
        return this.max[progressType.ordinal()];
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public void cancel() {
        setIsCancelled(true);
        Iterator<? extends JobItem> it = getChildJobItems().iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
        getChildJobItems().clear();
        deleteFromLevelDB();
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public boolean pause() {
        if (!canPause()) {
            return false;
        }
        setIsPaused(true);
        saveToLevelDB();
        if (isFullyPaused()) {
            reportPaused(this);
        }
        Iterator<? extends JobItem> it = getChildJobItems().iterator();
        while (it.hasNext()) {
            it.next().pause();
        }
        this.mFailedJobItems.clear();
        return true;
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public boolean restart(boolean z) {
        if (!canRestart()) {
            return false;
        }
        Iterator<JobItem> it = this.mFailedJobItems.iterator();
        while (it.hasNext()) {
            this.mCompletedJobItems.remove(it.next());
        }
        this.mFailedJobItems.clear();
        Iterator<? extends JobItem> it2 = getChildJobItems().iterator();
        while (it2.hasNext()) {
            it2.next().restart(z);
        }
        setIsPaused(false);
        saveToLevelDB();
        return true;
    }

    public boolean canRestart() {
        return this.mExecutingJobItems.isEmpty();
    }

    public boolean canPause() {
        return !isPaused();
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public boolean hasError() {
        return this.mFailedJobItems.size() > 0;
    }
}
