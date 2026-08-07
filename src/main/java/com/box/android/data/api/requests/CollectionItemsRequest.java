package com.box.android.data.api.requests;

import com.box.android.coreservices.jobmanager.jobs.BoxItemJob;
import com.box.android.data.api.models.collections.CollectionItemsDTO;
import com.box.android.data.api.models.collections.MembershipOperationDTO;
import com.box.android.data.api.models.collections.MembershipOperationsResultDTO;
import com.box.androidsdk.content.models.BoxIterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: compiled from: CollectionItemsRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\nJ(\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u00052\u000e\b\u0001\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH§@¢\u0006\u0002\u0010\u0011¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/CollectionItemsRequest;", "", "getCollectionItems", "Lcom/box/android/data/api/models/collections/CollectionItemsDTO;", "id", "", "itemFields", BoxIterator.FIELD_LIMIT, "", "marker", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCollection", "Lcom/box/android/data/api/models/collections/MembershipOperationsResultDTO;", BoxItemJob.COLLECTION_ID, "membershipOperationDTOList", "", "Lcom/box/android/data/api/models/collections/MembershipOperationDTO;", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CollectionItemsRequest {
    @GET("collections/{id}/items")
    Object getCollectionItems(@Path("id") String str, @Query("item_fields") String str2, @Query(BoxIterator.FIELD_LIMIT) Integer num, @Query("marker") String str3, Continuation<? super CollectionItemsDTO> continuation);

    @Headers({"Content-Type: application/vnd.box+json;version=v2", "Cookie: csrf-token=unused", "x-csrf-token: unused"})
    @PATCH("collections/{id}/items")
    Object updateCollection(@Path("id") String str, @Body List<MembershipOperationDTO> list, Continuation<? super MembershipOperationsResultDTO> continuation);

    /* JADX INFO: compiled from: CollectionItemsRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getCollectionItems$default(CollectionItemsRequest collectionItemsRequest, String str, String str2, Integer num, String str3, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCollectionItems");
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            num = 100;
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        return collectionItemsRequest.getCollectionItems(str, str2, num, str3, continuation);
    }
}
