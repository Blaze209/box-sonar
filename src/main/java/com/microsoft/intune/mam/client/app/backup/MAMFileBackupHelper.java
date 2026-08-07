package com.microsoft.intune.mam.client.app.backup;

import android.app.backup.BackupDataOutput;
import android.app.backup.FileBackupHelper;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.app.MAMComponents;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMFileBackupHelper extends FileBackupHelper implements HookedFileBackupHelper {
    private FileBackupHelperBehavior mBehavior;
    private Context mContext;
    private String[] mFileNames;

    public MAMFileBackupHelper(Context context, String... strArr) {
        super(context, strArr);
        FileBackupHelperBehavior fileBackupHelperBehavior = (FileBackupHelperBehavior) MAMComponents.get(FileBackupHelperBehavior.class);
        this.mBehavior = fileBackupHelperBehavior;
        this.mContext = context;
        this.mFileNames = strArr;
        fileBackupHelperBehavior.init(this);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupHelper
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupHelper
    public String[] getFileNames() {
        return this.mFileNames;
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupHelper
    public boolean isValid() {
        String[] strArr;
        return (this.mContext == null || (strArr = this.mFileNames) == null || strArr.length == 0) ? false : true;
    }

    @Override // android.app.backup.FileBackupHelper, android.app.backup.BackupHelper, com.microsoft.intune.mam.client.app.backup.HookedBackupHelper
    public void performBackup(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) {
        this.mBehavior.performBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupHelper
    public void performBackupReal(ParcelFileDescriptor parcelFileDescriptor, BackupDataOutput backupDataOutput, ParcelFileDescriptor parcelFileDescriptor2) {
        super.performBackup(parcelFileDescriptor, backupDataOutput, parcelFileDescriptor2);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupHelper
    public File getRootDirectory() {
        if (isValid()) {
            return this.mContext.getFilesDir();
        }
        return null;
    }
}
