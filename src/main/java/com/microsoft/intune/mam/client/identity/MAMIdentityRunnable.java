package com.microsoft.intune.mam.client.identity;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class MAMIdentityRunnable implements Runnable {
    private String mIdentity;
    private Runnable mWrapped;

    public MAMIdentityRunnable(String str, Runnable runnable) {
        this.mIdentity = str;
        this.mWrapped = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        String currentThreadIdentity = MAMPolicyManager.getCurrentThreadIdentity();
        MAMPolicyManager.setCurrentThreadIdentity(this.mIdentity);
        try {
            this.mWrapped.run();
        } finally {
            MAMPolicyManager.setCurrentThreadIdentity(currentThreadIdentity);
        }
    }
}
