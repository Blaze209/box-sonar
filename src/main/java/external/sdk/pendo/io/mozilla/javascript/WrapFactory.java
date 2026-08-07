package external.sdk.pendo.io.mozilla.javascript;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class WrapFactory {
    private boolean javaPrimitiveWrap = true;

    public final boolean isJavaPrimitiveWrap() {
        return this.javaPrimitiveWrap;
    }

    public final void setJavaPrimitiveWrap(boolean z) {
        Context currentContext = Context.getCurrentContext();
        if (currentContext != null && currentContext.isSealed()) {
            Context.onSealedMutation();
        }
        this.javaPrimitiveWrap = z;
    }

    public Object wrap(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        Object obj2;
        if (obj != null && obj != (obj2 = Undefined.instance) && !(obj instanceof Scriptable)) {
            if (cls == null || !cls.isPrimitive()) {
                if (!isJavaPrimitiveWrap()) {
                    if (!(obj instanceof String) && !(obj instanceof Boolean) && !(obj instanceof Integer) && !(obj instanceof Short) && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Double)) {
                        if (obj instanceof Character) {
                            return String.valueOf(((Character) obj).charValue());
                        }
                    }
                }
                return obj.getClass().isArray() ? NativeJavaArray.wrap(scriptable, obj) : wrapAsJavaObject(context, scriptable, obj, cls);
            }
            if (cls == Void.TYPE) {
                return obj2;
            }
            if (cls == Character.TYPE) {
                return Integer.valueOf(((Character) obj).charValue());
            }
        }
        return obj;
    }

    public Scriptable wrapAsJavaObject(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        if (List.class.isAssignableFrom(obj.getClass())) {
            return new NativeJavaList(scriptable, obj);
        }
        return Map.class.isAssignableFrom(obj.getClass()) ? new NativeJavaMap(scriptable, obj) : new NativeJavaObject(scriptable, obj, cls);
    }

    public Scriptable wrapJavaClass(Context context, Scriptable scriptable, Class<?> cls) {
        return new NativeJavaClass(scriptable, cls);
    }

    public Scriptable wrapNewObject(Context context, Scriptable scriptable, Object obj) {
        if (obj instanceof Scriptable) {
            return (Scriptable) obj;
        }
        return obj.getClass().isArray() ? NativeJavaArray.wrap(scriptable, obj) : wrapAsJavaObject(context, scriptable, obj, null);
    }
}
