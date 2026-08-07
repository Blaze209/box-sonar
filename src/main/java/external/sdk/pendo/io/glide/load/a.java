package external.sdk.pendo.io.glide.load;

import external.sdk.pendo.io.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: external.sdk.pendo.io.glide.load.a$a, reason: collision with other inner class name */
    class C0306a implements l {
        final /* synthetic */ InputStream a;

        C0306a(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // external.sdk.pendo.io.glide.load.a.l
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.getType(this.a);
            } finally {
                this.a.reset();
            }
        }
    }

    class b implements l {
        final /* synthetic */ ByteBuffer a;

        b(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }

        @Override // external.sdk.pendo.io.glide.load.a.l
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.getType(this.a);
            } finally {
                sdk.pendo.io.y.a.b(this.a);
            }
        }
    }

    class c implements l {
        final /* synthetic */ ParcelFileDescriptorRewinder a;
        final /* synthetic */ sdk.pendo.io.i.a b;

        c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, sdk.pendo.io.i.a aVar) {
            this.a = parcelFileDescriptorRewinder;
            this.b = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.a.l
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
            sdk.pendo.io.n.a aVar;
            try {
                aVar = new sdk.pendo.io.n.a(new FileInputStream(this.a.rewindAndGet().getFileDescriptor()), this.b);
                try {
                    ImageHeaderParser.ImageType type = imageHeaderParser.getType(aVar);
                    aVar.b();
                    this.a.rewindAndGet();
                    return type;
                } catch (Throwable th) {
                    th = th;
                    if (aVar != null) {
                        aVar.b();
                    }
                    this.a.rewindAndGet();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
            }
        }
    }

    class d implements k {
        final /* synthetic */ ByteBuffer a;
        final /* synthetic */ sdk.pendo.io.i.a b;

        d(ByteBuffer byteBuffer, sdk.pendo.io.i.a aVar) {
            this.a = byteBuffer;
            this.b = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.a.k
        public int a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.getOrientation(this.a, this.b);
            } finally {
                sdk.pendo.io.y.a.b(this.a);
            }
        }
    }

    class e implements k {
        final /* synthetic */ InputStream a;
        final /* synthetic */ sdk.pendo.io.i.a b;

        e(InputStream inputStream, sdk.pendo.io.i.a aVar) {
            this.a = inputStream;
            this.b = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.a.k
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.getOrientation(this.a, this.b);
            } finally {
                this.a.reset();
            }
        }
    }

    class f implements k {
        final /* synthetic */ ParcelFileDescriptorRewinder a;
        final /* synthetic */ sdk.pendo.io.i.a b;

        f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, sdk.pendo.io.i.a aVar) {
            this.a = parcelFileDescriptorRewinder;
            this.b = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.a.k
        public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
            sdk.pendo.io.n.a aVar;
            try {
                aVar = new sdk.pendo.io.n.a(new FileInputStream(this.a.rewindAndGet().getFileDescriptor()), this.b);
                try {
                    int orientation = imageHeaderParser.getOrientation(aVar, this.b);
                    aVar.b();
                    this.a.rewindAndGet();
                    return orientation;
                } catch (Throwable th) {
                    th = th;
                    if (aVar != null) {
                        aVar.b();
                    }
                    this.a.rewindAndGet();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
            }
        }
    }

    class g implements j {
        final /* synthetic */ ByteBuffer a;
        final /* synthetic */ sdk.pendo.io.i.a b;

        g(ByteBuffer byteBuffer, sdk.pendo.io.i.a aVar) {
            this.a = byteBuffer;
            this.b = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.a.j
        public boolean a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.hasJpegMpf(this.a, this.b);
            } finally {
                sdk.pendo.io.y.a.b(this.a);
            }
        }
    }

    class h implements j {
        final /* synthetic */ InputStream a;
        final /* synthetic */ sdk.pendo.io.i.a b;

        h(InputStream inputStream, sdk.pendo.io.i.a aVar) {
            this.a = inputStream;
            this.b = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.a.j
        public boolean a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.hasJpegMpf(this.a, this.b);
            } finally {
                this.a.reset();
            }
        }
    }

    class i implements j {
        final /* synthetic */ ParcelFileDescriptorRewinder a;
        final /* synthetic */ sdk.pendo.io.i.a b;

        i(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, sdk.pendo.io.i.a aVar) {
            this.a = parcelFileDescriptorRewinder;
            this.b = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.a.j
        public boolean a(ImageHeaderParser imageHeaderParser) throws Throwable {
            sdk.pendo.io.n.a aVar;
            try {
                aVar = new sdk.pendo.io.n.a(new FileInputStream(this.a.rewindAndGet().getFileDescriptor()), this.b);
                try {
                    boolean zHasJpegMpf = imageHeaderParser.hasJpegMpf(aVar, this.b);
                    aVar.b();
                    this.a.rewindAndGet();
                    return zHasJpegMpf;
                } catch (Throwable th) {
                    th = th;
                    if (aVar != null) {
                        aVar.b();
                    }
                    this.a.rewindAndGet();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
            }
        }
    }

    private interface j {
        boolean a(ImageHeaderParser imageHeaderParser);
    }

    private interface k {
        int a(ImageHeaderParser imageHeaderParser);
    }

    private interface l {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    public static int a(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, sdk.pendo.io.i.a aVar) {
        return a(list, new f(parcelFileDescriptorRewinder, aVar));
    }

    public static ImageHeaderParser.ImageType b(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, sdk.pendo.io.i.a aVar) {
        return a(list, new c(parcelFileDescriptorRewinder, aVar));
    }

    public static boolean c(List<ImageHeaderParser> list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, sdk.pendo.io.i.a aVar) {
        return a(list, new i(parcelFileDescriptorRewinder, aVar));
    }

    public static int a(List<ImageHeaderParser> list, InputStream inputStream, sdk.pendo.io.i.a aVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new sdk.pendo.io.n.a(inputStream, aVar);
        }
        inputStream.mark(5242880);
        return a(list, new e(inputStream, aVar));
    }

    public static ImageHeaderParser.ImageType b(List<ImageHeaderParser> list, InputStream inputStream, sdk.pendo.io.i.a aVar) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new sdk.pendo.io.n.a(inputStream, aVar);
        }
        inputStream.mark(5242880);
        return a(list, new C0306a(inputStream));
    }

    public static boolean c(List<ImageHeaderParser> list, InputStream inputStream, sdk.pendo.io.i.a aVar) {
        if (inputStream == null) {
            return false;
        }
        if (!inputStream.markSupported()) {
            inputStream = new sdk.pendo.io.n.a(inputStream, aVar);
        }
        inputStream.mark(5242880);
        return a(list, new h(inputStream, aVar));
    }

    public static int a(List<ImageHeaderParser> list, ByteBuffer byteBuffer, sdk.pendo.io.i.a aVar) {
        if (byteBuffer == null) {
            return -1;
        }
        return a(list, new d(byteBuffer, aVar));
    }

    public static boolean b(List<ImageHeaderParser> list, ByteBuffer byteBuffer, sdk.pendo.io.i.a aVar) {
        if (byteBuffer == null) {
            return false;
        }
        return a(list, new g(byteBuffer, aVar));
    }

    private static int a(List<ImageHeaderParser> list, k kVar) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iA = kVar.a(list.get(i2));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, ByteBuffer byteBuffer) {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : a(list, new b(byteBuffer));
    }

    private static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, l lVar) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType imageTypeA = lVar.a(list.get(i2));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    private static boolean a(List<ImageHeaderParser> list, j jVar) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (jVar.a(list.get(i2))) {
                return true;
            }
        }
        return false;
    }
}
