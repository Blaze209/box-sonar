package com.box.android.tasksrepo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxIteratorTaskCollaborators;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class TaskCollaboratorsRepo {
    private final IBaseModelController mBaseMoCo;
    private final BoxApiPrivate mBoxApiPrivate;
    private final MutableLiveData<BoxResponse<BoxIteratorTaskCollaborators>> mTaskCollaborators = new MutableLiveData<>();

    @Inject
    public TaskCollaboratorsRepo(IBaseModelController iBaseModelController, BoxApiPrivate boxApiPrivate) {
        this.mBaseMoCo = iBaseModelController;
        this.mBoxApiPrivate = boxApiPrivate;
    }

    public LiveData<BoxResponse<BoxIteratorTaskCollaborators>> getTaskCollaborators(String str, boolean z) {
        fetchTaskCollaboratorsFromCache(str);
        if (z) {
            fetchTaskCollaboratorsFromRemote(str);
        }
        return this.mTaskCollaborators;
    }

    LiveData<BoxResponse<BoxIteratorTaskCollaborators>> getTaskCollaboratorsForTesting() {
        return this.mTaskCollaborators;
    }

    private void postResultWithErrorInfo(BoxResponse<BoxIteratorTaskCollaborators> boxResponse, Exception exc) {
        this.mTaskCollaborators.postValue(new BoxResponse<>((BoxIteratorTaskCollaborators) boxResponse.getResult(), exc, boxResponse.getRequest()));
    }

    private void fetchTaskCollaboratorsFromCache(String str, final Exception exc) {
        this.mBaseMoCo.performLocal(this.mBoxApiPrivate.getTaskCollaborators(str).setFetchAll(true), new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.tasksrepo.TaskCollaboratorsRepo$$ExternalSyntheticLambda2
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$fetchTaskCollaboratorsFromCache$0(exc, boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchTaskCollaboratorsFromCache$0(Exception exc, BoxResponse boxResponse) {
        if (boxResponse != null) {
            postResultWithErrorInfo(boxResponse, exc);
        }
    }

    private void fetchTaskCollaboratorsFromCache(String str) {
        this.mBaseMoCo.performLocal(this.mBoxApiPrivate.getTaskCollaborators(str), new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.tasksrepo.TaskCollaboratorsRepo$$ExternalSyntheticLambda1
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$fetchTaskCollaboratorsFromCache$1(boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchTaskCollaboratorsFromCache$1(BoxResponse boxResponse) {
        if (boxResponse != null) {
            if (!boxResponse.isSuccess()) {
                postResultWithErrorInfo(boxResponse, boxResponse.getException());
            } else {
                this.mTaskCollaborators.postValue(boxResponse);
            }
        }
    }

    public void fetchTaskCollaboratorsFromRemote(final String str) {
        this.mBaseMoCo.performRemote(this.mBoxApiPrivate.getTaskCollaborators(str).limitTaskCollaboratorsRole(BoxTaskCollaborator.ROLE_ASSIGNEE).setFetchAll(true), new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.tasksrepo.TaskCollaboratorsRepo$$ExternalSyntheticLambda0
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$fetchTaskCollaboratorsFromRemote$2(str, boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchTaskCollaboratorsFromRemote$2(String str, BoxResponse boxResponse) {
        if (boxResponse != null) {
            if (!boxResponse.isSuccess()) {
                fetchTaskCollaboratorsFromCache(str, boxResponse.getException());
            } else {
                fetchTaskCollaboratorsFromCache(str);
            }
        }
    }
}
