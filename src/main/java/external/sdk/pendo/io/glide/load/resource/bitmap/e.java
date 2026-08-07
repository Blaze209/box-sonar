package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public final class e {
    public static final boolean e = false;
    public static final boolean f = true;
    private static final File g = new File("/proc/self/fd");
    private static volatile e h;
    private int b;
    private boolean c = true;
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final int a = 20000;

    e() {
    }

    private boolean a() {
        return e && !this.d.get();
    }

    public static e b() {
        if (h == null) {
            synchronized (e.class) {
                if (h == null) {
                    h = new e();
                }
            }
        }
        return h;
    }

    private int c() {
        if (e()) {
            return 500;
        }
        return this.a;
    }

    private synchronized boolean d() {
        boolean z = true;
        int i = this.b + 1;
        this.b = i;
        if (i >= 50) {
            this.b = 0;
            int length = g.list().length;
            long jC = c();
            if (length >= jC) {
                z = false;
            }
            this.c = z;
            if (!z && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + jC);
            }
        }
        return this.c;
    }

    private static boolean e() {
        return false;
    }

    public void f() {
        l.b();
        this.d.set(true);
    }

    public boolean a(int i, int i2, boolean z, boolean z2) {
        if (!z) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!f) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (a()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z2) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        if (i < 0 || i2 < 0) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
            }
            return false;
        }
        if (d()) {
            return true;
        }
        if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
        }
        return false;
    }

    boolean a(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean zA = a(i, i2, z, z2);
        if (zA) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zA;
    }
}
