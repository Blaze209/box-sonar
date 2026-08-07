package external.sdk.pendo.io.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
class c {
    private static final a f = new a();
    private final a a;
    private final b b;
    private final sdk.pendo.io.i.a c;
    private final ContentResolver d;
    private final List<ImageHeaderParser> e;

    c(List<ImageHeaderParser> list, a aVar, b bVar, sdk.pendo.io.i.a aVar2, ContentResolver contentResolver) {
        this.a = aVar;
        this.b = bVar;
        this.c = aVar2;
        this.d = contentResolver;
        this.e = list;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004a  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private String b(Uri uri) throws Throwable {
        Cursor cursorA;
        ?? r2 = 0;
        try {
            try {
                cursorA = this.b.a(uri);
                if (cursorA != null) {
                    try {
                        if (cursorA.moveToFirst()) {
                            String string = cursorA.getString(0);
                            cursorA.close();
                            return string;
                        }
                    } catch (SecurityException e) {
                        e = e;
                        if (Log.isLoggable("ThumbStreamOpener", 3)) {
                            Log.d("ThumbStreamOpener", "Failed to query for thumbnail for Uri: " + uri, e);
                        }
                        if (cursorA != null) {
                            cursorA.close();
                        }
                        return null;
                    }
                }
                if (cursorA != null) {
                    cursorA.close();
                }
                return null;
            } catch (Throwable th) {
                th = th;
                r2 = this;
                if (r2 != 0) {
                    r2.close();
                }
                throw th;
            }
        } catch (SecurityException e2) {
            e = e2;
            cursorA = null;
        } catch (Throwable th2) {
            th = th2;
            if (r2 != 0) {
                r2.close();
            }
            throw th;
        }
    }

    int a(Uri uri) {
        InputStream inputStreamOpenInputStream = null;
        try {
            inputStreamOpenInputStream = MAMContentResolverManagement.openInputStream(this.d, uri);
            return external.sdk.pendo.io.glide.load.a.a(this.e, inputStreamOpenInputStream, this.c);
        } catch (IOException | NullPointerException e) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e);
            }
            if (inputStreamOpenInputStream == null) {
                return -1;
            }
            try {
                return -1;
            } catch (IOException unused) {
                return -1;
            }
        } finally {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException unused2) {
                }
            }
        }
    }

    public InputStream c(Uri uri) throws Throwable {
        String strB = b(uri);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        File fileA = this.a.a(strB);
        if (!a(fileA)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileA);
        try {
            return MAMContentResolverManagement.openInputStream(this.d, uriFromFile);
        } catch (NullPointerException e) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e));
        }
    }

    c(List<ImageHeaderParser> list, b bVar, sdk.pendo.io.i.a aVar, ContentResolver contentResolver) {
        this(list, f, bVar, aVar, contentResolver);
    }

    private boolean a(File file) {
        return this.a.a(file) && 0 < this.a.b(file);
    }
}
