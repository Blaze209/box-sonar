package external.sdk.pendo.io.jose4j.jwt.consumer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import sdk.pendo.io.r0.o;

/* JADX INFO: loaded from: classes4.dex */
public class JwtConsumer {
    private sdk.pendo.io.z0.b a;
    private sdk.pendo.io.z0.a b;
    private List<b> c;
    private sdk.pendo.io.q0.c d;
    private sdk.pendo.io.q0.c e;
    private sdk.pendo.io.q0.c f;
    private boolean g = true;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private sdk.pendo.io.m0.a o;
    private sdk.pendo.io.m0.a p;

    JwtConsumer() {
    }

    private boolean a(sdk.pendo.io.x0.c cVar) {
        String strD = cVar.d();
        if (strD != null) {
            return strD.equalsIgnoreCase("jwt") || strD.equalsIgnoreCase("application/jwt");
        }
        return false;
    }

    void a(sdk.pendo.io.w0.a aVar) {
    }

    void a(sdk.pendo.io.w0.b bVar) {
    }

    public sdk.pendo.io.v0.b b(String str) {
        return a(str).c();
    }

    void c(sdk.pendo.io.q0.c cVar) {
        this.d = cVar;
    }

    void d(boolean z) {
        this.h = z;
    }

    void e(boolean z) {
        this.i = z;
    }

    void f(boolean z) {
        this.g = z;
    }

    void g(boolean z) {
        this.k = z;
    }

    public void h(boolean z) {
        this.m = z;
    }

    public g a(String str) throws c {
        String strS;
        LinkedList linkedList = new LinkedList();
        sdk.pendo.io.v0.b bVarA = null;
        g gVar = new g(str, null, Collections.unmodifiableList(linkedList));
        String str2 = str;
        while (bVarA == null) {
            try {
                try {
                    try {
                        sdk.pendo.io.x0.c cVarA = sdk.pendo.io.x0.c.a(str2);
                        if (cVarA instanceof sdk.pendo.io.u0.e) {
                            strS = ((sdk.pendo.io.u0.e) cVarA).q();
                        } else {
                            o oVar = (o) cVarA;
                            sdk.pendo.io.m0.a aVar = this.p;
                            if (aVar != null) {
                                oVar.a(aVar);
                            }
                            if (this.n) {
                                oVar.a(false);
                            }
                            sdk.pendo.io.q0.c cVar = this.f;
                            if (cVar != null) {
                                oVar.b(cVar);
                            }
                            oVar.a(this.b.a(oVar, Collections.unmodifiableList(linkedList)));
                            sdk.pendo.io.q0.c cVar2 = this.e;
                            if (cVar2 != null) {
                                oVar.a(cVar2);
                            }
                            strS = oVar.s();
                        }
                        if (a(cVarA)) {
                            str2 = strS;
                        } else {
                            try {
                                bVarA = sdk.pendo.io.v0.b.a(strS, gVar);
                                gVar.a(bVarA);
                            } catch (c e) {
                                if (this.j) {
                                    try {
                                        sdk.pendo.io.x0.c.a(str);
                                        str2 = strS;
                                    } catch (sdk.pendo.io.a1.g unused) {
                                        throw e;
                                    }
                                }
                                throw e;
                            }
                        }
                        linkedList.addFirst(cVarA);
                    } catch (c e2) {
                        throw e2;
                    }
                } catch (sdk.pendo.io.a1.g e3) {
                    StringBuilder sb = new StringBuilder("Unable to process");
                    if (!linkedList.isEmpty()) {
                        sb.append(" nested");
                    }
                    sb.append(" JOSE object (cause: ").append(e3).append("): ").append(str2);
                    throw new c("JWT processing failed.", new b.a(17, sb.toString()), e3, gVar);
                }
            } catch (Exception e4) {
                StringBuilder sb2 = new StringBuilder("Unexpected exception encountered while processing");
                if (!linkedList.isEmpty()) {
                    sb2.append(" nested");
                }
                sb2.append(" JOSE object (").append(e4).append("): ").append(str2);
                throw new c("JWT processing failed.", new b.a(17, sb2.toString()), e4, gVar);
            }
        }
        a(gVar);
        return gVar;
    }

    void b(sdk.pendo.io.q0.c cVar) {
        this.f = cVar;
    }

    void c(boolean z) {
        this.l = z;
    }

