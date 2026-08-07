package com.microsoft.identity.common.java.commands;

/* JADX INFO: loaded from: classes14.dex */
public class EmptyCommandCallback<T, U> implements CommandCallback<T, U> {
    @Override // com.microsoft.identity.common.java.commands.CommandCallback
    public void onCancel() {
    }

    @Override // com.microsoft.identity.common.java.util.TaskCompletedCallbackWithError
    public void onError(U u) {
    }

    @Override // com.microsoft.identity.common.java.util.TaskCompletedCallback
    public void onTaskCompleted(T t) {
    }
}
