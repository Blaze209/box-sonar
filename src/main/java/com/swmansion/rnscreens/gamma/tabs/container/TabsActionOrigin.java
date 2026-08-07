package com.swmansion.rnscreens.gamma.tabs.container;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: TabsActionOrigin.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\t"}, d2 = {"Lcom/swmansion/rnscreens/gamma/tabs/container/TabsActionOrigin;", "", "<init>", "(Ljava/lang/String;I)V", "USER", "PROGRAMMATIC_JS", "PROGRAMMATIC_NATIVE", "toString", "", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum TabsActionOrigin {
    USER,
    PROGRAMMATIC_JS,
    PROGRAMMATIC_NATIVE;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: compiled from: TabsActionOrigin.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TabsActionOrigin.values().length];
            try {
                iArr[TabsActionOrigin.USER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TabsActionOrigin.PROGRAMMATIC_JS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TabsActionOrigin.PROGRAMMATIC_NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<TabsActionOrigin> getEntries() {
        return $ENTRIES;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return "user";
        }
        if (i == 2) {
            return "programmatic-js";
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "programmatic-native";
    }
}
