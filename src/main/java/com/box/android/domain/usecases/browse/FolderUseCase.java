package com.box.android.domain.usecases.browse;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.utils.result.Result;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: FolderViewUseCase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0002\u0010\tJ\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\f\u001a\u00020\bH¦@¢\u0006\u0002\u0010\t¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/usecases/browse/FolderUseCase;", "", "getFolderHierarchy", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/item/ItemModel;", "Lcom/box/android/domain/models/DomainError;", TypedValues.TransitionType.S_FROM, "Lcom/box/android/domain/models/ItemId$Remote;", "(Lcom/box/android/domain/models/ItemId$Remote;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFolder", "Lcom/box/android/domain/models/item/FolderModel;", "folderId", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FolderUseCase {
    Object getFolder(ItemId.Remote remote, Continuation<? super Result<FolderModel, ? extends DomainError>> continuation);

    Object getFolderHierarchy(ItemId.Remote remote, Continuation<? super Result<? extends List<? extends ItemModel>, ? extends DomainError>> continuation);
}
