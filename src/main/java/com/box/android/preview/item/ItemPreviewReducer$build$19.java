package com.box.android.preview.item;

import com.box.android.preview.previewtype.code.CodePreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewReducer$build$19 extends FunctionReferenceImpl implements Function1<CodePreviewReducer.State, ItemState.Code> {
    public static final ItemPreviewReducer$build$19 INSTANCE = new ItemPreviewReducer$build$19();

    ItemPreviewReducer$build$19() {
        super(1, ItemState.Code.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/code/CodePreviewReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemState.Code invoke(CodePreviewReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemState.Code(p0);
    }
}
