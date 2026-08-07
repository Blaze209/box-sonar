package com.microsoft.identity.common.java.eststelemetry;

import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes14.dex */
public abstract class RequestTelemetry implements IRequestTelemetry {
    private static final String TAG = "RequestTelemetry";

    @SerializedName("platform_telemetry")
    private final ConcurrentMap<String, String> mPlatformTelemetry;

    @SerializedName(SchemaConstants.SCHEMA_VERSION_KEY)
    private final String mSchemaVersion;

    RequestTelemetry(String str) {
        if (str == null) {
            throw new NullPointerException("schemaVersion is marked non-null but is null");
        }
        this.mSchemaVersion = str;
        this.mPlatformTelemetry = new ConcurrentHashMap();
    }

    private boolean isPlatformTelemetryField(String str) {
        if (this instanceof CurrentRequestTelemetry) {
            return SchemaConstants.isCurrentPlatformField(str);
        }
        if (this instanceof LastRequestTelemetry) {
            return SchemaConstants.isLastPlatformField(str);
        }
        return false;
    }

    final void putInPlatformTelemetry(String str, String str2) {
        if (isPlatformTelemetryField(str)) {
            this.mPlatformTelemetry.putIfAbsent(str, str2);
        }
    }

    @Override // com.microsoft.identity.common.java.eststelemetry.IRequestTelemetry
    public String getSchemaVersion() {
        return this.mSchemaVersion;
    }

    @Override // com.microsoft.identity.common.java.eststelemetry.IRequestTelemetry
    public String getCompleteHeaderString() {
        if (StringUtil.isNullOrEmpty(this.mSchemaVersion)) {
            Logger.verbose(TAG + ":getCompleteHeaderString", "SCHEMA_VERSION is null or empty. Telemetry Header String cannot be formed.");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.mSchemaVersion).append("|").append(getHeaderStringForFields()).append("|").append(getPlatformTelemetryHeaderString());
        return sb.toString();
    }

    private String getPlatformTelemetryHeaderString() {
        List<String> lastRequestPlatformFields;
        this.mPlatformTelemetry.putIfAbsent(SchemaConstants.Key.PLATFORM_SCHEMA_VERSION, "2");
        if (this instanceof CurrentRequestTelemetry) {
            lastRequestPlatformFields = SchemaConstants.getCurrentRequestPlatformFields(TelemetryUtils.getBooleanFromString(this.mPlatformTelemetry.get(SchemaConstants.Key.IS_SHARED_DEVICE)));
        } else {
            lastRequestPlatformFields = SchemaConstants.getLastRequestPlatformFields();
        }
        return getHeaderStringForFields(lastRequestPlatformFields, this.mPlatformTelemetry);
    }

    private String getHeaderStringForFields(List<String> list, Map<String, String> map) {
        if (list == null || map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(TelemetryUtils.getSchemaCompliantString(map.get(list.get(i))));
            if (i != list.size() - 1) {
                sb.append(AbstractJsonLexerKt.COMMA);
            }
        }
        return sb.toString();
    }

    @Override // com.microsoft.identity.common.java.eststelemetry.IRequestTelemetry
    public IRequestTelemetry copySharedValues(IRequestTelemetry iRequestTelemetry) {
        if (iRequestTelemetry == null) {
            throw new NullPointerException("requestTelemetry is marked non-null but is null");
        }
        for (Map.Entry<String, String> entry : this.mPlatformTelemetry.entrySet()) {
            putInPlatformTelemetry(entry.getKey(), entry.getValue());
        }
        return this;
    }
}
