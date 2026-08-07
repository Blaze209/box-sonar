package androidx.navigation.testing;

import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.FloatingWindow;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavDestination;
import androidx.navigation.NavigatorState;
import androidx.navigation.SupportingPane;
import androidx.navigation.internal.NavContext;
import androidx.savedstate.SavedStateWriter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: TestNavigatorState.android.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0000*\u0001\r\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013H\u0016J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0016J\u0018\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u0010\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0015H\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0015H\u0016J\"\u0010'\u001a\u00020\u001e2\u000e\b\u0002\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00150)2\b\b\u0002\u0010\"\u001a\u00020\u0016H\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u00060\u0012j\u0002`\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Landroidx/navigation/testing/TestNavigatorState;", "Landroidx/navigation/NavigatorState;", "context", "Landroid/content/Context;", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Landroid/content/Context;Lkotlinx/coroutines/CoroutineDispatcher;)V", "navContext", "Landroidx/navigation/internal/NavContext;", "getNavContext$navigation_testing", "()Landroidx/navigation/internal/NavContext;", "viewModelStoreProvider", "androidx/navigation/testing/TestNavigatorState$viewModelStoreProvider$1", "Landroidx/navigation/testing/TestNavigatorState$viewModelStoreProvider$1;", "savedStates", "", "", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "entrySavedState", "Landroidx/navigation/NavBackStackEntry;", "", "createBackStackEntry", FirebaseAnalytics.Param.DESTINATION, "Landroidx/navigation/NavDestination;", "arguments", "restoreBackStackEntry", "previouslySavedEntry", "push", "", "backStackEntry", TokenRequest.TokenType.POP, "popUpTo", "saveState", "popWithTransition", "markTransitionComplete", "entry", "prepareForTransition", "updateMaxLifecycle", "poppedList", "", "navigation-testing"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TestNavigatorState extends NavigatorState {
    private final Context context;
    private final CoroutineDispatcher coroutineDispatcher;
    private final Map<NavBackStackEntry, Boolean> entrySavedState;
    private final NavContext navContext;
    private final Map<String, Bundle> savedStates;
    private final TestNavigatorState$viewModelStoreProvider$1 viewModelStoreProvider;

    /* JADX WARN: Multi-variable type inference failed */
    public TestNavigatorState() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TestNavigatorState(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ TestNavigatorState(Context context, MainCoroutineDispatcher mainCoroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : context, (i & 2) != 0 ? Dispatchers.getMain().getImmediate() : mainCoroutineDispatcher);
    }

    public TestNavigatorState(Context context, CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "coroutineDispatcher");
        this.context = context;
        this.coroutineDispatcher = coroutineDispatcher;
        this.navContext = new NavContext(context);
        this.viewModelStoreProvider = new TestNavigatorState$viewModelStoreProvider$1();
        this.savedStates = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
    }

    /* JADX INFO: renamed from: getNavContext$navigation_testing, reason: from getter */
    public final NavContext getNavContext() {
        return this.navContext;
    }

    @Override // androidx.navigation.NavigatorState
    public NavBackStackEntry createBackStackEntry(NavDestination destination, Bundle arguments) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return NavBackStackEntry.Companion.create$default(NavBackStackEntry.INSTANCE, this.navContext, destination, arguments, Lifecycle.State.RESUMED, this.viewModelStoreProvider, null, null, 96, null);
    }

    public final NavBackStackEntry restoreBackStackEntry(NavBackStackEntry previouslySavedEntry) {
        Intrinsics.checkNotNullParameter(previouslySavedEntry, "previouslySavedEntry");
        Bundle bundle = this.savedStates.get(previouslySavedEntry.getId());
        if (bundle == null) {
            throw new IllegalStateException("restoreBackStackEntry(previouslySavedEntry) must be passed a NavBackStackEntry that was previously popped with popBackStack(previouslySavedEntry, true)".toString());
        }
        return NavBackStackEntry.INSTANCE.create(this.navContext, previouslySavedEntry.getDestination(), previouslySavedEntry.getArguments(), Lifecycle.State.RESUMED, this.viewModelStoreProvider, previouslySavedEntry.getId(), bundle);
    }

    @Override // androidx.navigation.NavigatorState
    public void push(NavBackStackEntry backStackEntry) throws InterruptedException {
        Intrinsics.checkNotNullParameter(backStackEntry, "backStackEntry");
        super.push(backStackEntry);
        updateMaxLifecycle$default(this, null, false, 3, null);
    }

    @Override // androidx.navigation.NavigatorState
    public void pop(NavBackStackEntry popUpTo, boolean saveState) throws InterruptedException {
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        List<NavBackStackEntry> value = getBackStack().getValue();
        List<NavBackStackEntry> listSubList = value.subList(value.indexOf(popUpTo), value.size());
        super.pop(popUpTo, saveState);
        updateMaxLifecycle(listSubList, saveState);
    }

    @Override // androidx.navigation.NavigatorState
    public void popWithTransition(NavBackStackEntry popUpTo, boolean saveState) {
        Intrinsics.checkNotNullParameter(popUpTo, "popUpTo");
        super.popWithTransition(popUpTo, saveState);
        this.entrySavedState.put(popUpTo, Boolean.valueOf(saveState));
    }

    @Override // androidx.navigation.NavigatorState
    public void markTransitionComplete(NavBackStackEntry entry) throws InterruptedException {
        Intrinsics.checkNotNullParameter(entry, "entry");
        boolean zAreEqual = Intrinsics.areEqual((Object) this.entrySavedState.get(entry), (Object) true);
        super.markTransitionComplete(entry);
        this.entrySavedState.remove(entry);
        if (!getBackStack().getValue().contains(entry)) {
            updateMaxLifecycle(CollectionsKt.listOf(entry), zAreEqual);
        } else {
            updateMaxLifecycle$default(this, null, false, 3, null);
        }
    }

    /* JADX INFO: renamed from: androidx.navigation.testing.TestNavigatorState$prepareForTransition$1, reason: invalid class name */
    /* JADX INFO: compiled from: TestNavigatorState.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.navigation.testing.TestNavigatorState$prepareForTransition$1", f = "TestNavigatorState.android.kt", i = {}, l = {Token.LOOP}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NavBackStackEntry $entry;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NavBackStackEntry navBackStackEntry, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$entry = navBackStackEntry;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$entry, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new C00901(this.$entry, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.navigation.testing.TestNavigatorState$prepareForTransition$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TestNavigatorState.android.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.navigation.testing.TestNavigatorState$prepareForTransition$1$1", f = "TestNavigatorState.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ NavBackStackEntry $entry;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00901(NavBackStackEntry navBackStackEntry, Continuation<? super C00901> continuation) {
                super(2, continuation);
                this.$entry = navBackStackEntry;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00901(this.$entry, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$entry.setMaxLifecycle(Lifecycle.State.STARTED);
                return Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.navigation.NavigatorState
    public void prepareForTransition(NavBackStackEntry entry) throws InterruptedException {
        Intrinsics.checkNotNullParameter(entry, "entry");
        super.prepareForTransition(entry);
        BuildersKt.runBlocking(this.coroutineDispatcher, new AnonymousClass1(entry, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void updateMaxLifecycle$default(TestNavigatorState testNavigatorState, List list, boolean z, int i, Object obj) throws InterruptedException {
        if ((i & 1) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 2) != 0) {
            z = false;
        }
        testNavigatorState.updateMaxLifecycle(list, z);
    }

    /* JADX INFO: renamed from: androidx.navigation.testing.TestNavigatorState$updateMaxLifecycle$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TestNavigatorState.android.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.navigation.testing.TestNavigatorState$updateMaxLifecycle$1", f = "TestNavigatorState.android.kt", i = {}, l = {Token.COLONCOLON}, m = "invokeSuspend", n = {}, s = {})
    static final class C08341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<NavBackStackEntry> $poppedList;
        final /* synthetic */ boolean $saveState;
        int label;
        final /* synthetic */ TestNavigatorState this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08341(List<NavBackStackEntry> list, boolean z, TestNavigatorState testNavigatorState, Continuation<? super C08341> continuation) {
            super(2, continuation);
            this.$poppedList = list;
            this.$saveState = z;
            this.this$0 = testNavigatorState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08341(this.$poppedList, this.$saveState, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new C00911(this.$poppedList, this.$saveState, this.this$0, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: androidx.navigation.testing.TestNavigatorState$updateMaxLifecycle$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TestNavigatorState.android.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "androidx.navigation.testing.TestNavigatorState$updateMaxLifecycle$1$1", f = "TestNavigatorState.android.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C00911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<NavBackStackEntry> $poppedList;
            final /* synthetic */ boolean $saveState;
            int label;
            final /* synthetic */ TestNavigatorState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00911(List<NavBackStackEntry> list, boolean z, TestNavigatorState testNavigatorState, Continuation<? super C00911> continuation) {
                super(2, continuation);
                this.$poppedList = list;
                this.$saveState = z;
                this.this$0 = testNavigatorState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00911(this.$poppedList, this.$saveState, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C00911) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Lifecycle.State state;
                Lifecycle.State state2;
                Pair[] pairArr;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                for (NavBackStackEntry navBackStackEntry : CollectionsKt.reversed(this.$poppedList)) {
                    if (this.$saveState && navBackStackEntry.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
                        navBackStackEntry.setMaxLifecycle(Lifecycle.State.CREATED);
                        Map mapEmptyMap = MapsKt.emptyMap();
                        if (mapEmptyMap.isEmpty()) {
                            pairArr = new Pair[0];
                        } else {
                            ArrayList arrayList = new ArrayList(mapEmptyMap.size());
                            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                                arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
                            }
                            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
                        }
                        Bundle bundleBundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
                        SavedStateWriter.m11040constructorimpl(bundleBundleOf);
                        navBackStackEntry.saveState(bundleBundleOf);
                        this.this$0.savedStates.put(navBackStackEntry.getId(), bundleBundleOf);
                    }
                    if (!this.this$0.getTransitionsInProgress().getValue().contains(navBackStackEntry)) {
                        navBackStackEntry.setMaxLifecycle(Lifecycle.State.DESTROYED);
                        if (!this.$saveState) {
                            this.this$0.savedStates.remove(navBackStackEntry.getId());
                            this.this$0.viewModelStoreProvider.getViewModelStore(navBackStackEntry.getId()).clear();
                        }
                    } else {
                        navBackStackEntry.setMaxLifecycle(Lifecycle.State.CREATED);
                    }
                }
                NavBackStackEntry navBackStackEntry2 = null;
                for (NavBackStackEntry navBackStackEntry3 : CollectionsKt.reversed(this.this$0.getBackStack().getValue())) {
                    boolean zContains = this.this$0.getTransitionsInProgress().getValue().contains(navBackStackEntry3);
                    if (navBackStackEntry2 == null) {
                        if (!zContains) {
                            state = Lifecycle.State.RESUMED;
                        } else {
                            state = Lifecycle.State.STARTED;
                        }
                    } else if (navBackStackEntry2.getDestination() instanceof SupportingPane) {
                        Lifecycle.State maxLifecycle = navBackStackEntry2.getMaxLifecycle();
                        if (!zContains) {
                            state2 = Lifecycle.State.RESUMED;
                        } else {
                            state2 = Lifecycle.State.STARTED;
                        }
                        state = (Lifecycle.State) RangesKt.coerceAtMost(maxLifecycle, state2);
                    } else {
                        state = navBackStackEntry2.getDestination() instanceof FloatingWindow ? Lifecycle.State.STARTED : Lifecycle.State.CREATED;
                    }
                    navBackStackEntry3.setMaxLifecycle(state);
                    navBackStackEntry2 = navBackStackEntry3;
                }
                return Unit.INSTANCE;
            }
        }
    }

    private final void updateMaxLifecycle(List<NavBackStackEntry> poppedList, boolean saveState) throws InterruptedException {
        BuildersKt.runBlocking(this.coroutineDispatcher, new C08341(poppedList, saveState, this, null));
    }
}
