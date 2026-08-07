package sdk.pendo.io.m3;

import java.util.concurrent.Callable;
import sdk.pendo.io.k3.p;
import sdk.pendo.io.p3.b;
import sdk.pendo.io.q3.h;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private static volatile h<Callable<p>, p> a;
    private static volatile h<p, p> b;

    static <T, R> R a(h<T, R> hVar, T t) {
        try {
            return hVar.apply(t);
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    public static p b(Callable<p> callable) {
        if (callable == null) {
            throw new NullPointerException("scheduler == null");
        }
        h<Callable<p>, p> hVar = a;
        return hVar == null ? a(callable) : a(hVar, callable);
    }

    static p a(h<Callable<p>, p> hVar, Callable<p> callable) {
        p pVar = (p) a((h<Callable<p>, R>) hVar, callable);
        if (pVar != null) {
            return pVar;
        }
        throw new NullPointerException("Scheduler Callable returned null");
    }

    static p a(Callable<p> callable) {
        try {
            p pVarCall = callable.call();
            if (pVarCall != null) {
                return pVarCall;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th) {
            throw b.a(th);
        }
    }

    public static p a(p pVar) {
        if (pVar == null) {
            throw new NullPointerException("scheduler == null");
        }
        h<p, p> hVar = b;
        return hVar == null ? pVar : (p) a((h<p, R>) hVar, pVar);
    }
}
