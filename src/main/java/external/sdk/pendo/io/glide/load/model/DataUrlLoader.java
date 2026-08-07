package external.sdk.pendo.io.glide.load.model;

import android.util.Base64;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class DataUrlLoader<Model, Data> implements external.sdk.pendo.io.glide.load.model.b<Model, Data> {
    private static final String BASE64_TAG = ";base64";
    private static final String DATA_SCHEME_IMAGE = "data:image";
    private final a<Data> dataDecoder;

    public static final class StreamFactory<Model> implements sdk.pendo.io.l.d<Model, InputStream> {
        private final a<InputStream> opener = new a();

        class a implements a<InputStream> {
            a() {
            }

            @Override // external.sdk.pendo.io.glide.load.model.DataUrlLoader.a
            public void a(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // external.sdk.pendo.io.glide.load.model.DataUrlLoader.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public InputStream a(String str) {
                if (!str.startsWith(DataUrlLoader.DATA_SCHEME_IMAGE)) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(DataUrlLoader.BASE64_TAG)) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }

            @Override // external.sdk.pendo.io.glide.load.model.DataUrlLoader.a
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        @Override // sdk.pendo.io.l.d
        public external.sdk.pendo.io.glide.load.model.b<Model, InputStream> build(e eVar) {
            return new DataUrlLoader(this.opener);
        }

        public void teardown() {
        }
    }

    public interface a<Data> {
        Data a(String str);

        void a(Data data);

        Class<Data> getDataClass();
    }

    private static final class b<Data> implements external.sdk.pendo.io.glide.load.data.a<Data> {
        private final String a;
        private final a<Data> b;
        private Data c;

        b(String str, a<Data> aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
            try {
                this.b.a(this.c);
            } catch (IOException unused) {
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

        /* JADX WARN: Type inference failed for: r2v2, types: [Data, java.lang.Object] */
        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.c.b bVar, external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<? super Data> interfaceC0307a) {
            try {
                Data dataA = this.b.a(this.a);
                this.c = dataA;
                interfaceC0307a.a(dataA);
            } catch (IllegalArgumentException e) {
                interfaceC0307a.a((Exception) e);
            }
        }
    }

    public DataUrlLoader(a<Data> aVar) {
        this.dataDecoder = aVar;
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public external.sdk.pendo.io.glide.load.model.b.a<Data> buildLoadData(Model model, int i, int i2, Options options) {
        return new external.sdk.pendo.io.glide.load.model.b.a<>(new ObjectKey(model), new b(model.toString(), this.dataDecoder));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Model model) {
        return model.toString().startsWith(DATA_SCHEME_IMAGE);
    }
}
