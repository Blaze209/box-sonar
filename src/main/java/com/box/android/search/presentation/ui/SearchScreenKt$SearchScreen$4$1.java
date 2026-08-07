package com.box.android.search.presentation.ui;

import androidx.compose.runtime.State;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.search.FilesSearchFilters;
import com.box.android.search.presentation.cpl.FilesSearchReducer;
import com.box.android.search.presentation.cpl.SearchReducer;
import external.sdk.pendo.io.mozilla.javascript.Token;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: SearchScreen.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.search.presentation.ui.SearchScreenKt$SearchScreen$4$1", f = "SearchScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SearchScreenKt$SearchScreen$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FilesSearchReducer.State $filesSearchState;
    final /* synthetic */ LifecycleCoroutineScope $lifecycleScope;
    final /* synthetic */ Function2<String, String, Unit> $onOpenAiCenter;
    final /* synthetic */ Function2<FilesSearchFilters, Continuation<? super FilesSearchFilters>, Object> $onOpenFilesFiltersForResult;
    final /* synthetic */ Function1<String, Unit> $onOpenHub;
    final /* synthetic */ Function2<ItemModel, String, Unit> $onOpenItem;
    final /* synthetic */ Function1<ItemModel, Unit> $onOpenItemMoreActionsMenu;
    final /* synthetic */ State<SearchReducer.State> $state$delegate;
    final /* synthetic */ Store<SearchReducer.State, SearchReducer.Action> $store;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SearchScreenKt$SearchScreen$4$1(Function2<? super ItemModel, ? super String, Unit> function2, Function1<? super ItemModel, Unit> function1, Function1<? super String, Unit> function3, Function2<? super FilesSearchFilters, ? super Continuation<? super FilesSearchFilters>, ? extends Object> function4, FilesSearchReducer.State state, LifecycleCoroutineScope lifecycleCoroutineScope, Function2<? super String, ? super String, Unit> function5, Store<SearchReducer.State, SearchReducer.Action> store, State<SearchReducer.State> state2, Continuation<? super SearchScreenKt$SearchScreen$4$1> continuation) {
        super(2, continuation);
        this.$onOpenItem = function2;
        this.$onOpenItemMoreActionsMenu = function1;
        this.$onOpenHub = function3;
        this.$onOpenFilesFiltersForResult = function4;
        this.$filesSearchState = state;
        this.$lifecycleScope = lifecycleCoroutineScope;
        this.$onOpenAiCenter = function5;
        this.$store = store;
        this.$state$delegate = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SearchScreenKt$SearchScreen$4$1(this.$onOpenItem, this.$onOpenItemMoreActionsMenu, this.$onOpenHub, this.$onOpenFilesFiltersForResult, this.$filesSearchState, this.$lifecycleScope, this.$onOpenAiCenter, this.$store, this.$state$delegate, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SearchScreenKt$SearchScreen$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SearchReducer.SearchRoute route = SearchScreenKt.SearchScreen$lambda$1(this.$state$delegate).getRoute();
            if (!(route instanceof SearchReducer.SearchRoute.None)) {
                if (route instanceof SearchReducer.SearchRoute.OpenItem) {
                    Function2<ItemModel, String, Unit> function2 = this.$onOpenItem;
                    if (function2 != null) {
                        SearchReducer.SearchRoute.OpenItem openItem = (SearchReducer.SearchRoute.OpenItem) route;
                        function2.invoke(openItem.getItem(), openItem.getAccessibleSharedLink());
                    }
                } else if (route instanceof SearchReducer.SearchRoute.OpenItemMoreActionsMenu) {
                    Function1<ItemModel, Unit> function1 = this.$onOpenItemMoreActionsMenu;
                    if (function1 != null) {
                        function1.invoke(((SearchReducer.SearchRoute.OpenItemMoreActionsMenu) route).getItem());
                    }
                } else if (route instanceof SearchReducer.SearchRoute.HubDetails) {
                    Function1<String, Unit> function3 = this.$onOpenHub;
                    if (function3 != null) {
                        function3.invoke(((SearchReducer.SearchRoute.HubDetails) route).getHubId());
                    }
                } else if (route instanceof SearchReducer.SearchRoute.FilesFilters) {
                    if (this.$onOpenFilesFiltersForResult != null) {
                        FilesSearchReducer.State state = this.$filesSearchState;
                        if ((state != null ? state.getFilters() : null) != null) {
                            BuildersKt__Builders_commonKt.launch$default(this.$lifecycleScope, null, null, new AnonymousClass1(this.$onOpenFilesFiltersForResult, this.$filesSearchState, this.$store, null), 3, null);
                        }
                    }
                } else {
                    if (!(route instanceof SearchReducer.SearchRoute.AiCenter)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    SearchReducer.SearchRoute.AiCenter aiCenter = (SearchReducer.SearchRoute.AiCenter) route;
                    this.$onOpenAiCenter.invoke(aiCenter.getSessionId(), aiCenter.getInitialPrompt());
                }
            }
            this.$store.send(SearchReducer.Action.SearchRouteHandled.INSTANCE);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: com.box.android.search.presentation.ui.SearchScreenKt$SearchScreen$4$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchScreen.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.search.presentation.ui.SearchScreenKt$SearchScreen$4$1$1", f = "SearchScreen.kt", i = {}, l = {Token.DOTDOT}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FilesSearchReducer.State $filesSearchState;
        final /* synthetic */ Function2<FilesSearchFilters, Continuation<? super FilesSearchFilters>, Object> $onOpenFilesFiltersForResult;
        final /* synthetic */ Store<SearchReducer.State, SearchReducer.Action> $store;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function2<? super FilesSearchFilters, ? super Continuation<? super FilesSearchFilters>, ? extends Object> function2, FilesSearchReducer.State state, Store<SearchReducer.State, SearchReducer.Action> store, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$onOpenFilesFiltersForResult = function2;
            this.$filesSearchState = state;
            this.$store = store;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$onOpenFilesFiltersForResult, this.$filesSearchState, this.$store, continuation);
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
                Function2<FilesSearchFilters, Continuation<? super FilesSearchFilters>, Object> function2 = this.$onOpenFilesFiltersForResult;
                FilesSearchFilters filters = this.$filesSearchState.getFilters();
                this.label = 1;
                obj = function2.invoke(filters, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            FilesSearchFilters filesSearchFilters = (FilesSearchFilters) obj;
            if (filesSearchFilters != null) {
                this.$store.send(new SearchReducer.Action.FilesSearch(new FilesSearchReducer.Action.UpdateFilters(filesSearchFilters)));
            }
            return Unit.INSTANCE;
        }
    }
}
