package com.box.android.search.navigation.compose;

import com.box.android.domain.models.search.FilesSearchFilters;
import com.box.android.search.navigation.SearchDestination;
import com.box.android.search.navigation.SearchNavigator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SearchNavigationCompose.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/models/search/FilesSearchFilters;", "currentFilters"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.search.navigation.compose.SearchNavigationComposeKt$searchNavigationGraph$2$1$4$1", f = "SearchNavigationCompose.kt", i = {0}, l = {101}, m = "invokeSuspend", n = {"currentFilters"}, s = {"L$0"}, v = 1)
final class SearchNavigationComposeKt$searchNavigationGraph$2$1$4$1 extends SuspendLambda implements Function2<FilesSearchFilters, Continuation<? super FilesSearchFilters>, Object> {
    final /* synthetic */ SearchNavigator $navigator;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SearchNavigationComposeKt$searchNavigationGraph$2$1$4$1(SearchNavigator searchNavigator, Continuation<? super SearchNavigationComposeKt$searchNavigationGraph$2$1$4$1> continuation) {
        super(2, continuation);
        this.$navigator = searchNavigator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SearchNavigationComposeKt$searchNavigationGraph$2$1$4$1 searchNavigationComposeKt$searchNavigationGraph$2$1$4$1 = new SearchNavigationComposeKt$searchNavigationGraph$2$1$4$1(this.$navigator, continuation);
        searchNavigationComposeKt$searchNavigationGraph$2$1$4$1.L$0 = obj;
        return searchNavigationComposeKt$searchNavigationGraph$2$1$4$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(FilesSearchFilters filesSearchFilters, Continuation<? super FilesSearchFilters> continuation) {
        return ((SearchNavigationComposeKt$searchNavigationGraph$2$1$4$1) create(filesSearchFilters, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FilesSearchFilters filesSearchFilters = (FilesSearchFilters) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.L$0 = SpillingKt.nullOutSpilledVariable(filesSearchFilters);
        this.label = 1;
        Object objNavigateForResult = this.$navigator.navigateForResult(new SearchDestination.InnerDestination.Filters(filesSearchFilters), this);
        return objNavigateForResult == coroutine_suspended ? coroutine_suspended : objNavigateForResult;
    }
}
