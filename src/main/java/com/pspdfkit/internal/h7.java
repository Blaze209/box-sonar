package com.pspdfkit.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class h7 extends FileProvider {
    private static final String COLUMN_DATA = "_data";
    private static final String PROVIDER_SCHEME = "content";
    private final a strategy;

    public interface a {
        String getAuthority(Context context);

        Map<String, File> getDirectories(Context context);
    }

    public h7(a aVar) {
        this.strategy = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0078  */
    /* JADX WARN: Code duplicated, block: B:19:0x007e  */
    public static File getFile(Context context, a aVar, Uri uri) throws FileNotFoundException {
        File value;
        if (!uri.getScheme().equals("content")) {
            throw new FileNotFoundException(uri + " has invalid scheme, expected: \"content\"");
        }
        if (!aVar.getAuthority(context).equals(uri.getAuthority())) {
            throw new FileNotFoundException(uri + " has invalid authority, expected: \"" + aVar.getAuthority(context) + "\"");
        }
        String path = uri.getPath();
        if (path == null) {
            throw new FileNotFoundException(uri + " has empty path.");
        }
        try {
            String canonicalPath = new File(path).getCanonicalPath();
            for (Map.Entry<String, File> entry : aVar.getDirectories(context).entrySet()) {
                if (canonicalPath.startsWith("/" + entry.getKey())) {
                    value = entry.getValue();
                    canonicalPath = canonicalPath.substring(entry.getKey().length() + 1);
                    if (value != null) {
                        return new File(value, canonicalPath);
                    }
                    throw new FileNotFoundException(uri + " has invalid path.");
                }
            }
            value = null;
            if (value != null) {
                return new File(value, canonicalPath);
            }
            throw new FileNotFoundException(uri + " has invalid path.");
        } catch (IOException unused) {
            throw new FileNotFoundException(uri + " has invalid path.");
        }
    }

    private File getFileOrNull(Context context, a aVar, Uri uri) {
        try {
            return getFile(context, aVar, uri);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    private static String getRelativePath(File file, File file2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(file2.getName());
        File parentFile = file2.getParentFile();
        while (parentFile != null && !file.equals(parentFile)) {
            arrayList.add(parentFile.getName());
            parentFile = file2.getParentFile();
        }
        StringBuilder sb = new StringBuilder();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            sb.append((String) arrayList.get(size));
            if (size != 0) {
                sb.append(File.pathSeparator);
            }
        }
        return sb.toString();
    }

    public static Uri getUriForFile(Context context, a aVar, File file) {
        Map.Entry<String, File> next;
        try {
            File canonicalFile = file.getCanonicalFile();
            Iterator<Map.Entry<String, File>> it = aVar.getDirectories(context).entrySet().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!isInDirectory(next.getValue().getCanonicalFile(), canonicalFile));
            if (next == null) {
                throw new IllegalArgumentException("Trying to share file \"" + file.getAbsolutePath() + "\". For security reasons, only files from provider directories may be shared.");
            }
            return new Uri.Builder().scheme("content").authority(aVar.getAuthority(context)).path(next.getKey()).appendPath(getRelativePath(next.getValue().getCanonicalFile(), canonicalFile)).build();
        } catch (IOException e) {
            throw new IllegalArgumentException("Couldn't resolve canonical filepath for " + file.getAbsoluteFile() + "!", e);
        }
    }

    private static boolean isInDirectory(File file, File file2) {
        for (File parentFile = file2.getParentFile(); parentFile != null; parentFile = parentFile.getParentFile()) {
            if (file.equals(parentFile)) {
                return true;
            }
        }
        return false;
    }

    public static int parseMode(String str) {
        if ("r".equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        return "rwt".equals(str) ? 1006632960 : 0;
    }

    @Override // androidx.core.content.FileProvider, com.microsoft.intune.mam.client.content.HookedContentProvider
    public int deleteMAM(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public String getType(Uri uri) {
        File fileOrNull;
        if (getContext() == null || (fileOrNull = getFileOrNull(getContext(), this.strategy, uri)) == null || !fileOrNull.exists()) {
            return null;
        }
        return MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(uri.toString()));
    }

    @Override // androidx.core.content.FileProvider, com.microsoft.intune.mam.client.content.HookedContentProvider
    public Uri insertMAM(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // androidx.core.content.FileProvider, com.microsoft.intune.mam.client.content.MAMContentProvider, com.microsoft.intune.mam.client.content.HookedContentProvider
    public ParcelFileDescriptor openFileMAM(Uri uri, String str) throws FileNotFoundException {
        if (getContext() == null) {
            throw new IllegalStateException("Context was null.");
        }
        try {
            return ParcelFileDescriptor.open(getFile(getContext(), this.strategy, uri), parseMode(str));
        } catch (IOException unused) {
            throw new FileNotFoundException(uri.toString() + " was not found.");
        }
    }

    @Override // androidx.core.content.FileProvider, com.microsoft.intune.mam.client.content.HookedContentProvider
    public Cursor queryMAM(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (getContext() == null) {
            throw new IllegalStateException("Context was null.");
        }
        File fileOrNull = getFileOrNull(getContext(), this.strategy, uri);
        if (fileOrNull == null || !fileOrNull.exists()) {
            return null;
        }
        if (strArr == null) {
            strArr = new String[]{"_display_name", "_size"};
        }
        Object[] objArr = new Object[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            String str3 = strArr[i];
            objArr[i] = "_display_name".equals(str3) ? fileOrNull.getName() : "_size".equals(str3) ? Long.valueOf(fileOrNull.length()) : null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr, 1);
        matrixCursor.addRow(objArr);
        return matrixCursor;
    }

    @Override // androidx.core.content.FileProvider, com.microsoft.intune.mam.client.content.HookedContentProvider
    public int updateMAM(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public static File getFile(Context context, a aVar, String str, Uri uri) throws FileNotFoundException {
        if (uri.getScheme().equals("content")) {
            if (aVar.getAuthority(context).equals(uri.getAuthority())) {
                String path = uri.getPath();
                if (path != null) {
                    File file = aVar.getDirectories(context).get(str);
                    if (path.startsWith("/" + str) && file != null) {
                        return new File(file, path.substring(str.length() + 1));
                    }
                    throw new FileNotFoundException(uri + " has invalid path.");
                }
                throw new FileNotFoundException(uri + " has empty path.");
            }
            throw new FileNotFoundException(uri + " has invalid authority, expected: \"" + aVar.getAuthority(context) + "\"");
        }
        throw new FileNotFoundException(uri + " has invalid scheme, expected: \"content\"");
    }
}
