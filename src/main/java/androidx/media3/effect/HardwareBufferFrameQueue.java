package androidx.media3.effect;

import androidx.media3.common.ColorInfo;
import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes8.dex */
public interface HardwareBufferFrameQueue {
    HardwareBufferFrame dequeue(FrameFormat frameFormat, Runnable runnable);

    void queue(HardwareBufferFrame hardwareBufferFrame);

    void release();

    void signalEndOfStream();

    public static final class FrameFormat {
        public final ColorInfo colorInfo;
        public final int height;
        public final int pixelFormat;
        public final long usageFlags;
        public final int width;

        public static final class Builder {
            private int height;
            private int width;
            private int pixelFormat = 1;
            private long usageFlags = 256;
            private ColorInfo colorInfo = ColorInfo.SDR_BT709_LIMITED;

            public Builder setWidth(int i) {
                this.width = i;
                return this;
            }

            public Builder setHeight(int i) {
                this.height = i;
                return this;
            }

            public Builder setPixelFormat(int i) {
                this.pixelFormat = i;
                return this;
            }

            public Builder setUsageFlags(long j) {
                this.usageFlags = j;
                return this;
            }

            public Builder setColorInfo(ColorInfo colorInfo) {
                this.colorInfo = colorInfo;
                return this;
            }

            public FrameFormat build() {
                return new FrameFormat(this.width, this.height, this.pixelFormat, this.usageFlags, this.colorInfo);
            }
        }

        private FrameFormat(int i, int i2, int i3, long j, ColorInfo colorInfo) {
            this.width = i;
            this.height = i2;
            this.pixelFormat = i3;
            this.usageFlags = j;
            this.colorInfo = colorInfo;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                FrameFormat frameFormat = (FrameFormat) obj;
                if (this.width == frameFormat.width && this.height == frameFormat.height && this.pixelFormat == frameFormat.pixelFormat && this.usageFlags == frameFormat.usageFlags && Objects.equals(this.colorInfo, frameFormat.colorInfo)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.width), Integer.valueOf(this.height), Integer.valueOf(this.pixelFormat), Long.valueOf(this.usageFlags), this.colorInfo);
        }

        public String toString() {
            return "FrameFormat{width=" + this.width + ", height=" + this.height + ", pixelFormat=" + this.pixelFormat + ", usageFlags=" + this.usageFlags + ", colorInfo=" + this.colorInfo + AbstractJsonLexerKt.END_OBJ;
        }
    }
}
