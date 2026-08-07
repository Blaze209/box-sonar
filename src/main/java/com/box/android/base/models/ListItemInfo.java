package com.box.android.base.models;

import com.box.android.base.compose.ItemThumbnail;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: BoxListViewItemModels.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u001b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\tHÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003J\t\u0010$\u001a\u00020\u000bHÆ\u0003JY\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000bHÆ\u0001J\u0013\u0010&\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019¨\u0006+"}, d2 = {"Lcom/box/android/base/models/ListItemInfo;", "", "name", "", "itemThumbnail", "Lcom/box/android/base/compose/ItemThumbnail;", "footerDescription", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "offlineBadgeType", "Lcom/box/android/base/models/OfflineBadgeType;", "isInCollections", "", "commentsCount", "", "hasSharedLink", "<init>", "(Ljava/lang/String;Lcom/box/android/base/compose/ItemThumbnail;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/base/models/OfflineBadgeType;ZJZ)V", "getName", "()Ljava/lang/String;", "getItemThumbnail", "()Lcom/box/android/base/compose/ItemThumbnail;", "getFooterDescription", "getTestTag", "getOfflineBadgeType", "()Lcom/box/android/base/models/OfflineBadgeType;", "()Z", "getCommentsCount", "()J", "getHasSharedLink", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ListItemInfo {
    public static final int $stable = 0;
    private final long commentsCount;
    private final String footerDescription;
    private final boolean hasSharedLink;
    private final boolean isInCollections;
    private final ItemThumbnail itemThumbnail;
    private final String name;
    private final OfflineBadgeType offlineBadgeType;
    private final String testTag;

    public static /* synthetic */ ListItemInfo copy$default(ListItemInfo listItemInfo, String str, ItemThumbnail itemThumbnail, String str2, String str3, OfflineBadgeType offlineBadgeType, boolean z, long j, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = listItemInfo.name;
        }
        if ((i & 2) != 0) {
            itemThumbnail = listItemInfo.itemThumbnail;
        }
        if ((i & 4) != 0) {
            str2 = listItemInfo.footerDescription;
        }
        if ((i & 8) != 0) {
            str3 = listItemInfo.testTag;
        }
        if ((i & 16) != 0) {
            offlineBadgeType = listItemInfo.offlineBadgeType;
        }
        if ((i & 32) != 0) {
            z = listItemInfo.isInCollections;
        }
        if ((i & 64) != 0) {
            j = listItemInfo.commentsCount;
        }
        if ((i & 128) != 0) {
            z2 = listItemInfo.hasSharedLink;
        }
        boolean z3 = z2;
        long j2 = j;
        OfflineBadgeType offlineBadgeType2 = offlineBadgeType;
        boolean z4 = z;
        return listItemInfo.copy(str, itemThumbnail, str2, str3, offlineBadgeType2, z4, j2, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ItemThumbnail getItemThumbnail() {
        return this.itemThumbnail;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFooterDescription() {
        return this.footerDescription;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getTestTag() {
        return this.testTag;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final OfflineBadgeType getOfflineBadgeType() {
        return this.offlineBadgeType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsInCollections() {
        return this.isInCollections;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final long getCommentsCount() {
        return this.commentsCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getHasSharedLink() {
        return this.hasSharedLink;
    }

    public final ListItemInfo copy(String name, ItemThumbnail itemThumbnail, String footerDescription, String testTag, OfflineBadgeType offlineBadgeType, boolean isInCollections, long commentsCount, boolean hasSharedLink) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(itemThumbnail, "itemThumbnail");
        Intrinsics.checkNotNullParameter(footerDescription, "footerDescription");
        Intrinsics.checkNotNullParameter(testTag, "testTag");
        Intrinsics.checkNotNullParameter(offlineBadgeType, "offlineBadgeType");
        return new ListItemInfo(name, itemThumbnail, footerDescription, testTag, offlineBadgeType, isInCollections, commentsCount, hasSharedLink);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ListItemInfo)) {
            return false;
        }
        ListItemInfo listItemInfo = (ListItemInfo) other;
        return Intrinsics.areEqual(this.name, listItemInfo.name) && Intrinsics.areEqual(this.itemThumbnail, listItemInfo.itemThumbnail) && Intrinsics.areEqual(this.footerDescription, listItemInfo.footerDescription) && Intrinsics.areEqual(this.testTag, listItemInfo.testTag) && Intrinsics.areEqual(this.offlineBadgeType, listItemInfo.offlineBadgeType) && this.isInCollections == listItemInfo.isInCollections && this.commentsCount == listItemInfo.commentsCount && this.hasSharedLink == listItemInfo.hasSharedLink;
    }

    public int hashCode() {
        return (((((((((((((this.name.hashCode() * 31) + this.itemThumbnail.hashCode()) * 31) + this.footerDescription.hashCode()) * 31) + this.testTag.hashCode()) * 31) + this.offlineBadgeType.hashCode()) * 31) + Boolean.hashCode(this.isInCollections)) * 31) + Long.hashCode(this.commentsCount)) * 31) + Boolean.hashCode(this.hasSharedLink);
    }

    public String toString() {
        return "ListItemInfo(name=" + this.name + ", itemThumbnail=" + this.itemThumbnail + ", footerDescription=" + this.footerDescription + ", testTag=" + this.testTag + ", offlineBadgeType=" + this.offlineBadgeType + ", isInCollections=" + this.isInCollections + ", commentsCount=" + this.commentsCount + ", hasSharedLink=" + this.hasSharedLink + ")";
    }

    public ListItemInfo(String name, ItemThumbnail itemThumbnail, String footerDescription, String testTag, OfflineBadgeType offlineBadgeType, boolean z, long j, boolean z2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(itemThumbnail, "itemThumbnail");
        Intrinsics.checkNotNullParameter(footerDescription, "footerDescription");
        Intrinsics.checkNotNullParameter(testTag, "testTag");
        Intrinsics.checkNotNullParameter(offlineBadgeType, "offlineBadgeType");
        this.name = name;
        this.itemThumbnail = itemThumbnail;
        this.footerDescription = footerDescription;
        this.testTag = testTag;
        this.offlineBadgeType = offlineBadgeType;
        this.isInCollections = z;
        this.commentsCount = j;
        this.hasSharedLink = z2;
    }

    public final String getName() {
        return this.name;
    }

    public final ItemThumbnail getItemThumbnail() {
        return this.itemThumbnail;
    }

    public final String getFooterDescription() {
        return this.footerDescription;
    }

    public final String getTestTag() {
        return this.testTag;
    }

    public /* synthetic */ ListItemInfo(String str, ItemThumbnail itemThumbnail, String str2, String str3, OfflineBadgeType offlineBadgeType, boolean z, long j, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, itemThumbnail, str2, str3, (i & 16) != 0 ? OfflineBadgeType.None.INSTANCE : offlineBadgeType, (i & 32) != 0 ? false : z, (i & 64) != 0 ? 0L : j, (i & 128) != 0 ? false : z2);
    }

    public final OfflineBadgeType getOfflineBadgeType() {
        return this.offlineBadgeType;
    }

    public final boolean isInCollections() {
        return this.isInCollections;
    }

    public final long getCommentsCount() {
        return this.commentsCount;
    }

    public final boolean getHasSharedLink() {
        return this.hasSharedLink;
    }
}
