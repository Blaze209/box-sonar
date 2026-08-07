package com.microsoft.identity.common.nativeauth.internal.controllers;

import com.microsoft.identity.common.internal.broker.ipc.WebAppsAdditionalRequiredParameters;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.GenerateShrCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.RemoveAccountCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.dto.AccountRecord;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationRequest;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResponse;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2Strategy;
import com.microsoft.identity.common.java.providers.oauth2.OAuth2TokenCache;
import com.microsoft.identity.common.java.providers.oauth2.TokenResult;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.result.GenerateShrResult;
import com.microsoft.identity.common.java.ui.PreferredAuthMethod;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BaseNativeAuthController.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0010\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0017J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0017J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\rH\u0017J\u001a\u0010\u000e\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0017J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u0011H\u0017J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0015H\u0017J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u0017H\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0007\u001a\u00020\u0017H\u0015J\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0015H\u0017J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0015H\u0017J\b\u0010\u001d\u001a\u00020\u001eH\u0017Jl\u0010\u001f\u001a^\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030!\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\"\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030#\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060 2\u0006\u0010\u0007\u001a\u00020\u0017H\u0017J\\\u0010$\u001aN\u0012:\b\u0001\u00126\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030 \u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030!\u0012\u0002\b\u00030%2\u0006\u0010\u0007\u001a\u00020\u0017H\u0017J\u0018\u0010&\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020)H\u0015J \u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0017J\u0088\u0001\u00101\u001a\u0002022b\u00103\u001a^\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030!\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\"\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030#\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u000e\b\u0001\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00060 2\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030!2\u0006\u00104\u001a\u0002052\u0006\u0010\u0007\u001a\u00020\u000bH\u0015J\u0012\u00106\u001a\u00020\u001c2\b\u0010\u0007\u001a\u0004\u0018\u000107H\u0017J\u0012\u00108\u001a\u00020\u001c2\b\u0010\u0007\u001a\u0004\u0018\u000107H\u0017J\u0010\u00109\u001a\u0002022\u0006\u0010\u0007\u001a\u00020\u0017H\u0017¨\u0006:"}, d2 = {"Lcom/microsoft/identity/common/nativeauth/internal/controllers/BaseNativeAuthController;", "Lcom/microsoft/identity/common/java/controllers/BaseController;", "()V", "acquireDeviceCodeFlowToken", "Lcom/microsoft/identity/common/java/result/AcquireTokenResult;", "authorizationResult", "Lcom/microsoft/identity/common/java/providers/oauth2/AuthorizationResult;", "parameters", "Lcom/microsoft/identity/common/java/commands/parameters/DeviceCodeFlowCommandParameters;", "acquireToken", "request", "Lcom/microsoft/identity/common/java/commands/parameters/InteractiveTokenCommandParameters;", ArgumentException.ACQUIRE_TOKEN_WITH_PASSWORD_OPERATION_NAME, "Lcom/microsoft/identity/common/java/commands/parameters/RopcTokenCommandParameters;", "deviceCodeFlowAuthRequest", "generateSignedHttpRequest", "Lcom/microsoft/identity/common/java/result/GenerateShrResult;", "Lcom/microsoft/identity/common/java/commands/parameters/GenerateShrCommandParameters;", "getAccounts", "", "Lcom/microsoft/identity/common/java/cache/ICacheRecord;", "Lcom/microsoft/identity/common/java/commands/parameters/CommandParameters;", "getCacheRecord", "Lcom/microsoft/identity/common/java/commands/parameters/SilentTokenCommandParameters;", "getCachedAccountRecordFromAllCaches", "Lcom/microsoft/identity/common/java/dto/AccountRecord;", "getCurrentAccount", "getDeviceMode", "", "getPreferredAuthMethod", "Lcom/microsoft/identity/common/java/ui/PreferredAuthMethod;", "getStrategy", "Lcom/microsoft/identity/common/java/providers/oauth2/OAuth2Strategy;", "Lcom/microsoft/identity/common/java/providers/oauth2/AuthorizationRequest;", "Lcom/microsoft/identity/common/java/providers/oauth2/AuthorizationRequest$Builder;", "Lcom/microsoft/identity/common/java/providers/oauth2/IAuthorizationStrategy;", "getTokenCache", "Lcom/microsoft/identity/common/java/providers/oauth2/OAuth2TokenCache;", "idTokenIsNull", "cacheRecord", WebAppsAdditionalRequiredParameters.FIELD_SDK_TYPE, "Lcom/microsoft/identity/common/java/request/SdkType;", "onFinishAuthorizationSession", "", "requestCode", "", "resultCode", "data", "Lcom/microsoft/identity/common/java/util/ported/PropertyBag;", "performTokenRequest", "Lcom/microsoft/identity/common/java/providers/oauth2/TokenResult;", "strategy", "response", "Lcom/microsoft/identity/common/java/providers/oauth2/AuthorizationResponse;", ArgumentException.REMOVE_ACCOUNT_OPERATION_NAME, "Lcom/microsoft/identity/common/java/commands/parameters/RemoveAccountCommandParameters;", "removeCurrentAccount", "renewAccessToken", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class BaseNativeAuthController extends BaseController {
    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "acquireToken() not supported in NativeAuthController")
    public /* synthetic */ AcquireTokenResult acquireToken(InteractiveTokenCommandParameters request) throws ClientException {
        throw new ClientException("acquireToken() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "onFinishAuthorizationSession() not supported in NativeAuthController")
    public /* synthetic */ void onFinishAuthorizationSession(int requestCode, int resultCode, PropertyBag data) throws ClientException {
        Intrinsics.checkNotNullParameter(data, "data");
        throw new ClientException("onFinishAuthorizationSession() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "getAccounts() not supported in NativeAuthController")
    public /* synthetic */ List getAccounts(CommandParameters parameters) throws ClientException {
        throw new ClientException("getAccounts() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "removeAccount() not supported in NativeAuthController")
    public /* synthetic */ boolean removeAccount(RemoveAccountCommandParameters parameters) throws ClientException {
        throw new ClientException("removeAccount() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "getDeviceMode() not supported in NativeAuthController")
    public /* synthetic */ boolean getDeviceMode(CommandParameters parameters) throws ClientException {
        throw new ClientException("getDeviceMode() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "getCurrentAccount() not supported in NativeAuthController")
    public /* synthetic */ List getCurrentAccount(CommandParameters parameters) throws ClientException {
        throw new ClientException("getCurrentAccount() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "removeCurrentAccount() not supported in NativeAuthController")
    public /* synthetic */ boolean removeCurrentAccount(RemoveAccountCommandParameters parameters) throws ClientException {
        throw new ClientException("removeCurrentAccount() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "deviceCodeFlowAuthRequest() not supported in NativeAuthController")
    public /* synthetic */ AuthorizationResult deviceCodeFlowAuthRequest(DeviceCodeFlowCommandParameters parameters) throws ClientException {
        throw new ClientException("deviceCodeFlowAuthRequest() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "acquireDeviceCodeFlowToken() not supported in NativeAuthController")
    public /* synthetic */ AcquireTokenResult acquireDeviceCodeFlowToken(AuthorizationResult authorizationResult, DeviceCodeFlowCommandParameters parameters) throws ClientException {
        throw new ClientException("acquireDeviceCodeFlowToken() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "generateSignedHttpRequest() not supported in NativeAuthController")
    public /* synthetic */ GenerateShrResult generateSignedHttpRequest(GenerateShrCommandParameters parameters) throws ClientException {
        throw new ClientException("generateSignedHttpRequest() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "acquireTokenWithPassword() not supported in NativeAuthController")
    public /* synthetic */ AcquireTokenResult acquireTokenWithPassword(RopcTokenCommandParameters parameters) throws ClientException {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        throw new ClientException("acquireTokenWithPassword() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "renewAccessToken() not supported in NativeAuthController")
    public /* synthetic */ TokenResult renewAccessToken(SilentTokenCommandParameters parameters) throws ClientException {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        throw new ClientException("renewAccessToken() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "getStrategy() not supported in NativeAuthController")
    public /* synthetic */ OAuth2Strategy getStrategy(SilentTokenCommandParameters parameters) throws ClientException {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        throw new ClientException("getStrategy() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "getCacheRecord() not supported in NativeAuthController")
    public /* synthetic */ ICacheRecord getCacheRecord(SilentTokenCommandParameters parameters) throws ClientException {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        throw new ClientException("getCacheRecord() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "getTokenCache() not supported in NativeAuthController")
    public /* synthetic */ OAuth2TokenCache getTokenCache(SilentTokenCommandParameters parameters) throws ClientException {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        throw new ClientException("getTokenCache() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "performTokenRequest() not supported in NativeAuthController")
    protected /* synthetic */ TokenResult performTokenRequest(OAuth2Strategy strategy, AuthorizationRequest request, AuthorizationResponse response, InteractiveTokenCommandParameters parameters) throws ClientException {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        throw new ClientException("performTokenRequest() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "idTokenIsNull() not supported in NativeAuthController")
    protected /* synthetic */ boolean idTokenIsNull(ICacheRecord cacheRecord, SdkType sdkType) throws ClientException {
        Intrinsics.checkNotNullParameter(cacheRecord, "cacheRecord");
        Intrinsics.checkNotNullParameter(sdkType, "sdkType");
        throw new ClientException("idTokenIsNull() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "getCachedAccountRecordFromAllCaches() not supported in NativeAuthController")
    protected /* synthetic */ AccountRecord getCachedAccountRecordFromAllCaches(SilentTokenCommandParameters parameters) throws ClientException {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        throw new ClientException("getCachedAccountRecordFromAllCaches() not supported in NativeAuthController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "getPreferredAuthMethod() not supported in NativeAuthController")
    public /* synthetic */ PreferredAuthMethod getPreferredAuthMethod() throws ClientException {
        throw new ClientException("getPreferredAuthMethod() not supported in NativeAuthController");
    }
}
