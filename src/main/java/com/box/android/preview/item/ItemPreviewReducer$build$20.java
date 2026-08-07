package com.box.android.preview.item;

import com.box.android.preview.previewtype.code.CodePreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewReducer$build$20 extends FunctionReferenceImpl implements Function1<CodePreviewReducer.Action, ItemPreviewReducer.Action.CodePreview> {
    public static final ItemPreviewReducer$build$20 INSTANCE = new ItemPreviewReducer$build$20();

    ItemPreviewReducer$build$20() {
        super(1, ItemPreviewReducer.Action.CodePreview.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/code/CodePreviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemPreviewReducer.Action.CodePreview invoke(CodePreviewReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemPreviewReducer.Action.CodePreview(p0);
    }
}
