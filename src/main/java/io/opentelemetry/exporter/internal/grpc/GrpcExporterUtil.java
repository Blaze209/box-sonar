package io.opentelemetry.exporter.internal.grpc;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class GrpcExporterUtil {
    static void logUnimplemented(Logger logger, String str, @Nullable String str2) {
        String str3;
        str.hashCode();
        switch (str) {
            case "metric":
                str3 = "OTEL_METRICS_EXPORTER";
                break;
            case "log":
                str3 = "OTEL_LOGS_EXPORTER";
                break;
            case "span":
                str3 = "OTEL_TRACES_EXPORTER";
                break;
            default:
                throw new IllegalStateException("Unrecognized type, this is a programming bug in the OpenTelemetry SDK");
        }
        logger.log(Level.SEVERE, "Failed to export " + str + "s. Server responded with UNIMPLEMENTED. This usually means that your collector is not configured with an otlp receiver in the \"pipelines\" section of the configuration. If export is not desired and you are using OpenTelemetry autoconfiguration or the javaagent, disable export by setting " + str3 + "=none. Full error message: " + str2);
    }

    private GrpcExporterUtil() {
    }
}
