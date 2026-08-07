package com.box.android.data.datasource.items.interceptors;

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

/* JADX INFO: compiled from: GQLGetFolderItemsResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLGetFolderItemsResponseInterceptor$intercept$1$4", f = "GQLGetFolderItemsResponseInterceptor.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {96, 98}, m = "emit", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onSuccess$iv", "itemDTOs", "fetchedEdges", "$i$f$onSuccess", "$i$a$-onSuccess-GQLGetFolderItemsResponseInterceptor$intercept$1$4$1", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$onSuccess$iv", "itemDTOs", "fetchedEdges", "$i$f$onSuccess", "$i$a$-onSuccess-GQLGetFolderItemsResponseInterceptor$intercept$1$4$1"}, s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1", "L$0", "L$1", "L$3", "L$4", "I$0", "I$1"}, v = 1)
final class GQLGetFolderItemsResponseInterceptor$intercept$1$4$emit$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GQLGetFolderItemsResponseInterceptor.C11691.AnonymousClass4<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    GQLGetFolderItemsResponseInterceptor$intercept$1$4$emit$1(GQLGetFolderItemsResponseInterceptor.C11691.AnonymousClass4<? super T> anonymousClass4, Continuation<? super GQLGetFolderItemsResponseInterceptor$intercept$1$4$emit$1> continuation) {
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
