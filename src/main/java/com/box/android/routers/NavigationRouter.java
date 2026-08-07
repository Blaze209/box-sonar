package com.box.android.routers;

import android.content.Intent;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.android.base.LifecycleUtilsKt;
import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.base.presentation.utilities.IItemActionHandler;
import com.box.android.browse.cpl.browse.BrowseReducer;
import com.box.android.browse.cpl.itemsList.ActionableItemsListRouter;
import com.box.android.browse.cpl.offlined.OfflinedReducer;
import com.box.android.browse.cpl.recents.RecentsReducer;
import com.box.android.browse.utilities.CopyOrMoveHelper;
import com.box.android.coreservices.services.IntentServices;
import com.box.android.cpl.Store;
import com.box.android.cpl.StoreKt;
import com.box.android.cpl.navigation.NavigationReducer;
import com.box.android.cpl.navigation.NavigationViewModel;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.utilities.CoroutineExtensionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.KClassesJvm;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: NavigationRouter.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u001c\u0010\u001a\u001a\u00020\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cH\u0002J\u001c\u0010\u001f\u001a\u00020\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001cH\u0002J\u001c\u0010\"\u001a\u00020\u00172\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\u001cH\u0002J\u0010\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020'H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/box/android/routers/NavigationRouter;", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "itemActionHandler", "Lcom/box/android/base/presentation/utilities/IItemActionHandler;", "copyOrMoveHelper", "Lcom/box/android/browse/utilities/CopyOrMoveHelper;", "intentServices", "Lcom/box/android/coreservices/services/IntentServices;", "mUserContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "<init>", "(Landroidx/appcompat/app/AppCompatActivity;Landroidx/activity/result/ActivityResultLauncher;Lcom/box/android/base/presentation/utilities/IItemActionHandler;Lcom/box/android/browse/utilities/CopyOrMoveHelper;Lcom/box/android/coreservices/services/IntentServices;Lcom/box/android/domain/identity/IUserContextManager;)V", "browseRouter", "Lcom/box/android/browse/cpl/itemsList/ActionableItemsListRouter;", "recentsRouter", "offlinedRouter", "currentActiveRouter", "initNavigation", "", "viewModel", "Lcom/box/android/cpl/navigation/NavigationViewModel;", "initBrowseNavigation", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "initRecentsNavigation", "Lcom/box/android/browse/cpl/recents/RecentsReducer$State;", "Lcom/box/android/browse/cpl/recents/RecentsReducer$Action;", "initOfflinedNavigation", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$State;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "navigateToMainPhone", "folder", "Lcom/box/android/domain/models/item/FolderModel;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class NavigationRouter {
    public static final int $stable = 8;
    private final AppCompatActivity activity;
    private ActionableItemsListRouter browseRouter;
    private final CopyOrMoveHelper copyOrMoveHelper;
    private ActionableItemsListRouter currentActiveRouter;
    private final IntentServices intentServices;
    private final IItemActionHandler itemActionHandler;
    private final ActivityResultLauncher<Intent> launcher;
    private final IUserContextManager mUserContextManager;
    private ActionableItemsListRouter offlinedRouter;
    private ActionableItemsListRouter recentsRouter;

    /* JADX INFO: compiled from: NavigationRouter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NavigationReducer.Tab.values().length];
            try {
                iArr[NavigationReducer.Tab.ALL_FILES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NavigationReducer.Tab.RECENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NavigationReducer.Tab.OFFLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NavigationReducer.Tab.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public NavigationRouter(AppCompatActivity activity, ActivityResultLauncher<Intent> launcher, IItemActionHandler itemActionHandler, CopyOrMoveHelper copyOrMoveHelper, IntentServices intentServices, IUserContextManager mUserContextManager) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        Intrinsics.checkNotNullParameter(itemActionHandler, "itemActionHandler");
        Intrinsics.checkNotNullParameter(copyOrMoveHelper, "copyOrMoveHelper");
        Intrinsics.checkNotNullParameter(intentServices, "intentServices");
        Intrinsics.checkNotNullParameter(mUserContextManager, "mUserContextManager");
        this.activity = activity;
        this.launcher = launcher;
        this.itemActionHandler = itemActionHandler;
        this.copyOrMoveHelper = copyOrMoveHelper;
        this.intentServices = intentServices;
        this.mUserContextManager = mUserContextManager;
    }

    public final void initNavigation(NavigationViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.browseRouter = new ActionableItemsListRouter(this.activity, this.launcher, this.itemActionHandler, this.copyOrMoveHelper, this.intentServices, BottomSheetAttributes.LaunchContext.BrowseAllFiles.INSTANCE);
        this.recentsRouter = new ActionableItemsListRouter(this.activity, this.launcher, this.itemActionHandler, this.copyOrMoveHelper, this.intentServices, BottomSheetAttributes.LaunchContext.BrowseRecents.INSTANCE);
        this.offlinedRouter = new ActionableItemsListRouter(this.activity, this.launcher, this.itemActionHandler, this.copyOrMoveHelper, this.intentServices, BottomSheetAttributes.LaunchContext.BrowseOfflined.INSTANCE);
        initBrowseNavigation(viewModel.getBrowseStore());
        initRecentsNavigation(viewModel.getRecentsStore());
        initOfflinedNavigation(viewModel.getOfflinedStore());
        StoreKt.observe$default(viewModel.getStore(), new PropertyReference1Impl() { // from class: com.box.android.routers.NavigationRouter.initNavigation.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((NavigationReducer.State) obj).getActiveTab();
            }
        }, null, new Function1() { // from class: com.box.android.routers.NavigationRouter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NavigationRouter.initNavigation$lambda$0(this.f$0, (NavigationReducer.Tab) obj);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x003f A[PHI: r3
      0x003f: PHI (r3v5 com.box.android.browse.cpl.itemsList.ActionableItemsListRouter) = 
      (r3v3 com.box.android.browse.cpl.itemsList.ActionableItemsListRouter)
      (r3v6 com.box.android.browse.cpl.itemsList.ActionableItemsListRouter)
      (r3v8 com.box.android.browse.cpl.itemsList.ActionableItemsListRouter)
     binds: [B:20:0x0037, B:17:0x002d, B:14:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    public static final Unit initNavigation$lambda$0(NavigationRouter navigationRouter, NavigationReducer.Tab activeTab) {
        ActionableItemsListRouter actionableItemsListRouter;
        Intrinsics.checkNotNullParameter(activeTab, "activeTab");
        int i = WhenMappings.$EnumSwitchMapping$0[activeTab.ordinal()];
        ActionableItemsListRouter actionableItemsListRouter2 = null;
        if (i == 1) {
            actionableItemsListRouter = navigationRouter.browseRouter;
            if (actionableItemsListRouter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("browseRouter");
            } else {
                actionableItemsListRouter2 = actionableItemsListRouter;
            }
        } else if (i == 2) {
            actionableItemsListRouter = navigationRouter.recentsRouter;
            if (actionableItemsListRouter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recentsRouter");
            } else {
                actionableItemsListRouter2 = actionableItemsListRouter;
            }
        } else if (i == 3) {
            actionableItemsListRouter = navigationRouter.offlinedRouter;
            if (actionableItemsListRouter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("offlinedRouter");
            } else {
                actionableItemsListRouter2 = actionableItemsListRouter;
            }
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        navigationRouter.currentActiveRouter = actionableItemsListRouter2;
        return Unit.INSTANCE;
    }

    private final void initBrowseNavigation(Store<BrowseReducer.State, BrowseReducer.Action> store) {
        Store<LocalState, BrowseReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.routers.NavigationRouter.initBrowseNavigation.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((BrowseReducer.State) obj).getNavigationRoute();
            }
        });
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BrowseReducer.Route.Folder.class);
        NavigationRouter$initBrowseNavigation$2$1 navigationRouter$initBrowseNavigation$2$1 = NavigationRouter$initBrowseNavigation$2$1.INSTANCE;
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.activity);
        final Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<BrowseReducer.Route, BrowseReducer.Route, Boolean>() { // from class: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$1
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(BrowseReducer.Route old, BrowseReducer.Route route) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(route, "new");
                return Boolean.valueOf((old instanceof BrowseReducer.Route.Folder) && (route instanceof BrowseReducer.Route.Folder));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<BrowseReducer.Route.Folder>() { // from class: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$2

            /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$2$2", f = "NavigationRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super BrowseReducer.Route.Folder> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$3(storeScope, orCreateKotlinClass, navigationRouter$initBrowseNavigation$2$1, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope), KClassesJvm.getJvmName(orCreateKotlinClass)));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(BrowseReducer.Route.File.class);
        NavigationRouter$initBrowseNavigation$2$3 navigationRouter$initBrowseNavigation$2$3 = NavigationRouter$initBrowseNavigation$2$3.INSTANCE;
        LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this.activity);
        final Flow flowDistinctUntilChanged2 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<BrowseReducer.Route, BrowseReducer.Route, Boolean>() { // from class: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$4
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(BrowseReducer.Route old, BrowseReducer.Route route) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(route, "new");
                return Boolean.valueOf((old instanceof BrowseReducer.Route.File) && (route instanceof BrowseReducer.Route.File));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<BrowseReducer.Route.File>() { // from class: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$5

            /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$5$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$5$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$5$2", f = "NavigationRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super BrowseReducer.Route.File> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged2.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$6(storeScope, orCreateKotlinClass2, navigationRouter$initBrowseNavigation$2$3, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope2), KClassesJvm.getJvmName(orCreateKotlinClass2)));
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(BrowseReducer.Route.WebLink.class);
        NavigationRouter$initBrowseNavigation$2$5 navigationRouter$initBrowseNavigation$2$5 = NavigationRouter$initBrowseNavigation$2$5.INSTANCE;
        LifecycleCoroutineScope lifecycleScope3 = LifecycleOwnerKt.getLifecycleScope(this.activity);
        final Flow flowDistinctUntilChanged3 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<BrowseReducer.Route, BrowseReducer.Route, Boolean>() { // from class: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$7
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(BrowseReducer.Route old, BrowseReducer.Route route) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(route, "new");
                return Boolean.valueOf((old instanceof BrowseReducer.Route.WebLink) && (route instanceof BrowseReducer.Route.WebLink));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<BrowseReducer.Route.WebLink>() { // from class: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$8

            /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$8$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$8$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$8$2", f = "NavigationRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super BrowseReducer.Route.WebLink> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged3.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }
        }, new NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$9(storeScope, orCreateKotlinClass3, navigationRouter$initBrowseNavigation$2$5, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope3), KClassesJvm.getJvmName(orCreateKotlinClass3)));
        KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(BrowseReducer.Route.FeatureBanner.class);
        NavigationRouter$initBrowseNavigation$2$7 navigationRouter$initBrowseNavigation$2$7 = NavigationRouter$initBrowseNavigation$2$7.INSTANCE;
        LifecycleCoroutineScope lifecycleScope4 = LifecycleOwnerKt.getLifecycleScope(this.activity);
        final Flow flowDistinctUntilChanged4 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<BrowseReducer.Route, BrowseReducer.Route, Boolean>() { // from class: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$10
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(BrowseReducer.Route old, BrowseReducer.Route route) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(route, "new");
                return Boolean.valueOf((old instanceof BrowseReducer.Route.FeatureBanner) && (route instanceof BrowseReducer.Route.FeatureBanner));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<BrowseReducer.Route.FeatureBanner>() { // from class: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$11
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super BrowseReducer.Route.FeatureBanner> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged4.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$11$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$11$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$11$2", f = "NavigationRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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
        }, new NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$12(storeScope, orCreateKotlinClass4, navigationRouter$initBrowseNavigation$2$7, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope4), KClassesJvm.getJvmName(orCreateKotlinClass4)));
        LifecycleUtilsKt.launchRepeatOnLifecycle(this.activity, Lifecycle.State.STARTED, new NavigationRouter$initBrowseNavigation$2$9(storeScope, this, store, null));
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(BrowseReducer.Route.InviteCollaborators.class);
        NavigationRouter$initBrowseNavigation$2$10 navigationRouter$initBrowseNavigation$2$10 = NavigationRouter$initBrowseNavigation$2$10.INSTANCE;
        LifecycleCoroutineScope lifecycleScope5 = LifecycleOwnerKt.getLifecycleScope(this.activity);
        final Flow flowDistinctUntilChanged5 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<BrowseReducer.Route, BrowseReducer.Route, Boolean>() { // from class: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$13
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(BrowseReducer.Route old, BrowseReducer.Route route) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(route, "new");
                return Boolean.valueOf((old instanceof BrowseReducer.Route.InviteCollaborators) && (route instanceof BrowseReducer.Route.InviteCollaborators));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<BrowseReducer.Route.InviteCollaborators>() { // from class: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$14
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super BrowseReducer.Route.InviteCollaborators> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged5.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$14$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$14$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.routers.NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$14$2", f = "NavigationRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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
        }, new NavigationRouter$initBrowseNavigation$lambda$0$$inlined$switchEmbeddedScope$15(storeScope, orCreateKotlinClass5, navigationRouter$initBrowseNavigation$2$10, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope5), KClassesJvm.getJvmName(orCreateKotlinClass5)));
    }

    private final void initRecentsNavigation(Store<RecentsReducer.State, RecentsReducer.Action> store) {
        Store<LocalState, RecentsReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.routers.NavigationRouter.initRecentsNavigation.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((RecentsReducer.State) obj).getNavigationRoute();
            }
        });
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(RecentsReducer.Route.File.class);
        NavigationRouter$initRecentsNavigation$2$1 navigationRouter$initRecentsNavigation$2$1 = NavigationRouter$initRecentsNavigation$2$1.INSTANCE;
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.activity);
        final Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<RecentsReducer.Route, RecentsReducer.Route, Boolean>() { // from class: com.box.android.routers.NavigationRouter$initRecentsNavigation$lambda$0$$inlined$switchEmbeddedScope$1
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(RecentsReducer.Route old, RecentsReducer.Route route) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(route, "new");
                return Boolean.valueOf((old instanceof RecentsReducer.Route.File) && (route instanceof RecentsReducer.Route.File));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<RecentsReducer.Route.File>() { // from class: com.box.android.routers.NavigationRouter$initRecentsNavigation$lambda$0$$inlined$switchEmbeddedScope$2
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super RecentsReducer.Route.File> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initRecentsNavigation$lambda$0$$inlined$switchEmbeddedScope$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initRecentsNavigation$lambda$0$$inlined$switchEmbeddedScope$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.routers.NavigationRouter$initRecentsNavigation$lambda$0$$inlined$switchEmbeddedScope$2$2", f = "NavigationRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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
                        RecentsReducer.Route.File file = (RecentsReducer.Route.File) (!(obj instanceof RecentsReducer.Route.File) ? null : obj);
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
        }, new NavigationRouter$initRecentsNavigation$lambda$0$$inlined$switchEmbeddedScope$3(storeScope, orCreateKotlinClass, navigationRouter$initRecentsNavigation$2$1, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope), KClassesJvm.getJvmName(orCreateKotlinClass)));
        LifecycleUtilsKt.launchRepeatOnLifecycle(this.activity, Lifecycle.State.STARTED, new NavigationRouter$initRecentsNavigation$2$3(storeScope, this, store, null));
    }

    private final void initOfflinedNavigation(Store<OfflinedReducer.State, OfflinedReducer.Action> store) {
        Store<LocalState, OfflinedReducer.Action> storeScope = store.scope(new PropertyReference1Impl() { // from class: com.box.android.routers.NavigationRouter.initOfflinedNavigation.1
            @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
            public Object get(Object obj) {
                return ((OfflinedReducer.State) obj).getNavigationRoute();
            }
        });
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(OfflinedReducer.Route.Folder.class);
        NavigationRouter$initOfflinedNavigation$2$1 navigationRouter$initOfflinedNavigation$2$1 = NavigationRouter$initOfflinedNavigation$2$1.INSTANCE;
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.activity);
        final Flow flowDistinctUntilChanged = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<OfflinedReducer.Route, OfflinedReducer.Route, Boolean>() { // from class: com.box.android.routers.NavigationRouter$initOfflinedNavigation$lambda$0$$inlined$switchEmbeddedScope$1
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(OfflinedReducer.Route old, OfflinedReducer.Route route) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(route, "new");
                return Boolean.valueOf((old instanceof OfflinedReducer.Route.Folder) && (route instanceof OfflinedReducer.Route.Folder));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<OfflinedReducer.Route.Folder>() { // from class: com.box.android.routers.NavigationRouter$initOfflinedNavigation$lambda$0$$inlined$switchEmbeddedScope$2
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super OfflinedReducer.Route.Folder> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initOfflinedNavigation$lambda$0$$inlined$switchEmbeddedScope$2$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initOfflinedNavigation$lambda$0$$inlined$switchEmbeddedScope$2$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.routers.NavigationRouter$initOfflinedNavigation$lambda$0$$inlined$switchEmbeddedScope$2$2", f = "NavigationRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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
                        OfflinedReducer.Route.Folder folder = (OfflinedReducer.Route.Folder) (!(obj instanceof OfflinedReducer.Route.Folder) ? null : obj);
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
        }, new NavigationRouter$initOfflinedNavigation$lambda$0$$inlined$switchEmbeddedScope$3(storeScope, orCreateKotlinClass, navigationRouter$initOfflinedNavigation$2$1, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope), KClassesJvm.getJvmName(orCreateKotlinClass)));
        KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(OfflinedReducer.Route.File.class);
        NavigationRouter$initOfflinedNavigation$2$3 navigationRouter$initOfflinedNavigation$2$3 = NavigationRouter$initOfflinedNavigation$2$3.INSTANCE;
        LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this.activity);
        final Flow flowDistinctUntilChanged2 = FlowKt.distinctUntilChanged(storeScope.getState(), new Function2<OfflinedReducer.Route, OfflinedReducer.Route, Boolean>() { // from class: com.box.android.routers.NavigationRouter$initOfflinedNavigation$lambda$0$$inlined$switchEmbeddedScope$4
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(OfflinedReducer.Route old, OfflinedReducer.Route route) {
                Intrinsics.checkNotNullParameter(old, "old");
                Intrinsics.checkNotNullParameter(route, "new");
                return Boolean.valueOf((old instanceof OfflinedReducer.Route.File) && (route instanceof OfflinedReducer.Route.File));
            }
        });
        FlowKt.launchIn(FlowKt.onEach(new Flow<OfflinedReducer.Route.File>() { // from class: com.box.android.routers.NavigationRouter$initOfflinedNavigation$lambda$0$$inlined$switchEmbeddedScope$5
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super OfflinedReducer.Route.File> flowCollector, Continuation continuation) {
                Object objCollect = flowDistinctUntilChanged2.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCollect : Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initOfflinedNavigation$lambda$0$$inlined$switchEmbeddedScope$5$2, reason: invalid class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "com/box/android/cpl/StoreKt$switchEmbeddedScope$$inlined$mapNotNull$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* JADX INFO: renamed from: com.box.android.routers.NavigationRouter$initOfflinedNavigation$lambda$0$$inlined$switchEmbeddedScope$5$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: Emitters.kt */
                @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                @DebugMetadata(c = "com.box.android.routers.NavigationRouter$initOfflinedNavigation$lambda$0$$inlined$switchEmbeddedScope$5$2", f = "NavigationRouter.kt", i = {0, 0, 0, 0, 0, 0}, l = {221}, m = "emit", n = {"value", "$completion", "value", "$this$mapNotNull_u24lambda_u246", "transformed", "$i$a$-unsafeTransform-FlowKt__TransformKt$mapNotNull$1"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
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
                        OfflinedReducer.Route.File file = (OfflinedReducer.Route.File) (!(obj instanceof OfflinedReducer.Route.File) ? null : obj);
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
        }, new NavigationRouter$initOfflinedNavigation$lambda$0$$inlined$switchEmbeddedScope$6(storeScope, orCreateKotlinClass2, navigationRouter$initOfflinedNavigation$2$3, null, this, store)), StoreKt.registerCoroutineScope(storeScope, CoroutineExtensionsKt.getChildScope(lifecycleScope2), KClassesJvm.getJvmName(orCreateKotlinClass2)));
        LifecycleUtilsKt.launchRepeatOnLifecycle(this.activity, Lifecycle.State.STARTED, new NavigationRouter$initOfflinedNavigation$2$5(storeScope, this, store, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void navigateToMainPhone(FolderModel folder) {
        this.launcher.launch(this.intentServices.mainPhoneActivityIntent(this.activity, folder.getItemId(), folder.getName(), 67108864));
    }
}
