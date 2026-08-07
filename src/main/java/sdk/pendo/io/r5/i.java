package sdk.pendo.io.r5;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.s7.l0;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    private static volatile i f = null;
    private static final Object g = new Object();
    private static boolean h = false;
    private final sdk.pendo.io.q3.e<List<JSONObject>> a = new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.r5.i$$ExternalSyntheticLambda5
        @Override // sdk.pendo.io.q3.e
        public final void accept(Object obj) {
            i.a((List) obj);
        }
    };
    private volatile sdk.pendo.io.j4.b<JSONObject> b = sdk.pendo.io.j4.b.m();
    private sdk.pendo.io.j4.b<Boolean> c = sdk.pendo.io.j4.b.m();
    private volatile boolean d = false;
    private volatile boolean e = false;

    class a implements sdk.pendo.io.q3.j<Long> {
        private int a = 0;

        a() {
        }

        @Override // sdk.pendo.io.q3.j
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Long l) {
            if (i.this.e) {
                this.a = 0;
                i.this.e = false;
            }
            this.a++;
            synchronized (i.g) {
                if (this.a != 1) {
                    return false;
                }
                this.a = 0;
                i.this.d = true;
                return true;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements sdk.pendo.io.q3.j<T> {
        private int a = 0;

        b() {
        }

        @Override // sdk.pendo.io.q3.j
        public boolean test(T t) {
            if (i.this.d) {
                this.a = 0;
                i.this.d = false;
            }
            this.a++;
            synchronized (i.g) {
                if (this.a != 3) {
                    return false;
                }
                this.a = 0;
                i.this.e = true;
                return true;
            }
        }
    }

    private i() {
        synchronized (g) {
            g();
        }
    }

    private sdk.pendo.io.k3.j b() {
        return sdk.pendo.io.w6.b.e().c().a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.r5.i$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.q3.j
            public final boolean test(Object obj) {
                return i.a((sdk.pendo.io.w6.b.c) obj);
            }
        });
    }

    public static synchronized i e() {
        if (f == null) {
            synchronized (g) {
                if (f == null) {
                    f = new i();
                }
            }
        }
        return f;
    }

    public static m f() {
        return new m();
    }

    private void g() {
        synchronized (g) {
            this.b.a(sdk.pendo.io.i4.a.c()).c(a()).a((sdk.pendo.io.q3.e<? super R>) new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.r5.i$$ExternalSyntheticLambda3
                @Override // sdk.pendo.io.q3.e
                public final void accept(Object obj) {
                    sdk.pendo.io.p6.b.a((JSONObject) obj);
                }
            }).a((sdk.pendo.io.k3.m) a(this.b)).a(sdk.pendo.io.i4.a.c()).a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.r5.i$$ExternalSyntheticLambda4
                @Override // sdk.pendo.io.q3.j
                public final boolean test(Object obj) {
                    return i.b((List) obj);
                }
            }).a(this.a, new sdk.pendo.io.q6.a("PendoAnalytics analytics events consumer error consumer"));
        }
    }

    private sdk.pendo.io.k3.j h() {
        return sdk.pendo.io.k3.j.d(1L, TimeUnit.SECONDS).a(new a());
    }

    void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                if (!b(jSONObject) && jSONObject2 != null) {
                    JSONObject jSONObject3 = jSONObject.has("properties") ? (JSONObject) jSONObject.get("properties") : null;
                    if (jSONObject3 == null) {
                        jSONObject.put("properties", jSONObject2);
                        return;
                    }
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject3.put(next, jSONObject2.get(next));
                    }
                }
            } catch (JSONException e) {
                PendoLogger.e("Failed to addGlobalEventPropertiesIfNeeded, exception: " + e, new Object[0]);
            }
        }
    }

    public void c() {
        this.c.onNext(Boolean.TRUE);
    }

    public synchronized sdk.pendo.io.j4.b<JSONObject> d() {
        return this.b;
    }

    private boolean b(JSONObject jSONObject) {
        return jSONObject != null && d.APP_SESSION_END.b().equals(jSONObject.optString("event"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ JSONObject c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            a(jSONObject2);
            a(jSONObject2, sdk.pendo.io.w6.a.a.d().getPropertiesJson());
            return jSONObject2;
        } catch (JSONException e) {
            PendoLogger.e("Failed to adjustAnalyticEventDataIfNeeded, exception: " + e, new Object[0]);
            return jSONObject;
        }
    }

    public static m e(JSONObject jSONObject) {
        return new m(jSONObject);
    }

    void a(JSONObject jSONObject) {
        try {
            String strG = l0.g();
            String strC = l0.c();
            String strG2 = PendoInternal.G();
            String strL = PendoInternal.l();
            if (!jSONObject.has("visitorId") && !jSONObject.has("visitor_id")) {
                if (strG2 != null) {
                    jSONObject.put("visitorId", strG2);
                } else if (strG != null) {
                    jSONObject.put("visitorId", strG);
                }
            }
            if (jSONObject.has("accountId") || jSONObject.has("account_id")) {
                return;
            }
            if (strL != null) {
                jSONObject.put("accountId", strL);
            } else if (strC != null) {
                jSONObject.put("accountId", strC);
            }
        } catch (JSONException e) {
            PendoLogger.e("Failed to addVisitorAndAccountDataIfNeeded, exception: " + e, new Object[0]);
        }
    }

    private sdk.pendo.io.q3.h<JSONObject, JSONObject> a() {
        return new sdk.pendo.io.q3.h() { // from class: sdk.pendo.io.r5.i$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.q3.h
            public final Object apply(Object obj) {
                return this.f$0.c((JSONObject) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean b(List list) {
        return !list.isEmpty();
    }

    private sdk.pendo.io.k3.j<?> a(sdk.pendo.io.k3.j<?> jVar) {
        return sdk.pendo.io.k3.j.a(h(), b(jVar), b(), this.c);
    }

    private <T> sdk.pendo.io.k3.j<T> b(sdk.pendo.io.k3.j<T> jVar) {
        return jVar.a((sdk.pendo.io.q3.j) new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(sdk.pendo.io.w6.b.c cVar) {
        boolean zEquals = cVar.equals(sdk.pendo.io.w6.b.c.IN_BACKGROUND);
        h = zEquals;
        return zEquals;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(List list) {
        try {
            sdk.pendo.io.r5.b.f().a((List<JSONObject>) list);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(j jVar) {
        JSONObject jSONObjectA = jVar.a();
        if (jSONObjectA != null) {
            this.b.onNext(jSONObjectA);
        }
    }

    public g a(GuideModel guideModel) {
        return new g(guideModel);
    }

    public static m a(g gVar) {
        return new m(gVar);
    }

    public void a(j... jVarArr) {
        sdk.pendo.io.k3.j.a((Object[]) jVarArr).a((o) sdk.pendo.io.t6.d.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.r5.i$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                this.f$0.a((j) obj);
            }
        }, "PendoAnalytics analytics data publisher bulk observer"));
    }
}
