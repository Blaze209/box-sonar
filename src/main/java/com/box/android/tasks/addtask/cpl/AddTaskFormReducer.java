package com.box.android.tasks.addtask.cpl;

import com.box.android.base.models.UserMiniUIModel;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.tasks.CompletionRule;
import com.box.android.domain.models.tasks.TaskType;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AddTaskFormReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0010\u0011\u0012B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u0002H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$State;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "environment", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormEnvironment;", "<init>", "(Lcom/box/android/tasks/addtask/cpl/AddTaskFormEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceForm", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "handleSubmit", "State", "FormStatus", "Action", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AddTaskFormReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final AddTaskFormEnvironment environment;

    /* JADX INFO: compiled from: AddTaskFormReducer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CompletionRule.values().length];
            try {
                iArr[CompletionRule.ALL_ASSIGNEES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CompletionRule.ANY_ASSIGNEE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AddTaskFormReducer(AddTaskFormEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new AddTaskFormReducer$build$1(this));
        final AddTaskFormReducer$build$2 addTaskFormReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.tasks.addtask.cpl.AddTaskFormReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((AddTaskFormReducer.State) obj).getAssigneePickerState();
            }
        };
        final AddTaskFormReducer$build$3 addTaskFormReducer$build$3 = AddTaskFormReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new AssigneePickerReducer(environment.getAssigneePickerEnvironment()), new Function1<State, AssigneePickerReducer.State>() { // from class: com.box.android.tasks.addtask.cpl.AddTaskFormReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.tasks.addtask.cpl.AssigneePickerReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final AssigneePickerReducer.State invoke(AddTaskFormReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return addTaskFormReducer$build$2.invoke(it);
            }
        }, new Function1<Action, AssigneePickerReducer.Action>() { // from class: com.box.android.tasks.addtask.cpl.AddTaskFormReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final AssigneePickerReducer.Action invoke(AddTaskFormReducer.Action action) {
                if (!(action instanceof AddTaskFormReducer.Action.Assignees)) {
                    action = null;
                }
                AddTaskFormReducer.Action.Assignees assignees = (AddTaskFormReducer.Action.Assignees) action;
                if (assignees != null) {
                    return assignees.getState();
                }
                return null;
            }
        }, new Function2<State, AssigneePickerReducer.State, State>() { // from class: com.box.android.tasks.addtask.cpl.AddTaskFormReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final AddTaskFormReducer.State invoke(AddTaskFormReducer.State parentState, AssigneePickerReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = addTaskFormReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(AddTaskFormReducer.State.class)).iterator();
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
                            return (AddTaskFormReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.tasks.addtask.cpl.AddTaskFormReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<AssigneePickerReducer.Action, Action>() { // from class: com.box.android.tasks.addtask.cpl.AddTaskFormReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AddTaskFormReducer.Action invoke(AssigneePickerReducer.Action action) {
                Object objInvoke = addTaskFormReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (AddTaskFormReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.tasks.addtask.cpl.AddTaskFormReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: AddTaskFormReducer.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0007HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\rHÆ\u0003J\t\u0010*\u001a\u00020\u000fHÆ\u0003J\t\u0010+\u001a\u00020\rHÆ\u0003JY\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\rHÆ\u0001J\u0013\u0010-\u001a\u00020\r2\b\u0010.\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010/\u001a\u000200HÖ\u0001J\t\u00101\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010!\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b!\u0010\u001dR\u0011\u0010\"\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b#\u0010\u001d¨\u00062"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$State;", "", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "selectedType", "Lcom/box/android/domain/models/tasks/TaskType;", "message", "", "assigneePickerState", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$State;", "completionRule", "Lcom/box/android/domain/models/tasks/CompletionRule;", "isDueDateEnabled", "", "status", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$FormStatus;", "submitError", "<init>", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/domain/models/tasks/TaskType;Ljava/lang/String;Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$State;Lcom/box/android/domain/models/tasks/CompletionRule;ZLcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$FormStatus;Z)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "getSelectedType", "()Lcom/box/android/domain/models/tasks/TaskType;", "getMessage", "()Ljava/lang/String;", "getAssigneePickerState", "()Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$State;", "getCompletionRule", "()Lcom/box/android/domain/models/tasks/CompletionRule;", "()Z", "getStatus", "()Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$FormStatus;", "getSubmitError", "isSubmitting", "canSubmit", "getCanSubmit", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "", "toString", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final AssigneePickerReducer.State assigneePickerState;
        private final CompletionRule completionRule;
        private final FileModel fileModel;
        private final boolean isDueDateEnabled;
        private final String message;
        private final TaskType selectedType;
        private final FormStatus status;
        private final boolean submitError;

        public static /* synthetic */ State copy$default(State state, FileModel fileModel, TaskType taskType, String str, AssigneePickerReducer.State state2, CompletionRule completionRule, boolean z, FormStatus formStatus, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                fileModel = state.fileModel;
            }
            if ((i & 2) != 0) {
                taskType = state.selectedType;
            }
            if ((i & 4) != 0) {
                str = state.message;
            }
            if ((i & 8) != 0) {
                state2 = state.assigneePickerState;
            }
            if ((i & 16) != 0) {
                completionRule = state.completionRule;
            }
            if ((i & 32) != 0) {
                z = state.isDueDateEnabled;
            }
            if ((i & 64) != 0) {
                formStatus = state.status;
            }
            if ((i & 128) != 0) {
                z2 = state.submitError;
            }
            FormStatus formStatus2 = formStatus;
            boolean z3 = z2;
            CompletionRule completionRule2 = completionRule;
            boolean z4 = z;
            return state.copy(fileModel, taskType, str, state2, completionRule2, z4, formStatus2, z3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final FileModel getFileModel() {
            return this.fileModel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final TaskType getSelectedType() {
            return this.selectedType;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final AssigneePickerReducer.State getAssigneePickerState() {
            return this.assigneePickerState;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final CompletionRule getCompletionRule() {
            return this.completionRule;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsDueDateEnabled() {
            return this.isDueDateEnabled;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final FormStatus getStatus() {
            return this.status;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getSubmitError() {
            return this.submitError;
        }

        public final State copy(FileModel fileModel, TaskType selectedType, String message, AssigneePickerReducer.State assigneePickerState, CompletionRule completionRule, boolean isDueDateEnabled, FormStatus status, boolean submitError) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(selectedType, "selectedType");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(assigneePickerState, "assigneePickerState");
            Intrinsics.checkNotNullParameter(completionRule, "completionRule");
            Intrinsics.checkNotNullParameter(status, "status");
            return new State(fileModel, selectedType, message, assigneePickerState, completionRule, isDueDateEnabled, status, submitError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.fileModel, state.fileModel) && this.selectedType == state.selectedType && Intrinsics.areEqual(this.message, state.message) && Intrinsics.areEqual(this.assigneePickerState, state.assigneePickerState) && this.completionRule == state.completionRule && this.isDueDateEnabled == state.isDueDateEnabled && Intrinsics.areEqual(this.status, state.status) && this.submitError == state.submitError;
        }

        public int hashCode() {
            return (((((((((((((this.fileModel.hashCode() * 31) + this.selectedType.hashCode()) * 31) + this.message.hashCode()) * 31) + this.assigneePickerState.hashCode()) * 31) + this.completionRule.hashCode()) * 31) + Boolean.hashCode(this.isDueDateEnabled)) * 31) + this.status.hashCode()) * 31) + Boolean.hashCode(this.submitError);
        }

        public String toString() {
            return "State(fileModel=" + this.fileModel + ", selectedType=" + this.selectedType + ", message=" + this.message + ", assigneePickerState=" + this.assigneePickerState + ", completionRule=" + this.completionRule + ", isDueDateEnabled=" + this.isDueDateEnabled + ", status=" + this.status + ", submitError=" + this.submitError + ")";
        }

        public State(FileModel fileModel, TaskType selectedType, String message, AssigneePickerReducer.State assigneePickerState, CompletionRule completionRule, boolean z, FormStatus status, boolean z2) {
            Intrinsics.checkNotNullParameter(fileModel, "fileModel");
            Intrinsics.checkNotNullParameter(selectedType, "selectedType");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(assigneePickerState, "assigneePickerState");
            Intrinsics.checkNotNullParameter(completionRule, "completionRule");
            Intrinsics.checkNotNullParameter(status, "status");
            this.fileModel = fileModel;
            this.selectedType = selectedType;
            this.message = message;
            this.assigneePickerState = assigneePickerState;
            this.completionRule = completionRule;
            this.isDueDateEnabled = z;
            this.status = status;
            this.submitError = z2;
        }

        public final FileModel getFileModel() {
            return this.fileModel;
        }

        public final TaskType getSelectedType() {
            return this.selectedType;
        }

        public /* synthetic */ State(FileModel fileModel, TaskType taskType, String str, AssigneePickerReducer.State state, CompletionRule completionRule, boolean z, FormStatus formStatus, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(fileModel, taskType, (i & 4) != 0 ? "" : str, state, (i & 16) != 0 ? CompletionRule.ALL_ASSIGNEES : completionRule, (i & 32) != 0 ? false : z, (i & 64) != 0 ? FormStatus.Editing.INSTANCE : formStatus, (i & 128) != 0 ? false : z2);
        }

        public final String getMessage() {
            return this.message;
        }

        public final AssigneePickerReducer.State getAssigneePickerState() {
            return this.assigneePickerState;
        }

        public final CompletionRule getCompletionRule() {
            return this.completionRule;
        }

        public final boolean isDueDateEnabled() {
            return this.isDueDateEnabled;
        }

        public final FormStatus getStatus() {
            return this.status;
        }

        public final boolean getSubmitError() {
            return this.submitError;
        }

        public final boolean isSubmitting() {
            return this.status instanceof FormStatus.Submitting;
        }

        public final boolean getCanSubmit() {
            return (this.status instanceof FormStatus.Editing) && !this.assigneePickerState.getSelected().isEmpty() && !StringsKt.isBlank(this.message) && StringsKt.isBlank(this.assigneePickerState.getQuery());
        }
    }

    /* JADX INFO: compiled from: AddTaskFormReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$FormStatus;", "", "<init>", "()V", "Editing", "Submitting", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$FormStatus$Editing;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$FormStatus$Submitting;", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class FormStatus {
        public static final int $stable = 0;

        public /* synthetic */ FormStatus(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: AddTaskFormReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$FormStatus$Editing;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$FormStatus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Editing extends FormStatus {
            public static final int $stable = 0;
            public static final Editing INSTANCE = new Editing();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Editing)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1350149178;
            }

            public String toString() {
                return "Editing";
            }

            private Editing() {
                super(null);
            }
        }

        private FormStatus() {
        }

        /* JADX INFO: compiled from: AddTaskFormReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$FormStatus$Submitting;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$FormStatus;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Submitting extends FormStatus {
            public static final int $stable = 0;
            public static final Submitting INSTANCE = new Submitting();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Submitting)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -269907432;
            }

            public String toString() {
                return "Submitting";
            }

            private Submitting() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: AddTaskFormReducer.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\n\u0004\u0005\u0006\u0007\b\t\n\u000b\f\rB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\n\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "", "<init>", "()V", "MessageChanged", "CompletionRuleToggled", "DueDateEnabledChanged", "LoadAssignees", "Submit", "SubmitSucceeded", "SubmitFailed", "Dismiss", "ErrorShown", "Assignees", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$Assignees;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$CompletionRuleToggled;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$Dismiss;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$DueDateEnabledChanged;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$ErrorShown;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$LoadAssignees;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$MessageChanged;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$Submit;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$SubmitFailed;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$SubmitSucceeded;", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: AddTaskFormReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$MessageChanged;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "message", "", "<init>", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class MessageChanged extends Action {
            public static final int $stable = 0;
            private final String message;

            public static /* synthetic */ MessageChanged copy$default(MessageChanged messageChanged, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = messageChanged.message;
                }
                return messageChanged.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final MessageChanged copy(String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                return new MessageChanged(message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof MessageChanged) && Intrinsics.areEqual(this.message, ((MessageChanged) other).message);
            }

            public int hashCode() {
                return this.message.hashCode();
            }

            public String toString() {
                return "MessageChanged(message=" + this.message + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MessageChanged(String message) {
                super(null);
                Intrinsics.checkNotNullParameter(message, "message");
                this.message = message;
            }

            public final String getMessage() {
                return this.message;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: AddTaskFormReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$CompletionRuleToggled;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class CompletionRuleToggled extends Action {
            public static final int $stable = 0;
            public static final CompletionRuleToggled INSTANCE = new CompletionRuleToggled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CompletionRuleToggled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1892953978;
            }

            public String toString() {
                return "CompletionRuleToggled";
            }

            private CompletionRuleToggled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AddTaskFormReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$DueDateEnabledChanged;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class DueDateEnabledChanged extends Action {
            public static final int $stable = 0;
            private final boolean enabled;

            public static /* synthetic */ DueDateEnabledChanged copy$default(DueDateEnabledChanged dueDateEnabledChanged, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = dueDateEnabledChanged.enabled;
                }
                return dueDateEnabledChanged.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getEnabled() {
                return this.enabled;
            }

            public final DueDateEnabledChanged copy(boolean enabled) {
                return new DueDateEnabledChanged(enabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof DueDateEnabledChanged) && this.enabled == ((DueDateEnabledChanged) other).enabled;
            }

            public int hashCode() {
                return Boolean.hashCode(this.enabled);
            }

            public String toString() {
                return "DueDateEnabledChanged(enabled=" + this.enabled + ")";
            }

            public DueDateEnabledChanged(boolean z) {
                super(null);
                this.enabled = z;
            }

            public final boolean getEnabled() {
                return this.enabled;
            }
        }

        /* JADX INFO: compiled from: AddTaskFormReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$LoadAssignees;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class LoadAssignees extends Action {
            public static final int $stable = 0;
            public static final LoadAssignees INSTANCE = new LoadAssignees();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof LoadAssignees)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -178730676;
            }

            public String toString() {
                return "LoadAssignees";
            }

            private LoadAssignees() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AddTaskFormReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$Submit;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Submit extends Action {
            public static final int $stable = 0;
            public static final Submit INSTANCE = new Submit();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Submit)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -2091166518;
            }

            public String toString() {
                return "Submit";
            }

            private Submit() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AddTaskFormReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$SubmitSucceeded;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SubmitSucceeded extends Action {
            public static final int $stable = 0;
            public static final SubmitSucceeded INSTANCE = new SubmitSucceeded();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SubmitSucceeded)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1645784905;
            }

            public String toString() {
                return "SubmitSucceeded";
            }

            private SubmitSucceeded() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AddTaskFormReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$SubmitFailed;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SubmitFailed extends Action {
            public static final int $stable = 0;
            public static final SubmitFailed INSTANCE = new SubmitFailed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SubmitFailed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 422745511;
            }

            public String toString() {
                return "SubmitFailed";
            }

            private SubmitFailed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AddTaskFormReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$Dismiss;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Dismiss extends Action {
            public static final int $stable = 0;
            public static final Dismiss INSTANCE = new Dismiss();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Dismiss)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1157155816;
            }

            public String toString() {
                return "Dismiss";
            }

            private Dismiss() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AddTaskFormReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$ErrorShown;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ErrorShown extends Action {
            public static final int $stable = 0;
            public static final ErrorShown INSTANCE = new ErrorShown();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ErrorShown)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -445041765;
            }

            public String toString() {
                return "ErrorShown";
            }

            private ErrorShown() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AddTaskFormReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action$Assignees;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;)V", "getAction", "()Lcom/box/android/tasks/addtask/cpl/AssigneePickerReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Assignees extends Action implements Embedded<AssigneePickerReducer.Action> {
            public static final int $stable = 0;
            private final AssigneePickerReducer.Action action;

            public static /* synthetic */ Assignees copy$default(Assignees assignees, AssigneePickerReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = assignees.action;
                }
                return assignees.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AssigneePickerReducer.Action getState() {
                return this.action;
            }

            public final Assignees copy(AssigneePickerReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Assignees(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Assignees) && Intrinsics.areEqual(this.action, ((Assignees) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Assignees(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Assignees(AssigneePickerReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final AssigneePickerReducer.Action getAction() {
                return this.action;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ReducerResult<State, Action> reduceForm(State state, Action action) {
        CompletionRule completionRule;
        if (action instanceof Action.MessageChanged) {
            return new ReducerResult<>(State.copy$default(state, null, null, ((Action.MessageChanged) action).getMessage(), null, null, false, null, false, 251, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.CompletionRuleToggled.INSTANCE)) {
            int i = WhenMappings.$EnumSwitchMapping$0[state.getCompletionRule().ordinal()];
            if (i == 1) {
                completionRule = CompletionRule.ANY_ASSIGNEE;
            } else {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                completionRule = CompletionRule.ALL_ASSIGNEES;
            }
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, completionRule, false, null, false, 239, null), null, 2, null);
        }
        if (action instanceof Action.DueDateEnabledChanged) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, ((Action.DueDateEnabledChanged) action).getEnabled(), null, false, 223, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.LoadAssignees.INSTANCE)) {
            return new ReducerResult<>(state, new Effect(new Action.Assignees(AssigneePickerReducer.Action.Load.INSTANCE)));
        }
        if (Intrinsics.areEqual(action, Action.Submit.INSTANCE)) {
            return handleSubmit(state);
        }
        if (Intrinsics.areEqual(action, Action.SubmitSucceeded.INSTANCE)) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.SubmitFailed.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, false, FormStatus.Editing.INSTANCE, true, 63, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.Dismiss.INSTANCE)) {
            return new ReducerResult<>(state, null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.ErrorShown.INSTANCE)) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, false, null, false, 127, null), null, 2, null);
        }
        if (action instanceof Action.Assignees) {
            return new ReducerResult<>(state, null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    private final ReducerResult<State, Action> handleSubmit(State state) {
        if (!state.getCanSubmit()) {
            return new ReducerResult<>(state, null, 2, null);
        }
        String strBoxIdOrNull = state.getFileModel().boxIdOrNull();
        if (strBoxIdOrNull == null) {
            return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, false, null, true, 127, null), null, 2, null);
        }
        String message = state.getMessage();
        TaskType selectedType = state.getSelectedType();
        List<UserMiniUIModel> selected = state.getAssigneePickerState().getSelected();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(selected, 10));
        Iterator<T> it = selected.iterator();
        while (it.hasNext()) {
            arrayList.add(((UserMiniUIModel) it.next()).getId());
        }
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, null, false, FormStatus.Submitting.INSTANCE, false, 191, null), new Effect((Function1) new AnonymousClass1(strBoxIdOrNull, selectedType, message, arrayList, state, null)));
    }

    /* JADX INFO: renamed from: com.box.android.tasks.addtask.cpl.AddTaskFormReducer$handleSubmit$1, reason: invalid class name */
    /* JADX INFO: compiled from: AddTaskFormReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.tasks.addtask.cpl.AddTaskFormReducer$handleSubmit$1", f = "AddTaskFormReducer.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Action>, Object> {
        final /* synthetic */ List<String> $assigneeIds;
        final /* synthetic */ String $fileId;
        final /* synthetic */ String $message;
        final /* synthetic */ State $state;
        final /* synthetic */ TaskType $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, TaskType taskType, String str2, List<String> list, State state, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$fileId = str;
            this.$type = taskType;
            this.$message = str2;
            this.$assigneeIds = list;
            this.$state = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return AddTaskFormReducer.this.new AnonymousClass1(this.$fileId, this.$type, this.$message, this.$assigneeIds, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Action> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = AddTaskFormReducer.this.environment.getTaskService().createTask(this.$fileId, this.$type, this.$message, null, this.$assigneeIds, this.$state.getCompletionRule(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result result = (Result) obj;
            if (result instanceof Result.Success) {
                return Action.SubmitSucceeded.INSTANCE;
            }
            if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            BoxLogUtils.e(ExtensionsKt.getTAG(AddTaskFormReducer.this), "Task creation failed " + ((DomainError) ((Result.Error) result).getValue()).getMessage());
            return Action.SubmitFailed.INSTANCE;
        }
    }
}
