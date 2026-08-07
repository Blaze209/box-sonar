package com.box.android.tasks.addtask.cpl;

import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.tasks.TaskType;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.pspdfkit.analytics.Analytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddTaskReducer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0012\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action;", "environment", "Lcom/box/android/tasks/addtask/cpl/AddTaskEnvironment;", "<init>", "(Lcom/box/android/tasks/addtask/cpl/AddTaskEnvironment;)V", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "reduceAddTask", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "reduceFormDelegate", "formAction", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "State", "Action", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AddTaskReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final AddTaskEnvironment environment;

    public AddTaskReducer(AddTaskEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new AddTaskReducer$build$1(this));
        final AddTaskReducer$build$2 addTaskReducer$build$2 = AddTaskReducer$build$2.INSTANCE;
        final AddTaskReducer$build$3 addTaskReducer$build$3 = AddTaskReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new AddTaskFormReducer(environment.getFormEnvironment()), new Function1<State, AddTaskFormReducer.State>() { // from class: com.box.android.tasks.addtask.cpl.AddTaskReducer$special$$inlined$ifCaseLet$1
            @Override // kotlin.jvm.functions.Function1
            public final AddTaskFormReducer.State invoke(AddTaskReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!(it instanceof AddTaskReducer.State.Form)) {
                    it = null;
                }
                AddTaskReducer.State.Form form = (AddTaskReducer.State.Form) it;
                if (form != null) {
                    return form.getAction();
                }
                return null;
            }
        }, new Function1<Action, AddTaskFormReducer.Action>() { // from class: com.box.android.tasks.addtask.cpl.AddTaskReducer$special$$inlined$ifCaseLet$2
            @Override // kotlin.jvm.functions.Function1
            public final AddTaskFormReducer.Action invoke(AddTaskReducer.Action action) {
                if (!(action instanceof AddTaskReducer.Action.Form)) {
                    action = null;
                }
                AddTaskReducer.Action.Form form = (AddTaskReducer.Action.Form) action;
                if (form != null) {
                    return form.getAction();
                }
                return null;
            }
        }, new Function2<State, AddTaskFormReducer.State, State>() { // from class: com.box.android.tasks.addtask.cpl.AddTaskReducer$special$$inlined$ifCaseLet$3
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final AddTaskReducer.State invoke(AddTaskReducer.State state, AddTaskFormReducer.State state2) {
                Intrinsics.checkNotNullParameter(state, "<anonymous parameter 0>");
                Object objInvoke = addTaskReducer$build$2.invoke(state2);
                if (objInvoke != null) {
                    return (AddTaskReducer.State) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.tasks.addtask.cpl.AddTaskReducer.State");
            }
        }, new Function1<AddTaskFormReducer.Action, Action>() { // from class: com.box.android.tasks.addtask.cpl.AddTaskReducer$special$$inlined$ifCaseLet$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final AddTaskReducer.Action invoke(AddTaskFormReducer.Action action) {
                Object objInvoke = addTaskReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (AddTaskReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.tasks.addtask.cpl.AddTaskReducer.Action");
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: AddTaskReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State;", "", "<init>", "()V", "PickType", "Form", "Done", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State$Done;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State$Form;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State$PickType;", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class State {
        public static final int $stable = 0;

        public /* synthetic */ State(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: AddTaskReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State$PickType;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "<init>", "(Lcom/box/android/domain/models/item/FileModel;)V", "getFileModel", "()Lcom/box/android/domain/models/item/FileModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class PickType extends State {
            public static final int $stable = 8;
            private final FileModel fileModel;

            public static /* synthetic */ PickType copy$default(PickType pickType, FileModel fileModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    fileModel = pickType.fileModel;
                }
                return pickType.copy(fileModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final FileModel getFileModel() {
                return this.fileModel;
            }

            public final PickType copy(FileModel fileModel) {
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                return new PickType(fileModel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PickType) && Intrinsics.areEqual(this.fileModel, ((PickType) other).fileModel);
            }

            public int hashCode() {
                return this.fileModel.hashCode();
            }

            public String toString() {
                return "PickType(fileModel=" + this.fileModel + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public PickType(FileModel fileModel) {
                super(null);
                Intrinsics.checkNotNullParameter(fileModel, "fileModel");
                this.fileModel = fileModel;
            }

            public final FileModel getFileModel() {
                return this.fileModel;
            }
        }

        private State() {
        }

        /* JADX INFO: compiled from: AddTaskReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State$Form;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$State;", "state", "<init>", "(Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$State;)V", "getState", "()Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$State;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Form extends State implements Embedded<AddTaskFormReducer.State> {
            public static final int $stable = 8;
            private final AddTaskFormReducer.State state;

            public static /* synthetic */ Form copy$default(Form form, AddTaskFormReducer.State state, int i, Object obj) {
                if ((i & 1) != 0) {
                    state = form.state;
                }
                return form.copy(state);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AddTaskFormReducer.State getAction() {
                return this.state;
            }

            public final Form copy(AddTaskFormReducer.State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return new Form(state);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Form) && Intrinsics.areEqual(this.state, ((Form) other).state);
            }

            public int hashCode() {
                return this.state.hashCode();
            }

            public String toString() {
                return "Form(state=" + this.state + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Form(AddTaskFormReducer.State state) {
                super(null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            public final AddTaskFormReducer.State getState() {
                return this.state;
            }
        }

        /* JADX INFO: compiled from: AddTaskReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State$Done;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$State;", TelemetryEventStrings.Value.SUCCEEDED, "", "<init>", "(Z)V", "getSucceeded", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Done extends State {
            public static final int $stable = 0;
            private final boolean succeeded;

            public static /* synthetic */ Done copy$default(Done done, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = done.succeeded;
                }
                return done.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getSucceeded() {
                return this.succeeded;
            }

            public final Done copy(boolean succeeded) {
                return new Done(succeeded);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Done) && this.succeeded == ((Done) other).succeeded;
            }

            public int hashCode() {
                return Boolean.hashCode(this.succeeded);
            }

            public String toString() {
                return "Done(succeeded=" + this.succeeded + ")";
            }

            public Done(boolean z) {
                super(null);
                this.succeeded = z;
            }

            public final boolean getSucceeded() {
                return this.succeeded;
            }
        }
    }

    /* JADX INFO: compiled from: AddTaskReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action;", "", "<init>", "()V", "TypeSelected", "Dismiss", "Form", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action$Dismiss;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action$Form;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action$TypeSelected;", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: AddTaskReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action$TypeSelected;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action;", "type", "Lcom/box/android/domain/models/tasks/TaskType;", "<init>", "(Lcom/box/android/domain/models/tasks/TaskType;)V", "getType", "()Lcom/box/android/domain/models/tasks/TaskType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TypeSelected extends Action {
            public static final int $stable = 0;
            private final TaskType type;

            public static /* synthetic */ TypeSelected copy$default(TypeSelected typeSelected, TaskType taskType, int i, Object obj) {
                if ((i & 1) != 0) {
                    taskType = typeSelected.type;
                }
                return typeSelected.copy(taskType);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final TaskType getType() {
                return this.type;
            }

            public final TypeSelected copy(TaskType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return new TypeSelected(type);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof TypeSelected) && this.type == ((TypeSelected) other).type;
            }

            public int hashCode() {
                return this.type.hashCode();
            }

            public String toString() {
                return "TypeSelected(type=" + this.type + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TypeSelected(TaskType type) {
                super(null);
                Intrinsics.checkNotNullParameter(type, "type");
                this.type = type;
            }

            public final TaskType getType() {
                return this.type;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: AddTaskReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action$Dismiss;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -416111052;
            }

            public String toString() {
                return "Dismiss";
            }

            private Dismiss() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AddTaskReducer.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action$Form;", "Lcom/box/android/tasks/addtask/cpl/AddTaskReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;)V", "getAction", "()Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "tasks_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Form extends Action implements Embedded<AddTaskFormReducer.Action> {
            public static final int $stable = 0;
            private final AddTaskFormReducer.Action action;

            public static /* synthetic */ Form copy$default(Form form, AddTaskFormReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = form.action;
                }
                return form.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AddTaskFormReducer.Action getAction() {
                return this.action;
            }

            public final Form copy(AddTaskFormReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Form(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Form) && Intrinsics.areEqual(this.action, ((Form) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Form(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Form(AddTaskFormReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final AddTaskFormReducer.Action getAction() {
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
    public final ReducerResult<State, Action> reduceAddTask(State state, Action action) {
        if (!(action instanceof Action.TypeSelected)) {
            if (Intrinsics.areEqual(action, Action.Dismiss.INSTANCE)) {
                return new ReducerResult<>(new State.Done(false), null, 2, null);
            }
            if (action instanceof Action.Form) {
                return reduceFormDelegate(state, ((Action.Form) action).getAction());
            }
            throw new NoWhenBranchMatchedException();
        }
        if (state instanceof State.PickType) {
            State.PickType pickType = (State.PickType) state;
            String str = null;
            List list = null;
            List list2 = null;
            List list3 = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            return new ReducerResult<>(new State.Form(new AddTaskFormReducer.State(pickType.getFileModel(), ((Action.TypeSelected) action).getType(), null, new AssigneePickerReducer.State(pickType.getFileModel().getItemId(), str, list, list2, list3, z, z2, z3, 254, null), 0 == true ? 1 : 0, z4, 0 == true ? 1 : 0, z5, 244, null)), new Effect(new Action.Form(AddTaskFormReducer.Action.LoadAssignees.INSTANCE)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> reduceFormDelegate(State state, AddTaskFormReducer.Action formAction) {
        if (Intrinsics.areEqual(formAction, AddTaskFormReducer.Action.SubmitSucceeded.INSTANCE)) {
            return new ReducerResult<>(new State.Done(true), null, 2, null);
        }
        return Intrinsics.areEqual(formAction, AddTaskFormReducer.Action.Dismiss.INSTANCE) ? new ReducerResult<>(new State.Done(false), null, 2, null) : new ReducerResult<>(state, null, 2, null);
    }
}
