package com.microsoft.identity.common.java.exception;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
public interface IErrorInformation {
    String getErrorCode();

    @Nullable
    String getSubErrorCode();
}
