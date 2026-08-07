package com.microsoft.identity.common.internal.broker.ipc;

import android.os.Bundle;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.cache.ActiveBrokerCacheUpdater;
import com.microsoft.identity.common.logging.Logger;

/* JADX INFO: loaded from: classes14.dex */
public class BrokerOperationBundle {
    private static final String TAG = "BrokerOperationBundle";
    public final Bundle bundle;
    public final Operation operation;
    public final String targetBrokerAppPackageName;

    public enum Operation {
        MSAL_HELLO(AuthenticationConstants.BrokerContentProvider.API.MSAL_HELLO, AuthenticationConstants.BrokerAccountManagerOperation.HELLO),
        MSAL_GET_INTENT_FOR_INTERACTIVE_REQUEST(AuthenticationConstants.BrokerContentProvider.API.ACQUIRE_TOKEN_INTERACTIVE, AuthenticationConstants.BrokerAccountManagerOperation.GET_INTENT_FOR_INTERACTIVE_REQUEST),
        MSAL_ACQUIRE_TOKEN_SILENT(AuthenticationConstants.BrokerContentProvider.API.ACQUIRE_TOKEN_SILENT, AuthenticationConstants.BrokerAccountManagerOperation.ACQUIRE_TOKEN_SILENT),
        MSAL_GET_ACCOUNTS(AuthenticationConstants.BrokerContentProvider.API.GET_ACCOUNTS, AuthenticationConstants.BrokerAccountManagerOperation.GET_ACCOUNTS),
        MSAL_REMOVE_ACCOUNT(AuthenticationConstants.BrokerContentProvider.API.REMOVE_ACCOUNT, AuthenticationConstants.BrokerAccountManagerOperation.REMOVE_ACCOUNT),
        MSAL_GET_DEVICE_MODE(AuthenticationConstants.BrokerContentProvider.API.GET_DEVICE_MODE, AuthenticationConstants.BrokerAccountManagerOperation.GET_DEVICE_MODE),
        MSAL_GET_CURRENT_ACCOUNT_IN_SHARED_DEVICE(AuthenticationConstants.BrokerContentProvider.API.GET_CURRENT_ACCOUNT_SHARED_DEVICE, AuthenticationConstants.BrokerAccountManagerOperation.GET_CURRENT_ACCOUNT),
        MSAL_SIGN_OUT_FROM_SHARED_DEVICE(AuthenticationConstants.BrokerContentProvider.API.SIGN_OUT_FROM_SHARED_DEVICE, AuthenticationConstants.BrokerAccountManagerOperation.REMOVE_ACCOUNT_FROM_SHARED_DEVICE),
        MSAL_GENERATE_SHR(AuthenticationConstants.BrokerContentProvider.API.GENERATE_SHR, AuthenticationConstants.BrokerAccountManagerOperation.GENERATE_SHR),
        BROKER_GET_KEY_FROM_INACTIVE_BROKER(null, null),
        BROKER_API_HELLO(AuthenticationConstants.BrokerContentProvider.API.BROKER_HELLO, null),
        BROKER_API_GET_BROKER_ACCOUNTS(AuthenticationConstants.BrokerContentProvider.API.BROKER_GET_ACCOUNTS, null),
        BROKER_API_REMOVE_BROKER_ACCOUNT(AuthenticationConstants.BrokerContentProvider.API.BROKER_REMOVE_ACCOUNT, null),
        BROKER_API_UPDATE_BRT(AuthenticationConstants.BrokerContentProvider.API.BROKER_UPDATE_BRT, null),
        BROKER_GET_FLIGHTS(AuthenticationConstants.BrokerContentProvider.API.BROKER_GET_FLIGHTS, null),
        BROKER_SET_FLIGHTS(AuthenticationConstants.BrokerContentProvider.API.BROKER_SET_FLIGHTS, null),
        MSAL_SSO_TOKEN(AuthenticationConstants.BrokerContentProvider.API.GET_SSO_TOKEN, null),
        MSAL_ALL_SSO_TOKENS(AuthenticationConstants.BrokerContentProvider.API.GET_ALL_SSO_TOKENS, null),
        DEVICE_REGISTRATION_OPERATIONS(AuthenticationConstants.BrokerContentProvider.API.DEVICE_REGISTRATION_PROTOCOLS, null),
        BROKER_API_UPLOAD_LOGS(AuthenticationConstants.BrokerContentProvider.API.BROKER_UPLOAD_LOGS, null),
        MSAL_FETCH_DCF_AUTH_RESULT(AuthenticationConstants.BrokerContentProvider.API.FETCH_DCF_AUTH_RESULT, null),
        MSAL_ACQUIRE_TOKEN_DCF(AuthenticationConstants.BrokerContentProvider.API.ACQUIRE_TOKEN_DCF, null),
        BROKER_DISCOVERY_METADATA_RETRIEVAL(AuthenticationConstants.BrokerContentProvider.API.BROKER_DISCOVERY_METADATA_RETRIEVAL, null),
        BROKER_DISCOVERY_FROM_SDK(AuthenticationConstants.BrokerContentProvider.API.BROKER_DISCOVERY_FROM_SDK, null),
        BROKER_DISCOVERY_SET_ACTIVE_BROKER(AuthenticationConstants.BrokerContentProvider.API.BROKER_DISCOVERY_SET_ACTIVE_BROKER, null),
        PASSTHROUGH(AuthenticationConstants.BrokerContentProvider.API.PASSTHROUGH, null),
        BROKER_READ_RESTRICTIONS_MANAGER(AuthenticationConstants.BrokerContentProvider.API.READ_RESTRICTIONS_MANAGER, null),
        MSAL_GET_PREFERRED_AUTH_METHOD(AuthenticationConstants.BrokerContentProvider.API.GET_PREFERRED_AUTH_METHOD, null),
        BROKER_INDIVIDUAL_LOGS_UPLOAD(AuthenticationConstants.BrokerContentProvider.API.BROKER_INDIVIDUAL_LOGS_UPLOAD, null),
        BROKER_API_RESTORE_MSA_ACCOUNTS_WITH_TRANSFER_TOKENS(AuthenticationConstants.BrokerContentProvider.API.BROKER_RESTORE_MSA_ACCOUNTS_WITH_TRANSFER_TOKENS, null),
        BROKER_WEBAPPS_API_GET_SUPPORTED_WEB_APPS_CONTRACTS(AuthenticationConstants.BrokerContentProvider.API.WEBAPPS_GET_SUPPORTED_WEB_APPS_CONTRACTS, null),
        BROKER_WEBAPPS_API_EXECUTE_WEB_APPS_REQUEST(AuthenticationConstants.BrokerContentProvider.API.WEBAPPS_EXECUTE_WEB_APPS_REQUEST, null),
        PROVISION_RESOURCE_ACCOUNT(AuthenticationConstants.BrokerContentProvider.API.PROVISION_RESOURCE_ACCOUNT, null),
        GET_AAD_DEVICE_ID(AuthenticationConstants.BrokerContentProvider.API.GET_AAD_DEVICE_ID, null),
        BROKER_GET_NUMBER_MATCH(AuthenticationConstants.BrokerContentProvider.API.BROKER_GET_NUMBER_MATCH, null);

