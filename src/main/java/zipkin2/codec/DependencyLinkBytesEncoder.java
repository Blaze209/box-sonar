package zipkin2.codec;

import java.util.List;
import zipkin2.DependencyLink;
import zipkin2.internal.JsonCodec;
import zipkin2.internal.JsonEscaper;
import zipkin2.internal.WriteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public enum DependencyLinkBytesEncoder implements BytesEncoder<DependencyLink> {
    JSON_V1 { // from class: zipkin2.codec.DependencyLinkBytesEncoder.1
        @Override // zipkin2.codec.BytesEncoder
        public Encoding encoding() {
            return Encoding.JSON;
        }

        @Override // zipkin2.codec.BytesEncoder
        public int sizeInBytes(DependencyLink dependencyLink) {
            return WRITER.sizeInBytes(dependencyLink);
        }

        @Override // zipkin2.codec.BytesEncoder
        public byte[] encode(DependencyLink dependencyLink) {
            return JsonCodec.write(WRITER, dependencyLink);
        }

        @Override // zipkin2.codec.BytesEncoder
        public byte[] encodeList(List<DependencyLink> list) {
            return JsonCodec.writeList(WRITER, list);
        }
    };

    static final WriteBuffer.Writer<DependencyLink> WRITER = new WriteBuffer.Writer<DependencyLink>() { // from class: zipkin2.codec.DependencyLinkBytesEncoder.2
        @Override // zipkin2.internal.WriteBuffer.Writer
        public int sizeInBytes(DependencyLink dependencyLink) {
            int iJsonEscapedSizeInBytes = JsonEscaper.jsonEscapedSizeInBytes(dependencyLink.parent()) + 37 + JsonEscaper.jsonEscapedSizeInBytes(dependencyLink.child()) + WriteBuffer.asciiSizeInBytes(dependencyLink.callCount());
            return dependencyLink.errorCount() > 0 ? iJsonEscapedSizeInBytes + 14 + WriteBuffer.asciiSizeInBytes(dependencyLink.errorCount()) : iJsonEscapedSizeInBytes;
        }

        @Override // zipkin2.internal.WriteBuffer.Writer
        public void write(DependencyLink dependencyLink, WriteBuffer writeBuffer) {
            writeBuffer.writeAscii("{\"parent\":\"");
            writeBuffer.writeUtf8(JsonEscaper.jsonEscape(dependencyLink.parent()));
            writeBuffer.writeAscii("\",\"child\":\"");
            writeBuffer.writeUtf8(JsonEscaper.jsonEscape(dependencyLink.child()));
            writeBuffer.writeAscii("\",\"callCount\":");
            writeBuffer.writeAscii(dependencyLink.callCount());
            if (dependencyLink.errorCount() > 0) {
                writeBuffer.writeAscii(",\"errorCount\":");
                writeBuffer.writeAscii(dependencyLink.errorCount());
            }
            writeBuffer.writeByte(125);
        }

        public String toString() {
            return "DependencyLink";
        }
    };
}
