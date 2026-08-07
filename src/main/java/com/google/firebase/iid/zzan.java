package com.google.firebase.iid;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@20.1.0 */
/* JADX INFO: loaded from: classes14.dex */
final class zzan extends zzam<Void> {
    zzan(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    @Override // com.google.firebase.iid.zzam
    final boolean zza() {
        return true;
    }

    @Override // com.google.firebase.iid.zzam
    final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zza((Object) null);
        } else {
            zza(new zzap(4, "Invalid response to one way request"));
        }
    }
}
