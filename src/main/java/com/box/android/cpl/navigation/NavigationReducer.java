package com.box.android.cpl.navigation;

import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.browse.cpl.offlined.OfflinedReducer;
import com.box.android.browse.cpl.recents.RecentsReducer;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: NavigationReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0013\u0014\u0015\u0016B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/cpl/navigation/NavigationReducer$State;", "Lcom/box/android/cpl/navigation/NavigationReducer$Action;", "environment", "Lcom/box/android/cpl/navigation/NavigationEnvironment;", "<init>", "(Lcom/box/android/cpl/navigation/NavigationEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "getNewTabVisibleAction", "newTab", "Lcom/box/android/cpl/navigation/NavigationReducer$Tab;", "getOldTabHiddenAction", "oldTab", "getTabChangedAction", "folderIdOfNewTab", "", "State", "Tab", "ToolbarState", "Action", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final NavigationEnvironment environment;

    /* JADX INFO: compiled from: NavigationReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Tab.values().length];
            try {
                iArr[Tab.ALL_FILES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Tab.OFFLINE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Tab.RECENTS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NavigationReducer(NavigationEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new Function2() { // from class: com.box.android.cpl.navigation.NavigationReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NavigationReducer.build$lambda$0(this.f$0, (NavigationReducer.State) obj, (NavigationReducer.Action) obj2);
            }
        });
        final NavigationReducer$build$2 navigationReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.cpl.navigation.NavigationReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((NavigationReducer.State) obj).getBrowseState();
            }
        };
        final NavigationReducer$build$3 navigationReducer$build$3 = NavigationReducer$build$3.INSTANCE;
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new BrowseReducer(environment.getBrowseEnvironment()), new Function1<State, BrowseReducer.State>() { // from class: com.box.android.cpl.navigation.NavigationReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.browse.cpl.browse.BrowseReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final BrowseReducer.State invoke(NavigationReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return navigationReducer$build$2.invoke(it);
            }
        }, new Function1<Action, BrowseReducer.Action>() { // from class: com.box.android.cpl.navigation.NavigationReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final BrowseReducer.Action invoke(NavigationReducer.Action action) {
                if (!(action instanceof NavigationReducer.Action.NavigationBrowseAction)) {
                    action = null;
                }
                NavigationReducer.Action.NavigationBrowseAction navigationBrowseAction = (NavigationReducer.Action.NavigationBrowseAction) action;
                if (navigationBrowseAction != null) {
                    return navigationBrowseAction.getCollectionAction();
                }
                return null;
            }
        }, new Function2<State, BrowseReducer.State, State>() { // from class: com.box.android.cpl.navigation.NavigationReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final NavigationReducer.State invoke(NavigationReducer.State parentState, BrowseReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = navigationReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(NavigationReducer.State.class)).iterator();
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
                            return (NavigationReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.cpl.navigation.NavigationReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<BrowseReducer.Action, Action>() { // from class: com.box.android.cpl.navigation.NavigationReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final NavigationReducer.Action invoke(BrowseReducer.Action action) {
                Object objInvoke = navigationReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (NavigationReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.cpl.navigation.NavigationReducer.Action");
            }
        });
        final NavigationReducer$build$5 navigationReducer$build$5 = new PropertyReference1Impl() { // from class: com.box.android.cpl.navigation.NavigationReducer$build$5
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((NavigationReducer.State) obj).getRecentsState();
            }
        };
        final NavigationReducer$build$6 navigationReducer$build$6 = NavigationReducer$build$6.INSTANCE;
        IfLetReducer ifLetReducer2 = new IfLetReducer(ifLetReducer, new RecentsReducer(environment.getRecentsEnvironment()), new Function1<State, RecentsReducer.State>() { // from class: com.box.android.cpl.navigation.NavigationReducer$special$$inlined$scope$5
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.browse.cpl.recents.RecentsReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final RecentsReducer.State invoke(NavigationReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return navigationReducer$build$5.invoke(it);
            }
        }, new Function1<Action, RecentsReducer.Action>() { // from class: com.box.android.cpl.navigation.NavigationReducer$special$$inlined$scope$6
            @Override // kotlin.jvm.functions.Function1
            public final RecentsReducer.Action invoke(NavigationReducer.Action action) {
                if (!(action instanceof NavigationReducer.Action.NavigationRecentsAction)) {
                    action = null;
                }
                NavigationReducer.Action.NavigationRecentsAction navigationRecentsAction = (NavigationReducer.Action.NavigationRecentsAction) action;
                if (navigationRecentsAction != null) {
                    return navigationRecentsAction.getCollectionAction();
                }
                return null;
            }
        }, new Function2<State, RecentsReducer.State, State>() { // from class: com.box.android.cpl.navigation.NavigationReducer$special$$inlined$scope$7
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final NavigationReducer.State invoke(NavigationReducer.State parentState, RecentsReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = navigationReducer$build$5;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(NavigationReducer.State.class)).iterator();
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
                            return (NavigationReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.cpl.navigation.NavigationReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<RecentsReducer.Action, Action>() { // from class: com.box.android.cpl.navigation.NavigationReducer$special$$inlined$scope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final NavigationReducer.Action invoke(RecentsReducer.Action action) {
                Object objInvoke = navigationReducer$build$6.invoke(action);
                if (objInvoke != null) {
                    return (NavigationReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.cpl.navigation.NavigationReducer.Action");
            }
        });
        final NavigationReducer$build$8 navigationReducer$build$8 = new PropertyReference1Impl() { // from class: com.box.android.cpl.navigation.NavigationReducer$build$8
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((NavigationReducer.State) obj).getOfflinedState();
            }
        };
        final NavigationReducer$build$9 navigationReducer$build$9 = NavigationReducer$build$9.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer2, new OfflinedReducer(environment.getOfflinedEnvironment()), new Function1<State, OfflinedReducer.State>() { // from class: com.box.android.cpl.navigation.NavigationReducer$special$$inlined$scope$9
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.browse.cpl.offlined.OfflinedReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final OfflinedReducer.State invoke(NavigationReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return navigationReducer$build$8.invoke(it);
            }
        }, new Function1<Action, OfflinedReducer.Action>() { // from class: com.box.android.cpl.navigation.NavigationReducer$special$$inlined$scope$10
            @Override // kotlin.jvm.functions.Function1
            public final OfflinedReducer.Action invoke(NavigationReducer.Action action) {
                if (!(action instanceof NavigationReducer.Action.NavigationOfflinedAction)) {
                    action = null;
                }
                NavigationReducer.Action.NavigationOfflinedAction navigationOfflinedAction = (NavigationReducer.Action.NavigationOfflinedAction) action;
                if (navigationOfflinedAction != null) {
                    return navigationOfflinedAction.getCollectionAction();
                }
                return null;
            }
        }, new Function2<State, OfflinedReducer.State, State>() { // from class: com.box.android.cpl.navigation.NavigationReducer$special$$inlined$scope$11
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final NavigationReducer.State invoke(NavigationReducer.State parentState, OfflinedReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = navigationReducer$build$8;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(NavigationReducer.State.class)).iterator();
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
                            return (NavigationReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.cpl.navigation.NavigationReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<OfflinedReducer.Action, Action>() { // from class: com.box.android.cpl.navigation.NavigationReducer$special$$inlined$scope$12
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final NavigationReducer.Action invoke(OfflinedReducer.Action action) {
                Object objInvoke = navigationReducer$build$9.invoke(action);
                if (objInvoke != null) {
                    return (NavigationReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.cpl.navigation.NavigationReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: NavigationReducer.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J1\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationReducer$State;", "", "browseState", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "recentsState", "Lcom/box/android/browse/cpl/recents/RecentsReducer$State;", "offlinedState", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$State;", "activeTab", "Lcom/box/android/cpl/navigation/NavigationReducer$Tab;", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseReducer$State;Lcom/box/android/browse/cpl/recents/RecentsReducer$State;Lcom/box/android/browse/cpl/offlined/OfflinedReducer$State;Lcom/box/android/cpl/navigation/NavigationReducer$Tab;)V", "getBrowseState", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "getRecentsState", "()Lcom/box/android/browse/cpl/recents/RecentsReducer$State;", "getOfflinedState", "()Lcom/box/android/browse/cpl/offlined/OfflinedReducer$State;", "getActiveTab", "()Lcom/box/android/cpl/navigation/NavigationReducer$Tab;", "toolbarState", "Lcom/box/android/cpl/navigation/NavigationReducer$ToolbarState;", "getToolbarState", "()Lcom/box/android/cpl/navigation/NavigationReducer$ToolbarState;", "component1", "component2", "component3", "component4", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = (OfflinedReducer.State.$stable | RecentsReducer.State.$stable) | BrowseReducer.State.$stable;
        private final Tab activeTab;
        private final BrowseReducer.State browseState;
        private final OfflinedReducer.State offlinedState;
        private final RecentsReducer.State recentsState;
        private final ToolbarState toolbarState;

        public static /* synthetic */ State copy$default(State state, BrowseReducer.State state2, RecentsReducer.State state3, OfflinedReducer.State state4, Tab tab, int i, Object obj) {
            if ((i & 1) != 0) {
                state2 = state.browseState;
            }
            if ((i & 2) != 0) {
                state3 = state.recentsState;
            }
            if ((i & 4) != 0) {
                state4 = state.offlinedState;
            }
            if ((i & 8) != 0) {
                tab = state.activeTab;
            }
            return state.copy(state2, state3, state4, tab);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final BrowseReducer.State getBrowseState() {
            return this.browseState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final RecentsReducer.State getRecentsState() {
            return this.recentsState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final OfflinedReducer.State getOfflinedState() {
            return this.offlinedState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Tab getActiveTab() {
            return this.activeTab;
        }

        public final State copy(BrowseReducer.State browseState, RecentsReducer.State recentsState, OfflinedReducer.State offlinedState, Tab activeTab) {
            Intrinsics.checkNotNullParameter(browseState, "browseState");
            Intrinsics.checkNotNullParameter(recentsState, "recentsState");
            Intrinsics.checkNotNullParameter(offlinedState, "offlinedState");
            Intrinsics.checkNotNullParameter(activeTab, "activeTab");
            return new State(browseState, recentsState, offlinedState, activeTab);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.browseState, state.browseState) && Intrinsics.areEqual(this.recentsState, state.recentsState) && Intrinsics.areEqual(this.offlinedState, state.offlinedState) && this.activeTab == state.activeTab;
        }

        public int hashCode() {
            return (((((this.browseState.hashCode() * 31) + this.recentsState.hashCode()) * 31) + this.offlinedState.hashCode()) * 31) + this.activeTab.hashCode();
        }

        public String toString() {
            return "State(browseState=" + this.browseState + ", recentsState=" + this.recentsState + ", offlinedState=" + this.offlinedState + ", activeTab=" + this.activeTab + ")";
        }

        public State(BrowseReducer.State browseState, RecentsReducer.State recentsState, OfflinedReducer.State offlinedState, Tab activeTab) {
            Intrinsics.checkNotNullParameter(browseState, "browseState");
            Intrinsics.checkNotNullParameter(recentsState, "recentsState");
            Intrinsics.checkNotNullParameter(offlinedState, "offlinedState");
            Intrinsics.checkNotNullParameter(activeTab, "activeTab");
            this.browseState = browseState;
            this.recentsState = recentsState;
            this.offlinedState = offlinedState;
            this.activeTab = activeTab;
            this.toolbarState = new ToolbarState(CollectionsKt.listOf((Object[]) new Tab[]{Tab.ALL_FILES, Tab.OFFLINE}).contains(activeTab), activeTab == Tab.RECENTS);
        }

        public final BrowseReducer.State getBrowseState() {
            return this.browseState;
        }

        public final RecentsReducer.State getRecentsState() {
            return this.recentsState;
        }

        public final OfflinedReducer.State getOfflinedState() {
            return this.offlinedState;
        }

        public /* synthetic */ State(BrowseReducer.State state, RecentsReducer.State state2, OfflinedReducer.State state3, Tab tab, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(state, state2, state3, (i & 8) != 0 ? Tab.UNKNOWN : tab);
        }

        public final Tab getActiveTab() {
            return this.activeTab;
        }

        public final ToolbarState getToolbarState() {
            return this.toolbarState;
        }
    }

    /* JADX INFO: compiled from: NavigationReducer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationReducer$Tab;", "", "intValue", "", "<init>", "(Ljava/lang/String;II)V", "getIntValue", "()I", "RECENTS", "ALL_FILES", "OFFLINE", "UNKNOWN", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Tab {
        RECENTS(13),
        ALL_FILES(2),
        OFFLINE(8),
        UNKNOWN(0);

        private final int intValue;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);

        public static EnumEntries<Tab> getEntries() {
            return $ENTRIES;
        }

        Tab(int i) {
            this.intValue = i;
        }

        public final int getIntValue() {
            return this.intValue;
        }

        /* JADX INFO: compiled from: NavigationReducer.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationReducer$Tab$Companion;", "", "<init>", "()V", "byValue", "Lcom/box/android/cpl/navigation/NavigationReducer$Tab;", "value", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Code duplicated, block: B:10:0x0017  */
            /* JADX WARN: Code duplicated, block: B:12:0x001a A[RETURN] */
            public final Tab byValue(int value) {
                for (Tab tab : Tab.values()) {
                    if (tab.getIntValue() == value) {
                        if (tab == null) {
                            return Tab.UNKNOWN;
                        }
                        return tab;
                    }
                }
                tab = null;
                if (tab == null) {
                    return Tab.UNKNOWN;
                }
                return tab;
            }
        }
    }

    /* JADX INFO: compiled from: NavigationReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationReducer$ToolbarState;", "", "sortIcon", "", "filterIcon", "<init>", "(ZZ)V", "getSortIcon", "()Z", "getFilterIcon", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ToolbarState {
        public static final int $stable = 0;
        private final boolean filterIcon;
        private final boolean sortIcon;

        /* JADX WARN: Illegal instructions before constructor call */
        public ToolbarState() {
            boolean z = false;
            this(z, z, 3, null);
        }

        public static /* synthetic */ ToolbarState copy$default(ToolbarState toolbarState, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = toolbarState.sortIcon;
            }
            if ((i & 2) != 0) {
                z2 = toolbarState.filterIcon;
            }
            return toolbarState.copy(z, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getSortIcon() {
            return this.sortIcon;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getFilterIcon() {
            return this.filterIcon;
        }

        public final ToolbarState copy(boolean sortIcon, boolean filterIcon) {
            return new ToolbarState(sortIcon, filterIcon);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ToolbarState)) {
                return false;
            }
            ToolbarState toolbarState = (ToolbarState) other;
            return this.sortIcon == toolbarState.sortIcon && this.filterIcon == toolbarState.filterIcon;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.sortIcon) * 31) + Boolean.hashCode(this.filterIcon);
        }

        public String toString() {
            return "ToolbarState(sortIcon=" + this.sortIcon + ", filterIcon=" + this.filterIcon + ")";
        }

        public ToolbarState(boolean z, boolean z2) {
            this.sortIcon = z;
            this.filterIcon = z2;
        }

        public /* synthetic */ ToolbarState(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z, (i & 2) != 0 ? false : z2);
        }

        public final boolean getFilterIcon() {
            return this.filterIcon;
        }

        public final boolean getSortIcon() {
            return this.sortIcon;
        }
    }

    /* JADX INFO: compiled from: NavigationReducer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationReducer$Action;", "", "<init>", "()V", "TabChanged", "ChildScreenClosed", "NavigationBrowseAction", "NavigationRecentsAction", "NavigationOfflinedAction", "Lcom/box/android/cpl/navigation/NavigationReducer$Action$ChildScreenClosed;", "Lcom/box/android/cpl/navigation/NavigationReducer$Action$NavigationBrowseAction;", "Lcom/box/android/cpl/navigation/NavigationReducer$Action$NavigationOfflinedAction;", "Lcom/box/android/cpl/navigation/NavigationReducer$Action$NavigationRecentsAction;", "Lcom/box/android/cpl/navigation/NavigationReducer$Action$TabChanged;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: NavigationReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationReducer$Action$TabChanged;", "Lcom/box/android/cpl/navigation/NavigationReducer$Action;", "browseTabInt", "", "<init>", "(I)V", "getBrowseTabInt", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TabChanged extends Action {
            public static final int $stable = 0;
            private final int browseTabInt;

            public static /* synthetic */ TabChanged copy$default(TabChanged tabChanged, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = tabChanged.browseTabInt;
                }
                return tabChanged.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getBrowseTabInt() {
                return this.browseTabInt;
            }

            public final TabChanged copy(int browseTabInt) {
                return new TabChanged(browseTabInt);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TabChanged) && this.browseTabInt == ((TabChanged) other).browseTabInt;
            }

            public int hashCode() {
                return Integer.hashCode(this.browseTabInt);
            }

            public String toString() {
                return "TabChanged(browseTabInt=" + this.browseTabInt + ")";
            }

            public TabChanged(int i) {
                super(null);
                this.browseTabInt = i;
            }

            public final int getBrowseTabInt() {
                return this.browseTabInt;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: NavigationReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationReducer$Action$ChildScreenClosed;", "Lcom/box/android/cpl/navigation/NavigationReducer$Action;", "<init>", "()V", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ChildScreenClosed extends Action {
            public static final int $stable = 0;
            public static final ChildScreenClosed INSTANCE = new ChildScreenClosed();

            private ChildScreenClosed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: NavigationReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationReducer$Action$NavigationBrowseAction;", "Lcom/box/android/cpl/navigation/NavigationReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "browseAction", "<init>", "(Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;)V", "getBrowseAction", "()Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigationBrowseAction extends Action implements Embedded<BrowseReducer.Action> {
            public static final int $stable = BrowseReducer.Action.$stable;
            private final BrowseReducer.Action browseAction;

            public static /* synthetic */ NavigationBrowseAction copy$default(NavigationBrowseAction navigationBrowseAction, BrowseReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = navigationBrowseAction.browseAction;
                }
                return navigationBrowseAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BrowseReducer.Action getCollectionAction() {
                return this.browseAction;
            }

            public final NavigationBrowseAction copy(BrowseReducer.Action browseAction) {
                Intrinsics.checkNotNullParameter(browseAction, "browseAction");
                return new NavigationBrowseAction(browseAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigationBrowseAction) && Intrinsics.areEqual(this.browseAction, ((NavigationBrowseAction) other).browseAction);
            }

            public int hashCode() {
                return this.browseAction.hashCode();
            }

            public String toString() {
                return "NavigationBrowseAction(browseAction=" + this.browseAction + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigationBrowseAction(BrowseReducer.Action browseAction) {
                super(null);
                Intrinsics.checkNotNullParameter(browseAction, "browseAction");
                this.browseAction = browseAction;
            }

            public final BrowseReducer.Action getBrowseAction() {
                return this.browseAction;
            }
        }

        /* JADX INFO: compiled from: NavigationReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationReducer$Action$NavigationRecentsAction;", "Lcom/box/android/cpl/navigation/NavigationReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "recentsAction", "<init>", "(Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;)V", "getRecentsAction", "()Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigationRecentsAction extends Action implements Embedded<RecentsReducer.Action> {
            public static final int $stable = RecentsReducer.Action.$stable;
            private final RecentsReducer.Action recentsAction;

            public static /* synthetic */ NavigationRecentsAction copy$default(NavigationRecentsAction navigationRecentsAction, RecentsReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = navigationRecentsAction.recentsAction;
                }
                return navigationRecentsAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final RecentsReducer.Action getCollectionAction() {
                return this.recentsAction;
            }

            public final NavigationRecentsAction copy(RecentsReducer.Action recentsAction) {
                Intrinsics.checkNotNullParameter(recentsAction, "recentsAction");
                return new NavigationRecentsAction(recentsAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigationRecentsAction) && Intrinsics.areEqual(this.recentsAction, ((NavigationRecentsAction) other).recentsAction);
            }

            public int hashCode() {
                return this.recentsAction.hashCode();
            }

            public String toString() {
                return "NavigationRecentsAction(recentsAction=" + this.recentsAction + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigationRecentsAction(RecentsReducer.Action recentsAction) {
                super(null);
                Intrinsics.checkNotNullParameter(recentsAction, "recentsAction");
                this.recentsAction = recentsAction;
            }

            public final RecentsReducer.Action getRecentsAction() {
                return this.recentsAction;
            }
        }

        /* JADX INFO: compiled from: NavigationReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/cpl/navigation/NavigationReducer$Action$NavigationOfflinedAction;", "Lcom/box/android/cpl/navigation/NavigationReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "offlinedAction", "<init>", "(Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;)V", "getOfflinedAction", "()Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigationOfflinedAction extends Action implements Embedded<OfflinedReducer.Action> {
            public static final int $stable = OfflinedReducer.Action.$stable;
            private final OfflinedReducer.Action offlinedAction;

            public static /* synthetic */ NavigationOfflinedAction copy$default(NavigationOfflinedAction navigationOfflinedAction, OfflinedReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = navigationOfflinedAction.offlinedAction;
                }
                return navigationOfflinedAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final OfflinedReducer.Action getCollectionAction() {
                return this.offlinedAction;
            }

            public final NavigationOfflinedAction copy(OfflinedReducer.Action offlinedAction) {
                Intrinsics.checkNotNullParameter(offlinedAction, "offlinedAction");
                return new NavigationOfflinedAction(offlinedAction);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigationOfflinedAction) && Intrinsics.areEqual(this.offlinedAction, ((NavigationOfflinedAction) other).offlinedAction);
            }

            public int hashCode() {
                return this.offlinedAction.hashCode();
            }

            public String toString() {
                return "NavigationOfflinedAction(offlinedAction=" + this.offlinedAction + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigationOfflinedAction(OfflinedReducer.Action offlinedAction) {
                super(null);
                Intrinsics.checkNotNullParameter(offlinedAction, "offlinedAction");
                this.offlinedAction = offlinedAction;
            }

            public final OfflinedReducer.Action getOfflinedAction() {
                return this.offlinedAction;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(NavigationReducer navigationReducer, State state, Action action) {
        Effect effectNone;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.TabChanged) {
            Tab activeTab = state.getActiveTab();
            Tab tabByValue = Tab.INSTANCE.byValue(((Action.TabChanged) action).getBrowseTabInt());
            ArrayList arrayList = new ArrayList();
            Action oldTabHiddenAction = navigationReducer.getOldTabHiddenAction(activeTab);
            if (oldTabHiddenAction != null) {
                arrayList.add(oldTabHiddenAction);
            }
            Action newTabVisibleAction = navigationReducer.getNewTabVisibleAction(tabByValue);
            if (newTabVisibleAction != null) {
                arrayList.add(newTabVisibleAction);
            }
            Action tabChangedAction = navigationReducer.getTabChangedAction(tabByValue);
            if (tabChangedAction != null) {
                arrayList.add(tabChangedAction);
            }
            State stateCopy$default = State.copy$default(state, null, null, null, tabByValue, 7, null);
            Effect.Companion companion = Effect.INSTANCE;
            Action[] actionArr = (Action[]) arrayList.toArray(new Action[0]);
            return new ReducerResult(stateCopy$default, companion.merge(Arrays.copyOf(actionArr, actionArr.length)));
        }
        if (Intrinsics.areEqual(action, Action.ChildScreenClosed.INSTANCE)) {
            if (WhenMappings.$EnumSwitchMapping$0[state.getActiveTab().ordinal()] == 1) {
                effectNone = new Effect(new Action.NavigationBrowseAction(BrowseReducer.Action.ChildScreenClosed.INSTANCE));
            } else {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult(state, new Effect((Flow) effectNone));
        }
        return new ReducerResult(state, null, 2, null);
    }

    private final Action getNewTabVisibleAction(Tab newTab) {
        int i = WhenMappings.$EnumSwitchMapping$0[newTab.ordinal()];
        if (i == 1) {
            return new Action.NavigationBrowseAction(BrowseReducer.Action.TabVisible.INSTANCE);
        }
        if (i == 2) {
            return new Action.NavigationOfflinedAction(OfflinedReducer.Action.TabVisible.INSTANCE);
        }
        if (i != 3) {
            return null;
        }
        return new Action.NavigationRecentsAction(RecentsReducer.Action.TabVisible.INSTANCE);
    }

    private final Action getOldTabHiddenAction(Tab oldTab) {
        int i = WhenMappings.$EnumSwitchMapping$0[oldTab.ordinal()];
        if (i == 2) {
            return new Action.NavigationOfflinedAction(OfflinedReducer.Action.TabHidden.INSTANCE);
        }
        if (i != 3) {
            return null;
        }
        return new Action.NavigationRecentsAction(RecentsReducer.Action.TabHidden.INSTANCE);
    }

    private final Action getTabChangedAction(Tab newTab) {
        String strFolderIdOfNewTab = folderIdOfNewTab(newTab);
        return strFolderIdOfNewTab != null ? new Action.NavigationBrowseAction(new BrowseReducer.Action.ChildActionableItemsListAction(new ActionableItemsListReducer.Action.ItemsListAction(new ItemsListReducer.Action.TabChanged(strFolderIdOfNewTab)))) : null;
    }

    private final String folderIdOfNewTab(Tab newTab) {
        int i = WhenMappings.$EnumSwitchMapping$0[newTab.ordinal()];
        if (i == 1) {
            return "0";
        }
        if (i == 2) {
            return "-1";
        }
        if (i != 3) {
            return null;
        }
        return BoxCommonConstants.RECENTS_ROOT_FOLDER_ID;
    }
}
