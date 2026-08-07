package com.box.android.domain.utils;

import com.box.android.domain.identity.IUserContextManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserSharedPreferencesUtilities.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001c\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b¨\u0006\f"}, d2 = {"Lcom/box/android/domain/utils/UserSharedPreferencesUtilities;", "", "<init>", "()V", "savePreference", "", "Lcom/box/android/domain/identity/IUserContextManager;", "key", "", "value", "getPreference", "defaultValue", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UserSharedPreferencesUtilities {
    public static final UserSharedPreferencesUtilities INSTANCE = new UserSharedPreferencesUtilities();

    private UserSharedPreferencesUtilities() {
    }

    public final void savePreference(IUserContextManager iUserContextManager, String key, String value) {
        Intrinsics.checkNotNullParameter(iUserContextManager, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        iUserContextManager.getUserSharedPrefs().edit().putString(key, value).apply();
    }

    public final String getPreference(IUserContextManager iUserContextManager, String key, String defaultValue) {
        Intrinsics.checkNotNullParameter(iUserContextManager, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return iUserContextManager.getUserSharedPrefs().getString(key, defaultValue);
    }
}
