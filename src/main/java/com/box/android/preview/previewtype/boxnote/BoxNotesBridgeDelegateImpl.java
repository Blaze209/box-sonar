package com.box.android.preview.previewtype.boxnote;

import android.os.SystemClock;
import android.text.Html;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.cpl.Store;
import com.box.android.domain.models.DomainError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BoxNoteBridgeDelegate.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0018\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0014H\u0016J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0014H\u0016J\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0014H\u0016J\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0017H\u0016J,\u0010$\u001a\u00020\u000f2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u0014H\u0002J&\u0010'\u001a\u00020\u000f2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\u0010(\u001a\u0004\u0018\u00010)H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006*"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotesBridgeDelegateImpl;", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteBridgeDelegate;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$State;", "Lcom/box/android/preview/previewtype/boxnote/BoxNotePreviewReducer$Action;", "<init>", "(Lcom/box/android/cpl/Store;)V", "loadStartTime", "", "getLoadStartTime", "()J", "setLoadStartTime", "(J)V", "onEditorReady", "", "onError", "errorCode", "", "description", "", "onEditorFocus", "isFocused", "", "onConnectionStateChanged", "value", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "onStyleChanged", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_STYLE_TYPE, BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_STYLE_VALUE, "onExternalLinkClicked", "uri", "onSelectedHtmlFetched", "selectedHtml", "onSelectionChanged", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_HAS_SELECTION, "sendTextEvent", "textStyle", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$TextStyle;", "sendListEvent", "listStyle", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteEditModeReducer$ListStyle;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxNotesBridgeDelegateImpl implements BoxNoteBridgeDelegate {
    public static final int $stable = 8;
    private long loadStartTime;
    private final Store<BoxNotePreviewReducer.State, BoxNotePreviewReducer.Action> store;

    public BoxNotesBridgeDelegateImpl(Store<BoxNotePreviewReducer.State, BoxNotePreviewReducer.Action> store) {
        Intrinsics.checkNotNullParameter(store, "store");
        this.store = store;
    }

    public final long getLoadStartTime() {
        return this.loadStartTime;
    }

    public final void setLoadStartTime(long j) {
        this.loadStartTime = j;
    }

    @Override // com.box.android.preview.previewtype.boxnote.BoxNoteBridgeDelegate
    public void onEditorReady() {
        this.store.send(new BoxNotePreviewReducer.Action.EditorReady(this.loadStartTime > 0 ? SystemClock.uptimeMillis() - this.loadStartTime : 0L));
    }

    @Override // com.box.android.preview.previewtype.boxnote.BoxNoteBridgeDelegate
    public void onError(int errorCode, String description) {
        if (errorCode != -2) {
            this.store.send(new BoxNotePreviewReducer.Action.Error(new DomainError.CustomError("Notes error: " + description)));
        }
    }

    @Override // com.box.android.preview.previewtype.boxnote.BoxNoteBridgeDelegate
    public void onEditorFocus(boolean isFocused) {
        this.store.send(new BoxNotePreviewReducer.Action.EditorFocusChanged(isFocused));
    }

    @Override // com.box.android.preview.previewtype.boxnote.BoxNoteBridgeDelegate
    public void onConnectionStateChanged(String value, String reason) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.store.send(new BoxNotePreviewReducer.Action.ConnectionStateChanged(value, reason));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.box.android.preview.previewtype.boxnote.BoxNoteBridgeDelegate
    public void onStyleChanged(String styleType, String styleValue) {
        Intrinsics.checkNotNullParameter(styleType, "styleType");
        Intrinsics.checkNotNullParameter(styleValue, "styleValue");
        switch (styleType.hashCode()) {
            case -1178781136:
                if (styleType.equals("italic")) {
                    sendTextEvent(this.store, BoxNoteEditModeReducer.TextStyle.ITALIC, styleValue);
                    break;
                }
                break;
            case -1026963764:
                if (styleType.equals("underline")) {
                    sendTextEvent(this.store, BoxNoteEditModeReducer.TextStyle.UNDERLINE, styleValue);
                    break;
                }
                break;
            case 3029637:
                if (styleType.equals("bold")) {
                    sendTextEvent(this.store, BoxNoteEditModeReducer.TextStyle.BOLD, styleValue);
                    break;
                }
                break;
            case 3322014:
                if (styleType.equals(BoxNoteConstants.BOX_NOTE_STYLE_TYPE_LIST)) {
                    int iHashCode = styleValue.hashCode();
                    if (iHashCode == -1377934078) {
                        if (styleValue.equals(BoxNoteConstants.BOX_NOTE_STYLE_TYPE_BULLET)) {
                            sendListEvent(this.store, BoxNoteEditModeReducer.ListStyle.BULLET);
                        }
                    } else if (iHashCode == -1034364087) {
                        if (styleValue.equals("number")) {
                            sendListEvent(this.store, BoxNoteEditModeReducer.ListStyle.NUMBER);
                        }
                    } else if (iHashCode == 399298982 && styleValue.equals(BoxNoteConstants.BOX_NOTE_STYLE_TYPE_CHECK)) {
                        sendListEvent(this.store, BoxNoteEditModeReducer.ListStyle.CHECK);
                    }
                    sendListEvent(this.store, null);
                    break;
                }
                break;
        }
    }

    @Override // com.box.android.preview.previewtype.boxnote.BoxNoteBridgeDelegate
    public void onExternalLinkClicked(String uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        CommonBoxUtil.launchURL(uri);
    }

    @Override // com.box.android.preview.previewtype.boxnote.BoxNoteBridgeDelegate
    public void onSelectedHtmlFetched(String selectedHtml) {
        Intrinsics.checkNotNullParameter(selectedHtml, "selectedHtml");
        this.store.send(new BoxNotePreviewReducer.Action.EditModeAction(new BoxNoteEditModeReducer.Action.SelectedTextRetrieved(StringsKt.trim((CharSequence) Html.fromHtml(selectedHtml).toString()).toString())));
    }

    @Override // com.box.android.preview.previewtype.boxnote.BoxNoteBridgeDelegate
    public void onSelectionChanged(boolean hasSelection) {
        if (hasSelection) {
            this.store.send(new BoxNotePreviewReducer.Action.EditModeAction(BoxNoteEditModeReducer.Action.EnterSelectionMode.INSTANCE));
        } else {
            this.store.send(new BoxNotePreviewReducer.Action.EditModeAction(BoxNoteEditModeReducer.Action.ExitSelectionMode.INSTANCE));
        }
    }

    private final void sendTextEvent(Store<BoxNotePreviewReducer.State, BoxNotePreviewReducer.Action> store, BoxNoteEditModeReducer.TextStyle textStyle, String styleValue) {
        store.send(new BoxNotePreviewReducer.Action.EditModeAction(new BoxNoteEditModeReducer.Action.TextStyleChanged(textStyle, Intrinsics.areEqual(styleValue, "on"))));
    }

    private final void sendListEvent(Store<BoxNotePreviewReducer.State, BoxNotePreviewReducer.Action> store, BoxNoteEditModeReducer.ListStyle listStyle) {
        store.send(new BoxNotePreviewReducer.Action.EditModeAction(new BoxNoteEditModeReducer.Action.ListStyleChanged(listStyle)));
    }
}
