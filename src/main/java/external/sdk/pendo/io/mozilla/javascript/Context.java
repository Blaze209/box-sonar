package external.sdk.pendo.io.mozilla.javascript;

import external.sdk.pendo.io.mozilla.javascript.ast.AstRoot;
import external.sdk.pendo.io.mozilla.javascript.ast.ScriptNode;
import external.sdk.pendo.io.mozilla.javascript.debug.DebuggableScript;
import external.sdk.pendo.io.mozilla.javascript.debug.Debugger;
import external.sdk.pendo.io.mozilla.javascript.xml.XMLLib;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import sdk.pendo.io.d2.c;

/* JADX INFO: loaded from: classes4.dex */
public class Context {
    public static final int FEATURE_DYNAMIC_SCOPE = 7;
    public static final int FEATURE_E4X = 6;
    public static final int FEATURE_ENABLE_XML_SECURE_PARSING = 20;
    public static final int FEATURE_ENHANCED_JAVA_ACCESS = 13;
    public static final int FEATURE_ENUMERATE_IDS_FIRST = 16;
    public static final int FEATURE_INTEGER_WITHOUT_DECIMAL_PLACE = 18;
    public static final int FEATURE_LITTLE_ENDIAN = 19;
    public static final int FEATURE_LOCATION_INFORMATION_IN_ERROR = 10;
    public static final int FEATURE_MEMBER_EXPR_AS_FUNCTION_NAME = 2;
    public static final int FEATURE_NON_ECMA_GET_YEAR = 1;
    public static final int FEATURE_OLD_UNDEF_NULL_THIS = 15;
    public static final int FEATURE_PARENT_PROTO_PROPERTIES = 5;

    @Deprecated
    public static final int FEATURE_PARENT_PROTO_PROPRTIES = 5;
    public static final int FEATURE_RESERVED_KEYWORD_AS_IDENTIFIER = 3;
    public static final int FEATURE_STRICT_EVAL = 9;
    public static final int FEATURE_STRICT_MODE = 11;
    public static final int FEATURE_STRICT_VARS = 8;
    public static final int FEATURE_THREAD_SAFE_OBJECTS = 17;
    public static final int FEATURE_TO_STRING_AS_SOURCE = 4;
    public static final int FEATURE_V8_EXTENSIONS = 14;
    public static final int FEATURE_WARNING_AS_ERROR = 12;
    public static final int VERSION_1_0 = 100;
    public static final int VERSION_1_1 = 110;
    public static final int VERSION_1_2 = 120;
    public static final int VERSION_1_3 = 130;
    public static final int VERSION_1_4 = 140;
    public static final int VERSION_1_5 = 150;
    public static final int VERSION_1_6 = 160;
    public static final int VERSION_1_7 = 170;
    public static final int VERSION_1_8 = 180;
    public static final int VERSION_DEFAULT = 0;
    public static final int VERSION_ES6 = 200;
    public static final int VERSION_UNKNOWN = -1;
    public static final String errorReporterProperty = "error reporter";
    public static final String languageVersionProperty = "language version";
    Set<String> activationNames;
    private ClassLoader applicationClassLoader;
    XMLLib cachedXMLLib;
    private ClassShutter classShutter;
    NativeCall currentActivationCall;
    Debugger debugger;
    private Object debuggerData;
    private int enterCount;
    private ErrorReporter errorReporter;
    private final ContextFactory factory;
    public boolean generateObserverCount;
    private boolean generatingDebug;
    private boolean generatingDebugChanged;
    private boolean generatingSource;
    private boolean hasClassShutter;
    int instructionCount;
    int instructionThreshold;
    Object interpreterSecurityDomain;
    boolean isContinuationsTopCall;
    boolean isTopLevelStrict;
    ObjToIntMap iterating;
    Object lastInterpreterFrame;
    private Locale locale;
    private int maximumInterpreterStackDepth;
    private int optimizationLevel;
    ObjArray previousInterpreterInvocations;
    private Object propertyListeners;
    RegExpProxy regExpProxy;
    Scriptable scratchScriptable;
    long scratchUint32;
    private Object sealKey;
    private boolean sealed;
    private SecurityController securityController;
    private Map<Object, Object> threadLocalMap;
    Scriptable topCallScope;
    BaseFunction typeErrorThrower;
    boolean useDynamicScope;
    int version;
    private WrapFactory wrapFactory;
    public static final Object[] emptyArgs = ScriptRuntime.emptyArgs;
    private static Class<?> codegenClass = Kit.classOrNull("external.sdk.pendo.io.mozilla.javascript.optimizer.Codegen");
    private static Class<?> interpreterClass = Kit.classOrNull("external.sdk.pendo.io.mozilla.javascript.Interpreter");

