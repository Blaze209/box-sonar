package com.microsoft.identity.common.internal.result;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.microsoft.identity.common.adal.internal.ADALError;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.java.commands.AcquirePrtSsoTokenBatchResult;
import com.microsoft.identity.common.java.commands.AcquirePrtSsoTokenResult;
import com.microsoft.identity.common.java.constants.OAuth2ErrorCode;
import com.microsoft.identity.common.java.dto.IAccountRecord;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.ErrorStrings;
import com.microsoft.identity.common.java.exception.IntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.exception.UserCancelException;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.java.util.SchemaUtil;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public class AdalBrokerResultAdapter implements IBrokerResultAdapter {
    private static final String TAG = "AdalBrokerResultAdapter";

    @Override // com.microsoft.identity.common.internal.result.IBrokerResultAdapter
    public Bundle bundleFromAuthenticationResult(ILocalAuthenticationResult iLocalAuthenticationResult, String str) {
        Logger.verbose(TAG + ":bundleFromAuthenticationResult", "Constructing success bundle from Authentication Result.");
        Bundle bundle = new Bundle();
        IAccountRecord accountRecord = iLocalAuthenticationResult.getAccountRecord();
        bundle.putString(AuthenticationConstants.Broker.ACCOUNT_LOGIN_HINT, accountRecord.getUsername());
        bundle.putString("account.userinfo.userid", accountRecord.getLocalAccountId());
        bundle.putString("account.userinfo.userid.displayable", accountRecord.getUsername());
        bundle.putString("account.userinfo.given.name", accountRecord.getFirstName());
        bundle.putString("account.userinfo.family.name", accountRecord.getFamilyName());
        bundle.putString("account.userinfo.identity.provider", SchemaUtil.getIdentityProvider(iLocalAuthenticationResult.getIdToken()));
        bundle.putString("account.userinfo.tenantid", iLocalAuthenticationResult.getTenantId());
        bundle.putLong(AuthenticationConstants.Broker.ACCOUNT_EXPIREDATE, iLocalAuthenticationResult.getExpiresOn().getTime());
        bundle.putString(AuthenticationConstants.Broker.ACCOUNT_AUTHORITY, getAuthority(iLocalAuthenticationResult));
        bundle.putString(AuthenticationConstants.Broker.ACCOUNT_ACCESS_TOKEN, iLocalAuthenticationResult.getAccessToken());
        bundle.putString("account.idtoken", iLocalAuthenticationResult.getIdToken());
        bundle.putString(AuthenticationConstants.Broker.CliTelemInfo.SPE_RING, iLocalAuthenticationResult.getSpeRing());
        bundle.putString(AuthenticationConstants.Broker.CliTelemInfo.RT_AGE, iLocalAuthenticationResult.getRefreshTokenAge());
        bundle.putString("authtoken", iLocalAuthenticationResult.getAccessToken());
        return bundle;
    }

    @Override // com.microsoft.identity.common.internal.result.IBrokerResultAdapter
    public Bundle bundleFromBaseException(BaseException baseException, String str) {
        Logger.verbose(TAG + ":bundleFromBaseException", "Constructing error bundle from exception.");
        Bundle bundle = new Bundle();
        bundle.putString("com.microsoft.aad.adal:BrowserErrorCode", baseException.getErrorCode());
        bundle.putString(AuthenticationConstants.Browser.RESPONSE_ERROR_MESSAGE, baseException.getMessage());
        bundle.putString(AuthenticationConstants.Broker.CliTelemInfo.SPE_RING, baseException.getSpeRing());
        bundle.putString(AuthenticationConstants.Broker.CliTelemInfo.RT_AGE, baseException.getRefreshTokenAge());
        bundle.putString(AuthenticationConstants.Broker.CliTelemInfo.SERVER_ERROR, baseException.getCliTelemErrorCode());
        bundle.putString(AuthenticationConstants.Broker.CliTelemInfo.SERVER_SUBERROR, baseException.getCliTelemSubErrorCode());
        mapExceptionToBundle(bundle, baseException);
        return bundle;
    }

    @Override // com.microsoft.identity.common.internal.result.IBrokerResultAdapter
    public ILocalAuthenticationResult authenticationResultFromBundle(Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // com.microsoft.identity.common.internal.result.IBrokerResultAdapter
    public BaseException getBaseExceptionFromBundle(Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // com.microsoft.identity.common.internal.result.IBrokerResultAdapter
    public AcquirePrtSsoTokenResult getAcquirePrtSsoTokenResultFromBundle(Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    @Override // com.microsoft.identity.common.internal.result.IBrokerResultAdapter
    public AcquirePrtSsoTokenBatchResult getAcquirePrtSsoTokenBatchResultFromBundle(Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    private void mapExceptionToBundle(Bundle bundle, BaseException baseException) {
        String str = TAG + ":mapExceptionToBundle";
        if (baseException instanceof UserCancelException) {
            Logger.info(str, "Setting Bundle result from UserCancelException.");
            setErrorToResultBundle(bundle, 4, baseException.getMessage());
            return;
        }
        if (baseException instanceof ArgumentException) {
            Logger.info(str, "Setting Bundle result from ArgumentException.");
            setErrorToResultBundle(bundle, 7, baseException.getMessage());
        } else if (baseException instanceof ClientException) {
            setClientExceptionPropertiesToBundle(bundle, (ClientException) baseException);
        } else if (baseException instanceof ServiceException) {
            setServiceExceptionPropertiesToBundle(bundle, (ServiceException) baseException);
        } else {
            Logger.info(str, "Setting Bundle result for Unknown Exception/Bad result.");
            setErrorToResultBundle(bundle, 8, baseException.getMessage());
        }
    }

    private String getAuthority(ILocalAuthenticationResult iLocalAuthenticationResult) {
        Uri.Builder builderScheme = new Uri.Builder().scheme("https");
        builderScheme.authority(iLocalAuthenticationResult.getAccessTokenRecord().getEnvironment());
        if (!TextUtils.isEmpty(iLocalAuthenticationResult.getTenantId())) {
            builderScheme.appendPath(iLocalAuthenticationResult.getTenantId());
        } else {
            builderScheme.appendPath("common");
        }
        return builderScheme.build().toString();
    }

    private void setClientExceptionPropertiesToBundle(Bundle bundle, ClientException clientException) {
        Logger.info(TAG + ":setClientExceptionPropertiesToBundle", "Setting properties from ClientException.");
        if ("device_network_not_available".equalsIgnoreCase(clientException.getErrorCode())) {
            setErrorToResultBundle(bundle, 3, ADALError.DEVICE_CONNECTION_IS_NOT_AVAILABLE.getDescription());
        } else if (ErrorStrings.NO_NETWORK_CONNECTION_POWER_OPTIMIZATION.equalsIgnoreCase(clientException.getErrorCode())) {
            setErrorToResultBundle(bundle, 3, ADALError.NO_NETWORK_CONNECTION_POWER_OPTIMIZATION.getDescription());
        } else if ("io_error".equalsIgnoreCase(clientException.getErrorCode())) {
            setErrorToResultBundle(bundle, 3, ADALError.IO_EXCEPTION.getDescription());
        }
    }

    private void setServiceExceptionPropertiesToBundle(Bundle bundle, ServiceException serviceException) {
        String str = TAG + ":setServiceExceptionPropertiesToBundle";
        Logger.info(str, "Setting properties from ServiceException.");
        bundle.putString("error", serviceException.getErrorCode());
        bundle.putString("error_description", serviceException.getMessage());
        bundle.putString("suberror", serviceException.getSubErrorCode());
        if (serviceException.getHttpResponseBody() != null) {
            bundle.putSerializable("response_body", serviceException.getHttpResponseBody());
        }
        if (serviceException.getHttpResponseHeaders() != null) {
            bundle.putSerializable("response_headers", serviceException.getHttpResponseHeaders());
        }
        bundle.putInt("status_code", serviceException.getHttpStatusCode());
        if (serviceException instanceof IntuneAppProtectionPolicyRequiredException) {
            Logger.verbose(str, "Exception was IntuneAppProtectionPolicyRequired");
            setIntuneAppProtectionPropertiesToBundle(bundle, (IntuneAppProtectionPolicyRequiredException) serviceException);
        }
        if ("invalid_grant".equalsIgnoreCase(serviceException.getErrorCode()) || OAuth2ErrorCode.INTERACTION_REQUIRED.equalsIgnoreCase(serviceException.getErrorCode())) {
            bundle.putString("error", ADALError.AUTH_REFRESH_FAILED_PROMPT_NOT_ALLOWED.getDescription());
            bundle.putString("error_description", serviceException.getMessage());
        }
    }

    private void setIntuneAppProtectionPropertiesToBundle(Bundle bundle, IntuneAppProtectionPolicyRequiredException intuneAppProtectionPolicyRequiredException) {
        Logger.info(TAG + ":setIntuneAppProtectionPropertiesToBundle", "Setting properties from IntuneAppProtectionPolicyRequiredException.");
        bundle.putString("com.microsoft.aad.adal:BrowserErrorCode", ADALError.AUTH_FAILED_INTUNE_POLICY_REQUIRED.name());
        bundle.putString("account.userinfo.tenantid", intuneAppProtectionPolicyRequiredException.getTenantId());
        bundle.putString(AuthenticationConstants.Broker.ACCOUNT_AUTHORITY, intuneAppProtectionPolicyRequiredException.getAuthorityUrl());
        bundle.putString("account.userinfo.userid", intuneAppProtectionPolicyRequiredException.getAccountUserId());
        bundle.putString(AuthenticationConstants.Broker.ACCOUNT_NAME, intuneAppProtectionPolicyRequiredException.getAccountUpn());
    }

    private void setErrorToResultBundle(Bundle bundle, int i, String str) {
        bundle.putInt("errorCode", i);
        bundle.putString("errorMessage", str);
    }
}
