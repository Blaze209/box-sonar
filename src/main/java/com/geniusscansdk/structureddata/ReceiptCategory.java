package com.geniusscansdk.structureddata;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: ReceiptCategory.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000e"}, d2 = {"Lcom/geniusscansdk/structureddata/ReceiptCategory;", "", "<init>", "(Ljava/lang/String;I)V", "GAS", "TRANSPORTATION", "ACCOMMODATION", "RESTAURANT", "SUPERMARKET", "OTHER", "description", "", "getDescription", "()Ljava/lang/String;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum ReceiptCategory {
    GAS,
    TRANSPORTATION,
    ACCOMMODATION,
    RESTAURANT,
    SUPERMARKET,
    OTHER;

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: compiled from: ReceiptCategory.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReceiptCategory.values().length];
            try {
                iArr[ReceiptCategory.GAS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReceiptCategory.TRANSPORTATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ReceiptCategory.ACCOMMODATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ReceiptCategory.RESTAURANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ReceiptCategory.SUPERMARKET.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ReceiptCategory.OTHER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<ReceiptCategory> getEntries() {
        return $ENTRIES;
    }

    public final String getDescription() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "gas";
            case 2:
                return "transportation";
            case 3:
                return "accomodation";
            case 4:
                return "restaurant";
            case 5:
                return "supermarket";
            case 6:
                return "other";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
