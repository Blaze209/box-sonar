package com.box.android.browse.cpl.recents;

import com.box.android.browse.cpl.helpers.ItemsFilter;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducerKt;
import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.capture.documentscanning.presentation.dialogs.FilterDialog;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.RecentFileModel;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
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

/* JADX INFO: compiled from: RecentsReducer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0014\u0015\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0002H\u0002J$\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$State;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "environment", "Lcom/box/android/browse/cpl/recents/RecentsEnvironment;", "<init>", "(Lcom/box/android/browse/cpl/recents/RecentsEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceRecents", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceChildActionableItemsList", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action$ChildActionableItemsListAction;", "reduceItemsList", "actionableItemAction", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action$ItemsListAction;", "Route", "State", "Action", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RecentsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final RecentsEnvironment environment;

    public RecentsReducer(RecentsEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new RecentsReducer$build$1(this));
        final RecentsReducer$build$2 recentsReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.recents.RecentsReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((RecentsReducer.State) obj).getActionableItemsListState();
            }
        };
        final RecentsReducer$build$3 recentsReducer$build$3 = RecentsReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new ActionableItemsListReducer(environment.getActionableItemsListEnvironment()), new Function1<State, ActionableItemsListReducer.State>() { // from class: com.box.android.browse.cpl.recents.RecentsReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.browse.cpl.itemsList.ActionableItemsListReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final ActionableItemsListReducer.State invoke(RecentsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return recentsReducer$build$2.invoke(it);
            }
        }, new Function1<Action, ActionableItemsListReducer.Action>() { // from class: com.box.android.browse.cpl.recents.RecentsReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final ActionableItemsListReducer.Action invoke(RecentsReducer.Action action) {
                if (!(action instanceof RecentsReducer.Action.ChildActionableItemsListAction)) {
                    action = null;
                }
                RecentsReducer.Action.ChildActionableItemsListAction childActionableItemsListAction = (RecentsReducer.Action.ChildActionableItemsListAction) action;
                if (childActionableItemsListAction != null) {
                    return childActionableItemsListAction.getAction();
                }
                return null;
            }
        }, new Function2<State, ActionableItemsListReducer.State, State>() { // from class: com.box.android.browse.cpl.recents.RecentsReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final RecentsReducer.State invoke(RecentsReducer.State parentState, ActionableItemsListReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = recentsReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(RecentsReducer.State.class)).iterator();
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
                            return (RecentsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.recents.RecentsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ActionableItemsListReducer.Action, Action>() { // from class: com.box.android.browse.cpl.recents.RecentsReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final RecentsReducer.Action invoke(ActionableItemsListReducer.Action action) {
                Object objInvoke = recentsReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (RecentsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.browse.cpl.recents.RecentsReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: RecentsReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsReducer$Route;", "", "<init>", "()V", "File", "ItemAction", "None", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Route$File;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Route$ItemAction;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Route$None;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Route {
        public static final int $stable = 0;

        public /* synthetic */ Route(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: RecentsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsReducer$Route$File;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/domain/models/item/RecentFileModel;", "file", "<init>", "(Lcom/box/android/domain/models/item/RecentFileModel;)V", "getFile", "()Lcom/box/android/domain/models/item/RecentFileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class File extends Route implements Embedded<RecentFileModel> {
            public static final int $stable = 8;
            private final RecentFileModel file;

            public static /* synthetic */ File copy$default(File file, RecentFileModel recentFileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    recentFileModel = file.file;
                }
                return file.copy(recentFileModel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final RecentFileModel getAction() {
                return this.file;
            }

            public final File copy(RecentFileModel file) {
                Intrinsics.checkNotNullParameter(file, "file");
                return new File(file);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof File) && Intrinsics.areEqual(this.file, ((File) other).file);
            }

            public int hashCode() {
                return this.file.hashCode();
            }

            public String toString() {
                return "File(file=" + this.file + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public File(RecentFileModel file) {
                super(null);
                Intrinsics.checkNotNullParameter(file, "file");
                this.file = file;
            }

            public final RecentFileModel getFile() {
                return this.file;
            }
        }

        private Route() {
        }

        /* JADX INFO: compiled from: RecentsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsReducer$Route$ItemAction;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "route", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;)V", "getRoute", "()Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Route;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemAction extends Route implements Embedded<ActionableItemsListReducer.Route> {
            public static final int $stable = 0;
            private final ActionableItemsListReducer.Route route;

            public static /* synthetic */ ItemAction copy$default(ItemAction itemAction, ActionableItemsListReducer.Route route, int i, Object obj) {
                if ((i & 1) != 0) {
                    route = itemAction.route;
                }
                return itemAction.copy(route);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ActionableItemsListReducer.Route getAction() {
                return this.route;
            }

            public final ItemAction copy(ActionableItemsListReducer.Route route) {
                Intrinsics.checkNotNullParameter(route, "route");
                return new ItemAction(route);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemAction) && Intrinsics.areEqual(this.route, ((ItemAction) other).route);
            }

            public int hashCode() {
                return this.route.hashCode();
            }

            public String toString() {
                return "ItemAction(route=" + this.route + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemAction(ActionableItemsListReducer.Route route) {
                super(null);
                Intrinsics.checkNotNullParameter(route, "route");
                this.route = route;
            }

            public final ActionableItemsListReducer.Route getRoute() {
                return this.route;
            }
        }

        /* JADX INFO: compiled from: RecentsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsReducer$Route$None;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Route;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class None extends Route {
            public static final int $stable = 0;
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: RecentsReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J'\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsReducer$State;", "", "actionableItemsListState", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "navigationRoute", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Route;", ViewProps.VISIBLE, "", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;Lcom/box/android/browse/cpl/recents/RecentsReducer$Route;Z)V", "getActionableItemsListState", "()Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$State;", "getNavigationRoute", "()Lcom/box/android/browse/cpl/recents/RecentsReducer$Route;", "getVisible", "()Z", FilterDialog.SELECTED_FILTER, "Lcom/box/android/browse/cpl/helpers/ItemsFilter;", "getSelectedFilter", "()Lcom/box/android/browse/cpl/helpers/ItemsFilter;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final ActionableItemsListReducer.State actionableItemsListState;
        private final Route navigationRoute;
        private final ItemsFilter selectedFilter;
        private final boolean visible;

        public static /* synthetic */ State copy$default(State state, ActionableItemsListReducer.State state2, Route route, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                state2 = state.actionableItemsListState;
            }
            if ((i & 2) != 0) {
                route = state.navigationRoute;
            }
            if ((i & 4) != 0) {
                z = state.visible;
            }
            return state.copy(state2, route, z);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ActionableItemsListReducer.State getActionableItemsListState() {
            return this.actionableItemsListState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getVisible() {
            return this.visible;
        }

        public final State copy(ActionableItemsListReducer.State actionableItemsListState, Route navigationRoute, boolean visible) {
            Intrinsics.checkNotNullParameter(actionableItemsListState, "actionableItemsListState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            return new State(actionableItemsListState, navigationRoute, visible);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.actionableItemsListState, state.actionableItemsListState) && Intrinsics.areEqual(this.navigationRoute, state.navigationRoute) && this.visible == state.visible;
        }

        public int hashCode() {
            return (((this.actionableItemsListState.hashCode() * 31) + this.navigationRoute.hashCode()) * 31) + Boolean.hashCode(this.visible);
        }

        public String toString() {
            return "State(actionableItemsListState=" + this.actionableItemsListState + ", navigationRoute=" + this.navigationRoute + ", visible=" + this.visible + ")";
        }

        public State(ActionableItemsListReducer.State actionableItemsListState, Route navigationRoute, boolean z) {
            Intrinsics.checkNotNullParameter(actionableItemsListState, "actionableItemsListState");
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            this.actionableItemsListState = actionableItemsListState;
            this.navigationRoute = navigationRoute;
            this.visible = z;
            this.selectedFilter = actionableItemsListState.getItemsListViewState().getFilesConfigState().getSelectedFilter();
        }

        public final ActionableItemsListReducer.State getActionableItemsListState() {
            return this.actionableItemsListState;
        }

        public /* synthetic */ State(ActionableItemsListReducer.State state, Route.None none, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(state, (i & 2) != 0 ? Route.None.INSTANCE : none, (i & 4) != 0 ? false : z);
        }

        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public final ItemsFilter getSelectedFilter() {
            return this.selectedFilter;
        }
    }

    /* JADX INFO: compiled from: RecentsReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "", "<init>", "()V", "LoadItems", "TabHidden", "TabVisible", "ChildActionableItemsListAction", "NavigationCompleted", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action$ChildActionableItemsListAction;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action$LoadItems;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action$NavigationCompleted;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action$TabHidden;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action$TabVisible;", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: RecentsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsReducer$Action$LoadItems;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class LoadItems extends Action {
            public static final int $stable = 0;
            public static final LoadItems INSTANCE = new LoadItems();

            private LoadItems() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: RecentsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsReducer$Action$TabHidden;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class TabHidden extends Action {
            public static final int $stable = 0;
            public static final TabHidden INSTANCE = new TabHidden();

            private TabHidden() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: RecentsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsReducer$Action$TabVisible;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class TabVisible extends Action {
            public static final int $stable = 0;
            public static final TabVisible INSTANCE = new TabVisible();

            private TabVisible() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: RecentsReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsReducer$Action$ChildActionableItemsListAction;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)V", "getAction", "()Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ChildActionableItemsListAction extends Action implements Embedded<ActionableItemsListReducer.Action> {
            public static final int $stable = 0;
            private final ActionableItemsListReducer.Action action;

            public static /* synthetic */ ChildActionableItemsListAction copy$default(ChildActionableItemsListAction childActionableItemsListAction, ActionableItemsListReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = childActionableItemsListAction.action;
                }
                return childActionableItemsListAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ActionableItemsListReducer.Action getAction() {
                return this.action;
            }

            public final ChildActionableItemsListAction copy(ActionableItemsListReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new ChildActionableItemsListAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ChildActionableItemsListAction) && Intrinsics.areEqual(this.action, ((ChildActionableItemsListAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "ChildActionableItemsListAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ChildActionableItemsListAction(ActionableItemsListReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ActionableItemsListReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: RecentsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/browse/cpl/recents/RecentsReducer$Action$NavigationCompleted;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "<init>", "()V", "browse_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class NavigationCompleted extends Action {
            public static final int $stable = 0;
            public static final NavigationCompleted INSTANCE = new NavigationCompleted();

            private NavigationCompleted() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceRecents(State state, Action action) {
        if (action instanceof Action.ChildActionableItemsListAction) {
            return reduceChildActionableItemsList((Action.ChildActionableItemsListAction) action, state);
        }
        if (Intrinsics.areEqual(action, Action.LoadItems.INSTANCE)) {
            return new ReducerResult<>(state, new Effect(new Action.ChildActionableItemsListAction(ActionableItemsListReducerKt.loadItems(ActionableItemsListReducer.Action.INSTANCE))));
        }
        if (Intrinsics.areEqual(action, Action.TabVisible.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, true, 3, null), new Effect(new Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(ItemsListReducer.Action.ScreenUpdated.INSTANCE))));
        }
        if (Intrinsics.areEqual(action, Action.TabHidden.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, false, 3, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.NavigationCompleted.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, Route.None.INSTANCE, false, 5, null), null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ReducerResult<State, Action> reduceChildActionableItemsList(Action.ChildActionableItemsListAction action, State state) {
        ActionableItemsListReducer.Action action2 = action.getAction();
        if (action2 instanceof ActionableItemsListReducer.Action.ItemsListAction) {
            return reduceItemsList((ActionableItemsListReducer.Action.ItemsListAction) action2, state);
        }
        if (action2 instanceof ActionableItemsListReducer.Action.NavigateTo) {
            return new ReducerResult<>(State.copy$default(state, null, new Route.ItemAction(((ActionableItemsListReducer.Action.NavigateTo) action2).getRoute()), false, 5, null), null, 2, null);
        }
        if ((action2 instanceof ActionableItemsListReducer.Action.NavigationCompleted) || (action2 instanceof ActionableItemsListReducer.Action.ExitMultiselectMode)) {
            return new ReducerResult<>(State.copy$default(state, null, Route.None.INSTANCE, false, 5, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceItemsList(ActionableItemsListReducer.Action.ItemsListAction actionableItemAction, State state) {
        ItemsListReducer.Action itemsListViewAction = actionableItemAction.getItemsListViewAction();
        if (itemsListViewAction instanceof ItemsListReducer.Action.RefreshCompleted) {
            return new ReducerResult<>(state, new Effect(Action.LoadItems.INSTANCE));
        }
        if (itemsListViewAction instanceof ItemsListReducer.Action.OpenItem) {
            ItemReducer.State state2 = (ItemReducer.State) state.getActionableItemsListState().getItemsListViewState().getItems().getById(((ItemsListReducer.Action.OpenItem) itemsListViewAction).getId());
            ItemModel itemModel = state2 != null ? state2.getItemModel() : null;
            Intrinsics.checkNotNull(itemModel, "null cannot be cast to non-null type com.box.android.domain.models.item.RecentFileModel");
            return new ReducerResult<>(State.copy$default(state, null, new Route.File((RecentFileModel) itemModel), false, 5, null), null, 2, null);
        }
        return new ReducerResult<>(state, null, 2, null);
    }
}
