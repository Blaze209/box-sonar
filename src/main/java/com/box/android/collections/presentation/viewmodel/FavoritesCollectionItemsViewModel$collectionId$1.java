package com.box.android.collections.presentation.viewmodel;

import androidx.lifecycle.LiveDataScope;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: FavoritesCollectionItemsViewModel.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/lifecycle/LiveDataScope;", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel$collectionId$1", f = "FavoritesCollectionItemsViewModel.kt", i = {0, 1, 1}, l = {25, 26}, m = "invokeSuspend", n = {"$this$liveData", "$this$liveData", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$0", "L$1"}, v = 1)
final class FavoritesCollectionItemsViewModel$collectionId$1 extends SuspendLambda implements Function2<LiveDataScope<String>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ FavoritesCollectionItemsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FavoritesCollectionItemsViewModel$collectionId$1(FavoritesCollectionItemsViewModel favoritesCollectionItemsViewModel, Continuation<? super FavoritesCollectionItemsViewModel$collectionId$1> continuation) {
        super(2, continuation);
        this.this$0 = favoritesCollectionItemsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FavoritesCollectionItemsViewModel$collectionId$1 favoritesCollectionItemsViewModel$collectionId$1 = new FavoritesCollectionItemsViewModel$collectionId$1(this.this$0, continuation);
        favoritesCollectionItemsViewModel$collectionId$1.L$0 = obj;
        return favoritesCollectionItemsViewModel$collectionId$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(LiveDataScope<String> liveDataScope, Continuation<? super Unit> continuation) {
        return ((FavoritesCollectionItemsViewModel$collectionId$1) create(liveDataScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
    
        if (r0.emit(((com.box.android.domain.utils.result.Result.Success) r7).getValue(), r6) == r1) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.L$0
            androidx.lifecycle.LiveDataScope r0 = (androidx.lifecycle.LiveDataScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r6.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L26
            if (r2 == r4) goto L22
            if (r2 != r3) goto L1a
            java.lang.Object r6 = r6.L$1
            com.box.android.domain.utils.result.Result r6 = (com.box.android.domain.utils.result.Result) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L81
        L1a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L22:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L3d
        L26:
            kotlin.ResultKt.throwOnFailure(r7)
            com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel r7 = r6.this$0
            com.box.android.domain.usecases.collections.GetFavoritesCollectionIdUseCase r7 = com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel.access$getGetFavoritesCollectionIdUseCase$p(r7)
            r2 = r6
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r6.L$0 = r0
            r6.label = r4
            java.lang.Object r7 = r7.invoke(r2)
            if (r7 != r1) goto L3d
            goto L61
        L3d:
            com.box.android.domain.utils.result.Result r7 = (com.box.android.domain.utils.result.Result) r7
            boolean r2 = r7 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto L62
            r2 = r7
            com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
            java.lang.Object r2 = r2.getValue()
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r6.L$0 = r5
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r6.L$1 = r7
            r6.label = r3
            java.lang.Object r6 = r0.emit(r2, r4)
            if (r6 != r1) goto L81
        L61:
            return r1
        L62:
            boolean r0 = r7 instanceof com.box.android.domain.utils.result.Result.Error
            if (r0 == 0) goto L84
            com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel r0 = r6.this$0
            androidx.lifecycle.MutableLiveData r0 = com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel.access$get_errorLiveData(r0)
            com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel r6 = r6.this$0
            com.box.android.domain.utils.result.Result$Error r7 = (com.box.android.domain.utils.result.Result.Error) r7
            java.lang.Object r7 = r7.getValue()
            com.box.android.domain.models.DomainError r7 = (com.box.android.domain.models.DomainError) r7
            com.box.android.domain.models.DomainError r7 = com.box.android.domain.models.DomainErrorKt.unwrapCachedDomainError(r7)
            com.box.android.common.utilities.ErrorEvent r6 = r6.errorHelper(r7)
            r0.setValue(r6)
        L81:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L84:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.collections.presentation.viewmodel.FavoritesCollectionItemsViewModel$collectionId$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
