package com.box.android.collections.presentation.navigationmodernization.collectionitemslist;

import com.box.android.base.presentation.multiselect.MultiselectReducer;
import com.box.android.base.presentation.multiselect.SelectionId;
import com.box.android.base.presentation.multiselect.SelectionIdKt;
import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.EmbeddedItem;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.IdentifiedListKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.ForEachReducer;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CollectionModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.androidsdk.content.models.BoxCollection;
import com.facebook.react.modules.dialog.AlertFragment;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
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

/* JADX INFO: compiled from: CollectionItemsListReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0005\u0018\u0019\u001a\u001b\u001cB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0010H\u0002J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J$\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$State;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "environment", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListEnvironment;", "<init>", "(Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceActions", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceItemAction", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$ItemAction;", "reduceLoadItems", "reduceRefreshItems", "isPullToRefresh", "", "reduceLoadFailed", "error", "Lcom/box/android/domain/models/DomainError;", "State", "LoadingState", "Route", "Action", "Companion", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectionItemsListReducer implements Reducable<State, Action> {
    public static final String LOAD_COLLECTIONS_ITEMS_EFFECT_ID = "load_collections_items";
    private final Reducable<State, Action> build;
    private final CollectionItemsListEnvironment environment;
    public static final int $stable = 8;

    public CollectionItemsListReducer(CollectionItemsListEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new CollectionItemsListReducer$build$1(this));
        final CollectionItemsListReducer$build$2 collectionItemsListReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CollectionItemsListReducer.State) obj).getMultiselect();
            }
        };
        final CollectionItemsListReducer$build$3 collectionItemsListReducer$build$3 = CollectionItemsListReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new MultiselectReducer(environment.getMultiselectEnvironment()), new Function1<State, MultiselectReducer.State>() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.multiselect.MultiselectReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final MultiselectReducer.State invoke(CollectionItemsListReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return collectionItemsListReducer$build$2.invoke(it);
            }
        }, new Function1<Action, MultiselectReducer.Action>() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final MultiselectReducer.Action invoke(CollectionItemsListReducer.Action action) {
                if (!(action instanceof CollectionItemsListReducer.Action.Multiselect)) {
                    action = null;
                }
                CollectionItemsListReducer.Action.Multiselect multiselect = (CollectionItemsListReducer.Action.Multiselect) action;
                if (multiselect != null) {
                    return multiselect.getState();
                }
                return null;
            }
        }, new Function2<State, MultiselectReducer.State, State>() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CollectionItemsListReducer.State invoke(CollectionItemsListReducer.State parentState, MultiselectReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = collectionItemsListReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CollectionItemsListReducer.State.class)).iterator();
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
                            return (CollectionItemsListReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<MultiselectReducer.Action, Action>() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CollectionItemsListReducer.Action invoke(MultiselectReducer.Action action) {
                Object objInvoke = collectionItemsListReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (CollectionItemsListReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer.Action");
            }
        });
        final CollectionItemsListReducer$build$5 collectionItemsListReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CollectionItemsListReducer.State) obj).getItems();
            }
        };
        final CollectionItemsListReducer$build$6 collectionItemsListReducer$build$6 = CollectionItemsListReducer$build$6.INSTANCE;
        this.build = new ForEachReducer(ifLetReducer, new ItemReducer(environment.getItemEnvironment()), collectionItemsListReducer$build$5, new Function1<Action, EmbeddedItem<ItemId.Remote, ItemReducer.Action>>() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$special$$inlined$forEach$1
            @Override // kotlin.jvm.functions.Function1
            public final EmbeddedItem<ItemId.Remote, ItemReducer.Action> invoke(CollectionItemsListReducer.Action action) {
                if (!(action instanceof CollectionItemsListReducer.Action.ItemAction)) {
                    action = null;
                }
                return (CollectionItemsListReducer.Action.ItemAction) action;
            }
        }, new Function2<State, ItemReducer.State, State>() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$special$$inlined$forEach$2
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CollectionItemsListReducer.State invoke(CollectionItemsListReducer.State parentState, ItemReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                IdentifiedList identifiedListListByReplacingElement = ((IdentifiedList) collectionItemsListReducer$build$5.get(parentState)).listByReplacingElement(childState);
                KProperty1 kProperty1 = collectionItemsListReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CollectionItemsListReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, identifiedListListByReplacingElement)));
                        if (rCallBy != 0) {
                            return (CollectionItemsListReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function2<ItemId.Remote, ItemReducer.Action, Action>() { // from class: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$special$$inlined$forEach$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final CollectionItemsListReducer.Action invoke(ItemId.Remote id, ItemReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Object objInvoke = collectionItemsListReducer$build$6.invoke(id, action);
                if (objInvoke != null) {
                    return (CollectionItemsListReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u0006J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0015\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005HÆ\u0003J\t\u0010+\u001a\u00020\tHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u0010.\u001a\u00020\u000fHÆ\u0003J\t\u0010/\u001a\u00020\u0011HÆ\u0003J]\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u00101\u001a\u00020\u000b2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$¨\u00066"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$State;", "", BoxCollection.TYPE, "Lcom/box/android/domain/models/CollectionModel;", AlertFragment.ARG_ITEMS, "Lcom/box/android/cpl/IdentifiedList;", "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", "loadingState", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$LoadingState;", "isRefreshing", "", "error", "Lcom/box/android/domain/models/DomainError;", "navigationRoute", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route;", "multiselect", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", "<init>", "(Lcom/box/android/domain/models/CollectionModel;Lcom/box/android/cpl/IdentifiedList;Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$LoadingState;ZLcom/box/android/domain/models/DomainError;Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route;Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;)V", "getCollection", "()Lcom/box/android/domain/models/CollectionModel;", "getItems", "()Lcom/box/android/cpl/IdentifiedList;", "getLoadingState", "()Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$LoadingState;", "()Z", "getError", "()Lcom/box/android/domain/models/DomainError;", "getNavigationRoute", "()Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route;", "getMultiselect", "()Lcom/box/android/base/presentation/multiselect/MultiselectReducer$State;", BoxItemJob.COLLECTION_ID, "", "getCollectionId", "()Ljava/lang/String;", "collectionName", "getCollectionName", "isItemChecked", "itemId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final CollectionModel collection;
        private final String collectionId;
        private final String collectionName;
        private final DomainError error;
        private final boolean isRefreshing;
        private final IdentifiedList<ItemId.Remote, ItemReducer.State> items;
        private final LoadingState loadingState;
        private final MultiselectReducer.State multiselect;
        private final Route navigationRoute;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, CollectionModel collectionModel, IdentifiedList identifiedList, LoadingState loadingState, boolean z, DomainError domainError, Route route, MultiselectReducer.State state2, int i, Object obj) {
            if ((i & 1) != 0) {
                collectionModel = state.collection;
            }
            if ((i & 2) != 0) {
                identifiedList = state.items;
            }
            if ((i & 4) != 0) {
                loadingState = state.loadingState;
            }
            if ((i & 8) != 0) {
                z = state.isRefreshing;
            }
            if ((i & 16) != 0) {
                domainError = state.error;
            }
            if ((i & 32) != 0) {
                route = state.navigationRoute;
            }
            if ((i & 64) != 0) {
                state2 = state.multiselect;
            }
            Route route2 = route;
            MultiselectReducer.State state3 = state2;
            DomainError domainError2 = domainError;
            LoadingState loadingState2 = loadingState;
            return state.copy(collectionModel, identifiedList, loadingState2, z, domainError2, route2, state3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CollectionModel getCollection() {
            return this.collection;
        }

        public final IdentifiedList<ItemId.Remote, ItemReducer.State> component2() {
            return this.items;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final LoadingState getLoadingState() {
            return this.loadingState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsRefreshing() {
            return this.isRefreshing;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final DomainError getError() {
            return this.error;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final MultiselectReducer.State getMultiselect() {
            return this.multiselect;
        }

        public final State copy(CollectionModel collection, IdentifiedList<ItemId.Remote, ItemReducer.State> items, LoadingState loadingState, boolean isRefreshing, DomainError error, Route navigationRoute, MultiselectReducer.State multiselect) {
            Intrinsics.checkNotNullParameter(collection, "collection");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(loadingState, "loadingState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            Intrinsics.checkNotNullParameter(multiselect, "multiselect");
            return new State(collection, items, loadingState, isRefreshing, error, navigationRoute, multiselect);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.collection, state.collection) && Intrinsics.areEqual(this.items, state.items) && Intrinsics.areEqual(this.loadingState, state.loadingState) && this.isRefreshing == state.isRefreshing && Intrinsics.areEqual(this.error, state.error) && Intrinsics.areEqual(this.navigationRoute, state.navigationRoute) && Intrinsics.areEqual(this.multiselect, state.multiselect);
        }

        public int hashCode() {
            int iHashCode = ((((((this.collection.hashCode() * 31) + this.items.hashCode()) * 31) + this.loadingState.hashCode()) * 31) + Boolean.hashCode(this.isRefreshing)) * 31;
            DomainError domainError = this.error;
            return ((((iHashCode + (domainError == null ? 0 : domainError.hashCode())) * 31) + this.navigationRoute.hashCode()) * 31) + this.multiselect.hashCode();
        }

        public String toString() {
            return "State(collection=" + this.collection + ", items=" + this.items + ", loadingState=" + this.loadingState + ", isRefreshing=" + this.isRefreshing + ", error=" + this.error + ", navigationRoute=" + this.navigationRoute + ", multiselect=" + this.multiselect + ")";
        }

        public State(CollectionModel collection, IdentifiedList<ItemId.Remote, ItemReducer.State> items, LoadingState loadingState, boolean z, DomainError domainError, Route navigationRoute, MultiselectReducer.State multiselect) {
            Intrinsics.checkNotNullParameter(collection, "collection");
            Intrinsics.checkNotNullParameter(items, "items");
            Intrinsics.checkNotNullParameter(loadingState, "loadingState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            Intrinsics.checkNotNullParameter(multiselect, "multiselect");
            this.collection = collection;
            this.items = items;
            this.loadingState = loadingState;
            this.isRefreshing = z;
            this.error = domainError;
            this.navigationRoute = navigationRoute;
            this.multiselect = multiselect;
            this.collectionId = collection.getId();
            this.collectionName = collection.getName();
        }

        public final CollectionModel getCollection() {
            return this.collection;
        }

        public /* synthetic */ State(CollectionModel collectionModel, IdentifiedList identifiedList, LoadingState loadingState, boolean z, DomainError domainError, Route route, MultiselectReducer.State state, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(collectionModel, (i & 2) != 0 ? IdentifiedListKt.emptyIdentifiedList() : identifiedList, (i & 4) != 0 ? LoadingState.Loading.INSTANCE : loadingState, (i & 8) != 0 ? false : z, (i & 16) != 0 ? null : domainError, (i & 32) != 0 ? Route.None.INSTANCE : route, (i & 64) != 0 ? MultiselectReducer.State.Unavailable.INSTANCE : state);
        }

        public final IdentifiedList<ItemId.Remote, ItemReducer.State> getItems() {
            return this.items;
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

        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        public final MultiselectReducer.State getMultiselect() {
            return this.multiselect;
        }

        public final String getCollectionId() {
            return this.collectionId;
        }

        public final String getCollectionName() {
            return this.collectionName;
        }

        public final boolean isItemChecked(ItemId.Remote itemId) {
            MultiselectReducer.SelectionInfo selectionInfo;
            Set<SelectionId> selectedIds;
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            MultiselectReducer.State state = this.multiselect;
            MultiselectReducer.State.Selecting selecting = state instanceof MultiselectReducer.State.Selecting ? (MultiselectReducer.State.Selecting) state : null;
            return (selecting == null || (selectionInfo = selecting.getSelectionInfo()) == null || (selectedIds = selectionInfo.getSelectedIds()) == null || !selectedIds.contains(SelectionIdKt.toSelectionId(itemId))) ? false : true;
        }
    }

    /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$LoadingState;", "", "<init>", "()V", "Loading", "Loaded", "Error", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$LoadingState$Error;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$LoadingState$Loaded;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$LoadingState$Loading;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class LoadingState {
        public static final int $stable = 0;

        public /* synthetic */ LoadingState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$LoadingState$Loading;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$LoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 109542382;
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

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$LoadingState$Loaded;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$LoadingState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -966297837;
            }

            public String toString() {
                return "Loaded";
            }

            private Loaded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$LoadingState$Error;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$LoadingState;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

    /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route;", "", "<init>", "()V", "None", "OpenItem", "OpenItemMoreActionsMenu", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route$None;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route$OpenItem;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route$OpenItemMoreActionsMenu;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Route {
        public static final int $stable = 0;

        public /* synthetic */ Route(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route$None;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class None extends Route {
            public static final int $stable = 0;
            public static final None INSTANCE = new None();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof None)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1413550248;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }

        private Route() {
        }

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route$OpenItem;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route;", "item", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItem", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OpenItem extends Route {
            public static final int $stable = 8;
            private final ItemModel item;

            public static /* synthetic */ OpenItem copy$default(OpenItem openItem, ItemModel itemModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = openItem.item;
                }
                return openItem.copy(itemModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItem() {
                return this.item;
            }

            public final OpenItem copy(ItemModel item) {
                Intrinsics.checkNotNullParameter(item, "item");
                return new OpenItem(item);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof OpenItem) && Intrinsics.areEqual(this.item, ((OpenItem) other).item);
            }

            public int hashCode() {
                return this.item.hashCode();
            }

            public String toString() {
                return "OpenItem(item=" + this.item + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenItem(ItemModel item) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                this.item = item;
            }

            public final ItemModel getItem() {
                return this.item;
            }
        }

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route$OpenItemMoreActionsMenu;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route;", "item", "Lcom/box/android/domain/models/item/ItemModel;", BoxItemJob.COLLECTION_ID, "", "collectionName", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;Ljava/lang/String;Ljava/lang/String;)V", "getItem", "()Lcom/box/android/domain/models/item/ItemModel;", "getCollectionId", "()Ljava/lang/String;", "getCollectionName", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class OpenItemMoreActionsMenu extends Route {
            public static final int $stable = 8;
            private final String collectionId;
            private final String collectionName;
            private final ItemModel item;

            public static /* synthetic */ OpenItemMoreActionsMenu copy$default(OpenItemMoreActionsMenu openItemMoreActionsMenu, ItemModel itemModel, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    itemModel = openItemMoreActionsMenu.item;
                }
                if ((i & 2) != 0) {
                    str = openItemMoreActionsMenu.collectionId;
                }
                if ((i & 4) != 0) {
                    str2 = openItemMoreActionsMenu.collectionName;
                }
                return openItemMoreActionsMenu.copy(itemModel, str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemModel getItem() {
                return this.item;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getCollectionId() {
                return this.collectionId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getCollectionName() {
                return this.collectionName;
            }

            public final OpenItemMoreActionsMenu copy(ItemModel item, String collectionId, String collectionName) {
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(collectionId, "collectionId");
                Intrinsics.checkNotNullParameter(collectionName, "collectionName");
                return new OpenItemMoreActionsMenu(item, collectionId, collectionName);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof OpenItemMoreActionsMenu)) {
                    return false;
                }
                OpenItemMoreActionsMenu openItemMoreActionsMenu = (OpenItemMoreActionsMenu) other;
                return Intrinsics.areEqual(this.item, openItemMoreActionsMenu.item) && Intrinsics.areEqual(this.collectionId, openItemMoreActionsMenu.collectionId) && Intrinsics.areEqual(this.collectionName, openItemMoreActionsMenu.collectionName);
            }

            public int hashCode() {
                return (((this.item.hashCode() * 31) + this.collectionId.hashCode()) * 31) + this.collectionName.hashCode();
            }

            public String toString() {
                return "OpenItemMoreActionsMenu(item=" + this.item + ", collectionId=" + this.collectionId + ", collectionName=" + this.collectionName + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public OpenItemMoreActionsMenu(ItemModel item, String collectionId, String collectionName) {
                super(null);
                Intrinsics.checkNotNullParameter(item, "item");
                Intrinsics.checkNotNullParameter(collectionId, "collectionId");
                Intrinsics.checkNotNullParameter(collectionName, "collectionName");
                this.item = item;
                this.collectionId = collectionId;
                this.collectionName = collectionName;
            }

            public final String getCollectionId() {
                return this.collectionId;
            }

            public final String getCollectionName() {
                return this.collectionName;
            }

            public final ItemModel getItem() {
                return this.item;
            }
        }
    }

    /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u000b\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u000b\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "", "<init>", "()V", "ScreenViewed", "LoadItems", "RefreshItems", "ItemsLoaded", "ItemAction", "LoadFailed", "RefreshCompleted", "RefreshFailed", "ErrorHandled", "Navigate", "Multiselect", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$ErrorHandled;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$ItemAction;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$ItemsLoaded;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$LoadFailed;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$LoadItems;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$Multiselect;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$Navigate;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$RefreshCompleted;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$RefreshFailed;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$RefreshItems;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$ScreenViewed;", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$ScreenViewed;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return 229014013;
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

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$LoadItems;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadItems extends Action {
            public static final int $stable = 0;
            public static final LoadItems INSTANCE = new LoadItems();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadItems)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 579851565;
            }

            public String toString() {
                return "LoadItems";
            }

            private LoadItems() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$RefreshItems;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "isPullToRefresh", "", "<init>", "(Z)V", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshItems extends Action {
            public static final int $stable = 0;
            private final boolean isPullToRefresh;

            public RefreshItems() {
                this(false, 1, null);
            }

            public static /* synthetic */ RefreshItems copy$default(RefreshItems refreshItems, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = refreshItems.isPullToRefresh;
                }
                return refreshItems.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsPullToRefresh() {
                return this.isPullToRefresh;
            }

            public final RefreshItems copy(boolean isPullToRefresh) {
                return new RefreshItems(isPullToRefresh);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RefreshItems) && this.isPullToRefresh == ((RefreshItems) other).isPullToRefresh;
            }

            public int hashCode() {
                return Boolean.hashCode(this.isPullToRefresh);
            }

            public String toString() {
                return "RefreshItems(isPullToRefresh=" + this.isPullToRefresh + ")";
            }

            public RefreshItems(boolean z) {
                super(null);
                this.isPullToRefresh = z;
            }

            public /* synthetic */ RefreshItems(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? false : z);
            }

            public final boolean isPullToRefresh() {
                return this.isPullToRefresh;
            }
        }

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$ItemsLoaded;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Ljava/util/List;)V", "getItems", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemsLoaded extends Action {
            public static final int $stable = 8;
            private final List<ItemModel> items;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ItemsLoaded copy$default(ItemsLoaded itemsLoaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = itemsLoaded.items;
                }
                return itemsLoaded.copy(list);
            }

            public final List<ItemModel> component1() {
                return this.items;
            }

            public final ItemsLoaded copy(List<? extends ItemModel> items) {
                Intrinsics.checkNotNullParameter(items, "items");
                return new ItemsLoaded(items);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemsLoaded) && Intrinsics.areEqual(this.items, ((ItemsLoaded) other).items);
            }

            public int hashCode() {
                return this.items.hashCode();
            }

            public String toString() {
                return "ItemsLoaded(items=" + this.items + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public ItemsLoaded(List<? extends ItemModel> items) {
                super(null);
                Intrinsics.checkNotNullParameter(items, "items");
                this.items = items;
            }

            public final List<ItemModel> getItems() {
                return this.items;
            }
        }

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$ItemAction;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "Lcom/box/android/cpl/EmbeddedItem;", "Lcom/box/android/domain/models/ItemId$Remote;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "id", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;)V", "getId", "()Lcom/box/android/domain/models/ItemId$Remote;", "getAction", "()Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemAction extends Action implements EmbeddedItem<ItemId.Remote, ItemReducer.Action> {
            public static final int $stable = 8;
            private final ItemReducer.Action action;
            private final ItemId.Remote id;

            public static /* synthetic */ ItemAction copy$default(ItemAction itemAction, ItemId.Remote remote, ItemReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    remote = itemAction.id;
                }
                if ((i & 2) != 0) {
                    action = itemAction.action;
                }
                return itemAction.copy(remote, action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemId.Remote getId() {
                return this.id;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final ItemReducer.Action getAction() {
                return this.action;
            }

            public final ItemAction copy(ItemId.Remote id, ItemReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(action, "action");
                return new ItemAction(id, action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ItemAction)) {
                    return false;
                }
                ItemAction itemAction = (ItemAction) other;
                return Intrinsics.areEqual(this.id, itemAction.id) && Intrinsics.areEqual(this.action, itemAction.action);
            }

            public int hashCode() {
                return (this.id.hashCode() * 31) + this.action.hashCode();
            }

            public String toString() {
                return "ItemAction(id=" + this.id + ", action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemAction(ItemId.Remote id, ItemReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(action, "action");
                this.id = id;
                this.action = action;
            }

            public final ItemReducer.Action getAction() {
                return this.action;
            }

            public final ItemId.Remote getId() {
                return this.id;
            }
        }

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$LoadFailed;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$RefreshCompleted;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshCompleted extends Action {
            public static final int $stable = 0;
            public static final RefreshCompleted INSTANCE = new RefreshCompleted();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshCompleted)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -20830307;
            }

            public String toString() {
                return "RefreshCompleted";
            }

            private RefreshCompleted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$RefreshFailed;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$ErrorHandled;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ErrorHandled extends Action {
            public static final int $stable = 0;
            public static final ErrorHandled INSTANCE = new ErrorHandled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ErrorHandled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1521491839;
            }

            public String toString() {
                return "ErrorHandled";
            }

            private ErrorHandled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$Navigate;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "route", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route;", "<init>", "(Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route;)V", "getRoute", "()Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Route;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Navigate extends Action {
            public static final int $stable = 0;
            private final Route route;

            public static /* synthetic */ Navigate copy$default(Navigate navigate, Route route, int i, Object obj) {
                if ((i & 1) != 0) {
                    route = navigate.route;
                }
                return navigate.copy(route);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Route getRoute() {
                return this.route;
            }

            public final Navigate copy(Route route) {
                Intrinsics.checkNotNullParameter(route, "route");
                return new Navigate(route);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Navigate) && Intrinsics.areEqual(this.route, ((Navigate) other).route);
            }

            public int hashCode() {
                return this.route.hashCode();
            }

            public String toString() {
                return "Navigate(route=" + this.route + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Navigate(Route route) {
                super(null);
                Intrinsics.checkNotNullParameter(route, "route");
                this.route = route;
            }

            public final Route getRoute() {
                return this.route;
            }
        }

        /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action$Multiselect;", "Lcom/box/android/collections/presentation/navigationmodernization/collectionitemslist/CollectionItemsListReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/multiselect/MultiselectReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "collections_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Multiselect extends Action implements Embedded<MultiselectReducer.Action> {
            public static final int $stable = MultiselectReducer.Action.$stable;
            private final MultiselectReducer.Action action;

            public static /* synthetic */ Multiselect copy$default(Multiselect multiselect, MultiselectReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = multiselect.action;
                }
                return multiselect.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MultiselectReducer.Action getState() {
                return this.action;
            }

            public final Multiselect copy(MultiselectReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Multiselect(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Multiselect) && Intrinsics.areEqual(this.action, ((Multiselect) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Multiselect(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Multiselect(MultiselectReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final MultiselectReducer.Action getAction() {
                return this.action;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceActions(State state, Action action) {
        if (Intrinsics.areEqual(action, Action.ScreenViewed.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(state, null)));
        }
        if (action instanceof Action.LoadItems) {
            return reduceLoadItems(state);
        }
        if (action instanceof Action.RefreshItems) {
            return reduceRefreshItems(state, ((Action.RefreshItems) action).isPullToRefresh());
        }
        if (action instanceof Action.ItemsLoaded) {
            List<ItemModel> items = ((Action.ItemsLoaded) action).getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add(new ItemReducer.State((ItemModel) it.next(), false, null, null, null, 30, null));
            }
            ItemReducer.State[] stateArr = (ItemReducer.State[]) arrayList.toArray(new ItemReducer.State[0]);
            return new ReducerResult<>(State.copy$default(state, null, IdentifiedListKt.identifiedListOf((Identifiable[]) Arrays.copyOf(stateArr, stateArr.length)), LoadingState.Loaded.INSTANCE, false, null, null, null, 113, null), null, 2, null);
        }
        if (action instanceof Action.LoadFailed) {
            return reduceLoadFailed(state, ((Action.LoadFailed) action).getError());
        }
        if (action instanceof Action.RefreshCompleted) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, 119, null), null, 2, null);
        }
        if (action instanceof Action.RefreshFailed) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, ((Action.RefreshFailed) action).getError(), null, null, 103, null), null, 2, null);
        }
        if (action instanceof Action.ErrorHandled) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, null, null, 111, null), null, 2, null);
        }
        if (action instanceof Action.Navigate) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, ((Action.Navigate) action).getRoute(), null, 95, null), null, 2, null);
        }
        if (action instanceof Action.Multiselect) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.ItemAction) {
            return reduceItemAction(state, (Action.ItemAction) action);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: renamed from: com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$reduceActions$1, reason: invalid class name */
    /* JADX INFO: compiled from: CollectionItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.collections.presentation.navigationmodernization.collectionitemslist.CollectionItemsListReducer$reduceActions$1", f = "CollectionItemsListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ State $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return CollectionItemsListReducer.this.new AnonymousClass1(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CollectionItemsListReducer.this.environment.getAnalytics().collectionItemsListScreenViewed(this.$state.getCollection().getType());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final ReducerResult<State, Action> reduceItemAction(State state, Action.ItemAction action) {
        ItemModel itemModel;
        ItemReducer.Action action2 = action.getAction();
        ItemReducer.State state2 = (ItemReducer.State) state.getItems().getById(action.getId());
        if (state2 == null || (itemModel = state2.getItemModel()) == null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action2 instanceof ItemReducer.Action.Clicked) {
            MultiselectReducer.State multiselect = state.getMultiselect();
            if (!(multiselect instanceof MultiselectReducer.State.Selecting)) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, new Route.OpenItem(itemModel), null, 95, null), null, 2, null);
            }
            if ((itemModel instanceof FolderModel) && ((MultiselectReducer.State.Selecting) multiselect).getSelectionInfo().getAllowFolderNavigation()) {
                return new ReducerResult<>(State.copy$default(state, null, null, null, false, null, new Route.OpenItem(itemModel), null, 95, null), null, 2, null);
            }
            return new ReducerResult<>(state, new Effect(new Action.Multiselect(new MultiselectReducer.Action.Toggle(itemModel))));
        }
        if (action2 instanceof ItemReducer.Action.CheckboxClicked) {
            if (state.getMultiselect() instanceof MultiselectReducer.State.Selecting) {
                return new ReducerResult<>(state, new Effect(new Action.Multiselect(new MultiselectReducer.Action.Toggle(itemModel))));
            }
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action2 instanceof ItemReducer.Action.MenuClicked) {
            return new ReducerResult<>(state, new Effect(new Action.Navigate(new Route.OpenItemMoreActionsMenu(itemModel, state.getCollectionId(), state.getCollectionName()))));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceLoadItems(State state) {
        return new ReducerResult<>(state, EffectKt.toEffect(FlowKt.channelFlow(new CollectionItemsListReducer$reduceLoadItems$effect$1(this, state, null))).cancellable("load_collections_items/" + state.getCollectionId(), true));
    }

    private final ReducerResult<State, Action> reduceRefreshItems(State state, boolean isPullToRefresh) {
        return new ReducerResult<>(State.copy$default(state, null, null, null, isPullToRefresh, null, null, null, 103, null), new Effect((Function1) new CollectionItemsListReducer$reduceRefreshItems$effect$1(this, state, null)));
    }

    private final ReducerResult<State, Action> reduceLoadFailed(State state, DomainError error) {
        State stateCopy$default;
        if (Intrinsics.areEqual(state.getLoadingState(), LoadingState.Loaded.INSTANCE)) {
            stateCopy$default = State.copy$default(state, null, null, null, false, error, null, null, 103, null);
        } else {
            stateCopy$default = State.copy$default(state, null, null, new LoadingState.Error(error), false, null, null, null, 99, null);
        }
        return new ReducerResult<>(stateCopy$default, null, 2, null);
    }
}
