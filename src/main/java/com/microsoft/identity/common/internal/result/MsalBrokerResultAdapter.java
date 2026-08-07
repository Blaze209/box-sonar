package com.microsoft.identity.common.internal.result;

import android.content.Intent;
import android.os.Bundle;
import com.google.gson.Gson;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.adal.internal.util.HashMapExtensions;
import com.microsoft.identity.common.adal.internal.util.JsonExtensions;
import com.microsoft.identity.common.internal.broker.BrokerResult;
import com.microsoft.identity.common.internal.request.AuthenticationSchemeTypeAdapter;
import com.microsoft.identity.common.internal.util.GzipUtil;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.java.cache.CacheRecord;
import com.microsoft.identity.common.java.cache.ICacheRecord;
import com.microsoft.identity.common.java.commands.AcquirePrtSsoTokenBatchResult;
import com.microsoft.identity.common.java.commands.AcquirePrtSsoTokenResult;
import com.microsoft.identity.common.java.constants.OAuth2ErrorCode;
import com.microsoft.identity.common.java.constants.OAuth2SubErrorCode;
import com.microsoft.identity.common.java.dto.AadDeviceIdRecord;
import com.microsoft.identity.common.java.dto.AccessTokenRecord;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.exception.IntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.exception.UiRequiredException;
import com.microsoft.identity.common.java.exception.UnsupportedBrokerException;
import com.microsoft.identity.common.java.exception.UserCancelException;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.request.SdkType;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.result.GenerateShrResult;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.java.result.LocalAuthenticationResult;
import com.microsoft.identity.common.java.ui.PreferredAuthMethod;
import com.microsoft.identity.common.java.util.BrokerProtocolVersionUtil;
import com.microsoft.identity.common.java.util.HeaderSerializationUtil;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ThrowableUtil;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.json.JSONException;

/* JADX INFO: loaded from: classes14.dex */
public class MsalBrokerResultAdapter implements IBrokerResultAdapter {
    private static final String DCF_NOT_SUPPORTED_ERROR = "deviceCodeFlowAuthRequest() not supported in BrokerMsalController";
    public static final Gson GSON = new Gson();
    public static final String REMOVE_RT_FROM_AAD_RESULT_MSAL_PROTOCOL_VERSION = "16.0";
    private static final String TAG = "MsalBrokerResultAdapter";
    private static final String WEBAPPS_ENTRY_IS_NULL_ERROR = "WebApps entry in the bundle is null";
    private final IBooleanCallback mShouldStopReturningRtWithAadResponseCallback;

    interface IBooleanCallback {
        boolean getResult();
    }

    static /* synthetic */ boolean lambda$new$1(boolean z) {
        return z;
    }

