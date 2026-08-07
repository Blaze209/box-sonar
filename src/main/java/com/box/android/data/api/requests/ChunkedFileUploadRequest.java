package com.box.android.data.api.requests;

import com.box.android.data.api.models.upload.ChunkedFileUploadDTO;
import com.box.android.data.api.models.upload.UploadFileChunkDTOWrapper;
import com.box.android.data.api.models.upload.UploadSessionArgsDTO;
import com.box.android.data.api.models.upload.UploadSessionDTO;
import com.box.android.data.api.utils.ApiConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Url;

/* JADX INFO: compiled from: ChunkedFileUploadRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0006J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\bH§@¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\bH§@¢\u0006\u0002\u0010\rJ2\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0001\u0010\u0014\u001a\u00020\b2\b\b\u0001\u0010\u0015\u001a\u00020\b2\b\b\u0001\u0010\u0016\u001a\u00020\u0017H§@¢\u0006\u0002\u0010\u0018J6\u0010\u0019\u001a\u00020\u001a2\b\b\u0001\u0010\u001b\u001a\u00020\b2\b\b\u0001\u0010\u001c\u001a\u00020\b2\b\b\u0001\u0010\u001d\u001a\u00020\b2\b\b\u0001\u0010\u001e\u001a\u00020\u0017H§@¢\u0006\u0002\u0010\u001f¨\u0006 À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/ChunkedFileUploadRequest;", "", "createUploadSession", "Lcom/box/android/data/api/models/upload/UploadSessionDTO;", "uploadSessionArgsDTO", "Lcom/box/android/data/api/models/upload/UploadSessionArgsDTO;", "(Lcom/box/android/data/api/models/upload/UploadSessionArgsDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "id", "", "(Ljava/lang/String;Lcom/box/android/data/api/models/upload/UploadSessionArgsDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadedChunks", "Lcom/box/android/data/api/models/upload/ChunkedFileUploadDTO;", "sessionId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "abortUpload", "", "abortUrl", "commitSession", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "commitUrl", "sha1", "requestBody", "Lokhttp3/RequestBody;", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadPart", "Lcom/box/android/data/api/models/upload/UploadFileChunkDTOWrapper;", "partUrl", "contentRange", "digest", "fileChunk", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ChunkedFileUploadRequest {
    @DELETE
    Object abortUpload(@Url String str, Continuation<? super Unit> continuation);

    @POST
    Object commitSession(@Url String str, @Header("digest") String str2, @Body RequestBody requestBody, Continuation<? super Response<ResponseBody>> continuation);

    @POST(ApiConstants.UPLOAD_SESSION_ENDPOINT)
    Object createUploadSession(@Body UploadSessionArgsDTO uploadSessionArgsDTO, Continuation<? super UploadSessionDTO> continuation);

    @POST("{id}/upload_sessions")
    Object createUploadSession(@Path("id") String str, @Body UploadSessionArgsDTO uploadSessionArgsDTO, Continuation<? super UploadSessionDTO> continuation);

    @PUT
    Object uploadPart(@Url String str, @Header("Content-Range") String str2, @Header("Digest") String str3, @Body RequestBody requestBody, Continuation<? super UploadFileChunkDTOWrapper> continuation);

    @GET("upload_sessions/{sessionId}/parts")
    Object uploadedChunks(@Path("sessionId") String str, Continuation<? super ChunkedFileUploadDTO> continuation);
}
