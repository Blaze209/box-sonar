package com.box.android.data.api.requests;

import com.box.android.data.api.models.ClientSettingsDTO;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Header;

/* JADX INFO: compiled from: ClientSettingsRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/ClientSettingsRequest;", "", "getClientSettings", "Lcom/box/android/data/api/models/ClientSettingsDTO;", "accessToken", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ClientSettingsRequest {
    @GET("apps/me/settings")
    Object getClientSettings(@Header("Authorization") String str, Continuation<? super ClientSettingsDTO> continuation);
}
