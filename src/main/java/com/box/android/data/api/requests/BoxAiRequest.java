package com.box.android.data.api.requests;

import com.box.android.data.api.models.boxai.AiCreateSessionDTO;
import com.box.android.data.api.models.boxai.AiCreateSessionRequestDTO;
import com.box.android.data.api.models.boxai.AiGetAnswerStreamingRequestDTO;
import com.box.android.data.api.models.boxai.AiPermissionDTO;
import com.box.android.data.api.utils.StreamingTag;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Streaming;
import retrofit2.http.Tag;

/* JADX INFO: compiled from: BoxAiRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\f2\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005H§@¢\u0006\u0002\u0010\rJ.\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u00112\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0003\u0010\u0012\u001a\u00020\u0013H§@¢\u0006\u0002\u0010\u0014¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/BoxAiRequest;", "", "getPermission", "Lcom/box/android/data/api/models/boxai/AiPermissionDTO;", "id", "", "type", "authorization", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSession", "Lcom/box/android/data/api/models/boxai/AiCreateSessionDTO;", "createSessionDTO", "Lcom/box/android/data/api/models/boxai/AiCreateSessionRequestDTO;", "(Lcom/box/android/data/api/models/boxai/AiCreateSessionRequestDTO;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnswerStreaming", "Lokhttp3/ResponseBody;", "getAnswerStreamingRequestDTO", "Lcom/box/android/data/api/models/boxai/AiGetAnswerStreamingRequestDTO;", "streaming", "Lcom/box/android/data/api/utils/StreamingTag;", "(Lcom/box/android/data/api/models/boxai/AiGetAnswerStreamingRequestDTO;Ljava/lang/String;Lcom/box/android/data/api/utils/StreamingTag;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface BoxAiRequest {
    @POST("createSession")
    Object createSession(@Body AiCreateSessionRequestDTO aiCreateSessionRequestDTO, @Header("Authorization") String str, Continuation<? super AiCreateSessionDTO> continuation);

    @Headers({"Content-Type: application/vnd.box+json;version=2"})
    @Streaming
    @POST("getAnswerStreaming")
    Object getAnswerStreaming(@Body AiGetAnswerStreamingRequestDTO aiGetAnswerStreamingRequestDTO, @Header("Authorization") String str, @Tag StreamingTag streamingTag, Continuation<? super ResponseBody> continuation);

    @GET("getPermission")
    Object getPermission(@Query("id") String str, @Query("type") String str2, @Header("Authorization") String str3, Continuation<? super AiPermissionDTO> continuation);

    /* JADX INFO: compiled from: BoxAiRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getPermission$default(BoxAiRequest boxAiRequest, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPermission");
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        return boxAiRequest.getPermission(str, str2, str3, continuation);
    }

    static /* synthetic */ Object createSession$default(BoxAiRequest boxAiRequest, AiCreateSessionRequestDTO aiCreateSessionRequestDTO, String str, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createSession");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        return boxAiRequest.createSession(aiCreateSessionRequestDTO, str, continuation);
    }

    static /* synthetic */ Object getAnswerStreaming$default(BoxAiRequest boxAiRequest, AiGetAnswerStreamingRequestDTO aiGetAnswerStreamingRequestDTO, String str, StreamingTag streamingTag, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAnswerStreaming");
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            streamingTag = StreamingTag.INSTANCE;
        }
        return boxAiRequest.getAnswerStreaming(aiGetAnswerStreamingRequestDTO, str, streamingTag, continuation);
    }
}
