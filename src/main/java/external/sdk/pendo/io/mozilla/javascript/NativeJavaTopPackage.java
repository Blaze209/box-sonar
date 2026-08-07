package external.sdk.pendo.io.mozilla.javascript;

import com.box.android.capture.documentscanning.logic.TextRecognitionConverter;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;

/* JADX INFO: loaded from: classes4.dex */
public class NativeJavaTopPackage extends NativeJavaPackage implements Function, IdFunctionCall {
    private static final int Id_getClass = 1;
    private static final long serialVersionUID = -1455787259477709999L;
    private static final String[][] commonPackages = {new String[]{ResourceAttributes.TelemetrySdkLanguageValues.JAVA, TextRecognitionConverter.Attributes.LANG, "reflect"}, new String[]{ResourceAttributes.TelemetrySdkLanguageValues.JAVA, "io"}, new String[]{ResourceAttributes.TelemetrySdkLanguageValues.JAVA, "math"}, new String[]{ResourceAttributes.TelemetrySdkLanguageValues.JAVA, "net"}, new String[]{ResourceAttributes.TelemetrySdkLanguageValues.JAVA, "util", "zip"}, new String[]{ResourceAttributes.TelemetrySdkLanguageValues.JAVA, "text", "resources"}, new String[]{ResourceAttributes.TelemetrySdkLanguageValues.JAVA, "applet"}, new String[]{"javax", "swing"}};
    private static final Object FTAG = "JavaTopPackage";

    NativeJavaTopPackage(ClassLoader classLoader) {
        super(true, "", classLoader);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        NativeJavaTopPackage nativeJavaTopPackage = new NativeJavaTopPackage(context.getApplicationClassLoader());
        nativeJavaTopPackage.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeJavaTopPackage.setParentScope(scriptable);
        for (int i = 0; i != commonPackages.length; i++) {
            int i2 = 0;
            NativeJavaPackage nativeJavaPackage = nativeJavaTopPackage;
            while (true) {
                String[] strArr = commonPackages[i];
                if (i2 != strArr.length) {
                    NativeJavaPackage nativeJavaPackageForcePackage = nativeJavaPackage.forcePackage(strArr[i2], scriptable);
                    i2++;
                    nativeJavaPackage = nativeJavaPackageForcePackage;
                }
            }
        }
        IdFunctionObject idFunctionObject = new IdFunctionObject(nativeJavaTopPackage, FTAG, 1, "getClass", 1, scriptable);
        String[] topPackageNames = ScriptRuntime.getTopPackageNames();
        Object[] objArr = new NativeJavaPackage[topPackageNames.length];
        for (int i3 = 0; i3 < topPackageNames.length; i3++) {
            objArr[i3] = (NativeJavaPackage) nativeJavaTopPackage.get(topPackageNames[i3], nativeJavaTopPackage);
        }
        ScriptableObject scriptableObject = (ScriptableObject) scriptable;
        if (z) {
            idFunctionObject.sealObject();
        }
        idFunctionObject.exportAsScopeProperty();
        scriptableObject.defineProperty("Packages", nativeJavaTopPackage, 2);
        for (int i4 = 0; i4 < topPackageNames.length; i4++) {
            scriptableObject.defineProperty(topPackageNames[i4], objArr[i4], 2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [external.sdk.pendo.io.mozilla.javascript.Scriptable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    private Scriptable js_getClass(Context context, Scriptable scriptable, Object[] objArr) {
        if (objArr.length > 0) {
            int i = 0;
            Object obj = objArr[0];
            if (obj instanceof Wrapper) {
                String name = ((Wrapper) obj).unwrap().getClass().getName();
                ?? r1 = this;
                while (true) {
                    int iIndexOf = name.indexOf(46, i);
                    Object obj2 = r1.get(iIndexOf == -1 ? name.substring(i) : name.substring(i, iIndexOf), r1);
                    if (!(obj2 instanceof Scriptable)) {
                        break;
                    }
                    Scriptable scriptable2 = (Scriptable) obj2;
                    if (iIndexOf == -1) {
                        return scriptable2;
                    }
                    i = iIndexOf + 1;
                    r1 = scriptable2;
                }
            }
        }
        throw Context.reportRuntimeError0("msg.not.java.obj");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.Function, external.sdk.pendo.io.mozilla.javascript.Callable
    public Object call(Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        return construct(context, scriptable, objArr);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0018  */
    @Override // external.sdk.pendo.io.mozilla.javascript.Function
    public Scriptable construct(Context context, Scriptable scriptable, Object[] objArr) {
        ClassLoader classLoader;
        if (objArr.length != 0) {
            Object objUnwrap = objArr[0];
            if (objUnwrap instanceof Wrapper) {
                objUnwrap = ((Wrapper) objUnwrap).unwrap();
            }
            if (objUnwrap instanceof ClassLoader) {
                classLoader = (ClassLoader) objUnwrap;
            } else {
                classLoader = null;
            }
        } else {
            classLoader = null;
        }
        if (classLoader == null) {
            Context.reportRuntimeError0("msg.not.classloader");
            return null;
        }
        NativeJavaPackage nativeJavaPackage = new NativeJavaPackage(true, "", classLoader);
        ScriptRuntime.setObjectProtoAndParent(nativeJavaPackage, scriptable);
        return nativeJavaPackage;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 1) {
            return js_getClass(context, scriptable, objArr);
        }
        throw idFunctionObject.unknown();
    }
}
