package com.box.android.vm;

import androidx.lifecycle.LiveData;
import com.box.android.tasksrepo.TasksRepo;

/* JADX INFO: loaded from: classes13.dex */
public class MyTasksVM extends TasksVM {
    public MyTasksVM(TasksRepo tasksRepo) {
        super(tasksRepo);
        this.mTasksData = this.mTasksRepo.getMyTasksData();
    }

    public LiveData<TasksRepo.TasksData> getMyTasksData() {
        return this.mTasksData;
    }

    @Override // com.box.android.vm.TasksVM
    public void loadItems(boolean z) {
        this.mTasksRepo.updateMyTasks(z);
    }
}
