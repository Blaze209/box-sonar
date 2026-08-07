package com.microsoft.identity.common.java.commands;

import com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError;

/* JADX INFO: loaded from: classes14.dex */
public interface CommandCallback<T, U> extends TaskCompletedCallbackWithError<T, U> {
    void onCancel();
}
