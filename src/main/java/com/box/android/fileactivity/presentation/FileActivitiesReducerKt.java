package com.box.android.fileactivity.presentation;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.fileactivity.R;
import kotlin.Metadata;

/* JADX INFO: compiled from: FileActivitiesReducer.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¨\u0006\u0006"}, d2 = {"getCommentSubmissionErrorMessageRes", "", "error", "Lcom/box/android/domain/models/DomainError;", "getErrorMessageRes", "defaultErrorRes", "file-activity_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileActivitiesReducerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final int getCommentSubmissionErrorMessageRes(DomainError domainError) {
        if (domainError instanceof DomainError.APIResourceConflict) {
            return R.string.box_commentsdk_Duplicate_comment_error;
        }
        return R.string.Error_posting_comment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getErrorMessageRes(DomainError domainError, int i) {
        return DomainErrorKt.isNetworkConnectionError(domainError) ? R.string.check_connection_try_again : i;
    }
}
