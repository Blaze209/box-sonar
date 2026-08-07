package com.box.android.search.presentation.cpl;

import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import com.box.android.hubs.presentation.HubReducer;
import com.box.android.hubs.presentation.HubsEnvironment;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.UUID;
import kotlin.Metadata;
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

/* JADX INFO: compiled from: SearchItemReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\r\u000e\u000f\u0010B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchItemReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$State;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action;", "environment", "Lcom/box/android/search/presentation/cpl/SearchEnvironment;", "<init>", "(Lcom/box/android/search/presentation/cpl/SearchEnvironment;)V", "getEnvironment", "()Lcom/box/android/search/presentation/cpl/SearchEnvironment;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "State", "Action", "SearchItem", "NoteActionType", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SearchItemReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final SearchEnvironment environment;

    public SearchItemReducer(SearchEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new Function2() { // from class: com.box.android.search.presentation.cpl.SearchItemReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SearchItemReducer.build$lambda$0((SearchItemReducer.State) obj, (SearchItemReducer.Action) obj2);
            }
        });
        final SearchItemReducer$build$2 searchItemReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.search.presentation.cpl.SearchItemReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((SearchItemReducer.State) obj).getSearchItem();
            }
        };
        final SearchItemReducer$build$3 searchItemReducer$build$3 = SearchItemReducer$build$3.INSTANCE;
        final SearchItemReducer$build$4 searchItemReducer$build$4 = SearchItemReducer$build$4.INSTANCE;
        HubsEnvironment hubsEnvironment = environment.getHubsEnvironment();
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        IfLetReducer ifLetReducer = new IfLetReducer(reduce, new HubReducer(hubsEnvironment, string), new Function1<State, HubReducer.State>() { // from class: com.box.android.search.presentation.cpl.SearchItemReducer$special$$inlined$ifCaseScope$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final HubReducer.State invoke(SearchItemReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = searchItemReducer$build$2.invoke(it);
                if (!(objInvoke instanceof SearchItemReducer.SearchItem.HubItem)) {
                    objInvoke = null;
                }
                SearchItemReducer.SearchItem.HubItem hubItem = (SearchItemReducer.SearchItem.HubItem) objInvoke;
                if (hubItem != null) {
                    return hubItem.getState();
                }
                return null;
            }
        }, new Function1<Action, HubReducer.Action>() { // from class: com.box.android.search.presentation.cpl.SearchItemReducer$special$$inlined$ifCaseScope$2
            @Override // kotlin.jvm.functions.Function1
            public final HubReducer.Action invoke(SearchItemReducer.Action action) {
                if (!(action instanceof SearchItemReducer.Action.HubAction)) {
                    action = null;
                }
                SearchItemReducer.Action.HubAction hubAction = (SearchItemReducer.Action.HubAction) action;
                if (hubAction != null) {
                    return hubAction.getState();
                }
                return null;
            }
        }, new Function2<State, HubReducer.State, State>() { // from class: com.box.android.search.presentation.cpl.SearchItemReducer$special$$inlined$ifCaseScope$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final SearchItemReducer.State invoke(SearchItemReducer.State parentState, HubReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = searchItemReducer$build$2;
                Object objInvoke = searchItemReducer$build$3.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(SearchItemReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, objInvoke)));
                        if (rCallBy != 0) {
                            return (SearchItemReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchItemReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<HubReducer.Action, Action>() { // from class: com.box.android.search.presentation.cpl.SearchItemReducer$special$$inlined$ifCaseScope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final SearchItemReducer.Action invoke(HubReducer.Action action) {
                Object objInvoke = searchItemReducer$build$4.invoke(action);
                if (objInvoke != null) {
                    return (SearchItemReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchItemReducer.Action");
            }
        });
        final SearchItemReducer$build$6 searchItemReducer$build$6 = new PropertyReference1Impl() { // from class: com.box.android.search.presentation.cpl.SearchItemReducer$build$6
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((SearchItemReducer.State) obj).getSearchItem();
            }
        };
        final SearchItemReducer$build$7 searchItemReducer$build$7 = SearchItemReducer$build$7.INSTANCE;
        final SearchItemReducer$build$8 searchItemReducer$build$8 = SearchItemReducer$build$8.INSTANCE;
        this.build = new IfLetReducer(ifLetReducer, new ItemReducer(environment.getItemEnvironment()), new Function1<State, ItemReducer.State>() { // from class: com.box.android.search.presentation.cpl.SearchItemReducer$special$$inlined$ifCaseScope$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ItemReducer.State invoke(SearchItemReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object objInvoke = searchItemReducer$build$6.invoke(it);
                if (!(objInvoke instanceof SearchItemReducer.SearchItem.FileItem)) {
                    objInvoke = null;
                }
                SearchItemReducer.SearchItem.FileItem fileItem = (SearchItemReducer.SearchItem.FileItem) objInvoke;
                if (fileItem != null) {
                    return fileItem.getState();
                }
                return null;
            }
        }, new Function1<Action, ItemReducer.Action>() { // from class: com.box.android.search.presentation.cpl.SearchItemReducer$special$$inlined$ifCaseScope$6
            @Override // kotlin.jvm.functions.Function1
            public final ItemReducer.Action invoke(SearchItemReducer.Action action) {
                if (!(action instanceof SearchItemReducer.Action.FileAction)) {
                    action = null;
                }
                SearchItemReducer.Action.FileAction fileAction = (SearchItemReducer.Action.FileAction) action;
                if (fileAction != null) {
                    return fileAction.getState();
                }
                return null;
            }
        }, new Function2<State, ItemReducer.State, State>() { // from class: com.box.android.search.presentation.cpl.SearchItemReducer$special$$inlined$ifCaseScope$7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final SearchItemReducer.State invoke(SearchItemReducer.State parentState, ItemReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                KProperty1 kProperty1 = searchItemReducer$build$6;
                Object objInvoke = searchItemReducer$build$7.invoke(childState);
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(SearchItemReducer.State.class)).iterator();
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
                        R rCallBy = kFunction.callBy(MapsKt.mapOf(TuplesKt.to(instanceParameter, parentState), TuplesKt.to(kParameter, objInvoke)));
                        if (rCallBy != 0) {
                            return (SearchItemReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchItemReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<ItemReducer.Action, Action>() { // from class: com.box.android.search.presentation.cpl.SearchItemReducer$special$$inlined$ifCaseScope$8
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final SearchItemReducer.Action invoke(ItemReducer.Action action) {
                Object objInvoke = searchItemReducer$build$8.invoke(action);
                if (objInvoke != null) {
                    return (SearchItemReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.search.presentation.cpl.SearchItemReducer.Action");
            }
        });
    }

    public final SearchEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: SearchItemReducer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchItemReducer$State;", "Lcom/box/android/cpl/Identifiable;", "", "id", "searchItem", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$SearchItem;", "accessibleSharedLink", "<init>", "(Ljava/lang/String;Lcom/box/android/search/presentation/cpl/SearchItemReducer$SearchItem;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSearchItem", "()Lcom/box/android/search/presentation/cpl/SearchItemReducer$SearchItem;", "getAccessibleSharedLink", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State implements Identifiable<String> {
        public static final int $stable = 0;
        private final String accessibleSharedLink;
        private final String id;
        private final SearchItem searchItem;

        public static /* synthetic */ State copy$default(State state, String str, SearchItem searchItem, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = state.id;
            }
            if ((i & 2) != 0) {
                searchItem = state.searchItem;
            }
            if ((i & 4) != 0) {
                str2 = state.accessibleSharedLink;
            }
            return state.copy(str, searchItem, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final SearchItem getSearchItem() {
            return this.searchItem;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getAccessibleSharedLink() {
            return this.accessibleSharedLink;
        }

        public final State copy(String id, SearchItem searchItem, String accessibleSharedLink) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(searchItem, "searchItem");
            return new State(id, searchItem, accessibleSharedLink);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.id, state.id) && Intrinsics.areEqual(this.searchItem, state.searchItem) && Intrinsics.areEqual(this.accessibleSharedLink, state.accessibleSharedLink);
        }

        public int hashCode() {
            int iHashCode = ((this.id.hashCode() * 31) + this.searchItem.hashCode()) * 31;
            String str = this.accessibleSharedLink;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "State(id=" + this.id + ", searchItem=" + this.searchItem + ", accessibleSharedLink=" + this.accessibleSharedLink + ")";
        }

        public State(String id, SearchItem searchItem, String str) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(searchItem, "searchItem");
            this.id = id;
            this.searchItem = searchItem;
            this.accessibleSharedLink = str;
        }

        public /* synthetic */ State(String str, SearchItem searchItem, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, searchItem, (i & 4) != 0 ? null : str2);
        }

        public final String getAccessibleSharedLink() {
            return this.accessibleSharedLink;
        }

        @Override // com.box.android.cpl.Identifiable
        public String getId() {
            return this.id;
        }

        public final SearchItem getSearchItem() {
            return this.searchItem;
        }
    }

    /* JADX INFO: compiled from: SearchItemReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action;", "", "<init>", "()V", "HubAction", "FileAction", "NoteAction", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action$FileAction;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action$HubAction;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action$NoteAction;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: SearchItemReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action$HubAction;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/hubs/presentation/HubReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/hubs/presentation/HubReducer$Action;)V", "getAction", "()Lcom/box/android/hubs/presentation/HubReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HubAction extends Action implements Embedded<HubReducer.Action> {
            public static final int $stable = HubReducer.Action.$stable;
            private final HubReducer.Action action;

            public static /* synthetic */ HubAction copy$default(HubAction hubAction, HubReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = hubAction.action;
                }
                return hubAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final HubReducer.Action getState() {
                return this.action;
            }

            public final HubAction copy(HubReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new HubAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof HubAction) && Intrinsics.areEqual(this.action, ((HubAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "HubAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HubAction(HubReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final HubReducer.Action getAction() {
                return this.action;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: SearchItemReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action$FileAction;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;)V", "getAction", "()Lcom/box/android/browse/cpl/itemsList/ItemReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FileAction extends Action implements Embedded<ItemReducer.Action> {
            public static final int $stable = ItemReducer.Action.$stable;
            private final ItemReducer.Action action;

            public static /* synthetic */ FileAction copy$default(FileAction fileAction, ItemReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = fileAction.action;
                }
                return fileAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemReducer.Action getState() {
                return this.action;
            }

            public final FileAction copy(ItemReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new FileAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FileAction) && Intrinsics.areEqual(this.action, ((FileAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "FileAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FileAction(ItemReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final ItemReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: SearchItemReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action$NoteAction;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$Action;", Analytics.Data.ACTION, "Lcom/box/android/search/presentation/cpl/SearchItemReducer$NoteActionType;", "<init>", "(Lcom/box/android/search/presentation/cpl/SearchItemReducer$NoteActionType;)V", "getAction", "()Lcom/box/android/search/presentation/cpl/SearchItemReducer$NoteActionType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NoteAction extends Action {
            public static final int $stable = 0;
            private final NoteActionType action;

            public static /* synthetic */ NoteAction copy$default(NoteAction noteAction, NoteActionType noteActionType, int i, Object obj) {
                if ((i & 1) != 0) {
                    noteActionType = noteAction.action;
                }
                return noteAction.copy(noteActionType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final NoteActionType getAction() {
                return this.action;
            }

            public final NoteAction copy(NoteActionType action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new NoteAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NoteAction) && Intrinsics.areEqual(this.action, ((NoteAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "NoteAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NoteAction(NoteActionType action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final NoteActionType getAction() {
                return this.action;
            }
        }
    }

    /* JADX INFO: compiled from: SearchItemReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchItemReducer$SearchItem;", "", "<init>", "()V", "HubItem", "FileItem", "NoteItem", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$SearchItem$FileItem;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$SearchItem$HubItem;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$SearchItem$NoteItem;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class SearchItem {
        public static final int $stable = 0;

        public /* synthetic */ SearchItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: SearchItemReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchItemReducer$SearchItem$HubItem;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$SearchItem;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/hubs/presentation/HubReducer$State;", "state", "<init>", "(Lcom/box/android/hubs/presentation/HubReducer$State;)V", "getState", "()Lcom/box/android/hubs/presentation/HubReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class HubItem extends SearchItem implements Embedded<HubReducer.State> {
            public static final int $stable = HubReducer.State.$stable;
            private final HubReducer.State state;

            public static /* synthetic */ HubItem copy$default(HubItem hubItem, HubReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = hubItem.state;
                }
                return hubItem.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final HubReducer.State getState() {
                return this.state;
            }

            public final HubItem copy(HubReducer.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new HubItem(state);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof HubItem) && Intrinsics.areEqual(this.state, ((HubItem) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "HubItem(state=" + this.state + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HubItem(HubReducer.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final HubReducer.State getState() {
                return this.state;
            }
        }

        private SearchItem() {
        }

        /* JADX INFO: compiled from: SearchItemReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchItemReducer$SearchItem$FileItem;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$SearchItem;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", "state", "<init>", "(Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;)V", "getState", "()Lcom/box/android/browse/cpl/itemsList/ItemReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FileItem extends SearchItem implements Embedded<ItemReducer.State> {
            public static final int $stable = ItemReducer.State.$stable;
            private final ItemReducer.State state;

            public static /* synthetic */ FileItem copy$default(FileItem fileItem, ItemReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = fileItem.state;
                }
                return fileItem.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ItemReducer.State getState() {
                return this.state;
            }

            public final FileItem copy(ItemReducer.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new FileItem(state);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof FileItem) && Intrinsics.areEqual(this.state, ((FileItem) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "FileItem(state=" + this.state + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FileItem(ItemReducer.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final ItemReducer.State getState() {
                return this.state;
            }
        }

        /* JADX INFO: compiled from: SearchItemReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchItemReducer$SearchItem$NoteItem;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$SearchItem;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NoteItem extends SearchItem {
            public static final int $stable = 8;
            private final FileModel fileModel;

            public static /* synthetic */ NoteItem copy$default(NoteItem noteItem, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = noteItem.fileModel;
                }
                return noteItem.copy(fileModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final NoteItem copy(FileModel fileModel) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new NoteItem(fileModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NoteItem) && Intrinsics.areEqual(this.fileModel, ((NoteItem) other).fileModel);
            }

            public int hashCode() {
                return this.fileModel.hashCode();
            }

            public String toString() {
                return "NoteItem(fileModel=" + this.fileModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NoteItem(FileModel fileModel) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }
        }
    }

    /* JADX INFO: compiled from: SearchItemReducer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchItemReducer$NoteActionType;", "", "<init>", "()V", "Clicked", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$NoteActionType$Clicked;", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class NoteActionType {
        public static final int $stable = 0;

        public /* synthetic */ NoteActionType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: SearchItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/search/presentation/cpl/SearchItemReducer$NoteActionType$Clicked;", "Lcom/box/android/search/presentation/cpl/SearchItemReducer$NoteActionType;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "search_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Clicked extends NoteActionType {
            public static final int $stable = 0;
            public static final Clicked INSTANCE = new Clicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Clicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1630687420;
            }

            public String toString() {
                return "Clicked";
            }

            private Clicked() {
                super(null);
            }
        }

        private NoteActionType() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "<unused var>");
        return new ReducerResult(state, null, 2, null);
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }
}
