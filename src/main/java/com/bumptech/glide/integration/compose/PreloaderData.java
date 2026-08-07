package com.bumptech.glide.integration.compose;

import android.graphics.drawable.Drawable;
import androidx.compose.ui.geometry.Size;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Preload.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002Bz\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006\u0012L\u0010\u0007\u001aH\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\bj\b\u0012\u0004\u0012\u00028\u0000`\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\t\u0010\u001c\u001a\u00020\u0004HÆ\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003JO\u0010\u001e\u001aH\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\bj\b\u0012\u0004\u0012\u00028\u0000`\u000fHÆ\u0003J\u0019\u0010\u001f\u001a\u00020\u0011HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u001aJ\u0096\u0001\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u00062N\b\u0002\u0010\u0007\u001aH\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\bj\b\u0012\u0004\u0012\u00028\u0000`\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010'\u001a\u00020\u0004HÖ\u0001J!\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010+J\t\u0010,\u001a\u00020-HÖ\u0001R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016RW\u0010\u0007\u001aH\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\r0\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\bj\b\u0012\u0004\u0012\u00028\u0000`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006."}, d2 = {"Lcom/bumptech/glide/integration/compose/PreloaderData;", "DataT", "", "dataSize", "", "dataAccessor", "Lkotlin/Function1;", "requestBuilderTransform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "item", "Lcom/bumptech/glide/RequestBuilder;", "Landroid/graphics/drawable/Drawable;", "requestBuilder", "Lcom/bumptech/glide/integration/compose/PreloadRequestBuilderTransform;", "size", "Landroidx/compose/ui/geometry/Size;", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDataAccessor", "()Lkotlin/jvm/functions/Function1;", "getDataSize", "()I", "getRequestBuilderTransform", "()Lkotlin/jvm/functions/Function2;", "getSize-NH-jbRc", "()J", "J", "component1", "component2", "component3", "component4", "component4-NH-jbRc", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-Ug5Nnss", "(ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;J)Lcom/bumptech/glide/integration/compose/PreloaderData;", "equals", "", "other", "hashCode", "preloadRequests", "requestManager", "Lcom/bumptech/glide/RequestManager;", "(Lcom/bumptech/glide/RequestManager;Ljava/lang/Object;)Lcom/bumptech/glide/RequestBuilder;", "toString", "", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final /* data */ class PreloaderData<DataT> {
    private final Function1<Integer, DataT> dataAccessor;
    private final int dataSize;
    private final Function2<DataT, RequestBuilder<Drawable>, RequestBuilder<Drawable>> requestBuilderTransform;
    private final long size;

    public /* synthetic */ PreloaderData(int i, Function1 function1, Function2 function2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, function1, function2, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-Ug5Nnss$default, reason: not valid java name */
    public static /* synthetic */ PreloaderData m13168copyUg5Nnss$default(PreloaderData preloaderData, int i, Function1 function1, Function2 function2, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = preloaderData.dataSize;
        }
        if ((i2 & 2) != 0) {
            function1 = preloaderData.dataAccessor;
        }
        if ((i2 & 4) != 0) {
            function2 = preloaderData.requestBuilderTransform;
        }
        if ((i2 & 8) != 0) {
            j = preloaderData.size;
        }
        Function2 function3 = function2;
        return preloaderData.m13170copyUg5Nnss(i, function1, function3, j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getDataSize() {
        return this.dataSize;
    }

    public final Function1<Integer, DataT> component2() {
        return this.dataAccessor;
    }

    public final Function2<DataT, RequestBuilder<Drawable>, RequestBuilder<Drawable>> component3() {
        return this.requestBuilderTransform;
    }

    /* JADX INFO: renamed from: component4-NH-jbRc, reason: not valid java name and from getter */
    public final long getSize() {
        return this.size;
    }

    /* JADX INFO: renamed from: copy-Ug5Nnss, reason: not valid java name */
    public final PreloaderData<DataT> m13170copyUg5Nnss(int dataSize, Function1<? super Integer, ? extends DataT> dataAccessor, Function2<? super DataT, ? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> requestBuilderTransform, long size) {
        Intrinsics.checkNotNullParameter(dataAccessor, "dataAccessor");
        Intrinsics.checkNotNullParameter(requestBuilderTransform, "requestBuilderTransform");
        return new PreloaderData<>(dataSize, dataAccessor, requestBuilderTransform, size, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreloaderData)) {
            return false;
        }
        PreloaderData preloaderData = (PreloaderData) other;
        return this.dataSize == preloaderData.dataSize && Intrinsics.areEqual(this.dataAccessor, preloaderData.dataAccessor) && Intrinsics.areEqual(this.requestBuilderTransform, preloaderData.requestBuilderTransform) && Size.m6634equalsimpl0(this.size, preloaderData.size);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.dataSize) * 31) + this.dataAccessor.hashCode()) * 31) + this.requestBuilderTransform.hashCode()) * 31) + Size.m6639hashCodeimpl(this.size);
    }

    public String toString() {
        return "PreloaderData(dataSize=" + this.dataSize + ", dataAccessor=" + this.dataAccessor + ", requestBuilderTransform=" + this.requestBuilderTransform + ", size=" + ((Object) Size.m6642toStringimpl(this.size)) + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PreloaderData(int i, Function1<? super Integer, ? extends DataT> dataAccessor, Function2<? super DataT, ? super RequestBuilder<Drawable>, ? extends RequestBuilder<Drawable>> requestBuilderTransform, long j) {
        Intrinsics.checkNotNullParameter(dataAccessor, "dataAccessor");
        Intrinsics.checkNotNullParameter(requestBuilderTransform, "requestBuilderTransform");
        this.dataSize = i;
        this.dataAccessor = dataAccessor;
        this.requestBuilderTransform = requestBuilderTransform;
        this.size = j;
    }

    public final int getDataSize() {
        return this.dataSize;
    }

    public final Function1<Integer, DataT> getDataAccessor() {
        return this.dataAccessor;
    }

    public final Function2<DataT, RequestBuilder<Drawable>, RequestBuilder<Drawable>> getRequestBuilderTransform() {
        return this.requestBuilderTransform;
    }

    /* JADX INFO: renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m13171getSizeNHjbRc() {
        return this.size;
    }

    public final RequestBuilder<Drawable> preloadRequests(RequestManager requestManager, DataT item) {
        Intrinsics.checkNotNullParameter(requestManager, "requestManager");
        Function2<DataT, RequestBuilder<Drawable>, RequestBuilder<Drawable>> function2 = this.requestBuilderTransform;
        RequestBuilder<Drawable> requestBuilderAsDrawable = requestManager.asDrawable();
        Intrinsics.checkNotNullExpressionValue(requestBuilderAsDrawable, "requestManager.asDrawable()");
        return function2.invoke(item, requestBuilderAsDrawable);
    }
}
