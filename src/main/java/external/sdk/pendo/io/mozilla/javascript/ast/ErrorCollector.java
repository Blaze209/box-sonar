package external.sdk.pendo.io.mozilla.javascript.ast;

import external.sdk.pendo.io.mozilla.javascript.EvaluatorException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ErrorCollector implements IdeErrorReporter {
    private List<ParseProblem> errors = new ArrayList();

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.IdeErrorReporter
    public void error(String str, String str2, int i, int i2) {
        this.errors.add(new ParseProblem(ParseProblem.Type.Error, str, str2, i, i2));
    }

    public List<ParseProblem> getErrors() {
        return this.errors;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ErrorReporter
    public EvaluatorException runtimeError(String str, String str2, int i, String str3, int i2) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.errors.size() * 100);
        Iterator<ParseProblem> it = this.errors.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString()).append("\n");
        }
        return sb.toString();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ast.IdeErrorReporter
    public void warning(String str, String str2, int i, int i2) {
        this.errors.add(new ParseProblem(ParseProblem.Type.Warning, str, str2, i, i2));
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ErrorReporter
    public void error(String str, String str2, int i, String str3, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ErrorReporter
    public void warning(String str, String str2, int i, String str3, int i2) {
        throw new UnsupportedOperationException();
    }
}
