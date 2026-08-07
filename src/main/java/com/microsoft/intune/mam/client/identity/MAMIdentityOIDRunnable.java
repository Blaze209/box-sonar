package com.microsoft.intune.mam.client.identity;

/* JADX INFO: loaded from: classes3.dex */
public class MAMIdentityOIDRunnable implements Runnable {
    private String mOid;
    private Runnable mWrapped;

    public MAMIdentityOIDRunnable(String str, Runnable runnable) {
        this.mOid = str;
        this.mWrapped = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        String currentThreadIdentityOID = MAMPolicyManager.getCurrentThreadIdentityOID();
        MAMPolicyManager.setCurrentThreadIdentityOID(this.mOid);
        try {
            this.mWrapped.run();
        } finally {
            MAMPolicyManager.setCurrentThreadIdentityOID(currentThreadIdentityOID);
        }
    }
}
