package com.box.android.data.persistence.capture;

import com.box.android.domain.models.ItemId;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: CaptureHistoryDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\u0016\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000fJ\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0012H§@¢\u0006\u0002\u0010\u0013J\u0014\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00160\u0015H'J\u000e\u0010\u0017\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0018¨\u0006\u001aÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/capture/CaptureHistoryDao;", "", "updateLastUpdatedDate", "", "itemId", "Lcom/box/android/domain/models/ItemId$Local;", "currentDate", "Ljava/util/Date;", "(Lcom/box/android/domain/models/ItemId$Local;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCaptureHistoryItem", "captureHistoryItemEntity", "Lcom/box/android/data/persistence/capture/CaptureHistoryItemEntity;", "(Lcom/box/android/data/persistence/capture/CaptureHistoryItemEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCaptureHistoryItem", "deleteCaptureHistoryForId", "(Lcom/box/android/domain/models/ItemId$Local;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLocalIdForServerId", "serverId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCaptureHistory", "Lkotlinx/coroutines/flow/Flow;", "", "truncateDb", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CaptureHistoryDao {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    Object deleteCaptureHistoryForId(ItemId.Local local, Continuation<? super Unit> continuation);

    Flow<List<CaptureHistoryItemEntity>> getCaptureHistory();

    Object getLocalIdForServerId(String str, Continuation<? super ItemId.Local> continuation);

    Object insertCaptureHistoryItem(CaptureHistoryItemEntity captureHistoryItemEntity, Continuation<? super Unit> continuation);

    Object truncateDb(Continuation<? super Unit> continuation);

    Object updateCaptureHistoryItem(CaptureHistoryItemEntity captureHistoryItemEntity, Continuation<? super Unit> continuation);

    Object updateLastUpdatedDate(ItemId.Local local, Date date, Continuation<? super Unit> continuation);

    /* JADX INFO: compiled from: CaptureHistoryDao.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/box/android/data/persistence/capture/CaptureHistoryDao$Companion;", "", "<init>", "()V", "MAX_NUM_OF_CAPTURE_HISTORY_ITEM", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final int MAX_NUM_OF_CAPTURE_HISTORY_ITEM = 2000;

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: CaptureHistoryDao.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object updateLastUpdatedDate$default(CaptureHistoryDao captureHistoryDao, ItemId.Local local, Date date, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLastUpdatedDate");
        }
        if ((i & 2) != 0) {
            date = new Date();
        }
        return captureHistoryDao.updateLastUpdatedDate(local, date, continuation);
    }
}
