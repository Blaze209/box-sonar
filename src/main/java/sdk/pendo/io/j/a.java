package sdk.pendo.io.j;

import android.app.ActivityManager;
import android.content.Context;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private final int a;
    private final int b;
    private final Context c;
    private final int d;

    /* JADX INFO: renamed from: sdk.pendo.io.j.a$a, reason: collision with other inner class name */
    public static final class C0399a {
        static final int i = 1;
        final Context a;
        ActivityManager b;
        c c;
        float e;
        float d = 2.0f;
        float f = 0.4f;
        float g = 0.33f;
        int h = 4194304;

        public C0399a(Context context) {
            this.e = i;
            this.a = context;
            this.b = (ActivityManager) context.getSystemService("activity");
            this.c = new b(context.getResources().getDisplayMetrics());
            if (a.a(this.b)) {
                this.e = 0.0f;
            }
        }

        public a a() {
            return new a(this);
        }
    }

    private static final class b implements c {
        private final DisplayMetrics a;

        b(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }

        @Override // sdk.pendo.io.j.a.c
        public int a() {
            return this.a.heightPixels;
        }

        @Override // sdk.pendo.io.j.a.c
        public int b() {
            return this.a.widthPixels;
        }
    }

    interface c {
        int a();

        int b();
    }

    a(C0399a c0399a) {
        this.c = c0399a.a;
        int i = a(c0399a.b) ? c0399a.h / 2 : c0399a.h;
        this.d = i;
        int iA = a(c0399a.b, c0399a.f, c0399a.g);
        float fB = c0399a.c.b() * c0399a.c.a() * 4;
        int iRound = Math.round(c0399a.e * fB);
        int iRound2 = Math.round(fB * c0399a.d);
        int i2 = iA - i;
        int i3 = iRound2 + iRound;
        if (i3 <= i2) {
            this.b = iRound2;
            this.a = iRound;
        } else {
            float f = i2;
            float f2 = c0399a.e;
            float f3 = c0399a.d;
            float f4 = f / (f2 + f3);
            this.b = Math.round(f3 * f4);
            this.a = Math.round(f4 * c0399a.e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Log.d("MemorySizeCalculator", "Calculation complete, Calculated memory cache size: " + a(this.b) + ", pool size: " + a(this.a) + ", byte array size: " + a(i) + ", memory class limited? " + (i3 > iA) + ", max size: " + a(iA) + ", memoryClass: " + c0399a.b.getMemoryClass() + ", isLowMemoryDevice: " + a(c0399a.b));
        }
    }

    public int a() {
        return this.d;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    private static int a(ActivityManager activityManager, float f, float f2) {
        float memoryClass = activityManager.getMemoryClass() * 1048576;
        if (a(activityManager)) {
            f = f2;
        }
        return Math.round(memoryClass * f);
    }

    static boolean a(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String a(int i) {
        return Formatter.formatFileSize(this.c, i);
    }
}
