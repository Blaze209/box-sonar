package external.sdk.pendo.io.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.resource.drawable.ResourceDrawableDecoder;
import external.sdk.pendo.io.glide.signature.ObjectKey;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes4.dex */
public final class DirectResourceLoader<DataT> implements external.sdk.pendo.io.glide.load.model.b<Integer, DataT> {
    private final Context context;
    private final e<DataT> resourceOpener;

    private static final class a implements sdk.pendo.io.l.d<Integer, AssetFileDescriptor>, e<AssetFileDescriptor> {
        private final Context a;

        a(Context context) {
            this.a = context;
        }

        @Override // external.sdk.pendo.io.glide.load.model.DirectResourceLoader.e
        public void a(AssetFileDescriptor assetFileDescriptor) throws IOException {
            assetFileDescriptor.close();
        }

        @Override // external.sdk.pendo.io.glide.load.model.DirectResourceLoader.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public AssetFileDescriptor a(Resources.Theme theme, Resources resources, int i) {
            return resources.openRawResourceFd(i);
        }

        @Override // sdk.pendo.io.l.d
        public external.sdk.pendo.io.glide.load.model.b<Integer, AssetFileDescriptor> build(external.sdk.pendo.io.glide.load.model.e eVar) {
            return new DirectResourceLoader(this.a, this);
        }

        @Override // external.sdk.pendo.io.glide.load.model.DirectResourceLoader.e
        public Class<AssetFileDescriptor> getDataClass() {
            return AssetFileDescriptor.class;
        }
    }

    private static final class b implements sdk.pendo.io.l.d<Integer, Drawable>, e<Drawable> {
        private final Context a;

        b(Context context) {
            this.a = context;
        }

        @Override // external.sdk.pendo.io.glide.load.model.DirectResourceLoader.e
        public void a(Drawable drawable) {
        }

        @Override // external.sdk.pendo.io.glide.load.model.DirectResourceLoader.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Drawable a(Resources.Theme theme, Resources resources, int i) {
            return sdk.pendo.io.o.b.a(this.a, i, theme);
        }

        @Override // sdk.pendo.io.l.d
        public external.sdk.pendo.io.glide.load.model.b<Integer, Drawable> build(external.sdk.pendo.io.glide.load.model.e eVar) {
            return new DirectResourceLoader(this.a, this);
        }

        @Override // external.sdk.pendo.io.glide.load.model.DirectResourceLoader.e
        public Class<Drawable> getDataClass() {
            return Drawable.class;
        }
    }

    private static final class c implements sdk.pendo.io.l.d<Integer, InputStream>, e<InputStream> {
        private final Context a;

        c(Context context) {
            this.a = context;
        }

        @Override // external.sdk.pendo.io.glide.load.model.DirectResourceLoader.e
        public void a(InputStream inputStream) throws IOException {
            inputStream.close();
        }

        @Override // external.sdk.pendo.io.glide.load.model.DirectResourceLoader.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public InputStream a(Resources.Theme theme, Resources resources, int i) {
            return resources.openRawResource(i);
        }

        @Override // sdk.pendo.io.l.d
        public external.sdk.pendo.io.glide.load.model.b<Integer, InputStream> build(external.sdk.pendo.io.glide.load.model.e eVar) {
            return new DirectResourceLoader(this.a, this);
        }

        @Override // external.sdk.pendo.io.glide.load.model.DirectResourceLoader.e
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }
    }

    private static final class d<DataT> implements external.sdk.pendo.io.glide.load.data.a<DataT> {
        private final Resources.Theme a;
        private final Resources b;
        private final e<DataT> c;
        private final int d;
        private DataT e;

        d(Resources.Theme theme, Resources resources, e<DataT> eVar, int i) {
            this.a = theme;
            this.b = resources;
            this.c = eVar;
            this.d = i;
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cancel() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public void cleanup() {
            DataT datat = this.e;
            if (datat != null) {
                try {
                    this.c.a(datat);
                } catch (IOException unused) {
                }
            }
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public Class<DataT> getDataClass() {
            return this.c.getDataClass();
        }

        @Override // external.sdk.pendo.io.glide.load.data.a
        public sdk.pendo.io.e.a getDataSource() {
            return sdk.pendo.io.e.a.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [DataT, java.lang.Object] */
        @Override // external.sdk.pendo.io.glide.load.data.a
        public void loadData(sdk.pendo.io.c.b bVar, external.sdk.pendo.io.glide.load.data.a.InterfaceC0307a<? super DataT> interfaceC0307a) {
            try {
                DataT datatA = this.c.a(this.a, this.b, this.d);
                this.e = datatA;
                interfaceC0307a.a(datatA);
            } catch (Resources.NotFoundException e) {
                interfaceC0307a.a((Exception) e);
            }
        }
    }

    private interface e<DataT> {
        DataT a(Resources.Theme theme, Resources resources, int i);

        void a(DataT datat);

        Class<DataT> getDataClass();
    }

    DirectResourceLoader(Context context, e<DataT> eVar) {
        this.context = context.getApplicationContext();
        this.resourceOpener = eVar;
    }

    public static sdk.pendo.io.l.d<Integer, AssetFileDescriptor> assetFileDescriptorFactory(Context context) {
        return new a(context);
    }

    public static sdk.pendo.io.l.d<Integer, Drawable> drawableFactory(Context context) {
        return new b(context);
    }

    public static sdk.pendo.io.l.d<Integer, InputStream> inputStreamFactory(Context context) {
        return new c(context);
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public external.sdk.pendo.io.glide.load.model.b.a<DataT> buildLoadData(Integer num, int i, int i2, Options options) {
        Resources.Theme theme = (Resources.Theme) options.get(ResourceDrawableDecoder.THEME);
        return new external.sdk.pendo.io.glide.load.model.b.a<>(new ObjectKey(num), new d(theme, theme != null ? theme.getResources() : this.context.getResources(), this.resourceOpener, num.intValue()));
    }

    @Override // external.sdk.pendo.io.glide.load.model.b
    public boolean handles(Integer num) {
        return true;
    }
}
