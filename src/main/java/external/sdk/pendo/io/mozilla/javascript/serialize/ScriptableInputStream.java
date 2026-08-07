package external.sdk.pendo.io.mozilla.javascript.serialize;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Undefined;
import external.sdk.pendo.io.mozilla.javascript.UniqueTag;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/* JADX INFO: loaded from: classes4.dex */
public class ScriptableInputStream extends ObjectInputStream {
    private ClassLoader classLoader;
    private Scriptable scope;

    public ScriptableInputStream(InputStream inputStream, Scriptable scriptable) {
        super(inputStream);
        this.scope = scriptable;
        enableResolveObject(true);
        Context currentContext = Context.getCurrentContext();
        if (currentContext != null) {
            this.classLoader = currentContext.getApplicationClassLoader();
        }
    }

    @Override // java.io.ObjectInputStream
    protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) {
        String name = objectStreamClass.getName();
        ClassLoader classLoader = this.classLoader;
        if (classLoader != null) {
            try {
                return classLoader.loadClass(name);
            } catch (ClassNotFoundException unused) {
            }
        }
        return super.resolveClass(objectStreamClass);
    }

    @Override // java.io.ObjectInputStream
    protected Object resolveObject(Object obj) throws IOException {
        if (!(obj instanceof ScriptableOutputStream.PendingLookup)) {
            if (obj instanceof UniqueTag) {
                return ((UniqueTag) obj).readResolve();
            }
            return obj instanceof Undefined ? ((Undefined) obj).readResolve() : obj;
        }
        String name = ((ScriptableOutputStream.PendingLookup) obj).getName();
        Object objLookupQualifiedName = ScriptableOutputStream.lookupQualifiedName(this.scope, name);
        if (objLookupQualifiedName != Scriptable.NOT_FOUND) {
            return objLookupQualifiedName;
        }
        throw new IOException("Object " + name + " not found upon deserialization.");
    }
}
