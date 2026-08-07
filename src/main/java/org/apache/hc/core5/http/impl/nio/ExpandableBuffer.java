package org.apache.hc.core5.http.impl.nio;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class ExpandableBuffer {
    private ByteBuffer buffer;
    private Mode mode = Mode.INPUT;

    public enum Mode {
        INPUT,
        OUTPUT
    }

    protected ExpandableBuffer(int i) {
        this.buffer = ByteBuffer.allocate(i);
    }

    protected Mode mode() {
        return this.mode;
    }

    protected ByteBuffer buffer() {
        return this.buffer;
    }

    protected void setOutputMode() {
        if (this.mode != Mode.OUTPUT) {
            this.buffer.flip();
            this.mode = Mode.OUTPUT;
        }
    }

    protected void setInputMode() {
        if (this.mode != Mode.INPUT) {
            if (this.buffer.hasRemaining()) {
                this.buffer.compact();
            } else {
                this.buffer.clear();
            }
            this.mode = Mode.INPUT;
        }
    }

    private void expandCapacity(int i) {
        ByteBuffer byteBuffer = this.buffer;
        this.buffer = ByteBuffer.allocate(i);
        byteBuffer.flip();
        this.buffer.put(byteBuffer);
    }

    protected void expand() throws BufferOverflowException {
        int iCapacity = (this.buffer.capacity() + 1) << 1;
        if (iCapacity < 0 && (iCapacity = Integer.MAX_VALUE - Math.max(8, 8)) <= this.buffer.capacity()) {
            throw new BufferOverflowException();
        }
        expandCapacity(iCapacity);
    }

    protected void ensureCapacity(int i) {
        if (i > this.buffer.capacity()) {
            expandCapacity(i);
        }
    }

    protected void ensureAdjustedCapacity(int i) {
        if (i > this.buffer.capacity()) {
            expandCapacity(((i >> 10) + 1) << 10);
        }
    }

    protected boolean hasData() {
        setOutputMode();
        return this.buffer.hasRemaining();
    }

    protected int length() {
        setOutputMode();
        return this.buffer.remaining();
    }

    protected int capacity() {
        setInputMode();
        return this.buffer.remaining();
    }

    protected void clear() {
        this.buffer.clear();
        this.mode = Mode.INPUT;
    }

    public String toString() {
        return "[mode=" + this.mode + " pos=" + this.buffer.position() + " lim=" + this.buffer.limit() + " cap=" + this.buffer.capacity() + "]";
    }
}
