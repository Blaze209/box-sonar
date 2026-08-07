package sdk.pendo.io.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\b\u0010\u001a\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fJ0\u0010\u001c\u001a\u00020\u00172\u001e\u0010\u001d\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\t0\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u001e\u0010\u001f\u001a\u00020\u00172\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001eJ\u001e\u0010!\u001a\u00020\u00172\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001eR\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8B@BX\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R$\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006#"}, d2 = {"Lsdk/pendo/io/models/GlobalEventProperties;", "", "()V", "accountGlobalEventProperties", "", "", "getAccountGlobalEventProperties", "()Ljava/util/Map;", "accountPromotedKeys", "", "getAccountPromotedKeys", "()Ljava/util/List;", "setAccountPromotedKeys", "(Ljava/util/List;)V", "<set-?>", "Lorg/json/JSONObject;", "globalEventPropertiesJson", "visitorGlobalEventProperties", "getVisitorGlobalEventProperties", "visitorPromotedKeys", "getVisitorPromotedKeys", "setVisitorPromotedKeys", "clearAndUpdateGlobalEventProperties", "", "sessionData", "Lsdk/pendo/io/models/SessionData;", "createGlobalEventPropertiesJson", "getPropertiesJson", "setPromotedMetadataKeys", "keysMap", "", "updateAccountGlobalEventProperties", "accountData", "updateVisitorGlobalEventProperties", "visitorData", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GlobalEventProperties {
    private List<String> accountPromotedKeys;
    private JSONObject globalEventPropertiesJson;
    private List<String> visitorPromotedKeys;
    private final Map<String, Object> visitorGlobalEventProperties = new HashMap();
    private final Map<String, Object> accountGlobalEventProperties = new HashMap();

    public final synchronized void clearAndUpdateGlobalEventProperties(SessionData sessionData) {
        this.globalEventPropertiesJson = null;
        this.visitorGlobalEventProperties.clear();
        this.accountGlobalEventProperties.clear();
        updateVisitorGlobalEventProperties(sessionData != null ? sessionData.getVisitorData() : null);
        updateAccountGlobalEventProperties(sessionData != null ? sessionData.getAccountData() : null);
    }

    public final synchronized JSONObject createGlobalEventPropertiesJson() {
        JSONObject jSONObject = null;
        if (this.visitorGlobalEventProperties.isEmpty() && this.accountGlobalEventProperties.isEmpty()) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            if (!this.visitorGlobalEventProperties.isEmpty()) {
                jSONObject2.put(GlobalEventPropertiesKt.VISITOR_METADATA_KEY, new JSONObject(this.visitorGlobalEventProperties));
            }
            if (!this.accountGlobalEventProperties.isEmpty()) {
                jSONObject2.put(GlobalEventPropertiesKt.ACCOUNT_METADATA_KEY, new JSONObject(this.accountGlobalEventProperties));
            }
            jSONObject3.put(GlobalEventPropertiesKt.GLOBAL_EVENT_PROPERTIES_SG_KEY, jSONObject2);
            jSONObject = jSONObject3;
        } catch (JSONException e) {
            PendoLogger.i("AnalyticsUtils - could not create the global event properties json, " + e.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    public final Map<String, Object> getAccountGlobalEventProperties() {
        return this.accountGlobalEventProperties;
    }

    public final List<String> getAccountPromotedKeys() {
        return this.accountPromotedKeys;
    }

    public final synchronized JSONObject getPropertiesJson() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = this.globalEventPropertiesJson;
        jSONObject = null;
        if (jSONObject2 != null) {
            try {
                jSONObject = new JSONObject(jSONObject2.toString());
            } catch (JSONException e) {
                PendoLogger.e(e, "GlobalEventProperties, failed to getPropertiesJson", new Object[0]);
            }
        }
        return jSONObject;
    }

    public final Map<String, Object> getVisitorGlobalEventProperties() {
        return this.visitorGlobalEventProperties;
    }

    public final List<String> getVisitorPromotedKeys() {
        return this.visitorPromotedKeys;
    }

    public final void setAccountPromotedKeys(List<String> list) {
        this.accountPromotedKeys = list;
    }

    public final synchronized void setPromotedMetadataKeys(Map<String, ? extends List<String>> keysMap, SessionData sessionData) {
        Intrinsics.checkNotNullParameter(keysMap, "keysMap");
        List<String> list = keysMap.get(GlobalEventPropertiesKt.VISITOR_KEY);
        if (list != null) {
            this.visitorPromotedKeys = list;
        }
        List<String> list2 = keysMap.get("account");
        if (list2 != null) {
            this.accountPromotedKeys = list2;
        }
        PendoLogger.d("GlobalEventProperties, in setPromotedMetadataKeys: visitorKeys:" + this.visitorPromotedKeys + ", accountKeys:" + this.accountPromotedKeys, new Object[0]);
        clearAndUpdateGlobalEventProperties(sessionData);
    }

    public final void setVisitorPromotedKeys(List<String> list) {
        this.visitorPromotedKeys = list;
    }

    public final synchronized void updateAccountGlobalEventProperties(Map<String, ? extends Object> accountData) {
        List<String> list = this.accountPromotedKeys;
        if (list != null && accountData != null) {
            for (String str : list) {
                Object obj = accountData.get(str);
                if (obj != null) {
                    this.accountGlobalEventProperties.put(GlobalEventPropertiesKt.AGENT_PREFIX + str, obj);
                }
            }
            this.globalEventPropertiesJson = createGlobalEventPropertiesJson();
        }
    }

    public final synchronized void updateVisitorGlobalEventProperties(Map<String, ? extends Object> visitorData) {
        List<String> list = this.visitorPromotedKeys;
        if (list != null && visitorData != null) {
            for (String str : list) {
                Object obj = visitorData.get(str);
                if (obj != null) {
                    this.visitorGlobalEventProperties.put(GlobalEventPropertiesKt.AGENT_PREFIX + str, obj);
                }
            }
            this.globalEventPropertiesJson = createGlobalEventPropertiesJson();
        }
    }
}
