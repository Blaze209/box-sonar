package com.box.android.base.utilities;

import com.box.android.base.R;
import com.box.android.base.models.OfflineBadgeType;
import com.box.android.coreservices.models.BoxModelOfflineManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflineManagerExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0002¨\u0006\u0006"}, d2 = {"getResource", "", "Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;", "(Lcom/box/android/coreservices/models/BoxModelOfflineManager$State;)Ljava/lang/Integer;", "toOfflineBadgeType", "Lcom/box/android/base/models/OfflineBadgeType;", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OfflineManagerExtensionsKt {

    /* JADX INFO: compiled from: OfflineManagerExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BoxModelOfflineManager.State.values().length];
            try {
                iArr[BoxModelOfflineManager.State.OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BoxModelOfflineManager.State.OFFLINE_PENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BoxModelOfflineManager.State.CACHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BoxModelOfflineManager.State.OUT_OF_DATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Integer getResource(BoxModelOfflineManager.State state) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            return Integer.valueOf(R.drawable.ic_circlecheck16_accent);
        }
        if (i == 2) {
            return Integer.valueOf(R.drawable.ic_circlecheck16_inactive);
        }
        if (i == 3) {
            return Integer.valueOf(R.drawable.ic_checkmarkbadge16);
        }
        if (i != 4) {
            return null;
        }
        return Integer.valueOf(R.drawable.ic_circlecheck16_inactive);
    }

    public static final OfflineBadgeType toOfflineBadgeType(BoxModelOfflineManager.State state) {
        Intrinsics.checkNotNullParameter(state, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
        if (i == 1) {
            return OfflineBadgeType.UpToDate.INSTANCE;
        }
        if (i == 2) {
            return OfflineBadgeType.Pending.INSTANCE;
        }
        if (i == 4) {
            return OfflineBadgeType.OutOfDate.INSTANCE;
        }
        return OfflineBadgeType.None.INSTANCE;
    }
}
