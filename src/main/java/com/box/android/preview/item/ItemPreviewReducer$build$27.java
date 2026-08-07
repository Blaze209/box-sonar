package com.box.android.preview.item;

import com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemPreviewReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class ItemPreviewReducer$build$27 extends FunctionReferenceImpl implements Function1<BoxNotePreviewReducer.State, ItemState.BoxNote> {
    public static final ItemPreviewReducer$build$27 INSTANCE = new ItemPreviewReducer$build$27();

    ItemPreviewReducer$build$27() {
        super(1, ItemState.BoxNote.class, "<init>", "<init>(Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final ItemState.BoxNote invoke(BoxNotePreviewReducer.State p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return new ItemState.BoxNote(p0);
    }
}
