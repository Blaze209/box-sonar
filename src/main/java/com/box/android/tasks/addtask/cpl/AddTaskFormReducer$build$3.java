package com.box.android.tasks.addtask.cpl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddTaskFormReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AddTaskFormReducer$build$3 extends FunctionReferenceImpl implements Function1<AssigneePickerReducer.Action, AddTaskFormReducer.Action.Assignees> {
    public static final AddTaskFormReducer$build$3 INSTANCE = new AddTaskFormReducer$build$3();

    AddTaskFormReducer$build$3() {
        super(1, AddTaskFormReducer.Action.Assignees.class, "<init>", "<init>(Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final AddTaskFormReducer.Action.Assignees invoke(AssigneePickerReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new AddTaskFormReducer.Action.Assignees(p0);
    }
}
