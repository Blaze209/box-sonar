package com.microsoft.identity.common.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.broker.BrokerRequest;
import com.microsoft.identity.common.internal.commands.parameters.AndroidInteractiveTokenCommandParameters;
import com.microsoft.identity.common.internal.util.GzipUtil;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAuthority;
import com.microsoft.identity.common.java.authscheme.AuthenticationSchemeFactory;
import com.microsoft.identity.common.java.authscheme.INameable;
import com.microsoft.identity.common.java.authscheme.PopAuthenticationSchemeInternal;
import com.microsoft.identity.common.java.commands.parameters.AcquirePrtSsoTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.GenerateShrCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.GetAadDeviceIdCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.RemoveAccountCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.ResourceAccountCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.TokenCommandParameters;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.opentelemetry.SerializableSpanContext;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.providers.microsoft.azureactivedirectory.AzureActiveDirectory;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.OpenIdConnectPromptParameter;
import com.microsoft.identity.common.java.ui.AuthorizationAgent;
import com.microsoft.identity.common.java.util.BrokerProtocolVersionUtil;
import com.microsoft.identity.common.java.util.ObjectMapper;
import com.microsoft.identity.common.java.util.QueryParamsAdapter;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.logging.Logger;
import java.io.IOException;

/* JADX INFO: loaded from: classes14.dex */
public class MsalBrokerRequestAdapter implements IBrokerRequestAdapter {
    private static final String TAG = "MsalBrokerRequestAdapter";

    @Override // com.microsoft.identity.common.internal.request.IBrokerRequestAdapter
    public BrokerRequest brokerRequestFromAcquireTokenParameters(InteractiveTokenCommandParameters interactiveTokenCommandParameters) {
        String strName;
        Logger.info(TAG + ":brokerRequestFromAcquireTokenParameters", "Constructing result bundle from AcquireTokenOperationParameters.");
        BrokerRequest.BrokerRequestBuilder brokerRequestBuilderMultipleCloudsSupported = BrokerRequest.builder().authority(interactiveTokenCommandParameters.getAuthority().getAuthorityURL().toString()).scope(TextUtils.join(" ", interactiveTokenCommandParameters.getScopes())).redirect(interactiveTokenCommandParameters.getRedirectUri()).clientId(interactiveTokenCommandParameters.getClientId()).childRedirectUri(interactiveTokenCommandParameters.getChildRedirectUri()).childClientId(interactiveTokenCommandParameters.getChildClientId()).userName(interactiveTokenCommandParameters.getLoginHint()).extraQueryStringParameter(interactiveTokenCommandParameters.getExtraQueryStringParameters() != null ? QueryParamsAdapter._toJson(interactiveTokenCommandParameters.getExtraQueryStringParameters()) : null).extraOptions(interactiveTokenCommandParameters.getExtraOptions() != null ? QueryParamsAdapter._toJson(interactiveTokenCommandParameters.getExtraOptions()) : null).prompt(OpenIdConnectPromptParameter.UNSET.name().equals(interactiveTokenCommandParameters.getPrompt().name()) ? null : interactiveTokenCommandParameters.getPrompt().name()).claims(interactiveTokenCommandParameters.getClaimsRequestJson()).forceRefresh(interactiveTokenCommandParameters.isForceRefresh()).correlationId(interactiveTokenCommandParameters.getCorrelationId()).applicationName(interactiveTokenCommandParameters.getApplicationName()).applicationVersion(interactiveTokenCommandParameters.getApplicationVersion()).msalVersion(interactiveTokenCommandParameters.getSdkVersion()).sdkType(interactiveTokenCommandParameters.getSdkType()).environment(AzureActiveDirectory.getEnvironment().name()).multipleCloudsSupported(getMultipleCloudsSupported(interactiveTokenCommandParameters));
        if (interactiveTokenCommandParameters.isBrokerBrowserSupportEnabled()) {
            strName = AuthorizationAgent.BROWSER.name();
        } else {
            strName = AuthorizationAgent.WEBVIEW.name();
        }
        BrokerRequest.BrokerRequestBuilder brokerRequestBuilderSuppressAccountPicker = brokerRequestBuilderMultipleCloudsSupported.authorizationAgent(strName).authenticationScheme(interactiveTokenCommandParameters.getAuthenticationScheme()).powerOptCheckEnabled(interactiveTokenCommandParameters.isPowerOptCheckEnabled()).spanContext(SerializableSpanContext.builder().traceId(SpanExtension.current().getSpanContext().getTraceId()).spanId(SpanExtension.current().getSpanContext().getSpanId()).traceFlags(SpanExtension.current().getSpanContext().getTraceFlags().asByte()).build()).preferredBrowser(interactiveTokenCommandParameters.getPreferredBrowser()).preferredAuthMethod(interactiveTokenCommandParameters.getPreferredAuthMethod()).accountTransferToken(interactiveTokenCommandParameters.getAccountTransferToken()).suppressAccountPicker(interactiveTokenCommandParameters.isSuppressBrokerAccountPicker());
        if (interactiveTokenCommandParameters instanceof AndroidInteractiveTokenCommandParameters) {
            brokerRequestBuilderSuppressAccountPicker.signInWithGoogleCredential(((AndroidInteractiveTokenCommandParameters) interactiveTokenCommandParameters).getSignInWithGoogleCredential());
        }
        return brokerRequestBuilderSuppressAccountPicker.build();
    }

