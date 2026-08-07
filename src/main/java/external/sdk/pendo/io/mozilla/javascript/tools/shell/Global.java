package external.sdk.pendo.io.mozilla.javascript.tools.shell;

import androidx.core.app.NotificationCompat;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ContextAction;
import external.sdk.pendo.io.mozilla.javascript.ContextFactory;
import external.sdk.pendo.io.mozilla.javascript.ErrorReporter;
import external.sdk.pendo.io.mozilla.javascript.Function;
import external.sdk.pendo.io.mozilla.javascript.ImporterTopLevel;
import external.sdk.pendo.io.mozilla.javascript.NativeArray;
import external.sdk.pendo.io.mozilla.javascript.RhinoException;
import external.sdk.pendo.io.mozilla.javascript.Script;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.ScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.Synchronizer;
import external.sdk.pendo.io.mozilla.javascript.Undefined;
import external.sdk.pendo.io.mozilla.javascript.Wrapper;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.Require;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.RequireBuilder;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider.SoftCachingModuleScriptProvider;
import external.sdk.pendo.io.mozilla.javascript.commonjs.module.provider.UrlModuleSourceProvider;
import external.sdk.pendo.io.mozilla.javascript.serialize.ScriptableInputStream;
import external.sdk.pendo.io.mozilla.javascript.serialize.ScriptableOutputStream;
import external.sdk.pendo.io.mozilla.javascript.tools.ToolErrorReporter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;

/* JADX INFO: loaded from: classes4.dex */
public class Global extends ImporterTopLevel {
    static final long serialVersionUID = 4029130780977538005L;
    boolean attemptedJLineLoad;
    private ShellConsole console;
    private HashMap<String, String> doctestCanonicalizations;
    private PrintStream errStream;
    NativeArray history;
    private InputStream inStream;
    boolean initialized;
    private PrintStream outStream;
    private QuitAction quitAction;
    private boolean sealedStdLib = false;
    private String[] prompts = {"js> ", "  > "};

    public Global() {
    }

    public static void defineClass(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IllegalAccessException, InvocationTargetException {
        Class<?> cls = getClass(objArr);
        if (!Scriptable.class.isAssignableFrom(cls)) {
            throw reportRuntimeError("msg.must.implement.Scriptable");
        }
        ScriptableObject.defineClass(scriptable, cls);
    }

    public static Object deserialize(Context context, Scriptable scriptable, Object[] objArr, Function function) throws ClassNotFoundException, IOException {
        if (objArr.length < 1) {
            throw Context.reportRuntimeError("Expected a filename to read the serialization from");
        }
        FileInputStream fileInputStream = new FileInputStream(Context.toString(objArr[0]));
        Scriptable topLevelScope = ScriptableObject.getTopLevelScope(scriptable);
        ScriptableInputStream scriptableInputStream = new ScriptableInputStream(fileInputStream, topLevelScope);
        Object object = scriptableInputStream.readObject();
        scriptableInputStream.close();
        return Context.toObject(object, topLevelScope);
    }

    private static Object doPrint(Object[] objArr, Function function, boolean z) {
        PrintStream out = getInstance(function).getOut();
        for (int i = 0; i < objArr.length; i++) {
            if (i > 0) {
                out.print(" ");
            }
            out.print(Context.toString(objArr[i]));
        }
        if (z) {
            out.println();
        }
        return Context.getUndefinedValue();
    }

    public static Object doctest(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length == 0) {
            return Boolean.FALSE;
        }
        String string = Context.toString(objArr[0]);
        Global global = getInstance(function);
        return Integer.valueOf(global.runDoctest(context, global, string, null, 0));
    }

