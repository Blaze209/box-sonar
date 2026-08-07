package com.box.android.data.api.requests;

import com.box.android.data.api.models.CollectionsDTO;
import com.box.android.data.api.models.collections.CollectionDTO;
import com.box.android.data.api.models.collections.CreateCollectionDTO;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* JADX INFO: compiled from: CollectionsRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\b\u001a\u00020\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0007H§@¢\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/CollectionsRequest;", "", "getCollections", "Lcom/box/android/data/api/models/CollectionsDTO;", BoxIterator.FIELD_LIMIT, "", "marker", "", "orderBy", "sort", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCollection", "Lcom/box/android/data/api/models/collections/CollectionDTO;", "body", "Lcom/box/android/data/api/models/collections/CreateCollectionDTO;", "(Lcom/box/android/data/api/models/collections/CreateCollectionDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CollectionsRequest {
    @Headers({"Content-Type: application/vnd.box+json;version=v2", "Cookie: csrf-token=unused", "x-csrf-token: unused"})
    @POST(BoxItem.FIELD_COLLECTIONS)
    Object createCollection(@Body CreateCollectionDTO createCollectionDTO, Continuation<? super CollectionDTO> continuation);

    @GET(BoxItem.FIELD_COLLECTIONS)
    Object getCollections(@Query(BoxIterator.FIELD_LIMIT) Integer num, @Query("marker") String str, @Query("order_by") String str2, @Query("sort") String str3, Continuation<? super CollectionsDTO> continuation);

    /* JADX INFO: compiled from: CollectionsRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getCollections$default(CollectionsRequest collectionsRequest, Integer num, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCollections");
        }
        if ((i & 1) != 0) {
            num = 100;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            str2 = "name";
        }
        if ((i & 8) != 0) {
            str3 = "asc";
        }
        String str4 = str2;
        return collectionsRequest.getCollections(num, str, str4, str3, continuation);
    }
}
