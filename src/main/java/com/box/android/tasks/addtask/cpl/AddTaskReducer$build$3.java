package com.box.android.tasks.addtask.cpl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddTaskReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AddTaskReducer$build$3 extends FunctionReferenceImpl implements Function1<AddTaskFormReducer.Action, AddTaskReducer.Action.Form> {
    public static final AddTaskReducer$build$3 INSTANCE = new AddTaskReducer$build$3();

    AddTaskReducer$build$3() {
        super(1, AddTaskReducer.Action.Form.class, "<init>", "<init>(Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final AddTaskReducer.Action.Form invoke(AddTaskFormReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new AddTaskReducer.Action.Form(p0);
    }
}
