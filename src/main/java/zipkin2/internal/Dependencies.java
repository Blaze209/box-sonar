package zipkin2.internal;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import zipkin2.DependencyLink;

/* JADX INFO: loaded from: classes6.dex */
public final class Dependencies {
    final long endTs;
    final List<DependencyLink> links;
    final long startTs;
    static final ThriftField START_TS = new ThriftField((byte) 10, 1);
    static final ThriftField END_TS = new ThriftField((byte) 10, 2);
    static final ThriftField LINKS = new ThriftField(Ascii.SI, 3);
    static final DependencyLinkAdapter DEPENDENCY_LINK_ADAPTER = new DependencyLinkAdapter();

    public List<DependencyLink> links() {
        return this.links;
    }

    public static Dependencies fromThrift(ByteBuffer byteBuffer) {
        List listEmptyList = Collections.emptyList();
        ReadBuffer readBufferWrapUnsafe = ReadBuffer.wrapUnsafe(byteBuffer);
        long j = 0;
        long j2 = 0;
        while (true) {
            ThriftField thriftField = ThriftField.read(readBufferWrapUnsafe);
            if (thriftField.type != 0) {
                if (thriftField.isEqualTo(START_TS)) {
                    j = readBufferWrapUnsafe.readLong();
                } else if (thriftField.isEqualTo(END_TS)) {
                    j2 = readBufferWrapUnsafe.readLong();
                } else if (thriftField.isEqualTo(LINKS)) {
                    int listLength = ThriftCodec.readListLength(readBufferWrapUnsafe);
                    if (listLength != 0) {
                        listEmptyList = new ArrayList(listLength);
                        for (int i = 0; i < listLength; i++) {
                            listEmptyList.add(DependencyLinkAdapter.read(readBufferWrapUnsafe));
                        }
                    }
                } else {
                    ThriftCodec.skip(readBufferWrapUnsafe, thriftField.type);
                }
            } else {
                return create(j, j2, listEmptyList);
            }
        }
    }

    public ByteBuffer toThrift() {
        byte[] bArr = new byte[sizeInBytes()];
        write(WriteBuffer.wrap(bArr));
        return ByteBuffer.wrap(bArr);
    }

    int sizeInBytes() {
        return ThriftCodec.listSizeInBytes(DEPENDENCY_LINK_ADAPTER, this.links) + 26;
    }

    void write(WriteBuffer writeBuffer) {
        START_TS.write(writeBuffer);
        ThriftCodec.writeLong(writeBuffer, this.startTs);
        END_TS.write(writeBuffer);
        ThriftCodec.writeLong(writeBuffer, this.endTs);
        LINKS.write(writeBuffer);
        ThriftCodec.writeList(DEPENDENCY_LINK_ADAPTER, this.links, writeBuffer);
        writeBuffer.writeByte(0);
    }

    public static Dependencies create(long j, long j2, List<DependencyLink> list) {
        return new Dependencies(j, j2, list);
    }

    Dependencies(long j, long j2, List<DependencyLink> list) {
        this.startTs = j;
        this.endTs = j2;
        if (list == null) {
            throw new NullPointerException("links == null");
        }
        this.links = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Dependencies)) {
            return false;
        }
        Dependencies dependencies = (Dependencies) obj;
        return this.startTs == dependencies.startTs && this.endTs == dependencies.endTs && this.links.equals(dependencies.links);
    }

    public int hashCode() {
        long j = this.startTs;
        int i = (((int) (((long) 1000003) ^ (j ^ (j >>> 32)))) ^ 1000003) * 1000003;
        long j2 = this.endTs;
        return this.links.hashCode() ^ ((i ^ ((int) (((long) i) ^ ((j2 >>> 32) ^ j2)))) * 1000003);
    }

    static final class DependencyLinkAdapter implements WriteBuffer.Writer<DependencyLink> {
        static final ThriftField PARENT = new ThriftField((byte) 11, 1);
        static final ThriftField CHILD = new ThriftField((byte) 11, 2);
        static final ThriftField CALL_COUNT = new ThriftField((byte) 10, 4);
        static final ThriftField ERROR_COUNT = new ThriftField((byte) 10, 5);

        DependencyLinkAdapter() {
        }

        static DependencyLink read(ReadBuffer readBuffer) {
            DependencyLink.Builder builderNewBuilder = DependencyLink.newBuilder();
            while (true) {
                ThriftField thriftField = ThriftField.read(readBuffer);
                if (thriftField.type != 0) {
                    if (thriftField.isEqualTo(PARENT)) {
                        builderNewBuilder.parent(readBuffer.readUtf8(readBuffer.readInt()));
                    } else if (thriftField.isEqualTo(CHILD)) {
                        builderNewBuilder.child(readBuffer.readUtf8(readBuffer.readInt()));
                    } else if (thriftField.isEqualTo(CALL_COUNT)) {
                        builderNewBuilder.callCount(readBuffer.readLong());
                    } else if (thriftField.isEqualTo(ERROR_COUNT)) {
                        builderNewBuilder.errorCount(readBuffer.readLong());
                    } else {
                        ThriftCodec.skip(readBuffer, thriftField.type);
                    }
                } else {
                    return builderNewBuilder.build();
                }
            }
        }

        @Override // zipkin2.internal.WriteBuffer.Writer
        public int sizeInBytes(DependencyLink dependencyLink) {
            int iUtf8SizeInBytes = WriteBuffer.utf8SizeInBytes(dependencyLink.parent()) + 7 + WriteBuffer.utf8SizeInBytes(dependencyLink.child()) + 7;
            int i = iUtf8SizeInBytes + 11;
            if (dependencyLink.errorCount() > 0) {
                i = iUtf8SizeInBytes + 22;
            }
            return i + 1;
        }

        @Override // zipkin2.internal.WriteBuffer.Writer
        public void write(DependencyLink dependencyLink, WriteBuffer writeBuffer) {
            PARENT.write(writeBuffer);
            ThriftCodec.writeLengthPrefixed(writeBuffer, dependencyLink.parent());
            CHILD.write(writeBuffer);
            ThriftCodec.writeLengthPrefixed(writeBuffer, dependencyLink.child());
            CALL_COUNT.write(writeBuffer);
            ThriftCodec.writeLong(writeBuffer, dependencyLink.callCount());
            if (dependencyLink.errorCount() > 0) {
                ERROR_COUNT.write(writeBuffer);
                ThriftCodec.writeLong(writeBuffer, dependencyLink.errorCount());
            }
            writeBuffer.writeByte(0);
        }
    }
}
