package com.margelo.nitro.com.nitromarkdown;

import com.box.android.observability.DiagnosisParams;
import com.facebook.jni.HybridData;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.margelo.nitro.core.HybridObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HybridMarkdownSessionSpec.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\nH'J\b\u0010\u0014\u001a\u00020\u0007H'J\b\u0010\u0015\u001a\u00020\nH'J\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H&J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u001aH\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u0082 R\u0012\u0010\u0004\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8g@gX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/margelo/nitro/com/nitromarkdown/HybridMarkdownSessionSpec;", "Lcom/margelo/nitro/core/HybridObject;", "<init>", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "updateNative", "", "hybridData", "toString", "", "value", "", "highlightPosition", "getHighlightPosition", "()D", "setHighlightPosition", "(D)V", "append", "chunk", DiagnosisParams.CLEAR_ON_LOGOUT, "getAllText", "addListener", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addListener_cxx", "Lcom/margelo/nitro/com/nitromarkdown/Func_void;", "initHybrid", "Companion", "react-native-nitro-markdown_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class HybridMarkdownSessionSpec extends HybridObject {
    protected static final String TAG = "HybridMarkdownSessionSpec";
    private HybridData mHybridData;

    private final native HybridData initHybrid();

    public abstract Function0<Unit> addListener(Function0<Unit> listener);

    public abstract void append(String chunk);

    public abstract void clear();

    public abstract String getAllText();

    public abstract double getHighlightPosition();

    public abstract void setHighlightPosition(double d);

    public HybridMarkdownSessionSpec() {
        HybridData hybridDataInitHybrid = initHybrid();
        this.mHybridData = hybridDataInitHybrid;
        super.updateNative(hybridDataInitHybrid);
    }

    @Override // com.margelo.nitro.core.HybridObject
    protected void updateNative(HybridData hybridData) {
        Intrinsics.checkNotNullParameter(hybridData, "hybridData");
        this.mHybridData = hybridData;
        super.updateNative(hybridData);
    }

    @Override // com.margelo.nitro.core.HybridObject
    public String toString() {
        return "[HybridObject MarkdownSession]";
    }

    private final Func_void addListener_cxx(Func_void listener) {
        return new Func_void_java(addListener(listener));
    }
}
