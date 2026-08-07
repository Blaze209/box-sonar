package com.box.android.common.tests;

import android.util.Log;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: InstrumentationArguments.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0018J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020/0.J\u0006\u00100\u001a\u000201R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b \u0010\u001cR\u0013\u0010!\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010\u001cR\u0013\u0010#\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b$\u0010\u001cR\u0013\u0010%\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b&\u0010\u001cR\u0013\u0010'\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b(\u0010\u001cR\u0013\u0010)\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b*\u0010\u001cR\u0013\u0010+\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b,\u0010\u001c¨\u00063"}, d2 = {"Lcom/box/android/common/tests/InstrumentationArguments;", "", "<init>", "()V", "CLEAR_SHARED_PREFERENCES", "", "SHOULD_NOT_DISPLAY_FIRST_TIME_UX", "KEY_TEST_LOGIN", "KEY_TEST_PASSWORD", "KEY_TEST_LOGIN_ACCT2", "KEY_TEST_PASSWORD_ACCT2", "KEY_TEST_LOGIN_DEVICETRUST", "KEY_TEST_PASSWORD_DEVICETRUST", "KEY_TEST_LOGIN_FREE_ACCT", "KEY_TEST_PASSWORD_FREE_ACCT", InstrumentationArguments.ADDITIONAL_FEATURE_FLIP_TURNED_ON, "SHARED_PREFERENCES_VALUES", "arguments", "", "getArguments", "()Ljava/util/Map;", "setArguments", "(Ljava/util/Map;)V", "needToClearSharedPreferences", "", "shouldNotDisplayFirstTimeUX", "featureFlipTurnedOn", "getFeatureFlipTurnedOn", "()Ljava/lang/String;", "testLogin", "getTestLogin", "testPassword", "getTestPassword", "testLoginAcct2", "getTestLoginAcct2", "testPasswordAcct2", "getTestPasswordAcct2", "testLoginDeviceTrust", "getTestLoginDeviceTrust", "testPasswordDeviceTrust", "getTestPasswordDeviceTrust", "testLoginFreeAcct", "getTestLoginFreeAcct", "testPasswordFreeAcct", "getTestPasswordFreeAcct", "extraSharedPreferencesValues", "", "Lcom/box/android/common/tests/InstrumentationArguments$SharedPreferenceValue;", "logArguments", "", "SharedPreferenceValue", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class InstrumentationArguments {
    private static final String ADDITIONAL_FEATURE_FLIP_TURNED_ON = "ADDITIONAL_FEATURE_FLIP_TURNED_ON";
    private static final String CLEAR_SHARED_PREFERENCES = "clearSharedPreferences";
    public static final InstrumentationArguments INSTANCE = new InstrumentationArguments();
    private static final String KEY_TEST_LOGIN = "UI-Test:TEST_LOGIN";
    private static final String KEY_TEST_LOGIN_ACCT2 = "UI-Test:TEST_LOGIN_ACCT2";
    private static final String KEY_TEST_LOGIN_DEVICETRUST = "UI-Test:TEST_LOGIN_DEVICETRUST";
    private static final String KEY_TEST_LOGIN_FREE_ACCT = "UI-Test:TEST_LOGIN_FREE_ACCT";
    private static final String KEY_TEST_PASSWORD = "UI-Test:TEST_PASSWORD";
    private static final String KEY_TEST_PASSWORD_ACCT2 = "UI-Test:TEST_PASSWORD_ACCT2";
    private static final String KEY_TEST_PASSWORD_DEVICETRUST = "UI-Test:TEST_PASSWORD_DEVICETRUST";
    private static final String KEY_TEST_PASSWORD_FREE_ACCT = "UI-Test:TEST_PASSWORD_FREE_ACCT";
    private static final String SHARED_PREFERENCES_VALUES = "sharedPreferencesValues";
    private static final String SHOULD_NOT_DISPLAY_FIRST_TIME_UX = "shouldNotDisplayFirstTimeUx";
    private static Map<String, String> arguments;

    private InstrumentationArguments() {
    }

    public final Map<String, String> getArguments() {
        return arguments;
    }

    public final void setArguments(Map<String, String> map) {
        arguments = map;
    }

    public final boolean needToClearSharedPreferences() {
        Map<String, String> map = arguments;
        return Boolean.parseBoolean(map != null ? map.get(CLEAR_SHARED_PREFERENCES) : null);
    }

    public final boolean shouldNotDisplayFirstTimeUX() {
        Map<String, String> map = arguments;
        return Boolean.parseBoolean(map != null ? map.get(SHOULD_NOT_DISPLAY_FIRST_TIME_UX) : null);
    }

    public final String getFeatureFlipTurnedOn() {
        Map<String, String> map = arguments;
        if (map != null) {
            return map.get(ADDITIONAL_FEATURE_FLIP_TURNED_ON);
        }
        return null;
    }

    public final String getTestLogin() {
        Map<String, String> map = arguments;
        if (map != null) {
            return map.get(KEY_TEST_LOGIN);
        }
        return null;
    }

    public final String getTestPassword() {
        Map<String, String> map = arguments;
        if (map != null) {
            return map.get(KEY_TEST_PASSWORD);
        }
        return null;
    }

    public final String getTestLoginAcct2() {
        Map<String, String> map = arguments;
        if (map != null) {
            return map.get(KEY_TEST_LOGIN_ACCT2);
        }
        return null;
    }

    public final String getTestPasswordAcct2() {
        Map<String, String> map = arguments;
        if (map != null) {
            return map.get(KEY_TEST_PASSWORD_ACCT2);
        }
        return null;
    }

    public final String getTestLoginDeviceTrust() {
        Map<String, String> map = arguments;
        if (map != null) {
            return map.get(KEY_TEST_LOGIN_DEVICETRUST);
        }
        return null;
    }

    public final String getTestPasswordDeviceTrust() {
        Map<String, String> map = arguments;
        if (map != null) {
            return map.get(KEY_TEST_PASSWORD_DEVICETRUST);
        }
        return null;
    }

    public final String getTestLoginFreeAcct() {
        Map<String, String> map = arguments;
        if (map != null) {
            return map.get(KEY_TEST_LOGIN_FREE_ACCT);
        }
        return null;
    }

    public final String getTestPasswordFreeAcct() {
        Map<String, String> map = arguments;
        if (map != null) {
            return map.get(KEY_TEST_PASSWORD_FREE_ACCT);
        }
        return null;
    }

    /* JADX INFO: compiled from: InstrumentationArguments.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\r\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\r\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J'\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0010HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/box/android/common/tests/InstrumentationArguments$SharedPreferenceValue;", "", "preferenceName", "", "key", "value", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getPreferenceName", "()Ljava/lang/String;", "getKey", "getValue", "getBooleanValue", "", "()Ljava/lang/Boolean;", "getIntegerValue", "", "()Ljava/lang/Integer;", "getFloatValue", "", "()Ljava/lang/Float;", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "other", "hashCode", "toString", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SharedPreferenceValue {
        private final String key;
        private final String preferenceName;
        private final String value;

        public static /* synthetic */ SharedPreferenceValue copy$default(SharedPreferenceValue sharedPreferenceValue, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sharedPreferenceValue.preferenceName;
            }
            if ((i & 2) != 0) {
                str2 = sharedPreferenceValue.key;
            }
            if ((i & 4) != 0) {
                str3 = sharedPreferenceValue.value;
            }
            return sharedPreferenceValue.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getPreferenceName() {
            return this.preferenceName;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getKey() {
            return this.key;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        public final SharedPreferenceValue copy(String preferenceName, String key, String value) {
            Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            return new SharedPreferenceValue(preferenceName, key, value);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SharedPreferenceValue)) {
                return false;
            }
            SharedPreferenceValue sharedPreferenceValue = (SharedPreferenceValue) other;
            return Intrinsics.areEqual(this.preferenceName, sharedPreferenceValue.preferenceName) && Intrinsics.areEqual(this.key, sharedPreferenceValue.key) && Intrinsics.areEqual(this.value, sharedPreferenceValue.value);
        }

        public int hashCode() {
            return (((this.preferenceName.hashCode() * 31) + this.key.hashCode()) * 31) + this.value.hashCode();
        }

        public String toString() {
            return "SharedPreferenceValue(preferenceName=" + this.preferenceName + ", key=" + this.key + ", value=" + this.value + ")";
        }

        public SharedPreferenceValue(String preferenceName, String key, String value) {
            Intrinsics.checkNotNullParameter(preferenceName, "preferenceName");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            this.preferenceName = preferenceName;
            this.key = key;
            this.value = value;
        }

        public final String getKey() {
            return this.key;
        }

        public final String getPreferenceName() {
            return this.preferenceName;
        }

        public final String getValue() {
            return this.value;
        }

        public final Boolean getBooleanValue() {
            return StringsKt.toBooleanStrictOrNull(this.value);
        }

        public final Integer getIntegerValue() {
            return StringsKt.toIntOrNull(this.value);
        }

        public final Float getFloatValue() {
            return StringsKt.toFloatOrNull(this.value);
        }
    }

    public final List<SharedPreferenceValue> extraSharedPreferencesValues() {
        Map<String, String> map = arguments;
        List listSplit$default = StringsKt.split$default((CharSequence) String.valueOf(map != null ? map.get(SHARED_PREFERENCES_VALUES) : null), new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            List listSplit$default2 = StringsKt.split$default((CharSequence) it.next(), new String[]{SimpleComparison.EQUAL_TO_OPERATION}, false, 0, 6, (Object) null);
            SharedPreferenceValue sharedPreferenceValue = listSplit$default2.size() != 3 ? null : new SharedPreferenceValue((String) listSplit$default2.get(0), (String) listSplit$default2.get(1), (String) listSplit$default2.get(2));
            if (sharedPreferenceValue != null) {
                arrayList.add(sharedPreferenceValue);
            }
        }
        return arrayList;
    }

    public final void logArguments() {
        Map<String, String> map = arguments;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                Log.v("InstrumentationArguments", entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
