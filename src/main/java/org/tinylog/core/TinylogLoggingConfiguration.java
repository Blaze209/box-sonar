package org.tinylog.core;

import com.box.android.data.mappers.annotation.CommentEntityDomainMapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import org.tinylog.Level;
import org.tinylog.Supplier;
import org.tinylog.configuration.Configuration;
import org.tinylog.format.MessageFormatter;
import org.tinylog.provider.ContextProvider;
import org.tinylog.runtime.RuntimeProvider;
import org.tinylog.runtime.Timestamp;
import org.tinylog.writers.Writer;

/* JADX INFO: loaded from: classes5.dex */
public class TinylogLoggingConfiguration {
    public Collection<Writer>[][] createWriters(List<String> list, Level level, boolean z) {
        String strTrim;
        Level level2;
        if (RuntimeProvider.getProcessId() == Long.MIN_VALUE) {
            ServiceLoader.load(Writer.class);
        }
        Collection<Writer>[][] collectionArr = (Collection[][]) Array.newInstance((Class<?>) Collection.class, list.size() + 2, Level.values().length - 1);
        org.tinylog.configuration.ServiceLoader serviceLoader = new org.tinylog.configuration.ServiceLoader(Writer.class, Map.class);
        Map<String, String> siblings = Configuration.getSiblings("writer");
        if (siblings.isEmpty()) {
            siblings = Collections.singletonMap("writer", RuntimeProvider.getDefaultWriter());
        }
        for (Map.Entry<String, String> entry : siblings.entrySet()) {
            Map<String, String> children = Configuration.getChildren(entry.getKey());
            String str = children.get("tag");
            Level level3 = ConfigurationParser.parse(children.get(FirebaseAnalytics.Param.LEVEL), level);
            if (level3.ordinal() < level.ordinal()) {
                level3 = level;
            }
            String str2 = Configuration.get("exception");
            if (str2 != null && !children.containsKey("exception")) {
                children.put("exception", str2);
            }
            children.put("ID", entry.getKey());
            children.put("writingthread", Boolean.toString(z));
            Writer writer = (Writer) serviceLoader.create(entry.getValue(), children);
            if (writer != null) {
                if (str == null || str.isEmpty()) {
                    for (int i = 0; i < collectionArr.length; i++) {
                        addWriter(writer, collectionArr, i, level3);
                    }
                } else if (str.equals(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                    addWriter(writer, collectionArr, 0, level3);
                } else {
                    for (String str3 : str.split(",")) {
                        String strTrim2 = str3.trim();
                        String[] strArrSplit = strTrim2.split(CommentEntityDomainMapper.MENTIONS_SYMBOL, 2);
                        if (strArrSplit.length == 1) {
                            level2 = level3;
                            strTrim = strTrim2;
                        } else {
                            strTrim = strArrSplit[0].trim();
                            level2 = ConfigurationParser.parse(strArrSplit[1].trim(), level3);
                        }
                        if (!strTrim2.isEmpty()) {
                            addWriter(writer, collectionArr, list.indexOf(strTrim) + 1, level2);
                        }
                    }
                }
            }
        }
        for (Collection<Writer>[] collectionArr2 : collectionArr) {
            int i2 = 0;
            while (true) {
                if (i2 < collectionArr2.length) {
                    if (collectionArr2[i2] == null) {
                        collectionArr2[i2] = Collections.emptyList();
                    }
                    i2++;
                }
            }
        }
        return collectionArr;
    }

    protected void addWriter(Writer writer, Collection<Writer>[][] collectionArr, int i, Level level) {
        for (int iOrdinal = level.ordinal(); iOrdinal < Level.OFF.ordinal(); iOrdinal++) {
            Collection<Writer> arrayList = collectionArr[i][iOrdinal];
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                collectionArr[i][iOrdinal] = arrayList;
            }
            arrayList.add(writer);
        }
    }

    public Level calculateMinimumLevel(Level level, Map<String, Level> map) {
        for (Level level2 : map.values()) {
            if (level2.ordinal() < level.ordinal()) {
                level = level2;
            }
        }
        return level;
    }

    public Collection<LogEntryValue>[][] calculateRequiredLogEntryValues(Collection<Writer>[][] collectionArr) {
        Collection<LogEntryValue>[][] collectionArr2 = (Collection[][]) Array.newInstance((Class<?>) Collection.class, collectionArr.length, Level.values().length - 1);
        for (int i = 0; i < collectionArr.length; i++) {
            for (int i2 = 0; i2 < Level.OFF.ordinal(); i2++) {
                EnumSet enumSetNoneOf = EnumSet.noneOf(LogEntryValue.class);
                Iterator<Writer> it = collectionArr[i][i2].iterator();
                while (it.hasNext()) {
                    enumSetNoneOf.addAll(it.next().getRequiredLogEntryValues());
                }
                collectionArr2[i][i2] = enumSetNoneOf;
            }
        }
        return collectionArr2;
    }

    public BitSet calculateFullStackTraceRequirements(Collection<LogEntryValue>[][] collectionArr) {
        BitSet bitSet = new BitSet(collectionArr.length);
        for (int i = 0; i < collectionArr.length; i++) {
            Collection<LogEntryValue> collection = collectionArr[i][Level.ERROR.ordinal()];
            if (collection.contains(LogEntryValue.METHOD) || collection.contains(LogEntryValue.FILE) || collection.contains(LogEntryValue.LINE)) {
                bitSet.set(i);
            }
        }
        return bitSet;
    }

    public WritingThread createWritingThread(Collection<Writer>[][] collectionArr) {
        WritingThread writingThread = new WritingThread(getAllWriters(collectionArr));
        writingThread.start();
        return writingThread;
    }

    public static Collection<Writer> getAllWriters(Collection<Writer>[][] collectionArr) {
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        for (Collection<Writer>[] collectionArr2 : collectionArr) {
            int i = 0;
            while (true) {
                if (i < collectionArr2.length) {
                    setNewSetFromMap.addAll(collectionArr2[i]);
                    i++;
                }
            }
        }
        return setNewSetFromMap;
    }

    public static LogEntry createLogEntry(StackTraceElement stackTraceElement, String str, Level level, Throwable th, MessageFormatter messageFormatter, Object obj, Object[] objArr, Collection<LogEntryValue>[] collectionArr, ContextProvider contextProvider) {
        int lineNumber;
        String str2;
        String str3;
        String str4;
        String string;
        Collection<LogEntryValue> collection = collectionArr[level.ordinal()];
        Timestamp timestampCreateTimestamp = RuntimeProvider.createTimestamp();
        Thread threadCurrentThread = collection.contains(LogEntryValue.THREAD) ? Thread.currentThread() : null;
        Map<String, String> mapping = collection.contains(LogEntryValue.CONTEXT) ? contextProvider.getMapping() : null;
        if (stackTraceElement == null) {
            lineNumber = -1;
            str4 = null;
            str3 = null;
            str2 = null;
        } else {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            lineNumber = stackTraceElement.getLineNumber();
            str2 = fileName;
            str3 = methodName;
            str4 = className;
        }
        int i = lineNumber;
        if (objArr == null || objArr.length == 0) {
            Object obj2 = obj instanceof Supplier ? ((Supplier) obj).get() : obj;
            string = obj2 != null ? obj2.toString() : null;
        } else {
            string = messageFormatter.format((String) obj, objArr);
        }
        return new LogEntry(timestampCreateTimestamp, threadCurrentThread, mapping, str4, str3, str2, i, str, level, string, th);
    }
}
