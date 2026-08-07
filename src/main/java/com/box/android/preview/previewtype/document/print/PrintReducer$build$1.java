package com.box.android.preview.previewtype.document.print;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PrintReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PrintReducer$build$1 extends FunctionReferenceImpl implements Function2<PrintReducer.State, PrintReducer.Action, ReducerResult<PrintReducer.State, PrintReducer.Action>> {
    PrintReducer$build$1(Object obj) {
        super(2, obj, PrintReducer.class, "reducePrint", "reducePrint(Lcom/box/android/preview/previewtype/document/print/PrintReducer$State;Lcom/box/android/preview/previewtype/document/print/PrintReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<PrintReducer.State, PrintReducer.Action> invoke(PrintReducer.State p0, PrintReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((PrintReducer) this.receiver).reducePrint(p0, p1);
    }
}