    public MsalBrokerResultAdapter() {
        this.mShouldStopReturningRtWithAadResponseCallback = new IBooleanCallback() { // from class: com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter$$ExternalSyntheticLambda0
            @Override // com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter.IBooleanCallback
            public final boolean getResult() {
                return CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.STOP_RETURNING_AAD_RT_BACK_TO_CALLING_APP);
            }
        };
    }

    public MsalBrokerResultAdapter(final boolean z) {
        this.mShouldStopReturningRtWithAadResponseCallback = new IBooleanCallback() { // from class: com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter$$ExternalSyntheticLambda1
            @Override // com.microsoft.identity.common.internal.result.MsalBrokerResultAdapter.IBooleanCallback
            public final boolean getResult() {
                return MsalBrokerResultAdapter.lambda$new$1(z);
            }
        };
    }

    @Override // com.microsoft.identity.common.internal.result.IBrokerResultAdapter
    public Bundle bundleFromAuthenticationResult(ILocalAuthenticationResult iLocalAuthenticationResult, String str) {
        Logger.info(TAG + ":bundleFromAuthenticationResult", "Constructing result bundle from ILocalAuthenticationResult");
        Bundle bundleBundleFromBrokerResult = bundleFromBrokerResult(buildBrokerResultFromAuthenticationResult(iLocalAuthenticationResult, str), str);
        bundleBundleFromBrokerResult.putBoolean(AuthenticationConstants.Broker.BROKER_REQUEST_V2_SUCCESS, true);
        return bundleBundleFromBrokerResult;
    }

    public BrokerResult buildBrokerResultFromAuthenticationResult(ILocalAuthenticationResult iLocalAuthenticationResult, String str) {
        IAccountRecord accountRecord = iLocalAuthenticationResult.getAccountRecord();
        AccessTokenRecord accessTokenRecord = iLocalAuthenticationResult.getAccessTokenRecord();
        long j = Long.parseLong(accessTokenRecord.getExpiresOn());
        BrokerResult.Builder builderServicedFromCache = new BrokerResult.Builder().tenantProfileRecords(iLocalAuthenticationResult.getCacheRecordWithTenantProfileData()).accessToken(iLocalAuthenticationResult.getAccessToken()).idToken(iLocalAuthenticationResult.getIdToken()).homeAccountId(accountRecord.getHomeAccountId()).localAccountId(accountRecord.getLocalAccountId()).userName(accountRecord.getUsername()).tokenType(accessTokenRecord.getAccessTokenType()).clientId(accessTokenRecord.getClientId()).familyId(iLocalAuthenticationResult.getFamilyId()).scope(accessTokenRecord.getTarget()).clientInfo(accountRecord.getClientInfo()).authority(accessTokenRecord.getAuthority()).environment(accessTokenRecord.getEnvironment()).tenantId(iLocalAuthenticationResult.getTenantId()).expiresOn(j).extendedExpiresOn(accessTokenRecord.getExtendedExpiresOn() == null ? j : Long.parseLong(accessTokenRecord.getExtendedExpiresOn())).cachedAt(Long.parseLong(accessTokenRecord.getCachedAt())).speRing(iLocalAuthenticationResult.getSpeRing()).success(true).servicedFromCache(iLocalAuthenticationResult.isServicedFromCache());
        if (shouldRemoveRefreshTokenFromResult(iLocalAuthenticationResult, str)) {
            builderServicedFromCache.tenantProfileRecords(removeRefreshTokenFromCacheRecords(iLocalAuthenticationResult.getCacheRecordWithTenantProfileData()));
        } else {
            builderServicedFromCache.tenantProfileRecords(iLocalAuthenticationResult.getCacheRecordWithTenantProfileData()).refreshToken(iLocalAuthenticationResult.getRefreshToken()).refreshTokenAge(iLocalAuthenticationResult.getRefreshTokenAge());
        }
        return builderServicedFromCache.build();
    }

    private List<ICacheRecord> removeRefreshTokenFromCacheRecords(List<ICacheRecord> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (ICacheRecord iCacheRecord : list) {
            arrayList.add(CacheRecord.builder().account(iCacheRecord.getAccount()).idToken(iCacheRecord.getIdToken()).v1IdToken(iCacheRecord.getV1IdToken()).accessToken(iCacheRecord.getAccessToken()).build());
        }
        return arrayList;
    }

    private boolean shouldRemoveRefreshTokenFromResult(ILocalAuthenticationResult iLocalAuthenticationResult, String str) {
        String str2 = TAG + ":shouldRemoveRefreshTokenFromResult";
        if (this.mShouldStopReturningRtWithAadResponseCallback.getResult()) {
            if (!BrokerProtocolVersionUtil.isFirstVersionOlderOrEqual(REMOVE_RT_FROM_AAD_RESULT_MSAL_PROTOCOL_VERSION, str)) {
                SpanExtension.current().setAttribute(AttributeName.stop_returning_rt_result.name(), "protocol_version_too_low");
                return false;
            }
            try {
                boolean z = true;
                if (!StringUtil.isNullOrEmpty(iLocalAuthenticationResult.getTenantId())) {
                    boolean z2 = !AzureActiveDirectoryAudience.MSA_MEGA_TENANT_ID.equalsIgnoreCase(iLocalAuthenticationResult.getTenantId());
                    SpanExtension.current().setAttribute(AttributeName.stop_returning_rt_result.name(), Boolean.toString(z2));
                    return z2;
                }
                if (!StringUtil.isNullOrEmpty(iLocalAuthenticationResult.getAccessTokenRecord().getAuthority())) {
                    if (iLocalAuthenticationResult.getAccessTokenRecord().getAuthority().contains(AzureActiveDirectoryAudience.MSA_MEGA_TENANT_ID) || iLocalAuthenticationResult.getAccessTokenRecord().getAuthority().contains("consumers")) {
                        z = false;
                    }
                    SpanExtension.current().setAttribute(AttributeName.stop_returning_rt_result.name(), Boolean.toString(z));
                    return z;
                }
                SpanExtension.current().setAttribute(AttributeName.stop_returning_rt_result.name(), "cannot_determine_account_type");
                return false;
            } catch (Throwable th) {
                Logger.error(str2, "Failed to determine if RT should be removed", th);
                SpanExtension.current().setAttribute(AttributeName.stop_returning_rt_result.name(), ThrowableUtil.getStackTraceAsString(th));
                return false;
            }
        }
        SpanExtension.current().setAttribute(AttributeName.stop_returning_rt_result.name(), "feature_disabled");
        return false;
    }

    @Override // com.microsoft.identity.common.internal.result.IBrokerResultAdapter
    public Bundle bundleFromBaseException(BaseException baseException, String str) {
        Logger.info(TAG + ":bundleFromBaseException", "Constructing result bundle from ClientException");
        BrokerResult.Builder builderRefreshTokenAge = new BrokerResult.Builder().success(false).errorCode(baseException.getErrorCode()).subErrorCode(baseException.getSubErrorCode()).errorMessage(baseException.getMessage()).exceptionType(baseException.getExceptionName()).correlationId(baseException.getCorrelationId()).cliTelemErrorCode(baseException.getCliTelemErrorCode()).cliTelemSubErrorCode(baseException.getCliTelemSubErrorCode()).speRing(baseException.getSpeRing()).refreshTokenAge(baseException.getRefreshTokenAge());
        if (baseException instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) baseException;
            builderRefreshTokenAge.subErrorCode(serviceException.getSubErrorCode()).httpStatusCode(serviceException.getHttpStatusCode()).httpResponseBody(AuthenticationSchemeTypeAdapter.getGsonInstance().toJson(serviceException.getHttpResponseBody()));
            if (serviceException.getHttpResponseHeaders() != null) {
                builderRefreshTokenAge.httpResponseHeaders(HeaderSerializationUtil.toJson(serviceException.getHttpResponseHeaders()));
            }
            if (serviceException.getHttpResponseBody() != null) {
                builderRefreshTokenAge.httpResponseBody(AuthenticationSchemeTypeAdapter.getGsonInstance().toJson(serviceException.getHttpResponseBody()));
            }
        }
        if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ADD_USERNAME_IN_UI_REQUIRED_EXCEPTION_BROKER_RESULT) && (baseException instanceof UiRequiredException)) {
            builderRefreshTokenAge.userName(baseException.getUsername());
        }
        if (baseException instanceof IntuneAppProtectionPolicyRequiredException) {
            SpanExtension.current().setAttribute(AttributeName.is_mam_flow.name(), true);
            IntuneAppProtectionPolicyRequiredException intuneAppProtectionPolicyRequiredException = (IntuneAppProtectionPolicyRequiredException) baseException;
            builderRefreshTokenAge.userName(intuneAppProtectionPolicyRequiredException.getAccountUpn()).localAccountId(intuneAppProtectionPolicyRequiredException.getAccountUserId()).authority(intuneAppProtectionPolicyRequiredException.getAuthorityUrl()).tenantId(intuneAppProtectionPolicyRequiredException.getTenantId());
        }
        Bundle bundleBundleFromBrokerResult = bundleFromBrokerResult(builderRefreshTokenAge.build(), str);
        bundleBundleFromBrokerResult.putBoolean(AuthenticationConstants.Broker.BROKER_REQUEST_V2_SUCCESS, false);
        return bundleBundleFromBrokerResult;
    }

    @Override // com.microsoft.identity.common.internal.result.IBrokerResultAdapter
    public ILocalAuthenticationResult authenticationResultFromBundle(Bundle bundle) throws ClientException {
        String str = TAG + ":authenticationResultFromBundle";
        BrokerResult brokerResultBrokerResultFromBundle = brokerResultFromBundle(bundle);
        Logger.info(str, "Broker Result returned from Bundle, constructing authentication result");
        List<ICacheRecord> tenantProfileData = brokerResultBrokerResultFromBundle.getTenantProfileData();
        if (tenantProfileData == null) {
            Logger.error(str, "getTenantProfileData is null", null);
            throw new ClientException(ClientException.INVALID_BROKER_BUNDLE, "getTenantProfileData is null.");
        }
        return new LocalAuthenticationResult(tenantProfileData.get(0), tenantProfileData, SdkType.MSAL, brokerResultBrokerResultFromBundle.isServicedFromCache());
    }

    @Override // com.microsoft.identity.common.internal.result.IBrokerResultAdapter
    public BaseException getBaseExceptionFromBundle(Bundle bundle) {
        String str = TAG + ":getBaseExceptionFromBundle";
        Logger.info(str, "Constructing exception from result bundle");
        try {
            BrokerResult brokerResultBrokerResultFromBundle = brokerResultFromBundle(bundle);
            String exceptionType = brokerResultBrokerResultFromBundle.getExceptionType();
            if (!StringUtil.isNullOrEmpty(exceptionType)) {
                return getBaseExceptionFromExceptionType(exceptionType, brokerResultBrokerResultFromBundle);
            }
            Logger.info(str, "Exception type is not returned from the broker, using error codes to transform to the right exception");
            return getBaseExceptionFromErrorCodes(brokerResultBrokerResultFromBundle);
        } catch (ClientException e) {
            return e;
        }
    }

    @Override // com.microsoft.identity.common.internal.result.IBrokerResultAdapter
    public AcquirePrtSsoTokenResult getAcquirePrtSsoTokenResultFromBundle(Bundle bundle) {
        return (AcquirePrtSsoTokenResult) GSON.fromJson(bundle.getString(AuthenticationConstants.Broker.BROKER_GENERATE_SSO_TOKEN_RESULT), AcquirePrtSsoTokenResult.class);
    }

    @Override // com.microsoft.identity.common.internal.result.IBrokerResultAdapter
    public AcquirePrtSsoTokenBatchResult getAcquirePrtSsoTokenBatchResultFromBundle(Bundle bundle) {
        return (AcquirePrtSsoTokenBatchResult) GSON.fromJson(bundle.getString(AuthenticationConstants.Broker.BROKER_GENERATE_ALL_SSO_TOKENS_RESULT), AcquirePrtSsoTokenBatchResult.class);
    }

    public Bundle bundleFromBrokerResult(BrokerResult brokerResult, String str) {
        String str2 = TAG + ":bundleFromBrokerResult";
        Bundle bundle = new Bundle();
        String json = AuthenticationSchemeTypeAdapter.getGsonInstance().toJson(brokerResult, BrokerResult.class);
        if (BrokerProtocolVersionUtil.canCompressBrokerPayloads(str)) {
            try {
                byte[] bArrCompressString = GzipUtil.compressString(json);
                Logger.info(str2, "Broker Result, raw payload size:" + json.getBytes(AuthenticationConstants.CHARSET_UTF8).length + " ,compressed bytes " + bArrCompressString.length);
                bundle.putByteArray(AuthenticationConstants.Broker.BROKER_RESULT_V2_COMPRESSED, bArrCompressString);
                return bundle;
            } catch (IOException e) {
                Logger.error(str2, "Failed to compress Broker Result, sending as jsonString ", e);
                bundle.putString(AuthenticationConstants.Broker.BROKER_RESULT_V2, json);
                return bundle;
            }
        }
        Logger.info(str2, "Broker protocol version: " + str + " lower than compression changes, sending as string");
        bundle.putString(AuthenticationConstants.Broker.BROKER_RESULT_V2, json);
        return bundle;
    }

    public BrokerResult brokerResultFromBundle(Bundle bundle) throws ClientException {
        String strDecompressBytesToString;
        String str = TAG + ":brokerResultFromBundle";
        byte[] byteArray = bundle.getByteArray(AuthenticationConstants.Broker.BROKER_RESULT_V2_COMPRESSED);
        if (byteArray != null) {
            try {
                strDecompressBytesToString = GzipUtil.decompressBytesToString(byteArray);
            } catch (IOException e) {
                Logger.error(str, "Failed to decompress broker result :", e);
                throw new ClientException(ClientException.INVALID_BROKER_BUNDLE, "Failed to decompress broker result", e);
            }
        } else {
            strDecompressBytesToString = bundle.getString(AuthenticationConstants.Broker.BROKER_RESULT_V2);
        }
        if (StringUtil.isNullOrEmpty(strDecompressBytesToString)) {
            Logger.error(str, "Broker Result not returned from Broker", null);
            throw new ClientException(ClientException.INVALID_BROKER_BUNDLE, "Broker Result not returned from Broker", null);
        }
        return JsonExtensions.getBrokerResultFromJsonString(strDecompressBytesToString);
    }

    private BaseException getBaseExceptionFromExceptionType(String str, BrokerResult brokerResult) {
        BaseException clientException;
        String str2 = TAG + ":getBaseExceptionFromExceptionType";
        Logger.warn(str2, "Received a " + str + " from Broker : " + brokerResult.getErrorCode());
        if (str.equalsIgnoreCase(UiRequiredException.sName)) {
            clientException = getUiRequiredException(brokerResult);
        } else if (str.equalsIgnoreCase(ServiceException.sName)) {
            clientException = getServiceException(brokerResult);
        } else if (str.equalsIgnoreCase(IntuneAppProtectionPolicyRequiredException.sName)) {
            clientException = getIntuneProtectionRequiredException(brokerResult);
        } else if (str.equalsIgnoreCase(UserCancelException.sName)) {
            clientException = new UserCancelException();
        } else if (str.equalsIgnoreCase(ClientException.sName)) {
            clientException = new ClientException(brokerResult.getErrorCode(), brokerResult.getErrorMessage());
        } else if (str.equalsIgnoreCase(ArgumentException.sName)) {
            clientException = new ArgumentException(ArgumentException.BROKER_TOKEN_REQUEST_OPERATION_NAME, brokerResult.getErrorCode(), brokerResult.getErrorMessage());
        } else {
            Logger.warn(str2, " Exception type is unknown : " + str + brokerResult.getErrorCode() + ", defaulting to Client Exception ");
            clientException = new ClientException(brokerResult.getErrorCode(), brokerResult.getErrorMessage());
        }
        clientException.setSubErrorCode(brokerResult.getSubErrorCode());
        clientException.setCliTelemErrorCode(brokerResult.getCliTelemErrorCode());
        clientException.setCliTelemSubErrorCode(brokerResult.getCliTelemSubErrorCode());
        clientException.setCorrelationId(brokerResult.getCorrelationId());
        clientException.setSpeRing(brokerResult.getSpeRing());
        clientException.setRefreshTokenAge(brokerResult.getRefreshTokenAge());
        return clientException;
    }

    private BaseException getBaseExceptionFromErrorCodes(BrokerResult brokerResult) {
        BaseException uiRequiredException;
        String str = TAG + ":getBaseExceptionFromErrorCodes";
        String errorCode = brokerResult.getErrorCode();
        if (OAuth2ErrorCode.INTERACTION_REQUIRED.equalsIgnoreCase(errorCode) || "invalid_grant".equalsIgnoreCase(errorCode) || ErrorStrings.INVALID_BROKER_REFRESH_TOKEN.equalsIgnoreCase(errorCode) || "no_account_found".equalsIgnoreCase(errorCode) || "no_tokens_found".equalsIgnoreCase(errorCode)) {
            Logger.warn(str, "Received a UIRequired exception from Broker : " + errorCode);
            uiRequiredException = getUiRequiredException(brokerResult);
        } else if ("unauthorized_client".equalsIgnoreCase(errorCode) && OAuth2SubErrorCode.PROTECTION_POLICY_REQUIRED.equalsIgnoreCase(brokerResult.getSubErrorCode())) {
            Logger.warn(str, "Received a IntuneAppProtectionPolicyRequiredException exception from Broker : " + errorCode);
            uiRequiredException = getIntuneProtectionRequiredException(brokerResult);
        } else if (ErrorStrings.USER_CANCELLED.equalsIgnoreCase(errorCode)) {
            Logger.warn(str, "Received a User cancelled exception from Broker : " + errorCode);
            uiRequiredException = new UserCancelException();
        } else if (ArgumentException.ILLEGAL_ARGUMENT_ERROR_CODE.equalsIgnoreCase(errorCode)) {
            Logger.warn(str, "Received a Argument exception from Broker : " + errorCode);
            uiRequiredException = new ArgumentException(ArgumentException.BROKER_TOKEN_REQUEST_OPERATION_NAME, errorCode, brokerResult.getErrorMessage());
        } else if (!StringUtil.isNullOrEmpty(brokerResult.getHttpResponseHeaders()) || !StringUtil.isNullOrEmpty(brokerResult.getHttpResponseBody())) {
            Logger.warn(str, "Received a Service exception from Broker : " + errorCode);
            uiRequiredException = getServiceException(brokerResult);
        } else {
            Logger.warn(str, "Received a Client exception from Broker : " + errorCode);
            uiRequiredException = new ClientException(brokerResult.getErrorCode(), brokerResult.getErrorMessage());
        }
        uiRequiredException.setSubErrorCode(brokerResult.getSubErrorCode());
        uiRequiredException.setCliTelemErrorCode(brokerResult.getCliTelemErrorCode());
        uiRequiredException.setCliTelemSubErrorCode(brokerResult.getCliTelemSubErrorCode());
        uiRequiredException.setCorrelationId(brokerResult.getCorrelationId());
        uiRequiredException.setSpeRing(brokerResult.getSpeRing());
        uiRequiredException.setRefreshTokenAge(brokerResult.getRefreshTokenAge());
        return uiRequiredException;
    }

    private IntuneAppProtectionPolicyRequiredException getIntuneProtectionRequiredException(BrokerResult brokerResult) {
        String str = TAG + ":getIntuneProtectionRequiredException";
        IntuneAppProtectionPolicyRequiredException intuneAppProtectionPolicyRequiredException = new IntuneAppProtectionPolicyRequiredException(brokerResult.getErrorCode(), brokerResult.getErrorMessage());
        intuneAppProtectionPolicyRequiredException.setTenantId(brokerResult.getTenantId());
        intuneAppProtectionPolicyRequiredException.setAuthorityUrl(brokerResult.getAuthority());
        intuneAppProtectionPolicyRequiredException.setAccountUserId(brokerResult.getLocalAccountId());
        intuneAppProtectionPolicyRequiredException.setAccountUpn(brokerResult.getUserName());
        intuneAppProtectionPolicyRequiredException.setSubErrorCode(brokerResult.getSubErrorCode());
        try {
            intuneAppProtectionPolicyRequiredException.setHttpResponseBody(HashMapExtensions.jsonStringAsMap(brokerResult.getHttpResponseBody()));
            if (brokerResult.getHttpResponseHeaders() != null) {
                intuneAppProtectionPolicyRequiredException.setHttpResponseHeaders(HeaderSerializationUtil.fromJson(brokerResult.getHttpResponseHeaders()));
            }
            return intuneAppProtectionPolicyRequiredException;
        } catch (JSONException unused) {
            Logger.warn(str, "Unable to parse json");
            return intuneAppProtectionPolicyRequiredException;
        }
    }

    private ServiceException getServiceException(BrokerResult brokerResult) {
        String str = TAG + ":getServiceException";
        ServiceException serviceException = new ServiceException(brokerResult.getErrorCode(), brokerResult.getErrorMessage(), null);
        try {
            serviceException.setHttpResponseBody(brokerResult.getHttpResponseBody() != null ? HashMapExtensions.jsonStringAsMap(brokerResult.getHttpResponseBody()) : null);
            serviceException.setHttpResponseHeaders(brokerResult.getHttpResponseHeaders() != null ? HeaderSerializationUtil.fromJson(brokerResult.getHttpResponseHeaders()) : null);
            return serviceException;
        } catch (JSONException unused) {
            Logger.warn(str, "Unable to parse json");
            return serviceException;
        }
    }

    private UiRequiredException getUiRequiredException(BrokerResult brokerResult) {
        String errorCode = brokerResult.getErrorCode();
        UiRequiredException uiRequiredException = new UiRequiredException(errorCode, brokerResult.getErrorMessage());
        if (OAuth2ErrorCode.INTERACTION_REQUIRED.equalsIgnoreCase(errorCode) || "invalid_grant".equalsIgnoreCase(errorCode)) {
            uiRequiredException.setSubErrorCode(brokerResult.getSubErrorCode());
        }
        if (!StringUtil.isNullOrEmpty(brokerResult.getUserName())) {
            uiRequiredException.setUsername(brokerResult.getUserName());
        }
        return uiRequiredException;
    }

    public String verifyHelloFromResultBundle(String str, Bundle bundle) throws BaseException {
        String str2 = TAG + ":verifyHelloFromResultBundle";
        if (bundle == null) {
            Logger.warn(str2, "The hello result bundle is null.");
            throw new UnsupportedBrokerException(str);
        }
        String string = bundle.getString(AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY);
        if (!StringUtil.isNullOrEmpty(string)) {
            Logger.info(str2, "Able to establish the connect, the broker protocol version in common is [" + string + "]");
            return string;
        }
        if (!StringUtil.isNullOrEmpty(bundle.getString("error"))) {
            throw new UnsupportedBrokerException(str, bundle.getString("error"), bundle.getString("error_description"));
        }
        Object obj = bundle.get(AuthenticationConstants.Broker.BROKER_RESULT_V2);
        if (obj instanceof BrokerResult) {
            BrokerResult brokerResult = (BrokerResult) obj;
            throw new ClientException(brokerResult.getErrorCode(), brokerResult.getErrorMessage());
        }
        Logger.warn(str2, "The result bundle is not in a recognizable format.");
        throw new UnsupportedBrokerException(str);
    }

    public Intent getIntentForInteractiveRequestFromResultBundle(Bundle bundle, String str) throws ClientException {
        Bundle bundleExtractInteractiveRequestBundleFromResultBundle = extractInteractiveRequestBundleFromResultBundle(bundle);
        String string = bundleExtractInteractiveRequestBundleFromResultBundle.getString(AuthenticationConstants.Broker.BROKER_PACKAGE_NAME);
        String string2 = bundleExtractInteractiveRequestBundleFromResultBundle.getString(AuthenticationConstants.Broker.BROKER_ACTIVITY_NAME);
        if (StringUtil.isNullOrEmpty(string) || StringUtil.isNullOrEmpty(string2)) {
            throw new ClientException(ClientException.INVALID_BROKER_BUNDLE, "Content of Authorization Intent's package and class name should not be null.");
        }
        Intent intent = new Intent();
        intent.setPackage(string);
        intent.setClassName(string, string2);
        intent.putExtras(bundleExtractInteractiveRequestBundleFromResultBundle);
        intent.putExtra(AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY, str);
        return intent;
    }

    public Bundle extractInteractiveRequestBundleFromResultBundle(Bundle bundle) {
        Intent intent = (Intent) bundle.getParcelable("intent");
        return intent != null ? intent.getExtras() : bundle;
    }

    public AuthorizationResult getDeviceCodeFlowAuthResultFromResultBundle(Bundle bundle) throws BaseException {
        String string = bundle.getString(AuthenticationConstants.Broker.BROKER_DCF_AUTH_RESULT);
        if (string != null) {
            return (AuthorizationResult) ObjectMapper.deserializeJsonStringToObject(string, MicrosoftStsAuthorizationResult.class);
        }
        BrokerResult brokerResultBrokerResultFromBundle = brokerResultFromBundle(bundle);
        if (brokerResultBrokerResultFromBundle.getErrorCode() != null && brokerResultBrokerResultFromBundle.getErrorCode().equals(ErrorStrings.DEVICE_CODE_FLOW_NOT_SUPPORTED)) {
            Logger.error(TAG, DCF_NOT_SUPPORTED_ERROR, new ClientException(ErrorStrings.DEVICE_CODE_FLOW_NOT_SUPPORTED, DCF_NOT_SUPPORTED_ERROR));
            throw new ClientException(ErrorStrings.DEVICE_CODE_FLOW_NOT_SUPPORTED, DCF_NOT_SUPPORTED_ERROR);
        }
        throw getBaseExceptionFromBundle(bundle);
    }

    public AcquireTokenResult getDeviceCodeFlowTokenResultFromResultBundle(Bundle bundle) throws BaseException {
        BrokerResult brokerResultBrokerResultFromBundle = brokerResultFromBundle(bundle);
        Span spanCreateSpan = OTelUtility.createSpan(SpanName.AcquireTokenDcfFetchToken.name());
        spanCreateSpan.setAttribute(AttributeName.correlation_id.name(), brokerResultBrokerResultFromBundle.getCorrelationId());
        spanCreateSpan.setAttribute(AttributeName.public_api_id.name(), brokerResultBrokerResultFromBundle.getClientId());
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpan);
            try {
                if (brokerResultBrokerResultFromBundle.getErrorCode() != null && brokerResultBrokerResultFromBundle.getErrorCode().equals(ErrorStrings.DEVICE_CODE_FLOW_NOT_SUPPORTED)) {
                    spanCreateSpan.setStatus(StatusCode.ERROR, "acquireDeviceCodeFlowToken() not supported in BrokerMsalController");
                    Logger.error(TAG, "acquireDeviceCodeFlowToken() not supported in BrokerMsalController", new ClientException(ErrorStrings.DEVICE_CODE_FLOW_NOT_SUPPORTED, DCF_NOT_SUPPORTED_ERROR));
                    throw new ClientException(ErrorStrings.DEVICE_CODE_FLOW_NOT_SUPPORTED, "acquireDeviceCodeFlowToken() not supported in BrokerMsalController");
                }
                if (bundle.getBoolean(AuthenticationConstants.Broker.BROKER_REQUEST_V2_SUCCESS)) {
                    AcquireTokenResult acquireTokenResult = new AcquireTokenResult();
                    acquireTokenResult.setLocalAuthenticationResult(authenticationResultFromBundle(bundle));
                    spanCreateSpan.setStatus(StatusCode.OK);
                    if (scopeMakeCurrentSpan != null) {
                        scopeMakeCurrentSpan.close();
                    }
                    spanCreateSpan.end();
                    return acquireTokenResult;
                }
                if (brokerResultBrokerResultFromBundle.getErrorCode().equals(ErrorStrings.DEVICE_CODE_FLOW_AUTHORIZATION_PENDING_ERROR_CODE)) {
                    spanCreateSpan.setStatus(StatusCode.OK, "authorization_pending response");
                    if (scopeMakeCurrentSpan != null) {
                        scopeMakeCurrentSpan.close();
                    }
                    spanCreateSpan.end();
                    return null;
                }
                throw getBaseExceptionFromBundle(bundle);
            } catch (Throwable th) {
                if (scopeMakeCurrentSpan != null) {
                    try {
                        scopeMakeCurrentSpan.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                spanCreateSpan.setStatus(StatusCode.ERROR);
                spanCreateSpan.recordException(th3);
                throw th3;
            } catch (Throwable th4) {
                spanCreateSpan.end();
                throw th4;
            }
        }
    }

    public AcquireTokenResult getAcquireTokenResultFromResultBundle(Bundle bundle) throws BaseException {
        MsalBrokerResultAdapter msalBrokerResultAdapter = new MsalBrokerResultAdapter();
        if (bundle.getBoolean(AuthenticationConstants.Broker.BROKER_REQUEST_V2_SUCCESS)) {
            AcquireTokenResult acquireTokenResult = new AcquireTokenResult();
            acquireTokenResult.setLocalAuthenticationResult(msalBrokerResultAdapter.authenticationResultFromBundle(bundle));
            return acquireTokenResult;
        }
        throw getBaseExceptionFromBundle(bundle);
    }

    public Bundle bundleFromAccounts(List<ICacheRecord> list, String str) {
        String str2 = TAG + ":bundleFromAccounts";
        Bundle bundle = new Bundle();
        String jsonStringFromICacheRecordList = JsonExtensions.getJsonStringFromICacheRecordList(list);
        if (BrokerProtocolVersionUtil.canCompressBrokerPayloads(str)) {
            try {
                byte[] bArrCompressString = GzipUtil.compressString(jsonStringFromICacheRecordList);
                Logger.info(str2, "Get accounts, raw payload size :" + jsonStringFromICacheRecordList.getBytes(AuthenticationConstants.CHARSET_UTF8).length + " compressed size " + bArrCompressString.length);
                bundle.putByteArray(AuthenticationConstants.Broker.BROKER_ACCOUNTS_COMPRESSED, bArrCompressString);
                return bundle;
            } catch (IOException e) {
                Logger.error(str2, " Failed to compress account list to bytes, sending as jsonString", e);
                bundle.putString(AuthenticationConstants.Broker.BROKER_ACCOUNTS, jsonStringFromICacheRecordList);
                return bundle;
            }
        }
        Logger.info(str2, "Broker protocol version: " + str + " lower than compression changes, sending as string");
        bundle.putString(AuthenticationConstants.Broker.BROKER_ACCOUNTS, jsonStringFromICacheRecordList);
        return bundle;
    }

    public List<ICacheRecord> getAccountsFromResultBundle(Bundle bundle) throws BaseException {
        String strDecompressBytesToString;
        String str = TAG + ":getAccountsFromResultBundle";
        byte[] byteArray = bundle.getByteArray(AuthenticationConstants.Broker.BROKER_ACCOUNTS_COMPRESSED);
        if (byteArray != null) {
            try {
                strDecompressBytesToString = GzipUtil.decompressBytesToString(byteArray);
            } catch (IOException e) {
                Logger.error(str, " Failed to decompress account list to bytes", e);
                throw new ClientException(ClientException.INVALID_BROKER_BUNDLE, " Failed to decompress account list to bytes.");
            }
        } else {
            strDecompressBytesToString = bundle.getString(AuthenticationConstants.Broker.BROKER_ACCOUNTS);
        }
        if (StringUtil.isNullOrEmpty(strDecompressBytesToString)) {
            throw new MsalBrokerResultAdapter().getBaseExceptionFromBundle(bundle);
        }
        return JsonExtensions.getICacheRecordListFromJsonString(strDecompressBytesToString);
    }

    public ICacheRecord resourceAccountRecordFromBundle(Bundle bundle) throws BaseException {
        String str = TAG + ":resourceAccountRecordFromBundle";
        List<ICacheRecord> accountsFromResultBundle = getAccountsFromResultBundle(bundle);
        if (accountsFromResultBundle.isEmpty()) {
            Logger.error(str, "No accounts found in the result bundle", null);
            throw new ClientException(ClientException.INVALID_BROKER_BUNDLE, "No accounts found in the result bundle");
        }
        if (accountsFromResultBundle.size() > 1) {
            Logger.error(str, "Multiple accounts found in the result bundle", null);
            throw new ClientException(ClientException.INVALID_BROKER_BUNDLE, "Multiple accounts found in the result bundle");
        }
        return accountsFromResultBundle.get(0);
    }

    public void verifyRemoveAccountResultFromBundle(Bundle bundle) throws BaseException {
        String str = TAG + ":verifyRemoveAccountResultFromBundle";
        if (bundle == null) {
            return;
        }
        String string = bundle.getString(AuthenticationConstants.Broker.BROKER_RESULT_V2);
        if (StringUtil.isNullOrEmpty(string)) {
            throw getBaseExceptionFromBundle(bundle);
        }
        BrokerResult brokerResultFromJsonString = JsonExtensions.getBrokerResultFromJsonString(string);
        if (brokerResultFromJsonString == null || !brokerResultFromJsonString.isSuccess()) {
            Logger.warn(str, "Failed to remove account.");
            throw getBaseExceptionFromBundle(bundle);
        }
    }

    public Bundle bundleFromDeviceMode(boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(AuthenticationConstants.Broker.BROKER_DEVICE_MODE, z);
        return bundle;
    }

    public boolean getDeviceModeFromResultBundle(Bundle bundle) throws BaseException {
        if (!bundle.containsKey(AuthenticationConstants.Broker.BROKER_DEVICE_MODE)) {
            throw new MsalBrokerResultAdapter().getBaseExceptionFromBundle(bundle);
        }
        return bundle.getBoolean(AuthenticationConstants.Broker.BROKER_DEVICE_MODE);
    }

    public ClientException getExceptionForEmptyResultBundle() {
        return new ClientException(ClientException.INVALID_BROKER_BUNDLE, "Broker Result not returned from Broker.");
    }

    public GenerateShrResult getGenerateShrResultFromResultBundle(Bundle bundle) {
        return (GenerateShrResult) AuthenticationSchemeTypeAdapter.getGsonInstance().fromJson(bundle.getString(AuthenticationConstants.Broker.BROKER_GENERATE_SHR_RESULT), GenerateShrResult.class);
    }

    public PreferredAuthMethod getPreferredAuthMethodFromResultBundle(Bundle bundle) throws BaseException {
        String str = TAG + ":getPreferredAuthMethodFromResultBundle";
        if (bundle == null) {
            throw getExceptionForEmptyResultBundle();
        }
        if (!bundle.containsKey(AuthenticationConstants.Broker.PREFERRED_AUTH_METHOD_CODE)) {
            throw new MsalBrokerResultAdapter().getBaseExceptionFromBundle(bundle);
        }
        int i = bundle.getInt(AuthenticationConstants.Broker.PREFERRED_AUTH_METHOD_CODE);
        try {
            return PreferredAuthMethod.fromCode(i);
        } catch (NoSuchElementException e) {
            ClientException clientException = new ClientException(ClientException.CLIENT_UPDATE_REQUIRED, "Preferred auth method code " + i + " not recognized.", e);
            Logger.error(str, clientException.getMessage(), clientException);
            throw clientException;
        }
    }

    public AadDeviceIdRecord aadDeviceIdRecordFromBundle(Bundle bundle) throws BaseException {
        AadDeviceIdRecord aadDeviceIdRecord = brokerResultFromBundle(bundle).getAadDeviceIdRecord();
        if (aadDeviceIdRecord != null) {
            return aadDeviceIdRecord;
        }
        throw getBaseExceptionFromBundle(bundle);
    }

    public String getSupportedWebAppsContractFromBundle(Bundle bundle) throws ClientException {
        String string = bundle.getString(AuthenticationConstants.Broker.BROKER_WEBAPPS_GET_CONTRACTS_RESULT);
        if (string != null) {
            return string;
        }
        throw new ClientException(ClientException.INVALID_BROKER_BUNDLE, "WebApps entry in the bundle is null for contracts");
    }

    public String getExecuteWebAppRequestResultFromBundle(Bundle bundle) throws ClientException {
        if (bundle.containsKey("error")) {
            String string = bundle.getString("error");
            if (string != null) {
                return string;
            }
            throw new ClientException(ClientException.INVALID_BROKER_BUNDLE, "WebApps entry in the bundle is null for error");
        }
        String string2 = bundle.getString("response");
        if (string2 != null) {
            return string2;
        }
        throw new ClientException(ClientException.INVALID_BROKER_BUNDLE, "WebApps entry in the bundle is null for response");
    }
}
