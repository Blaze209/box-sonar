package com.box.android.data.persistence;

import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: FileSystem.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0007H\u0016¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/persistence/FileSystem;", "Lcom/box/android/data/persistence/IFileSystem;", "<init>", "()V", "createOrGetFile", "Ljava/io/File;", "parent", "", "child", "filePath", "createOrGetDirectory", "dirName", "listContent", "", "directory", "deleteFile", "", "fileToDelete", "writeText", "", "file", "text", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileSystem implements IFileSystem {
    @Inject
    public FileSystem() {
    }

    @Override // com.box.android.data.persistence.IFileSystem
    public File createOrGetFile(String parent, String child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        try {
            return new File(parent, child);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.box.android.data.persistence.IFileSystem
    public File createOrGetFile(File parent, String child) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        try {
            return new File(parent, child);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.box.android.data.persistence.IFileSystem
    public File createOrGetFile(String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        try {
            return new File(filePath);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.box.android.data.persistence.IFileSystem
    public File createOrGetDirectory(File parent, String dirName) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(dirName, "dirName");
        try {
            File file = new File(parent, dirName);
            file.mkdirs();
            return file;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.box.android.data.persistence.IFileSystem
    public List<File> listContent(File directory) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        try {
            if (!directory.isDirectory()) {
                return CollectionsKt.emptyList();
            }
            File[] fileArrListFiles = directory.listFiles();
            Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "listFiles(...)");
            return ArraysKt.toList(fileArrListFiles);
        } catch (Exception unused) {
            return CollectionsKt.emptyList();
        }
    }

    @Override // com.box.android.data.persistence.IFileSystem
    public boolean deleteFile(File fileToDelete) {
        Intrinsics.checkNotNullParameter(fileToDelete, "fileToDelete");
        try {
            String name = fileToDelete.getName();
            boolean zDelete = fileToDelete.delete();
            if (zDelete) {
                BoxLogUtils.i(ExtensionsKt.getTAG(this), "Deleted file: " + name);
                return zDelete;
            }
            BoxLogUtils.w(ExtensionsKt.getTAG(this), "Failed to delete file: " + name);
            return zDelete;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.box.android.data.persistence.IFileSystem
    public void writeText(File file, String text) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(text, "text");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), Charsets.UTF_8);
        BufferedWriter bufferedWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
        try {
            try {
                bufferedWriter.write(text);
                bufferedWriter.close();
            } catch (Exception e) {
                BoxLogUtils.e(ExtensionsKt.getTAG(this), e);
                throw e;
            }
        } catch (Throwable th) {
            bufferedWriter.close();
            throw th;
        }
    }
}
