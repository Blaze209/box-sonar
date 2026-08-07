package com.box.android.tasks.addtask.ui;

import com.box.android.tasks.addtask.cpl.AddTaskFormReducer;
import com.box.android.tasks.addtask.cpl.AddTaskReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddTaskScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AddTaskScreenKt$AddTaskScreen$formStore$1$1 extends FunctionReferenceImpl implements Function1<AddTaskFormReducer.Action, AddTaskReducer.Action.Form> {
    public static final AddTaskScreenKt$AddTaskScreen$formStore$1$1 INSTANCE = new AddTaskScreenKt$AddTaskScreen$formStore$1$1();

    AddTaskScreenKt$AddTaskScreen$formStore$1$1() {
        super(1, AddTaskReducer.Action.Form.class, "<init>", "<init>(Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final AddTaskReducer.Action.Form invoke(AddTaskFormReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new AddTaskReducer.Action.Form(p0);
    }
}
