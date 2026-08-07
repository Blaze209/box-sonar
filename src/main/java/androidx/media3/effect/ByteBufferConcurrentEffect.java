package androidx.media3.effect;

import androidx.media3.common.GlObjectsProvider;
import androidx.media3.common.GlTextureInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.GlRect;
import androidx.media3.common.util.GlUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes8.dex */
class ByteBufferConcurrentEffect<T> implements QueuingGlShaderProgram.ConcurrentEffect<T> {
    private static final int BYTES_PER_PIXEL = 4;
    private GlTextureInfo effectInputTexture;
    private final int pendingPixelBufferQueueSize;
    private final ByteBufferGlEffect.Processor<T> processor;
    private final Queue<TexturePixelBuffer> unmappedPixelBuffers = new ArrayDeque();
    private final Queue<TexturePixelBuffer> mappedPixelBuffers = new ArrayDeque();
    private final PixelBufferObjectProvider pixelBufferObjectProvider = new PixelBufferObjectProvider();
    private int inputWidth = -1;
    private int inputHeight = -1;

    public ByteBufferConcurrentEffect(int i, ByteBufferGlEffect.Processor<T> processor) {
        this.processor = processor;
        this.pendingPixelBufferQueueSize = i;
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public Future<T> queueInputFrame(GlObjectsProvider glObjectsProvider, GlTextureInfo glTextureInfo, final long j) {
        while (this.unmappedPixelBuffers.size() >= this.pendingPixelBufferQueueSize) {
            try {
                Preconditions.checkState(mapOnePixelBuffer());
            } catch (VideoFrameProcessingException | GlUtil.GlException e) {
                return Futures.immediateFailedFuture(e);
            }
        }
        if (this.effectInputTexture == null || glTextureInfo.width != this.inputWidth || glTextureInfo.height != this.inputHeight) {
            while (mapOnePixelBuffer()) {
            }
            this.inputWidth = glTextureInfo.width;
            int i = glTextureInfo.height;
            this.inputHeight = i;
            Size sizeConfigure = this.processor.configure(this.inputWidth, i);
            GlTextureInfo glTextureInfo2 = this.effectInputTexture;
            if (glTextureInfo2 != null) {
                glTextureInfo2.release();
            }
            this.effectInputTexture = glObjectsProvider.createBuffersForTexture(GlUtil.createTexture(sizeConfigure.getWidth(), sizeConfigure.getHeight(), false), sizeConfigure.getWidth(), sizeConfigure.getHeight());
        }
        GlUtil.blitFrameBuffer(glTextureInfo.fboId, this.processor.getScaledRegion(j), this.effectInputTexture.fboId, new GlRect(this.effectInputTexture.width, this.effectInputTexture.height));
        TexturePixelBuffer texturePixelBuffer = new TexturePixelBuffer(this.effectInputTexture);
        texturePixelBuffer.schedulePixelBufferRead(this.pixelBufferObjectProvider);
        this.unmappedPixelBuffers.add(texturePixelBuffer);
        return Util.transformFutureAsync(texturePixelBuffer.imageSettableFuture, new AsyncFunction() { // from class: androidx.media3.effect.ByteBufferConcurrentEffect$$ExternalSyntheticLambda0
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final ListenableFuture apply(Object obj) {
                return this.f$0.m10362xfe8250b1(j, (ByteBufferGlEffect.Image) obj);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$queueInputFrame$0$androidx-media3-effect-ByteBufferConcurrentEffect, reason: not valid java name */
    /* synthetic */ ListenableFuture m10362xfe8250b1(long j, ByteBufferGlEffect.Image image) throws Exception {
        return this.processor.processImage(image, j);
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public void finishProcessingAndBlend(GlTextureInfo glTextureInfo, long j, T t) throws VideoFrameProcessingException {
        try {
            ((TexturePixelBuffer) Preconditions.checkNotNull(this.mappedPixelBuffers.poll())).unmapAndRecycle(this.pixelBufferObjectProvider);
            this.processor.finishProcessingAndBlend(glTextureInfo, j, t);
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public void signalEndOfCurrentInputStream() throws VideoFrameProcessingException {
        do {
            try {
            } catch (GlUtil.GlException e) {
                throw new VideoFrameProcessingException(e);
            }
        } while (mapOnePixelBuffer());
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public void flush() throws VideoFrameProcessingException {
        try {
            unmapAndRecyclePixelBuffers();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    @Override // androidx.media3.effect.QueuingGlShaderProgram.ConcurrentEffect
    public void release() throws VideoFrameProcessingException {
        try {
            unmapAndRecyclePixelBuffers();
            this.pixelBufferObjectProvider.release();
        } catch (GlUtil.GlException e) {
            throw new VideoFrameProcessingException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int texturePixelBufferSize(GlTextureInfo glTextureInfo) {
        return glTextureInfo.width * glTextureInfo.height * 4;
    }

    private void unmapAndRecyclePixelBuffers() throws GlUtil.GlException {
        while (true) {
            TexturePixelBuffer texturePixelBufferPoll = this.unmappedPixelBuffers.poll();
            if (texturePixelBufferPoll == null) {
                break;
            } else {
                texturePixelBufferPoll.unmapAndRecycle(this.pixelBufferObjectProvider);
            }
        }
        while (true) {
            TexturePixelBuffer texturePixelBufferPoll2 = this.mappedPixelBuffers.poll();
            if (texturePixelBufferPoll2 == null) {
                return;
            } else {
                texturePixelBufferPoll2.unmapAndRecycle(this.pixelBufferObjectProvider);
            }
        }
    }

    private boolean mapOnePixelBuffer() throws GlUtil.GlException {
        TexturePixelBuffer texturePixelBufferPoll = this.unmappedPixelBuffers.poll();
        if (texturePixelBufferPoll == null) {
            return false;
        }
        texturePixelBufferPoll.map();
        this.mappedPixelBuffers.add(texturePixelBufferPoll);
        return true;
    }

    private static final class TexturePixelBuffer {
        public final SettableFuture<ByteBufferGlEffect.Image> imageSettableFuture = SettableFuture.create();
        private boolean mapped;
        private PixelBufferObjectInfo pixelBufferObjectInfo;
        private final GlTextureInfo textureInfo;

        public TexturePixelBuffer(GlTextureInfo glTextureInfo) {
            this.textureInfo = glTextureInfo;
        }

        public void schedulePixelBufferRead(PixelBufferObjectProvider pixelBufferObjectProvider) throws GlUtil.GlException {
            this.pixelBufferObjectInfo = pixelBufferObjectProvider.getPixelBufferObject(ByteBufferConcurrentEffect.texturePixelBufferSize(this.textureInfo));
            GlUtil.schedulePixelBufferRead(this.textureInfo.fboId, this.textureInfo.width, this.textureInfo.height, this.pixelBufferObjectInfo.id);
        }

        public void map() throws GlUtil.GlException {
            Preconditions.checkNotNull(this.pixelBufferObjectInfo);
            this.imageSettableFuture.set(new ByteBufferGlEffect.Image(this.textureInfo.width, this.textureInfo.height, GlUtil.mapPixelBufferObject(this.pixelBufferObjectInfo.id, this.pixelBufferObjectInfo.size)));
            this.mapped = true;
        }

        public void unmapAndRecycle(PixelBufferObjectProvider pixelBufferObjectProvider) throws GlUtil.GlException {
            Preconditions.checkNotNull(this.pixelBufferObjectInfo);
            if (this.mapped) {
                GlUtil.unmapPixelBufferObject(this.pixelBufferObjectInfo.id);
            }
            pixelBufferObjectProvider.recycle(this.pixelBufferObjectInfo);
        }
    }

    private static final class PixelBufferObjectInfo {
        public final int id;
        public final int size;

        public PixelBufferObjectInfo(int i) throws GlUtil.GlException {
            this.size = i;
            this.id = GlUtil.createPixelBufferObject(i);
        }

        public void release() throws GlUtil.GlException {
            GlUtil.deleteBuffer(this.id);
        }
    }

    private static final class PixelBufferObjectProvider {
        private final Queue<PixelBufferObjectInfo> availablePixelBufferObjects = new ArrayDeque();

        /* JADX INFO: Access modifiers changed from: private */
        public PixelBufferObjectInfo getPixelBufferObject(int i) throws GlUtil.GlException {
            while (true) {
                PixelBufferObjectInfo pixelBufferObjectInfoPoll = this.availablePixelBufferObjects.poll();
                if (pixelBufferObjectInfoPoll != null) {
                    if (pixelBufferObjectInfoPoll.size == i) {
                        return pixelBufferObjectInfoPoll;
                    }
                    GlUtil.deleteBuffer(pixelBufferObjectInfoPoll.id);
                } else {
                    return new PixelBufferObjectInfo(i);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void recycle(PixelBufferObjectInfo pixelBufferObjectInfo) {
            this.availablePixelBufferObjects.add(pixelBufferObjectInfo);
        }

        public void release() throws GlUtil.GlException {
            while (true) {
                PixelBufferObjectInfo pixelBufferObjectInfoPoll = this.availablePixelBufferObjects.poll();
                if (pixelBufferObjectInfoPoll == null) {
                    return;
                } else {
                    pixelBufferObjectInfoPoll.release();
                }
            }
        }
    }
}
