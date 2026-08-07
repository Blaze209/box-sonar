package io.opentelemetry.sdk.autoconfigure.spi.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.j256.ormlite.stmt.query.SimpleComparison;
import io.opentelemetry.api.internal.ConfigUtil;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import io.opentelemetry.sdk.autoconfigure.spi.ConfigurationException;
import java.time.Duration;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class DefaultConfigProperties implements ConfigProperties {
    private final Map<String, String> config;

    public static /* synthetic */ LinkedHashMap $r8$lambda$9jZrLfmN7qos7GZMvkzgNgs9WjU() {
        return new LinkedHashMap();
    }

    static /* synthetic */ String lambda$getMap$7(String str, String str2) {
        return str2;
    }

    public static DefaultConfigProperties create(Map<String, String> map) {
        return new DefaultConfigProperties(System.getProperties(), System.getenv(), map);
    }

    public static DefaultConfigProperties createForTest(Map<String, String> map) {
        return new DefaultConfigProperties(map, Collections.emptyMap(), Collections.emptyMap());
    }

    private DefaultConfigProperties(Map<?, ?> map, Map<String, String> map2, Map<String, String> map3) {
        final HashMap map4 = new HashMap();
        map3.forEach(new BiConsumer() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                map4.put(ConfigUtil.normalizePropertyKey((String) obj), (String) obj2);
            }
        });
        map2.forEach(new BiConsumer() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                map4.put(ConfigUtil.normalizeEnvironmentVariableKey((String) obj), (String) obj2);
            }
        });
        map.forEach(new BiConsumer() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda3
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                map4.put(ConfigUtil.normalizePropertyKey(obj.toString()), obj2.toString());
            }
        });
        this.config = map4;
    }

    private DefaultConfigProperties(DefaultConfigProperties defaultConfigProperties, Map<String, String> map) {
        final HashMap map2 = new HashMap(defaultConfigProperties.config);
        map.forEach(new BiConsumer() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                map2.put(ConfigUtil.normalizePropertyKey((String) obj), (String) obj2);
            }
        });
        this.config = map2;
    }

    @Override // io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties
    @Nullable
    public String getString(String str) {
        return this.config.get(ConfigUtil.normalizePropertyKey(str));
    }

    @Override // io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties
    @Nullable
    public Boolean getBoolean(String str) {
        String str2 = this.config.get(ConfigUtil.normalizePropertyKey(str));
        if (str2 == null || str2.isEmpty()) {
            return null;
        }
        return Boolean.valueOf(Boolean.parseBoolean(str2));
    }

    @Override // io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties
    @Nullable
    public Integer getInt(String str) {
        String str2 = this.config.get(ConfigUtil.normalizePropertyKey(str));
        if (str2 == null || str2.isEmpty()) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            throw newInvalidPropertyException(str, str2, TypedValues.Custom.S_INT);
        }
    }

    @Override // io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties
    @Nullable
    public Long getLong(String str) {
        String str2 = this.config.get(ConfigUtil.normalizePropertyKey(str));
        if (str2 == null || str2.isEmpty()) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(str2));
        } catch (NumberFormatException unused) {
            throw newInvalidPropertyException(str, str2, "long");
        }
    }

    @Override // io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties
    @Nullable
    public Double getDouble(String str) {
        String str2 = this.config.get(ConfigUtil.normalizePropertyKey(str));
        if (str2 == null || str2.isEmpty()) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(str2));
        } catch (NumberFormatException unused) {
            throw newInvalidPropertyException(str, str2, "double");
        }
    }

    @Override // io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties
    @Nullable
    public Duration getDuration(String str) {
        String str2 = this.config.get(ConfigUtil.normalizePropertyKey(str));
        if (str2 == null || str2.isEmpty()) {
            return null;
        }
        String unitString = getUnitString(str2);
        String strSubstring = str2.substring(0, str2.length() - unitString.length());
        try {
            return Duration.ofMillis(TimeUnit.MILLISECONDS.convert(Long.parseLong(strSubstring.trim()), getDurationUnit(unitString.trim())));
        } catch (ConfigurationException e) {
            throw new ConfigurationException("Invalid duration property " + str + SimpleComparison.EQUAL_TO_OPERATION + str2 + ". " + e.getMessage());
        } catch (NumberFormatException e2) {
            throw new ConfigurationException("Invalid duration property " + str + SimpleComparison.EQUAL_TO_OPERATION + str2 + ". Expected number, found: " + strSubstring, e2);
        }
    }

    @Override // io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties
    public List<String> getList(String str) {
        String str2 = this.config.get(ConfigUtil.normalizePropertyKey(str));
        if (str2 == null) {
            return Collections.emptyList();
        }
        return filterBlanksAndNulls(str2.split(","));
    }

    public static Set<String> getSet(ConfigProperties configProperties, String str) {
        List<String> list = configProperties.getList(ConfigUtil.normalizePropertyKey(str));
        HashSet hashSet = new HashSet(list);
        if (hashSet.size() == list.size()) {
            return hashSet;
        }
        throw new ConfigurationException(str + " contains duplicates: " + ((String) ((Map) list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))).entrySet().stream().filter(new Predicate() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda10
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return DefaultConfigProperties.lambda$getSet$4((Map.Entry) obj);
            }
        }).map(new Function() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda11
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) ((Map.Entry) obj).getKey();
            }
        }).collect(Collectors.joining(",", "[", "]"))));
    }

    static /* synthetic */ boolean lambda$getSet$4(Map.Entry entry) {
        return ((Long) entry.getValue()).longValue() > 1;
    }

    @Override // io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties
    public Map<String, String> getMap(final String str) {
        return (Map) getList(ConfigUtil.normalizePropertyKey(str)).stream().map(new Function() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return DefaultConfigProperties.filterBlanksAndNulls(((String) obj).split(SimpleComparison.EQUAL_TO_OPERATION, 2));
            }
        }).map(new Function() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda5
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.f$0.m14755x81ccdca6(str, (List) obj);
            }
        }).collect(Collectors.toMap(new Function() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda6
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) ((AbstractMap.SimpleImmutableEntry) obj).getKey();
            }
        }, new Function() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda7
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) ((AbstractMap.SimpleImmutableEntry) obj).getValue();
            }
        }, new BinaryOperator() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda8
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return DefaultConfigProperties.lambda$getMap$7((String) obj, (String) obj2);
            }
        }, new Supplier() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda9
            @Override // java.util.function.Supplier
            public final Object get() {
                return DefaultConfigProperties.$r8$lambda$9jZrLfmN7qos7GZMvkzgNgs9WjU();
            }
        }));
    }

    /* JADX INFO: renamed from: lambda$getMap$6$io-opentelemetry-sdk-autoconfigure-spi-internal-DefaultConfigProperties, reason: not valid java name */
    /* synthetic */ AbstractMap.SimpleImmutableEntry m14755x81ccdca6(String str, List list) {
        if (list.size() != 2) {
            throw new ConfigurationException("Invalid map property: " + str + SimpleComparison.EQUAL_TO_OPERATION + this.config.get(str));
        }
        return new AbstractMap.SimpleImmutableEntry((String) list.get(0), (String) list.get(1));
    }

    public DefaultConfigProperties withOverrides(Map<String, String> map) {
        return new DefaultConfigProperties(this, map);
    }

    private static ConfigurationException newInvalidPropertyException(String str, String str2, String str3) {
        throw new ConfigurationException("Invalid value for property " + str + SimpleComparison.EQUAL_TO_OPERATION + str2 + ". Must be a " + str3 + ".");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<String> filterBlanksAndNulls(String[] strArr) {
        return (List) Arrays.stream(strArr).map(new Function() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda12
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String) obj).trim();
            }
        }).filter(new Predicate() { // from class: io.opentelemetry.sdk.autoconfigure.spi.internal.DefaultConfigProperties$$ExternalSyntheticLambda13
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return DefaultConfigProperties.lambda$filterBlanksAndNulls$8((String) obj);
            }
        }).collect(Collectors.toList());
    }

    static /* synthetic */ boolean lambda$filterBlanksAndNulls$8(String str) {
        return !str.isEmpty();
    }

    private static TimeUnit getDurationUnit(String str) {
        str.hashCode();
        switch (str) {
            case "":
            case "ms":
                return TimeUnit.MILLISECONDS;
            case "d":
                return TimeUnit.DAYS;
            case "h":
                return TimeUnit.HOURS;
            case "m":
                return TimeUnit.MINUTES;
            case "s":
                return TimeUnit.SECONDS;
            default:
                throw new ConfigurationException("Invalid duration string, found: " + str);
        }
    }

    private static String getUnitString(String str) {
        int length = str.length() - 1;
        while (length >= 0 && !Character.isDigit(str.charAt(length))) {
            length--;
        }
        return str.substring(length + 1);
    }
}
