package org.tinylog.throwable;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractStackTraceElementsFilter extends AbstractThrowableFilter {
    protected abstract boolean shouldKept(String str, List<String> list);

    public AbstractStackTraceElementsFilter(String str) {
        super(str);
    }

    @Override // org.tinylog.throwable.ThrowableFilter
    public ThrowableData filter(ThrowableData throwableData) {
        List<StackTraceElement> stackTrace = throwableData.getStackTrace();
        ArrayList arrayList = new ArrayList(stackTrace.size());
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (shouldKept(stackTraceElement.getClassName(), getArguments())) {
                arrayList.add(stackTraceElement);
            }
        }
        ThrowableData cause = throwableData.getCause();
        if (cause != null) {
            cause = filter(cause);
        }
        return new ThrowableStore(throwableData.getClassName(), throwableData.getMessage(), arrayList, cause);
    }

    protected boolean match(String str, String str2) {
        if (str.startsWith(str2)) {
            return str2.length() == str.length() || str.charAt(str2.length()) == '.';
        }
        return false;
    }
}
