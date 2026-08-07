package external.sdk.pendo.io.gson;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import sdk.pendo.io.a0.i;
import sdk.pendo.io.a0.j;
import sdk.pendo.io.h0.b;
import sdk.pendo.io.h0.c;

/* JADX INFO: loaded from: classes4.dex */
public abstract class TypeAdapter<T> {
    public final T a(Reader reader) {
        return a(new sdk.pendo.io.h0.a(reader));
    }

    public abstract T a(sdk.pendo.io.h0.a aVar);

    public abstract void a(c cVar, T t);

    public final T a(String str) {
        return a((Reader) new StringReader(str));
    }

    public final TypeAdapter<T> a() {
        return new TypeAdapter<T>() { // from class: external.sdk.pendo.io.gson.TypeAdapter.1
            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public T a(sdk.pendo.io.h0.a aVar) throws IOException {
                if (aVar.t() != b.NULL) {
                    return (T) TypeAdapter.this.a(aVar);
                }
                aVar.q();
                return null;
            }

            @Override // external.sdk.pendo.io.gson.TypeAdapter
            public void a(c cVar, T t) throws IOException {
                if (t == null) {
                    cVar.k();
                } else {
                    TypeAdapter.this.a(cVar, t);
                }
            }
        };
    }

    public final i a(T t) {
        try {
            sdk.pendo.io.d0.a aVar = new sdk.pendo.io.d0.a();
            a(aVar, t);
            return aVar.n();
        } catch (IOException e) {
            throw new j(e);
        }
    }
}
