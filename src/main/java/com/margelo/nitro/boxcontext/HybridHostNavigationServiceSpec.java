package com.margelo.nitro.boxcontext;

import com.facebook.jni.HybridData;
import com.margelo.nitro.core.HybridObject;
import com.margelo.nitro.core.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HybridHostNavigationServiceSpec.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0014J\b\u0010\t\u001a\u00020\nH\u0016J\u0087\u0001\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00122N\u0010\u0013\u001aJ\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\r0\f0\u0014H&¢\u0006\u0002\u0010\u001bJ?\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010\u000f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u001dH\u0003¢\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u000eH'J\t\u0010!\u001a\u00020\u0005H\u0082 R\u0012\u0010\u0004\u001a\u00020\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/margelo/nitro/boxcontext/HybridHostNavigationServiceSpec;", "Lcom/margelo/nitro/core/HybridObject;", "<init>", "()V", "mHybridData", "Lcom/facebook/jni/HybridData;", "updateNative", "", "hybridData", "toString", "", "openContentPicker", "Lcom/margelo/nitro/core/Promise;", "", "Lcom/margelo/nitro/boxcontext/ItemInfo;", "recipientId", "currentItems", "config", "Lcom/margelo/nitro/boxcontext/PickerConfig;", "getItemsStatus", "Lkotlin/Function2;", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "Lkotlin/ParameterName;", "name", "selectedItemIds", "itemIds", "Lcom/margelo/nitro/boxcontext/ItemStatus;", "(Ljava/lang/String;[Lcom/margelo/nitro/boxcontext/ItemInfo;Lcom/margelo/nitro/boxcontext/PickerConfig;Lkotlin/jvm/functions/Function2;)Lcom/margelo/nitro/core/Promise;", "openContentPicker_cxx", "Lcom/margelo/nitro/boxcontext/Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier_;", "(Ljava/lang/String;[Lcom/margelo/nitro/boxcontext/ItemInfo;Lcom/margelo/nitro/boxcontext/PickerConfig;Lcom/margelo/nitro/boxcontext/Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier_;)Lcom/margelo/nitro/core/Promise;", "openPreview", "item", "initHybrid", "Companion", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class HybridHostNavigationServiceSpec extends HybridObject {
    protected static final String TAG = "HybridHostNavigationServiceSpec";
    private HybridData mHybridData;

    private final native HybridData initHybrid();

    public abstract Promise<ItemInfo[]> openContentPicker(String recipientId, ItemInfo[] currentItems, PickerConfig config, Function2<? super ItemIdentifier[], ? super ItemIdentifier[], Promise<ItemStatus[]>> getItemsStatus);

    public abstract Promise<Unit> openPreview(String recipientId, ItemInfo item);

    public HybridHostNavigationServiceSpec() {
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
        return "[HybridObject HostNavigationService]";
    }

    private final Promise<ItemInfo[]> openContentPicker_cxx(String recipientId, ItemInfo[] currentItems, PickerConfig config, Func_std__shared_ptr_Promise_std__vector_ItemStatus____std__vector_ItemIdentifier__std__vector_ItemIdentifier_ getItemsStatus) {
        return openContentPicker(recipientId, currentItems, config, getItemsStatus);
    }
}
