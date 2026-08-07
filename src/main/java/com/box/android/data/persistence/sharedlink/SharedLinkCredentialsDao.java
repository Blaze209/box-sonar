package com.box.android.data.persistence.sharedlink;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: SharedLinkCredentialsDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH§@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/sharedlink/SharedLinkCredentialsDao;", "", "insertSharedLinkCredentials", "", "sharedlinkCredential", "Lcom/box/android/data/persistence/sharedlink/SharedlinkCredentialEntity;", "(Lcom/box/android/data/persistence/sharedlink/SharedlinkCredentialEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSharedLinkCredential", "fileId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SharedLinkCredentialsDao {
    Object getSharedLinkCredential(String str, Continuation<? super SharedlinkCredentialEntity> continuation);

    Object insertSharedLinkCredentials(SharedlinkCredentialEntity sharedlinkCredentialEntity, Continuation<? super Unit> continuation);
}
