package external.sdk.pendo.io.glide.load;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import sdk.pendo.io.e.f;
import sdk.pendo.io.e.g;
import sdk.pendo.io.y.b;

/* JADX INFO: loaded from: classes4.dex */
public final class Options implements f {
    private final ArrayMap<g<?>, Object> values = new b();

    @Override // sdk.pendo.io.e.f
    public boolean equals(Object obj) {
        if (obj instanceof Options) {
            return this.values.equals(((Options) obj).values);
        }
        return false;
    }

    public <T> T get(g<T> gVar) {
        return this.values.containsKey(gVar) ? (T) this.values.get(gVar) : gVar.b();
    }

    @Override // sdk.pendo.io.e.f
    public int hashCode() {
        return this.values.hashCode();
    }

    public void putAll(Options options) {
        this.values.putAll((SimpleArrayMap<? extends g<?>, ? extends Object>) options.values);
    }

    public Options remove(g<?> gVar) {
        this.values.remove(gVar);
        return this;
    }

    public <T> Options set(g<T> gVar, T t) {
        this.values.put(gVar, t);
        return this;
    }

    public String toString() {
        return "Options{values=" + this.values + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // sdk.pendo.io.e.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (int i = 0; i < this.values.getSize(); i++) {
            updateDiskCacheKey(this.values.keyAt(i), this.values.valueAt(i), messageDigest);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void updateDiskCacheKey(g<T> gVar, Object obj, MessageDigest messageDigest) {
        gVar.a(obj, messageDigest);
    }
}
