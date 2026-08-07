package com.box.android.tasks.addtask.cpl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddTaskReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AddTaskReducer$build$2 extends FunctionReferenceImpl implements Function1<AddTaskFormReducer.State, AddTaskReducer.State.Form> {
    public static final AddTaskReducer$build$2 INSTANCE = new AddTaskReducer$build$2();

    AddTaskReducer$build$2() {
        super(1, AddTaskReducer.State.Form.class, "<init>", "<init>(Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final AddTaskReducer.State.Form invoke(AddTaskFormReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new AddTaskReducer.State.Form(p0);
    }
}
