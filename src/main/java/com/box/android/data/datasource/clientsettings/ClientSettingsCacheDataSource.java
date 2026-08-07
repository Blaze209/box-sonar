package com.box.android.data.datasource.clientsettings;

import android.content.SharedPreferences;
import com.box.android.data.api.models.ClientSettingsDTO;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.domain.localrepo.ILocalSharedPreferences;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClientSettingsCacheDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tJ,\u0010\r\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\t0\t \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\t0\t\u0018\u00010\u000e0\u000eH\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/box/android/data/datasource/clientsettings/ClientSettingsCacheDataSource;", "", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/domain/identity/IUserContextManager;Lcom/squareup/moshi/Moshi;)V", "getClientSettings", "Lcom/box/android/data/api/models/ClientSettingsDTO;", "saveClientSettings", "", "clientSettings", "moshiAdapter", "Lcom/squareup/moshi/JsonAdapter;", "kotlin.jvm.PlatformType", "getSharedPrefs", "Landroid/content/SharedPreferences;", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClientSettingsCacheDataSource {
    public static final String USER_CLIENT_ADMIN_SETTINGS = "com.box.android.MoCoBoxUsers.userClientAdminSettings";
    private final Moshi moshi;
    private final IUserContextManager userContextManager;

    @Inject
    public ClientSettingsCacheDataSource(IUserContextManager userContextManager, Moshi moshi) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.userContextManager = userContextManager;
        this.moshi = moshi;
    }

    public final ClientSettingsDTO getClientSettings() {
        String string;
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs == null || (string = sharedPrefs.getString(USER_CLIENT_ADMIN_SETTINGS, null)) == null) {
            return null;
        }
        return moshiAdapter().fromJson(string);
    }

    public final void saveClientSettings(ClientSettingsDTO clientSettings) {
        Intrinsics.checkNotNullParameter(clientSettings, "clientSettings");
        SharedPreferences sharedPrefs = getSharedPrefs();
        if (sharedPrefs != null) {
            SharedPreferences.Editor editorEdit = sharedPrefs.edit();
            editorEdit.putString(USER_CLIENT_ADMIN_SETTINGS, moshiAdapter().toJson(clientSettings));
            editorEdit.apply();
        }
    }

    private final JsonAdapter<ClientSettingsDTO> moshiAdapter() {
        return this.moshi.adapter(ClientSettingsDTO.class);
    }

    private final SharedPreferences getSharedPrefs() {
        return this.userContextManager.getEncryptedSharedPrefs(ILocalSharedPreferences.PreferenceName.MOCO_ADMIN_SETTINGS);
    }
}
