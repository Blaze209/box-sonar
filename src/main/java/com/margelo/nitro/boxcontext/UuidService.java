package com.margelo.nitro.boxcontext;

import com.margelo.nitro.boxcontext.providers.UuidProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UuidService.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/margelo/nitro/boxcontext/UuidService;", "Lcom/margelo/nitro/boxcontext/HybridUuidServiceSpec;", "<init>", "()V", "generateUuid", "", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UuidService extends HybridUuidServiceSpec {
    /* JADX INFO: Access modifiers changed from: private */
    public static final UuidProvider generateUuid$lambda$0(BoxContext.Dependencies require) {
        Intrinsics.checkNotNullParameter(require, "$this$require");
        return require.getUuidProvider();
    }

    @Override // com.margelo.nitro.boxcontext.HybridUuidServiceSpec
    public String generateUuid() {
        return ((UuidProvider) BoxContext.INSTANCE.require(new Function1() { // from class: com.margelo.nitro.boxcontext.UuidService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UuidService.generateUuid$lambda$0((BoxContext.Dependencies) obj);
            }
        })).generateUuid();
    }
}
