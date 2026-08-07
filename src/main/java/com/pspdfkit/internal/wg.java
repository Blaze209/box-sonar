package com.pspdfkit.internal;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import com.pspdfkit.BuildConfig;
import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.utils.PdfLog;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public final class wg {
    /* JADX WARN: Code duplicated, block: B:53:0x0104  */
    public static String a(Context context, Uri uri) {
        String strA;
        Uri uri2;
        if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        if (!Environment.isExternalStorageManager()) {
            return null;
        }
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(":");
                if (strArrSplit.length == 2 && "primary".equalsIgnoreCase(strArrSplit[0])) {
                    strA = Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                } else {
                    strA = null;
                }
            } else {
                try {
                    if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                        String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(":");
                        if (strArrSplit2.length == 2 && "raw".equalsIgnoreCase(strArrSplit2[0])) {
                            strA = strArrSplit2[1];
                        } else {
                            strA = a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(DocumentsContract.getDocumentId(uri))), (String) null, (String[]) null);
                        }
                    } else {
                        if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                            String[] strArrSplit3 = DocumentsContract.getDocumentId(uri).split(":");
                            String str = strArrSplit3[0];
                            str.getClass();
                            str.hashCode();
                            switch (str) {
                                case "audio":
                                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                                    break;
                                case "image":
                                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                                    break;
                                case "video":
                                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                                    break;
                                default:
                                    uri2 = null;
                                    break;
                            }
                            String[] strArr = {strArrSplit3[1]};
                            if (uri2 != null) {
                                strA = a(context, uri2, "_id=?", strArr);
                            }
                        }
                        strA = null;
                    }
                } catch (IllegalArgumentException unused) {
                }
            }
        } else {
            strA = null;
        }
        if (strA == null && "content".equalsIgnoreCase(uri.getScheme())) {
            try {
                strA = a(context, uri, (String) null, (String[]) null);
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (strA != null) {
            File file = new File(strA);
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    if (fileInputStream.read() == -1 || !file.canWrite()) {
                        strA = null;
                    }
                    fileInputStream.close();
                } catch (Throwable th) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused3) {
                return null;
            }
        }
        return strA;
    }

    public static String b(String str) {
        return "nutrient/" + str;
    }

    public static String b(InputStream inputStream) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        while (true) {
            try {
                int i = bufferedReader.read();
                if (i == -1) {
                    bufferedReader.close();
                    return sb.toString();
                }
                sb.append((char) i);
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static InputStream b(Context context, Uri uri) throws IOException {
        try {
            if (uri.toString().startsWith("file:///android_asset/")) {
                return context.getAssets().open(uri.getPath().substring(15));
            }
            String strA = a(context, uri);
            if (strA != null) {
                return new BufferedInputStream(new FileInputStream(strA));
            }
            InputStream inputStreamOpenInputStream = MAMContentResolverManagement.openInputStream(context.getContentResolver(), uri);
            if (inputStreamOpenInputStream != null) {
                return inputStreamOpenInputStream;
            }
            throw new IOException("ContentResolver.openInputStream() returned null.");
        } catch (Exception e) {
            throw new IOException("Could not open input stream for " + uri, e);
        }
    }

    public static String a(Context context, Uri uri, String str, String[] strArr) throws IllegalArgumentException {
        try {
            Cursor cursorQuery = MAMContentResolverManagement.query(context.getContentResolver(), uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        cursorQuery.close();
                        return string;
                    }
                } catch (Throwable th) {
                    try {
                        cursorQuery.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                        throw th;
                    }
                }
            }
            if (cursorQuery == null) {
                return null;
            }
            cursorQuery.close();
            return null;
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static File a(Context context) throws IOException {
        File file = new File(context.getCacheDir(), "nutrient");
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        throw new IOException("Failed to create Nutrient cache directory.");
    }

    public static File a(Context context, String str) {
        try {
            if (str.startsWith(".")) {
                str = str.substring(1);
            }
            String strConcat = ".".concat(str);
            File file = new File(context.getCacheDir(), "nutrient");
            file.mkdirs();
            return File.createTempFile("pspdf", strConcat, file);
        } catch (IOException e) {
            PdfLog.e("Nutri.FileUtils", "Failed to create temporary file.", e);
            return null;
        }
    }

    public static File a(Context context, String str, HashSet hashSet, String str2) throws IOException {
        Integer numValueOf;
        String[] list = context.getAssets().list(str);
        if (list.length != 0) {
            File file = new File(context.getFilesDir(), str2);
            file.mkdirs();
            File file2 = new File(file, "version");
            if (file2.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "r");
                numValueOf = Integer.valueOf(randomAccessFile.readInt());
                randomAccessFile.close();
            } else {
                numValueOf = null;
            }
            if (numValueOf == null || 146948 != numValueOf.intValue()) {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                randomAccessFile2.writeInt(BuildConfig.NUTRIENT_VERSION_CODE);
                randomAccessFile2.close();
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(BuildConfig.NUTRIENT_VERSION_CODE);
                }
            }
            for (String str3 : list) {
                if (hashSet == null || hashSet.contains(str3)) {
                    File file3 = new File(str, str3);
                    File file4 = new File(file, str3);
                    if (!file4.exists() || numValueOf.intValue() != 146948) {
                        InputStream inputStreamOpen = context.getAssets().open(file3.getPath());
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file4);
                            try {
                                a(inputStreamOpen, fileOutputStream);
                                fileOutputStream.close();
                                inputStreamOpen.close();
                            } catch (Throwable th) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            if (inputStreamOpen != null) {
                                try {
                                    inputStreamOpen.close();
                                } catch (Throwable th4) {
                                    th3.addSuppressed(th4);
                                }
                            }
                            throw th3;
                        }
                    }
                }
            }
            return file;
        }
        throw new FileNotFoundException("Source assets directory \"" + str + "\" must not be empty.");
    }

    public static String a(String str) {
        String name = new File(str).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf < 1 ? name : name.substring(0, iLastIndexOf);
    }

    public static String a(Uri uri) {
        String strA = a(uri, false);
        if (strA == null) {
            return null;
        }
        String strA2 = a(strA);
        if (strA2.isEmpty()) {
            return null;
        }
        return strA2;
    }

    public static String a(Uri uri, boolean z) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null || lastPathSegment.isEmpty()) {
            return null;
        }
        String name = new File(lastPathSegment).getName();
        if (z) {
            String strA = a(lastPathSegment);
            String strSubstring = name.substring(strA.length() + 1);
            int iIndexOf = strSubstring.indexOf(95) + 1;
            if (iIndexOf > 0 && strSubstring.length() - iIndexOf == 40) {
                return name.substring(0, strA.length() + iIndexOf);
            }
        }
        return name;
    }

    public static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[65535];
        long j = 0;
        while (true) {
            int i = inputStream.read(bArr);
            if (i < 0) {
                return j;
            }
            outputStream.write(bArr, 0, i);
            j += (long) i;
        }
    }

    public static void a(DataProvider dataProvider, OutputStream outputStream) throws IOException {
        long size = dataProvider.getSize();
        for (long j = 0; j < size; j += WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            int iMin = (int) Math.min(WebSocketProtocol.PAYLOAD_SHORT_MAX, size - j);
            outputStream.write(dataProvider.read(iMin, j), 0, iMin);
        }
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(102400);
        byte[] bArr = new byte[65535];
        while (true) {
            int i = inputStream.read(bArr);
            if (i >= 0) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static void a(Context context, boolean z, List<Uri> list) {
        if (list == null || list.isEmpty() || context == null || context.getContentResolver() == null) {
            return;
        }
        int i = z ? 3 : 1;
        ContentResolver contentResolver = context.getContentResolver();
        for (Uri uri : list) {
            if (uri != null) {
                try {
                    contentResolver.takePersistableUriPermission(uri, i);
                } catch (SecurityException unused) {
                    PdfLog.d("Nutri.FileUtils", "Ignoring failed `takePersistableUriPermission` for file " + uri, new Object[0]);
                }
            }
        }
    }
}
