package com.box.android.notes.navigationmodernization.tabsscreen;

import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesTabsReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$State;", "Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action;", "environment", "Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsEnvironment;", "<init>", "(Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsEnvironment;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Action", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NotesTabsReducer implements Reducable<State, Action> {
    public static final int $stable = 0;
    private final NotesTabsEnvironment environment;

    public NotesTabsReducer(NotesTabsEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: NotesTabsReducer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$State;", "", "<init>", "()V", "equals", "", "other", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class State {
        public static final int $stable = 0;
        public static final State INSTANCE = new State();

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return -1998220549;
        }

        public String toString() {
            return "State";
        }

        private State() {
        }
    }

    /* JADX INFO: compiled from: NotesTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action;", "", "<init>", "()V", "ScreenViewed", "RecentsTabScreenViewed", "FavoritesTabScreenViewed", "SettingsClicked", "Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action$FavoritesTabScreenViewed;", "Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action$RecentsTabScreenViewed;", "Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action$ScreenViewed;", "Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action$SettingsClicked;", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: NotesTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action$ScreenViewed;", "Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ScreenViewed extends Action {
            public static final int $stable = 0;
            public static final ScreenViewed INSTANCE = new ScreenViewed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ScreenViewed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -1372621998;
            }

            public String toString() {
                return "ScreenViewed";
            }

            private ScreenViewed() {
                super(null);
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: NotesTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action$RecentsTabScreenViewed;", "Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class RecentsTabScreenViewed extends Action {
            public static final int $stable = 0;
            public static final RecentsTabScreenViewed INSTANCE = new RecentsTabScreenViewed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof RecentsTabScreenViewed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return -932734865;
            }

            public String toString() {
                return "RecentsTabScreenViewed";
            }

            private RecentsTabScreenViewed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: NotesTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action$FavoritesTabScreenViewed;", "Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class FavoritesTabScreenViewed extends Action {
            public static final int $stable = 0;
            public static final FavoritesTabScreenViewed INSTANCE = new FavoritesTabScreenViewed();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof FavoritesTabScreenViewed)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 825798960;
            }

            public String toString() {
                return "FavoritesTabScreenViewed";
            }

            private FavoritesTabScreenViewed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: NotesTabsReducer.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action$SettingsClicked;", "Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsReducer$Action;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "notes_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SettingsClicked extends Action {
            public static final int $stable = 0;
            public static final SettingsClicked INSTANCE = new SettingsClicked();

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SettingsClicked)) {
                    return false;
                }
                return true;
            }

            public int hashCode() {
                return 1506904450;
            }

            public String toString() {
                return "SettingsClicked";
            }

            private SettingsClicked() {
                super(null);
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (Intrinsics.areEqual(action, Action.ScreenViewed.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(null)));
        }
        if (Intrinsics.areEqual(action, Action.RecentsTabScreenViewed.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass2(null)));
        }
        if (Intrinsics.areEqual(action, Action.FavoritesTabScreenViewed.INSTANCE)) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass3(null)));
        }
        if (!Intrinsics.areEqual(action, Action.SettingsClicked.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass4(null)));
    }

    /* JADX INFO: renamed from: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsReducer$reduce$1, reason: invalid class name */
    /* JADX INFO: compiled from: NotesTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsReducer$reduce$1", f = "NotesTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return NotesTabsReducer.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NotesTabsReducer.this.environment.getAnalytics().notesScreenViewed();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: NotesTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsReducer$reduce$2", f = "NotesTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return NotesTabsReducer.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NotesTabsReducer.this.environment.getAnalytics().recentsTabScreenViewed();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsReducer$reduce$3, reason: invalid class name */
    /* JADX INFO: compiled from: NotesTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsReducer$reduce$3", f = "NotesTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return NotesTabsReducer.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NotesTabsReducer.this.environment.getAnalytics().favoritesTabScreenViewed();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsReducer$reduce$4, reason: invalid class name */
    /* JADX INFO: compiled from: NotesTabsReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsReducer$reduce$4", f = "NotesTabsReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass4(Continuation<? super AnonymousClass4> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return NotesTabsReducer.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            NotesTabsReducer.this.environment.getAnalytics().settingsClicked();
            return Unit.INSTANCE;
        }
    }
}
