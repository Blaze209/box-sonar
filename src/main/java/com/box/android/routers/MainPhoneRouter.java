package com.box.android.routers;

import android.content.Intent;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcherKt;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import com.box.android.R;
import com.box.android.base.LifecycleUtilsKt;
import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.browse.cpl.CollectionReducer;
import com.box.android.browse.cpl.NestedViewState;
import com.box.android.browse.cpl.None;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListRouter;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.ScopesStore;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.mainphone.MainPhoneReducer;
import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.utilities.CoroutineExtensionsKt;
import com.github.clans.fab.FloatingActionMenu;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.KClassesJvm;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: MainPhoneRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 J2\u0010#\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 2\b\u0010$\u001a\u0004\u0018\u00010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00120'J\u0006\u0010(\u001a\u00020\u0012J\u001c\u0010)\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 H\u0002J\u001c\u0010*\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,0 H\u0002J\u001c\u0010-\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0 H\u0002J\u001c\u00100\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020/0 H\u0002J\b\u00101\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/box/android/routers/MainPhoneRouter;", "", "itemActionHandler", "Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "copyOrMoveHelper", "Lcom/box/android/browse/utilities/CopyOrMoveHelper;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "mUserContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "filePickerMode", "", "<init>", "(Lcom/box/android/base/presentation/utilities/IItemActionHandler;Landroidx/appcompat/app/AppCompatActivity;Lcom/box/android/browse/utilities/CopyOrMoveHelper;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/domain/identity/IUserContextManager;Landroidx/activity/result/ActivityResultLauncher;Lcom/box/android/domain/configuration/FeatureFlips;Z)V", "navController", "Landroidx/navigation/NavController;", "initialStoreKey", "", "backNavigationHandler", "Lcom/box/android/routers/MainPhoneBackNavigationHandler;", "actionableItemsListRouter", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListRouter;", "initNavigation", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$State;", "Lcom/box/android/cpl/mainphone/MainPhoneReducer$Action;", "initBackNavigationHandler", "fabMenu", "Lcom/github/clans/fab/FloatingActionMenu;", "closeSearch", "Lkotlin/Function0;", "onSupportNavigateUp", "setupNestedChildNavigation", "setupCollectionsChildNavigation", "Lcom/box/android/browse/cpl/CollectionReducer$State;", "Lcom/box/android/browse/cpl/CollectionReducer$Action;", "setupBrowseChildNavigation", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "navigateToFolder", "navigateToAllFilesAndFinish", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MainPhoneRouter {
    public static final int $stable = 8;
    private ActionableItemsListRouter actionableItemsListRouter;
    private final AppCompatActivity activity;
    private MainPhoneBackNavigationHandler backNavigationHandler;
    private final CopyOrMoveHelper copyOrMoveHelper;
    private final FeatureFlips featureFlips;
    private final boolean filePickerMode;
    private String initialStoreKey;
    private final IntentServices intentServices;
    private final IItemActionHandler itemActionHandler;
    private final ActivityResultLauncher<Intent> launcher;
    private final IUserContextManager mUserContextManager;
    private NavController navController;

    public MainPhoneRouter(IItemActionHandler itemActionHandler, AppCompatActivity activity, CopyOrMoveHelper copyOrMoveHelper, IntentServices intentServices, IUserContextManager mUserContextManager, ActivityResultLauncher<Intent> launcher, FeatureFlips featureFlips, boolean z) {
        Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(copyOrMoveHelper, "copyOrMoveHelper");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(mUserContextManager, "mUserContextManager");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.itemActionHandler = itemActionHandler;
        this.activity = activity;
        this.copyOrMoveHelper = copyOrMoveHelper;
        this.intentServices = intentServices;
        this.mUserContextManager = mUserContextManager;
        this.launcher = launcher;
        this.featureFlips = featureFlips;
        this.filePickerMode = z;
    }

    public /* synthetic */ MainPhoneRouter(IItemActionHandler iItemActionHandler, AppCompatActivity appCompatActivity, CopyOrMoveHelper copyOrMoveHelper, IntentServices intentServices, IUserContextManager iUserContextManager, ActivityResultLauncher activityResultLauncher, FeatureFlips featureFlips, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(iItemActionHandler, appCompatActivity, copyOrMoveHelper, intentServices, iUserContextManager, activityResultLauncher, featureFlips, (i & 128) != 0 ? false : z);
    }

    public final void initNavigation(NavController navController, Store<MainPhoneReducer.State, MainPhoneReducer.Action> store) {
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(store, "store");
        if (this.navController != null) {
            return;
        }
        this.navController = navController;
        this.initialStoreKey = store.getKey();
        setupNestedChildNavigation(store);
        this.actionableItemsListRouter = new ActionableItemsListRouter(this.activity, this.launcher, this.itemActionHandler, this.copyOrMoveHelper, this.intentServices, null, 32, null);
    }

    public final void initBackNavigationHandler(Store<MainPhoneReducer.State, MainPhoneReducer.Action> store, FloatingActionMenu fabMenu, Function0<Boolean> closeSearch) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(closeSearch, "closeSearch");
        this.backNavigationHandler = new MainPhoneBackNavigationHandler(this.activity, this.intentServices, this.featureFlips, store, fabMenu, closeSearch);
        OnBackPressedDispatcherKt.addCallback$default(this.activity.getOnBackPressedDispatcher(), this.activity, false, new Function1() { // from class: com.box.android.routers.MainPhoneRouter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return MainPhoneRouter.initBackNavigationHandler$lambda$0(this.f$0, (OnBackPressedCallback) obj);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initBackNavigationHandler$lambda$0(MainPhoneRouter mainPhoneRouter, OnBackPressedCallback addCallback) {
        Intrinsics.checkNotNullParameter(addCallback, "$this$addCallback");
        MainPhoneBackNavigationHandler mainPhoneBackNavigationHandler = mainPhoneRouter.backNavigationHandler;
        if (mainPhoneBackNavigationHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backNavigationHandler");
            mainPhoneBackNavigationHandler = null;
        }
        mainPhoneBackNavigationHandler.handleBackNavigation();
        return Unit.INSTANCE;
    }

    public final boolean onSupportNavigateUp() {
        MainPhoneBackNavigationHandler mainPhoneBackNavigationHandler = this.backNavigationHandler;
        if (mainPhoneBackNavigationHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backNavigationHandler");
            mainPhoneBackNavigationHandler = null;
        }
        return mainPhoneBackNavigationHandler.onSupportNavigateUp();
    }

    private final void setupNestedChildNavigation(Store<MainPhoneReducer.State, MainPhoneReducer.Action> store) {
        NavController navController = this.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        if (navController.getCurrentBackStackEntry() != null) {
            Store<LocalState, MainPhoneReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$1$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((MainPhoneReducer.State) obj).getNestedViewState();
                }
            });
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseReducer.State.class);
            MainPhoneRouter$setupNestedChildNavigation$1$2$1 mainPhoneRouter$setupNestedChildNavigation$1$2$1 = MainPhoneRouter$setupNestedChildNavigation$1$2$1.INSTANCE;
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.activity);
            final Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<NestedViewState, NestedViewState, Boolean>() { // from class: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$1
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(NestedViewState old, NestedViewState nestedViewState) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(nestedViewState, "new");
                    return Boolean.valueOf((old instanceof BrowseReducer.State) && (nestedViewState instanceof BrowseReducer.State));
                }
            });
            FlowKt.launchIn(FlowKt.onEach(new Flow<BrowseReducer.State>() { // from class: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$2

                /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$2$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$2$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$2$2", f = "MainPhoneRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            BrowseReducer.State state = (BrowseReducer.State) (!(obj instanceof BrowseReducer.State) ? null : obj);
                            if (state != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(state);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(state, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super BrowseReducer.State> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            }, new MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$3(storeScope, orCreateKotlinClass, mainPhoneRouter$setupNestedChildNavigation$1$2$1, null, this)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope), KClassesJvm.getJvmName(orCreateKotlinClass)));
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(CollectionReducer.State.class);
            MainPhoneRouter$setupNestedChildNavigation$1$2$3 mainPhoneRouter$setupNestedChildNavigation$1$2$3 = MainPhoneRouter$setupNestedChildNavigation$1$2$3.INSTANCE;
            LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this.activity);
            final Flow flowDistinctUntilChanged2 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<NestedViewState, NestedViewState, Boolean>() { // from class: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$4
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(NestedViewState old, NestedViewState nestedViewState) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(nestedViewState, "new");
                    return Boolean.valueOf((old instanceof CollectionReducer.State) && (nestedViewState instanceof CollectionReducer.State));
                }
            });
            FlowKt.launchIn(FlowKt.onEach(new Flow<CollectionReducer.State>() { // from class: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$5

                /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$5$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$5$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$5$2", f = "MainPhoneRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            CollectionReducer.State state = (CollectionReducer.State) (!(obj instanceof CollectionReducer.State) ? null : obj);
                            if (state != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(state);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(state, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }

                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super CollectionReducer.State> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged2.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }
            }, new MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$6(storeScope, orCreateKotlinClass2, mainPhoneRouter$setupNestedChildNavigation$1$2$3, null, this)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope2), KClassesJvm.getJvmName(orCreateKotlinClass2)));
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(None.class);
            MainPhoneRouter$setupNestedChildNavigation$1$2$5 mainPhoneRouter$setupNestedChildNavigation$1$2$5 = MainPhoneRouter$setupNestedChildNavigation$1$2$5.INSTANCE;
            LifecycleCoroutineScope lifecycleScope3 = LifecycleOwnerKt.getLifecycleScope(this.activity);
            final Flow flowDistinctUntilChanged3 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<NestedViewState, NestedViewState, Boolean>() { // from class: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$7
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(NestedViewState old, NestedViewState nestedViewState) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(nestedViewState, "new");
                    return Boolean.valueOf((old instanceof None) && (nestedViewState instanceof None));
                }
            });
            FlowKt.launchIn(FlowKt.onEach(new Flow<None>() { // from class: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$8
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super None> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged3.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$8$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$8$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$8$2", f = "MainPhoneRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            None none = (None) (!(obj instanceof None) ? null : obj);
                            if (none != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(none);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(none, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, new MainPhoneRouter$setupNestedChildNavigation$lambda$0$0$$inlined$switchScope$9(storeScope, orCreateKotlinClass3, mainPhoneRouter$setupNestedChildNavigation$1$2$5, null, this)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope3), KClassesJvm.getJvmName(orCreateKotlinClass3)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupCollectionsChildNavigation(Store<CollectionReducer.State, CollectionReducer.Action> store) {
        NavController navController = this.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        NavBackStackEntry currentBackStackEntry = navController.getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            Store<LocalState, CollectionReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$1$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((CollectionReducer.State) obj).getNavigationRoute();
                }
            });
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(CollectionReducer.Route.Folder.class);
            MainPhoneRouter$setupCollectionsChildNavigation$1$2$1 mainPhoneRouter$setupCollectionsChildNavigation$1$2$1 = MainPhoneRouter$setupCollectionsChildNavigation$1$2$1.INSTANCE;
            NavBackStackEntry navBackStackEntry = currentBackStackEntry;
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(navBackStackEntry);
            final Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<CollectionReducer.Route, CollectionReducer.Route, Boolean>() { // from class: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$1
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(CollectionReducer.Route old, CollectionReducer.Route route) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(route, "new");
                    return Boolean.valueOf((old instanceof CollectionReducer.Route.Folder) && (route instanceof CollectionReducer.Route.Folder));
                }
            });
            FlowKt.launchIn(FlowKt.onEach(new Flow<CollectionReducer.Route.Folder>() { // from class: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$2
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super CollectionReducer.Route.Folder> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$2$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$2$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$2$2", f = "MainPhoneRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            CollectionReducer.Route.Folder folder = (CollectionReducer.Route.Folder) (!(obj instanceof CollectionReducer.Route.Folder) ? null : obj);
                            if (folder != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(folder);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(folder, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, new MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$3(storeScope, orCreateKotlinClass, mainPhoneRouter$setupCollectionsChildNavigation$1$2$1, null, this)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope), KClassesJvm.getJvmName(orCreateKotlinClass)));
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(CollectionReducer.Route.File.class);
            MainPhoneRouter$setupCollectionsChildNavigation$1$2$3 mainPhoneRouter$setupCollectionsChildNavigation$1$2$3 = MainPhoneRouter$setupCollectionsChildNavigation$1$2$3.INSTANCE;
            LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(navBackStackEntry);
            final Flow flowDistinctUntilChanged2 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<CollectionReducer.Route, CollectionReducer.Route, Boolean>() { // from class: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$4
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(CollectionReducer.Route old, CollectionReducer.Route route) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(route, "new");
                    return Boolean.valueOf((old instanceof CollectionReducer.Route.File) && (route instanceof CollectionReducer.Route.File));
                }
            });
            FlowKt.launchIn(FlowKt.onEach(new Flow<CollectionReducer.Route.File>() { // from class: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$5
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super CollectionReducer.Route.File> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged2.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$5$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$5$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$5$2", f = "MainPhoneRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            CollectionReducer.Route.File file = (CollectionReducer.Route.File) (!(obj instanceof CollectionReducer.Route.File) ? null : obj);
                            if (file != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(file);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(file, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, new MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$6(storeScope, orCreateKotlinClass2, mainPhoneRouter$setupCollectionsChildNavigation$1$2$3, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope2), KClassesJvm.getJvmName(orCreateKotlinClass2)));
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(CollectionReducer.Route.WebLink.class);
            MainPhoneRouter$setupCollectionsChildNavigation$1$2$5 mainPhoneRouter$setupCollectionsChildNavigation$1$2$5 = MainPhoneRouter$setupCollectionsChildNavigation$1$2$5.INSTANCE;
            LifecycleCoroutineScope lifecycleScope3 = LifecycleOwnerKt.getLifecycleScope(navBackStackEntry);
            final Flow flowDistinctUntilChanged3 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<CollectionReducer.Route, CollectionReducer.Route, Boolean>() { // from class: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$7
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(CollectionReducer.Route old, CollectionReducer.Route route) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(route, "new");
                    return Boolean.valueOf((old instanceof CollectionReducer.Route.WebLink) && (route instanceof CollectionReducer.Route.WebLink));
                }
            });
            FlowKt.launchIn(FlowKt.onEach(new Flow<CollectionReducer.Route.WebLink>() { // from class: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$8
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super CollectionReducer.Route.WebLink> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged3.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$8$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$8$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$8$2", f = "MainPhoneRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            CollectionReducer.Route.WebLink webLink = (CollectionReducer.Route.WebLink) (!(obj instanceof CollectionReducer.Route.WebLink) ? null : obj);
                            if (webLink != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(webLink);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(webLink, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, new MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$9(storeScope, orCreateKotlinClass3, mainPhoneRouter$setupCollectionsChildNavigation$1$2$5, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope3), KClassesJvm.getJvmName(orCreateKotlinClass3)));
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(CollectionReducer.Route.None.class);
            MainPhoneRouter$setupCollectionsChildNavigation$1$2$7 mainPhoneRouter$setupCollectionsChildNavigation$1$2$7 = MainPhoneRouter$setupCollectionsChildNavigation$1$2$7.INSTANCE;
            LifecycleCoroutineScope lifecycleScope4 = LifecycleOwnerKt.getLifecycleScope(navBackStackEntry);
            final Flow flowDistinctUntilChanged4 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<CollectionReducer.Route, CollectionReducer.Route, Boolean>() { // from class: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchScope$1
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(CollectionReducer.Route old, CollectionReducer.Route route) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(route, "new");
                    return Boolean.valueOf((old instanceof CollectionReducer.Route.None) && (route instanceof CollectionReducer.Route.None));
                }
            });
            FlowKt.launchIn(FlowKt.onEach(new Flow<CollectionReducer.Route.None>() { // from class: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchScope$2
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super CollectionReducer.Route.None> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged4.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchScope$2$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchScope$2$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchScope$2$2", f = "MainPhoneRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            CollectionReducer.Route.None none = (CollectionReducer.Route.None) (!(obj instanceof CollectionReducer.Route.None) ? null : obj);
                            if (none != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(none);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(none, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, new MainPhoneRouter$setupCollectionsChildNavigation$lambda$0$0$$inlined$switchScope$3(storeScope, orCreateKotlinClass4, mainPhoneRouter$setupCollectionsChildNavigation$1$2$7, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope4), KClassesJvm.getJvmName(orCreateKotlinClass4)));
        }
    }

    private final void setupBrowseChildNavigation(Store<BrowseReducer.State, BrowseReducer.Action> store) {
        NavController navController = this.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        NavBackStackEntry currentBackStackEntry = navController.getCurrentBackStackEntry();
        if (currentBackStackEntry != null) {
            Store<LocalState, BrowseReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$1$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((BrowseReducer.State) obj).getNavigationRoute();
                }
            });
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseReducer.Route.Folder.class);
            MainPhoneRouter$setupBrowseChildNavigation$1$2$1 mainPhoneRouter$setupBrowseChildNavigation$1$2$1 = MainPhoneRouter$setupBrowseChildNavigation$1$2$1.INSTANCE;
            NavBackStackEntry navBackStackEntry = currentBackStackEntry;
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(navBackStackEntry);
            final Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<BrowseReducer.Route, BrowseReducer.Route, Boolean>() { // from class: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$1
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(BrowseReducer.Route old, BrowseReducer.Route route) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(route, "new");
                    return Boolean.valueOf((old instanceof BrowseReducer.Route.Folder) && (route instanceof BrowseReducer.Route.Folder));
                }
            });
            FlowKt.launchIn(FlowKt.onEach(new Flow<BrowseReducer.Route.Folder>() { // from class: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$2
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super BrowseReducer.Route.Folder> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$2$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$2$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$2$2", f = "MainPhoneRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            BrowseReducer.Route.Folder folder = (BrowseReducer.Route.Folder) (!(obj instanceof BrowseReducer.Route.Folder) ? null : obj);
                            if (folder != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(folder);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(folder, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, new MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$3(storeScope, orCreateKotlinClass, mainPhoneRouter$setupBrowseChildNavigation$1$2$1, null, this)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope), KClassesJvm.getJvmName(orCreateKotlinClass)));
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(BrowseReducer.Route.File.class);
            MainPhoneRouter$setupBrowseChildNavigation$1$2$3 mainPhoneRouter$setupBrowseChildNavigation$1$2$3 = MainPhoneRouter$setupBrowseChildNavigation$1$2$3.INSTANCE;
            LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(navBackStackEntry);
            final Flow flowDistinctUntilChanged2 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<BrowseReducer.Route, BrowseReducer.Route, Boolean>() { // from class: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$4
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(BrowseReducer.Route old, BrowseReducer.Route route) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(route, "new");
                    return Boolean.valueOf((old instanceof BrowseReducer.Route.File) && (route instanceof BrowseReducer.Route.File));
                }
            });
            FlowKt.launchIn(FlowKt.onEach(new Flow<BrowseReducer.Route.File>() { // from class: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$5
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super BrowseReducer.Route.File> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged2.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$5$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$5$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$5$2", f = "MainPhoneRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            BrowseReducer.Route.File file = (BrowseReducer.Route.File) (!(obj instanceof BrowseReducer.Route.File) ? null : obj);
                            if (file != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(file);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(file, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, new MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$6(storeScope, orCreateKotlinClass2, mainPhoneRouter$setupBrowseChildNavigation$1$2$3, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope2), KClassesJvm.getJvmName(orCreateKotlinClass2)));
            KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(BrowseReducer.Route.WebLink.class);
            MainPhoneRouter$setupBrowseChildNavigation$1$2$5 mainPhoneRouter$setupBrowseChildNavigation$1$2$5 = MainPhoneRouter$setupBrowseChildNavigation$1$2$5.INSTANCE;
            LifecycleCoroutineScope lifecycleScope3 = LifecycleOwnerKt.getLifecycleScope(navBackStackEntry);
            final Flow flowDistinctUntilChanged3 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<BrowseReducer.Route, BrowseReducer.Route, Boolean>() { // from class: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$7
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(BrowseReducer.Route old, BrowseReducer.Route route) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(route, "new");
                    return Boolean.valueOf((old instanceof BrowseReducer.Route.WebLink) && (route instanceof BrowseReducer.Route.WebLink));
                }
            });
            FlowKt.launchIn(FlowKt.onEach(new Flow<BrowseReducer.Route.WebLink>() { // from class: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$8
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super BrowseReducer.Route.WebLink> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged3.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$8$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$8$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$8$2", f = "MainPhoneRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            BrowseReducer.Route.WebLink webLink = (BrowseReducer.Route.WebLink) (!(obj instanceof BrowseReducer.Route.WebLink) ? null : obj);
                            if (webLink != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(webLink);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(webLink, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, new MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$9(storeScope, orCreateKotlinClass3, mainPhoneRouter$setupBrowseChildNavigation$1$2$5, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope3), KClassesJvm.getJvmName(orCreateKotlinClass3)));
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(BrowseReducer.Route.FeatureBanner.class);
            MainPhoneRouter$setupBrowseChildNavigation$1$2$7 mainPhoneRouter$setupBrowseChildNavigation$1$2$7 = MainPhoneRouter$setupBrowseChildNavigation$1$2$7.INSTANCE;
            LifecycleCoroutineScope lifecycleScope4 = LifecycleOwnerKt.getLifecycleScope(navBackStackEntry);
            final Flow flowDistinctUntilChanged4 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<BrowseReducer.Route, BrowseReducer.Route, Boolean>() { // from class: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$10
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(BrowseReducer.Route old, BrowseReducer.Route route) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(route, "new");
                    return Boolean.valueOf((old instanceof BrowseReducer.Route.FeatureBanner) && (route instanceof BrowseReducer.Route.FeatureBanner));
                }
            });
            FlowKt.launchIn(FlowKt.onEach(new Flow<BrowseReducer.Route.FeatureBanner>() { // from class: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$11
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super BrowseReducer.Route.FeatureBanner> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged4.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$11$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$11$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$11$2", f = "MainPhoneRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            BrowseReducer.Route.FeatureBanner featureBanner = (BrowseReducer.Route.FeatureBanner) (!(obj instanceof BrowseReducer.Route.FeatureBanner) ? null : obj);
                            if (featureBanner != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(featureBanner);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(featureBanner, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, new MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$12(storeScope, orCreateKotlinClass4, mainPhoneRouter$setupBrowseChildNavigation$1$2$7, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope4), KClassesJvm.getJvmName(orCreateKotlinClass4)));
            LifecycleUtilsKt.launchRepeatOnLifecycle(this.activity, Lifecycle.State.STARTED, new MainPhoneRouter$setupBrowseChildNavigation$1$2$9(storeScope, this, store, null));
            KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(BrowseReducer.Route.InviteCollaborators.class);
            MainPhoneRouter$setupBrowseChildNavigation$1$2$10 mainPhoneRouter$setupBrowseChildNavigation$1$2$10 = MainPhoneRouter$setupBrowseChildNavigation$1$2$10.INSTANCE;
            LifecycleCoroutineScope lifecycleScope5 = LifecycleOwnerKt.getLifecycleScope(navBackStackEntry);
            final Flow flowDistinctUntilChanged5 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<BrowseReducer.Route, BrowseReducer.Route, Boolean>() { // from class: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$13
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(BrowseReducer.Route old, BrowseReducer.Route route) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(route, "new");
                    return Boolean.valueOf((old instanceof BrowseReducer.Route.InviteCollaborators) && (route instanceof BrowseReducer.Route.InviteCollaborators));
                }
            });
            FlowKt.launchIn(FlowKt.onEach(new Flow<BrowseReducer.Route.InviteCollaborators>() { // from class: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$14
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super BrowseReducer.Route.InviteCollaborators> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged5.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$14$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$14$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$14$2", f = "MainPhoneRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            BrowseReducer.Route.InviteCollaborators inviteCollaborators = (BrowseReducer.Route.InviteCollaborators) (!(obj instanceof BrowseReducer.Route.InviteCollaborators) ? null : obj);
                            if (inviteCollaborators != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(inviteCollaborators);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(inviteCollaborators, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, new MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchEmbeddedScope$15(storeScope, orCreateKotlinClass5, mainPhoneRouter$setupBrowseChildNavigation$1$2$10, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope5), KClassesJvm.getJvmName(orCreateKotlinClass5)));
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(BrowseReducer.Route.None.class);
            MainPhoneRouter$setupBrowseChildNavigation$1$2$12 mainPhoneRouter$setupBrowseChildNavigation$1$2$12 = MainPhoneRouter$setupBrowseChildNavigation$1$2$12.INSTANCE;
            LifecycleCoroutineScope lifecycleScope6 = LifecycleOwnerKt.getLifecycleScope(navBackStackEntry);
            final Flow flowDistinctUntilChanged6 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<BrowseReducer.Route, BrowseReducer.Route, Boolean>() { // from class: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchScope$1
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(BrowseReducer.Route old, BrowseReducer.Route route) {
                    Intrinsics.checkNotNullParameter(old, "old");
                    Intrinsics.checkNotNullParameter(route, "new");
                    return Boolean.valueOf((old instanceof BrowseReducer.Route.None) && (route instanceof BrowseReducer.Route.None));
                }
            });
            FlowKt.launchIn(FlowKt.onEach(new Flow<BrowseReducer.Route.None>() { // from class: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchScope$2
                @Override // kotlinx.coroutines.flow.Flow
                public Object collect(FlowCollector<? super BrowseReducer.Route.None> flowCollector, Continuation continuation) {
                    Object objCollect = flowDistinctUntilChanged6.collect(new AnonymousClass2(flowCollector), continuation);
                    return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchScope$2$2, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* JADX INFO: renamed from: com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchScope$2$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "com.box.android.routers.MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchScope$2$2", f = "MainPhoneRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        Object L$4;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public final Object emit(Object obj, Continuation continuation) {
                        AnonymousClass1 anonymousClass1;
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
                        Object obj2 = anonymousClass1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = anonymousClass1.label;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj2);
                            FlowCollector flowCollector = this.$this_unsafeFlow;
                            BrowseReducer.Route.None none = (BrowseReducer.Route.None) (!(obj instanceof BrowseReducer.Route.None) ? null : obj);
                            if (none != null) {
                                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(obj);
                                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                                anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(none);
                                anonymousClass1.I$0 = 0;
                                anonymousClass1.label = 1;
                                if (flowCollector.emit(none, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            int i2 = anonymousClass1.I$0;
                            Object obj3 = anonymousClass1.L$2;
                            Object obj4 = anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj2);
                        }
                        return Unit.INSTANCE;
                    }
                }
            }, new MainPhoneRouter$setupBrowseChildNavigation$lambda$0$0$$inlined$switchScope$3(storeScope, orCreateKotlinClass6, mainPhoneRouter$setupBrowseChildNavigation$1$2$12, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope6), KClassesJvm.getJvmName(orCreateKotlinClass6)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToFolder(Store<BrowseReducer.State, BrowseReducer.Action> store) {
        if (!this.filePickerMode && ((BrowseReducer.State) StoreKt.stateValue(store)).getActionableItemsListState().getItemsListViewState().getCurrentFolder().isRoot()) {
            navigateToAllFilesAndFinish();
            return;
        }
        NavController navController = this.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        navController.navigate(R.id.browseFragment, BundleKt.bundleOf(TuplesKt.to(BoxCommonConstants.STORE_KEY, store.getKey())));
        setupBrowseChildNavigation(store);
    }

    private final void navigateToAllFilesAndFinish() {
        this.launcher.launch(this.intentServices.navigationActivityIntent(this.activity, this.featureFlips.getMainScreenRedesign().getEnabled(), IntentServices.NavigationIntentTarget.ALL_FILES));
        ScopesStore scopesStore = ScopesStore.INSTANCE;
        String str = this.initialStoreKey;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("initialStoreKey");
            str = null;
        }
        Object obj = scopesStore.get(str);
        Store store = obj instanceof Store ? (Store) obj : null;
        if (store != null) {
            store.close();
        }
        this.activity.finish();
    }
}
