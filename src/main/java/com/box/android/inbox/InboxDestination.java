package com.box.android.inbox;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: InboxDestination.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/inbox/InboxDestination;", "", "<init>", "()V", com.swmansion.rnscreens.gamma.tabs.screen.TabsScreen.TAG, "Companion", "Lcom/box/android/inbox/InboxDestination$TabsScreen;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class InboxDestination {
    public static final int $stable = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ InboxDestination(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private InboxDestination() {
    }

    /* JADX INFO: compiled from: InboxDestination.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/box/android/inbox/InboxDestination$TabsScreen;", "Lcom/box/android/inbox/InboxDestination;", "tabs", "", "Lcom/box/android/inbox/InboxDestination$TabsScreen$InboxTab;", "startTab", "<init>", "(Ljava/util/List;Lcom/box/android/inbox/InboxDestination$TabsScreen$InboxTab;)V", "getTabs", "()Ljava/util/List;", "getStartTab", "()Lcom/box/android/inbox/InboxDestination$TabsScreen$InboxTab;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "InboxTab", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class TabsScreen extends InboxDestination {
        public static final int $stable = 8;
        private final InboxTab startTab;
        private final List<InboxTab> tabs;

        /* JADX INFO: compiled from: InboxDestination.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/inbox/InboxDestination$TabsScreen$InboxTab;", "", "<init>", "(Ljava/lang/String;I)V", "Notifications", "MyTasks", "SentTasks", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public enum InboxTab {
            Notifications,
            MyTasks,
            SentTasks;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            public static EnumEntries<InboxTab> getEntries() {
                return $ENTRIES;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ TabsScreen copy$default(TabsScreen tabsScreen, List list, InboxTab inboxTab, int i, Object obj) {
            if ((i & 1) != 0) {
                list = tabsScreen.tabs;
            }
            if ((i & 2) != 0) {
                inboxTab = tabsScreen.startTab;
            }
            return tabsScreen.copy(list, inboxTab);
        }

        public final List<InboxTab> component1() {
            return this.tabs;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final InboxTab getStartTab() {
            return this.startTab;
        }

        public final TabsScreen copy(List<? extends InboxTab> tabs, InboxTab startTab) {
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
        public TabsScreen(List<? extends InboxTab> tabs, InboxTab startTab) {
            super(null);
            Intrinsics.checkNotNullParameter(tabs, "tabs");
            Intrinsics.checkNotNullParameter(startTab, "startTab");
            this.tabs = tabs;
            this.startTab = startTab;
        }

        public final InboxTab getStartTab() {
            return this.startTab;
        }

        public final List<InboxTab> getTabs() {
            return this.tabs;
        }
    }

    /* JADX INFO: compiled from: InboxDestination.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/inbox/InboxDestination$Companion;", "", "<init>", "()V", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
