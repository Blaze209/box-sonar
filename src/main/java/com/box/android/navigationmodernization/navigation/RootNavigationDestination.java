package com.box.android.navigationmodernization.navigation;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.preview.PreviewSource;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RootNavigationDestination.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination;", "", "<init>", "()V", "InnerDestination", "OuterDestination", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$OuterDestination;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class RootNavigationDestination {
    public static final int $stable = 0;

    public /* synthetic */ RootNavigationDestination(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private RootNavigationDestination() {
    }

    /* JADX INFO: compiled from: RootNavigationDestination.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination;", "<init>", "()V", "HomeScreen", "Search", "NotesSearch", "Inbox", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$HomeScreen;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Inbox;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$NotesSearch;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Search;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class InnerDestination extends RootNavigationDestination {
        public static final int $stable = 0;

        public /* synthetic */ InnerDestination(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: RootNavigationDestination.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$HomeScreen;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HomeScreen extends InnerDestination {
            public static final int $stable = 0;
            public static final HomeScreen INSTANCE = new HomeScreen();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HomeScreen)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -35340195;
            }

            public String toString() {
                return "HomeScreen";
            }

            private HomeScreen() {
                super(null);
            }
        }

        private InnerDestination() {
            super(null);
        }

        /* JADX INFO: compiled from: RootNavigationDestination.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Search;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination;", "<init>", "()V", "Files", "Unified", "Companion", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Search$Companion;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Search$Files;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Search$Unified;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static abstract class Search extends InnerDestination {
            public static final int $stable = 0;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            public /* synthetic */ Search(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Search() {
                super(null);
            }

            /* JADX INFO: compiled from: RootNavigationDestination.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Search$Files;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Search;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final /* data */ class Files extends Search {
                public static final int $stable = 0;
                public static final Files INSTANCE = new Files();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Files)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return -1069089725;
                }

                public String toString() {
                    return "Files";
                }

                private Files() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: RootNavigationDestination.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Search$Unified;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Search;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final /* data */ class Unified extends Search {
                public static final int $stable = 0;
                public static final Unified INSTANCE = new Unified();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Unified)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return -329990050;
                }

                public String toString() {
                    return "Unified";
                }

                private Unified() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: RootNavigationDestination.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Search$Companion;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Search;", "<init>", "()V", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Companion extends Search {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                    super(null);
                }
            }
        }

        /* JADX INFO: compiled from: RootNavigationDestination.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$NotesSearch;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NotesSearch extends InnerDestination {
            public static final int $stable = 0;
            public static final NotesSearch INSTANCE = new NotesSearch();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NotesSearch)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -894464041;
            }

            public String toString() {
                return "NotesSearch";
            }

            private NotesSearch() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: RootNavigationDestination.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination$Inbox;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$InnerDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Inbox extends InnerDestination {
            public static final int $stable = 0;
            public static final Inbox INSTANCE = new Inbox();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Inbox)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1890023148;
            }

            public String toString() {
                return "Inbox";
            }

            private Inbox() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: RootNavigationDestination.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$OuterDestination;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination;", "<init>", "()V", "JobsUI", "Settings", "Item", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$OuterDestination$Item;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$OuterDestination$JobsUI;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$OuterDestination$Settings;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class OuterDestination extends RootNavigationDestination {
        public static final int $stable = 0;

        public /* synthetic */ OuterDestination(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: RootNavigationDestination.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$OuterDestination$JobsUI;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$OuterDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class JobsUI extends OuterDestination {
            public static final int $stable = 0;
            public static final JobsUI INSTANCE = new JobsUI();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof JobsUI)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 333645697;
            }

            public String toString() {
                return "JobsUI";
            }

            private JobsUI() {
                super(null);
            }
        }

        private OuterDestination() {
            super(null);
        }

        /* JADX INFO: compiled from: RootNavigationDestination.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$OuterDestination$Settings;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$OuterDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Settings extends OuterDestination {
            public static final int $stable = 0;
            public static final Settings INSTANCE = new Settings();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Settings)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1543139450;
            }

            public String toString() {
                return "Settings";
            }

            private Settings() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: RootNavigationDestination.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$OuterDestination$Item;", "Lcom/box/android/navigationmodernization/navigation/RootNavigationDestination$OuterDestination;", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "previewSource", "Lcom/box/android/domain/models/preview/PreviewSource;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;Lcom/box/android/domain/models/preview/PreviewSource;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "getPreviewSource", "()Lcom/box/android/domain/models/preview/PreviewSource;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Item extends OuterDestination {
            public static final int $stable = 8;
            private final ItemModel itemModel;
            private final PreviewSource previewSource;

            public static /* synthetic */ Item copy$default(Item item, ItemModel itemModel, PreviewSource previewSource, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = item.itemModel;
                }
                if ((i & 2) != 0) {
                    previewSource = item.previewSource;
                }
                return item.copy(itemModel, previewSource);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final PreviewSource getPreviewSource() {
                return this.previewSource;
            }

            public final Item copy(ItemModel itemModel, PreviewSource previewSource) {
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                Intrinsics.checkNotNullParameter(previewSource, "previewSource");
                return new Item(itemModel, previewSource);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Item)) {
                    return false;
                }
                Item item = (Item) other;
                return Intrinsics.areEqual(this.itemModel, item.itemModel) && Intrinsics.areEqual(this.previewSource, item.previewSource);
            }

            public int hashCode() {
                return (this.itemModel.hashCode() * 31) + this.previewSource.hashCode();
            }

            public String toString() {
                return "Item(itemModel=" + this.itemModel + ", previewSource=" + this.previewSource + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Item(ItemModel itemModel, PreviewSource previewSource) {
                super(null);
                Intrinsics.checkNotNullParameter(itemModel, "itemModel");
                Intrinsics.checkNotNullParameter(previewSource, "previewSource");
                this.itemModel = itemModel;
                this.previewSource = previewSource;
            }

            public final ItemModel getItemModel() {
                return this.itemModel;
            }

            public final PreviewSource getPreviewSource() {
                return this.previewSource;
            }
        }
    }
}
