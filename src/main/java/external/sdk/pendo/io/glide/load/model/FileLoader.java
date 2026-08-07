package external.sdk.pendo.io.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public class FileLoader<Data> implements external.sdk.pendo.io.glide.load.model.b<File, Data> {
    private static final String TAG = "FileLoader";
    private final b<Data> fileOpener;

    public static class Factory<Data> implements sdk.pendo.io.l.d<File, Data> {
        private final b<Data> opener;

        public Factory(b<Data> bVar) {
            this.opener = bVar;
        }

        @Override // sdk.pendo.io.l.d
        public final external.sdk.pendo.io.glide.load.model.b<File, Data> build(e eVar) {
            return new FileLoader(this.opener);
        }

        public final void teardown() {
        }
    }

    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {

        class a implements b<ParcelFileDescriptor> {
            a() {
            }

            @Override // external.sdk.pendo.io.glide.load.model.FileLoader.b
            public void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // external.sdk.pendo.io.glide.load.model.FileLoader.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor a(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            @Override // external.sdk.pendo.io.glide.load.model.FileLoader.b
            public Class<ParcelFileDescriptor> getDataClass() {
                return ParcelFileDescriptor.class;
            }
        }

        public FileDescriptorFactory() {
            super(new a());
        }
    }

    public static class StreamFactory extends Factory<InputStream> {

        class a implements b<InputStream> {
            a() {
            }

            @Override // external.sdk.pendo.io.glide.load.model.FileLoader.b
            public void a(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // external.sdk.pendo.io.glide.load.model.FileLoader.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public InputStream a(File file) {
                return new FileInputStream(file);
            }

            @Override // external.sdk.pendo.io.glide.load.model.FileLoader.b
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        public StreamFactory() {
            super(new a());
        }
    }

    private static final class a<Data> implements external.sdk.pendo.io.glide.load.data.a<Data> {
        private final File a;
        private final b<Data> b;
        private Data c;

        a(File file, b<Data> bVar) {
            this.a = file;
            this.b = bVar;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
            Data data = this.c;
            if (data != null) {
                try {
                    this.b.a(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<Data> getDataClass() {
            return this.b.getDataClass();
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.e.a getDataSource() {
            return sdk.pendo.io.e.a.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v5, types: [Data, java.lang.Object] */
        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.c.b bVar, external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<? super Data> interfaceC0307a) {
            try {
                Data dataA = this.b.a(this.a);
                this.c = dataA;
                interfaceC0307a.a(dataA);
            } catch (FileNotFoundException e) {
                if (Log.isLoggable(FileLoader.TAG, 3)) {
                    Log.d(FileLoader.TAG, "Failed to open file", e);
                }
                interfaceC0307a.a((Exception) e);
            }
        }
    }

    public interface b<Data> {
        Data a(File file);

        void a(Data data);

        Class<Data> getDataClass();
    }

    public FileLoader(b<Data> bVar) {
        this.fileOpener = bVar;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public external.sdk.pendo.io.glide.load.model.b.a<Data> buildLoadData(File file, int i, int i2, Options options) {
        return new external.sdk.pendo.io.glide.load.model.b.a<>(new ObjectKey(file), new a(file, this.fileOpener));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(File file) {
        return true;
    }
}
