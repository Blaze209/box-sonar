package sdk.pendo.io.c2;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b<L, R> implements Map.Entry<L, R>, Comparable<b<L, R>>, Serializable {
    public static final b<?, ?>[] a = new a[0];

    private static final class a<L, R> extends b<L, R> {
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b<L, R> bVar) {
        return new sdk.pendo.io.x1.a().a(a(), bVar.a()).a(b(), bVar.b()).a();
    }

    public abstract L a();

    public abstract R b();

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (Objects.equals(getKey(), entry.getKey()) && Objects.equals(getValue(), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final L getKey() {
        return a();
    }

    @Override // java.util.Map.Entry
    public R getValue() {
        return b();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return Objects.hashCode(getValue()) ^ Objects.hashCode(getKey());
    }

    public String toString() {
        return "(" + a() + AbstractJsonLexerKt.COMMA + b() + ')';
    }

    public static <L, R> b<L, R> a(L l, R r) {
        return sdk.pendo.io.c2.a.b(l, r);
    }
}
