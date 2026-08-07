package com.geniusscansdk.scanflow;

import android.content.Context;
import com.box.androidsdk.content.models.BoxFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ImageStore.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/geniusscansdk/scanflow/ImageStore;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "imageFolder", "Ljava/io/File;", "getImageFolder", "()Ljava/io/File;", "imageFolder$delegate", "Lkotlin/Lazy;", "generateImageFile", BoxFile.FIELD_EXTENSION, "", "getTemporaryPdfImageFile", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageStore {
    private final Context context;

    /* JADX INFO: renamed from: imageFolder$delegate, reason: from kotlin metadata */
    private final Lazy imageFolder;

    public ImageStore(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.imageFolder = LazyKt.lazy(new Function0() { // from class: com.geniusscansdk.scanflow.ImageStore$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ImageStore.imageFolder_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final File getImageFolder() {
        return (File) this.imageFolder.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final File imageFolder_delegate$lambda$0(ImageStore imageStore) throws IOException {
        File externalFilesDir = imageStore.context.getExternalFilesDir(null);
        if (externalFilesDir != null) {
            return externalFilesDir;
        }
        throw new IOException("App folder is not available");
    }

    public final File generateImageFile(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return new File(getImageFolder(), UUID.randomUUID() + "." + extension);
    }

    public final File getTemporaryPdfImageFile(String extension) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        return new File(this.context.getExternalCacheDir(), UUID.randomUUID() + extension);
    }
}