    public interface ClassShutterSetter {
        ClassShutter getClassShutter();

        void setClassShutter(ClassShutter classShutter);
    }

    @Deprecated
    public Context() {
        this(ContextFactory.getGlobal());
    }

    @Deprecated
    public static void addContextListener(ContextListener contextListener) {
        if (!"external.sdk.pendo.io.mozilla.javascript.tools.debugger.Main".equals(contextListener.getClass().getName())) {
            ContextFactory.getGlobal().addListener(contextListener);
            return;
        }
        try {
            contextListener.getClass().getMethod("attachTo", Kit.classOrNull("external.sdk.pendo.io.mozilla.javascript.ContextFactory")).invoke(contextListener, ContextFactory.getGlobal());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public static <T> T call(ContextAction<T> contextAction) {
        return (T) call(ContextFactory.getGlobal(), contextAction);
    }

    public static void checkLanguageVersion(int i) {
        if (!isValidLanguageVersion(i)) {
            throw new IllegalArgumentException("Bad language version: " + i);
        }
    }

    public static void checkOptimizationLevel(int i) {
        if (!isValidOptimizationLevel(i)) {
            throw new IllegalArgumentException("Optimization level outside [-1..9]: " + i);
        }
    }

    private Object compileImpl(Scriptable scriptable, String str, String str2, int i, Object obj, boolean z, Evaluator evaluator, ErrorReporter errorReporter) {
        Object objCompile;
        if (str2 == null) {
            str2 = "unnamed script";
        }
        String str3 = str2;
        if (obj != null && getSecurityController() == null) {
            throw new IllegalArgumentException("securityDomain should be null if setSecurityController() was never called");
        }
        if (!((scriptable == null) ^ z)) {
            Kit.codeBug();
        }
        CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
        compilerEnvirons.initFromContext(this);
        if (errorReporter == null) {
            errorReporter = compilerEnvirons.getErrorReporter();
        }
        ErrorReporter errorReporter2 = errorReporter;
        ScriptNode scriptNode = parse(str, str3, i, compilerEnvirons, errorReporter2, z);
        if (evaluator == null) {
            try {
                evaluator = createCompiler();
            } catch (c.b unused) {
                ScriptNode scriptNode2 = parse(str, str3, i, compilerEnvirons, errorReporter2, z);
                evaluator = createInterpreter();
                objCompile = evaluator.compile(compilerEnvirons, scriptNode2, scriptNode2.getEncodedSource(), z);
            }
        }
        objCompile = evaluator.compile(compilerEnvirons, scriptNode, scriptNode.getEncodedSource(), z);
        if (this.debugger != null) {
            if (str == null) {
                Kit.codeBug();
            }
            if (!(objCompile instanceof DebuggableScript)) {
                throw new RuntimeException("NOT SUPPORTED");
            }
            notifyDebugger_r(this, (DebuggableScript) objCompile, str);
        }
        return z ? evaluator.createFunctionObject(this, scriptable, objCompile, obj) : evaluator.createScriptObject(objCompile, obj);
    }

    private Evaluator createCompiler() {
        Class<?> cls;
        Evaluator evaluator = (this.optimizationLevel < 0 || (cls = codegenClass) == null) ? null : (Evaluator) Kit.newInstanceOrNull(cls);
        return evaluator == null ? createInterpreter() : evaluator;
    }

    static Evaluator createInterpreter() {
        return (Evaluator) Kit.newInstanceOrNull(interpreterClass);
    }

    public static Context enter() {
        return enter(null, ContextFactory.getGlobal());
    }

    public static void exit() {
        VMBridge vMBridge = VMBridge.instance;
        Object threadContextHelper = vMBridge.getThreadContextHelper();
        Context context = vMBridge.getContext(threadContextHelper);
        if (context == null) {
            throw new IllegalStateException("Calling Context.exit without previous Context.enter");
        }
        if (context.enterCount < 1) {
            Kit.codeBug();
        }
        int i = context.enterCount - 1;
        context.enterCount = i;
        if (i == 0) {
            vMBridge.setContext(threadContextHelper, null);
            context.factory.onContextReleased(context);
        }
    }

    private void firePropertyChangeImpl(Object obj, String str, Object obj2, Object obj3) {
        int i = 0;
        while (true) {
            Object listener = Kit.getListener(obj, i);
            if (listener == null) {
                return;
            }
            if (listener instanceof PropertyChangeListener) {
                ((PropertyChangeListener) listener).propertyChange(new PropertyChangeEvent(this, str, obj2, obj3));
            }
            i++;
        }
    }

    static Context getContext() {
        Context currentContext = getCurrentContext();
        if (currentContext != null) {
            return currentContext;
        }
        throw new RuntimeException("No Context associated with current Thread");
    }

    public static Context getCurrentContext() {
        VMBridge vMBridge = VMBridge.instance;
        return vMBridge.getContext(vMBridge.getThreadContextHelper());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static DebuggableScript getDebuggableView(Script script) {
        if (script instanceof NativeFunction) {
            return ((NativeFunction) script).getDebuggableView();
        }
        return null;
    }

    static String getSourcePositionFromStack(int[] iArr) {
        int lineNumber;
        Evaluator evaluatorCreateInterpreter;
        Context currentContext = getCurrentContext();
        if (currentContext == null) {
            return null;
        }
        if (currentContext.lastInterpreterFrame != null && (evaluatorCreateInterpreter = createInterpreter()) != null) {
            return evaluatorCreateInterpreter.getSourcePositionFromStack(currentContext, iArr);
        }
        for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
            String fileName = stackTraceElement.getFileName();
            if (fileName != null && !fileName.endsWith(".java") && (lineNumber = stackTraceElement.getLineNumber()) >= 0) {
                iArr[0] = lineNumber;
                return fileName;
            }
        }
        return null;
    }

    public static Object getUndefinedValue() {
        return Undefined.instance;
    }

    public static boolean isValidLanguageVersion(int i) {
        switch (i) {
            case 0:
            case 100:
            case 110:
            case 120:
            case 130:
            case 140:
            case 150:
            case 160:
            case VERSION_1_7 /* 170 */:
            case 180:
            case 200:
                return true;
            default:
                return false;
        }
    }

    public static boolean isValidOptimizationLevel(int i) {
        return -1 <= i && i <= 9;
    }

    public static Object javaToJS(Object obj, Scriptable scriptable) {
        if ((obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof Scriptable)) {
            return obj;
        }
        if (obj instanceof Character) {
            return String.valueOf(((Character) obj).charValue());
        }
        Context context = getContext();
        return context.getWrapFactory().wrap(context, scriptable, obj, null);
    }

    public static Object jsToJava(Object obj, Class<?> cls) {
        return NativeJavaObject.coerceTypeImpl(cls, obj);
    }

    private static void notifyDebugger_r(Context context, DebuggableScript debuggableScript, String str) {
        context.debugger.handleCompilationDone(context, debuggableScript, str);
        for (int i = 0; i != debuggableScript.getFunctionCount(); i++) {
            notifyDebugger_r(context, debuggableScript.getFunction(i), str);
        }
    }

    static void onSealedMutation() {
        throw new IllegalStateException();
    }

    private ScriptNode parse(String str, String str2, int i, CompilerEnvirons compilerEnvirons, ErrorReporter errorReporter, boolean z) {
        Parser parser = new Parser(compilerEnvirons, errorReporter);
        if (z) {
            parser.calledByCompileFunction = true;
        }
        if (isStrictMode()) {
            parser.setDefaultUseStrictDirective(true);
        }
        AstRoot astRoot = parser.parse(str, str2, i);
        if (!z || (astRoot.getFirstChild() != null && astRoot.getFirstChild().getType() == 110)) {
            return new IRFactory(compilerEnvirons, errorReporter).transformTree(astRoot);
        }
        throw new IllegalArgumentException("compileFunction only accepts source with single JS function: " + str);
    }

    @Deprecated
    public static void removeContextListener(ContextListener contextListener) {
        ContextFactory.getGlobal().addListener(contextListener);
    }

    public static void reportError(String str) {
        int[] iArr = {0};
        reportError(str, getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    public static EvaluatorException reportRuntimeError(String str) {
        int[] iArr = {0};
        return reportRuntimeError(str, getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    static EvaluatorException reportRuntimeError0(String str) {
        return reportRuntimeError(ScriptRuntime.getMessage0(str));
    }

    static EvaluatorException reportRuntimeError1(String str, Object obj) {
        return reportRuntimeError(ScriptRuntime.getMessage1(str, obj));
    }

    static EvaluatorException reportRuntimeError2(String str, Object obj, Object obj2) {
        return reportRuntimeError(ScriptRuntime.getMessage2(str, obj, obj2));
    }

    static EvaluatorException reportRuntimeError3(String str, Object obj, Object obj2, Object obj3) {
        return reportRuntimeError(ScriptRuntime.getMessage3(str, obj, obj2, obj3));
    }

    static EvaluatorException reportRuntimeError4(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        return reportRuntimeError(ScriptRuntime.getMessage4(str, obj, obj2, obj3, obj4));
    }

    public static void reportWarning(String str) {
        int[] iArr = {0};
        reportWarning(str, getSourcePositionFromStack(iArr), iArr[0], null, 0);
    }

    @Deprecated
    public static void setCachingEnabled(boolean z) {
    }

    public static RuntimeException throwAsScriptRuntimeEx(Throwable th) {
        Context context;
        while (th instanceof InvocationTargetException) {
            th = ((InvocationTargetException) th).getTargetException();
        }
        if ((th instanceof Error) && ((context = getContext()) == null || !context.hasFeature(13))) {
            throw ((Error) th);
        }
        if (th instanceof RhinoException) {
            throw ((RhinoException) th);
        }
        throw new WrappedException(th);
    }

    public static boolean toBoolean(Object obj) {
        return ScriptRuntime.toBoolean(obj);
    }

    public static double toNumber(Object obj) {
        return ScriptRuntime.toNumber(obj);
    }

    public static Scriptable toObject(Object obj, Scriptable scriptable) {
        return ScriptRuntime.toObject(scriptable, obj);
    }

    public static String toString(Object obj) {
        return ScriptRuntime.toString(obj);
    }

    @Deprecated
    public static Object toType(Object obj, Class<?> cls) {
        try {
            return jsToJava(obj, cls);
        } catch (EvaluatorException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }

    public void addActivationName(String str) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.activationNames == null) {
            this.activationNames = new HashSet();
        }
        this.activationNames.add(str);
    }

    public final void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.propertyListeners = Kit.addListener(this.propertyListeners, propertyChangeListener);
    }

    public Object callFunctionWithContinuations(Callable callable, Scriptable scriptable, Object[] objArr) {
        if (!(callable instanceof InterpretedFunction)) {
            throw new IllegalArgumentException("Function argument was not created by interpreted mode ");
        }
        if (ScriptRuntime.hasTopCall(this)) {
            throw new IllegalStateException("Cannot have any pending top calls when executing a script with continuations");
        }
        this.isContinuationsTopCall = true;
        return ScriptRuntime.doTopCall(callable, this, scriptable, scriptable, objArr, this.isTopLevelStrict);
    }

    public ContinuationPending captureContinuation() {
        return new ContinuationPending(Interpreter.captureContinuation(this));
    }

    final Function compileFunction(Scriptable scriptable, String str, Evaluator evaluator, ErrorReporter errorReporter, String str2, int i, Object obj) {
        try {
            return (Function) compileImpl(scriptable, str, str2, i, obj, true, evaluator, errorReporter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Deprecated
    public final Script compileReader(Scriptable scriptable, Reader reader, String str, int i, Object obj) {
        return compileReader(reader, str, i, obj);
    }

    final Script compileString(String str, Evaluator evaluator, ErrorReporter errorReporter, String str2, int i, Object obj) {
        try {
            return (Script) compileImpl(null, str, str2, i, obj, false, evaluator, errorReporter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public GeneratedClassLoader createClassLoader(ClassLoader classLoader) {
        return getFactory().createClassLoader(classLoader);
    }

    public final String decompileFunction(Function function, int i) {
        return function instanceof BaseFunction ? ((BaseFunction) function).decompile(i, 0) : "function " + function.getClassName() + "() {\n\t[native code]\n}\n";
    }

    public final String decompileFunctionBody(Function function, int i) {
        return function instanceof BaseFunction ? ((BaseFunction) function).decompile(i, 1) : "[native code]\n";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String decompileScript(Script script, int i) {
        return ((NativeFunction) script).decompile(i, 0);
    }

    public final Object evaluateReader(Scriptable scriptable, Reader reader, String str, int i, Object obj) {
        Script scriptCompileReader = compileReader(scriptable, reader, str, i, obj);
        if (scriptCompileReader != null) {
            return scriptCompileReader.exec(this, scriptable);
        }
        return null;
    }

    public final Object evaluateString(Scriptable scriptable, String str, String str2, int i, Object obj) {
        Script scriptCompileString = compileString(str, str2, i, obj);
        if (scriptCompileString != null) {
            return scriptCompileString.exec(this, scriptable);
        }
        return null;
    }

    public Object executeScriptWithContinuations(Script script, Scriptable scriptable) {
        if (script instanceof InterpretedFunction) {
            InterpretedFunction interpretedFunction = (InterpretedFunction) script;
            if (interpretedFunction.isScript()) {
                return callFunctionWithContinuations(interpretedFunction, scriptable, ScriptRuntime.emptyArgs);
            }
        }
        throw new IllegalArgumentException("Script argument was not a script or was not created by interpreted mode ");
    }

    final void firePropertyChange(String str, Object obj, Object obj2) {
        Object obj3 = this.propertyListeners;
        if (obj3 != null) {
            firePropertyChangeImpl(obj3, str, obj, obj2);
        }
    }

    public final ClassLoader getApplicationClassLoader() {
        if (this.applicationClassLoader == null) {
            ContextFactory factory = getFactory();
            ClassLoader applicationClassLoader = factory.getApplicationClassLoader();
            if (applicationClassLoader == null) {
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                if (contextClassLoader != null && Kit.testIfCanLoadRhinoClasses(contextClassLoader)) {
                    return contextClassLoader;
                }
                Class<?> cls = factory.getClass();
                if (cls == ScriptRuntime.ContextFactoryClass) {
                    cls = getClass();
                }
                applicationClassLoader = cls.getClassLoader();
            }
            this.applicationClassLoader = applicationClassLoader;
        }
        return this.applicationClassLoader;
    }

    final synchronized ClassShutter getClassShutter() {
        return this.classShutter;
    }

    public final synchronized ClassShutterSetter getClassShutterSetter() {
        if (this.hasClassShutter) {
            return null;
        }
        this.hasClassShutter = true;
        return new ClassShutterSetter() { // from class: external.sdk.pendo.io.mozilla.javascript.Context.1
            @Override // external.sdk.pendo.io.mozilla.javascript.Context.ClassShutterSetter
            public ClassShutter getClassShutter() {
                return Context.this.classShutter;
            }

            @Override // external.sdk.pendo.io.mozilla.javascript.Context.ClassShutterSetter
            public void setClassShutter(ClassShutter classShutter) {
                Context.this.classShutter = classShutter;
            }
        };
    }

    public final Debugger getDebugger() {
        return this.debugger;
    }

    public final Object getDebuggerContextData() {
        return this.debuggerData;
    }

    public XMLLib.Factory getE4xImplementationFactory() {
        return getFactory().getE4xImplementationFactory();
    }

    public final Object[] getElements(Scriptable scriptable) {
        return ScriptRuntime.getArrayElements(scriptable);
    }

    public final ErrorReporter getErrorReporter() {
        ErrorReporter errorReporter = this.errorReporter;
        return errorReporter == null ? DefaultErrorReporter.instance : errorReporter;
    }

    public final ContextFactory getFactory() {
        return this.factory;
    }

    public final String getImplementationVersion() {
        return ImplementationVersion.get();
    }

    public final int getInstructionObserverThreshold() {
        return this.instructionThreshold;
    }

    public final int getLanguageVersion() {
        return this.version;
    }

    public final Locale getLocale() {
        if (this.locale == null) {
            this.locale = Locale.getDefault();
        }
        return this.locale;
    }

    public final int getMaximumInterpreterStackDepth() {
        return this.maximumInterpreterStackDepth;
    }

    public final int getOptimizationLevel() {
        return this.optimizationLevel;
    }

    RegExpProxy getRegExpProxy() {
        Class<?> clsClassOrNull;
        if (this.regExpProxy == null && (clsClassOrNull = Kit.classOrNull("external.sdk.pendo.io.mozilla.javascript.regexp.RegExpImpl")) != null) {
            this.regExpProxy = (RegExpProxy) Kit.newInstanceOrNull(clsClassOrNull);
        }
        return this.regExpProxy;
    }

    SecurityController getSecurityController() {
        SecurityController securityControllerGlobal = SecurityController.global();
        return securityControllerGlobal != null ? securityControllerGlobal : this.securityController;
    }

    public final Object getThreadLocal(Object obj) {
        Map<Object, Object> map = this.threadLocalMap;
        if (map == null) {
            return null;
        }
        return map.get(obj);
    }

    public final WrapFactory getWrapFactory() {
        if (this.wrapFactory == null) {
            this.wrapFactory = new WrapFactory();
        }
        return this.wrapFactory;
    }

    public boolean hasFeature(int i) {
        return getFactory().hasFeature(this, i);
    }

    public final Scriptable initSafeStandardObjects(ScriptableObject scriptableObject) {
        return initSafeStandardObjects(scriptableObject, false);
    }

    public final Scriptable initStandardObjects(ScriptableObject scriptableObject) {
        return initStandardObjects(scriptableObject, false);
    }

    public final boolean isActivationNeeded(String str) {
        Set<String> set = this.activationNames;
        return set != null && set.contains(str);
    }

    public final boolean isGeneratingDebug() {
        return this.generatingDebug;
    }

    public final boolean isGeneratingDebugChanged() {
        return this.generatingDebugChanged;
    }

    public final boolean isGeneratingSource() {
        return this.generatingSource;
    }

    public final boolean isSealed() {
        return this.sealed;
    }

    public final boolean isStrictMode() {
        if (this.isTopLevelStrict) {
            return true;
        }
        NativeCall nativeCall = this.currentActivationCall;
        return nativeCall != null && nativeCall.isStrict;
    }

    final boolean isVersionECMA1() {
        int i = this.version;
        return i == 0 || i >= 130;
    }

    public Scriptable newArray(Scriptable scriptable, int i) {
        NativeArray nativeArray = new NativeArray(i);
        ScriptRuntime.setBuiltinProtoAndParent(nativeArray, scriptable, TopLevel.Builtins.Array);
        return nativeArray;
    }

    public Scriptable newObject(Scriptable scriptable) {
        NativeObject nativeObject = new NativeObject();
        ScriptRuntime.setBuiltinProtoAndParent(nativeObject, scriptable, TopLevel.Builtins.Object);
        return nativeObject;
    }

    protected void observeInstructionCount(int i) {
        getFactory().observeInstructionCount(this, i);
    }

    public final synchronized void putThreadLocal(Object obj, Object obj2) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.threadLocalMap == null) {
            this.threadLocalMap = new HashMap();
        }
        this.threadLocalMap.put(obj, obj2);
    }

    public void removeActivationName(String str) {
        if (this.sealed) {
            onSealedMutation();
        }
        Set<String> set = this.activationNames;
        if (set != null) {
            set.remove(str);
        }
    }

    public final void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.propertyListeners = Kit.removeListener(this.propertyListeners, propertyChangeListener);
    }

    public final void removeThreadLocal(Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        Map<Object, Object> map = this.threadLocalMap;
        if (map == null) {
            return;
        }
        map.remove(obj);
    }

    public Object resumeContinuation(Object obj, Scriptable scriptable, Object obj2) {
        return Interpreter.restartContinuation((NativeContinuation) obj, this, scriptable, new Object[]{obj2});
    }

    public final void seal(Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.sealed = true;
        this.sealKey = obj;
    }

    public final void setApplicationClassLoader(ClassLoader classLoader) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (classLoader == null) {
            this.applicationClassLoader = null;
        } else {
            if (!Kit.testIfCanLoadRhinoClasses(classLoader)) {
                throw new IllegalArgumentException("Loader can not resolve Rhino classes");
            }
            this.applicationClassLoader = classLoader;
        }
    }

    public final synchronized void setClassShutter(ClassShutter classShutter) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (classShutter == null) {
            throw new IllegalArgumentException();
        }
        if (this.hasClassShutter) {
            throw new SecurityException("Cannot overwrite existing ClassShutter object");
        }
        this.classShutter = classShutter;
        this.hasClassShutter = true;
    }

    public final void setDebugger(Debugger debugger, Object obj) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.debugger = debugger;
        this.debuggerData = obj;
    }

    public final ErrorReporter setErrorReporter(ErrorReporter errorReporter) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (errorReporter == null) {
            throw new IllegalArgumentException();
        }
        ErrorReporter errorReporter2 = getErrorReporter();
        if (errorReporter == errorReporter2) {
            return errorReporter2;
        }
        Object obj = this.propertyListeners;
        if (obj != null) {
            firePropertyChangeImpl(obj, errorReporterProperty, errorReporter2, errorReporter);
        }
        this.errorReporter = errorReporter;
        return errorReporter2;
    }

    public void setGenerateObserverCount(boolean z) {
        this.generateObserverCount = z;
    }

    public final void setGeneratingDebug(boolean z) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.generatingDebugChanged = true;
        if (z && getOptimizationLevel() > 0) {
            setOptimizationLevel(0);
        }
        this.generatingDebug = z;
    }

    public final void setGeneratingSource(boolean z) {
        if (this.sealed) {
            onSealedMutation();
        }
        this.generatingSource = z;
    }

    public final void setInstructionObserverThreshold(int i) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        this.instructionThreshold = i;
        setGenerateObserverCount(i > 0);
    }

    public void setLanguageVersion(int i) {
        int i2;
        if (this.sealed) {
            onSealedMutation();
        }
        checkLanguageVersion(i);
        Object obj = this.propertyListeners;
        if (obj != null && i != (i2 = this.version)) {
            firePropertyChangeImpl(obj, languageVersionProperty, Integer.valueOf(i2), Integer.valueOf(i));
        }
        this.version = i;
    }

    public final Locale setLocale(Locale locale) {
        if (this.sealed) {
            onSealedMutation();
        }
        Locale locale2 = this.locale;
        this.locale = locale;
        return locale2;
    }

    public final void setMaximumInterpreterStackDepth(int i) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (this.optimizationLevel != -1) {
            throw new IllegalStateException("Cannot set maximumInterpreterStackDepth when optimizationLevel != -1");
        }
        if (i < 1) {
            throw new IllegalArgumentException("Cannot set maximumInterpreterStackDepth to less than 1");
        }
        this.maximumInterpreterStackDepth = i;
    }

    public final void setOptimizationLevel(int i) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (i == -2) {
            i = -1;
        }
        checkOptimizationLevel(i);
        this.optimizationLevel = codegenClass != null ? i : -1;
    }

