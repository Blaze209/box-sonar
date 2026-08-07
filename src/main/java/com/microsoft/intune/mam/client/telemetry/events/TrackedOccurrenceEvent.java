package com.microsoft.intune.mam.client.telemetry.events;

import android.content.pm.PackageInfo;
import android.os.Parcelable;
import com.microsoft.intune.mam.client.telemetry.AriaTelemetryEvent;
import com.microsoft.intune.mam.client.telemetry.TelemetryEvent;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TrackedOccurrenceEvent extends AriaTelemetryEvent {
    public static final Parcelable.Creator<TrackedOccurrenceEvent> CREATOR = new TelemetryEvent.ParcelableCreator(TrackedOccurrenceEvent.class);
    private static final String EVENT_NAME = "TrackedOccurrence";

    public enum KEYS {
        MAM_SDK_VERSION,
        OCCURRENCE,
        DETAIL,
        EXTRA_DETAILS
    }

    public TrackedOccurrenceEvent(JSONObject jSONObject) throws JSONException {
        super(jSONObject, EVENT_NAME, KEYS.values());
    }

    public TrackedOccurrenceEvent(PackageInfo packageInfo, String str, TrackedOccurrenceType trackedOccurrenceType, String str2, Map<String, String> map) {
        super(EVENT_NAME, KEYS.values(), packageInfo);
        setProperty(KEYS.MAM_SDK_VERSION, str);
        setProperty(KEYS.OCCURRENCE, trackedOccurrenceType.getName());
        setProperty(KEYS.DETAIL, str2);
        if (map != null) {
            setProperty(KEYS.EXTRA_DETAILS, map);
        }
    }
}
