package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.usecases.InteractionType;
import com.box.android.domain.utils.result.Result;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: IRecentsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH¦@¢\u0006\u0002\u0010\rJ(\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH¦@¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00050\u00030\u0012H&J\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H¦@¢\u0006\u0002\u0010\u0016¨\u0006\u0017À\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IRecentsService;", "", "addToRecents", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "remoteId", "Lcom/box/android/domain/models/ItemId$Remote;", "interactionType", "Lcom/box/android/domain/usecases/InteractionType;", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "", "password", "(Lcom/box/android/domain/models/ItemId$Remote;Lcom/box/android/domain/usecases/InteractionType;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/usecases/InteractionType;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recentItems", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/box/android/domain/models/item/ItemModel;", "fetchRecentItemsFromRemote", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IRecentsService {
    Object addToRecents(ItemId.Remote remote, InteractionType interactionType, String str, String str2, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object addToRecents(ItemId itemId, InteractionType interactionType, String str, Continuation<? super Unit> continuation);

    Object fetchRecentItemsFromRemote(Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Flow<Result<List<ItemModel>, DomainError>> recentItems();
}
