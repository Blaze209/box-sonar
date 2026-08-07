package sdk.pendo.io.j;

import androidx.core.util.Pools;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sdk.pendo.io.e.f;
import sdk.pendo.io.y.h;
import sdk.pendo.io.y.k;
import sdk.pendo.io.y.l;
import sdk.pendo.io.z.c;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    private final h<f, String> a = new h<>(1000);
    private final Pools.Pool<C0400b> b = sdk.pendo.io.z.a.a(10, new a());

    class a implements sdk.pendo.io.z.a.d<C0400b> {
        a() {
        }

        @Override // sdk.pendo.io.z.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C0400b a() {
            try {
                return new C0400b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: renamed from: sdk.pendo.io.j.b$b, reason: collision with other inner class name */
    private static final class C0400b implements sdk.pendo.io.z.a.f {
        final MessageDigest a;
        private final c b = c.a();

        C0400b(MessageDigest messageDigest) {
            this.a = messageDigest;
        }

        @Override // sdk.pendo.io.z.a.f
        public c b() {
            return this.b;
        }
    }

    private String a(f fVar) {
        C0400b c0400b = (C0400b) k.a(this.b.acquire());
        try {
            fVar.updateDiskCacheKey(c0400b.a);
            return l.a(c0400b.a.digest());
        } finally {
            this.b.release(c0400b);
        }
    }

    public String b(f fVar) {
        String strA;
        synchronized (this.a) {
            strA = this.a.get(fVar);
        }
        if (strA == null) {
            strA = a(fVar);
        }
        synchronized (this.a) {
            this.a.put(fVar, strA);
        }
        return strA;
    }
}
