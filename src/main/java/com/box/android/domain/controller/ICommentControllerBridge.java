package com.box.android.domain.controller;

import com.box.android.domain.models.ItemId;
import com.box.androidsdk.content.models.BoxIteratorCollaborators;
import com.box.androidsdk.content.requests.BoxResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ICommentControllerBridge.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/controller/ICommentControllerBridge;", "", "fetchCollaboratorsSync", "Lcom/box/androidsdk/content/requests/BoxResponse;", "Lcom/box/androidsdk/content/models/BoxIteratorCollaborators;", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ICommentControllerBridge {
    Object fetchCollaboratorsSync(ItemId itemId, Continuation<? super BoxResponse<BoxIteratorCollaborators>> continuation);
}
