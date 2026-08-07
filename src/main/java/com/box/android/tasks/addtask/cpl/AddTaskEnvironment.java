package com.box.android.tasks.addtask.cpl;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddTaskReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskEnvironment;", "", "formEnvironment", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormEnvironment;", "<init>", "(Lcom/box/android/tasks/addtask/cpl/AddTaskFormEnvironment;)V", "getFormEnvironment", "()Lcom/box/android/tasks/addtask/cpl/AddTaskFormEnvironment;", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AddTaskEnvironment {
    public static final int $stable = 8;
    private final AddTaskFormEnvironment formEnvironment;

    @Inject
    public AddTaskEnvironment(AddTaskFormEnvironment formEnvironment) {
        Intrinsics.checkNotNullParameter(formEnvironment, "formEnvironment");
        this.formEnvironment = formEnvironment;
    }

    public final AddTaskFormEnvironment getFormEnvironment() {
        return this.formEnvironment;
    }
}
