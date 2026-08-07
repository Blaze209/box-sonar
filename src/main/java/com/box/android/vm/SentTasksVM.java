package com.box.android.vm;

import androidx.lifecycle.LiveData;
import com.box.android.tasksrepo.TasksRepo;

/* JADX INFO: loaded from: classes13.dex */
public class SentTasksVM extends TasksVM {
    public SentTasksVM(TasksRepo tasksRepo) {
        super(tasksRepo);
        this.mTasksData = this.mTasksRepo.getSentTasksData();
    }

    public LiveData<TasksRepo.TasksData> getSentTasksData() {
        return this.mTasksData;
    }

    @Override // com.box.android.vm.TasksVM
    public void loadItems(boolean z) {
        this.mTasksRepo.updateSentTasks(z);
    }
}
