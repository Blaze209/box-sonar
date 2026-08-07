package external.sdk.pendo.io.mozilla.javascript;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/* JADX INFO: loaded from: classes4.dex */
public class ImplementationVersion {
    private static final ImplementationVersion version = new ImplementationVersion();
    private String versionString;

    private ImplementationVersion() {
        try {
            Enumeration<URL> resources = ImplementationVersion.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
            while (resources.hasMoreElements()) {
                try {
                    InputStream inputStreamOpenStream = resources.nextElement().openStream();
                    try {
                        Attributes mainAttributes = new Manifest(inputStreamOpenStream).getMainAttributes();
                        if ("Mozilla Rhino".equals(mainAttributes.getValue("Implementation-Title"))) {
                            this.versionString = "Rhino " + mainAttributes.getValue("Implementation-Version") + " " + mainAttributes.getValue("Built-Date").replaceAll(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, " ");
                            if (inputStreamOpenStream != null) {
                                inputStreamOpenStream.close();
                                return;
                            }
                            return;
                        }
                        if (inputStreamOpenStream != null) {
                            inputStreamOpenStream.close();
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            if (inputStreamOpenStream != null) {
                                try {
                                    inputStreamOpenStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (IOException unused) {
                    continue;
                }
                continue;
            }
        } catch (IOException unused2) {
        }
    }

    public static String get() {
        return version.versionString;
    }
}
