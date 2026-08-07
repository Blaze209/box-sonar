package com.box.android.tasksrepo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.coreservices.modelcontroller.IBaseModelController;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxTask;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class SingleTaskRepo {
    private final IBaseModelController mBaseMoCo;
    private final BoxApiPrivate mBoxApiPrivate;
    private final MutableLiveData<BoxResponse<BoxTask>> mTask = new MutableLiveData<>();

    @Inject
    public SingleTaskRepo(IBaseModelController iBaseModelController, BoxApiPrivate boxApiPrivate) {
        this.mBaseMoCo = iBaseModelController;
        this.mBoxApiPrivate = boxApiPrivate;
    }

    public LiveData<BoxResponse<BoxTask>> getTask(String str, boolean z) {
        fetchTaskFromCache(str);
        if (z) {
            fetchTaskFromRemote(str);
        }
        return this.mTask;
    }

    private void fetchTaskFromCache(String str, final Exception exc) {
        this.mBaseMoCo.performLocal(this.mBoxApiPrivate.getTask(str), new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.tasksrepo.SingleTaskRepo$$ExternalSyntheticLambda2
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$fetchTaskFromCache$0(exc, boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchTaskFromCache$0(Exception exc, BoxResponse boxResponse) {
        if (boxResponse != null) {
            postResultWithErrorInfo(boxResponse, exc);
        }
    }

    private void fetchTaskFromCache(String str) {
        this.mBaseMoCo.performLocal(this.mBoxApiPrivate.getTask(str), new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.tasksrepo.SingleTaskRepo$$ExternalSyntheticLambda1
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$fetchTaskFromCache$1(boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchTaskFromCache$1(BoxResponse boxResponse) {
        if (boxResponse != null) {
            if (!boxResponse.isSuccess()) {
                postResultWithErrorInfo(boxResponse, boxResponse.getException());
            } else {
                this.mTask.postValue(boxResponse);
            }
        }
    }

    private void postResultWithErrorInfo(BoxResponse<BoxTask> boxResponse, Exception exc) {
        this.mTask.postValue(new BoxResponse<>((BoxTask) boxResponse.getResult(), exc, boxResponse.getRequest()));
    }

    private void fetchTaskFromRemote(final String str) {
        this.mBaseMoCo.performRemote(this.mBoxApiPrivate.getTask(str), new BoxAppFutureTask.OnCompletedListener() { // from class: com.box.android.tasksrepo.SingleTaskRepo$$ExternalSyntheticLambda0
            @Override // com.box.android.coreservices.modelcontroller.BoxAppFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$fetchTaskFromRemote$2(str, boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchTaskFromRemote$2(String str, BoxResponse boxResponse) {
        if (boxResponse != null) {
            if (boxResponse.isSuccess()) {
                fetchTaskFromCache(str);
            } else {
                fetchTaskFromCache(str, boxResponse.getException());
            }
        }
    }
}
