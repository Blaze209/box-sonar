package com.microsoft.identity.common.internal.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.microsoft.identity.common.PropertyBagUtil;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.BrokerActivity;
import com.microsoft.identity.common.internal.broker.BrokerResult;
import com.microsoft.identity.common.internal.broker.ipc.AccountManagerAddAccountStrategy;
import com.microsoft.identity.common.internal.broker.ipc.BoundServiceStrategy;
import com.microsoft.identity.common.internal.broker.ipc.BrokerOperationBundle;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.internal.broker.ipc.WebAppsAdditionalRequiredParameters;
import com.microsoft.identity.common.internal.cache.ActiveBrokerCacheUpdater;
import com.microsoft.identity.common.internal.cache.ClientActiveBrokerCache;
import com.microsoft.identity.common.internal.cache.HelloCache;
import com.microsoft.identity.common.internal.cache.HelloCacheResult;
import com.microsoft.identity.common.internal.commands.parameters.AndroidInteractiveTokenCommandParameters;
import com.microsoft.identity.common.internal.request.MsalBrokerRequestAdapter;
import com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;
import com.microsoft.identity.common.internal.telemetry.events.ApiStartEvent;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeWithClientKeyInternal;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.common.java.commands.AcquirePrtSsoTokenBatchResult;
import com.microsoft.identity.common.java.commands.AcquirePrtSsoTokenResult;
import com.microsoft.identity.common.java.commands.parameters.AcquirePrtSsoTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.GenerateShrCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.GetAadDeviceIdCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.RemoveAccountCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.RopcTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters;
import com.microsoft.identity.common.java.controllers.BaseController;
import com.microsoft.identity.common.java.dto.AadDeviceIdRecord;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.exception.UnsupportedBrokerException;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.ClientInfo;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAccount;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.IDToken;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.result.GenerateShrResult;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.ui.PreferredAuthMethod;
import com.microsoft.identity.common.java.util.BrokerProtocolVersionUtil;
import com.microsoft.identity.common.java.util.ResultFuture;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ThreadUtils;
import com.microsoft.identity.common.java.util.ported.LocalBroadcaster;
import com.microsoft.identity.common.java.util.ported.PropertyBag;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.identity.common.sharedwithoneauth.OneAuthSharedFunctions;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes14.dex */
public class BrokerMsalController extends BaseController {
    private static final String TAG = "BrokerMsalController";
    private final List<IIpcStrategy> ipcStrategies;
    private final String mActiveBrokerPackageName;
    private final Context mApplicationContext;
    private ResultFuture<Bundle> mBrokerResultFuture;
    private final IPlatformComponents mComponents;
    private final HelloCache mHelloCache;
    private String mMaxMsalBrokerProtocolVersion;
    private BrokerOperationExecutor mOperationExecutor;
    protected final MsalBrokerRequestAdapter mRequestAdapter;
    protected final MsalBrokerResultAdapter mResultAdapter;
    private static final long WAIT_BETWEEN_DCF_POLLING_MILLISECONDS = TimeUnit.SECONDS.toMillis(5);
    private static final long HELLO_CACHE_ENTRY_TIMEOUT = TimeUnit.HOURS.toMillis(4);

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    protected boolean canEqual(Object obj) {
        return obj instanceof BrokerMsalController;
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof BrokerMsalController) && ((BrokerMsalController) obj).canEqual(this) && super.equals(obj);
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public int hashCode() {
        return super.hashCode();
    }

    public BrokerMsalController(Context context, IPlatformComponents iPlatformComponents, String str) {
        this(context, iPlatformComponents, str, "19.0");
    }

    public BrokerMsalController(Context context, IPlatformComponents iPlatformComponents, String str, String str2) {
        this(context, iPlatformComponents, str, null, str2);
    }

    public BrokerMsalController(Context context, IPlatformComponents iPlatformComponents, String str, List<IIpcStrategy> list) {
        this(context, iPlatformComponents, str, list, "19.0");
    }

    private BrokerMsalController(Context context, IPlatformComponents iPlatformComponents, String str, List<IIpcStrategy> list, String str2) {
        this.mRequestAdapter = new MsalBrokerRequestAdapter();
        this.mResultAdapter = new MsalBrokerResultAdapter();
        this.mComponents = iPlatformComponents;
        this.mApplicationContext = context;
        this.mActiveBrokerPackageName = str;
        this.ipcStrategies = list;
        this.mHelloCache = getHelloCache();
        this.mMaxMsalBrokerProtocolVersion = str2;
    }

