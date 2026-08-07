package io.opentelemetry.exporter.internal.retry;

import io.opentelemetry.exporter.internal.grpc.GrpcExporterBuilder;
import io.opentelemetry.exporter.internal.grpc.GrpcStatusUtil;
import io.opentelemetry.exporter.internal.okhttp.OkHttpExporterBuilder;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class RetryUtil {
    private static final Set<String> RETRYABLE_GRPC_STATUS_CODES;
    private static final Set<Integer> RETRYABLE_HTTP_STATUS_CODES = Collections.unmodifiableSet(new HashSet(Arrays.asList(429, 502, 503, 504)));

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("1");
        hashSet.add(GrpcStatusUtil.GRPC_STATUS_DEADLINE_EXCEEDED);
        hashSet.add(GrpcStatusUtil.GRPC_STATUS_RESOURCE_EXHAUSTED);
        hashSet.add(GrpcStatusUtil.GRPC_STATUS_ABORTED);
        hashSet.add(GrpcStatusUtil.GRPC_STATUS_OUT_OF_RANGE);
        hashSet.add(GrpcStatusUtil.GRPC_STATUS_UNAVAILABLE);
        hashSet.add(GrpcStatusUtil.GRPC_STATUS_DATA_LOSS);
        RETRYABLE_GRPC_STATUS_CODES = Collections.unmodifiableSet(hashSet);
    }

    private RetryUtil() {
    }

    public static Set<String> retryableGrpcStatusCodes() {
        return RETRYABLE_GRPC_STATUS_CODES;
    }

    public static Set<Integer> retryableHttpResponseCodes() {
        return RETRYABLE_HTTP_STATUS_CODES;
    }

    public static void setRetryPolicyOnDelegate(Object obj, RetryPolicy retryPolicy) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("delegate");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 instanceof GrpcExporterBuilder) {
                ((GrpcExporterBuilder) obj2).setRetryPolicy(retryPolicy);
            } else {
                if (obj2 instanceof OkHttpExporterBuilder) {
                    ((OkHttpExporterBuilder) obj2).setRetryPolicy(retryPolicy);
                    return;
                }
                throw new IllegalArgumentException("delegate field is not type DefaultGrpcExporterBuilder or OkHttpGrpcExporterBuilder");
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalArgumentException("Unable to access delegate reflectively.", e);
        }
    }
}
