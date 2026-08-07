package sdk.pendo.io.m1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import sdk.pendo.io.d1.g;

/* JADX INFO: loaded from: classes4.dex */
public class c implements a {
    private final ReentrantLock a = new ReentrantLock();
    private final Map<String, g> b = new ConcurrentHashMap();
    private final Deque<String> c = new LinkedList();
    private final int d;

    public c(int i) {
        this.d = i;
    }

    private void b(String str) {
        this.a.lock();
        try {
            this.c.addFirst(str);
        } finally {
            this.a.unlock();
        }
    }

    private void c(String str) {
        this.a.lock();
        try {
            this.c.removeFirstOccurrence(str);
            this.c.addFirst(str);
        } finally {
            this.a.unlock();
        }
    }

    @Override // sdk.pendo.io.m1.a
    public g a(String str) {
        g gVar = this.b.get(str);
        if (gVar != null) {
            c(str);
        }
        return gVar;
    }

    public String toString() {
        return this.b.toString();
    }

    @Override // sdk.pendo.io.m1.a
    public void a(String str, g gVar) {
        if (this.b.put(str, gVar) != null) {
            c(str);
        } else {
            b(str);
        }
        if (this.b.size() > this.d) {
            this.b.remove(a());
        }
    }

    private String a() {
        this.a.lock();
        try {
            return this.c.removeLast();
        } finally {
            this.a.unlock();
        }
    }
}
