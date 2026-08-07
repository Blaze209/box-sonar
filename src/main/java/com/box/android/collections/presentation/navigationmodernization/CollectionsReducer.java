package com.box.android.collections.presentation.navigationmodernization;

import com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.data.CreateCollectionMutation;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.CollectionType;
import com.box.android.domain.models.DomainError;
import com.box.androidsdk.content.models.BoxCollection;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CollectionsReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0011\u0012\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$State;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action;", "environment", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsEnvironment;", "<init>", "(Lcom/box/android/collections/presentation/navigationmodernization/CollectionsEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceCollections", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceCreateCollection", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$CreateCollection;", "State", "CollectionCreationError", "Action", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final CollectionsEnvironment environment;

    public CollectionsReducer(CollectionsEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new CollectionsReducer$build$1(this));
        final CollectionsReducer$build$2 collectionsReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CollectionsReducer.State) obj).getCollectionsListState();
            }
        };
        final CollectionsReducer$build$3 collectionsReducer$build$3 = CollectionsReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new CollectionsListReducer(environment.getCollectionsListEnvironment(), CollectionsKt.listOf((Object[]) new CollectionType[]{CollectionType.PERSONAL, CollectionType.FAVORITES})), new Function1<State, CollectionsListReducer.State>() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.collections.presentation.navigationmodernization.collectionslist.CollectionsListReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CollectionsListReducer.State invoke(CollectionsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return collectionsReducer$build$2.invoke(it);
            }
        }, new Function1<Action, CollectionsListReducer.Action>() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final CollectionsListReducer.Action invoke(CollectionsReducer.Action action) {
                if (!(action instanceof CollectionsReducer.Action.CollectionsListAction)) {
                    action = null;
                }
                CollectionsReducer.Action.CollectionsListAction collectionsListAction = (CollectionsReducer.Action.CollectionsListAction) action;
                if (collectionsListAction != null) {
                    return collectionsListAction.getRoute();
                }
                return null;
            }
        }, new Function2<State, CollectionsListReducer.State, State>() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CollectionsReducer.State invoke(CollectionsReducer.State parentState, CollectionsListReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = collectionsReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CollectionsReducer.State.class)).iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((KFunction) next).getName(), BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB));
                KFunction kFunction = (KFunction) next;
                if (kFunction == null) {
                    throw new InvalidObjectException("Copy method not found. Make sure that you work on data class!");
                }
                KParameter instanceParameter = KCallables.getInstanceParameter(kFunction);
                Intrinsics.checkNotNull(instanceParameter);
                for (KParameter kParameter : kFunction.getParameters()) {
                    if (Intrinsics.areEqual(kParameter.getName(), kProperty1.getName())) {
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, state)));
                        if (rCallBy != 0) {
                            return (CollectionsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.collections.presentation.navigationmodernization.CollectionsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CollectionsListReducer.Action, Action>() { // from class: com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CollectionsReducer.Action invoke(CollectionsListReducer.Action action) {
                Object objInvoke = collectionsReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (CollectionsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.collections.presentation.navigationmodernization.CollectionsReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CollectionsReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$State;", "", "collectionsListState", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$State;", "createCollectionDialogVisible", "", "collectionCreationError", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$CollectionCreationError;", "<init>", "(Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$State;ZLcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$CollectionCreationError;)V", "getCollectionsListState", "()Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$State;", "getCreateCollectionDialogVisible", "()Z", "getCollectionCreationError", "()Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$CollectionCreationError;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final CollectionCreationError collectionCreationError;
        private final CollectionsListReducer.State collectionsListState;
        private final boolean createCollectionDialogVisible;

        public State() {
            this(null, false, null, 7, null);
        }

        public static /* synthetic */ State copy$default(State state, CollectionsListReducer.State state2, boolean z, CollectionCreationError collectionCreationError, int i, Object obj) {
            if ((i & 1) != 0) {
                state2 = state.collectionsListState;
            }
            if ((i & 2) != 0) {
                z = state.createCollectionDialogVisible;
            }
            if ((i & 4) != 0) {
                collectionCreationError = state.collectionCreationError;
            }
            return state.copy(state2, z, collectionCreationError);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CollectionsListReducer.State getCollectionsListState() {
            return this.collectionsListState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getCreateCollectionDialogVisible() {
            return this.createCollectionDialogVisible;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CollectionCreationError getCollectionCreationError() {
            return this.collectionCreationError;
        }

        public final State copy(CollectionsListReducer.State collectionsListState, boolean createCollectionDialogVisible, CollectionCreationError collectionCreationError) {
            Intrinsics.checkNotNullParameter(collectionsListState, "collectionsListState");
            return new State(collectionsListState, createCollectionDialogVisible, collectionCreationError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.collectionsListState, state.collectionsListState) && this.createCollectionDialogVisible == state.createCollectionDialogVisible && Intrinsics.areEqual(this.collectionCreationError, state.collectionCreationError);
        }

        public int hashCode() {
            int iHashCode = ((this.collectionsListState.hashCode() * 31) + Boolean.hashCode(this.createCollectionDialogVisible)) * 31;
            CollectionCreationError collectionCreationError = this.collectionCreationError;
            return iHashCode + (collectionCreationError == null ? 0 : collectionCreationError.hashCode());
        }

        public String toString() {
            return "State(collectionsListState=" + this.collectionsListState + ", createCollectionDialogVisible=" + this.createCollectionDialogVisible + ", collectionCreationError=" + this.collectionCreationError + ")";
        }

        public State(CollectionsListReducer.State collectionsListState, boolean z, CollectionCreationError collectionCreationError) {
            Intrinsics.checkNotNullParameter(collectionsListState, "collectionsListState");
            this.collectionsListState = collectionsListState;
            this.createCollectionDialogVisible = z;
            this.collectionCreationError = collectionCreationError;
        }

        public /* synthetic */ State(CollectionsListReducer.State state, boolean z, CollectionCreationError collectionCreationError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            if ((i & 1) != 0) {
                state = new CollectionsListReducer.State(null, null, false, null, 15, null);
            }
            this(state, (i & 2) != 0 ? false : z, (i & 4) != 0 ? null : collectionCreationError);
        }

        public final CollectionsListReducer.State getCollectionsListState() {
            return this.collectionsListState;
        }

        public final boolean getCreateCollectionDialogVisible() {
            return this.createCollectionDialogVisible;
        }

        public final CollectionCreationError getCollectionCreationError() {
            return this.collectionCreationError;
        }
    }

    /* JADX INFO: compiled from: CollectionsReducer.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$CollectionCreationError;", "", "error", "Lcom/box/android/domain/models/DomainError;", "collectionName", "", "<init>", "(Lcom/box/android/domain/models/DomainError;Ljava/lang/String;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "getCollectionName", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class CollectionCreationError {
        public static final int $stable = 8;
        private final String collectionName;
        private final DomainError error;

        public static /* synthetic */ CollectionCreationError copy$default(CollectionCreationError collectionCreationError, DomainError domainError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                domainError = collectionCreationError.error;
            }
            if ((i & 2) != 0) {
                str = collectionCreationError.collectionName;
            }
            return collectionCreationError.copy(domainError, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final DomainError getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCollectionName() {
            return this.collectionName;
        }

        public final CollectionCreationError copy(DomainError error, String collectionName) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(collectionName, "collectionName");
            return new CollectionCreationError(error, collectionName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CollectionCreationError)) {
                return false;
            }
            CollectionCreationError collectionCreationError = (CollectionCreationError) other;
            return Intrinsics.areEqual(this.error, collectionCreationError.error) && Intrinsics.areEqual(this.collectionName, collectionCreationError.collectionName);
        }

        public int hashCode() {
            return (this.error.hashCode() * 31) + this.collectionName.hashCode();
        }

        public String toString() {
            return "CollectionCreationError(error=" + this.error + ", collectionName=" + this.collectionName + ")";
        }

        public CollectionCreationError(DomainError error, String collectionName) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(collectionName, "collectionName");
            this.error = error;
            this.collectionName = collectionName;
        }

        public final String getCollectionName() {
            return this.collectionName;
        }

        public final DomainError getError() {
            return this.error;
        }
    }

    /* JADX INFO: compiled from: CollectionsReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action;", "", "<init>", "()V", "ScreenViewed", "SettingsClicked", "CollectionsListAction", "ShowCreateCollectionDialog", "HideCreateCollectionDialog", CreateCollectionMutation.OPERATION_NAME, "CollectionCreated", "CollectionCreationFailed", "DismissCollectionCreationError", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$CollectionCreated;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$CollectionCreationFailed;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$CollectionsListAction;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$CreateCollection;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$DismissCollectionCreationError;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$HideCreateCollectionDialog;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$ScreenViewed;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$SettingsClicked;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$ShowCreateCollectionDialog;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CollectionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$ScreenViewed;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ScreenViewed extends Action {
            public static final int $stable = 0;
            public static final ScreenViewed INSTANCE = new ScreenViewed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ScreenViewed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1569673754;
            }

            public String toString() {
                return "ScreenViewed";
            }

            private ScreenViewed() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CollectionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$SettingsClicked;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SettingsClicked extends Action {
            public static final int $stable = 0;
            public static final SettingsClicked INSTANCE = new SettingsClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SettingsClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -547891782;
            }

            public String toString() {
                return "SettingsClicked";
            }

            private SettingsClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CollectionsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$CollectionsListAction;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;)V", "getAction", "()Lcom/box/android/collections/presentation/navigationmodernization/collectionslist/CollectionsListReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CollectionsListAction extends Action implements Embedded<CollectionsListReducer.Action> {
            public static final int $stable = 0;
            private final CollectionsListReducer.Action action;

            public static /* synthetic */ CollectionsListAction copy$default(CollectionsListAction collectionsListAction, CollectionsListReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = collectionsListAction.action;
                }
                return collectionsListAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CollectionsListReducer.Action getRoute() {
                return this.action;
            }

            public final CollectionsListAction copy(CollectionsListReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new CollectionsListAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CollectionsListAction) && Intrinsics.areEqual(this.action, ((CollectionsListAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "CollectionsListAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CollectionsListAction(CollectionsListReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final CollectionsListReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: CollectionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$ShowCreateCollectionDialog;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowCreateCollectionDialog extends Action {
            public static final int $stable = 0;
            public static final ShowCreateCollectionDialog INSTANCE = new ShowCreateCollectionDialog();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowCreateCollectionDialog)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1195160311;
            }

            public String toString() {
                return "ShowCreateCollectionDialog";
            }

            private ShowCreateCollectionDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CollectionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$HideCreateCollectionDialog;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HideCreateCollectionDialog extends Action {
            public static final int $stable = 0;
            public static final HideCreateCollectionDialog INSTANCE = new HideCreateCollectionDialog();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof HideCreateCollectionDialog)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 487529870;
            }

            public String toString() {
                return "HideCreateCollectionDialog";
            }

            private HideCreateCollectionDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CollectionsReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$CreateCollection;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action;", "name", "", "<init>", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CreateCollection extends Action {
            public static final int $stable = 0;
            private final String name;

            public static /* synthetic */ CreateCollection copy$default(CreateCollection createCollection, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = createCollection.name;
                }
                return createCollection.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final CreateCollection copy(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return new CreateCollection(name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CreateCollection) && Intrinsics.areEqual(this.name, ((CreateCollection) other).name);
            }

            public int hashCode() {
                return this.name.hashCode();
            }

            public String toString() {
                return "CreateCollection(name=" + this.name + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CreateCollection(String name) {
                super(null);
                Intrinsics.checkNotNullParameter(name, "name");
                this.name = name;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* JADX INFO: compiled from: CollectionsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$CollectionCreated;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action;", BoxCollection.TYPE, "Lcom/box/android/domain/models/CollectionModel;", "<init>", "(Lcom/box/android/domain/models/CollectionModel;)V", "getCollection", "()Lcom/box/android/domain/models/CollectionModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CollectionCreated extends Action {
            public static final int $stable = 8;
            private final CollectionModel collection;

            public static /* synthetic */ CollectionCreated copy$default(CollectionCreated collectionCreated, CollectionModel collectionModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    collectionModel = collectionCreated.collection;
                }
                return collectionCreated.copy(collectionModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CollectionModel getCollection() {
                return this.collection;
            }

            public final CollectionCreated copy(CollectionModel collection) {
                Intrinsics.checkNotNullParameter(collection, "collection");
                return new CollectionCreated(collection);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CollectionCreated) && Intrinsics.areEqual(this.collection, ((CollectionCreated) other).collection);
            }

            public int hashCode() {
                return this.collection.hashCode();
            }

            public String toString() {
                return "CollectionCreated(collection=" + this.collection + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CollectionCreated(CollectionModel collection) {
                super(null);
                Intrinsics.checkNotNullParameter(collection, "collection");
                this.collection = collection;
            }

            public final CollectionModel getCollection() {
                return this.collection;
            }
        }

        /* JADX INFO: compiled from: CollectionsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$CollectionCreationFailed;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "collectionName", "", "<init>", "(Lcom/box/android/domain/models/DomainError;Ljava/lang/String;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "getCollectionName", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CollectionCreationFailed extends Action {
            public static final int $stable = 8;
            private final String collectionName;
            private final DomainError error;

            public static /* synthetic */ CollectionCreationFailed copy$default(CollectionCreationFailed collectionCreationFailed, DomainError domainError, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = collectionCreationFailed.error;
                }
                if ((i & 2) != 0) {
                    str = collectionCreationFailed.collectionName;
                }
                return collectionCreationFailed.copy(domainError, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getCollectionName() {
                return this.collectionName;
            }

            public final CollectionCreationFailed copy(DomainError error, String collectionName) {
                Intrinsics.checkNotNullParameter(error, "error");
                Intrinsics.checkNotNullParameter(collectionName, "collectionName");
                return new CollectionCreationFailed(error, collectionName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CollectionCreationFailed)) {
                    return false;
                }
                CollectionCreationFailed collectionCreationFailed = (CollectionCreationFailed) other;
                return Intrinsics.areEqual(this.error, collectionCreationFailed.error) && Intrinsics.areEqual(this.collectionName, collectionCreationFailed.collectionName);
            }

            public int hashCode() {
                return (this.error.hashCode() * 31) + this.collectionName.hashCode();
            }

            public String toString() {
                return "CollectionCreationFailed(error=" + this.error + ", collectionName=" + this.collectionName + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CollectionCreationFailed(DomainError error, String collectionName) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                Intrinsics.checkNotNullParameter(collectionName, "collectionName");
                this.error = error;
                this.collectionName = collectionName;
            }

            public final String getCollectionName() {
                return this.collectionName;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: CollectionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action$DismissCollectionCreationError;", "Lcom/box/android/collections/presentation/navigationmodernization/CollectionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DismissCollectionCreationError extends Action {
            public static final int $stable = 0;
            public static final DismissCollectionCreationError INSTANCE = new DismissCollectionCreationError();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DismissCollectionCreationError)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1854887797;
            }

            public String toString() {
                return "DismissCollectionCreationError";
            }

            private DismissCollectionCreationError() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceCollections(State state, Action action) {
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        Object[] objArr8 = 0;
        Object[] objArr9 = 0;
        if (Intrinsics.areEqual(action, Action.ScreenViewed.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(null)));
        }
        if (Intrinsics.areEqual(action, Action.SettingsClicked.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass2(null)));
        }
        int i = 2;
        if (action instanceof Action.CollectionsListAction) {
            return new ReducerResult<>(state, effect, i, objArr9 == true ? 1 : 0);
        }
        if (action instanceof Action.ShowCreateCollectionDialog) {
            return new ReducerResult<>(State.copy$default(state, null, true, null, 5, null), Effect.INSTANCE.fireAndForget(new AnonymousClass3(null)));
        }
        if (action instanceof Action.HideCreateCollectionDialog) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, 5, null), objArr8 == true ? 1 : 0, i, objArr7 == true ? 1 : 0);
        }
        if (action instanceof Action.CreateCollection) {
            return reduceCreateCollection(state, (Action.CreateCollection) action);
        }
        if (action instanceof Action.CollectionCreated) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, 5, null), objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        }
        if (action instanceof Action.CollectionCreationFailed) {
            Action.CollectionCreationFailed collectionCreationFailed = (Action.CollectionCreationFailed) action;
            return new ReducerResult<>(State.copy$default(state, null, false, new CollectionCreationError(collectionCreationFailed.getError(), collectionCreationFailed.getCollectionName()), 1, null), objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (!(action instanceof Action.DismissCollectionCreationError)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(State.copy$default(state, null, false, null, 3, null), objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$reduceCollections$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$reduceCollections$1", f = "CollectionsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CollectionsReducer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CollectionsReducer.this.environment.getAnalytics().collectionsScreenViewed();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$reduceCollections$2, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$reduceCollections$2", f = "CollectionsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CollectionsReducer.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CollectionsReducer.this.environment.getAnalytics().settingsClicked();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$reduceCollections$3, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.CollectionsReducer$reduceCollections$3", f = "CollectionsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CollectionsReducer.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CollectionsReducer.this.environment.getAnalytics().createCollectionClicked();
            return Unit.INSTANCE;
        }
    }

    private final ReducerResult<State, Action> reduceCreateCollection(State state, Action.CreateCollection action) {
        return new ReducerResult<>(state, EffectKt.toEffect(FlowKt.flow(new CollectionsReducer$reduceCreateCollection$effect$1(this, action, null))));
    }
}
