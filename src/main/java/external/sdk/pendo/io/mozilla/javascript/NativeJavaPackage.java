package external.sdk.pendo.io.mozilla.javascript;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class NativeJavaPackage extends ScriptableObject {
    private static final long serialVersionUID = 7445054382212031523L;
    private transient ClassLoader classLoader;
    private Set<String> negativeCache;
    private String packageName;

    @Deprecated
    public NativeJavaPackage(String str) {
        this(false, str, Context.getCurrentContext().getApplicationClassLoader());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.classLoader = Context.getCurrentContext().getApplicationClassLoader();
    }

    public boolean equals(Object obj) {
        if (obj instanceof NativeJavaPackage) {
            NativeJavaPackage nativeJavaPackage = (NativeJavaPackage) obj;
            if (this.packageName.equals(nativeJavaPackage.packageName) && this.classLoader == nativeJavaPackage.classLoader) {
                return true;
            }
        }
        return false;
    }

    NativeJavaPackage forcePackage(String str, Scriptable scriptable) {
        Object obj = super.get(str, this);
        if (obj != null && (obj instanceof NativeJavaPackage)) {
            return (NativeJavaPackage) obj;
        }
        NativeJavaPackage nativeJavaPackage = new NativeJavaPackage(true, this.packageName.length() == 0 ? str : this.packageName + "." + str, this.classLoader);
        ScriptRuntime.setObjectProtoAndParent(nativeJavaPackage, scriptable);
        super.put(str, this, nativeJavaPackage);
        return nativeJavaPackage;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return Scriptable.NOT_FOUND;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "JavaPackage";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        return toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v3, types: [external.sdk.pendo.io.mozilla.javascript.Scriptable] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v6, types: [external.sdk.pendo.io.mozilla.javascript.NativeJavaPackage, external.sdk.pendo.io.mozilla.javascript.ScriptableObject] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r5v0, types: [external.sdk.pendo.io.mozilla.javascript.NativeJavaPackage, external.sdk.pendo.io.mozilla.javascript.Scriptable, external.sdk.pendo.io.mozilla.javascript.ScriptableObject] */
    synchronized Object getPkgProperty(String str, Scriptable scriptable, boolean z) {
        Object obj = super.get(str, scriptable);
        if (obj != Scriptable.NOT_FOUND) {
            return obj;
        }
        Set<String> set = this.negativeCache;
        ?? WrapJavaClass = 0;
        WrapJavaClass = 0;
        if (set != null && set.contains(str)) {
            return null;
        }
        String str2 = this.packageName.length() == 0 ? str : this.packageName + '.' + str;
        Context context = Context.getContext();
        ClassShutter classShutter = context.getClassShutter();
        if (classShutter == null || classShutter.visibleToScripts(str2)) {
            ClassLoader classLoader = this.classLoader;
            Class<?> clsClassOrNull = classLoader != null ? Kit.classOrNull(classLoader, str2) : Kit.classOrNull(str2);
            if (clsClassOrNull != null) {
                WrapJavaClass = context.getWrapFactory().wrapJavaClass(context, ScriptableObject.getTopLevelScope(this), clsClassOrNull);
                WrapJavaClass.setPrototype(getPrototype());
            }
        }
        if (WrapJavaClass == 0) {
            if (z) {
                WrapJavaClass = new NativeJavaPackage(true, str2, this.classLoader);
                ScriptRuntime.setObjectProtoAndParent(WrapJavaClass, getParentScope());
            } else {
                if (this.negativeCache == null) {
                    this.negativeCache = new HashSet();
                }
                this.negativeCache.add(str);
            }
        }
        if (WrapJavaClass != 0) {
            super.put(str, scriptable, WrapJavaClass);
        }
        return WrapJavaClass;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return false;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(String str, Scriptable scriptable) {
        return true;
    }

    public int hashCode() {
        int iHashCode = this.packageName.hashCode();
        ClassLoader classLoader = this.classLoader;
        return (classLoader == null ? 0 : classLoader.hashCode()) ^ iHashCode;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        throw Context.reportRuntimeError0("msg.pkg.int");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(String str, Scriptable scriptable, Object obj) {
    }

    public String toString() {
        return "[JavaPackage " + this.packageName + "]";
    }

    @Deprecated
    public NativeJavaPackage(String str, ClassLoader classLoader) {
        this(false, str, classLoader);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(String str, Scriptable scriptable) {
        return getPkgProperty(str, scriptable, true);
    }

    NativeJavaPackage(boolean z, String str, ClassLoader classLoader) {
        this.negativeCache = null;
        this.packageName = str;
        this.classLoader = classLoader;
    }
}
