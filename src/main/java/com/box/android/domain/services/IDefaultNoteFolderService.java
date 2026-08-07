package com.box.android.domain.services;

import com.box.android.domain.models.DefaultNoteFolderResult;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IDefaultNoteFolderService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H¦@¢\u0006\u0002\u0010\u0006J\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\t\u001a\u00020\nH¦@¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\bH&¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IDefaultNoteFolderService;", "", "getOrCreateDefaultNoteFolder", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/DefaultNoteFolderResult;", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDefaultNoteFolder", "", "folderId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCache", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IDefaultNoteFolderService {
    void clearCache();

    Object getOrCreateDefaultNoteFolder(Continuation<? super Result<? extends DefaultNoteFolderResult, ? extends DomainError>> continuation);

    Object setDefaultNoteFolder(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation);
}
