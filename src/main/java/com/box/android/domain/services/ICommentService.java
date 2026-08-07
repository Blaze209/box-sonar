package com.box.android.domain.services;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.annotations.CommentContent;
import com.box.android.domain.models.annotations.FileActivityIdModel;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: ICommentService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\tJ*\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH¦@¢\u0006\u0002\u0010\rJ2\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0011J>\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0016J\"\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0013\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0019J2\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u001bJ\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0013\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0019¨\u0006\u001dÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/ICommentService;", "", "createComment", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/annotations/FileActivityModel$CommentModel;", "Lcom/box/android/domain/models/DomainError;", "fileId", "", "message", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCommentV2", "content", "Lcom/box/android/domain/models/annotations/CommentContent;", "(Ljava/lang/String;Lcom/box/android/domain/models/annotations/CommentContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createReply", "parentIdModel", "Lcom/box/android/domain/models/annotations/FileActivityIdModel;", "(Ljava/lang/String;Lcom/box/android/domain/models/annotations/FileActivityIdModel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateComment", "commentId", "status", "Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/annotations/FileActivityModel$Status;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteComment", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCommentV2", "(Ljava/lang/String;Lcom/box/android/domain/models/annotations/CommentContent;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCommentV2", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ICommentService {
    Object createComment(String str, String str2, Continuation<? super Result<FileActivityModel.CommentModel, ? extends DomainError>> continuation);

    Object createCommentV2(String str, CommentContent commentContent, Continuation<? super Result<FileActivityModel.CommentModel, ? extends DomainError>> continuation);

    Object createReply(String str, FileActivityIdModel fileActivityIdModel, String str2, Continuation<? super Result<FileActivityModel.CommentModel, ? extends DomainError>> continuation);

    Object deleteComment(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object deleteCommentV2(String str, Continuation<? super Result<Unit, ? extends DomainError>> continuation);

    Object updateComment(String str, String str2, FileActivityModel.Status status, String str3, Continuation<? super Result<FileActivityModel.CommentModel, ? extends DomainError>> continuation);

    Object updateCommentV2(String str, CommentContent commentContent, String str2, Continuation<? super Result<FileActivityModel.CommentModel, ? extends DomainError>> continuation);
}
