package com.box.android.data.api.requests;

import androidx.core.provider.FontsContractCompat;
import com.box.android.data.api.utils.StreamingTag;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Tag;

/* JADX INFO: compiled from: PreviewDownloadRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\b\b\u0003\u0010\t\u001a\u00020\nH§@¢\u0006\u0002\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/PreviewDownloadRequest;", "", "downloadPreview", "Lokhttp3/ResponseBody;", "fileId", "", "version", "isPreview", "", "streaming", "Lcom/box/android/data/api/utils/StreamingTag;", "(Ljava/lang/String;Ljava/lang/String;ZLcom/box/android/data/api/utils/StreamingTag;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PreviewDownloadRequest {
    @Streaming
    @GET("files/{file_id}/content")
    Object downloadPreview(@Path(FontsContractCompat.Columns.FILE_ID) String str, @Query("version") String str2, @Query(BoxAnalyticsParams.CTA_PAGE_PREVIEW) boolean z, @Tag StreamingTag streamingTag, Continuation<? super ResponseBody> continuation);

    /* JADX INFO: compiled from: PreviewDownloadRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object downloadPreview$default(PreviewDownloadRequest previewDownloadRequest, String str, String str2, boolean z, StreamingTag streamingTag, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadPreview");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            streamingTag = StreamingTag.INSTANCE;
        }
        return previewDownloadRequest.downloadPreview(str, str3, z2, streamingTag, continuation);
    }
}
