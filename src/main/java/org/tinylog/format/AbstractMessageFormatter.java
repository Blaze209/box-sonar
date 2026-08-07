package org.tinylog.format;

import org.tinylog.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractMessageFormatter implements MessageFormatter {
    protected static final int ADDITIONAL_STRING_BUILDER_CAPACITY = 32;

    protected AbstractMessageFormatter() {
    }

    protected static Object[] resolve(Object[] objArr) {
        Object[] objArr2 = new Object[objArr.length];
        for (int i = 0; i < objArr.length; i++) {
            objArr2[i] = resolve(objArr[i]);
        }
        return objArr2;
    }

    protected static Object resolve(Object obj) {
        return obj instanceof Supplier ? ((Supplier) obj).get() : obj;
    }
}
