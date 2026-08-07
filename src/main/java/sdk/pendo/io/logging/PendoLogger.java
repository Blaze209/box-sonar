package sdk.pendo.io.logging;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes4.dex */
public final class PendoLogger {
    static final String ASSERT = "A";
    static final int CALL_STACK_INDEX = 7;
    static final String DEBUG = "D";
    static final String ERROR = "E";
    static final String INFO = "I";
    static final int MAX_LOG_LENGTH = 4000;
    private static final d[] TREE_ARRAY_EMPTY;
    static final String VERBOSE = "V";
    static final String WARNING = "W";
    private static volatile d[] sForestAsArray;
    static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
    private static final List<d> FOREST = new ArrayList();
    private static final d TREE_OF_SOULS = new a();

    class a extends d {
        a() {
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void a(String str, Object... objArr) {
            a(PendoLogger.DEBUG, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void b(String str, Object... objArr) {
            a("E", str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void c(String str, Object... objArr) {
            a(PendoLogger.INFO, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void d(Throwable th) {
            a(PendoLogger.INFO, th);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void e(Throwable th) {
            a("V", th);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void f(Throwable th) {
            a("W", th);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void g(Throwable th) {
            a("A", th);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void a(Throwable th) {
            a(PendoLogger.DEBUG, th);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void b(Throwable th) {
            a("E", th);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void d(Throwable th, String str, Object... objArr) {
            a(PendoLogger.INFO, th, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void e(Throwable th, String str, Object... objArr) {
            a("V", th, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void f(Throwable th, String str, Object... objArr) {
            a("W", th, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void g(Throwable th, String str, Object... objArr) {
            a("A", th, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void a(Throwable th, String str, Object... objArr) {
            a(PendoLogger.DEBUG, th, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void b(Throwable th, String str, Object... objArr) {
            a("E", th, str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void d(String str, Object... objArr) {
            a("V", str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void e(String str, Object... objArr) {
            a("W", str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void f(String str, Object... objArr) {
            a("A", str, objArr);
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        protected void a(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void a(int i, String str, Object... objArr) {
            try {
                a(PendoLogger.logLevelIntToString(i), str, objArr);
            } catch (Exception unused) {
            }
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void a(int i, Throwable th) {
            try {
                a(PendoLogger.logLevelIntToString(i), th);
            } catch (Exception unused) {
            }
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        public void a(int i, Throwable th, String str, Object... objArr) {
            try {
                a(PendoLogger.logLevelIntToString(i), th, str, objArr);
            } catch (Exception unused) {
            }
        }

        private void a(String str, String str2, Object... objArr) {
            d[] dVarArr = PendoLogger.sForestAsArray;
            int length = dVarArr.length;
            for (int i = 0; i < length; i++) {
                str.hashCode();
                str.hashCode();
                switch (str) {
                    case "A":
                        dVarArr[i].f(str2, objArr);
                        break;
                    case "D":
                        dVarArr[i].a(str2, objArr);
                        break;
                    case "E":
                        dVarArr[i].b(str2, objArr);
                        break;
                    case "I":
                        dVarArr[i].c(str2, objArr);
                        break;
                    case "V":
                        dVarArr[i].d(str2, objArr);
                        break;
                    case "W":
                        dVarArr[i].e(str2, objArr);
                        break;
                }
            }
        }

        private void a(String str, Throwable th) {
            d[] dVarArr = PendoLogger.sForestAsArray;
            int length = dVarArr.length;
            for (int i = 0; i < length; i++) {
                str.hashCode();
                str.hashCode();
                switch (str) {
                    case "A":
                        dVarArr[i].g(th);
                        break;
                    case "D":
                        dVarArr[i].a(th);
                        break;
                    case "E":
                        dVarArr[i].b(th);
                        break;
                    case "I":
                        dVarArr[i].d(th);
                        break;
                    case "V":
                        dVarArr[i].e(th);
                        break;
                    case "W":
                        dVarArr[i].f(th);
                        break;
                }
            }
        }

        private void a(String str, Throwable th, String str2, Object... objArr) {
            d[] dVarArr = PendoLogger.sForestAsArray;
            int length = dVarArr.length;
            for (int i = 0; i < length; i++) {
                str.hashCode();
                str.hashCode();
                switch (str) {
                    case "A":
                        dVarArr[i].g(th, str2, objArr);
                        break;
                    case "D":
                        dVarArr[i].a(th, str2, objArr);
                        break;
                    case "E":
                        dVarArr[i].b(th, str2, objArr);
                        break;
                    case "I":
                        dVarArr[i].d(th, str2, objArr);
                        break;
                    case "V":
                        dVarArr[i].e(th, str2, objArr);
                        break;
                    case "W":
                        dVarArr[i].f(th, str2, objArr);
                        break;
                }
            }
        }
    }

    public static class b extends d {
        @Override // sdk.pendo.io.logging.PendoLogger.d
        final String a() {
            String strA = super.a();
            if (strA != null) {
                return strA;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 7) {
                return a(stackTrace[7]);
            }
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        protected String a(StackTraceElement stackTraceElement) {
            throw null;
        }

        @Override // sdk.pendo.io.logging.PendoLogger.d
        protected void a(int i, String str, String str2, Throwable th) {
            int iMin;
            if (str2.length() < 4000) {
                if (i == 7) {
                    Log.wtf(str, str2);
                    return;
                } else {
                    Log.println(i, str, str2);
                    return;
                }
            }
            int length = str2.length();
            int i2 = 0;
            while (i2 < length) {
                int iIndexOf = str2.indexOf(10, i2);
                if (iIndexOf == -1) {
                    iIndexOf = length;
                }
                while (true) {
                    iMin = Math.min(iIndexOf, i2 + 4000);
                    String strSubstring = str2.substring(i2, iMin);
                    if (i == 7) {
                        Log.wtf(str, strSubstring);
                    } else {
                        Log.println(i, str, strSubstring);
                    }
                    if (iMin >= iIndexOf) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }

    public static class c extends sdk.pendo.io.i6.a {
        private final Runnable a;

        c(Runnable runnable) {
            this.a = runnable;
        }

        @Override // sdk.pendo.io.i6.a
        protected void execute() {
            try {
                this.a.run();
            } catch (Throwable unused) {
            }
        }
    }

    public static abstract class d {
        private final ThreadLocal<String> a = new ThreadLocal<>();

        protected abstract void a(int i, String str, String str2, Throwable th);

        public void a(String str, Object... objArr) {
            b(3, null, str, objArr);
        }

        protected boolean a(int i) {
            return true;
        }

        public void b(String str, Object... objArr) {
            b(6, null, str, objArr);
        }

        protected String c(Throwable th, String str, Object... objArr) {
            if (str != null && str.isEmpty()) {
                str = null;
            }
            if (str == null) {
                if (th == null) {
                    return null;
                }
                return c(th);
            }
            if (objArr.length > 0) {
                if (!str.contains("%s")) {
                    str = str + " %s";
                }
                str = String.format(str, objArr);
            }
            return th != null ? str + "\n" + c(th) : str;
        }

        public void d(Throwable th) {
            b(4, th, null, new Object[0]);
        }

        public void e(Throwable th) {
            b(2, th, null, new Object[0]);
        }

        public void f(Throwable th) {
            b(5, th, null, new Object[0]);
        }

        public void g(Throwable th) {
            b(7, th, null, new Object[0]);
        }

        private String c(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter((Writer) stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        public void a(Throwable th) {
            b(3, th, null, new Object[0]);
        }

        public void b(Throwable th) {
            b(6, th, null, new Object[0]);
        }

        public void d(Throwable th, String str, Object... objArr) {
            b(4, th, str, objArr);
        }

        public void e(Throwable th, String str, Object... objArr) {
            b(2, th, str, objArr);
        }

        public void f(Throwable th, String str, Object... objArr) {
            b(5, th, str, objArr);
        }

        public void g(Throwable th, String str, Object... objArr) {
            b(7, th, str, objArr);
        }

        public void a(Throwable th, String str, Object... objArr) {
            b(3, th, str, objArr);
        }

        public void b(Throwable th, String str, Object... objArr) {
            b(6, th, str, objArr);
        }

        public void c(String str, Object... objArr) {
            b(4, null, str, objArr);
        }

        public void d(String str, Object... objArr) {
            b(2, null, str, objArr);
        }

        public void e(String str, Object... objArr) {
            b(5, null, str, objArr);
        }

        public void f(String str, Object... objArr) {
            b(7, null, str, objArr);
        }

        private void b(int i, Throwable th, String str, Object... objArr) {
            String strC;
            String strA = a();
            if (a(i) && (strC = c(th, str, objArr)) != null) {
                a(i, strA, strC, th);
            }
        }

        String a() {
            String str = this.a.get();
            if (str != null) {
                this.a.remove();
            }
            return str;
        }

        public void a(int i, String str, Object... objArr) {
            b(i, null, str, objArr);
        }

        public void a(int i, Throwable th) {
            b(i, th, null, new Object[0]);
        }

        public void a(int i, Throwable th, String str, Object... objArr) {
            b(i, th, str, objArr);
        }
    }

    static {
        d[] dVarArr = new d[0];
        TREE_ARRAY_EMPTY = dVarArr;
        sForestAsArray = dVarArr;
    }

    private PendoLogger() {
        throw new AssertionError("No instances.");
    }

    public static d asTree() {
        return TREE_OF_SOULS;
    }

    public static void d(String str, Object... objArr) {
        TREE_OF_SOULS.a(str, objArr);
    }

    public static void e(String str, String str2, Throwable th) {
        StringBuilder logMessage = formatLogMessage(str, str2);
        if (th != null) {
            logMessage.append(" | with error: ");
            logMessage.append(th);
            logMessage.append(" | with stacktrace: ");
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                int i3 = i2 + 1;
                if (i2 == 20) {
                    break;
                }
                logMessage.append("\n");
                logMessage.append(stackTraceElement);
                i++;
                i2 = i3;
            }
        }
        e(logMessage.toString(), new Object[0]);
    }

    public static List<d> forest() {
        List<d> listUnmodifiableList;
        List<d> list = FOREST;
        synchronized (list) {
            listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        }
        return listUnmodifiableList;
    }

    private static StringBuilder formatLogMessage(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
            sb.append(" | ");
        }
        if (str2 != null) {
            sb.append(str2);
        }
        return sb;
    }

    public static void i(String str, Object... objArr) {
        TREE_OF_SOULS.c(str, objArr);
    }

    public static void log(int i, String str, Object... objArr) {
        TREE_OF_SOULS.a(i, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String logLevelIntToString(int i) {
        switch (i) {
            case 2:
                return "V";
            case 3:
                return DEBUG;
            case 4:
                return INFO;
            case 5:
                return "W";
            case 6:
                return "E";
            case 7:
                return "A";
            default:
                throw new IllegalArgumentException("Level: " + i + " is not supported");
        }
    }

    public static void plant(d dVar) {
        if (dVar == null) {
            throw new NullPointerException("tree == null");
        }
        if (dVar == TREE_OF_SOULS) {
            throw new IllegalArgumentException("Cannot plant PendoLogger into itself.");
        }
        List<d> list = FOREST;
        synchronized (list) {
            list.remove(dVar);
            list.add(dVar);
            sForestAsArray = (d[]) list.toArray(new d[list.size()]);
        }
    }

    public static d tag(String str) {
        for (d dVar : sForestAsArray) {
            dVar.a.set(str);
        }
        return TREE_OF_SOULS;
    }

    public static int treeCount() {
        int size;
        List<d> list = FOREST;
        synchronized (list) {
            size = list.size();
        }
        return size;
    }

    public static void uproot(d dVar) {
        List<d> list = FOREST;
        synchronized (list) {
            list.remove(dVar);
            sForestAsArray = (d[]) list.toArray(new d[list.size()]);
        }
    }

    public static void uprootAll() {
        List<d> list = FOREST;
        synchronized (list) {
            list.clear();
            sForestAsArray = TREE_ARRAY_EMPTY;
        }
    }

    public static void v(String str, Object... objArr) {
        TREE_OF_SOULS.d(str, objArr);
    }

    public static void w(String str, Object... objArr) {
        TREE_OF_SOULS.e(str, objArr);
    }

    public static void wtf(String str, Object... objArr) {
        TREE_OF_SOULS.f(str, objArr);
    }

    public static void d(Throwable th) {
        TREE_OF_SOULS.a(th);
    }

    public static void e(String str, Object... objArr) {
        TREE_OF_SOULS.b(str, objArr);
    }

    public static void i(Throwable th) {
        TREE_OF_SOULS.d(th);
    }

    public static void log(int i, Throwable th) {
        TREE_OF_SOULS.a(i, th);
    }

    public static void plant(d... dVarArr) {
        if (dVarArr == null) {
            throw new NullPointerException("trees == null");
        }
        for (d dVar : dVarArr) {
            if (dVar == null) {
                throw new NullPointerException("trees contains null");
            }
            if (dVar == TREE_OF_SOULS) {
                throw new IllegalArgumentException("Cannot plant PendoLogger into itself.");
            }
        }
        List<d> list = FOREST;
        synchronized (list) {
            Collections.addAll(list, dVarArr);
            sForestAsArray = (d[]) list.toArray(new d[list.size()]);
        }
    }

    public static void v(Throwable th) {
        TREE_OF_SOULS.e(th);
    }

    public static void w(Throwable th) {
        TREE_OF_SOULS.f(th);
    }

    public static void wtf(Throwable th) {
        TREE_OF_SOULS.g(th);
    }

    public static void d(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.a(th, str, objArr);
    }

    private static void e(Throwable th) {
        TREE_OF_SOULS.b(th);
    }

    public static void i(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.d(th, str, objArr);
    }

    public static void log(int i, Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.a(i, th, str, objArr);
    }

    public static void v(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.e(th, str, objArr);
    }

    public static void w(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.f(th, str, objArr);
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.g(th, str, objArr);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        TREE_OF_SOULS.b(th, str, objArr);
    }
}
