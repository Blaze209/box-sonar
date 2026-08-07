package external.sdk.pendo.io.mozilla.javascript.tools;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.EcmaError;
import external.sdk.pendo.io.mozilla.javascript.ErrorReporter;
import external.sdk.pendo.io.mozilla.javascript.EvaluatorException;
import external.sdk.pendo.io.mozilla.javascript.JavaScriptException;
import external.sdk.pendo.io.mozilla.javascript.RhinoException;
import external.sdk.pendo.io.mozilla.javascript.SecurityUtilities;
import external.sdk.pendo.io.mozilla.javascript.WrappedException;
import java.io.PrintStream;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* JADX INFO: loaded from: classes4.dex */
public class ToolErrorReporter implements ErrorReporter {
    private static final String messagePrefix = "js: ";
    private PrintStream err;
    private boolean hasReportedErrorFlag;
    private boolean reportWarnings;

    public ToolErrorReporter(boolean z) {
        this(z, System.err);
    }

    private String buildIndicator(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i - 1; i2++) {
            sb.append(".");
        }
        sb.append("^");
        return sb.toString();
    }

    private static String getExceptionMessage(RhinoException rhinoException) {
        String strDetails;
        String str;
        if (rhinoException instanceof JavaScriptException) {
            strDetails = rhinoException.details();
            str = "msg.uncaughtJSException";
        } else {
            if (!(rhinoException instanceof EcmaError)) {
                return rhinoException instanceof EvaluatorException ? rhinoException.details() : rhinoException.toString();
            }
            strDetails = rhinoException.details();
            str = "msg.uncaughtEcmaError";
        }
        return getMessage(str, strDetails);
    }

    public static String getMessage(String str) {
        return getMessage(str, (Object[]) null);
    }

    private void reportErrorMessage(String str, String str2, int i, String str3, int i2, boolean z) {
        String message;
        if (i > 0) {
            String strValueOf = String.valueOf(i);
            message = str2 != null ? getMessage("msg.format3", new Object[]{str2, strValueOf, str}) : getMessage("msg.format2", new Object[]{strValueOf, str});
        } else {
            message = getMessage("msg.format1", new Object[]{str});
        }
        if (z) {
            message = getMessage("msg.warning", message);
        }
        this.err.println(messagePrefix + message);
        if (str3 != null) {
            this.err.println(messagePrefix + str3);
            this.err.println(messagePrefix + buildIndicator(i2));
        }
    }

    public static void reportException(ErrorReporter errorReporter, RhinoException rhinoException) {
        if (errorReporter instanceof ToolErrorReporter) {
            ((ToolErrorReporter) errorReporter).reportException(rhinoException);
        } else {
            errorReporter.error(getExceptionMessage(rhinoException), rhinoException.sourceName(), rhinoException.lineNumber(), rhinoException.lineSource(), rhinoException.columnNumber());
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ErrorReporter
    public void error(String str, String str2, int i, String str3, int i2) {
        this.hasReportedErrorFlag = true;
        reportErrorMessage(str, str2, i, str3, i2, false);
    }

    public boolean hasReportedError() {
        return this.hasReportedErrorFlag;
    }

    public boolean isReportingWarnings() {
        return this.reportWarnings;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ErrorReporter
    public EvaluatorException runtimeError(String str, String str2, int i, String str3, int i2) {
        return new EvaluatorException(str, str2, i, str3, i2);
    }

    public void setIsReportingWarnings(boolean z) {
        this.reportWarnings = z;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ErrorReporter
    public void warning(String str, String str2, int i, String str3, int i2) {
        if (this.reportWarnings) {
            reportErrorMessage(str, str2, i, str3, i2, true);
        }
    }

    public ToolErrorReporter(boolean z, PrintStream printStream) {
        this.reportWarnings = z;
        this.err = printStream;
    }

    public static String getMessage(String str, Object obj, Object obj2) {
        return getMessage(str, new Object[]{obj, obj2});
    }

    public void reportException(RhinoException rhinoException) {
        if (rhinoException instanceof WrappedException) {
            ((WrappedException) rhinoException).printStackTrace(this.err);
        } else {
            reportErrorMessage(getExceptionMessage(rhinoException) + SecurityUtilities.getSystemProperty("line.separator") + rhinoException.getScriptStackTrace(), rhinoException.sourceName(), rhinoException.lineNumber(), rhinoException.lineSource(), rhinoException.columnNumber(), false);
        }
    }

    public static String getMessage(String str, String str2) {
        return getMessage(str, new Object[]{str2});
    }

    public static String getMessage(String str, Object[] objArr) {
        Context currentContext = Context.getCurrentContext();
        try {
            String string = ResourceBundle.getBundle("external.sdk.pendo.io.mozilla.javascript.tools.resources.Messages", currentContext == null ? Locale.getDefault() : currentContext.getLocale()).getString(str);
            return objArr == null ? string : new MessageFormat(string).format(objArr);
        } catch (MissingResourceException unused) {
            throw new RuntimeException("no message resource found for message property " + str);
        }
    }
}
