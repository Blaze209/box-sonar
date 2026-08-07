package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import sdk.pendo.io.events.IdentificationData;

/* JADX INFO: compiled from: ILegacyBridgeService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\"\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000bH¦@¢\u0006\u0002\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/ILegacyBridgeService;", "", "save", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "boxItem", "Lcom/box/androidsdk/content/models/BoxItem;", "(Lcom/box/androidsdk/content/models/BoxItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delete", "itemId", "", "itemType", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveUploadedItemToGQLCache", "deleteItemFromGQLCache", IdentificationData.FIELD_PARENT_ID, "(Lcom/box/androidsdk/content/models/BoxItem;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ILegacyBridgeService {
    Object delete(String str, String str2, Continuation<? super Unit> continuation);

    Object deleteItemFromGQLCache(BoxItem boxItem, String str, Continuation<? super Unit> continuation);

    Object save(BoxItem boxItem, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object saveUploadedItemToGQLCache(BoxItem boxItem, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: ILegacyBridgeService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object deleteItemFromGQLCache$default(ILegacyBridgeService iLegacyBridgeService, BoxItem boxItem, String str, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteItemFromGQLCache");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return iLegacyBridgeService.deleteItemFromGQLCache(boxItem, str, continuation);
    }
}
