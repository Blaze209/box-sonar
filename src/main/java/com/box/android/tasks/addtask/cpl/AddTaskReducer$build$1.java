package com.box.android.tasks.addtask.cpl;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddTaskReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AddTaskReducer$build$1 extends FunctionReferenceImpl implements Function2<AddTaskReducer.State, AddTaskReducer.Action, ReducerResult<AddTaskReducer.State, AddTaskReducer.Action>> {
    AddTaskReducer$build$1(Object obj) {
        super(2, obj, AddTaskReducer.class, "reduceAddTask", "reduceAddTask(Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State;Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<AddTaskReducer.State, AddTaskReducer.Action> invoke(AddTaskReducer.State p0, AddTaskReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((AddTaskReducer) this.receiver).reduceAddTask(p0, p1);
    }
}
