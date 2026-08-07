package com.box.android.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.box.android.tasksrepo.TasksRepo;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxTask;

/* JADX INFO: loaded from: classes13.dex */
public abstract class TasksVM extends ViewModel {
    protected LiveData<TasksRepo.TasksData> mTasksData;
    protected final TasksRepo mTasksRepo;

    public abstract void loadItems(boolean z);

    protected TasksVM(TasksRepo tasksRepo) {
        this.mTasksRepo = tasksRepo;
    }

    public LiveData<BoxResponse<BoxTask>> updateTaskCollaborationStatus(BoxTask boxTask, String str) {
        return this.mTasksRepo.updateStatus(boxTask, str);
    }

    public boolean isContentAvailable() {
        return this.mTasksData.getValue() != null;
    }
}
