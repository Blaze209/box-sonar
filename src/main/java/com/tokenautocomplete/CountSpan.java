package com.tokenautocomplete;

import android.text.Layout;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
class CountSpan extends CharacterStyle {
    private String countText = "";

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
    }

    CountSpan() {
    }

    void setCount(int i) {
        if (i > 0) {
            this.countText = String.format(Locale.getDefault(), " +%d", Integer.valueOf(i));
        } else {
            this.countText = "";
        }
    }

    String getCountText() {
        return this.countText;
    }

    float getCountTextWidthForPaint(TextPaint textPaint) {
        String str = this.countText;
        return Layout.getDesiredWidth(str, 0, str.length(), textPaint);
    }
}
