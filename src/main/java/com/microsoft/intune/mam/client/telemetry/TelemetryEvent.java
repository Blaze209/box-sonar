package com.microsoft.intune.mam.client.telemetry;

import android.os.Parcel;
import android.os.Parcelable;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.client.telemetry.scrubbing.CustomerContentProperty;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TelemetryEvent implements Parcelable {
    private static final String EVENT_CLASS_KEY = "EVENT_CLASS";
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(TelemetryEvent.class);

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public abstract List<CustomerContentProperty> getCustomerContentProperties();

    public abstract String getProperty(Enum r1);

    protected abstract void readDetailsFromJSON(JSONObject jSONObject) throws JSONException;

    public abstract void setProperty(Enum r1, double d);

    public abstract void setProperty(Enum r1, long j);

    public abstract void setProperty(Enum r1, String str);

    public abstract void setProperty(Enum r1, Map<String, String> map);

    public abstract void setProperty(Enum r1, boolean z);

    protected abstract void writeDetailsToMap(Map<String, Object> map);

    protected static class ParcelableCreator<T extends TelemetryEvent> implements Parcelable.Creator<T> {
        private Class<T> mClass;

        public ParcelableCreator(Class<T> cls) {
            this.mClass = cls;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel parcel) {
            try {
                String string = parcel.readString();
                if (string == null) {
                    TelemetryEvent.LOGGER.error(MAMInterfaceError.TELEMETRY_INVALID_PARCEL, "Ignoring invalid parcel.", new Object[0]);
                    return null;
                }
                return this.mClass.cast(TelemetryEvent.createFromJSON(new JSONObject(string)));
            } catch (JSONException e) {
                TelemetryEvent.LOGGER.error(MAMInterfaceError.TELEMETRY_INVALID_PARCEL, "Ignoring TelemetryEvent parcel containing invalid JSON.", e);
                return null;
            } catch (Exception e2) {
                TelemetryEvent.LOGGER.error(MAMInterfaceError.TELEMETRY_INVALID_PARCEL, "Unable to create TelemetryEvent from parcel", e2);
                return null;
            }
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int i) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            parcel.writeString(writeToJSON().toString());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public JSONObject writeToJSON() throws JSONException {
        HashMap map = new HashMap();
        writeDetailsToMap(map);
        map.put(EVENT_CLASS_KEY, getClass().getName());
        map.values().removeAll(Collections.singleton(null));
        return new JSONObject(map);
    }

    public static TelemetryEvent createFromJSON(JSONObject jSONObject) throws JSONException, ClassNotFoundException {
        String string = jSONObject.getString(EVENT_CLASS_KEY);
        try {
            Class<?> cls = Class.forName(string);
            if (!TelemetryEvent.class.isAssignableFrom(cls)) {
                throw new JSONException("Unable to create class for JSON, because it is not a TelemetryEvent: " + cls);
            }
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(JSONObject.class);
            jSONObject.remove(EVENT_CLASS_KEY);
            return (TelemetryEvent) declaredConstructor.newInstance(jSONObject);
        } catch (IllegalAccessException e) {
            throw new JSONException("Could not load class " + string + " from JSON. " + e);
        } catch (InstantiationException e2) {
            throw new JSONException("Could not load class " + string + " from JSON. " + e2);
        } catch (NoSuchMethodException e3) {
            throw new JSONException("Could not load class " + string + " from JSON. " + e3);
        } catch (InvocationTargetException e4) {
            throw new JSONException("Could not load class " + string + " from JSON. " + e4);
        }
    }

    public String toString() {
        try {
            return writeToJSON().toString();
        } catch (JSONException unused) {
            return getClass().toString();
        }
    }

    public boolean equals(Object obj) {
        return getClass().isInstance(obj) && toString().equals(String.valueOf(obj));
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
