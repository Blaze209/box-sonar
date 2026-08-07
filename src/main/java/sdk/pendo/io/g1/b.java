package sdk.pendo.io.g1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.e1.g;

/* JADX INFO: loaded from: classes4.dex */
public class b {
    private a a;
    private g b;
    private sdk.pendo.io.i1.a c;
    private Boolean d;
    private String e;

    public b() {
        this.d = Boolean.FALSE;
    }

    public static void a(Class cls, sdk.pendo.io.e1.d dVar, Collection collection, Object obj) {
        if (!dVar.a().f().e(obj)) {
            if (obj == null || !cls.isAssignableFrom(obj.getClass())) {
                return;
            }
            collection.add(obj);
            return;
        }
        for (Object string : dVar.a().f().f(obj)) {
            if (string == null || !cls.isAssignableFrom(string.getClass())) {
                if (string != null && cls == String.class) {
                    string = string.toString();
                }
            }
            collection.add(string);
        }
    }

    public g b() {
        return this.b;
    }

    public a c() {
        return this.a;
    }

    public Object d() {
        return this.c.get();
    }

    public boolean e() {
        return this.d.booleanValue();
    }

    public b(String str) {
        this.d = Boolean.FALSE;
        this.e = str;
        this.a = a.JSON;
    }

    public String a() {
        return this.e;
    }

    public b(g gVar) {
        this.d = Boolean.FALSE;
        this.b = gVar;
        this.a = a.PATH;
    }

    public void a(Boolean bool) {
        this.d = bool;
    }

    public void a(sdk.pendo.io.i1.a aVar) {
        this.c = aVar;
    }

    public void a(g gVar) {
        this.b = gVar;
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    public static <T> List<T> a(Class<T> cls, sdk.pendo.io.e1.d dVar, List<b> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                a(cls, dVar, arrayList, it.next().d());
            }
        }
        return arrayList;
    }
}
