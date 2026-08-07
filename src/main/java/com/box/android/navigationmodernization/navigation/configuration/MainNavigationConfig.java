package com.box.android.navigationmodernization.navigation.configuration;

import com.box.android.browse.cpl.navigationmodernization.BrowseNavigationConfig;
import com.box.android.collections.presentation.navigationmodernization.navigation.CollectionsNavigationConfig;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.inbox.InboxNavigationConfig;
import com.box.android.navigationmodernization.homescreen.navigation.HomeNavigationBarDestination;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainNavigationConfig.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig;", "", "<init>", "()V", "Home", "Inbox", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig$Home;", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig$Inbox;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class MainNavigationConfig {
    public static final int $stable = 0;

    public /* synthetic */ MainNavigationConfig(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MainNavigationConfig() {
    }

    /* JADX INFO: compiled from: MainNavigationConfig.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003J7\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig$Home;", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig;", "homeGraph", "Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "browseNavigationConfig", "Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigationConfig;", "collectionsNavigationConfig", "Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigationConfig;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigationConfig;Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigationConfig;Lcom/box/android/domain/models/DomainError;)V", "getHomeGraph", "()Lcom/box/android/navigationmodernization/homescreen/navigation/HomeNavigationBarDestination;", "getBrowseNavigationConfig", "()Lcom/box/android/browse/cpl/navigationmodernization/BrowseNavigationConfig;", "getCollectionsNavigationConfig", "()Lcom/box/android/collections/presentation/navigationmodernization/navigation/CollectionsNavigationConfig;", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Home extends MainNavigationConfig {
        public static final int $stable = 8;
        private final BrowseNavigationConfig browseNavigationConfig;
        private final CollectionsNavigationConfig collectionsNavigationConfig;
        private final DomainError error;
        private final HomeNavigationBarDestination homeGraph;

        public static /* synthetic */ Home copy$default(Home home, HomeNavigationBarDestination homeNavigationBarDestination, BrowseNavigationConfig browseNavigationConfig, CollectionsNavigationConfig collectionsNavigationConfig, DomainError domainError, int i, Object obj) {
            if ((i & 1) != 0) {
                homeNavigationBarDestination = home.homeGraph;
            }
            if ((i & 2) != 0) {
                browseNavigationConfig = home.browseNavigationConfig;
            }
            if ((i & 4) != 0) {
                collectionsNavigationConfig = home.collectionsNavigationConfig;
            }
            if ((i & 8) != 0) {
                domainError = home.error;
            }
            return home.copy(homeNavigationBarDestination, browseNavigationConfig, collectionsNavigationConfig, domainError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final HomeNavigationBarDestination getHomeGraph() {
            return this.homeGraph;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final BrowseNavigationConfig getBrowseNavigationConfig() {
            return this.browseNavigationConfig;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CollectionsNavigationConfig getCollectionsNavigationConfig() {
            return this.collectionsNavigationConfig;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final DomainError getError() {
            return this.error;
        }

        public final Home copy(HomeNavigationBarDestination homeGraph, BrowseNavigationConfig browseNavigationConfig, CollectionsNavigationConfig collectionsNavigationConfig, DomainError error) {
            Intrinsics.checkNotNullParameter(homeGraph, "homeGraph");
            return new Home(homeGraph, browseNavigationConfig, collectionsNavigationConfig, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Home)) {
                return false;
            }
            Home home = (Home) other;
            return Intrinsics.areEqual(this.homeGraph, home.homeGraph) && Intrinsics.areEqual(this.browseNavigationConfig, home.browseNavigationConfig) && Intrinsics.areEqual(this.collectionsNavigationConfig, home.collectionsNavigationConfig) && Intrinsics.areEqual(this.error, home.error);
        }

        public int hashCode() {
            int iHashCode = this.homeGraph.hashCode() * 31;
            BrowseNavigationConfig browseNavigationConfig = this.browseNavigationConfig;
            int iHashCode2 = (iHashCode + (browseNavigationConfig == null ? 0 : browseNavigationConfig.hashCode())) * 31;
            CollectionsNavigationConfig collectionsNavigationConfig = this.collectionsNavigationConfig;
            int iHashCode3 = (iHashCode2 + (collectionsNavigationConfig == null ? 0 : collectionsNavigationConfig.hashCode())) * 31;
            DomainError domainError = this.error;
            return iHashCode3 + (domainError != null ? domainError.hashCode() : 0);
        }

        public String toString() {
            return "Home(homeGraph=" + this.homeGraph + ", browseNavigationConfig=" + this.browseNavigationConfig + ", collectionsNavigationConfig=" + this.collectionsNavigationConfig + ", error=" + this.error + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Home(HomeNavigationBarDestination homeGraph, BrowseNavigationConfig browseNavigationConfig, CollectionsNavigationConfig collectionsNavigationConfig, DomainError domainError) {
            super(null);
            Intrinsics.checkNotNullParameter(homeGraph, "homeGraph");
            this.homeGraph = homeGraph;
            this.browseNavigationConfig = browseNavigationConfig;
            this.collectionsNavigationConfig = collectionsNavigationConfig;
            this.error = domainError;
        }

        public /* synthetic */ Home(HomeNavigationBarDestination homeNavigationBarDestination, BrowseNavigationConfig browseNavigationConfig, CollectionsNavigationConfig collectionsNavigationConfig, DomainError domainError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(homeNavigationBarDestination, (i & 2) != 0 ? null : browseNavigationConfig, (i & 4) != 0 ? null : collectionsNavigationConfig, (i & 8) != 0 ? null : domainError);
        }

        public final HomeNavigationBarDestination getHomeGraph() {
            return this.homeGraph;
        }

        public final BrowseNavigationConfig getBrowseNavigationConfig() {
            return this.browseNavigationConfig;
        }

        public final CollectionsNavigationConfig getCollectionsNavigationConfig() {
            return this.collectionsNavigationConfig;
        }

        public final DomainError getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: MainNavigationConfig.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig$Inbox;", "Lcom/box/android/navigationmodernization/navigation/configuration/MainNavigationConfig;", "inboxNavigationConfig", "Lcom/box/android/inbox/InboxNavigationConfig;", "<init>", "(Lcom/box/android/inbox/InboxNavigationConfig;)V", "getInboxNavigationConfig", "()Lcom/box/android/inbox/InboxNavigationConfig;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class Inbox extends MainNavigationConfig {
        public static final int $stable = 8;
        private final InboxNavigationConfig inboxNavigationConfig;

        public static /* synthetic */ Inbox copy$default(Inbox inbox, InboxNavigationConfig inboxNavigationConfig, int i, Object obj) {
            if ((i & 1) != 0) {
                inboxNavigationConfig = inbox.inboxNavigationConfig;
            }
            return inbox.copy(inboxNavigationConfig);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final InboxNavigationConfig getInboxNavigationConfig() {
            return this.inboxNavigationConfig;
        }

        public final Inbox copy(InboxNavigationConfig inboxNavigationConfig) {
            Intrinsics.checkNotNullParameter(inboxNavigationConfig, "inboxNavigationConfig");
            return new Inbox(inboxNavigationConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Inbox) && Intrinsics.areEqual(this.inboxNavigationConfig, ((Inbox) other).inboxNavigationConfig);
        }

        public int hashCode() {
            return this.inboxNavigationConfig.hashCode();
        }

        public String toString() {
            return "Inbox(inboxNavigationConfig=" + this.inboxNavigationConfig + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Inbox(InboxNavigationConfig inboxNavigationConfig) {
            super(null);
            Intrinsics.checkNotNullParameter(inboxNavigationConfig, "inboxNavigationConfig");
            this.inboxNavigationConfig = inboxNavigationConfig;
        }

        public final InboxNavigationConfig getInboxNavigationConfig() {
            return this.inboxNavigationConfig;
        }
    }
}
