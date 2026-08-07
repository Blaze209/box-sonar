package com.box.android.data.persistence.inboxnotifications;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotificationSourceConverter.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Lcom/box/android/data/persistence/inboxnotifications/NotificationSourceConverter;", "", "<init>", "()V", "fromNotificationSource", "", "source", "Lcom/box/android/data/persistence/inboxnotifications/NotificationSource;", "toNotificationSource", "value", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotificationSourceConverter {
    public final String fromNotificationSource(NotificationSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return source.name();
    }

    public final NotificationSource toNotificationSource(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return NotificationSource.valueOf(value);
    }
}
