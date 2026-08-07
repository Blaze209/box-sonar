package com.bumptech.glide.integration.compose;

import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Preload.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0019\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bumptech/glide/integration/compose/PreloadModelProvider;", "DataT", "", "Lcom/bumptech/glide/ListPreloader$PreloadModelProvider;", "requestManager", "Lcom/bumptech/glide/RequestManager;", "data", "Lcom/bumptech/glide/integration/compose/PreloaderData;", "(Lcom/bumptech/glide/RequestManager;Lcom/bumptech/glide/integration/compose/PreloaderData;)V", "getPreloadItems", "", ViewProps.POSITION, "", "getPreloadRequestBuilder", "Lcom/bumptech/glide/RequestBuilder;", "item", "(Ljava/lang/Object;)Lcom/bumptech/glide/RequestBuilder;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PreloadModelProvider<DataT> implements ListPreloader.PreloadModelProvider<DataT> {
    private final PreloaderData<DataT> data;
    private final RequestManager requestManager;

    public PreloadModelProvider(RequestManager requestManager, PreloaderData<DataT> data) {
        Intrinsics.checkNotNullParameter(requestManager, "requestManager");
        Intrinsics.checkNotNullParameter(data, "data");
        this.requestManager = requestManager;
        this.data = data;
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadModelProvider
    public List<DataT> getPreloadItems(int position) {
        return CollectionsKt.mutableListOf(this.data.getDataAccessor().invoke(Integer.valueOf(position)));
    }

    @Override // com.bumptech.glide.ListPreloader.PreloadModelProvider
    public RequestBuilder<?> getPreloadRequestBuilder(DataT item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return this.data.preloadRequests(this.requestManager, item);
    }
}
