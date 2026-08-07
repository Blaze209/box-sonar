package external.sdk.pendo.io.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.microsoft.intune.mam.client.content.MAMContentResolverManagement;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.model.e;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import sdk.pendo.io.l.d;

/* JADX INFO: loaded from: classes4.dex */
public final class QMediaStoreUriLoader<DataT> implements external.sdk.pendo.io.glide.load.model.b<Uri, DataT> {
    private final Context context;
    private final Class<DataT> dataClass;
    private final external.sdk.pendo.io.glide.load.model.b<File, DataT> fileDelegate;
    private final external.sdk.pendo.io.glide.load.model.b<Uri, DataT> uriDelegate;

    public static final class FileDescriptorFactory extends a<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    public static final class InputStreamFactory extends a<InputStream> {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    private static abstract class a<DataT> implements d<Uri, DataT> {
        private final Context context;
        private final Class<DataT> dataClass;

        a(Context context, Class<DataT> cls) {
            this.context = context;
            this.dataClass = cls;
        }

        @Override // sdk.pendo.io.l.d
        public final external.sdk.pendo.io.glide.load.model.b<Uri, DataT> build(e eVar) {
            return new QMediaStoreUriLoader(this.context, eVar.a(File.class, this.dataClass), eVar.a(Uri.class, this.dataClass), this.dataClass);
        }

        public final void teardown() {
        }
    }

    private static final class b<DataT> implements external.sdk.pendo.io.glide.load.data.a<DataT> {
        private static final String[] k = {"_data"};
        private final Context a;
        private final external.sdk.pendo.io.glide.load.model.b<File, DataT> b;
        private final external.sdk.pendo.io.glide.load.model.b<Uri, DataT> c;
        private final Uri d;
        private final int e;
        private final int f;
        private final Options g;
        private final Class<DataT> h;
        private volatile boolean i;
        private volatile external.sdk.pendo.io.glide.load.data.a<DataT> j;

        b(Context context, external.sdk.pendo.io.glide.load.model.b<File, DataT> bVar, external.sdk.pendo.io.glide.load.model.b<Uri, DataT> bVar2, Uri uri, int i, int i2, Options options, Class<DataT> cls) {
            this.a = context.getApplicationContext();
            this.b = bVar;
            this.c = bVar2;
            this.d = uri;
            this.e = i;
            this.f = i2;
            this.g = options;
            this.h = cls;
        }

        private external.sdk.pendo.io.glide.load.model.b.a<DataT> a() {
            if (Environment.isExternalStorageLegacy()) {
                return this.b.buildLoadData(a(this.d), this.e, this.f, this.g);
            }
            if (sdk.pendo.io.g.a.a(this.d)) {
                return this.c.buildLoadData(this.d, this.e, this.f, this.g);
            }
            return this.c.buildLoadData(c() ? MediaStore.setRequireOriginal(this.d) : this.d, this.e, this.f, this.g);
        }

        private external.sdk.pendo.io.glide.load.data.a<DataT> b() {
            external.sdk.pendo.io.glide.load.model.b.a<DataT> aVarA = a();
            if (aVarA != null) {
                return aVarA.c;
            }
            return null;
        }

        private boolean c() {
            return this.a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
            this.i = true;
            external.sdk.pendo.io.glide.load.data.a<DataT> aVar = this.j;
            if (aVar != null) {
                aVar.cancel();
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
            external.sdk.pendo.io.glide.load.data.a<DataT> aVar = this.j;
            if (aVar != null) {
                aVar.cleanup();
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<DataT> getDataClass() {
            return this.h;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.e.a getDataSource() {
            return sdk.pendo.io.e.a.LOCAL;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.c.b bVar, external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<? super DataT> interfaceC0307a) {
            try {
                external.sdk.pendo.io.glide.load.data.a<DataT> aVarB = b();
                if (aVarB == null) {
                    interfaceC0307a.a((Exception) new IllegalArgumentException("Failed to build fetcher for: " + this.d));
                    return;
                }
                this.j = aVarB;
                if (this.i) {
                    cancel();
                } else {
                    aVarB.loadData(bVar, interfaceC0307a);
                }
            } catch (FileNotFoundException e) {
                interfaceC0307a.a((Exception) e);
            }
        }

        private File a(Uri uri) {
            Cursor cursor = null;
            try {
                Cursor cursorQuery = MAMContentResolverManagement.query(this.a.getContentResolver(), uri, k, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                if (TextUtils.isEmpty(string)) {
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                File file = new File(string);
                cursorQuery.close();
                return file;
            } catch (Throwable th) {
                if (0 == 0) {
                    throw th;
                }
                cursor.close();
                throw th;
            }
        }
    }

    QMediaStoreUriLoader(Context context, external.sdk.pendo.io.glide.load.model.b<File, DataT> bVar, external.sdk.pendo.io.glide.load.model.b<Uri, DataT> bVar2, Class<DataT> cls) {
        this.context = context.getApplicationContext();
        this.fileDelegate = bVar;
        this.uriDelegate = bVar2;
        this.dataClass = cls;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public external.sdk.pendo.io.glide.load.model.b.a<DataT> buildLoadData(Uri uri, int i, int i2, Options options) {
        return new external.sdk.pendo.io.glide.load.model.b.a<>(new ObjectKey(uri), new b(this.context, this.fileDelegate, this.uriDelegate, uri, i, i2, options, this.dataClass));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Uri uri) {
        return sdk.pendo.io.g.a.c(uri);
    }
}
