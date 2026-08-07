package org.tinylog.core;

import androidx.camera.core.CameraInfo;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.tinylog.Level;
import org.tinylog.format.MessageFormatter;
import org.tinylog.provider.ContextProvider;
import org.tinylog.provider.InternalLogger;
import org.tinylog.provider.LoggingProvider;
import org.tinylog.runtime.RuntimeProvider;
import org.tinylog.writers.Writer;

/* JADX INFO: loaded from: classes5.dex */
public class TinylogLoggingProvider implements LoggingProvider {
    private final ContextProvider context;
    private final Map<String, Level> customLevels;
    private final BitSet fullStackTraceRequired;
    private final Level globalLevel;
    private final List<String> knownTags;
    private final Collection<LogEntryValue>[][] requiredLogEntryValues;
    private final Collection<Writer>[][] writers;
    private final WritingThread writingThread;

    public TinylogLoggingProvider() {
        this(new TinylogContextProvider());
    }

    protected TinylogLoggingProvider(ContextProvider contextProvider) {
        TinylogLoggingConfiguration tinylogLoggingConfiguration = new TinylogLoggingConfiguration();
        this.context = contextProvider;
        Level globalLevel = ConfigurationParser.getGlobalLevel();
        this.globalLevel = globalLevel;
        Map<String, Level> customLevels = ConfigurationParser.getCustomLevels();
        this.customLevels = customLevels;
        List<String> tags = ConfigurationParser.getTags();
        this.knownTags = tags;
        Level levelCalculateMinimumLevel = tinylogLoggingConfiguration.calculateMinimumLevel(globalLevel, customLevels);
        boolean zIsWritingThreadEnabled = ConfigurationParser.isWritingThreadEnabled();
        Collection<Writer>[][] collectionArrCreateWriters = tinylogLoggingConfiguration.createWriters(tags, levelCalculateMinimumLevel, zIsWritingThreadEnabled);
        this.writers = collectionArrCreateWriters;
        Collection<LogEntryValue>[][] collectionArrCalculateRequiredLogEntryValues = tinylogLoggingConfiguration.calculateRequiredLogEntryValues(collectionArrCreateWriters);
        this.requiredLogEntryValues = collectionArrCalculateRequiredLogEntryValues;
        this.fullStackTraceRequired = tinylogLoggingConfiguration.calculateFullStackTraceRequirements(collectionArrCalculateRequiredLogEntryValues);
        this.writingThread = zIsWritingThreadEnabled ? tinylogLoggingConfiguration.createWritingThread(collectionArrCreateWriters) : null;
        if (ConfigurationParser.isAutoShutdownEnabled()) {
            Runtime.getRuntime().addShutdownHook(new Thread() { // from class: org.tinylog.core.TinylogLoggingProvider.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        TinylogLoggingProvider.this.shutdown();
                    } catch (InterruptedException e) {
                        InternalLogger.log(Level.ERROR, e, "Interrupted while waiting for shutdown");
                    }
                }
            });
        }
    }

    @Override // org.tinylog.provider.LoggingProvider
    public ContextProvider getContextProvider() {
        return this.context;
    }

    @Override // org.tinylog.provider.LoggingProvider
    public Level getMinimumLevel() {
        Level level = Level.OFF;
        for (int i = 0; i < this.writers.length; i++) {
            for (int iOrdinal = Level.TRACE.ordinal(); iOrdinal < level.ordinal(); iOrdinal++) {
                if (!this.writers[i][iOrdinal].isEmpty()) {
                    level = Level.values()[iOrdinal];
                }
            }
        }
        return level;
    }

    @Override // org.tinylog.provider.LoggingProvider
    public Level getMinimumLevel(String str) {
        int tagIndex = getTagIndex(str);
        for (int iOrdinal = Level.TRACE.ordinal(); iOrdinal < Level.OFF.ordinal(); iOrdinal++) {
            if (!this.writers[tagIndex][iOrdinal].isEmpty()) {
                return Level.values()[iOrdinal];
            }
        }
        return Level.OFF;
    }

    @Override // org.tinylog.provider.LoggingProvider
    public boolean isEnabled(int i, String str, Level level) {
        return isLoggable(RuntimeProvider.getCallerClassName(i + 1), level, str);
    }

    @Override // org.tinylog.provider.LoggingProvider
    public boolean isEnabled(String str, String str2, Level level) {
        return isLoggable(RuntimeProvider.getCallerClassName(str), level, str2);
    }

    private boolean isLoggable(String str, Level level, String str2) {
        return (this.customLevels.isEmpty() ? this.globalLevel : getLevel(str)).ordinal() <= level.ordinal() && !this.writers[getTagIndex(str2)][level.ordinal()].isEmpty();
    }

    @Override // org.tinylog.provider.LoggingProvider
    public void log(int i, String str, Level level, Throwable th, MessageFormatter messageFormatter, Object obj, Object... objArr) {
        Level level2;
        int tagIndex = getTagIndex(str);
        StackTraceElement callerStackTraceElement = this.fullStackTraceRequired.get(tagIndex) ? RuntimeProvider.getCallerStackTraceElement(i + 1) : null;
        if (this.customLevels.isEmpty()) {
            if (callerStackTraceElement == null && this.requiredLogEntryValues[tagIndex][level.ordinal()].contains(LogEntryValue.CLASS)) {
                callerStackTraceElement = new StackTraceElement(RuntimeProvider.getCallerClassName(i + 1), CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN, null, -1);
            }
            level2 = this.globalLevel;
        } else {
            if (callerStackTraceElement == null) {
                callerStackTraceElement = new StackTraceElement(RuntimeProvider.getCallerClassName(i + 1), CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN, null, -1);
            }
            level2 = getLevel(callerStackTraceElement.getClassName());
        }
        if (level2.ordinal() <= level.ordinal()) {
            LogEntry logEntryCreateLogEntry = TinylogLoggingConfiguration.createLogEntry(callerStackTraceElement, str, level, th, messageFormatter, obj, objArr, this.requiredLogEntryValues[tagIndex], this.context);
            output(logEntryCreateLogEntry, this.writers[tagIndex][logEntryCreateLogEntry.getLevel().ordinal()]);
        }
    }

    @Override // org.tinylog.provider.LoggingProvider
    public void log(String str, String str2, Level level, Throwable th, MessageFormatter messageFormatter, Object obj, Object... objArr) {
        Level level2;
        int tagIndex = getTagIndex(str2);
        StackTraceElement callerStackTraceElement = this.fullStackTraceRequired.get(tagIndex) ? RuntimeProvider.getCallerStackTraceElement(str) : null;
        if (this.customLevels.isEmpty()) {
            if (callerStackTraceElement == null && this.requiredLogEntryValues[tagIndex][level.ordinal()].contains(LogEntryValue.CLASS)) {
                callerStackTraceElement = new StackTraceElement(RuntimeProvider.getCallerClassName(str), CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN, null, -1);
            }
            level2 = this.globalLevel;
        } else {
            if (callerStackTraceElement == null) {
                callerStackTraceElement = new StackTraceElement(RuntimeProvider.getCallerClassName(str), CameraInfo.IMPLEMENTATION_TYPE_UNKNOWN, null, -1);
            }
            level2 = getLevel(callerStackTraceElement.getClassName());
        }
        if (level2.ordinal() <= level.ordinal()) {
            LogEntry logEntryCreateLogEntry = TinylogLoggingConfiguration.createLogEntry(callerStackTraceElement, str2, level, th, messageFormatter, obj, objArr, this.requiredLogEntryValues[tagIndex], this.context);
            output(logEntryCreateLogEntry, this.writers[tagIndex][logEntryCreateLogEntry.getLevel().ordinal()]);
        }
    }

    @Override // org.tinylog.provider.LoggingProvider
    public void shutdown() throws InterruptedException {
        WritingThread writingThread = this.writingThread;
        if (writingThread == null) {
            Iterator<Writer> it = TinylogLoggingConfiguration.getAllWriters(this.writers).iterator();
            while (it.hasNext()) {
                try {
                    it.next().close();
                } catch (Exception e) {
                    InternalLogger.log(Level.ERROR, e, "Failed to close writer");
                }
            }
            return;
        }
        writingThread.shutdown();
        this.writingThread.join();
    }

    private int getTagIndex(String str) {
        if (str == null) {
            return 0;
        }
        int iIndexOf = this.knownTags.indexOf(str);
        return iIndexOf == -1 ? this.knownTags.size() + 1 : iIndexOf + 1;
    }

    private Level getLevel(String str) {
        while (true) {
            Level level = this.customLevels.get(str);
            if (level != null) {
                return level;
            }
            int iLastIndexOf = str.lastIndexOf(46);
            if (iLastIndexOf == -1) {
                return this.globalLevel;
            }
            str = str.substring(0, iLastIndexOf);
        }
    }

    private void output(LogEntry logEntry, Iterable<Writer> iterable) {
        if (this.writingThread == null) {
            Iterator<Writer> it = iterable.iterator();
            while (it.hasNext()) {
                try {
                    it.next().write(logEntry);
                } catch (Exception e) {
                    InternalLogger.log(Level.ERROR, e, "Failed to write log entry '" + logEntry.getMessage() + "'");
                }
            }
            return;
        }
        Iterator<Writer> it2 = iterable.iterator();
        while (it2.hasNext()) {
            this.writingThread.add(it2.next(), logEntry);
        }
    }

    public Collection<Writer> getWriters(String str, Level level) {
        HashSet hashSet = new HashSet();
        int tagIndex = getTagIndex(str);
        if (tagIndex <= this.knownTags.size() && level != Level.OFF) {
            hashSet.addAll(this.writers[tagIndex][level.ordinal()]);
        }
        return hashSet;
    }

    public Collection<Writer> getWriters(String str) {
        HashSet hashSet = new HashSet();
        int tagIndex = getTagIndex(str);
        if (tagIndex <= this.knownTags.size()) {
            int i = 0;
            while (true) {
                Collection<Writer>[] collectionArr = this.writers[tagIndex];
                if (i >= collectionArr.length) {
                    break;
                }
                hashSet.addAll(collectionArr[i]);
                i++;
            }
        }
        return hashSet;
    }

    public Collection<Writer> getWriters() {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < this.writers.length; i++) {
            int i2 = 0;
            while (true) {
                Collection<Writer>[] collectionArr = this.writers[i];
                if (i2 < collectionArr.length) {
                    hashSet.addAll(collectionArr[i2]);
                    i2++;
                }
            }
        }
        return hashSet;
    }
}
