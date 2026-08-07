package sdk.pendo.io.r5;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class m {
    private final transient sdk.pendo.io.j4.b<a> a;
    private final g b;
    private JSONObject c;

    public static final class a {
        private final d a;
        private final JSONObject b;
        private final long c = System.currentTimeMillis();
        private final String d;

        public a(d dVar, JSONObject jSONObject, String str) {
            this.a = dVar;
            this.b = jSONObject;
            this.d = str;
        }

        protected String a() {
            return this.d;
        }

        protected d b() {
            return this.a;
        }

        public JSONObject c() {
            return this.b;
        }

        public long d() {
            return this.c;
        }
    }

    protected m() {
        sdk.pendo.io.j4.b<a> bVarM = sdk.pendo.io.j4.b.m();
        this.a = bVarM;
        this.b = null;
        this.c = null;
        bVarM.a(sdk.pendo.io.t6.d.a(a(true), "Tracker trackerInfoPublisher none observer"));
    }

    public void a(d dVar, JSONObject jSONObject, String str) {
        a(new a(dVar, jSONObject, str));
    }

    public g b() {
        return this.b;
    }

    protected m(JSONObject jSONObject) {
        sdk.pendo.io.j4.b<a> bVarM = sdk.pendo.io.j4.b.m();
        this.a = bVarM;
        this.b = null;
        this.c = jSONObject;
        bVarM.a(sdk.pendo.io.t6.d.a(a(false), "Tracker trackerInfoPublisher json analytics data observer"));
    }

    public JSONObject a() {
        return this.c;
    }

    protected m(g gVar) {
        sdk.pendo.io.j4.b<a> bVarM = sdk.pendo.io.j4.b.m();
        this.a = bVarM;
        this.b = gVar;
        this.c = null;
        if (gVar != null) {
            gVar.d().setTracker(this);
        }
        bVarM.a(sdk.pendo.io.t6.d.a(a(true), "Tracker trackerInfoPublisher GenericPendoAnalyticsData observer"));
    }

    protected sdk.pendo.io.q3.e<a> a(final boolean z) {
        return new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.r5.m$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.q3.e
            public final void accept(Object obj) {
                this.f$0.a(z, (m.a) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, a aVar) {
        i.e().a(z ? new j(this.b, aVar) : new j(this.c, aVar));
    }

    public void a(a aVar) {
        this.a.onNext(aVar);
    }

    public void a(JSONObject jSONObject) {
        this.c = jSONObject;
    }
}
