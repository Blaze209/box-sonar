package io.opentelemetry.context;

import java.util.Arrays;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes4.dex */
final class ArrayBasedContext implements Context {
    private static final Context ROOT = new ArrayBasedContext(new Object[0]);
    private final Object[] entries;

    static Context root() {
        return ROOT;
    }

    private ArrayBasedContext(Object[] objArr) {
        this.entries = objArr;
    }

    @Override // io.opentelemetry.context.Context
    @Nullable
    public <V> V get(ContextKey<V> contextKey) {
        int i = 0;
        while (true) {
            Object[] objArr = this.entries;
            if (i >= objArr.length) {
                return null;
            }
            if (objArr[i] == contextKey) {
                return (V) objArr[i + 1];
            }
            i += 2;
        }
    }

    @Override // io.opentelemetry.context.Context
    public <V> Context with(ContextKey<V> contextKey, V v) {
        int i = 0;
        while (true) {
            Object[] objArr = this.entries;
            if (i < objArr.length) {
                if (objArr[i] == contextKey) {
                    int i2 = i + 1;
                    if (objArr[i2] == v) {
                        return this;
                    }
                    Object[] objArr2 = (Object[]) objArr.clone();
                    objArr2[i2] = v;
                    return new ArrayBasedContext(objArr2);
                }
                i += 2;
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + 2);
                objArrCopyOf[objArrCopyOf.length - 2] = contextKey;
                objArrCopyOf[objArrCopyOf.length - 1] = v;
                return new ArrayBasedContext(objArrCopyOf);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        int i = 0;
        while (true) {
            Object[] objArr = this.entries;
            if (i >= objArr.length) {
                break;
            }
            sb.append(objArr[i]).append('=').append(this.entries[i + 1]).append(", ");
            i += 2;
        }
        if (sb.length() > 1) {
            sb.setLength(sb.length() - 2);
        }
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
