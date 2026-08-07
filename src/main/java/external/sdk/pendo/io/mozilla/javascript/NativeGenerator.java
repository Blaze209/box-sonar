package external.sdk.pendo.io.mozilla.javascript;

import org.apache.hc.core5.http.HeaderElements;

/* JADX INFO: loaded from: classes4.dex */
public final class NativeGenerator extends IdScriptableObject {
    public static final int GENERATOR_CLOSE = 2;
    public static final int GENERATOR_SEND = 0;
    private static final Object GENERATOR_TAG = "Generator";
    public static final int GENERATOR_THROW = 1;
    private static final int Id___iterator__ = 5;
    private static final int Id_close = 1;
    private static final int Id_next = 2;
    private static final int Id_send = 3;
    private static final int Id_throw = 4;
    private static final int MAX_PROTOTYPE_ID = 5;
    private static final long serialVersionUID = 1645892441041347273L;
    private boolean firstTime = true;
    private NativeFunction function;
    private int lineNumber;
    private String lineSource;
    private boolean locked;
    private Object savedState;

    public static class GeneratorClosedException extends RuntimeException {
        private static final long serialVersionUID = 2561315658662379681L;
    }

    private NativeGenerator() {
    }

    static NativeGenerator init(ScriptableObject scriptableObject, boolean z) {
        NativeGenerator nativeGenerator = new NativeGenerator();
        if (scriptableObject != null) {
            nativeGenerator.setParentScope(scriptableObject);
            nativeGenerator.setPrototype(ScriptableObject.getObjectPrototype(scriptableObject));
        }
        nativeGenerator.activatePrototypeMap(5);
        if (z) {
            nativeGenerator.sealObject();
        }
        if (scriptableObject != null) {
            scriptableObject.associateValue(GENERATOR_TAG, nativeGenerator);
        }
        return nativeGenerator;
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0072  */
    /* JADX WARN: Code duplicated, block: B:69:0x007f  */
    /* JADX WARN: Code duplicated, block: B:76:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x006d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:? A[SYNTHETIC] */
    private Object resume(Context context, Scriptable scriptable, int i, Object obj) throws Throwable {
        Throwable th;
        if (this.savedState == null) {
            if (i == 2) {
                return Undefined.instance;
            }
            if (i != 1) {
                obj = NativeIterator.getStopIterationObject(scriptable);
            }
            throw new JavaScriptException(obj, this.lineSource, this.lineNumber);
        }
        try {
            try {
                try {
                    try {
                        synchronized (this) {
                            try {
                                if (this.locked) {
                                    throw ScriptRuntime.typeError0("msg.already.exec.gen");
                                }
                                this.locked = true;
                                Object objResumeGenerator = this.function.resumeGenerator(context, scriptable, i, this.savedState, obj);
                                synchronized (this) {
                                    this.locked = false;
                                }
                                if (i == 2) {
                                    this.savedState = null;
                                }
                                return objResumeGenerator;
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        th = th;
                        synchronized (this) {
                            this.locked = false;
                        }
                        if (i == 2) {
                            throw th;
                        }
                        this.savedState = null;
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (GeneratorClosedException unused) {
                Object obj2 = Undefined.instance;
                synchronized (this) {
                    this.locked = false;
                }
                if (i == 2) {
                    this.savedState = null;
                }
                return obj2;
            } catch (RhinoException e) {
                e = e;
                RhinoException rhinoException = e;
                this.lineNumber = rhinoException.lineNumber();
                this.lineSource = rhinoException.lineSource();
                this.savedState = null;
                throw rhinoException;
            } catch (Throwable th5) {
                th = th5;
                th = th;
                synchronized (this) {
                    this.locked = false;
                    if (i == 2) {
                        throw th;
                    }
                    this.savedState = null;
                    throw th;
                }
            }
        } catch (GeneratorClosedException unused2) {
            Object obj3 = Undefined.instance;
            synchronized (this) {
                this.locked = false;
                if (i == 2) {
                    this.savedState = null;
                }
                return obj3;
            }
        } catch (RhinoException e2) {
            e = e2;
            RhinoException rhinoException2 = e;
            this.lineNumber = rhinoException2.lineNumber();
            this.lineSource = rhinoException2.lineSource();
            this.savedState = null;
            throw rhinoException2;
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(GENERATOR_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (!(scriptable2 instanceof NativeGenerator)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        NativeGenerator nativeGenerator = (NativeGenerator) scriptable2;
        if (iMethodId == 1) {
            return nativeGenerator.resume(context, scriptable, 2, new GeneratorClosedException());
        }
        if (iMethodId == 2) {
            nativeGenerator.firstTime = false;
            return nativeGenerator.resume(context, scriptable, 0, Undefined.instance);
        }
        if (iMethodId != 3) {
            if (iMethodId == 4) {
                return nativeGenerator.resume(context, scriptable, 1, objArr.length > 0 ? objArr[0] : Undefined.instance);
            }
            if (iMethodId == 5) {
                return scriptable2;
            }
            throw new IllegalArgumentException(String.valueOf(iMethodId));
        }
        Object obj = objArr.length > 0 ? objArr[0] : Undefined.instance;
        if (!nativeGenerator.firstTime || obj.equals(Undefined.instance)) {
            return nativeGenerator.resume(context, scriptable, 0, obj);
        }
        throw ScriptRuntime.typeError0("msg.send.newborn");
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003d  */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 4;
        if (length == 4) {
            char cCharAt = str.charAt(0);
            if (cCharAt == 'n') {
                str2 = ES6Iterator.NEXT_METHOD;
                i = 2;
            } else if (cCharAt == 's') {
                str2 = "send";
                i = 3;
            } else {
                str2 = null;
                i = 0;
            }
        } else if (length == 5) {
            char cCharAt2 = str.charAt(0);
            if (cCharAt2 == 'c') {
                str2 = HeaderElements.CLOSE;
                i = 1;
            } else if (cCharAt2 == 't') {
                str2 = "throw";
            } else {
                str2 = null;
                i = 0;
            }
        } else if (length == 12) {
            str2 = NativeIterator.ITERATOR_PROPERTY_NAME;
            i = 5;
        } else {
            str2 = null;
            i = 0;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Generator";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2 = 1;
        if (i == 1) {
            str = HeaderElements.CLOSE;
        } else if (i != 2) {
            if (i == 3) {
                str = "send";
            } else if (i == 4) {
                str = "throw";
            } else {
                if (i != 5) {
                    throw new IllegalArgumentException(String.valueOf(i));
                }
                str = NativeIterator.ITERATOR_PROPERTY_NAME;
            }
            i2 = 0;
        } else {
            str = ES6Iterator.NEXT_METHOD;
        }
        initPrototypeMethod(GENERATOR_TAG, i, str, i2);
    }

    public NativeGenerator(Scriptable scriptable, NativeFunction nativeFunction, Object obj) {
        this.function = nativeFunction;
        this.savedState = obj;
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        setParentScope(topLevelScope);
        setPrototype((NativeGenerator) ScriptableObject.getTopScopeValue(topLevelScope, GENERATOR_TAG));
    }
}
