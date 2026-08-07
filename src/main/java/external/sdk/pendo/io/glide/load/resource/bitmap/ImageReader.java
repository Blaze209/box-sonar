package external.sdk.pendo.io.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.data.InputStreamRewinder;
import external.sdk.pendo.io.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import sdk.pendo.io.y.k;

/* JADX INFO: loaded from: classes4.dex */
interface ImageReader {

    public static final class ByteArrayReader implements ImageReader {
        private final sdk.pendo.io.i.a byteArrayPool;
        private final byte[] bytes;
        private final List<ImageHeaderParser> parsers;

        ByteArrayReader(byte[] bArr, List<ImageHeaderParser> list, sdk.pendo.io.i.a aVar) {
            this.bytes = bArr;
            this.parsers = list;
            this.byteArrayPool = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options options) {
            return d.a(this.bytes, options, this);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() {
            return external.sdk.pendo.io.glide.load.a.a(this.parsers, ByteBuffer.wrap(this.bytes), this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() {
            return external.sdk.pendo.io.glide.load.a.a(this.parsers, ByteBuffer.wrap(this.bytes));
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public boolean hasJpegMpf() {
            return external.sdk.pendo.io.glide.load.a.b(this.parsers, ByteBuffer.wrap(this.bytes), this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }
    }

    public static final class ByteBufferReader implements ImageReader {
        private final ByteBuffer buffer;
        private final sdk.pendo.io.i.a byteArrayPool;
        private final List<ImageHeaderParser> parsers;

        ByteBufferReader(ByteBuffer byteBuffer, List<ImageHeaderParser> list, sdk.pendo.io.i.a aVar) {
            this.buffer = byteBuffer;
            this.parsers = list;
            this.byteArrayPool = aVar;
        }

        private InputStream stream() {
            return sdk.pendo.io.y.a.d(sdk.pendo.io.y.a.b(this.buffer));
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options options) {
            return d.a(stream(), options, this);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() {
            return external.sdk.pendo.io.glide.load.a.a(this.parsers, sdk.pendo.io.y.a.b(this.buffer), this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() {
            return external.sdk.pendo.io.glide.load.a.a(this.parsers, sdk.pendo.io.y.a.b(this.buffer));
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public boolean hasJpegMpf() {
            return external.sdk.pendo.io.glide.load.a.b(this.parsers, sdk.pendo.io.y.a.b(this.buffer), this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }
    }

    public static final class FileReader implements ImageReader {
        private final sdk.pendo.io.i.a byteArrayPool;
        private final File file;
        private final List<ImageHeaderParser> parsers;

        FileReader(File file, List<ImageHeaderParser> list, sdk.pendo.io.i.a aVar) {
            this.file = file;
            this.parsers = list;
            this.byteArrayPool = aVar;
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options options) throws Throwable {
            sdk.pendo.io.n.a aVar;
            try {
                aVar = new sdk.pendo.io.n.a(new FileInputStream(this.file), this.byteArrayPool);
                try {
                    Bitmap bitmapA = d.a(aVar, options, this);
                    try {
                        aVar.close();
                    } catch (IOException unused) {
                    }
                    return bitmapA;
                } catch (Throwable th) {
                    th = th;
                    if (aVar != null) {
                        try {
                            aVar.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
            }
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() throws Throwable {
            sdk.pendo.io.n.a aVar;
            try {
                aVar = new sdk.pendo.io.n.a(new FileInputStream(this.file), this.byteArrayPool);
                try {
                    int iA = external.sdk.pendo.io.glide.load.a.a(this.parsers, aVar, this.byteArrayPool);
                    try {
                        aVar.close();
                    } catch (IOException unused) {
                    }
                    return iA;
                } catch (Throwable th) {
                    th = th;
                    if (aVar != null) {
                        try {
                            aVar.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
            }
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() throws Throwable {
            sdk.pendo.io.n.a aVar;
            try {
                aVar = new sdk.pendo.io.n.a(new FileInputStream(this.file), this.byteArrayPool);
                try {
                    ImageHeaderParser.ImageType imageTypeB = external.sdk.pendo.io.glide.load.a.b(this.parsers, aVar, this.byteArrayPool);
                    try {
                        aVar.close();
                    } catch (IOException unused) {
                    }
                    return imageTypeB;
                } catch (Throwable th) {
                    th = th;
                    if (aVar != null) {
                        try {
                            aVar.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                aVar = null;
            }
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public boolean hasJpegMpf() throws Throwable {
            FileInputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(this.file);
                try {
                    boolean zC = external.sdk.pendo.io.glide.load.a.c(this.parsers, fileInputStream, this.byteArrayPool);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused) {
                    }
                    return zC;
                } catch (Throwable th) {
                    th = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }
    }

    public static final class InputStreamImageReader implements ImageReader {
        private final sdk.pendo.io.i.a byteArrayPool;
        private final InputStreamRewinder dataRewinder;
        private final List<ImageHeaderParser> parsers;

        InputStreamImageReader(InputStream inputStream, List<ImageHeaderParser> list, sdk.pendo.io.i.a aVar) {
            this.byteArrayPool = (sdk.pendo.io.i.a) k.a(aVar);
            this.parsers = (List) k.a(list);
            this.dataRewinder = new InputStreamRewinder(inputStream, aVar);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options options) {
            return d.a(this.dataRewinder.rewindAndGet(), options, this);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() {
            return external.sdk.pendo.io.glide.load.a.a(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() {
            return external.sdk.pendo.io.glide.load.a.b(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public boolean hasJpegMpf() {
            return external.sdk.pendo.io.glide.load.a.c(this.parsers, this.dataRewinder.rewindAndGet(), this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
            this.dataRewinder.fixMarkLimits();
        }
    }

    public static final class ParcelFileDescriptorImageReader implements ImageReader {
        private final sdk.pendo.io.i.a byteArrayPool;
        private final ParcelFileDescriptorRewinder dataRewinder;
        private final List<ImageHeaderParser> parsers;

        ParcelFileDescriptorImageReader(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, sdk.pendo.io.i.a aVar) {
            this.byteArrayPool = (sdk.pendo.io.i.a) k.a(aVar);
            this.parsers = (List) k.a(list);
            this.dataRewinder = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public Bitmap decodeBitmap(BitmapFactory.Options options) {
            return d.a(this.dataRewinder.rewindAndGet().getFileDescriptor(), options, this);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public int getImageOrientation() {
            return external.sdk.pendo.io.glide.load.a.a(this.parsers, this.dataRewinder, this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public ImageHeaderParser.ImageType getImageType() {
            return external.sdk.pendo.io.glide.load.a.b(this.parsers, this.dataRewinder, this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public boolean hasJpegMpf() {
            return external.sdk.pendo.io.glide.load.a.c(this.parsers, this.dataRewinder, this.byteArrayPool);
        }

        @Override // external.sdk.pendo.io.glide.load.resource.bitmap.ImageReader
        public void stopGrowingBuffers() {
        }
    }

    Bitmap decodeBitmap(BitmapFactory.Options options);

    int getImageOrientation();

    ImageHeaderParser.ImageType getImageType();

    boolean hasJpegMpf();

    void stopGrowingBuffers();
}
