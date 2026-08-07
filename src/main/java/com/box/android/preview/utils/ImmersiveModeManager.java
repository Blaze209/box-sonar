package com.box.android.preview.utils;

import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: compiled from: ImmersiveModeManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¨\u0006\u000b"}, d2 = {"Lcom/box/android/preview/utils/ImmersiveModeManager;", "", "<init>", "()V", "configureSystemBarVisibility", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "isImmersiveModeFlow", "Lkotlinx/coroutines/flow/Flow;", "", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ImmersiveModeManager {
    public static final int $stable = 0;
    public static final ImmersiveModeManager INSTANCE = new ImmersiveModeManager();

    private ImmersiveModeManager() {
    }

    public final void configureSystemBarVisibility(FragmentActivity activity, Flow<Boolean> isImmersiveModeFlow) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(isImmersiveModeFlow, "isImmersiveModeFlow");
        WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(activity.getWindow(), activity.getWindow().getDecorView());
        Intrinsics.checkNotNullExpressionValue(insetsController, "getInsetsController(...)");
        insetsController.setSystemBarsBehavior(2);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(activity), null, null, new AnonymousClass1(activity, isImmersiveModeFlow, insetsController, null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.preview.utils.ImmersiveModeManager$configureSystemBarVisibility$1, reason: invalid class name */
    /* JADX INFO: compiled from: ImmersiveModeManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.preview.utils.ImmersiveModeManager$configureSystemBarVisibility$1", f = "ImmersiveModeManager.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $activity;
        final /* synthetic */ Flow<Boolean> $isImmersiveModeFlow;
        final /* synthetic */ WindowInsetsControllerCompat $windowInsetsController;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FragmentActivity fragmentActivity, Flow<Boolean> flow, WindowInsetsControllerCompat windowInsetsControllerCompat, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = fragmentActivity;
            this.$isImmersiveModeFlow = flow;
            this.$windowInsetsController = windowInsetsControllerCompat;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$activity, this.$isImmersiveModeFlow, this.$windowInsetsController, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.box.android.preview.utils.ImmersiveModeManager$configureSystemBarVisibility$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ImmersiveModeManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.box.android.preview.utils.ImmersiveModeManager$configureSystemBarVisibility$1$1", f = "ImmersiveModeManager.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {}, v = 1)
        static final class C01821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Flow<Boolean> $isImmersiveModeFlow;
            final /* synthetic */ WindowInsetsControllerCompat $windowInsetsController;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01821(Flow<Boolean> flow, WindowInsetsControllerCompat windowInsetsControllerCompat, Continuation<? super C01821> continuation) {
                super(2, continuation);
                this.$isImmersiveModeFlow = flow;
                this.$windowInsetsController = windowInsetsControllerCompat;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01821(this.$isImmersiveModeFlow, this.$windowInsetsController, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Flow<Boolean> flow = this.$isImmersiveModeFlow;
                    final WindowInsetsControllerCompat windowInsetsControllerCompat = this.$windowInsetsController;
                    this.label = 1;
                    if (flow.collect(new FlowCollector() { // from class: com.box.android.preview.utils.ImmersiveModeManager.configureSystemBarVisibility.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit(((Boolean) obj2).booleanValue(), (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(boolean z, Continuation<? super Unit> continuation) {
                            if (z) {
                                windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.systemBars());
                            } else {
                                windowInsetsControllerCompat.show(WindowInsetsCompat.Type.systemBars());
                            }
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(this.$activity, Lifecycle.State.STARTED, new C01821(this.$isImmersiveModeFlow, this.$windowInsetsController, null), this) == coroutine_suspended) {
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
}
