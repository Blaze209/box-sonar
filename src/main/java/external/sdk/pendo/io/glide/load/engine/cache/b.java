package external.sdk.pendo.io.glide.load.engine.cache;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
final class b {
    private final Map<String, a> a = new HashMap();
    private final C0312b b = new C0312b();

    private static class a {
        final Lock a = new ReentrantLock();
        int b;

        a() {
        }
    }

    /* JADX INFO: renamed from: external.sdk.pendo.io.glide.load.engine.cache.b$b, reason: collision with other inner class name */
    private static class C0312b {
        private final Queue<a> a = new ArrayDeque();

        C0312b() {
        }

        a a() {
            a aVarPoll;
            synchronized (this.a) {
                aVarPoll = this.a.poll();
            }
            return aVarPoll == null ? new a() : aVarPoll;
        }

        void a(a aVar) {
            synchronized (this.a) {
                if (this.a.size() < 10) {
                    this.a.offer(aVar);
                }
            }
        }
    }

    b() {
    }

    void a(String str) {
        a aVarA;
        synchronized (this) {
            aVarA = this.a.get(str);
            if (aVarA == null) {
                aVarA = this.b.a();
                this.a.put(str, aVarA);
            }
            aVarA.b++;
        }
        aVarA.a.lock();
    }

    void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) k.a(this.a.get(str));
            int i = aVar.b;
            if (i < 1) {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.b);
            }
            int i2 = i - 1;
            aVar.b = i2;
            if (i2 == 0) {
                a aVarRemove = this.a.remove(str);
                if (!aVarRemove.equals(aVar)) {
                    throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + aVarRemove + ", safeKey: " + str);
                }
                this.b.a(aVarRemove);
            }
        }
        aVar.a.unlock();
    }
}
