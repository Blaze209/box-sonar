package com.box.android.data.api.interceptors.auth;

import com.box.android.data.api.utils.ApiConstants;
import com.box.android.domain.services.ISessionManager;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: AuthInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0002J\u001e\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/box/android/data/api/interceptors/auth/AuthInterceptor;", "Lokhttp3/Interceptor;", "sessionManager", "Lcom/box/android/domain/services/ISessionManager;", "<init>", "(Lcom/box/android/domain/services/ISessionManager;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "isAuthHeaderAttached", "", "request", "Lokhttp3/Request;", "isAuthenticationRequest", "hasAuthFailed", "response", "headerMap", "", "", "accessToken", "hasAuthExpired", "isInvalidTokenError", "str", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AuthInterceptor implements Interceptor {
    public static final String AUTHORIZATION_KEY = "Authorization";
    private static final String TAG = "AuthInterceptor";
    private final ISessionManager sessionManager;

    @Inject
    public AuthInterceptor(ISessionManager sessionManager) {
        Intrinsics.checkNotNullParameter(sessionManager, "sessionManager");
        this.sessionManager = sessionManager;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws InterruptedException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        BuildersKt.runBlocking(Dispatchers.getIO(), new AnonymousClass1(chain, this, objectRef, null));
        Response response = (Response) objectRef.element;
        return response == null ? new Response.Builder().code(403).request(chain.request()).build() : response;
    }

    /* JADX INFO: renamed from: com.box.android.data.api.interceptors.auth.AuthInterceptor$intercept$1, reason: invalid class name */
    /* JADX INFO: compiled from: AuthInterceptor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.api.interceptors.auth.AuthInterceptor$intercept$1", f = "AuthInterceptor.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {47, 53, 55}, m = "invokeSuspend", n = {"request", "builder", "request", "builder", "authExpired", "request", "builder", "authExpired"}, s = {"L$0", "L$1", "L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Interceptor.Chain $chain;
        final /* synthetic */ Ref.ObjectRef<Response> $response;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;
        final /* synthetic */ AuthInterceptor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Interceptor.Chain chain, AuthInterceptor authInterceptor, Ref.ObjectRef<Response> objectRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$chain = chain;
            this.this$0 = authInterceptor;
            this.$response = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$chain, this.this$0, this.$response, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:33:0x0104  */
        /* JADX WARN: Code duplicated, block: B:36:0x0128  */
        /* JADX WARN: Code duplicated, block: B:40:0x013e A[LOOP:0: B:38:0x0138->B:40:0x013e, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:43:0x0160  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v19, types: [T, okhttp3.Request$Builder] */
        /* JADX WARN: Type inference failed for: r1v10, types: [T, okhttp3.Response] */
        /* JADX WARN: Type inference failed for: r5v0, types: [T, okhttp3.Request$Builder] */
        /* JADX WARN: Type inference failed for: r9v12, types: [T, okhttp3.Response] */
        /* JADX WARN: Type inference failed for: r9v2, types: [T, okhttp3.Response] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Request request;
            Ref.ObjectRef objectRef;
            AuthInterceptor authInterceptor;
            boolean z;
            Ref.ObjectRef objectRef2;
            Request request2;
            AuthInterceptor authInterceptor2;
            Object accessToken;
            AuthInterceptor authInterceptor3;
            Response response;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Request request3 = this.$chain.request();
                if (this.this$0.isAuthHeaderAttached(request3) || this.this$0.isAuthenticationRequest(request3)) {
                    this.$response.element = this.$chain.proceed(request3);
                    return Unit.INSTANCE;
                }
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                objectRef3.element = request3.newBuilder();
                AuthInterceptor authInterceptor4 = this.this$0;
                this.L$0 = request3;
                this.L$1 = objectRef3;
                this.L$2 = authInterceptor4;
                this.label = 1;
                Object accessToken2 = authInterceptor4.sessionManager.getAccessToken(this);
                if (accessToken2 != coroutine_suspended) {
                    request = request3;
                    obj = accessToken2;
                    objectRef = objectRef3;
                    authInterceptor = authInterceptor4;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                authInterceptor = (AuthInterceptor) this.L$2;
                objectRef = (Ref.ObjectRef) this.L$1;
                request = (Request) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i == 2) {
                    boolean z2 = this.Z$0;
                    Ref.ObjectRef objectRef4 = (Ref.ObjectRef) this.L$1;
                    request2 = (Request) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    z = z2;
                    objectRef2 = objectRef4;
                    if (((Boolean) obj).booleanValue()) {
                        objectRef2.element = request2.newBuilder();
                        authInterceptor2 = this.this$0;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                        this.L$1 = objectRef2;
                        this.L$2 = authInterceptor2;
                        this.Z$0 = z;
                        this.label = 3;
                        accessToken = authInterceptor2.sessionManager.getAccessToken(this);
                        if (accessToken != coroutine_suspended) {
                            authInterceptor3 = authInterceptor2;
                            obj = accessToken;
                        }
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                authInterceptor3 = (AuthInterceptor) this.L$2;
                objectRef2 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure(obj);
            }
            for (Map.Entry entry : authInterceptor3.headerMap((String) obj).entrySet()) {
                ((Request.Builder) objectRef2.element).header((String) entry.getKey(), (String) entry.getValue());
            }
            response = this.$response.element;
            if (response != null) {
                response.close();
            }
            this.$response.element = this.$chain.proceed(((Request.Builder) objectRef2.element).build());
            return Unit.INSTANCE;
            for (Map.Entry entry2 : authInterceptor.headerMap((String) obj).entrySet()) {
                ((Request.Builder) objectRef.element).header((String) entry2.getKey(), (String) entry2.getValue());
            }
            this.$response.element = this.$chain.proceed(((Request.Builder) objectRef.element).build());
            boolean zHasAuthExpired = this.this$0.hasAuthExpired(this.$response.element);
            if (zHasAuthExpired) {
                this.L$0 = request;
                this.L$1 = objectRef;
                this.L$2 = null;
                this.Z$0 = zHasAuthExpired;
                this.label = 2;
                obj = this.this$0.sessionManager.refreshSession(this);
                if (obj != coroutine_suspended) {
                    z = zHasAuthExpired;
                    objectRef2 = objectRef;
                    request2 = request;
                    if (((Boolean) obj).booleanValue()) {
                        objectRef2.element = request2.newBuilder();
                        authInterceptor2 = this.this$0;
                        this.L$0 = SpillingKt.nullOutSpilledVariable(request2);
                        this.L$1 = objectRef2;
                        this.L$2 = authInterceptor2;
                        this.Z$0 = z;
                        this.label = 3;
                        accessToken = authInterceptor2.sessionManager.getAccessToken(this);
                        if (accessToken != coroutine_suspended) {
                            authInterceptor3 = authInterceptor2;
                            obj = accessToken;
                            while (r10.hasNext()) {
                                ((Request.Builder) objectRef2.element).header((String) entry.getKey(), (String) entry.getValue());
                            }
                            response = this.$response.element;
                            if (response != null) {
                                response.close();
                            }
                            this.$response.element = this.$chain.proceed(((Request.Builder) objectRef2.element).build());
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (this.this$0.hasAuthFailed(this.$response.element)) {
                Response response2 = this.$response.element;
                BoxLogUtils.e(AuthInterceptor.TAG, "Request auth failed : " + (response2 != null ? response2.message() : null));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAuthHeaderAttached(Request request) {
        List<String> listHeaders = request.headers("Authorization");
        if (!listHeaders.isEmpty()) {
            BoxLogUtils.v(TAG, "Auth header found already attached, skipping");
        }
        return !listHeaders.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isAuthenticationRequest(Request request) {
        boolean zContains$default = StringsKt.contains$default((CharSequence) request.url().getUrl(), (CharSequence) ApiConstants.TOKEN_ENDPOINT, false, 2, (Object) null);
        if (zContains$default) {
            BoxLogUtils.v(TAG, "Intercepted Authentication request, Auth header not required, skipping");
        }
        return zContains$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasAuthFailed(Response response) {
        return response != null && response.code() == 401;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> headerMap(String accessToken) {
        return MapsKt.mapOf(TuplesKt.to("Authorization", "Bearer " + accessToken));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasAuthExpired(Response response) {
        if (response == null || 401 != response.code()) {
            return false;
        }
        for (String str : (String[]) StringsKt.split$default((CharSequence) response.headers("WWW-Authenticate").get(0), new String[]{","}, false, 0, 6, (Object) null).toArray(new String[0])) {
            if (isInvalidTokenError(str)) {
                return true;
            }
        }
        return false;
    }

    private final boolean isInvalidTokenError(String str) {
        String str2;
        String[] strArr = (String[]) StringsKt.split$default((CharSequence) str, new String[]{SimpleComparison.EQUAL_TO_OPERATION}, false, 0, 6, (Object) null).toArray(new String[0]);
        if (strArr.length == 2 && (str2 = strArr[0]) != null && strArr[1] != null) {
            Intrinsics.checkNotNull(str2);
            String str3 = str2;
            int length = str3.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str3.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            if (StringsKt.equals("error", str3.subSequence(i, length + 1).toString(), true)) {
                String str4 = strArr[1];
                Intrinsics.checkNotNull(str4);
                String strReplace$default = StringsKt.replace$default(str4, "\"", "", false, 4, (Object) null);
                int length2 = strReplace$default.length() - 1;
                int i2 = 0;
                boolean z3 = false;
                while (i2 <= length2) {
                    boolean z4 = Intrinsics.compare((int) strReplace$default.charAt(!z3 ? i2 : length2), 32) <= 0;
                    if (z3) {
                        if (!z4) {
                            break;
                        }
                        length2--;
                    } else if (z4) {
                        i2++;
                    } else {
                        z3 = true;
                    }
                }
                if (StringsKt.equals(BoxRequest.BoxRequestHandler.OAUTH_INVALID_TOKEN, strReplace$default.subSequence(i2, length2 + 1).toString(), true)) {
                    return true;
                }
            }
        }
        return false;
    }
}
