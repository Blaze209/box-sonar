package com.box.android.tasks.addtask.cpl;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddTaskFormReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class AddTaskFormReducer$build$1 extends FunctionReferenceImpl implements Function2<AddTaskFormReducer.State, AddTaskFormReducer.Action, ReducerResult<AddTaskFormReducer.State, AddTaskFormReducer.Action>> {
    AddTaskFormReducer$build$1(Object obj) {
        super(2, obj, AddTaskFormReducer.class, "reduceForm", "reduceForm(Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$State;Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<AddTaskFormReducer.State, AddTaskFormReducer.Action> invoke(AddTaskFormReducer.State p0, AddTaskFormReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((AddTaskFormReducer) this.receiver).reduceForm(p0, p1);
    }
}
