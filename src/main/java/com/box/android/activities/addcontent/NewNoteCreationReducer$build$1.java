package com.box.android.activities.addcontent;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NewNoteCreationReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class NewNoteCreationReducer$build$1 extends FunctionReferenceImpl implements Function2<NewNoteCreationReducer.State, NewNoteCreationReducer.Action, ReducerResult<NewNoteCreationReducer.State, NewNoteCreationReducer.Action>> {
    NewNoteCreationReducer$build$1(Object obj) {
        super(2, obj, NewNoteCreationReducer.class, "reduceNewNote", "reduceNewNote(Lcom/box/android/activities/addcontent/NewNoteCreationReducer$State;Lcom/box/android/activities/addcontent/NewNoteCreationReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<NewNoteCreationReducer.State, NewNoteCreationReducer.Action> invoke(NewNoteCreationReducer.State p0, NewNoteCreationReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((NewNoteCreationReducer) this.receiver).reduceNewNote(p0, p1);
    }
}
