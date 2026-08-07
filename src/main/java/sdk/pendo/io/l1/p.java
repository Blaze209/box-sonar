package sdk.pendo.io.l1;

/* JADX INFO: loaded from: classes4.dex */
public class p extends j {
    private j f = this;
    private int g = 1;
    private final String h;

    class a implements k {
        a() {
        }

        @Override // sdk.pendo.io.l1.k
        public k a(j jVar) {
            p.this.c(jVar);
            return this;
        }
    }

    p(char c) {
        this.h = Character.toString(c);
    }

    @Override // sdk.pendo.io.l1.j
    public void a(String str, sdk.pendo.io.e1.h hVar, Object obj, g gVar) {
        if (!b()) {
            g().a(this.h, hVar, obj, gVar);
            return;
        }
        if (!gVar.c()) {
            hVar = sdk.pendo.io.e1.h.b;
        }
        gVar.a(this.h, hVar, obj);
    }

    public p c(j jVar) {
        this.f = this.f.a(jVar);
        this.g++;
        return this;
    }

    public void d(j jVar) {
        this.f = jVar;
    }

    @Override // sdk.pendo.io.l1.j
    public boolean e() {
        return true;
    }

    public k h() {
        return new a();
    }

    public boolean i() {
        return this.f instanceof h;
    }

    @Override // sdk.pendo.io.l1.j
    public String a() {
        return this.h;
    }
}
