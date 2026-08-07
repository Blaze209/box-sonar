package org.apache.hc.core5.reactor;

import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public final class IOReactorConfig {
    public static final IOReactorConfig DEFAULT = new Builder().build();
    private final int backlogSize;
    private final int ioThreadCount;
    private final int rcvBufSize;
    private final TimeValue selectInterval;
    private final int sndBufSize;
    private final boolean soKeepAlive;
    private final TimeValue soLinger;
    private final boolean soReuseAddress;
    private final Timeout soTimeout;
    private final SocketAddress socksProxyAddress;
    private final String socksProxyPassword;
    private final String socksProxyUsername;
    private final int tcpKeepCount;
    private final int tcpKeepIdle;
    private final int tcpKeepInterval;
    private final boolean tcpNoDelay;
    private final int trafficClass;

    IOReactorConfig(TimeValue timeValue, int i, Timeout timeout, boolean z, TimeValue timeValue2, boolean z2, boolean z3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, SocketAddress socketAddress, String str, String str2) {
        this.selectInterval = timeValue;
        this.ioThreadCount = i;
        this.soTimeout = timeout;
        this.soReuseAddress = z;
        this.soLinger = timeValue2;
        this.soKeepAlive = z2;
        this.tcpNoDelay = z3;
        this.trafficClass = i2;
        this.sndBufSize = i3;
        this.rcvBufSize = i4;
        this.backlogSize = i5;
        this.tcpKeepIdle = i6;
        this.tcpKeepInterval = i7;
        this.tcpKeepCount = i8;
        this.socksProxyAddress = socketAddress;
        this.socksProxyUsername = str;
        this.socksProxyPassword = str2;
    }

    public TimeValue getSelectInterval() {
        return this.selectInterval;
    }

    public int getIoThreadCount() {
        return this.ioThreadCount;
    }

    public Timeout getSoTimeout() {
        return this.soTimeout;
    }

    public boolean isSoReuseAddress() {
        return this.soReuseAddress;
    }

    public TimeValue getSoLinger() {
        return this.soLinger;
    }

    public boolean isSoKeepAlive() {
        return this.soKeepAlive;
    }

    @Deprecated
    public boolean isSoKeepalive() {
        return this.soKeepAlive;
    }

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
    }

    public int getTrafficClass() {
        return this.trafficClass;
    }

    public int getSndBufSize() {
        return this.sndBufSize;
    }

    public int getRcvBufSize() {
        return this.rcvBufSize;
    }

    public int getBacklogSize() {
        return this.backlogSize;
    }

    public int getTcpKeepIdle() {
        return this.tcpKeepIdle;
    }

    public int getTcpKeepInterval() {
        return this.tcpKeepInterval;
    }

    public int getTcpKeepCount() {
        return this.tcpKeepCount;
    }

    public SocketAddress getSocksProxyAddress() {
        return this.socksProxyAddress;
    }

    public String getSocksProxyUsername() {
        return this.socksProxyUsername;
    }

    public String getSocksProxyPassword() {
        return this.socksProxyPassword;
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(IOReactorConfig iOReactorConfig) {
        Args.notNull(iOReactorConfig, "I/O reactor config");
        return new Builder().setSelectInterval(iOReactorConfig.getSelectInterval()).setIoThreadCount(iOReactorConfig.getIoThreadCount()).setSoTimeout(iOReactorConfig.getSoTimeout()).setSoReuseAddress(iOReactorConfig.isSoReuseAddress()).setSoLinger(iOReactorConfig.getSoLinger()).setSoKeepAlive(iOReactorConfig.isSoKeepAlive()).setTcpNoDelay(iOReactorConfig.isTcpNoDelay()).setSndBufSize(iOReactorConfig.getSndBufSize()).setRcvBufSize(iOReactorConfig.getRcvBufSize()).setBacklogSize(iOReactorConfig.getBacklogSize()).setTcpKeepIdle(iOReactorConfig.getTcpKeepIdle()).setTcpKeepInterval(iOReactorConfig.getTcpKeepInterval()).setTcpKeepCount(iOReactorConfig.getTcpKeepCount()).setSocksProxyAddress(iOReactorConfig.getSocksProxyAddress()).setSocksProxyUsername(iOReactorConfig.getSocksProxyUsername()).setSocksProxyPassword(iOReactorConfig.getSocksProxyPassword());
    }

    public static class Builder {
        private static int defaultMaxIOThreadCount = -1;
        private TimeValue selectInterval = TimeValue.ofSeconds(1);
        private int ioThreadCount = getDefaultMaxIOThreadCount();
        private Timeout soTimeout = Timeout.ZERO_MILLISECONDS;
        private boolean soReuseAddress = false;
        private TimeValue soLinger = TimeValue.NEG_ONE_SECOND;
        private boolean soKeepAlive = false;
        private boolean tcpNoDelay = true;
        private int trafficClass = 0;
        private int sndBufSize = 0;
        private int rcvBufSize = 0;
        private int backlogSize = 0;
        private int tcpKeepIdle = -1;
        private int tcpKeepInterval = -1;
        private int tcpKeepCount = -1;
        private SocketAddress socksProxyAddress = null;
        private String socksProxyUsername = null;
        private String socksProxyPassword = null;

        public static int getDefaultMaxIOThreadCount() {
            int i = defaultMaxIOThreadCount;
            return i > 0 ? i : Runtime.getRuntime().availableProcessors();
        }

        public static void setDefaultMaxIOThreadCount(int i) {
            defaultMaxIOThreadCount = i;
        }

        Builder() {
        }

        public Builder setSelectInterval(TimeValue timeValue) {
            this.selectInterval = timeValue;
            return this;
        }

        public Builder setIoThreadCount(int i) {
            this.ioThreadCount = i;
            return this;
        }

        public Builder setSoTimeout(int i, TimeUnit timeUnit) {
            this.soTimeout = Timeout.of(i, timeUnit);
            return this;
        }

        public Builder setSoTimeout(Timeout timeout) {
            this.soTimeout = timeout;
            return this;
        }

        public Builder setSoReuseAddress(boolean z) {
            this.soReuseAddress = z;
            return this;
        }

        public Builder setSoLinger(int i, TimeUnit timeUnit) {
            this.soLinger = TimeValue.of(i, timeUnit);
            return this;
        }

        public Builder setSoLinger(TimeValue timeValue) {
            this.soLinger = timeValue;
            return this;
        }

        public Builder setSoKeepAlive(boolean z) {
            this.soKeepAlive = z;
            return this;
        }

        public Builder setTcpNoDelay(boolean z) {
            this.tcpNoDelay = z;
            return this;
        }

        public Builder setTrafficClass(int i) {
            this.trafficClass = i;
            return this;
        }

        public Builder setSndBufSize(int i) {
            this.sndBufSize = i;
            return this;
        }

        public Builder setRcvBufSize(int i) {
            this.rcvBufSize = i;
            return this;
        }

        public Builder setBacklogSize(int i) {
            this.backlogSize = i;
            return this;
        }

        public Builder setTcpKeepIdle(int i) {
            this.tcpKeepIdle = i;
            return this;
        }

        public Builder setTcpKeepInterval(int i) {
            this.tcpKeepInterval = i;
            return this;
        }

        public Builder setTcpKeepCount(int i) {
            this.tcpKeepCount = i;
            return this;
        }

        public Builder setSocksProxyAddress(SocketAddress socketAddress) {
            this.socksProxyAddress = socketAddress;
            return this;
        }

        public Builder setSocksProxyUsername(String str) {
            this.socksProxyUsername = str;
            return this;
        }

        public Builder setSocksProxyPassword(String str) {
            this.socksProxyPassword = str;
            return this;
        }

        public IOReactorConfig build() {
            TimeValue timeValueOfSeconds = this.selectInterval;
            if (timeValueOfSeconds == null) {
                timeValueOfSeconds = TimeValue.ofSeconds(1L);
            }
            return new IOReactorConfig(timeValueOfSeconds, this.ioThreadCount, Timeout.defaultsToInfinite(this.soTimeout), this.soReuseAddress, TimeValue.defaultsToNegativeOneMillisecond(this.soLinger), this.soKeepAlive, this.tcpNoDelay, this.trafficClass, this.sndBufSize, this.rcvBufSize, this.backlogSize, this.tcpKeepIdle, this.tcpKeepInterval, this.tcpKeepCount, this.socksProxyAddress, this.socksProxyUsername, this.socksProxyPassword);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[selectInterval=");
        sb.append(this.selectInterval).append(", ioThreadCount=").append(this.ioThreadCount).append(", soTimeout=").append(this.soTimeout).append(", soReuseAddress=").append(this.soReuseAddress).append(", soLinger=").append(this.soLinger).append(", soKeepAlive=").append(this.soKeepAlive).append(", tcpNoDelay=").append(this.tcpNoDelay).append(", trafficClass=").append(this.trafficClass).append(", sndBufSize=").append(this.sndBufSize).append(", rcvBufSize=").append(this.rcvBufSize).append(", backlogSize=").append(this.backlogSize).append(", socksProxyAddress=").append(this.socksProxyAddress).append("]");
        return sb.toString();
    }
}
