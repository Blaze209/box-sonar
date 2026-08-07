package com.bumptech.glide.integration.compose;

import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [DataT] */
/* JADX INFO: compiled from: Preload.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* synthetic */ class PreloadKt$rememberGlidePreloadingData$2<DataT> extends FunctionReferenceImpl implements Function1<Integer, DataT> {
    PreloadKt$rememberGlidePreloadingData$2(Object obj) {
        super(1, obj, List.class, PasskeyWebListener.GET_UNIQUE_KEY, "get(I)Ljava/lang/Object;", 0);
    }

    public final DataT invoke(int i) {
        return (DataT) ((List) this.receiver).get(i);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }
}
