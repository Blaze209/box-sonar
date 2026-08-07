package com.box.android.base.compose;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: NavControllerExtensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a*\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u001a>\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020\n*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0086@¢\u0006\u0002\u0010\r\u001a\u0012\u0010\u000e\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\n\"\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"popBackStackSafely", "", "Landroidx/navigation/NavController;", "isCurrentEntryResumed", "navigateWithArgs", "", "route", "", "navArgs", "", "", "navigateForResult", "R", "(Landroidx/navigation/NavController;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "popWithResult", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "RESULT_KEY", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NavControllerExtensionsKt {
    private static final String RESULT_KEY = "result_key";

    /* JADX INFO: renamed from: com.box.android.base.compose.NavControllerExtensionsKt$navigateForResult$1, reason: invalid class name */
    /* JADX INFO: compiled from: NavControllerExtensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.compose.NavControllerExtensionsKt", f = "NavControllerExtensions.kt", i = {0, 0, 0, 0}, l = {48}, m = "navigateForResult", n = {"$this$navigateForResult", "route", "navArgs", "entry"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class AnonymousClass1<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NavControllerExtensionsKt.navigateForResult(null, null, null, this);
        }
    }

    public static final boolean popBackStackSafely(NavController navController) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        if (isCurrentEntryResumed(navController)) {
            return navController.popBackStack();
        }
        return false;
    }

    private static final boolean isCurrentEntryResumed(NavController navController) {
        Lifecycle lifecycleRegistry;
        Lifecycle.State state;
        NavBackStackEntry currentBackStackEntry = navController.getCurrentBackStackEntry();
        if (currentBackStackEntry == null || (lifecycleRegistry = currentBackStackEntry.getLifecycle()) == null || (state = lifecycleRegistry.getState()) == null) {
            return true;
        }
        return state.isAtLeast(Lifecycle.State.RESUMED);
    }

    public static /* synthetic */ void navigateWithArgs$default(NavController navController, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        navigateWithArgs(navController, str, map);
    }

    public static final void navigateWithArgs(NavController navController, String route, Map<String, ? extends Object> navArgs) {
        Intrinsics.checkNotNullParameter(navController, "<this>");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(navArgs, "navArgs");
        NavController.navigate$default(navController, route, (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        NavBackStackEntry backStackEntry = navController.getBackStackEntry(route);
        for (Map.Entry<String, ? extends Object> entry : navArgs.entrySet()) {
            backStackEntry.getSavedStateHandle().set(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <R> Object navigateForResult(NavController navController, String str, Map<String, ? extends Object> map, Continuation<? super R> continuation) {
        AnonymousClass1 anonymousClass1;
        SavedStateHandle savedStateHandle;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            navigateWithArgs(navController, str, map);
            NavBackStackEntry backStackEntry = navController.getBackStackEntry(str);
            Flow<Lifecycle.Event> eventFlow = LifecycleKt.getEventFlow(backStackEntry.getLifecycle());
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(null);
            anonymousClass1.L$0 = navController;
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(map);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(backStackEntry);
            anonymousClass1.label = 1;
            if (FlowKt.first(eventFlow, anonymousClass2, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            navController = (NavController) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        NavBackStackEntry currentBackStackEntry = navController.getCurrentBackStackEntry();
        if (currentBackStackEntry == null || (savedStateHandle = currentBackStackEntry.getSavedStateHandle()) == null) {
            return null;
        }
        return savedStateHandle.remove(RESULT_KEY);
    }

    public static /* synthetic */ Object navigateForResult$default(NavController navController, String str, Map map, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return navigateForResult(navController, str, map, continuation);
    }

    /* JADX INFO: renamed from: com.box.android.base.compose.NavControllerExtensionsKt$navigateForResult$2, reason: invalid class name */
    /* JADX INFO: compiled from: NavControllerExtensions.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Landroidx/lifecycle/Lifecycle$Event;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.base.compose.NavControllerExtensionsKt$navigateForResult$2", f = "NavControllerExtensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Lifecycle.Event, Continuation<? super Boolean>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Lifecycle.Event event, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(event, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Lifecycle.Event event = (Lifecycle.Event) this.L$0;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(event == Lifecycle.Event.ON_DESTROY);
        }
    }

    public static final void popWithResult(NavController navController, Object result) {
        SavedStateHandle savedStateHandle;
        Intrinsics.checkNotNullParameter(navController, "<this>");
        Intrinsics.checkNotNullParameter(result, "result");
        NavBackStackEntry previousBackStackEntry = navController.getPreviousBackStackEntry();
        if (previousBackStackEntry != null && (savedStateHandle = previousBackStackEntry.getSavedStateHandle()) != null) {
            savedStateHandle.set(RESULT_KEY, result);
        }
        popBackStackSafely(navController);
    }
}
