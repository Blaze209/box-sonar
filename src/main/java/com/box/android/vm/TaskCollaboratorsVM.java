package com.box.android.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.box.android.tasksrepo.SingleTaskRepo;
import com.box.android.tasksrepo.TaskCollaboratorsRepo;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxIteratorTaskCollaborators;
import com.box.boxandroidlibv2private.model.BoxTask;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class TaskCollaboratorsVM extends ViewModel {
    private TaskCollaboratorsRepo mTaskCollaboratorsRepo;
    private SingleTaskRepo mTaskRepo;

    @Inject
    public TaskCollaboratorsVM(TaskCollaboratorsRepo taskCollaboratorsRepo, SingleTaskRepo singleTaskRepo) {
        this.mTaskCollaboratorsRepo = taskCollaboratorsRepo;
        this.mTaskRepo = singleTaskRepo;
    }

    public LiveData<BoxResponse<BoxIteratorTaskCollaborators>> getTaskCollaborators(String str) {
        return this.mTaskCollaboratorsRepo.getTaskCollaborators(str, false);
    }

    public void updateTaskCollaborators(String str) {
        this.mTaskCollaboratorsRepo.fetchTaskCollaboratorsFromRemote(str);
    }

    public LiveData<BoxResponse<BoxTask>> getTask(String str) {
        return this.mTaskRepo.getTask(str, false);
    }
}
