package org.tinylog.policies;

import java.util.Calendar;

/* JADX INFO: loaded from: classes5.dex */
public final class DailyPolicy extends AbstractDatePolicy {
    public DailyPolicy() {
        this(null);
    }

    public DailyPolicy(String str) {
        super("daily policy", str);
    }

    @Override // org.tinylog.policies.AbstractDatePolicy
    protected void truncate(Calendar calendar, int i, int i2) {
        calendar.set(11, i);
        calendar.set(12, i2);
        calendar.set(13, 0);
        calendar.set(14, 0);
    }

    @Override // org.tinylog.policies.AbstractDatePolicy
    protected void scrollBack(Calendar calendar) {
        calendar.add(5, -1);
    }

    @Override // org.tinylog.policies.AbstractDatePolicy
    protected void scrollAhead(Calendar calendar) {
        calendar.add(5, 1);
    }
}
