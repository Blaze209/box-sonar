package external.sdk.pendo.io.mozilla.javascript;

import com.pspdfkit.analytics.Analytics;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes4.dex */
public class NativeJavaArray extends NativeJavaObject {
    private static final long serialVersionUID = -924022554283675333L;
    Object array;
    Class<?> cls;
    int length;

    public NativeJavaArray(Scriptable scriptable, Object obj) {
        super(scriptable, null, ScriptRuntime.ObjectClass);
        Class<?> cls = obj.getClass();
        if (!cls.isArray()) {
            throw new RuntimeException("Array expected");
        }
        this.array = obj;
        this.length = Array.getLength(obj);
        this.cls = cls.getComponentType();
    }

    public static NativeJavaArray wrap(Scriptable scriptable, Object obj) {
        return new NativeJavaArray(scriptable, obj);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.SymbolScriptable
    public void delete(Symbol symbol) {
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        if (i < 0 || i >= this.length) {
            return Undefined.instance;
        }
        Context context = Context.getContext();
        return context.getWrapFactory().wrap(context, this, Array.get(this.array, i), this.cls);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaArray";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        if (cls == null || cls == ScriptRuntime.StringClass) {
            return this.array.toString();
        }
        if (cls == ScriptRuntime.BooleanClass) {
            return Boolean.TRUE;
        }
        return cls == ScriptRuntime.NumberClass ? ScriptRuntime.NaNobj : this;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object[] getIds() {
        int i = this.length;
        Object[] objArr = new Object[i];
        while (true) {
            i--;
            if (i < 0) {
                return objArr;
            }
            objArr[i] = Integer.valueOf(i);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Scriptable getPrototype() {
        if (this.prototype == null) {
            this.prototype = ScriptableObject.getArrayPrototype(getParentScope());
        }
        return this.prototype;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return i >= 0 && i < this.length;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean hasInstance(Scriptable scriptable) {
        if (!(scriptable instanceof Wrapper)) {
            return false;
        }
        return this.cls.isInstance(((Wrapper) scriptable).unwrap());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        if (i < 0 || i >= this.length) {
            throw Context.reportRuntimeError2("msg.java.array.index.out.of.bounds", String.valueOf(i), String.valueOf(this.length - 1));
        }
        Array.set(this.array, i, Context.jsToJava(obj, this.cls));
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Wrapper
    public Object unwrap() {
        return this.array;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.SymbolScriptable
    public Object get(Symbol symbol, Scriptable scriptable) {
        return SymbolKey.IS_CONCAT_SPREADABLE.equals(symbol) ? Boolean.TRUE : Scriptable.NOT_FOUND;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.SymbolScriptable
    public boolean has(Symbol symbol, Scriptable scriptable) {
        return SymbolKey.IS_CONCAT_SPREADABLE.equals(symbol);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (!str.equals(Analytics.Data.LENGTH)) {
            throw Context.reportRuntimeError1("msg.java.array.member.not.found", str);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        if (str.equals(Analytics.Data.LENGTH)) {
            return Integer.valueOf(this.length);
        }
        Object obj = super.get(str, scriptable);
        if (obj != Scriptable.NOT_FOUND || ScriptableObject.hasProperty(getPrototype(), str)) {
            return obj;
        }
        throw Context.reportRuntimeError2("msg.java.member.not.found", this.array.getClass().getName(), str);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return str.equals(Analytics.Data.LENGTH) || super.has(str, scriptable);
    }
}
