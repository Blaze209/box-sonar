package org.tinylog.throwable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractThrowableFilter implements ThrowableFilter {
    private final List<String> arguments;

    public AbstractThrowableFilter(String str) {
        if (str == null) {
            this.arguments = Collections.emptyList();
            return;
        }
        this.arguments = new ArrayList();
        for (String str2 : str.split("\\|")) {
            String strTrim = str2.trim();
            if (!strTrim.isEmpty()) {
                this.arguments.add(strTrim);
            }
        }
    }

    protected final List<String> getArguments() {
        return this.arguments;
    }
}
