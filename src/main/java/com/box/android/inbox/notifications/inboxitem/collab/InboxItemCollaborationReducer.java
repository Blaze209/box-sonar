package com.box.android.inbox.notifications.inboxitem.collab;

import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.CollaborationDomainError;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.InboxCollaborationResponseModel;
import com.box.android.domain.models.inboxnotifications.AcceptanceRequirementType;
import com.box.android.domain.models.inboxnotifications.InboxNotificationCollaborationStatus;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel;
import com.box.android.inbox.mfasetup.MfaSetupDialogReducer;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0004\u0012\u0013\u0014\u0015B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$State;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "environment", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationEnvironment;", "<init>", "(Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceCollaboration", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "handleCollaborationStatusUpdate", "status", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;", "DialogState", "CollaborationDisplayState", "State", "Action", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxItemCollaborationReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final InboxItemCollaborationEnvironment environment;

    public InboxItemCollaborationReducer(InboxItemCollaborationEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new InboxItemCollaborationReducer$build$1(this));
        final InboxItemCollaborationReducer$build$2 inboxItemCollaborationReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((InboxItemCollaborationReducer.State) obj).getMfaSetupDialogState();
            }
        };
        final InboxItemCollaborationReducer$build$3 inboxItemCollaborationReducer$build$3 = InboxItemCollaborationReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new MfaSetupDialogReducer(environment.getMfaSetupDialogEnvironment()), new Function1<State, MfaSetupDialogReducer.State>() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.inbox.mfasetup.MfaSetupDialogReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final MfaSetupDialogReducer.State invoke(InboxItemCollaborationReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return inboxItemCollaborationReducer$build$2.invoke(it);
            }
        }, new Function1<Action, MfaSetupDialogReducer.Action>() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final MfaSetupDialogReducer.Action invoke(InboxItemCollaborationReducer.Action action) {
                if (!(action instanceof InboxItemCollaborationReducer.Action.MfaSetupDialogAction)) {
                    action = null;
                }
                InboxItemCollaborationReducer.Action.MfaSetupDialogAction mfaSetupDialogAction = (InboxItemCollaborationReducer.Action.MfaSetupDialogAction) action;
                if (mfaSetupDialogAction != null) {
                    return mfaSetupDialogAction.getAction();
                }
                return null;
            }
        }, new Function2<State, MfaSetupDialogReducer.State, State>() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final InboxItemCollaborationReducer.State invoke(InboxItemCollaborationReducer.State parentState, MfaSetupDialogReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = inboxItemCollaborationReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(InboxItemCollaborationReducer.State.class)).iterator();
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
                            return (InboxItemCollaborationReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<MfaSetupDialogReducer.Action, Action>() { // from class: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final InboxItemCollaborationReducer.Action invoke(MfaSetupDialogReducer.Action action) {
                Object objInvoke = inboxItemCollaborationReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (InboxItemCollaborationReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState;", "", "<init>", "()V", "CollaborationError", "RequirementDetails", "MFASetup", "DeclineConfirmation", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState$CollaborationError;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState$DeclineConfirmation;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState$MFASetup;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState$RequirementDetails;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class DialogState {
        public static final int $stable = 0;

        public /* synthetic */ DialogState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState$CollaborationError;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CollaborationError extends DialogState {
            public static final int $stable = 0;
            public static final CollaborationError INSTANCE = new CollaborationError();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CollaborationError)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1727664197;
            }

            public String toString() {
                return "CollaborationError";
            }

            private CollaborationError() {
                super(null);
            }
        }

        private DialogState() {
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState$RequirementDetails;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState;", "requirementType", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "<init>", "(Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;)V", "getRequirementType", "()Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RequirementDetails extends DialogState {
            public static final int $stable = 8;
            private final AcceptanceRequirementType requirementType;

            public static /* synthetic */ RequirementDetails copy$default(RequirementDetails requirementDetails, AcceptanceRequirementType acceptanceRequirementType, int i, Object obj) {
                if ((i & 1) != 0) {
                    acceptanceRequirementType = requirementDetails.requirementType;
                }
                return requirementDetails.copy(acceptanceRequirementType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AcceptanceRequirementType getRequirementType() {
                return this.requirementType;
            }

            public final RequirementDetails copy(AcceptanceRequirementType requirementType) {
                Intrinsics.checkNotNullParameter(requirementType, "requirementType");
                return new RequirementDetails(requirementType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof RequirementDetails) && Intrinsics.areEqual(this.requirementType, ((RequirementDetails) other).requirementType);
            }

            public int hashCode() {
                return this.requirementType.hashCode();
            }

            public String toString() {
                return "RequirementDetails(requirementType=" + this.requirementType + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public RequirementDetails(AcceptanceRequirementType requirementType) {
                super(null);
                Intrinsics.checkNotNullParameter(requirementType, "requirementType");
                this.requirementType = requirementType;
            }

            public final AcceptanceRequirementType getRequirementType() {
                return this.requirementType;
            }
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState$MFASetup;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MFASetup extends DialogState {
            public static final int $stable = 0;
            public static final MFASetup INSTANCE = new MFASetup();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MFASetup)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 56670583;
            }

            public String toString() {
                return "MFASetup";
            }

            private MFASetup() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState$DeclineConfirmation;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DeclineConfirmation extends DialogState {
            public static final int $stable = 0;
            public static final DeclineConfirmation INSTANCE = new DeclineConfirmation();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DeclineConfirmation)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1033065207;
            }

            public String toString() {
                return "DeclineConfirmation";
            }

            private DeclineConfirmation() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState;", "", "<init>", "()V", "Actions", "Status", "Hidden", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Actions;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Hidden;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Status;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class CollaborationDisplayState {
        public static final int $stable = 0;

        public /* synthetic */ CollaborationDisplayState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Actions;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState;", "<init>", "()V", "AcceptDecline", "RequirementDetails", "MFASetup", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Actions$AcceptDecline;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Actions$MFASetup;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Actions$RequirementDetails;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static abstract class Actions extends CollaborationDisplayState {
            public static final int $stable = 0;

            public /* synthetic */ Actions(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Actions() {
                super(null);
            }

            /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Actions$AcceptDecline;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Actions;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final /* data */ class AcceptDecline extends Actions {
                public static final int $stable = 0;
                public static final AcceptDecline INSTANCE = new AcceptDecline();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof AcceptDecline)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return -1745143578;
                }

                public String toString() {
                    return "AcceptDecline";
                }

                private AcceptDecline() {
                    super(null);
                }
            }

            /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
            @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Actions$RequirementDetails;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Actions;", "requirementType", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "<init>", "(Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;)V", "getRequirementType", "()Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final /* data */ class RequirementDetails extends Actions {
                public static final int $stable = 8;
                private final AcceptanceRequirementType requirementType;

                public static /* synthetic */ RequirementDetails copy$default(RequirementDetails requirementDetails, AcceptanceRequirementType acceptanceRequirementType, int i, Object obj) {
                    if ((i & 1) != 0) {
                        acceptanceRequirementType = requirementDetails.requirementType;
                    }
                    return requirementDetails.copy(acceptanceRequirementType);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final AcceptanceRequirementType getRequirementType() {
                    return this.requirementType;
                }

                public final RequirementDetails copy(AcceptanceRequirementType requirementType) {
                    Intrinsics.checkNotNullParameter(requirementType, "requirementType");
                    return new RequirementDetails(requirementType);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof RequirementDetails) && Intrinsics.areEqual(this.requirementType, ((RequirementDetails) other).requirementType);
                }

                public int hashCode() {
                    return this.requirementType.hashCode();
                }

                public String toString() {
                    return "RequirementDetails(requirementType=" + this.requirementType + ")";
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public RequirementDetails(AcceptanceRequirementType requirementType) {
                    super(null);
                    Intrinsics.checkNotNullParameter(requirementType, "requirementType");
                    this.requirementType = requirementType;
                }

                public final AcceptanceRequirementType getRequirementType() {
                    return this.requirementType;
                }
            }

            /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Actions$MFASetup;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Actions;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final /* data */ class MFASetup extends Actions {
                public static final int $stable = 0;
                public static final MFASetup INSTANCE = new MFASetup();

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof MFASetup)) {
                        return false;
                    }
                    return true;
                }

                public int hashCode() {
                    return 89341533;
                }

                public String toString() {
                    return "MFASetup";
                }

                private MFASetup() {
                    super(null);
                }
            }
        }

        private CollaborationDisplayState() {
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Status;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState;", "status", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;", "<init>", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;)V", "getStatus", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationCollaborationStatus;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Status extends CollaborationDisplayState {
            public static final int $stable = 0;
            private final InboxNotificationCollaborationStatus status;

            public static /* synthetic */ Status copy$default(Status status, InboxNotificationCollaborationStatus inboxNotificationCollaborationStatus, int i, Object obj) {
                if ((i & 1) != 0) {
                    inboxNotificationCollaborationStatus = status.status;
                }
                return status.copy(inboxNotificationCollaborationStatus);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InboxNotificationCollaborationStatus getStatus() {
                return this.status;
            }

            public final Status copy(InboxNotificationCollaborationStatus status) {
                Intrinsics.checkNotNullParameter(status, "status");
                return new Status(status);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Status) && this.status == ((Status) other).status;
            }

            public int hashCode() {
                return this.status.hashCode();
            }

            public String toString() {
                return "Status(status=" + this.status + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Status(InboxNotificationCollaborationStatus status) {
                super(null);
                Intrinsics.checkNotNullParameter(status, "status");
                this.status = status;
            }

            public final InboxNotificationCollaborationStatus getStatus() {
                return this.status;
            }
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState$Hidden;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Hidden extends CollaborationDisplayState {
            public static final int $stable = 0;
            public static final Hidden INSTANCE = new Hidden();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Hidden)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 206659937;
            }

            public String toString() {
                return "Hidden";
            }

            private Hidden() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J?\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010%\u001a\u00020\u00052\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006+"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$State;", "", "notification", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "isEnabled", "", "collabUpdateResult", "Lcom/box/android/domain/models/InboxCollaborationResponseModel;", "dialogState", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState;", "mfaSetupDialogState", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$State;", "<init>", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;ZLcom/box/android/domain/models/InboxCollaborationResponseModel;Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState;Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$State;)V", "getNotification", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "()Z", "getCollabUpdateResult", "()Lcom/box/android/domain/models/InboxCollaborationResponseModel;", "getDialogState", "()Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$DialogState;", "getMfaSetupDialogState", "()Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$State;", "displayState", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState;", "getDisplayState", "()Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$CollaborationDisplayState;", "pendingAcceptanceRequirement", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "getPendingAcceptanceRequirement", "()Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final InboxCollaborationResponseModel collabUpdateResult;
        private final DialogState dialogState;
        private final boolean isEnabled;
        private final MfaSetupDialogReducer.State mfaSetupDialogState;
        private final InboxNotificationModel notification;

        public static /* synthetic */ State copy$default(State state, InboxNotificationModel inboxNotificationModel, boolean z, InboxCollaborationResponseModel inboxCollaborationResponseModel, DialogState dialogState, MfaSetupDialogReducer.State state2, int i, Object obj) {
            if ((i & 1) != 0) {
                inboxNotificationModel = state.notification;
            }
            if ((i & 2) != 0) {
                z = state.isEnabled;
            }
            if ((i & 4) != 0) {
                inboxCollaborationResponseModel = state.collabUpdateResult;
            }
            if ((i & 8) != 0) {
                dialogState = state.dialogState;
            }
            if ((i & 16) != 0) {
                state2 = state.mfaSetupDialogState;
            }
            MfaSetupDialogReducer.State state3 = state2;
            InboxCollaborationResponseModel inboxCollaborationResponseModel2 = inboxCollaborationResponseModel;
            return state.copy(inboxNotificationModel, z, inboxCollaborationResponseModel2, dialogState, state3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final InboxNotificationModel getNotification() {
            return this.notification;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsEnabled() {
            return this.isEnabled;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final InboxCollaborationResponseModel getCollabUpdateResult() {
            return this.collabUpdateResult;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final DialogState getDialogState() {
            return this.dialogState;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final MfaSetupDialogReducer.State getMfaSetupDialogState() {
            return this.mfaSetupDialogState;
        }

        public final State copy(InboxNotificationModel notification, boolean isEnabled, InboxCollaborationResponseModel collabUpdateResult, DialogState dialogState, MfaSetupDialogReducer.State mfaSetupDialogState) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            Intrinsics.checkNotNullParameter(mfaSetupDialogState, "mfaSetupDialogState");
            return new State(notification, isEnabled, collabUpdateResult, dialogState, mfaSetupDialogState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.notification, state.notification) && this.isEnabled == state.isEnabled && Intrinsics.areEqual(this.collabUpdateResult, state.collabUpdateResult) && Intrinsics.areEqual(this.dialogState, state.dialogState) && Intrinsics.areEqual(this.mfaSetupDialogState, state.mfaSetupDialogState);
        }

        public int hashCode() {
            int iHashCode = ((this.notification.hashCode() * 31) + Boolean.hashCode(this.isEnabled)) * 31;
            InboxCollaborationResponseModel inboxCollaborationResponseModel = this.collabUpdateResult;
            int iHashCode2 = (iHashCode + (inboxCollaborationResponseModel == null ? 0 : inboxCollaborationResponseModel.hashCode())) * 31;
            DialogState dialogState = this.dialogState;
            return ((iHashCode2 + (dialogState != null ? dialogState.hashCode() : 0)) * 31) + this.mfaSetupDialogState.hashCode();
        }

        public String toString() {
            return "State(notification=" + this.notification + ", isEnabled=" + this.isEnabled + ", collabUpdateResult=" + this.collabUpdateResult + ", dialogState=" + this.dialogState + ", mfaSetupDialogState=" + this.mfaSetupDialogState + ")";
        }

        public State(InboxNotificationModel notification, boolean z, InboxCollaborationResponseModel inboxCollaborationResponseModel, DialogState dialogState, MfaSetupDialogReducer.State mfaSetupDialogState) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            Intrinsics.checkNotNullParameter(mfaSetupDialogState, "mfaSetupDialogState");
            this.notification = notification;
            this.isEnabled = z;
            this.collabUpdateResult = inboxCollaborationResponseModel;
            this.dialogState = dialogState;
            this.mfaSetupDialogState = mfaSetupDialogState;
        }

        public final InboxNotificationModel getNotification() {
            return this.notification;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public final InboxCollaborationResponseModel getCollabUpdateResult() {
            return this.collabUpdateResult;
        }

        public final DialogState getDialogState() {
            return this.dialogState;
        }

        public /* synthetic */ State(InboxNotificationModel inboxNotificationModel, boolean z, InboxCollaborationResponseModel inboxCollaborationResponseModel, DialogState dialogState, MfaSetupDialogReducer.State state, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(inboxNotificationModel, (i & 2) != 0 ? true : z, (i & 4) != 0 ? null : inboxCollaborationResponseModel, (i & 8) != 0 ? null : dialogState, (i & 16) != 0 ? new MfaSetupDialogReducer.State(null, 1, null) : state);
        }

        public final MfaSetupDialogReducer.State getMfaSetupDialogState() {
            return this.mfaSetupDialogState;
        }

        public final CollaborationDisplayState getDisplayState() {
            CollaborationDisplayState.Actions.RequirementDetails requirementDetails;
            if (this.collabUpdateResult != null) {
                return new CollaborationDisplayState.Status(this.collabUpdateResult.getStatus());
            }
            if (this.notification.getPayload() instanceof InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) {
                InboxNotificationPayloadModel payload = this.notification.getPayload();
                Intrinsics.checkNotNull(payload, "null cannot be cast to non-null type com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel.CollabInvitePayloadInboxModel");
                AcceptanceRequirementType pendingAcceptanceRequirement = getPendingAcceptanceRequirement();
                if (((InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) payload).getCollab().getStatus() != InboxNotificationCollaborationStatus.PENDING) {
                    return CollaborationDisplayState.Hidden.INSTANCE;
                }
                if (pendingAcceptanceRequirement != null) {
                    if (pendingAcceptanceRequirement instanceof AcceptanceRequirementType.MFA) {
                        requirementDetails = CollaborationDisplayState.Actions.MFASetup.INSTANCE;
                    } else {
                        requirementDetails = new CollaborationDisplayState.Actions.RequirementDetails(pendingAcceptanceRequirement);
                    }
                    return requirementDetails;
                }
                return CollaborationDisplayState.Actions.AcceptDecline.INSTANCE;
            }
            return CollaborationDisplayState.Hidden.INSTANCE;
        }

        public final AcceptanceRequirementType getPendingAcceptanceRequirement() {
            InboxNotificationPayloadModel payload = this.notification.getPayload();
            InboxNotificationPayloadModel.CollabInvitePayloadInboxModel collabInvitePayloadInboxModel = payload instanceof InboxNotificationPayloadModel.CollabInvitePayloadInboxModel ? (InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) payload : null;
            if (collabInvitePayloadInboxModel == null) {
                return null;
            }
            return collabInvitePayloadInboxModel.getCollab().getAcceptanceRequirementsStatus().getPriorityPendingRequirement();
        }
    }

    /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "", "<init>", "()V", "Initialize", "AcceptCollaboration", "DeclineCollaboration", "ConfirmDeclineCollaboration", "ShowRequirementDetails", "ShowSetUpMFA", "CollaborationActionCompleted", "CollaborationActionFailed", "DismissDialog", "MfaSetupDialogAction", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$AcceptCollaboration;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$CollaborationActionCompleted;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$CollaborationActionFailed;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$ConfirmDeclineCollaboration;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$DeclineCollaboration;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$DismissDialog;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$Initialize;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$MfaSetupDialogAction;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$ShowRequirementDetails;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$ShowSetUpMFA;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$Initialize;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Initialize extends Action {
            public static final int $stable = 0;
            public static final Initialize INSTANCE = new Initialize();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialize)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -30622773;
            }

            public String toString() {
                return "Initialize";
            }

            private Initialize() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$AcceptCollaboration;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class AcceptCollaboration extends Action {
            public static final int $stable = 0;
            public static final AcceptCollaboration INSTANCE = new AcceptCollaboration();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof AcceptCollaboration)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -79559614;
            }

            public String toString() {
                return "AcceptCollaboration";
            }

            private AcceptCollaboration() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$DeclineCollaboration;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DeclineCollaboration extends Action {
            public static final int $stable = 0;
            public static final DeclineCollaboration INSTANCE = new DeclineCollaboration();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DeclineCollaboration)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -411178646;
            }

            public String toString() {
                return "DeclineCollaboration";
            }

            private DeclineCollaboration() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$ConfirmDeclineCollaboration;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ConfirmDeclineCollaboration extends Action {
            public static final int $stable = 0;
            public static final ConfirmDeclineCollaboration INSTANCE = new ConfirmDeclineCollaboration();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ConfirmDeclineCollaboration)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 806301428;
            }

            public String toString() {
                return "ConfirmDeclineCollaboration";
            }

            private ConfirmDeclineCollaboration() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$ShowRequirementDetails;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "requirementType", "Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "<init>", "(Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;)V", "getRequirementType", "()Lcom/box/android/domain/models/inboxnotifications/AcceptanceRequirementType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowRequirementDetails extends Action {
            public static final int $stable = 8;
            private final AcceptanceRequirementType requirementType;

            public static /* synthetic */ ShowRequirementDetails copy$default(ShowRequirementDetails showRequirementDetails, AcceptanceRequirementType acceptanceRequirementType, int i, Object obj) {
                if ((i & 1) != 0) {
                    acceptanceRequirementType = showRequirementDetails.requirementType;
                }
                return showRequirementDetails.copy(acceptanceRequirementType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AcceptanceRequirementType getRequirementType() {
                return this.requirementType;
            }

            public final ShowRequirementDetails copy(AcceptanceRequirementType requirementType) {
                Intrinsics.checkNotNullParameter(requirementType, "requirementType");
                return new ShowRequirementDetails(requirementType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ShowRequirementDetails) && Intrinsics.areEqual(this.requirementType, ((ShowRequirementDetails) other).requirementType);
            }

            public int hashCode() {
                return this.requirementType.hashCode();
            }

            public String toString() {
                return "ShowRequirementDetails(requirementType=" + this.requirementType + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ShowRequirementDetails(AcceptanceRequirementType requirementType) {
                super(null);
                Intrinsics.checkNotNullParameter(requirementType, "requirementType");
                this.requirementType = requirementType;
            }

            public final AcceptanceRequirementType getRequirementType() {
                return this.requirementType;
            }
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$ShowSetUpMFA;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowSetUpMFA extends Action {
            public static final int $stable = 0;
            public static final ShowSetUpMFA INSTANCE = new ShowSetUpMFA();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowSetUpMFA)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1590579619;
            }

            public String toString() {
                return "ShowSetUpMFA";
            }

            private ShowSetUpMFA() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$CollaborationActionCompleted;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "collaborationResponse", "Lcom/box/android/domain/models/InboxCollaborationResponseModel;", "<init>", "(Lcom/box/android/domain/models/InboxCollaborationResponseModel;)V", "getCollaborationResponse", "()Lcom/box/android/domain/models/InboxCollaborationResponseModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CollaborationActionCompleted extends Action {
            public static final int $stable = 8;
            private final InboxCollaborationResponseModel collaborationResponse;

            public static /* synthetic */ CollaborationActionCompleted copy$default(CollaborationActionCompleted collaborationActionCompleted, InboxCollaborationResponseModel inboxCollaborationResponseModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    inboxCollaborationResponseModel = collaborationActionCompleted.collaborationResponse;
                }
                return collaborationActionCompleted.copy(inboxCollaborationResponseModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InboxCollaborationResponseModel getCollaborationResponse() {
                return this.collaborationResponse;
            }

            public final CollaborationActionCompleted copy(InboxCollaborationResponseModel collaborationResponse) {
                Intrinsics.checkNotNullParameter(collaborationResponse, "collaborationResponse");
                return new CollaborationActionCompleted(collaborationResponse);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CollaborationActionCompleted) && Intrinsics.areEqual(this.collaborationResponse, ((CollaborationActionCompleted) other).collaborationResponse);
            }

            public int hashCode() {
                return this.collaborationResponse.hashCode();
            }

            public String toString() {
                return "CollaborationActionCompleted(collaborationResponse=" + this.collaborationResponse + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CollaborationActionCompleted(InboxCollaborationResponseModel collaborationResponse) {
                super(null);
                Intrinsics.checkNotNullParameter(collaborationResponse, "collaborationResponse");
                this.collaborationResponse = collaborationResponse;
            }

            public final InboxCollaborationResponseModel getCollaborationResponse() {
                return this.collaborationResponse;
            }
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$CollaborationActionFailed;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "error", "Lcom/box/android/domain/models/DomainError;", "<init>", "(Lcom/box/android/domain/models/DomainError;)V", "getError", "()Lcom/box/android/domain/models/DomainError;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CollaborationActionFailed extends Action {
            public static final int $stable = 8;
            private final DomainError error;

            public static /* synthetic */ CollaborationActionFailed copy$default(CollaborationActionFailed collaborationActionFailed, DomainError domainError, int i, Object obj) {
                if ((i & 1) != 0) {
                    domainError = collaborationActionFailed.error;
                }
                return collaborationActionFailed.copy(domainError);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final DomainError getError() {
                return this.error;
            }

            public final CollaborationActionFailed copy(DomainError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                return new CollaborationActionFailed(error);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CollaborationActionFailed) && Intrinsics.areEqual(this.error, ((CollaborationActionFailed) other).error);
            }

            public int hashCode() {
                return this.error.hashCode();
            }

            public String toString() {
                return "CollaborationActionFailed(error=" + this.error + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CollaborationActionFailed(DomainError error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            public final DomainError getError() {
                return this.error;
            }
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$DismissDialog;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DismissDialog extends Action {
            public static final int $stable = 0;
            public static final DismissDialog INSTANCE = new DismissDialog();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof DismissDialog)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1805971031;
            }

            public String toString() {
                return "DismissDialog";
            }

            private DismissDialog() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action$MfaSetupDialogAction;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action;)V", "getAction", "()Lcom/box/android/inbox/mfasetup/MfaSetupDialogReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MfaSetupDialogAction extends Action implements Embedded<MfaSetupDialogReducer.Action> {
            public static final int $stable = 0;
            private final MfaSetupDialogReducer.Action action;

            public static /* synthetic */ MfaSetupDialogAction copy$default(MfaSetupDialogAction mfaSetupDialogAction, MfaSetupDialogReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = mfaSetupDialogAction.action;
                }
                return mfaSetupDialogAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MfaSetupDialogReducer.Action getAction() {
                return this.action;
            }

            public final MfaSetupDialogAction copy(MfaSetupDialogReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new MfaSetupDialogAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MfaSetupDialogAction) && Intrinsics.areEqual(this.action, ((MfaSetupDialogAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "MfaSetupDialogAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MfaSetupDialogAction(MfaSetupDialogReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final MfaSetupDialogReducer.Action getAction() {
                return this.action;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceCollaboration(State state, Action action) {
        DialogState.CollaborationError collaborationError;
        if (action instanceof Action.Initialize) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (action instanceof Action.AcceptCollaboration) {
            return handleCollaborationStatusUpdate(state, InboxNotificationCollaborationStatus.ACCEPTED);
        }
        if (action instanceof Action.DeclineCollaboration) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, DialogState.DeclineConfirmation.INSTANCE, null, 23, null), null, 2, null);
        }
        if (action instanceof Action.ConfirmDeclineCollaboration) {
            return handleCollaborationStatusUpdate(state, InboxNotificationCollaborationStatus.REJECTED);
        }
        if (action instanceof Action.ShowRequirementDetails) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, new DialogState.RequirementDetails(((Action.ShowRequirementDetails) action).getRequirementType()), null, 23, null), null, 2, null);
        }
        if (action instanceof Action.ShowSetUpMFA) {
            long jCurrentTimeMillis = this.environment.getClock().currentTimeMillis();
            return new ReducerResult<>(State.copy$default(state, null, false, null, DialogState.MFASetup.INSTANCE, state.getMfaSetupDialogState().copy(Long.valueOf(jCurrentTimeMillis)), 7, null), Effect.INSTANCE.fireAndForget(new C16531(jCurrentTimeMillis, null)));
        }
        if (action instanceof Action.CollaborationActionCompleted) {
            return new ReducerResult<>(State.copy$default(state, null, true, ((Action.CollaborationActionCompleted) action).getCollaborationResponse(), null, null, 17, null), null, 2, null);
        }
        if (action instanceof Action.CollaborationActionFailed) {
            if (((Action.CollaborationActionFailed) action).getError() instanceof CollaborationDomainError.TwoFactorAuthenticationUnmet) {
                collaborationError = DialogState.MFASetup.INSTANCE;
            } else {
                collaborationError = DialogState.CollaborationError.INSTANCE;
            }
            return new ReducerResult<>(State.copy$default(state, null, true, null, collaborationError, null, 17, null), null, 2, null);
        }
        if (action instanceof Action.DismissDialog) {
            return new ReducerResult<>(State.copy$default(state, null, false, null, null, null, 23, null), null, 2, null);
        }
        if (!(action instanceof Action.MfaSetupDialogAction)) {
            throw new NoWhenBranchMatchedException();
        }
        if (((Action.MfaSetupDialogAction) action).getAction() instanceof MfaSetupDialogReducer.Action.Dismiss) {
            return new ReducerResult<>(state, new Effect(Action.DismissDialog.INSTANCE));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    /* JADX INFO: renamed from: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$reduceCollaboration$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$reduceCollaboration$1", f = "InboxItemCollaborationReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16531 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ long $mobileSessionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16531(long j, Continuation<? super C16531> continuation) {
            super(1, continuation);
            this.$mobileSessionId = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return InboxItemCollaborationReducer.this.new C16531(this.$mobileSessionId, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C16531) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                InboxItemCollaborationReducer.this.environment.getMfaSetupAnalytics().setUpMfaButtonClicked(Boxing.boxLong(this.$mobileSessionId));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final ReducerResult<State, Action> handleCollaborationStatusUpdate(State state, InboxNotificationCollaborationStatus status) {
        if (!state.isEnabled()) {
            return new ReducerResult<>(state, null, 2, null);
        }
        InboxNotificationPayloadModel payload = state.getNotification().getPayload();
        InboxNotificationPayloadModel.CollabInvitePayloadInboxModel collabInvitePayloadInboxModel = payload instanceof InboxNotificationPayloadModel.CollabInvitePayloadInboxModel ? (InboxNotificationPayloadModel.CollabInvitePayloadInboxModel) payload : null;
        if (collabInvitePayloadInboxModel == null) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (collabInvitePayloadInboxModel.getCollab().getStatus() != InboxNotificationCollaborationStatus.PENDING) {
            return new ReducerResult<>(state, null, 2, null);
        }
        return new ReducerResult<>(State.copy$default(state, null, false, null, null, null, 29, null), new Effect(FlowKt.flow(new AnonymousClass1(collabInvitePayloadInboxModel, status, null))));
    }

    /* JADX INFO: renamed from: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$handleCollaborationStatusUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: InboxItemCollaborationReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$handleCollaborationStatusUpdate$1", f = "InboxItemCollaborationReducer.kt", i = {0, 1, 1, 2, 2}, l = {224, 229, 230}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ InboxNotificationPayloadModel.CollabInvitePayloadInboxModel $payload;
        final /* synthetic */ InboxNotificationCollaborationStatus $status;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InboxNotificationPayloadModel.CollabInvitePayloadInboxModel collabInvitePayloadInboxModel, InboxNotificationCollaborationStatus inboxNotificationCollaborationStatus, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$payload = collabInvitePayloadInboxModel;
            this.$status = inboxNotificationCollaborationStatus;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = InboxItemCollaborationReducer.this.new AnonymousClass1(this.$payload, this.$status, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
        
            if (r0.emit(new com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer.Action.CollaborationActionCompleted((com.box.android.domain.models.InboxCollaborationResponseModel) ((com.box.android.domain.utils.result.Result.Success) r9).getValue()), r8) == r1) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x00a5, code lost:
        
            if (r0.emit(new com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer.Action.CollaborationActionFailed((com.box.android.domain.models.DomainError) ((com.box.android.domain.utils.result.Result.Error) r9).getValue()), r8) == r1) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = r8.L$0
                kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r8.label
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L2b
                if (r2 == r5) goto L27
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                goto L1e
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1e:
                java.lang.Object r8 = r8.L$1
                com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
                kotlin.ResultKt.throwOnFailure(r9)
                goto La8
            L27:
                kotlin.ResultKt.throwOnFailure(r9)
                goto L52
            L2b:
                kotlin.ResultKt.throwOnFailure(r9)
                com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer r9 = com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer.this
                com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationEnvironment r9 = com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer.access$getEnvironment$p(r9)
                com.box.android.domain.services.IInboxCollaborationService r9 = r9.getInboxCollaborationService()
                com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel$CollabInvitePayloadInboxModel r2 = r8.$payload
                com.box.android.domain.models.inboxnotifications.InboxNotificationCollaborationModel r2 = r2.getCollab()
                java.lang.String r2 = r2.getId()
                com.box.android.domain.models.inboxnotifications.InboxNotificationCollaborationStatus r6 = r8.$status
                r7 = r8
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r8.L$0 = r0
                r8.label = r5
                java.lang.Object r9 = r9.updateCollaborationStatus(r2, r6, r7)
                if (r9 != r1) goto L52
                goto La7
            L52:
                com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
                boolean r2 = r9 instanceof com.box.android.domain.utils.result.Result.Success
                if (r2 == 0) goto L7e
                com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$Action$CollaborationActionCompleted r2 = new com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$Action$CollaborationActionCompleted
                r3 = r9
                com.box.android.domain.utils.result.Result$Success r3 = (com.box.android.domain.utils.result.Result.Success) r3
                java.lang.Object r3 = r3.getValue()
                com.box.android.domain.models.InboxCollaborationResponseModel r3 = (com.box.android.domain.models.InboxCollaborationResponseModel) r3
                r2.<init>(r3)
                r3 = r8
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r8.L$0 = r5
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                r8.L$1 = r9
                r8.label = r4
                java.lang.Object r8 = r0.emit(r2, r3)
                if (r8 != r1) goto La8
                goto La7
            L7e:
                boolean r2 = r9 instanceof com.box.android.domain.utils.result.Result.Error
                if (r2 == 0) goto Lab
                com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$Action$CollaborationActionFailed r2 = new com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$Action$CollaborationActionFailed
                r4 = r9
                com.box.android.domain.utils.result.Result$Error r4 = (com.box.android.domain.utils.result.Result.Error) r4
                java.lang.Object r4 = r4.getValue()
                com.box.android.domain.models.DomainError r4 = (com.box.android.domain.models.DomainError) r4
                r2.<init>(r4)
                r4 = r8
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r8.L$0 = r5
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                r8.L$1 = r9
                r8.label = r3
                java.lang.Object r8 = r0.emit(r2, r4)
                if (r8 != r1) goto La8
            La7:
                return r1
            La8:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            Lab:
                kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
                r8.<init>()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
