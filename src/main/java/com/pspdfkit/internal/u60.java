package com.pspdfkit.internal;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.pspdfkit.internal.ui.dialog.signatures.TypingElectronicSignatureCanvasView;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class u60 implements TextWatcher {
    public final float a;
    public final /* synthetic */ TypingElectronicSignatureCanvasView b;

    public u60(TypingElectronicSignatureCanvasView typingElectronicSignatureCanvasView) {
        this.b = typingElectronicSignatureCanvasView;
        EditText editText = typingElectronicSignatureCanvasView.s;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
            editText = null;
        }
        this.a = editText.getTextSize();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        float textSize;
        EditText editText = null;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            textSize = this.a;
        } else {
            TextView textView = this.b.u;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("autosizeHelper");
                textView = null;
            }
            textView.setText(charSequence.toString(), TextView.BufferType.EDITABLE);
            TextView textView2 = this.b.u;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("autosizeHelper");
                textView2 = null;
            }
            textSize = textView2.getTextSize();
        }
        EditText editText2 = this.b.s;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("typeSignature");
        } else {
            editText = editText2;
        }
        editText.setTextSize(0, textSize);
    }
}
