package com.microsoft.identity.client;

/* JADX INFO: loaded from: classes14.dex */
public interface ICurrentAccountResult {
    boolean didAccountChange();

    IAccount getCurrentAccount();

    IAccount getPriorAccount();
}
