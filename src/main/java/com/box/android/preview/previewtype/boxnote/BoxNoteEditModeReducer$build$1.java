package com.box.android.preview.previewtype.boxnote;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxNoteEditModeReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxNoteEditModeReducer$build$1 extends FunctionReferenceImpl implements Function2<BoxNoteEditModeReducer.State, BoxNoteEditModeReducer.Action, ReducerResult<BoxNoteEditModeReducer.State, BoxNoteEditModeReducer.Action>> {
    BoxNoteEditModeReducer$build$1(Object obj) {
        super(2, obj, BoxNoteEditModeReducer.class, "reduce", "reduce(Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$State;Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<BoxNoteEditModeReducer.State, BoxNoteEditModeReducer.Action> invoke(BoxNoteEditModeReducer.State p0, BoxNoteEditModeReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((BoxNoteEditModeReducer) this.receiver).reduce(p0, p1);
    }
}
