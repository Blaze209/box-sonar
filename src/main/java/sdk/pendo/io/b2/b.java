package sdk.pendo.io.b2;

import java.util.Objects;
import kotlinx.coroutines.debug.internal.DebugCoroutineInfoImplKt;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    private final String a;
    private c b;
    private EnumC0349b c;
    private long d;
    private long e;
    private long f;
    private long g;

    /* JADX INFO: renamed from: sdk.pendo.io.b2.b$b, reason: collision with other inner class name */
    private enum EnumC0349b {
        SPLIT,
        UNSPLIT
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    private static abstract class c {
        private static final /* synthetic */ c[] $VALUES;
        public static final c RUNNING;
        public static final c STOPPED;
        public static final c SUSPENDED;
        public static final c UNSTARTED;

        static enum a extends c {
            a(String str, int i) {
                super(str, i);
            }

            @Override // sdk.pendo.io.b2.b.c
            boolean a() {
                return true;
            }

            @Override // sdk.pendo.io.b2.b.c
            boolean b() {
                return false;
            }

            @Override // sdk.pendo.io.b2.b.c
            boolean c() {
                return false;
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.b2.b$c$b, reason: collision with other inner class name */
        static enum C0350b extends c {
            C0350b(String str, int i) {
                super(str, i);
            }

            @Override // sdk.pendo.io.b2.b.c
            boolean a() {
                return false;
            }

            @Override // sdk.pendo.io.b2.b.c
            boolean b() {
                return true;
            }

            @Override // sdk.pendo.io.b2.b.c
            boolean c() {
                return false;
            }
        }

        /* JADX INFO: renamed from: sdk.pendo.io.b2.b$c$c, reason: collision with other inner class name */
        static enum C0351c extends c {
            C0351c(String str, int i) {
                super(str, i);
            }

            @Override // sdk.pendo.io.b2.b.c
            boolean a() {
                return true;
            }

            @Override // sdk.pendo.io.b2.b.c
            boolean b() {
                return false;
            }

            @Override // sdk.pendo.io.b2.b.c
            boolean c() {
                return true;
            }
        }

        static enum d extends c {
            d(String str, int i) {
                super(str, i);
            }

            @Override // sdk.pendo.io.b2.b.c
            boolean a() {
                return false;
            }

            @Override // sdk.pendo.io.b2.b.c
            boolean b() {
                return true;
            }

            @Override // sdk.pendo.io.b2.b.c
            boolean c() {
                return false;
            }
        }

        static {
            a aVar = new a(DebugCoroutineInfoImplKt.RUNNING, 0);
            RUNNING = aVar;
            C0350b c0350b = new C0350b("STOPPED", 1);
            STOPPED = c0350b;
            C0351c c0351c = new C0351c(DebugCoroutineInfoImplKt.SUSPENDED, 2);
            SUSPENDED = c0351c;
            d dVar = new d("UNSTARTED", 3);
            UNSTARTED = dVar;
            $VALUES = new c[]{aVar, c0350b, c0351c, dVar};
        }

        private c(String str, int i) {
            super(str, i);
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) $VALUES.clone();
        }

        abstract boolean a();

        abstract boolean b();

        abstract boolean c();
    }

    public b() {
        this(null);
    }

    public String a() {
        return sdk.pendo.io.b2.a.a(c());
    }

    public long b() {
        long jNanoTime;
        c cVar = this.b;
        if (cVar == c.STOPPED || cVar == c.SUSPENDED) {
            jNanoTime = this.g;
        } else {
            if (cVar == c.UNSTARTED) {
                return 0L;
            }
            if (cVar != c.RUNNING) {
                throw new IllegalStateException("Illegal running state has occurred.");
            }
            jNanoTime = System.nanoTime();
        }
        return jNanoTime - this.d;
    }

    public long c() {
        return b() / 1000000;
    }

    public boolean d() {
        return this.b.a();
    }

    public boolean e() {
        return this.b.b();
    }

    public boolean f() {
        return this.b.c();
    }

    public void g() {
        this.b = c.UNSTARTED;
        this.c = EnumC0349b.UNSPLIT;
    }

    public void h() {
        c cVar = this.b;
        if (cVar == c.STOPPED) {
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        }
        if (cVar != c.UNSTARTED) {
            throw new IllegalStateException("Stopwatch already started. ");
        }
        this.d = System.nanoTime();
        this.e = System.currentTimeMillis();
        this.b = c.RUNNING;
    }

    public void i() {
        c cVar = this.b;
        c cVar2 = c.RUNNING;
        if (cVar != cVar2 && cVar != c.SUSPENDED) {
            throw new IllegalStateException("Stopwatch is not running. ");
        }
        if (cVar == cVar2) {
            this.g = System.nanoTime();
            this.f = System.currentTimeMillis();
        }
        this.b = c.STOPPED;
    }

    public String toString() {
        String string = Objects.toString(this.a, "");
        String strA = a();
        return string.isEmpty() ? strA : string + " " + strA;
    }

    public b(String str) {
        this.b = c.UNSTARTED;
        this.c = EnumC0349b.UNSPLIT;
        this.a = str;
    }
}
