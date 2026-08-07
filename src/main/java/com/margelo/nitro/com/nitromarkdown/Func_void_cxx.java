package com.margelo.nitro.com.nitromarkdown;

import com.facebook.jni.HybridData;
import dalvik.annotation.optimization.FastNative;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: compiled from: Func_void.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0013\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\bH\u0097\u0002J\t\u0010\t\u001a\u00020\bH\u0083 R\u0010\u0010\u0006\u001a\u00020\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/margelo/nitro/com/nitromarkdown/Func_void_cxx;", "Lcom/margelo/nitro/com/nitromarkdown/Func_void;", "hybridData", "Lcom/facebook/jni/HybridData;", "<init>", "(Lcom/facebook/jni/HybridData;)V", "mHybridData", "invoke", "", "invoke_cxx", "react-native-nitro-markdown_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Func_void_cxx implements Func_void {
    private final HybridData mHybridData;

    @FastNative
    private final native void invoke_cxx();

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    private Func_void_cxx(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    @Override // com.margelo.nitro.com.nitromarkdown.Func_void
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2() {
        invoke_cxx();
    }
}
