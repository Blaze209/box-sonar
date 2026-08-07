package com.box.android.data.service.impl;

import android.os.SystemClock;
import com.box.android.data.api.models.ClientSettingsDTO;
import com.box.android.data.datasource.clientsettings.ClientSettingsCacheDataSource;
import com.box.android.data.datasource.clientsettings.ClientSettingsRemoteDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.mappers.ClientSettingsDTODomainMapper;
import com.box.android.domain.identity.IUserContext;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalStatics;
import com.box.android.domain.models.ClientSettingsModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.IClientSettingsService;
import com.box.android.domain.utils.result.Result;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientSettingsService.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0096@¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0096@¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/service/impl/ClientSettingsService;", "Lcom/box/android/domain/services/IClientSettingsService;", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "clientSettingsRemoteDataSource", "Lcom/box/android/data/datasource/clientsettings/ClientSettingsRemoteDataSource;", "clientSettingsCacheDataSource", "Lcom/box/android/data/datasource/clientsettings/ClientSettingsCacheDataSource;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/box/android/data/datasource/clientsettings/ClientSettingsRemoteDataSource;Lcom/box/android/data/datasource/clientsettings/ClientSettingsCacheDataSource;)V", "getClientSettingsRemote", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/ClientSettingsModel;", "Lcom/box/android/domain/models/DomainError;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getClientSettingsIfNeeded", "getClientSettingsLocal", "saveLastClientSettingsFetchTime", "", "areClientSettingsInvalid", "", "validityTimeMs", "", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClientSettingsService implements IClientSettingsService {
    public static final long DEFAULT_ADMIN_SETTINGS_PERIOD = 3600000;
    private final ClientSettingsCacheDataSource clientSettingsCacheDataSource;
    private final ClientSettingsRemoteDataSource clientSettingsRemoteDataSource;
    private final IUserContextManager userContextManager;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.ClientSettingsService$getClientSettingsRemote$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClientSettingsService.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.ClientSettingsService", f = "ClientSettingsService.kt", i = {}, l = {25}, m = "getClientSettingsRemote", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ClientSettingsService.this.getClientSettingsRemote(this);
        }
    }

    @Inject
    public ClientSettingsService(IUserContextManager userContextManager, ClientSettingsRemoteDataSource clientSettingsRemoteDataSource, ClientSettingsCacheDataSource clientSettingsCacheDataSource) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(clientSettingsRemoteDataSource, "clientSettingsRemoteDataSource");
        Intrinsics.checkNotNullParameter(clientSettingsCacheDataSource, "clientSettingsCacheDataSource");
        this.userContextManager = userContextManager;
        this.clientSettingsRemoteDataSource = clientSettingsRemoteDataSource;
        this.clientSettingsCacheDataSource = clientSettingsCacheDataSource;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.services.IClientSettingsService
    public Object getClientSettingsRemote(Continuation<? super Result<ClientSettingsModel, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object clientSettings$default = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(clientSettings$default);
            ClientSettingsRemoteDataSource clientSettingsRemoteDataSource = this.clientSettingsRemoteDataSource;
            anonymousClass1.label = 1;
            clientSettings$default = ClientSettingsRemoteDataSource.getClientSettings$default(clientSettingsRemoteDataSource, null, anonymousClass1, 1, null);
            if (clientSettings$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(clientSettings$default);
        }
        Result.Error error = (Result) clientSettings$default;
        if (!(error instanceof Result.Success)) {
            if (error instanceof Result.Error) {
                RemoteError remoteError = (RemoteError) ((Result.Error) error).getValue();
                error = new Result.Error(DomainErrorMapper.INSTANCE.toDomainError(remoteError, "Get client settings from remote error due to " + remoteError.getMessage()));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (error instanceof Result.Success) {
            ClientSettingsDTO clientSettingsDTO = (ClientSettingsDTO) ((Result.Success) error).getValue();
            this.clientSettingsCacheDataSource.saveClientSettings(clientSettingsDTO);
            saveLastClientSettingsFetchTime();
            return new Result.Success(ClientSettingsDTODomainMapper.INSTANCE.toDomain(clientSettingsDTO));
        }
        if (error instanceof Result.Error) {
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.box.android.domain.services.IClientSettingsService
    public Object getClientSettingsIfNeeded(Continuation<? super Result<ClientSettingsModel, ? extends DomainError>> continuation) {
        if (areClientSettingsInvalid$default(this, 0L, 1, null)) {
            return getClientSettingsRemote(continuation);
        }
        return getClientSettingsLocal();
    }

    @Override // com.box.android.domain.services.IClientSettingsService
    public Result<ClientSettingsModel, DomainError> getClientSettingsLocal() {
        ClientSettingsDTO clientSettings = this.clientSettingsCacheDataSource.getClientSettings();
        if (clientSettings != null) {
            return new Result.Success(ClientSettingsDTODomainMapper.INSTANCE.toDomain(clientSettings));
        }
        return new Result.Error(new DomainError.CacheReadError("No client settings available"));
    }

    private final void saveLastClientSettingsFetchTime() {
        IUserContextComponent userContextComponent = this.userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_STATIC_VARIABLE);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.domain.localrepo.ILocalStatics");
        Map<String, Long> lastAdminSettingsFetchTimeMap = ((ILocalStatics) userContextComponent).getLastAdminSettingsFetchTimeMap();
        Intrinsics.checkNotNullExpressionValue(lastAdminSettingsFetchTimeMap, "getLastAdminSettingsFetchTimeMap(...)");
        lastAdminSettingsFetchTimeMap.put(this.userContextManager.getUserInfo().getUserId(), Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public static /* synthetic */ boolean areClientSettingsInvalid$default(ClientSettingsService clientSettingsService, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 3600000;
        }
        return clientSettingsService.areClientSettingsInvalid(j);
    }

    public final boolean areClientSettingsInvalid(long validityTimeMs) {
        IUserContextComponent userContextComponent = this.userContextManager.getCurrentContext().getUserContextComponent(IUserContext.UserContextComponent.LOCAL_STATIC_VARIABLE);
        Intrinsics.checkNotNull(userContextComponent, "null cannot be cast to non-null type com.box.android.domain.localrepo.ILocalStatics");
        Long l = ((ILocalStatics) userContextComponent).getLastAdminSettingsFetchTimeMap().get(this.userContextManager.getUserInfo().getUserId());
        return l == null || l.longValue() < 1 || l.longValue() + validityTimeMs < SystemClock.elapsedRealtime();
    }
}
