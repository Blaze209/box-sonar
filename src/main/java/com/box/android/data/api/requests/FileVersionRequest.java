package com.box.android.data.api.requests;

import androidx.core.provider.FontsContractCompat;
import com.amplitude.api.Constants;
import com.box.android.data.api.models.fileversions.FileVersionDTOV2;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Path;

/* JADX INFO: compiled from: FileVersionRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/FileVersionRequest;", "", "getFileVersion", "Lcom/box/android/data/api/models/fileversions/FileVersionDTOV2;", "fileId", "", Constants.AMP_PLAN_VERSION_ID, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FileVersionRequest {
    @GET("files/{file_id}/versions/{version_id}?fields=id,name,version_number,created_at,modified_at,modified_by")
    Object getFileVersion(@Path(FontsContractCompat.Columns.FILE_ID) String str, @Path("version_id") String str2, Continuation<? super FileVersionDTOV2> continuation);
}
