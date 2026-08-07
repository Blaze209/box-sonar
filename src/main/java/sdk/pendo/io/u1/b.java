package sdk.pendo.io.u1;

import external.sdk.pendo.io.mozilla.javascript.Token;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import sdk.pendo.io.r1.g;
import sdk.pendo.io.r1.h;

/* JADX INFO: loaded from: classes5.dex */
public class b implements e<Object> {
    @Override // sdk.pendo.io.u1.e
    public <E> void a(E e, Appendable appendable, g gVar) {
        Method declaredMethod;
        Object objInvoke;
        Class<?> type;
        try {
            gVar.j(appendable);
            boolean z = false;
            for (Class<?> superclass = e.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
                for (Field field : superclass.getDeclaredFields()) {
                    int modifiers = field.getModifiers();
                    if ((modifiers & Token.GET) <= 0) {
                        if ((modifiers & 1) > 0) {
                            objInvoke = field.get(e);
                        } else {
                            try {
                                declaredMethod = superclass.getDeclaredMethod(h.a(field.getName()), new Class[0]);
                            } catch (Exception unused) {
                                declaredMethod = null;
                            }
                            if (declaredMethod == null && ((type = field.getType()) == Boolean.TYPE || type == Boolean.class)) {
                                declaredMethod = superclass.getDeclaredMethod(h.b(field.getName()), new Class[0]);
                            }
                            if (declaredMethod != null) {
                                objInvoke = declaredMethod.invoke(e, new Object[0]);
                            }
                        }
                        if (objInvoke != null || !gVar.a()) {
                            if (z) {
                                gVar.i(appendable);
                            } else {
                                z = true;
                            }
                            d.a(field.getName(), objInvoke, appendable, gVar);
                        }
                    }
                }
            }
            gVar.k(appendable);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
