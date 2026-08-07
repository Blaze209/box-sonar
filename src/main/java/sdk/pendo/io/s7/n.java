package sdk.pendo.io.s7;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
public class n {

    public interface a {
        void a(long j);
    }

    public static void a(File file) {
        try {
            try {
                RandomAccessFile randomAccessFileA = a(file, "rwd");
                if (randomAccessFileA != null) {
                    randomAccessFileA.setLength(0L);
                } else {
                    PendoLogger.d("Could not clear buffer file due to an IOException and it being null.", new Object[0]);
                }
                a(randomAccessFileA);
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
                a((Closeable) null);
            }
        } catch (Throwable th) {
            a((Closeable) null);
            throw th;
        }
    }

    public static boolean b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            File file = new File(context.getCacheDir(), str);
            if (file.exists()) {
                return file.delete();
            }
        }
        return false;
    }

    public static synchronized boolean c(Context context, String str) {
        boolean zDelete;
        if (context != null) {
            try {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        zDelete = a(context, str).delete();
                        if (zDelete) {
                            PendoLogger.i("Deleted cache file.", new Object[0]);
                        } else {
                            PendoLogger.w("Could not delete the file!", new Object[0]);
                        }
                    }
                } catch (IOException e) {
                    PendoLogger.e(e, "Could not delete the file!", "file: " + str);
                    return false;
                }
            } catch (Exception e2) {
                PendoLogger.e(e2, e2.getMessage(), "file: " + str);
                return false;
            }
        }
        throw new sdk.pendo.io.y5.i("Could not delete the file! check context/filename ");
        return zDelete;
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x00b8: MOVE (r0 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:49:0x00b8 */
    public static String d(Context context, String str) throws Throwable {
        IOException e;
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3 = null;
        if (context == null || TextUtils.isEmpty(str) || !new File(context.getFilesDir(), str).exists()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStreamOpenFileInput = context.openFileInput(str);
            try {
                try {
                    inputStreamReader = new InputStreamReader(fileInputStreamOpenFileInput, Charset.forName("UTF-8"));
                    try {
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line);
                        }
                        bufferedReader.close();
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (Exception e2) {
                            PendoLogger.w(e2, e2.getMessage(), new Object[0]);
                        }
                        try {
                            inputStreamReader.close();
                        } catch (IOException e3) {
                            PendoLogger.w(e3, e3.getMessage(), new Object[0]);
                        }
                    } catch (IOException e4) {
                        e = e4;
                        PendoLogger.e(e, e.getMessage(), "error reading: " + str);
                        try {
                            fileInputStreamOpenFileInput.close();
                        } catch (Exception e5) {
                            PendoLogger.w(e5, e5.getMessage(), new Object[0]);
                        }
                        try {
                            inputStreamReader.close();
                        } catch (IOException e6) {
                            PendoLogger.w(e6, e6.getMessage(), new Object[0]);
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStreamReader3 = inputStreamReader2;
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (Exception e7) {
                        PendoLogger.w(e7, e7.getMessage(), new Object[0]);
                    }
                    try {
                        inputStreamReader3.close();
                        throw th;
                    } catch (IOException e8) {
                        PendoLogger.w(e8, e8.getMessage(), new Object[0]);
                        throw th;
                    }
                }
            } catch (IOException e9) {
                e = e9;
                inputStreamReader = null;
            } catch (Throwable th2) {
                th = th2;
                fileInputStreamOpenFileInput.close();
                inputStreamReader3.close();
                throw th;
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                return sb.toString();
            }
            PendoLogger.i("No stored information", new Object[0]);
            return null;
        } catch (FileNotFoundException e10) {
            PendoLogger.e(e10, e10.getMessage(), "file: " + str + " not found");
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v8, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.BufferedReader] */
    public static String e(Context context, String str) throws Throwable {
        Throwable th;
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(context.getCacheDir(), (String) str);
        try {
            try {
                str = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.defaultCharset()));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = str.readLine();
                        if (line == null) {
                            String string = sb.toString();
                            try {
                                str.close();
                                return string;
                            } catch (IOException unused) {
                                PendoLogger.e("FileUtils - Unable to close cache file", new Object[0]);
                                return string;
                            }
                        }
                        sb.append(line);
                    }
                } catch (FileNotFoundException unused2) {
                    try {
                        if (file.createNewFile()) {
                            PendoLogger.i("FileUtils - file has been created", new Object[0]);
                        }
                    } catch (IOException unused3) {
                        PendoLogger.e("FileUtils - Error occurred while create cache file", new Object[0]);
                    }
                    if (str != 0) {
                        try {
                            str.close();
                        } catch (IOException unused4) {
                            PendoLogger.e("FileUtils - Unable to close cache file", new Object[0]);
                        }
                    }
                    return null;
                } catch (Exception unused5) {
                    PendoLogger.e("FileUtils - Error occurred while reading cache file", new Object[0]);
                    if (str != 0) {
                        try {
                            str.close();
                        } catch (IOException unused6) {
                            PendoLogger.e("FileUtils - Unable to close cache file", new Object[0]);
                        }
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                if (str != 0) {
                    try {
                        str.close();
                    } catch (IOException unused7) {
                        PendoLogger.e("FileUtils - Unable to close cache file", new Object[0]);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused8) {
            str = 0;
        } catch (Exception unused9) {
            str = 0;
        } catch (Throwable th3) {
            th = th3;
            str = 0;
            if (str != 0) {
                str.close();
            }
            throw th;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                PendoLogger.w("FileUils->", "closeFile, " + e.getMessage());
            }
        }
    }

    public static File a(Context context, String str) throws sdk.pendo.io.y5.f {
        if (context == null || TextUtils.isEmpty(str)) {
            throw new sdk.pendo.io.y5.i("Cannot create cache file check context/filename ");
        }
        File file = new File(context.getFilesDir(), str);
        if (file.exists() || file.createNewFile()) {
            return file;
        }
        throw new sdk.pendo.io.y5.f("Cannot create cache file");
    }

    public static void a(Context context, byte[] bArr, String str) {
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                a(context, str);
                fileOutputStreamOpenFileOutput = context.openFileOutput(str, 0);
                fileOutputStreamOpenFileOutput.write(bArr);
                fileOutputStreamOpenFileOutput.flush();
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e) {
                    PendoLogger.e(e, e.getMessage(), new Object[0]);
                }
            } catch (Throwable th) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException e2) {
                        PendoLogger.e(e2, e2.getMessage(), new Object[0]);
                    }
                }
                throw th;
            }
        } catch (Exception e3) {
            PendoLogger.e(e3, e3.getMessage(), "file: " + str);
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (IOException e4) {
                    PendoLogger.e(e4, e4.getMessage(), new Object[0]);
                }
            }
        }
    }

    private static RandomAccessFile a(File file, String str) {
        if (file != null) {
            return new RandomAccessFile(file.getPath(), str);
        }
        return null;
    }

    public static String a(File file, long j, a aVar) {
        String strB = "";
        try {
            try {
                RandomAccessFile randomAccessFileA = a(file, "r");
                if (randomAccessFileA == null || j < 0) {
                    PendoLogger.d("Could not read from file because buffer file is null due to an IOException.", new Object[0]);
                } else {
                    byte[] bArr = new byte[(int) (randomAccessFileA.length() - j)];
                    randomAccessFileA.seek(j);
                    randomAccessFileA.readFully(bArr);
                    strB = y0.b(bArr);
                    if (j == 0 && aVar != null) {
                        aVar.a(randomAccessFileA.getFilePointer());
                    }
                }
                a(randomAccessFileA);
                return strB;
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
                a((Closeable) null);
                return "";
            }
        } catch (Throwable th) {
            a((Closeable) null);
            throw th;
        }
    }

    public static boolean a(Context context, String str, String str2) {
        return a(context, str, str2, context.getCacheDir());
    }

    private static boolean a(Context context, String str, String str2, File file) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        File file2 = new File(file, str2);
        if (file2.exists() && file2.delete()) {
            PendoLogger.i("Logger", "file is removed");
        }
        try {
            File file3 = new File(file, str2);
            if (!file3.createNewFile()) {
                return true;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file3), Charset.forName("UTF-8"));
            outputStreamWriter.write(str);
            outputStreamWriter.flush();
            outputStreamWriter.close();
            return true;
        } catch (IOException unused) {
            PendoLogger.e("Logger", "Error occurred while saveString2File log file");
            return true;
        }
    }

    public static boolean a(File file, byte[] bArr) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (file == null) {
                    PendoLogger.d("Could not write to file because of an IOException causing buffer file to be null.", new Object[0]);
                    a(fileOutputStream2);
                    return false;
                }
                fileOutputStream = new FileOutputStream(file.getPath(), true);
                try {
                    fileOutputStream.write(bArr);
                    a(fileOutputStream);
                    return true;
                } catch (Exception e) {
                    e = e;
                    fileOutputStream2 = fileOutputStream;
                    PendoLogger.e(e, e.getMessage(), "file: " + file.getAbsolutePath());
                    a(fileOutputStream2);
                    return false;
                } catch (Throwable th) {
                    th = th;
                    a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }
}
