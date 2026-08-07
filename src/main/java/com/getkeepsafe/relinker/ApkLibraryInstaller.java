package com.getkeepsafe.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes13.dex */
public class ApkLibraryInstaller implements ReLinker.LibraryInstaller {
    private static final int COPY_BUFFER_SIZE = 4096;
    private static final int MAX_TRIES = 5;

    private String[] sourceDirectories(final Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo.splitSourceDirs != null && applicationInfo.splitSourceDirs.length != 0) {
            String[] strArr = new String[applicationInfo.splitSourceDirs.length + 1];
            strArr[0] = applicationInfo.sourceDir;
            System.arraycopy(applicationInfo.splitSourceDirs, 0, strArr, 1, applicationInfo.splitSourceDirs.length);
            return strArr;
        }
        return new String[]{applicationInfo.sourceDir};
    }

    private static class ZipFileInZipEntry {
        public ZipEntry zipEntry;
        public ZipFile zipFile;

        public ZipFileInZipEntry(ZipFile zipFile, ZipEntry zipEntry) {
            this.zipFile = zipFile;
            this.zipEntry = zipEntry;
        }
    }

    private ZipFileInZipEntry findAPKWithLibrary(final Context context, final String[] abis, final String mappedLibraryName, final ReLinkerInstance instance) {
        String[] strArrSourceDirectories = sourceDirectories(context);
        int length = strArrSourceDirectories.length;
        int i = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i >= length) {
                return null;
            }
            String str = strArrSourceDirectories[i];
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str), 1);
                    break;
                } catch (IOException unused) {
                    i2 = i3;
                }
            }
            if (zipFile != null) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (i4 < 5) {
                        for (String str2 : abis) {
                            String str3 = "lib" + File.separatorChar + str2 + File.separatorChar + mappedLibraryName;
                            instance.log("Looking for %s in APK %s...", str3, str);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new ZipFileInZipEntry(zipFile, entry);
                            }
                        }
                        i4 = i5;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i++;
        }
    }

    private String[] getSupportedABIs(Context context, String mappedLibraryName) {
        Pattern patternCompile = Pattern.compile("lib" + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + mappedLibraryName);
        HashSet hashSet = new HashSet();
        for (String str : sourceDirectories(context)) {
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = new ZipFile(new File(str), 1).entries();
                while (enumerationEntries.hasMoreElements()) {
                    Matcher matcher = patternCompile.matcher(enumerationEntries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    @Override // com.getkeepsafe.relinker.ReLinker.LibraryInstaller
    public void installLibrary(Context context, String[] strArr, String str, File file, ReLinkerInstance reLinkerInstance) throws Throwable {
        String[] supportedABIs;
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        ZipFileInZipEntry zipFileInZipEntry = null;
        Closeable closeable = null;
        try {
            ZipFileInZipEntry zipFileInZipEntryFindAPKWithLibrary = findAPKWithLibrary(context, strArr, str, reLinkerInstance);
            try {
                if (zipFileInZipEntryFindAPKWithLibrary == null) {
                    try {
                        supportedABIs = getSupportedABIs(context, str);
                    } catch (Exception e) {
                        supportedABIs = new String[]{e.toString()};
                    }
                    throw new MissingLibraryException(str, strArr, supportedABIs);
                }
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    try {
                        if (i >= 5) {
                            reLinkerInstance.log("FATAL! Couldn't extract the library from the APK!");
                            if (zipFileInZipEntryFindAPKWithLibrary != null && zipFileInZipEntryFindAPKWithLibrary.zipFile != null) {
                                break;
                            } else {
                                return;
                            }
                        }
                        reLinkerInstance.log("Found %s! Extracting...", str);
                        try {
                            if (file.exists() || file.createNewFile()) {
                                try {
                                    inputStream = zipFileInZipEntryFindAPKWithLibrary.zipFile.getInputStream(zipFileInZipEntryFindAPKWithLibrary.zipEntry);
                                    try {
                                        fileOutputStream = new FileOutputStream(file);
                                        try {
                                            long jCopy = copy(inputStream, fileOutputStream);
                                            fileOutputStream.getFD().sync();
                                            if (jCopy == file.length()) {
                                                closeSilently(inputStream);
                                                closeSilently(fileOutputStream);
                                                file.setReadable(true, false);
                                                file.setExecutable(true, false);
                                                file.setWritable(true);
                                                if (zipFileInZipEntryFindAPKWithLibrary != null && zipFileInZipEntryFindAPKWithLibrary.zipFile != null) {
                                                    break;
                                                } else {
                                                    return;
                                                }
                                            }
                                            closeSilently(inputStream);
                                            closeSilently(fileOutputStream);
                                        } catch (FileNotFoundException unused) {
                                            closeSilently(inputStream);
                                        } catch (IOException unused2) {
                                            closeSilently(inputStream);
                                        } catch (Throwable th) {
                                            th = th;
                                            closeable = inputStream;
                                            closeSilently(closeable);
                                            closeSilently(fileOutputStream);
                                            throw th;
                                        }
                                    } catch (FileNotFoundException unused3) {
                                        fileOutputStream = null;
                                    } catch (IOException unused4) {
                                        fileOutputStream = null;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fileOutputStream = null;
                                    }
                                } catch (FileNotFoundException unused5) {
                                    inputStream = null;
                                    fileOutputStream = null;
                                } catch (IOException unused6) {
                                    inputStream = null;
                                    fileOutputStream = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = null;
                                }
                            }
                        } catch (IOException unused7) {
                        }
                        i = i2;
                    } catch (IOException unused8) {
                        return;
                    }
                }
                zipFileInZipEntryFindAPKWithLibrary.zipFile.close();
            } catch (Throwable th4) {
                th = th4;
                zipFileInZipEntry = zipFileInZipEntryFindAPKWithLibrary;
                if (zipFileInZipEntry != null) {
                    try {
                        if (zipFileInZipEntry.zipFile != null) {
                            zipFileInZipEntry.zipFile.close();
                        }
                    } catch (IOException unused9) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private long copy(InputStream in, OutputStream out) throws IOException {
        byte[] bArr = new byte[4096];
        long j = 0;
        while (true) {
            int i = in.read(bArr);
            if (i != -1) {
                out.write(bArr, 0, i);
                j += (long) i;
            } else {
                out.flush();
                return j;
            }
        }
    }

    private void closeSilently(final Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
