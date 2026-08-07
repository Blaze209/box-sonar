package com.box.android.collections.presentation.navigationmodernization.collectionslist;

import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.DomainError;
import com.box.androidsdk.content.models.BoxItem;
import com.pspdfkit.analytics.Analytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CollectionsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0017\u0018\u0019\u001aB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0003H\u0002J\u001c\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J$\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$State;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;", "environment", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListEnvironment;", "collectionTypes", "", "Lcom/box/android/domain/models/CollectionType;", "<init>", "(Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListEnvironment;Ljava/util/List;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "reduceCollectionsList", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceLoadCollections", "reduceLoadFailed", "error", "Lcom/box/android/domain/models/DomainError;", "State", "LoadingState", "Action", "Companion", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionsListReducer implements Reducable<State, Action> {
    public static final String LOAD_COLLECTIONS_EFFECT_ID = "load_collections";
    private final Reduce<State, Action> build;
    private final List<CollectionType> collectionTypes;
    private final CollectionsListEnvironment environment;
    public static final int $stable = 8;

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsListReducer(CollectionsListEnvironment environment, List<? extends CollectionType> collectionTypes) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(collectionTypes, "collectionTypes");
        this.environment = environment;
        this.collectionTypes = collectionTypes;
        this.build = new Reduce<>(new CollectionsListReducer$build$1(this));
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CollectionsListReducer.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$State;", "", BoxItem.FIELD_COLLECTIONS, "", "Lcom/box/android/domain/models/CollectionModel;", "loadingState", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$LoadingState;", "isRefreshing", "", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Ljava/util/List;Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$LoadingState;ZLcom/box/android/domain/models/DomainError;)V", "getCollections", "()Ljava/util/List;", "getLoadingState", "()Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$LoadingState;", "()Z", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final List<CollectionModel> collections;
        private final DomainError error;
        private final boolean isRefreshing;
        private final LoadingState loadingState;

        public State() {
            this(null, null, false, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, List list, LoadingState loadingState, boolean z, DomainError domainError, int i, Object obj) {
            if ((i & 1) != 0) {
                list = state.collections;
            }
            if ((i & 2) != 0) {
                loadingState = state.loadingState;
            }
            if ((i & 4) != 0) {
                z = state.isRefreshing;
            }
            if ((i & 8) != 0) {
                domainError = state.error;
            }
            return state.copy(list, loadingState, z, domainError);
        }

        public final List<CollectionModel> component1() {
            return this.collections;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final LoadingState getLoadingState() {
            return this.loadingState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsRefreshing() {
            return this.isRefreshing;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final DomainError getError() {
            return this.error;
        }

        public final State copy(List<CollectionModel> collections, LoadingState loadingState, boolean isRefreshing, DomainError error) {
            Intrinsics.checkNotNullParameter(collections, "collections");
            Intrinsics.checkNotNullParameter(loadingState, "loadingState");
            return new State(collections, loadingState, isRefreshing, error);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.collections, state.collections) && Intrinsics.areEqual(this.loadingState, state.loadingState) && this.isRefreshing == state.isRefreshing && Intrinsics.areEqual(this.error, state.error);
        }

        public int hashCode() {
            int iHashCode = ((((this.collections.hashCode() * 31) + this.loadingState.hashCode()) * 31) + Boolean.hashCode(this.isRefreshing)) * 31;
            DomainError domainError = this.error;
            return iHashCode + (domainError == null ? 0 : domainError.hashCode());
        }

        public String toString() {
            return "State(collections=" + this.collections + ", loadingState=" + this.loadingState + ", isRefreshing=" + this.isRefreshing + ", error=" + this.error + ")";
        }

        public State(List<CollectionModel> collections, LoadingState loadingState, boolean z, DomainError domainError) {
            Intrinsics.checkNotNullParameter(collections, "collections");
            Intrinsics.checkNotNullParameter(loadingState, "loadingState");
            this.collections = collections;
            this.loadingState = loadingState;
            this.isRefreshing = z;
            this.error = domainError;
        }

        public /* synthetic */ State(List list, LoadingState.Loading loading, boolean z, DomainError domainError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? LoadingState.Loading.INSTANCE : loading, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : domainError);
        }

        public final List<CollectionModel> getCollections() {
            return this.collections;
        }

        public final LoadingState getLoadingState() {
            return this.loadingState;
        }

        public final boolean isRefreshing() {
            return this.isRefreshing;
        }

        public final DomainError getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: CollectionsListReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$LoadingState;", "", "<init>", "()V", "Loading", "Loaded", "Error", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$LoadingState$Error;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$LoadingState$Loaded;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$LoadingState$Loading;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class LoadingState {
        public static final int $stable = 0;

        public /* synthetic */ LoadingState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CollectionsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$LoadingState$Loading;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$LoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loading extends LoadingState {
            public static final int $stable = 0;
            public static final Loading INSTANCE = new Loading();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loading)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 675574132;
            }

            public String toString() {
                return "Loading";
            }

            private Loading() {
                super(null);
            }
        }

        private LoadingState() {
        }

        /* JADX INFO: compiled from: CollectionsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$LoadingState$Loaded;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$LoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loaded extends LoadingState {
            public static final int $stable = 0;
            public static final Loaded INSTANCE = new Loaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 437434573;
            }

            public String toString() {
                return "Loaded";
            }

            private Loaded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CollectionsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$LoadingState$Error;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$LoadingState;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends LoadingState {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ Error copy$default(Error error, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = error.error;
                }
                return error.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final Error copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new Error(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Error) && Intrinsics.areEqual(this.error, ((Error) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "Error(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }
    }

    /* JADX INFO: compiled from: CollectionsListReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;", "", "<init>", "()V", "LoadCollections", "RefreshCollections", "CollectionsLoaded", "LoadFailed", "DismissError", "RefreshSucceeded", "RefreshFailed", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$CollectionsLoaded;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$DismissError;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$LoadCollections;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$LoadFailed;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$RefreshCollections;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$RefreshFailed;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$RefreshSucceeded;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CollectionsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$LoadCollections;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadCollections extends Action {
            public static final int $stable = 0;
            public static final LoadCollections INSTANCE = new LoadCollections();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadCollections)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1804155208;
            }

            public String toString() {
                return "LoadCollections";
            }

            private LoadCollections() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CollectionsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$RefreshCollections;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;", "isPullToRefresh", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshCollections extends Action {
            public static final int $stable = 0;
            private final boolean isPullToRefresh;

            public static /* synthetic */ RefreshCollections copy$default(RefreshCollections refreshCollections, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = refreshCollections.isPullToRefresh;
                }
                return refreshCollections.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsPullToRefresh() {
                return this.isPullToRefresh;
            }

            public final RefreshCollections copy(boolean isPullToRefresh) {
                return new RefreshCollections(isPullToRefresh);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RefreshCollections) && this.isPullToRefresh == ((RefreshCollections) other).isPullToRefresh;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isPullToRefresh);
            }

            public String toString() {
                return "RefreshCollections(isPullToRefresh=" + this.isPullToRefresh + ")";
            }

            public RefreshCollections(boolean z) {
                super(null);
                this.isPullToRefresh = z;
            }

            public final boolean isPullToRefresh() {
                return this.isPullToRefresh;
            }
        }

        /* JADX INFO: compiled from: CollectionsListReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$CollectionsLoaded;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;", BoxItem.FIELD_COLLECTIONS, "", "Lcom/box/android/domain/models/CollectionModel;", "<init>", "(Ljava/util/List;)V", "getCollections", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CollectionsLoaded extends Action {
            public static final int $stable = 8;
            private final List<CollectionModel> collections;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ CollectionsLoaded copy$default(CollectionsLoaded collectionsLoaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = collectionsLoaded.collections;
                }
                return collectionsLoaded.copy(list);
            }

            public final List<CollectionModel> component1() {
                return this.collections;
            }

            public final CollectionsLoaded copy(List<CollectionModel> collections) {
                Intrinsics.checkNotNullParameter(collections, "collections");
                return new CollectionsLoaded(collections);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CollectionsLoaded) && Intrinsics.areEqual(this.collections, ((CollectionsLoaded) other).collections);
            }

            public int hashCode() {
                return this.collections.hashCode();
            }

            public String toString() {
                return "CollectionsLoaded(collections=" + this.collections + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CollectionsLoaded(List<CollectionModel> collections) {
                super(null);
                Intrinsics.checkNotNullParameter(collections, "collections");
                this.collections = collections;
            }

            public final List<CollectionModel> getCollections() {
                return this.collections;
            }
        }

        /* JADX INFO: compiled from: CollectionsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$LoadFailed;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadFailed extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ LoadFailed copy$default(LoadFailed loadFailed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = loadFailed.error;
                }
                return loadFailed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final LoadFailed copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new LoadFailed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof LoadFailed) && Intrinsics.areEqual(this.error, ((LoadFailed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "LoadFailed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public LoadFailed(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: CollectionsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$DismissError;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DismissError extends Action {
            public static final int $stable = 0;
            public static final DismissError INSTANCE = new DismissError();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DismissError)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -650308667;
            }

            public String toString() {
                return "DismissError";
            }

            private DismissError() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CollectionsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$RefreshSucceeded;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshSucceeded extends Action {
            public static final int $stable = 0;
            public static final RefreshSucceeded INSTANCE = new RefreshSucceeded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshSucceeded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1356871571;
            }

            public String toString() {
                return "RefreshSucceeded";
            }

            private RefreshSucceeded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CollectionsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action$RefreshFailed;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshFailed extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ RefreshFailed copy$default(RefreshFailed refreshFailed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = refreshFailed.error;
                }
                return refreshFailed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final RefreshFailed copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new RefreshFailed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RefreshFailed) && Intrinsics.areEqual(this.error, ((RefreshFailed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "RefreshFailed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RefreshFailed(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceCollectionsList(State state, Action action) {
        if (action instanceof Action.LoadCollections) {
            return reduceLoadCollections(state);
        }
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        if (action instanceof Action.RefreshCollections) {
            return new ReducerResult<>(State.copy$default(state, null, null, ((Action.RefreshCollections) action).isPullToRefresh(), null, 3, null), EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(null))));
        }
        int i = 2;
        if (action instanceof Action.CollectionsLoaded) {
            return new ReducerResult<>(State.copy$default(state, ((Action.CollectionsLoaded) action).getCollections(), LoadingState.Loaded.INSTANCE, false, null, 8, null), effect, i, objArr7 == true ? 1 : 0);
        }
        if (action instanceof Action.LoadFailed) {
            return reduceLoadFailed(state, ((Action.LoadFailed) action).getError());
        }
        if (action instanceof Action.DismissError) {
            return new ReducerResult<>(State.copy$default(state, null, null, false, null, 7, null), objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        }
        if (action instanceof Action.RefreshSucceeded) {
            return new ReducerResult<>(State.copy$default(state, null, null, false, null, 11, null), objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (action instanceof Action.RefreshFailed) {
            return new ReducerResult<>(State.copy$default(state, null, null, false, ((Action.RefreshFailed) action).getError(), 3, null), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer$reduceCollectionsList$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionsListReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer$reduceCollectionsList$1", f = "CollectionsListReducer.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}, l = {65, 68, 69, 73}, m = "invokeSuspend", n = {"$this$flow", "$this$forEach$iv", "element$iv", "type", "$i$f$forEach", "$i$a$-forEach-CollectionsListReducer$reduceCollectionsList$1$1", "$this$flow", "$this$forEach$iv", "element$iv", "type", "$this$onError$iv", "it", "$i$f$forEach", "$i$a$-forEach-CollectionsListReducer$reduceCollectionsList$1$1", "$i$f$onError", "$i$a$-onError-CollectionsListReducer$reduceCollectionsList$1$1$1", "$this$flow", "$this$forEach$iv", "element$iv", "type", "$this$onError$iv", "it", "$i$f$forEach", "$i$a$-forEach-CollectionsListReducer$reduceCollectionsList$1$1", "$i$f$onError", "$i$a$-onError-CollectionsListReducer$reduceCollectionsList$1$1$1", "$this$flow"}, s = {"L$0", "L$1", "L$4", "L$5", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2", "I$3", "L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = CollectionsListReducer.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x009e  */
        /* JADX WARN: Code duplicated, block: B:20:0x00d3  */
        /* JADX WARN: Code duplicated, block: B:23:0x00de  */
        /* JADX WARN: Code duplicated, block: B:25:0x00e2  */
        /* JADX WARN: Code duplicated, block: B:28:0x011e  */
        /* JADX WARN: Code duplicated, block: B:34:0x0168  */
        /* JADX WARN: Code duplicated, block: B:36:0x016e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00d3 -> B:21:0x00d8). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 406
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final ReducerResult<State, Action> reduceLoadCollections(State state) {
        return new ReducerResult<>(State.copy$default(state, null, LoadingState.Loading.INSTANCE, false, null, 5, null), EffectKt.toEffect(FlowKt.flow(new CollectionsListReducer$reduceLoadCollections$effect$1(this, null))).cancellable(LOAD_COLLECTIONS_EFFECT_ID, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final ReducerResult<State, Action> reduceLoadFailed(State state, DomainError error) {
        State stateCopy$default;
        if (Intrinsics.areEqual(state.getLoadingState(), LoadingState.Loaded.INSTANCE)) {
            stateCopy$default = State.copy$default(state, null, null, false, error, 3, null);
        } else {
            stateCopy$default = State.copy$default(state, null, new LoadingState.Error(error), false, null, 1, null);
        }
        return new ReducerResult<>(stateCopy$default, null, 2, 0 == true ? 1 : 0);
    }
}
