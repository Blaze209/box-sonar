package com.box.android.preview.item;

import com.box.android.preview.previewtype.document.DocumentPreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewReducer$build$4 extends FunctionReferenceImpl implements Function1<DocumentPreviewReducer.Action, ItemPreviewReducer.Action.DocumentPreview> {
    public static final ItemPreviewReducer$build$4 INSTANCE = new ItemPreviewReducer$build$4();

    ItemPreviewReducer$build$4() {
        super(1, ItemPreviewReducer.Action.DocumentPreview.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/document/DocumentPreviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemPreviewReducer.Action.DocumentPreview invoke(DocumentPreviewReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemPreviewReducer.Action.DocumentPreview(p0);
    }
}
