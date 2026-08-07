package androidx.media3.exoplayer.source;

import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.Callback {
    private MediaPeriod.Callback callback;
    private ClippingMediaSource.IllegalClippingException clippingError;
    private final boolean enableClippingInMediaPeriod;
    long endUs;
    private boolean isPeriodClippingEndPosition;
    private long lastReportedDiscontinuityUs;
    public final MediaPeriod mediaPeriod;
    private long pendingInitialDiscontinuityPositionUs;
    private ClippingSampleStream[] sampleStreams;
    long startUs;

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z, long j, long j2) {
        this(mediaPeriod, z, j, j2, false);
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z, long j, long j2, boolean z2) {
        this.mediaPeriod = mediaPeriod;
        this.sampleStreams = new ClippingSampleStream[0];
        this.pendingInitialDiscontinuityPositionUs = z ? j : -9223372036854775807L;
        this.lastReportedDiscontinuityUs = -9223372036854775807L;
        this.enableClippingInMediaPeriod = z2;
        updateClipping(j, j2);
    }

    public void updateClipping(long j, long j2) {
        this.startUs = j;
        this.endUs = j2;
        if (this.enableClippingInMediaPeriod) {
            long endPositionUs = this.mediaPeriod.setEndPositionUs(j2);
            Preconditions.checkState(endPositionUs == Long.MIN_VALUE || endPositionUs == j2, "Period updating end positions not supported, %s!=%s", endPositionUs, j2);
            this.isPeriodClippingEndPosition = endPositionUs == j2;
        }
    }

    public void setClippingError(ClippingMediaSource.IllegalClippingException illegalClippingException) {
        this.clippingError = illegalClippingException;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void prepare(MediaPeriod.Callback callback, long j) {
        this.callback = callback;
        this.mediaPeriod.prepare(this, j);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void maybeThrowPrepareError() throws IOException {
        ClippingMediaSource.IllegalClippingException illegalClippingException = this.clippingError;
        if (illegalClippingException != null) {
            throw illegalClippingException;
        }
        this.mediaPeriod.maybeThrowPrepareError();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public List<StreamKey> getStreamKeys(List<ExoTrackSelection> list) {
        return this.mediaPeriod.getStreamKeys(list);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public TrackGroupArray getTrackGroups() {
        return this.mediaPeriod.getTrackGroups();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        this.sampleStreams = new ClippingSampleStream[sampleStreamArr.length];
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        int i = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i >= sampleStreamArr.length) {
                break;
            }
            ClippingSampleStream[] clippingSampleStreamArr = this.sampleStreams;
            ClippingSampleStream clippingSampleStream = (ClippingSampleStream) sampleStreamArr[i];
            clippingSampleStreamArr[i] = clippingSampleStream;
            if (clippingSampleStream != null) {
                sampleStream = clippingSampleStream.childStream;
            }
            sampleStreamArr2[i] = sampleStream;
            i++;
        }
        long jSelectTracks = this.mediaPeriod.selectTracks(exoTrackSelectionArr, zArr, sampleStreamArr2, zArr2, j);
        long jEnforceClippingRange = enforceClippingRange(jSelectTracks, j, this.endUs);
        this.pendingInitialDiscontinuityPositionUs = (isPendingInitialDiscontinuity() && shouldKeepInitialDiscontinuity(jSelectTracks, j, exoTrackSelectionArr)) ? jEnforceClippingRange : -9223372036854775807L;
        for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
            if (sampleStreamArr2[i2] == null) {
                this.sampleStreams[i2] = null;
            } else {
                ClippingSampleStream clippingSampleStream2 = this.sampleStreams[i2];
                if (clippingSampleStream2 == null || clippingSampleStream2.childStream != sampleStreamArr2[i2]) {
                    this.sampleStreams[i2] = new ClippingSampleStream(sampleStreamArr2[i2]);
                }
            }
            sampleStreamArr[i2] = this.sampleStreams[i2];
        }
        return jEnforceClippingRange;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public void discardBuffer(long j, boolean z) {
        this.mediaPeriod.discardBuffer(j, z);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public void reevaluateBuffer(long j) {
        this.mediaPeriod.reevaluateBuffer(j);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long readDiscontinuity() {
        if (isPendingInitialDiscontinuity()) {
            long j = this.pendingInitialDiscontinuityPositionUs;
            this.pendingInitialDiscontinuityPositionUs = -9223372036854775807L;
            this.lastReportedDiscontinuityUs = j;
            long discontinuity = readDiscontinuity();
            return discontinuity != -9223372036854775807L ? discontinuity : j;
        }
        long discontinuity2 = this.mediaPeriod.readDiscontinuity();
        if (discontinuity2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long jEnforceClippingRange = enforceClippingRange(discontinuity2, this.startUs, this.endUs);
        if (jEnforceClippingRange == this.lastReportedDiscontinuityUs) {
            return -9223372036854775807L;
        }
        this.lastReportedDiscontinuityUs = jEnforceClippingRange;
        return jEnforceClippingRange;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long getBufferedPositionUs() {
        long bufferedPositionUs = this.mediaPeriod.getBufferedPositionUs();
        if (!this.isPeriodClippingEndPosition) {
            if (bufferedPositionUs != Long.MIN_VALUE) {
                long j = this.endUs;
                if (j == Long.MIN_VALUE || bufferedPositionUs < j) {
                }
            }
            return Long.MIN_VALUE;
        }
        long j2 = this.endUs;
        if (j2 != Long.MIN_VALUE && bufferedPositionUs != Long.MIN_VALUE) {
            return Math.min(j2, bufferedPositionUs);
        }
        return bufferedPositionUs;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long seekToUs(long j) {
        this.pendingInitialDiscontinuityPositionUs = -9223372036854775807L;
        for (ClippingSampleStream clippingSampleStream : this.sampleStreams) {
            if (clippingSampleStream != null) {
                clippingSampleStream.clearSentEos();
            }
        }
        return enforceClippingRange(this.mediaPeriod.seekToUs(j), this.startUs, this.endUs);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod
    public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
        long j2 = this.startUs;
        if (j == j2) {
            return j2;
        }
        return this.mediaPeriod.getAdjustedSeekPositionUs(j, clipSeekParameters(j, seekParameters));
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public long getNextLoadPositionUs() {
        long nextLoadPositionUs = this.mediaPeriod.getNextLoadPositionUs();
        if (!this.isPeriodClippingEndPosition) {
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                long j = this.endUs;
                if (j == Long.MIN_VALUE || nextLoadPositionUs < j) {
                }
            }
            return Long.MIN_VALUE;
        }
        long j2 = this.endUs;
        if (j2 != Long.MIN_VALUE && nextLoadPositionUs != Long.MIN_VALUE) {
            return Math.min(j2, nextLoadPositionUs);
        }
        return nextLoadPositionUs;
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean continueLoading(LoadingInfo loadingInfo) {
        return this.mediaPeriod.continueLoading(loadingInfo);
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod, androidx.media3.exoplayer.source.SequenceableLoader
    public boolean isLoading() {
        return this.mediaPeriod.isLoading();
    }

    @Override // androidx.media3.exoplayer.source.MediaPeriod.Callback
    public void onPrepared(MediaPeriod mediaPeriod) {
        if (this.clippingError != null) {
            return;
        }
        ((MediaPeriod.Callback) Preconditions.checkNotNull(this.callback)).onPrepared(this);
    }

    @Override // androidx.media3.exoplayer.source.SequenceableLoader.Callback
    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        ((MediaPeriod.Callback) Preconditions.checkNotNull(this.callback)).onContinueLoadingRequested(this);
    }

    boolean isPendingInitialDiscontinuity() {
        return this.pendingInitialDiscontinuityPositionUs != -9223372036854775807L;
    }

    private SeekParameters clipSeekParameters(long j, SeekParameters seekParameters) {
        long jConstrainValue = Util.constrainValue(seekParameters.toleranceBeforeUs, 0L, j - this.startUs);
        long j2 = seekParameters.toleranceAfterUs;
        long j3 = this.endUs;
        long jConstrainValue2 = Util.constrainValue(j2, 0L, j3 == Long.MIN_VALUE ? Long.MAX_VALUE : j3 - j);
        return (jConstrainValue == seekParameters.toleranceBeforeUs && jConstrainValue2 == seekParameters.toleranceAfterUs) ? seekParameters : new SeekParameters(jConstrainValue, jConstrainValue2);
    }

    private static boolean shouldKeepInitialDiscontinuity(long j, long j2, ExoTrackSelection[] exoTrackSelectionArr) {
        if (j < j2) {
            return true;
        }
        if (j != 0) {
            for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
                if (exoTrackSelection != null) {
                    Format selectedFormat = exoTrackSelection.getSelectedFormat();
                    if (!MimeTypes.allSamplesAreSyncSamples(selectedFormat.sampleMimeType, selectedFormat.codecs)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static long enforceClippingRange(long j, long j2, long j3) {
        long jMax = Math.max(j, j2);
        return j3 != Long.MIN_VALUE ? Math.min(jMax, j3) : jMax;
    }

    private final class ClippingSampleStream implements SampleStream {
        public final SampleStream childStream;
        private boolean sentEos;

        public ClippingSampleStream(SampleStream sampleStream) {
            this.childStream = sampleStream;
        }

        public void clearSentEos() {
            this.sentEos = false;
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public boolean isReady() {
            return !ClippingMediaPeriod.this.isPendingInitialDiscontinuity() && this.childStream.isReady();
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public void maybeThrowError() throws IOException {
            this.childStream.maybeThrowError();
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
        
            if (r19.waitingForKeys == false) goto L35;
         */
        @Override // androidx.media3.exoplayer.source.SampleStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int readData(androidx.media3.exoplayer.FormatHolder r18, androidx.media3.decoder.DecoderInputBuffer r19, int r20) {
            /*
                r17 = this;
                r0 = r17
                r1 = r18
                r2 = r19
                r3 = r20
                androidx.media3.exoplayer.source.ClippingMediaPeriod r4 = androidx.media3.exoplayer.source.ClippingMediaPeriod.this
                boolean r4 = r4.isPendingInitialDiscontinuity()
                r5 = -3
                if (r4 == 0) goto L12
                return r5
            L12:
                androidx.media3.exoplayer.source.ClippingMediaPeriod r4 = androidx.media3.exoplayer.source.ClippingMediaPeriod.this
                boolean r4 = androidx.media3.exoplayer.source.ClippingMediaPeriod.access$000(r4)
                r6 = -5
                if (r4 == 0) goto L30
                androidx.media3.exoplayer.source.SampleStream r4 = r0.childStream
                int r2 = r4.readData(r1, r2, r3)
                if (r2 != r6) goto L2f
                androidx.media3.exoplayer.source.ClippingMediaPeriod r2 = androidx.media3.exoplayer.source.ClippingMediaPeriod.this
                long r2 = r2.startUs
                androidx.media3.exoplayer.source.ClippingMediaPeriod r0 = androidx.media3.exoplayer.source.ClippingMediaPeriod.this
                long r4 = r0.endUs
                androidx.media3.exoplayer.source.ClippingMediaPeriod.access$100(r1, r2, r4)
                return r6
            L2f:
                return r2
            L30:
                boolean r4 = r0.sentEos
                r7 = 4
                r8 = -4
                if (r4 == 0) goto L3a
                r2.setFlags(r7)
                return r8
            L3a:
                androidx.media3.exoplayer.source.ClippingMediaPeriod r4 = androidx.media3.exoplayer.source.ClippingMediaPeriod.this
                long r9 = r4.getBufferedPositionUs()
                androidx.media3.exoplayer.source.SampleStream r4 = r0.childStream
                int r3 = r4.readData(r1, r2, r3)
                androidx.media3.exoplayer.source.ClippingMediaPeriod r4 = androidx.media3.exoplayer.source.ClippingMediaPeriod.this
                long r11 = androidx.media3.exoplayer.source.ClippingMediaPeriod.access$200(r4)
                r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                int r4 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r4 == 0) goto L5c
                if (r3 == r5) goto L5c
                androidx.media3.exoplayer.source.ClippingMediaPeriod r4 = androidx.media3.exoplayer.source.ClippingMediaPeriod.this
                androidx.media3.exoplayer.source.ClippingMediaPeriod.access$202(r4, r13)
            L5c:
                if (r3 != r6) goto L6a
                androidx.media3.exoplayer.source.ClippingMediaPeriod r2 = androidx.media3.exoplayer.source.ClippingMediaPeriod.this
                long r2 = r2.startUs
                androidx.media3.exoplayer.source.ClippingMediaPeriod r0 = androidx.media3.exoplayer.source.ClippingMediaPeriod.this
                long r4 = r0.endUs
                androidx.media3.exoplayer.source.ClippingMediaPeriod.access$100(r1, r2, r4)
                return r6
            L6a:
                androidx.media3.exoplayer.source.ClippingMediaPeriod r1 = androidx.media3.exoplayer.source.ClippingMediaPeriod.this
                long r11 = r1.endUs
                r13 = -9223372036854775808
                int r1 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r1 == 0) goto L99
                if (r3 != r8) goto L83
                long r11 = r2.timeUs
                androidx.media3.exoplayer.source.ClippingMediaPeriod r1 = androidx.media3.exoplayer.source.ClippingMediaPeriod.this
                r4 = r8
                r15 = r9
                long r8 = r1.endUs
                int r1 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
                if (r1 >= 0) goto L8f
                goto L85
            L83:
                r4 = r8
                r15 = r9
            L85:
                if (r3 != r5) goto L99
                int r1 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
                if (r1 != 0) goto L99
                boolean r1 = r2.waitingForKeys
                if (r1 != 0) goto L99
            L8f:
                r2.clear()
                r2.setFlags(r7)
                r1 = 1
                r0.sentEos = r1
                return r4
            L99:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.ClippingMediaPeriod.ClippingSampleStream.readData(androidx.media3.exoplayer.FormatHolder, androidx.media3.decoder.DecoderInputBuffer, int):int");
        }

        @Override // androidx.media3.exoplayer.source.SampleStream
        public int skipData(long j) {
            if (ClippingMediaPeriod.this.isPendingInitialDiscontinuity()) {
                return -3;
            }
            return this.childStream.skipData(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateDecoderDelayPaddingForClipping(FormatHolder formatHolder, long j, long j2) {
        Format format = (Format) Preconditions.checkNotNull(formatHolder.format);
        if (format.encoderDelay == 0 && format.encoderPadding == 0) {
            return;
        }
        formatHolder.format = format.buildUpon().setEncoderDelay(j != 0 ? 0 : format.encoderDelay).setEncoderPadding(j2 == Long.MIN_VALUE ? format.encoderPadding : 0).build();
    }
}
