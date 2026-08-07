package com.box.android.base.presentation.components.inputbar;

import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicInputBarReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$State;", "Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action;", "<init>", "()V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "State", "Action", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BasicInputBarReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build = new Reduce<>(new Function2() { // from class: com.box.android.base.presentation.components.inputbar.BasicInputBarReducer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return BasicInputBarReducer.build$lambda$0((BasicInputBarReducer.State) obj, (BasicInputBarReducer.Action) obj2);
        }
    });

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: BasicInputBarReducer.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$State;", "", "textField", "Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "keyboardAction", "Lcom/box/android/base/presentation/components/inputbar/KeyboardAction;", "<init>", "(Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;Lcom/box/android/base/presentation/components/inputbar/KeyboardAction;)V", "getTextField", "()Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "getKeyboardAction", "()Lcom/box/android/base/presentation/components/inputbar/KeyboardAction;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        private final KeyboardAction keyboardAction;
        private final TextFieldValueUIModel textField;

        /* JADX WARN: Multi-variable type inference failed */
        public State() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ State copy$default(State state, TextFieldValueUIModel textFieldValueUIModel, KeyboardAction keyboardAction, int i, Object obj) {
            if ((i & 1) != 0) {
                textFieldValueUIModel = state.textField;
            }
            if ((i & 2) != 0) {
                keyboardAction = state.keyboardAction;
            }
            return state.copy(textFieldValueUIModel, keyboardAction);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final TextFieldValueUIModel getTextField() {
            return this.textField;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final KeyboardAction getKeyboardAction() {
            return this.keyboardAction;
        }

        public final State copy(TextFieldValueUIModel textField, KeyboardAction keyboardAction) {
            Intrinsics.checkNotNullParameter(textField, "textField");
            return new State(textField, keyboardAction);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics.areEqual(this.textField, state.textField) && this.keyboardAction == state.keyboardAction;
        }

        public int hashCode() {
            int iHashCode = this.textField.hashCode() * 31;
            KeyboardAction keyboardAction = this.keyboardAction;
            return iHashCode + (keyboardAction == null ? 0 : keyboardAction.hashCode());
        }

        public String toString() {
            return "State(textField=" + this.textField + ", keyboardAction=" + this.keyboardAction + ")";
        }

        public State(TextFieldValueUIModel textField, KeyboardAction keyboardAction) {
            Intrinsics.checkNotNullParameter(textField, "textField");
            this.textField = textField;
            this.keyboardAction = keyboardAction;
        }

        public /* synthetic */ State(TextFieldValueUIModel textFieldValueUIModel, KeyboardAction keyboardAction, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new TextFieldValueUIModel("", 0, 0, null, 14, null) : textFieldValueUIModel, (i & 2) != 0 ? null : keyboardAction);
        }

        public final KeyboardAction getKeyboardAction() {
            return this.keyboardAction;
        }

        public final TextFieldValueUIModel getTextField() {
            return this.textField;
        }
    }

    /* JADX INFO: compiled from: BasicInputBarReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action;", "", "<init>", "()V", "UpdateText", "ShowKeyboard", "KeyboardActionHandled", "SubmitClicked", "Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action$KeyboardActionHandled;", "Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action$ShowKeyboard;", "Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action$SubmitClicked;", "Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action$UpdateText;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BasicInputBarReducer.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action$UpdateText;", "Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action;", "textField", "Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "<init>", "(Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;)V", "getTextField", "()Lcom/box/android/base/presentation/components/inputbar/TextFieldValueUIModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class UpdateText extends Action {
            public static final int $stable = 0;
            private final TextFieldValueUIModel textField;

            public static /* synthetic */ UpdateText copy$default(UpdateText updateText, TextFieldValueUIModel textFieldValueUIModel, int i, Object obj) {
                if ((i & 1) != 0) {
                    textFieldValueUIModel = updateText.textField;
                }
                return updateText.copy(textFieldValueUIModel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final TextFieldValueUIModel getTextField() {
                return this.textField;
            }

            public final UpdateText copy(TextFieldValueUIModel textField) {
                Intrinsics.checkNotNullParameter(textField, "textField");
                return new UpdateText(textField);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof UpdateText) && Intrinsics.areEqual(this.textField, ((UpdateText) other).textField);
            }

            public int hashCode() {
                return this.textField.hashCode();
            }

            public String toString() {
                return "UpdateText(textField=" + this.textField + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateText(TextFieldValueUIModel textField) {
                super(null);
                Intrinsics.checkNotNullParameter(textField, "textField");
                this.textField = textField;
            }

            public final TextFieldValueUIModel getTextField() {
                return this.textField;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: BasicInputBarReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action$ShowKeyboard;", "Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -1431157418;
            }

            public String toString() {
                return "ShowKeyboard";
            }

            private ShowKeyboard() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BasicInputBarReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action$KeyboardActionHandled;", "Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
                return -1558974355;
            }

            public String toString() {
                return "KeyboardActionHandled";
            }

            private KeyboardActionHandled() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: BasicInputBarReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action$SubmitClicked;", "Lcom/box/android/base/presentation/components/inputbar/BasicInputBarReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SubmitClicked extends Action {
            public static final int $stable = 0;
            public static final SubmitClicked INSTANCE = new SubmitClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SubmitClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1401104349;
            }

            public String toString() {
                return "SubmitClicked";
            }

            private SubmitClicked() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.UpdateText) {
            return new ReducerResult(State.copy$default(state, ((Action.UpdateText) action).getTextField(), null, 2, null), null, 2, null);
        }
        if (action instanceof Action.ShowKeyboard) {
            return new ReducerResult(State.copy$default(state, null, KeyboardAction.SHOW, 1, null), null, 2, null);
        }
        if (action instanceof Action.KeyboardActionHandled) {
            return new ReducerResult(State.copy$default(state, null, null, 1, null), null, 2, null);
        }
        if (action instanceof Action.SubmitClicked) {
            return new ReducerResult(state, null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