    public void a(g gVar) throws c {
        ArrayList arrayList = new ArrayList(gVar.a());
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            List listSubList = arrayList.subList(size + 1, arrayList.size());
            List<sdk.pendo.io.x0.c> listUnmodifiableList = Collections.unmodifiableList(listSubList);
            sdk.pendo.io.x0.c cVar = (sdk.pendo.io.x0.c) arrayList.get(size);
            try {
                if (cVar instanceof sdk.pendo.io.u0.e) {
                    sdk.pendo.io.u0.e eVar = (sdk.pendo.io.u0.e) cVar;
                    boolean zEquals = "none".equals(eVar.c());
                    if (!this.k) {
                        sdk.pendo.io.m0.a aVar = this.o;
                        if (aVar != null) {
                            eVar.a(aVar);
                        }
                        if (this.l) {
                            eVar.a(false);
                        }
                        sdk.pendo.io.q0.c cVar2 = this.d;
                        if (cVar2 != null) {
                            eVar.a(cVar2);
                        }
                        if (!zEquals || !this.m) {
                            eVar.a(this.a.a(eVar, listUnmodifiableList));
                        }
                        if (!eVar.s()) {
                            throw new d(eVar, gVar);
                        }
                    }
                    if (!zEquals) {
                        z = true;
                    }
                } else {
                    o oVar = (o) cVar;
                    sdk.pendo.io.q0.c cVar3 = this.e;
                    if (cVar3 != null) {
                        cVar3.a(oVar.c());
                    }
                    sdk.pendo.io.q0.c cVar4 = this.f;
                    if (cVar4 != null) {
                        cVar4.a(oVar.q());
                    }
                    z2 = true;
                    z3 = oVar.r().a() == sdk.pendo.io.y0.h.SYMMETRIC;
                }
            } catch (c e) {
                throw e;
            } catch (sdk.pendo.io.a1.g e2) {
                StringBuilder sb = new StringBuilder("Unable to process");
                if (!listSubList.isEmpty()) {
                    sb.append(" nested");
                }
                sb.append(" JOSE object (cause: ").append(e2).append("): ").append(cVar);
                throw new c("JWT processing failed.", new b.a(17, sb.toString()), e2, gVar);
            } catch (Exception e3) {
                StringBuilder sb2 = new StringBuilder("Unexpected exception encountered while processing");
                if (!listSubList.isEmpty()) {
                    sb2.append(" nested");
                }
                sb2.append(" JOSE object (").append(e3).append("): ").append(cVar);
                throw new c("JWT processing failed.", new b.a(17, sb2.toString()), e3, gVar);
            }
        }
        if (this.g && !z) {
            throw new c("The JWT has no signature but the JWT Consumer is configured to require one: " + gVar.b(), Collections.singletonList(new b.a(10, "Missing signature.")), gVar);
        }
        if (this.h && !z2) {
            throw new c("The JWT has no encryption but the JWT Consumer is configured to require it: " + gVar.b(), Collections.singletonList(new b.a(19, "No encryption.")), gVar);
        }
        if (this.i && !z && !z3) {
            throw new c("The JWT has no integrity protection (signature/MAC or symmetric AEAD encryption) but the JWT Consumer is configured to require it: " + gVar.b(), Collections.singletonList(new b.a(20, "Missing Integrity Protection")), gVar);
        }
        b(gVar);
    }

    void b(sdk.pendo.io.m0.a aVar) {
        this.o = aVar;
    }

    void a(sdk.pendo.io.z0.a aVar) {
        this.b = aVar;
    }

    void b(boolean z) {
        this.n = z;
    }

    void a(sdk.pendo.io.q0.c cVar) {
        this.e = cVar;
    }

    void b(g gVar) throws c {
        b.a aVar;
        b.a aVarA;
        ArrayList arrayList = new ArrayList();
        for (b bVar : this.c) {
            try {
                aVarA = bVar.a(gVar);
            } catch (sdk.pendo.io.v0.c e) {
                aVar = new b.a(18, e.getMessage());
                aVarA = aVar;
            } catch (Exception e2) {
                aVar = new b.a(17, "Unexpected exception thrown from validator " + bVar.getClass().getName() + ": " + sdk.pendo.io.a1.b.a(e2, getClass()));
                aVarA = aVar;
            }
            if (aVarA != null) {
                arrayList.add(aVarA);
            }
        }
        if (!arrayList.isEmpty()) {
            throw new c("JWT (claims->" + gVar.c().g() + ") rejected due to invalid claims or other invalid content.", arrayList, gVar);
        }
    }

    void a(sdk.pendo.io.m0.a aVar) {
        this.p = aVar;
    }

    void a(boolean z) {
        this.j = z;
    }

    void a(List<b> list) {
        this.c = list;
    }

    void a(sdk.pendo.io.z0.b bVar) {
        this.a = bVar;
    }
}