    private boolean doctestOutputMatches(String str, String str2) {
        String strTrim = str.trim();
        String strReplace = str2.trim().replace(IOUtils.LINE_SEPARATOR_WINDOWS, "\n");
        if (strTrim.equals(strReplace)) {
            return true;
        }
        for (Map.Entry<String, String> entry : this.doctestCanonicalizations.entrySet()) {
            strTrim = strTrim.replace(entry.getKey(), entry.getValue());
        }
        if (strTrim.equals(strReplace)) {
            return true;
        }
        Pattern patternCompile = Pattern.compile("@[0-9a-fA-F]+");
        Matcher matcher = patternCompile.matcher(strTrim);
        Matcher matcher2 = patternCompile.matcher(strReplace);
        while (matcher.find() && matcher2.find() && matcher2.start() == matcher.start()) {
            int iStart = matcher.start();
            if (!strTrim.substring(0, iStart).equals(strReplace.substring(0, iStart))) {
                return false;
            }
            String strGroup = matcher.group();
            String strGroup2 = matcher2.group();
            String str3 = this.doctestCanonicalizations.get(strGroup);
            if (str3 == null) {
                this.doctestCanonicalizations.put(strGroup, strGroup2);
                strTrim = strTrim.replace(strGroup, strGroup2);
            } else if (!strGroup2.equals(str3)) {
                return false;
            }
            if (strTrim.equals(strReplace)) {
                return true;
            }
        }
        return false;
    }

    public static void gc(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        System.gc();
    }

    private static String getCharCodingFromType(String str) {
        int iIndexOf = str.indexOf(59);
        if (iIndexOf < 0) {
            return null;
        }
        int length = str.length();
        int i = iIndexOf + 1;
        while (i != length && str.charAt(i) <= ' ') {
            i++;
        }
        if (!"charset".regionMatches(true, 0, str, i, 7)) {
            return null;
        }
        int i2 = i + 7;
        while (i2 != length && str.charAt(i2) <= ' ') {
            i2++;
        }
        if (i2 == length || str.charAt(i2) != '=') {
            return null;
        }
        do {
            i2++;
            if (i2 == length) {
                break;
            }
        } while (str.charAt(i2) <= ' ');
        if (i2 == length) {
            return null;
        }
        while (str.charAt(length - 1) <= ' ') {
            length--;
        }
        return str.substring(i2, length);
    }

    private static Class<?> getClass(Object[] objArr) {
        if (objArr.length == 0) {
            throw reportRuntimeError("msg.expected.string.arg");
        }
        Object obj = objArr[0];
        if (obj instanceof Wrapper) {
            Object objUnwrap = ((Wrapper) obj).unwrap();
            if (objUnwrap instanceof Class) {
                return (Class) objUnwrap;
            }
        }
        String string = Context.toString(objArr[0]);
        try {
            return Class.forName(string);
        } catch (ClassNotFoundException unused) {
            throw reportRuntimeError("msg.class.not.found", string);
        }
    }

    private static Global getInstance(Function function) {
        Scriptable parentScope = function.getParentScope();
        if (parentScope instanceof Global) {
            return (Global) parentScope;
        }
        throw reportRuntimeError("msg.bad.shell.function.scope", String.valueOf(parentScope));
    }

    public static void help(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        getInstance(function).getOut().println(ToolErrorReporter.getMessage("msg.help"));
    }

    public static void load(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        for (Object obj : objArr) {
            String string = Context.toString(obj);
            try {
                Main.processFile(context, scriptable, string);
            } catch (IOException e) {
                throw Context.reportRuntimeError(ToolErrorReporter.getMessage("msg.couldnt.read.source", string, e.getMessage()));
            } catch (VirtualMachineError e2) {
                e2.printStackTrace();
                throw Context.reportRuntimeError(ToolErrorReporter.getMessage("msg.uncaughtJSException", e2.toString()));
            }
        }
    }

    public static void loadClass(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Class<?> cls = getClass(objArr);
        if (!Script.class.isAssignableFrom(cls)) {
            throw reportRuntimeError("msg.must.implement.Script");
        }
        ((Script) cls.newInstance()).exec(context, scriptable);
    }

