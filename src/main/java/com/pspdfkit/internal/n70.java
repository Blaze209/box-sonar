package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.TypedValue;
import androidx.appcompat.R;
import com.android.tools.r8.RecordTag;
import com.pspdfkit.exceptions.InvalidThemeException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class n70 {
    public static AtomicBoolean a;

    public static final class a<K, V> extends RecordTag {
        public final String a;
        public final Integer b;

        private /* synthetic */ boolean $record$equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.a, aVar.a) && Objects.equals(this.b, aVar.b);
        }

        private /* synthetic */ Object[] $record$getFieldsAsObjects() {
            return new Object[]{this.a, this.b};
        }

        public a(String str, Integer num) {
            this.a = str;
            this.b = num;
        }

        public final boolean equals(Object obj) {
            return $record$equals(obj);
        }

        public final int hashCode() {
            return n70$a$$ExternalSyntheticRecord0.m(this.a, this.b);
        }

        public final String toString() {
            return n70$a$$ExternalSyntheticRecord0.m($record$getFieldsAsObjects(), a.class, "a;b");
        }
    }

    public static <T extends Enum<T>> void a(EnumSet<T> enumSet, T t, boolean z) {
        if (z) {
            if (enumSet.contains(t)) {
                return;
            }
            enumSet.add(t);
        } else if (enumSet.contains(t)) {
            enumSet.remove(t);
        }
    }

    public static ArrayList a(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i : iArr) {
            arrayList.add(Integer.valueOf(i));
        }
        return arrayList;
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        return str != null && str.equals(str2);
    }

    public static void a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.styleable.AppCompatTheme);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBar, true);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false);
        if (!z && z2) {
            if (context.getTheme().resolveAttribute(com.google.android.material.R.attr.colorSecondary, new TypedValue(), true) && typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_colorPrimary) && typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_colorPrimaryDark) && typedArrayObtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_colorAccent)) {
                typedArrayObtainStyledAttributes.recycle();
                return;
            }
            throw new InvalidThemeException("The theme used by the provided context does not specify values for theme color attributes. Please use a Theme.MaterialComponents.NoActionBar theme and define your colors for the colorPrimary, colorSecondary, colorPrimaryDark, and colorAccent attributes.");
        }
        throw new InvalidThemeException("The theme used by the provided context does not disable the decor window action bar. Please use a theme that sets 'windowActionBar' to false and 'windowNoTitle' to true (e.g. Theme.MaterialComponents.NoActionBar) or define those values in your custom theme and apply it to the context.");
    }
}
