package external.sdk.pendo.io.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes4.dex */
public final class MediaStoreFileLoader implements b<Uri, File> {
    private final Context context;

    public static final class Factory implements sdk.pendo.io.l.d<Uri, File> {
        private final Context context;

        public Factory(Context context) {
            this.context = context;
        }

        @Override // sdk.pendo.io.l.d
        public b<Uri, File> build(e eVar) {
            return new MediaStoreFileLoader(this.context);
        }

        public void teardown() {
        }
    }

    private static class a implements external.sdk.pendo.io.glide.load.data.a<File> {
        private static final String[] c = {"_data"};
        private final Context a;
        private final Uri b;

        a(Context context, Uri uri) {
            this.a = context;
            this.b = uri;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<File> getDataClass() {
            return File.class;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.e.a getDataSource() {
            return sdk.pendo.io.e.a.LOCAL;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.c.b bVar, external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<? super File> interfaceC0307a) {
            Cursor cursorQuery = MAMContentResolverManagement.query(this.a.getContentResolver(), this.b, c, null, null, null);
            String string = null;
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (TextUtils.isEmpty(string)) {
                interfaceC0307a.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.b));
            } else {
                interfaceC0307a.a(new File(string));
            }
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.context = context;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public b.a<File> buildLoadData(Uri uri, int i, int i2, Options options) {
        return new b.a<>(new ObjectKey(uri), new a(this.context, uri));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Uri uri) {
        return sdk.pendo.io.g.a.c(uri);
    }
}
