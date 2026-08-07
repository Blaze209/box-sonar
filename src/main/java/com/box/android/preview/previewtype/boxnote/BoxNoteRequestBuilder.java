package com.box.android.preview.previewtype.boxnote;

import android.util.Base64;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: BoxNoteRequestBuilder.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\nJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002¨\u0006\u0014"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNoteRequestBuilder;", "", "<init>", "()V", "setViewportHeight", "Lcom/box/android/preview/previewtype/boxnote/BoxNoteRequest;", "height", "", "setStyle", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_STYLE_TYPE, "", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_STYLE_VALUE, "setEditorFocus", "shouldBeFocused", "", "requestSelectedHtml", "insertHtmlString", "string", "uriAndBase64Encode", "unencodedString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxNoteRequestBuilder {
    public static final int $stable = 0;

    @Inject
    public BoxNoteRequestBuilder() {
    }

    public final BoxNoteRequest setViewportHeight(int height) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("height", String.valueOf(height));
        return new BoxNoteRequest(BoxNoteConstants.BOX_NOTE_COMMAND_SET_VIEWPORT, linkedHashMap);
    }

    public final BoxNoteRequest setStyle(String styleType) {
        Intrinsics.checkNotNullParameter(styleType, "styleType");
        return setStyle(styleType, null);
    }

    public final BoxNoteRequest setStyle(String styleType, String styleValue) {
        Intrinsics.checkNotNullParameter(styleType, "styleType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_STYLE_TYPE, styleType);
        if (styleValue != null) {
            linkedHashMap.put(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_STYLE_VALUE, styleValue);
        }
        return new BoxNoteRequest(BoxNoteConstants.BOX_NOTE_COMMAND_SET_STYLE, linkedHashMap);
    }

    public final BoxNoteRequest setEditorFocus(boolean shouldBeFocused) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("value", shouldBeFocused ? "on" : "off");
        return new BoxNoteRequest(BoxNoteConstants.BOX_NOTE_COMMAND_FOCUS_EDITOR, linkedHashMap);
    }

    public final BoxNoteRequest requestSelectedHtml() {
        return new BoxNoteRequest(BoxNoteConstants.BOX_NOTE_COMMAND_GET_SELECTED_HTML, new LinkedHashMap());
    }

    public final BoxNoteRequest insertHtmlString(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_ENCODED_HTML, uriAndBase64Encode(string));
        return new BoxNoteRequest(BoxNoteConstants.BOX_NOTE_COMMAND_INSERT_HTML, linkedHashMap);
    }

    private final String uriAndBase64Encode(String unencodedString) {
        try {
            String strEncode = URLEncoder.encode(unencodedString, "UTF-8");
            Intrinsics.checkNotNull(strEncode);
            byte[] bytes = strEncode.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return Base64.encodeToString(bytes, 0);
        } catch (UnsupportedEncodingException e) {
            BoxLogUtils.logException(e);
            return null;
        }
    }
}
