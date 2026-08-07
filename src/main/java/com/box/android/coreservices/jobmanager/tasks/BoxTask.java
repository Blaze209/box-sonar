package com.box.android.coreservices.jobmanager.tasks;

import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.coreservices.exceptions.FileTransferException;
import com.box.android.coreservices.exceptions.MissingOsPermissionException;
import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.modelcontroller.BoxFutureTask;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.android.coreservices.modelcontroller.messages.BoxMessage;
import com.box.android.coreservices.utilities.CoreServiceUtils;
import com.box.android.domain.exceptions.PermissionDeniedException;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxError;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import com.microsoft.intune.mam.client.content.ContentResolverFileAccessDeniedException;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxTask extends JobItem implements RunnableFuture<BoxMessage<?>> {
    public static final String CURRENT_STATE = "mCurrentState";
    public static final String HAS_ERROR = "mHasError";
    private static transient HashSet<String> mCancelledTasks = new HashSet<>();
    private transient boolean mIsCancelled;
    protected transient MoCoContainerBuilder.MoCoContainer mMoCoContainer;
    protected transient BoxJob mParentJob;
    protected transient BoxFutureTask<? extends BoxMessage<?>> mTask;

    protected abstract BoxFutureTask<? extends BoxMessage<?>> createTask();

    protected void handleCancelProgress() {
    }

    protected BoxTask() {
    }

    protected BoxTask(String str, String str2, MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob) {
        super(str, str2);
        setCurrentState(JobItem.JobItemState.QUEUED);
        init(moCoContainer, boxJob);
    }

    public void init(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob) {
        super.init(moCoContainer.getBaseModelController().getKeyValueStore());
        this.mMoCoContainer = moCoContainer;
        this.mParentJob = boxJob;
    }

    public BoxJob getParent() {
        return this.mParentJob;
    }

    public boolean getHasError() {
        if (this.mProperties.get(HAS_ERROR) != null) {
            return ((Boolean) this.mProperties.get(HAS_ERROR)).booleanValue();
        }
        return false;
    }

    public void setHasError(boolean z) {
        this.mProperties.put(HAS_ERROR, Boolean.valueOf(z));
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem, com.box.android.coreservices.jobmanager.JobItemJsonEntity, com.box.android.coreservices.models.BoxPersistableObject
    protected void parseJSONMember(JsonObject.Member member) {
        String name = member.getName();
        JsonValue value = member.getValue();
        if (name.equals(HAS_ERROR)) {
            setHasError(value.asBoolean());
        } else if (name.equals(CURRENT_STATE)) {
            setCurrentState(JobItem.JobItemState.fromString(value.asString()));
        } else {
            super.parseJSONMember(member);
        }
    }

    protected void setCurrentState(JobItem.JobItemState jobItemState) {
        this.mProperties.put(CURRENT_STATE, jobItemState);
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public void run() {
        if (isCancelled() || isDone()) {
            return;
        }
        try {
            BoxFutureTask<? extends BoxMessage<?>> boxFutureTask = this.mTask;
            if (boxFutureTask == null || boxFutureTask.isCancelled() || this.mTask.isDone()) {
                this.mTask = createTask();
            }
            reportStarted(this);
            this.mTask.run();
        } catch (Exception e) {
            if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
                throw new RuntimeException(e);
            }
            reportError(this, e);
        }
    }

    @Override // java.util.concurrent.Future
    public BoxMessage<?> get() throws ExecutionException, InterruptedException {
        BoxFutureTask<? extends BoxMessage<?>> boxFutureTask = this.mTask;
        if (boxFutureTask != null) {
            return boxFutureTask.get();
        }
        return null;
    }

    @Override // java.util.concurrent.Future
    public BoxMessage<?> get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        BoxFutureTask<? extends BoxMessage<?>> boxFutureTask = this.mTask;
        if (boxFutureTask != null) {
            return boxFutureTask.get(j, timeUnit);
        }
        return null;
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public boolean pause() {
        if (getCurrentState() == JobItem.JobItemState.PAUSED) {
            return false;
        }
        if (getCurrentState() != JobItem.JobItemState.COMPLETED) {
            setCurrentState(JobItem.JobItemState.PAUSED);
            cancel(true);
        }
        saveToLevelDB();
        return true;
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public boolean restart(boolean z) {
        if (getCurrentState() != JobItem.JobItemState.PAUSED && !hasError()) {
            return false;
        }
        clearState();
        saveToLevelDB();
        return true;
    }

    protected void clearState() {
        setHasError(false);
        setCurrentState(JobItem.JobItemState.QUEUED);
        setErrorType(null);
        this.mTask = null;
        this.mIsCancelled = false;
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public void cancel() {
        setCurrentState(JobItem.JobItemState.CANCELLED);
        cancel(true);
        deleteFromLevelDB();
        handleCancelProgress();
        this.mParentJob.removeTask(this);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        this.mIsCancelled = true;
        mCancelledTasks.add(getId());
        BoxFutureTask<? extends BoxMessage<?>> boxFutureTask = this.mTask;
        if (boxFutureTask != null) {
            return boxFutureTask.cancel(z);
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.mIsCancelled || getCurrentState() == JobItem.JobItemState.PAUSED || getCurrentState() == JobItem.JobItemState.CANCELLED;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        BoxFutureTask<? extends BoxMessage<?>> boxFutureTask = this.mTask;
        if (boxFutureTask != null) {
            return boxFutureTask.isDone();
        }
        return getCurrentState() == JobItem.JobItemState.COMPLETED;
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public JobItem.JobItemState getCurrentState() {
        return (JobItem.JobItemState) this.mProperties.get(CURRENT_STATE);
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    protected void reportStarted(ProgressReporter progressReporter) {
        setCurrentState(JobItem.JobItemState.EXECUTING);
        super.reportStarted(progressReporter);
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    protected void reportCompleted(ProgressReporter progressReporter) {
        setCurrentState(JobItem.JobItemState.COMPLETED);
        saveToLevelDB();
        super.reportCompleted(progressReporter);
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    protected void reportError(ProgressReporter progressReporter, Exception exc) {
        if (getCurrentState() != JobItem.JobItemState.PAUSED && getCurrentState() != JobItem.JobItemState.CANCELLED) {
            setCurrentState(JobItem.JobItemState.COMPLETED);
            saveToLevelDB();
        }
        if (getCurrentState() == JobItem.JobItemState.PAUSED) {
            super.reportPaused(progressReporter);
            return;
        }
        setErrorStateFromError(exc);
        setHasError(true);
        saveToLevelDB();
        super.reportError(progressReporter, exc);
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public boolean hasError() {
        return getHasError();
    }

    @Override // com.box.android.coreservices.jobmanager.JobItem
    public String getErrorText() {
        return getErrorType().getMessage();
    }

    protected void setErrorStateFromError(Exception exc) {
        if (CoreServiceUtils.isConnectionIssueException(exc)) {
            setErrorType(JobItem.ErrorType.LOST_CONNECTION);
            return;
        }
        if (exc instanceof FileNotFoundException) {
            if (exc instanceof ContentResolverFileAccessDeniedException) {
                setErrorType(JobItem.ErrorType.OPERATION_NOT_ALLOWED_BY_ENTERPRISE);
                return;
            } else {
                setErrorType(JobItem.ErrorType.ITEM_NOT_FOUND);
                return;
            }
        }
        if (exc instanceof PermissionDeniedException) {
            setErrorType(JobItem.ErrorType.PERMISSION);
            return;
        }
        if (exc instanceof MissingOsPermissionException) {
            setErrorType(JobItem.ErrorType.OS_PERMISSION);
            return;
        }
        if (exc instanceof FileTransferException) {
            setErrorType(((FileTransferException) exc).getJobItemErrorType());
            return;
        }
        if (exc instanceof BoxException.CorruptedContentException) {
            setErrorType(JobItem.ErrorType.BAD_DIGEST);
            return;
        }
        if (exc instanceof BoxException) {
            BoxException boxException = (BoxException) exc;
            BoxError asBoxError = boxException.getAsBoxError();
            if (asBoxError != null && asBoxError.getStatus() != null) {
                int iIntValue = asBoxError.getStatus().intValue();
                if (iIntValue != 403) {
                    if (iIntValue == 404) {
                        setErrorType(JobItem.ErrorType.ITEM_NOT_FOUND);
                        return;
                    } else if (iIntValue == 409) {
                        setErrorType(JobItem.ErrorType.CONFLICTS_WITH_EXISTING);
                        return;
                    } else {
                        BoxLogUtils.logException("BoxTask unhandled status " + asBoxError.getStatus(), toString(), exc);
                        setErrorType(JobItem.ErrorType.GENERIC_EXCEPTION);
                        return;
                    }
                }
                BoxError asBoxError2 = boxException.getAsBoxError();
                String code = asBoxError2 != null ? asBoxError2.getCode() : null;
                if ("storage_limit_exceeded".equals(code)) {
                    setErrorType(JobItem.ErrorType.STORAGE_LIMIT_EXCEEDED);
                    return;
                } else if ("operation_not_allowed_by_enterprise".equals(code)) {
                    setErrorType(JobItem.ErrorType.OPERATION_NOT_ALLOWED_BY_ENTERPRISE);
                    return;
                } else {
                    setErrorType(JobItem.ErrorType.PERMISSION);
                    return;
                }
            }
            if (exc.getCause() instanceof InterruptedException) {
                setErrorType(JobItem.ErrorType.IO);
                return;
            } else {
                setErrorType(JobItem.ErrorType.GENERIC_EXCEPTION);
                return;
            }
        }
        BoxLogUtils.logException("BoxTask Error", toString(), exc);
        setErrorType(JobItem.ErrorType.GENERIC_EXCEPTION);
    }
}
