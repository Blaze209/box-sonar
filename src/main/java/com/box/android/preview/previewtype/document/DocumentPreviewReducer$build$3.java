package com.box.android.preview.previewtype.document;

import com.box.android.preview.annotations.cpl.AnnotationsReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class DocumentPreviewReducer$build$3 extends FunctionReferenceImpl implements Function1<AnnotationsReducer.Action, DocumentPreviewReducer.Action.Annotations> {
    public static final DocumentPreviewReducer$build$3 INSTANCE = new DocumentPreviewReducer$build$3();

    DocumentPreviewReducer$build$3() {
        super(1, DocumentPreviewReducer.Action.Annotations.class, "<init>", "<init>(Lcom/box/android/preview/annotations/cpl/AnnotationsReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final DocumentPreviewReducer.Action.Annotations invoke(AnnotationsReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new DocumentPreviewReducer.Action.Annotations(p0);
    }
}
