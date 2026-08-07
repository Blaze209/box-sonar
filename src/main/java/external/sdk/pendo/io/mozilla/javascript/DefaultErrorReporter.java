package external.sdk.pendo.io.mozilla.javascript;

/* JADX INFO: loaded from: classes4.dex */
class DefaultErrorReporter implements ErrorReporter {
    static final DefaultErrorReporter instance = new DefaultErrorReporter();
    private ErrorReporter chainedReporter;
    private boolean forEval;

    private DefaultErrorReporter() {
    }

    static ErrorReporter forEval(ErrorReporter errorReporter) {
        DefaultErrorReporter defaultErrorReporter = new DefaultErrorReporter();
        defaultErrorReporter.forEval = true;
        defaultErrorReporter.chainedReporter = errorReporter;
        return defaultErrorReporter;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ErrorReporter
    public void error(String str, String str2, int i, String str3, int i2) {
        String str4;
        if (this.forEval) {
            if (str.startsWith("TypeError: ")) {
                str = str.substring(11);
                str4 = "TypeError";
            } else {
                str4 = "SyntaxError";
            }
            throw ScriptRuntime.constructError(str4, str, str2, i, str3, i2);
        }
        ErrorReporter errorReporter = this.chainedReporter;
        if (errorReporter == null) {
            throw runtimeError(str, str2, i, str3, i2);
        }
        errorReporter.error(str, str2, i, str3, i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ErrorReporter
    public EvaluatorException runtimeError(String str, String str2, int i, String str3, int i2) {
        ErrorReporter errorReporter = this.chainedReporter;
        return errorReporter != null ? errorReporter.runtimeError(str, str2, i, str3, i2) : new EvaluatorException(str, str2, i, str3, i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ErrorReporter
    public void warning(String str, String str2, int i, String str3, int i2) {
        ErrorReporter errorReporter = this.chainedReporter;
        if (errorReporter != null) {
            errorReporter.warning(str, str2, i, str3, i2);
        }
    }
}
