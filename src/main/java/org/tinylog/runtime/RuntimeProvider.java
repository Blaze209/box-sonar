package org.tinylog.runtime;

import com.box.android.data.api.models.MetadataReservedKeys;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class RuntimeProvider {
    private static final int MINIMUM_VERSION_MODERN_JAVA = 9;
    private static final RuntimeDialect dialect = resolveDialect();

    private RuntimeProvider() {
    }

    public static boolean isAndroid() {
        return dialect.isAndroid();
    }

    public static List<ClassLoader> getClassLoaders() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader = RuntimeProvider.class.getClassLoader();
        if (contextClassLoader == null || contextClassLoader == classLoader) {
            return Collections.singletonList(classLoader);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(contextClassLoader);
        arrayList.add(classLoader);
        return arrayList;
    }

    public static String getDefaultWriter() {
        return dialect.getDefaultWriter();
    }

    public static long getProcessId() {
        return dialect.getProcessId();
    }

    public static Timestamp getStartTime() {
        return dialect.getStartTime();
    }

    public static String getCallerClassName(int i) {
        return stripAnonymousPart(dialect.getCallerClassName(i + 1));
    }

    public static String getCallerClassName(String str) {
        String callerClassName = dialect.getCallerClassName(str);
        if (callerClassName == null) {
            InternalLogger.log(Level.ERROR, "Logger class \"" + str + "\" is missing in stack trace");
            return "<unknown class>";
        }
        return stripAnonymousPart(callerClassName);
    }

    public static StackTraceElement getCallerStackTraceElement(int i) {
        return normalizeClassName(dialect.getCallerStackTraceElement(i + 1));
    }

    public static StackTraceElement getCallerStackTraceElement(String str) {
        StackTraceElement callerStackTraceElement = dialect.getCallerStackTraceElement(str);
        if (callerStackTraceElement == null) {
            InternalLogger.log(Level.ERROR, "Logger class \"" + str + "\" is missing in stack trace");
            return new StackTraceElement("<unknown class>", "<unknown method>", "<unknown file>", -1);
        }
        return normalizeClassName(callerStackTraceElement);
    }

    public static Timestamp createTimestamp() {
        return dialect.createTimestamp();
    }

    public static TimestampFormatter createTimestampFormatter(String str, Locale locale) {
        return dialect.createTimestampFormatter(str, locale);
    }

    private static RuntimeDialect resolveDialect() {
        if (getJavaVersion() >= 9) {
            return new ModernJavaRuntime();
        }
        if ("Android Runtime".equalsIgnoreCase(System.getProperty("java.runtime.name"))) {
            return new AndroidRuntime();
        }
        return new LegacyJavaRuntime();
    }

    private static int getJavaVersion() {
        String property = System.getProperty("java.version");
        if (property == null) {
            return -1;
        }
        int iIndexOf = property.indexOf(46);
        if (iIndexOf > 0) {
            property = property.substring(0, iIndexOf);
        }
        try {
            return Integer.parseInt(property);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private static String stripAnonymousPart(String str) {
        int iIndexOf = str.indexOf(MetadataReservedKeys.PREFIX, 0);
        while (iIndexOf != -1) {
            if (iIndexOf >= str.length() - 1) {
                return str.substring(0, iIndexOf);
            }
            char cCharAt = str.charAt(iIndexOf + 1);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                iIndexOf = str.indexOf(36, iIndexOf + 2);
            } else {
                return str.substring(0, iIndexOf);
            }
        }
        return str;
    }

    private static StackTraceElement normalizeClassName(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        return className.indexOf(MetadataReservedKeys.PREFIX) == -1 ? stackTraceElement : new StackTraceElement(stripAnonymousPart(className), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }
}
