package com.box.android.preview.previewtype.boxnote;

import kotlin.Metadata;

/* JADX INFO: compiled from: BoxNoteBridgeDelegate.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000bH&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000bH&J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0006H&¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteBridgeDelegate;", "", "onEditorReady", "", "onEditorFocus", "isFocused", "", "onError", "errorCode", "", "description", "", "onStyleChanged", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_STYLE_TYPE, BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_STYLE_VALUE, "onExternalLinkClicked", "uri", "onSelectedHtmlFetched", "selectedHtml", "onConnectionStateChanged", "value", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "onSelectionChanged", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_HAS_SELECTION, "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface BoxNoteBridgeDelegate {
    void onConnectionStateChanged(String value, String reason);

    void onEditorFocus(boolean isFocused);

    void onEditorReady();

    void onError(int errorCode, String description);

    void onExternalLinkClicked(String uri);

    void onSelectedHtmlFetched(String selectedHtml);

    void onSelectionChanged(boolean hasSelection);

    void onStyleChanged(String styleType, String styleValue);
}