    @Override // com.microsoft.identity.common.internal.request.IBrokerRequestAdapter
    public BrokerRequest brokerRequestFromDeviceCodeFlowCommandParameters(DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters) {
        Logger.info(TAG + ":brokerRequestFromDeviceCodeFlowCommandParameters", "Constructing result bundle from DeviceCodeFlowCommandParameters.");
        return BrokerRequest.builder().authority(deviceCodeFlowCommandParameters.getAuthority().getAuthorityURL().toString()).scope(TextUtils.join(" ", deviceCodeFlowCommandParameters.getScopes())).redirect(deviceCodeFlowCommandParameters.getRedirectUri()).extraOptions(deviceCodeFlowCommandParameters.getExtraOptions() != null ? QueryParamsAdapter._toJson(deviceCodeFlowCommandParameters.getExtraOptions()) : null).clientId(deviceCodeFlowCommandParameters.getClientId()).claims(deviceCodeFlowCommandParameters.getClaimsRequestJson()).forceRefresh(deviceCodeFlowCommandParameters.isForceRefresh()).correlationId(deviceCodeFlowCommandParameters.getCorrelationId()).applicationName(deviceCodeFlowCommandParameters.getApplicationName()).applicationVersion(deviceCodeFlowCommandParameters.getApplicationVersion()).msalVersion(deviceCodeFlowCommandParameters.getSdkVersion()).sdkType(deviceCodeFlowCommandParameters.getSdkType()).environment(AzureActiveDirectory.getEnvironment().name()).multipleCloudsSupported(getMultipleCloudsSupported(deviceCodeFlowCommandParameters)).authenticationScheme(deviceCodeFlowCommandParameters.getAuthenticationScheme()).build();
    }

