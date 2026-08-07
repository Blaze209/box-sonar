package com.box.android.data.api.requests;

import com.box.android.data.api.models.PreflightCheckDTO;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.HTTP;
import retrofit2.http.Header;
import retrofit2.http.Path;

/* JADX INFO: compiled from: PreflightCheckRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ.\u0010\u0002\u001a\u00020\u00032\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/PreflightCheckRequest;", "", "performPreflightCheck", "", "accessToken", "", "preflightCheckDTO", "Lcom/box/android/data/api/models/PreflightCheckDTO;", "(Ljava/lang/String;Lcom/box/android/data/api/models/PreflightCheckDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "id", "(Ljava/lang/String;Ljava/lang/String;Lcom/box/android/data/api/models/PreflightCheckDTO;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface PreflightCheckRequest {
    @HTTP(hasBody = true, method = "OPTIONS", path = "content")
    Object performPreflightCheck(@Header("Authorization") String str, @Body PreflightCheckDTO preflightCheckDTO, Continuation<? super Unit> continuation);

    @HTTP(hasBody = true, method = "OPTIONS", path = "{id}/content")
    Object performPreflightCheck(@Header("Authorization") String str, @Path("id") String str2, @Body PreflightCheckDTO preflightCheckDTO, Continuation<? super Unit> continuation);
}
