package com.box.android.data.persistence;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: ScannedDocumentPageDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH'J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tH§@¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\rH§@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H§@¢\u0006\u0002\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/ScannedDocumentPageDao;", "", "insertOrUpdateScannedDocumentPage", "", "scannedDocumentPage", "Lcom/box/android/data/persistence/ScannedDocumentPageEntity;", "(Lcom/box/android/data/persistence/ScannedDocumentPageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeScannedDocumentPages", "Lkotlinx/coroutines/flow/Flow;", "", "getScannedDocumentPages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllDocumentPages", "", "deletePage", "pageId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ScannedDocumentPageDao {
    Object deleteAllDocumentPages(Continuation<? super Unit> continuation);

    Object deletePage(int i, Continuation<? super Unit> continuation);

    Object getScannedDocumentPages(Continuation<? super List<ScannedDocumentPageEntity>> continuation);

    Object insertOrUpdateScannedDocumentPage(ScannedDocumentPageEntity scannedDocumentPageEntity, Continuation<? super Long> continuation);

    Flow<List<ScannedDocumentPageEntity>> observeScannedDocumentPages();
}
