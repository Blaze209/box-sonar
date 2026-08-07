package androidx.media3.effect;

import android.util.JsonWriter;
import androidx.media3.common.util.SystemClock;
import androidx.media3.common.util.Util;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class DebugTraceUtil {
    private static final boolean ENABLE_TRACES_IN_LOGCAT = false;
    public static final String EVENT_RECEIVE_EOS = "ReceiveEOS";
    private static final int MAX_FIRST_LAST_LOGS = 10;
    public static boolean enableTracing = false;
    public static final String COMPONENT_COMPOSITION_PLAYER = "CompositionPlayer";
    public static final String EVENT_SET_COMPOSITION = "SetComposition";
    public static final String EVENT_SEEK_TO = "SeekTo";
    public static final String EVENT_SET_VIDEO_OUTPUT = "SetVideoOutput";
    public static final String EVENT_RELEASE = "Release";
    public static final String COMPONENT_TRANSFORMER_INTERNAL = "TransformerInternal";
    public static final String EVENT_START = "Start";
    public static final String COMPONENT_ASSET_LOADER = "AssetLoader";
    public static final String EVENT_INPUT_FORMAT = "InputFormat";
    public static final String EVENT_OUTPUT_FORMAT = "OutputFormat";
    public static final String COMPONENT_AUDIO_DECODER = "AudioDecoder";
    public static final String EVENT_ACCEPTED_INPUT = "AcceptedInput";
    public static final String EVENT_PRODUCED_OUTPUT = "ProducedOutput";
    public static final String EVENT_INPUT_ENDED = "InputEnded";
    public static final String EVENT_OUTPUT_ENDED = "OutputEnded";
    public static final String COMPONENT_AUDIO_GRAPH = "AudioGraph";
    public static final String EVENT_REGISTER_NEW_INPUT_STREAM = "RegisterNewInputStream";
    public static final String COMPONENT_AUDIO_MIXER = "AudioMixer";
    public static final String COMPONENT_AUDIO_ENCODER = "AudioEncoder";
    public static final String COMPONENT_VIDEO_DECODER = "VideoDecoder";
    public static final String COMPONENT_VFP = "VideoFrameProcessor";
    public static final String EVENT_SURFACE_TEXTURE_INPUT = "SurfaceTextureInput";
    public static final String EVENT_QUEUE_FRAME = "QueueFrame";
    public static final String EVENT_QUEUE_BITMAP = "QueueBitmap";
    public static final String EVENT_QUEUE_TEXTURE = "QueueTexture";
    public static final String EVENT_RENDERED_TO_OUTPUT_SURFACE = "RenderedToOutputSurface";
    public static final String EVENT_OUTPUT_TEXTURE_RENDERED = "OutputTextureRendered";
    public static final String EVENT_RECEIVE_END_OF_ALL_INPUT = "ReceiveEndOfAllInput";
    public static final String EVENT_SIGNAL_ENDED = "SignalEnded";
    public static final String COMPONENT_EXTERNAL_TEXTURE_MANAGER = "ExternalTextureManager";
    public static final String EVENT_SIGNAL_EOS = "SignalEOS";
    public static final String EVENT_SURFACE_TEXTURE_TRANSFORM_FIX = "SurfaceTextureTransformFix";
    public static final String COMPONENT_BITMAP_TEXTURE_MANAGER = "BitmapTextureManager";
    public static final String COMPONENT_TEX_ID_TEXTURE_MANAGER = "TexIdTextureManager";
    public static final String COMPONENT_COMPOSITOR = "Compositor";
    public static final String COMPONENT_VIDEO_ENCODER = "VideoEncoder";
    public static final String COMPONENT_MUXER = "Muxer";
    public static final String EVENT_CAN_WRITE_SAMPLE = "CanWriteSample";
    private static final ImmutableMap<String, List<String>> COMPONENTS_TO_EVENTS = ImmutableMap.builder().put(COMPONENT_COMPOSITION_PLAYER, ImmutableList.of(EVENT_SET_COMPOSITION, EVENT_SEEK_TO, EVENT_SET_VIDEO_OUTPUT, EVENT_RELEASE)).put(COMPONENT_TRANSFORMER_INTERNAL, ImmutableList.of(EVENT_START)).put(COMPONENT_ASSET_LOADER, ImmutableList.of(EVENT_INPUT_FORMAT, EVENT_OUTPUT_FORMAT)).put(COMPONENT_AUDIO_DECODER, ImmutableList.of(EVENT_INPUT_FORMAT, EVENT_OUTPUT_FORMAT, EVENT_ACCEPTED_INPUT, EVENT_PRODUCED_OUTPUT, EVENT_INPUT_ENDED, EVENT_OUTPUT_ENDED)).put(COMPONENT_AUDIO_GRAPH, ImmutableList.of(EVENT_REGISTER_NEW_INPUT_STREAM, EVENT_OUTPUT_ENDED)).put(COMPONENT_AUDIO_MIXER, ImmutableList.of(EVENT_REGISTER_NEW_INPUT_STREAM, EVENT_OUTPUT_FORMAT, EVENT_PRODUCED_OUTPUT)).put(COMPONENT_AUDIO_ENCODER, ImmutableList.of(EVENT_INPUT_FORMAT, EVENT_OUTPUT_FORMAT, EVENT_ACCEPTED_INPUT, EVENT_PRODUCED_OUTPUT, EVENT_INPUT_ENDED, EVENT_OUTPUT_ENDED)).put(COMPONENT_VIDEO_DECODER, ImmutableList.of(EVENT_INPUT_FORMAT, EVENT_OUTPUT_FORMAT, EVENT_ACCEPTED_INPUT, EVENT_PRODUCED_OUTPUT, EVENT_INPUT_ENDED, EVENT_OUTPUT_ENDED)).put(COMPONENT_VFP, ImmutableList.of(EVENT_REGISTER_NEW_INPUT_STREAM, EVENT_SURFACE_TEXTURE_INPUT, EVENT_QUEUE_FRAME, EVENT_QUEUE_BITMAP, EVENT_QUEUE_TEXTURE, EVENT_RENDERED_TO_OUTPUT_SURFACE, EVENT_OUTPUT_TEXTURE_RENDERED, EVENT_RECEIVE_END_OF_ALL_INPUT, EVENT_SIGNAL_ENDED)).put(COMPONENT_EXTERNAL_TEXTURE_MANAGER, ImmutableList.of(EVENT_SIGNAL_EOS, EVENT_SURFACE_TEXTURE_TRANSFORM_FIX)).put(COMPONENT_BITMAP_TEXTURE_MANAGER, ImmutableList.of(EVENT_SIGNAL_EOS)).put(COMPONENT_TEX_ID_TEXTURE_MANAGER, ImmutableList.of(EVENT_SIGNAL_EOS)).put(COMPONENT_COMPOSITOR, ImmutableList.of(EVENT_OUTPUT_TEXTURE_RENDERED)).put(COMPONENT_VIDEO_ENCODER, ImmutableList.of(EVENT_INPUT_FORMAT, EVENT_OUTPUT_FORMAT, EVENT_ACCEPTED_INPUT, EVENT_PRODUCED_OUTPUT, EVENT_INPUT_ENDED, EVENT_OUTPUT_ENDED)).put(COMPONENT_MUXER, ImmutableList.of(EVENT_INPUT_FORMAT, EVENT_CAN_WRITE_SAMPLE, EVENT_ACCEPTED_INPUT, EVENT_INPUT_ENDED, EVENT_OUTPUT_ENDED)).buildOrThrow();
    private static final Map<String, Map<String, EventLogger>> componentsToEventsToLogs = new LinkedHashMap();
    private static long startTimeMs = SystemClock.DEFAULT.elapsedRealtime();

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Component {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Event {
    }

    public static synchronized void reset() {
        componentsToEventsToLogs.clear();
        startTimeMs = SystemClock.DEFAULT.elapsedRealtime();
    }

    public static synchronized void logEvent(String str, String str2, long j, String str3, Object... objArr) {
        if (enableTracing) {
            logEventInternal(str, str2, new StringEventLog(j, getEventTimeMs(), Util.formatInvariant(str3, objArr)));
        }
    }

    public static synchronized void logEvent(String str, String str2, long j, JSONObject jSONObject) {
        if (enableTracing) {
            logEventInternal(str, str2, new JsonEventLog(j, getEventTimeMs(), jSONObject));
        }
    }

    public static synchronized void logEvent(String str, String str2, long j) {
        logEvent(str, str2, j, "", new Object[0]);
    }

    public static synchronized void logCodecEvent(boolean z, boolean z2, String str, long j, String str2, Object... objArr) {
        logEvent(getCodecComponent(z, z2), str, j, str2, objArr);
    }

    public static synchronized String generateTraceSummary() {
        if (!enableTracing) {
            return "\"Tracing disabled\"";
        }
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            try {
                jsonWriter.beginObject();
                UnmodifiableIterator<Map.Entry<String, List<String>>> it = COMPONENTS_TO_EVENTS.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<String, List<String>> next = it.next();
                    String key = next.getKey();
                    List<String> value = next.getValue();
                    jsonWriter.name(key);
                    Map<String, EventLogger> map = componentsToEventsToLogs.get(key);
                    jsonWriter.beginObject();
                    for (String str : value) {
                        jsonWriter.name(str);
                        if (map != null && map.containsKey(str)) {
                            ((EventLogger) Preconditions.checkNotNull(map.get(str))).toJson(jsonWriter);
                        } else {
                            jsonWriter.value("No events");
                        }
                    }
                    jsonWriter.endObject();
                }
                jsonWriter.endObject();
                String string = stringWriter.toString();
                Util.closeQuietly(jsonWriter);
                return string;
            } catch (Throwable th) {
                Util.closeQuietly(jsonWriter);
                throw th;
            }
        } catch (IOException unused) {
            Util.closeQuietly(jsonWriter);
            return "\"Error generating trace summary\"";
        }
    }

    public static synchronized void dumpTsv(Writer writer) throws IOException {
        if (!enableTracing) {
            writer.write("Tracing disabled");
            return;
        }
        writer.write("component\tevent\ttimestamp\tpresentation\textra\n");
        for (Map.Entry<String, Map<String, EventLogger>> entry : componentsToEventsToLogs.entrySet()) {
            String key = entry.getKey();
            for (Map.Entry<String, EventLogger> entry2 : entry.getValue().entrySet()) {
                String key2 = entry2.getKey();
                UnmodifiableIterator<EventLog> it = entry2.getValue().getLogs().iterator();
                while (it.hasNext()) {
                    EventLog next = it.next();
                    writer.write(Util.formatInvariant("%s\t%s\t%dms\t%s\t%s\n", key, key2, Long.valueOf(next.eventTimeMs), presentationTimeToString(next.presentationTimeUs), next.toString()));
                }
            }
        }
    }

    private static synchronized long getEventTimeMs() {
        return SystemClock.DEFAULT.elapsedRealtime() - startTimeMs;
    }

    private static synchronized void logEventInternal(String str, String str2, EventLog eventLog) {
        Map<String, Map<String, EventLogger>> map = componentsToEventsToLogs;
        if (!map.containsKey(str)) {
            map.put(str, new LinkedHashMap());
        }
        Map<String, EventLogger> map2 = map.get(str);
        if (!map2.containsKey(str2)) {
            map2.put(str2, new EventLogger());
        }
        map2.get(str2).addLog(eventLog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String presentationTimeToString(long j) {
        if (j == -9223372036854775807L) {
            return TelemetryEventStrings.Value.UNSET;
        }
        if (j == Long.MIN_VALUE) {
            return "EOS";
        }
        return j + "us";
    }

    private static String getCodecComponent(boolean z, boolean z2) {
        if (z) {
            if (z2) {
                return COMPONENT_VIDEO_DECODER;
            }
            return COMPONENT_AUDIO_DECODER;
        }
        if (z2) {
            return COMPONENT_VIDEO_ENCODER;
        }
        return COMPONENT_AUDIO_ENCODER;
    }

    private static abstract class EventLog {
        public final long eventTimeMs;
        public final long presentationTimeUs;

        public abstract String toString();

        protected EventLog(long j, long j2) {
            this.presentationTimeUs = j;
            this.eventTimeMs = j2;
        }
    }

    private static final class StringEventLog extends EventLog {
        public final String extra;

        private StringEventLog(long j, long j2, String str) {
            super(j, j2);
            this.extra = str;
        }

        @Override // androidx.media3.effect.DebugTraceUtil.EventLog
        public String toString() {
            return Util.formatInvariant("%s@%dms", DebugTraceUtil.presentationTimeToString(this.presentationTimeUs), Long.valueOf(this.eventTimeMs)) + (this.extra.isEmpty() ? "" : Util.formatInvariant("(%s)", this.extra));
        }
    }

    private static final class JsonEventLog extends EventLog {
        public final JSONObject jsonObject;

        public JsonEventLog(long j, long j2, JSONObject jSONObject) {
            super(j, j2);
            this.jsonObject = jSONObject;
        }

        @Override // androidx.media3.effect.DebugTraceUtil.EventLog
        public String toString() {
            return this.jsonObject.toString();
        }
    }

    private static final class EventLogger {
        private final List<EventLog> firstLogs = new ArrayList(10);
        private final Queue<EventLog> lastLogs = new ArrayDeque(10);
        private int totalCount = 0;

        public void addLog(EventLog eventLog) {
            if (this.firstLogs.size() < 10) {
                this.firstLogs.add(eventLog);
            } else {
                this.lastLogs.add(eventLog);
                if (this.lastLogs.size() > 10) {
                    this.lastLogs.remove();
                }
            }
            this.totalCount++;
        }

        public ImmutableList<EventLog> getLogs() {
            return new ImmutableList.Builder().addAll((Iterable) this.firstLogs).addAll((Iterable) this.lastLogs).build();
        }

        public void toJson(JsonWriter jsonWriter) throws IOException {
            jsonWriter.beginObject().name("count").value(this.totalCount).name("first").beginArray();
            Iterator<EventLog> it = this.firstLogs.iterator();
            while (it.hasNext()) {
                jsonWriter.value(it.next().toString());
            }
            jsonWriter.endArray();
            if (!this.lastLogs.isEmpty()) {
                jsonWriter.name("last").beginArray();
                Iterator<EventLog> it2 = this.lastLogs.iterator();
                while (it2.hasNext()) {
                    jsonWriter.value(it2.next().toString());
                }
                jsonWriter.endArray();
            }
            jsonWriter.endObject();
        }
    }
}
