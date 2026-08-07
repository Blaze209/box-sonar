package sdk.pendo.io.i2;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u001a\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b\u001a7\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/i2/a;", "task", "Lsdk/pendo/io/i2/d;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "", "message", "", "b", "", "ns", CmcdData.OBJECT_TYPE_AUDIO_ONLY, ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "block", "logElapsed", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "okhttp"}, k = 2, mv = {1, 8, 0})
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(a aVar, d dVar, String str) {
        Logger loggerA = e.h.a();
        StringBuilder sbAppend = new StringBuilder().append(dVar.getName()).append(' ');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        loggerA.fine(sbAppend.append(str2).append(": ").append(aVar.getName()).toString());
    }

    public static final String a(long j) {
        StringBuilder sb;
        long j2;
        StringBuilder sb2;
        long j3;
        StringBuilder sb3;
        long j4;
        StringBuilder sbAppend;
        if (j > -999500000) {
            if (j > -999500) {
                if (j <= 0) {
                    sb3 = new StringBuilder();
                    j4 = j - ((long) 500);
                } else if (j < 999500) {
                    sb3 = new StringBuilder();
                    j4 = j + ((long) 500);
                } else if (j < 999500000) {
                    sb2 = new StringBuilder();
                    j3 = j + ((long) 500000);
                } else {
                    sb = new StringBuilder();
                    j2 = j + ((long) 500000000);
                }
                sbAppend = sb3.append(j4 / ((long) 1000)).append(" µs");
                String string = sbAppend.toString();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("%6s", Arrays.copyOf(new Object[]{string}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                return str;
            }
            sb2 = new StringBuilder();
            j3 = j - ((long) 500000);
            sbAppend = sb2.append(j3 / ((long) 1000000)).append(" ms");
            String string2 = sbAppend.toString();
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format("%6s", Arrays.copyOf(new Object[]{string2}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            return str2;
        }
        sb = new StringBuilder();
        j2 = j - ((long) 500000000);
        sbAppend = sb.append(j2 / ((long) 1000000000)).append(" s ");
        String string3 = sbAppend.toString();
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String str3 = String.format("%6s", Arrays.copyOf(new Object[]{string3}, 1));
        Intrinsics.checkNotNullExpressionValue(str3, "format(format, *args)");
        return str3;
    }
}
