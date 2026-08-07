package sdk.pendo.io.e2;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00132\u00020\u0001:\u0002\u0007\tB%\b\u0000\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\rR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\r¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/e2/s;", "Lsdk/pendo/io/e2/c0;", "Lsdk/pendo/io/s2/e;", "sink", "", "countBytes", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lsdk/pendo/io/e2/x;", "b", "", "", "", "Ljava/util/List;", "encodedNames", "c", "encodedValues", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "d", "okhttp"}, k = 1, mv = {1, 8, 0})
public final class s extends c0 {
    private static final x e = x.INSTANCE.a("application/x-www-form-urlencoded");

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final List<String> encodedNames;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final List<String> encodedValues;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\fR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/e2/s$a;", "", "", "name", "value", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "Lsdk/pendo/io/e2/s;", "Ljava/nio/charset/Charset;", "Ljava/nio/charset/Charset;", "charset", "", "Ljava/util/List;", "names", "c", "values", "<init>", "(Ljava/nio/charset/Charset;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final Charset charset;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final List<String> names;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final List<String> values;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final a a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            List<String> list = this.names;
            v.Companion companion = v.INSTANCE;
            list.add(v.Companion.a(companion, name, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            this.values.add(v.Companion.a(companion, value, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            return this;
        }

        public final a b(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            List<String> list = this.names;
            v.Companion companion = v.INSTANCE;
            list.add(v.Companion.a(companion, name, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            this.values.add(v.Companion.a(companion, value, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            return this;
        }

        public a(Charset charset) {
            this.charset = charset;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        public final s a() {
            return new s(this.names, this.values);
        }

        public /* synthetic */ a(Charset charset, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : charset);
        }
    }

    public s(List<String> encodedNames, List<String> encodedValues) {
        Intrinsics.checkNotNullParameter(encodedNames, "encodedNames");
        Intrinsics.checkNotNullParameter(encodedValues, "encodedValues");
        this.encodedNames = sdk.pendo.io.f2.b.b(encodedNames);
        this.encodedValues = sdk.pendo.io.f2.b.b(encodedValues);
    }

    @Override // sdk.pendo.io.e2.c0
    public long a() {
        return a((sdk.pendo.io.s2.e) null, true);
    }

    @Override // sdk.pendo.io.e2.c0
    /* JADX INFO: renamed from: b */
    public x getContentType() {
        return e;
    }

    private final long a(sdk.pendo.io.s2.e sink, boolean countBytes) throws EOFException {
        sdk.pendo.io.s2.d bufferField;
        if (countBytes) {
            bufferField = new sdk.pendo.io.s2.d();
        } else {
            Intrinsics.checkNotNull(sink);
            bufferField = sink.getBufferField();
        }
        int size = this.encodedNames.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                bufferField.writeByte(38);
            }
            bufferField.writeUtf8(this.encodedNames.get(i));
            bufferField.writeByte(61);
            bufferField.writeUtf8(this.encodedValues.get(i));
        }
        if (!countBytes) {
            return 0L;
        }
        long size2 = bufferField.getSize();
        bufferField.a();
        return size2;
    }

    @Override // sdk.pendo.io.e2.c0
    public void a(sdk.pendo.io.s2.e sink) throws EOFException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        a(sink, false);
    }
}
