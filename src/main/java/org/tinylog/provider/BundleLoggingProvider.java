package org.tinylog.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.tinylog.Level;
import org.tinylog.format.MessageFormatter;

/* JADX INFO: loaded from: classes5.dex */
public final class BundleLoggingProvider implements LoggingProvider {
    private final ContextProvider contextProvider;
    private final LoggingProvider[] loggingProviders;

    BundleLoggingProvider(Collection<LoggingProvider> collection) {
        this.loggingProviders = (LoggingProvider[]) collection.toArray(new LoggingProvider[0]);
        this.contextProvider = createContextProvider(collection);
    }

    @Override // org.tinylog.provider.LoggingProvider
    public ContextProvider getContextProvider() {
        return this.contextProvider;
    }

    @Override // org.tinylog.provider.LoggingProvider
    public Level getMinimumLevel() {
        Level level = Level.OFF;
        int i = 0;
        while (true) {
            LoggingProvider[] loggingProviderArr = this.loggingProviders;
            if (i >= loggingProviderArr.length) {
                return level;
            }
            Level minimumLevel = loggingProviderArr[i].getMinimumLevel();
            if (minimumLevel.ordinal() < level.ordinal()) {
                level = minimumLevel;
            }
            i++;
        }
    }

    @Override // org.tinylog.provider.LoggingProvider
    public Level getMinimumLevel(String str) {
        Level level = Level.OFF;
        int i = 0;
        while (true) {
            LoggingProvider[] loggingProviderArr = this.loggingProviders;
            if (i >= loggingProviderArr.length) {
                return level;
            }
            Level minimumLevel = loggingProviderArr[i].getMinimumLevel(str);
            if (minimumLevel.ordinal() < level.ordinal()) {
                level = minimumLevel;
            }
            i++;
        }
    }

    @Override // org.tinylog.provider.LoggingProvider
    public boolean isEnabled(int i, String str, Level level) {
        for (LoggingProvider loggingProvider : this.loggingProviders) {
            if (loggingProvider.isEnabled(i + 1, str, level)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.tinylog.provider.LoggingProvider
    public boolean isEnabled(String str, String str2, Level level) {
        for (LoggingProvider loggingProvider : this.loggingProviders) {
            if (loggingProvider.isEnabled(str, str2, level)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.tinylog.provider.LoggingProvider
    public void log(int i, String str, Level level, Throwable th, MessageFormatter messageFormatter, Object obj, Object... objArr) {
        int i2 = 0;
        while (true) {
            LoggingProvider[] loggingProviderArr = this.loggingProviders;
            if (i2 >= loggingProviderArr.length) {
                return;
            }
            loggingProviderArr[i2].log(i + 1, str, level, th, messageFormatter, obj, objArr);
            i2++;
        }
    }

    @Override // org.tinylog.provider.LoggingProvider
    public void log(String str, String str2, Level level, Throwable th, MessageFormatter messageFormatter, Object obj, Object... objArr) {
        int i = 0;
        while (true) {
            LoggingProvider[] loggingProviderArr = this.loggingProviders;
            if (i >= loggingProviderArr.length) {
                return;
            }
            loggingProviderArr[i].log(str, str2, level, th, messageFormatter, obj, objArr);
            i++;
        }
    }

    @Override // org.tinylog.provider.LoggingProvider
    public void shutdown() throws InterruptedException {
        int i = 0;
        while (true) {
            LoggingProvider[] loggingProviderArr = this.loggingProviders;
            if (i >= loggingProviderArr.length) {
                return;
            }
            loggingProviderArr[i].shutdown();
            i++;
        }
    }

    private static ContextProvider createContextProvider(Collection<LoggingProvider> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<LoggingProvider> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getContextProvider());
        }
        return new BundleContextProvider(arrayList);
    }

    List<LoggingProvider> getLoggingProviders() {
        return Arrays.asList(this.loggingProviders);
    }
}
