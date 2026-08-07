package com.box.android.notes.navigationmodernization;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesDestination.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/box/android/notes/navigationmodernization/NotesDestination;", "", "<init>", "()V", "InnerDestination", "OuterDestination", "Companion", "Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination;", "Lcom/box/android/notes/navigationmodernization/NotesDestination$OuterDestination;", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class NotesDestination {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ NotesDestination(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private NotesDestination() {
    }

    /* JADX INFO: compiled from: NotesDestination.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination;", "Lcom/box/android/notes/navigationmodernization/NotesDestination;", "<init>", "()V", com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen.TAG, "Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen;", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class InnerDestination extends NotesDestination {
        public static final int $stable = 0;

        public /* synthetic */ InnerDestination(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: NotesDestination.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen;", "Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination;", "tabs", "", "Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;", "startTab", "<init>", "(Ljava/util/List;Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;)V", "getTabs", "()Ljava/util/List;", "getStartTab", "()Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "NotesTab", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TabsScreen extends InnerDestination {
            public static final int $stable = 8;
            private final NotesTab startTab;
            private final List<NotesTab> tabs;

            /* JADX INFO: compiled from: NotesDestination.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;", "", "<init>", "(Ljava/lang/String;I)V", "RecentsTab", "FavoritesTab", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public enum NotesTab {
                RecentsTab,
                FavoritesTab;

                private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

                public static EnumEntries<NotesTab> getEntries() {
                    return $ENTRIES;
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ TabsScreen copy$default(TabsScreen tabsScreen, List list, NotesTab notesTab, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = tabsScreen.tabs;
                }
                if ((i & 2) != 0) {
                    notesTab = tabsScreen.startTab;
                }
                return tabsScreen.copy(list, notesTab);
            }

            public final List<NotesTab> component1() {
                return this.tabs;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final NotesTab getStartTab() {
                return this.startTab;
            }

            public final TabsScreen copy(List<? extends NotesTab> tabs, NotesTab startTab) {
                Intrinsics.checkNotNullParameter(tabs, "tabs");
                Intrinsics.checkNotNullParameter(startTab, "startTab");
                return new TabsScreen(tabs, startTab);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TabsScreen)) {
                    return false;
                }
                TabsScreen tabsScreen = (TabsScreen) other;
                return Intrinsics.areEqual(this.tabs, tabsScreen.tabs) && this.startTab == tabsScreen.startTab;
            }

            public int hashCode() {
                return (this.tabs.hashCode() * 31) + this.startTab.hashCode();
            }

            public String toString() {
                return "TabsScreen(tabs=" + this.tabs + ", startTab=" + this.startTab + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public TabsScreen(List<? extends NotesTab> tabs, NotesTab startTab) {
                super(null);
                Intrinsics.checkNotNullParameter(tabs, "tabs");
                Intrinsics.checkNotNullParameter(startTab, "startTab");
                this.tabs = tabs;
                this.startTab = startTab;
            }

            public final NotesTab getStartTab() {
                return this.startTab;
            }

            public final List<NotesTab> getTabs() {
                return this.tabs;
            }
        }

        private InnerDestination() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: NotesDestination.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/notes/navigationmodernization/NotesDestination$OuterDestination;", "Lcom/box/android/notes/navigationmodernization/NotesDestination;", "<init>", "()V", "NewNote", "Lcom/box/android/notes/navigationmodernization/NotesDestination$OuterDestination$NewNote;", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class OuterDestination extends NotesDestination {
        public static final int $stable = 0;

        public /* synthetic */ OuterDestination(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: NotesDestination.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/navigationmodernization/NotesDestination$OuterDestination$NewNote;", "Lcom/box/android/notes/navigationmodernization/NotesDestination$OuterDestination;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NewNote extends OuterDestination {
            public static final int $stable = 0;
            public static final NewNote INSTANCE = new NewNote();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NewNote)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 887693855;
            }

            public String toString() {
                return "NewNote";
            }

            private NewNote() {
                super(null);
            }
        }

        private OuterDestination() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: NotesDestination.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/notes/navigationmodernization/NotesDestination$Companion;", "", "<init>", "()V", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
