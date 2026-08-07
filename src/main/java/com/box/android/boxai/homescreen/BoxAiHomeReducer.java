package com.box.android.boxai.homescreen;

import com.box.android.boxai.AiCenterSessionInfoProviderImpl;
import com.box.android.cpl.Effect;
import com.box.android.cpl.Reducable;
import com.box.android.cpl.ReducerResult;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.brownfieldApi.featuresNavigator.HostSurface;
import com.margelo.nitro.boxcontext.providers.StyleVariant;
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

/* JADX INFO: compiled from: BoxAiHomeReducer.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\f\rB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/box/android/boxai/homescreen/BoxAiHomeReducer;", "Lcom/box/android/cpl/Reducable;", "Lcom/box/android/boxai/homescreen/BoxAiHomeReducer$State;", "Lcom/box/android/boxai/homescreen/BoxAiHomeReducer$Action;", "environment", "Lcom/box/android/boxai/homescreen/BoxAiHomeEnvironment;", "<init>", "(Lcom/box/android/boxai/homescreen/BoxAiHomeEnvironment;)V", "reduce", "Lcom/box/android/cpl/ReducerResult;", "state", Analytics.Data.ACTION, "State", "Action", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiHomeReducer implements Reducable<State, Action> {
    public static final int $stable = 8;
    private final BoxAiHomeEnvironment environment;

    public BoxAiHomeReducer(BoxAiHomeEnvironment environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        this.environment = environment;
    }

    @Override // com.box.android.cpl.Reducable
    public /* bridge */ Reducable<State, Action> getBuild() {
        return Reducable.DefaultImpls.getBuild(this);
    }

    /* JADX INFO: compiled from: BoxAiHomeReducer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/box/android/boxai/homescreen/BoxAiHomeReducer$State;", "", "<init>", "()V", "equals", "", "other", "hashCode", "", "toString", "", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
            return 1760214774;
        }

        public String toString() {
            return "State";
        }

        private State() {
        }
    }

    /* JADX INFO: compiled from: BoxAiHomeReducer.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/boxai/homescreen/BoxAiHomeReducer$Action;", "", "<init>", "()V", "ScreenViewed", "SessionChanged", "Lcom/box/android/boxai/homescreen/BoxAiHomeReducer$Action$ScreenViewed;", "Lcom/box/android/boxai/homescreen/BoxAiHomeReducer$Action$SessionChanged;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static abstract class Action {
        public static final int $stable = 0;

        public /* synthetic */ Action(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: BoxAiHomeReducer.kt */
        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/box/android/boxai/homescreen/BoxAiHomeReducer$Action$ScreenViewed;", "Lcom/box/android/boxai/homescreen/BoxAiHomeReducer$Action;", "hostSurface", "Lcom/box/brownfieldApi/featuresNavigator/HostSurface;", "styleVariant", "Lcom/margelo/nitro/boxcontext/providers/StyleVariant;", "sessionId", "", "<init>", "(Lcom/box/brownfieldApi/featuresNavigator/HostSurface;Lcom/margelo/nitro/boxcontext/providers/StyleVariant;Ljava/lang/String;)V", "getHostSurface", "()Lcom/box/brownfieldApi/featuresNavigator/HostSurface;", "getStyleVariant", "()Lcom/margelo/nitro/boxcontext/providers/StyleVariant;", "getSessionId", "()Ljava/lang/String;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class ScreenViewed extends Action {
            public static final int $stable = 0;
            private final HostSurface hostSurface;
            private final String sessionId;
            private final StyleVariant styleVariant;

            public static /* synthetic */ ScreenViewed copy$default(ScreenViewed screenViewed, HostSurface hostSurface, StyleVariant styleVariant, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    hostSurface = screenViewed.hostSurface;
                }
                if ((i & 2) != 0) {
                    styleVariant = screenViewed.styleVariant;
                }
                if ((i & 4) != 0) {
                    str = screenViewed.sessionId;
                }
                return screenViewed.copy(hostSurface, styleVariant, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final HostSurface getHostSurface() {
                return this.hostSurface;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final StyleVariant getStyleVariant() {
                return this.styleVariant;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getSessionId() {
                return this.sessionId;
            }

            public final ScreenViewed copy(HostSurface hostSurface, StyleVariant styleVariant, String sessionId) {
                return new ScreenViewed(hostSurface, styleVariant, sessionId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ScreenViewed)) {
                    return false;
                }
                ScreenViewed screenViewed = (ScreenViewed) other;
                return this.hostSurface == screenViewed.hostSurface && this.styleVariant == screenViewed.styleVariant && Intrinsics.areEqual(this.sessionId, screenViewed.sessionId);
            }

            public int hashCode() {
                HostSurface hostSurface = this.hostSurface;
                int iHashCode = (hostSurface == null ? 0 : hostSurface.hashCode()) * 31;
                StyleVariant styleVariant = this.styleVariant;
                int iHashCode2 = (iHashCode + (styleVariant == null ? 0 : styleVariant.hashCode())) * 31;
                String str = this.sessionId;
                return iHashCode2 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                return "ScreenViewed(hostSurface=" + this.hostSurface + ", styleVariant=" + this.styleVariant + ", sessionId=" + this.sessionId + ")";
            }

            public ScreenViewed(HostSurface hostSurface, StyleVariant styleVariant, String str) {
                super(null);
                this.hostSurface = hostSurface;
                this.styleVariant = styleVariant;
                this.sessionId = str;
            }

            public final HostSurface getHostSurface() {
                return this.hostSurface;
            }

            public final String getSessionId() {
                return this.sessionId;
            }

            public final StyleVariant getStyleVariant() {
                return this.styleVariant;
            }
        }

        private Action() {
        }

        /* JADX INFO: compiled from: BoxAiHomeReducer.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/box/android/boxai/homescreen/BoxAiHomeReducer$Action$SessionChanged;", "Lcom/box/android/boxai/homescreen/BoxAiHomeReducer$Action;", "sessionId", "", "<init>", "(Ljava/lang/String;)V", "getSessionId", "()Ljava/lang/String;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class SessionChanged extends Action {
            public static final int $stable = 0;
            private final String sessionId;

            public static /* synthetic */ SessionChanged copy$default(SessionChanged sessionChanged, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = sessionChanged.sessionId;
                }
                return sessionChanged.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getSessionId() {
                return this.sessionId;
            }

            public final SessionChanged copy(String sessionId) {
                return new SessionChanged(sessionId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof SessionChanged) && Intrinsics.areEqual(this.sessionId, ((SessionChanged) other).sessionId);
            }

            public int hashCode() {
                String str = this.sessionId;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return "SessionChanged(sessionId=" + this.sessionId + ")";
            }

            public SessionChanged(String str) {
                super(null);
                this.sessionId = str;
            }

            public final String getSessionId() {
                return this.sessionId;
            }
        }
    }

    @Override // com.box.android.cpl.Reducable
    public ReducerResult<State, Action> reduce(State state, Action action) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(action, "action");
        if (action instanceof Action.ScreenViewed) {
            return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass1(action, null)));
        }
        if (!(action instanceof Action.SessionChanged)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ReducerResult<>(state, Effect.INSTANCE.fireAndForget(new AnonymousClass2(action, null)));
    }

    /* JADX INFO: renamed from: com.box.android.boxai.homescreen.BoxAiHomeReducer$reduce$1, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiHomeReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.homescreen.BoxAiHomeReducer$reduce$1", f = "BoxAiHomeReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Action action, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BoxAiHomeReducer.this.new AnonymousClass1(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BoxAiHomeReducer.this.environment.getAnalytics().boxAiHomeScreenViewed();
                AiCenterSessionInfoProviderImpl boxAiCenterSessionInfoProviderImpl = BoxAiHomeReducer.this.environment.getBoxAiCenterSessionInfoProviderImpl();
                Action.ScreenViewed screenViewed = (Action.ScreenViewed) this.$action;
                boxAiCenterSessionInfoProviderImpl.setLastActiveSessionId(screenViewed.getSessionId());
                boxAiCenterSessionInfoProviderImpl.setLastActiveHostSurface(screenViewed.getHostSurface());
                boxAiCenterSessionInfoProviderImpl.setLastActiveStyleVariant(screenViewed.getStyleVariant());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.box.android.boxai.homescreen.BoxAiHomeReducer$reduce$2, reason: invalid class name */
    /* JADX INFO: compiled from: BoxAiHomeReducer.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.boxai.homescreen.BoxAiHomeReducer$reduce$2", f = "BoxAiHomeReducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ Action $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Action action, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.$action = action;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return BoxAiHomeReducer.this.new AnonymousClass2(this.$action, continuation);
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
            BoxAiHomeReducer.this.environment.getBoxAiCenterSessionInfoProviderImpl().setLastActiveSessionId(((Action.SessionChanged) this.$action).getSessionId());
            return Unit.INSTANCE;
        }
    }
}