    private boolean loadJLine(Charset charset) {
        if (!this.attemptedJLineLoad) {
            this.attemptedJLineLoad = true;
            this.console = ShellConsole.getConsole(this, charset);
        }
        return this.console != null;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0025 A[Catch: IOException -> 0x002c, TRY_ENTER, TryCatch #3 {IOException -> 0x002c, blocks: (B:17:0x0025, B:18:0x0029), top: B:36:0x0023 }] */
    /* JADX WARN: Code duplicated, block: B:18:0x0029 A[Catch: IOException -> 0x002c, TRY_LEAVE, TryCatch #3 {IOException -> 0x002c, blocks: (B:17:0x0025, B:18:0x0029), top: B:36:0x0023 }] */
    static void pipe(boolean z, InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int i = !z ? inputStream.read(bArr, 0, 4096) : inputStream.read(bArr, 0, 4096);
                if (i < 0) {
                    break;
                }
                if (z) {
                    outputStream.write(bArr, 0, i);
                    outputStream.flush();
                } else {
                    try {
                        outputStream.write(bArr, 0, i);
                        outputStream.flush();
                    } catch (IOException unused) {
                        try {
                            if (z) {
                                inputStream.close();
                            } else {
                                outputStream.close();
                            }
                        } catch (IOException unused2) {
                            return;
                        }
                    }
                }
            }
            if (z) {
                inputStream.close();
            } else {
                outputStream.close();
            }
        } catch (Throwable th) {
            try {
                if (z) {
                    inputStream.close();
                } else {
                    outputStream.close();
                }
            } catch (IOException unused3) {
            }
            throw th;
        }
    }

    public static Object print(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        return doPrint(objArr, function, true);
    }

    public static void quit(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Global global = getInstance(function);
        if (global.quitAction != null) {
            global.quitAction.quit(context, objArr.length != 0 ? ScriptRuntime.toInt32(objArr[0]) : 0);
        }
    }

