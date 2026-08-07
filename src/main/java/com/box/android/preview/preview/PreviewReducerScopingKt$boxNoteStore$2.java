package com.box.android.preview.preview;

import com.box.android.preview.item.ItemPreviewReducer;
import com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewReducerScoping.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviewReducerScopingKt$boxNoteStore$2 extends FunctionReferenceImpl implements Function1<BoxNotePreviewReducer.Action, ItemPreviewReducer.Action.BoxNotePreview> {
    public static final PreviewReducerScopingKt$boxNoteStore$2 INSTANCE = new PreviewReducerScopingKt$boxNoteStore$2();

    PreviewReducerScopingKt$boxNoteStore$2() {
        super(1, ItemPreviewReducer.Action.BoxNotePreview.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemPreviewReducer.Action.BoxNotePreview invoke(BoxNotePreviewReducer.Action p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemPreviewReducer.Action.BoxNotePreview(p0);
    }
}