    @Override // com.microsoft.identity.common.internal.request.IBrokerRequestAdapter
    public BrokerRequest brokerRequestFromSilentOperationParameters(SilentTokenCommandParameters silentTokenCommandParameters) {
        Logger.info(TAG + ":brokerRequestFromSilentOperationParameters", "Constructing result bundle from AcquireTokenSilentOperationParameters.");
        return BrokerRequest.builder().authority(silentTokenCommandParameters.getAuthority().getAuthorityURL().toString()).scope(TextUtils.join(" ", silentTokenCommandParameters.getScopes())).redirect(silentTokenCommandParameters.getRedirectUri()).extraOptions(silentTokenCommandParameters.getExtraOptions() != null ? QueryParamsAdapter._toJson(silentTokenCommandParameters.getExtraOptions()) : null).clientId(silentTokenCommandParameters.getClientId()).childRedirectUri(silentTokenCommandParameters.getChildRedirectUri()).childClientId(silentTokenCommandParameters.getChildClientId()).homeAccountId(silentTokenCommandParameters.getAccount().getHomeAccountId()).localAccountId(silentTokenCommandParameters.getAccount().getLocalAccountId()).userName(silentTokenCommandParameters.getAccount().getUsername()).claims(silentTokenCommandParameters.getClaimsRequestJson()).forceRefresh(silentTokenCommandParameters.isForceRefresh()).correlationId(silentTokenCommandParameters.getCorrelationId()).applicationName(silentTokenCommandParameters.getApplicationName()).applicationVersion(silentTokenCommandParameters.getApplicationVersion()).msalVersion(silentTokenCommandParameters.getSdkVersion()).sdkType(silentTokenCommandParameters.getSdkType()).environment(AzureActiveDirectory.getEnvironment().name()).multipleCloudsSupported(getMultipleCloudsSupported(silentTokenCommandParameters)).authenticationScheme(silentTokenCommandParameters.getAuthenticationScheme()).powerOptCheckEnabled(silentTokenCommandParameters.isPowerOptCheckEnabled()).spanContext(SerializableSpanContext.builder().traceId(SpanExtension.current().getSpanContext().getTraceId()).spanId(SpanExtension.current().getSpanContext().getSpanId()).traceFlags(SpanExtension.current().getSpanContext().getTraceFlags().asByte()).build()).build();
    }

    public Bundle getRequestBundleForSsoToken(AcquirePrtSsoTokenCommandParameters acquirePrtSsoTokenCommandParameters, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(AuthenticationConstants.Broker.ACCOUNT_NAME, acquirePrtSsoTokenCommandParameters.getAccountName());
        bundle.putString("account.home.account.id", acquirePrtSsoTokenCommandParameters.getHomeAccountId());
        bundle.putString("account.local.account.id", acquirePrtSsoTokenCommandParameters.getLocalAccountId());
        bundle.putString(AuthenticationConstants.Broker.SSO_TOKEN_CLIENT_ID, acquirePrtSsoTokenCommandParameters.getClientId());
        if (acquirePrtSsoTokenCommandParameters.getRequestAuthority() != null) {
            bundle.putString(AuthenticationConstants.Broker.REQUEST_AUTHORITY, acquirePrtSsoTokenCommandParameters.getRequestAuthority());
        }
        if (acquirePrtSsoTokenCommandParameters.getSsoUrl() != null) {
            bundle.putString(AuthenticationConstants.Broker.BROKER_SSO_URL_KEY, acquirePrtSsoTokenCommandParameters.getSsoUrl());
        }
        bundle.putString(AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY, str);
        addRequiredBrokerProtocolVersionToRequestBundle(bundle, acquirePrtSsoTokenCommandParameters.getRequiredBrokerProtocolVersion());
        bundle.putString(AuthenticationConstants.Broker.ACCOUNT_CORRELATIONID, acquirePrtSsoTokenCommandParameters.getCorrelationId());
        return bundle;
    }

