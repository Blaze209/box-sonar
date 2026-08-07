package external.sdk.pendo.io.mozilla.javascript;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class NativeJavaMap extends NativeJavaObject {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Map<Object, Object> map;

    public NativeJavaMap(Scriptable scriptable, Object obj) {
        super(scriptable, obj, obj.getClass());
        this.map = (Map) obj;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        if (!this.map.containsKey(Integer.valueOf(i))) {
            return super.get(i, scriptable);
        }
        Context context = Context.getContext();
        Object obj = this.map.get(Integer.valueOf(i));
        return context.getWrapFactory().wrap(context, this, obj, obj.getClass());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaMap";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object[] getIds() {
        ArrayList arrayList = new ArrayList(this.map.size());
        for (Object obj : this.map.keySet()) {
            arrayList.add(obj instanceof Integer ? (Integer) obj : ScriptRuntime.toString(obj));
        }
        return arrayList.toArray();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        if (this.map.containsKey(Integer.valueOf(i))) {
            return true;
        }
        return super.has(i, scriptable);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        this.map.put(Integer.valueOf(i), Context.jsToJava(obj, Object.class));
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        if (!this.map.containsKey(str)) {
            return super.get(str, scriptable);
        }
        Context context = Context.getContext();
        Object obj = this.map.get(str);
        return context.getWrapFactory().wrap(context, this, obj, obj.getClass());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        if (this.map.containsKey(str)) {
            return true;
        }
        return super.has(str, scriptable);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        this.map.put(str, Context.jsToJava(obj, Object.class));
    }
}
