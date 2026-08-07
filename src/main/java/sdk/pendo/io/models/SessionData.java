package sdk.pendo.io.models;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import sdk.pendo.io.analytics.data.AnonDataForIdentifyEvent;
import sdk.pendo.io.analytics.data.IdentifyData;
import sdk.pendo.io.b0.a;
import sdk.pendo.io.b0.c;
import sdk.pendo.io.f6.d;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.s7.l0;
import sdk.pendo.io.s7.p0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u001c\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 ?2\u00020\u0001:\u0001?B±\u0001\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0012$\b\u0002\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0006\u0012$\b\u0002\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eBe\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0012\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\b\u0010*\u001a\u00020\u0000H\u0016J\u0019\u0010+\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b,J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/H\u0002JF\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\u00032\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H\u0002JH\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00122\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012H\u0002J\b\u00109\u001a\u000201H\u0016J6\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00122\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\u0006\u00102\u001a\u00020\u000bH\u0016J\b\u0010;\u001a\u00020\u0000H\u0016J\b\u0010<\u001a\u00020\u0000H\u0016J \u0010=\u001a\u0002012\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012H\u0016J \u0010>\u001a\u0002012\u0016\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0012H\u0016R.\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R6\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010!\"\u0004\b\"\u0010#R.\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0014\"\u0004\b%\u0010\u0016R6\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0014\"\u0004\b'\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001c¨\u0006@"}, d2 = {"Lsdk/pendo/io/models/SessionData;", "", "accountId", "", "visitorId", "visitorData", "", "accountData", "visitorExternalData", "accountExternalData", "isJwtModeOn", "", "identifyData", "Lsdk/pendo/io/analytics/data/IdentifyData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;ZLsdk/pendo/io/analytics/data/IdentifyData;)V", "anonDataForIdentifyEvent", "Lsdk/pendo/io/analytics/data/AnonDataForIdentifyEvent;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;ZLsdk/pendo/io/analytics/data/AnonDataForIdentifyEvent;)V", "", "getAccountData", "()Ljava/util/Map;", "setAccountData", "(Ljava/util/Map;)V", "getAccountExternalData", "setAccountExternalData", "getAccountId", "()Ljava/lang/String;", "setAccountId", "(Ljava/lang/String;)V", "<set-?>", "getIdentifyData", "()Lsdk/pendo/io/analytics/data/IdentifyData;", "isAnonymous", "()Z", "setJwtModeOn", "(Z)V", "getVisitorData", "setVisitorData", "getVisitorExternalData", "setVisitorExternalData", "getVisitorId", "setVisitorId", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "generateIdentifyData", "generateIdentifyData$pendoIO_release", "isLegitStartKey", "char", "", "logWarningsIfNeeded", "", "keepOriginalKey", "duplicates", "originalMap", "newMap", "mergeAndUpdateData", "newData", "currentExistingData", "persistData", "removeDuplicates", "removeDuplicatesAndTransformKeys", "removeDuplicatesKeepingOriginalKeys", "setAndMergeAccountData", "setAndMergeVisitorData", "Companion", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class SessionData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static boolean disableAnonVisitorGenerator = true;

    @c("account")
    @a(serialize = true)
    private Map<String, Object> accountData;
    private Map<String, ? extends Map<String, ? extends Object>> accountExternalData;
    private String accountId;
    private IdentifyData identifyData;
    private boolean isJwtModeOn;

    @c(GlobalEventPropertiesKt.VISITOR_KEY)
    @a(serialize = true)
    private Map<String, Object> visitorData;
    private Map<String, ? extends Map<String, ? extends Object>> visitorExternalData;
    private String visitorId;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0007J\u0006\u0010\b\u001a\u00020\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0007J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\r8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lsdk/pendo/io/models/SessionData$Companion;", "Lsdk/pendo/io/f6/d;", "Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", "response", "", "onGetAccessTokenResponseReceived", "", "generateAndStoreNewAnonymousVisitorID", "generateAnonymousVisitorID", "visitorID", "storeAnonymousVisitorID$pendoIO_release", "(Ljava/lang/String;)V", "storeAnonymousVisitorID", "", "isGeneratedDeviceIdAfterAppInstall", "deviceId", "retrieveAnonymousVisitorID", GlobalEventPropertiesKt.VISITOR_KEY, "getFormattedAnonymousID$pendoIO_release", "(Ljava/lang/String;)Ljava/lang/String;", "getFormattedAnonymousID", "<set-?>", "disableAnonVisitorGenerator", "Z", "getDisableAnonVisitorGenerator", "()Z", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class Companion implements d {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String generateAndStoreNewAnonymousVisitorID() {
            String strGenerateAnonymousVisitorID = generateAnonymousVisitorID();
            if (!getDisableAnonVisitorGenerator()) {
                storeAnonymousVisitorID$pendoIO_release(strGenerateAnonymousVisitorID);
            }
            return strGenerateAnonymousVisitorID;
        }

        public final String generateAnonymousVisitorID() {
            return getDisableAnonVisitorGenerator() ? "" : p0.INSTANCE.a(11);
        }

        public final boolean getDisableAnonVisitorGenerator() {
            return SessionData.disableAnonVisitorGenerator;
        }

        public final String getFormattedAnonymousID$pendoIO_release(String visitor) {
            Intrinsics.checkNotNullParameter(visitor, "visitor");
            return "_PENDO_T_M_" + visitor;
        }

        @Override // sdk.pendo.io.f6.d
        public void onGetAccessTokenResponseReceived(GetAuthToken.GetAuthTokenResponse response) {
            if (response == null) {
                return;
            }
            SessionData.disableAnonVisitorGenerator = response.getDisableAnonVisitorGenerator();
        }

        @JvmStatic
        public final String retrieveAnonymousVisitorID(boolean isGeneratedDeviceIdAfterAppInstall, String deviceId) {
            if (getDisableAnonVisitorGenerator()) {
                return "";
            }
            String strGenerateAndStoreNewAnonymousVisitorID = isGeneratedDeviceIdAfterAppInstall ? generateAndStoreNewAnonymousVisitorID() : l0.a(deviceId);
            Intrinsics.checkNotNull(strGenerateAndStoreNewAnonymousVisitorID);
            return getFormattedAnonymousID$pendoIO_release(strGenerateAndStoreNewAnonymousVisitorID);
        }

        public final void storeAnonymousVisitorID$pendoIO_release(String visitorID) {
            Intrinsics.checkNotNullParameter(visitorID, "visitorID");
            l0.c(visitorID);
        }
    }

    public SessionData() {
        this((String) null, (String) null, (Map) null, (Map) null, false, (AnonDataForIdentifyEvent) null, 63, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final String generateAndStoreNewAnonymousVisitorID() {
        return INSTANCE.generateAndStoreNewAnonymousVisitorID();
    }

    private final boolean isLegitStartKey(char c) {
        if (c == '_') {
            return true;
        }
        if ('a' > c || c >= '{') {
            return 'A' <= c && c < '[';
        }
        return true;
    }

    private final void logWarningsIfNeeded(boolean keepOriginalKey, String duplicates, Map<String, ? extends Object> originalMap, Map<String, Object> newMap) {
        if (keepOriginalKey) {
            if (duplicates.length() > 0) {
                PendoLogger.w("Visitor or Account data keys are used as all lowercase, without whitespaces. Your data contained more than one of the same key, which is unsupported. Dropped keys: [" + duplicates + "].Please notice that visitor or account data keys must not be null, empty nor blank, and must start with a letter or an underscore", new Object[0]);
            } else {
                if (originalMap == null || originalMap.isEmpty() || newMap.size() >= originalMap.size()) {
                    return;
                }
                PendoLogger.w("Please notice that visitor or account data keys must not be null, empty nor blank, and must start with a letter or an underscore", new Object[0]);
            }
        }
    }

    private final synchronized Map<String, Object> mergeAndUpdateData(Map<String, ? extends Object> newData, Map<String, Object> currentExistingData) {
        if (newData != null) {
            if (!newData.isEmpty()) {
                if (currentExistingData == null) {
                    currentExistingData = new HashMap<>();
                }
                currentExistingData.putAll(newData);
                return currentExistingData;
            }
        }
        PendoLogger.d("mergeAndUpdateData: no new data received, keeping the existing data", new Object[0]);
        return currentExistingData;
    }

    @JvmStatic
    public static final String retrieveAnonymousVisitorID(boolean z, String str) {
        return INSTANCE.retrieveAnonymousVisitorID(z, str);
    }

    public SessionData copy() {
        return new SessionData(this.accountId, this.visitorId, (Map) this.visitorData, (Map) this.accountData, false, (AnonDataForIdentifyEvent) null, 48, (DefaultConstructorMarker) null);
    }

    public final IdentifyData generateIdentifyData$pendoIO_release(AnonDataForIdentifyEvent anonDataForIdentifyEvent) {
        if (disableAnonVisitorGenerator || isAnonymous() || anonDataForIdentifyEvent == null) {
            return null;
        }
        return new IdentifyData(this.visitorId, anonDataForIdentifyEvent.getAnonVisitorId(), this.accountId, anonDataForIdentifyEvent.getAnonAccountId(), 0L, 16, null);
    }

    public final Map<String, Object> getAccountData() {
        return this.accountData;
    }

    public final Map<String, Map<String, Object>> getAccountExternalData() {
        return this.accountExternalData;
    }

    public final String getAccountId() {
        return this.accountId;
    }

    public final IdentifyData getIdentifyData() {
        return this.identifyData;
    }

    public final Map<String, Object> getVisitorData() {
        return this.visitorData;
    }

    public final Map<String, Map<String, Object>> getVisitorExternalData() {
        return this.visitorExternalData;
    }

    public final String getVisitorId() {
        return this.visitorId;
    }

    public boolean isAnonymous() {
        return this.visitorId.length() == 0 || StringsKt.startsWith$default(this.visitorId, "_PENDO_T_M_", false, 2, (Object) null);
    }

    /* JADX INFO: renamed from: isJwtModeOn, reason: from getter */
    public boolean getIsJwtModeOn() {
        return this.isJwtModeOn;
    }

    public void persistData() {
        l0.d(this.visitorId);
        l0.b(this.accountId);
    }

    public Map<String, Object> removeDuplicates(Map<String, ? extends Object> originalMap, boolean keepOriginalKey) throws IOException {
        HashSet hashSet = new HashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = "";
        if (originalMap != null) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Map.Entry<String, ? extends Object> entry : originalMap.entrySet()) {
                String key = entry.getKey();
                if (!StringsKt.isBlank(key) && isLegitStartKey(key.charAt(0))) {
                    linkedHashMap2.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                String lowerCase = ((String) entry2.getKey()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < lowerCase.length(); i++) {
                    char cCharAt = lowerCase.charAt(i);
                    if (!CharsKt.isWhitespace(cCharAt)) {
                        sb.append(cCharAt);
                    }
                }
                Object string = sb.toString();
                Intrinsics.checkNotNullExpressionValue(string, "filterNotTo(StringBuilder(), predicate).toString()");
                if (hashSet.contains(string)) {
                    str = ((Object) str) + entry2.getKey() + ",";
                } else {
                    hashSet.add(string);
                    if (keepOriginalKey) {
                        string = entry2.getKey();
                    }
                    linkedHashMap.put(string, entry2.getValue());
                }
            }
        }
        logWarningsIfNeeded(keepOriginalKey, str, originalMap, linkedHashMap);
        return linkedHashMap;
    }

    public SessionData removeDuplicatesAndTransformKeys() {
        SessionData sessionData = new SessionData(this.accountId, this.visitorId, (Map<String, ? extends Object>) null, (Map<String, ? extends Object>) null, this.visitorExternalData, this.accountExternalData, getIsJwtModeOn(), this.identifyData);
        sessionData.visitorData = removeDuplicates(this.visitorData, false);
        sessionData.accountData = removeDuplicates(this.accountData, false);
        return sessionData;
    }

    public SessionData removeDuplicatesKeepingOriginalKeys() {
        SessionData sessionData = new SessionData(this.accountId, this.visitorId, null, null, null, null, getIsJwtModeOn(), this.identifyData, 48, null);
        sessionData.visitorData = removeDuplicates(this.visitorData, true);
        sessionData.accountData = removeDuplicates(this.accountData, true);
        return sessionData;
    }

    public final void setAccountData(Map<String, Object> map) {
        this.accountData = map;
    }

    public final void setAccountExternalData(Map<String, ? extends Map<String, ? extends Object>> map) {
        this.accountExternalData = map;
    }

    public final void setAccountId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.accountId = str;
    }

    public synchronized void setAndMergeAccountData(Map<String, Object> newData) {
        this.accountData = mergeAndUpdateData(newData, this.accountData);
    }

    public synchronized void setAndMergeVisitorData(Map<String, Object> newData) {
        this.visitorData = mergeAndUpdateData(newData, this.visitorData);
    }

    public void setJwtModeOn(boolean z) {
        this.isJwtModeOn = z;
    }

    public final void setVisitorData(Map<String, Object> map) {
        this.visitorData = map;
    }

    public final void setVisitorExternalData(Map<String, ? extends Map<String, ? extends Object>> map) {
        this.visitorExternalData = map;
    }

    public final void setVisitorId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.visitorId = str;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionData(String accountId) {
        this(accountId, (String) null, (Map) null, (Map) null, false, (AnonDataForIdentifyEvent) null, 62, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(accountId, "accountId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionData(String accountId, String visitorId) {
        this(accountId, visitorId, (Map) null, (Map) null, false, (AnonDataForIdentifyEvent) null, 60, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(visitorId, "visitorId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionData(String accountId, String visitorId, Map<String, ? extends Object> map) {
        this(accountId, visitorId, (Map) map, (Map) null, false, (AnonDataForIdentifyEvent) null, 56, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(visitorId, "visitorId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionData(String accountId, String visitorId, Map<String, ? extends Object> map, Map<String, ? extends Object> map2) {
        this(accountId, visitorId, (Map) map, (Map) map2, false, (AnonDataForIdentifyEvent) null, 48, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(visitorId, "visitorId");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionData(String accountId, String visitorId, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<String, ? extends Map<String, ? extends Object>> map3, Map<String, ? extends Map<String, ? extends Object>> map4, boolean z, IdentifyData identifyData) {
        this(accountId, visitorId, map, map2, z, (AnonDataForIdentifyEvent) null, 32, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(visitorId, "visitorId");
        this.visitorExternalData = map3;
        this.accountExternalData = map4;
        this.identifyData = identifyData;
    }

    public /* synthetic */ SessionData(String str, String str2, Map map, Map map2, Map map3, Map map4, boolean z, IdentifyData identifyData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (Map<String, ? extends Object>) ((i & 4) != 0 ? null : map), (Map<String, ? extends Object>) ((i & 8) != 0 ? null : map2), (Map<String, ? extends Map<String, ? extends Object>>) ((i & 16) != 0 ? null : map3), (Map<String, ? extends Map<String, ? extends Object>>) ((i & 32) != 0 ? null : map4), (i & 64) != 0 ? false : z, (i & 128) != 0 ? null : identifyData);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SessionData(String accountId, String visitorId, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, boolean z) {
        this(accountId, visitorId, map, map2, z, (AnonDataForIdentifyEvent) null, 32, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(visitorId, "visitorId");
    }

    public SessionData(String accountId, String visitorId, Map<String, ? extends Object> map, Map<String, ? extends Object> map2, boolean z, AnonDataForIdentifyEvent anonDataForIdentifyEvent) {
        Intrinsics.checkNotNullParameter(accountId, "accountId");
        Intrinsics.checkNotNullParameter(visitorId, "visitorId");
        this.accountId = accountId;
        this.visitorId = visitorId;
        this.isJwtModeOn = z;
        this.identifyData = generateIdentifyData$pendoIO_release(anonDataForIdentifyEvent);
        this.accountData = map2 != null ? MapsKt.toMutableMap(map2) : null;
        this.visitorData = map != null ? MapsKt.toMutableMap(map) : null;
    }

    public /* synthetic */ SessionData(String str, String str2, Map map, Map map2, boolean z, AnonDataForIdentifyEvent anonDataForIdentifyEvent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? null : map, (i & 8) != 0 ? null : map2, (i & 16) != 0 ? false : z, (i & 32) != 0 ? null : anonDataForIdentifyEvent);
    }
}
