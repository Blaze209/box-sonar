package com.microsoft.identity.common.java.util;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.providers.oauth2.AuthorizationResult;
import com.microsoft.identity.common.java.providers.oauth2.IResult;

/* JADX INFO: loaded from: classes14.dex */
public class ResultUtil {
    public static void logResult(String str, IResult iResult) {
        if (str == null) {
            throw new NullPointerException("tag is marked non-null but is null");
        }
        if (iResult == null) {
            throw new NullPointerException("result is marked non-null but is null");
        }
        String str2 = str + ":" + iResult.getClass().getSimpleName();
        if (iResult.getSuccess()) {
            Logger.info(str2, "Success Result");
            logExposedFieldsOfObject(str2, iResult.getSuccessResponse());
        } else {
            Logger.warn(str2, "Failure Result");
            if (iResult.getErrorResponse() != null) {
                if (iResult.getErrorResponse().getError() != null) {
                    Logger.warn(str2, "Error: " + iResult.getErrorResponse().getError());
                }
                if (iResult.getErrorResponse().getErrorDescription() != null) {
                    Logger.warnPII(str2, "Description: " + iResult.getErrorResponse().getErrorDescription());
                }
                logExposedFieldsOfObject(str2, iResult.getErrorResponse());
            }
        }
        if (iResult instanceof AuthorizationResult) {
            AuthorizationResult authorizationResult = (AuthorizationResult) iResult;
            if (authorizationResult.getAuthorizationStatus() != null) {
                Logger.info(str2, "Authorization Status: " + authorizationResult.getAuthorizationStatus().toString());
            }
        }
    }

    public static void logExposedFieldsOfObject(String str, Object obj) {
        if (str == null) {
            throw new NullPointerException("tag is marked non-null but is null");
        }
        if (obj == null) {
            throw new NullPointerException("object is marked non-null but is null");
        }
        Logger.info(str + ":" + obj.getClass().getSimpleName(), ObjectMapper.serializeExposedFieldsOfObjectToJsonString(obj));
    }
}
