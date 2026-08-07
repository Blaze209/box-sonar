package com.box.android.data.jobs;

import com.box.android.data.api.models.upload.CommitSessionState;
import com.box.android.data.api.models.upload.InitialState;
import com.box.android.data.api.models.upload.PreflightCheckState;
import com.box.android.data.api.models.upload.UploadChunksState;
import com.box.android.data.api.models.upload.UploadFileRunningData;
import com.box.android.data.api.models.upload.UploadJobState;
import com.box.android.data.api.models.upload.UploadSessionCreationState;
import com.box.android.data.api.models.upload.UploadWholeFileState;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UploadStatesFactory.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/jobs/UploadStatesFactory;", "", "initialStateFactory", "Lcom/box/android/data/api/models/upload/InitialState$Factory;", "preflightCheckStateFactory", "Lcom/box/android/data/api/models/upload/PreflightCheckState$Factory;", "uploadWholeFileStateFactory", "Lcom/box/android/data/api/models/upload/UploadWholeFileState$Factory;", "uploadSessionCreationStateFactory", "Lcom/box/android/data/api/models/upload/UploadSessionCreationState$Factory;", "uploadChunksStateFactory", "Lcom/box/android/data/api/models/upload/UploadChunksState$Factory;", "commitSessionStateFactory", "Lcom/box/android/data/api/models/upload/CommitSessionState$Factory;", "<init>", "(Lcom/box/android/data/api/models/upload/InitialState$Factory;Lcom/box/android/data/api/models/upload/PreflightCheckState$Factory;Lcom/box/android/data/api/models/upload/UploadWholeFileState$Factory;Lcom/box/android/data/api/models/upload/UploadSessionCreationState$Factory;Lcom/box/android/data/api/models/upload/UploadChunksState$Factory;Lcom/box/android/data/api/models/upload/CommitSessionState$Factory;)V", "createUploadState", "Lcom/box/android/data/api/models/upload/UploadJobState;", "job", "Lcom/box/android/data/jobs/UploadFileJobV2;", "runningData", "Lcom/box/android/data/api/models/upload/UploadFileRunningData;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UploadStatesFactory {
    private final CommitSessionState.Factory commitSessionStateFactory;
    private final InitialState.Factory initialStateFactory;
    private final PreflightCheckState.Factory preflightCheckStateFactory;
    private final UploadChunksState.Factory uploadChunksStateFactory;
    private final UploadSessionCreationState.Factory uploadSessionCreationStateFactory;
    private final UploadWholeFileState.Factory uploadWholeFileStateFactory;

    @Inject
    public UploadStatesFactory(InitialState.Factory initialStateFactory, PreflightCheckState.Factory preflightCheckStateFactory, UploadWholeFileState.Factory uploadWholeFileStateFactory, UploadSessionCreationState.Factory uploadSessionCreationStateFactory, UploadChunksState.Factory uploadChunksStateFactory, CommitSessionState.Factory commitSessionStateFactory) {
        Intrinsics.checkNotNullParameter(initialStateFactory, "initialStateFactory");
        Intrinsics.checkNotNullParameter(preflightCheckStateFactory, "preflightCheckStateFactory");
        Intrinsics.checkNotNullParameter(uploadWholeFileStateFactory, "uploadWholeFileStateFactory");
        Intrinsics.checkNotNullParameter(uploadSessionCreationStateFactory, "uploadSessionCreationStateFactory");
        Intrinsics.checkNotNullParameter(uploadChunksStateFactory, "uploadChunksStateFactory");
        Intrinsics.checkNotNullParameter(commitSessionStateFactory, "commitSessionStateFactory");
        this.initialStateFactory = initialStateFactory;
        this.preflightCheckStateFactory = preflightCheckStateFactory;
        this.uploadWholeFileStateFactory = uploadWholeFileStateFactory;
        this.uploadSessionCreationStateFactory = uploadSessionCreationStateFactory;
        this.uploadChunksStateFactory = uploadChunksStateFactory;
        this.commitSessionStateFactory = commitSessionStateFactory;
    }

    public final UploadJobState createUploadState(UploadFileJobV2 job, UploadFileRunningData runningData) {
        Intrinsics.checkNotNullParameter(job, "job");
        Intrinsics.checkNotNullParameter(runningData, "runningData");
        if (runningData instanceof UploadFileRunningData.InitialData) {
            return this.initialStateFactory.createState(job);
        }
        if (runningData instanceof UploadFileRunningData.PreflightCheckData) {
            return this.preflightCheckStateFactory.createState(job);
        }
        if (runningData instanceof UploadFileRunningData.SessionCreationData) {
            return this.uploadSessionCreationStateFactory.createState(job);
        }
        if (runningData instanceof UploadFileRunningData.UploadWholeFileData) {
            return this.uploadWholeFileStateFactory.createState(job);
        }
        if (runningData instanceof UploadFileRunningData.ChunkUploadingData) {
            return this.uploadChunksStateFactory.createState(job);
        }
        if (runningData instanceof UploadFileRunningData.CommitSessionData) {
            return this.commitSessionStateFactory.createState(job);
        }
        throw new NoWhenBranchMatchedException();
    }
}
