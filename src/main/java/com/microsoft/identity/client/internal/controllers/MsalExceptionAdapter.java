package com.microsoft.identity.client.internal.controllers;

import com.microsoft.identity.client.exception.MsalArgumentException;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.exception.MsalException;
import com.microsoft.identity.client.exception.MsalIntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.client.exception.MsalServiceException;
import com.microsoft.identity.client.exception.MsalUiRequiredException;
import com.microsoft.identity.client.exception.MsalUnsupportedBrokerException;
import com.microsoft.identity.client.exception.MsalUserCancelException;
import com.microsoft.identity.common.java.exception.ArgumentException;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.exception.IntuneAppProtectionPolicyRequiredException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.exception.UiRequiredException;
import com.microsoft.identity.common.java.exception.UnsupportedBrokerException;
import com.microsoft.identity.common.java.exception.UserCancelException;
import com.microsoft.identity.common.java.util.StringUtil;

/* JADX INFO: loaded from: classes14.dex */
public class MsalExceptionAdapter {
    public static MsalException msalExceptionFromBaseException(BaseException baseException) {
        MsalException msalExceptionMsalExceptionFromBaseExceptionInternal = msalExceptionFromBaseExceptionInternal(baseException);
        msalExceptionMsalExceptionFromBaseExceptionInternal.setSubErrorCode(baseException.getSubErrorCode());
        return msalExceptionMsalExceptionFromBaseExceptionInternal;
    }

    private static MsalException msalExceptionFromBaseExceptionInternal(BaseException baseException) {
        if (baseException instanceof MsalException) {
            return (MsalException) baseException;
        }
        if (baseException instanceof ClientException) {
            ClientException clientException = (ClientException) baseException;
            return new MsalClientException(clientException.getErrorCode(), clientException.getMessage(), clientException);
        }
        if (baseException instanceof ArgumentException) {
            ArgumentException argumentException = (ArgumentException) baseException;
            return new MsalArgumentException(argumentException.getArgumentName(), argumentException.getOperationName(), argumentException.getMessage(), argumentException);
        }
        if (baseException instanceof UiRequiredException) {
            UiRequiredException uiRequiredException = (UiRequiredException) baseException;
            MsalUiRequiredException msalUiRequiredException = new MsalUiRequiredException(uiRequiredException.getErrorCode(), uiRequiredException.getMessage(), uiRequiredException);
            if (!StringUtil.isNullOrEmpty(uiRequiredException.getUsername())) {
                msalUiRequiredException.setUsername(uiRequiredException.getUsername());
            }
            return msalUiRequiredException;
        }
        if (baseException instanceof IntuneAppProtectionPolicyRequiredException) {
            return new MsalIntuneAppProtectionPolicyRequiredException((IntuneAppProtectionPolicyRequiredException) baseException);
        }
        if (baseException instanceof UnsupportedBrokerException) {
            return new MsalUnsupportedBrokerException((UnsupportedBrokerException) baseException);
        }
        if (baseException instanceof ServiceException) {
            ServiceException serviceException = (ServiceException) baseException;
            return new MsalServiceException(serviceException.getErrorCode(), serviceException.getMessage(), serviceException.getHttpStatusCode(), serviceException);
        }
        if (baseException instanceof UserCancelException) {
            return new MsalUserCancelException();
        }
        return new MsalClientException("unknown_error", baseException.getMessage(), baseException);
    }
}