    public static Object readFile(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length != 0) {
            return readUrl(ScriptRuntime.toString(objArr[0]), objArr.length >= 2 ? ScriptRuntime.toString(objArr[1]) : null, true);
        }
        throw reportRuntimeError("msg.shell.readFile.bad.args");
    }

    private static String readReader(Reader reader) {
        return readReader(reader, 4096);
    }

    public static Object readUrl(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length != 0) {
            return readUrl(ScriptRuntime.toString(objArr[0]), objArr.length >= 2 ? ScriptRuntime.toString(objArr[1]) : null, false);
        }
        throw reportRuntimeError("msg.shell.readUrl.bad.args");
    }

    public static Object readline(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Global global = getInstance(function);
        int length = objArr.length;
        ShellConsole shellConsole = global.console;
        return length > 0 ? shellConsole.readLine(Context.toString(objArr[0])) : shellConsole.readLine();
    }

    static RuntimeException reportRuntimeError(String str) {
        return Context.reportRuntimeError(ToolErrorReporter.getMessage(str));
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:52:0x00db  */
    /* JADX WARN: Code duplicated, block: B:53:0x00de  */
    /* JADX WARN: Code duplicated, block: B:57:0x00e9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r17v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r3v6 */
    public static Object runCommand(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        ?? r2;
        ?? r3;
        Object obj;
        Scriptable scriptable2;
        String[] strArr;
        File file;
        InputStream inputStream;
        Object property;
        OutputStream err;
        ?? r16;
        String[] strArr2;
        Object outputStream;
        Object obj2;
        OutputStream outputStream2;
        Object property2;
        String str;
        int length = objArr.length;
        if (length == 0 || (length == 1 && (objArr[0] instanceof Scriptable))) {
            throw reportRuntimeError("msg.runCommand.bad.args");
        }
        Object obj3 = objArr[length - 1];
        Object out = null;
        if (obj3 instanceof Scriptable) {
            Scriptable scriptable3 = (Scriptable) obj3;
            length--;
            Object property3 = ScriptableObject.getProperty(scriptable3, "env");
            if (property3 == Scriptable.NOT_FOUND) {
                strArr2 = null;
            } else if (property3 == null) {
                strArr2 = new String[0];
            } else {
                if (!(property3 instanceof Scriptable)) {
                    throw reportRuntimeError("msg.runCommand.bad.env");
                }
                Scriptable scriptable4 = (Scriptable) property3;
                Object[] propertyIds = ScriptableObject.getPropertyIds(scriptable4);
                String[] strArr3 = new String[propertyIds.length];
                for (int i = 0; i != propertyIds.length; i++) {
                    Object obj4 = propertyIds[i];
                    if (obj4 instanceof String) {
                        str = (String) obj4;
                        property2 = ScriptableObject.getProperty(scriptable4, str);
                    } else {
                        int iIntValue = ((Number) obj4).intValue();
                        String string = Integer.toString(iIntValue);
                        property2 = ScriptableObject.getProperty(scriptable4, iIntValue);
                        str = string;
                    }
                    if (property2 == Scriptable.NOT_FOUND) {
                        property2 = Undefined.instance;
                    }
                    strArr3[i] = str + '=' + ScriptRuntime.toString(property2);
                }
                strArr2 = strArr3;
            }
            Object property4 = ScriptableObject.getProperty(scriptable3, KeyManagementAlgorithmIdentifiers.DIRECT);
            Object obj5 = Scriptable.NOT_FOUND;
            file = property4 != obj5 ? new File(ScriptRuntime.toString(property4)) : null;
            Object property5 = ScriptableObject.getProperty(scriptable3, "input");
            InputStream inputStream2 = property5 != obj5 ? toInputStream(property5) : null;
            Object property6 = ScriptableObject.getProperty(scriptable3, "output");
            if (property6 != obj5) {
                outputStream = toOutputStream(property6);
                if (outputStream == null) {
                    outputStream = new ByteArrayOutputStream();
                } else {
                    obj2 = null;
                }
                property = ScriptableObject.getProperty(scriptable3, NotificationCompat.CATEGORY_ERROR);
                if (property != obj5) {
                    err = toOutputStream(property);
                    if (err == null) {
                        err = new ByteArrayOutputStream();
                    } else {
                        outputStream2 = null;
                    }
                    Object property7 = ScriptableObject.getProperty(scriptable3, "args");
                    out = property7 != obj5 ? context.getElements(Context.toObject(property7, ScriptableObject.getTopLevelScope(scriptable))) : null;
                    strArr = strArr2;
                    r2 = out;
                    obj = property6;
                    out = outputStream;
                    inputStream = inputStream2;
                    scriptable2 = scriptable3;
                    r3 = obj2;
                    r16 = outputStream2;
                } else {
                    err = null;
                }
                outputStream2 = err;
                Object property8 = ScriptableObject.getProperty(scriptable3, "args");
                if (property8 != obj5) {
                }
                strArr = strArr2;
                r2 = out;
                obj = property6;
                out = outputStream;
                inputStream = inputStream2;
                scriptable2 = scriptable3;
                r3 = obj2;
                r16 = outputStream2;
            } else {
                outputStream = null;
            }
            obj2 = outputStream;
            property = ScriptableObject.getProperty(scriptable3, NotificationCompat.CATEGORY_ERROR);
            if (property != obj5) {
                err = toOutputStream(property);
                if (err == null) {
                    err = new ByteArrayOutputStream();
                } else {
                    outputStream2 = null;
                }
                Object property9 = ScriptableObject.getProperty(scriptable3, "args");
                if (property9 != obj5) {
                }
                strArr = strArr2;
                r2 = out;
                obj = property6;
                out = outputStream;
                inputStream = inputStream2;
                scriptable2 = scriptable3;
                r3 = obj2;
                r16 = outputStream2;
            } else {
                err = null;
            }
            outputStream2 = err;
            Object property10 = ScriptableObject.getProperty(scriptable3, "args");
            if (property10 != obj5) {
            }
            strArr = strArr2;
            r2 = out;
            obj = property6;
            out = outputStream;
            inputStream = inputStream2;
            scriptable2 = scriptable3;
            r3 = obj2;
            r16 = outputStream2;
        } else {
            r2 = 0;
            r3 = 0;
            obj = null;
            scriptable2 = null;
            strArr = null;
            file = null;
            inputStream = null;
            property = null;
            err = null;
            r16 = 0;
        }
        Global global = getInstance(function);
        if (out == null) {
            out = global.getOut();
        }
        if (err == null) {
            err = global.getErr();
        }
        OutputStream outputStream3 = err;
        String[] strArr4 = new String[r2 == 0 ? length : r2.length + length];
        for (int i2 = 0; i2 != length; i2++) {
            strArr4[i2] = ScriptRuntime.toString(objArr[i2]);
        }
        if (r2 != 0) {
            for (int i3 = 0; i3 != r2.length; i3++) {
                strArr4[length + i3] = ScriptRuntime.toString((Object) r2[i3]);
            }
        }
        ?? r12 = out;
        Scriptable scriptable5 = scriptable2;
        int iRunProcess = runProcess(strArr4, strArr, file, inputStream, r12, outputStream3);
        if (r3 != 0) {
            ScriptableObject.putProperty(scriptable5, "output", ScriptRuntime.toString(obj) + r3.toString());
        }
        if (r16 != 0) {
            ScriptableObject.putProperty(scriptable5, NotificationCompat.CATEGORY_ERROR, ScriptRuntime.toString(property) + r16.toString());
        }
        return Integer.valueOf(iRunProcess);
    }

    private static int runProcess(String[] strArr, String[] strArr2, File file, InputStream inputStream, OutputStream outputStream, OutputStream outputStream2) {
        PipeThread pipeThread;
        PipeThread pipeThread2;
        PipeThread pipeThread3 = null;
        Process processExec = strArr2 == null ? Runtime.getRuntime().exec(strArr, (String[]) null, file) : Runtime.getRuntime().exec(strArr, strArr2, file);
        try {
            if (inputStream != null) {
                pipeThread = new PipeThread(false, inputStream, processExec.getOutputStream());
                pipeThread.start();
            } else {
                processExec.getOutputStream().close();
                pipeThread = null;
            }
            if (outputStream != null) {
                pipeThread2 = new PipeThread(true, processExec.getInputStream(), outputStream);
                pipeThread2.start();
            } else {
                processExec.getInputStream().close();
                pipeThread2 = null;
            }
            if (outputStream2 != null) {
                pipeThread3 = new PipeThread(true, processExec.getErrorStream(), outputStream2);
                pipeThread3.start();
            } else {
                processExec.getErrorStream().close();
            }
            while (true) {
                try {
                    processExec.waitFor();
                    if (pipeThread2 != null) {
                        pipeThread2.join();
                    }
                    if (pipeThread != null) {
                        pipeThread.join();
                    }
                    if (pipeThread3 == null) {
                        break;
                    }
                    pipeThread3.join();
                    break;
                } catch (InterruptedException unused) {
                }
            }
            int iExitValue = processExec.exitValue();
            processExec.destroy();
            return iExitValue;
        } catch (Throwable th) {
            processExec.destroy();
            throw th;
        }
    }

    public static void seal(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        for (int i = 0; i != objArr.length; i++) {
            Object obj = objArr[i];
            if (!(obj instanceof ScriptableObject) || obj == Undefined.instance) {
                if ((obj instanceof Scriptable) && obj != Undefined.instance) {
                    throw reportRuntimeError("msg.shell.seal.not.scriptable");
                }
                throw reportRuntimeError("msg.shell.seal.not.object");
            }
        }
        for (int i2 = 0; i2 != objArr.length; i2++) {
            ((ScriptableObject) objArr[i2]).sealObject();
        }
    }

    public static void serialize(Context context, Scriptable scriptable, Object[] objArr, Function function) throws IOException {
        if (objArr.length < 2) {
            throw Context.reportRuntimeError("Expected an object to serialize and a filename to write the serialization to");
        }
        Object obj = objArr[0];
        ScriptableOutputStream scriptableOutputStream = new ScriptableOutputStream(new FileOutputStream(Context.toString(objArr[1])), ScriptableObject.getTopLevelScope(scriptable));
        scriptableOutputStream.writeObject(obj);
        scriptableOutputStream.close();
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001f  */
    public static Object spawn(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Runner runner;
        Object[] elements;
        Scriptable parentScope = function.getParentScope();
        if (objArr.length == 0 || !(objArr[0] instanceof Function)) {
            if (objArr.length != 0) {
                Object obj = objArr[0];
                if (obj instanceof Script) {
                    runner = new Runner(parentScope, (Script) obj);
                }
            }
            throw reportRuntimeError("msg.spawn.args");
        }
        if (objArr.length > 1) {
            Object obj2 = objArr[1];
            if (obj2 instanceof Scriptable) {
                elements = context.getElements((Scriptable) obj2);
            } else {
                elements = null;
            }
        } else {
            elements = null;
        }
        if (elements == null) {
            elements = ScriptRuntime.emptyArgs;
        }
        runner = new Runner(parentScope, (Function) objArr[0], elements);
        runner.factory = context.getFactory();
        Thread thread = new Thread(runner);
        thread.start();
        return thread;
    }

    public static Object sync(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Object obj;
        if (objArr.length >= 1 && objArr.length <= 2) {
            Object obj2 = objArr[0];
            if (obj2 instanceof Function) {
                if (objArr.length != 2 || (obj = objArr[1]) == Undefined.instance) {
                    obj = null;
                }
                return new Synchronizer((Function) obj2, obj);
            }
        }
        throw reportRuntimeError("msg.sync.args");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    private static InputStream toInputStream(Object obj) {
        String string;
        InputStream inputStream = null;
        if (obj instanceof Wrapper) {
            Object objUnwrap = ((Wrapper) obj).unwrap();
            if (objUnwrap instanceof InputStream) {
                inputStream = (InputStream) objUnwrap;
                string = null;
            } else if (objUnwrap instanceof byte[]) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[]) objUnwrap);
                string = null;
                inputStream = byteArrayInputStream;
            } else if (objUnwrap instanceof Reader) {
                string = readReader((Reader) objUnwrap);
            } else if (objUnwrap instanceof char[]) {
                string = new String((char[]) objUnwrap);
            } else {
                string = null;
            }
        } else {
            string = null;
        }
        if (inputStream != null) {
            return inputStream;
        }
        if (string == null) {
            string = ScriptRuntime.toString(obj);
        }
        return new ByteArrayInputStream(string.getBytes());
    }

    private static OutputStream toOutputStream(Object obj) {
        if (!(obj instanceof Wrapper)) {
            return null;
        }
        Object objUnwrap = ((Wrapper) obj).unwrap();
        if (objUnwrap instanceof OutputStream) {
            return (OutputStream) objUnwrap;
        }
        return null;
    }

    public static Object toint32(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        Object obj = objArr.length != 0 ? objArr[0] : Undefined.instance;
        return obj instanceof Integer ? obj : ScriptRuntime.wrapInt(ScriptRuntime.toInt32(obj));
    }

    public static double version(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        if (objArr.length > 0) {
            context.setLanguageVersion((int) Context.toNumber(objArr[0]));
        }
        return context.getLanguageVersion();
    }

    public static Object write(Context context, Scriptable scriptable, Object[] objArr, Function function) {
        return doPrint(objArr, function, false);
    }

    public ShellConsole getConsole(Charset charset) {
        if (!loadJLine(charset)) {
            this.console = ShellConsole.getConsole(getIn(), getErr(), charset);
        }
        return this.console;
    }

    public PrintStream getErr() {
        PrintStream printStream = this.errStream;
        return printStream == null ? System.err : printStream;
    }

    public InputStream getIn() {
        if (this.inStream == null && !this.attemptedJLineLoad && loadJLine(Charset.defaultCharset())) {
            this.inStream = this.console.getIn();
        }
        InputStream inputStream = this.inStream;
        return inputStream == null ? System.in : inputStream;
    }

    public PrintStream getOut() {
        PrintStream printStream = this.outStream;
        return printStream == null ? System.out : printStream;
    }

    public String[] getPrompts(Context context) {
        if (ScriptableObject.hasProperty(this, "prompts")) {
            Object property = ScriptableObject.getProperty(this, "prompts");
            if (property instanceof Scriptable) {
                Scriptable scriptable = (Scriptable) property;
                if (ScriptableObject.hasProperty(scriptable, 0) && ScriptableObject.hasProperty(scriptable, 1)) {
                    Object property2 = ScriptableObject.getProperty(scriptable, 0);
                    if (property2 instanceof Function) {
                        property2 = ((Function) property2).call(context, this, scriptable, new Object[0]);
                    }
                    this.prompts[0] = Context.toString(property2);
                    Object property3 = ScriptableObject.getProperty(scriptable, 1);
                    if (property3 instanceof Function) {
                        property3 = ((Function) property3).call(context, this, scriptable, new Object[0]);
                    }
                    this.prompts[1] = Context.toString(property3);
                }
            }
        }
        return this.prompts;
    }

    public void init(Context context) {
        initStandardObjects(context, this.sealedStdLib);
        defineFunctionProperties(new String[]{"defineClass", "deserialize", "doctest", "gc", "help", "load", "loadClass", Analytics.Event.PRINT, "quit", "readline", "readFile", "readUrl", "runCommand", "seal", "serialize", "spawn", "sync", "toint32", "version", "write"}, Global.class, 2);
        Environment.defineClass(this);
        defineProperty("environment", new Environment(this), 2);
        NativeArray nativeArray = (NativeArray) context.newArray(this, 0);
        this.history = nativeArray;
        defineProperty("history", nativeArray, 2);
        this.initialized = true;
    }

    public void initQuitAction(QuitAction quitAction) {
        if (quitAction == null) {
            throw new IllegalArgumentException("quitAction is null");
        }
        if (this.quitAction != null) {
            throw new IllegalArgumentException("The method is once-call.");
        }
        this.quitAction = quitAction;
    }

    public Require installRequire(Context context, List<String> list, boolean z) {
        RequireBuilder requireBuilder = new RequireBuilder();
        requireBuilder.setSandboxed(z);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (String str : list) {
                try {
                    URI uri = new URI(str);
                    if (!uri.isAbsolute()) {
                        uri = new File(str).toURI().resolve("");
                    }
                    if (!uri.toString().endsWith("/")) {
                        uri = new URI(uri + "/");
                    }
                    arrayList.add(uri);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        requireBuilder.setModuleScriptProvider(new SoftCachingModuleScriptProvider(new UrlModuleSourceProvider(arrayList, null)));
        Require requireCreateRequire = requireBuilder.createRequire(context, this);
        requireCreateRequire.install(this);
        return requireCreateRequire;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    /* JADX INFO: renamed from: lambda$init$0$external-sdk-pendo-io-mozilla-javascript-tools-shell-Global, reason: not valid java name */
    /* synthetic */ Object m14717x63b55001(Context context) {
        init(context);
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 7 */
    public int runDoctest(Context context, Scriptable scriptable, String str, String str2, int i) throws Throwable {
        PrintStream printStream;
        ErrorReporter errorReporter;
        PrintStream printStream2;
        ByteArrayOutputStream byteArrayOutputStream;
        StringBuilder sb;
        String[] strArr;
        String str3;
        StringBuilder sb2;
        this.doctestCanonicalizations = new HashMap<>();
        String[] strArrSplit = str.split("\r\n?|\n");
        boolean z = false;
        String strTrim = this.prompts[0].trim();
        boolean z2 = true;
        String strTrim2 = this.prompts[1].trim();
        int i2 = 0;
        while (i2 < strArrSplit.length && !strArrSplit[i2].trim().startsWith(strTrim)) {
            i2++;
        }
        int i3 = 0;
        while (i2 < strArrSplit.length) {
            StringBuilder sb3 = new StringBuilder(strArrSplit[i2].trim().substring(strTrim.length()));
            while (true) {
                sb3.append('\n');
                i2++;
                if (i2 >= strArrSplit.length || !strArrSplit[i2].trim().startsWith(strTrim2)) {
                    break;
                }
                sb3.append(strArrSplit[i2].trim().substring(strTrim2.length()));
            }
            StringBuilder sb4 = new StringBuilder();
            int i4 = i2;
            while (i4 < strArrSplit.length && !strArrSplit[i4].trim().startsWith(strTrim)) {
                sb4.append(strArrSplit[i4]).append('\n');
                i4++;
            }
            PrintStream out = getOut();
            PrintStream err = getErr();
            boolean z3 = z2;
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            int i5 = i4;
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            setOut(new PrintStream(byteArrayOutputStream2));
            setErr(new PrintStream(byteArrayOutputStream3));
            ErrorReporter errorReporter2 = context.getErrorReporter();
            context.setErrorReporter(new ToolErrorReporter(z, getErr()));
            int i6 = i3 + 1;
            try {
                String string = sb3.toString();
                printStream = out;
                sb = sb4;
                strArr = strArrSplit;
                printStream2 = err;
                str3 = strTrim;
                errorReporter = errorReporter2;
                byteArrayOutputStream = byteArrayOutputStream3;
                try {
                    try {
                        Object objEvaluateString = context.evaluateString(scriptable, string, "doctest input", 1, null);
                        String string2 = (objEvaluateString == Context.getUndefinedValue() || ((objEvaluateString instanceof Function) && string.trim().startsWith("function"))) ? "" : Context.toString(objEvaluateString);
                        setOut(printStream);
                        setErr(printStream2);
                        context.setErrorReporter(errorReporter);
                        sb2 = new StringBuilder().append(string2);
                    } catch (RhinoException e) {
                        e = e;
                        ToolErrorReporter.reportException(context.getErrorReporter(), e);
                        setOut(printStream);
                        setErr(printStream2);
                        context.setErrorReporter(errorReporter);
                        sb2 = new StringBuilder("");
                    }
                } catch (Throwable th) {
                    th = th;
                    setOut(printStream);
                    setErr(printStream2);
                    context.setErrorReporter(errorReporter);
                    byteArrayOutputStream.toString();
                    byteArrayOutputStream2.toString();
                    throw th;
                }
            } catch (RhinoException e2) {
                e = e2;
                printStream = out;
                sb = sb4;
                strArr = strArrSplit;
                str3 = strTrim;
                byteArrayOutputStream = byteArrayOutputStream3;
                errorReporter = errorReporter2;
                printStream2 = err;
            } catch (Throwable th2) {
                th = th2;
                printStream = out;
                errorReporter = errorReporter2;
                printStream2 = err;
                byteArrayOutputStream = byteArrayOutputStream3;
            }
            String string3 = sb2.append(byteArrayOutputStream.toString()).append(byteArrayOutputStream2.toString()).toString();
            if (!doctestOutputMatches(sb.toString(), string3)) {
                String str4 = "doctest failure running:\n" + ((Object) sb3) + "expected: " + ((Object) sb) + "actual: " + string3 + "\n";
                if (str2 != null) {
                    throw Context.reportRuntimeError(str4, str2, (i + i5) - 1, null, 0);
                }
                throw Context.reportRuntimeError(str4);
            }
            z2 = z3;
            i2 = i5;
            i3 = i6;
            strArrSplit = strArr;
            strTrim = str3;
            z = false;
        }
        return i3;
    }

    public void setErr(PrintStream printStream) {
        this.errStream = printStream;
    }

    public void setIn(InputStream inputStream) {
        this.inStream = inputStream;
    }

    public void setOut(PrintStream printStream) {
        this.outStream = printStream;
    }

    public void setSealedStdLib(boolean z) {
        this.sealedStdLib = z;
    }

    public Global(Context context) {
        init(context);
    }

    private static String readReader(Reader reader, int i) throws IOException {
        char[] cArr = new char[i];
        int i2 = 0;
        while (true) {
            int i3 = reader.read(cArr, i2, cArr.length - i2);
            if (i3 < 0) {
                return new String(cArr, 0, i2);
            }
            i2 += i3;
            if (i2 == cArr.length) {
                char[] cArr2 = new char[cArr.length * 2];
                System.arraycopy(cArr, 0, cArr2, 0, i2);
                cArr = cArr2;
            }
        }
    }

    private static String readUrl(String str, String str2, boolean z) throws IOException {
        int contentLength;
        InputStream inputStream;
        String contentType;
        InputStream inputStream2 = null;
        try {
            if (z) {
                File file = new File(str);
                if (!file.exists()) {
                    throw new FileNotFoundException("File not found: " + str);
                }
                if (!file.canRead()) {
                    throw new IOException("Cannot read file: " + str);
                }
                long length = file.length();
                int i = (int) length;
                if (i != length) {
                    throw new IOException("Too big file size: " + length);
                }
                if (i == 0) {
                    return "";
                }
                FileInputStream fileInputStream = new FileInputStream(file);
                contentLength = i;
                inputStream = fileInputStream;
            } else {
                URLConnection uRLConnectionOpenConnection = new URL(str).openConnection();
                inputStream = uRLConnectionOpenConnection.getInputStream();
                contentLength = uRLConnectionOpenConnection.getContentLength();
                if (contentLength <= 0) {
                    contentLength = 1024;
                }
                if (str2 == null && (contentType = uRLConnectionOpenConnection.getContentType()) != null) {
                    str2 = getCharCodingFromType(contentType);
                }
            }
            String reader = readReader(str2 == null ? new InputStreamReader(inputStream) : new InputStreamReader(inputStream, str2), contentLength);
            if (inputStream != null) {
                inputStream.close();
            }
            return reader;
        } catch (Throwable th) {
            if (0 != 0) {
                inputStream2.close();
            }
            throw th;
        }
    }

    static RuntimeException reportRuntimeError(String str, String str2) {
        return Context.reportRuntimeError(ToolErrorReporter.getMessage(str, str2));
    }

    public void init(ContextFactory contextFactory) {
        contextFactory.call(new ContextAction() { // from class: external.sdk.pendo.io.mozilla.javascript.tools.shell.Global$$ExternalSyntheticLambda0
            @Override // external.sdk.pendo.io.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return this.f$0.m14717x63b55001(context);
            }
        });
    }
}
