package com.box.android.data.utilities;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ZipUtils.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/data/utilities/ZipUtils;", "", "<init>", "()V", "BUFFER_SIZE", "", "compressFiles", "", "listFiles", "", "Ljava/io/File;", "destZipFile", "", "addFolderToZip", "folder", "parentFolder", "zos", "Ljava/util/zip/ZipOutputStream;", "addFileToZip", "file", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ZipUtils {
    private static final int BUFFER_SIZE = 4096;
    public static final ZipUtils INSTANCE = new ZipUtils();

    private ZipUtils() {
    }

    public final void compressFiles(List<? extends File> listFiles, String destZipFile) throws IOException {
        Intrinsics.checkNotNullParameter(listFiles, "listFiles");
        Intrinsics.checkNotNullParameter(destZipFile, "destZipFile");
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(destZipFile));
        for (File file : listFiles) {
            if (file.isDirectory()) {
                String name = file.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                addFolderToZip(file, name, zipOutputStream);
            } else {
                addFileToZip(file, zipOutputStream);
            }
        }
        zipOutputStream.flush();
        zipOutputStream.close();
    }

    private final void addFolderToZip(File folder, String parentFolder, ZipOutputStream zos) throws IOException {
        File[] fileArrListFiles = folder.listFiles();
        Intrinsics.checkNotNullExpressionValue(fileArrListFiles, "listFiles(...)");
        for (File file : fileArrListFiles) {
            if (file.isDirectory()) {
                Intrinsics.checkNotNull(file);
                addFolderToZip(file, parentFolder + "/" + file.getName(), zos);
            } else {
                zos.putNextEntry(new ZipEntry(parentFolder + "/" + file.getName()));
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    } else {
                        zos.write(bArr, 0, i);
                    }
                }
                zos.closeEntry();
            }
        }
    }

    private final void addFileToZip(File file, ZipOutputStream zos) throws IOException {
        zos.putNextEntry(new ZipEntry(file.getName()));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] bArr = new byte[4096];
        while (true) {
            int i = bufferedInputStream.read(bArr);
            if (i != -1) {
                zos.write(bArr, 0, i);
            } else {
                zos.closeEntry();
                return;
            }
        }
    }
}
