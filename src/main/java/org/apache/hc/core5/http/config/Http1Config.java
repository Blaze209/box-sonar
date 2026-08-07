package org.apache.hc.core5.http.config;

import org.apache.hc.core5.http.HttpVersion;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class Http1Config {
    private static final int INIT_BUF_CHUNK = -1;
    private static final int INIT_BUF_SIZE = 8192;
    private static final int INIT_MAX_EMPTY_LINE_COUNT = 10;
    private static final int INIT_MAX_HEADER_COUNT = -1;
    private static final int INIT_MAX_LINE_LENGTH = -1;
    private static final int INIT_WINDOW_SIZE = 65535;
    private final int bufferSize;
    private final int chunkSizeHint;
    private final int initialWindowSize;
    private final int maxEmptyLineCount;
    private final int maxHeaderCount;
    private final int maxLineLength;
    private final HttpVersion version;
    private final Timeout waitForContinueTimeout;
    public static final Http1Config DEFAULT = new Builder().build();
    private static final Timeout INIT_WAIT_FOR_CONTINUE = Timeout.ofSeconds(3L);

    Http1Config(HttpVersion httpVersion, int i, int i2, Timeout timeout, int i3, int i4, int i5, int i6) {
        this.version = httpVersion;
        this.bufferSize = i;
        this.chunkSizeHint = i2;
        this.waitForContinueTimeout = timeout;
        this.maxLineLength = i3;
        this.maxHeaderCount = i4;
        this.maxEmptyLineCount = i5;
        this.initialWindowSize = i6;
    }

    public HttpVersion getVersion() {
        return this.version;
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public int getChunkSizeHint() {
        return this.chunkSizeHint;
    }

    public Timeout getWaitForContinueTimeout() {
        return this.waitForContinueTimeout;
    }

    public int getMaxLineLength() {
        return this.maxLineLength;
    }

    public int getMaxHeaderCount() {
        return this.maxHeaderCount;
    }

    public int getMaxEmptyLineCount() {
        return this.maxEmptyLineCount;
    }

    public int getInitialWindowSize() {
        return this.initialWindowSize;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[version=");
        sb.append(this.version).append(", bufferSize=").append(this.bufferSize).append(", chunkSizeHint=").append(this.chunkSizeHint).append(", waitForContinueTimeout=").append(this.waitForContinueTimeout).append(", maxLineLength=").append(this.maxLineLength).append(", maxHeaderCount=").append(this.maxHeaderCount).append(", maxEmptyLineCount=").append(this.maxEmptyLineCount).append(", initialWindowSize=").append(this.initialWindowSize).append("]");
        return sb.toString();
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(Http1Config http1Config) {
        Args.notNull(http1Config, "Config");
        return new Builder().setVersion(http1Config.getVersion()).setBufferSize(http1Config.getBufferSize()).setChunkSizeHint(http1Config.getChunkSizeHint()).setWaitForContinueTimeout(http1Config.getWaitForContinueTimeout()).setMaxHeaderCount(http1Config.getMaxHeaderCount()).setMaxLineLength(http1Config.getMaxLineLength()).setMaxEmptyLineCount(http1Config.getMaxEmptyLineCount()).setInitialWindowSize(http1Config.getInitialWindowSize());
    }

    public static class Builder {
        private HttpVersion version = HttpVersion.HTTP_1_1;
        private int bufferSize = 8192;
        private int chunkSizeHint = -1;
        private Timeout waitForContinueTimeout = Http1Config.INIT_WAIT_FOR_CONTINUE;
        private int maxLineLength = -1;
        private int maxHeaderCount = -1;
        private int maxEmptyLineCount = 10;
        private int initialWindowSize = 65535;

        Builder() {
        }

        public Builder setVersion(HttpVersion httpVersion) {
            Args.notNull(httpVersion, "HTTP/1 protocol version");
            Args.check(httpVersion.getMajor() == 1, "HTTP/1 protocol version is required");
            this.version = httpVersion;
            return this;
        }

        public Builder setBufferSize(int i) {
            this.bufferSize = i;
            return this;
        }

        public Builder setChunkSizeHint(int i) {
            this.chunkSizeHint = i;
            return this;
        }

        public Builder setWaitForContinueTimeout(Timeout timeout) {
            this.waitForContinueTimeout = timeout;
            return this;
        }

        public Builder setMaxLineLength(int i) {
            this.maxLineLength = i;
            return this;
        }

        public Builder setMaxHeaderCount(int i) {
            this.maxHeaderCount = i;
            return this;
        }

        public Builder setMaxEmptyLineCount(int i) {
            this.maxEmptyLineCount = i;
            return this;
        }

        public Builder setInitialWindowSize(int i) {
            Args.positive(i, "Initial window size");
            this.initialWindowSize = i;
            return this;
        }

        public Http1Config build() {
            return new Http1Config(this.version, this.bufferSize, this.chunkSizeHint, this.waitForContinueTimeout, this.maxLineLength, this.maxHeaderCount, this.maxEmptyLineCount, this.initialWindowSize);
        }
    }
}
