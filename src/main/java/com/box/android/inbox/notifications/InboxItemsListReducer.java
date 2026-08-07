package com.box.android.inbox.notifications;

import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.EmbeddedItem;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.IdentifiedList;
import com.box.android.cpl.IdentifiedListKt;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.ForEachReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.inboxnotifications.InboxNotificationIteratorModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.domain.services.IInboxNotificationService;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.facebook.react.modules.dialog.AlertFragment;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: InboxItemsListReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\"#$B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\u000e\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0002H\u0002J\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010\u0017\u001a\u00020\u0014H\u0002JD\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001a0\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001a0\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0082@¢\u0006\u0002\u0010!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006%"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$State;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", "environment", "Lcom/box/android/inbox/notifications/InboxItemsListEnvironment;", "<init>", "(Lcom/box/android/inbox/notifications/InboxItemsListEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceItemsList", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceNotificationsLoaded", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$NotificationsLoaded;", "createLoadNotificationsEffect", "Lcom/box/android/cpl/Effect;", "eventTypeFilter", "", "nextMarker", "createMarkAllNotificationsAsSeenEffect", "lastNotificationId", "mergeItems", "Lcom/box/android/cpl/IdentifiedList;", "Lcom/box/android/inbox/notifications/InboxItemReducer$State;", "existing", "new", "", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "isLoadingMore", "", "(Lcom/box/android/cpl/IdentifiedList;Ljava/util/List;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NotificationsState", "State", "Action", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxItemsListReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final InboxItemsListEnvironment environment;

    public InboxItemsListReducer(InboxItemsListEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new InboxItemsListReducer$build$1(this));
        final InboxItemsListReducer$build$2 inboxItemsListReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.inbox.notifications.InboxItemsListReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((InboxItemsListReducer.State) obj).getItems();
            }
        };
        final InboxItemsListReducer$build$3 inboxItemsListReducer$build$3 = InboxItemsListReducer$build$3.INSTANCE;
        this.build = new ForEachReducer(reduce, new InboxItemReducer(environment.getInboxItemEnvironment()), inboxItemsListReducer$build$2, new Function1<Action, EmbeddedItem<String, InboxItemReducer.Action>>() { // from class: com.box.android.inbox.notifications.InboxItemsListReducer$special$$inlined$forEach$1
            @Override // kotlin.jvm.functions.Function1
            public final EmbeddedItem<String, InboxItemReducer.Action> invoke(InboxItemsListReducer.Action action) {
                if (!(action instanceof InboxItemsListReducer.Action.ItemAction)) {
                    action = null;
                }
                return (InboxItemsListReducer.Action.ItemAction) action;
            }
        }, new Function2<State, InboxItemReducer.State, State>() { // from class: com.box.android.inbox.notifications.InboxItemsListReducer$special$$inlined$forEach$2
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final InboxItemsListReducer.State invoke(InboxItemsListReducer.State parentState, InboxItemReducer.State childState) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                Intrinsics.checkNotNullParameter(childState, "childState");
                IdentifiedList identifiedListListByReplacingElement = ((IdentifiedList) inboxItemsListReducer$build$2.get(parentState)).listByReplacingElement(childState);
                KProperty1 kProperty1 = inboxItemsListReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(InboxItemsListReducer.State.class)).iterator();
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
                            return (InboxItemsListReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.inbox.notifications.InboxItemsListReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function2<String, InboxItemReducer.Action, Action>() { // from class: com.box.android.inbox.notifications.InboxItemsListReducer$special$$inlined$forEach$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final InboxItemsListReducer.Action invoke(String id, InboxItemReducer.Action action) {
                Intrinsics.checkNotNullParameter(id, "id");
                Object objInvoke = inboxItemsListReducer$build$3.invoke(id, action);
                if (objInvoke != null) {
                    return (InboxItemsListReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.inbox.notifications.InboxItemsListReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: InboxItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$NotificationsState;", "", "<init>", "()V", "Loading", "FullyLoaded", "Error", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$NotificationsState$Error;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$NotificationsState$FullyLoaded;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$NotificationsState$Loading;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class NotificationsState {
        public static final int $stable = 0;

        public /* synthetic */ NotificationsState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: InboxItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$NotificationsState$Loading;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$NotificationsState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Loading extends NotificationsState {
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
                return 706317294;
            }

            public String toString() {
                return "Loading";
            }

            private Loading() {
                super(null);
            }
        }

        private NotificationsState() {
        }

        /* JADX INFO: compiled from: InboxItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$NotificationsState$FullyLoaded;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$NotificationsState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FullyLoaded extends NotificationsState {
            public static final int $stable = 0;
            public static final FullyLoaded INSTANCE = new FullyLoaded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FullyLoaded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 415878689;
            }

            public String toString() {
                return "FullyLoaded";
            }

            private FullyLoaded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: InboxItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$NotificationsState$Error;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$NotificationsState;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Error extends NotificationsState {
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

    /* JADX INFO: compiled from: InboxItemsListReducer.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003JU\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0001J\u0013\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0013R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0013¨\u0006*"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$State;", "", "notificationsState", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$NotificationsState;", "eventTypeFilter", "", "isRefreshing", "", "isLoadingMore", "nextMarker", AlertFragment.ARG_ITEMS, "Lcom/box/android/cpl/IdentifiedList;", "Lcom/box/android/inbox/notifications/InboxItemReducer$State;", "<init>", "(Lcom/box/android/inbox/notifications/InboxItemsListReducer$NotificationsState;Ljava/lang/String;ZZLjava/lang/String;Lcom/box/android/cpl/IdentifiedList;)V", "getNotificationsState", "()Lcom/box/android/inbox/notifications/InboxItemsListReducer$NotificationsState;", "getEventTypeFilter", "()Ljava/lang/String;", "()Z", "getNextMarker", "getItems", "()Lcom/box/android/cpl/IdentifiedList;", "isEmpty", "error", "Lcom/box/android/domain/models/DomainError;", "getError", "()Lcom/box/android/domain/models/DomainError;", "canLoadMore", "getCanLoadMore", "component1", "component2", "component3", "component4", "component5", "component6", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final String eventTypeFilter;
        private final boolean isLoadingMore;
        private final boolean isRefreshing;
        private final IdentifiedList<String, InboxItemReducer.State> items;
        private final String nextMarker;
        private final NotificationsState notificationsState;

        public State() {
            this(null, null, false, false, null, null, 63, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, NotificationsState notificationsState, String str, boolean z, boolean z2, String str2, IdentifiedList identifiedList, int i, Object obj) {
            if ((i & 1) != 0) {
                notificationsState = state.notificationsState;
            }
            if ((i & 2) != 0) {
                str = state.eventTypeFilter;
            }
            if ((i & 4) != 0) {
                z = state.isRefreshing;
            }
            if ((i & 8) != 0) {
                z2 = state.isLoadingMore;
            }
            if ((i & 16) != 0) {
                str2 = state.nextMarker;
            }
            if ((i & 32) != 0) {
                identifiedList = state.items;
            }
            String str3 = str2;
            IdentifiedList identifiedList2 = identifiedList;
            return state.copy(notificationsState, str, z, z2, str3, identifiedList2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final NotificationsState getNotificationsState() {
            return this.notificationsState;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getEventTypeFilter() {
            return this.eventTypeFilter;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsRefreshing() {
            return this.isRefreshing;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsLoadingMore() {
            return this.isLoadingMore;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getNextMarker() {
            return this.nextMarker;
        }

        public final IdentifiedList<String, InboxItemReducer.State> component6() {
            return this.items;
        }

        public final State copy(NotificationsState notificationsState, String eventTypeFilter, boolean isRefreshing, boolean isLoadingMore, String nextMarker, IdentifiedList<String, InboxItemReducer.State> items) {
            Intrinsics.checkNotNullParameter(notificationsState, "notificationsState");
            Intrinsics.checkNotNullParameter(items, "items");
            return new State(notificationsState, eventTypeFilter, isRefreshing, isLoadingMore, nextMarker, items);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.notificationsState, state.notificationsState) && Intrinsics.areEqual(this.eventTypeFilter, state.eventTypeFilter) && this.isRefreshing == state.isRefreshing && this.isLoadingMore == state.isLoadingMore && Intrinsics.areEqual(this.nextMarker, state.nextMarker) && Intrinsics.areEqual(this.items, state.items);
        }

        public int hashCode() {
            int iHashCode = this.notificationsState.hashCode() * 31;
            String str = this.eventTypeFilter;
            int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.isRefreshing)) * 31) + Boolean.hashCode(this.isLoadingMore)) * 31;
            String str2 = this.nextMarker;
            return ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.items.hashCode();
        }

        public String toString() {
            return "State(notificationsState=" + this.notificationsState + ", eventTypeFilter=" + this.eventTypeFilter + ", isRefreshing=" + this.isRefreshing + ", isLoadingMore=" + this.isLoadingMore + ", nextMarker=" + this.nextMarker + ", items=" + this.items + ")";
        }

        public State(NotificationsState notificationsState, String str, boolean z, boolean z2, String str2, IdentifiedList<String, InboxItemReducer.State> items) {
            Intrinsics.checkNotNullParameter(notificationsState, "notificationsState");
            Intrinsics.checkNotNullParameter(items, "items");
            this.notificationsState = notificationsState;
            this.eventTypeFilter = str;
            this.isRefreshing = z;
            this.isLoadingMore = z2;
            this.nextMarker = str2;
            this.items = items;
        }

        public /* synthetic */ State(NotificationsState.Loading loading, String str, boolean z, boolean z2, String str2, IdentifiedList identifiedList, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? NotificationsState.Loading.INSTANCE : loading, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z, (i & 8) != 0 ? false : z2, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? IdentifiedListKt.emptyIdentifiedList() : identifiedList);
        }

        public final NotificationsState getNotificationsState() {
            return this.notificationsState;
        }

        public final String getEventTypeFilter() {
            return this.eventTypeFilter;
        }

        public final boolean isRefreshing() {
            return this.isRefreshing;
        }

        public final boolean isLoadingMore() {
            return this.isLoadingMore;
        }

        public final String getNextMarker() {
            return this.nextMarker;
        }

        public final IdentifiedList<String, InboxItemReducer.State> getItems() {
            return this.items;
        }

        public final boolean isEmpty() {
            if (this.notificationsState instanceof NotificationsState.FullyLoaded) {
                return this.items.isEmpty();
            }
            return false;
        }

        public final DomainError getError() {
            NotificationsState notificationsState = this.notificationsState;
            if (notificationsState instanceof NotificationsState.Error) {
                return ((NotificationsState.Error) notificationsState).getError();
            }
            return null;
        }

        public final boolean getCanLoadMore() {
            return (this.nextMarker == null || this.isLoadingMore) ? false : true;
        }
    }

    /* JADX INFO: compiled from: InboxItemsListReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", "", "<init>", "()V", "LoadNotifications", "RefreshNotifications", "LoadMoreNotifications", "MarkAllNotificationsAsSeen", "NotificationsLoaded", "NotificationsLoadError", "SetEventTypeFilter", "UpdateItems", "ItemAction", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$ItemAction;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$LoadMoreNotifications;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$LoadNotifications;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$MarkAllNotificationsAsSeen;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$NotificationsLoadError;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$NotificationsLoaded;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$RefreshNotifications;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$SetEventTypeFilter;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$UpdateItems;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: InboxItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$LoadNotifications;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadNotifications extends Action {
            public static final int $stable = 0;
            public static final LoadNotifications INSTANCE = new LoadNotifications();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadNotifications)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1406931137;
            }

            public String toString() {
                return "LoadNotifications";
            }

            private LoadNotifications() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: InboxItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$RefreshNotifications;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RefreshNotifications extends Action {
            public static final int $stable = 0;
            public static final RefreshNotifications INSTANCE = new RefreshNotifications();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RefreshNotifications)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -413746610;
            }

            public String toString() {
                return "RefreshNotifications";
            }

            private RefreshNotifications() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: InboxItemsListReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$LoadMoreNotifications;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadMoreNotifications extends Action {
            public static final int $stable = 0;
            public static final LoadMoreNotifications INSTANCE = new LoadMoreNotifications();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadMoreNotifications)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 285229804;
            }

            public String toString() {
                return "LoadMoreNotifications";
            }

            private LoadMoreNotifications() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: InboxItemsListReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$MarkAllNotificationsAsSeen;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", "firstNotificationId", "", "<init>", "(Ljava/lang/String;)V", "getFirstNotificationId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MarkAllNotificationsAsSeen extends Action {
            public static final int $stable = 0;
            private final String firstNotificationId;

            public static /* synthetic */ MarkAllNotificationsAsSeen copy$default(MarkAllNotificationsAsSeen markAllNotificationsAsSeen, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = markAllNotificationsAsSeen.firstNotificationId;
                }
                return markAllNotificationsAsSeen.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getFirstNotificationId() {
                return this.firstNotificationId;
            }

            public final MarkAllNotificationsAsSeen copy(String firstNotificationId) {
                Intrinsics.checkNotNullParameter(firstNotificationId, "firstNotificationId");
                return new MarkAllNotificationsAsSeen(firstNotificationId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MarkAllNotificationsAsSeen) && Intrinsics.areEqual(this.firstNotificationId, ((MarkAllNotificationsAsSeen) other).firstNotificationId);
            }

            public int hashCode() {
                return this.firstNotificationId.hashCode();
            }

            public String toString() {
                return "MarkAllNotificationsAsSeen(firstNotificationId=" + this.firstNotificationId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MarkAllNotificationsAsSeen(String firstNotificationId) {
                super(null);
                Intrinsics.checkNotNullParameter(firstNotificationId, "firstNotificationId");
                this.firstNotificationId = firstNotificationId;
            }

            public final String getFirstNotificationId() {
                return this.firstNotificationId;
            }
        }

        /* JADX INFO: compiled from: InboxItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$NotificationsLoaded;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", "notifications", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationIteratorModel;", "<init>", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationIteratorModel;)V", "getNotifications", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationIteratorModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NotificationsLoaded extends Action {
            public static final int $stable = 8;
            private final InboxNotificationIteratorModel notifications;

            public static /* synthetic */ NotificationsLoaded copy$default(NotificationsLoaded notificationsLoaded, InboxNotificationIteratorModel inboxNotificationIteratorModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    inboxNotificationIteratorModel = notificationsLoaded.notifications;
                }
                return notificationsLoaded.copy(inboxNotificationIteratorModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InboxNotificationIteratorModel getNotifications() {
                return this.notifications;
            }

            public final NotificationsLoaded copy(InboxNotificationIteratorModel notifications) {
                Intrinsics.checkNotNullParameter(notifications, "notifications");
                return new NotificationsLoaded(notifications);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NotificationsLoaded) && Intrinsics.areEqual(this.notifications, ((NotificationsLoaded) other).notifications);
            }

            public int hashCode() {
                return this.notifications.hashCode();
            }

            public String toString() {
                return "NotificationsLoaded(notifications=" + this.notifications + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NotificationsLoaded(InboxNotificationIteratorModel notifications) {
                super(null);
                Intrinsics.checkNotNullParameter(notifications, "notifications");
                this.notifications = notifications;
            }

            public final InboxNotificationIteratorModel getNotifications() {
                return this.notifications;
            }
        }

        /* JADX INFO: compiled from: InboxItemsListReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$NotificationsLoadError;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class NotificationsLoadError extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ NotificationsLoadError copy$default(NotificationsLoadError notificationsLoadError, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = notificationsLoadError.error;
                }
                return notificationsLoadError.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final NotificationsLoadError copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new NotificationsLoadError(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof NotificationsLoadError) && Intrinsics.areEqual(this.error, ((NotificationsLoadError) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "NotificationsLoadError(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public NotificationsLoadError(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: InboxItemsListReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$SetEventTypeFilter;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", ViewProps.FILTER, "", "<init>", "(Ljava/lang/String;)V", "getFilter", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        /* JADX INFO: compiled from: InboxItemsListReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$UpdateItems;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", "newItems", "Lcom/box/android/cpl/IdentifiedList;", "", "Lcom/box/android/inbox/notifications/InboxItemReducer$State;", "<init>", "(Lcom/box/android/cpl/IdentifiedList;)V", "getNewItems", "()Lcom/box/android/cpl/IdentifiedList;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateItems extends Action {
            public static final int $stable = 8;
            private final IdentifiedList<String, InboxItemReducer.State> newItems;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ UpdateItems copy$default(UpdateItems updateItems, IdentifiedList identifiedList, int i, Object obj) {
                if ((i & 1) != 0) {
                    identifiedList = updateItems.newItems;
                }
                return updateItems.copy(identifiedList);
            }

            public final IdentifiedList<String, InboxItemReducer.State> component1() {
                return this.newItems;
            }

            public final UpdateItems copy(IdentifiedList<String, InboxItemReducer.State> newItems) {
                Intrinsics.checkNotNullParameter(newItems, "newItems");
                return new UpdateItems(newItems);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateItems) && Intrinsics.areEqual(this.newItems, ((UpdateItems) other).newItems);
            }

            public int hashCode() {
                return this.newItems.hashCode();
            }

            public String toString() {
                return "UpdateItems(newItems=" + this.newItems + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateItems(IdentifiedList<String, InboxItemReducer.State> newItems) {
                super(null);
                Intrinsics.checkNotNullParameter(newItems, "newItems");
                this.newItems = newItems;
            }

            public final IdentifiedList<String, InboxItemReducer.State> getNewItems() {
                return this.newItems;
            }
        }

        /* JADX INFO: compiled from: InboxItemsListReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action$ItemAction;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;", "Lcom/box/android/cpl/EmbeddedItem;", "", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action;", "id", Analytics.Data.ACTION, "<init>", "(Ljava/lang/String;Lcom/box/android/inbox/notifications/InboxItemReducer$Action;)V", "getId", "()Ljava/lang/String;", "getAction", "()Lcom/box/android/inbox/notifications/InboxItemReducer$Action;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ItemAction extends Action implements EmbeddedItem<String, InboxItemReducer.Action> {
            public static final int $stable = 0;
            private final InboxItemReducer.Action action;
            private final String id;

            public static /* synthetic */ ItemAction copy$default(ItemAction itemAction, String str, InboxItemReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = itemAction.id;
                }
                if ((i & 2) != 0) {
                    action = itemAction.action;
                }
                return itemAction.copy(str, action);
            }

            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component1, reason: avoid collision after fix types in other method and from getter */
            public final String getId() {
                return this.id;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.EmbeddedItem
            /* JADX INFO: renamed from: component2, reason: from getter */
            public final InboxItemReducer.Action getAction() {
                return this.action;
            }

            public final ItemAction copy(String id, InboxItemReducer.Action action) {
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
            public ItemAction(String id, InboxItemReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(action, "action");
                this.id = id;
                this.action = action;
            }

            public final InboxItemReducer.Action getAction() {
                return this.action;
            }

            public final String getId() {
                return this.id;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ReducerResult<State, Action> reduceItemsList(State state, Action action) {
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        if (action instanceof Action.LoadNotifications) {
            return new ReducerResult<>(State.copy$default(state, NotificationsState.Loading.INSTANCE, null, false, false, null, null, 62, null), createLoadNotificationsEffect(state.getEventTypeFilter(), null));
        }
        if (action instanceof Action.RefreshNotifications) {
            return new ReducerResult<>(State.copy$default(state, null, null, true, false, null, null, 59, null), createLoadNotificationsEffect(state.getEventTypeFilter(), null));
        }
        int i = 2;
        if (action instanceof Action.LoadMoreNotifications) {
            if (state.getCanLoadMore()) {
                return new ReducerResult<>(State.copy$default(state, null, null, false, true, null, null, 55, null), createLoadNotificationsEffect(state.getEventTypeFilter(), state.getNextMarker()));
            }
            return new ReducerResult<>(state, effect, i, objArr7 == true ? 1 : 0);
        }
        if (action instanceof Action.NotificationsLoaded) {
            return reduceNotificationsLoaded((Action.NotificationsLoaded) action, state);
        }
        if (action instanceof Action.UpdateItems) {
            return new ReducerResult<>(State.copy$default(state, null, null, false, false, null, ((Action.UpdateItems) action).getNewItems(), 31, null), objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        }
        if (action instanceof Action.NotificationsLoadError) {
            return new ReducerResult<>(State.copy$default(state, new NotificationsState.Error(((Action.NotificationsLoadError) action).getError()), null, false, false, null, null, 50, null), objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        if (action instanceof Action.SetEventTypeFilter) {
            return new ReducerResult<>(State.copy$default(state, null, ((Action.SetEventTypeFilter) action).getFilter(), false, false, null, null, 61, null), new Effect(Action.LoadNotifications.INSTANCE));
        }
        if (action instanceof Action.MarkAllNotificationsAsSeen) {
            IdentifiedList<String, InboxItemReducer.State> items = state.getItems();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(items, 10));
            for (InboxItemReducer.State state2 : items) {
                arrayList.add(InboxItemReducer.State.copy$default(state2, InboxNotificationModel.copy$default(state2.getNotification(), null, null, null, true, false, null, null, null, 247, null), false, null, 6, null));
            }
            return new ReducerResult<>(State.copy$default(state, null, null, false, false, null, new IdentifiedList((Identifiable[]) arrayList.toArray(new InboxItemReducer.State[0])), 31, null), createMarkAllNotificationsAsSeenEffect(((Action.MarkAllNotificationsAsSeen) action).getFirstNotificationId()));
        }
        if (action instanceof Action.ItemAction) {
            return new ReducerResult<>(state, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ReducerResult<State, Action> reduceNotificationsLoaded(Action.NotificationsLoaded action, State state) {
        return new ReducerResult<>(State.copy$default(state, NotificationsState.FullyLoaded.INSTANCE, null, false, false, action.getNotifications().getNextMarker(), null, 34, null), EffectKt.toEffect(FlowKt.flow(new C16521(state, action, state.isLoadingMore(), null))));
    }

    /* JADX INFO: renamed from: com.box.android.inbox.notifications.InboxItemsListReducer$reduceNotificationsLoaded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.inbox.notifications.InboxItemsListReducer$reduceNotificationsLoaded$1", f = "InboxItemsListReducer.kt", i = {0, 1, 1, 2, 2, 2}, l = {Token.XML, Token.TO_DOUBLE, Token.SETCONSTVAR}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "newItems", "$this$flow", "newItems", "lastNotificationId"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2"}, v = 1)
    static final class C16521 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Action.NotificationsLoaded $action;
        final /* synthetic */ State $state;
        final /* synthetic */ boolean $wasLoadingMore;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16521(State state, Action.NotificationsLoaded notificationsLoaded, boolean z, Continuation<? super C16521> continuation) {
            super(2, continuation);
            this.$state = state;
            this.$action = notificationsLoaded;
            this.$wasLoadingMore = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C16521 c16521 = InboxItemsListReducer.this.new C16521(this.$state, this.$action, this.$wasLoadingMore, continuation);
            c16521.L$0 = obj;
            return c16521;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16521) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:24:0x00ae  */
        /* JADX WARN: Code duplicated, block: B:29:0x00d5  */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00ce, code lost:
        
            if (r0.emit(new com.box.android.inbox.notifications.InboxItemsListReducer.Action.MarkAllNotificationsAsSeen(r10), r9) == r1) goto L26;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                Method dump skipped, instruction units count: 229
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.inbox.notifications.InboxItemsListReducer.C16521.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: com.box.android.inbox.notifications.InboxItemsListReducer$createLoadNotificationsEffect$1, reason: invalid class name */
    /* JADX INFO: compiled from: InboxItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.inbox.notifications.InboxItemsListReducer$createLoadNotificationsEffect$1", f = "InboxItemsListReducer.kt", i = {0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5}, l = {176, 183, 192, 194, 197, 202}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "error", "cachedData", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "error", "cachedData", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "error", "$this$flow", "<unused var>"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $eventTypeFilter;
        final /* synthetic */ String $nextMarker;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$eventTypeFilter = str;
            this.$nextMarker = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = InboxItemsListReducer.this.new AnonymousClass1(this.$eventTypeFilter, this.$nextMarker, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0080 A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:8:0x0029, B:13:0x004d, B:21:0x007a, B:23:0x0080, B:26:0x00a4, B:28:0x00a8, B:30:0x00b5, B:32:0x00c0, B:35:0x00c6, B:38:0x00ed, B:41:0x011a, B:44:0x013a, B:45:0x013f, B:18:0x0058), top: B:51:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:25:0x00a2  */
        /* JADX WARN: Code duplicated, block: B:26:0x00a4 A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:8:0x0029, B:13:0x004d, B:21:0x007a, B:23:0x0080, B:26:0x00a4, B:28:0x00a8, B:30:0x00b5, B:32:0x00c0, B:35:0x00c6, B:38:0x00ed, B:41:0x011a, B:44:0x013a, B:45:0x013f, B:18:0x0058), top: B:51:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:28:0x00a8 A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:8:0x0029, B:13:0x004d, B:21:0x007a, B:23:0x0080, B:26:0x00a4, B:28:0x00a8, B:30:0x00b5, B:32:0x00c0, B:35:0x00c6, B:38:0x00ed, B:41:0x011a, B:44:0x013a, B:45:0x013f, B:18:0x0058), top: B:51:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:30:0x00b5 A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:8:0x0029, B:13:0x004d, B:21:0x007a, B:23:0x0080, B:26:0x00a4, B:28:0x00a8, B:30:0x00b5, B:32:0x00c0, B:35:0x00c6, B:38:0x00ed, B:41:0x011a, B:44:0x013a, B:45:0x013f, B:18:0x0058), top: B:51:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:32:0x00c0 A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:8:0x0029, B:13:0x004d, B:21:0x007a, B:23:0x0080, B:26:0x00a4, B:28:0x00a8, B:30:0x00b5, B:32:0x00c0, B:35:0x00c6, B:38:0x00ed, B:41:0x011a, B:44:0x013a, B:45:0x013f, B:18:0x0058), top: B:51:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:33:0x00c3  */
        /* JADX WARN: Code duplicated, block: B:35:0x00c6 A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:8:0x0029, B:13:0x004d, B:21:0x007a, B:23:0x0080, B:26:0x00a4, B:28:0x00a8, B:30:0x00b5, B:32:0x00c0, B:35:0x00c6, B:38:0x00ed, B:41:0x011a, B:44:0x013a, B:45:0x013f, B:18:0x0058), top: B:51:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:37:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:38:0x00ed A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:8:0x0029, B:13:0x004d, B:21:0x007a, B:23:0x0080, B:26:0x00a4, B:28:0x00a8, B:30:0x00b5, B:32:0x00c0, B:35:0x00c6, B:38:0x00ed, B:41:0x011a, B:44:0x013a, B:45:0x013f, B:18:0x0058), top: B:51:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:40:0x0119  */
        /* JADX WARN: Code duplicated, block: B:41:0x011a A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:8:0x0029, B:13:0x004d, B:21:0x007a, B:23:0x0080, B:26:0x00a4, B:28:0x00a8, B:30:0x00b5, B:32:0x00c0, B:35:0x00c6, B:38:0x00ed, B:41:0x011a, B:44:0x013a, B:45:0x013f, B:18:0x0058), top: B:51:0x000d }] */
        /* JADX WARN: Code duplicated, block: B:43:0x0139  */
        /* JADX WARN: Code duplicated, block: B:44:0x013a A[Catch: Exception -> 0x0051, TryCatch #0 {Exception -> 0x0051, blocks: (B:8:0x0029, B:13:0x004d, B:21:0x007a, B:23:0x0080, B:26:0x00a4, B:28:0x00a8, B:30:0x00b5, B:32:0x00c0, B:35:0x00c6, B:38:0x00ed, B:41:0x011a, B:44:0x013a, B:45:0x013f, B:18:0x0058), top: B:51:0x000d }] */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0166, code lost:
        
            if (r1.emit(new com.box.android.inbox.notifications.InboxItemsListReducer.Action.NotificationsLoadError(new com.box.android.domain.models.DomainError.NetworkError(r4, r3, r4 == true ? 1 : 0)), r13) == r2) goto L48;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) {
            /*
                Method dump skipped, instruction units count: 382
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.inbox.notifications.InboxItemsListReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Effect<Action> createLoadNotificationsEffect(String eventTypeFilter, String nextMarker) {
        return EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(eventTypeFilter, nextMarker, null)));
    }

    /* JADX INFO: renamed from: com.box.android.inbox.notifications.InboxItemsListReducer$createMarkAllNotificationsAsSeenEffect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/inbox/notifications/InboxItemsListReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.inbox.notifications.InboxItemsListReducer$createMarkAllNotificationsAsSeenEffect$1", f = "InboxItemsListReducer.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16511 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $lastNotificationId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16511(String str, Continuation<? super C16511> continuation) {
            super(2, continuation);
            this.$lastNotificationId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InboxItemsListReducer.this.new C16511(this.$lastNotificationId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16511) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (IInboxNotificationService.markAllNotificationsAsSeen$default(InboxItemsListReducer.this.environment.getInboxNotificationService(), this.$lastNotificationId, null, this, 2, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }
    }

    private final Effect<Action> createMarkAllNotificationsAsSeenEffect(String lastNotificationId) {
        return EffectKt.toEffect(FlowKt.flow(new C16511(lastNotificationId, null)));
    }

    /* JADX INFO: renamed from: com.box.android.inbox.notifications.InboxItemsListReducer$mergeItems$2, reason: invalid class name */
    /* JADX INFO: compiled from: InboxItemsListReducer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/box/android/cpl/IdentifiedList;", "", "Lcom/box/android/inbox/notifications/InboxItemReducer$State;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.inbox.notifications.InboxItemsListReducer$mergeItems$2", f = "InboxItemsListReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super IdentifiedList<String, InboxItemReducer.State>>, Object> {
        final /* synthetic */ IdentifiedList<String, InboxItemReducer.State> $existing;
        final /* synthetic */ boolean $isLoadingMore;
        final /* synthetic */ List<InboxNotificationModel> $new;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(List<InboxNotificationModel> list, boolean z, IdentifiedList<String, InboxItemReducer.State> identifiedList, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$new = list;
            this.$isLoadingMore = z;
            this.$existing = identifiedList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$new, this.$isLoadingMore, this.$existing, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super IdentifiedList<String, InboxItemReducer.State>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<InboxNotificationModel> list = this.$new;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new InboxItemReducer.State((InboxNotificationModel) it.next(), false, null, 6, null));
            }
            ArrayList<InboxItemReducer.State> arrayList2 = arrayList;
            if (this.$isLoadingMore) {
                IdentifiedList<String, InboxItemReducer.State> identifiedList = this.$existing;
                LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(identifiedList, 10)), 16));
                for (InboxItemReducer.State state : identifiedList) {
                    linkedHashMap.put(state.getId(), state);
                }
                Map mutableMap = MapsKt.toMutableMap(linkedHashMap);
                for (InboxItemReducer.State state2 : arrayList2) {
                    mutableMap.put(state2.getId(), state2);
                }
                return new IdentifiedList((Identifiable[]) mutableMap.values().toArray(new InboxItemReducer.State[0]));
            }
            return new IdentifiedList((Identifiable[]) arrayList2.toArray(new InboxItemReducer.State[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object mergeItems(IdentifiedList<String, InboxItemReducer.State> identifiedList, List<InboxNotificationModel> list, boolean z, Continuation<? super IdentifiedList<String, InboxItemReducer.State>> continuation) {
        return BuildersKt.withContext(this.environment.getDispatcher(), new AnonymousClass2(list, z, identifiedList, null), continuation);
    }
}
