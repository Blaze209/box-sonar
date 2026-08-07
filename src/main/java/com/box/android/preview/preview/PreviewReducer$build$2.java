package com.box.android.preview.preview;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviewReducer$build$2 extends FunctionReferenceImpl implements Function2<PreviewReducer.State, PreviewReducer.Action, ReducerResult<PreviewReducer.State, PreviewReducer.Action>> {
    PreviewReducer$build$2(Object obj) {
        super(2, obj, PreviewReducer.class, "reduceHighlightDisabling", "reduceHighlightDisabling(Lcom/box/android/preview/preview/PreviewReducer$State;Lcom/box/android/preview/preview/PreviewReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<PreviewReducer.State, PreviewReducer.Action> invoke(PreviewReducer.State p0, PreviewReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((PreviewReducer) this.receiver).reduceHighlightDisabling(p0, p1);
    }
}
