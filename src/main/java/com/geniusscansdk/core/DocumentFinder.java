package com.geniusscansdk.core;

import android.content.Context;
import android.graphics.Bitmap;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DocumentFinder.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0003\u001b\u001c\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0014J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0010J\u0011\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0012H\u0082 J\u0011\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\tH\u0082 J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0082 J\u0019\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0010H\u0082 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/geniusscansdk/core/DocumentFinder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "modelBuffer", "Ljava/nio/MappedByteBuffer;", "nativeHandle", "", "finalize", "", "findDocumentInImage", "Lcom/geniusscansdk/core/DocumentFinder$Result;", "image", "Ljava/io/File;", "Landroid/graphics/Bitmap;", "createFinder", "Ljava/nio/ByteBuffer;", "deleteFinder", "handle", "findDocumentFromFile", "Lcom/geniusscansdk/core/DocumentFinder$ImageType;", "path", "", "findDocumentFromBitmap", "bitmap", "ImageType", "Result", "Companion", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentFinder {
    private static final Companion Companion = new Companion(null);
    private final MappedByteBuffer modelBuffer;
    private final long nativeHandle;

    /* JADX INFO: compiled from: DocumentFinder.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/geniusscansdk/core/DocumentFinder$ImageType;", "", "<init>", "(Ljava/lang/String;I)V", "NoDocument", "Unwarped", "Warped", "Enhanced", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum ImageType {
        NoDocument,
        Unwarped,
        Warped,
        Enhanced;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<ImageType> getEntries() {
            return $ENTRIES;
        }
    }

    private final native long createFinder(ByteBuffer modelBuffer);

    private final native void deleteFinder(long handle);

    private final native ImageType findDocumentFromBitmap(long handle, Bitmap bitmap) throws LicenseException, ProcessingException;

    private final native ImageType findDocumentFromFile(long handle, String path) throws LicenseException, ProcessingException;

    public DocumentFinder(Context context) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        MappedByteBuffer mappedByteBufferLoad = ModelLoader.load(context, "documentFinder.png");
        this.modelBuffer = mappedByteBufferLoad;
        this.nativeHandle = createFinder(mappedByteBufferLoad);
    }

    /* JADX INFO: compiled from: DocumentFinder.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/geniusscansdk/core/DocumentFinder$Result;", "", "imageType", "Lcom/geniusscansdk/core/DocumentFinder$ImageType;", "<init>", "(Lcom/geniusscansdk/core/DocumentFinder$ImageType;)V", "getImageType", "()Lcom/geniusscansdk/core/DocumentFinder$ImageType;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Result {
        private final ImageType imageType;

        public static /* synthetic */ Result copy$default(Result result, ImageType imageType, int i, Object obj) {
            if ((i & 1) != 0) {
                imageType = result.imageType;
            }
            return result.copy(imageType);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ImageType getImageType() {
            return this.imageType;
        }

        public final Result copy(ImageType imageType) {
            Intrinsics.checkNotNullParameter(imageType, "imageType");
            return new Result(imageType);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Result) && this.imageType == ((Result) other).imageType;
        }

        public int hashCode() {
            return this.imageType.hashCode();
        }

        public String toString() {
            return "Result(imageType=" + this.imageType + ")";
        }

        public Result(ImageType imageType) {
            Intrinsics.checkNotNullParameter(imageType, "imageType");
            this.imageType = imageType;
        }

        public final ImageType getImageType() {
            return this.imageType;
        }
    }

    protected void finalize() {
        deleteFinder(this.nativeHandle);
    }

    public final Result findDocumentInImage(File image) throws LicenseException, ProcessingException {
        Intrinsics.checkNotNullParameter(image, "image");
        long j = this.nativeHandle;
        String absolutePath = image.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
        return new Result(findDocumentFromFile(j, absolutePath));
    }

    public final Result findDocumentInImage(Bitmap image) throws LicenseException, ProcessingException {
        Intrinsics.checkNotNullParameter(image, "image");
        return new Result(findDocumentFromBitmap(this.nativeHandle, image));
    }

    /* JADX INFO: compiled from: DocumentFinder.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/geniusscansdk/core/DocumentFinder$Companion;", "", "<init>", "()V", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        System.loadLibrary("gssdk-core");
    }
}
