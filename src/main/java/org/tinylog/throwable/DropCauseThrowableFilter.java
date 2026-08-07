package org.tinylog.throwable;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public final class DropCauseThrowableFilter extends AbstractThrowableFilter {
    public DropCauseThrowableFilter() {
        this(null);
    }

    public DropCauseThrowableFilter(String str) {
        super(str);
    }

    @Override // org.tinylog.throwable.ThrowableFilter
    public ThrowableData filter(ThrowableData throwableData) {
        if (getArguments().isEmpty()) {
            return new ThrowableStore(throwableData.getClassName(), throwableData.getMessage(), throwableData.getStackTrace(), null);
        }
        String className = throwableData.getClassName();
        Iterator<String> it = getArguments().iterator();
        while (it.hasNext()) {
            if (className.equals(it.next())) {
                return new ThrowableStore(throwableData.getClassName(), throwableData.getMessage(), throwableData.getStackTrace(), null);
            }
        }
        return throwableData;
    }
}
