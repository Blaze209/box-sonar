package com.pspdfkit.internal;

import android.text.InputFilter;
import android.text.Spanned;
import com.pspdfkit.forms.ComboBoxFormElement;
import com.pspdfkit.internal.jni.NativeJSError;
import com.pspdfkit.internal.jni.NativeJSEvent;
import com.pspdfkit.internal.jni.NativeJSResult;
import com.pspdfkit.internal.jni.NativeJSValue;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class k9 implements InputFilter {
    public final ComboBoxFormElement a;

    public k9(ComboBoxFormElement comboBoxFormElement) {
        comboBoxFormElement.getClass();
        this.a = comboBoxFormElement;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        in inVar;
        NativeJSEvent event;
        charSequence.getClass();
        spanned.getClass();
        String string = StringsKt.replaceRange((CharSequence) spanned.toString(), i3, i4, (CharSequence) charSequence.subSequence(i, i2).toString()).toString();
        ComboBoxFormElement comboBoxFormElement = this.a;
        comboBoxFormElement.getClass();
        string.getClass();
        lm internalDocument = comboBoxFormElement.getAnnotation().getInternal().getInternalDocument();
        if (internalDocument == null || !internalDocument.l.d) {
            inVar = new in(string);
        } else {
            NativeJSResult nativeJSResultExecuteKeystrokeEventForComboOrListFields = comboBoxFormElement.getFormField().getInternal().getNativeFormControl().executeKeystrokeEventForComboOrListFields(string);
            nativeJSResultExecuteKeystrokeEventForComboOrListFields.getClass();
            if (nativeJSResultExecuteKeystrokeEventForComboOrListFields.getError() == null && ((event = nativeJSResultExecuteKeystrokeEventForComboOrListFields.getEvent()) == null || event.getRc())) {
                NativeJSValue value = nativeJSResultExecuteKeystrokeEventForComboOrListFields.getValue();
                inVar = new in(value != null ? value.getStringValue() : null);
            } else {
                NativeJSError error = nativeJSResultExecuteKeystrokeEventForComboOrListFields.getError();
                if (error != null) {
                    error.getMessage();
                }
                inVar = new in(null);
            }
        }
        String str = inVar.a;
        if (str != null) {
            if (Intrinsics.areEqual(str, string)) {
                return null;
            }
            this.a.setCustomText(str);
        }
        return spanned.subSequence(i3, i4);
    }
}
