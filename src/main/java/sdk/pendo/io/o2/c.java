package sdk.pendo.io.o2;

import android.util.Log;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.data.api.utils.OkHttpLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.e2.z;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J1\u0010\u0004\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\u0004\u0010\rJ\u0006\u0010\u0004\u001a\u00020\u0007R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/o2/c;", "", "", "loggerName", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "logger", "tag", "", "", "logLevel", "message", "", "t", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/logging/Logger;", "b", "Ljava/util/concurrent/CopyOnWriteArraySet;", "configuredLoggers", "", "c", "Ljava/util/Map;", "knownLoggers", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class c {
    public static final c a = new c();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private static final Map<String, String> knownLoggers;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r1 = z.class.getPackage();
        String name = r1 != null ? r1.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, OkHttpLogger.TAG);
        }
        String name2 = z.class.getName();
        Intrinsics.checkNotNullExpressionValue(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = sdk.pendo.io.m2.e.class.getName();
        Intrinsics.checkNotNullExpressionValue(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = sdk.pendo.io.i2.e.class.getName();
        Intrinsics.checkNotNullExpressionValue(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("external.sdk.pendo.io.okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = MapsKt.toMap(linkedHashMap);
    }

    private c() {
    }

    public final void a(String loggerName, int logLevel, String message, Throwable t) {
        int iMin;
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Intrinsics.checkNotNullParameter(message, "message");
        String strA = a(loggerName);
        if (Log.isLoggable(strA, logLevel)) {
            if (t != null) {
                message = message + '\n' + Log.getStackTraceString(t);
            }
            String str = message;
            int length = str.length();
            int i = 0;
            while (i < length) {
                int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, '\n', i, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = length;
                }
                while (true) {
                    iMin = Math.min(iIndexOf$default, i + 4000);
                    String strSubstring = str.substring(i, iMin);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(logLevel, strA, strSubstring);
                    if (iMin >= iIndexOf$default) {
                        break;
                    } else {
                        i = iMin;
                    }
                }
                i = iMin + 1;
            }
        }
    }

    public final void a() {
        for (Map.Entry<String, String> entry : knownLoggers.entrySet()) {
            a(entry.getKey(), entry.getValue());
        }
    }

    private final void a(String logger, String tag) {
        Level level;
        Logger logger2 = Logger.getLogger(logger);
        if (configuredLoggers.add(logger2)) {
            logger2.setUseParentHandlers(false);
            if (Log.isLoggable(tag, 3)) {
                level = Level.FINE;
            } else {
                level = Log.isLoggable(tag, 4) ? Level.INFO : Level.WARNING;
            }
            logger2.setLevel(level);
            logger2.addHandler(d.a);
        }
    }

    private final String a(String loggerName) {
        String str = knownLoggers.get(loggerName);
        return str == null ? StringsKt.take(loggerName, 23) : str;
    }
}
