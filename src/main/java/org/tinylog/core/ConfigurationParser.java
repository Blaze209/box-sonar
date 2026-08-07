package org.tinylog.core;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.tinylog.Level;
import org.tinylog.configuration.Configuration;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class ConfigurationParser {
    private ConfigurationParser() {
    }

    public static Level getGlobalLevel() {
        return parse(Configuration.get(FirebaseAnalytics.Param.LEVEL), Level.TRACE);
    }

    public static Map<String, Level> getCustomLevels() {
        HashMap map = new HashMap();
        for (Map.Entry<String, String> entry : Configuration.getSiblings("level@").entrySet()) {
            String strSubstring = entry.getKey().substring("level@".length());
            Level level = parse(entry.getValue(), null);
            if (level != null) {
                map.put(strSubstring, level);
            }
        }
        return map;
    }

    public static List<String> getTags() {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = Configuration.getSiblings("writer").keySet().iterator();
        while (it.hasNext()) {
            String str = Configuration.get(it.next() + ".tag");
            if (str != null && !str.isEmpty() && !str.equals(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                for (String str2 : str.split(",")) {
                    String strTrim = str2.replaceAll("@.*", "").trim();
                    if (!arrayList.contains(strTrim) && !strTrim.isEmpty()) {
                        arrayList.add(strTrim);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean isWritingThreadEnabled() {
        String str = Configuration.get("writingthread");
        return str != null && Boolean.parseBoolean(str.trim());
    }

    public static boolean isAutoShutdownEnabled() {
        String str = Configuration.get("autoshutdown");
        return str == null || Boolean.parseBoolean(str.trim());
    }

    public static Level parse(String str, Level level) {
        if (str == null) {
            return level;
        }
        try {
            return Level.valueOf(str.trim().toUpperCase(Locale.ROOT));
        } catch (IllegalArgumentException unused) {
            InternalLogger.log(Level.ERROR, "Illegal severity level: " + str);
            return level;
        }
    }
}
