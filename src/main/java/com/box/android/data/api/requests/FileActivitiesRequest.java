package com.box.android.data.api.requests;

import com.box.android.data.api.models.annotations.FileActivitiesDTO;
import com.box.androidsdk.content.models.BoxIterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: FileActivitiesRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u000b\u001a\u00020\fH§@¢\u0006\u0002\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/FileActivitiesRequest;", "", "getActivities", "Lcom/box/android/data/api/models/annotations/FileActivitiesDTO;", "fileId", "", BoxIterator.FIELD_LIMIT, "", "marker", "replyLimit", "types", "enableReplies", "", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FileActivitiesRequest {
    @GET("file_activities/{fileId}")
    Object getActivities(@Path("fileId") String str, @Query(BoxIterator.FIELD_LIMIT) Integer num, @Query("marker") String str2, @Query("reply_limit") Integer num2, @Query("activity_types") String str3, @Query("enable_replies") boolean z, Continuation<? super FileActivitiesDTO> continuation);

    /* JADX INFO: compiled from: FileActivitiesRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getActivities$default(FileActivitiesRequest fileActivitiesRequest, String str, Integer num, String str2, Integer num2, String str3, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getActivities");
        }
        if ((i & 2) != 0) {
            num = 100;
        }
        return fileActivitiesRequest.getActivities(str, num, (i & 4) != 0 ? null : str2, num2, (i & 16) != 0 ? null : str3, z, continuation);
    }
}
