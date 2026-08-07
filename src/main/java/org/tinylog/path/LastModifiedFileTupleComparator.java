package org.tinylog.path;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes5.dex */
final class LastModifiedFileTupleComparator implements Comparator<FileTuple>, Serializable {
    static final LastModifiedFileTupleComparator INSTANCE = new LastModifiedFileTupleComparator();
    private static final long serialVersionUID = 1;

    private LastModifiedFileTupleComparator() {
    }

    @Override // java.util.Comparator
    public int compare(FileTuple fileTuple, FileTuple fileTuple2) {
        long lastModified = fileTuple.getLastModified();
        long lastModified2 = fileTuple2.getLastModified();
        if (lastModified < lastModified2) {
            return 1;
        }
        return lastModified == lastModified2 ? 0 : -1;
    }
}
