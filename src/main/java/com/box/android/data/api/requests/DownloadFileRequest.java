package com.box.android.data.api.requests;

import androidx.core.provider.FontsContractCompat;
import com.box.android.data.api.interceptors.auth.SharedLinkAuthInterceptor;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/* JADX INFO: compiled from: DownloadFileRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\u0007J.\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/DownloadFileRequest;", "", "downloadFile", "Lokhttp3/ResponseBody;", "fileId", "", "sharedLinkHeader", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFileChunk", "byteRange", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DownloadFileRequest {
    @GET("files/{file_id}/content")
    Object downloadFile(@Path(FontsContractCompat.Columns.FILE_ID) String str, @Header(SharedLinkAuthInterceptor.HEADER_AUTH_SHARED_LINK) String str2, Continuation<? super ResponseBody> continuation);

    @GET("files/{file_id}/content")
    Object downloadFileChunk(@Path(FontsContractCompat.Columns.FILE_ID) String str, @Header("range") String str2, @Header(SharedLinkAuthInterceptor.HEADER_AUTH_SHARED_LINK) String str3, Continuation<? super ResponseBody> continuation);

    /* JADX INFO: compiled from: DownloadFileRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object downloadFile$default(DownloadFileRequest downloadFileRequest, String str, String str2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadFile");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return downloadFileRequest.downloadFile(str, str2, continuation);
    }

    static /* synthetic */ Object downloadFileChunk$default(DownloadFileRequest downloadFileRequest, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadFileChunk");
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return downloadFileRequest.downloadFileChunk(str, str2, str3, continuation);
    }
}
