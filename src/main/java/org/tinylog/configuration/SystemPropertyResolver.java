package org.tinylog.configuration;

import com.pspdfkit.contentediting.models.serializer.ColorSerializer;

/* JADX INFO: loaded from: classes5.dex */
public final class SystemPropertyResolver implements Resolver {
    public static final SystemPropertyResolver INSTANCE = new SystemPropertyResolver();

    @Override // org.tinylog.configuration.Resolver
    public char getPrefix() {
        return ColorSerializer.PREFIX;
    }

    private SystemPropertyResolver() {
    }

    @Override // org.tinylog.configuration.Resolver
    public String getName() {
        return "system properties";
    }

    @Override // org.tinylog.configuration.Resolver
    public String resolve(String str) {
        return System.getProperty(str);
    }
}
