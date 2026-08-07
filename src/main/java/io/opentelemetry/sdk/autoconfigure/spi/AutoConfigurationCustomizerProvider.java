package io.opentelemetry.sdk.autoconfigure.spi;

/* JADX INFO: loaded from: classes4.dex */
public interface AutoConfigurationCustomizerProvider extends Ordered {
    void customize(AutoConfigurationCustomizer autoConfigurationCustomizer);
}
