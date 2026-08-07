package com.splunk.rum;

import android.app.Application;
import android.system.ErrnoException;
import android.system.Os;
import android.util.AtomicFile;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes3.dex */
class FileUtils {
    FileUtils() {
    }

    static File getSpansDirectory(Application application) {
        return new File(application.getApplicationContext().getFilesDir(), "spans");
    }

    void writeAsLines(File file, List<byte[]> list) throws IOException {
        AtomicFile atomicFile = new AtomicFile(file);
        FileOutputStream fileOutputStreamStartWrite = atomicFile.startWrite();
        try {
            Iterator<byte[]> it = list.iterator();
            while (it.hasNext()) {
                fileOutputStreamStartWrite.write(it.next());
                fileOutputStreamStartWrite.write(10);
            }
            atomicFile.finishWrite(fileOutputStreamStartWrite);
            if (fileOutputStreamStartWrite != null) {
                fileOutputStreamStartWrite.close();
            }
        } catch (Throwable th) {
            if (fileOutputStreamStartWrite != null) {
                try {
                    fileOutputStreamStartWrite.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    List<byte[]> readFileCompletely(File file) throws IOException {
        ArrayList arrayList = new ArrayList();
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        try {
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                try {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        arrayList.add(line.getBytes(StandardCharsets.UTF_8));
                    } else {
                        bufferedReader.close();
                        inputStreamReader.close();
                        return arrayList;
                    }
                } catch (Throwable th) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
                try {
                    inputStreamReader.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th;
            }
        } catch (Throwable th4) {
            inputStreamReader.close();
            throw th4;
        }
    }

    Stream<File> listFiles(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return Stream.empty();
        }
        return Arrays.stream(fileArrListFiles);
    }

    Stream<File> listSpanFiles(File file) {
        return listFiles(file).filter(new Predicate() { // from class: com.splunk.rum.FileUtils$$ExternalSyntheticLambda2
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f$0.isRegularFile((File) obj);
            }
        }).filter(new Predicate() { // from class: com.splunk.rum.FileUtils$$ExternalSyntheticLambda3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((File) obj).toString().endsWith(".spans");
            }
        });
    }

    long getTotalFileSizeInBytes(File file) {
        return ((Long) listFiles(file).reduce(0L, new BiFunction() { // from class: com.splunk.rum.FileUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return this.f$0.m14332lambda$getTotalFileSizeInBytes$1$comsplunkrumFileUtils((Long) obj, (File) obj2);
            }
        }, new BinaryOperator() { // from class: com.splunk.rum.FileUtils$$ExternalSyntheticLambda1
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Long.valueOf(Long.sum(((Long) obj).longValue(), ((Long) obj2).longValue()));
            }
        })).longValue();
    }

    /* JADX INFO: renamed from: lambda$getTotalFileSizeInBytes$1$com-splunk-rum-FileUtils, reason: not valid java name */
    /* synthetic */ Long m14332lambda$getTotalFileSizeInBytes$1$comsplunkrumFileUtils(Long l, File file) {
        return Long.valueOf(l.longValue() + getFileSize(file));
    }

    long getFileSize(File file) {
        try {
            return Os.stat(file.getCanonicalPath()).st_size;
        } catch (ErrnoException | IOException e) {
            Log.w("SplunkRum", "Error getting file size for " + file, e);
            return 0L;
        }
    }

    long getModificationTime(File file) {
        try {
            return Os.stat(file.getCanonicalPath()).st_mtime;
        } catch (ErrnoException | IOException e) {
            Log.w("SplunkRum", "Error getting file size for " + file, e);
            return 0L;
        }
    }

    boolean isRegularFile(File file) {
        return file.isFile();
    }

    void safeDelete(File file) {
        if (file.delete()) {
            return;
        }
        Log.w("SplunkRum", "Error deleting file " + file);
    }
}
