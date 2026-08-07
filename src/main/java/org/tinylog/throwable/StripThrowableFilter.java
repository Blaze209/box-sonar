package org.tinylog.throwable;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class StripThrowableFilter extends AbstractStackTraceElementsFilter {
    public StripThrowableFilter() {
        this(null);
    }

    public StripThrowableFilter(String str) {
        super(str);
    }

    @Override // org.tinylog.throwable.AbstractStackTraceElementsFilter
    protected boolean shouldKept(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (match(str, it.next())) {
                return false;
            }
        }
        return true;
    }
}
