package com.box.android.data.api.requests;

import com.box.android.data.api.models.items.ItemsDTO;
import com.box.androidsdk.content.models.BoxIterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: FolderItemsRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001JR\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\r¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/FolderItemsRequest;", "", "getFolderItems", "Lcom/box/android/data/api/models/items/ItemsDTO;", "folderId", "", "fields", "offset", "", BoxIterator.FIELD_LIMIT, "", "sort", "direction", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FolderItemsRequest {
    @GET("folders/{folder_id}/items")
    Object getFolderItems(@Path("folder_id") String str, @Query("fields") String str2, @Query("offset") Long l, @Query(BoxIterator.FIELD_LIMIT) Integer num, @Query("sort") String str3, @Query("direction") String str4, Continuation<? super ItemsDTO> continuation);

    /* JADX INFO: compiled from: FolderItemsRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getFolderItems$default(FolderItemsRequest folderItemsRequest, String str, String str2, Long l, Integer num, String str3, String str4, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getFolderItems");
        }
        if ((i & 4) != 0) {
            l = 0L;
        }
        Long l2 = l;
        if ((i & 8) != 0) {
            num = 100;
        }
        return folderItemsRequest.getFolderItems(str, str2, l2, num, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, continuation);
    }
}