    public Bundle getRequestBundleForAllSsoTokens(AcquirePrtSsoTokenCommandParameters acquirePrtSsoTokenCommandParameters, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY, str);
        if (acquirePrtSsoTokenCommandParameters.getRequestAuthority() != null) {
            bundle.putString(AuthenticationConstants.Broker.REQUEST_AUTHORITY, acquirePrtSsoTokenCommandParameters.getRequestAuthority());
        }
        if (acquirePrtSsoTokenCommandParameters.getSsoUrl() != null) {
            bundle.putString(AuthenticationConstants.Broker.BROKER_SSO_URL_KEY, acquirePrtSsoTokenCommandParameters.getSsoUrl());
        }
        if (acquirePrtSsoTokenCommandParameters.getCorrelationId() != null) {
            bundle.putString(AuthenticationConstants.Broker.ACCOUNT_CORRELATIONID, acquirePrtSsoTokenCommandParameters.getCorrelationId());
        }
        addRequiredBrokerProtocolVersionToRequestBundle(bundle, acquirePrtSsoTokenCommandParameters.getRequiredBrokerProtocolVersion());
        return bundle;
    }

    public Bundle getRequestBundleForHello(CommandParameters commandParameters) {
        Bundle bundle = new Bundle();
        bundle.putString(AuthenticationConstants.Broker.CLIENT_ADVERTISED_MAXIMUM_BP_VERSION_KEY, "19.0");
        addRequiredBrokerProtocolVersionToRequestBundle(bundle, commandParameters.getRequiredBrokerProtocolVersion());
        return bundle;
    }

    public Bundle getRequestBundleForAcquireTokenInteractive(InteractiveTokenCommandParameters interactiveTokenCommandParameters, String str) {
        return getRequestBundleFromBrokerRequest(brokerRequestFromAcquireTokenParameters(interactiveTokenCommandParameters), str, interactiveTokenCommandParameters.getRequiredBrokerProtocolVersion());
    }

    public Bundle getRequestBundleForProvisionResourceAccount(ResourceAccountCommandParameters resourceAccountCommandParameters, String str) {
        Logger.info(TAG + ":getRequestBundleForProvisionResourceAccount", "Constructing result bundle from ProvisionResourceAccount.");
        return getRequestBundleFromBrokerRequest(BrokerRequest.builder().authority(resourceAccountCommandParameters.getAuthority().getAuthorityURL().toString()).extraOptions(resourceAccountCommandParameters.getExtraOptions() != null ? QueryParamsAdapter._toJson(resourceAccountCommandParameters.getExtraOptions()) : null).homeAccountId(resourceAccountCommandParameters.getHomeAccountId()).userName(resourceAccountCommandParameters.getLoginHint()).correlationId(resourceAccountCommandParameters.getCorrelationId()).clientId(resourceAccountCommandParameters.getClientId()).redirect(resourceAccountCommandParameters.getRedirectUri()).applicationName(resourceAccountCommandParameters.getApplicationName()).applicationVersion(resourceAccountCommandParameters.getApplicationVersion()).msalVersion(resourceAccountCommandParameters.getSdkVersion()).sdkType(resourceAccountCommandParameters.getSdkType()).environment(AzureActiveDirectory.getEnvironment().name()).powerOptCheckEnabled(resourceAccountCommandParameters.isPowerOptCheckEnabled()).spanContext(SerializableSpanContext.builder().traceId(SpanExtension.current().getSpanContext().getTraceId()).spanId(SpanExtension.current().getSpanContext().getSpanId()).traceFlags(SpanExtension.current().getSpanContext().getTraceFlags().asByte()).build()).build(), str, resourceAccountCommandParameters.getRequiredBrokerProtocolVersion());
    }

    public Bundle getRequestBundleForDeviceCodeFlowAuthRequest(Context context, DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters, String str) {
        Bundle requestBundleFromBrokerRequest = getRequestBundleFromBrokerRequest(brokerRequestFromDeviceCodeFlowCommandParameters(deviceCodeFlowCommandParameters), str, deviceCodeFlowCommandParameters.getRequiredBrokerProtocolVersion());
        requestBundleFromBrokerRequest.putInt(AuthenticationConstants.Broker.CALLER_INFO_UID, context.getApplicationInfo().uid);
        return requestBundleFromBrokerRequest;
    }

    public Bundle getRequestBundleForDeviceCodeFlowTokenRequest(Context context, DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters, AuthorizationResult authorizationResult, String str) {
        Bundle requestBundleFromBrokerRequest = getRequestBundleFromBrokerRequest(brokerRequestFromDeviceCodeFlowCommandParameters(deviceCodeFlowCommandParameters), str, deviceCodeFlowCommandParameters.getRequiredBrokerProtocolVersion());
        requestBundleFromBrokerRequest.putInt(AuthenticationConstants.Broker.CALLER_INFO_UID, context.getApplicationInfo().uid);
        requestBundleFromBrokerRequest.putString(AuthenticationConstants.Broker.BROKER_DCF_AUTH_RESULT, ObjectMapper.serializeObjectToJsonString((MicrosoftStsAuthorizationResult) authorizationResult));
        return requestBundleFromBrokerRequest;
    }

    public Bundle getRequestBundleForAcquireTokenSilent(Context context, SilentTokenCommandParameters silentTokenCommandParameters, String str) {
        Bundle requestBundleFromBrokerRequest = getRequestBundleFromBrokerRequest(brokerRequestFromSilentOperationParameters(silentTokenCommandParameters), str, silentTokenCommandParameters.getRequiredBrokerProtocolVersion());
        requestBundleFromBrokerRequest.putInt(AuthenticationConstants.Broker.CALLER_INFO_UID, context.getApplicationInfo().uid);
        return requestBundleFromBrokerRequest;
    }

    private Bundle getRequestBundleFromBrokerRequest(BrokerRequest brokerRequest, String str, String str2) {
        String str3 = TAG + ":getRequestBundleFromBrokerRequest";
        Bundle bundle = new Bundle();
        if (BrokerProtocolVersionUtil.canCompressBrokerPayloads(str)) {
            try {
                String json = AuthenticationSchemeTypeAdapter.getGsonInstance().toJson(brokerRequest, BrokerRequest.class);
                byte[] bArrCompressString = GzipUtil.compressString(json);
                Logger.info(str3, "Broker Result, raw payload size:" + json.getBytes(AuthenticationConstants.CHARSET_UTF8).length + " ,compressed bytes size: " + bArrCompressString.length);
                bundle.putByteArray(AuthenticationConstants.Broker.BROKER_REQUEST_V2_COMPRESSED, bArrCompressString);
            } catch (IOException e) {
                Logger.error(str3, "Compression to bytes failed, sending broker request as json String", e);
                bundle.putString(AuthenticationConstants.Broker.BROKER_REQUEST_V2, AuthenticationSchemeTypeAdapter.getGsonInstance().toJson(brokerRequest, BrokerRequest.class));
            }
        } else {
            Logger.info(str3, "Broker protocol version: " + str + " lower than compression changes, sending as string");
            bundle.putString(AuthenticationConstants.Broker.BROKER_REQUEST_V2, AuthenticationSchemeTypeAdapter.getGsonInstance().toJson(brokerRequest, BrokerRequest.class));
        }
        bundle.putString(AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY, str);
        addRequiredBrokerProtocolVersionToRequestBundle(bundle, str2);
        bundle.putBoolean(AuthenticationConstants.Broker.SHOULD_SEND_PKEYAUTH_HEADER_TO_THE_TOKEN_ENDPOINT, BrokerProtocolVersionUtil.canSendPKeyAuthHeaderToTheTokenEndpoint(str2));
        return bundle;
    }

    public Bundle getRequestBundleForGetAccounts(CommandParameters commandParameters, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(AuthenticationConstants.Broker.ACCOUNT_CLIENTID_KEY, commandParameters.getClientId());
        bundle.putString(AuthenticationConstants.Broker.ACCOUNT_REDIRECT, commandParameters.getRedirectUri());
        bundle.putString(AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY, str);
        bundle.putBoolean(AuthenticationConstants.Broker.CAN_FOCI_APPS_CONSTRUCT_ACCOUNTS_FROM_PRT_ID_TOKEN_KEY, BrokerProtocolVersionUtil.canFociAppsConstructAccountsFromPrtIdTokens(commandParameters.getRequiredBrokerProtocolVersion()));
        addRequiredBrokerProtocolVersionToRequestBundle(bundle, commandParameters.getRequiredBrokerProtocolVersion());
        return bundle;
    }

    public Bundle getRequestBundleForRemoveAccount(RemoveAccountCommandParameters removeAccountCommandParameters, String str) {
        Bundle bundle = new Bundle();
        if (removeAccountCommandParameters.getAccount() != null) {
            bundle.putString(AuthenticationConstants.Broker.ACCOUNT_CLIENTID_KEY, removeAccountCommandParameters.getClientId());
            bundle.putString("environment", removeAccountCommandParameters.getAccount().getEnvironment());
            bundle.putString("account.home.account.id", removeAccountCommandParameters.getAccount().getHomeAccountId());
        }
        bundle.putString(AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY, str);
        addRequiredBrokerProtocolVersionToRequestBundle(bundle, removeAccountCommandParameters.getRequiredBrokerProtocolVersion());
        return bundle;
    }

    public Bundle getRequestBundleForRemoveAccountFromSharedDevice(RemoveAccountCommandParameters removeAccountCommandParameters, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY, str);
        addRequiredBrokerProtocolVersionToRequestBundle(bundle, removeAccountCommandParameters.getRequiredBrokerProtocolVersion());
        return bundle;
    }

    public Bundle getRequestBundleForGenerateShr(GenerateShrCommandParameters generateShrCommandParameters, String str) throws ClientException {
        String clientId = generateShrCommandParameters.getClientId();
        String homeAccountId = generateShrCommandParameters.getHomeAccountId();
        String json = AuthenticationSchemeTypeAdapter.getGsonInstance().toJson((PopAuthenticationSchemeInternal) AuthenticationSchemeFactory.createScheme(generateShrCommandParameters.getPlatformComponents(), (INameable) generateShrCommandParameters.getPopParameters()), PopAuthenticationSchemeInternal.class);
        Bundle bundle = new Bundle();
        bundle.putString(AuthenticationConstants.Broker.ACCOUNT_CLIENTID_KEY, clientId);
        bundle.putString("account.home.account.id", homeAccountId);
        bundle.putString(AuthenticationConstants.Broker.AUTH_SCHEME_PARAMS_POP, json);
        bundle.putString(AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY, str);
        addRequiredBrokerProtocolVersionToRequestBundle(bundle, generateShrCommandParameters.getRequiredBrokerProtocolVersion());
        return bundle;
    }

    public Bundle getRequestBundleForAadDeviceIdRequest(GetAadDeviceIdCommandParameters getAadDeviceIdCommandParameters, String str) {
        Logger.info(TAG + ":getRequestBundleGetAadDeviceIdRequest", "Constructing result bundle from getRequestBundleGetAadDeviceIdRequest.");
        return getRequestBundleFromBrokerRequest(BrokerRequest.builder().correlationId(getAadDeviceIdCommandParameters.getCorrelationId()).tenantId(getAadDeviceIdCommandParameters.getTenantId()).clientId(getAadDeviceIdCommandParameters.getClientId()).redirect(getAadDeviceIdCommandParameters.getRedirectUri()).applicationName(getAadDeviceIdCommandParameters.getApplicationName()).applicationVersion(getAadDeviceIdCommandParameters.getApplicationVersion()).msalVersion(getAadDeviceIdCommandParameters.getSdkVersion()).sdkType(getAadDeviceIdCommandParameters.getSdkType()).environment(AzureActiveDirectory.getEnvironment().name()).powerOptCheckEnabled(getAadDeviceIdCommandParameters.isPowerOptCheckEnabled()).build(), str, getAadDeviceIdCommandParameters.getRequiredBrokerProtocolVersion());
    }

    public Bundle getRequestBundleForGetSupportedWebAppContracts(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY, str);
        addRequiredBrokerProtocolVersionToRequestBundle(bundle, str2);
        return bundle;
    }

    public Bundle getRequestBundleForExecuteWebAppRequest(String str, String str2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString(AuthenticationConstants.Broker.NEGOTIATED_BP_VERSION_KEY, str2);
        bundle.putString("request", str);
        addRequiredBrokerProtocolVersionToRequestBundle(bundle, str3);
        return bundle;
    }

    private boolean getMultipleCloudsSupported(TokenCommandParameters tokenCommandParameters) {
        if (tokenCommandParameters.getAuthority() instanceof AzureActiveDirectoryAuthority) {
            return ((AzureActiveDirectoryAuthority) tokenCommandParameters.getAuthority()).isMultipleCloudsSupported();
        }
        return false;
    }

    private void addRequiredBrokerProtocolVersionToRequestBundle(Bundle bundle, String str) {
        if (StringUtil.isNullOrEmpty(str)) {
            return;
        }
        bundle.putString(AuthenticationConstants.Broker.CLIENT_CONFIGURED_MINIMUM_BP_VERSION_KEY, str);
    }
}
