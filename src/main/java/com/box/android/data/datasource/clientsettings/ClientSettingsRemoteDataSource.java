package com.box.android.data.datasource.clientsettings;

import com.box.android.data.api.models.ClientSettingsDTO;
import com.box.android.data.api.requests.ClientSettingsRequest;
import com.box.android.data.datasource.ErrorUtil;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import com.squareup.moshi.Moshi;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientSettingsRemoteDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0086@¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/box/android/data/datasource/clientsettings/ClientSettingsRemoteDataSource;", "", "clientSettingsRequest", "Lcom/box/android/data/api/requests/ClientSettingsRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/api/requests/ClientSettingsRequest;Lcom/squareup/moshi/Moshi;)V", "getClientSettings", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/api/models/ClientSettingsDTO;", "Lcom/box/android/data/datasource/errors/RemoteError;", "accessToken", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClientSettingsRemoteDataSource {
    private final ClientSettingsRequest clientSettingsRequest;
    private final Moshi moshi;

    /* JADX INFO: renamed from: com.box.android.data.datasource.clientsettings.ClientSettingsRemoteDataSource$getClientSettings$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClientSettingsRemoteDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.clientsettings.ClientSettingsRemoteDataSource", f = "ClientSettingsRemoteDataSource.kt", i = {0, 0, 0, 0}, l = {26}, m = "getClientSettings", n = {"accessToken", "bearerToken", "$i$f$resultOf", "$i$a$-resultOf-ClientSettingsRemoteDataSource$getClientSettings$2"}, s = {"L$0", "L$1", "I$0", "I$1"}, v = 1)
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
            return ClientSettingsRemoteDataSource.this.getClientSettings(null, this);
        }
    }

    @Inject
    public ClientSettingsRemoteDataSource(ClientSettingsRequest clientSettingsRequest, Moshi moshi) {
        Intrinsics.checkNotNullParameter(clientSettingsRequest, "clientSettingsRequest");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.clientSettingsRequest = clientSettingsRequest;
        this.moshi = moshi;
    }

    public static /* synthetic */ Object getClientSettings$default(ClientSettingsRemoteDataSource clientSettingsRemoteDataSource, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        return clientSettingsRemoteDataSource.getClientSettings(str, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getClientSettings(String str, Continuation<? super Result<ClientSettingsDTO, ? extends RemoteError>> continuation) {
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
        Object clientSettings = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(clientSettings);
                String str2 = str != null ? "Bearer " + str : null;
                ClientSettingsRequest clientSettingsRequest = this.clientSettingsRequest;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 1;
                clientSettings = clientSettingsRequest.getClientSettings(str2, anonymousClass1);
                if (clientSettings == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i2 = anonymousClass1.I$1;
                int i3 = anonymousClass1.I$0;
                ResultKt.throwOnFailure(clientSettings);
            }
            error = new Result.Success((ClientSettingsDTO) clientSettings);
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
}
