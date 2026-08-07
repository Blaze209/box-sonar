package sdk.pendo.io.m0;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private SecureRandom a;
    private C0418a b = new C0418a();
    private C0418a c = new C0418a();

    /* JADX INFO: renamed from: sdk.pendo.io.m0.a$a, reason: collision with other inner class name */
    public class C0418a {
        private String a;
        private String b;
        private String c;
        private b d;
        private String e;
        private String f;
        private String g;
        private String h;

        public C0418a() {
        }

        public String a() {
            return a(this.c);
        }

        public String b() {
            return a(this.b);
        }

        public b c() {
            return this.d;
        }

        public String d() {
            return a(this.h);
        }

        public String e() {
            return a(this.f);
        }

        public String f() {
            return a(this.g);
        }

        public c g() {
            return null;
        }

        public String h() {
            return a(this.e);
        }

        private String a(String str) {
            return str == null ? this.a : str;
        }
    }

    public enum b {
        UNWRAP,
        DECRYPT
    }

    public static class c {
    }

    public C0418a a() {
        return this.c;
    }

    public SecureRandom b() {
        return this.a;
    }

    public C0418a c() {
        return this.b;
    }
}