    private synchronized BrokerOperationExecutor getBrokerOperationExecutor() {
        if (this.mOperationExecutor == null) {
            List<IIpcStrategy> ipcStrategies = this.ipcStrategies;
            if (ipcStrategies == null) {
                ipcStrategies = OneAuthSharedFunctions.getIpcStrategies(this.mApplicationContext, this.mActiveBrokerPackageName);
            }
            this.mOperationExecutor = new BrokerOperationExecutor(ipcStrategies, new ActiveBrokerCacheUpdater(this.mApplicationContext, ClientActiveBrokerCache.getClientSdkCache(this.mComponents.getStorageSupplier())));
        }
        return this.mOperationExecutor;
    }

    public HelloCache getHelloCache() {
        return new HelloCache(this.mApplicationContext, AuthenticationConstants.Broker.MSAL_TO_BROKER_PROTOCOL_NAME, this.mActiveBrokerPackageName, this.mComponents, HELLO_CACHE_ENTRY_TIMEOUT);
    }

    public String hello(IIpcStrategy iIpcStrategy, String str) throws BaseException {
        return hello(iIpcStrategy, str, this.mMaxMsalBrokerProtocolVersion);
    }

    public String hello(IIpcStrategy iIpcStrategy, String str, String str2) throws BaseException {
        String str3 = TAG + ":hello";
        String strTryGetNegotiatedProtocolVersionFromHelloCache = tryGetNegotiatedProtocolVersionFromHelloCache(str, str2);
        if (!StringUtil.isNullOrEmpty(strTryGetNegotiatedProtocolVersionFromHelloCache)) {
            return strTryGetNegotiatedProtocolVersionFromHelloCache;
        }
        Logger.info(str3, String.format("Calling broker for to establish negotiated protocol version for: MinRequestVersion=%s, ClientMaxProtocolVersion=%s, ActiveBroker=%s", str, str2, this.mActiveBrokerPackageName));
        Bundle bundle = new Bundle();
        bundle.putString(AuthenticationConstants.Broker.CLIENT_ADVERTISED_MAXIMUM_BP_VERSION_KEY, str2);
        if (!StringUtil.isNullOrEmpty(str)) {
            bundle.putString(AuthenticationConstants.Broker.CLIENT_CONFIGURED_MINIMUM_BP_VERSION_KEY, str);
        }
        try {
            String strVerifyHelloFromResultBundle = this.mResultAdapter.verifyHelloFromResultBundle(this.mActiveBrokerPackageName, iIpcStrategy.communicateToBroker(new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_HELLO, this.mActiveBrokerPackageName, bundle)));
            this.mHelloCache.saveNegotiatedProtocolVersion(str, str2, strVerifyHelloFromResultBundle);
            return strVerifyHelloFromResultBundle;
        } catch (UnsupportedBrokerException e) {
            this.mHelloCache.saveHandshakeError(str, str2);
            throw e;
        }
    }

    private String tryGetNegotiatedProtocolVersionFromHelloCache(String str, String str2) throws UnsupportedBrokerException {
        String str3 = TAG + ":tryGetNegotiatedProtocolVersionFromHelloCache";
        HelloCacheResult helloCacheResult = this.mHelloCache.getHelloCacheResult(str, str2);
        if (helloCacheResult == null) {
            Logger.info(str3, "No valid entry found in cache");
            return null;
        }
        if (helloCacheResult.isHandShakeError()) {
            Logger.info(str3, "Handshake error from cache.");
            throw new UnsupportedBrokerException(this.mActiveBrokerPackageName);
        }
        String negotiatedProtocolVersion = helloCacheResult.getNegotiatedProtocolVersion();
        if (!StringUtil.isNullOrEmpty(negotiatedProtocolVersion)) {
            return negotiatedProtocolVersion;
        }
        Logger.warn(str3, "Unexpected: cachedProtocolVersion is empty. Continue with hello IPC protocol.");
        return null;
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AcquireTokenResult acquireToken(InteractiveTokenCommandParameters interactiveTokenCommandParameters) throws Exception {
        final String str = TAG + ":acquireToken";
        Telemetry.emit(new ApiStartEvent().putProperties(interactiveTokenCommandParameters).putApiId(TelemetryEventStrings.Api.BROKER_ACQUIRE_TOKEN_INTERACTIVE));
        this.mBrokerResultFuture = new ResultFuture<>();
        Intent brokerAuthorizationIntent = getBrokerAuthorizationIntent(interactiveTokenCommandParameters);
        Activity activity = interactiveTokenCommandParameters instanceof AndroidInteractiveTokenCommandParameters ? ((AndroidInteractiveTokenCommandParameters) interactiveTokenCommandParameters).getActivity() : null;
        Intent intent = new Intent(this.mApplicationContext, (Class<?>) BrokerActivity.class);
        intent.putExtra(BrokerActivity.BROKER_INTENT, brokerAuthorizationIntent);
        LocalBroadcaster.INSTANCE.registerCallback(com.microsoft.identity.common.java.AuthenticationConstants.LocalBroadcasterAliases.RETURN_BROKER_INTERACTIVE_ACQUIRE_TOKEN_RESULT, new LocalBroadcaster.IReceiverCallback() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.1
            @Override // com.microsoft.identity.common.java.util.ported.LocalBroadcaster.IReceiverCallback
            public void onReceive(PropertyBag propertyBag) {
                Logger.verbose(str, "Received result from Broker...");
                Telemetry.emit(new ApiStartEvent().putApiId(TelemetryEventStrings.Api.BROKER_COMPLETE_ACQUIRE_TOKEN_INTERACTIVE).put(TelemetryEventStrings.Key.REQUEST_CODE, ((Integer) propertyBag.getOrDefault(com.microsoft.identity.common.java.AuthenticationConstants.LocalBroadcasterFields.REQUEST_CODE, -1)).toString()).put(TelemetryEventStrings.Key.RESULT_CODE, ((Integer) propertyBag.getOrDefault(com.microsoft.identity.common.java.AuthenticationConstants.LocalBroadcasterFields.RESULT_CODE, -1)).toString()));
                BrokerMsalController.this.mBrokerResultFuture.setResult(PropertyBagUtil.toBundle(propertyBag));
                Telemetry.emit(new ApiEndEvent().putApiId(TelemetryEventStrings.Api.BROKER_COMPLETE_ACQUIRE_TOKEN_INTERACTIVE));
                LocalBroadcaster.INSTANCE.unregisterCallback(com.microsoft.identity.common.java.AuthenticationConstants.LocalBroadcasterAliases.RETURN_BROKER_INTERACTIVE_ACQUIRE_TOKEN_RESULT);
            }
        });
        if (activity == null) {
            intent.addFlags(268435456);
            this.mApplicationContext.startActivity(intent);
        } else {
            activity.startActivity(intent);
        }
        try {
            Bundle bundle = this.mBrokerResultFuture.get();
            String stringExtra = brokerAuthorizationIntent.getStringExtra(AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY);
            if (interactiveTokenCommandParameters.getOAuth2TokenCache() != null && !BrokerProtocolVersionUtil.canSupportMsaAccountsInBroker(stringExtra)) {
                saveMsaAccountToCache(bundle, (MsalOAuth2TokenCache) interactiveTokenCommandParameters.getOAuth2TokenCache());
            }
            verifyBrokerVersionIsSupported(bundle, interactiveTokenCommandParameters.getRequiredBrokerProtocolVersion());
            AcquireTokenResult acquireTokenResultFromResultBundle = this.mResultAdapter.getAcquireTokenResultFromResultBundle(bundle);
            Telemetry.emit(new ApiEndEvent().putResult(acquireTokenResultFromResultBundle).putApiId(TelemetryEventStrings.Api.BROKER_ACQUIRE_TOKEN_INTERACTIVE));
            return acquireTokenResultFromResultBundle;
        } catch (BaseException | ExecutionException e) {
            Telemetry.emit(new ApiEndEvent().putException(e).putApiId(TelemetryEventStrings.Api.BROKER_ACQUIRE_TOKEN_INTERACTIVE));
            throw e;
        }
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public void onFinishAuthorizationSession(int i, int i2, PropertyBag propertyBag) {
        throw new UnsupportedOperationException();
    }

    private Intent getBrokerAuthorizationIntent(final InteractiveTokenCommandParameters interactiveTokenCommandParameters) throws BaseException {
        return (Intent) getBrokerOperationExecutor().execute(interactiveTokenCommandParameters, new BrokerOperationExecutor.BrokerOperation<Intent>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.2
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, Intent intent) {
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                BrokerMsalController.this.verifyTokenParametersAreSupported(interactiveTokenCommandParameters);
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, interactiveTokenCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_GET_INTENT_FOR_INTERACTIVE_REQUEST, BrokerMsalController.this.mActiveBrokerPackageName, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public Intent extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle == null) {
                    throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
                }
                Intent intentForInteractiveRequestFromResultBundle = BrokerMsalController.this.mResultAdapter.getIntentForInteractiveRequestFromResultBundle(bundle, this.negotiatedBrokerProtocolVersion);
                intentForInteractiveRequestFromResultBundle.putExtras(BrokerMsalController.this.mRequestAdapter.getRequestBundleForAcquireTokenInteractive(interactiveTokenCommandParameters, this.negotiatedBrokerProtocolVersion));
                return intentForInteractiveRequestFromResultBundle;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":getBrokerAuthorizationIntent";
            }
        });
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AuthorizationResult deviceCodeFlowAuthRequest(final DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters) throws BaseException {
        return (AuthorizationResult) getBrokerOperationExecutor().execute(deviceCodeFlowCommandParameters, new BrokerOperationExecutor.BrokerOperation<AuthorizationResult>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.3
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, AuthorizationResult authorizationResult) {
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, deviceCodeFlowCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_FETCH_DCF_AUTH_RESULT, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForDeviceCodeFlowAuthRequest(BrokerMsalController.this.mApplicationContext, deviceCodeFlowCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public AuthorizationResult extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle != null) {
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, deviceCodeFlowCommandParameters.getRequiredBrokerProtocolVersion());
                    return BrokerMsalController.this.mResultAdapter.getDeviceCodeFlowAuthResultFromResultBundle(bundle);
                }
                throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":deviceCodeFlowAuthRequest";
            }
        });
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AcquireTokenResult acquireDeviceCodeFlowToken(final AuthorizationResult authorizationResult, final DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters) throws BaseException {
        return (AcquireTokenResult) getBrokerOperationExecutor().execute(deviceCodeFlowCommandParameters, new BrokerOperationExecutor.BrokerOperation<AcquireTokenResult>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.4
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, deviceCodeFlowCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_ACQUIRE_TOKEN_DCF, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForDeviceCodeFlowTokenRequest(BrokerMsalController.this.mApplicationContext, deviceCodeFlowCommandParameters, authorizationResult, this.negotiatedBrokerProtocolVersion));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public AcquireTokenResult extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle != null) {
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, deviceCodeFlowCommandParameters.getRequiredBrokerProtocolVersion());
                    AcquireTokenResult deviceCodeFlowTokenResultFromResultBundle = BrokerMsalController.this.mResultAdapter.getDeviceCodeFlowTokenResultFromResultBundle(bundle);
                    if (deviceCodeFlowTokenResultFromResultBundle != null) {
                        return deviceCodeFlowTokenResultFromResultBundle;
                    }
                    ThreadUtils.sleepSafely((int) BrokerMsalController.WAIT_BETWEEN_DCF_POLLING_MILLISECONDS, BrokerMsalController.TAG, "Attempting to sleep thread during Device Code Flow token polling...");
                    return BrokerMsalController.this.acquireDeviceCodeFlowToken(authorizationResult, deviceCodeFlowCommandParameters);
                }
                throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":deviceCodeFlowAuthRequest";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, AcquireTokenResult acquireTokenResult) {
                apiEndEvent.putResult(acquireTokenResult);
            }
        });
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AcquireTokenResult acquireTokenSilent(final SilentTokenCommandParameters silentTokenCommandParameters) throws BaseException {
        return (AcquireTokenResult) getBrokerOperationExecutor().execute(silentTokenCommandParameters, new BrokerOperationExecutor.BrokerOperation<AcquireTokenResult>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.5
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                BrokerMsalController.this.verifyTokenParametersAreSupported(silentTokenCommandParameters);
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, silentTokenCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_ACQUIRE_TOKEN_SILENT, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForAcquireTokenSilent(BrokerMsalController.this.mApplicationContext, silentTokenCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public AcquireTokenResult extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle != null) {
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, silentTokenCommandParameters.getRequiredBrokerProtocolVersion());
                    return BrokerMsalController.this.mResultAdapter.getAcquireTokenResultFromResultBundle(bundle);
                }
                throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":acquireTokenSilent";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return TelemetryEventStrings.Api.BROKER_ACQUIRE_TOKEN_SILENT;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, AcquireTokenResult acquireTokenResult) {
                apiEndEvent.putResult(acquireTokenResult);
            }
        });
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public List<ICacheRecord> getAccounts(final CommandParameters commandParameters) throws BaseException {
        return (List) getBrokerOperationExecutor().execute(commandParameters, new BrokerOperationExecutor.BrokerOperation<List<ICacheRecord>>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.6
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, commandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_GET_ACCOUNTS, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForGetAccounts(commandParameters, this.negotiatedBrokerProtocolVersion));
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public List<ICacheRecord> extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle != null) {
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, commandParameters.getRequiredBrokerProtocolVersion());
                    return BrokerMsalController.this.mResultAdapter.getAccountsFromResultBundle(bundle);
                }
                throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":getAccounts";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return TelemetryEventStrings.Api.BROKER_GET_ACCOUNTS;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, List<ICacheRecord> list) {
                apiEndEvent.put(TelemetryEventStrings.Key.ACCOUNTS_NUMBER, Integer.toString(list.size()));
            }
        });
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public boolean removeAccount(final RemoveAccountCommandParameters removeAccountCommandParameters) throws BaseException {
        return ((Boolean) getBrokerOperationExecutor().execute(removeAccountCommandParameters, new BrokerOperationExecutor.BrokerOperation<Boolean>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.7
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, Boolean bool) {
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, removeAccountCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_REMOVE_ACCOUNT, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForRemoveAccount(removeAccountCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public Boolean extractResultBundle(Bundle bundle) throws BaseException {
                BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, removeAccountCommandParameters.getRequiredBrokerProtocolVersion());
                BrokerMsalController.this.mResultAdapter.verifyRemoveAccountResultFromBundle(bundle);
                return true;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":removeAccount";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return TelemetryEventStrings.Api.BROKER_REMOVE_ACCOUNT;
            }
        })).booleanValue();
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public PreferredAuthMethod getPreferredAuthMethod() throws BaseException {
        final String str = TAG + ":getPreferredAuthMethod";
        return (PreferredAuthMethod) getBrokerOperationExecutor().execute(null, new BrokerOperationExecutor.BrokerOperation<PreferredAuthMethod>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.8
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, PreferredAuthMethod preferredAuthMethod) {
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BrokerCommunicationException {
                if ((iIpcStrategy instanceof BoundServiceStrategy) || (iIpcStrategy instanceof AccountManagerAddAccountStrategy)) {
                    String str2 = iIpcStrategy + " is not supported for getPreferredAuthMethod operation";
                    Logger.warn(str, str2);
                    throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_SERVER_SIDE, iIpcStrategy.getType(), str2, null);
                }
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_GET_PREFERRED_AUTH_METHOD, BrokerMsalController.this.mActiveBrokerPackageName, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public PreferredAuthMethod extractResultBundle(Bundle bundle) throws BaseException {
                return BrokerMsalController.this.mResultAdapter.getPreferredAuthMethodFromResultBundle(bundle);
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":getPreferredAuthMethod";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return TelemetryEventStrings.Api.GET_PREFERRED_AUTH_METHOD;
            }
        });
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public boolean getDeviceMode(CommandParameters commandParameters) throws BaseException {
        return ((Boolean) getBrokerOperationExecutor().execute(commandParameters, new BrokerOperationExecutor.BrokerOperation<Boolean>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.9
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) {
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_GET_DEVICE_MODE, BrokerMsalController.this.mActiveBrokerPackageName, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public Boolean extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle == null) {
                    throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
                }
                return Boolean.valueOf(BrokerMsalController.this.mResultAdapter.getDeviceModeFromResultBundle(bundle));
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":getDeviceMode";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return TelemetryEventStrings.Api.GET_BROKER_DEVICE_MODE;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, Boolean bool) {
                apiEndEvent.put(TelemetryEventStrings.Key.IS_DEVICE_SHARED, Boolean.toString(bool.booleanValue()));
            }
        })).booleanValue();
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public List<ICacheRecord> getCurrentAccount(final CommandParameters commandParameters) throws BaseException {
        if (!commandParameters.isSharedDevice()) {
            Logger.verbose(TAG + ":getCurrentAccount", "Not a shared device, invoke getAccounts() instead of getCurrentAccount()");
            return getAccounts(commandParameters);
        }
        return (List) getBrokerOperationExecutor().execute(commandParameters, new BrokerOperationExecutor.BrokerOperation<List<ICacheRecord>>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.10
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, commandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_GET_CURRENT_ACCOUNT_IN_SHARED_DEVICE, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForGetAccounts(commandParameters, this.negotiatedBrokerProtocolVersion));
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public List<ICacheRecord> extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle != null) {
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, commandParameters.getRequiredBrokerProtocolVersion());
                    return BrokerMsalController.this.mResultAdapter.getAccountsFromResultBundle(bundle);
                }
                throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":getCurrentAccount";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return TelemetryEventStrings.Api.BROKER_GET_CURRENT_ACCOUNT;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, List<ICacheRecord> list) {
                apiEndEvent.put(TelemetryEventStrings.Key.ACCOUNTS_NUMBER, Integer.toString(list.size()));
            }
        });
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public boolean removeCurrentAccount(final RemoveAccountCommandParameters removeAccountCommandParameters) throws BaseException {
        if (!removeAccountCommandParameters.isSharedDevice()) {
            Logger.verbose(":removeCurrentAccount", "Not a shared device, invoke removeAccount() instead of removeCurrentAccount()");
            return removeAccount(removeAccountCommandParameters);
        }
        return ((Boolean) getBrokerOperationExecutor().execute(removeAccountCommandParameters, new BrokerOperationExecutor.BrokerOperation<Boolean>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.11
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, Boolean bool) {
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, removeAccountCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_SIGN_OUT_FROM_SHARED_DEVICE, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForRemoveAccountFromSharedDevice(removeAccountCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public Boolean extractResultBundle(Bundle bundle) throws BaseException {
                BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, removeAccountCommandParameters.getRequiredBrokerProtocolVersion());
                BrokerMsalController.this.mResultAdapter.verifyRemoveAccountResultFromBundle(bundle);
                return true;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":removeCurrentAccount";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return TelemetryEventStrings.Api.BROKER_REMOVE_ACCOUNT_FROM_SHARED_DEVICE;
            }
        })).booleanValue();
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public AcquireTokenResult acquireTokenWithPassword(RopcTokenCommandParameters ropcTokenCommandParameters) throws Exception {
        if (ropcTokenCommandParameters == null) {
            throw new NullPointerException("parameters is marked non-null but is null");
        }
        throw new ClientException("acquireTokenWithPassword() not supported in BrokerMsalController");
    }

    @Override // com.microsoft.identity.common.java.controllers.BaseController
    public GenerateShrResult generateSignedHttpRequest(final GenerateShrCommandParameters generateShrCommandParameters) throws BaseException {
        return (GenerateShrResult) getBrokerOperationExecutor().execute(generateShrCommandParameters, new BrokerOperationExecutor.BrokerOperation<GenerateShrResult>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.12
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, GenerateShrResult generateShrResult) {
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, generateShrCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() throws ClientException {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_GENERATE_SHR, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForGenerateShr(generateShrCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public GenerateShrResult extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle != null) {
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, generateShrCommandParameters.getRequiredBrokerProtocolVersion());
                    return BrokerMsalController.this.mResultAdapter.getGenerateShrResultFromResultBundle(bundle);
                }
                throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":generateSignedHttpRequest";
            }
        });
    }

    public AcquirePrtSsoTokenResult getSsoToken(final AcquirePrtSsoTokenCommandParameters acquirePrtSsoTokenCommandParameters) throws BaseException {
        return (AcquirePrtSsoTokenResult) getBrokerOperationExecutor().execute(acquirePrtSsoTokenCommandParameters, new BrokerOperationExecutor.BrokerOperation<AcquirePrtSsoTokenResult>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.13
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, AcquirePrtSsoTokenResult acquirePrtSsoTokenResult) {
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, acquirePrtSsoTokenCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() throws ClientException {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_SSO_TOKEN, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForSsoToken(acquirePrtSsoTokenCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public AcquirePrtSsoTokenResult extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle != null) {
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, acquirePrtSsoTokenCommandParameters.getRequiredBrokerProtocolVersion());
                    return BrokerMsalController.this.mResultAdapter.getAcquirePrtSsoTokenResultFromBundle(bundle);
                }
                throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":getSsoToken";
            }
        });
    }

    public AcquirePrtSsoTokenBatchResult getAllSsoTokens(final AcquirePrtSsoTokenCommandParameters acquirePrtSsoTokenCommandParameters) throws BaseException {
        return (AcquirePrtSsoTokenBatchResult) getBrokerOperationExecutor().execute(acquirePrtSsoTokenCommandParameters, new BrokerOperationExecutor.BrokerOperation<AcquirePrtSsoTokenBatchResult>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.14
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, AcquirePrtSsoTokenBatchResult acquirePrtSsoTokenBatchResult) {
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, acquirePrtSsoTokenCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() throws ClientException {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.MSAL_ALL_SSO_TOKENS, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForAllSsoTokens(acquirePrtSsoTokenCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public AcquirePrtSsoTokenBatchResult extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle != null) {
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, acquirePrtSsoTokenCommandParameters.getRequiredBrokerProtocolVersion());
                    return BrokerMsalController.this.mResultAdapter.getAcquirePrtSsoTokenBatchResultFromBundle(bundle);
                }
                throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":getAllSsoTokens";
            }
        });
    }

    public ICacheRecord provisionResourceAccount(final ResourceAccountCommandParameters resourceAccountCommandParameters) throws BaseException {
        return (ICacheRecord) getBrokerOperationExecutor().execute(resourceAccountCommandParameters, new BrokerOperationExecutor.BrokerOperation<ICacheRecord>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.15
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, resourceAccountCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.PROVISION_RESOURCE_ACCOUNT, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForProvisionResourceAccount(resourceAccountCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public ICacheRecord extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle != null) {
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, resourceAccountCommandParameters.getRequiredBrokerProtocolVersion());
                    return BrokerMsalController.this.mResultAdapter.resourceAccountRecordFromBundle(bundle);
                }
                throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":provisionResourceAccount";
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, ICacheRecord iCacheRecord) {
                if (apiEndEvent == null) {
                    throw new NullPointerException("event is marked non-null but is null");
                }
                if (iCacheRecord == null) {
                    throw new NullPointerException("result is marked non-null but is null");
                }
            }
        });
    }

    public AadDeviceIdRecord getAadDeviceId(final GetAadDeviceIdCommandParameters getAadDeviceIdCommandParameters) throws BaseException {
        return (AadDeviceIdRecord) getBrokerOperationExecutor().execute(getAadDeviceIdCommandParameters, new BrokerOperationExecutor.BrokerOperation<AadDeviceIdRecord>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.16
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, AadDeviceIdRecord aadDeviceIdRecord) {
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, getAadDeviceIdCommandParameters.getRequiredBrokerProtocolVersion());
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() throws ClientException {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.GET_AAD_DEVICE_ID, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForAadDeviceIdRequest(getAadDeviceIdCommandParameters, this.negotiatedBrokerProtocolVersion));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public AadDeviceIdRecord extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle != null) {
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, getAadDeviceIdCommandParameters.getRequiredBrokerProtocolVersion());
                    return BrokerMsalController.this.mResultAdapter.aadDeviceIdRecordFromBundle(bundle);
                }
                throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":getAadDeviceId";
            }
        });
    }

    public String getSupportedWebAppContracts(final String str) throws BaseException {
        return (String) getBrokerOperationExecutor().execute(null, new BrokerOperationExecutor.BrokerOperation<String>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.17
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, String str2) {
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, str);
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() throws ClientException {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.BROKER_WEBAPPS_API_GET_SUPPORTED_WEB_APPS_CONTRACTS, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForGetSupportedWebAppContracts(this.negotiatedBrokerProtocolVersion, str));
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle != null) {
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, str);
                    return BrokerMsalController.this.mResultAdapter.getSupportedWebAppsContractFromBundle(bundle);
                }
                throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":getSupportedWebAppContracts";
            }
        });
    }

    public String executeWebAppRequest(final String str, final String str2, WebAppsAdditionalRequiredParameters webAppsAdditionalRequiredParameters) throws BaseException {
        return (String) getBrokerOperationExecutor().execute(null, new BrokerOperationExecutor.BrokerOperation<String>() { // from class: com.microsoft.identity.common.internal.controllers.BrokerMsalController.18
            private String negotiatedBrokerProtocolVersion;

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getTelemetryApiId() {
                return null;
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void putValueInSuccessEvent(ApiEndEvent apiEndEvent, String str3) {
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException {
                this.negotiatedBrokerProtocolVersion = BrokerMsalController.this.hello(iIpcStrategy, str2);
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public BrokerOperationBundle getBundle() throws ClientException {
                return new BrokerOperationBundle(BrokerOperationBundle.Operation.BROKER_WEBAPPS_API_EXECUTE_WEB_APPS_REQUEST, BrokerMsalController.this.mActiveBrokerPackageName, BrokerMsalController.this.mRequestAdapter.getRequestBundleForExecuteWebAppRequest(str, this.negotiatedBrokerProtocolVersion, str2));
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String extractResultBundle(Bundle bundle) throws BaseException {
                if (bundle != null) {
                    BrokerMsalController.this.verifyBrokerVersionIsSupported(bundle, str2);
                    return BrokerMsalController.this.mResultAdapter.getExecuteWebAppRequestResultFromBundle(bundle);
                }
                throw BrokerMsalController.this.mResultAdapter.getExceptionForEmptyResultBundle();
            }

            @Override // com.microsoft.identity.common.internal.controllers.BrokerOperationExecutor.BrokerOperation
            public String getMethodName() {
                return ":executeWebAppRequest";
            }
        });
    }

    private void saveMsaAccountToCache(Bundle bundle, MsalOAuth2TokenCache msalOAuth2TokenCache) throws BaseException {
        String str = TAG + ":saveMsaAccountToCache";
        BrokerResult brokerResultBrokerResultFromBundle = new MsalBrokerResultAdapter().brokerResultFromBundle(bundle);
        if (bundle.getBoolean(AuthenticationConstants.Broker.BROKER_REQUEST_V2_SUCCESS) && AzureActiveDirectoryAudience.MSA_MEGA_TENANT_ID.equalsIgnoreCase(brokerResultBrokerResultFromBundle.getTenantId())) {
            Logger.info(str, "Result returned for MSA Account, saving to cache");
            if (StringUtil.isNullOrEmpty(brokerResultBrokerResultFromBundle.getClientInfo())) {
                Logger.error(str, "ClientInfo is empty.", null);
                throw new ClientException("unknown_error", "ClientInfo is empty.");
            }
            try {
                ClientInfo clientInfo = new ClientInfo(brokerResultBrokerResultFromBundle.getClientInfo());
                MicrosoftStsAccount microsoftStsAccount = new MicrosoftStsAccount(new IDToken(brokerResultBrokerResultFromBundle.getIdToken()), clientInfo);
                microsoftStsAccount.setEnvironment(brokerResultBrokerResultFromBundle.getEnvironment());
                msalOAuth2TokenCacheSetSingleSignOnState(msalOAuth2TokenCache, microsoftStsAccount, new MicrosoftRefreshToken(brokerResultBrokerResultFromBundle.getRefreshToken(), clientInfo, brokerResultBrokerResultFromBundle.getScope(), brokerResultBrokerResultFromBundle.getClientId(), brokerResultBrokerResultFromBundle.getEnvironment(), brokerResultBrokerResultFromBundle.getFamilyId()));
            } catch (ServiceException e) {
                Logger.errorPII(str, "Exception while creating Idtoken or ClientInfo, cannot save MSA account tokens", e);
                throw new ClientException("invalid_jwt", e.getMessage(), e);
            }
        }
    }

    private void msalOAuth2TokenCacheSetSingleSignOnState(MsalOAuth2TokenCache msalOAuth2TokenCache, MicrosoftStsAccount microsoftStsAccount, MicrosoftRefreshToken microsoftRefreshToken) throws ClientException {
        msalOAuth2TokenCache.setSingleSignOnState(microsoftStsAccount, microsoftRefreshToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyTokenParametersAreSupported(TokenCommandParameters tokenCommandParameters) throws ClientException {
        String requiredBrokerProtocolVersion = tokenCommandParameters.getRequiredBrokerProtocolVersion();
        if ((tokenCommandParameters.getAuthenticationScheme() instanceof PopAuthenticationSchemeWithClientKeyInternal) && !BrokerProtocolVersionUtil.canSupportPopAuthenticationSchemeWithClientKey(requiredBrokerProtocolVersion)) {
            throw new ClientException(ClientException.AUTH_SCHEME_NOT_SUPPORTED, "The min broker protocol version for PopAuthenticationSchemeWithClientKey should be equal or more than 11.0. Current required version is set to: " + requiredBrokerProtocolVersion);
        }
        validateNestedAppAuthParameters(tokenCommandParameters, requiredBrokerProtocolVersion);
    }

    private void validateNestedAppAuthParameters(TokenCommandParameters tokenCommandParameters, String str) throws ClientException {
        if (tokenCommandParameters.hasNestedAppParameters()) {
            if (!StringUtil.isNullOrEmpty(tokenCommandParameters.getChildClientId()) && !StringUtil.isNullOrEmpty(tokenCommandParameters.getChildRedirectUri()) && !BrokerProtocolVersionUtil.canSupportNestedAppAuthentication(str)) {
                throw new ClientException(ClientException.NESTED_APP_AUTH_NOT_SUPPORTED, "The min broker protocol version for Nested app auth should be equal or more than 15.0. Current required version is set to: " + str);
            }
            if (StringUtil.isNullOrEmpty(tokenCommandParameters.getChildClientId())) {
                throw new ClientException(ClientException.NESTED_APP_INVALID_PARAMETERS, "ClientId of the nested app is null or empty");
            }
            if (StringUtil.isNullOrEmpty(tokenCommandParameters.getChildRedirectUri())) {
                throw new ClientException(ClientException.NESTED_APP_INVALID_PARAMETERS, "RedirectURI of the nested app is null or empty");
            }
            if (tokenCommandParameters.getSdkType() != SdkType.MSAL_CPP) {
                throw new ClientException(ClientException.NESTED_APP_INVALID_PARAMETERS, "Nested app auth is only supported for request originating from OneAuth");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyBrokerVersionIsSupported(Bundle bundle, String str) throws UnsupportedBrokerException {
        String str2 = TAG + ":verifyBrokerVersionIsSupported";
        if (bundle == null) {
            Logger.info(str2, "result bundle is null");
            return;
        }
        try {
            BrokerResult brokerResultBrokerResultFromBundle = this.mResultAdapter.brokerResultFromBundle(bundle);
            if (!brokerResultBrokerResultFromBundle.isSuccess() && ErrorStrings.UNSUPPORTED_BROKER_VERSION_ERROR_CODE.equals(brokerResultBrokerResultFromBundle.getErrorCode())) {
                this.mHelloCache.saveHandshakeError(str, "19.0");
                throw new UnsupportedBrokerException(this.mActiveBrokerPackageName);
            }
        } catch (ClientException unused) {
            Logger.info(str2, "ResultBundle does not contain BrokerResult. So, this is not likely a broker version supported issue. Continuing.");
        }
    }
}
