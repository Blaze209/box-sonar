package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeFormChoiceFlags;
import com.pspdfkit.internal.jni.NativeFormControl;
import com.pspdfkit.internal.jni.NativeFormField;
import com.pspdfkit.internal.jni.NativeFormFlags;
import com.pspdfkit.internal.jni.NativeFormTextFlags;
import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public interface em {
    EnumSet<NativeFormChoiceFlags> getChoiceFlags();

    EnumSet<NativeFormFlags> getFlags();

    NativeFormControl getNativeFormControl();

    NativeFormField getNativeFormField();

    EnumSet<NativeFormTextFlags> getTextFlags();

    void setChoiceFlags(EnumSet<NativeFormChoiceFlags> enumSet);

    void setFlags(EnumSet<NativeFormFlags> enumSet);

    void setTextFlags(EnumSet<NativeFormTextFlags> enumSet);
}
