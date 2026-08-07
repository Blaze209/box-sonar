package org.apache.hc.core5.reactor.ssl;

import java.nio.ByteBuffer;
import org.apache.hc.core5.util.Args;

/* JADX INFO: loaded from: classes5.dex */
abstract class SSLManagedBuffer {
    abstract ByteBuffer acquire();

    abstract boolean hasData();

    abstract boolean isAcquired();

    abstract void release();

    SSLManagedBuffer() {
    }

    static SSLManagedBuffer create(SSLBufferMode sSLBufferMode, int i) {
        return sSLBufferMode == SSLBufferMode.DYNAMIC ? new DynamicBuffer(i) : new StaticBuffer(i);
    }

    static final class StaticBuffer extends SSLManagedBuffer {
        private final ByteBuffer buffer;

        @Override // org.apache.hc.core5.reactor.ssl.SSLManagedBuffer
        public boolean isAcquired() {
            return true;
        }

        @Override // org.apache.hc.core5.reactor.ssl.SSLManagedBuffer
        public void release() {
        }

        public StaticBuffer(int i) {
            Args.positive(i, "size");
            this.buffer = ByteBuffer.allocate(i);
        }

        @Override // org.apache.hc.core5.reactor.ssl.SSLManagedBuffer
        public ByteBuffer acquire() {
            return this.buffer;
        }

        @Override // org.apache.hc.core5.reactor.ssl.SSLManagedBuffer
        public boolean hasData() {
            return this.buffer.position() > 0;
        }
    }

    static final class DynamicBuffer extends SSLManagedBuffer {
        private final int length;
        private ByteBuffer wrapped;

        public DynamicBuffer(int i) {
            Args.positive(i, "size");
            this.length = i;
        }

        @Override // org.apache.hc.core5.reactor.ssl.SSLManagedBuffer
        public ByteBuffer acquire() {
            ByteBuffer byteBuffer = this.wrapped;
            if (byteBuffer != null) {
                return byteBuffer;
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.length);
            this.wrapped = byteBufferAllocate;
            return byteBufferAllocate;
        }

        @Override // org.apache.hc.core5.reactor.ssl.SSLManagedBuffer
        public void release() {
            this.wrapped = null;
        }

        @Override // org.apache.hc.core5.reactor.ssl.SSLManagedBuffer
        public boolean isAcquired() {
            return this.wrapped != null;
        }

        @Override // org.apache.hc.core5.reactor.ssl.SSLManagedBuffer
        public boolean hasData() {
            ByteBuffer byteBuffer = this.wrapped;
            return byteBuffer != null && byteBuffer.position() > 0;
        }
    }
}
