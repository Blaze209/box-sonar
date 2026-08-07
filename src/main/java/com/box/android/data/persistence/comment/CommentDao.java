package com.box.android.data.persistence.comment;

import com.box.android.data.persistence.annotations.CommentEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: CommentDao.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH'¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/comment/CommentDao;", "", "insertComment", "", "commentEntity", "Lcom/box/android/data/persistence/annotations/CommentEntity;", "(Lcom/box/android/data/persistence/annotations/CommentEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteComment", "commentId", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CommentDao {
    void deleteComment(String commentId);

    Object insertComment(CommentEntity commentEntity, Continuation<? super Unit> continuation);
}
