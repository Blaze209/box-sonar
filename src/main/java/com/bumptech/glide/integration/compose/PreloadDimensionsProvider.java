package com.bumptech.glide.integration.compose;

import com.bumptech.glide.ListPreloader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Preload.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\rR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/bumptech/glide/integration/compose/PreloadDimensionsProvider;", "DataT", "", "Lcom/bumptech/glide/ListPreloader$PreloadSizeProvider;", "updatedData", "Lcom/bumptech/glide/integration/compose/PreloaderData;", "(Lcom/bumptech/glide/integration/compose/PreloaderData;)V", "getPreloadSize", "", "item", "adapterPosition", "", "perItemPosition", "(Ljava/lang/Object;II)[I", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PreloadDimensionsProvider<DataT> implements ListPreloader.PreloadSizeProvider<DataT> {
    private final PreloaderData<DataT> updatedData;

    public PreloadDimensionsProvider(PreloaderData<DataT> updatedData) {
        Intrinsics.checkNotNullParameter(updatedData, "updatedData");
        this.updatedData = updatedData;
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public int[] getPreloadSize(DataT item, int adapterPosition, int perItemPosition) {
        Intrinsics.checkNotNullParameter(item, "item");
        return PreloadKt.m13167toIntArrayuvyYCjk(this.updatedData.m13171getSizeNHjbRc());
    }
}
