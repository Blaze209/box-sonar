package external.sdk.pendo.io.jose4j.jwt.consumer;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class g {
    private String a;
    private sdk.pendo.io.v0.b b;
    private List<sdk.pendo.io.x0.c> c;

    public g(String str, sdk.pendo.io.v0.b bVar, List<sdk.pendo.io.x0.c> list) {
        this.a = str;
        this.b = bVar;
        this.c = list;
    }

    public List<sdk.pendo.io.x0.c> a() {
        return this.c;
    }

    public String b() {
        return this.a;
    }

    public sdk.pendo.io.v0.b c() {
        return this.b;
    }

    void a(sdk.pendo.io.v0.b bVar) {
        this.b = bVar;
    }
}
