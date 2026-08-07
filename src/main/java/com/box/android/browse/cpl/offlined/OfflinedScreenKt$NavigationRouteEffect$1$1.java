package com.box.android.browse.cpl.offlined;

import com.box.android.base.presentation.fragments.models.BottomSheetAttributes;
import com.box.android.browse.cpl.itemsList.ActionableItemsListNavigationKt;
import com.box.android.browse.cpl.itemsList.ActionableItemsListReducer;
import com.box.android.browse.cpl.navigationmodernization.BrowseDestination;
import com.box.android.browse.cpl.navigationmodernization.BrowseNavigator;
import com.box.android.cpl.Store;
import com.box.android.domain.models.preview.PreviewSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: OfflinedScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.offlined.OfflinedScreenKt$NavigationRouteEffect$1$1", f = "OfflinedScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class OfflinedScreenKt$NavigationRouteEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BrowseNavigator $navigator;
    final /* synthetic */ OfflinedReducer.Route $route;
    final /* synthetic */ Store<OfflinedReducer.State, OfflinedReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OfflinedScreenKt$NavigationRouteEffect$1$1(OfflinedReducer.Route route, BrowseNavigator browseNavigator, Store<OfflinedReducer.State, OfflinedReducer.Action> store, Continuation<? super OfflinedScreenKt$NavigationRouteEffect$1$1> continuation) {
        super(2, continuation);
        this.$route = route;
        this.$navigator = browseNavigator;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OfflinedScreenKt$NavigationRouteEffect$1$1(this.$route, this.$navigator, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OfflinedScreenKt$NavigationRouteEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        OfflinedReducer.Route route = this.$route;
        if (route instanceof OfflinedReducer.Route.Folder) {
            this.$navigator.navigateTo(new BrowseDestination.OuterDestination.Folder(((OfflinedReducer.Route.Folder) this.$route).getState().getActionableItemsListState().getCurrentFolder()));
        } else if (route instanceof OfflinedReducer.Route.File) {
            this.$navigator.navigateTo(new BrowseDestination.OuterDestination.File(((OfflinedReducer.Route.File) this.$route).getFile(), PreviewSource.Offline.INSTANCE));
        } else if (route instanceof OfflinedReducer.Route.ItemAction) {
            ActionableItemsListNavigationKt.navigateActionableItemsList$default(this.$navigator, ((OfflinedReducer.Route.ItemAction) route).getRoute(), this.$store.scope(new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.offlined.OfflinedScreenKt$NavigationRouteEffect$1$1.1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj2) {
                    return ((OfflinedReducer.State) obj2).getActionableItemsListState();
                }
            }, AnonymousClass2.INSTANCE), null, BottomSheetAttributes.LaunchContext.BrowseOfflined.INSTANCE, null, 40, null);
        } else if (!Intrinsics.areEqual(route, OfflinedReducer.Route.None.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!Intrinsics.areEqual(this.$route, OfflinedReducer.Route.None.INSTANCE)) {
            this.$store.send(OfflinedReducer.Action.NavigationCompleted.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.offlined.OfflinedScreenKt$NavigationRouteEffect$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: OfflinedScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ActionableItemsListReducer.Action, OfflinedReducer.Action.ChildActionableItemsListAction> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1, OfflinedReducer.Action.ChildActionableItemsListAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final OfflinedReducer.Action.ChildActionableItemsListAction invoke(ActionableItemsListReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new OfflinedReducer.Action.ChildActionableItemsListAction(p0);
        }
    }
}
