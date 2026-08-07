package com.geniusscansdk.core;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LicenseKeyStorage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/geniusscansdk/core/LicenseKeyStorage;", "", "preferences", "Landroid/content/SharedPreferences;", "logger", "Lcom/geniusscansdk/core/Logger;", "<init>", "(Landroid/content/SharedPreferences;Lcom/geniusscansdk/core/Logger;)V", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "fetchDeviceId", "", "fetchLicenseKey", "Lcom/geniusscansdk/core/LicenseKeyRefresher$TimestampedKey;", "fetchIntegrationMode", "fetchFramework", "saveLicenseKey", "", "key", "Companion", "DateTypeAdapter", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LicenseKeyStorage {
    public static final String CAMERA_SCREEN_DISPLAYED_KEY = "camera_screen_displayed";
    private static final String DEVICE_ID_KEY = "DEVICE_ID";
    public static final String FRAMEWORK_KEY = "framework";
    public static final String INTEGRATION_MODE_KEY = "integration_mode";
    private static final String LICENSE_KEY_KEY = "LICENSE_KEY";
    public static final String PREFERENCES_NAME = "com.geniusscansdk.prefs";

    /* JADX INFO: renamed from: gson$delegate, reason: from kotlin metadata */
    private final Lazy gson;
    private final Logger logger;
    private final SharedPreferences preferences;

    public LicenseKeyStorage(SharedPreferences preferences, Logger logger) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.preferences = preferences;
        this.logger = logger;
        this.gson = LazyKt.lazy(new Function0() { // from class: com.geniusscansdk.core.LicenseKeyStorage$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LicenseKeyStorage.gson_delegate$lambda$0();
            }
        });
    }

    public /* synthetic */ LicenseKeyStorage(SharedPreferences sharedPreferences, Logger logger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sharedPreferences, (i & 2) != 0 ? GeniusScanSDK.getLogger() : logger);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public LicenseKeyStorage(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this(sharedPreferences, null, 2, 0 == true ? 1 : 0);
    }

    private final Gson getGson() {
        Object value = this.gson.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Gson) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Gson gson_delegate$lambda$0() {
        return new GsonBuilder().registerTypeAdapter(Date.class, new DateTypeAdapter()).create();
    }

    public final String fetchDeviceId() {
        String string = this.preferences.getString(DEVICE_ID_KEY, null);
        if (string != null) {
            return string;
        }
        String string2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        editorEdit.putString(DEVICE_ID_KEY, string2);
        editorEdit.apply();
        return string2;
    }

    public final LicenseKeyRefresher.TimestampedKey fetchLicenseKey() {
        String string = this.preferences.getString(LICENSE_KEY_KEY, null);
        if (string == null) {
            return null;
        }
        try {
            return (LicenseKeyRefresher.TimestampedKey) getGson().fromJson(string, LicenseKeyRefresher.TimestampedKey.class);
        } catch (JsonSyntaxException e) {
            this.logger.error("Error deserializing license key " + string + ": " + e);
            return null;
        }
    }

    public final String fetchIntegrationMode() {
        if (!this.preferences.getBoolean(CAMERA_SCREEN_DISPLAYED_KEY, false)) {
            return null;
        }
        String string = this.preferences.getString(INTEGRATION_MODE_KEY, SchedulerSupport.CUSTOM);
        Intrinsics.checkNotNull(string);
        return string;
    }

    public final String fetchFramework() {
        String string = this.preferences.getString("framework", "native");
        Intrinsics.checkNotNull(string);
        return string;
    }

    public final void saveLicenseKey(LicenseKeyRefresher.TimestampedKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        editorEdit.putString(LICENSE_KEY_KEY, getGson().toJson(key));
        editorEdit.apply();
    }

    /* JADX INFO: compiled from: LicenseKeyStorage.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/geniusscansdk/core/LicenseKeyStorage$DateTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Ljava/util/Date;", "<init>", "()V", "dateFormats", "", "Ljava/text/SimpleDateFormat;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "read", "reader", "Lcom/google/gson/stream/JsonReader;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class DateTypeAdapter extends TypeAdapter<Date> {
        private final List<SimpleDateFormat> dateFormats = CollectionsKt.listOf((Object[]) new SimpleDateFormat[]{new SimpleDateFormat("MMM dd, yyyy h:mm:ss a", Locale.US), new SimpleDateFormat("MMM dd, yyyy HH:mm:ss", Locale.US)});

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter out, Date value) throws IOException {
            Intrinsics.checkNotNullParameter(out, "out");
            if (value == null) {
                out.nullValue();
            } else {
                out.value(String.valueOf(value.getTime()));
            }
        }

        @Override // com.google.gson.TypeAdapter
        /* JADX INFO: renamed from: read, reason: avoid collision after fix types in other method */
        public Date read2(JsonReader reader) throws IOException {
            Intrinsics.checkNotNullParameter(reader, "reader");
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return null;
            }
            String strNextString = reader.nextString();
            Intrinsics.checkNotNull(strNextString);
            Long longOrNull = StringsKt.toLongOrNull(strNextString);
            if (longOrNull != null) {
                return new Date(longOrNull.longValue());
            }
            Iterator<SimpleDateFormat> it = this.dateFormats.iterator();
            while (it.hasNext()) {
                try {
                    return it.next().parse(strNextString);
                } catch (ParseException unused) {
                }
            }
            throw new JsonParseException("Unable to parse date " + strNextString);
        }
    }
}