    public final void setSecurityController(SecurityController securityController) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (securityController == null) {
            throw new IllegalArgumentException();
        }
        if (this.securityController != null) {
            throw new SecurityException("Can not overwrite existing SecurityController object");
        }
        if (SecurityController.hasGlobal()) {
            throw new SecurityException("Can not overwrite existing global SecurityController object");
        }
        this.securityController = securityController;
    }

    public final void setWrapFactory(WrapFactory wrapFactory) {
        if (this.sealed) {
            onSealedMutation();
        }
        if (wrapFactory == null) {
            throw new IllegalArgumentException();
        }
        this.wrapFactory = wrapFactory;
    }

    public final boolean stringIsCompilableUnit(String str) {
        CompilerEnvirons compilerEnvirons = new CompilerEnvirons();
        compilerEnvirons.initFromContext(this);
        compilerEnvirons.setGeneratingSource(false);
        Parser parser = new Parser(compilerEnvirons, DefaultErrorReporter.instance);
        try {
            parser.parse(str, (String) null, 1);
        } catch (EvaluatorException unused) {
            if (parser.eof()) {
                return false;
            }
        }
        return true;
    }

    public final void unseal(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        if (this.sealKey != obj) {
            throw new IllegalArgumentException();
        }
        if (!this.sealed) {
            throw new IllegalStateException();
        }
        this.sealed = false;
        this.sealKey = null;
    }

    protected Context(ContextFactory contextFactory) {
        this.generatingSource = true;
        this.generateObserverCount = false;
        if (contextFactory == null) {
            throw new IllegalArgumentException("factory == null");
        }
        this.factory = contextFactory;
        this.version = 0;
        this.optimizationLevel = codegenClass == null ? -1 : 0;
        this.maximumInterpreterStackDepth = Integer.MAX_VALUE;
    }

    public static Object call(ContextFactory contextFactory, final Callable callable, final Scriptable scriptable, final Scriptable scriptable2, final Object[] objArr) {
        if (contextFactory == null) {
            contextFactory = ContextFactory.getGlobal();
        }
        return call(contextFactory, new ContextAction() { // from class: external.sdk.pendo.io.mozilla.javascript.Context$$ExternalSyntheticLambda0
            @Override // external.sdk.pendo.io.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return callable.call(context, scriptable, scriptable2, objArr);
            }
        });
    }

    @Deprecated
    public static Context enter(Context context) {
        return enter(context, ContextFactory.getGlobal());
    }

    public static void reportError(String str, String str2, int i, String str3, int i2) {
        Context currentContext = getCurrentContext();
        if (currentContext == null) {
            throw new EvaluatorException(str, str2, i, str3, i2);
        }
        currentContext.getErrorReporter().error(str, str2, i, str3, i2);
    }

    public static EvaluatorException reportRuntimeError(String str, String str2, int i, String str3, int i2) {
        Context currentContext = getCurrentContext();
        if (currentContext != null) {
            return currentContext.getErrorReporter().runtimeError(str, str2, i, str3, i2);
        }
        throw new EvaluatorException(str, str2, i, str3, i2);
    }

    public static void reportWarning(String str, String str2, int i, String str3, int i2) {
        Context context = getContext();
        if (context.hasFeature(12)) {
            reportError(str, str2, i, str3, i2);
        } else {
            context.getErrorReporter().warning(str, str2, i, str3, i2);
        }
    }

    @Deprecated
    public static Scriptable toObject(Object obj, Scriptable scriptable, Class<?> cls) {
        return ScriptRuntime.toObject(scriptable, obj);
    }

    public final Function compileFunction(Scriptable scriptable, String str, String str2, int i, Object obj) {
        return compileFunction(scriptable, str, null, null, str2, i, obj);
    }

    public final Script compileReader(Reader reader, String str, int i, Object obj) throws IOException {
        if (i < 0) {
            i = 0;
        }
        return (Script) compileImpl(null, Kit.readReader(reader), str, i, obj, false, null, null);
    }

    public final Script compileString(String str, String str2, int i, Object obj) {
        if (i < 0) {
            i = 0;
        }
        return compileString(str, null, null, str2, i, obj);
    }

    public final ScriptableObject initSafeStandardObjects() {
        return initSafeStandardObjects(null, false);
    }

    public final ScriptableObject initStandardObjects() {
        return initStandardObjects(null, false);
    }

    public Scriptable newArray(Scriptable scriptable, Object[] objArr) {
        if (objArr.getClass().getComponentType() != ScriptRuntime.ObjectClass) {
            throw new IllegalArgumentException();
        }
        NativeArray nativeArray = new NativeArray(objArr);
        ScriptRuntime.setBuiltinProtoAndParent(nativeArray, scriptable, TopLevel.Builtins.Array);
        return nativeArray;
    }

    public Scriptable newObject(Scriptable scriptable, String str) {
        return newObject(scriptable, str, ScriptRuntime.emptyArgs);
    }

    static <T> T call(ContextFactory contextFactory, ContextAction<T> contextAction) {
        try {
            return contextAction.run(enter(null, contextFactory));
        } finally {
            exit();
        }
    }

    static final Context enter(Context context, ContextFactory contextFactory) {
        VMBridge vMBridge = VMBridge.instance;
        Object threadContextHelper = vMBridge.getThreadContextHelper();
        Context context2 = vMBridge.getContext(threadContextHelper);
        if (context2 == null) {
            if (context == null) {
                context = contextFactory.makeContext();
                if (context.enterCount != 0) {
                    throw new IllegalStateException("factory.makeContext() returned Context instance already associated with some thread");
                }
                contextFactory.onContextCreated(context);
                if (contextFactory.isSealed() && !context.isSealed()) {
                    context.seal(null);
                }
            } else if (context.enterCount != 0) {
                throw new IllegalStateException("can not use Context instance already associated with some thread");
            }
            vMBridge.setContext(threadContextHelper, context);
            context2 = context;
        }
        context2.enterCount++;
        return context2;
    }

    public static void reportWarning(String str, Throwable th) {
        int[] iArr = {0};
        String sourcePositionFromStack = getSourcePositionFromStack(iArr);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println(str);
        th.printStackTrace(printWriter);
        printWriter.flush();
        reportWarning(stringWriter.toString(), sourcePositionFromStack, iArr[0], null, 0);
    }

    public ScriptableObject initSafeStandardObjects(ScriptableObject scriptableObject, boolean z) {
        return ScriptRuntime.initSafeStandardObjects(this, scriptableObject, z);
    }

    public ScriptableObject initStandardObjects(ScriptableObject scriptableObject, boolean z) {
        return ScriptRuntime.initStandardObjects(this, scriptableObject, z);
    }

    public Scriptable newObject(Scriptable scriptable, String str, Object[] objArr) {
        return ScriptRuntime.newObject(this, scriptable, str, objArr);
    }
}
