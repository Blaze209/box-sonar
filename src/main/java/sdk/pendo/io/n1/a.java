package sdk.pendo.io.n1;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.d1.h;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements b {
    @Override // sdk.pendo.io.n1.b
    public Object a(Object obj, int i) {
        return ((List) obj).get(i);
    }

    @Override // sdk.pendo.io.n1.b
    public Collection<String> c(Object obj) {
        if (e(obj)) {
            throw new UnsupportedOperationException();
        }
        return ((Map) obj).keySet();
    }

    @Override // sdk.pendo.io.n1.b
    public int d(Object obj) {
        if (e(obj)) {
            return ((List) obj).size();
        }
        if (a(obj)) {
            return c(obj).size();
        }
        if (obj instanceof String) {
            return ((String) obj).length();
        }
        throw new h("length operation cannot be applied to " + (obj != null ? obj.getClass().getName() : AbstractJsonLexerKt.NULL));
    }

    @Override // sdk.pendo.io.n1.b
    public boolean e(Object obj) {
        return obj instanceof List;
    }

    @Override // sdk.pendo.io.n1.b
    public Iterable<?> f(Object obj) {
        if (e(obj)) {
            return (Iterable) obj;
        }
        throw new h(new StringBuilder("Cannot iterate over ").append(obj).toString() != null ? obj.getClass().getName() : AbstractJsonLexerKt.NULL);
    }

    @Override // sdk.pendo.io.n1.b
    public Object g(Object obj) {
        return obj;
    }

    @Override // sdk.pendo.io.n1.b
    public Object a(Object obj, String str) {
        Map map = (Map) obj;
        return !map.containsKey(str) ? b.a : map.get(str);
    }

    @Override // sdk.pendo.io.n1.b
    public boolean a(Object obj) {
        return obj instanceof Map;
    }

    @Override // sdk.pendo.io.n1.b
    public void a(Object obj, int i, Object obj2) {
        if (!e(obj)) {
            throw new UnsupportedOperationException();
        }
        List list = (List) obj;
        if (i == list.size()) {
            list.add(obj2);
        } else {
            list.set(i, obj2);
        }
    }

    @Override // sdk.pendo.io.n1.b
    public void a(Object obj, Object obj2, Object obj3) {
        if (!a(obj)) {
            throw new h(new StringBuilder("setProperty operation cannot be used with ").append(obj).toString() != null ? obj.getClass().getName() : AbstractJsonLexerKt.NULL);
        }
        ((Map) obj).put(obj2.toString(), obj3);
    }
}
