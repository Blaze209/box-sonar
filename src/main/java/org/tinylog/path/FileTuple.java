package org.tinylog.path;

import java.io.File;
import org.tinylog.Level;
import org.tinylog.provider.InternalLogger;

/* JADX INFO: loaded from: classes5.dex */
public final class FileTuple {
    private final File backup;
    private final File original;

    public FileTuple(File file, File file2) {
        this.original = file;
        this.backup = file2;
    }

    public File getOriginal() {
        return this.original;
    }

    public File getBackup() {
        return this.backup;
    }

    public long getLastModified() {
        return Math.max(this.original.lastModified(), this.backup.lastModified());
    }

    public void delete() {
        if (this.original.isFile() && !this.original.delete()) {
            InternalLogger.log(Level.WARN, "Failed to delete log file '" + this.original + "'");
        }
        if (this.backup.equals(this.original) || !this.backup.isFile() || this.backup.delete()) {
            return;
        }
        InternalLogger.log(Level.WARN, "Failed to delete backup file '" + this.backup + "'");
    }
}
