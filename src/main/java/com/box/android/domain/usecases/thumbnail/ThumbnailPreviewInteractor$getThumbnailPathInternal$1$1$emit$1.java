package com.box.android.domain.usecases.thumbnail;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.utils.result.Result;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: ThumbnailPreviewInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.domain.usecases.thumbnail.ThumbnailPreviewInteractor$getThumbnailPathInternal$1$1", f = "ThumbnailPreviewInteractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {77, 79, 84}, m = "emit", n = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "updated", "sha1Changed", "watermarkedChanged", "canPreviewChanged", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "updated", "sha1Changed", "watermarkedChanged", "canPreviewChanged", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "updated", "path", "sha1Changed", "watermarkedChanged", "canPreviewChanged"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "L$2", "I$0", "I$1", "I$2"}, v = 1)
final class ThumbnailPreviewInteractor$getThumbnailPathInternal$1$1$emit$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThumbnailPreviewInteractor.AnonymousClass1.C01751<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ThumbnailPreviewInteractor$getThumbnailPathInternal$1$1$emit$1(ThumbnailPreviewInteractor.AnonymousClass1.C01751<? super T> c01751, Continuation<? super ThumbnailPreviewInteractor$getThumbnailPathInternal$1$1$emit$1> continuation) {
        super(continuation);
        this.this$0 = c01751;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((Result<? extends ItemModel, ? extends DomainError>) null, (Continuation<? super Unit>) this);
    }
}
