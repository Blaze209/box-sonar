package com.box.android.domain.configuration;

import com.box.android.domain.models.ForceUpdateReason;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Set;
import kotlin.Metadata;
import sdk.pendo.io.network.responses.KillSwitchModel;

/* JADX INFO: compiled from: IForceUpdateRepository.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0016\u0010\u000b\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\rH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0010\u001a\u00020\u0005H&J\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H&J\b\u0010\u0015\u001a\u00020\u0013H&J\u0010\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\tH&J\b\u0010\u0018\u001a\u00020\u0003H&J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\tH&J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH&J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH&¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lcom/box/android/domain/configuration/IForceUpdateRepository;", "", "saveForceUpdateFeatureEnabled", "", "enabled", "", "isForceUpdateFeatureEnabled", "saveMinSupportedVersion", "version", "", "getMinSupportedVersion", "saveUnsupportedVersions", KillSwitchModel.KILL_SWITCH_VERSIONS, "", "getUnsupportedVersions", "saveGQLValidationEnabled", "isGQLValidationEnabled", "saveGQLValidationAfterMonths", "months", "", "currentMonthsSinceBuild", "getGQLValidationAfterMonths", "recordGQLValidationError", RemoteConfigConstants.RequestFieldKey.APP_VERSION, "clearGQLValidationError", "hasGQLValidationError", "saveLastTrackedForceUpdateReason", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "Lcom/box/android/domain/models/ForceUpdateReason;", "getLastTrackedForceUpdateReason", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IForceUpdateRepository {
    void clearGQLValidationError();

    int getGQLValidationAfterMonths();

    ForceUpdateReason getLastTrackedForceUpdateReason();

    String getMinSupportedVersion();

    Set<String> getUnsupportedVersions();

    boolean hasGQLValidationError(String appVersion);

    boolean isForceUpdateFeatureEnabled();

    boolean isGQLValidationEnabled();

    void recordGQLValidationError(String appVersion);

    void saveForceUpdateFeatureEnabled(boolean enabled);

    void saveGQLValidationAfterMonths(int months, int currentMonthsSinceBuild);

    void saveGQLValidationEnabled(boolean enabled);

    void saveLastTrackedForceUpdateReason(ForceUpdateReason reason);

    void saveMinSupportedVersion(String version);

    void saveUnsupportedVersions(Set<String> versions);
}
