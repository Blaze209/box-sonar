package org.tinylog.pattern;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.tinylog.core.LogEntry;
import org.tinylog.core.LogEntryValue;
import org.tinylog.throwable.ThrowableData;
import org.tinylog.throwable.ThrowableFilter;
import org.tinylog.throwable.ThrowableWrapper;

/* JADX INFO: loaded from: classes5.dex */
final class ExceptionToken implements Token {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private final List<ThrowableFilter> filters;

    ExceptionToken(List<ThrowableFilter> list) {
        this.filters = list;
    }

    @Override // org.tinylog.pattern.Token
    public Collection<LogEntryValue> getRequiredLogEntryValues() {
        return Collections.singleton(LogEntryValue.EXCEPTION);
    }

    @Override // org.tinylog.pattern.Token
    public void render(LogEntry logEntry, StringBuilder sb) {
        Throwable exception = logEntry.getException();
        if (exception != null) {
            render(filter(exception), Collections.emptyList(), sb);
        }
    }

    @Override // org.tinylog.pattern.Token
    public void apply(LogEntry logEntry, PreparedStatement preparedStatement, int i) throws SQLException {
        Throwable exception = logEntry.getException();
        if (exception == null) {
            preparedStatement.setString(i, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        render(filter(exception), Collections.emptyList(), sb);
        preparedStatement.setString(i, sb.toString());
    }

    private ThrowableData filter(Throwable th) {
        ThrowableData throwableWrapper = new ThrowableWrapper(th);
        Iterator<ThrowableFilter> it = this.filters.iterator();
        while (it.hasNext()) {
            throwableWrapper = it.next().filter(throwableWrapper);
        }
        return throwableWrapper;
    }

    private void render(ThrowableData throwableData, List<StackTraceElement> list, StringBuilder sb) {
        List<StackTraceElement> stackTrace = throwableData.getStackTrace();
        int size = list.size() - 1;
        int size2 = stackTrace.size() - 1;
        int i = 0;
        while (size >= 0 && size2 >= 0 && list.get(size).equals(stackTrace.get(size2))) {
            size--;
            size2--;
            i++;
        }
        sb.append(throwableData.getClassName());
        String message = throwableData.getMessage();
        if (message != null) {
            sb.append(": ");
            sb.append(message);
        }
        for (int i2 = 0; i2 < stackTrace.size() - i; i2++) {
            sb.append(NEW_LINE);
            sb.append("\tat ");
            sb.append(stackTrace.get(i2));
        }
        if (i > 0) {
            sb.append(NEW_LINE);
            sb.append("\t... ");
            sb.append(i);
            sb.append(" more");
        }
        ThrowableData cause = throwableData.getCause();
        if (cause != null) {
            sb.append(NEW_LINE);
            sb.append("Caused by: ");
            render(cause, stackTrace, sb);
        }
    }
}
