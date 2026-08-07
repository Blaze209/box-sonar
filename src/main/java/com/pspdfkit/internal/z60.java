package com.pspdfkit.internal;

import com.pspdfkit.undo.edit.Edit;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class z60 {
    public final LinkedHashMap a = new LinkedHashMap();

    public final <T extends Edit> y60<T> a(Class<? extends T> cls) {
        y60<T> y60Var = (y60) this.a.get(cls);
        if (y60Var != null) {
            return y60Var;
        }
        for (Map.Entry entry : this.a.entrySet()) {
            Class cls2 = (Class) entry.getKey();
            y60<T> y60Var2 = (y60) entry.getValue();
            if (cls2.isAssignableFrom(cls)) {
                y60Var2.getClass();
                if (y60Var2.a(cls)) {
                    return y60Var2;
                }
            }
        }
        throw new IllegalArgumentException("Unregistered Edit class " + cls.getName() + " requests UndoExecutor.");
    }
}
