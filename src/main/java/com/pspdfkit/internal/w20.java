package com.pspdfkit.internal;

import android.view.MotionEvent;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w20 implements xi {
    @Override // com.pspdfkit.internal.xi
    public boolean a(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.pspdfkit.internal.xi
    public final boolean a(vi viVar, MotionEvent motionEvent) {
        int iOrdinal = viVar.ordinal();
        if (iOrdinal == 0) {
            return h(motionEvent);
        }
        if (iOrdinal == 1) {
            return e(motionEvent);
        }
        if (iOrdinal == 2) {
            return f(motionEvent);
        }
        if (iOrdinal == 3) {
            return g(motionEvent);
        }
        PdfLog.e("Nutri.Gestures", "Encountered unhandled gesture %s", viVar);
        return false;
    }

    @Override // com.pspdfkit.internal.xi
    public void b(MotionEvent motionEvent) {
    }

    @Override // com.pspdfkit.internal.xi
    public void c(MotionEvent motionEvent) {
    }

    @Override // com.pspdfkit.internal.xi
    public boolean d(MotionEvent motionEvent) {
        return false;
    }

    public boolean e(MotionEvent motionEvent) {
        return false;
    }

    public boolean f(MotionEvent motionEvent) {
        return false;
    }

    public boolean g(MotionEvent motionEvent) {
        return false;
    }

    public boolean h(MotionEvent motionEvent) {
        return this instanceof p7.a;
    }

    @Override // com.pspdfkit.internal.xi
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.pspdfkit.internal.xi
    public void onDown(MotionEvent motionEvent) {
    }

    @Override // com.pspdfkit.internal.xi
    public boolean onLongPress(MotionEvent motionEvent) {
        return false;
    }

    @Override // com.pspdfkit.internal.xi
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }
}
