package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.ComposeView;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.profileinstaller.ProfileVerifier;
import com.pspdfkit.R;
import com.pspdfkit.annotations.stamps.StampPickerItem;
import com.pspdfkit.compose.theme.UiThemeKt;
import io.nutrient.ui.theme.ThemeWrapperKt;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h40 extends LinearLayout {
    public static final int[] i = R.styleable.pspdf__StampPicker;
    public static final int j = R.attr.pspdf__stampPickerStyle;
    public static final int k = R.style.PSPDFKit_StampPicker;
    public final boolean a;
    public final f40.a b;
    public ComposeView c;
    public ComposeView d;
    public ComposeView e;
    public FrameLayout f;
    public List<? extends StampPickerItem> g;
    public StampPickerItem h;

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 com.pspdfkit.internal.h40$a[], still in use, count: 1, list:
      (r0v1 com.pspdfkit.internal.h40$a[]) from 0x001a: INVOKE (r0v1 com.pspdfkit.internal.h40$a[]) STATIC call: kotlin.enums.EnumEntriesKt.enumEntries(java.lang.Enum[]):kotlin.enums.EnumEntries A[MD:<E extends java.lang.Enum<E>>:(E extends java.lang.Enum<E>[]):kotlin.enums.EnumEntries<E extends java.lang.Enum<E>> (m)]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:101)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:100)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:257)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:187)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static final class a {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT;

        static {
            EnumEntriesKt.enumEntries(aVarArr);
        }

        public a() {
            super(str, i);
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) c.clone();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public h40(Context context, boolean z, f40.a aVar) {
        context.getClass();
        int i2 = k;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{j});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, i2);
        typedArrayObtainStyledAttributes.recycle();
        super(new ContextThemeWrapper(context, resourceId));
        this.a = z;
        this.b = aVar;
        this.g = CollectionsKt.emptyList();
        a();
    }

    public static final Unit b(final h40 h40Var, j40 j40Var, yq yqVar, Composer composer, int i2) {
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(969941706, i2, -1, "com.pspdfkit.internal.ui.dialog.stamps.StampPickerLayout.init.<anonymous>.<anonymous> (StampPickerLayout.kt:100)");
            }
            String strA = no.a(h40Var.getContext(), R.string.pspdf__create_stamp, h40Var);
            strA.getClass();
            StampPickerItem stampPickerItem = h40Var.h;
            boolean zChangedInstance = composer.changedInstance(h40Var);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.h40$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return h40.a(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(h40Var);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.h40$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return h40.a(this.f$0, (StampPickerItem) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            hc.a(strA, stampPickerItem, (Function0<Unit>) function0, (Function1<? super StampPickerItem, Unit>) objRememberedValue2, j40Var, yqVar, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, 1572864);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public final void a() {
        final yq yqVar = new yq(getContext());
        yqVar.getCornerRadius();
        Context context = getContext();
        context.getClass();
        Resources.Theme theme = context.getTheme();
        int[] iArr = i;
        int i2 = j;
        int i3 = k;
        FrameLayout frameLayout = null;
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(null, iArr, i2, i3);
        typedArrayObtainStyledAttributes.getClass();
        typedArrayObtainStyledAttributes.getColor(R.styleable.pspdf__StampPicker_pspdf__backgroundColor, -1);
        typedArrayObtainStyledAttributes.recycle();
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setOrientation(1);
        FrameLayout frameLayout2 = new FrameLayout(getContext());
        this.f = frameLayout2;
        frameLayout2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        Context context2 = getContext();
        context2.getClass();
        i40 i40Var = new i40(context2);
        final j40 j40Var = new j40(i40Var.a, i40Var.b, i40Var.c, i40Var.e, i40Var.d, i40Var.h);
        Context context3 = getContext();
        Context context4 = getContext();
        context4.getClass();
        TypedArray typedArrayObtainStyledAttributes2 = context4.getTheme().obtainStyledAttributes(new int[]{i2});
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, i3);
        typedArrayObtainStyledAttributes2.recycle();
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context3, resourceId);
        this.c = y9.a(contextThemeWrapper, ComposableLambdaKt.composableLambdaInstance(1409833639, true, new Function2() { // from class: com.pspdfkit.internal.h40$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return h40.a(this.f$0, j40Var, yqVar, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        this.d = y9.a(contextThemeWrapper, ComposableLambdaKt.composableLambdaInstance(-2042182608, true, new Function2() { // from class: com.pspdfkit.internal.h40$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return h40.a(this.f$0, yqVar, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
        boolean z = this.a;
        FrameLayout frameLayout3 = this.f;
        if (z) {
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.RUBY_CONTAINER);
                frameLayout3 = null;
            }
            ComposeView composeView = this.c;
            if (composeView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customStampLayout");
                composeView = null;
            }
            frameLayout3.addView(composeView);
            ComposeView composeView2 = this.c;
            if (composeView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("customStampLayout");
                composeView2 = null;
            }
            this.e = composeView2;
        } else {
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.RUBY_CONTAINER);
                frameLayout3 = null;
            }
            ComposeView composeView3 = this.d;
            if (composeView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stampGridLayout");
                composeView3 = null;
            }
            frameLayout3.addView(composeView3);
            ComposeView composeView4 = this.d;
            if (composeView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stampGridLayout");
                composeView4 = null;
            }
            this.e = composeView4;
        }
        FrameLayout frameLayout4 = this.f;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.RUBY_CONTAINER);
        } else {
            frameLayout = frameLayout4;
        }
        addView(frameLayout, 0);
        setFullscreen(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        f40.a aVar;
        keyEvent.getClass();
        if (keyEvent.getKeyCode() != 4) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() != 0 || (aVar = this.b) == null) {
            return true;
        }
        aVar.a();
        return true;
    }

    public final StampPickerItem getCustomStampAnnotation() {
        return this.h;
    }

    public final List<StampPickerItem> getItems() {
        return this.g;
    }

    public final void setCustomStampAnnotation(StampPickerItem stampPickerItem) {
        this.h = stampPickerItem;
    }

    public final void setFullscreen(boolean z) {
    }

    public final void setItems(List<? extends StampPickerItem> list) {
        list.getClass();
        this.g = list;
    }

    public static final Unit a(final h40 h40Var, final j40 j40Var, final yq yqVar, Composer composer, int i2) {
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1409833639, i2, -1, "com.pspdfkit.internal.ui.dialog.stamps.StampPickerLayout.init.<anonymous> (StampPickerLayout.kt:99)");
            }
            ThemeWrapperKt.WithUiTheme(UiThemeKt.getUiColors(composer, 0), ComposableLambdaKt.rememberComposableLambda(969941706, true, new Function2() { // from class: com.pspdfkit.internal.h40$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return h40.b(this.f$0, j40Var, yqVar, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(h40 h40Var) {
        f40.a aVar = h40Var.b;
        if (aVar != null) {
            aVar.a();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(h40 h40Var, StampPickerItem stampPickerItem) {
        f40.a aVar;
        if (stampPickerItem != null && (aVar = h40Var.b) != null) {
            aVar.a(stampPickerItem, false);
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(final h40 h40Var, final yq yqVar, Composer composer, int i2) {
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2042182608, i2, -1, "com.pspdfkit.internal.ui.dialog.stamps.StampPickerLayout.init.<anonymous> (StampPickerLayout.kt:123)");
            }
            ThemeWrapperKt.WithUiTheme(UiThemeKt.getUiColors(composer, 0), ComposableLambdaKt.rememberComposableLambda(983054611, true, new Function2() { // from class: com.pspdfkit.internal.h40$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return h40.b(this.f$0, yqVar, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void a(View view, h40 h40Var) {
        view.setVisibility(8);
        FrameLayout frameLayout = h40Var.f;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.RUBY_CONTAINER);
            frameLayout = null;
        }
        frameLayout.removeView(view);
    }

    public final void a(ComposeView composeView, a aVar) {
        FrameLayout frameLayout = this.f;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.RUBY_CONTAINER);
            frameLayout = null;
        }
        frameLayout.addView(composeView);
        composeView.animate().cancel();
        composeView.setVisibility(0);
        composeView.animate().setInterpolator(new DecelerateInterpolator()).setDuration(200L);
        int width = getWidth() / 2;
        if (aVar == a.LEFT_TO_RIGHT) {
            width = -width;
        }
        composeView.setTranslationX(width);
        composeView.animate().translationX(0.0f);
        composeView.setAlpha(0.0f);
        composeView.animate().alpha(1.0f);
    }

    public static final Unit b(final h40 h40Var, yq yqVar, Composer composer, int i2) {
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(983054611, i2, -1, "com.pspdfkit.internal.ui.dialog.stamps.StampPickerLayout.init.<anonymous>.<anonymous> (StampPickerLayout.kt:124)");
            }
            String strA = no.a(h40Var.getContext(), R.string.pspdf__annotation_type_stamp, h40Var);
            strA.getClass();
            List<? extends StampPickerItem> list = h40Var.g;
            boolean zChangedInstance = composer.changedInstance(h40Var);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.h40$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return h40.b(this.f$0, (StampPickerItem) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            boolean zChangedInstance2 = composer.changedInstance(h40Var);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.h40$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return h40.b(this.f$0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            b40.a(strA, list, function1, (Function0) objRememberedValue2, yqVar, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit b(h40 h40Var, StampPickerItem stampPickerItem) {
        stampPickerItem.getClass();
        f40.a aVar = h40Var.b;
        if (aVar != null) {
            aVar.a(stampPickerItem, stampPickerItem.isCustomStamp());
        }
        return Unit.INSTANCE;
    }

    public static final Unit b(h40 h40Var) {
        f40.a aVar = h40Var.b;
        if (aVar != null) {
            aVar.a();
        }
        return Unit.INSTANCE;
    }

    public final void b(final ComposeView composeView, a aVar) {
        composeView.animate().cancel();
        composeView.animate().setInterpolator(new DecelerateInterpolator()).setDuration(200L);
        int width = getWidth() / 2;
        composeView.setTranslationX(0.0f);
        ViewPropertyAnimator viewPropertyAnimatorAnimate = composeView.animate();
        if (aVar != a.LEFT_TO_RIGHT) {
            width = -width;
        }
        viewPropertyAnimatorAnimate.translationX(width);
        composeView.setAlpha(1.0f);
        composeView.animate().alpha(0.0f);
        composeView.animate().withEndAction(new Runnable() { // from class: com.pspdfkit.internal.h40$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                h40.a(composeView, this);
            }
        });
    }
}
