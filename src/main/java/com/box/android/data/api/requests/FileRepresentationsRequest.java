package com.box.android.data.api.requests;

import androidx.core.provider.FontsContractCompat;
import com.amplitude.api.Constants;
import com.box.android.data.api.models.RepresentationDTO;
import com.box.android.data.api.models.fileversions.FileVersionRepresentationsDTO;
import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.ItemDTOFields;
import com.box.android.data.api.utils.StreamingTag;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.androidsdk.content.models.BoxRepresentation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Tag;
import retrofit2.http.Url;

/* JADX INFO: compiled from: FileRepresentationsRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0007J,\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\t\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\nJ,\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\nJ\"\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u00052\b\b\u0003\u0010\u0012\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00162\b\b\u0001\u0010\u0017\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0018¨\u0006\u0019À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/FileRepresentationsRequest;", "", "getFileRepresentations", "Lcom/box/android/data/api/models/items/FileDTO;", "id", "", BoxAnalyticsParams.CTA_LOCATION_HEADER, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileWithRepresentations", "fields", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFileVersionRepresentations", "Lcom/box/android/data/api/models/fileversions/FileVersionRepresentationsDTO;", "fileId", Constants.AMP_PLAN_VERSION_ID, "downloadRepresentation", "Lokhttp3/ResponseBody;", "fileUrl", "streaming", "Lcom/box/android/data/api/utils/StreamingTag;", "(Ljava/lang/String;Lcom/box/android/data/api/utils/StreamingTag;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRepresentationInfo", "Lcom/box/android/data/api/models/RepresentationDTO;", "infoUrl", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FileRepresentationsRequest {
    @Streaming
    @GET
    Object downloadRepresentation(@Url String str, @Tag StreamingTag streamingTag, Continuation<? super ResponseBody> continuation);

    @GET("files/{id}?fields=representations")
    Object getFileRepresentations(@Path("id") String str, @Header(BoxRepresentation.REP_HINTS_HEADER) String str2, Continuation<? super FileDTO> continuation);

    @GET("files/{file_id}/versions/{version_id}?fields=name,representations,authenticated_download_url")
    Object getFileVersionRepresentations(@Path(FontsContractCompat.Columns.FILE_ID) String str, @Path("version_id") String str2, @Header(BoxRepresentation.REP_HINTS_HEADER) String str3, Continuation<? super FileVersionRepresentationsDTO> continuation);

    @GET("files/{id}")
    Object getFileWithRepresentations(@Path("id") String str, @Header(BoxRepresentation.REP_HINTS_HEADER) String str2, @Query("fields") String str3, Continuation<? super FileDTO> continuation);

    @GET
    Object getRepresentationInfo(@Url String str, Continuation<? super RepresentationDTO> continuation);

    /* JADX INFO: compiled from: FileRepresentationsRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getFileWithRepresentations$default(FileRepresentationsRequest fileRepresentationsRequest, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFileWithRepresentations");
        }
        if ((i & 4) != 0) {
            str3 = ItemDTOFields.INSTANCE.getALL_FILE_FIELDS_WITH_REPRESENTATIONS();
        }
        return fileRepresentationsRequest.getFileWithRepresentations(str, str2, str3, continuation);
    }

    static /* synthetic */ Object downloadRepresentation$default(FileRepresentationsRequest fileRepresentationsRequest, String str, StreamingTag streamingTag, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: downloadRepresentation");
        }
        if ((i & 2) != 0) {
            streamingTag = StreamingTag.INSTANCE;
        }
        return fileRepresentationsRequest.downloadRepresentation(str, streamingTag, continuation);
    }
}
