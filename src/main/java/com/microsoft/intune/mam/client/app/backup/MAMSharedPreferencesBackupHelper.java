package com.microsoft.intune.mam.client.app.backup;

import android.app.backup.BackupDataOutput;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.microsoft.intune.mam.client.app.MAMComponents;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMSharedPreferencesBackupHelper extends SharedPreferencesBackupHelper implements HookedSharedPreferencesBackupHelper {
    private SharedPreferencesBackupHelperBehavior mBehavior;
    private Context mContext;
    private String[] mPrefGroups;

    public MAMSharedPreferencesBackupHelper(Context context, String... strArr) {
        super(context, strArr);
        SharedPreferencesBackupHelperBehavior sharedPreferencesBackupHelperBehavior = (SharedPreferencesBackupHelperBehavior) MAMComponents.get(SharedPreferencesBackupHelperBehavior.class);
        this.mBehavior = sharedPreferencesBackupHelperBehavior;
        this.mContext = context;
        this.mPrefGroups = strArr;
        sharedPreferencesBackupHelperBehavior.init(this);
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupHelper
    public String[] getFileNames() {
        return this.mPrefGroups;
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupHelper
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.microsoft.intune.mam.client.app.backup.HookedBackupHelper
    public boolean isValid() {
        String[] strArr;
        return (this.mContext == null || (strArr = this.mPrefGroups) == null || strArr.length == 0) ? false : true;
    }

    @Override // android.app.backup.SharedPreferencesBackupHelper, android.app.backup.BackupHelper, com.microsoft.intune.mam.client.app.backup.HookedBackupHelper
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
            return new File(this.mContext.getApplicationInfo().dataDir, "shared_prefs");
        }
        return null;
    }
}
