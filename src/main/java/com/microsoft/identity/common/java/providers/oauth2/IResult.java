package com.microsoft.identity.common.java.providers.oauth2;

/* JADX INFO: loaded from: classes14.dex */
public interface IResult {
    IErrorResponse getErrorResponse();

    boolean getSuccess();

    ISuccessResponse getSuccessResponse();
}
