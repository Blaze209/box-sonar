package com.box.android.domain.utils.result;

import androidx.exifinterface.media.ExifInterface;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ResultProgressWrapper.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u00020\u0004B1\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\u001a\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b0\u0006¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\u0007\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/box/android/domain/utils/result/ResultProgressWrapper;", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LONGITUDE_EAST, "P", "", "progress", "Lkotlinx/coroutines/flow/Flow;", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/box/android/domain/utils/result/Result;", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;)V", "getProgress", "()Lkotlinx/coroutines/flow/Flow;", "getResult", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ResultProgressWrapper<T, E, P> {
    private final Flow<P> progress;
    private final Flow<Result<T, E>> result;

    /* JADX WARN: Multi-variable type inference failed */
    public ResultProgressWrapper(Flow<? extends P> progress, Flow<? extends Result<? extends T, ? extends E>> result) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        Intrinsics.checkNotNullParameter(result, "result");
        this.progress = progress;
        this.result = result;
    }

    public final Flow<P> getProgress() {
        return this.progress;
    }

    public final Flow<Result<T, E>> getResult() {
        return this.result;
    }
}
