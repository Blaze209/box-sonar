package com.box.android.data.persistence;

import java.io.File;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: IFileSystem.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H&J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0005H&¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/box/android/data/persistence/IFileSystem;", "", "createOrGetFile", "Ljava/io/File;", "parent", "", "child", "filePath", "createOrGetDirectory", "dirName", "listContent", "", "directory", "deleteFile", "", "fileToDelete", "writeText", "", "file", "text", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IFileSystem {
    File createOrGetDirectory(File parent, String dirName);

    File createOrGetFile(File parent, String child);

    File createOrGetFile(String filePath);

    File createOrGetFile(String parent, String child);

    boolean deleteFile(File fileToDelete);

    List<File> listContent(File directory);

    void writeText(File file, String text) throws IOException;
}
