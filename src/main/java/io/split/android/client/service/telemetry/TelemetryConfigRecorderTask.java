package io.split.android.client.service.telemetry;

import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.executor.SplitTaskExecutionInfo;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.HttpRecorderException;
import io.split.android.client.service.http.HttpStatus;
import io.split.android.client.telemetry.model.Config;
import io.split.android.client.telemetry.model.OperationType;
import io.split.android.client.telemetry.storage.TelemetryConfigProvider;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import java.util.Collections;

/* JADX INFO: loaded from: classes4.dex */
public class TelemetryConfigRecorderTask implements SplitTask {
    private final TelemetryConfigProvider mTelemetryConfigProvider;
    private final HttpRecorder<Config> mTelemetryConfigRecorder;
    private final TelemetryRuntimeProducer mTelemetryRuntimeProducer;

    public TelemetryConfigRecorderTask(HttpRecorder<Config> telemetryConfigRecorder, TelemetryConfigProvider telemetryConfigProvider, TelemetryRuntimeProducer telemetryRuntimeProducer) {
        this.mTelemetryConfigRecorder = (HttpRecorder) Utils.checkNotNull(telemetryConfigRecorder);
        this.mTelemetryConfigProvider = (TelemetryConfigProvider) Utils.checkNotNull(telemetryConfigProvider);
        this.mTelemetryRuntimeProducer = (TelemetryRuntimeProducer) Utils.checkNotNull(telemetryRuntimeProducer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [io.split.android.client.telemetry.storage.TelemetryRuntimeProducer] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.split.android.client.service.executor.SplitTask
    public SplitTaskExecutionInfo execute() {
        SplitTaskExecutionInfo splitTaskExecutionInfoError;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                this.mTelemetryConfigRecorder.execute(this.mTelemetryConfigProvider.getConfigTelemetry());
                this.mTelemetryRuntimeProducer.recordSuccessfulSync(OperationType.TELEMETRY, System.currentTimeMillis());
                splitTaskExecutionInfoError = SplitTaskExecutionInfo.success(SplitTaskType.TELEMETRY_CONFIG_TASK);
            } catch (HttpRecorderException e) {
                Logger.e(e);
                this.mTelemetryRuntimeProducer.recordSyncError(OperationType.TELEMETRY, e.getHttpStatus());
                if (HttpStatus.isNotRetryable(HttpStatus.fromCode(e.getHttpStatus()))) {
                    splitTaskExecutionInfoError = SplitTaskExecutionInfo.error(SplitTaskType.TELEMETRY_CONFIG_TASK, Collections.singletonMap(SplitTaskExecutionInfo.DO_NOT_RETRY, true));
                } else {
                    splitTaskExecutionInfoError = SplitTaskExecutionInfo.error(SplitTaskType.TELEMETRY_CONFIG_TASK);
                }
            }
            return splitTaskExecutionInfoError;
        } finally {
            this.mTelemetryRuntimeProducer.recordSyncLatency(OperationType.TELEMETRY, System.currentTimeMillis() - jCurrentTimeMillis);
        }
    }
}
