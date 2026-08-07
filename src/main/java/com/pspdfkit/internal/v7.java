package com.pspdfkit.internal;

import android.graphics.Bitmap;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\b\u0017\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001c\u0010\f¨\u0006!"}, d2 = {"Lcom/pspdfkit/internal/v7;", "", "Lcom/pspdfkit/internal/zo;", "managedBitmap", "", "id", "<init>", "(Lcom/pspdfkit/internal/zo;J)V", "Landroid/graphics/Bitmap;", "bitmap", "(Landroid/graphics/Bitmap;)V", "tryAcquireBitmapOrNull", "()Landroid/graphics/Bitmap;", "Lcom/pspdfkit/internal/x7;", "acquireLeaseOrNull", "()Lcom/pspdfkit/internal/x7;", "", "release", "()V", "Lcom/pspdfkit/internal/zo;", "getManagedBitmap$sdk_nutrient", "()Lcom/pspdfkit/internal/zo;", "J", "getId", "()J", "", "released", "Z", "getPeekBitmapOrNull", "getPeekBitmapOrNull$annotations", "peekBitmapOrNull", "Companion", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class v7 {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion();
    private static final AtomicLong nextId = new AtomicLong(0);
    private final long id;
    private final zo managedBitmap;
    private volatile boolean released;

    /* JADX INFO: renamed from: com.pspdfkit.internal.v7$a, reason: from kotlin metadata */
    public static final class Companion {
    }

    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function0<Unit> {
        public b(Object obj) {
            super(0, obj, zo.class, "recycleIfOwned", "recycleIfOwned()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ((zo) this.receiver).b();
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ v7(zo zoVar, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(zoVar, j);
    }

    public static /* synthetic */ void getPeekBitmapOrNull$annotations() {
    }

    private final Bitmap tryAcquireBitmapOrNull() {
        if (this.released) {
            return null;
        }
        try {
            Bitmap bitmapC = this.managedBitmap.c();
            if (bitmapC == null || bitmapC.isRecycled()) {
                return null;
            }
            return bitmapC;
        } catch (IllegalStateException unused) {
        }
    }

    public final x7 acquireLeaseOrNull() {
        Bitmap bitmapTryAcquireBitmapOrNull = tryAcquireBitmapOrNull();
        if (bitmapTryAcquireBitmapOrNull != null) {
            return new x7(bitmapTryAcquireBitmapOrNull, new b(this.managedBitmap));
        }
        return null;
    }

    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: getManagedBitmap$sdk_nutrient, reason: from getter */
    public final zo getManagedBitmap() {
        return this.managedBitmap;
    }

    public final Bitmap getPeekBitmapOrNull() {
        if (this.released) {
            return null;
        }
        try {
            Bitmap bitmapA = this.managedBitmap.a();
            if (bitmapA.isRecycled()) {
                return null;
            }
            return bitmapA;
        } catch (IllegalStateException unused) {
        }
    }

    public final synchronized void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        this.managedBitmap.b();
    }

    private v7(zo zoVar, long j) {
        this.managedBitmap = zoVar;
        this.id = j;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public v7(Bitmap bitmap) {
        this(new zo(bitmap), nextId.incrementAndGet());
        bitmap.getClass();
    }
}
