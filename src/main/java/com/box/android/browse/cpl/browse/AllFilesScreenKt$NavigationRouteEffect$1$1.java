package com.box.android.browse.cpl.browse;

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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AllFilesScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.browse.cpl.browse.AllFilesScreenKt$NavigationRouteEffect$1$1", f = "AllFilesScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class AllFilesScreenKt$NavigationRouteEffect$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BrowseNavigator $navigator;
    final /* synthetic */ BrowseReducer.Route $route;
    final /* synthetic */ Store<BrowseReducer.State, BrowseReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AllFilesScreenKt$NavigationRouteEffect$1$1(BrowseReducer.Route route, BrowseNavigator browseNavigator, Store<BrowseReducer.State, BrowseReducer.Action> store, Continuation<? super AllFilesScreenKt$NavigationRouteEffect$1$1> continuation) {
        super(2, continuation);
        this.$route = route;
        this.$navigator = browseNavigator;
        this.$store = store;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AllFilesScreenKt$NavigationRouteEffect$1$1(this.$route, this.$navigator, this.$store, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AllFilesScreenKt$NavigationRouteEffect$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        final Store<BrowseReducer.State, BrowseReducer.Action> store = this.$store;
        Function0<Unit> function0 = new Function0() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$NavigationRouteEffect$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AllFilesScreenKt$NavigationRouteEffect$1$1.invokeSuspend$lambda$0(store);
            }
        };
        BrowseReducer.Route route = this.$route;
        if (route instanceof BrowseReducer.Route.Folder) {
            this.$navigator.navigateToWithCallback(new BrowseDestination.OuterDestination.Folder(((BrowseReducer.Route.Folder) this.$route).getState().getActionableItemsListState().getCurrentFolder()), function0);
        } else if (route instanceof BrowseReducer.Route.File) {
            this.$navigator.navigateToWithCallback(new BrowseDestination.OuterDestination.File(((BrowseReducer.Route.File) this.$route).getFile(), PreviewSource.Browse.INSTANCE), function0);
        } else if (route instanceof BrowseReducer.Route.WebLink) {
            this.$navigator.navigateToWithCallback(new BrowseDestination.OuterDestination.WebLink(((BrowseReducer.Route.WebLink) this.$route).getFile()), function0);
        } else if (route instanceof BrowseReducer.Route.FeatureBanner) {
            this.$navigator.navigateToWithCallback(new BrowseDestination.OuterDestination.FeatureBanner(((BrowseReducer.Route.FeatureBanner) this.$route).getData()), function0);
        } else if (route instanceof BrowseReducer.Route.InviteCollaborators) {
            this.$navigator.navigateToWithCallback(new BrowseDestination.OuterDestination.InviteCollaborators(((BrowseReducer.Route.InviteCollaborators) this.$route).getFolder()), function0);
        } else if (route instanceof BrowseReducer.Route.ItemAction) {
            ActionableItemsListNavigationKt.navigateActionableItemsList$default(this.$navigator, ((BrowseReducer.Route.ItemAction) route).getRoute(), this.$store.scope(new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.AllFilesScreenKt$NavigationRouteEffect$1$1.1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj2) {
                    return ((BrowseReducer.State) obj2).getActionableItemsListState();
                }
            }, AnonymousClass2.INSTANCE), null, BottomSheetAttributes.LaunchContext.BrowseAllFiles.INSTANCE, function0, 8, null);
        } else if (!Intrinsics.areEqual(route, BrowseReducer.Route.None.INSTANCE)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!Intrinsics.areEqual(this.$route, BrowseReducer.Route.None.INSTANCE)) {
            this.$store.send(BrowseReducer.Action.NavigationCompleted.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Store store) {
        store.send(BrowseReducer.Action.ChildScreenClosed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.box.android.browse.cpl.browse.AllFilesScreenKt$NavigationRouteEffect$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: AllFilesScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<ActionableItemsListReducer.Action, BrowseReducer.Action.ChildActionableItemsListAction> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1, BrowseReducer.Action.ChildActionableItemsListAction.class, "<init>", "<init>(Lcom/box/android/browse/cpl/itemsList/ActionableItemsListReducer$Action;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final BrowseReducer.Action.ChildActionableItemsListAction invoke(ActionableItemsListReducer.Action p0) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            return new BrowseReducer.Action.ChildActionableItemsListAction(p0);
        }
    }
}
