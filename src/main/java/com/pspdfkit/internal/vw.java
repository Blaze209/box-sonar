package com.pspdfkit.internal;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class vw {
    public final SharedPreferences a;

    public vw(final Context context, final String str) {
        context.getClass();
        Object objA = s40.a((Function0<? extends Object>) new Function0() { // from class: com.pspdfkit.internal.vw$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return vw.a(context, str);
            }
        });
        objA.getClass();
        this.a = (SharedPreferences) objA;
    }

    public static final SharedPreferences a(Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }

    public final boolean a(final String str, final boolean z) {
        return ((Boolean) s40.a(new Function0() { // from class: com.pspdfkit.internal.vw$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(vw.a(this.f$0, str, z));
            }
        })).booleanValue();
    }

    public static final boolean a(vw vwVar, String str, boolean z) {
        return vwVar.a.getBoolean(str, z);
    }

    public final int a(final String str, final int i) {
        return ((Number) s40.a(new Function0() { // from class: com.pspdfkit.internal.vw$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(vw.a(this.f$0, str, i));
            }
        })).intValue();
    }

    public static final int a(vw vwVar, String str, int i) {
        return vwVar.a.getInt(str, i);
    }

    public final float a(final String str, final float f) {
        return ((Number) s40.a(new Function0() { // from class: com.pspdfkit.internal.vw$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Float.valueOf(vw.a(this.f$0, str, f));
            }
        })).floatValue();
    }

    public static final float a(vw vwVar, String str, float f) {
        return vwVar.a.getFloat(str, f);
    }

    public final String a(final String str, final String str2) {
        return (String) s40.a(new Function0() { // from class: com.pspdfkit.internal.vw$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return vw.a(this.f$0, str, str2);
            }
        });
    }

    public static final String a(vw vwVar, String str, String str2) {
        return vwVar.a.getString(str, str2);
    }
}
