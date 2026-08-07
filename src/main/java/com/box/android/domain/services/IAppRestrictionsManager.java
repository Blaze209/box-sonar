package com.box.android.domain.services;

import android.os.Bundle;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: compiled from: IAppRestrictionsManager.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J$\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b2\u0006\u0010\t\u001a\u00020\nH&J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&J\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u0017\u001a\u00020\u0015H&J$\u0010\u0018\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\b2\u0006\u0010\u0019\u001a\u00020\nH&J$\u0010\u001a\u001a\u00020\u00032\u001a\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\bH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\nH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u000b\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u0012\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0012\u0010\u001e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0004¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/services/IAppRestrictionsManager;", "", "isRestrictionsSet", "", "()Z", "getMandatoryFieldsNotSet", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "appRestrictionsBundle", "Landroid/os/Bundle;", "savedAppRestrictions", "getSavedAppRestrictions", "()Landroid/os/Bundle;", "getString", "appRestrictionsKey", "getBoolean", "(Ljava/lang/String;)Ljava/lang/Boolean;", "latestAppRestrictions", "getLatestAppRestrictions", "setAppRestrictions", "", "commitAppRestrictions", "clearAppRestrictions", "getAlteredAppRestrictionKeys", "latest", "containsMandatoryKey", "keys", "isRestrictionsValid", "restrictions", "isAppFedrampHighCompliant", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IAppRestrictionsManager {
    void clearAppRestrictions();

    void commitAppRestrictions(Bundle appRestrictionsBundle);

    boolean containsMandatoryKey(ArrayList<String> keys) throws RuntimeException;

    ArrayList<String> getAlteredAppRestrictionKeys(Bundle latest);

    Boolean getBoolean(String appRestrictionsKey);

    Bundle getLatestAppRestrictions();

    ArrayList<String> getMandatoryFieldsNotSet(Bundle appRestrictionsBundle) throws RuntimeException;

    Bundle getSavedAppRestrictions();

    String getString(String appRestrictionsKey);

    boolean isAppFedrampHighCompliant();

    boolean isRestrictionsSet();

    boolean isRestrictionsValid(Bundle restrictions) throws RuntimeException;

    void setAppRestrictions();
}
