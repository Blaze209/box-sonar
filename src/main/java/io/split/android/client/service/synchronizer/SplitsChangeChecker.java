package io.split.android.client.service.synchronizer;

/* JADX INFO: loaded from: classes4.dex */
public class SplitsChangeChecker {
    public boolean changeNumberIsNewer(long oldChangeNumber, long newChangeNumber) {
        return oldChangeNumber < newChangeNumber;
    }
}
