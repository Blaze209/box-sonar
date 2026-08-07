package com.box.android.inbox.notifications;

import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
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

/* JADX INFO: compiled from: InboxReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u000f\u0010\u0011B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/InboxReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/inbox/notifications/InboxReducer$State;", "Lcom/box/android/inbox/notifications/InboxReducer$Action;", "environment", "Lcom/box/android/inbox/notifications/InboxEnvironment;", "<init>", "(Lcom/box/android/inbox/notifications/InboxEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceInbox", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "Route", "State", "Action", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final InboxEnvironment environment;

    /* JADX INFO: compiled from: InboxReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/inbox/notifications/InboxReducer$Route;", "", "<init>", "()V", "NotificationDetail", "None", "Lcom/box/android/inbox/notifications/InboxReducer$Route$None;", "Lcom/box/android/inbox/notifications/InboxReducer$Route$NotificationDetail;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Route {
        public static final int $stable = 0;

        public /* synthetic */ Route(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: InboxReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/inbox/notifications/InboxReducer$Route$NotificationDetail;", "Lcom/box/android/inbox/notifications/InboxReducer$Route;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "notification", "<init>", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;)V", "getNotification", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NotificationDetail extends Route implements Embedded<InboxNotificationModel> {
            public static final int $stable = 8;
            private final InboxNotificationModel notification;

            public static /* synthetic */ NotificationDetail copy$default(NotificationDetail notificationDetail, InboxNotificationModel inboxNotificationModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    inboxNotificationModel = notificationDetail.notification;
                }
                return notificationDetail.copy(inboxNotificationModel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InboxNotificationModel getAction() {
                return this.notification;
            }

            public final NotificationDetail copy(InboxNotificationModel notification) {
                Intrinsics.checkNotNullParameter(notification, "notification");
                return new NotificationDetail(notification);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NotificationDetail) && Intrinsics.areEqual(this.notification, ((NotificationDetail) other).notification);
            }

            public int hashCode() {
                return this.notification.hashCode();
            }

            public String toString() {
                return "NotificationDetail(notification=" + this.notification + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NotificationDetail(InboxNotificationModel notification) {
                super(null);
                Intrinsics.checkNotNullParameter(notification, "notification");
                this.notification = notification;
            }

            public final InboxNotificationModel getNotification() {
                return this.notification;
            }
        }

        private Route() {
        }

        /* JADX INFO: compiled from: InboxReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/InboxReducer$Route$None;", "Lcom/box/android/inbox/notifications/InboxReducer$Route;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -603005720;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }
    }

    public InboxReducer(InboxEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new InboxReducer$build$1(this));
        final InboxReducer$build$2 inboxReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.inbox.notifications.InboxReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((InboxReducer.State) obj).getItemsListState();
            }
        };
        final InboxReducer$build$3 inboxReducer$build$3 = InboxReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new InboxItemsListReducer(environment.getInboxItemsListEnvironment()), new Function1<State, InboxItemsListReducer.State>() { // from class: com.box.android.inbox.notifications.InboxReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.inbox.notifications.InboxItemsListReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final InboxItemsListReducer.State invoke(InboxReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return inboxReducer$build$2.invoke(it);
            }
        }, new Function1<Action, InboxItemsListReducer.Action>() { // from class: com.box.android.inbox.notifications.InboxReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final InboxItemsListReducer.Action invoke(InboxReducer.Action action) {
                if (!(action instanceof InboxReducer.Action.ItemsListAction)) {
                    action = null;
                }
                InboxReducer.Action.ItemsListAction itemsListAction = (InboxReducer.Action.ItemsListAction) action;
                if (itemsListAction != null) {
                    return itemsListAction.getAction();
                }
                return null;
            }
        }, new Function2<State, InboxItemsListReducer.State, State>() { // from class: com.box.android.inbox.notifications.InboxReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final InboxReducer.State invoke(InboxReducer.State parentState, InboxItemsListReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = inboxReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(InboxReducer.State.class)).iterator();
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
                            return (InboxReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.inbox.notifications.InboxReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<InboxItemsListReducer.Action, Action>() { // from class: com.box.android.inbox.notifications.InboxReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final InboxReducer.Action invoke(InboxItemsListReducer.Action action) {
                Object objInvoke = inboxReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (InboxReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.inbox.notifications.InboxReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: InboxReducer.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/box/android/inbox/notifications/InboxReducer$State;", "", "navigationRoute", "Lcom/box/android/inbox/notifications/InboxReducer$Route;", "itemsListState", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$State;", "eventTypeFilter", "", "<init>", "(Lcom/box/android/inbox/notifications/InboxReducer$Route;Lcom/box/android/inbox/notifications/InboxItemsListReducer$State;Ljava/lang/String;)V", "getNavigationRoute", "()Lcom/box/android/inbox/notifications/InboxReducer$Route;", "getItemsListState", "()Lcom/box/android/inbox/notifications/InboxItemsListReducer$State;", "getEventTypeFilter", "()Ljava/lang/String;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final String eventTypeFilter;
        private final InboxItemsListReducer.State itemsListState;
        private final Route navigationRoute;

        public State() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ State copy$default(State state, Route route, InboxItemsListReducer.State state2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                route = state.navigationRoute;
            }
            if ((i & 2) != 0) {
                state2 = state.itemsListState;
            }
            if ((i & 4) != 0) {
                str = state.eventTypeFilter;
            }
            return state.copy(route, state2, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final InboxItemsListReducer.State getItemsListState() {
            return this.itemsListState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getEventTypeFilter() {
            return this.eventTypeFilter;
        }

        public final State copy(Route navigationRoute, InboxItemsListReducer.State itemsListState, String eventTypeFilter) {
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            Intrinsics.checkNotNullParameter(itemsListState, "itemsListState");
            return new State(navigationRoute, itemsListState, eventTypeFilter);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.navigationRoute, state.navigationRoute) && Intrinsics.areEqual(this.itemsListState, state.itemsListState) && Intrinsics.areEqual(this.eventTypeFilter, state.eventTypeFilter);
        }

        public int hashCode() {
            int iHashCode = ((this.navigationRoute.hashCode() * 31) + this.itemsListState.hashCode()) * 31;
            String str = this.eventTypeFilter;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "State(navigationRoute=" + this.navigationRoute + ", itemsListState=" + this.itemsListState + ", eventTypeFilter=" + this.eventTypeFilter + ")";
        }

        public State(Route navigationRoute, InboxItemsListReducer.State itemsListState, String str) {
            Intrinsics.checkNotNullParameter(navigationRoute, "navigationRoute");
            Intrinsics.checkNotNullParameter(itemsListState, "itemsListState");
            this.navigationRoute = navigationRoute;
            this.itemsListState = itemsListState;
            this.eventTypeFilter = str;
        }

        public /* synthetic */ State(Route.None none, InboxItemsListReducer.State state, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Route.None.INSTANCE : none, (i & 2) != 0 ? new InboxItemsListReducer.State(null, null, false, false, null, null, 63, null) : state, (i & 4) != 0 ? null : str);
        }

        public final Route getNavigationRoute() {
            return this.navigationRoute;
        }

        public final InboxItemsListReducer.State getItemsListState() {
            return this.itemsListState;
        }

        public final String getEventTypeFilter() {
            return this.eventTypeFilter;
        }
    }

    /* JADX INFO: compiled from: InboxReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/InboxReducer$Action;", "", "<init>", "()V", "SetEventTypeFilter", "NavigateToNotification", "NavigationCompleted", "ItemsListAction", "Lcom/box/android/inbox/notifications/InboxReducer$Action$ItemsListAction;", "Lcom/box/android/inbox/notifications/InboxReducer$Action$NavigateToNotification;", "Lcom/box/android/inbox/notifications/InboxReducer$Action$NavigationCompleted;", "Lcom/box/android/inbox/notifications/InboxReducer$Action$SetEventTypeFilter;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: InboxReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/inbox/notifications/InboxReducer$Action$SetEventTypeFilter;", "Lcom/box/android/inbox/notifications/InboxReducer$Action;", ViewProps.FILTER, "", "<init>", "(Ljava/lang/String;)V", "getFilter", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SetEventTypeFilter extends Action {
            public static final int $stable = 0;
            private final String filter;

            public static /* synthetic */ SetEventTypeFilter copy$default(SetEventTypeFilter setEventTypeFilter, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = setEventTypeFilter.filter;
                }
                return setEventTypeFilter.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getFilter() {
                return this.filter;
            }

            public final SetEventTypeFilter copy(String filter) {
                return new SetEventTypeFilter(filter);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SetEventTypeFilter) && Intrinsics.areEqual(this.filter, ((SetEventTypeFilter) other).filter);
            }

            public int hashCode() {
                String str = this.filter;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "SetEventTypeFilter(filter=" + this.filter + ")";
            }

            public SetEventTypeFilter(String str) {
                super(null);
                this.filter = str;
            }

            public final String getFilter() {
                return this.filter;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: InboxReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/InboxReducer$Action$NavigateToNotification;", "Lcom/box/android/inbox/notifications/InboxReducer$Action;", "notification", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "<init>", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;)V", "getNotification", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigateToNotification extends Action {
            public static final int $stable = 8;
            private final InboxNotificationModel notification;

            public static /* synthetic */ NavigateToNotification copy$default(NavigateToNotification navigateToNotification, InboxNotificationModel inboxNotificationModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    inboxNotificationModel = navigateToNotification.notification;
                }
                return navigateToNotification.copy(inboxNotificationModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InboxNotificationModel getNotification() {
                return this.notification;
            }

            public final NavigateToNotification copy(InboxNotificationModel notification) {
                Intrinsics.checkNotNullParameter(notification, "notification");
                return new NavigateToNotification(notification);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NavigateToNotification) && Intrinsics.areEqual(this.notification, ((NavigateToNotification) other).notification);
            }

            public int hashCode() {
                return this.notification.hashCode();
            }

            public String toString() {
                return "NavigateToNotification(notification=" + this.notification + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NavigateToNotification(InboxNotificationModel notification) {
                super(null);
                Intrinsics.checkNotNullParameter(notification, "notification");
                this.notification = notification;
            }

            public final InboxNotificationModel getNotification() {
                return this.notification;
            }
        }

        /* JADX INFO: compiled from: InboxReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/InboxReducer$Action$NavigationCompleted;", "Lcom/box/android/inbox/notifications/InboxReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NavigationCompleted extends Action {
            public static final int $stable = 0;
            public static final NavigationCompleted INSTANCE = new NavigationCompleted();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof NavigationCompleted)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 235105738;
            }

            public String toString() {
                return "NavigationCompleted";
            }

            private NavigationCompleted() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: InboxReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/inbox/notifications/InboxReducer$Action$ItemsListAction;", "Lcom/box/android/inbox/notifications/InboxReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;)V", "getAction", "()Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemsListAction extends Action implements Embedded<InboxItemsListReducer.Action> {
            public static final int $stable = 0;
            private final InboxItemsListReducer.Action action;

            public static /* synthetic */ ItemsListAction copy$default(ItemsListAction itemsListAction, InboxItemsListReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = itemsListAction.action;
                }
                return itemsListAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InboxItemsListReducer.Action getAction() {
                return this.action;
            }

            public final ItemsListAction copy(InboxItemsListReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new ItemsListAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ItemsListAction) && Intrinsics.areEqual(this.action, ((ItemsListAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "ItemsListAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ItemsListAction(InboxItemsListReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final InboxItemsListReducer.Action getAction() {
                return this.action;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceInbox(State state, Action action) {
        if (action instanceof Action.SetEventTypeFilter) {
            Action.SetEventTypeFilter setEventTypeFilter = (Action.SetEventTypeFilter) action;
            return new ReducerResult<>(State.copy$default(state, null, null, setEventTypeFilter.getFilter(), 3, null), new Effect(new Action.ItemsListAction(new InboxItemsListReducer.Action.SetEventTypeFilter(setEventTypeFilter.getFilter()))));
        }
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        if (action instanceof Action.NavigateToNotification) {
            return new ReducerResult<>(State.copy$default(state, new Route.NotificationDetail(((Action.NavigateToNotification) action).getNotification()), null, null, 6, null), effect, i, objArr5 == true ? 1 : 0);
        }
        if (action instanceof Action.NavigationCompleted) {
            return new ReducerResult<>(State.copy$default(state, Route.None.INSTANCE, null, null, 6, null), objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (!(action instanceof Action.ItemsListAction)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }
}
