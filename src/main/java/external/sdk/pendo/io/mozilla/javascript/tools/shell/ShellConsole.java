package external.sdk.pendo.io.mozilla.javascript.tools.shell;

import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Kit;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ShellConsole {
    private static final Class[] NO_ARG = new Class[0];
    private static final Class[] BOOLEAN_ARG = {Boolean.TYPE};
    private static final Class[] STRING_ARG = {String.class};
    private static final Class[] CHARSEQ_ARG = {CharSequence.class};

    private static class ConsoleInputStream extends InputStream {
        private static final byte[] EMPTY = new byte[0];
        private final ShellConsole console;
        private final Charset cs;
        private byte[] buffer = EMPTY;
        private int cursor = -1;
        private boolean atEOF = false;

        public ConsoleInputStream(ShellConsole shellConsole, Charset charset) {
            this.console = shellConsole;
            this.cs = charset;
        }

        private boolean ensureInput() {
            if (this.atEOF) {
                return false;
            }
            int i = this.cursor;
            if (i < 0 || i > this.buffer.length) {
                if (readNextLine() == -1) {
                    this.atEOF = true;
                    return false;
                }
                this.cursor = 0;
            }
            return true;
        }

        private int readNextLine() {
            String line = this.console.readLine(null);
            if (line == null) {
                this.buffer = EMPTY;
                return -1;
            }
            byte[] bytes = line.getBytes(this.cs);
            this.buffer = bytes;
            return bytes.length;
        }

        @Override // java.io.InputStream
        public synchronized int read() {
            if (!ensureInput()) {
                return -1;
            }
            int i = this.cursor;
            byte[] bArr = this.buffer;
            if (i == bArr.length) {
                this.cursor = i + 1;
                return 10;
            }
            this.cursor = i + 1;
            return bArr[i];
        }

        @Override // java.io.InputStream
        public synchronized int read(byte[] bArr, int i, int i2) {
            bArr.getClass();
            if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
                throw new IndexOutOfBoundsException();
            }
            if (i2 == 0) {
                return 0;
            }
            if (!ensureInput()) {
                return -1;
            }
            int iMin = Math.min(i2, this.buffer.length - this.cursor);
            for (int i3 = 0; i3 < iMin; i3++) {
                bArr[i + i3] = this.buffer[this.cursor + i3];
            }
            if (iMin < i2) {
                bArr[i + iMin] = 10;
                iMin++;
            }
            this.cursor += iMin;
            return iMin;
        }
    }

    private static class JLineShellConsoleV1 extends ShellConsole {
        private final InputStream in;
        private final Object reader;

        JLineShellConsoleV1(Object obj, Charset charset) {
            this.reader = obj;
            this.in = new ConsoleInputStream(this, charset);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public void flush() {
            ShellConsole.tryInvoke(this.reader, "flushConsole", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public InputStream getIn() {
            return this.in;
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public void print(String str) {
            ShellConsole.tryInvoke(this.reader, "printString", ShellConsole.STRING_ARG, str);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public void println() {
            ShellConsole.tryInvoke(this.reader, "printNewline", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public String readLine() {
            return (String) ShellConsole.tryInvoke(this.reader, "readLine", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public void println(String str) {
            ShellConsole.tryInvoke(this.reader, "printString", ShellConsole.STRING_ARG, str);
            ShellConsole.tryInvoke(this.reader, "printNewline", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public String readLine(String str) {
            return (String) ShellConsole.tryInvoke(this.reader, "readLine", ShellConsole.STRING_ARG, str);
        }
    }

    private static class JLineShellConsoleV2 extends ShellConsole {
        private final InputStream in;
        private final Object reader;

        JLineShellConsoleV2(Object obj, Charset charset) {
            this.reader = obj;
            this.in = new ConsoleInputStream(this, charset);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public void flush() {
            ShellConsole.tryInvoke(this.reader, "flush", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public InputStream getIn() {
            return this.in;
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public void print(String str) {
            ShellConsole.tryInvoke(this.reader, Analytics.Event.PRINT, ShellConsole.CHARSEQ_ARG, str);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public void println() {
            ShellConsole.tryInvoke(this.reader, "println", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public String readLine() {
            return (String) ShellConsole.tryInvoke(this.reader, "readLine", ShellConsole.NO_ARG, new Object[0]);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public void println(String str) {
            ShellConsole.tryInvoke(this.reader, "println", ShellConsole.CHARSEQ_ARG, str);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public String readLine(String str) {
            return (String) ShellConsole.tryInvoke(this.reader, "readLine", ShellConsole.STRING_ARG, str);
        }
    }

    private static class SimpleShellConsole extends ShellConsole {
        private final InputStream in;
        private final PrintWriter out;
        private final BufferedReader reader;

        SimpleShellConsole(InputStream inputStream, PrintStream printStream, Charset charset) {
            this.in = inputStream;
            this.out = new PrintWriter(printStream);
            this.reader = new BufferedReader(new InputStreamReader(inputStream, charset));
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public void flush() {
            this.out.flush();
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public InputStream getIn() {
            return this.in;
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public void print(String str) {
            this.out.print(str);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public void println() {
            this.out.println();
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public String readLine() {
            return this.reader.readLine();
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public void println(String str) {
            this.out.println(str);
        }

        @Override // external.sdk.pendo.io.mozilla.javascript.tools.shell.ShellConsole
        public String readLine(String str) {
            if (str != null) {
                this.out.write(str);
                this.out.flush();
            }
            return this.reader.readLine();
        }
    }

    protected ShellConsole() {
    }

    public static ShellConsole getConsole(Scriptable scriptable, Charset charset) {
        ClassLoader classLoader = ShellConsole.class.getClassLoader();
        if (classLoader == null) {
            classLoader = ClassLoader.getSystemClassLoader();
        }
        if (classLoader == null) {
            return null;
        }
        try {
            Class<?> clsClassOrNull = Kit.classOrNull(classLoader, "jline.console.ConsoleReader");
            if (clsClassOrNull != null) {
                return getJLineShellConsoleV2(classLoader, clsClassOrNull, scriptable, charset);
            }
            Class<?> clsClassOrNull2 = Kit.classOrNull(classLoader, "jline.ConsoleReader");
            if (clsClassOrNull2 != null) {
                return getJLineShellConsoleV1(classLoader, clsClassOrNull2, scriptable, charset);
            }
            return null;
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
        }
    }

    private static JLineShellConsoleV1 getJLineShellConsoleV1(ClassLoader classLoader, Class<?> cls, Scriptable scriptable, Charset charset) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        tryInvoke(objNewInstance, "setBellEnabled", BOOLEAN_ARG, Boolean.FALSE);
        Class<?> clsClassOrNull = Kit.classOrNull(classLoader, "jline.Completor");
        tryInvoke(objNewInstance, "addCompletor", new Class[]{clsClassOrNull}, Proxy.newProxyInstance(classLoader, new Class[]{clsClassOrNull}, new FlexibleCompletor(clsClassOrNull, scriptable)));
        return new JLineShellConsoleV1(objNewInstance, charset);
    }

    private static JLineShellConsoleV2 getJLineShellConsoleV2(ClassLoader classLoader, Class<?> cls, Scriptable scriptable, Charset charset) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Object objNewInstance = cls.getConstructor(new Class[0]).newInstance(new Object[0]);
        tryInvoke(objNewInstance, "setBellEnabled", BOOLEAN_ARG, Boolean.FALSE);
        Class<?> clsClassOrNull = Kit.classOrNull(classLoader, "jline.console.completer.Completer");
        tryInvoke(objNewInstance, "addCompleter", new Class[]{clsClassOrNull}, Proxy.newProxyInstance(classLoader, new Class[]{clsClassOrNull}, new FlexibleCompletor(clsClassOrNull, scriptable)));
        return new JLineShellConsoleV2(objNewInstance, charset);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Object tryInvoke(Object obj, String str, Class[] clsArr, Object... objArr) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            if (declaredMethod != null) {
                return declaredMethod.invoke(obj, objArr);
            }
            return null;
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public abstract void flush();

    public abstract InputStream getIn();

    public abstract void print(String str);

    public abstract void println();

    public abstract void println(String str);

    public abstract String readLine();

    public abstract String readLine(String str);

    public static ShellConsole getConsole(InputStream inputStream, PrintStream printStream, Charset charset) {
        return new SimpleShellConsole(inputStream, printStream, charset);
    }
}
