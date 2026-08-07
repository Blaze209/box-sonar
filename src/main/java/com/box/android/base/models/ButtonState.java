package com.box.android.base.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ButtonState.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\n"}, d2 = {"Lcom/box/android/base/models/ButtonState;", "", "<init>", "(Ljava/lang/String;I)V", "ENABLED", "DISABLED", "HIDDEN", "isEnabled", "", "isVisible", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum ButtonState {
    ENABLED,
    DISABLED,
    HIDDEN;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    public static EnumEntries<ButtonState> getEntries() {
        return $ENTRIES;
    }

    public final boolean isEnabled() {
        return this == ENABLED;
    }

    public final boolean isVisible() {
        return this != HIDDEN;
    }
}
