package com.pspdfkit.annotations.sound;

import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.internal.rq;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public class EmbeddedAudioSource {
    public static final int DURATION_UNKNOWN = -1;
    private final AudioEncoding audioEncoding;
    private final int channels;
    private final DataProvider dataProvider;
    private final int sampleRate;
    private final int sampleSize;
    private final String soundDescription;

    public EmbeddedAudioSource(DataProvider dataProvider, AudioEncoding audioEncoding, int i, int i2, int i3, String str) {
        uw.a(dataProvider, "audioDataProvider", null);
        uw.a(audioEncoding, "audioEncoding", null);
        if (i <= 0) {
            throw new IllegalArgumentException("Sample rate must be larger than 0, was: " + i);
        }
        if (i2 < 8) {
            throw new IllegalArgumentException("Sample size must be at least 8 bits, was: " + i2);
        }
        if (i3 < 1) {
            throw new IllegalArgumentException("Number of channels must be at least 1, was: " + i3);
        }
        this.dataProvider = dataProvider;
        this.audioEncoding = audioEncoding;
        this.sampleRate = i;
        this.sampleSize = i2;
        this.channels = i3;
        this.soundDescription = str;
    }

    public AudioEncoding getAudioEncoding() {
        return this.audioEncoding;
    }

    public int getChannels() {
        return this.channels;
    }

    public DataProvider getDataProvider() {
        return this.dataProvider;
    }

    public String getDescription() {
        return this.soundDescription;
    }

    public long getDuration() {
        long size = this.dataProvider.getSize();
        if (size == -1) {
            return -1L;
        }
        return (long) (size / ((this.sampleSize / 8.0f) * ((this.sampleRate / 1000.0f) * this.channels)));
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    public int getSampleSize() {
        return this.sampleSize;
    }

    public EmbeddedAudioSource(byte[] bArr, AudioEncoding audioEncoding, int i, int i2, int i3, String str) {
        this(new rq(bArr), audioEncoding, i, i2, i3, str);
    }
}
