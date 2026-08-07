package org.tinylog.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;
import org.tinylog.writers.Writer;

/* JADX INFO: loaded from: classes5.dex */
public final class WritingThread extends Thread {
    private static final String THREAD_NAME = "tinylog-WritingThread";
    private final Object mutex = new Object();
    private List<Task> tasks = new ArrayList();
    private final Collection<Writer> writers;

    WritingThread(Collection<Writer> collection) {
        this.writers = collection;
        setName(THREAD_NAME);
        setPriority(1);
        setDaemon(true);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList(1);
        while (true) {
            for (Task task : receiveTasks()) {
                if (task == Task.POISON) {
                    close();
                    return;
                }
                write(arrayList, task);
            }
            flush(arrayList);
            arrayList.clear();
        }
    }

    public void add(Writer writer, LogEntry logEntry) {
        Task task = new Task(writer, logEntry);
        synchronized (this.mutex) {
            this.tasks.add(task);
            this.mutex.notify();
        }
    }

    public void shutdown() {
        synchronized (this.mutex) {
            this.tasks.add(Task.POISON);
            this.mutex.notify();
        }
    }

    private List<Task> receiveTasks() {
        List<Task> list;
        synchronized (this.mutex) {
            while (this.tasks.isEmpty()) {
                try {
                    this.mutex.wait();
                } catch (InterruptedException unused) {
                    return Collections.emptyList();
                }
            }
            list = this.tasks;
            this.tasks = new ArrayList();
        }
        return list;
    }

    private void write(Collection<Writer> collection, Task task) {
        try {
            Writer writer = task.writer;
            writer.write(task.logEntry);
            if (collection.contains(writer)) {
                return;
            }
            collection.add(writer);
        } catch (Exception e) {
            InternalLogger.log(Level.ERROR, e, "Failed to write log entry '" + task.logEntry.getMessage() + "'");
        }
    }

    private void flush(Collection<Writer> collection) {
        Iterator<Writer> it = collection.iterator();
        while (it.hasNext()) {
            try {
                it.next().flush();
            } catch (Exception e) {
                InternalLogger.log(Level.ERROR, e, "Failed to flush writer");
            }
        }
    }

    private void close() {
        Iterator<Writer> it = this.writers.iterator();
        while (it.hasNext()) {
            try {
                it.next().close();
            } catch (Exception e) {
                InternalLogger.log(Level.ERROR, e, "Failed to close writer");
            }
        }
    }

    private static final class Task {
        private static final Task POISON = null;
        private final LogEntry logEntry;
        private final Writer writer;

        Task(Writer writer, LogEntry logEntry) {
            this.writer = writer;
            this.logEntry = logEntry;
        }
    }
}
