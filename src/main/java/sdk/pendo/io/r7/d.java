package sdk.pendo.io.r7;

import android.view.MotionEvent;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0007¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/r7/d;", "Lsdk/pendo/io/s5/c;", "Landroid/view/MotionEvent;", "event", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "handler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class d implements sdk.pendo.io.s5.c {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final Function1<MotionEvent, Unit> handler;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Function1<? super MotionEvent, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
    }

    @Override // sdk.pendo.io.s5.c
    public void a(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.handler.invoke(event);
    }

    @Override // sdk.pendo.io.s5.c
    public void b(MotionEvent motionEvent) {
        sdk.pendo.io.s5.c.a.a(this, motionEvent);
    }
}
