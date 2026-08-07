package com.box.android.tasks.addtask.cpl;

import com.box.android.domain.services.ITaskService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddTaskFormReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormEnvironment;", "", "taskService", "Lcom/box/android/domain/services/ITaskService;", "assigneePickerEnvironment", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerEnvironment;", "<init>", "(Lcom/box/android/domain/services/ITaskService;Lcom/box/android/tasks/addtask/cpl/AssigneePickerEnvironment;)V", "getTaskService", "()Lcom/box/android/domain/services/ITaskService;", "getAssigneePickerEnvironment", "()Lcom/box/android/tasks/addtask/cpl/AssigneePickerEnvironment;", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AddTaskFormEnvironment {
    public static final int $stable = 8;
    private final AssigneePickerEnvironment assigneePickerEnvironment;
    private final ITaskService taskService;

    @Inject
    public AddTaskFormEnvironment(ITaskService taskService, AssigneePickerEnvironment assigneePickerEnvironment) {
        Intrinsics.checkNotNullParameter(taskService, "taskService");
        Intrinsics.checkNotNullParameter(assigneePickerEnvironment, "assigneePickerEnvironment");
        this.taskService = taskService;
        this.assigneePickerEnvironment = assigneePickerEnvironment;
    }

    public final AssigneePickerEnvironment getAssigneePickerEnvironment() {
        return this.assigneePickerEnvironment;
    }

    public final ITaskService getTaskService() {
        return this.taskService;
    }
}
