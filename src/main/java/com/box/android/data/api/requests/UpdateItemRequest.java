package com.box.android.data.api.requests;

import androidx.core.provider.FontsContractCompat;
import com.box.android.data.api.models.UpdateItemDTO;
import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.WebLinkDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: UpdateItemRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ,\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ,\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ,\u0010\u0010\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ,\u0010\u0011\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\tJ,\u0010\u0012\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH§@¢\u0006\u0002\u0010\t¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/UpdateItemRequest;", "", "copyFolder", "Lcom/box/android/data/api/models/items/FolderDTO;", "folderId", "", "fields", "body", "Lcom/box/android/data/api/models/UpdateItemDTO;", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/UpdateItemDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "copyFile", "Lcom/box/android/data/api/models/items/FileDTO;", "fileId", "copyWeblink", "Lcom/box/android/data/api/models/items/WebLinkDTO;", "weblinkId", "moveFolder", "moveFile", "moveWeblink", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface UpdateItemRequest {
    @POST("files/{file_id}/copy")
    Object copyFile(@Path(FontsContractCompat.Columns.FILE_ID) String str, @Query("fields") String str2, @Body UpdateItemDTO updateItemDTO, Continuation<? super FileDTO> continuation);

    @POST("folders/{folder_id}/copy")
    Object copyFolder(@Path("folder_id") String str, @Query("fields") String str2, @Body UpdateItemDTO updateItemDTO, Continuation<? super FolderDTO> continuation);

    @POST("web_links/{web_link_id}/copy")
    Object copyWeblink(@Path("web_link_id") String str, @Query("fields") String str2, @Body UpdateItemDTO updateItemDTO, Continuation<? super WebLinkDTO> continuation);

    @PUT("files/{file_id}")
    Object moveFile(@Path(FontsContractCompat.Columns.FILE_ID) String str, @Query("fields") String str2, @Body UpdateItemDTO updateItemDTO, Continuation<? super FileDTO> continuation);

    @PUT("folders/{folder_id}")
    Object moveFolder(@Path("folder_id") String str, @Query("fields") String str2, @Body UpdateItemDTO updateItemDTO, Continuation<? super FolderDTO> continuation);

    @PUT("web_links/{web_link_id}")
    Object moveWeblink(@Path("web_link_id") String str, @Query("fields") String str2, @Body UpdateItemDTO updateItemDTO, Continuation<? super WebLinkDTO> continuation);
}
