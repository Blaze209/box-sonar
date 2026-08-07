package com.box.android.preview.fileactions.openin;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OpenInReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class OpenInReducer$build$1 extends FunctionReferenceImpl implements Function2<OpenInReducer.State, OpenInReducer.Action, ReducerResult<OpenInReducer.State, OpenInReducer.Action>> {
    OpenInReducer$build$1(Object obj) {
        super(2, obj, OpenInReducer.class, "reduceOpenIn", "reduceOpenIn(Lcom/box/android/preview/fileactions/openin/OpenInReducer$State;Lcom/box/android/preview/fileactions/openin/OpenInReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<OpenInReducer.State, OpenInReducer.Action> invoke(OpenInReducer.State p0, OpenInReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((OpenInReducer) this.receiver).reduceOpenIn(p0, p1);
    }
}
