package org.yaml.snakeyaml.internal;

/* JADX INFO: loaded from: classes5.dex */
public class Logger {
    private final java.util.logging.Logger logger;

    public enum Level {
        WARNING(java.util.logging.Level.FINE);

        private final java.util.logging.Level level;

        Level(java.util.logging.Level level) {
            this.level = level;
        }
    }

    private Logger(String str) {
        this.logger = java.util.logging.Logger.getLogger(str);
    }

    public static Logger getLogger(String str) {
        return new Logger(str);
    }

    public boolean isLoggable(Level level) {
        return this.logger.isLoggable(level.level);
    }

    public void warn(String str) {
        this.logger.log(Level.WARNING.level, str);
    }
}
