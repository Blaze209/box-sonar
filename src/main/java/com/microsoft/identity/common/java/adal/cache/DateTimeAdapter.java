package com.microsoft.identity.common.java.adal.cache;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.microsoft.identity.common.java.logging.Logger;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes14.dex */
public class DateTimeAdapter implements JsonDeserializer<Date>, JsonSerializer<Date> {
    private static final String TAG = "DateTimeAdapter";
    private final DateFormat mEnUsFormat = DateFormat.getDateTimeInstance(2, 2, Locale.US);
    private final DateFormat mLocalFormat = DateFormat.getDateTimeInstance(2, 2);
    private final DateFormat mISO8601Format = buildIso8601Format();
    private final DateFormat mEnUs24HourFormat = buildEnUs24HourDateFormat();
    private final DateFormat mLocal24HourFormat = buildLocal24HourDateFormat();

    private static DateFormat buildIso8601Format() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat;
    }

    private static DateFormat buildEnUs24HourDateFormat() {
        return new SimpleDateFormat("MMM dd, yyyy HH:mm:ss", Locale.US);
    }

    private static DateFormat buildLocal24HourDateFormat() {
        return new SimpleDateFormat("MMM dd, yyyy HH:mm:ss", Locale.getDefault());
    }

    @Override // com.google.gson.JsonDeserializer
    public synchronized Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        String asString;
        asString = jsonElement.getAsString();
        try {
        } catch (ParseException unused) {
            Logger.verbose(TAG, "Cannot parse with ISO8601, try again with local format.");
            try {
                return this.mLocalFormat.parse(asString);
            } catch (ParseException unused2) {
                Logger.verbose(TAG, "Cannot parse with local format, try again with local 24 hour format.");
                try {
                    return this.mLocal24HourFormat.parse(asString);
                } catch (ParseException unused3) {
                    Logger.verbose(TAG, "Cannot parse with local 24 hour format, try again with en us format.");
                    try {
                        return this.mEnUsFormat.parse(asString);
                    } catch (ParseException unused4) {
                        Logger.verbose(TAG, "Cannot parse with en us format, try again with en us 24 hour format.");
                        try {
                            return this.mEnUs24HourFormat.parse(asString);
                        } catch (ParseException e) {
                            Logger.error(TAG, "Could not parse date: " + e.getMessage(), e);
                            throw new JsonParseException("Could not parse date: " + asString);
                        }
                    }
                }
            }
        }
        return this.mISO8601Format.parse(asString);
    }

    @Override // com.google.gson.JsonSerializer
    public synchronized JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(this.mISO8601Format.format(date));
    }
}
