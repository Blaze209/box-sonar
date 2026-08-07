package org.tinylog.runtime;

import android.os.Process;
import dalvik.system.VMStack;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
final class AndroidRuntime implements RuntimeDialect {
    private static final int STACK_TRACE_SIZE = 10;
    private static final Timestamp startTime = new LegacyTimestamp();
    private final Method stackTraceElementsFiller;
    private final int stackTraceOffset;

    @Override // org.tinylog.runtime.RuntimeDialect
    public boolean isAndroid() {
        return true;
    }

    AndroidRuntime() {
        StackTraceElementsFiller stackTraceElementsFiller = getStackTraceElementsFiller();
        this.stackTraceElementsFiller = stackTraceElementsFiller.method;
        this.stackTraceOffset = stackTraceElementsFiller.index;
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public String getDefaultWriter() {
        return "logcat";
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public long getProcessId() {
        return Process.myPid();
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public Timestamp getStartTime() {
        return startTime;
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public String getCallerClassName(int i) {
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
        StackTraceElement[] stackTraceElementArrExtractCallerStackTraceElements = extractCallerStackTraceElements(this.stackTraceOffset + i + 1);
        return stackTraceElementArrExtractCallerStackTraceElements == null ? new Throwable().getStackTrace()[i] : stackTraceElementArrExtractCallerStackTraceElements[stackTraceElementArrExtractCallerStackTraceElements.length - 1];
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public StackTraceElement getCallerStackTraceElement(String str) {
        StackTraceElement stackTraceElementFindStackTraceElement;
        StackTraceElement[] stackTraceElementArrExtractCallerStackTraceElements = extractCallerStackTraceElements(this.stackTraceOffset + 10);
        return (stackTraceElementArrExtractCallerStackTraceElements == null || (stackTraceElementFindStackTraceElement = findStackTraceElement(str, stackTraceElementArrExtractCallerStackTraceElements)) == null) ? findStackTraceElement(str, new Throwable().getStackTrace()) : stackTraceElementFindStackTraceElement;
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public Timestamp createTimestamp() {
        return new LegacyTimestamp();
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public TimestampFormatter createTimestampFormatter(String str, Locale locale) {
        return new LegacyTimestampFormatter(str, locale);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static StackTraceElementsFiller getStackTraceElementsFiller() {
        int i = -1;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        try {
            Method declaredMethod = VMStack.class.getDeclaredMethod("fillStackTraceElements", Thread.class, StackTraceElement[].class);
            declaredMethod.setAccessible(true);
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[10];
            declaredMethod.invoke(null, Thread.currentThread(), stackTraceElementArr);
            for (int i2 = 0; i2 < 10; i2++) {
                StackTraceElement stackTraceElement = stackTraceElementArr[i2];
                if (stackTraceElement != null && AndroidRuntime.class.getName().equals(stackTraceElement.getClassName()) && "getStackTraceElementsFiller".equals(stackTraceElement.getMethodName())) {
                    return new StackTraceElementsFiller(declaredMethod, i2);
                }
            }
            return new StackTraceElementsFiller(objArr2 == true ? 1 : 0, i);
        } catch (Exception unused) {
            return new StackTraceElementsFiller(0 == true ? 1 : 0, i);
        } catch (NoClassDefFoundError unused2) {
            return new StackTraceElementsFiller(0 == true ? 1 : 0, i);
        }
    }

    private static StackTraceElement findStackTraceElement(String str, StackTraceElement[] stackTraceElementArr) {
        int i = 0;
        while (i < stackTraceElementArr.length && !str.equals(stackTraceElementArr[i].getClassName())) {
            i++;
        }
        while (i < stackTraceElementArr.length && str.equals(stackTraceElementArr[i].getClassName())) {
            i++;
        }
        if (i < stackTraceElementArr.length) {
            return stackTraceElementArr[i];
        }
        return null;
    }

    private StackTraceElement[] extractCallerStackTraceElements(int i) {
        Method method = this.stackTraceElementsFiller;
        if (method != null) {
            try {
                StackTraceElement[] stackTraceElementArr = new StackTraceElement[i + 1];
                method.invoke(null, Thread.currentThread(), stackTraceElementArr);
                return stackTraceElementArr;
            } catch (IllegalAccessException e) {
                InternalLogger.log(Level.ERROR, e, "Failed getting stack trace element from dalvik.system.VMStack");
            } catch (InvocationTargetException e2) {
                InternalLogger.log(Level.ERROR, e2.getTargetException(), "Failed getting stack trace element from dalvik.system.VMStack");
            }
        }
        return null;
    }

    private static final class StackTraceElementsFiller {
        private final int index;
        private final Method method;

        private StackTraceElementsFiller(Method method, int i) {
            this.method = method;
            this.index = i;
        }
    }
}
