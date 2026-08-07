package com.box.android.common.utilities;

import kotlin.Metadata;

/* JADX INFO: compiled from: Clock.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/box/android/common/utilities/SystemClock;", "Lcom/box/android/common/utilities/Clock;", "<init>", "()V", "currentTimeMillis", "", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SystemClock implements Clock {
    public static final SystemClock INSTANCE = new SystemClock();

    private SystemClock() {
    }

    @Override // com.box.android.common.utilities.Clock
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
