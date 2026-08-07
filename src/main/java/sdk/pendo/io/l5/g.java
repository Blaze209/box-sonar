package sdk.pendo.io.l5;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class g {
    private Map<b, sdk.pendo.io.m5.d> a = new HashMap();

    public enum a {
        EVENT_TRIGGER,
        ANY_EVENT_TRIGGER,
        STATE_ENTER,
        ANY_STATE_ENTER,
        STATE_LEAVE,
        ANY_STATE_LEAVE,
        FINAL_STATE,
        ERROR
    }

    private static final class b {
        a a;
        c b;
        h c;

        private b(a aVar, c cVar, h hVar) {
            this.a = aVar;
            this.b = cVar;
            this.c = hVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            c cVar = this.b;
            if (cVar == null ? bVar.b != null : !cVar.equals(bVar.b)) {
                return false;
            }
            if (this.a != bVar.a) {
                return false;
            }
            h hVar = this.c;
            return hVar == null ? bVar.c == null : hVar.equals(bVar.c);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() * 31;
            c cVar = this.b;
            int iHashCode2 = (iHashCode + (cVar != null ? cVar.hashCode() : 0)) * 31;
            h hVar = this.c;
            return iHashCode2 + (hVar != null ? hVar.hashCode() : 0);
        }
    }

    g() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(sdk.pendo.io.n5.b bVar) {
        sdk.pendo.io.m5.d dVar = this.a.get(new b(a.ERROR, null, 0 == true ? 1 : 0));
        if (dVar != null) {
            ((sdk.pendo.io.m5.c) dVar).a(bVar, bVar.a());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends i> void b(h hVar, C c) {
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        sdk.pendo.io.m5.d dVar = this.a.get(new b(a.STATE_ENTER, null, hVar));
        if (dVar != null) {
            ((sdk.pendo.io.m5.a) dVar).a(c);
        }
        sdk.pendo.io.m5.d dVar2 = this.a.get(new b(a.ANY_STATE_ENTER, objArr3 == true ? 1 : 0, objArr2 == true ? 1 : 0));
        if (dVar2 != null) {
            ((sdk.pendo.io.m5.e) dVar2).a(hVar, c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends i> void c(h hVar, C c) {
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        sdk.pendo.io.m5.d dVar = this.a.get(new b(a.STATE_LEAVE, null, hVar));
        if (dVar != null) {
            ((sdk.pendo.io.m5.a) dVar).a(c);
        }
        sdk.pendo.io.m5.d dVar2 = this.a.get(new b(a.ANY_STATE_LEAVE, objArr3 == true ? 1 : 0, objArr2 == true ? 1 : 0));
        if (dVar2 != null) {
            ((sdk.pendo.io.m5.e) dVar2).a(hVar, c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends i> void a(c cVar, h hVar, h hVar2, C c) {
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        sdk.pendo.io.m5.d dVar = this.a.get(new b(a.EVENT_TRIGGER, cVar, null));
        if (dVar != null) {
            ((sdk.pendo.io.m5.a) dVar).a(c);
        }
        sdk.pendo.io.m5.d dVar2 = this.a.get(new b(a.ANY_EVENT_TRIGGER, objArr3 == true ? 1 : 0, objArr2 == true ? 1 : 0));
        if (dVar2 != null) {
            ((sdk.pendo.io.m5.b) dVar2).a(cVar, hVar, hVar2, c);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends i> void a(h hVar, C c) {
        sdk.pendo.io.m5.d dVar = this.a.get(new b(a.FINAL_STATE, null, 0 == true ? 1 : 0));
        if (dVar != null) {
            ((sdk.pendo.io.m5.e) dVar).a(hVar, c);
        }
    }

    public void a(a aVar, h hVar, c cVar, sdk.pendo.io.m5.d dVar) {
        this.a.put(new b(aVar, cVar, hVar), dVar);
    }
}
