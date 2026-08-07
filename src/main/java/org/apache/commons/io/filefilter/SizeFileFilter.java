package org.apache.commons.io.filefilter;

import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class SizeFileFilter extends AbstractFileFilter implements Serializable {
    private static final long serialVersionUID = 7388077430788600069L;
    private final boolean acceptLarger;
    private final long size;

    public SizeFileFilter(long j) {
        this(j, true);
    }

    public SizeFileFilter(long j, boolean z) {
        if (j < 0) {
            throw new IllegalArgumentException("The size must be non-negative");
        }
        this.size = j;
        this.acceptLarger = z;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File file) {
        boolean z = file.length() < this.size;
        if (this.acceptLarger) {
            return !z;
        }
        return z;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter
    public String toString() {
        return super.toString() + "(" + (this.acceptLarger ? SimpleComparison.GREATER_THAN_EQUAL_TO_OPERATION : SimpleComparison.LESS_THAN_OPERATION) + this.size + ")";
    }
}
