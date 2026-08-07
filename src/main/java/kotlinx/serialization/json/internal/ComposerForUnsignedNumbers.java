package kotlinx.serialization.json.internal;

import com.pspdfkit.analytics.Analytics;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Composers.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\fH\u0096\u0080\u0004J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\rH\u0096\u0080\u0004J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0096\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlinx/serialization/json/internal/ComposerForUnsignedNumbers;", "Lkotlinx/serialization/json/internal/Composer;", "writer", "Lkotlinx/serialization/json/internal/InternalJsonWriter;", "forceQuoting", "", "<init>", "(Lkotlinx/serialization/json/internal/InternalJsonWriter;Z)V", Analytics.Event.PRINT, "", "v", "", "", "", "", "kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ComposerForUnsignedNumbers extends Composer {
    private final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(InternalJsonWriter writer, boolean z) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.forceQuoting = z;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(int v) {
        boolean z = this.forceQuoting;
        String unsignedString = Integer.toUnsignedString(UInt.m14875constructorimpl(v));
        if (z) {
            printQuoted(unsignedString);
        } else {
            print(unsignedString);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(long v) {
        boolean z = this.forceQuoting;
        String unsignedString = Long.toUnsignedString(ULong.m14954constructorimpl(v));
        if (z) {
            printQuoted(unsignedString);
        } else {
            print(unsignedString);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(byte v) {
        boolean z = this.forceQuoting;
        String strM14842toStringimpl = UByte.m14842toStringimpl(UByte.m14798constructorimpl(v));
        if (z) {
            printQuoted(strM14842toStringimpl);
        } else {
            print(strM14842toStringimpl);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(short v) {
        boolean z = this.forceQuoting;
        String strM15105toStringimpl = UShort.m15105toStringimpl(UShort.m15061constructorimpl(v));
        if (z) {
            printQuoted(strM15105toStringimpl);
        } else {
            print(strM15105toStringimpl);
        }
    }
}
