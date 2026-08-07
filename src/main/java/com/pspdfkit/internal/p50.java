package com.pspdfkit.internal;

import android.text.InputFilter;
import android.text.Spanned;
import com.pspdfkit.datastructures.Range;
import com.pspdfkit.forms.TextFormElement;
import com.pspdfkit.internal.jni.NativeJSError;
import com.pspdfkit.internal.jni.NativeJSEvent;
import com.pspdfkit.internal.jni.NativeJSResult;
import com.pspdfkit.internal.jni.NativeJSValue;
import com.pspdfkit.internal.jni.NativeTextRange;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class p50 implements InputFilter {
    public final TextFormElement a;

    public p50(TextFormElement textFormElement) {
        this.a = textFormElement;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        in inVar;
        NativeJSEvent event;
        charSequence.getClass();
        spanned.getClass();
        String string = charSequence.subSequence(i, i2).toString();
        TextFormElement textFormElement = this.a;
        String string2 = spanned.toString();
        Range range = new Range(i3, i4 - i3);
        string2.getClass();
        string.getClass();
        lm internalDocument = textFormElement.getAnnotation().getInternal().getInternalDocument();
        if (internalDocument == null || !internalDocument.l.d) {
            inVar = new in(StringsKt.replaceRange((CharSequence) string2, range.getStartPosition(), range.getEndPosition(), (CharSequence) string).toString());
        } else {
            NativeJSResult nativeJSResultExecuteKeystrokeEventForTextSelection = textFormElement.getFormField().getInternal().getNativeFormControl().executeKeystrokeEventForTextSelection(string2, string, new NativeTextRange(range.getStartPosition(), range.getLength(), new ArrayList(), new ArrayList()), false);
            nativeJSResultExecuteKeystrokeEventForTextSelection.getClass();
            if (nativeJSResultExecuteKeystrokeEventForTextSelection.getError() == null && ((event = nativeJSResultExecuteKeystrokeEventForTextSelection.getEvent()) == null || event.getRc())) {
                NativeJSValue value = nativeJSResultExecuteKeystrokeEventForTextSelection.getValue();
                inVar = new in(value != null ? value.getStringValue() : null);
            } else {
                NativeJSError error = nativeJSResultExecuteKeystrokeEventForTextSelection.getError();
                if (error != null) {
                    error.getMessage();
                }
                inVar = new in(null);
            }
        }
        String str = inVar.a;
        if (str != null) {
            if (Intrinsics.areEqual(str, StringsKt.replaceRange(spanned, i3, i4, string).toString())) {
                return null;
            }
            this.a.setText(str);
        }
        return spanned.subSequence(i3, i4);
    }
}
