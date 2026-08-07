package com.box.android.boxai.qa;

import com.box.android.boxai.citations.BoxAiCitationsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiQaReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class BoxAiQaReducer$build$9 extends FunctionReferenceImpl implements Function1<BoxAiCitationsReducer.Action, BoxAiQaReducer.Action.CitationAction> {
    public static final BoxAiQaReducer$build$9 INSTANCE = new BoxAiQaReducer$build$9();

    BoxAiQaReducer$build$9() {
        super(1, BoxAiQaReducer.Action.CitationAction.class, "<init>", "<init>(Lcom/box/android/boxai/citations/BoxAiCitationsReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BoxAiQaReducer.Action.CitationAction invoke(BoxAiCitationsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new BoxAiQaReducer.Action.CitationAction(p0);
    }
}
