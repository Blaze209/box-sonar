package com.box.android.utilities;

import kotlin.Metadata;

/* JADX INFO: compiled from: OOMErrorsLoggingHelper.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\b"}, d2 = {"Lcom/box/android/utilities/OOMErrorsLoggingHelper;", "", "<init>", "()V", "initLoggingAllOOMsTogether", "", "createUnifiedOOM", "Ljava/lang/OutOfMemoryError;", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OOMErrorsLoggingHelper {
    public static final int $stable = 0;
    public static final OOMErrorsLoggingHelper INSTANCE = new OOMErrorsLoggingHelper();

    private OOMErrorsLoggingHelper() {
    }

    public final void initLoggingAllOOMsTogether() {
        final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.box.android.utilities.OOMErrorsLoggingHelper$$ExternalSyntheticLambda0
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                OOMErrorsLoggingHelper.initLoggingAllOOMsTogether$lambda$0(defaultUncaughtExceptionHandler, thread, th);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLoggingAllOOMsTogether$lambda$0(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th) {
        if (!(th instanceof OutOfMemoryError)) {
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } else {
            OutOfMemoryError outOfMemoryErrorCreateUnifiedOOM = INSTANCE.createUnifiedOOM();
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, outOfMemoryErrorCreateUnifiedOOM);
            }
        }
    }

    private final OutOfMemoryError createUnifiedOOM() {
        Runtime runtime = Runtime.getRuntime();
        long j = 1024;
        OutOfMemoryError outOfMemoryError = new OutOfMemoryError("Application ran out of memory. " + ("Used = " + (((runtime.totalMemory() - runtime.freeMemory()) / j) / j) + "mb, max = " + ((runtime.maxMemory() / j) / j) + "mb, free = " + ((runtime.freeMemory() / j) / j) + "mb"));
        outOfMemoryError.setStackTrace(new StackTraceElement[]{new StackTraceElement(getClass().getName(), "createUnifiedOOM", getClass().getSimpleName(), 57005)});
        return outOfMemoryError;
    }
}
