package com.pspdfkit.annotations.sound;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import android.view.Surface;
import com.box.android.capture.audiorecording.RecorderService;
import com.pspdfkit.internal.uw;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public class AudioExtractor {
    private static final String ASSETS_URI_PREFIX = "/android_asset/";
    private static final String ASSETS_URI_SCHEME = "file";
    private static final int DECODED_SAMPLE_SIZE = 16;
    private static final int TIMEOUT_US = 10000;
    private final Uri contentUri;
    private final Context context;
    private AudioDecodingWorker decodingWorker;
    private final List<Integer> audioTracksIndexes = new ArrayList();
    private int selectedMediaTrackIndex = -1;

    public static class AudioDecodingWorker {
        private final int channelCount;
        private final MediaCodec decoder;
        private final long duration;
        private boolean isEndOfStream;
        private final MediaExtractor mediaExtractor;
        private int outputBufferIndex;
        private final int sampleRate;

        private AudioDecodingWorker(Context context, Uri uri, int i) throws IOException {
            this.isEndOfStream = false;
            this.outputBufferIndex = -1;
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mediaExtractor = mediaExtractor;
            AudioExtractor.setDataSource(context, mediaExtractor, uri);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            String string = trackFormat.getString("mime");
            this.sampleRate = getInteger(trackFormat, "sample-rate", RecorderService.AUDIO_SAMPLING_RATE);
            this.channelCount = getInteger(trackFormat, "channel-count", 2);
            this.duration = getLong(trackFormat, "durationUs", 0L) / 1000;
            MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(string);
            this.decoder = mediaCodecCreateDecoderByType;
            mediaCodecCreateDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
            mediaExtractor.selectTrack(i);
            mediaCodecCreateDecoderByType.start();
        }

        private ByteBuffer getInputBuffer(int i) {
            return this.decoder.getInputBuffer(i);
        }

        private static int getInteger(MediaFormat mediaFormat, String str, int i) {
            return mediaFormat.containsKey(str) ? mediaFormat.getInteger(str) : i;
        }

        private static long getLong(MediaFormat mediaFormat, String str, long j) {
            return mediaFormat.containsKey(str) ? mediaFormat.getLong(str) : j;
        }

        private ByteBuffer getOutputBuffer(int i) {
            return this.decoder.getOutputBuffer(i);
        }

        private ByteBuffer readData(MediaCodec.BufferInfo bufferInfo) {
            int iDequeueOutputBuffer;
            int iDequeueInputBuffer;
            do {
                if (!this.isEndOfStream && (iDequeueInputBuffer = this.decoder.dequeueInputBuffer(10000L)) >= 0) {
                    int sampleData = this.mediaExtractor.readSampleData(getInputBuffer(iDequeueInputBuffer), 0);
                    MediaCodec mediaCodec = this.decoder;
                    if (sampleData < 0) {
                        mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                        this.isEndOfStream = true;
                    } else {
                        mediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, this.mediaExtractor.getSampleTime(), 0);
                        this.mediaExtractor.advance();
                    }
                }
                int i = this.outputBufferIndex;
                if (i >= 0) {
                    getOutputBuffer(i).position(0);
                    this.decoder.releaseOutputBuffer(this.outputBufferIndex, false);
                }
                iDequeueOutputBuffer = this.decoder.dequeueOutputBuffer(bufferInfo, 10000L);
                this.outputBufferIndex = iDequeueOutputBuffer;
            } while (iDequeueOutputBuffer < 0);
            if (bufferInfo.flags != 4) {
                return getOutputBuffer(iDequeueOutputBuffer);
            }
            this.decoder.stop();
            return null;
        }

        public void release() {
            this.mediaExtractor.release();
            this.decoder.release();
        }

        public EmbeddedAudioSource toAudioSource() throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            WritableByteChannel writableByteChannelNewChannel = Channels.newChannel(byteArrayOutputStream);
            try {
                MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                while (true) {
                    ByteBuffer data = readData(bufferInfo);
                    if (data == null || bufferInfo.flags == 4) {
                        break;
                        break;
                    }
                    writableByteChannelNewChannel.write(data);
                }
                if (byteArrayOutputStream.size() == 0) {
                    throw new IOException("Can't decode audio data.");
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
                    byteArray.getClass();
                    for (int i = 0; i < byteArray.length - 1; i += 2) {
                        byte b = byteArray[i];
                        int i2 = i + 1;
                        byteArray[i] = byteArray[i2];
                        byteArray[i2] = b;
                    }
                }
                EmbeddedAudioSource embeddedAudioSource = new EmbeddedAudioSource(byteArray, AudioEncoding.SIGNED, this.sampleRate, 16, this.channelCount, (String) null);
                if (writableByteChannelNewChannel != null) {
                    writableByteChannelNewChannel.close();
                }
                return embeddedAudioSource;
            } catch (Throwable th) {
                if (writableByteChannelNewChannel == null) {
                    throw th;
                }
                try {
                    writableByteChannelNewChannel.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        }
    }

    public AudioExtractor(Context context, Uri uri) throws IOException {
        this.context = context;
        this.contentUri = uri;
        MediaExtractor mediaExtractor = new MediaExtractor();
        setDataSource(context, mediaExtractor, uri);
        for (int i = 0; i < mediaExtractor.getTrackCount(); i++) {
            String string = mediaExtractor.getTrackFormat(i).getString("mime");
            if (string != null && string.startsWith("audio/")) {
                this.audioTracksIndexes.add(Integer.valueOf(i));
            }
        }
        if (this.audioTracksIndexes.isEmpty()) {
            throw new IllegalStateException("Input media file does not have any audio tracks");
        }
        mediaExtractor.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void setDataSource(Context context, MediaExtractor mediaExtractor, Uri uri) throws IOException {
        if (uri.getScheme() == null || !uri.getScheme().startsWith("file") || uri.getPath() == null || !uri.getPath().startsWith(ASSETS_URI_PREFIX)) {
            mediaExtractor.setDataSource(context, uri, (Map<String, String>) null);
        } else {
            mediaExtractor.setDataSource(context.getAssets().openFd(uri.getPath().replace(ASSETS_URI_PREFIX, "")));
        }
    }

    public EmbeddedAudioSource extractAudioTrack() throws IOException {
        AudioDecodingWorker audioDecodingWorker;
        synchronized (this) {
            audioDecodingWorker = this.decodingWorker;
            this.decodingWorker = null;
        }
        if (audioDecodingWorker == null) {
            if (this.selectedMediaTrackIndex == -1) {
                this.selectedMediaTrackIndex = this.audioTracksIndexes.get(0).intValue();
            }
            audioDecodingWorker = new AudioDecodingWorker(this.context, this.contentUri, this.selectedMediaTrackIndex);
        }
        EmbeddedAudioSource audioSource = audioDecodingWorker.toAudioSource();
        audioDecodingWorker.release();
        return audioSource;
    }

    public Single<EmbeddedAudioSource> extractAudioTrackAsync() {
        return Single.fromCallable(new Callable() { // from class: com.pspdfkit.annotations.sound.AudioExtractor$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.extractAudioTrack();
            }
        }).subscribeOn(Schedulers.io());
    }

    public int getAudioTracksCount() {
        return this.audioTracksIndexes.size();
    }

    public long getSelectedTrackDuration() {
        uw.b(this.decodingWorker != null, "Track needs to be selected before querying its duration.");
        return this.decodingWorker.duration;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x000f  */
    public synchronized void selectAudioTrack(int i) throws IOException {
        boolean z;
        if (i >= 0) {
            try {
                if (i < this.audioTracksIndexes.size()) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            z = false;
        }
        uw.b(z, "audioTrackIndex must be between 0 and " + this.audioTracksIndexes.size());
        int iIntValue = this.audioTracksIndexes.get(i).intValue();
        if (this.selectedMediaTrackIndex == iIntValue) {
            return;
        }
        this.selectedMediaTrackIndex = iIntValue;
        this.decodingWorker = new AudioDecodingWorker(this.context, this.contentUri, iIntValue);
    }
}
