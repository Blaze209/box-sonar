package io.opentelemetry.sdk.metrics.internal.debug;

/* JADX INFO: loaded from: classes4.dex */
final class StackTraceSourceInfo implements SourceInfo {
    private final StackTraceElement[] stackTraceElements;

    StackTraceSourceInfo(StackTraceElement[] stackTraceElementArr) {
        this.stackTraceElements = stackTraceElementArr;
    }

    @Override // io.opentelemetry.sdk.metrics.internal.debug.SourceInfo
    public String shortDebugString() {
        StackTraceElement[] stackTraceElementArr = this.stackTraceElements;
        if (stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (isInterestingStackTrace(stackTraceElement)) {
                    return String.format("%s:%d", stackTraceElement.getFileName(), Integer.valueOf(stackTraceElement.getLineNumber()));
                }
            }
            return "unknown source";
        }
        return "unknown source";
    }

    @Override // io.opentelemetry.sdk.metrics.internal.debug.SourceInfo
    public String multiLineDebugString() {
        if (this.stackTraceElements.length > 0) {
            StringBuilder sb = new StringBuilder();
            for (StackTraceElement stackTraceElement : this.stackTraceElements) {
                if (isInterestingStackTrace(stackTraceElement)) {
                    sb.append("\tat ").append(stackTraceElement).append("\n");
                }
            }
            return sb.toString();
        }
        return "\tat unknown source";
    }

    private static boolean isInterestingStackTrace(StackTraceElement stackTraceElement) {
        return (stackTraceElement.getClassName().startsWith("io.opentelemetry.sdk.metrics") || stackTraceElement.getClassName().startsWith("java.lang")) ? false : true;
    }
}
