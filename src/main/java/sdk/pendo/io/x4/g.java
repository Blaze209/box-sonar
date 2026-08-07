package sdk.pendo.io.x4;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;

/* JADX INFO: loaded from: classes6.dex */
public final class g {
    private static b a = null;
    private static boolean b = false;

    private static final class b extends SecurityManager {
        private b() {
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    private g() {
    }

    public static Class<?> a() {
        int i;
        b bVarB = b();
        if (bVarB == null) {
            return null;
        }
        Class<?>[] classContext = bVarB.getClassContext();
        String name = g.class.getName();
        int i2 = 0;
        while (i2 < classContext.length && !name.equals(classContext[i2].getName())) {
            i2++;
        }
        if (i2 >= classContext.length || (i = i2 + 2) >= classContext.length) {
            throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        }
        return classContext[i];
    }

    private static b b() {
        b bVar = a;
        if (bVar != null) {
            return bVar;
        }
        if (b) {
            return null;
        }
        b bVarC = c();
        a = bVarC;
        b = true;
        return bVarC;
    }

    private static b c() {
        try {
            return new b();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static final void a(String str) {
        System.err.println("SLF4J: " + str);
    }

    public static boolean b(String str) {
        String strC = c(str);
        if (strC == null) {
            return false;
        }
        return strC.equalsIgnoreCase(TelemetryEventStrings.Value.TRUE);
    }

    public static String c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static final void a(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }
}
