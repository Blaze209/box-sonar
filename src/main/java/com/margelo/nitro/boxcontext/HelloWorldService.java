package com.margelo.nitro.boxcontext;

import com.margelo.nitro.boxcontext.providers.HelloWorldProvider;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HelloWorldService.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lcom/margelo/nitro/boxcontext/HelloWorldService;", "Lcom/margelo/nitro/boxcontext/HybridHelloWorldServiceSpec;", "<init>", "()V", "sayHello", "", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HelloWorldService extends HybridHelloWorldServiceSpec {
    /* JADX INFO: Access modifiers changed from: private */
    public static final HelloWorldProvider sayHello$lambda$0(BoxContext.Dependencies require) {
        Intrinsics.checkNotNullParameter(require, "$this$require");
        return require.getHelloWorldProvider();
    }

    @Override // com.margelo.nitro.boxcontext.HybridHelloWorldServiceSpec
    public String sayHello() {
        return ((HelloWorldProvider) BoxContext.INSTANCE.require(new Function1() { // from class: com.margelo.nitro.boxcontext.HelloWorldService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HelloWorldService.sayHello$lambda$0((BoxContext.Dependencies) obj);
            }
        })).sayHello();
    }
}
