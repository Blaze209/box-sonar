package com.microsoft.intune.mam.client.telemetry;

import android.content.Context;
import com.microsoft.intune.mam.Version;
import com.microsoft.intune.mam.client.telemetry.events.MAMInterfaceError;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.log.PIIFile;
import com.microsoft.intune.mam.util.NamedThreadFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public class FileCacheTelemetryLogger extends TelemetryLogger implements FileCacheTelemetryConsumer {
    private static final String CACHE_ROOT = "com.microsoft.intune.mam.telemetry";
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(FileCacheTelemetryLogger.class);
    protected static final int MAX_CACHED_EVENTS = 50;
    protected static final int MAX_QUEUED_WRITES = 50;
    private static final int MAX_THREADS = 1;
    private static final int NUM_CORE_THREADS = 1;
    private static final String TELEMETRY_EVENTS_FILENAME = "TelemetryEvents.json";
    private static final int THREAD_KEEP_ALIVE_TIME_MIN = 1;
    private static final String THREAD_NAME = "Intune MAM telemetry";
    private static String mMAMSDKVersion;
    private final boolean mAllowWrite;
    private final BlockingQueue<Runnable> mEventQueue;
    private RandomAccessFile mEventsFile;
    private File mFile;
    protected final ThreadPoolExecutor mThreadPool;

    public FileCacheTelemetryLogger(Context context, boolean z, Version version, SessionDurationStore sessionDurationStore) {
        boolean z2;
        super(context, sessionDurationStore);
        this.mEventsFile = null;
        this.mFile = null;
        mMAMSDKVersion = version.toString();
        File file = new File(context.getCacheDir(), CACHE_ROOT);
        boolean z3 = false;
        if (file.exists() || !z || file.mkdir()) {
            z2 = z;
        } else {
            LOGGER.error(MAMInterfaceError.TELEMETRY_COULD_NOT_INIT_DIRECTORY, "Unable to create telemetry directory {0}, telemetry data will not be cached.", new PIIFile(file.getAbsolutePath()));
            z2 = false;
        }
        if (file.exists()) {
            File file2 = new File(file, TELEMETRY_EVENTS_FILENAME);
            this.mFile = file2;
            try {
                if (z) {
                    this.mEventsFile = new RandomAccessFile(this.mFile, "rw");
                } else if (file2.exists()) {
                    this.mEventsFile = new RandomAccessFile(this.mFile, "r");
                }
                z3 = z2;
            } catch (FileNotFoundException e) {
                LOGGER.error(MAMInterfaceError.TELEMETRY_CACHE_FILE_CREATE_FAILED, "Failed to create telemetry cache file. Telemetry events will not be logged", e);
            }
        } else {
            z3 = z2;
        }
        this.mAllowWrite = z3;
        if (z3) {
            ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(50);
            this.mEventQueue = arrayBlockingQueue;
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.MINUTES, arrayBlockingQueue, new ThreadPoolExecutor.DiscardOldestPolicy());
            this.mThreadPool = threadPoolExecutor;
            threadPoolExecutor.setThreadFactory(new NamedThreadFactory(THREAD_NAME));
            return;
        }
        this.mThreadPool = null;
        this.mEventQueue = null;
    }

    private class WriteEvent implements Runnable {
        private final TelemetryEvent mEvent;

        WriteEvent(TelemetryEvent telemetryEvent) {
            this.mEvent = telemetryEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileCacheTelemetryLogger.this.writeEvent(this.mEvent);
        }
    }

    @Override // com.microsoft.intune.mam.client.telemetry.TelemetryLogger
    public void logEvent(TelemetryEvent telemetryEvent) {
        if (this.mEventsFile == null || !this.mAllowWrite) {
            return;
        }
        this.mThreadPool.execute(new WriteEvent(telemetryEvent));
    }

    @Override // com.microsoft.intune.mam.client.telemetry.FileCacheTelemetryConsumer
    public synchronized List<TelemetryEvent> consumeEvents() {
        List<TelemetryEvent> events;
        try {
            events = readEvents();
            closeAndDelete();
        } catch (Throwable th) {
            closeAndDelete();
            throw th;
        }
        return events;
    }

    protected synchronized List<TelemetryEvent> readEvents() {
        RandomAccessFile randomAccessFile = this.mEventsFile;
        if (randomAccessFile == null) {
            return new ArrayList();
        }
        try {
            FileLock fileLockLock = randomAccessFile.getChannel().lock(0L, Long.MAX_VALUE, true);
            try {
                JSONArray eventsUnlocked = readEventsUnlocked();
                ArrayList arrayList = new ArrayList(eventsUnlocked.length());
                for (int i = 0; i < eventsUnlocked.length(); i++) {
                    try {
                        arrayList.add(TelemetryEvent.createFromJSON(eventsUnlocked.getJSONObject(i)));
                    } catch (ClassNotFoundException e) {
                        LOGGER.log(Level.WARNING, "Not parsing telemetry event because the event class was not found. It was probably removed.", e);
                    } catch (JSONException e2) {
                        LOGGER.error(MAMInterfaceError.TELEMETRY_CACHE_PARSE_FAILURE, "Failed to parse telemetry event.", e2);
                    }
                }
                fileLockLock.release();
                return arrayList;
            } catch (Throwable th) {
                fileLockLock.release();
                throw th;
            }
        } catch (IOException | IllegalStateException | JSONException e3) {
            LOGGER.error(MAMInterfaceError.TELEMETRY_CACHE_READ_FAILURE, "Failed to read telemetry events.", e3);
            return new ArrayList();
        }
    }

    private void closeAndDelete() {
        File file;
        if (this.mEventsFile == null || (file = this.mFile) == null || !file.exists()) {
            return;
        }
        try {
            this.mEventsFile.close();
            this.mEventsFile = null;
            if (!this.mFile.delete()) {
                if (this.mFile.exists()) {
                    LOGGER.error(MAMInterfaceError.TELEMETRY_CACHE_DELETE_FAILURE, "Failed to delete cached telemetry events.", new Object[0]);
                } else {
                    LOGGER.log(Level.INFO, "Cached telemetry events were deleted, likely by another process");
                }
            }
            this.mFile = null;
        } catch (IOException e) {
            LOGGER.error(MAMInterfaceError.TELEMETRY_CACHE_DELETE_FAILURE, "Failed to delete cached telemetry events.", e);
        }
    }

    public synchronized void clearEvents() {
        RandomAccessFile randomAccessFile = this.mEventsFile;
        if (randomAccessFile == null) {
            return;
        }
        try {
            randomAccessFile.seek(0L);
            this.mEventsFile.setLength(0L);
        } catch (IOException e) {
            LOGGER.error(MAMInterfaceError.TELEMETRY_CACHE_DELETE_FAILURE, "Failed to clear telemetry events.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void writeEvent(TelemetryEvent telemetryEvent) {
        try {
            FileLock fileLockLock = this.mEventsFile.getChannel().lock();
            try {
                JSONArray jSONArrayTruncateArray = truncateArray(readEventsUnlocked(), 49);
                jSONArrayTruncateArray.put(telemetryEvent.writeToJSON());
                this.mEventsFile.seek(0L);
                this.mEventsFile.writeUTF(jSONArrayTruncateArray.toString());
                fileLockLock.release();
            } catch (Throwable th) {
                fileLockLock.release();
                throw th;
            }
        } catch (IOException | IllegalStateException | OutOfMemoryError | JSONException e) {
            LOGGER.error(MAMInterfaceError.TELEMETRY_CACHE_WRITE_FAILURE, "Failed to log telemetry event to file.", e);
        }
    }

    private JSONArray readEventsUnlocked() throws JSONException, IOException {
        if (this.mEventsFile.length() == 0) {
            return new JSONArray();
        }
        this.mEventsFile.seek(0L);
        return new JSONArray(this.mEventsFile.readUTF());
    }

    private JSONArray truncateArray(JSONArray jSONArray, int i) throws JSONException {
        if (jSONArray.length() > i) {
            while (jSONArray.length() > i) {
                jSONArray.remove(0);
            }
        }
        return jSONArray;
    }

    @Override // com.microsoft.intune.mam.client.telemetry.TelemetryLogger
    public String getSDKVersion() {
        return mMAMSDKVersion;
    }
}
