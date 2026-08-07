package com.box.android.localrepo;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.DocumentsContract;
import com.box.android.application.BoxBaseApplication;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.coreservices.models.BoxAccountManager;
import com.box.android.domain.identity.IUserContextComponent;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.box.android.providers.BoxDocumentsProvider;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;

/* JADX INFO: loaded from: classes12.dex */
public class DocumentProviderPreferences extends LocalSharedPreferences {
    private static final String EXTRA_DOCUMENT_PROVIDER_ENABLED = "documentProviderEnabled";

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onSoftDestroy() {
    }

    public DocumentProviderPreferences(Context context) {
    }

    @Override // com.box.android.localrepo.LocalSharedPreferences, com.box.android.domain.localrepo.ILocalSharedPreferences
    public SharedPreferences getSharedPreferences() {
        return getSharedPreferences(ILocalSharedPreferences.PreferenceName.DOCUMENT_PROVIDER);
    }

    @Override // com.box.android.localrepo.LocalSharedPreferences, com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onHardDestroy() {
        disableDocumentProvider();
    }

    @Override // com.box.android.usercontext.UserContextComponent, com.box.android.domain.identity.IUserContextComponent
    public void onCreate(String str) throws IUserContextComponent.UserContextComponentCreationException {
        super.onCreate(str);
        if (!CommonBoxUtil.isRunningAutomatedTest() && isDocumentProviderUserEnabled()) {
            enableDocumentProvider();
        } else {
            disableDocumentProvider();
        }
    }

    private void enableDocumentProvider() {
        BoxLogUtils.d("DocumentProviderPreferences", "Enabling BoxDocumentsProvider");
        MAMPackageManagement.setComponentEnabledSetting(BoxBaseApplication.getInstance().getPackageManager(), new ComponentName(BoxBaseApplication.getInstance(), (Class<?>) BoxDocumentsProvider.class), 1, 1);
        BoxBaseApplication.getInstance().getApplicationContext().getContentResolver().notifyChange(DocumentsContract.buildRootsUri(BoxDocumentsProvider.AUTHORITY), null);
    }

    private void disableDocumentProvider() {
        BoxLogUtils.d("DocumentProviderPreferences", "Disabling BoxDocumentsProvider");
        MAMPackageManagement.setComponentEnabledSetting(BoxBaseApplication.getInstance().getPackageManager(), new ComponentName(BoxBaseApplication.getInstance(), (Class<?>) BoxDocumentsProvider.class), 2, 1);
    }

    public boolean isDocumentProviderUserEnabled() {
        return (!getSharedPreferences().getBoolean(EXTRA_DOCUMENT_PROVIDER_ENABLED, true) || BoxAccountManager.isSaveOnDeviceAdminDisabled(super.getSharedPreferences()) || BoxAccountManager.doesSaveOnDeviceRequireEncryptedDevice(super.getSharedPreferences())) ? false : true;
    }
}
