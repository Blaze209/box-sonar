package com.margelo.nitro.boxcontext.providers;

import com.margelo.nitro.boxcontext.ItemIdentifier;
import com.margelo.nitro.boxcontext.ItemInfo;
import com.margelo.nitro.boxcontext.ItemStatus;
import com.margelo.nitro.boxcontext.PickerConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: HostNavigationDelegate.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Jf\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072:\u0010\b\u001a6\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH¦@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/margelo/nitro/boxcontext/providers/HostNavigationDelegate;", "", "showContentPicker", "", "Lcom/margelo/nitro/boxcontext/ItemInfo;", "currentItems", "config", "Lcom/margelo/nitro/boxcontext/PickerConfig;", "getItemsStatus", "Lkotlin/Function3;", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "Lkotlin/coroutines/Continuation;", "Lcom/margelo/nitro/boxcontext/ItemStatus;", "(Ljava/util/List;Lcom/margelo/nitro/boxcontext/PickerConfig;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showPreview", "", "item", "(Lcom/margelo/nitro/boxcontext/ItemInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface HostNavigationDelegate {
    Object showContentPicker(List<ItemInfo> list, PickerConfig pickerConfig, Function3<? super List<ItemIdentifier>, ? super List<ItemIdentifier>, ? super Continuation<? super List<ItemStatus>>, ? extends Object> function3, Continuation<? super List<ItemInfo>> continuation);

    Object showPreview(ItemInfo itemInfo, Continuation<? super Unit> continuation);
}
