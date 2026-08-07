package com.pspdfkit.internal;

import android.app.Activity;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.media3.common.C;
import com.microsoft.intune.mam.client.view.MAMWindowManagement;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class fk implements View.OnSystemUiVisibilityChangeListener {
    public final dv a;
    public final Activity b;
    public boolean c;
    public final HashSet d = new HashSet();
    public boolean e = false;

    public static class a {
    }

    public fk(AppCompatActivity appCompatActivity, dv dvVar) {
        this.b = appCompatActivity;
        this.a = dvVar;
    }

    public final boolean a(boolean z) {
        if (this.b.isInMultiWindowMode()) {
            this.c = false;
        } else {
            this.c = z;
        }
        boolean z2 = this.c;
        Activity activity = this.b;
        if (z2) {
            int i = (uc.a(activity, 540) || !uc.d(this.b)) ? C.BUFFER_FLAG_FIRST_SAMPLE : 0;
            boolean zD = uc.d(this.b);
            Activity activity2 = this.b;
            if (zD) {
                activity2.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
            } else {
                activity2.getWindow().getAttributes().layoutInDisplayCutoutMode = 1;
            }
            this.b.getWindow().addFlags(i);
            this.b.getWindow().getDecorView().setSystemUiVisibility(1792);
            this.b.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(this);
        } else {
            MAMWindowManagement.clearFlags(activity.getWindow(), 134218752);
            this.b.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(null);
        }
        return this.c;
    }

    public final void b(boolean z) {
        if (z || this.d.isEmpty()) {
            this.d.clear();
            if (this.c) {
                this.e = true;
                this.b.getWindow().getDecorView().setSystemUiVisibility(3846);
            }
        }
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i) {
        if ((i & 2) == 0) {
            if (this.e) {
                return;
            }
            dv dvVar = this.a;
            if (!dvVar.m) {
                dvVar.showUserInterface();
            }
            dvVar.l(false);
            return;
        }
        this.e = false;
        dv dvVar2 = this.a;
        if (dvVar2.l && !dvVar2.k()) {
            int i2 = dv.c.b[((jv) dvVar2.b).getActiveViewType().ordinal()];
            if (i2 == 1 || i2 == 2) {
                jv jvVar = (jv) dvVar2.b;
                jvVar.toggleView(jvVar.getActiveViewType(), 0L);
            }
            dvVar2.a(false, false, false);
        }
        dvVar2.l(true);
    }

    public final void b() {
        if (this.a.l) {
            return;
        }
        b(false);
    }

    public final void a() {
        this.e = false;
        if (this.c) {
            this.b.getWindow().getDecorView().setSystemUiVisibility(1792);
        }
    }
}
