package org.tinylog.configuration;

import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;
import org.tinylog.runtime.RuntimeProvider;

/* JADX INFO: loaded from: classes5.dex */
public final class Configuration {
    private static final String CONFIGURATION_LOADER_CLASS_PROPERTY = "tinylog.configurationloader";
    private static final String ESCAPING_ENABLED_KEY = "escaping.enabled";
    private static final String LOCALE_KEY = "locale";
    private static final int MAX_LOCALE_ARGUMENTS = 3;
    static final String PROPERTIES_PREFIX = "tinylog.";
    private static boolean frozen;
    private static final Resolver[] resolvers = {EnvironmentVariableResolver.INSTANCE, JndiValueResolver.INSTANCE, SystemPropertyResolver.INSTANCE};
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();
    private static final Properties properties = load();

    private Configuration() {
    }

    private static Properties load() {
        ConfigurationLoader configurationLoader;
        if (RuntimeProvider.getProcessId() == Long.MIN_VALUE) {
            java.util.ServiceLoader.load(ConfigurationLoader.class);
        }
        ServiceLoader serviceLoader = new ServiceLoader(ConfigurationLoader.class, new Class[0]);
        String property = System.getProperty(CONFIGURATION_LOADER_CLASS_PROPERTY);
        if (property != null) {
            configurationLoader = (ConfigurationLoader) serviceLoader.create(property, new Object[0]);
        } else {
            ConfigurationLoader configurationLoader2 = null;
            ConfigurationLoader configurationLoader3 = null;
            for (ConfigurationLoader configurationLoader4 : serviceLoader.createAll(new Object[0])) {
                if (configurationLoader4.getClass().equals(PropertiesConfigurationLoader.class)) {
                    configurationLoader3 = configurationLoader4;
                } else if (configurationLoader2 == null) {
                    configurationLoader2 = configurationLoader4;
                } else {
                    InternalLogger.log(Level.WARN, "Multiple configuration loaders found. Configuration loader " + configurationLoader4.getClass() + " will be ignored.");
                }
            }
            configurationLoader = configurationLoader2 == null ? configurationLoader3 : configurationLoader2;
        }
        Properties propertiesLoad = load(configurationLoader);
        mergeSystemProperties(propertiesLoad);
        resolveProperties(propertiesLoad, resolvers);
        return propertiesLoad;
    }

    private static Properties load(ConfigurationLoader configurationLoader) {
        if (configurationLoader == null) {
            return new Properties();
        }
        try {
            Properties propertiesLoad = configurationLoader.load();
            return propertiesLoad != null ? propertiesLoad : new Properties();
        } catch (Exception e) {
            InternalLogger.log(Level.ERROR, "Configuration loader error: '" + e + "'");
            return new Properties();
        }
    }

    public static Locale getLocale() {
        String str = get("locale");
        if (str == null) {
            return Locale.ROOT;
        }
        String[] strArrSplit = str.trim().split("_", 3);
        if (strArrSplit.length == 1) {
            return new Locale(strArrSplit[0]);
        }
        if (strArrSplit.length == 2) {
            return new Locale(strArrSplit[0], strArrSplit[1]);
        }
        return new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }

    public static boolean isEscapingEnabled() {
        String str = get(ESCAPING_ENABLED_KEY);
        return str != null && Boolean.parseBoolean(str.trim());
    }

    public static String get(String str) {
        try {
            lock.readLock().lock();
            frozen = true;
            return (String) properties.get(str);
        } finally {
            lock.readLock().unlock();
        }
    }

    public static Map<String, String> getSiblings(String str) {
        try {
            lock.readLock().lock();
            frozen = true;
            HashMap map = new HashMap();
            Enumeration enumerationKeys = properties.keys();
            while (enumerationKeys.hasMoreElements()) {
                String str2 = (String) enumerationKeys.nextElement();
                if (str2.startsWith(str) && (str.endsWith(CommentEntityDomainMapper.MENTIONS_SYMBOL) || str2.indexOf(46, str.length()) == -1)) {
                    map.put(str2, (String) properties.get(str2));
                }
            }
            return map;
        } finally {
            lock.readLock().unlock();
        }
    }

