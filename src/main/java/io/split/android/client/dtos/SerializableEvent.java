package io.split.android.client.dtos;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public class SerializableEvent {
    public static final String EVENT_TYPE_FIELD = "eventTypeId";
    public static final String KEY_FIELD = "key";
    public static final String PROPERTIES_FIELD = "properties";
    public static final String TIMESTAMP_FIELD = "timestamp";
    public static final String TRAFFIC_TYPE_NAME_FIELD = "trafficTypeName";
    public static final String VALUE_FIELD = "value";

    @SerializedName(EVENT_TYPE_FIELD)
    public String eventTypeId;

    @SerializedName("key")
    public String key;

    @SerializedName("properties")
    public Map<String, Object> properties;

    @SerializedName("timestamp")
    public long timestamp;

    @SerializedName(TRAFFIC_TYPE_NAME_FIELD)
    public String trafficTypeName;

    @SerializedName("value")
    public double value;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass()) {
            Event event = (Event) o;
            if (Double.compare(event.value, this.value) == 0 && this.timestamp == event.timestamp && Objects.equals(this.eventTypeId, event.eventTypeId) && Objects.equals(this.trafficTypeName, event.trafficTypeName) && Objects.equals(this.key, event.key) && Objects.equals(this.properties, event.properties)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.eventTypeId, this.trafficTypeName, this.key, Double.valueOf(this.value), Long.valueOf(this.timestamp));
    }
}
