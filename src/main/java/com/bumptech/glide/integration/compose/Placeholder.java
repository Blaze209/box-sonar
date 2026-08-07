package com.bumptech.glide.integration.compose;

import android.graphics.drawable.Drawable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.exifinterface.media.ExifInterface;
import androidx.navigation.compose.ComposeNavigator;
import com.bumptech.glide.RequestBuilder;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GlideImage.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0018\u0019\u001a\u001bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002JO\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u00072\u001a\u0010\t\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u00040\u0007H\u0000¢\u0006\u0002\b\u000bJ\r\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u001c\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0002\b\u0012H\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0000¢\u0006\u0002\b\u0017\u0082\u0001\u0004\u001c\u001d\u001e\u001f¨\u0006 "}, d2 = {"Lcom/bumptech/glide/integration/compose/Placeholder;", "", "()V", "apply", "Lcom/bumptech/glide/RequestBuilder;", ExifInterface.GPS_DIRECTION_TRUE, "resource", "Lkotlin/Function1;", "", "drawable", "Landroid/graphics/drawable/Drawable;", "apply$compose_release", "isResourceOrDrawable", "", "isResourceOrDrawable$compose_release", "maybeComposable", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "maybeComposable$compose_release", "()Lkotlin/jvm/functions/Function2;", "maybePainter", "Landroidx/compose/ui/graphics/painter/Painter;", "maybePainter$compose_release", "OfComposable", "OfDrawable", "OfPainter", "OfResourceId", "Lcom/bumptech/glide/integration/compose/Placeholder$OfComposable;", "Lcom/bumptech/glide/integration/compose/Placeholder$OfDrawable;", "Lcom/bumptech/glide/integration/compose/Placeholder$OfPainter;", "Lcom/bumptech/glide/integration/compose/Placeholder$OfResourceId;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Placeholder {
    public static final int $stable = 0;

    public /* synthetic */ Placeholder(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private Placeholder() {
    }

    /* JADX INFO: compiled from: GlideImage.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bumptech/glide/integration/compose/Placeholder$OfDrawable;", "Lcom/bumptech/glide/integration/compose/Placeholder;", "drawable", "Landroid/graphics/drawable/Drawable;", "(Landroid/graphics/drawable/Drawable;)V", "getDrawable$compose_release", "()Landroid/graphics/drawable/Drawable;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OfDrawable extends Placeholder {
        private final Drawable drawable;

        public OfDrawable(Drawable drawable) {
            super(null);
            this.drawable = drawable;
        }

        /* JADX INFO: renamed from: getDrawable$compose_release, reason: from getter */
        public final Drawable getDrawable() {
            return this.drawable;
        }
    }

    /* JADX INFO: compiled from: GlideImage.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bumptech/glide/integration/compose/Placeholder$OfResourceId;", "Lcom/bumptech/glide/integration/compose/Placeholder;", "resourceId", "", "(I)V", "getResourceId$compose_release", "()I", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OfResourceId extends Placeholder {
        private final int resourceId;

        public OfResourceId(int i) {
            super(null);
            this.resourceId = i;
        }

        /* JADX INFO: renamed from: getResourceId$compose_release, reason: from getter */
        public final int getResourceId() {
            return this.resourceId;
        }
    }

    /* JADX INFO: compiled from: GlideImage.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bumptech/glide/integration/compose/Placeholder$OfPainter;", "Lcom/bumptech/glide/integration/compose/Placeholder;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "getPainter$compose_release", "()Landroidx/compose/ui/graphics/painter/Painter;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OfPainter extends Placeholder {
        private final Painter painter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OfPainter(Painter painter) {
            super(null);
            Intrinsics.checkNotNullParameter(painter, "painter");
            this.painter = painter;
        }

        /* JADX INFO: renamed from: getPainter$compose_release, reason: from getter */
        public final Painter getPainter() {
            return this.painter;
        }
    }

    /* JADX INFO: compiled from: GlideImage.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0018\u0012\u0011\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005¢\u0006\u0002\u0010\u0006R!\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bumptech/glide/integration/compose/Placeholder$OfComposable;", "Lcom/bumptech/glide/integration/compose/Placeholder;", ComposeNavigator.NAME, "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;)V", "getComposable$compose_release", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "compose_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OfComposable extends Placeholder {
        private final Function2<Composer, Integer, Unit> composable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public OfComposable(Function2<? super Composer, ? super Integer, Unit> composable) {
            super(null);
            Intrinsics.checkNotNullParameter(composable, "composable");
            this.composable = composable;
        }

        public final Function2<Composer, Integer, Unit> getComposable$compose_release() {
            return this.composable;
        }
    }

    public final boolean isResourceOrDrawable$compose_release() {
        if ((this instanceof OfDrawable) || (this instanceof OfResourceId)) {
            return true;
        }
        if ((this instanceof OfComposable) || (this instanceof OfPainter)) {
            return false;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Function2<Composer, Integer, Unit> maybeComposable$compose_release() {
        if (this instanceof OfComposable) {
            return ((OfComposable) this).getComposable$compose_release();
        }
        return null;
    }

    public final Painter maybePainter$compose_release() {
        if (this instanceof OfPainter) {
            return ((OfPainter) this).getPainter();
        }
        return null;
    }

    public final <T> RequestBuilder<T> apply$compose_release(Function1<? super Integer, ? extends RequestBuilder<T>> resource, Function1<? super Drawable, ? extends RequestBuilder<T>> drawable) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        if (this instanceof OfDrawable) {
            return drawable.invoke(((OfDrawable) this).getDrawable());
        }
        return this instanceof OfResourceId ? resource.invoke(Integer.valueOf(((OfResourceId) this).getResourceId())) : drawable.invoke(null);
    }
}
