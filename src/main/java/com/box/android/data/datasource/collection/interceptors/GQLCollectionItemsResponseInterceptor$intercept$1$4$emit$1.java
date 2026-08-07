package com.box.android.data.datasource.collection.interceptors;

import com.box.android.data.api.models.items.IItemDTO;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: GQLCollectionItemsResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.collection.interceptors.GQLCollectionItemsResponseInterceptor$intercept$1$4", f = "GQLCollectionItemsResponseInterceptor.kt", i = {0, 0}, l = {98}, m = "emit", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "fetched"}, s = {"L$0", "L$1"}, v = 1)
final class GQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GQLCollectionItemsResponseInterceptor.C11321.AnonymousClass4<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    GQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1(GQLCollectionItemsResponseInterceptor.C11321.AnonymousClass4<? super T> anonymousClass4, Continuation<? super GQLCollectionItemsResponseInterceptor$intercept$1$4$emit$1> continuation) {
        super(continuation);
        this.this$0 = anonymousClass4;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Result<? extends List<? extends IItemDTO>, ? extends RemoteError>) null, (Continuation<? super Unit>) this);
    }
}
