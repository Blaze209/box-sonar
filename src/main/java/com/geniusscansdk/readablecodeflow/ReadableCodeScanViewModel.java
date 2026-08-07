package com.geniusscansdk.readablecodeflow;

import androidx.lifecycle.ViewModel;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.geniusscansdk.structureddata.ReadableCode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* JADX INFO: compiled from: ReadableCodeScanViewModel.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001aJ\u0014\u0010!\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015J\u0016\u0010#\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0016\u0010$\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010&\u001a\u00020'R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\rR\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "isBatchModeEnabled", "", "()Z", "_scanResult", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel$ScanState;", "scanResult", "Lkotlinx/coroutines/flow/StateFlow;", "getScanResult", "()Lkotlinx/coroutines/flow/StateFlow;", "_shouldShowBatchBottomSheet", "shouldShowBatchBottomSheet", "getShouldShowBatchBottomSheet", "_shouldVibrate", "shouldVibrate", "getShouldVibrate", "_detectedCodes", "", "Lcom/geniusscansdk/structureddata/ReadableCode;", "detectedCodes", "getDetectedCodes", "configuration", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeConfiguration;", "seenCodes", "", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel$CodeKey;", "initialize", "", "config", "onCodesDetected", "codes", "handleSimpleModeDetection", "handleBatchModeDetection", "finishBatchScanning", "getDetectedCodesCount", "", "CodeKey", "ScanState", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReadableCodeScanViewModel extends ViewModel {
    private final MutableStateFlow<List<ReadableCode>> _detectedCodes;
    private final MutableStateFlow<ScanState> _scanResult;
    private final MutableStateFlow<Boolean> _shouldShowBatchBottomSheet;
    private final MutableStateFlow<Boolean> _shouldVibrate;
    private ReadableCodeConfiguration configuration;
    private final StateFlow<List<ReadableCode>> detectedCodes;
    private final StateFlow<ScanState> scanResult;
    private final Set<CodeKey> seenCodes;
    private final StateFlow<Boolean> shouldShowBatchBottomSheet;
    private final StateFlow<Boolean> shouldVibrate;

    public ReadableCodeScanViewModel() {
        MutableStateFlow<ScanState> MutableStateFlow = StateFlowKt.MutableStateFlow(ScanState.Scanning.INSTANCE);
        this._scanResult = MutableStateFlow;
        this.scanResult = FlowKt.asStateFlow(MutableStateFlow);
        MutableStateFlow<Boolean> MutableStateFlow2 = StateFlowKt.MutableStateFlow(false);
        this._shouldShowBatchBottomSheet = MutableStateFlow2;
        this.shouldShowBatchBottomSheet = FlowKt.asStateFlow(MutableStateFlow2);
        MutableStateFlow<Boolean> MutableStateFlow3 = StateFlowKt.MutableStateFlow(false);
        this._shouldVibrate = MutableStateFlow3;
        this.shouldVibrate = FlowKt.asStateFlow(MutableStateFlow3);
        MutableStateFlow<List<ReadableCode>> MutableStateFlow4 = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
        this._detectedCodes = MutableStateFlow4;
        this.detectedCodes = FlowKt.asStateFlow(MutableStateFlow4);
        this.seenCodes = new LinkedHashSet();
    }

    public final boolean isBatchModeEnabled() {
        ReadableCodeConfiguration readableCodeConfiguration = this.configuration;
        if (readableCodeConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configuration");
            readableCodeConfiguration = null;
        }
        return readableCodeConfiguration.isBatchModeEnabled();
    }

    public final StateFlow<ScanState> getScanResult() {
        return this.scanResult;
    }

    public final StateFlow<Boolean> getShouldShowBatchBottomSheet() {
        return this.shouldShowBatchBottomSheet;
    }

    public final StateFlow<Boolean> getShouldVibrate() {
        return this.shouldVibrate;
    }

    public final StateFlow<List<ReadableCode>> getDetectedCodes() {
        return this.detectedCodes;
    }

    /* JADX INFO: compiled from: ReadableCodeScanViewModel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel$CodeKey;", "", "value", "", "type", "Lcom/geniusscansdk/structureddata/ReadableCode$Type;", "<init>", "(Ljava/lang/String;Lcom/geniusscansdk/structureddata/ReadableCode$Type;)V", "getValue", "()Ljava/lang/String;", "getType", "()Lcom/geniusscansdk/structureddata/ReadableCode$Type;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final /* data */ class CodeKey {
        private final ReadableCode.Type type;
        private final String value;

        public static /* synthetic */ CodeKey copy$default(CodeKey codeKey, String str, ReadableCode.Type type, int i, Object obj) {
            if ((i & 1) != 0) {
                str = codeKey.value;
            }
            if ((i & 2) != 0) {
                type = codeKey.type;
            }
            return codeKey.copy(str, type);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getValue() {
            return this.value;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ReadableCode.Type getType() {
            return this.type;
        }

        public final CodeKey copy(String value, ReadableCode.Type type) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(type, "type");
            return new CodeKey(value, type);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CodeKey)) {
                return false;
            }
            CodeKey codeKey = (CodeKey) other;
            return Intrinsics.areEqual(this.value, codeKey.value) && this.type == codeKey.type;
        }

        public int hashCode() {
            return (this.value.hashCode() * 31) + this.type.hashCode();
        }

        public String toString() {
            return "CodeKey(value=" + this.value + ", type=" + this.type + ")";
        }

        public CodeKey(String value, ReadableCode.Type type) {
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(type, "type");
            this.value = value;
            this.type = type;
        }

        public final ReadableCode.Type getType() {
            return this.type;
        }

        public final String getValue() {
            return this.value;
        }
    }

    /* JADX INFO: compiled from: ReadableCodeScanViewModel.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel$ScanState;", "", "<init>", "()V", "Scanning", "Success", "Error", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel$ScanState$Error;", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel$ScanState$Scanning;", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel$ScanState$Success;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class ScanState {
        public /* synthetic */ ScanState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: ReadableCodeScanViewModel.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel$ScanState$Scanning;", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel$ScanState;", "<init>", "()V", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Scanning extends ScanState {
            public static final Scanning INSTANCE = new Scanning();

            private Scanning() {
                super(null);
            }
        }

        private ScanState() {
        }

        /* JADX INFO: compiled from: ReadableCodeScanViewModel.kt */
        @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel$ScanState$Success;", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel$ScanState;", "codes", "", "Lcom/geniusscansdk/structureddata/ReadableCode;", "<init>", "(Ljava/util/List;)V", "getCodes", "()Ljava/util/List;", "component1", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Success extends ScanState {
            private final List<ReadableCode> codes;

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Success copy$default(Success success, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = success.codes;
                }
                return success.copy(list);
            }

            public final List<ReadableCode> component1() {
                return this.codes;
            }

            public final Success copy(List<ReadableCode> codes) {
                Intrinsics.checkNotNullParameter(codes, "codes");
                return new Success(codes);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Success) && Intrinsics.areEqual(this.codes, ((Success) other).codes);
            }

            public int hashCode() {
                return this.codes.hashCode();
            }

            public String toString() {
                return "Success(codes=" + this.codes + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(List<ReadableCode> codes) {
                super(null);
                Intrinsics.checkNotNullParameter(codes, "codes");
                this.codes = codes;
            }

            public final List<ReadableCode> getCodes() {
                return this.codes;
            }
        }

        /* JADX INFO: compiled from: ReadableCodeScanViewModel.kt */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel$ScanState$Error;", "Lcom/geniusscansdk/readablecodeflow/ReadableCodeScanViewModel$ScanState;", "errorType", "Lcom/geniusscansdk/readablecodeflow/ErrorType;", "message", "", "<init>", "(Lcom/geniusscansdk/readablecodeflow/ErrorType;Ljava/lang/String;)V", "getErrorType", "()Lcom/geniusscansdk/readablecodeflow/ErrorType;", "getMessage", "()Ljava/lang/String;", "component1", "component2", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "", "hashCode", "", "toString", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class Error extends ScanState {
            private final ErrorType errorType;
            private final String message;

            public static /* synthetic */ Error copy$default(Error error, ErrorType errorType, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    errorType = error.errorType;
                }
                if ((i & 2) != 0) {
                    str = error.message;
                }
                return error.copy(errorType, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ErrorType getErrorType() {
                return this.errorType;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            public final Error copy(ErrorType errorType, String message) {
                Intrinsics.checkNotNullParameter(errorType, "errorType");
                Intrinsics.checkNotNullParameter(message, "message");
                return new Error(errorType, message);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Error)) {
                    return false;
                }
                Error error = (Error) other;
                return this.errorType == error.errorType && Intrinsics.areEqual(this.message, error.message);
            }

            public int hashCode() {
                return (this.errorType.hashCode() * 31) + this.message.hashCode();
            }

            public String toString() {
                return "Error(errorType=" + this.errorType + ", message=" + this.message + ")";
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(ErrorType errorType, String message) {
                super(null);
                Intrinsics.checkNotNullParameter(errorType, "errorType");
                Intrinsics.checkNotNullParameter(message, "message");
                this.errorType = errorType;
                this.message = message;
            }

            public final ErrorType getErrorType() {
                return this.errorType;
            }

            public final String getMessage() {
                return this.message;
            }
        }
    }

    public final void initialize(ReadableCodeConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config.getSupportedCodeTypes().isEmpty()) {
            this._scanResult.setValue(new ScanState.Error(ErrorType.CONFIGURATION_ERROR, "No barcode types configured for scanning"));
            return;
        }
        this.configuration = config;
        if (config.isBatchModeEnabled()) {
            this._shouldShowBatchBottomSheet.setValue(true);
        }
    }

    public final void onCodesDetected(List<ReadableCode> codes) {
        Intrinsics.checkNotNullParameter(codes, "codes");
        if (codes.isEmpty()) {
            return;
        }
        ReadableCodeConfiguration readableCodeConfiguration = this.configuration;
        if (readableCodeConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("configuration");
            readableCodeConfiguration = null;
        }
        if (readableCodeConfiguration.isBatchModeEnabled()) {
            handleBatchModeDetection(codes);
        } else {
            handleSimpleModeDetection(codes);
        }
    }

    private final void handleSimpleModeDetection(List<ReadableCode> codes) {
        this._scanResult.setValue(new ScanState.Success(codes));
    }

    private final void handleBatchModeDetection(List<ReadableCode> codes) {
        ArrayList arrayList = new ArrayList();
        List<ReadableCode> value = this._detectedCodes.getValue();
        for (ReadableCode readableCode : codes) {
            if (this.seenCodes.add(new CodeKey(readableCode.getValue(), readableCode.getType()))) {
                arrayList.add(readableCode);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty()) {
            this._detectedCodes.setValue(CollectionsKt.plus((Collection) arrayList2, (Iterable) value));
            this._shouldVibrate.setValue(true);
        }
        this._shouldVibrate.setValue(false);
    }

    public final void finishBatchScanning() {
        this._scanResult.setValue(new ScanState.Success(this._detectedCodes.getValue()));
    }

    public final int getDetectedCodesCount() {
        return this._detectedCodes.getValue().size();
    }
}
