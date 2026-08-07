package sdk.pendo.io.a0;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i {
    public boolean a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public f d() {
        if (h()) {
            return (f) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public l e() {
        if (j()) {
            return (l) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public n f() {
        if (k()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean h() {
        return this instanceof f;
    }

    public boolean i() {
        return this instanceof k;
    }

    public boolean j() {
        return this instanceof l;
    }

    public boolean k() {
        return this instanceof n;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            sdk.pendo.io.h0.c cVar = new sdk.pendo.io.h0.c(stringWriter);
            cVar.b(true);
            sdk.pendo.io.c0.k.a(this, cVar);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