        final String mAccountManagerOperation;
        final AuthenticationConstants.BrokerContentProvider.API mContentApi;

        public AuthenticationConstants.BrokerContentProvider.API getContentApi() {
            return this.mContentApi;
        }

        public String getAccountManagerOperation() {
            return this.mAccountManagerOperation;
        }

        Operation(AuthenticationConstants.BrokerContentProvider.API api, String str) {
            this.mContentApi = api;
            this.mAccountManagerOperation = str;
        }
    }

    public Operation getOperation() {
        return this.operation;
    }

    public String getTargetBrokerAppPackageName() {
        return this.targetBrokerAppPackageName;
    }

    public Bundle getBundle() {
        return this.bundle;
    }

    public BrokerOperationBundle(Operation operation, String str, Bundle bundle) {
        this.operation = operation;
        this.targetBrokerAppPackageName = str;
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        this.bundle = bundle2;
        bundle2.putBoolean(ActiveBrokerCacheUpdater.KEY_REQUEST_ACTIVE_BROKER_DATA, true);
        Logger.info(TAG, "Requested Active Broker Data");
    }

    public Bundle getAccountManagerBundle() throws BrokerCommunicationException {
        Bundle bundle = this.bundle;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString(AuthenticationConstants.Broker.BROKER_ACCOUNT_MANAGER_OPERATION_KEY, getAccountManagerAddAccountOperationKey());
        return bundle;
    }

    private String getAccountManagerAddAccountOperationKey() throws BrokerCommunicationException {
        String str = TAG + ":getAccountManagerAddAccountOperationKey";
        String accountManagerOperation = this.operation.getAccountManagerOperation();
        if (accountManagerOperation != null) {
            return accountManagerOperation;
        }
        String str2 = "Operation " + this.operation.name() + " is not supported by AccountManager addAccount().";
        Logger.warn(str, str2);
        throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_CLIENT_SIDE, IIpcStrategy.Type.ACCOUNT_MANAGER_ADD_ACCOUNT, str2, null);
    }

    public String getContentProviderPath() throws BrokerCommunicationException {
        String str = TAG + ":getContentProviderUriPath";
        AuthenticationConstants.BrokerContentProvider.API contentApi = this.operation.getContentApi();
        if (contentApi == null) {
            String str2 = "Operation " + this.operation.name() + " is not supported by ContentProvider.";
            Logger.warn(str, str2);
            throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_CLIENT_SIDE, IIpcStrategy.Type.CONTENT_PROVIDER, str2, null);
        }
        return contentApi.getPath();
    }
}
