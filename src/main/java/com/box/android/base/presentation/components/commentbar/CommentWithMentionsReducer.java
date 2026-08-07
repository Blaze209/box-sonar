package com.box.android.base.presentation.components.commentbar;

import com.box.android.base.R;
import com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsReducer;
import com.box.android.base.presentation.components.inputbar.InputBoxValue;
import com.box.android.base.presentation.components.inputbar.KeyboardAction;
import com.box.android.base.presentation.components.inputbar.TextFieldValueUIModel;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Embedded;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.cpl.reducers.IfLetReducer;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ItemId;
import com.box.androidsdk.content.models.BoxCollaborator;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.pspdfkit.analytics.Analytics;
import java.io.InvalidObjectException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KFunction;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KCallables;
import kotlin.reflect.full.KClasses;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003#$%B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J$\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J$\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001aH\u0002J$\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001cH\u0002J\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0002J\u0014\u0010 \u001a\u00020\u001e*\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006&"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$State;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "environment", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsEnvironment;", "<init>", "(Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsEnvironment;)V", "getEnvironment", "()Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsEnvironment;", "build", "getBuild", "()Lcom/box/android/cpl/Reducable;", "getMentionInProgressRange", "Lkotlin/ranges/IntRange;", "textFieldValue", "Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "mentions", "", "Lcom/box/android/base/presentation/components/commentbar/MentionSpanV2;", "handleMentionOptionClick", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action$OnMentionOptionClicked;", "handleToggleCommentWithTimestamp", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$ToggleCommentWithTimestamp;", "handleCommentBoxTextChanged", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$TextChanged;", "hideCollaborators", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$Collaborators;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$Collaborators$Companion;", "loadCollaborators", "prefix", "", "State", "Action", "InputBoxState", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommentWithMentionsReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reducable<State, Action> build;
    private final CommentWithMentionsEnvironment environment;

    public CommentWithMentionsReducer(CommentWithMentionsEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
        Reduce reduce = new Reduce(new Function2() { // from class: com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return CommentWithMentionsReducer.build$lambda$0(this.f$0, (CommentWithMentionsReducer.State) obj, (CommentWithMentionsReducer.Action) obj2);
            }
        });
        final CommentWithMentionsReducer$build$2 commentWithMentionsReducer$build$2 = new PropertyReference1Impl() { // from class: com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer$build$2
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((CommentWithMentionsReducer.State) obj).getMentionsState();
            }
        };
        final CommentWithMentionsReducer$build$3 commentWithMentionsReducer$build$3 = CommentWithMentionsReducer$build$3.INSTANCE;
        this.build = new IfLetReducer(reduce, new CollaboratorsMentionsReducer(environment.getCollaboratorsEnvironment()), new Function1<State, CollaboratorsMentionsReducer.State>() { // from class: com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer$special$$inlined$scope$1
            {
                super(1);
            }

            /* JADX WARN: Type inference failed for: r1v2, types: [com.box.android.base.presentation.components.commentbar.mentions.CollaboratorsMentionsReducer$State, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public final CollaboratorsMentionsReducer.State invoke(CommentWithMentionsReducer.State it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return commentWithMentionsReducer$build$2.invoke(it);
            }
        }, new Function1<Action, CollaboratorsMentionsReducer.Action>() { // from class: com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer$special$$inlined$scope$2
            @Override // kotlin.jvm.functions.Function1
            public final CollaboratorsMentionsReducer.Action invoke(CommentWithMentionsReducer.Action action) {
                if (!(action instanceof CommentWithMentionsReducer.Action.Collaborators)) {
                    action = null;
                }
                CommentWithMentionsReducer.Action.Collaborators collaborators = (CommentWithMentionsReducer.Action.Collaborators) action;
                if (collaborators != null) {
                    return collaborators.getFile();
                }
                return null;
            }
        }, new Function2<State, CollaboratorsMentionsReducer.State, State>() { // from class: com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer$special$$inlined$scope$3
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public final CommentWithMentionsReducer.State invoke(CommentWithMentionsReducer.State parentState, CollaboratorsMentionsReducer.State state) throws InvalidObjectException {
                Object next;
                Intrinsics.checkNotNullParameter(parentState, "parentState");
                KProperty1 kProperty1 = commentWithMentionsReducer$build$2;
                Iterator<T> it = KClasses.getMemberFunctions(Reflection.getOrCreateKotlinClass(CommentWithMentionsReducer.State.class)).iterator();
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
                            return (CommentWithMentionsReducer.State) rCallBy;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer.State");
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }, new Function1<CollaboratorsMentionsReducer.Action, Action>() { // from class: com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer$special$$inlined$scope$4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CommentWithMentionsReducer.Action invoke(CollaboratorsMentionsReducer.Action action) {
                Object objInvoke = commentWithMentionsReducer$build$3.invoke(action);
                if (objInvoke != null) {
                    return (CommentWithMentionsReducer.Action) objInvoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer.Action");
            }
        });
    }

    public final CommentWithMentionsEnvironment getEnvironment() {
        return this.environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J?\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$State;", "", "itemId", "Lcom/box/android/domain/models/ItemId;", "inputBoxState", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;", "mentionsState", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$State;", "keyboardAction", "Lcom/box/android/base/presentation/components/inputbar/KeyboardAction;", "timestampedCommentConfig", "Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "<init>", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$State;Lcom/box/android/base/presentation/components/inputbar/KeyboardAction;Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;)V", "getItemId", "()Lcom/box/android/domain/models/ItemId;", "getInputBoxState", "()Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;", "getMentionsState", "()Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$State;", "getKeyboardAction", "()Lcom/box/android/base/presentation/components/inputbar/KeyboardAction;", "getTimestampedCommentConfig", "()Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "component1", "component2", "component3", "component4", "component5", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final InputBoxState inputBoxState;
        private final ItemId itemId;
        private final KeyboardAction keyboardAction;
        private final CollaboratorsMentionsReducer.State mentionsState;
        private final TimestampedCommentConfig timestampedCommentConfig;

        public static /* synthetic */ State copy$default(State state, ItemId itemId, InputBoxState inputBoxState, CollaboratorsMentionsReducer.State state2, KeyboardAction keyboardAction, TimestampedCommentConfig timestampedCommentConfig, int i, Object obj) {
            if ((i & 1) != 0) {
                itemId = state.itemId;
            }
            if ((i & 2) != 0) {
                inputBoxState = state.inputBoxState;
            }
            if ((i & 4) != 0) {
                state2 = state.mentionsState;
            }
            if ((i & 8) != 0) {
                keyboardAction = state.keyboardAction;
            }
            if ((i & 16) != 0) {
                timestampedCommentConfig = state.timestampedCommentConfig;
            }
            TimestampedCommentConfig timestampedCommentConfig2 = timestampedCommentConfig;
            CollaboratorsMentionsReducer.State state3 = state2;
            return state.copy(itemId, inputBoxState, state3, keyboardAction, timestampedCommentConfig2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemId getItemId() {
            return this.itemId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final InputBoxState getInputBoxState() {
            return this.inputBoxState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final CollaboratorsMentionsReducer.State getMentionsState() {
            return this.mentionsState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final KeyboardAction getKeyboardAction() {
            return this.keyboardAction;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final TimestampedCommentConfig getTimestampedCommentConfig() {
            return this.timestampedCommentConfig;
        }

        public final State copy(ItemId itemId, InputBoxState inputBoxState, CollaboratorsMentionsReducer.State mentionsState, KeyboardAction keyboardAction, TimestampedCommentConfig timestampedCommentConfig) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(inputBoxState, "inputBoxState");
            Intrinsics.checkNotNullParameter(mentionsState, "mentionsState");
            return new State(itemId, inputBoxState, mentionsState, keyboardAction, timestampedCommentConfig);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.itemId, state.itemId) && Intrinsics.areEqual(this.inputBoxState, state.inputBoxState) && Intrinsics.areEqual(this.mentionsState, state.mentionsState) && this.keyboardAction == state.keyboardAction && Intrinsics.areEqual(this.timestampedCommentConfig, state.timestampedCommentConfig);
        }

        public int hashCode() {
            int iHashCode = ((((this.itemId.hashCode() * 31) + this.inputBoxState.hashCode()) * 31) + this.mentionsState.hashCode()) * 31;
            KeyboardAction keyboardAction = this.keyboardAction;
            int iHashCode2 = (iHashCode + (keyboardAction == null ? 0 : keyboardAction.hashCode())) * 31;
            TimestampedCommentConfig timestampedCommentConfig = this.timestampedCommentConfig;
            return iHashCode2 + (timestampedCommentConfig != null ? timestampedCommentConfig.hashCode() : 0);
        }

        public String toString() {
            return "State(itemId=" + this.itemId + ", inputBoxState=" + this.inputBoxState + ", mentionsState=" + this.mentionsState + ", keyboardAction=" + this.keyboardAction + ", timestampedCommentConfig=" + this.timestampedCommentConfig + ")";
        }

        public State(ItemId itemId, InputBoxState inputBoxState, CollaboratorsMentionsReducer.State mentionsState, KeyboardAction keyboardAction, TimestampedCommentConfig timestampedCommentConfig) {
            Intrinsics.checkNotNullParameter(itemId, "itemId");
            Intrinsics.checkNotNullParameter(inputBoxState, "inputBoxState");
            Intrinsics.checkNotNullParameter(mentionsState, "mentionsState");
            this.itemId = itemId;
            this.inputBoxState = inputBoxState;
            this.mentionsState = mentionsState;
            this.keyboardAction = keyboardAction;
            this.timestampedCommentConfig = timestampedCommentConfig;
        }

        public final ItemId getItemId() {
            return this.itemId;
        }

        public /* synthetic */ State(ItemId itemId, InputBoxState inputBoxState, CollaboratorsMentionsReducer.State state, KeyboardAction keyboardAction, TimestampedCommentConfig timestampedCommentConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(itemId, (i & 2) != 0 ? new InputBoxState.ErrorMessage(R.string.Box_account_storage_limit_exceeded) : inputBoxState, (i & 4) != 0 ? new CollaboratorsMentionsReducer.State(itemId, null, null, 6, null) : state, (i & 8) != 0 ? null : keyboardAction, (i & 16) != 0 ? null : timestampedCommentConfig);
        }

        public final InputBoxState getInputBoxState() {
            return this.inputBoxState;
        }

        public final CollaboratorsMentionsReducer.State getMentionsState() {
            return this.mentionsState;
        }

        public final KeyboardAction getKeyboardAction() {
            return this.keyboardAction;
        }

        public final TimestampedCommentConfig getTimestampedCommentConfig() {
            return this.timestampedCommentConfig;
        }
    }

    /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\t\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\t\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "", "<init>", "()V", "UpdateInputBoxState", "UpdateInputBoxStateWithTimestamp", "TextChanged", "SubmitCommentClicked", "ExitModifyClicked", "Collaborators", "ShowKeyboard", "KeyboardActionHandled", "ToggleCommentWithTimestamp", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$Collaborators;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$ExitModifyClicked;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$KeyboardActionHandled;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$ShowKeyboard;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$SubmitCommentClicked;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$TextChanged;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$ToggleCommentWithTimestamp;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$UpdateInputBoxState;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$UpdateInputBoxStateWithTimestamp;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Action() {
        }

        /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$UpdateInputBoxState;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "newInputBoxState", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;", "<init>", "(Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;)V", "getNewInputBoxState", "()Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateInputBoxState extends Action {
            public static final int $stable = 0;
            private final InputBoxState newInputBoxState;

            public static /* synthetic */ UpdateInputBoxState copy$default(UpdateInputBoxState updateInputBoxState, InputBoxState inputBoxState, int i, Object obj) {
                if ((i & 1) != 0) {
                    inputBoxState = updateInputBoxState.newInputBoxState;
                }
                return updateInputBoxState.copy(inputBoxState);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InputBoxState getNewInputBoxState() {
                return this.newInputBoxState;
            }

            public final UpdateInputBoxState copy(InputBoxState newInputBoxState) {
                Intrinsics.checkNotNullParameter(newInputBoxState, "newInputBoxState");
                return new UpdateInputBoxState(newInputBoxState);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateInputBoxState) && Intrinsics.areEqual(this.newInputBoxState, ((UpdateInputBoxState) other).newInputBoxState);
            }

            public int hashCode() {
                return this.newInputBoxState.hashCode();
            }

            public String toString() {
                return "UpdateInputBoxState(newInputBoxState=" + this.newInputBoxState + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateInputBoxState(InputBoxState newInputBoxState) {
                super(null);
                Intrinsics.checkNotNullParameter(newInputBoxState, "newInputBoxState");
                this.newInputBoxState = newInputBoxState;
            }

            public final InputBoxState getNewInputBoxState() {
                return this.newInputBoxState;
            }
        }

        /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$UpdateInputBoxStateWithTimestamp;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "newInputBoxState", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;", "timestampConfig", "Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "<init>", "(Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;)V", "getNewInputBoxState", "()Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;", "getTimestampConfig", "()Lcom/box/android/base/presentation/components/commentbar/TimestampedCommentConfig;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateInputBoxStateWithTimestamp extends Action {
            public static final int $stable = 0;
            private final InputBoxState newInputBoxState;
            private final TimestampedCommentConfig timestampConfig;

            public static /* synthetic */ UpdateInputBoxStateWithTimestamp copy$default(UpdateInputBoxStateWithTimestamp updateInputBoxStateWithTimestamp, InputBoxState inputBoxState, TimestampedCommentConfig timestampedCommentConfig, int i, Object obj) {
                if ((i & 1) != 0) {
                    inputBoxState = updateInputBoxStateWithTimestamp.newInputBoxState;
                }
                if ((i & 2) != 0) {
                    timestampedCommentConfig = updateInputBoxStateWithTimestamp.timestampConfig;
                }
                return updateInputBoxStateWithTimestamp.copy(inputBoxState, timestampedCommentConfig);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InputBoxState getNewInputBoxState() {
                return this.newInputBoxState;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final TimestampedCommentConfig getTimestampConfig() {
                return this.timestampConfig;
            }

            public final UpdateInputBoxStateWithTimestamp copy(InputBoxState newInputBoxState, TimestampedCommentConfig timestampConfig) {
                Intrinsics.checkNotNullParameter(newInputBoxState, "newInputBoxState");
                return new UpdateInputBoxStateWithTimestamp(newInputBoxState, timestampConfig);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof UpdateInputBoxStateWithTimestamp)) {
                    return false;
                }
                UpdateInputBoxStateWithTimestamp updateInputBoxStateWithTimestamp = (UpdateInputBoxStateWithTimestamp) other;
                return Intrinsics.areEqual(this.newInputBoxState, updateInputBoxStateWithTimestamp.newInputBoxState) && Intrinsics.areEqual(this.timestampConfig, updateInputBoxStateWithTimestamp.timestampConfig);
            }

            public int hashCode() {
                int iHashCode = this.newInputBoxState.hashCode() * 31;
                TimestampedCommentConfig timestampedCommentConfig = this.timestampConfig;
                return iHashCode + (timestampedCommentConfig == null ? 0 : timestampedCommentConfig.hashCode());
            }

            public String toString() {
                return "UpdateInputBoxStateWithTimestamp(newInputBoxState=" + this.newInputBoxState + ", timestampConfig=" + this.timestampConfig + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateInputBoxStateWithTimestamp(InputBoxState newInputBoxState, TimestampedCommentConfig timestampedCommentConfig) {
                super(null);
                Intrinsics.checkNotNullParameter(newInputBoxState, "newInputBoxState");
                this.newInputBoxState = newInputBoxState;
                this.timestampConfig = timestampedCommentConfig;
            }

            public final InputBoxState getNewInputBoxState() {
                return this.newInputBoxState;
            }

            public final TimestampedCommentConfig getTimestampConfig() {
                return this.timestampConfig;
            }
        }

        /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$TextChanged;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "textFieldValue", "Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "ignoreMention", "Lcom/box/android/base/presentation/components/commentbar/MentionSpanV2;", "<init>", "(Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;Lcom/box/android/base/presentation/components/commentbar/MentionSpanV2;)V", "getTextFieldValue", "()Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "getIgnoreMention", "()Lcom/box/android/base/presentation/components/commentbar/MentionSpanV2;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class TextChanged extends Action {
            public static final int $stable = 8;
            private final MentionSpanV2 ignoreMention;
            private final TextFieldValueUIModel textFieldValue;

            public static /* synthetic */ TextChanged copy$default(TextChanged textChanged, TextFieldValueUIModel textFieldValueUIModel, MentionSpanV2 mentionSpanV2, int i, Object obj) {
                if ((i & 1) != 0) {
                    textFieldValueUIModel = textChanged.textFieldValue;
                }
                if ((i & 2) != 0) {
                    mentionSpanV2 = textChanged.ignoreMention;
                }
                return textChanged.copy(textFieldValueUIModel, mentionSpanV2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final TextFieldValueUIModel getTextFieldValue() {
                return this.textFieldValue;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final MentionSpanV2 getIgnoreMention() {
                return this.ignoreMention;
            }

            public final TextChanged copy(TextFieldValueUIModel textFieldValue, MentionSpanV2 ignoreMention) {
                Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
                return new TextChanged(textFieldValue, ignoreMention);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof TextChanged)) {
                    return false;
                }
                TextChanged textChanged = (TextChanged) other;
                return Intrinsics.areEqual(this.textFieldValue, textChanged.textFieldValue) && Intrinsics.areEqual(this.ignoreMention, textChanged.ignoreMention);
            }

            public int hashCode() {
                int iHashCode = this.textFieldValue.hashCode() * 31;
                MentionSpanV2 mentionSpanV2 = this.ignoreMention;
                return iHashCode + (mentionSpanV2 == null ? 0 : mentionSpanV2.hashCode());
            }

            public String toString() {
                return "TextChanged(textFieldValue=" + this.textFieldValue + ", ignoreMention=" + this.ignoreMention + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public TextChanged(TextFieldValueUIModel textFieldValue, MentionSpanV2 mentionSpanV2) {
                super(null);
                Intrinsics.checkNotNullParameter(textFieldValue, "textFieldValue");
                this.textFieldValue = textFieldValue;
                this.ignoreMention = mentionSpanV2;
            }

            public /* synthetic */ TextChanged(TextFieldValueUIModel textFieldValueUIModel, MentionSpanV2 mentionSpanV2, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(textFieldValueUIModel, (i & 2) != 0 ? null : mentionSpanV2);
            }

            public final MentionSpanV2 getIgnoreMention() {
                return this.ignoreMention;
            }

            public final TextFieldValueUIModel getTextFieldValue() {
                return this.textFieldValue;
            }
        }

        /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$SubmitCommentClicked;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SubmitCommentClicked extends Action {
            public static final int $stable = 0;
            public static final SubmitCommentClicked INSTANCE = new SubmitCommentClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SubmitCommentClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1931589360;
            }

            public String toString() {
                return "SubmitCommentClicked";
            }

            private SubmitCommentClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$ExitModifyClicked;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ExitModifyClicked extends Action {
            public static final int $stable = 0;
            public static final ExitModifyClicked INSTANCE = new ExitModifyClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ExitModifyClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -478603905;
            }

            public String toString() {
                return "ExitModifyClicked";
            }

            private ExitModifyClicked() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$Collaborators;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "Lcom/box/android/cpl/Embedded;", "Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;", Analytics.Data.ACTION, "<init>", "(Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;)V", "getAction", "()Lcom/box/android/base/presentation/components/commentbar/mentions/CollaboratorsMentionsReducer$Action;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "Companion", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Collaborators extends Action implements Embedded<CollaboratorsMentionsReducer.Action> {
            public static final int $stable = 0;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final CollaboratorsMentionsReducer.Action action;

            public static /* synthetic */ Collaborators copy$default(Collaborators collaborators, CollaboratorsMentionsReducer.Action action, int i, Object obj) {
                if ((i & 1) != 0) {
                    action = collaborators.action;
                }
                return collaborators.copy(action);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.box.android.cpl.Embedded
            /* JADX INFO: renamed from: component1, reason: from getter */
            public final CollaboratorsMentionsReducer.Action getFile() {
                return this.action;
            }

            public final Collaborators copy(CollaboratorsMentionsReducer.Action action) {
                Intrinsics.checkNotNullParameter(action, "action");
                return new Collaborators(action);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Collaborators) && Intrinsics.areEqual(this.action, ((Collaborators) other).action);
            }

            public int hashCode() {
                return this.action.hashCode();
            }

            public String toString() {
                return "Collaborators(action=" + this.action + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Collaborators(CollaboratorsMentionsReducer.Action action) {
                super(null);
                Intrinsics.checkNotNullParameter(action, "action");
                this.action = action;
            }

            public final CollaboratorsMentionsReducer.Action getAction() {
                return this.action;
            }

            /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$Collaborators$Companion;", "", "<init>", "()V", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$ShowKeyboard;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ShowKeyboard extends Action {
            public static final int $stable = 0;
            public static final ShowKeyboard INSTANCE = new ShowKeyboard();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ShowKeyboard)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 60922900;
            }

            public String toString() {
                return "ShowKeyboard";
            }

            private ShowKeyboard() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$KeyboardActionHandled;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class KeyboardActionHandled extends Action {
            public static final int $stable = 0;
            public static final KeyboardActionHandled INSTANCE = new KeyboardActionHandled();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof KeyboardActionHandled)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -511226001;
            }

            public String toString() {
                return "KeyboardActionHandled";
            }

            private KeyboardActionHandled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action$ToggleCommentWithTimestamp;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$Action;", "enabled", "", "<init>", "(Z)V", "getEnabled", "()Z", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ToggleCommentWithTimestamp extends Action {
            public static final int $stable = 0;
            private final boolean enabled;

            public static /* synthetic */ ToggleCommentWithTimestamp copy$default(ToggleCommentWithTimestamp toggleCommentWithTimestamp, boolean z, int i, Object obj) {
                if ((i & 1) != 0) {
                    z = toggleCommentWithTimestamp.enabled;
                }
                return toggleCommentWithTimestamp.copy(z);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getEnabled() {
                return this.enabled;
            }

            public final ToggleCommentWithTimestamp copy(boolean enabled) {
                return new ToggleCommentWithTimestamp(enabled);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ToggleCommentWithTimestamp) && this.enabled == ((ToggleCommentWithTimestamp) other).enabled;
            }

            public int hashCode() {
                return Boolean.hashCode(this.enabled);
            }

            public String toString() {
                return "ToggleCommentWithTimestamp(enabled=" + this.enabled + ")";
            }

            public ToggleCommentWithTimestamp(boolean z) {
                super(null);
                this.enabled = z;
            }

            public final boolean getEnabled() {
                return this.enabled;
            }
        }
    }

    /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;", "", "<init>", "()V", "Hidden", "ErrorMessage", "Shown", "InputBoxType", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$ErrorMessage;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$Hidden;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$Shown;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class InputBoxState {
        public static final int $stable = 0;

        /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$InputBoxType;", "", "<init>", "(Ljava/lang/String;I)V", "COMMENT", "REPLY", "MODIFY", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public enum InputBoxType {
            COMMENT,
            REPLY,
            MODIFY;

            private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

            public static EnumEntries<InputBoxType> getEntries() {
                return $ENTRIES;
            }
        }

        public /* synthetic */ InputBoxState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$Hidden;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Hidden extends InputBoxState {
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
                return 1567300560;
            }

            public String toString() {
                return "Hidden";
            }

            private Hidden() {
                super(null);
            }
        }

        private InputBoxState() {
        }

        /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$ErrorMessage;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;", "strRes", "", "<init>", "(I)V", "getStrRes", "()I", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ErrorMessage extends InputBoxState {
            public static final int $stable = 0;
            private final int strRes;

            public static /* synthetic */ ErrorMessage copy$default(ErrorMessage errorMessage, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = errorMessage.strRes;
                }
                return errorMessage.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getStrRes() {
                return this.strRes;
            }

            public final ErrorMessage copy(int strRes) {
                return new ErrorMessage(strRes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof ErrorMessage) && this.strRes == ((ErrorMessage) other).strRes;
            }

            public int hashCode() {
                return Integer.hashCode(this.strRes);
            }

            public String toString() {
                return "ErrorMessage(strRes=" + this.strRes + ")";
            }

            public ErrorMessage(int i) {
                super(null);
                this.strRes = i;
            }

            public final int getStrRes() {
                return this.strRes;
            }
        }

        /* JADX INFO: compiled from: CommentWithMentionsReducer.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$Shown;", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState;", "inputBoxType", "Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$InputBoxType;", "inputBoxValue", "Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "<init>", "(Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$InputBoxType;Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;)V", "getInputBoxType", "()Lcom/box/android/base/presentation/components/commentbar/CommentWithMentionsReducer$InputBoxState$InputBoxType;", "getInputBoxValue", "()Lcom/box/android/base/presentation/components/inputbar/InputBoxValue;", "isEnabled", "", "()Z", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class Shown extends InputBoxState {
            public static final int $stable = 8;
            private final InputBoxType inputBoxType;
            private final InputBoxValue inputBoxValue;
            private final boolean isEnabled;

            public static /* synthetic */ Shown copy$default(Shown shown, InputBoxType inputBoxType, InputBoxValue inputBoxValue, int i, Object obj) {
                if ((i & 1) != 0) {
                    inputBoxType = shown.inputBoxType;
                }
                if ((i & 2) != 0) {
                    inputBoxValue = shown.inputBoxValue;
                }
                return shown.copy(inputBoxType, inputBoxValue);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final InputBoxType getInputBoxType() {
                return this.inputBoxType;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final InputBoxValue getInputBoxValue() {
                return this.inputBoxValue;
            }

            public final Shown copy(InputBoxType inputBoxType, InputBoxValue inputBoxValue) {
                Intrinsics.checkNotNullParameter(inputBoxType, "inputBoxType");
                Intrinsics.checkNotNullParameter(inputBoxValue, "inputBoxValue");
                return new Shown(inputBoxType, inputBoxValue);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Shown)) {
                    return false;
                }
                Shown shown = (Shown) other;
                return this.inputBoxType == shown.inputBoxType && Intrinsics.areEqual(this.inputBoxValue, shown.inputBoxValue);
            }

            public int hashCode() {
                return (this.inputBoxType.hashCode() * 31) + this.inputBoxValue.hashCode();
            }

            public String toString() {
                return "Shown(inputBoxType=" + this.inputBoxType + ", inputBoxValue=" + this.inputBoxValue + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Shown(InputBoxType inputBoxType, InputBoxValue inputBoxValue) {
                super(null);
                Intrinsics.checkNotNullParameter(inputBoxType, "inputBoxType");
                Intrinsics.checkNotNullParameter(inputBoxValue, "inputBoxValue");
                this.inputBoxType = inputBoxType;
                this.inputBoxValue = inputBoxValue;
                this.isEnabled = !StringsKt.isBlank(inputBoxValue.getTextFieldValue().getText());
            }

            /* JADX WARN: Multi-variable type inference failed */
            public /* synthetic */ Shown(InputBoxType inputBoxType, InputBoxValue inputBoxValue, int i, DefaultConstructorMarker defaultConstructorMarker) {
                if ((i & 2) != 0) {
                    inputBoxValue = new InputBoxValue(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                }
                this(inputBoxType, inputBoxValue);
            }

            public final InputBoxType getInputBoxType() {
                return this.inputBoxType;
            }

            public final InputBoxValue getInputBoxValue() {
                return this.inputBoxValue;
            }

            /* JADX INFO: renamed from: isEnabled, reason: from getter */
            public final boolean getIsEnabled() {
                return this.isEnabled;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(CommentWithMentionsReducer commentWithMentionsReducer, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.UpdateInputBoxState) {
            return new ReducerResult(State.copy$default(state, null, ((Action.UpdateInputBoxState) action).getNewInputBoxState(), null, null, null, 29, null), null, 2, null);
        }
        if (action instanceof Action.UpdateInputBoxStateWithTimestamp) {
            Action.UpdateInputBoxStateWithTimestamp updateInputBoxStateWithTimestamp = (Action.UpdateInputBoxStateWithTimestamp) action;
            return new ReducerResult(State.copy$default(state, null, updateInputBoxStateWithTimestamp.getNewInputBoxState(), null, null, updateInputBoxStateWithTimestamp.getTimestampConfig(), 13, null), null, 2, null);
        }
        if (action instanceof Action.TextChanged) {
            return commentWithMentionsReducer.handleCommentBoxTextChanged(state, (Action.TextChanged) action);
        }
        if (action instanceof Action.SubmitCommentClicked) {
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.Collaborators) {
            Action.Collaborators collaborators = (Action.Collaborators) action;
            if (collaborators.getAction() instanceof CollaboratorsMentionsReducer.Action.OnMentionOptionClicked) {
                return commentWithMentionsReducer.handleMentionOptionClick(state, (CollaboratorsMentionsReducer.Action.OnMentionOptionClicked) collaborators.getAction());
            }
            return new ReducerResult(state, null, 2, null);
        }
        if (action instanceof Action.ExitModifyClicked) {
            return new ReducerResult(State.copy$default(state, null, null, null, KeyboardAction.HIDE, null, 23, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.ShowKeyboard.INSTANCE)) {
            return new ReducerResult(State.copy$default(state, null, null, null, KeyboardAction.SHOW, null, 23, null), null, 2, null);
        }
        if (Intrinsics.areEqual(action, Action.KeyboardActionHandled.INSTANCE)) {
            return new ReducerResult(State.copy$default(state, null, null, null, null, null, 23, null), null, 2, null);
        }
        if (action instanceof Action.ToggleCommentWithTimestamp) {
            return commentWithMentionsReducer.handleToggleCommentWithTimestamp(state, (Action.ToggleCommentWithTimestamp) action);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0044  */
    /* JADX WARN: Code duplicated, block: B:15:0x004d A[RETURN] */
    private final IntRange getMentionInProgressRange(TextFieldValueUIModel textFieldValue, List<MentionSpanV2> mentions) {
        String strSubstring = textFieldValue.getText().substring(0, textFieldValue.getSelectionStart());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) strSubstring, CommentBarInputBoxKt.MENTION_SYMBOL, textFieldValue.getSelectionStart(), false, 4, (Object) null);
        if (iLastIndexOf$default < 0) {
            return null;
        }
        for (Object obj : mentions) {
            if (((MentionSpanV2) obj).getStartIndex() == iLastIndexOf$default) {
                if (obj == null) {
                    return RangesKt.until(iLastIndexOf$default, strSubstring.length());
                }
                return null;
            }
        }
        obj = null;
        if (obj == null) {
            return RangesKt.until(iLastIndexOf$default, strSubstring.length());
        }
        return null;
    }

    private final ReducerResult<State, Action> handleMentionOptionClick(State state, CollaboratorsMentionsReducer.Action.OnMentionOptionClicked action) {
        BoxCollaborator user = action.getUser();
        InputBoxState inputBoxState = state.getInputBoxState();
        Intrinsics.checkNotNull(inputBoxState, "null cannot be cast to non-null type com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer.InputBoxState.Shown");
        InputBoxState.Shown shown = (InputBoxState.Shown) inputBoxState;
        InputBoxValue inputBoxValue = shown.getInputBoxValue();
        TextFieldValueUIModel textFieldValue = inputBoxValue.getTextFieldValue();
        IntRange mentionInProgressRange = getMentionInProgressRange(textFieldValue, shown.getInputBoxValue().getMentionSpans());
        if (mentionInProgressRange != null) {
            String mentionRepresentation = CommentBarInputBoxKt.toMentionRepresentation(user);
            String string = StringsKt.replaceRange((CharSequence) textFieldValue.getText(), mentionInProgressRange, (CharSequence) mentionRepresentation).toString();
            MentionSpanV2 mentionSpanV2 = new MentionSpanV2(action.getUser(), mentionInProgressRange.getFirst(), mentionInProgressRange.getFirst() + mentionRepresentation.length());
            return new ReducerResult<>(State.copy$default(state, null, InputBoxState.Shown.copy$default(shown, null, InputBoxValue.copy$default(inputBoxValue, null, CollectionsKt.plus((Collection<? extends MentionSpanV2>) inputBoxValue.getMentionSpans(), mentionSpanV2), 1, null), 1, null), null, null, null, 29, null), Effect.INSTANCE.merge(new Action.TextChanged(new TextFieldValueUIModel(string, mentionSpanV2.getEndIndex(), mentionSpanV2.getEndIndex(), null, 8, null), mentionSpanV2)));
        }
        return new ReducerResult<>(state, null, 2, null);
    }

    private final ReducerResult<State, Action> handleToggleCommentWithTimestamp(State state, Action.ToggleCommentWithTimestamp action) {
        TimestampedCommentConfig timestampedCommentConfig;
        TimestampedCommentConfig timestampedCommentConfigCopy$default;
        TimestampedCommentConfig timestampedCommentConfig2 = state.getTimestampedCommentConfig();
        if (timestampedCommentConfig2 != null) {
            if (action.getEnabled()) {
                timestampedCommentConfigCopy$default = TimestampedCommentConfig.copy$default(timestampedCommentConfig2, true, 0L, null, null, null, false, 62, null);
            } else {
                timestampedCommentConfigCopy$default = TimestampedCommentConfig.copy$default(timestampedCommentConfig2, false, 0L, null, null, null, false, 38, null);
            }
            timestampedCommentConfig = timestampedCommentConfigCopy$default;
        } else {
            timestampedCommentConfig = null;
        }
        return new ReducerResult<>(State.copy$default(state, null, null, null, null, timestampedCommentConfig, 15, null), null, 2, null);
    }

    private final ReducerResult<State, Action> handleCommentBoxTextChanged(State state, Action.TextChanged action) {
        InputBoxValue inputBoxValue;
        Action.Collaborators collaboratorsHideCollaborators;
        InputBoxState inputBoxState = state.getInputBoxState();
        Intrinsics.checkNotNull(inputBoxState, "null cannot be cast to non-null type com.box.android.base.presentation.components.commentbar.CommentWithMentionsReducer.InputBoxState.Shown");
        InputBoxState.Shown shown = (InputBoxState.Shown) inputBoxState;
        TextFieldValueUIModel textFieldValue = action.getTextFieldValue();
        try {
            inputBoxValue = CommentBarInputBoxKt.getUpdatedInputBoxValue(shown.getInputBoxValue(), textFieldValue, action.getIgnoreMention());
        } catch (Exception e) {
            BoxLogUtils.e(String.valueOf(getClass()), "Error while updating comment bar, old = " + shown + ", new = " + textFieldValue, e);
            inputBoxValue = shown.getInputBoxValue();
        }
        State stateCopy$default = State.copy$default(state, null, InputBoxState.Shown.copy$default(shown, null, inputBoxValue, 1, null), null, null, null, 29, null);
        String mentionPrefix = CommentBarInputBoxKt.getMentionPrefix(textFieldValue);
        if (mentionPrefix == null || (collaboratorsHideCollaborators = loadCollaborators(Action.Collaborators.INSTANCE, mentionPrefix)) == null) {
            collaboratorsHideCollaborators = hideCollaborators(Action.Collaborators.INSTANCE);
        }
        return new ReducerResult<>(stateCopy$default, new Effect(collaboratorsHideCollaborators));
    }

    private final Action.Collaborators hideCollaborators(Action.Collaborators.Companion companion) {
        return new Action.Collaborators(CollaboratorsMentionsReducer.Action.HideCollaborators.INSTANCE);
    }

    private final Action.Collaborators loadCollaborators(Action.Collaborators.Companion companion, String str) {
        return new Action.Collaborators(new CollaboratorsMentionsReducer.Action.LoadCollaborators(str));
    }
}
