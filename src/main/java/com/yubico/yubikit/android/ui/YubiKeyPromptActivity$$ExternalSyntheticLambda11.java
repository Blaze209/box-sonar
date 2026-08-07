package com.yubico.yubikit.android.ui;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class YubiKeyPromptActivity$$ExternalSyntheticLambda11 implements Runnable {
    public final /* synthetic */ YubiKeyPromptActivity f$0;

    public /* synthetic */ YubiKeyPromptActivity$$ExternalSyntheticLambda11(YubiKeyPromptActivity yubiKeyPromptActivity) {
        this.f$0 = yubiKeyPromptActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.finishIfDone();
    }
}
