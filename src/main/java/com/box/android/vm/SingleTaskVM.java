package com.box.android.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.box.android.tasksrepo.SingleTaskRepo;
import com.box.android.tasksrepo.TasksRepo;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxIteratorTasks;
import com.box.boxandroidlibv2private.model.BoxTask;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import java.util.HashMap;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class SingleTaskVM extends ViewModel {
    final MediatorLiveData<TasksRepo.TasksData> mSingleTaskData = new MediatorLiveData<>();
    LiveData<BoxResponse<BoxTask>> mSingleTaskLiveData = null;
    private SingleTaskRepo mSingleTaskRepo;
    private String mTaskId;
    private TasksRepo mTasksRepo;

    @Inject
    public SingleTaskVM(TasksRepo tasksRepo, SingleTaskRepo singleTaskRepo) {
        this.mTasksRepo = tasksRepo;
        this.mSingleTaskRepo = singleTaskRepo;
    }

    public LiveData<TasksRepo.TasksData> getTask(String str) {
        String str2 = this.mTaskId;
        if (str2 == null || !str2.equals(str)) {
            this.mTaskId = str;
            if (this.mSingleTaskLiveData == null) {
                LiveData<BoxResponse<BoxTask>> task = this.mSingleTaskRepo.getTask(str, false);
                this.mSingleTaskLiveData = task;
                this.mSingleTaskData.addSource(task, new Observer<BoxResponse<BoxTask>>() { // from class: com.box.android.vm.SingleTaskVM.1
                    @Override // androidx.lifecycle.Observer
                    public void onChanged(BoxResponse<BoxTask> boxResponse) {
                        if (boxResponse.getResult() == null || ((BoxTask) boxResponse.getResult()).getUserId().equals(SingleTaskVM.this.mTaskId)) {
                            SingleTaskVM.this.mSingleTaskData.postValue(SingleTaskVM.this.createData((BoxTask) boxResponse.getResult(), boxResponse.getException(), boxResponse.getRequest(), null));
                        }
                    }
                });
            }
        }
        return this.mSingleTaskData;
    }

    public void loadItems(boolean z) {
        this.mSingleTaskRepo.getTask(this.mTaskId, z);
    }

    public LiveData<BoxResponse<BoxTask>> updateTaskCollaborationStatus(final BoxTask boxTask, String str) {
        final LiveData<BoxResponse<BoxTask>> liveDataUpdateStatus = this.mTasksRepo.updateStatus(boxTask, str);
        this.mSingleTaskData.addSource(liveDataUpdateStatus, new Observer<BoxResponse<BoxTask>>() { // from class: com.box.android.vm.SingleTaskVM.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(BoxResponse<BoxTask> boxResponse) {
                if (boxResponse.isSuccess()) {
                    SingleTaskVM.this.mSingleTaskData.postValue(SingleTaskVM.this.createData((BoxTask) boxResponse.getResult(), boxResponse.getException(), boxResponse.getRequest(), TasksRepo.TasksData.TaskChangeCollabStatus.COMPLETED));
                } else {
                    SingleTaskVM.this.mSingleTaskData.postValue(SingleTaskVM.this.createData(boxTask, boxResponse.getException(), boxResponse.getRequest(), TasksRepo.TasksData.TaskChangeCollabStatus.ERROR));
                }
                SingleTaskVM.this.mSingleTaskData.removeSource(liveDataUpdateStatus);
            }
        });
        this.mSingleTaskData.postValue(createData(boxTask, null, null, TasksRepo.TasksData.TaskChangeCollabStatus.STARTED));
        return liveDataUpdateStatus;
    }

    protected TasksRepo.TasksData createData(BoxTask boxTask, Exception exc, BoxRequest boxRequest, TasksRepo.TasksData.TaskChangeCollabStatus taskChangeCollabStatus) {
        BoxIteratorTasks boxIteratorTasks;
        if (boxTask != null) {
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            jsonArray.add(boxTask.toJsonObject());
            jsonObject.set("entries", jsonArray);
            boxIteratorTasks = new BoxIteratorTasks(jsonObject);
        } else {
            boxIteratorTasks = null;
        }
        BoxResponse boxResponse = new BoxResponse(boxIteratorTasks, exc, boxRequest);
        HashMap map = new HashMap(1);
        if (taskChangeCollabStatus != null && boxTask != null) {
            map.put(boxTask.getUserId(), taskChangeCollabStatus);
        }
        return new TasksRepo.TasksData(boxResponse, map);
    }

    public boolean isContentAvailable() {
        return this.mSingleTaskData.getValue() != null;
    }
}
