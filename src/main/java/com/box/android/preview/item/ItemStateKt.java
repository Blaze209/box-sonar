package com.box.android.preview.item;

import com.box.android.preview.previewtype.boxnote.BoxNotePreviewReducer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemState.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"hasBoxNoteReachedEditorReadySurface", "", "Lcom/box/android/preview/item/ItemState;", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ItemStateKt {
    public static final boolean hasBoxNoteReachedEditorReadySurface(ItemState itemState) {
        Intrinsics.checkNotNullParameter(itemState, "<this>");
        ItemState.BoxNote boxNote = itemState instanceof ItemState.BoxNote ? (ItemState.BoxNote) itemState : null;
        return (boxNote != null ? boxNote.getState() : null) instanceof BoxNotePreviewReducer.State.EditorReady;
    }
}
