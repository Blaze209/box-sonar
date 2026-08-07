package org.apache.hc.core5.http.io;

import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;
import org.apache.hc.core5.util.Args;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public class SocketConfig {
    private final int backlogSize;
    private final int rcvBufSize;
    private final int sndBufSize;
    private final boolean soKeepAlive;
    private final TimeValue soLinger;
    private final boolean soReuseAddress;
    private final Timeout soTimeout;
    private final SocketAddress socksProxyAddress;
    private final int tcpKeepCount;
    private final int tcpKeepIdle;
    private final int tcpKeepInterval;
    private final boolean tcpNoDelay;
    private static final Timeout DEFAULT_SOCKET_TIMEOUT = Timeout.ofMinutes(3L);
    public static final SocketConfig DEFAULT = new Builder().build();

    SocketConfig(Timeout timeout, boolean z, TimeValue timeValue, boolean z2, boolean z3, int i, int i2, int i3, int i4, int i5, int i6, SocketAddress socketAddress) {
        this.soTimeout = timeout;
        this.soReuseAddress = z;
        this.soLinger = timeValue;
        this.soKeepAlive = z2;
        this.tcpNoDelay = z3;
        this.sndBufSize = i;
        this.rcvBufSize = i2;
        this.backlogSize = i3;
        this.tcpKeepIdle = i4;
        this.tcpKeepInterval = i5;
        this.tcpKeepCount = i6;
        this.socksProxyAddress = socketAddress;
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

    public boolean isTcpNoDelay() {
        return this.tcpNoDelay;
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

    public String toString() {
        StringBuilder sb = new StringBuilder("[soTimeout=");
        sb.append(this.soTimeout).append(", soReuseAddress=").append(this.soReuseAddress).append(", soLinger=").append(this.soLinger).append(", soKeepAlive=").append(this.soKeepAlive).append(", tcpNoDelay=").append(this.tcpNoDelay).append(", sndBufSize=").append(this.sndBufSize).append(", rcvBufSize=").append(this.rcvBufSize).append(", backlogSize=").append(this.backlogSize).append(", tcpKeepIdle=").append(this.tcpKeepIdle).append(", tcpKeepInterval=").append(this.tcpKeepInterval).append(", tcpKeepCount=").append(this.tcpKeepCount).append(", socksProxyAddress=").append(this.socksProxyAddress).append("]");
        return sb.toString();
    }

    public static Builder custom() {
        return new Builder();
    }

    public static Builder copy(SocketConfig socketConfig) {
        Args.notNull(socketConfig, "Socket config");
        return new Builder().setSoTimeout(socketConfig.getSoTimeout()).setSoReuseAddress(socketConfig.isSoReuseAddress()).setSoLinger(socketConfig.getSoLinger()).setSoKeepAlive(socketConfig.isSoKeepAlive()).setTcpNoDelay(socketConfig.isTcpNoDelay()).setSndBufSize(socketConfig.getSndBufSize()).setRcvBufSize(socketConfig.getRcvBufSize()).setBacklogSize(socketConfig.getBacklogSize()).setTcpKeepIdle(socketConfig.getTcpKeepIdle()).setTcpKeepInterval(socketConfig.getTcpKeepInterval()).setTcpKeepCount(socketConfig.getTcpKeepCount()).setSocksProxyAddress(socketConfig.getSocksProxyAddress());
    }

    public static class Builder {
        private Timeout soTimeout = SocketConfig.DEFAULT_SOCKET_TIMEOUT;
        private boolean soReuseAddress = false;
        private TimeValue soLinger = TimeValue.NEG_ONE_SECOND;
        private boolean soKeepAlive = false;
        private boolean tcpNoDelay = true;
        private int sndBufSize = 0;
        private int rcvBufSize = 0;
        private int backlogSize = 0;
        private int tcpKeepIdle = -1;
        private int tcpKeepInterval = -1;
        private int tcpKeepCount = -1;
        private SocketAddress socksProxyAddress = null;

        Builder() {
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
            this.soLinger = Timeout.of(i, timeUnit);
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

        public SocketConfig build() {
            Timeout timeoutDefaultsToInfinite = Timeout.defaultsToInfinite(this.soTimeout);
            boolean z = this.soReuseAddress;
            TimeValue timeValue = this.soLinger;
            if (timeValue == null) {
                timeValue = TimeValue.NEG_ONE_SECOND;
            }
            return new SocketConfig(timeoutDefaultsToInfinite, z, timeValue, this.soKeepAlive, this.tcpNoDelay, this.sndBufSize, this.rcvBufSize, this.backlogSize, this.tcpKeepIdle, this.tcpKeepInterval, this.tcpKeepCount, this.socksProxyAddress);
        }
    }
}
