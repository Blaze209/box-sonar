package org.tinylog.configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Properties;
import java.util.regex.Pattern;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;
import org.tinylog.runtime.RuntimeProvider;

/* JADX INFO: loaded from: classes5.dex */
public class PropertiesConfigurationLoader implements ConfigurationLoader {
    private static final String CONFIGURATION_PROPERTY = "tinylog.configuration";
    private static final String[] CONFIGURATION_FILES = {"tinylog-dev.properties", "tinylog-test.properties", "tinylog.properties"};
    private static final Pattern URL_DETECTION_PATTERN = Pattern.compile("^[a-zA-Z]{2,}:/.*");

    @Override // org.tinylog.configuration.ConfigurationLoader
    public Properties load() {
        Properties properties = new Properties();
        String property = System.getProperty(CONFIGURATION_PROPERTY);
        InputStream classpathStream = null;
        try {
            try {
                try {
                    if (property != null) {
                        if (URL_DETECTION_PATTERN.matcher(property).matches()) {
                            classpathStream = new URL(property).openStream();
                        } else {
                            classpathStream = getClasspathStream(property);
                            if (classpathStream == null) {
                                classpathStream = new FileInputStream(property);
                            }
                        }
                        load(properties, classpathStream);
                    } else {
                        for (String str : getConfigurationFiles()) {
                            classpathStream = getClasspathStream(str);
                            if (classpathStream != null) {
                                load(properties, classpathStream);
                                break;
                            }
                        }
                    }
                    if (classpathStream != null) {
                        classpathStream.close();
                        return properties;
                    }
                } catch (Throwable th) {
                    if (0 != 0) {
                        try {
                            classpathStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (IOException unused3) {
            InternalLogger.log(Level.ERROR, "Failed loading configuration from '" + property + "'");
            if (0 != 0) {
                classpathStream.close();
            }
        }
        return properties;
    }

    protected void load(Properties properties, InputStream inputStream) throws IOException {
        properties.load(inputStream);
    }

    protected String[] getConfigurationFiles() {
        return CONFIGURATION_FILES;
    }

    private InputStream getClasspathStream(String str) {
        Iterator<ClassLoader> it = RuntimeProvider.getClassLoaders().iterator();
        while (it.hasNext()) {
            InputStream resourceAsStream = it.next().getResourceAsStream(str);
            if (resourceAsStream != null) {
                return resourceAsStream;
            }
        }
        return null;
    }
}
