package com.pspdfkit.internal;

import android.view.MotionEvent;
import com.pspdfkit.preferences.PSPDFKitPreferences;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes3.dex */
public final class br {
    @JvmStatic
    public static final boolean a(MotionEvent motionEvent) {
        motionEvent.getClass();
        int toolType = motionEvent.getToolType(motionEvent.getActionIndex());
        return toolType == 2 || toolType == 4;
    }

    @JvmStatic
    public static final boolean a(MotionEvent motionEvent, boolean z, PSPDFKitPreferences pSPDFKitPreferences) {
        motionEvent.getClass();
        pSPDFKitPreferences.getClass();
        if (!x40.a()) {
            return true;
        }
        boolean zA = a(motionEvent);
        if (zA && z && !pSPDFKitPreferences.useStylusForAnnotating().booleanValue()) {
            pSPDFKitPreferences.setUseStylusForAnnotating(true);
        }
        return !pSPDFKitPreferences.useStylusForAnnotating().booleanValue() || zA;
    }
}
