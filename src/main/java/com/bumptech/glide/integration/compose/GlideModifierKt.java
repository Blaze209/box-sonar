package com.bumptech.glide.integration.compose;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.bumptech.glide.RequestBuilder;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: GlideModifier.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0097\u0001\u0010\u001c\u001a\u00020\u001d*\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0002\u00102\"\"\u0010\u0000\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\"\u0010\u0006\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0005\"\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\"?\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002*\u00020\u00112\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017*\u0004\b\u0012\u0010\u0013\"?\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0002*\u00020\u00112\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00028@@@X\u0080\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017*\u0004\b\u0019\u0010\u0013¨\u00063"}, d2 = {"DisplayedDrawableKey", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Lkotlin/Function0;", "Landroid/graphics/drawable/Drawable;", "getDisplayedDrawableKey", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "DisplayedPainterKey", "Landroidx/compose/ui/graphics/painter/Painter;", "getDisplayedPainterKey", "MAIN_HANDLER", "Landroid/os/Handler;", "getMAIN_HANDLER", "()Landroid/os/Handler;", "MAIN_HANDLER$delegate", "Lkotlin/Lazy;", "<set-?>", "displayedDrawable", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "getDisplayedDrawable$delegate", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/Object;", "getDisplayedDrawable", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Lkotlin/jvm/functions/Function0;", "setDisplayedDrawable", "(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;Lkotlin/jvm/functions/Function0;)V", "displayedPainter", "getDisplayedPainter$delegate", "getDisplayedPainter", "setDisplayedPainter", "glideNode", "Landroidx/compose/ui/Modifier;", "requestBuilder", "Lcom/bumptech/glide/RequestBuilder;", "contentDescription", "", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "transitionFactory", "Lcom/bumptech/glide/integration/compose/Transition$Factory;", "requestListener", "Lcom/bumptech/glide/integration/compose/RequestListener;", "draw", "", "loadingPlaceholder", "errorPlaceholder", "(Landroidx/compose/ui/Modifier;Lcom/bumptech/glide/RequestBuilder;Ljava/lang/String;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;Ljava/lang/Float;Landroidx/compose/ui/graphics/ColorFilter;Lcom/bumptech/glide/integration/compose/Transition$Factory;Lcom/bumptech/glide/integration/compose/RequestListener;Ljava/lang/Boolean;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;)Landroidx/compose/ui/Modifier;", "compose_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class GlideModifierKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(GlideModifierKt.class, "displayedDrawable", "getDisplayedDrawable(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Lkotlin/jvm/functions/Function0;", 1)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(GlideModifierKt.class, "displayedPainter", "getDisplayedPainter(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Lkotlin/jvm/functions/Function0;", 1))};
    private static final Lazy MAIN_HANDLER$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Handler>() { // from class: com.bumptech.glide.integration.compose.GlideModifierKt$MAIN_HANDLER$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });
    private static final SemanticsPropertyKey<Function0<Drawable>> DisplayedDrawableKey = new SemanticsPropertyKey<>("DisplayedDrawable", (Function2) null, 2, (DefaultConstructorMarker) null);
    private static final SemanticsPropertyKey<Function0<Painter>> DisplayedPainterKey = new SemanticsPropertyKey<>("DisplayedPainter", (Function2) null, 2, (DefaultConstructorMarker) null);

    public static /* synthetic */ Modifier glideNode$default(Modifier modifier, RequestBuilder requestBuilder, String str, Alignment alignment, ContentScale contentScale, Float f, ColorFilter colorFilter, Transition.Factory factory, RequestListener requestListener, Boolean bool, Painter painter, Painter painter2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            alignment = null;
        }
        if ((i & 8) != 0) {
            contentScale = null;
        }
        if ((i & 16) != 0) {
            f = null;
        }
        if ((i & 32) != 0) {
            colorFilter = null;
        }
        if ((i & 64) != 0) {
            factory = null;
        }
        if ((i & 128) != 0) {
            requestListener = null;
        }
        if ((i & 256) != 0) {
            bool = null;
        }
        if ((i & 512) != 0) {
            painter = null;
        }
        if ((i & 1024) != 0) {
            painter2 = null;
        }
        return glideNode(modifier, requestBuilder, str, alignment, contentScale, f, colorFilter, factory, requestListener, bool, painter, painter2);
    }

    public static final Modifier glideNode(Modifier modifier, RequestBuilder<Drawable> requestBuilder, final String str, Alignment alignment, ContentScale contentScale, Float f, ColorFilter colorFilter, Transition.Factory factory, RequestListener requestListener, Boolean bool, Painter painter, Painter painter2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(requestBuilder, "requestBuilder");
        return modifier.then(SemanticsModifierKt.semantics$default(ClipKt.clipToBounds(new GlideNodeElement(requestBuilder, contentScale == null ? ContentScale.INSTANCE.getNone() : contentScale, alignment == null ? Alignment.INSTANCE.getCenter() : alignment, f, colorFilter, requestListener, bool, factory, painter, painter2)), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: com.bumptech.glide.integration.compose.GlideModifierKt.glideNode.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                String str2 = str;
                if (str2 != null) {
                    SemanticsPropertiesKt.setContentDescription(semantics, str2);
                }
                SemanticsPropertiesKt.m8851setRolekuIjeqM(semantics, Role.INSTANCE.m8836getImageo7Vup1c());
            }
        }, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler getMAIN_HANDLER() {
        return (Handler) MAIN_HANDLER$delegate.getValue();
    }

    public static final SemanticsPropertyKey<Function0<Drawable>> getDisplayedDrawableKey() {
        return DisplayedDrawableKey;
    }

    public static final Function0<Drawable> getDisplayedDrawable(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return DisplayedDrawableKey.getValue(semanticsPropertyReceiver, $$delegatedProperties[0]);
    }

    public static final void setDisplayedDrawable(SemanticsPropertyReceiver semanticsPropertyReceiver, Function0<? extends Drawable> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        DisplayedDrawableKey.setValue(semanticsPropertyReceiver, $$delegatedProperties[0], function0);
    }

    public static final SemanticsPropertyKey<Function0<Painter>> getDisplayedPainterKey() {
        return DisplayedPainterKey;
    }

    public static final Function0<Painter> getDisplayedPainter(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        return DisplayedPainterKey.getValue(semanticsPropertyReceiver, $$delegatedProperties[1]);
    }

    public static final void setDisplayedPainter(SemanticsPropertyReceiver semanticsPropertyReceiver, Function0<? extends Painter> function0) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "<this>");
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        DisplayedPainterKey.setValue(semanticsPropertyReceiver, $$delegatedProperties[1], function0);
    }
}
