package com.swmansion.rnscreens.gamma.stack.header.subview;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: StackHeaderSubviewCollapseMode.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\bj\u0002\b\u0004j\u0002\b\u0005¨\u0006\t"}, d2 = {"Lcom/swmansion/rnscreens/gamma/stack/header/subview/StackHeaderSubviewCollapseMode;", "", "<init>", "(Ljava/lang/String;I)V", "OFF", "PARALLAX", "toNativeCollapseMode", "", "toNativeCollapseMode$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum StackHeaderSubviewCollapseMode {
    OFF,
    PARALLAX;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: compiled from: StackHeaderSubviewCollapseMode.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StackHeaderSubviewCollapseMode.values().length];
            try {
                iArr[StackHeaderSubviewCollapseMode.OFF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StackHeaderSubviewCollapseMode.PARALLAX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<StackHeaderSubviewCollapseMode> getEntries() {
        return $ENTRIES;
    }

    public final int toNativeCollapseMode$react_native_screens_release() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
