package com.pspdfkit.internal.document;

import com.pspdfkit.document.providers.DataProvider;
import com.pspdfkit.document.providers.WritableDataProvider;
import com.pspdfkit.internal.jni.NativeDataDescriptor;
import com.pspdfkit.internal.jni.NativeDataProvider;
import com.pspdfkit.internal.jni.NativeDataSink;
import com.pspdfkit.internal.jni.NativeDataSinkOption;
import com.pspdfkit.internal.jni.NativeSpanView;
import com.pspdfkit.utils.PdfLog;

/* JADX INFO: loaded from: classes3.dex */
public class DataProviderShim extends NativeDataProvider {
    private final String LOG_TAG = "Nutri.DataProviderShim";
    private final DataProvider publicProvider;
    private static final byte[] safetyBuffer = new byte[0];
    private static final NativeDataSink NOOP_DATA_SINK = new a();

    public class a extends NativeDataSink {
        @Override // com.pspdfkit.internal.jni.NativeDataSink
        public final boolean finish() {
            return false;
        }

        @Override // com.pspdfkit.internal.jni.NativeDataSink
        public final boolean writeData(byte[] bArr) {
            return false;
        }
    }

    public class b extends NativeDataSink {
        public final /* synthetic */ WritableDataProvider a;

        public b(WritableDataProvider writableDataProvider) {
            this.a = writableDataProvider;
        }

        @Override // com.pspdfkit.internal.jni.NativeDataSink
        public final boolean finish() {
            return true;
        }

        @Override // com.pspdfkit.internal.jni.NativeDataSink
        public final boolean writeData(byte[] bArr) {
            try {
                return this.a.write(bArr);
            } catch (RuntimeException e) {
                PdfLog.e("Nutri.DataProviderShim", "Exception on writeData: %s", e);
                return false;
            }
        }
    }

    public DataProviderShim(DataProvider dataProvider) {
        this.publicProvider = dataProvider;
    }

    public static NativeDataDescriptor createNativeDataDescriptor(DataProvider dataProvider) {
        return createNativeDataDescriptor(dataProvider, null);
    }

    @Override // com.pspdfkit.internal.jni.NativeDataProvider
    public NativeDataSink createDataSink(NativeDataSinkOption nativeDataSinkOption) {
        DataProvider dataProvider = this.publicProvider;
        if (!(dataProvider instanceof WritableDataProvider)) {
            return NOOP_DATA_SINK;
        }
        WritableDataProvider writableDataProvider = (WritableDataProvider) dataProvider;
        return !writableDataProvider.startWrite(nativeDataSinkOption == NativeDataSinkOption.DATA_SINK_OPTION_NEW_FILE ? WritableDataProvider.WriteMode.REWRITE_FILE : WritableDataProvider.WriteMode.APPEND_TO_FILE) ? NOOP_DATA_SINK : new b(writableDataProvider);
    }

    public DataProvider getPublicProvider() {
        return this.publicProvider;
    }

    @Override // com.pspdfkit.internal.jni.NativeDataProvider
    public long getSize() {
        try {
            return this.publicProvider.getSize();
        } catch (RuntimeException e) {
            PdfLog.e("Nutri.DataProviderShim", "Exception on getSize: %s", e);
            return 0L;
        }
    }

    @Override // com.pspdfkit.internal.jni.NativeDataProvider
    public String getUid() {
        try {
            return this.publicProvider.getUid();
        } catch (RuntimeException e) {
            PdfLog.e("Nutri.DataProviderShim", "Exception on getUid: %s", e);
            return "";
        }
    }

    @Override // com.pspdfkit.internal.jni.NativeDataProvider
    public NativeSpanView read(long j, long j2) {
        try {
            byte[] bArr = this.publicProvider.read(j, j2);
            if (bArr == null) {
                return NativeSpanView.createSpanView(safetyBuffer, 0L);
            }
            return ((long) bArr.length) <= j ? NativeSpanView.createSpanView(bArr, bArr.length) : NativeSpanView.createSpanView(bArr, j);
        } catch (RuntimeException e) {
            PdfLog.e("Nutri.DataProviderShim", "Exception on read: %s", e);
            return NativeSpanView.createSpanView(new byte[0], 0L);
        }
    }

    @Override // com.pspdfkit.internal.jni.NativeDataProvider
    public boolean replaceWithDataSink(NativeDataSink nativeDataSink) {
        DataProvider dataProvider = this.publicProvider;
        return (dataProvider instanceof WritableDataProvider) && ((WritableDataProvider) dataProvider).finishWrite();
    }

    @Override // com.pspdfkit.internal.jni.NativeDataProvider
    public boolean supportsAppending() {
        DataProvider dataProvider = this.publicProvider;
        return (dataProvider instanceof WritableDataProvider) && ((WritableDataProvider) dataProvider).supportsAppending();
    }

    @Override // com.pspdfkit.internal.jni.NativeDataProvider
    public boolean supportsWriting() {
        DataProvider dataProvider = this.publicProvider;
        return (dataProvider instanceof WritableDataProvider) && ((WritableDataProvider) dataProvider).canWrite();
    }

    public static NativeDataDescriptor createNativeDataDescriptor(DataProvider dataProvider, String str) {
        return new NativeDataDescriptor(null, new DataProviderShim(dataProvider), str, null, null);
    }
}
