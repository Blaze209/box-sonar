package com.pspdfkit.internal;

import android.graphics.Rect;
import android.text.DynamicLayout;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import com.pspdfkit.forms.TextFormElement;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class ur implements InputFilter {
    public final q50 a;
    public final Rect b = new Rect();

    public ur(q50 q50Var) {
        this.a = q50Var;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        CharSequence charSequenceDropLast;
        float textSize;
        int iRound;
        float textSize2;
        charSequence.getClass();
        spanned.getClass();
        CharSequence charSequenceSubSequence = charSequence.subSequence(i, i2);
        TextPaint textPaint = new TextPaint();
        textPaint.set(this.a.getPaint());
        if (this.a.getMaxLines() == 1) {
            int width = (this.a.getWidth() - this.a.getPaddingLeft()) - this.a.getPaddingRight();
            charSequenceDropLast = charSequenceSubSequence;
            while (charSequenceDropLast.length() > 0) {
                String string = StringsKt.replaceRange(spanned, i3, i4, charSequenceDropLast).toString();
                q50 q50Var = this.a;
                string.getClass();
                TextFormElement formElement = q50Var.getFormElement();
                if (formElement != null) {
                    textSize2 = s60.a(q50Var.getPdfToViewMatrix()) * q50Var.a(formElement, string);
                } else {
                    textSize2 = q50Var.getTextSize();
                }
                textPaint.setTextSize(textSize2);
                textPaint.getTextBounds(string, 0, string.length(), this.b);
                if (this.b.width() < width) {
                    break;
                }
                charSequenceDropLast = StringsKt.dropLast(charSequenceDropLast, 1);
            }
        } else {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(StringsKt.replaceRange(spanned, i3, i4, charSequenceSubSequence));
            Layout layout = this.a.getLayout();
            if (layout != null) {
                DynamicLayout dynamicLayout = new DynamicLayout(spannableStringBuilder, textPaint, layout.getWidth(), layout.getAlignment(), layout.getSpacingMultiplier(), layout.getSpacingAdd(), false);
                CharSequence charSequenceDropLast2 = charSequenceSubSequence;
                while (charSequenceDropLast2.length() > 0) {
                    q50 q50Var2 = this.a;
                    String string2 = spannableStringBuilder.toString();
                    string2.getClass();
                    TextFormElement formElement2 = q50Var2.getFormElement();
                    if (formElement2 != null) {
                        textSize = s60.a(q50Var2.getPdfToViewMatrix()) * q50Var2.a(formElement2, string2);
                    } else {
                        textSize = q50Var2.getTextSize();
                    }
                    textPaint.setTextSize(textSize);
                    int height = this.a.getHeight() - this.a.getPaddingBottom();
                    q50 q50Var3 = this.a;
                    TextFormElement formElement3 = q50Var3.getFormElement();
                    if (formElement3 != null && formElement3.isMultiLine() && StringsKt.contains$default((CharSequence) spannableStringBuilder.toString(), (CharSequence) "\n", false, 2, (Object) null)) {
                        iRound = Math.round(s60.a(q50Var3.getPdfToViewMatrix()) * Math.max(1.0f, 1.0f) * 1.5f);
                    } else {
                        iRound = 0;
                    }
                    int i5 = height - iRound;
                    if (dynamicLayout.getLineCount() == 1 || dynamicLayout.getHeight() < i5) {
                        break;
                    }
                    charSequenceDropLast2 = StringsKt.dropLast(charSequenceDropLast2, 1);
                    spannableStringBuilder.replace(0, spannableStringBuilder.length(), StringsKt.replaceRange(spanned, i3, i4, charSequenceDropLast2));
                }
                charSequenceDropLast = charSequenceDropLast2;
            } else {
                charSequenceDropLast = charSequenceSubSequence;
            }
        }
        if (Intrinsics.areEqual(charSequenceDropLast, charSequenceSubSequence)) {
            return null;
        }
        return charSequenceDropLast;
    }
}
