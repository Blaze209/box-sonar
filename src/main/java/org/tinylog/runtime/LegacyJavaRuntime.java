package org.tinylog.runtime;

import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;
import sun.reflect.Reflection;

/* JADX INFO: loaded from: classes5.dex */
public final class LegacyJavaRuntime extends AbstractJavaRuntime {
    private static final Timestamp startTime = new LegacyTimestamp(ManagementFactory.getRuntimeMXBean().getStartTime());
    private final boolean hasSunReflection = verifySunReflection();
    private final Method stackTraceElementGetter = getStackTraceElementGetter();

    @Override // org.tinylog.runtime.RuntimeDialect
    public boolean isAndroid() {
        return false;
    }

    @Override // org.tinylog.runtime.AbstractJavaRuntime, org.tinylog.runtime.RuntimeDialect
    public /* bridge */ /* synthetic */ String getDefaultWriter() {
        return super.getDefaultWriter();
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public long getProcessId() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        try {
            return Long.parseLong(name.substring(0, name.indexOf(64)));
        } catch (IndexOutOfBoundsException unused) {
            InternalLogger.log(Level.ERROR, "Name of virtual machine does not contain a process ID: " + name);
            return -1L;
        } catch (NumberFormatException unused2) {
            InternalLogger.log(Level.ERROR, "Illegal process ID: " + name.substring(0, name.indexOf(64)));
            return -1L;
        }
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public Timestamp getStartTime() {
        return startTime;
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public String getCallerClassName(int i) {
        if (this.hasSunReflection) {
            return Reflection.getCallerClass(i + 1).getName();
        }
        return getCallerStackTraceElement(i + 1).getClassName();
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public String getCallerClassName(String str) {
        StackTraceElement callerStackTraceElement = getCallerStackTraceElement(str);
        if (callerStackTraceElement == null) {
            return null;
        }
        return callerStackTraceElement.getClassName();
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public StackTraceElement getCallerStackTraceElement(int i) {
        Method method = this.stackTraceElementGetter;
        if (method != null) {
            try {
                return (StackTraceElement) method.invoke(new Throwable(), Integer.valueOf(i));
            } catch (IllegalAccessException e) {
                InternalLogger.log(Level.ERROR, e, "Failed getting single stack trace element from throwable");
            } catch (InvocationTargetException e2) {
                InternalLogger.log(Level.ERROR, e2.getTargetException(), "Failed getting single stack trace element from throwable");
            }
        }
        return new Throwable().getStackTrace()[i];
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public StackTraceElement getCallerStackTraceElement(String str) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int i = 0;
        while (i < stackTrace.length && !str.equals(stackTrace[i].getClassName())) {
            i++;
        }
        while (i < stackTrace.length && str.equals(stackTrace[i].getClassName())) {
            i++;
        }
        if (i < stackTrace.length) {
            return stackTrace[i];
        }
        return null;
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public Timestamp createTimestamp() {
        return new LegacyTimestamp();
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public TimestampFormatter createTimestampFormatter(String str, Locale locale) {
        return new LegacyTimestampFormatter(str, locale);
    }

    private static boolean verifySunReflection() {
        try {
            return AbstractJavaRuntime.class.equals(Reflection.getCallerClass(1));
        } catch (Exception | NoClassDefFoundError | NoSuchMethodError | UnsatisfiedLinkError unused) {
            return false;
        }
    }

    private static Method getStackTraceElementGetter() {
        try {
            Method declaredMethod = Throwable.class.getDeclaredMethod("getStackTraceElement", Integer.TYPE);
            declaredMethod.setAccessible(true);
            if (LegacyJavaRuntime.class.getName().equals(((StackTraceElement) declaredMethod.invoke(new Throwable(), 0)).getClassName())) {
                return declaredMethod;
            }
            return null;
        } catch (Exception unused) {
        }
    }
}