    public static Map<String, String> getChildren(String str) {
        try {
            lock.readLock().lock();
            frozen = true;
            String str2 = str + ".";
            HashMap map = new HashMap();
            Enumeration enumerationKeys = properties.keys();
            while (enumerationKeys.hasMoreElements()) {
                String str3 = (String) enumerationKeys.nextElement();
                if (str3.startsWith(str2)) {
                    map.put(str3.substring(str2.length()), (String) properties.get(str3));
                }
            }
            lock.readLock().unlock();
            return map;
        } catch (Throwable th) {
            lock.readLock().unlock();
            throw th;
        }
    }

    public static void set(String str, String str2) throws UnsupportedOperationException {
        try {
            ReadWriteLock readWriteLock = lock;
            readWriteLock.writeLock().lock();
            if (frozen) {
                throw new UnsupportedOperationException("Configuration cannot be changed after applying to tinylog");
            }
            properties.put(str, str2);
            readWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            lock.writeLock().unlock();
            throw th;
        }
    }

    public static void replace(Map<String, String> map) throws UnsupportedOperationException {
        try {
            ReadWriteLock readWriteLock = lock;
            readWriteLock.writeLock().lock();
            if (frozen) {
                throw new UnsupportedOperationException("Configuration cannot be changed after applying to tinylog");
            }
            Properties properties2 = properties;
            properties2.clear();
            properties2.putAll(map);
            readWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            lock.writeLock().unlock();
            throw th;
        }
    }

    public static String resolve(String str, Resolver resolver) {
        StringBuilder sb = new StringBuilder();
        String str2 = resolver.getPrefix() + "{";
        int iIndexOf = str.indexOf(str2);
        int i = 0;
        while (iIndexOf != -1) {
            sb.append((CharSequence) str, i, iIndexOf);
            int i2 = iIndexOf + 2;
            int iIndexOf2 = str.indexOf("}", i2);
            if (iIndexOf2 == -1) {
                InternalLogger.log(Level.WARN, "Closing curly bracket is missing for '" + str + "'");
                return str;
            }
            String strSubstring = str.substring(i2, iIndexOf2);
            if (strSubstring.length() == 0) {
                InternalLogger.log(Level.WARN, "Empty variable names cannot be resolved: " + str);
                return str;
            }
            String[] strArrSplit = strSubstring.split(":", -1);
            if (strArrSplit.length > 2) {
                InternalLogger.log(Level.WARN, "Multiple default values found: " + str);
                return str;
            }
            String str3 = strArrSplit[0];
            String str4 = strArrSplit.length == 2 ? strArrSplit[1] : null;
            String strResolve = resolver.resolve(str3);
            if (strResolve != null) {
                str4 = strResolve;
            } else if (str4 == null) {
                InternalLogger.log(Level.WARN, "'" + str3 + "' could not be found in " + resolver.getName());
                return str;
            }
            sb.append(str4);
            i = iIndexOf2 + 1;
            iIndexOf = str.indexOf(str2, i);
        }
        sb.append((CharSequence) str, i, str.length());
        return sb.toString();
    }

    public static void mergeSystemProperties(Properties properties2) {
        for (String str : new ArrayList(System.getProperties().keySet())) {
            if (str.startsWith(PROPERTIES_PREFIX)) {
                properties2.put(str.substring(PROPERTIES_PREFIX.length()), System.getProperty(str));
            }
        }
    }

    public static void resolveProperties(Properties properties2, Resolver... resolverArr) {
        if (resolverArr == null) {
            return;
        }
        for (Map.Entry entry : properties2.entrySet()) {
            String strResolve = (String) entry.getValue();
            if (strResolve.indexOf(123) != -1) {
                for (Resolver resolver : resolverArr) {
                    strResolve = resolve(strResolve, resolver);
                }
                properties2.put(entry.getKey(), strResolve);
            }
        }
    }

    public static boolean isFrozen() {
        return frozen;
    }
}
