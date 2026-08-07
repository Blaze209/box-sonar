package com.box.cirrus.providers;

import com.box.androidsdk.content.utils.BoxLogUtils;
import com.margelo.nitro.boxcontext.LoggingSeverity;
import com.margelo.nitro.boxcontext.providers.LoggingProvider;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxLoggingProvider.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/cirrus/providers/BoxLoggingProvider;", "Lcom/margelo/nitro/boxcontext/providers/LoggingProvider;", "<init>", "()V", "log", "", "severity", "Lcom/margelo/nitro/boxcontext/LoggingSeverity;", "message", "", "Companion", "cirrus_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxLoggingProvider implements LoggingProvider {
    private static final String TAG = "XPlatform";

    /* JADX INFO: compiled from: BoxLoggingProvider.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoggingSeverity.values().length];
            try {
                iArr[LoggingSeverity.DEBUG_LVL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoggingSeverity.INFO_LVL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoggingSeverity.WARN_LVL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoggingSeverity.ERROR_LVL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.margelo.nitro.boxcontext.providers.LoggingProvider
    public void log(LoggingSeverity severity, String message) {
        Intrinsics.checkNotNullParameter(severity, "severity");
        Intrinsics.checkNotNullParameter(message, "message");
        int i = WhenMappings.$EnumSwitchMapping$0[severity.ordinal()];
        int i2 = 3;
        if (i != 1) {
            if (i == 2) {
                i2 = 4;
            } else if (i == 3) {
                i2 = 5;
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                i2 = 6;
            }
        }
        BoxLogUtils.log(i2, TAG, message);
    }
}
