package external.sdk.pendo.io.gson;

import external.sdk.pendo.io.gson.internal.Excluder;
import external.sdk.pendo.io.gson.internal.bind.DefaultDateTypeAdapter;
import external.sdk.pendo.io.gson.internal.bind.TreeTypeAdapter;
import external.sdk.pendo.io.gson.internal.bind.TypeAdapters;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.a0.c;
import sdk.pendo.io.a0.d;
import sdk.pendo.io.a0.e;
import sdk.pendo.io.a0.h;
import sdk.pendo.io.a0.p;
import sdk.pendo.io.a0.r;
import sdk.pendo.io.a0.t;
import sdk.pendo.io.a0.u;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private Excluder a = Excluder.g;
    private r b = r.DEFAULT;
    private d c = c.IDENTITY;
    private final Map<Type, e<?>> d = new HashMap();
    private final List<u> e = new ArrayList();
    private final List<u> f = new ArrayList();
    private boolean g = false;
    private String h = Gson.y;
    private int i = 2;
    private int j = 2;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = true;
    private t r = Gson.A;
    private t s = Gson.B;

    private void a(String str, int i, int i2, List<u> list) {
        u uVarA;
        u uVarA2;
        boolean z = external.sdk.pendo.io.gson.internal.sql.a.a;
        u uVarA3 = null;
        if (str != null && !str.trim().isEmpty()) {
            uVarA = DefaultDateTypeAdapter.b.b.a(str);
            if (z) {
                uVarA3 = external.sdk.pendo.io.gson.internal.sql.a.c.a(str);
                uVarA2 = external.sdk.pendo.io.gson.internal.sql.a.b.a(str);
            } else {
                uVarA2 = null;
            }
        } else {
            if (i == 2 || i2 == 2) {
                return;
            }
            u uVarA4 = DefaultDateTypeAdapter.b.b.a(i, i2);
            if (z) {
                uVarA3 = external.sdk.pendo.io.gson.internal.sql.a.c.a(i, i2);
                u uVarA5 = external.sdk.pendo.io.gson.internal.sql.a.b.a(i, i2);
                uVarA = uVarA4;
                uVarA2 = uVarA5;
            } else {
                uVarA = uVarA4;
                uVarA2 = null;
            }
        }
        list.add(uVarA);
        if (z) {
            list.add(uVarA3);
            list.add(uVarA2);
        }
    }

    public a b() {
        this.m = false;
        return this;
    }

    public a c() {
        this.a = this.a.b();
        return this;
    }

    public Gson a() {
        List<u> arrayList = new ArrayList<>(this.e.size() + this.f.size() + 3);
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.h, this.i, this.j, arrayList);
        return new Gson(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.q, this.b, this.h, this.i, this.j, this.e, this.f, arrayList, this.r, this.s);
    }

    public a a(Type type, Object obj) {
        boolean z = obj instanceof p;
        sdk.pendo.io.c0.a.a(z || (obj instanceof h) || (obj instanceof e) || (obj instanceof TypeAdapter));
        if (obj instanceof e) {
            this.d.put(type, (e) obj);
        }
        if (z || (obj instanceof h)) {
            this.e.add(TreeTypeAdapter.a(sdk.pendo.io.g0.a.a(type), obj));
        }
        if (obj instanceof TypeAdapter) {
            this.e.add(TypeAdapters.a(sdk.pendo.io.g0.a.a(type), (TypeAdapter) obj));
        }
        return this;
    }
}
