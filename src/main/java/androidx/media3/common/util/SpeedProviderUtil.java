package androidx.media3.common.util;

import androidx.media3.common.audio.SpeedProvider;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Floats;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes8.dex */
public class SpeedProviderUtil {
    private SpeedProviderUtil() {
    }

    public static long getDurationAfterSpeedProviderApplied(SpeedProvider speedProvider, long j) {
        long j2 = 0;
        double dMin = 0.0d;
        while (j2 < j) {
            long nextSpeedChangeTimeUs = speedProvider.getNextSpeedChangeTimeUs(j2);
            if (nextSpeedChangeTimeUs == -9223372036854775807L) {
                nextSpeedChangeTimeUs = Long.MAX_VALUE;
            }
            Preconditions.checkState(nextSpeedChangeTimeUs > j2);
            dMin += (Math.min(nextSpeedChangeTimeUs, j) - j2) / ((double) speedProvider.getSpeed(j2));
            j2 = nextSpeedChangeTimeUs;
        }
        return (long) Math.floor(dMin);
    }

    public static float getSampleAlignedSpeed(SpeedProvider speedProvider, long j, int i) {
        Preconditions.checkArgument(j >= 0);
        Preconditions.checkArgument(i > 0);
        return speedProvider.getSpeed(Util.sampleCountToDurationUs(j, i));
    }

    public static long getNextSpeedChangeSamplePosition(SpeedProvider speedProvider, long j, int i) {
        Preconditions.checkArgument(j >= 0);
        Preconditions.checkArgument(i > 0);
        long nextSpeedChangeTimeUs = speedProvider.getNextSpeedChangeTimeUs(Util.sampleCountToDurationUs(j, i));
        if (nextSpeedChangeTimeUs == -9223372036854775807L) {
            return -1L;
        }
        return Util.durationUsToSampleCount(nextSpeedChangeTimeUs, i);
    }

    public static final class SpeedProviderMapper {
        private final long[] inputSegmentStartTimesUs;
        private final long[] outputSegmentStartTimesUs;
        private final float[] speeds;

        public SpeedProviderMapper(SpeedProvider speedProvider) {
            LongArray longArray = new LongArray();
            LongArray longArray2 = new LongArray();
            ArrayList arrayList = new ArrayList();
            float speed = speedProvider.getSpeed(0L);
            longArray.add(0L);
            longArray2.add(0L);
            arrayList.add(Float.valueOf(speed));
            long nextSpeedChangeTimeUs = speedProvider.getNextSpeedChangeTimeUs(0L);
            Preconditions.checkState(speed > 0.0f);
            long playoutDurationForMediaDuration = 0;
            long nextSpeedChangeTimeUs2 = nextSpeedChangeTimeUs;
            float speed2 = speed;
            long j = 0;
            while (nextSpeedChangeTimeUs2 != -9223372036854775807L) {
                Preconditions.checkState(nextSpeedChangeTimeUs2 > j);
                Preconditions.checkState(speed2 > 0.0f);
                playoutDurationForMediaDuration += Util.getPlayoutDurationForMediaDuration(nextSpeedChangeTimeUs2 - j, speed2);
                speed2 = speedProvider.getSpeed(nextSpeedChangeTimeUs2);
                longArray.add(playoutDurationForMediaDuration);
                longArray2.add(nextSpeedChangeTimeUs2);
                arrayList.add(Float.valueOf(speed2));
                j = nextSpeedChangeTimeUs2;
                nextSpeedChangeTimeUs2 = speedProvider.getNextSpeedChangeTimeUs(nextSpeedChangeTimeUs2);
            }
            this.outputSegmentStartTimesUs = longArray.toArray();
            this.inputSegmentStartTimesUs = longArray2.toArray();
            this.speeds = Floats.toArray(arrayList);
        }

        public long getAdjustedTimeUs(long j) {
            Preconditions.checkArgument((j == -9223372036854775807L || j == Long.MIN_VALUE) ? false : true);
            Preconditions.checkArgument(j >= 0);
            int iBinarySearchFloor = Util.binarySearchFloor(this.inputSegmentStartTimesUs, j, true, true);
            return this.outputSegmentStartTimesUs[iBinarySearchFloor] + Util.getPlayoutDurationForMediaDuration(j - this.inputSegmentStartTimesUs[iBinarySearchFloor], this.speeds[iBinarySearchFloor]);
        }

        public long getOriginalTimeUs(long j) {
            Preconditions.checkArgument((j == -9223372036854775807L || j == Long.MIN_VALUE) ? false : true);
            Preconditions.checkArgument(j >= 0);
            int iBinarySearchFloor = Util.binarySearchFloor(this.outputSegmentStartTimesUs, j, true, true);
            return this.inputSegmentStartTimesUs[iBinarySearchFloor] + Util.getMediaDurationForPlayoutDuration(j - this.outputSegmentStartTimesUs[iBinarySearchFloor], this.speeds[iBinarySearchFloor]);
        }
    }
}
