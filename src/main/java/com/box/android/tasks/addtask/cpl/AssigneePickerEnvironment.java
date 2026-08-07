package com.box.android.tasks.addtask.cpl;

import com.box.android.domain.controller.ICommentControllerBridge;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AssigneePickerReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AssigneePickerEnvironment;", "", "commentControllerBridge", "Lcom/box/android/domain/controller/ICommentControllerBridge;", "<init>", "(Lcom/box/android/domain/controller/ICommentControllerBridge;)V", "getCommentControllerBridge", "()Lcom/box/android/domain/controller/ICommentControllerBridge;", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssigneePickerEnvironment {
    public static final int $stable = 8;
    private final ICommentControllerBridge commentControllerBridge;

    @Inject
    public AssigneePickerEnvironment(ICommentControllerBridge commentControllerBridge) {
        Intrinsics.checkNotNullParameter(commentControllerBridge, "commentControllerBridge");
        this.commentControllerBridge = commentControllerBridge;
    }

    public final ICommentControllerBridge getCommentControllerBridge() {
        return this.commentControllerBridge;
    }
}
