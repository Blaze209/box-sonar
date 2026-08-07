package io.opentelemetry.exporter.internal.grpc;

import io.opentelemetry.exporter.internal.marshal.CodedInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public final class GrpcStatusUtil {
    public static final String GRPC_STATUS_ABORTED = "10";
    public static final String GRPC_STATUS_CANCELLED = "1";
    public static final String GRPC_STATUS_DATA_LOSS = "15";
    public static final String GRPC_STATUS_DEADLINE_EXCEEDED = "4";
    public static final String GRPC_STATUS_OUT_OF_RANGE = "11";
    public static final String GRPC_STATUS_RESOURCE_EXHAUSTED = "8";
    public static final String GRPC_STATUS_UNAVAILABLE = "14";
    public static final String GRPC_STATUS_UNIMPLEMENTED = "12";

    public static String getStatusMessage(byte[] bArr) throws IOException {
        CodedInputStream codedInputStreamNewInstance = CodedInputStream.newInstance(bArr);
        boolean z = false;
        while (!z) {
            int tag = codedInputStreamNewInstance.readTag();
            if (tag == 0) {
                z = true;
            } else {
                if (tag == 18) {
                    return codedInputStreamNewInstance.readStringRequireUtf8();
                }
                codedInputStreamNewInstance.skipField(tag);
            }
        }
        return "";
    }

    private GrpcStatusUtil() {
    }
}
