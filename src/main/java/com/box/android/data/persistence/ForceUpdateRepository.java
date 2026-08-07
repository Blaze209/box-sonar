package com.box.android.data.persistence;

import android.content.SharedPreferences;
import com.box.android.domain.configuration.IForceUpdateRepository;
import com.box.android.domain.models.ForceUpdateReason;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.network.responses.KillSwitchModel;

/* JADX INFO: compiled from: ForceUpdateRepository.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0016\u0010\u000f\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\rH\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0012\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\n\u0010!\u001a\u0004\u0018\u00010 H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/box/android/data/persistence/ForceUpdateRepository;", "Lcom/box/android/domain/configuration/IForceUpdateRepository;", "sharedPreferences", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/SharedPreferences;)V", "saveForceUpdateFeatureEnabled", "", "enabled", "", "isForceUpdateFeatureEnabled", "saveMinSupportedVersion", "version", "", "getMinSupportedVersion", "saveUnsupportedVersions", KillSwitchModel.KILL_SWITCH_VERSIONS, "", "getUnsupportedVersions", "saveGQLValidationEnabled", "isGQLValidationEnabled", "saveGQLValidationAfterMonths", "months", "", "currentMonthsSinceBuild", "getGQLValidationAfterMonths", "recordGQLValidationError", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "clearGQLValidationError", "hasGQLValidationError", "saveLastTrackedForceUpdateReason", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "Lcom/box/android/domain/models/ForceUpdateReason;", "getLastTrackedForceUpdateReason", "Companion", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ForceUpdateRepository implements IForceUpdateRepository {
    private static final String APP_VERSION_FOR_GQL_ERROR = "app_version_for_gql_error";
    private static final boolean DEFAULT_VALUE_FORCE_UPDATE_FEATURE_ENABLED = false;
    private static final boolean DEFAULT_VALUE_GQL_ERROR = false;
    private static final int DEFAULT_VALUE_GQL_VALIDATION_AFTER_MONTHS = 20;
    private static final boolean DEFAULT_VALUE_GQL_VALIDATION_ENABLED = true;
    private static final String FORCE_UPDATE_FEATURE_ENABLED = "force_update_feature_enabled";
    private static final String GQL_VALIDATION_AFTER_MONTHS = "gql_validation_after_months";
    private static final String GQL_VALIDATION_ENABLED = "gql_validation_enabled";
    private static final String LAST_TRACKED_FORCE_UPDATE_REASON = "last_tracked_force_update_reason";
    private static final String MIN_SUPPORTED_VERSION = "min_supported_version";
    private static final String UNSUPPORTED_VERSIONS = "unsupported_versions";
    private final SharedPreferences sharedPreferences;

    @Inject
    public ForceUpdateRepository(@Named("app_updates_shared_preferences") SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.sharedPreferences = sharedPreferences;
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public void saveForceUpdateFeatureEnabled(boolean enabled) {
        BoxLogUtils.v(ExtensionsKt.getTAG(this), "Saving force update feature enabled: " + enabled);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(FORCE_UPDATE_FEATURE_ENABLED, enabled);
        editorEdit.apply();
        if (enabled) {
            return;
        }
        clearGQLValidationError();
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public boolean isForceUpdateFeatureEnabled() {
        return this.sharedPreferences.getBoolean(FORCE_UPDATE_FEATURE_ENABLED, false);
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public void saveMinSupportedVersion(String version) {
        Intrinsics.checkNotNullParameter(version, "version");
        String string = StringsKt.trim((CharSequence) version).toString();
        BoxLogUtils.v(ExtensionsKt.getTAG(this), "Saving min supported version: '" + string + "'");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        if (string.length() == 0) {
            editorEdit.remove(MIN_SUPPORTED_VERSION);
        } else {
            editorEdit.putString(MIN_SUPPORTED_VERSION, string);
        }
        editorEdit.apply();
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public String getMinSupportedVersion() {
        String string = this.sharedPreferences.getString(MIN_SUPPORTED_VERSION, null);
        if (string != null) {
            return StringsKt.trim((CharSequence) string).toString();
        }
        return null;
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public void saveUnsupportedVersions(Set<String> versions) {
        Intrinsics.checkNotNullParameter(versions, "versions");
        Set<String> set = versions;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.trim((CharSequence) it.next()).toString());
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((String) obj).length() > 0) {
                arrayList2.add(obj);
            }
        }
        Set<String> set2 = CollectionsKt.toSet(arrayList2);
        BoxLogUtils.v(ExtensionsKt.getTAG(this), "Saving unsupported versions: " + set2);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        if (set2.isEmpty()) {
            editorEdit.remove(UNSUPPORTED_VERSIONS);
        } else {
            editorEdit.putStringSet(UNSUPPORTED_VERSIONS, set2);
        }
        editorEdit.apply();
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public Set<String> getUnsupportedVersions() {
        Set<String> stringSet = this.sharedPreferences.getStringSet(UNSUPPORTED_VERSIONS, null);
        return stringSet == null ? SetsKt.emptySet() : stringSet;
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public void saveGQLValidationEnabled(boolean enabled) {
        BoxLogUtils.v(ExtensionsKt.getTAG(this), "Saving GQL validation enabled: " + enabled);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putBoolean(GQL_VALIDATION_ENABLED, enabled);
        editorEdit.apply();
        if (enabled) {
            return;
        }
        clearGQLValidationError();
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public boolean isGQLValidationEnabled() {
        return this.sharedPreferences.getBoolean(GQL_VALIDATION_ENABLED, true);
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public void saveGQLValidationAfterMonths(int months, int currentMonthsSinceBuild) {
        BoxLogUtils.v(ExtensionsKt.getTAG(this), "Saving GQL validation after months: " + months + " (current app age: " + currentMonthsSinceBuild + " months)");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putInt(GQL_VALIDATION_AFTER_MONTHS, months);
        editorEdit.apply();
        if (months > currentMonthsSinceBuild) {
            BoxLogUtils.v(ExtensionsKt.getTAG(this), "New threshold (" + months + ") exceeds current app age (" + currentMonthsSinceBuild + "), clearing GQL error");
            clearGQLValidationError();
        }
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public int getGQLValidationAfterMonths() {
        return this.sharedPreferences.getInt(GQL_VALIDATION_AFTER_MONTHS, 20);
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public void recordGQLValidationError(String appVersion) {
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        BoxLogUtils.v(ExtensionsKt.getTAG(this), "Recording GQL validation error for app version: '" + appVersion + "'");
        if (appVersion.length() > 0) {
            SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
            editorEdit.putString(APP_VERSION_FOR_GQL_ERROR, appVersion);
            editorEdit.apply();
        }
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public void clearGQLValidationError() {
        BoxLogUtils.v(ExtensionsKt.getTAG(this), "Clearing GQL validation error");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(APP_VERSION_FOR_GQL_ERROR);
        editorEdit.apply();
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public boolean hasGQLValidationError(String appVersion) {
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        BoxLogUtils.v(ExtensionsKt.getTAG(this), "Checking GQL validation error for app version: '" + appVersion + "'");
        if (appVersion.length() > 0) {
            return Intrinsics.areEqual(appVersion, this.sharedPreferences.getString(APP_VERSION_FOR_GQL_ERROR, null));
        }
        return false;
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public void saveLastTrackedForceUpdateReason(ForceUpdateReason reason) {
        BoxLogUtils.v(ExtensionsKt.getTAG(this), "Saving last tracked force update reason: " + reason);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        if (reason != null) {
            editorEdit.putString(LAST_TRACKED_FORCE_UPDATE_REASON, reason.name());
        } else {
            editorEdit.remove(LAST_TRACKED_FORCE_UPDATE_REASON);
        }
        editorEdit.apply();
    }

    @Override // com.box.android.domain.configuration.IForceUpdateRepository
    public ForceUpdateReason getLastTrackedForceUpdateReason() {
        String string = this.sharedPreferences.getString(LAST_TRACKED_FORCE_UPDATE_REASON, null);
        if (string == null) {
            return null;
        }
        try {
            return ForceUpdateReason.valueOf(string);
        } catch (IllegalArgumentException e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Invalid force update reason stored: " + string, e);
            return null;
        }
    }
}
