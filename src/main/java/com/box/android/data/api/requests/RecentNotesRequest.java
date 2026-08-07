package com.box.android.data.api.requests;

import com.box.android.data.api.models.items.ItemDTOFields;
import com.box.android.data.api.models.recentnotes.RecentNotesIteratorDTO;
import com.box.androidsdk.content.models.BoxIterator;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: compiled from: RecentNotesRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J8\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00052\b\b\u0003\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/RecentNotesRequest;", "", "getRecentNotes", "Lcom/box/android/data/api/models/recentnotes/RecentNotesIteratorDTO;", "listType", "", "fields", BoxIterator.FIELD_LIMIT, "", "marker", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RecentNotesRequest {
    @GET("recent_items")
    Object getRecentNotes(@Query("list_type") String str, @Query("fields") String str2, @Query(BoxIterator.FIELD_LIMIT) int i, @Query("marker") String str3, Continuation<? super RecentNotesIteratorDTO> continuation);

    /* JADX INFO: compiled from: RecentNotesRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getRecentNotes$default(RecentNotesRequest recentNotesRequest, String str, String str2, int i, String str3, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRecentNotes");
        }
        if ((i2 & 1) != 0) {
            str = "notes.by_opened_time";
        }
        if ((i2 & 2) != 0) {
            str2 = ItemDTOFields.INSTANCE.getDEFAULT_ITEM_FIELDS();
        }
        if ((i2 & 4) != 0) {
            i = 100;
        }
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        int i3 = i;
        return recentNotesRequest.getRecentNotes(str, str2, i3, str3, continuation);
    }
}
