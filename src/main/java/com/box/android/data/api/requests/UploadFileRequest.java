package com.box.android.data.api.requests;

import com.box.android.data.api.models.items.ItemDTOFields;
import com.box.android.data.api.models.items.ItemsDTO;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: UploadFileRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000bJN\u0010\f\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\r\u001a\u00020\u00052\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0003\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/UploadFileRequest;", "", "uploadFile", "Lcom/box/android/data/api/models/items/ItemsDTO;", "accessToken", "", "attributesRequestBody", "Lokhttp3/RequestBody;", "uploadFileMultipartBodyPart", "Lokhttp3/MultipartBody$Part;", "fields", "(Ljava/lang/String;Lokhttp3/RequestBody;Lokhttp3/MultipartBody$Part;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadNewVersion", "fileId", "ifMatchEtag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;Lokhttp3/MultipartBody$Part;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface UploadFileRequest {
    @POST("content")
    @Multipart
    Object uploadFile(@Header("Authorization") String str, @Part(NativeAuthConstants.GrantType.ATTRIBUTES) RequestBody requestBody, @Part MultipartBody.Part part, @Query("fields") String str2, Continuation<? super ItemsDTO> continuation);

    @POST("{id}/content")
    @Multipart
    Object uploadNewVersion(@Header("Authorization") String str, @Path("id") String str2, @Header("If-Match") String str3, @Part(NativeAuthConstants.GrantType.ATTRIBUTES) RequestBody requestBody, @Part MultipartBody.Part part, @Query("fields") String str4, Continuation<? super ItemsDTO> continuation);

    /* JADX INFO: compiled from: UploadFileRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object uploadFile$default(UploadFileRequest uploadFileRequest, String str, RequestBody requestBody, MultipartBody.Part part, String str2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFile");
        }
        if ((i & 8) != 0) {
            str2 = ItemDTOFields.INSTANCE.getDEFAULT_ITEM_FIELDS();
        }
        return uploadFileRequest.uploadFile(str, requestBody, part, str2, continuation);
    }

    static /* synthetic */ Object uploadNewVersion$default(UploadFileRequest uploadFileRequest, String str, String str2, String str3, RequestBody requestBody, MultipartBody.Part part, String str4, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadNewVersion");
        }
        if ((i & 32) != 0) {
            str4 = ItemDTOFields.INSTANCE.getDEFAULT_ITEM_FIELDS();
        }
        return uploadFileRequest.uploadNewVersion(str, str2, str3, requestBody, part, str4, continuation);
    }
}
