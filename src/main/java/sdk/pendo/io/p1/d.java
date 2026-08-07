package sdk.pendo.io.p1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d<T> {
    private static ConcurrentHashMap<Class<?>, d<?>> c = new ConcurrentHashMap<>();
    private HashMap<String, b> a;
    private b[] b;

    private static void a(d<?> dVar, HashMap<String, String> map) {
        if (map == null) {
            return;
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            b bVar = ((d) dVar).a.get(entry.getValue());
            if (bVar != null) {
                map2.put(entry.getValue(), bVar);
            }
        }
        ((d) dVar).a.putAll(map2);
    }

    public abstract Object a(T t, int i);

    public abstract void a(T t, int i, Object obj);

    public HashMap<String, b> b() {
        return this.a;
    }

    public abstract T c();

    public static <P> d<P> a(Class<P> cls, j jVar) {
        Class<?> clsA;
        d<P> dVar = (d) c.get(cls);
        if (dVar != null) {
            return dVar;
        }
        b[] bVarArrA = a.a((Class<?>) cls, jVar);
        String name = cls.getName();
        String strConcat = name.startsWith("java.util.") ? "external.sdk.pendo.io.jsonsmart.asm." + name + "AccAccess" : name.concat("AccAccess");
        i iVar = new i(cls.getClassLoader());
        try {
            clsA = iVar.loadClass(strConcat);
        } catch (ClassNotFoundException unused) {
            clsA = null;
        }
        LinkedList<Class<?>> linkedListA = a((Class<?>) cls);
        if (clsA == null) {
            e eVar = new e(cls, bVarArrA, iVar);
            Iterator<Class<?>> it = linkedListA.iterator();
            while (it.hasNext()) {
                eVar.a(f.a.get(it.next()));
            }
            clsA = eVar.a();
        }
        try {
            d<P> dVar2 = (d) clsA.newInstance();
            dVar2.a(bVarArrA);
            c.putIfAbsent(cls, dVar2);
            Iterator<Class<?>> it2 = linkedListA.iterator();
            while (it2.hasNext()) {
                a((d<?>) dVar2, f.b.get(it2.next()));
            }
            return dVar2;
        } catch (Exception e) {
            throw new RuntimeException("Error constructing accessor class: " + strConcat, e);
        }
    }

    public b[] a() {
        return this.b;
    }

    public int a(String str) {
        b bVar = this.a.get(str);
        if (bVar == null) {
            return -1;
        }
        return bVar.d;
    }

    private static LinkedList<Class<?>> a(Class<?> cls) {
        LinkedList<Class<?>> linkedList = new LinkedList<>();
        while (cls != null && !cls.equals(Object.class)) {
            linkedList.addLast(cls);
            for (Class<?> cls2 : cls.getInterfaces()) {
                linkedList.addLast(cls2);
            }
            cls = cls.getSuperclass();
        }
        linkedList.addLast(Object.class);
        return linkedList;
    }

    public void a(T t, String str, Object obj) {
        int iA = a(str);
        if (iA == -1) {
            throw new sdk.pendo.io.q1.a(str + " in " + t.getClass() + " to put value : " + obj);
        }
        a(t, iA, obj);
    }

    protected void a(b[] bVarArr) {
        this.b = bVarArr;
        this.a = new HashMap<>();
        int length = bVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            b bVar = bVarArr[i];
            bVar.d = i2;
            this.a.put(bVar.c(), bVar);
            i++;
            i2++;
        }
    }
}
