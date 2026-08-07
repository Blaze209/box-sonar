package com.microsoft.intune.mam.client.app.backup;

import android.app.backup.BackupDataInput;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface MAMBackupDataInput {
    BackupDataInput asBackupDataInput();

    int getDataSize();

    String getKey();

    int readEntityData(byte[] bArr, int i, int i2) throws IOException;

    boolean readNextHeader() throws IOException;

    void skipEntityData() throws IOException;
}
