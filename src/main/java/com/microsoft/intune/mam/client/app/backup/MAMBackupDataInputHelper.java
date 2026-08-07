package com.microsoft.intune.mam.client.app.backup;

import android.app.backup.BackupDataInput;
import com.microsoft.intune.mam.client.telemetry.events.MAMExternalError;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMBackupDataInputHelper {
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(MAMBackupDataInputHelper.class);
    private static final Map<BackupDataInput, MAMBackupDataInput> BACKUP_DATA_INPUT_MAP = new ConcurrentHashMap();

    private MAMBackupDataInputHelper() {
    }

    protected static void track(BackupDataInput backupDataInput, MAMBackupDataInput mAMBackupDataInput) {
        BACKUP_DATA_INPUT_MAP.put(backupDataInput, mAMBackupDataInput);
    }

    private static MAMBackupDataInput find(BackupDataInput backupDataInput) {
        return BACKUP_DATA_INPUT_MAP.get(backupDataInput);
    }

    protected static void remove(BackupDataInput backupDataInput) {
        BACKUP_DATA_INPUT_MAP.remove(backupDataInput);
    }

    public static boolean readNextHeader(BackupDataInput backupDataInput) throws IOException {
        MAMBackupDataInput mAMBackupDataInputFind = find(backupDataInput);
        if (mAMBackupDataInputFind == null) {
            LOGGER.error(MAMExternalError.BACK_UP_MISSING_MAM_COPY, "Expected to find MAMBackupDataInput for BackupDataInput. Falling back to non-MAM BackupDataInput", new Object[0]);
            return backupDataInput.readNextHeader();
        }
        return mAMBackupDataInputFind.readNextHeader();
    }
}
