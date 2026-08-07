package com.microsoft.identity.common.internal.broker;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: compiled from: IRestrictionsManager.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003H&J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH&J&\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/IRestrictionsManager;", "", "getBoolean", "", "key", "", "brokerAppPackageName", "defaultValue", "getMultiValues", "Landroid/os/Bundle;", "bundleOfKeys", "getString", "BrokerRestrictionsManagerKeys", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IRestrictionsManager {
    public static final String BOOLEAN_VALUES_KEY = "booleanValuesKey";

    /* JADX INFO: renamed from: BrokerRestrictionsManagerKeys, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String PREFERRED_AUTH_CONFIG = "preferred_auth_config";
    public static final String SDM_SUPPRESS_CAMERA_CONSENT = "sdm_suppress_camera_consent";
    public static final String STRING_VALUES_KEY = "stringValuesKey";
    public static final String SUPPRESS_CAMERA_CONSENT = "suppress_camera_consent";

    @JvmStatic
    static Bundle buildMultiValueRequest() {
        return INSTANCE.buildMultiValueRequest();
    }

    @JvmStatic
    static Bundle buildMultiValueRequest(Set<String> set) {
        return INSTANCE.buildMultiValueRequest(set);
    }

    @JvmStatic
    static Bundle buildMultiValueRequest(Set<String> set, Set<String> set2) {
        return INSTANCE.buildMultiValueRequest(set, set2);
    }

    boolean getBoolean(String key, String brokerAppPackageName, boolean defaultValue);

    Bundle getMultiValues(String brokerAppPackageName, Bundle bundleOfKeys);

    String getString(String key, String brokerAppPackageName, String defaultValue);

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.broker.IRestrictionsManager$BrokerRestrictionsManagerKeys, reason: from kotlin metadata */
    /* JADX INFO: compiled from: IRestrictionsManager.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\n\u001a\u00020\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/IRestrictionsManager$BrokerRestrictionsManagerKeys;", "", "()V", "BOOLEAN_VALUES_KEY", "", "PREFERRED_AUTH_CONFIG", "SDM_SUPPRESS_CAMERA_CONSENT", "getSDM_SUPPRESS_CAMERA_CONSENT$annotations", "STRING_VALUES_KEY", "SUPPRESS_CAMERA_CONSENT", "buildMultiValueRequest", "Landroid/os/Bundle;", "stringKeys", "", "booleanKeys", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String BOOLEAN_VALUES_KEY = "booleanValuesKey";
        public static final String PREFERRED_AUTH_CONFIG = "preferred_auth_config";
        public static final String SDM_SUPPRESS_CAMERA_CONSENT = "sdm_suppress_camera_consent";
        public static final String STRING_VALUES_KEY = "stringValuesKey";
        public static final String SUPPRESS_CAMERA_CONSENT = "suppress_camera_consent";

        @Deprecated(message = "Use SUPPRESS_CAMERA_CONSENT instead")
        public static /* synthetic */ void getSDM_SUPPRESS_CAMERA_CONSENT$annotations() {
        }

        @JvmStatic
        public final Bundle buildMultiValueRequest() {
            return buildMultiValueRequest$default(this, null, null, 3, null);
        }

        @JvmStatic
        public final Bundle buildMultiValueRequest(Set<String> set) {
            return buildMultiValueRequest$default(this, set, null, 2, null);
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Bundle buildMultiValueRequest$default(Companion companion, Set set, Set set2, int i, Object obj) {
            if ((i & 1) != 0) {
                set = null;
            }
            if ((i & 2) != 0) {
                set2 = null;
            }
            return companion.buildMultiValueRequest(set, set2);
        }

        @JvmStatic
        public final Bundle buildMultiValueRequest(Set<String> stringKeys, Set<String> booleanKeys) {
            ArrayList<String> arrayList = stringKeys != null ? new ArrayList<>(stringKeys) : null;
            ArrayList<String> arrayList2 = booleanKeys != null ? new ArrayList<>(booleanKeys) : null;
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("stringValuesKey", arrayList);
            bundle.putStringArrayList("booleanValuesKey", arrayList2);
            return bundle;
        }
    }

    /* JADX INFO: compiled from: IRestrictionsManager.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ String getString$default(IRestrictionsManager iRestrictionsManager, String str, String str2, String str3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getString");
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            return iRestrictionsManager.getString(str, str2, str3);
        }

        public static /* synthetic */ boolean getBoolean$default(IRestrictionsManager iRestrictionsManager, String str, String str2, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBoolean");
            }
            if ((i & 4) != 0) {
                z = false;
            }
            return iRestrictionsManager.getBoolean(str, str2, z);
        }
    }
}
