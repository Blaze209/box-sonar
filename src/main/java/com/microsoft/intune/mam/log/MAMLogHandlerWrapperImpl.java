package com.microsoft.intune.mam.log;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Filter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class MAMLogHandlerWrapperImpl extends Handler implements MAMLogHandlerWrapper {
    public static final String ADAL_LOGGING_PACKAGE_NAME = "com.microsoft.intune.mam.aad.adal";
    public static final String MSMAM_PACKAGE_NAME = "MSMAM - com.microsoft.intune.mam";
    public static final int NO_FLAGS = 0;
    public static final int PRESERVE_PARAMETERS_WHEN_LOGGING_FLAG = 2;
    public static final int WANTS_PII_FLAG = 1;
    private Map<Handler, Integer> mHandlers;
    private final ReentrantReadWriteLock mHandlersLock = new ReentrantReadWriteLock();

    public MAMLogHandlerWrapperImpl() {
        this.mHandlers = null;
        this.mHandlers = new HashMap();
        setFilter(new MAMLoggerFilter());
        Logger logger = Logger.getLogger(MSMAM_PACKAGE_NAME);
        for (Handler handler : logger.getHandlers()) {
            if (handler.getClass().getName().equals(getClass().getName())) {
                logger.removeHandler(handler);
            }
        }
        logger.addHandler(this);
        logger.setUseParentHandlers(false);
    }

    class MAMLoggerFilter implements Filter {
        MAMLoggerFilter() {
        }

        @Override // java.util.logging.Filter
        public boolean isLoggable(LogRecord logRecord) {
            return logRecord.getLoggerName().startsWith(MAMLogHandlerWrapperImpl.MSMAM_PACKAGE_NAME);
        }
    }

    @Override // com.microsoft.intune.mam.log.MAMLogHandlerWrapper
    public void addHandler(Handler handler, boolean z) {
        this.mHandlersLock.writeLock().lock();
        try {
            this.mHandlers.put(handler, Integer.valueOf(z ? 1 : 0));
        } finally {
            this.mHandlersLock.writeLock().unlock();
        }
    }

    public void changeHandlerPIISetting(Handler handler, boolean z) {
        Integer numValueOf;
        Integer num = this.mHandlers.get(handler);
        if (num == null) {
            return;
        }
        if (z) {
            numValueOf = Integer.valueOf(num.intValue() | 1);
        } else {
            numValueOf = Integer.valueOf(num.intValue() & (-2));
        }
        this.mHandlers.put(handler, numValueOf);
    }

    public void addHandler(Handler handler, int i) {
        this.mHandlersLock.writeLock().lock();
        try {
            this.mHandlers.put(handler, Integer.valueOf(i));
        } finally {
            this.mHandlersLock.writeLock().unlock();
        }
    }

    @Override // com.microsoft.intune.mam.log.MAMLogHandlerWrapper
    public void removeHandler(Handler handler) {
        this.mHandlersLock.writeLock().lock();
        try {
            this.mHandlers.remove(handler);
        } finally {
            this.mHandlersLock.writeLock().unlock();
        }
    }

    @Override // com.microsoft.intune.mam.log.MAMLogHandlerWrapper
    public void setLogcatPII(boolean z) {
        this.mHandlersLock.writeLock().lock();
        try {
            for (Map.Entry<Handler, Integer> entry : this.mHandlers.entrySet()) {
                if (entry.getKey() instanceof LogCatHandler) {
                    addHandler(entry.getKey(), z ? 1 : 0);
                    break;
                }
            }
        } finally {
            this.mHandlersLock.writeLock().unlock();
        }
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        int i;
        this.mHandlersLock.readLock().lock();
        try {
            LogRecord logRecordBuildNoPIIRecord = buildNoPIIRecord(logRecord);
            Iterator<Map.Entry<Handler, Integer>> it = this.mHandlers.entrySet().iterator();
            LogRecord logRecordBuildPIIRecord = null;
            LogRecord logRecordBuildNoPIIRecordPreserveParameters = null;
            LogRecord logRecordBuildPIIRecord2 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Handler, Integer> next = it.next();
                if ((next.getValue().intValue() & 2) == 2) {
                    if ((next.getValue().intValue() & 1) == 1) {
                        if (logRecordBuildPIIRecord2 == null) {
                            logRecordBuildPIIRecord2 = buildPIIRecord(logRecord, true);
                        }
                        next.getKey().publish(logRecordBuildPIIRecord2);
                    } else {
                        if (logRecordBuildNoPIIRecordPreserveParameters == null) {
                            logRecordBuildNoPIIRecordPreserveParameters = buildNoPIIRecordPreserveParameters(logRecord);
                        }
                        next.getKey().publish(logRecordBuildNoPIIRecordPreserveParameters);
                    }
                } else if ((next.getValue().intValue() & 1) == 1) {
                    if (logRecordBuildPIIRecord == null) {
                        logRecordBuildPIIRecord = buildPIIRecord(logRecord, false);
                    }
                    next.getKey().publish(logRecordBuildPIIRecord);
                } else {
                    next.getKey().publish(logRecordBuildNoPIIRecord);
                }
            }
            for (Handler handler : Logger.getLogger("").getHandlers()) {
                if (!handler.getClass().getName().equals("com.android.internal.logging.AndroidHandler") && !this.mHandlers.keySet().contains(handler)) {
                    handler.publish(logRecordBuildNoPIIRecord);
                }
            }
        } finally {
            this.mHandlersLock.readLock().unlock();
        }
    }

    private LogRecord buildPIIRecord(LogRecord logRecord, boolean z) {
        Object[] parameters = logRecord.getParameters();
        if (parameters == null) {
            return messageFormatRecord(logRecord, null);
        }
        Object[] objArr = new Object[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            Object obj = parameters[i];
            if (obj instanceof PIIObj) {
                objArr[i] = ((PIIObj) obj).toStringPIIfull();
            } else {
                objArr[i] = obj;
            }
        }
        if (z) {
            return copyPrimitiveLogRecordComponents(logRecord, logRecord.getMessage(), objArr);
        }
        return messageFormatRecord(logRecord, objArr);
    }

    @Override // java.util.logging.Handler
    public void close() {
        this.mHandlersLock.readLock().lock();
        try {
            Iterator<Map.Entry<Handler, Integer>> it = this.mHandlers.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getKey().close();
            }
            this.mHandlersLock.readLock().unlock();
        } catch (Throwable th) {
            this.mHandlersLock.readLock().unlock();
            throw th;
        }
    }

    @Override // java.util.logging.Handler
    public void flush() {
        this.mHandlersLock.readLock().lock();
        try {
            Iterator<Map.Entry<Handler, Integer>> it = this.mHandlers.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getKey().flush();
            }
            this.mHandlersLock.readLock().unlock();
        } catch (Throwable th) {
            this.mHandlersLock.readLock().unlock();
            throw th;
        }
    }

    private LogRecord buildNoPIIRecord(LogRecord logRecord) {
        return messageFormatRecord(logRecord);
    }

    private LogRecord buildNoPIIRecordPreserveParameters(LogRecord logRecord) {
        return copyPrimitiveLogRecordComponents(logRecord, logRecord.getMessage(), logRecord.getParameters());
    }

    private LogRecord messageFormatRecord(LogRecord logRecord) {
        return messageFormatRecord(logRecord, logRecord.getParameters());
    }

    private LogRecord messageFormatRecord(LogRecord logRecord, Object[] objArr) {
        String message = logRecord.getMessage();
        if (objArr != null && message != null && message.contains("{0")) {
            try {
                if (oddSingleQuoteCount(message)) {
                    message = message.replaceAll("'", "''");
                }
                message = MessageFormat.format(message, objArr);
            } catch (Exception unused) {
                message = logRecord.getMessage();
            }
        }
        return copyPrimitiveLogRecordComponents(logRecord, message);
    }

    private boolean oddSingleQuoteCount(String str) {
        if (!str.contains("'")) {
            return false;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (str.charAt(i2) == '\'') {
                i++;
            }
        }
        return i % 2 == 1;
    }

    private LogRecord copyPrimitiveLogRecordComponents(LogRecord logRecord, String str) {
        LogRecord logRecord2;
        if (logRecord instanceof MAMErrorLogRecord) {
            logRecord2 = new MAMErrorLogRecord(((MAMErrorLogRecord) logRecord).getErrorId(), str);
        } else {
            logRecord2 = new LogRecord(logRecord.getLevel(), str);
        }
        logRecord2.setLoggerName(logRecord.getLoggerName());
        logRecord2.setMillis(logRecord.getMillis());
        logRecord2.setResourceBundle(logRecord.getResourceBundle());
        logRecord2.setResourceBundleName(logRecord.getResourceBundleName());
        logRecord2.setSequenceNumber(logRecord.getSequenceNumber());
        logRecord2.setSourceClassName(logRecord.getSourceClassName());
        logRecord2.setSourceMethodName(logRecord.getSourceMethodName());
        logRecord2.setThreadID(logRecord.getThreadID());
        logRecord2.setThrown(logRecord.getThrown());
        return logRecord2;
    }

    private LogRecord copyPrimitiveLogRecordComponents(LogRecord logRecord, String str, Object[] objArr) {
        LogRecord logRecordCopyPrimitiveLogRecordComponents = copyPrimitiveLogRecordComponents(logRecord, str);
        logRecordCopyPrimitiveLogRecordComponents.setParameters(objArr);
        return logRecordCopyPrimitiveLogRecordComponents;
    }
}
