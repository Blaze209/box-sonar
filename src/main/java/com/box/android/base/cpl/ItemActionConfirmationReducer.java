package com.box.android.base.cpl;

import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.Reduce;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemActionConfirmationReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0010\u0011B+\u0012\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0005¢\u0006\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/box/android/base/cpl/ItemActionConfirmationReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer$State;", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action;", "actionToPerformOnConfirmation", "Lkotlin/Function2;", "Lcom/box/android/domain/models/ItemId;", "Lkotlin/coroutines/Continuation;", "", "", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "build", "Lcom/box/android/cpl/Reduce;", "getBuild", "()Lcom/box/android/cpl/Reduce;", "Action", "State", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ItemActionConfirmationReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final Reduce<State, Action> build;

    public ItemActionConfirmationReducer(final Function2<? super ItemId, ? super Continuation<? super Unit>, ? extends Object> actionToPerformOnConfirmation) {
        Intrinsics.checkNotNullParameter(actionToPerformOnConfirmation, "actionToPerformOnConfirmation");
        this.build = new Reduce<>(new Function2() { // from class: com.box.android.base.cpl.ItemActionConfirmationReducer$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ItemActionConfirmationReducer.build$lambda$0(actionToPerformOnConfirmation, (ItemActionConfirmationReducer.State) obj, (ItemActionConfirmationReducer.Action) obj2);
            }
        });
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ ReducerResult<State, Action> reduce(State state, Action action) {
        return Reducable.DefaultImpls.reduce(this, state, action);
    }

    /* JADX INFO: compiled from: ItemActionConfirmationReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action;", "", "<init>", "()V", "ConfirmAction", "DismissAction", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action$ConfirmAction;", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action$DismissAction;", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ItemActionConfirmationReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action$ConfirmAction;", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action;", "<init>", "()V", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class ConfirmAction extends Action {
            public static final int $stable = 0;
            public static final ConfirmAction INSTANCE = new ConfirmAction();

            private ConfirmAction() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: ItemActionConfirmationReducer.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action$DismissAction;", "Lcom/box/android/base/cpl/ItemActionConfirmationReducer$Action;", "<init>", "()V", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class DismissAction extends Action {
            public static final int $stable = 0;
            public static final DismissAction INSTANCE = new DismissAction();

            private DismissAction() {
                super(null);
            }
        }
    }

    /* JADX INFO: compiled from: ItemActionConfirmationReducer.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/base/cpl/ItemActionConfirmationReducer$State;", "", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "<init>", "(Lcom/box/android/domain/models/item/ItemModel;)V", "getItemModel", "()Lcom/box/android/domain/models/item/ItemModel;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 8;
        private final ItemModel itemModel;

        public static /* synthetic */ State copy$default(State state, ItemModel itemModel, int i, Object obj) {
            if ((i & 1) != 0) {
                itemModel = state.itemModel;
            }
            return state.copy(itemModel);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ItemModel getItemModel() {
            return this.itemModel;
        }

        public final State copy(ItemModel itemModel) {
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            return new State(itemModel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof State) && Intrinsics.areEqual(this.itemModel, ((State) other).itemModel);
        }

        public int hashCode() {
            return this.itemModel.hashCode();
        }

        public String toString() {
            return "State(itemModel=" + this.itemModel + ")";
        }

        public State(ItemModel itemModel) {
            Intrinsics.checkNotNullParameter(itemModel, "itemModel");
            this.itemModel = itemModel;
        }

        public final ItemModel getItemModel() {
            return this.itemModel;
        }
    }

    @Override // com.box.android.cpl.Reducable
    public Reducable<State, Action> getBuild() {
        return this.build;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ReducerResult build$lambda$0(Function2 function2, State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, Action.ConfirmAction.INSTANCE)) {
            return new ReducerResult(state, Effect.INSTANCE.fireAndForget(new ItemActionConfirmationReducer$build$1$1(function2, state, null)));
        }
        if (Intrinsics.areEqual(action, Action.DismissAction.INSTANCE)) {
            return new ReducerResult(state, null, 2, null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
