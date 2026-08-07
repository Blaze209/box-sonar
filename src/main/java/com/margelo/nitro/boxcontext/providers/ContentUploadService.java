package com.margelo.nitro.boxcontext.providers;

import com.margelo.nitro.boxcontext.ItemIdentifier;
import com.margelo.nitro.boxcontext.PendingItemUpdate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ContentInfoProvider.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000bH&¨\u0006\r"}, d2 = {"Lcom/margelo/nitro/boxcontext/providers/ContentUploadService;", "", "startUpload", "Lkotlin/Function0;", "", "itemId", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "itemName", "", "uploadFolderId", "onUpdate", "Lkotlin/Function1;", "Lcom/margelo/nitro/boxcontext/PendingItemUpdate;", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ContentUploadService {
    Function0<Unit> startUpload(ItemIdentifier itemId, String itemName, String uploadFolderId, Function1<? super PendingItemUpdate, Unit> onUpdate);
}
