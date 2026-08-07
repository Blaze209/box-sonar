package com.box.android.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: InboxBadgeTextFormatter.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/box/android/utils/InboxBadgeTextFormatter;", "", "<init>", "()V", "formatBadgeText", "", "count", "", "hasMore", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxBadgeTextFormatter {
    public static final int $stable = 0;
    public static final InboxBadgeTextFormatter INSTANCE = new InboxBadgeTextFormatter();

    private InboxBadgeTextFormatter() {
    }

    public static /* synthetic */ String formatBadgeText$default(int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return formatBadgeText(i, z);
    }

    @JvmStatic
    public static final String formatBadgeText(int count, boolean hasMore) {
        if (count <= 0) {
            return null;
        }
        if ((count == 9 && hasMore) || count >= 10) {
            return "9+";
        }
        return String.valueOf(count);
    }
}
