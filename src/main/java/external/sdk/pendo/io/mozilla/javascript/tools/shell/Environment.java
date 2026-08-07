package external.sdk.pendo.io.mozilla.javascript.tools.shell;

import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.ScriptableObject;

/* JADX INFO: loaded from: classes4.dex */
public class Environment extends ScriptableObject {
    static final long serialVersionUID = -430727378460177065L;
    private Environment thePrototypeInstance = this;

    public Environment() {
    }

    private Object[] collectIds() {
        return System.getProperties().keySet().toArray();
    }

    public static void defineClass(ScriptableObject scriptableObject) {
        try {
            ScriptableObject.defineClass(scriptableObject, Environment.class);
        } catch (Exception e) {
            throw new Error(e.getMessage());
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        if (this == this.thePrototypeInstance) {
            return super.get(str, scriptable);
        }
        String property = System.getProperty(str);
        return property != null ? ScriptRuntime.toObject(getParentScope(), property) : Scriptable.NOT_FOUND;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.debug.DebuggableObject
    public Object[] getAllIds() {
        return this == this.thePrototypeInstance ? super.getAllIds() : collectIds();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Environment";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object[] getIds() {
        return this == this.thePrototypeInstance ? super.getIds() : collectIds();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        if (this == this.thePrototypeInstance) {
            return super.has(str, scriptable);
        }
        return System.getProperty(str) != null;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
        if (this == this.thePrototypeInstance) {
            super.put(str, scriptable, obj);
        } else {
            System.getProperties().put(str, ScriptRuntime.toString(obj));
        }
    }

    public Environment(ScriptableObject scriptableObject) {
        setParentScope(scriptableObject);
        Object topLevelProp = ScriptRuntime.getTopLevelProp(scriptableObject, "Environment");
        if (topLevelProp == null || !(topLevelProp instanceof Scriptable)) {
            return;
        }
        Scriptable scriptable = (Scriptable) topLevelProp;
        setPrototype((Scriptable) scriptable.get("prototype", scriptable));
    }
}
