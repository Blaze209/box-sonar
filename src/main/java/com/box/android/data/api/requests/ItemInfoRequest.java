package com.box.android.data.api.requests;

import com.box.android.data.api.models.items.FileDTO;
import com.box.android.data.api.models.items.FolderDTO;
import com.box.android.data.api.models.items.WebLinkDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: ItemInfoRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0007J\"\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0007J\"\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0007¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/ItemInfoRequest;", "", "getFileInfo", "Lcom/box/android/data/api/models/items/FileDTO;", "id", "", "fields", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFolderInfo", "Lcom/box/android/data/api/models/items/FolderDTO;", "getWebLinkInfo", "Lcom/box/android/data/api/models/items/WebLinkDTO;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ItemInfoRequest {
    @GET("files/{id}")
    Object getFileInfo(@Path("id") String str, @Query("fields") String str2, Continuation<? super FileDTO> continuation);

    @GET("folders/{id}")
    Object getFolderInfo(@Path("id") String str, @Query("fields") String str2, Continuation<? super FolderDTO> continuation);

    @GET("web_links/{id}")
    Object getWebLinkInfo(@Path("id") String str, @Query("fields") String str2, Continuation<? super WebLinkDTO> continuation);
}
