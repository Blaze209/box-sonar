package org.apache.commons.io.filefilter;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: classes5.dex */
public class AgeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = -2132740084016138541L;
    private final boolean acceptOlder;
    private final long cutoff;

    public AgeFileFilter(long j) {
        this(j, true);
    }

    public AgeFileFilter(long j, boolean z) {
        this.acceptOlder = z;
        this.cutoff = j;
    }

    public AgeFileFilter(Date date) {
        this(date, true);
    }

    public AgeFileFilter(Date date, boolean z) {
        this(date.getTime(), z);
    }

    public AgeFileFilter(File file) {
        this(file, true);
    }

    public AgeFileFilter(File file, boolean z) {
        this(file.lastModified(), z);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean zIsFileNewer = FileUtils.isFileNewer(file, this.cutoff);
        if (this.acceptOlder) {
            return !zIsFileNewer;
        }
        return zIsFileNewer;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        return super.toString() + "(" + (this.acceptOlder ? SimpleComparison.LESS_THAN_EQUAL_TO_OPERATION : SimpleComparison.GREATER_THAN_OPERATION) + this.cutoff + ")";
    }
}
