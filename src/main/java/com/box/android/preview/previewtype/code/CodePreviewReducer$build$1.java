package com.box.android.preview.previewtype.code;

import com.box.android.cpl.ReducerResult;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CodePreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class CodePreviewReducer$build$1 extends FunctionReferenceImpl implements Function2<CodePreviewReducer.State, CodePreviewReducer.Action, ReducerResult<CodePreviewReducer.State, CodePreviewReducer.Action>> {
    CodePreviewReducer$build$1(Object obj) {
        super(2, obj, CodePreviewReducer.class, "reduceCodePreview", "reduceCodePreview(Lcom/box/android/preview/previewtype/code/CodePreviewReducer$State;Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;)Lcom/box/android/cpl/ReducerResult;", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final ReducerResult<CodePreviewReducer.State, CodePreviewReducer.Action> invoke(CodePreviewReducer.State p0, CodePreviewReducer.Action p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return ((CodePreviewReducer) this.receiver).reduceCodePreview(p0, p1);
    }
}
