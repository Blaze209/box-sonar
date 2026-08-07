package com.box.android.data.api.requests;

import androidx.core.provider.FontsContractCompat;
import com.box.android.data.api.models.FileMetadataListDTO;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* JADX INFO: compiled from: FileMetadataRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000bJB\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\u0014\b\u0001\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000eH§@¢\u0006\u0002\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/FileMetadataRequest;", "", "removeFileMetadata", "", "fileId", "", "scope", "templateKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listFileMetadata", "Lcom/box/android/data/api/models/FileMetadataListDTO;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addFileMetadata", "body", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FileMetadataRequest {
    @POST("files/{file_id}/metadata/{scope}/{template_key}")
    Object addFileMetadata(@Path(FontsContractCompat.Columns.FILE_ID) String str, @Path("scope") String str2, @Path("template_key") String str3, @Body Map<String, String> map, Continuation<? super Unit> continuation);

    @GET("files/{file_id}/metadata")
    Object listFileMetadata(@Path(FontsContractCompat.Columns.FILE_ID) String str, Continuation<? super FileMetadataListDTO> continuation);

    @DELETE("files/{file_id}/metadata/{scope}/{template_key}")
    Object removeFileMetadata(@Path(FontsContractCompat.Columns.FILE_ID) String str, @Path("scope") String str2, @Path("template_key") String str3, Continuation<? super Unit> continuation);
}
