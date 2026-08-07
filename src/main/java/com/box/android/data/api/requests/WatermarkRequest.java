package com.box.android.data.api.requests;

import androidx.core.provider.FontsContractCompat;
import com.box.android.data.api.models.watermark.ApplyWatermarkRequestDTO;
import com.box.android.data.api.models.watermark.WatermarkResponseDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/* JADX INFO: compiled from: WatermarkRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000bJ\"\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u0018\u0010\u000e\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000b¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/WatermarkRequest;", "", "applyWatermarkToFile", "Lcom/box/android/data/api/models/watermark/WatermarkResponseDTO;", "fileId", "", "body", "Lcom/box/android/data/api/models/watermark/ApplyWatermarkRequestDTO;", "(Ljava/lang/String;Lcom/box/android/data/api/models/watermark/ApplyWatermarkRequestDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeWatermarkFromFile", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyWatermarkToFolder", "folderId", "removeWatermarkFromFolder", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface WatermarkRequest {
    @PUT("files/{file_id}/watermark")
    Object applyWatermarkToFile(@Path(FontsContractCompat.Columns.FILE_ID) String str, @Body ApplyWatermarkRequestDTO applyWatermarkRequestDTO, Continuation<? super WatermarkResponseDTO> continuation);

    @PUT("folders/{folder_id}/watermark")
    Object applyWatermarkToFolder(@Path("folder_id") String str, @Body ApplyWatermarkRequestDTO applyWatermarkRequestDTO, Continuation<? super WatermarkResponseDTO> continuation);

    @DELETE("files/{file_id}/watermark")
    Object removeWatermarkFromFile(@Path(FontsContractCompat.Columns.FILE_ID) String str, Continuation<? super Unit> continuation);

    @DELETE("folders/{folder_id}/watermark")
    Object removeWatermarkFromFolder(@Path("folder_id") String str, Continuation<? super Unit> continuation);
}
