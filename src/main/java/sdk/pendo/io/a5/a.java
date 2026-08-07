package sdk.pendo.io.a5;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    private ConcurrentMap<String, ConcurrentLinkedQueue<InterfaceC0343a>> a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: sdk.pendo.io.a5.a$a, reason: collision with other inner class name */
    public interface InterfaceC0343a {
        void call(Object... objArr);
    }

    private class b implements InterfaceC0343a {
        public final String a;
        public final InterfaceC0343a b;

        public b(String str, InterfaceC0343a interfaceC0343a) {
            this.a = str;
            this.b = interfaceC0343a;
        }

        @Override // sdk.pendo.io.a5.a.InterfaceC0343a
        public void call(Object... objArr) {
            a.this.a(this.a, this);
            this.b.call(objArr);
        }
    }

    public a a(String str, Object... objArr) {
        ConcurrentLinkedQueue<InterfaceC0343a> concurrentLinkedQueue = this.a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator<InterfaceC0343a> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                it.next().call(objArr);
            }
        }
        return this;
    }

    public a b(String str, InterfaceC0343a interfaceC0343a) {
        ConcurrentLinkedQueue<InterfaceC0343a> concurrentLinkedQueuePutIfAbsent;
        ConcurrentLinkedQueue<InterfaceC0343a> concurrentLinkedQueue = this.a.get(str);
        if (concurrentLinkedQueue == null && (concurrentLinkedQueuePutIfAbsent = this.a.putIfAbsent(str, (concurrentLinkedQueue = new ConcurrentLinkedQueue<>()))) != null) {
            concurrentLinkedQueue = concurrentLinkedQueuePutIfAbsent;
        }
        concurrentLinkedQueue.add(interfaceC0343a);
        return this;
    }

    public a c(String str, InterfaceC0343a interfaceC0343a) {
        b(str, new b(str, interfaceC0343a));
        return this;
    }

    public a a() {
        this.a.clear();
        return this;
    }

    public a a(String str) {
        this.a.remove(str);
        return this;
    }

    public a a(String str, InterfaceC0343a interfaceC0343a) {
        ConcurrentLinkedQueue<InterfaceC0343a> concurrentLinkedQueue = this.a.get(str);
        if (concurrentLinkedQueue != null) {
            Iterator<InterfaceC0343a> it = concurrentLinkedQueue.iterator();
            while (it.hasNext()) {
                if (a(interfaceC0343a, it.next())) {
                    it.remove();
                    break;
                }
            }
        }
        return this;
    }

    private static boolean a(InterfaceC0343a interfaceC0343a, InterfaceC0343a interfaceC0343a2) {
        if (interfaceC0343a.equals(interfaceC0343a2)) {
            return true;
        }
        if (interfaceC0343a2 instanceof b) {
            return interfaceC0343a.equals(((b) interfaceC0343a2).b);
        }
        return false;
    }
}
