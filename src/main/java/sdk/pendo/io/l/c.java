package sdk.pendo.io.l;

import java.util.Queue;
import sdk.pendo.io.y.h;
import sdk.pendo.io.y.l;

/* JADX INFO: loaded from: classes4.dex */
public class c<A, B> {
    private final h<b<A>, B> a;

    class a extends h<b<A>, B> {
        a(long j) {
            super(j);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // sdk.pendo.io.y.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onItemEvicted(b<A> bVar, B b) {
            bVar.a();
        }
    }

    static final class b<A> {
        private static final Queue<b<?>> d = l.a(0);
        private int a;
        private int b;
        private A c;

        private b() {
        }

        static <A> b<A> a(A a, int i, int i2) {
            b<A> bVar;
            Queue<b<?>> queue = d;
            synchronized (queue) {
                bVar = (b) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a, i, i2);
            return bVar;
        }

        private void b(A a, int i, int i2) {
            this.c = a;
            this.b = i;
            this.a = i2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (this.b == bVar.b && this.a == bVar.a && this.c.equals(bVar.c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.c.hashCode();
        }

        public void a() {
            Queue<b<?>> queue = d;
            synchronized (queue) {
                queue.offer(this);
            }
        }
    }

    public c(long j) {
        this.a = new a(j);
    }

    public B a(A a2, int i, int i2) {
        b<A> bVarA = b.a(a2, i, i2);
        B b2 = this.a.get(bVarA);
        bVarA.a();
        return b2;
    }

    public void a(A a2, int i, int i2, B b2) {
        this.a.put(b.a(a2, i, i2), b2);
    }
}
