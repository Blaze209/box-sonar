package com.box.android.coreservices.utilities.intune;

import android.content.SharedPreferences;
import com.box.android.common.utilities.ApplicationProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IntuneKeysConfigUtils.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\n\u001a\u00020\u000bH\u0007J\b\u0010\f\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/coreservices/utilities/intune/IntuneKeysConfigUtils;", "", "<init>", "()V", "NO_UPN_SET", "", "saveNewValues", "", "intuneEnterprise", "intuneUPN", "isIntuneEnterpriseSet", "", "getIntuneUPN", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IntuneKeysConfigUtils {
    public static final IntuneKeysConfigUtils INSTANCE = new IntuneKeysConfigUtils();
    public static final String NO_UPN_SET = "";

    private IntuneKeysConfigUtils() {
    }

    @JvmStatic
    public static final void saveNewValues(String intuneEnterprise, String intuneUPN) {
        SharedPreferences.Editor editorEdit = ApplicationProvider.getApplication().getSharedPreferences("intune config shared_pref", 0).edit();
        if (intuneEnterprise != null) {
            editorEdit.putString("Intune Enterprise", intuneEnterprise);
        }
        if (intuneUPN != null) {
            editorEdit.putString("userprincipalname", intuneUPN);
        }
        editorEdit.apply();
    }

    @JvmStatic
    public static final boolean isIntuneEnterpriseSet() {
        return Intrinsics.areEqual(ApplicationProvider.getApplication().getSharedPreferences("intune config shared_pref", 0).getString("Intune Enterprise", ""), "1");
    }

    @JvmStatic
    public static final String getIntuneUPN() {
        String string = ApplicationProvider.getApplication().getSharedPreferences("intune config shared_pref", 0).getString("userprincipalname", "");
        Intrinsics.checkNotNull(string);
        return string;
    }
}
