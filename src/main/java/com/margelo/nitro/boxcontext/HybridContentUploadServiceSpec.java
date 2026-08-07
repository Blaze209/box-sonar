package com.margelo.nitro.boxcontext;

import com.facebook.jni.HybridData;
import com.margelo.nitro.core.HybridObject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HybridContentUploadServiceSpec.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0014J\b\u0010\t\u001a\u00020\nH\u0016JI\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00070\u0012H&J(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0019H\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u0082 R\u0012\u0010\u0004\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/margelo/nitro/boxcontext/HybridContentUploadServiceSpec;", "Lcom/margelo/nitro/core/HybridObject;", "<init>", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "updateNative", "", "hybridData", "toString", "", "startUpload", "Lkotlin/Function0;", "itemId", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "itemName", "uploadFolderId", "onUpdate", "Lkotlin/Function1;", "Lcom/margelo/nitro/boxcontext/PendingItemUpdate;", "Lkotlin/ParameterName;", "name", "update", "startUpload_cxx", "Lcom/margelo/nitro/boxcontext/Func_void;", "Lcom/margelo/nitro/boxcontext/Func_void_PendingItemUpdate;", "initHybrid", "Companion", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class HybridContentUploadServiceSpec extends HybridObject {
    protected static final String TAG = "HybridContentUploadServiceSpec";
    private HybridData mHybridData;

    private final native HybridData initHybrid();

    public abstract Function0<Unit> startUpload(ItemIdentifier itemId, String itemName, String uploadFolderId, Function1<? super PendingItemUpdate, Unit> onUpdate);

    public HybridContentUploadServiceSpec() {
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
        return "[HybridObject ContentUploadService]";
    }

    private final Func_void startUpload_cxx(ItemIdentifier itemId, String itemName, String uploadFolderId, Func_void_PendingItemUpdate onUpdate) {
        return new Func_void_java(startUpload(itemId, itemName, uploadFolderId, onUpdate));
    }
}
