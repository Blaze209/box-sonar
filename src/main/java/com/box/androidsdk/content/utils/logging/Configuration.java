package com.box.androidsdk.content.utils.logging;

import java.util.Map;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Configuration.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/box/androidsdk/content/utils/logging/Configuration;", "", "<init>", "()V", "MASK_TAG", "", "PACKAGE_FILTER", "properties", "Ljava/util/Properties;", "getProperties", "()Ljava/util/Properties;", "dataMaskingFunction", "Lcom/box/androidsdk/content/utils/logging/DataMaskingConfig;", "getDataMaskingFunction", "()Lcom/box/androidsdk/content/utils/logging/DataMaskingConfig;", "packageContains", "getPackageContains", "()Ljava/lang/String;", "defaultMaskWith", "getDefaultMaskWith", "accept", "", "clazz", "Ljava/lang/Class;", "ConfigKeys", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Configuration {
    public static final Configuration INSTANCE = new Configuration();
    private static final String MASK_TAG = "<private>";
    private static final String PACKAGE_FILTER = "box";
    private static final DataMaskingConfig dataMaskingFunction;
    private static final Properties properties;

    private Configuration() {
    }

    public final Properties getProperties() {
        return properties;
    }

    /* JADX INFO: compiled from: Configuration.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/box/androidsdk/content/utils/logging/Configuration$ConfigKeys;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "PACKAGE_FILTER", "DEFAULT_DATA_MASKING_REPLACE_WITH", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum ConfigKeys {
        PACKAGE_FILTER("package.name.contains"),
        DEFAULT_DATA_MASKING_REPLACE_WITH("data.masking.replacewith");

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final String key;

        public static EnumEntries<ConfigKeys> getEntries() {
            return $ENTRIES;
        }

        ConfigKeys(String str) {
            this.key = str;
        }

        public final String getKey() {
            return this.key;
        }
    }

    static {
        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(ConfigKeys.PACKAGE_FILTER.getKey(), "box"), TuplesKt.to(ConfigKeys.DEFAULT_DATA_MASKING_REPLACE_WITH.getKey(), MASK_TAG));
        Properties properties2 = new Properties();
        properties2.putAll(mapMapOf);
        properties = properties2;
        dataMaskingFunction = new DataMaskingConfig();
    }

    public final DataMaskingConfig getDataMaskingFunction() {
        return dataMaskingFunction;
    }

    private final String getPackageContains() {
        String property = properties.getProperty(ConfigKeys.PACKAGE_FILTER.getKey());
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
        return property;
    }

    public final String getDefaultMaskWith() {
        String property = properties.getProperty(ConfigKeys.DEFAULT_DATA_MASKING_REPLACE_WITH.getKey());
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
        return property;
    }

    public final boolean accept(Class<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        String name = clazz.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.contains$default((CharSequence) name, (CharSequence) getPackageContains(), false, 2, (Object) null);
    }
}
