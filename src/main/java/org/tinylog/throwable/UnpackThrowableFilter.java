package org.tinylog.throwable;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class UnpackThrowableFilter extends AbstractThrowableFilter {
    public UnpackThrowableFilter() {
        this(null);
    }

    public UnpackThrowableFilter(String str) {
        super(str);
    }

    @Override // org.tinylog.throwable.ThrowableFilter
    public ThrowableData filter(ThrowableData throwableData) {
        ThrowableData cause = throwableData.getCause();
        if (cause != null) {
            List<String> arguments = getArguments();
            if (arguments.isEmpty()) {
                return filter(cause);
            }
            Iterator<String> it = arguments.iterator();
            while (it.hasNext()) {
                if (it.next().equals(throwableData.getClassName())) {
                    return filter(cause);
                }
            }
        }
        return throwableData;
    }
}
