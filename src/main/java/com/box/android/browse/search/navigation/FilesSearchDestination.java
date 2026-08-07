package com.box.android.browse.search.navigation;

import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.androidsdk.content.models.BoxSearchItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FilesSearchDestination.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/box/android/browse/search/navigation/FilesSearchDestination;", "", "<init>", "()V", "InnerDestination", "OuterDestination", "Companion", "Lcom/box/android/browse/search/navigation/FilesSearchDestination$InnerDestination;", "Lcom/box/android/browse/search/navigation/FilesSearchDestination$OuterDestination;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FilesSearchDestination {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ FilesSearchDestination(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private FilesSearchDestination() {
    }

    /* JADX INFO: compiled from: FilesSearchDestination.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/browse/search/navigation/FilesSearchDestination$InnerDestination;", "Lcom/box/android/browse/search/navigation/FilesSearchDestination;", "<init>", "()V", "Search", "Lcom/box/android/browse/search/navigation/FilesSearchDestination$InnerDestination$Search;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class InnerDestination extends FilesSearchDestination {
        public static final int $stable = 0;

        public /* synthetic */ InnerDestination(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FilesSearchDestination.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/browse/search/navigation/FilesSearchDestination$InnerDestination$Search;", "Lcom/box/android/browse/search/navigation/FilesSearchDestination$InnerDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Search extends InnerDestination {
            public static final int $stable = 0;
            public static final Search INSTANCE = new Search();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Search)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1271373288;
            }

            public String toString() {
                return "Search";
            }

            private Search() {
                super(null);
            }
        }

        private InnerDestination() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: FilesSearchDestination.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/browse/search/navigation/FilesSearchDestination$OuterDestination;", "Lcom/box/android/browse/search/navigation/FilesSearchDestination;", "<init>", "()V", "FilesSearchItem", "FilesSearchItemMoreActionsMenu", "Lcom/box/android/browse/search/navigation/FilesSearchDestination$OuterDestination$FilesSearchItem;", "Lcom/box/android/browse/search/navigation/FilesSearchDestination$OuterDestination$FilesSearchItemMoreActionsMenu;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class OuterDestination extends FilesSearchDestination {
        public static final int $stable = 0;

        public /* synthetic */ OuterDestination(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: FilesSearchDestination.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/browse/search/navigation/FilesSearchDestination$OuterDestination$FilesSearchItem;", "Lcom/box/android/browse/search/navigation/FilesSearchDestination$OuterDestination;", "boxSearchItem", "Lcom/box/androidsdk/content/models/BoxSearchItem;", "<init>", "(Lcom/box/androidsdk/content/models/BoxSearchItem;)V", "getBoxSearchItem", "()Lcom/box/androidsdk/content/models/BoxSearchItem;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FilesSearchItem extends OuterDestination {
            public static final int $stable = 8;
            private final BoxSearchItem boxSearchItem;

            public static /* synthetic */ FilesSearchItem copy$default(FilesSearchItem filesSearchItem, BoxSearchItem boxSearchItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    boxSearchItem = filesSearchItem.boxSearchItem;
                }
                return filesSearchItem.copy(boxSearchItem);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxSearchItem getBoxSearchItem() {
                return this.boxSearchItem;
            }

            public final FilesSearchItem copy(BoxSearchItem boxSearchItem) {
                Intrinsics.checkNotNullParameter(boxSearchItem, "boxSearchItem");
                return new FilesSearchItem(boxSearchItem);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FilesSearchItem) && Intrinsics.areEqual(this.boxSearchItem, ((FilesSearchItem) other).boxSearchItem);
            }

            public int hashCode() {
                return this.boxSearchItem.hashCode();
            }

            public String toString() {
                return "FilesSearchItem(boxSearchItem=" + this.boxSearchItem + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FilesSearchItem(BoxSearchItem boxSearchItem) {
                super(null);
                Intrinsics.checkNotNullParameter(boxSearchItem, "boxSearchItem");
                this.boxSearchItem = boxSearchItem;
            }

            public final BoxSearchItem getBoxSearchItem() {
                return this.boxSearchItem;
            }
        }

        private OuterDestination() {
            super(null);
        }

        /* JADX INFO: compiled from: FilesSearchDestination.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/browse/search/navigation/FilesSearchDestination$OuterDestination$FilesSearchItemMoreActionsMenu;", "Lcom/box/android/browse/search/navigation/FilesSearchDestination$OuterDestination;", "boxSearchItem", "Lcom/box/androidsdk/content/models/BoxSearchItem;", "bottomSheetMenuType", "Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "<init>", "(Lcom/box/androidsdk/content/models/BoxSearchItem;Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;)V", "getBoxSearchItem", "()Lcom/box/androidsdk/content/models/BoxSearchItem;", "getBottomSheetMenuType", "()Lcom/box/android/base/presentation/fragments/models/BottomSheetAttributes$BottomSheetMenuType;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FilesSearchItemMoreActionsMenu extends OuterDestination {
            public static final int $stable = 8;
            private final BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType;
            private final BoxSearchItem boxSearchItem;

            public static /* synthetic */ FilesSearchItemMoreActionsMenu copy$default(FilesSearchItemMoreActionsMenu filesSearchItemMoreActionsMenu, BoxSearchItem boxSearchItem, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType, int i, Object obj) {
                if ((i & 1) != 0) {
                    boxSearchItem = filesSearchItemMoreActionsMenu.boxSearchItem;
                }
                if ((i & 2) != 0) {
                    bottomSheetMenuType = filesSearchItemMoreActionsMenu.bottomSheetMenuType;
                }
                return filesSearchItemMoreActionsMenu.copy(boxSearchItem, bottomSheetMenuType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BoxSearchItem getBoxSearchItem() {
                return this.boxSearchItem;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final BottomSheetAttributes.BottomSheetMenuType getBottomSheetMenuType() {
                return this.bottomSheetMenuType;
            }

            public final FilesSearchItemMoreActionsMenu copy(BoxSearchItem boxSearchItem, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType) {
                Intrinsics.checkNotNullParameter(boxSearchItem, "boxSearchItem");
                Intrinsics.checkNotNullParameter(bottomSheetMenuType, "bottomSheetMenuType");
                return new FilesSearchItemMoreActionsMenu(boxSearchItem, bottomSheetMenuType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FilesSearchItemMoreActionsMenu)) {
                    return false;
                }
                FilesSearchItemMoreActionsMenu filesSearchItemMoreActionsMenu = (FilesSearchItemMoreActionsMenu) other;
                return Intrinsics.areEqual(this.boxSearchItem, filesSearchItemMoreActionsMenu.boxSearchItem) && Intrinsics.areEqual(this.bottomSheetMenuType, filesSearchItemMoreActionsMenu.bottomSheetMenuType);
            }

            public int hashCode() {
                return (this.boxSearchItem.hashCode() * 31) + this.bottomSheetMenuType.hashCode();
            }

            public String toString() {
                return "FilesSearchItemMoreActionsMenu(boxSearchItem=" + this.boxSearchItem + ", bottomSheetMenuType=" + this.bottomSheetMenuType + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FilesSearchItemMoreActionsMenu(BoxSearchItem boxSearchItem, BottomSheetAttributes.BottomSheetMenuType bottomSheetMenuType) {
                super(null);
                Intrinsics.checkNotNullParameter(boxSearchItem, "boxSearchItem");
                Intrinsics.checkNotNullParameter(bottomSheetMenuType, "bottomSheetMenuType");
                this.boxSearchItem = boxSearchItem;
                this.bottomSheetMenuType = bottomSheetMenuType;
            }

            public final BottomSheetAttributes.BottomSheetMenuType getBottomSheetMenuType() {
                return this.bottomSheetMenuType;
            }

            public final BoxSearchItem getBoxSearchItem() {
                return this.boxSearchItem;
            }
        }
    }

    /* JADX INFO: compiled from: FilesSearchDestination.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/search/navigation/FilesSearchDestination$Companion;", "", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
