package org.tinylog.provider;

import org.tinylog.Level;

/* JADX INFO: loaded from: classes5.dex */
public final class InternalLogger {
    private static final int BUFFER_SIZE = 256;

    private InternalLogger() {
    }

    public static void log(Level level, String str) {
        System.err.println("LOGGER " + level + ": " + str);
    }

    public static void log(Level level, Throwable th) {
        String name = th.getClass().getName();
        String message = th.getMessage();
        if (message == null || message.isEmpty()) {
            System.err.println("LOGGER " + level + ": " + name);
        } else {
            System.err.println("LOGGER " + level + ": " + message + " (" + name + ")");
        }
    }

    public static void log(Level level, Throwable th, String str) {
        String name = th.getClass().getName();
        String message = th.getMessage();
        StringBuilder sb = new StringBuilder(256);
        sb.append("LOGGER ");
        sb.append(level);
        sb.append(": ");
        sb.append(str);
        sb.append(" (");
        sb.append(name);
        if (message != null && !message.isEmpty()) {
            sb.append(": ");
            sb.append(message);
        }
        sb.append(")");
        System.err.println(sb);
    }
}
