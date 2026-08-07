package com.pspdfkit.internal;

import com.pspdfkit.internal.jni.NativeJSAlertResult;

/* JADX INFO: loaded from: classes3.dex */
public final class pr {
    public static final NativeJSAlertResult a(bn bnVar) {
        Enum r1;
        Enum[] enumArr = (Enum[]) bn.class.getEnumConstants();
        if (enumArr == null) {
            throw new IllegalArgumentException("Source enum class must have enum constants.");
        }
        Enum[] enumArr2 = (Enum[]) NativeJSAlertResult.class.getEnumConstants();
        if (enumArr2 == null) {
            throw new IllegalArgumentException("Target enum class must have enum constants.");
        }
        if (enumArr.length != enumArr2.length) {
            throw new IllegalArgumentException("Enum classes must have the same number of constants.");
        }
        Enum[] enumArr3 = (Enum[]) NativeJSAlertResult.class.getEnumConstants();
        if (enumArr3 == null || (r1 = enumArr3[bnVar.ordinal()]) == null) {
            throw new IllegalArgumentException("Could not map enum value " + bnVar + " to " + NativeJSAlertResult.class + ".");
        }
        return (NativeJSAlertResult) r1;
    }
}
