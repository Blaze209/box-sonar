package org.tinylog.runtime;

import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Stream;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
final class ModernJavaRuntime extends AbstractJavaRuntime {
    private static final ClassContextSecurityManager securityManager = new ClassContextSecurityManager();
    private static final Timestamp startTime = new PreciseTimestamp(ManagementFactory.getRuntimeMXBean().getStartTime(), 0);
    private final ProcessHandle currentProcess = getCurrentProcess();

    @Override // org.tinylog.runtime.RuntimeDialect
    public boolean isAndroid() {
        return false;
    }

    ModernJavaRuntime() {
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public long getProcessId() {
        return this.currentProcess.pid();
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public Timestamp getStartTime() {
        return startTime;
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public String getCallerClassName(int i) {
        Class<?>[] classContext = securityManager.getClassContext();
        int i2 = i + 1;
        if (classContext.length > i2) {
            return classContext[i2].getName();
        }
        return null;
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public String getCallerClassName(String str) {
        Class<?>[] classContext = securityManager.getClassContext();
        int i = 0;
        while (i < classContext.length) {
            int i2 = i + 1;
            if (str.equals(classContext[i].getName())) {
                i = i2;
                break;
            }
            i = i2;
        }
        while (i < classContext.length) {
            int i3 = i + 1;
            String name = classContext[i].getName();
            if (!str.equals(name)) {
                return name;
            }
            i = i3;
        }
        return null;
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public StackTraceElement getCallerStackTraceElement(int i) {
        StackWalker.StackFrame stackFrame = (StackWalker.StackFrame) StackWalker.getInstance().walk(new FixedStackFrameExtractor(i));
        if (stackFrame == null) {
            return null;
        }
        return stackFrame.toStackTraceElement();
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public StackTraceElement getCallerStackTraceElement(String str) {
        StackWalker.StackFrame stackFrame = (StackWalker.StackFrame) StackWalker.getInstance().walk(new DynamicStackFrameExtractor(str));
        if (stackFrame == null) {
            return null;
        }
        return stackFrame.toStackTraceElement();
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public Timestamp createTimestamp() {
        return new PreciseTimestamp();
    }

    @Override // org.tinylog.runtime.RuntimeDialect
    public TimestampFormatter createTimestampFormatter(String str, Locale locale) {
        return new PreciseTimestampFormatter(str, locale);
    }

    private static ProcessHandle getCurrentProcess() {
        try {
            return (ProcessHandle) ProcessHandle.class.getDeclaredMethod("current", new Class[0]).invoke(null, new Object[0]);
        } catch (ReflectiveOperationException e) {
            InternalLogger.log(Level.ERROR, e, "Failed to receive the handle of the current process");
            return null;
        }
    }

    private static final class ClassContextSecurityManager extends SecurityManager {
        private ClassContextSecurityManager() {
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    private static final class FixedStackFrameExtractor implements Function<Stream<StackWalker.StackFrame>, StackWalker.StackFrame> {
        private final int index;

        private FixedStackFrameExtractor(int i) {
            this.index = i;
        }

        @Override // java.util.function.Function
        public StackWalker.StackFrame apply(Stream<StackWalker.StackFrame> stream) {
            return stream.skip(this.index).findFirst().orElse(null);
        }
    }

    private static final class DynamicStackFrameExtractor implements Function<Stream<StackWalker.StackFrame>, StackWalker.StackFrame> {
        private final String loggerClassName;

        private DynamicStackFrameExtractor(String str) {
            this.loggerClassName = str;
        }

        @Override // java.util.function.Function
        public StackWalker.StackFrame apply(Stream<StackWalker.StackFrame> stream) {
            Iterator<StackWalker.StackFrame> it = stream.iterator();
            while (it.hasNext() && !this.loggerClassName.equals(it.next().getClassName())) {
            }
            while (it.hasNext()) {
                StackWalker.StackFrame next = it.next();
                if (!this.loggerClassName.equals(next.getClassName())) {
                    return next;
                }
            }
            return null;
        }
    }
}
