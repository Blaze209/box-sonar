package com.splunk.rum;

import android.app.Application;
import android.util.Log;
import io.opentelemetry.exporter.zipkin.ZipkinSpanExporter;
import java.io.File;
import java.net.InetAddress;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class ZipkinWriteToDiskExporterFactory {
    static /* synthetic */ InetAddress lambda$create$0() {
        return null;
    }

    private ZipkinWriteToDiskExporterFactory() {
    }

    static ZipkinSpanExporter create(Application application, int i) {
        File spansDirectory = FileUtils.getSpansDirectory(application);
        if (!spansDirectory.exists() && !spansDirectory.mkdirs()) {
            Log.e("SplunkRum", "Error creating path " + spansDirectory + " for span buffer, defaulting to parent");
            spansDirectory = application.getApplicationContext().getFilesDir();
        }
        FileUtils fileUtils = new FileUtils();
        return ZipkinSpanExporter.builder().setEncoder(new CustomZipkinEncoder()).setSender(ZipkinToDiskSender.builder().path(spansDirectory).fileUtils(fileUtils).storageLimiter(DeviceSpanStorageLimiter.builder().fileUtils(fileUtils).path(spansDirectory).maxStorageUseMb(i).build()).build()).setLocalIpAddressSupplier(new Supplier() { // from class: com.splunk.rum.ZipkinWriteToDiskExporterFactory$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                return ZipkinWriteToDiskExporterFactory.lambda$create$0();
            }
        }).build();
    }
}
