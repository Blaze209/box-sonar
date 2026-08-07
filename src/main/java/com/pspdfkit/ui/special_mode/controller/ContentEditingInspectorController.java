package com.pspdfkit.ui.special_mode.controller;

import android.os.Bundle;
import com.pspdfkit.contentediting.models.StyleInfo;
import com.pspdfkit.internal.pg;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ContentEditingInspectorController {
    void bindContentEditingController(ContentEditingController contentEditingController);

    void displayColorPicker(boolean z, StyleInfo styleInfo);

    void displayFontNamesSheet(boolean z, List<pg> list, StyleInfo styleInfo);

    void displayFontSizesSheet(boolean z, StyleInfo styleInfo);

    void displayLineSpacingSheet(boolean z, Float f);

    boolean isContentEditingInspectorVisible();

    void onRestoreInstanceState(Bundle bundle);

    void onSaveInstanceState(Bundle bundle);

    void unbindContentEditingController();
}
