package com.box.android.data.api.requests;

import com.box.android.data.api.interceptors.auth.SharedLinkAuthInterceptor;
import com.box.android.data.api.models.AddToRecentsDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/* JADX INFO: compiled from: RecentsRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007H§@¢\u0006\u0002\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/RecentsRequest;", "", "addToRecents", "", "body", "Lcom/box/android/data/api/models/AddToRecentsDTO;", "sharedlink", "", "(Lcom/box/android/data/api/models/AddToRecentsDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface RecentsRequest {
    @POST("undoc/recent_items")
    Object addToRecents(@Body AddToRecentsDTO addToRecentsDTO, @Header(SharedLinkAuthInterceptor.HEADER_AUTH_SHARED_LINK) String str, Continuation<? super Unit> continuation);
}
