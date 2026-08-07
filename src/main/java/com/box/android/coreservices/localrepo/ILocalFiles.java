package com.box.android.coreservices.localrepo;

import com.box.android.domain.identity.IUserContextComponent;
import java.io.File;

/* JADX INFO: loaded from: classes9.dex */
public interface ILocalFiles extends IUserContextComponent {

    public enum OfflineStatus {
        UP_TO_DATE,
        OUT_OF_DATE,
        DOES_NOT_EXIST
    }

    IDownloadFiles getDownloads();

    IPreviewFiles getPreviews();

    File getUserExternalStorageDirectory(String str);

    @Override // com.box.android.domain.identity.IUserContextComponent
    void onCreate(String str) throws IUserContextComponent.UserContextComponentCreationException;

    @Override // com.box.android.domain.identity.IUserContextComponent
    void onHardDestroy();

    @Override // com.box.android.domain.identity.IUserContextComponent
    void onSoftDestroy();

    void recoverMemory();
}
