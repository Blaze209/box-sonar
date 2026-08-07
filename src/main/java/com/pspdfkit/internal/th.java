package com.pspdfkit.internal;

import android.content.ContentResolver;
import android.provider.Settings;
import com.pspdfkit.forms.TextInputFormat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class th {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[TextInputFormat.values().length];
            try {
                iArr[TextInputFormat.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextInputFormat.DATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextInputFormat.TIME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final int a(TextInputFormat textInputFormat, ContentResolver contentResolver) {
        textInputFormat.getClass();
        return ((textInputFormat == TextInputFormat.NUMBER && Intrinsics.areEqual("com.samsung.android.honeyboard/.service.HoneyBoardService", Settings.Secure.getString(contentResolver, "default_input_method"))) || a.a[textInputFormat.ordinal()] != 1) ? 1 : 8194;
    }
}
