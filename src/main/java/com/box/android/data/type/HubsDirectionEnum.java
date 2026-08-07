package com.box.android.data.type;

import com.apollographql.apollo3.api.EnumType;
import com.box.androidsdk.content.models.BoxOrder;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HubsDirectionEnum.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/box/android/data/type/HubsDirectionEnum;", "", "rawValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", BoxOrder.DIRECTION_DESCENDING, BoxOrder.DIRECTION_ASCENDING, "UNKNOWN__", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public enum HubsDirectionEnum {
    DESC(BoxOrder.DIRECTION_DESCENDING),
    ASC(BoxOrder.DIRECTION_ASCENDING),
    UNKNOWN__("UNKNOWN__");

    private final String rawValue;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final EnumType type = new EnumType("HubsDirectionEnum", CollectionsKt.listOf((Object[]) new String[]{BoxOrder.DIRECTION_DESCENDING, BoxOrder.DIRECTION_ASCENDING}));

    public static EnumEntries<HubsDirectionEnum> getEntries() {
        return $ENTRIES;
    }

    HubsDirectionEnum(String str) {
        this.rawValue = str;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    /* JADX INFO: compiled from: HubsDirectionEnum.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0011\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/type/HubsDirectionEnum$Companion;", "", "<init>", "()V", "type", "Lcom/apollographql/apollo3/api/EnumType;", "getType", "()Lcom/apollographql/apollo3/api/EnumType;", "safeValueOf", "Lcom/box/android/data/type/HubsDirectionEnum;", "rawValue", "", "knownValues", "", "()[Lcom/box/android/data/type/HubsDirectionEnum;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EnumType getType() {
            return HubsDirectionEnum.type;
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0020  */
        /* JADX WARN: Code duplicated, block: B:12:0x0023 A[RETURN] */
        public final HubsDirectionEnum safeValueOf(String rawValue) {
            Intrinsics.checkNotNullParameter(rawValue, "rawValue");
            for (HubsDirectionEnum hubsDirectionEnum : HubsDirectionEnum.values()) {
                if (Intrinsics.areEqual(hubsDirectionEnum.getRawValue(), rawValue)) {
                    if (hubsDirectionEnum == null) {
                        return HubsDirectionEnum.UNKNOWN__;
                    }
                    return hubsDirectionEnum;
                }
            }
            hubsDirectionEnum = null;
            if (hubsDirectionEnum == null) {
                return HubsDirectionEnum.UNKNOWN__;
            }
            return hubsDirectionEnum;
        }

        public final HubsDirectionEnum[] knownValues() {
            return new HubsDirectionEnum[]{HubsDirectionEnum.DESC, HubsDirectionEnum.ASC};
        }
    }
}
