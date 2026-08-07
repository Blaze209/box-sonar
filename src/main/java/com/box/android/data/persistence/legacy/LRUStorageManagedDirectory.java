package com.box.android.data.persistence.legacy;

import android.os.AsyncTask;
import java.io.File;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes11.dex */
public class LRUStorageManagedDirectory {
    private static final int DAY_IN_MILLIS = 86400000;
    final DeleteHandler mDeleteHandler;
    final File mDirectory;
    final long mMaxAge;
    final long mMaxStorage;
    final AtomicLong mTotalStorageUsed;

    public interface DeleteHandler {
        void onFileDeleted(final File file, boolean deleteSuccessful);

        boolean shouldDelete(final File file);
    }

    public LRUStorageManagedDirectory(File directory, final long maxStorage, final int maxAge, DeleteHandler deleteHandler) {
        this.mDirectory = directory;
        this.mTotalStorageUsed = new AtomicLong(getDirectorySize(directory));
        this.mMaxStorage = maxStorage;
        this.mMaxAge = maxAge;
        this.mDeleteHandler = deleteHandler;
        deleteOldFilesSafely(0L, directory);
    }

    public static long getDirectorySize(File directory) {
        long directorySize;
        long j = 0;
        if (!directory.exists()) {
            return 0L;
        }
        if (directory.isDirectory()) {
            if (directory.listFiles() == null) {
                return 0L;
            }
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    directorySize = file.length();
                } else {
                    directorySize = getDirectorySize(file);
                }
                j += directorySize;
            }
        }
        return j;
    }

    public synchronized void makeRoomIfNecessary(final long spaceChanged) {
        this.mTotalStorageUsed.addAndGet(spaceChanged);
        long j = this.mTotalStorageUsed.get();
        long j2 = this.mMaxStorage;
        if (j > j2) {
            deleteOldFilesSafely(j2 / 5, this.mDirectory);
        }
    }

    public void makeRoomIfNecessary() {
        this.mTotalStorageUsed.set(getDirectorySize(this.mDirectory));
        long j = this.mTotalStorageUsed.get();
        long j2 = this.mMaxStorage;
        if (j > j2) {
            deleteOldFilesSafely(j2 / 5, this.mDirectory);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isExpired(File file, long currentTimeMillis) {
        return currentTimeMillis - file.lastModified() > this.mMaxAge * 86400000;
    }

    private void deleteOldFilesSafely(final long amountToDelete, final File directoryToDeleteFrom) {
        new AsyncTask() { // from class: com.box.android.data.persistence.legacy.LRUStorageManagedDirectory.1
            @Override // android.os.AsyncTask
            protected Object doInBackground(Object[] params) {
                File[] fileArrListFiles = directoryToDeleteFrom.listFiles();
                if (fileArrListFiles == null || fileArrListFiles.length < 1) {
                    return false;
                }
                PriorityQueue priorityQueue = new PriorityQueue(fileArrListFiles.length);
                long jCurrentTimeMillis = System.currentTimeMillis();
                for (File file : fileArrListFiles) {
                    if (file.isFile() && LRUStorageManagedDirectory.this.isExpired(file, jCurrentTimeMillis)) {
                        LRUStorageManagedDirectory.this.deleteFile(file);
                    } else if (file.isFile()) {
                        priorityQueue.add(new FileComparable(file));
                    }
                }
                while (0 < amountToDelete) {
                    FileComparable fileComparable = (FileComparable) priorityQueue.poll();
                    if (fileComparable == null) {
                        return false;
                    }
                    LRUStorageManagedDirectory.this.deleteFile(fileComparable.mFile);
                }
                return true;
            }
        }.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteFile(File file) {
        DeleteHandler deleteHandler = this.mDeleteHandler;
        if (deleteHandler == null || deleteHandler.shouldDelete(file)) {
            long length = file.length();
            boolean zDelete = file.delete();
            if (zDelete) {
                this.mTotalStorageUsed.addAndGet(-length);
            }
            DeleteHandler deleteHandler2 = this.mDeleteHandler;
            if (deleteHandler2 != null) {
                deleteHandler2.onFileDeleted(file, zDelete);
            }
        }
    }

    static class FileComparable implements Comparable<FileComparable> {
        public final File mFile;
        public final long mLastModifiedTime;

        public FileComparable(final File file) {
            this.mFile = file;
            this.mLastModifiedTime = file.lastModified();
        }

        @Override // java.lang.Comparable
        public int compareTo(FileComparable another) {
            if (this.mFile.getName().startsWith("f_local")) {
                return -1;
            }
            if (another.mFile.getName().startsWith("f_local")) {
                return 1;
            }
            return (int) (this.mLastModifiedTime - another.mLastModifiedTime);
        }
    }
}
