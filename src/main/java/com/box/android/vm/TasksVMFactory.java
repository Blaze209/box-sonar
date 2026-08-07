package com.box.android.vm;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.box.android.tasksrepo.TasksRepo;
import javax.inject.Inject;

/* JADX INFO: loaded from: classes13.dex */
public class TasksVMFactory implements ViewModelProvider.Factory {
    private final TasksRepo mTasksRepo;

    @Inject
    public TasksVMFactory(TasksRepo tasksRepo) {
        this.mTasksRepo = tasksRepo;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> cls) {
        if (cls.isAssignableFrom(MyTasksVM.class)) {
            return new MyTasksVM(this.mTasksRepo);
        }
        if (cls.isAssignableFrom(SentTasksVM.class)) {
            return new SentTasksVM(this.mTasksRepo);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
