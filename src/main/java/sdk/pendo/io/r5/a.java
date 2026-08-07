package sdk.pendo.io.r5;

import android.os.Handler;
import android.os.HandlerThread;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.n;

/* JADX INFO: loaded from: classes4.dex */
class a {
    private File a;
    private int b;
    private int c;
    private final AtomicInteger d;
    private final AtomicInteger e;
    private float f;
    private float g;
    private final AtomicLong h;
    private final AtomicBoolean i;
    private boolean j;
    private boolean k;
    private e l;
    private Runnable m;
    private final Runnable n;
    private final d o;

    /* JADX INFO: renamed from: sdk.pendo.io.r5.a$a, reason: collision with other inner class name */
    class RunnableC0473a implements Runnable {
        RunnableC0473a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = a.this.d.get();
            a aVar = a.this;
            if (i > 0) {
                aVar.o.a(aVar.j);
            } else {
                aVar.a(aVar.b);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    File file = a.this.a;
                    if (file != null && file.length() != 0) {
                        if (a.this.h.get() >= a.this.a.length()) {
                            n.a(a.this.a);
                        } else if (a.this.h.get() > 0) {
                            a aVar = a.this;
                            String strA = n.a(aVar.a, aVar.h.get(), (n.a) null);
                            n.a(a.this.a);
                            if (!strA.isEmpty()) {
                                n.a(a.this.a, strA.getBytes(Charset.forName("UTF-8")));
                            }
                        }
                        AtomicInteger atomicInteger = a.this.d;
                        atomicInteger.set(atomicInteger.get() - a.this.e.get());
                    }
                    a.this.m();
                } catch (Exception e) {
                    PendoLogger.e(e, e.getMessage(), new Object[0]);
                }
            } finally {
                a aVar2 = a.this;
                aVar2.a(aVar2.b);
            }
        }
    }

    class c implements n.a {
        c() {
        }

        @Override // sdk.pendo.io.s7.n.a
        public void a(long j) {
            a.this.h.set(j);
            if (j > 0) {
                a aVar = a.this;
                aVar.e.set(aVar.d.get());
                a.this.i.set(true);
            }
        }
    }

    interface d {
        void a(boolean z);
    }

    static class e extends HandlerThread {
        private Handler a;
        private Thread.UncaughtExceptionHandler b;

        /* JADX INFO: renamed from: sdk.pendo.io.r5.a$e$a, reason: collision with other inner class name */
        class C0474a implements Thread.UncaughtExceptionHandler {
            C0474a() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                PendoLogger.e(th, thread.getName() + " " + th.getMessage(), new Object[0]);
            }
        }

        public e(String str) {
            super(str);
        }

        public void a(Runnable runnable) {
            if (this.a == null) {
                a();
            }
            this.a.post(runnable);
        }

        public void b(Runnable runnable) {
            Handler handler = this.a;
            if (handler != null) {
                handler.removeCallbacks(runnable);
            }
        }

        public void a(Runnable runnable, long j) {
            if (this.a == null) {
                a();
            }
            this.a.postDelayed(runnable, j);
        }

        public void a() {
            this.a = new Handler(getLooper());
            C0474a c0474a = new C0474a();
            this.b = c0474a;
            setUncaughtExceptionHandler(c0474a);
        }
    }

    a(String str, int i, int i2, float f, float f2, d dVar) {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.d = atomicInteger;
        this.e = new AtomicInteger();
        this.h = new AtomicLong();
        this.i = new AtomicBoolean();
        this.m = new RunnableC0473a();
        this.n = new b();
        this.b = i;
        this.c = i2;
        this.o = dVar;
        this.f = f;
        this.g = f2;
        try {
            File fileA = n.a(PendoInternal.o(), str);
            this.a = fileA;
            if (fileA.length() > 0) {
                atomicInteger.set(a());
            }
            c();
            a(this.b);
        } catch (IOException e2) {
            PendoLogger.e(e2, e2.getMessage(), new Object[0]);
            this.a = null;
            this.l.quit();
        } catch (Exception e3) {
            PendoLogger.e(e3, e3.getMessage(), new Object[0]);
            this.l.quit();
        }
    }

    private int a() {
        return e().length - 1;
    }

    private synchronized void c() {
        e eVar = new e(this.a.getName() + " worker");
        this.l = eVar;
        eVar.start();
        this.l.a();
    }

    private synchronized String[] e() {
        return n.a(this.a, 0L, (n.a) null).split("\\}\\|\\{");
    }

    private boolean k() {
        return this.i.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.i.set(false);
        this.h.set(0L);
        this.e.set(0);
    }

    synchronized void b() {
        File file = this.a;
        if (file != null) {
            n.a(file);
            this.d.set(0);
            m();
            o();
        }
    }

    synchronized void d() {
        File file = this.a;
        if (file != null) {
            if (!file.delete()) {
                PendoLogger.w("AnalyticEventsBuffer couldn't delete the file " + this.a.getName(), new Object[0]);
            }
            m();
            o();
            this.a = null;
        }
        e eVar = this.l;
        if (eVar != null) {
            eVar.quit();
        }
    }

    public synchronized e f() {
        if (this.l == null) {
            c();
        }
        return this.l;
    }

    int g() {
        return this.e.get();
    }

    synchronized String h() {
        return n.a(this.a, 0L, new c());
    }

    int i() {
        return this.d.get();
    }

    synchronized void j() {
        File file = this.a;
        if (file != null && this.f != -1.0f && file.length() > this.f) {
            long length = (long) (this.a.length() - (this.f * this.g));
            String strA = n.a(this.a, length, (n.a) null);
            int length2 = strA.split("\\}\\|\\{").length - 1;
            int i = this.d.get() - length2;
            int iIndexOf = strA.indexOf("}|{");
            float length3 = length + ((long) strA.substring(0, iIndexOf).length());
            this.d.set(length2);
            if (this.h.get() > length3) {
                AtomicLong atomicLong = this.h;
                atomicLong.set((long) (atomicLong.get() - length3));
                AtomicInteger atomicInteger = this.e;
                atomicInteger.set(atomicInteger.get() - i);
            } else {
                this.h.set(0L);
                this.e.set(0);
            }
            n.a(this.a);
            if (this.d.get() > 0) {
                n.a(this.a, strA.substring(iIndexOf).getBytes(Charset.forName("UTF-8")));
            }
        }
    }

    public synchronized String l() {
        return n.a(this.a, 0L, (n.a) null);
    }

    public void n() {
        this.i.set(false);
    }

    synchronized void o() {
        this.k = false;
        f().b(this.m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(boolean z) {
        if (k()) {
            j();
            return;
        }
        if (this.d.get() >= this.c || z) {
            o();
            this.j = z;
            this.m.run();
            this.j = false;
        }
    }

    synchronized void b(final boolean z) {
        f().a(new Runnable() { // from class: sdk.pendo.io.r5.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(z);
            }
        });
    }

    synchronized void d(boolean z) {
        try {
            if (z) {
                f().a(this.n);
            } else {
                this.n.run();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, int i, boolean z) {
        if (n.a(this.a, str.getBytes(Charset.forName("UTF-8")))) {
            this.d.addAndGet(i);
        }
        a(z);
    }

    synchronized void b(final String str, final int i, final boolean z) {
        if (this.d.get() == 0 && !this.k) {
            a(this.b);
        }
        if (str.isEmpty()) {
            return;
        }
        f().a(new Runnable() { // from class: sdk.pendo.io.r5.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, i, z);
            }
        });
    }

    synchronized void a(int i, int i2, float f) {
        this.b = i;
        this.c = i2;
        this.f = f;
    }

    synchronized void a(long j) {
        if (!sdk.pendo.io.j6.a.d()) {
            this.k = true;
            f().a(this.m, j * 1000);
        }
    }
}
