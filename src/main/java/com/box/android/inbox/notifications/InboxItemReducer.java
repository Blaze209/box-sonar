package com.box.android.inbox.notifications;

import com.box.android.cpl.Effect;
import com.box.android.cpl.EffectKt;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Identifiable;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.inboxnotifications.ActionModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationModel;
import com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel;
import com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.pspdfkit.analytics.Analytics;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.InvalidObjectException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: InboxItemReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0015\u0016\u0017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/inbox/notifications/InboxItemReducer$State;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action;", "environment", "Lcom/box/android/inbox/notifications/InboxItemEnvironment;", "<init>", "(Lcom/box/android/inbox/notifications/InboxItemEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceItem", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "createMarkAsReadEffect", "Lcom/box/android/cpl/Effect;", "notificationId", "", "createExecuteActionEffect", "actionId", "RoutingTarget", "State", "Action", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InboxItemReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final InboxItemEnvironment environment;

    public InboxItemReducer(InboxItemEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new InboxItemReducer$build$1(this));
        final InboxItemReducer$build$2 inboxItemReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.inbox.notifications.InboxItemReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((InboxItemReducer.State) obj).getCollaborationState();
            }
        };
        final InboxItemReducer$build$3 inboxItemReducer$build$3 = InboxItemReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new InboxItemCollaborationReducer(environment.getInboxItemCollaborationEnvironment()), new Function1<State, InboxItemCollaborationReducer.State>() { // from class: com.box.android.inbox.notifications.InboxItemReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.inbox.notifications.inboxitem.collab.InboxItemCollaborationReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final InboxItemCollaborationReducer.State invoke(InboxItemReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return inboxItemReducer$build$2.invoke(it);
            }
        }, new Function1<Action, InboxItemCollaborationReducer.Action>() { // from class: com.box.android.inbox.notifications.InboxItemReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final InboxItemCollaborationReducer.Action invoke(InboxItemReducer.Action action) {
                if (!(action instanceof InboxItemReducer.Action.CollaborationAction)) {
                    action = null;
                }
                InboxItemReducer.Action.CollaborationAction collaborationAction = (InboxItemReducer.Action.CollaborationAction) action;
                if (collaborationAction != null) {
                    return collaborationAction.getAction();
                }
                return null;
            }
        }, new Function2<State, InboxItemCollaborationReducer.State, State>() { // from class: com.box.android.inbox.notifications.InboxItemReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final InboxItemReducer.State invoke(InboxItemReducer.State parentState, InboxItemCollaborationReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = inboxItemReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(InboxItemReducer.State.class)).iterator();
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
                            return (InboxItemReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.inbox.notifications.InboxItemReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<InboxItemCollaborationReducer.Action, Action>() { // from class: com.box.android.inbox.notifications.InboxItemReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final InboxItemReducer.Action invoke(InboxItemCollaborationReducer.Action action) {
                Object objInvoke = inboxItemReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (InboxItemReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.inbox.notifications.InboxItemReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: InboxItemReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget;", "", "<init>", "()V", "None", "File", "FileWithComment", "FileWithAnnotation", "Folder", "Task", "Url", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$File;", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$FileWithAnnotation;", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$FileWithComment;", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$Folder;", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$None;", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$Task;", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$Url;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class RoutingTarget {
        public static final int $stable = 0;

        public /* synthetic */ RoutingTarget(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$None;", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class None extends RoutingTarget {
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
                return -1511684115;
            }

            public String toString() {
                return "None";
            }

            private None() {
                super(null);
            }
        }

        private RoutingTarget() {
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$File;", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget;", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class File extends RoutingTarget {
            public static final int $stable = 0;
            private final String id;
            private final String name;

            public static /* synthetic */ File copy$default(File file, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = file.id;
                }
                if ((i & 2) != 0) {
                    str2 = file.name;
                }
                return file.copy(str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final File copy(String id, String name) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(name, "name");
                return new File(id, name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof File)) {
                    return false;
                }
                File file = (File) other;
                return Intrinsics.areEqual(this.id, file.id) && Intrinsics.areEqual(this.name, file.name);
            }

            public int hashCode() {
                return (this.id.hashCode() * 31) + this.name.hashCode();
            }

            public String toString() {
                return "File(id=" + this.id + ", name=" + this.name + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public File(String id, String name) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(name, "name");
                this.id = id;
                this.name = name;
            }

            public final String getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$FileWithComment;", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget;", "id", "", "name", "commentId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getCommentId", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FileWithComment extends RoutingTarget {
            public static final int $stable = 0;
            private final String commentId;
            private final String id;
            private final String name;

            public static /* synthetic */ FileWithComment copy$default(FileWithComment fileWithComment, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = fileWithComment.id;
                }
                if ((i & 2) != 0) {
                    str2 = fileWithComment.name;
                }
                if ((i & 4) != 0) {
                    str3 = fileWithComment.commentId;
                }
                return fileWithComment.copy(str, str2, str3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getCommentId() {
                return this.commentId;
            }

            public final FileWithComment copy(String id, String name, String commentId) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(commentId, "commentId");
                return new FileWithComment(id, name, commentId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FileWithComment)) {
                    return false;
                }
                FileWithComment fileWithComment = (FileWithComment) other;
                return Intrinsics.areEqual(this.id, fileWithComment.id) && Intrinsics.areEqual(this.name, fileWithComment.name) && Intrinsics.areEqual(this.commentId, fileWithComment.commentId);
            }

            public int hashCode() {
                return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.commentId.hashCode();
            }

            public String toString() {
                return "FileWithComment(id=" + this.id + ", name=" + this.name + ", commentId=" + this.commentId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FileWithComment(String id, String name, String commentId) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(commentId, "commentId");
                this.id = id;
                this.name = name;
                this.commentId = commentId;
            }

            public final String getCommentId() {
                return this.commentId;
            }

            public final String getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$FileWithAnnotation;", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget;", "id", "", "name", "annotationId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "getAnnotationId", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FileWithAnnotation extends RoutingTarget {
            public static final int $stable = 0;
            private final String annotationId;
            private final String id;
            private final String name;

            public static /* synthetic */ FileWithAnnotation copy$default(FileWithAnnotation fileWithAnnotation, String str, String str2, String str3, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = fileWithAnnotation.id;
                }
                if ((i & 2) != 0) {
                    str2 = fileWithAnnotation.name;
                }
                if ((i & 4) != 0) {
                    str3 = fileWithAnnotation.annotationId;
                }
                return fileWithAnnotation.copy(str, str2, str3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getAnnotationId() {
                return this.annotationId;
            }

            public final FileWithAnnotation copy(String id, String name, String annotationId) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(annotationId, "annotationId");
                return new FileWithAnnotation(id, name, annotationId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FileWithAnnotation)) {
                    return false;
                }
                FileWithAnnotation fileWithAnnotation = (FileWithAnnotation) other;
                return Intrinsics.areEqual(this.id, fileWithAnnotation.id) && Intrinsics.areEqual(this.name, fileWithAnnotation.name) && Intrinsics.areEqual(this.annotationId, fileWithAnnotation.annotationId);
            }

            public int hashCode() {
                return (((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.annotationId.hashCode();
            }

            public String toString() {
                return "FileWithAnnotation(id=" + this.id + ", name=" + this.name + ", annotationId=" + this.annotationId + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FileWithAnnotation(String id, String name, String annotationId) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(annotationId, "annotationId");
                this.id = id;
                this.name = name;
                this.annotationId = annotationId;
            }

            public final String getAnnotationId() {
                return this.annotationId;
            }

            public final String getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$Folder;", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget;", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Folder extends RoutingTarget {
            public static final int $stable = 0;
            private final String id;
            private final String name;

            public static /* synthetic */ Folder copy$default(Folder folder, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = folder.id;
                }
                if ((i & 2) != 0) {
                    str2 = folder.name;
                }
                return folder.copy(str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getId() {
                return this.id;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getName() {
                return this.name;
            }

            public final Folder copy(String id, String name) {
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(name, "name");
                return new Folder(id, name);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Folder)) {
                    return false;
                }
                Folder folder = (Folder) other;
                return Intrinsics.areEqual(this.id, folder.id) && Intrinsics.areEqual(this.name, folder.name);
            }

            public int hashCode() {
                return (this.id.hashCode() * 31) + this.name.hashCode();
            }

            public String toString() {
                return "Folder(id=" + this.id + ", name=" + this.name + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Folder(String id, String name) {
                super(null);
                Intrinsics.checkNotNullParameter(id, "id");
                Intrinsics.checkNotNullParameter(name, "name");
                this.id = id;
                this.name = name;
            }

            public final String getId() {
                return this.id;
            }

            public final String getName() {
                return this.name;
            }
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$Task;", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget;", "taskId", "", "isMyTask", "", "<init>", "(Ljava/lang/String;Z)V", "getTaskId", "()Ljava/lang/String;", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Task extends RoutingTarget {
            public static final int $stable = 0;
            private final boolean isMyTask;
            private final String taskId;

            public static /* synthetic */ Task copy$default(Task task, String str, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = task.taskId;
                }
                if ((i & 2) != 0) {
                    z = task.isMyTask;
                }
                return task.copy(str, z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getTaskId() {
                return this.taskId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsMyTask() {
                return this.isMyTask;
            }

            public final Task copy(String taskId, boolean isMyTask) {
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                return new Task(taskId, isMyTask);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Task)) {
                    return false;
                }
                Task task = (Task) other;
                return Intrinsics.areEqual(this.taskId, task.taskId) && this.isMyTask == task.isMyTask;
            }

            public int hashCode() {
                return (this.taskId.hashCode() * 31) + Boolean.hashCode(this.isMyTask);
            }

            public String toString() {
                return "Task(taskId=" + this.taskId + ", isMyTask=" + this.isMyTask + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Task(String taskId, boolean z) {
                super(null);
                Intrinsics.checkNotNullParameter(taskId, "taskId");
                this.taskId = taskId;
                this.isMyTask = z;
            }

            public final String getTaskId() {
                return this.taskId;
            }

            public final boolean isMyTask() {
                return this.isMyTask;
            }
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget$Url;", "Lcom/box/android/inbox/notifications/InboxItemReducer$RoutingTarget;", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Url extends RoutingTarget {
            public static final int $stable = 0;
            private final String url;

            public static /* synthetic */ Url copy$default(Url url, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = url.url;
                }
                return url.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getUrl() {
                return this.url;
            }

            public final Url copy(String url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return new Url(url);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Url) && Intrinsics.areEqual(this.url, ((Url) other).url);
            }

            public int hashCode() {
                return this.url.hashCode();
            }

            public String toString() {
                return "Url(url=" + this.url + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Url(String url) {
                super(null);
                Intrinsics.checkNotNullParameter(url, "url");
                this.url = url;
            }

            public final String getUrl() {
                return this.url;
            }
        }
    }

    /* JADX INFO: compiled from: InboxItemReducer.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J'\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010!\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0002HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\rR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u00158F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a¨\u0006'"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$State;", "Lcom/box/android/cpl/Identifiable;", "", "notification", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "isEnabled", "", "collaborationState", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$State;", "<init>", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;ZLcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$State;)V", "getNotification", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationModel;", "()Z", "getCollaborationState", "()Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$State;", "id", "getId", "()Ljava/lang/String;", "moreActions", "", "Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "getMoreActions", "()Ljava/util/List;", "primaryAction", "getPrimaryAction", "()Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "secondaryAction", "getSecondaryAction", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State implements Identifiable<String> {
        public static final int $stable = 8;
        private final InboxItemCollaborationReducer.State collaborationState;
        private final String id;
        private final boolean isEnabled;
        private final InboxNotificationModel notification;

        public static /* synthetic */ State copy$default(State state, InboxNotificationModel inboxNotificationModel, boolean z, InboxItemCollaborationReducer.State state2, int i, Object obj) {
            if ((i & 1) != 0) {
                inboxNotificationModel = state.notification;
            }
            if ((i & 2) != 0) {
                z = state.isEnabled;
            }
            if ((i & 4) != 0) {
                state2 = state.collaborationState;
            }
            return state.copy(inboxNotificationModel, z, state2);
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
        public final InboxItemCollaborationReducer.State getCollaborationState() {
            return this.collaborationState;
        }

        public final State copy(InboxNotificationModel notification, boolean isEnabled, InboxItemCollaborationReducer.State collaborationState) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            Intrinsics.checkNotNullParameter(collaborationState, "collaborationState");
            return new State(notification, isEnabled, collaborationState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.notification, state.notification) && this.isEnabled == state.isEnabled && Intrinsics.areEqual(this.collaborationState, state.collaborationState);
        }

        public int hashCode() {
            return (((this.notification.hashCode() * 31) + Boolean.hashCode(this.isEnabled)) * 31) + this.collaborationState.hashCode();
        }

        public String toString() {
            return "State(notification=" + this.notification + ", isEnabled=" + this.isEnabled + ", collaborationState=" + this.collaborationState + ")";
        }

        public State(InboxNotificationModel notification, boolean z, InboxItemCollaborationReducer.State collaborationState) {
            Intrinsics.checkNotNullParameter(notification, "notification");
            Intrinsics.checkNotNullParameter(collaborationState, "collaborationState");
            this.notification = notification;
            this.isEnabled = z;
            this.collaborationState = collaborationState;
            this.id = notification.getId();
        }

        public final InboxNotificationModel getNotification() {
            return this.notification;
        }

        public final boolean isEnabled() {
            return this.isEnabled;
        }

        public /* synthetic */ State(InboxNotificationModel inboxNotificationModel, boolean z, InboxItemCollaborationReducer.State state, int i, DefaultConstructorMarker defaultConstructorMarker) {
            InboxNotificationModel inboxNotificationModel2;
            z = (i & 2) != 0 ? true : z;
            if ((i & 4) != 0) {
                inboxNotificationModel2 = inboxNotificationModel;
                state = new InboxItemCollaborationReducer.State(inboxNotificationModel2, false, null, null, null, 30, null);
            } else {
                inboxNotificationModel2 = inboxNotificationModel;
            }
            this(inboxNotificationModel2, z, state);
        }

        public final InboxItemCollaborationReducer.State getCollaborationState() {
            return this.collaborationState;
        }

        @Override // com.box.android.cpl.Identifiable
        public String getId() {
            return this.id;
        }

        public final List<ActionModel> getMoreActions() {
            List<ActionModel> menuActions;
            InboxNotificationPayloadModel payload = this.notification.getPayload();
            InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel = payload instanceof InboxNotificationPayloadModel.CommonPayloadInboxModel ? (InboxNotificationPayloadModel.CommonPayloadInboxModel) payload : null;
            if (commonPayloadInboxModel == null || (menuActions = commonPayloadInboxModel.getMenuActions()) == null || menuActions.isEmpty()) {
                return null;
            }
            return menuActions;
        }

        public final ActionModel getPrimaryAction() {
            InboxNotificationPayloadModel payload = this.notification.getPayload();
            InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel = payload instanceof InboxNotificationPayloadModel.CommonPayloadInboxModel ? (InboxNotificationPayloadModel.CommonPayloadInboxModel) payload : null;
            if (commonPayloadInboxModel != null) {
                return commonPayloadInboxModel.getPrimaryAction();
            }
            return null;
        }

        public final ActionModel getSecondaryAction() {
            InboxNotificationPayloadModel payload = this.notification.getPayload();
            InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel = payload instanceof InboxNotificationPayloadModel.CommonPayloadInboxModel ? (InboxNotificationPayloadModel.CommonPayloadInboxModel) payload : null;
            if (commonPayloadInboxModel != null) {
                return commonPayloadInboxModel.getSecondaryAction();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: InboxItemReducer.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$Action;", "", "<init>", "()V", "Clicked", "SecondaryAction", "MarkAsRead", "CollaborationAction", "ExecuteCommonCardAction", "CommonCardActionCompleted", "CommonCardActionFailed", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action$Clicked;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action$CollaborationAction;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action$CommonCardActionCompleted;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action$CommonCardActionFailed;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action$ExecuteCommonCardAction;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action$MarkAsRead;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action$SecondaryAction;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$Action$Clicked;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Clicked extends Action {
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
                return 1167616589;
            }

            public String toString() {
                return "Clicked";
            }

            private Clicked() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$Action$SecondaryAction;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SecondaryAction extends Action {
            public static final int $stable = 0;
            public static final SecondaryAction INSTANCE = new SecondaryAction();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SecondaryAction)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 391071984;
            }

            public String toString() {
                return "SecondaryAction";
            }

            private SecondaryAction() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$Action$MarkAsRead;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MarkAsRead extends Action {
            public static final int $stable = 0;
            public static final MarkAsRead INSTANCE = new MarkAsRead();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof MarkAsRead)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 383222319;
            }

            public String toString() {
                return "MarkAsRead";
            }

            private MarkAsRead() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$Action$CollaborationAction;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;)V", "getAction", "()Lcom/box/android/inbox/notifications/inboxitem/collab/InboxItemCollaborationReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CollaborationAction extends Action implements Embedded<InboxItemCollaborationReducer.Action> {
            public static final int $stable = 0;
            private final InboxItemCollaborationReducer.Action action;

            public static /* synthetic */ CollaborationAction copy$default(CollaborationAction collaborationAction, InboxItemCollaborationReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = collaborationAction.action;
                }
                return collaborationAction.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InboxItemCollaborationReducer.Action getAction() {
                return this.action;
            }

            public final CollaborationAction copy(InboxItemCollaborationReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new CollaborationAction(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CollaborationAction) && Intrinsics.areEqual(this.action, ((CollaborationAction) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "CollaborationAction(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CollaborationAction(InboxItemCollaborationReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final InboxItemCollaborationReducer.Action getAction() {
                return this.action;
            }
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$Action$ExecuteCommonCardAction;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action;", "actionModel", "Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "<init>", "(Lcom/box/android/domain/models/inboxnotifications/ActionModel;)V", "getActionModel", "()Lcom/box/android/domain/models/inboxnotifications/ActionModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ExecuteCommonCardAction extends Action {
            public static final int $stable = 8;
            private final ActionModel actionModel;

            public static /* synthetic */ ExecuteCommonCardAction copy$default(ExecuteCommonCardAction executeCommonCardAction, ActionModel actionModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    actionModel = executeCommonCardAction.actionModel;
                }
                return executeCommonCardAction.copy(actionModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ActionModel getActionModel() {
                return this.actionModel;
            }

            public final ExecuteCommonCardAction copy(ActionModel actionModel) {
                Intrinsics.checkNotNullParameter(actionModel, "actionModel");
                return new ExecuteCommonCardAction(actionModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ExecuteCommonCardAction) && Intrinsics.areEqual(this.actionModel, ((ExecuteCommonCardAction) other).actionModel);
            }

            public int hashCode() {
                return this.actionModel.hashCode();
            }

            public String toString() {
                return "ExecuteCommonCardAction(actionModel=" + this.actionModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ExecuteCommonCardAction(ActionModel actionModel) {
                super(null);
                Intrinsics.checkNotNullParameter(actionModel, "actionModel");
                this.actionModel = actionModel;
            }

            public final ActionModel getActionModel() {
                return this.actionModel;
            }
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$Action$CommonCardActionCompleted;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action;", "updatedPayload", "Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommonPayloadInboxModel;", "<init>", "(Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommonPayloadInboxModel;)V", "getUpdatedPayload", "()Lcom/box/android/domain/models/inboxnotifications/InboxNotificationPayloadModel$CommonPayloadInboxModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CommonCardActionCompleted extends Action {
            public static final int $stable = 8;
            private final InboxNotificationPayloadModel.CommonPayloadInboxModel updatedPayload;

            public static /* synthetic */ CommonCardActionCompleted copy$default(CommonCardActionCompleted commonCardActionCompleted, InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    commonPayloadInboxModel = commonCardActionCompleted.updatedPayload;
                }
                return commonCardActionCompleted.copy(commonPayloadInboxModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InboxNotificationPayloadModel.CommonPayloadInboxModel getUpdatedPayload() {
                return this.updatedPayload;
            }

            public final CommonCardActionCompleted copy(InboxNotificationPayloadModel.CommonPayloadInboxModel updatedPayload) {
                return new CommonCardActionCompleted(updatedPayload);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof CommonCardActionCompleted) && Intrinsics.areEqual(this.updatedPayload, ((CommonCardActionCompleted) other).updatedPayload);
            }

            public int hashCode() {
                InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel = this.updatedPayload;
                if (commonPayloadInboxModel == null) {
                    return 0;
                }
                return commonPayloadInboxModel.hashCode();
            }

            public String toString() {
                return "CommonCardActionCompleted(updatedPayload=" + this.updatedPayload + ")";
            }

            public CommonCardActionCompleted(InboxNotificationPayloadModel.CommonPayloadInboxModel commonPayloadInboxModel) {
                super(null);
                this.updatedPayload = commonPayloadInboxModel;
            }

            public final InboxNotificationPayloadModel.CommonPayloadInboxModel getUpdatedPayload() {
                return this.updatedPayload;
            }
        }

        /* JADX INFO: compiled from: InboxItemReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/notifications/InboxItemReducer$Action$CommonCardActionFailed;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CommonCardActionFailed extends Action {
            public static final int $stable = 0;
            public static final CommonCardActionFailed INSTANCE = new CommonCardActionFailed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CommonCardActionFailed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -803683736;
            }

            public String toString() {
                return "CommonCardActionFailed";
            }

            private CommonCardActionFailed() {
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
    public final ReducerResult<State, Action> reduceItem(State state, Action action) {
        InboxNotificationModel notification;
        Effect effectNone;
        if (action instanceof Action.Clicked) {
            if (!state.getNotification().isRead()) {
                effectNone = new Effect(Action.MarkAsRead.INSTANCE);
            } else {
                effectNone = Effect.INSTANCE.none();
            }
            return new ReducerResult<>(state, effectNone);
        }
        if (action instanceof Action.MarkAsRead) {
            return new ReducerResult<>(State.copy$default(state, InboxNotificationModel.copy$default(state.getNotification(), null, null, null, false, true, null, null, null, 239, null), false, null, 6, null), createMarkAsReadEffect(state.getNotification().getId()));
        }
        int i = 2;
        Effect effect = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        Object[] objArr6 = 0;
        Object[] objArr7 = 0;
        if (action instanceof Action.ExecuteCommonCardAction) {
            String actionId = ((Action.ExecuteCommonCardAction) action).getActionModel().getActionHandler().getActionId();
            if (actionId != null) {
                return new ReducerResult<>(State.copy$default(state, null, false, null, 5, null), createExecuteActionEffect(state.getNotification().getId(), actionId));
            }
            return new ReducerResult<>(state, effect, i, objArr7 == true ? 1 : 0);
        }
        if (action instanceof Action.CommonCardActionCompleted) {
            Action.CommonCardActionCompleted commonCardActionCompleted = (Action.CommonCardActionCompleted) action;
            if (commonCardActionCompleted.getUpdatedPayload() != null) {
                notification = InboxNotificationModel.copy$default(state.getNotification(), null, null, null, false, false, commonCardActionCompleted.getUpdatedPayload(), null, null, 223, null);
            } else {
                notification = state.getNotification();
            }
            return new ReducerResult<>(State.copy$default(state, notification, true, null, 4, null), objArr6 == true ? 1 : 0, i, objArr5 == true ? 1 : 0);
        }
        if (action instanceof Action.CommonCardActionFailed) {
            return new ReducerResult<>(State.copy$default(state, null, true, null, 5, null), objArr4 == true ? 1 : 0, i, objArr3 == true ? 1 : 0);
        }
        return new ReducerResult<>(state, objArr2 == true ? 1 : 0, i, objArr == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: com.box.android.inbox.notifications.InboxItemReducer$createMarkAsReadEffect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InboxItemReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.inbox.notifications.InboxItemReducer$createMarkAsReadEffect$1", f = "InboxItemReducer.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C16501 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $notificationId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C16501(String str, Continuation<? super C16501> continuation) {
            super(2, continuation);
            this.$notificationId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return InboxItemReducer.this.new C16501(this.$notificationId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((C16501) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (InboxItemReducer.this.environment.getInboxNotificationService().markNotificationAsRead(this.$notificationId, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final Effect<Action> createMarkAsReadEffect(String notificationId) {
        return EffectKt.toEffect(FlowKt.flow(new C16501(notificationId, null)));
    }

    /* JADX INFO: renamed from: com.box.android.inbox.notifications.InboxItemReducer$createExecuteActionEffect$1, reason: invalid class name */
    /* JADX INFO: compiled from: InboxItemReducer.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/inbox/notifications/InboxItemReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.inbox.notifications.InboxItemReducer$createExecuteActionEffect$1", f = "InboxItemReducer.kt", i = {0, 1, 1, 1, 1, 2, 2}, l = {130, Token.SETELEM_OP, Token.COLONCOLON}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "response", "updatedPayload", "$this$flow", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Action>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $actionId;
        final /* synthetic */ String $notificationId;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$notificationId = str;
            this.$actionId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = InboxItemReducer.this.new AnonymousClass1(this.$notificationId, this.$actionId, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(FlowCollector<? super Action> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0093, code lost:
        
            if (r0.emit(new com.box.android.inbox.notifications.InboxItemReducer.Action.CommonCardActionCompleted(r3), r8) == r1) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00b1, code lost:
        
            if (r0.emit(com.box.android.inbox.notifications.InboxItemReducer.Action.CommonCardActionFailed.INSTANCE, r8) == r1) goto L29;
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
                if (r2 == 0) goto L33
                if (r2 == r5) goto L2f
                if (r2 == r4) goto L1e
                if (r2 != r3) goto L16
                goto L26
            L16:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L1e:
                java.lang.Object r0 = r8.L$3
                com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel$CommonPayloadInboxModel r0 = (com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel.CommonPayloadInboxModel) r0
                java.lang.Object r0 = r8.L$2
                com.box.android.domain.models.inboxnotifications.InboxNotificationActionResponseModel r0 = (com.box.android.domain.models.inboxnotifications.InboxNotificationActionResponseModel) r0
            L26:
                java.lang.Object r8 = r8.L$1
                com.box.android.domain.utils.result.Result r8 = (com.box.android.domain.utils.result.Result) r8
                kotlin.ResultKt.throwOnFailure(r9)
                goto Lb4
            L2f:
                kotlin.ResultKt.throwOnFailure(r9)
                goto L52
            L33:
                kotlin.ResultKt.throwOnFailure(r9)
                com.box.android.inbox.notifications.InboxItemReducer r9 = com.box.android.inbox.notifications.InboxItemReducer.this
                com.box.android.inbox.notifications.InboxItemEnvironment r9 = com.box.android.inbox.notifications.InboxItemReducer.access$getEnvironment$p(r9)
                com.box.android.domain.services.IInboxNotificationService r9 = r9.getInboxNotificationService()
                java.lang.String r2 = r8.$notificationId
                java.lang.String r6 = r8.$actionId
                r7 = r8
                kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
                r8.L$0 = r0
                r8.label = r5
                java.lang.Object r9 = r9.executeAction(r2, r6, r7)
                if (r9 != r1) goto L52
                goto Lb3
            L52:
                com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
                boolean r2 = r9 instanceof com.box.android.domain.utils.result.Result.Success
                if (r2 == 0) goto L96
                r2 = r9
                com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
                java.lang.Object r2 = r2.getValue()
                com.box.android.domain.models.inboxnotifications.InboxNotificationActionResponseModel r2 = (com.box.android.domain.models.inboxnotifications.InboxNotificationActionResponseModel) r2
                com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel r3 = r2.getPayload()
                boolean r5 = r3 instanceof com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel.CommonPayloadInboxModel
                if (r5 == 0) goto L6c
                com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel$CommonPayloadInboxModel r3 = (com.box.android.domain.models.inboxnotifications.InboxNotificationPayloadModel.CommonPayloadInboxModel) r3
                goto L6d
            L6c:
                r3 = 0
            L6d:
                com.box.android.inbox.notifications.InboxItemReducer$Action$CommonCardActionCompleted r5 = new com.box.android.inbox.notifications.InboxItemReducer$Action$CommonCardActionCompleted
                r5.<init>(r3)
                r6 = r8
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r8.L$0 = r7
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                r8.L$1 = r9
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
                r8.L$2 = r9
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r3)
                r8.L$3 = r9
                r8.label = r4
                java.lang.Object r8 = r0.emit(r5, r6)
                if (r8 != r1) goto Lb4
                goto Lb3
            L96:
                boolean r2 = r9 instanceof com.box.android.domain.utils.result.Result.Error
                if (r2 == 0) goto Lb7
                com.box.android.inbox.notifications.InboxItemReducer$Action$CommonCardActionFailed r2 = com.box.android.inbox.notifications.InboxItemReducer.Action.CommonCardActionFailed.INSTANCE
                r4 = r8
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
                r8.L$0 = r5
                java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
                r8.L$1 = r9
                r8.label = r3
                java.lang.Object r8 = r0.emit(r2, r4)
                if (r8 != r1) goto Lb4
            Lb3:
                return r1
            Lb4:
                kotlin.Unit r8 = kotlin.Unit.INSTANCE
                return r8
            Lb7:
                kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
                r8.<init>()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.inbox.notifications.InboxItemReducer.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    private final Effect<Action> createExecuteActionEffect(String notificationId, String actionId) {
        return EffectKt.toEffect(FlowKt.flow(new AnonymousClass1(notificationId, actionId, null)));
    }
}
