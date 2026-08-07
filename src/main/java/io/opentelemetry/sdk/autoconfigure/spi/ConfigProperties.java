package io.opentelemetry.sdk.autoconfigure.spi;

import io.opentelemetry.api.internal.ConfigUtil;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface ConfigProperties {
    @Nullable
    Boolean getBoolean(String str);

    @Nullable
    Double getDouble(String str);

    @Nullable
    Duration getDuration(String str);

    @Nullable
    Integer getInt(String str);

    List<String> getList(String str);

    @Nullable
    Long getLong(String str);

    Map<String, String> getMap(String str);

    @Nullable
    String getString(String str);

    default String getString(String str, String str2) {
        return (String) ConfigUtil.defaultIfNull(getString(str), str2);
    }

    default boolean getBoolean(String str, boolean z) {
        return ((Boolean) ConfigUtil.defaultIfNull(getBoolean(str), Boolean.valueOf(z))).booleanValue();
    }

    default int getInt(String str, int i) {
        return ((Integer) ConfigUtil.defaultIfNull(getInt(str), Integer.valueOf(i))).intValue();
    }

    default long getLong(String str, long j) {
        return ((Long) ConfigUtil.defaultIfNull(getLong(str), Long.valueOf(j))).longValue();
    }

    default double getDouble(String str, double d) {
        return ((Double) ConfigUtil.defaultIfNull(getDouble(str), Double.valueOf(d))).doubleValue();
    }

    default Duration getDuration(String str, Duration duration) {
        return (Duration) ConfigUtil.defaultIfNull(getDuration(str), duration);
    }

    default List<String> getList(String str, List<String> list) {
        List<String> list2 = getList(str);
        return list2.isEmpty() ? list : list2;
    }

    default Map<String, String> getMap(String str, Map<String, String> map) {
        Map<String, String> map2 = getMap(str);
        return map2.isEmpty() ? map : map2;
    }
}
