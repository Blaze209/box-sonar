package com.geniusscansdk.core;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ModelLoader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/core/ModelLoader;", "", "<init>", "()V", "load", "Ljava/nio/MappedByteBuffer;", "context", "Landroid/content/Context;", "filename", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModelLoader {
    public static final ModelLoader INSTANCE = new ModelLoader();

    private ModelLoader() {
    }

    @JvmStatic
    public static final MappedByteBuffer load(Context context, String filename) throws IOException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filename, "filename");
        AssetFileDescriptor assetFileDescriptorOpenFd = context.getAssets().openFd(filename);
        try {
            AssetFileDescriptor assetFileDescriptor = assetFileDescriptorOpenFd;
            FileChannel channel = new FileInputStream(assetFileDescriptor.getFileDescriptor()).getChannel();
            try {
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, assetFileDescriptor.getStartOffset(), assetFileDescriptor.getDeclaredLength());
                CloseableKt.closeFinally(channel, null);
                CloseableKt.closeFinally(assetFileDescriptorOpenFd, null);
                Intrinsics.checkNotNullExpressionValue(map, "use(...)");
                return map;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(channel, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(assetFileDescriptorOpenFd, th3);
                throw th4;
            }
        }
    }
}
