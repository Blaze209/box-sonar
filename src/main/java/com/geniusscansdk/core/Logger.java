package com.geniusscansdk.core;

import com.box.androidsdk.content.models.BoxRepresentation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\nH&J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0011"}, d2 = {"Lcom/geniusscansdk/core/Logger;", "Lcom/geniusscansdk/core/JNILogger;", "<init>", "()V", "log", "", "message", "", "severity", "Lcom/geniusscansdk/core/JNILoggerSeverity;", "Lcom/geniusscansdk/core/Logger$Severity;", "verbose", BoxRepresentation.FIELD_INFO, "debug", "warn", "error", "Severity", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Logger extends JNILogger {

    /* JADX INFO: compiled from: Logger.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/geniusscansdk/core/Logger$Severity;", "", "<init>", "(Ljava/lang/String;I)V", "Verbose", "Debug", "Info", "Warn", "Error", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum Severity {
        Verbose,
        Debug,
        Info,
        Warn,
        Error;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Severity> getEntries() {
            return $ENTRIES;
        }
    }

    public abstract void log(String message, Severity severity);

    @Override // com.geniusscansdk.core.JNILogger
    public void log(String message, JNILoggerSeverity severity) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(severity, "severity");
        log(message, LoggerKt.fromJNI(severity));
    }

    public final void verbose(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(message, Severity.Verbose);
    }

    public final void info(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(message, Severity.Info);
    }

    public final void debug(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(message, Severity.Debug);
    }

    public final void warn(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(message, Severity.Warn);
    }

    public final void error(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(message, Severity.Error);
    }
}
