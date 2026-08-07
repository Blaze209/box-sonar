package zipkin2.internal;

import kotlin.UShort;
import zipkin2.Endpoint;

/* JADX INFO: loaded from: classes6.dex */
final class ThriftEndpointCodec {
    static final byte[] INT_ZERO = {0, 0, 0, 0};
    static final ThriftField IPV4 = new ThriftField((byte) 8, 1);
    static final ThriftField PORT = new ThriftField((byte) 6, 2);
    static final ThriftField SERVICE_NAME = new ThriftField((byte) 11, 3);
    static final ThriftField IPV6 = new ThriftField((byte) 11, 4);

    ThriftEndpointCodec() {
    }

    static Endpoint read(ReadBuffer readBuffer) {
        Endpoint.Builder builderNewBuilder = Endpoint.newBuilder();
        while (true) {
            ThriftField thriftField = ThriftField.read(readBuffer);
            if (thriftField.type != 0) {
                if (thriftField.isEqualTo(IPV4)) {
                    int i = readBuffer.readInt();
                    if (i != 0) {
                        builderNewBuilder.parseIp(new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)});
                    }
                } else if (thriftField.isEqualTo(PORT)) {
                    builderNewBuilder.port(readBuffer.readShort() & UShort.MAX_VALUE);
                } else if (thriftField.isEqualTo(SERVICE_NAME)) {
                    builderNewBuilder.serviceName(readBuffer.readUtf8(readBuffer.readInt()));
                } else if (thriftField.isEqualTo(IPV6)) {
                    builderNewBuilder.parseIp(readBuffer.readBytes(readBuffer.readInt()));
                } else {
                    ThriftCodec.skip(readBuffer, thriftField.type);
                }
            } else {
                return builderNewBuilder.build();
            }
        }
    }

    static int sizeInBytes(Endpoint endpoint) {
        String strServiceName = endpoint.serviceName();
        int iUtf8SizeInBytes = strServiceName != null ? WriteBuffer.utf8SizeInBytes(strServiceName) : 0;
        int i = iUtf8SizeInBytes + 19;
        if (endpoint.ipv6() != null) {
            i = iUtf8SizeInBytes + 42;
        }
        return i + 1;
    }

    static void write(Endpoint endpoint, WriteBuffer writeBuffer) {
        IPV4.write(writeBuffer);
        writeBuffer.write(endpoint.ipv4Bytes() != null ? endpoint.ipv4Bytes() : INT_ZERO);
        PORT.write(writeBuffer);
        int iPortAsInt = endpoint.portAsInt();
        writeBuffer.writeByte((iPortAsInt >>> 8) & 255);
        writeBuffer.writeByte(iPortAsInt & 255);
        SERVICE_NAME.write(writeBuffer);
        ThriftCodec.writeLengthPrefixed(writeBuffer, endpoint.serviceName() != null ? endpoint.serviceName() : "");
        byte[] bArrIpv6Bytes = endpoint.ipv6Bytes();
        if (bArrIpv6Bytes != null) {
            IPV6.write(writeBuffer);
            ThriftCodec.writeInt(writeBuffer, 16);
            writeBuffer.write(bArrIpv6Bytes);
        }
        writeBuffer.writeByte(0);
    }
}
