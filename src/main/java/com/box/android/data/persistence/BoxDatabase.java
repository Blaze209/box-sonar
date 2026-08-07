package com.box.android.data.persistence;

import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import com.box.android.data.persistence.annotations.AnnotationsDao;
import com.box.android.data.persistence.annotations.FileActivityDao;
import com.box.android.data.persistence.capture.CaptureHistoryDao;
import com.box.android.data.persistence.comment.CommentDao;
import com.box.android.data.persistence.inboxnotifications.InboxNotificationDao;
import com.box.android.data.persistence.jobs.JobsDao;
import com.box.android.data.persistence.localItems.LocalItemsDao;
import com.box.android.data.persistence.offline.OfflineServiceDao;
import com.box.android.data.persistence.recentnotes.RecentNoteDao;
import com.box.android.data.persistence.representations.FileRepresentationsDao;
import com.box.android.data.persistence.sharedlink.SharedLinkCredentialsDao;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BoxDatabase.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0015H&J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u001bH&J,\u0010\u001c\u001a\u00020\u001d2\u001c\u0010\u001e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0 \u0012\u0006\u0012\u0004\u0018\u00010!0\u001fH\u0086@¢\u0006\u0002\u0010\"¨\u0006#"}, d2 = {"Lcom/box/android/data/persistence/BoxDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "annotationsDao", "Lcom/box/android/data/persistence/annotations/AnnotationsDao;", "commentDao", "Lcom/box/android/data/persistence/comment/CommentDao;", "fileActivityDao", "Lcom/box/android/data/persistence/annotations/FileActivityDao;", "scannedDocumentPagesDao", "Lcom/box/android/data/persistence/ScannedDocumentPageDao;", "captureHistoryDao", "Lcom/box/android/data/persistence/capture/CaptureHistoryDao;", "fileRepresentationsDao", "Lcom/box/android/data/persistence/representations/FileRepresentationsDao;", "jobsDao", "Lcom/box/android/data/persistence/jobs/JobsDao;", "localItemsDao", "Lcom/box/android/data/persistence/localItems/LocalItemsDao;", "sharedLinkCredentialsDao", "Lcom/box/android/data/persistence/sharedlink/SharedLinkCredentialsDao;", "offlineServiceDao", "Lcom/box/android/data/persistence/offline/OfflineServiceDao;", "inboxNotificationDao", "Lcom/box/android/data/persistence/inboxnotifications/InboxNotificationDao;", "recentNoteDao", "Lcom/box/android/data/persistence/recentnotes/RecentNoteDao;", "withTransactionWrapper", "", "lambda", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BoxDatabase extends RoomDatabase {
    public abstract AnnotationsDao annotationsDao();

    public abstract CaptureHistoryDao captureHistoryDao();

    public abstract CommentDao commentDao();

    public abstract FileActivityDao fileActivityDao();

    public abstract FileRepresentationsDao fileRepresentationsDao();

    public abstract InboxNotificationDao inboxNotificationDao();

    public abstract JobsDao jobsDao();

    public abstract LocalItemsDao localItemsDao();

    public abstract OfflineServiceDao offlineServiceDao();

    public abstract RecentNoteDao recentNoteDao();

    public abstract ScannedDocumentPageDao scannedDocumentPagesDao();

    public abstract SharedLinkCredentialsDao sharedLinkCredentialsDao();

    public final Object withTransactionWrapper(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super Unit> continuation) {
        Object objWithTransaction = RoomDatabaseKt.withTransaction(this, function1, continuation);
        return objWithTransaction == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithTransaction : Unit.INSTANCE;
    }
}
