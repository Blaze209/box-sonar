package sdk.pendo.io.h;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final a a = new C0390a();
    public static final a b = new b();
    public static final a c = new c();
    public static final a d = new d();
    public static final a e = new e();

    /* JADX INFO: renamed from: sdk.pendo.io.h.a$a, reason: collision with other inner class name */
    class C0390a extends a {
        C0390a() {
        }

        @Override // sdk.pendo.io.h.a
        public boolean a() {
            return true;
        }

        @Override // sdk.pendo.io.h.a
        public boolean b() {
            return true;
        }

        @Override // sdk.pendo.io.h.a
        public boolean a(sdk.pendo.io.e.a aVar) {
            return aVar == sdk.pendo.io.e.a.REMOTE;
        }

        @Override // sdk.pendo.io.h.a
        public boolean a(boolean z, sdk.pendo.io.e.a aVar, sdk.pendo.io.e.c cVar) {
            return (aVar == sdk.pendo.io.e.a.RESOURCE_DISK_CACHE || aVar == sdk.pendo.io.e.a.MEMORY_CACHE) ? false : true;
        }
    }

    class b extends a {
        b() {
        }

        @Override // sdk.pendo.io.h.a
        public boolean a() {
            return false;
        }

        @Override // sdk.pendo.io.h.a
        public boolean a(sdk.pendo.io.e.a aVar) {
            return false;
        }

        @Override // sdk.pendo.io.h.a
        public boolean a(boolean z, sdk.pendo.io.e.a aVar, sdk.pendo.io.e.c cVar) {
            return false;
        }

        @Override // sdk.pendo.io.h.a
        public boolean b() {
            return false;
        }
    }

    class c extends a {
        c() {
        }

        @Override // sdk.pendo.io.h.a
        public boolean a() {
            return true;
        }

        @Override // sdk.pendo.io.h.a
        public boolean a(boolean z, sdk.pendo.io.e.a aVar, sdk.pendo.io.e.c cVar) {
            return false;
        }

        @Override // sdk.pendo.io.h.a
        public boolean b() {
            return false;
        }

        @Override // sdk.pendo.io.h.a
        public boolean a(sdk.pendo.io.e.a aVar) {
            return (aVar == sdk.pendo.io.e.a.DATA_DISK_CACHE || aVar == sdk.pendo.io.e.a.MEMORY_CACHE) ? false : true;
        }
    }

    class e extends a {
        e() {
        }

        @Override // sdk.pendo.io.h.a
        public boolean a() {
            return true;
        }

        @Override // sdk.pendo.io.h.a
        public boolean b() {
            return true;
        }

        @Override // sdk.pendo.io.h.a
        public boolean a(sdk.pendo.io.e.a aVar) {
            return aVar == sdk.pendo.io.e.a.REMOTE;
        }

        @Override // sdk.pendo.io.h.a
        public boolean a(boolean z, sdk.pendo.io.e.a aVar, sdk.pendo.io.e.c cVar) {
            return ((z && aVar == sdk.pendo.io.e.a.DATA_DISK_CACHE) || aVar == sdk.pendo.io.e.a.LOCAL) && cVar == sdk.pendo.io.e.c.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean a(sdk.pendo.io.e.a aVar);

    public abstract boolean a(boolean z, sdk.pendo.io.e.a aVar, sdk.pendo.io.e.c cVar);

    public abstract boolean b();

    class d extends a {
        d() {
        }

        @Override // sdk.pendo.io.h.a
        public boolean a() {
            return false;
        }

        @Override // sdk.pendo.io.h.a
        public boolean a(sdk.pendo.io.e.a aVar) {
            return false;
        }

        @Override // sdk.pendo.io.h.a
        public boolean b() {
            return true;
        }

        @Override // sdk.pendo.io.h.a
        public boolean a(boolean z, sdk.pendo.io.e.a aVar, sdk.pendo.io.e.c cVar) {
            return (aVar == sdk.pendo.io.e.a.RESOURCE_DISK_CACHE || aVar == sdk.pendo.io.e.a.MEMORY_CACHE) ? false : true;
        }
    }
}
