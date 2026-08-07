package com.microsoft.identity.client;

/* JADX INFO: loaded from: classes14.dex */
public class CurrentAccountResult implements ICurrentAccountResult {
    private boolean mChanged;
    private IAccount mCurrentAccount;
    private IAccount mPriorAccount;

    public CurrentAccountResult(IAccount iAccount, IAccount iAccount2, boolean z) {
        this.mCurrentAccount = iAccount;
        this.mPriorAccount = iAccount2;
        this.mChanged = z;
    }

    @Override // com.microsoft.identity.client.ICurrentAccountResult
    public IAccount getCurrentAccount() {
        return this.mCurrentAccount;
    }

    @Override // com.microsoft.identity.client.ICurrentAccountResult
    public IAccount getPriorAccount() {
        return this.mPriorAccount;
    }

    @Override // com.microsoft.identity.client.ICurrentAccountResult
    public boolean didAccountChange() {
        return this.mChanged;
    }
}
