package com.microsoft.intune.mam.log;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class MAMLogger {
    private Logger mLogger;
    private final String mLoggerName;
    private static ThreadLocal<Boolean> sEnabled = new ThreadLocal<Boolean>() { // from class: com.microsoft.intune.mam.log.MAMLogger.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return true;
        }
    };
    private static boolean sLoggingDisabled = false;
    private static Queue<LogRecord> sBacklog = new ArrayDeque();

    public MAMLogger(String str) {
        this.mLoggerName = str;
    }

    public void entering(String str) {
        if (enabled()) {
            getLogger().finer(String.format("ENTER %s", str));
        }
    }

    public void exiting(String str) {
        if (enabled()) {
            getLogger().finer(String.format("RETURN %s", str));
        }
    }

    public void log(Level level, String str) {
        log(createLogRecord(level, str));
    }

    private LogRecord createLogRecord(Level level, String str) {
        LogRecord logRecord = new LogRecord(level, str);
        logRecord.setLoggerName(this.mLoggerName);
        return logRecord;
    }

    private LogRecord createLogRecord(Level level, String str, Object obj) {
        LogRecord logRecord = new LogRecord(level, str);
        logRecord.setLoggerName(this.mLoggerName);
        logRecord.setParameters(new Object[]{obj});
        return logRecord;
    }

    private LogRecord createLogRecord(Level level, String str, Object[] objArr) {
        LogRecord logRecord = new LogRecord(level, str);
        logRecord.setLoggerName(this.mLoggerName);
        logRecord.setParameters(objArr);
        return logRecord;
    }

    public void log(Level level, String str, Throwable th) {
        LogRecord logRecordCreateLogRecord = createLogRecord(level, str);
        logRecordCreateLogRecord.setThrown(th);
        log(logRecordCreateLogRecord);
    }

    public void log(Level level, String str, Throwable th, Object obj) {
        LogRecord logRecordCreateLogRecord = createLogRecord(level, str, obj);
        logRecordCreateLogRecord.setThrown(th);
        log(logRecordCreateLogRecord);
    }

    public void log(Level level, String str, Throwable th, Object... objArr) {
        LogRecord logRecordCreateLogRecord = createLogRecord(level, str, objArr);
        logRecordCreateLogRecord.setThrown(th);
        log(logRecordCreateLogRecord);
    }

    public void log(LogRecord logRecord) {
        if (!enabled()) {
            synchronized (sBacklog) {
                sBacklog.add(logRecord);
            }
            return;
        }
        try {
            setEnabled(false);
            ArrayList arrayList = new ArrayList();
            synchronized (sBacklog) {
                while (sBacklog.peek() != null) {
                    arrayList.add(sBacklog.poll());
                }
            }
            arrayList.add(logRecord);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                getLogger().log((LogRecord) it.next());
            }
            setEnabled(true);
        } catch (Throwable th) {
            setEnabled(true);
            throw th;
        }
    }

    public void log(Level level, String str, Object... objArr) {
        log(createLogRecord(level, str, objArr));
    }

    public void catastrophic(String str, Object... objArr) {
        log(MAMLevel.CATASTROPHIC, str, objArr);
    }

    public void error(MAMErrorId mAMErrorId, String str, Throwable th) {
        error(mAMErrorId, str, th, null);
    }

    public void error(MAMErrorId mAMErrorId, String str, Object... objArr) {
        error(mAMErrorId, str, null, objArr);
    }

    public void error(MAMErrorId mAMErrorId, String str, Throwable th, Object... objArr) {
        MAMErrorLogRecord mAMErrorLogRecord = new MAMErrorLogRecord(mAMErrorId, str);
        mAMErrorLogRecord.setLoggerName(this.mLoggerName);
        if (objArr != null) {
            mAMErrorLogRecord.setParameters(objArr);
        }
        if (th != null) {
            mAMErrorLogRecord.setThrown(th);
        }
        log(mAMErrorLogRecord);
    }

    public void severe(String str, Object... objArr) {
        log(Level.SEVERE, str, objArr);
    }

    public void severe(String str, Throwable th) {
        log(Level.SEVERE, str, th);
    }

    public void warning(String str, Object... objArr) {
        log(Level.WARNING, str, objArr);
    }

    public void warning(String str, Throwable th) {
        log(Level.WARNING, str, th);
    }

    public void info(String str, Object... objArr) {
        log(Level.INFO, str, objArr);
    }

    public void info(String str, Throwable th) {
        log(Level.INFO, str, th);
    }

    public void fine(String str, Object... objArr) {
        log(Level.FINE, str, objArr);
    }

    public void finer(String str, Object... objArr) {
        log(Level.FINER, str, objArr);
    }

    public void finest(String str, Object... objArr) {
        log(Level.FINEST, str, objArr);
    }

    public static boolean enabled() {
        return (sEnabled.get() == null || Boolean.TRUE.equals(sEnabled.get())) && !sLoggingDisabled;
    }

    public static void setEnabled(boolean z) {
        sEnabled.set(Boolean.valueOf(z));
    }

    public static void setLoggingDisabled(boolean z) {
        sLoggingDisabled = z;
    }

    private Logger getLogger() {
        if (this.mLogger == null) {
            this.mLogger = Logger.getLogger(this.mLoggerName);
        }
        return this.mLogger;
    }

    public static class MAMLevel extends Level {
        public static final Level CATASTROPHIC = new MAMLevel("CATASTROPHIC", 2000);

        public MAMLevel(String str, int i) {
            super(str, i);
        }
    }
}
