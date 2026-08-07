package com.pspdfkit.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.pspdfkit.contentediting.inspector.defaults.ContentEditingPreferencesManager;

/* JADX INFO: loaded from: classes3.dex */
public final class xa implements ContentEditingPreferencesManager {
    public final vw a;
    public final ia b = new ia();

    public xa(Context context) {
        this.a = new vw(context, "PSPDFKit");
    }

    @Override // com.pspdfkit.contentediting.inspector.defaults.ContentEditingPreferencesManager
    public final int getFillColor() {
        return this.a.a("content_editing_preferences_fill_color_", -16777216);
    }

    @Override // com.pspdfkit.contentediting.inspector.defaults.ContentEditingPreferencesManager
    public final void setFillColor(int i) {
        SharedPreferences.Editor editorEdit = this.a.a.edit();
        editorEdit.getClass();
        editorEdit.putInt("content_editing_preferences_fill_color_", i).apply();
    }
}
