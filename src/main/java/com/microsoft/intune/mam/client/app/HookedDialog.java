package com.microsoft.intune.mam.client.app;

import android.app.Dialog;
import android.os.Bundle;

/* JADX INFO: loaded from: classes3.dex */
public interface HookedDialog {
    Dialog asDialog();

    void onCreateReal(Bundle bundle);
}
