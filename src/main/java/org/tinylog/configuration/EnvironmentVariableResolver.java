package org.tinylog.configuration;

/* JADX INFO: loaded from: classes5.dex */
public final class EnvironmentVariableResolver implements Resolver {
    public static final EnvironmentVariableResolver INSTANCE = new EnvironmentVariableResolver();

    @Override // org.tinylog.configuration.Resolver
    public char getPrefix() {
        return '$';
    }

    private EnvironmentVariableResolver() {
    }

    @Override // org.tinylog.configuration.Resolver
    public String getName() {
        return "environment variables";
    }

    @Override // org.tinylog.configuration.Resolver
    public String resolve(String str) {
        return System.getenv(str);
    }
}
