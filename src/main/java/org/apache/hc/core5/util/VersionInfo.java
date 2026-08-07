package org.apache.hc.core5.util;

import com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes5.dex */
public class VersionInfo {
    private static final VersionInfo[] EMPTY_VERSION_INFO_ARRAY = new VersionInfo[0];
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";

    @Deprecated
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";
    private final String infoClassloader;
    private final String infoModule;
    private final String infoPackage;
    private final String infoRelease;
    private final String infoTimestamp;

    protected VersionInfo(String str, String str2, String str3, String str4, String str5) {
        Args.notNull(str, "Package identifier");
        this.infoPackage = str;
        this.infoModule = str2 == null ? "UNAVAILABLE" : str2;
        this.infoRelease = str3 == null ? "UNAVAILABLE" : str3;
        this.infoTimestamp = str4 == null ? "UNAVAILABLE" : str4;
        this.infoClassloader = str5 == null ? "UNAVAILABLE" : str5;
    }

    public final String getPackage() {
        return this.infoPackage;
    }

    public final String getModule() {
        return this.infoModule;
    }

    public final String getRelease() {
        return this.infoRelease;
    }

    @Deprecated
    public final String getTimestamp() {
        return this.infoTimestamp;
    }

    public final String getClassloader() {
        return this.infoClassloader;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.infoPackage.length() + 20 + this.infoModule.length() + this.infoRelease.length() + this.infoTimestamp.length() + this.infoClassloader.length());
        sb.append("VersionInfo(").append(this.infoPackage).append(AbstractJsonLexerKt.COLON).append(this.infoModule);
        if (!"UNAVAILABLE".equals(this.infoRelease)) {
            sb.append(AbstractJsonLexerKt.COLON).append(this.infoRelease);
        }
        sb.append(')');
        if (!"UNAVAILABLE".equals(this.infoClassloader)) {
            sb.append(CommentBarInputBoxKt.MENTION_SYMBOL).append(this.infoClassloader);
        }
        return sb.toString();
    }

    public static VersionInfo[] loadVersionInfo(String[] strArr, ClassLoader classLoader) {
        Args.notNull(strArr, "Package identifier array");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            VersionInfo versionInfoLoadVersionInfo = loadVersionInfo(str, classLoader);
            if (versionInfoLoadVersionInfo != null) {
                arrayList.add(versionInfoLoadVersionInfo);
            }
        }
        return (VersionInfo[]) arrayList.toArray(EMPTY_VERSION_INFO_ARRAY);
    }

    public static VersionInfo loadVersionInfo(String str, ClassLoader classLoader) {
        Properties properties;
        Args.notNull(str, "Package identifier");
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        try {
            InputStream resourceAsStream = classLoader.getResourceAsStream(str.replace('.', '/') + "/version.properties");
            if (resourceAsStream != null) {
                try {
                    properties = new Properties();
                    properties.load(resourceAsStream);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        if (resourceAsStream != null) {
                            try {
                                resourceAsStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
            } else {
                properties = null;
            }
            if (resourceAsStream != null) {
                try {
                    resourceAsStream.close();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            properties = null;
        }
        if (properties != null) {
            return fromMap(str, properties, classLoader);
        }
        return null;
    }

    protected static VersionInfo fromMap(String str, Map<?, ?> map, ClassLoader classLoader) {
        String str2;
        String str3;
        Args.notNull(str, "Package identifier");
        if (map != null) {
            String str4 = (String) map.get("info.module");
            if (str4 != null && str4.length() < 1) {
                str4 = null;
            }
            String str5 = (String) map.get("info.release");
            str3 = (str5 == null || (str5.length() >= 1 && !str5.equals("${project.version}"))) ? str5 : null;
            str2 = str4;
        } else {
            str2 = null;
            str3 = null;
        }
        return new VersionInfo(str, str2, str3, null, classLoader != null ? classLoader.toString() : null);
    }

    public static String getSoftwareInfo(String str, String str2, Class<?> cls) {
        VersionInfo versionInfoLoadVersionInfo = loadVersionInfo(str2, cls.getClassLoader());
        String release = versionInfoLoadVersionInfo != null ? versionInfoLoadVersionInfo.getRelease() : "UNAVAILABLE";
        String property = System.getProperty("java.version");
        if (!"UNAVAILABLE".equals(release)) {
            str = str + "/" + release;
        }
        return String.format("%s (Java/%s)", str, property);
    }
}
