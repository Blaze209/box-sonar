package com.box.android.capture.documentscanning.logic;

import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.domain.services.IGeniusScanLicenseService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.geniusscansdk.core.GeniusScanSDK;
import com.geniusscansdk.core.LicenseException;
import com.geniusscansdk.core.Logger;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GeniusScanLicenseInitializer.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001:\u0001\tB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/GeniusScanLicenseInitializer;", "", "geniusScanLicenseService", "Lcom/box/android/domain/services/IGeniusScanLicenseService;", "<init>", "(Lcom/box/android/domain/services/IGeniusScanLicenseService;)V", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "BoxLoggerProxy", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GeniusScanLicenseInitializer {
    public static final int $stable = 8;
    private final IGeniusScanLicenseService geniusScanLicenseService;

    /* JADX INFO: renamed from: com.box.android.capture.documentscanning.logic.GeniusScanLicenseInitializer$initialize$1, reason: invalid class name */
    /* JADX INFO: compiled from: GeniusScanLicenseInitializer.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.capture.documentscanning.logic.GeniusScanLicenseInitializer", f = "GeniusScanLicenseInitializer.kt", i = {}, l = {16}, m = "initialize", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GeniusScanLicenseInitializer.this.initialize(this);
        }
    }

    @Inject
    public GeniusScanLicenseInitializer(IGeniusScanLicenseService geniusScanLicenseService) {
        Intrinsics.checkNotNullParameter(geniusScanLicenseService, "geniusScanLicenseService");
        this.geniusScanLicenseService = geniusScanLicenseService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object initialize(Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object licenseKey = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(licenseKey);
            IGeniusScanLicenseService iGeniusScanLicenseService = this.geniusScanLicenseService;
            anonymousClass1.label = 1;
            licenseKey = iGeniusScanLicenseService.getLicenseKey(anonymousClass1);
            if (licenseKey == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(licenseKey);
        }
        Result result = (Result) licenseKey;
        if (!(result instanceof Result.Success)) {
            BoxLogUtils.e("GeniusScanLicenseInitializer", "Failed to fetch GeniusScan license due to " + result);
            return Boxing.boxBoolean(false);
        }
        try {
            GeniusScanSDK.setLogger(BoxLoggerProxy.INSTANCE);
            GeniusScanSDK.setLicenseKey(ApplicationProvider.getApplication(), (String) ((Result.Success) result).getValue());
        } catch (LicenseException e) {
            BoxLogUtils.e("GeniusScanLicenseInitializer", "Failed to initialize GeniusScan with license: " + result, e);
            z = false;
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: compiled from: GeniusScanLicenseInitializer.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/box/android/capture/documentscanning/logic/GeniusScanLicenseInitializer$BoxLoggerProxy;", "Lcom/geniusscansdk/core/Logger;", "<init>", "()V", "log", "", "message", "", "severity", "Lcom/geniusscansdk/core/Logger$Severity;", "capture_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class BoxLoggerProxy extends Logger {
        public static final BoxLoggerProxy INSTANCE = new BoxLoggerProxy();

        /* JADX INFO: compiled from: GeniusScanLicenseInitializer.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Logger.Severity.values().length];
                try {
                    iArr[Logger.Severity.Verbose.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Logger.Severity.Debug.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Logger.Severity.Info.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Logger.Severity.Warn.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Logger.Severity.Error.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        private BoxLoggerProxy() {
        }

        @Override // com.geniusscansdk.core.Logger
        public void log(String message, Logger.Severity severity) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(severity, "severity");
            int i = WhenMappings.$EnumSwitchMapping$0[severity.ordinal()];
            if (i == 1) {
                BoxLogUtils.v(message);
                return;
            }
            if (i == 2) {
                BoxLogUtils.d(message);
                return;
            }
            if (i == 3) {
                BoxLogUtils.i(message);
                return;
            }
            if (i == 4) {
                BoxLogUtils.w(message);
            } else if (i == 5) {
                BoxLogUtils.e(message);
            } else {
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Unexpected else branch");
            }
        }
    }
}
