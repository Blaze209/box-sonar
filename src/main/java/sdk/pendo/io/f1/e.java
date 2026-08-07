package sdk.pendo.io.f1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.d1.l;
import sdk.pendo.io.l1.m;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
public class e extends c {
    protected List<c> a;
    private final f b;

    private e(c cVar, f fVar, c cVar2) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.add(cVar);
        this.a.add(cVar2);
        this.b = fVar;
    }

    public static e b(Collection<c> collection) {
        return new e(f.OR, collection);
    }

    @Override // sdk.pendo.io.d1.l
    public boolean a(l.a aVar) {
        f fVar = this.b;
        if (fVar == f.OR) {
            for (c cVar : this.a) {
                if (cVar.a(aVar)) {
                    return true;
                }
                if (PendoInternal.N()) {
                    PendoLogger.d(String.format("FAILED logicalOperatorOR due to:\n expression = %s,\n testedPath = %s", cVar, ((m) aVar).d()), new Object[0]);
                }
            }
            PendoLogger.d("All logicalOR expressions failed - overall predicate didn't match", new Object[0]);
            return false;
        }
        f fVar2 = f.AND;
        List<c> list = this.a;
        if (fVar != fVar2) {
            return !list.get(0).a(aVar);
        }
        for (c cVar2 : list) {
            if (!cVar2.a(aVar)) {
                if (PendoInternal.N()) {
                    PendoLogger.d(String.format("FAILED logicalOperatorAND due to:\n expression = %s,\n testedPath = %s", cVar2, ((m) aVar).d()), new Object[0]);
                }
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "(" + sdk.pendo.io.e1.i.a(" " + this.b.b() + " ", this.a) + ")";
    }

    private e(f fVar, Collection<c> collection) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        arrayList.addAll(collection);
        this.b = fVar;
    }

    public static e a(Collection<c> collection) {
        return new e(f.AND, collection);
    }

    public static c a(c cVar) {
        return new e(cVar, f.NOT, null);
    }
}
