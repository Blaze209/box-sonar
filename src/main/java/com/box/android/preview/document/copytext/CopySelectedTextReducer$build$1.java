package com.box.android.preview.document.copytext;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CopySelectedTextReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CopySelectedTextReducer$build$1 extends FunctionReferenceImpl implements Function2<CopySelectedTextReducer.State, CopySelectedTextReducer.Action, ReducerResult<CopySelectedTextReducer.State, CopySelectedTextReducer.Action>> {
    CopySelectedTextReducer$build$1(Object obj) {
        super(2, obj, CopySelectedTextReducer.class, "reduceCopySelectedText", "reduceCopySelectedText(Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$State;Lcom/box/android/preview/document/copytext/CopySelectedTextReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<CopySelectedTextReducer.State, CopySelectedTextReducer.Action> invoke(CopySelectedTextReducer.State p0, CopySelectedTextReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((CopySelectedTextReducer) this.receiver).reduceCopySelectedText(p0, p1);
    }
}
