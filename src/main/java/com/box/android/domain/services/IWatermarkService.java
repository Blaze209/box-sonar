package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IWatermarkService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u000b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\bJ\"\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u000b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\b¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IWatermarkService;", "", "applyWatermarkToFile", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "fileId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeWatermarkFromFile", "applyWatermarkToFolder", "folderId", "removeWatermarkFromFolder", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IWatermarkService {
    Object applyWatermarkToFile(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object applyWatermarkToFolder(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object removeWatermarkFromFile(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object removeWatermarkFromFolder(ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation);
}
