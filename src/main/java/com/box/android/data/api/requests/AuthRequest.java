package com.box.android.data.api.requests;

import com.box.android.data.api.models.auth.AccessTokenDTO;
import com.box.android.data.api.utils.ApiConstants;
import com.microsoft.identity.common.java.dto.Credential;
import com.microsoft.identity.common.java.jwt.AbstractJwtRequest;
import com.microsoft.identity.common.java.providers.oauth2.TokenRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/* JADX INFO: compiled from: AuthRequest.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\bJ6\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u000bJ@\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u00052\b\b\u0003\u0010\u0010\u001a\u00020\u00052\b\b\u0003\u0010\u0007\u001a\u00020\u0005H§@¢\u0006\u0002\u0010\u0011J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0001\u0010\u0015\u001a\u00020\u0016H§@¢\u0006\u0002\u0010\u0017¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/box/android/data/api/requests/AuthRequest;", "", "authenticateAnonymously", "Lcom/box/android/data/api/models/auth/AccessTokenDTO;", "clientId", "", Credential.SerializedNames.SECRET, "grantType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticateUsingJWT", AbstractJwtRequest.ClaimNames.ASSERTION, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDownscopedTokenForSharedLink", "boxSharedLink", "token", "scope", "tokenType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticateWithMsal", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "body", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface AuthRequest {
    @FormUrlEncoded
    @POST(ApiConstants.TOKEN_ENDPOINT)
    Object authenticateAnonymously(@Field("client_id") String str, @Field("client_secret") String str2, @Field("grant_type") String str3, Continuation<? super AccessTokenDTO> continuation);

    @FormUrlEncoded
    @POST(ApiConstants.TOKEN_ENDPOINT)
    Object authenticateUsingJWT(@Field("client_id") String str, @Field("client_secret") String str2, @Field("grant_type") String str3, @Field(AbstractJwtRequest.ClaimNames.ASSERTION) String str4, Continuation<? super AccessTokenDTO> continuation);

    @POST("https://account.box.com/api/oauth2/authorize")
    Object authenticateWithMsal(@Body RequestBody requestBody, Continuation<? super Response<ResponseBody>> continuation);

    @FormUrlEncoded
    @POST(ApiConstants.TOKEN_ENDPOINT)
    Object getDownscopedTokenForSharedLink(@Field("box_shared_link") String str, @Field("subject_token") String str2, @Field("scope") String str3, @Field("subject_token_type") String str4, @Field("grant_type") String str5, Continuation<? super AccessTokenDTO> continuation);

    /* JADX INFO: compiled from: AuthRequest.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object authenticateAnonymously$default(AuthRequest authRequest, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: authenticateAnonymously");
        }
        if ((i & 4) != 0) {
            str3 = TokenRequest.GrantTypes.CLIENT_CREDENTIALS;
        }
        return authRequest.authenticateAnonymously(str, str2, str3, continuation);
    }

    static /* synthetic */ Object getDownscopedTokenForSharedLink$default(AuthRequest authRequest, String str, String str2, String str3, String str4, String str5, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDownscopedTokenForSharedLink");
        }
        if ((i & 8) != 0) {
            str4 = "urn:ietf:params:oauth:token-type:access_token";
        }
        String str6 = str4;
        if ((i & 16) != 0) {
            str5 = "urn:ietf:params:oauth:grant-type:token-exchange";
        }
        return authRequest.getDownscopedTokenForSharedLink(str, str2, str3, str6, str5, continuation);
    }
}
