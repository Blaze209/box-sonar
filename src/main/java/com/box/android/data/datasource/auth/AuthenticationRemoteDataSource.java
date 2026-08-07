package com.box.android.data.datasource.auth;

import android.util.Base64;
import com.box.android.base.presentation.activities.BoxIntuneMAMAuthActivityKt;
import com.box.android.data.api.models.JWTAuthInfo;
import com.box.android.data.api.models.auth.AccessTokenDTO;
import com.box.android.data.api.requests.AuthRequest;
import com.box.android.data.api.utils.ApiConstants;
import com.box.android.data.constants.AppConstants;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.ObservabilityRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.service.impl.AppRestrictionsManager;
import com.box.android.domain.services.IBVEManager;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.auth.OAuthWebView;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.microsoft.identity.common.java.dto.Credential;
import com.squareup.moshi.Moshi;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchGroup;
import kotlin.text.MatchGroupCollection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.lang.JoseException;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: compiled from: AuthenticationRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 *2\u00020\u0001:\u0001*B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0013J4\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0017J\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0011H\u0002J2\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0017J\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\"H\u0014J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0011H\u0016J\b\u0010&\u001a\u00020\u0011H\u0007J\u0012\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/box/android/data/datasource/auth/AuthenticationRemoteDataSource;", "", "authRequest", "Lcom/box/android/data/api/requests/AuthRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "appRestrictionsManager", "Lcom/box/android/data/service/impl/AppRestrictionsManager;", "bveManager", "Lcom/box/android/domain/services/IBVEManager;", "<init>", "(Lcom/box/android/data/api/requests/AuthRequest;Lcom/squareup/moshi/Moshi;Lcom/box/android/data/service/impl/AppRestrictionsManager;Lcom/box/android/domain/services/IBVEManager;)V", "authenticateAnonymously", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/auth/AccessTokenDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "clientId", "", Credential.SerializedNames.SECRET, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "authenticateWithMsal", "externalToken", BoxIntuneMAMAuthActivityKt.CODE_CHALLENGE_EXTRA, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildMsalRequestBody", "Lokhttp3/RequestBody;", "getCodeFromHtmlBody", "body", "authenticateWithJWT", "jwtAssertion", "createJWT", "authInfo", "Lcom/box/android/data/api/models/JWTAuthInfo;", "createJWS", "Lorg/jose4j/jws/JsonWebSignature;", "createEncodedPrivateKey", "Ljava/security/Key;", "privateKeyPem", "createAuthenticationUrl", "detectAndSetEnterpriseDomain", "", "host", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class AuthenticationRemoteDataSource {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String JWT_GRANT = "urn:ietf:params:oauth:grant-type:jwt-bearer";

    @Deprecated
    public static final String JWT_TOKEN_TYPE_NAME = "JWT";

    @Deprecated
    public static final String PEM_RSA_FOOTER = "-----END PRIVATE KEY-----";

    @Deprecated
    public static final String PEM_RSA_HEADER = "-----BEGIN PRIVATE KEY-----";

    @Deprecated
    public static final String PUBLIC_KEY_ID = "kid";

    @Deprecated
    public static final String RSA_ALGORITHM = "RSA";

    @Deprecated
    public static final String SUBJECT_TYPE_KEY = "box_sub_type";

    @Deprecated
    public static final String TOKEN_TYPE_KEY = "typ";
    private final AppRestrictionsManager appRestrictionsManager;
    private final AuthRequest authRequest;
    private final IBVEManager bveManager;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.auth.AuthenticationRemoteDataSource$authenticateAnonymously$1, reason: invalid class name */
    /* JADX INFO: compiled from: AuthenticationRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.auth.AuthenticationRemoteDataSource", f = "AuthenticationRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {60}, m = "authenticateAnonymously", n = {"clientId", Credential.SerializedNames.SECRET, "$i$f$resultOf", "$i$a$-resultOf-AuthenticationRemoteDataSource$authenticateAnonymously$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthenticationRemoteDataSource.this.authenticateAnonymously(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.auth.AuthenticationRemoteDataSource$authenticateWithJWT$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthenticationRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.auth.AuthenticationRemoteDataSource", f = "AuthenticationRemoteDataSource.kt", i = {0, 0, 0, 0, 0}, l = {134}, m = "authenticateWithJWT", n = {"clientId", Credential.SerializedNames.SECRET, "jwtAssertion", "$i$f$resultOf", "$i$a$-resultOf-AuthenticationRemoteDataSource$authenticateWithJWT$2"}, s = {"L$0", "L$1", "L$2", "I$0", "I$1"}, v = 1)
    static final class C11131 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C11131(Continuation<? super C11131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthenticationRemoteDataSource.this.authenticateWithJWT(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.auth.AuthenticationRemoteDataSource$authenticateWithMsal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AuthenticationRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.auth.AuthenticationRemoteDataSource", f = "AuthenticationRemoteDataSource.kt", i = {0, 0, 0, 0, 0, 0}, l = {73}, m = "authenticateWithMsal", n = {"externalToken", BoxIntuneMAMAuthActivityKt.CODE_CHALLENGE_EXTRA, "clientId", "requestBody", "$i$f$resultOf", "$i$a$-resultOf-AuthenticationRemoteDataSource$authenticateWithMsal$2"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class C11141 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C11141(Continuation<? super C11141> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthenticationRemoteDataSource.this.authenticateWithMsal(null, null, null, this);
        }
    }

    @Inject
    public AuthenticationRemoteDataSource(AuthRequest authRequest, Moshi moshi, AppRestrictionsManager appRestrictionsManager, IBVEManager bveManager) {
        Intrinsics.checkNotNullParameter(authRequest, "authRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        Intrinsics.checkNotNullParameter(appRestrictionsManager, "appRestrictionsManager");
        Intrinsics.checkNotNullParameter(bveManager, "bveManager");
        this.authRequest = authRequest;
        this.moshi = moshi;
        this.appRestrictionsManager = appRestrictionsManager;
        this.bveManager = bveManager;
    }

    /* JADX INFO: compiled from: AuthenticationRemoteDataSource.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/data/datasource/auth/AuthenticationRemoteDataSource$Companion;", "", "<init>", "()V", "TOKEN_TYPE_KEY", "", "JWT_TOKEN_TYPE_NAME", "PUBLIC_KEY_ID", "SUBJECT_TYPE_KEY", "RSA_ALGORITHM", "JWT_GRANT", "PEM_RSA_HEADER", "PEM_RSA_FOOTER", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object authenticateAnonymously(String str, String str2, Continuation<? super Result<AccessTokenDTO, ? extends RemoteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        Result.Error error;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objAuthenticateAnonymously$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objAuthenticateAnonymously$default);
                AuthRequest authRequest = this.authRequest;
                anonymousClass2.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass2.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass2.I$0 = 0;
                anonymousClass2.I$1 = 0;
                anonymousClass2.label = 1;
                objAuthenticateAnonymously$default = AuthRequest.authenticateAnonymously$default(authRequest, str, str2, null, anonymousClass2, 4, null);
                if (objAuthenticateAnonymously$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass2.I$1;
                int i3 = anonymousClass2.I$0;
                ResultKt.throwOnFailure(objAuthenticateAnonymously$default);
            }
            error = new Result.Success((AccessTokenDTO) objAuthenticateAnonymously$default);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object authenticateWithMsal(String str, String str2, String str3, Continuation<? super Result<String, ? extends RemoteError>> continuation) {
        C11141 c11141;
        Result.Error error;
        String strString;
        if (continuation instanceof C11141) {
            c11141 = (C11141) continuation;
            if ((c11141.label & Integer.MIN_VALUE) != 0) {
                c11141.label -= Integer.MIN_VALUE;
            } else {
                c11141 = new C11141(continuation);
            }
        } else {
            c11141 = new C11141(continuation);
        }
        Object objAuthenticateWithMsal = c11141.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11141.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objAuthenticateWithMsal);
                RequestBody requestBodyBuildMsalRequestBody = buildMsalRequestBody(str, str2, str3);
                AuthRequest authRequest = this.authRequest;
                c11141.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11141.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c11141.L$2 = SpillingKt.nullOutSpilledVariable(str3);
                c11141.L$3 = SpillingKt.nullOutSpilledVariable(requestBodyBuildMsalRequestBody);
                c11141.I$0 = 0;
                c11141.I$1 = 0;
                c11141.label = 1;
                objAuthenticateWithMsal = authRequest.authenticateWithMsal(requestBodyBuildMsalRequestBody, c11141);
                if (objAuthenticateWithMsal == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11141.I$1;
                int i3 = c11141.I$0;
                ResultKt.throwOnFailure(objAuthenticateWithMsal);
            }
            Response response = (Response) objAuthenticateWithMsal;
            if (response.isSuccessful() && response.body() != null) {
                detectAndSetEnterpriseDomain(response.raw().request().url().host());
                ResponseBody responseBody = (ResponseBody) response.body();
                if (responseBody == null || (strString = responseBody.string()) == null) {
                    strString = "";
                }
                error = new Result.Success(getCodeFromHtmlBody(strString));
                if (error instanceof Result.Success) {
                    return error;
                }
                if (!(error instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
            }
            throw new HttpException(response);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
    }

    private final RequestBody buildMsalRequestBody(String externalToken, String codeChallenge, String clientId) {
        MultipartBody.Builder builderAddFormDataPart = new MultipartBody.Builder(null, 1, null).setType(MultipartBody.FORM).addFormDataPart("response_type", "code").addFormDataPart("redirect_uri", ApiConstants.MSAL.MSAL_REDIRECT_URI).addFormDataPart("external_token", externalToken).addFormDataPart("auth_type", ApiConstants.MSAL.MSAL_AUTH_TYPE).addFormDataPart("client_id", clientId).addFormDataPart("state", ApiConstants.MSAL.INSTANCE.getMSAL_STATE());
        if (codeChallenge != null) {
            builderAddFormDataPart.addFormDataPart(OAuthWebView.CODE_CHALLENGE, codeChallenge);
        }
        return builderAddFormDataPart.build();
    }

    private final String getCodeFromHtmlBody(String body) throws Exception {
        MatchGroupCollection groups;
        MatchGroup matchGroup;
        String value;
        String str = body;
        String strSubstringAfter$default = null;
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "window.location.href", false, 2, (Object) null)) {
            throw new Exception("Body does not contain window.location.href attribute.");
        }
        MatchResult matchResultFind$default = Regex.find$default(new Regex("window\\.location\\.href\\s*=\\s*\"(.*?)\";"), str, 0, 2, null);
        if (matchResultFind$default != null && (groups = matchResultFind$default.getGroups()) != null && (matchGroup = groups.get(1)) != null && (value = matchGroup.getValue()) != null) {
            strSubstringAfter$default = StringsKt.substringAfter$default(value, "code=", (String) null, 2, (Object) null);
        }
        if (strSubstringAfter$default != null) {
            return strSubstringAfter$default;
        }
        throw new Exception("Redirect URL not found in response.");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object authenticateWithJWT(String str, String str2, String str3, Continuation<? super Result<AccessTokenDTO, ? extends RemoteError>> continuation) {
        C11131 c11131;
        Result.Error error;
        if (continuation instanceof C11131) {
            c11131 = (C11131) continuation;
            if ((c11131.label & Integer.MIN_VALUE) != 0) {
                c11131.label -= Integer.MIN_VALUE;
            } else {
                c11131 = new C11131(continuation);
            }
        } else {
            c11131 = new C11131(continuation);
        }
        C11131 c11132 = c11131;
        Object objAuthenticateUsingJWT = c11132.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c11132.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objAuthenticateUsingJWT);
                AuthRequest authRequest = this.authRequest;
                c11132.L$0 = SpillingKt.nullOutSpilledVariable(str);
                c11132.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                c11132.L$2 = SpillingKt.nullOutSpilledVariable(str3);
                c11132.I$0 = 0;
                c11132.I$1 = 0;
                c11132.label = 1;
                objAuthenticateUsingJWT = authRequest.authenticateUsingJWT(str, str2, "urn:ietf:params:oauth:grant-type:jwt-bearer", str3, c11132);
                if (objAuthenticateUsingJWT == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = c11132.I$1;
                int i3 = c11132.I$0;
                ResultKt.throwOnFailure(objAuthenticateUsingJWT);
            }
            error = new Result.Success((AccessTokenDTO) objAuthenticateUsingJWT);
        } catch (Exception e) {
            error = new Result.Error(e);
        }
        if (error instanceof Result.Success) {
            return error;
        }
        if (!(error instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return new Result.Error(ErrorUtil.INSTANCE.getInstance().getRemoteErrorFromApiException((Exception) ((Result.Error) error).getValue(), this.moshi));
    }

    public final Result<String, RemoteError> createJWT(JWTAuthInfo authInfo) {
        Result.Error error;
        Intrinsics.checkNotNullParameter(authInfo, "authInfo");
        String strCreateAuthenticationUrl = createAuthenticationUrl();
        JsonWebSignature jsonWebSignatureCreateJWS = createJWS();
        JwtClaims jwtClaims = new JwtClaims();
        jwtClaims.setIssuer(AppConstants.JWT_APP_CLIENT_ID);
        jwtClaims.setAudience(strCreateAuthenticationUrl);
        jwtClaims.setSubject(authInfo.getAssertion().getSubject());
        jwtClaims.setClaim(SUBJECT_TYPE_KEY, authInfo.getAssertion().getSubjectType());
        jwtClaims.setGeneratedJwtId(64);
        jwtClaims.setExpirationTimeMinutesInTheFuture(1.0f);
        try {
            Key keyCreateEncodedPrivateKey = createEncodedPrivateKey(authInfo.getPrivateKey());
            jsonWebSignatureCreateJWS.setPayload(jwtClaims.toJson());
            jsonWebSignatureCreateJWS.setAlgorithmHeaderValue("RS256");
            jsonWebSignatureCreateJWS.setHeader("typ", JWT_TOKEN_TYPE_NAME);
            jsonWebSignatureCreateJWS.setHeader("kid", authInfo.getPublicKeyId());
            jsonWebSignatureCreateJWS.setKey(keyCreateEncodedPrivateKey);
            return new Result.Success(jsonWebSignatureCreateJWS.getCompactSerialization());
        } catch (Exception e) {
            if (e instanceof GeneralSecurityException) {
                String message = e.getMessage();
                error = new Result.Error(new ObservabilityRemoteError.SecurityError(message != null ? message : ""));
            } else if (e instanceof JoseException) {
                String message2 = e.getMessage();
                error = new Result.Error(new ObservabilityRemoteError.JWTCreationError(message2 != null ? message2 : ""));
            } else {
                String message3 = e.getMessage();
                error = new Result.Error(new RemoteError.Unknown(-1, message3 != null ? message3 : ""));
            }
            return error;
        }
    }

    protected JsonWebSignature createJWS() {
        return new JsonWebSignature();
    }

    public Key createEncodedPrivateKey(String privateKeyPem) throws InvalidKeySpecException, NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(privateKeyPem, "privateKeyPem");
        byte[] bArrDecode = Base64.decode(new Regex("\\s").replace(StringsKt.replace$default(StringsKt.replace$default(privateKeyPem, PEM_RSA_HEADER, "", false, 4, (Object) null), PEM_RSA_FOOTER, "", false, 4, (Object) null), ""), 0);
        Intrinsics.checkNotNullExpressionValue(bArrDecode, "decode(...)");
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArrDecode));
        Intrinsics.checkNotNullExpressionValue(privateKeyGeneratePrivate, "generatePrivate(...)");
        return privateKeyGeneratePrivate;
    }

    public final String createAuthenticationUrl() {
        if (this.appRestrictionsManager.isAppFedrampHighCompliant()) {
            return "https://api.box-gov.com/oauth2/token";
        }
        return "https://api.box.com/oauth2/token";
    }

    private final void detectAndSetEnterpriseDomain(String host) {
        String str = host;
        if (str == null || str.length() == 0) {
            return;
        }
        try {
            if (StringsKt.endsWith$default(host, "ent.box.com", false, 2, (Object) null)) {
                this.bveManager.setVerifiedEnterprise(true);
                this.bveManager.setVerifiedEnterpriseDomain(host);
                BoxLogUtils.i("MSAL_BVE", "Enterprise domain detected and set: " + host);
            }
        } catch (Exception unused) {
        }
    }
}
