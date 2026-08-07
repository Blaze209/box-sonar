package com.pspdfkit.annotations.sound;

import com.pspdfkit.annotations.SoundAnnotation;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/pspdfkit/annotations/sound/WavWriter;", "", "audioData", "", "sampleRate", "", "sampleSize", "channels", "audioDataByteOrder", "Ljava/nio/ByteOrder;", "<init>", "([BIIILjava/nio/ByteOrder;)V", "writeToStream", "", "outputStream", "Ljava/io/OutputStream;", "getWaveHeader", "Ljava/nio/ByteBuffer;", "Companion", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class WavWriter {
    private static final int BUFFER_SIZE = 2048;
    private static final int RIFF_HEADER_SIZE = 8;
    private static final int WAVE_HEADER_SIZE = 36;
    private final byte[] audioData;
    private final ByteOrder audioDataByteOrder;
    private final int channels;
    private final int sampleRate;
    private final int sampleSize;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/pspdfkit/annotations/sound/WavWriter$Companion;", "", "<init>", "()V", "BUFFER_SIZE", "", "RIFF_HEADER_SIZE", "WAVE_HEADER_SIZE", "forAnnotation", "Lcom/pspdfkit/annotations/sound/WavWriter;", "annotation", "Lcom/pspdfkit/annotations/SoundAnnotation;", "forAudioSource", "audioSource", "Lcom/pspdfkit/annotations/sound/EmbeddedAudioSource;", "soundAnnotationSupportsWavExport", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final WavWriter forAnnotation(SoundAnnotation annotation) throws IOException {
            annotation.getClass();
            if (!annotation.hasAudioData()) {
                throw new IllegalStateException("No audio data is attached to sound annotation.");
            }
            if (annotation.getAudioEncoding() != AudioEncoding.SIGNED) {
                throw new IllegalStateException("Unsupported audio encoding: " + annotation.getAudioEncoding());
            }
            byte[] audioData = annotation.getAudioData();
            if (audioData == null) {
                throw new IOException("Can't read audio data from annotation");
            }
            int sampleRate = annotation.getSampleRate();
            int sampleSize = annotation.getSampleSize();
            int channels = annotation.getChannels();
            ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
            byteOrder.getClass();
            return new WavWriter(audioData, sampleRate, sampleSize, channels, byteOrder);
        }

        @JvmStatic
        public final WavWriter forAudioSource(EmbeddedAudioSource audioSource) {
            audioSource.getClass();
            if (audioSource.getAudioEncoding() != AudioEncoding.SIGNED) {
                throw new IllegalStateException("Unsupported audio encoding: " + audioSource.getAudioEncoding());
            }
            byte[] bArr = audioSource.getDataProvider().read(audioSource.getDataProvider().getSize(), 0L);
            bArr.getClass();
            int sampleRate = audioSource.getSampleRate();
            int sampleSize = audioSource.getSampleSize();
            int channels = audioSource.getChannels();
            ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
            byteOrder.getClass();
            return new WavWriter(bArr, sampleRate, sampleSize, channels, byteOrder);
        }

        @JvmStatic
        public final boolean soundAnnotationSupportsWavExport(SoundAnnotation annotation) {
            annotation.getClass();
            return annotation.hasAudioData() && annotation.getAudioEncoding() == AudioEncoding.SIGNED;
        }

        private Companion() {
        }
    }

    public WavWriter(byte[] bArr, int i, int i2, int i3, ByteOrder byteOrder) {
        bArr.getClass();
        byteOrder.getClass();
        this.audioData = bArr;
        this.sampleRate = i;
        this.sampleSize = i2;
        this.channels = i3;
        this.audioDataByteOrder = byteOrder;
    }

    @JvmStatic
    public static final WavWriter forAnnotation(SoundAnnotation soundAnnotation) throws IOException {
        return INSTANCE.forAnnotation(soundAnnotation);
    }

    @JvmStatic
    public static final WavWriter forAudioSource(EmbeddedAudioSource embeddedAudioSource) {
        return INSTANCE.forAudioSource(embeddedAudioSource);
    }

    private final ByteBuffer getWaveHeader() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(44);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        Charset charset = Charsets.UTF_8;
        byte[] bytes = "RIFF".getBytes(charset);
        bytes.getClass();
        byteBufferAllocate.put(bytes);
        byteBufferAllocate.putInt(this.audioData.length + 36);
        byte[] bytes2 = "WAVE".getBytes(charset);
        bytes2.getClass();
        byteBufferAllocate.put(bytes2);
        byte[] bytes3 = "fmt ".getBytes(charset);
        bytes3.getClass();
        byteBufferAllocate.put(bytes3);
        byteBufferAllocate.putInt(16);
        byteBufferAllocate.putShort((short) 1);
        byteBufferAllocate.putShort((short) this.channels);
        byteBufferAllocate.putInt(this.sampleRate);
        byteBufferAllocate.putInt(((this.sampleRate * this.sampleSize) * this.channels) / 8);
        byteBufferAllocate.putShort((short) ((this.channels * this.sampleSize) / 8));
        byteBufferAllocate.putShort((short) this.sampleSize);
        byte[] bytes4 = "data".getBytes(charset);
        bytes4.getClass();
        byteBufferAllocate.put(bytes4);
        byteBufferAllocate.putInt(this.audioData.length);
        return byteBufferAllocate;
    }

    @JvmStatic
    public static final boolean soundAnnotationSupportsWavExport(SoundAnnotation soundAnnotation) {
        return INSTANCE.soundAnnotationSupportsWavExport(soundAnnotation);
    }

    public final void writeToStream(OutputStream outputStream) throws IOException {
        outputStream.getClass();
        outputStream.write(getWaveHeader().array());
        if (this.sampleSize <= 8 || !Intrinsics.areEqual(this.audioDataByteOrder, ByteOrder.BIG_ENDIAN)) {
            outputStream.write(this.audioData);
        } else {
            byte[] bArr = new byte[2048];
            int i = 0;
            int i2 = 0;
            while (i < this.audioData.length - 1) {
                if (i2 == 2048) {
                    outputStream.write(bArr);
                    i2 = 0;
                }
                byte[] bArr2 = this.audioData;
                byte b = bArr2[i];
                byte b2 = bArr2[i + 1];
                i += 2;
                bArr[i2] = b2;
                bArr[i2 + 1] = b;
                i2 += 2;
            }
            if (i2 != 0) {
                outputStream.write(bArr, 0, i2);
            }
        }
        outputStream.close();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WavWriter(byte[] bArr, int i, int i2, int i3, ByteOrder byteOrder, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i4 & 16) != 0) {
            byteOrder = ByteOrder.BIG_ENDIAN;
            byteOrder.getClass();
        }
        this(bArr, i, i2, i3, byteOrder);
    }
}
