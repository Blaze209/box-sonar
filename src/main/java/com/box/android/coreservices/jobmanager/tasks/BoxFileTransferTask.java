package com.box.android.coreservices.jobmanager.tasks;

import com.box.android.coreservices.jobmanager.JobItem;
import com.box.android.coreservices.jobmanager.dao.ProgressReporter;
import com.box.android.coreservices.jobmanager.jobs.BoxJob;
import com.box.android.coreservices.modelcontroller.MoCoContainerBuilder;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxError;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxUploadSession;
import com.box.androidsdk.content.requests.BoxResponse;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BoxFileTransferTask extends BoxItemTask {
    protected BoxFileTransferTask() {
    }

    protected BoxFileTransferTask(String str, String str2, BoxFile boxFile, MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob) {
        super(str, str2, boxFile, moCoContainer, boxJob);
        init(moCoContainer, boxJob);
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask, com.box.android.coreservices.jobmanager.tasks.BoxTask
    public void init(MoCoContainerBuilder.MoCoContainer moCoContainer, BoxJob boxJob) {
        super.init(moCoContainer, boxJob);
        if (this.mBoxItem != null) {
            setMax(ProgressReporter.ProgressType.BYTES, this.mBoxItem.getSize().longValue());
        }
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected void setErrorStateFromError(Exception exc) {
        BoxError asBoxError;
        if ((exc instanceof BoxException) && (asBoxError = ((BoxException) exc).getAsBoxError()) != null && asBoxError.getStatus() != null && asBoxError.getStatus().intValue() == 400) {
            setErrorType(JobItem.ErrorType.BAD_DIGEST);
        } else {
            super.setErrorStateFromError(exc);
        }
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask, com.box.android.coreservices.jobmanager.dao.ProgressReporter
    public long getProgress(ProgressReporter.ProgressType progressType) {
        if (progressType == ProgressReporter.ProgressType.BYTES) {
            return this.mProgress;
        }
        return -3L;
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask, com.box.android.coreservices.jobmanager.dao.ProgressReporter
    public long getMax(ProgressReporter.ProgressType progressType) {
        if (progressType == ProgressReporter.ProgressType.BYTES) {
            return this.mProgressMax;
        }
        return -3L;
    }

    public void setMax(ProgressReporter.ProgressType progressType, long j) {
        if (progressType != ProgressReporter.ProgressType.BYTES || this.mProgressMax == j) {
            return;
        }
        this.mProgressMax = j;
        saveToLevelDB();
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask, com.box.android.coreservices.jobmanager.dao.ProgressReporter
    public ProgressReporter.ProgressType[] getSupportedProgressTypes() {
        return new ProgressReporter.ProgressType[]{ProgressReporter.ProgressType.BYTES};
    }

    protected void updateProgressMax(long j, long j2) {
        if (j == this.mProgress && j2 == this.mProgressMax) {
            return;
        }
        long j3 = j - this.mProgress;
        long j4 = j2 - this.mProgressMax;
        this.mProgress = j;
        this.mProgressMax = j2;
        reportProgressUpdated(this, ProgressReporter.ProgressType.BYTES, j3, j4);
    }

    protected ProgressReporter.FileTransferProgressListener getFileTransferProgressListener() {
        return new ProgressReporter.FileTransferProgressListener(getMax(ProgressReporter.ProgressType.BYTES)) { // from class: com.box.android.coreservices.jobmanager.tasks.BoxFileTransferTask.1
            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.FileTransferProgressListener
            public void onStarted(ProgressReporter progressReporter) {
                BoxFileTransferTask boxFileTransferTask = BoxFileTransferTask.this;
                boxFileTransferTask.reportStarted(boxFileTransferTask);
            }

            @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.FileTransferProgressListener, com.box.androidsdk.content.listeners.ProgressListener
            public void onProgressChanged(long j, long j2) {
                if (j2 != 0) {
                    this.mTotalBytes = j2;
                }
                if (BoxFileTransferTask.this.getCurrentState() != JobItem.JobItemState.CANCELLED) {
                    BoxFileTransferTask.this.updateProgressMax(j, j2);
                }
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.FileTransferProgressListener
            public void onError(Exception exc) {
                super.onError(exc);
                if (BoxFileTransferTask.this.getCurrentState() != JobItem.JobItemState.CANCELLED) {
                    BoxFileTransferTask boxFileTransferTask = BoxFileTransferTask.this;
                    boxFileTransferTask.updateProgressMax(0L, boxFileTransferTask.mProgressMax);
                }
                BoxFileTransferTask boxFileTransferTask2 = BoxFileTransferTask.this;
                boxFileTransferTask2.reportError(boxFileTransferTask2, exc);
            }

            /* JADX WARN: Type inference fix 'apply assigned field type' failed
            java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
            	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
            	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
            	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
            	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
             */
            @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.FileTransferProgressListener, com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public void onCompleted(BoxResponse boxResponse) {
                super.onCompleted(boxResponse);
                long progress = BoxFileTransferTask.this.getProgress(ProgressReporter.ProgressType.BYTES);
                long max = BoxFileTransferTask.this.getMax(ProgressReporter.ProgressType.BYTES);
                if (progress != max) {
                    BoxFileTransferTask.this.updateProgressMax(max, max);
                }
                BoxFileTransferTask boxFileTransferTask = BoxFileTransferTask.this;
                boxFileTransferTask.reportCompleted(boxFileTransferTask);
            }

            @Override // com.box.android.coreservices.jobmanager.dao.ProgressReporter.FileTransferProgressListener
            public void onSessionInitialized(BoxUploadSession boxUploadSession) {
                BoxFileTransferTask.this.reportSessionStarted(boxUploadSession);
            }
        };
    }

    @Override // com.box.android.coreservices.jobmanager.tasks.BoxItemTask, com.box.android.coreservices.jobmanager.tasks.BoxTask
    protected void handleCancelProgress() {
        updateProgressMax(0L, 0L);
    }
}
