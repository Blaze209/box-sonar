package androidx.compose.material.internal;

import android.R;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: ExposedDropdownMenuPopup.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B?\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010R\u001a\u00020\u0006J&\u0010L\u001a\u00020\u00062\u0006\u0010S\u001a\u00020T2\u0011\u0010I\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\bH¢\u0006\u0002\u0010UJ\r\u0010V\u001a\u00020\u0006H\u0017¢\u0006\u0002\u0010WJ\u0010\u0010X\u001a\u0002072\u0006\u0010Y\u001a\u00020ZH\u0016J&\u0010[\u001a\u00020\u00062\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\\\u001a\u00020!J\u0006\u0010]\u001a\u00020\u0006J\u0006\u0010^\u001a\u00020\u0006J\u0012\u0010_\u001a\u0002072\b\u0010Y\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010a\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020bH\u0016J\u0010\u0010c\u001a\u00020\u00062\u0006\u0010\\\u001a\u00020!H\u0002J\b\u0010d\u001a\u00020\u001aH\u0002J\f\u0010e\u001a\u00020'*\u00020@H\u0002J\b\u0010f\u001a\u00020\u0006H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R/\u0010(\u001a\u0004\u0018\u00010'2\b\u0010&\u001a\u0004\u0018\u00010'8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R/\u00100\u001a\u0004\u0018\u00010/2\b\u0010&\u001a\u0004\u0018\u00010/8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b5\u0010.\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u00106\u001a\u0002078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b8\u00109R\u0010\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0004\n\u0002\u0010>R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR\"\u0010E\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010G\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u0002070FX\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010I\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\bH2\u0011\u0010&\u001a\r\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\bH8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bN\u0010.\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010P\u001a\u0002072\u0006\u0010O\u001a\u000207@RX\u0094\u000e¢\u0006\b\n\u0000\u001a\u0004\bQ\u00109¨\u0006g"}, d2 = {"Landroidx/compose/material/internal/PopupLayout;", "Landroidx/compose/ui/platform/AbstractComposeView;", "Landroidx/compose/ui/platform/ViewRootForInspector;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onDismissRequest", "Lkotlin/Function0;", "", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "", "composeView", "Landroid/view/View;", "density", "Landroidx/compose/ui/unit/Density;", "initialPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "popupId", "Ljava/util/UUID;", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroid/view/View;Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/window/PopupPositionProvider;Ljava/util/UUID;)V", "getTestTag", "()Ljava/lang/String;", "setTestTag", "(Ljava/lang/String;)V", "windowManager", "Landroid/view/WindowManager;", SerializedNames.PARAMS, "Landroid/view/WindowManager$LayoutParams;", "positionProvider", "getPositionProvider", "()Landroidx/compose/ui/window/PopupPositionProvider;", "setPositionProvider", "(Landroidx/compose/ui/window/PopupPositionProvider;)V", "parentLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getParentLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setParentLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "<set-?>", "Landroidx/compose/ui/unit/IntRect;", "parentBounds", "getParentBounds", "()Landroidx/compose/ui/unit/IntRect;", "setParentBounds", "(Landroidx/compose/ui/unit/IntRect;)V", "parentBounds$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/unit/IntSize;", "popupContentSize", "getPopupContentSize-bOM6tXw", "()Landroidx/compose/ui/unit/IntSize;", "setPopupContentSize-fhxjrPA", "(Landroidx/compose/ui/unit/IntSize;)V", "popupContentSize$delegate", "canCalculatePosition", "", "getCanCalculatePosition", "()Z", "canCalculatePosition$delegate", "Landroidx/compose/runtime/State;", "maxSupportedElevation", "Landroidx/compose/ui/unit/Dp;", "F", "previousWindowVisibleFrame", "Landroid/graphics/Rect;", "tmpWindowVisibleFrame", "subCompositionView", "getSubCompositionView", "()Landroidx/compose/ui/platform/AbstractComposeView;", "dismissOnOutsideClick", "Lkotlin/Function2;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/runtime/Composable;", "content", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "content$delegate", "value", "shouldCreateCompositionOnAttachedToWindow", "getShouldCreateCompositionOnAttachedToWindow", "show", "parent", "Landroidx/compose/runtime/CompositionContext;", "(Landroidx/compose/runtime/CompositionContext;Lkotlin/jvm/functions/Function2;)V", "Content", "(Landroidx/compose/runtime/Composer;I)V", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "updateParameters", ViewProps.LAYOUT_DIRECTION, "updatePosition", BoxAnalyticsParams.ACTION_DISMISS, "onTouchEvent", "Landroid/view/MotionEvent;", "setLayoutDirection", "", "superSetLayoutDirection", "createLayoutParams", "toIntBounds", "onGlobalLayout", "material"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PopupLayout extends AbstractComposeView implements ViewRootForInspector, ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: canCalculatePosition$delegate, reason: from kotlin metadata */
    private final State canCalculatePosition;
    private final View composeView;

    /* JADX INFO: renamed from: content$delegate, reason: from kotlin metadata */
    private final MutableState content;
    private final Function2<Offset, IntRect, Boolean> dismissOnOutsideClick;
    private final float maxSupportedElevation;
    private Function0<Unit> onDismissRequest;
    private final WindowManager.LayoutParams params;

    /* JADX INFO: renamed from: parentBounds$delegate, reason: from kotlin metadata */
    private final MutableState parentBounds;
    private LayoutDirection parentLayoutDirection;

    /* JADX INFO: renamed from: popupContentSize$delegate, reason: from kotlin metadata */
    private final MutableState popupContentSize;
    private PopupPositionProvider positionProvider;
    private final Rect previousWindowVisibleFrame;
    private boolean shouldCreateCompositionOnAttachedToWindow;
    private String testTag;
    private final Rect tmpWindowVisibleFrame;
    private final WindowManager windowManager;

    /* JADX INFO: compiled from: ExposedDropdownMenuPopup.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0(PopupLayout popupLayout, int i, Composer composer, int i2) {
        popupLayout.Content(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    @Override // android.view.View
    public void setLayoutDirection(int layoutDirection) {
    }

    public final String getTestTag() {
        return this.testTag;
    }

    public final void setTestTag(String str) {
        this.testTag = str;
    }

    public PopupLayout(Function0<Unit> function0, String str, View view, Density density, PopupPositionProvider popupPositionProvider, UUID uuid) {
        super(view.getContext(), null, 0, 6, null);
        this.onDismissRequest = function0;
        this.testTag = str;
        this.composeView = view;
        Object systemService = view.getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        this.params = createLayoutParams();
        this.positionProvider = popupPositionProvider;
        this.parentLayoutDirection = LayoutDirection.Ltr;
        this.parentBounds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.popupContentSize = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.canCalculatePosition = SnapshotStateKt.derivedStateOf(new Function0() { // from class: androidx.compose.material.internal.PopupLayout$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(PopupLayout.canCalculatePosition_delegate$lambda$0(this.f$0));
            }
        });
        float fM9687constructorimpl = Dp.m9687constructorimpl(8);
        this.maxSupportedElevation = fM9687constructorimpl;
        this.previousWindowVisibleFrame = new Rect();
        this.tmpWindowVisibleFrame = new Rect();
        this.dismissOnOutsideClick = new Function2() { // from class: androidx.compose.material.internal.PopupLayout$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(PopupLayout.dismissOnOutsideClick$lambda$0((Offset) obj, (IntRect) obj2));
            }
        };
        setId(R.id.content);
        PopupLayout popupLayout = this;
        ViewTreeLifecycleOwner.set(popupLayout, ViewTreeLifecycleOwner.get(view));
        ViewTreeViewModelStoreOwner.set(popupLayout, ViewTreeViewModelStoreOwner.get(view));
        ViewTreeSavedStateRegistryOwner.set(popupLayout, ViewTreeSavedStateRegistryOwner.get(view));
        view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        setTag(androidx.compose.ui.R.id.compose_view_saveable_id_tag, "Popup:" + uuid);
        setClipChildren(false);
        setElevation(density.mo754toPx0680j_4(fM9687constructorimpl));
        setOutlineProvider(new ViewOutlineProvider() { // from class: androidx.compose.material.internal.PopupLayout.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline result) {
                result.setRect(0, 0, view2.getWidth(), view2.getHeight());
                result.setAlpha(0.0f);
            }
        });
        this.content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposableSingletons$ExposedDropdownMenuPopup_androidKt.INSTANCE.m2673getLambda$1578637197$material(), null, 2, null);
    }

    public final PopupPositionProvider getPositionProvider() {
        return this.positionProvider;
    }

    public final void setPositionProvider(PopupPositionProvider popupPositionProvider) {
        this.positionProvider = popupPositionProvider;
    }

    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    public final void setParentLayoutDirection(LayoutDirection layoutDirection) {
        this.parentLayoutDirection = layoutDirection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final IntRect getParentBounds() {
        return (IntRect) this.parentBounds.getValue();
    }

    public final void setParentBounds(IntRect intRect) {
        this.parentBounds.setValue(intRect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getPopupContentSize-bOM6tXw, reason: not valid java name */
    public final IntSize m2681getPopupContentSizebOM6tXw() {
        return (IntSize) this.popupContentSize.getValue();
    }

    /* JADX INFO: renamed from: setPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m2682setPopupContentSizefhxjrPA(IntSize intSize) {
        this.popupContentSize.setValue(intSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean canCalculatePosition_delegate$lambda$0(PopupLayout popupLayout) {
        return (popupLayout.getParentBounds() == null || popupLayout.m2681getPopupContentSizebOM6tXw() == null) ? false : true;
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.canCalculatePosition.getValue()).booleanValue();
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dismissOnOutsideClick$lambda$0(Offset offset, IntRect intRect) {
        if (offset == null) {
            return false;
        }
        return Float.intBitsToFloat((int) (offset.m6579unboximpl() >> 32)) < ((float) intRect.getLeft()) || Float.intBitsToFloat((int) (offset.m6579unboximpl() >> 32)) > ((float) intRect.getRight()) || Float.intBitsToFloat((int) (offset.m6579unboximpl() & 4294967295L)) < ((float) intRect.getTop()) || Float.intBitsToFloat((int) (offset.m6579unboximpl() & 4294967295L)) > ((float) intRect.getBottom());
    }

    private final Function2<Composer, Integer, Unit> getContent() {
        return (Function2) this.content.getValue();
    }

    private final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
        this.content.setValue(function2);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    public final void show() {
        this.windowManager.addView(this, this.params);
    }

    public final void setContent(CompositionContext parent, Function2<? super Composer, ? super Integer, Unit> content) {
        setParentCompositionContext(parent);
        setContent(content);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void Content(Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-864350873);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)304@11955L9:ExposedDropdownMenuPopup.android.kt#mnwmf7");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-864350873, i2, -1, "androidx.compose.material.internal.PopupLayout.Content (ExposedDropdownMenuPopup.android.kt:303)");
            }
            getContent().invoke(composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.internal.PopupLayout$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PopupLayout.Content$lambda$0(this.f$0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == 4 || event.getKeyCode() == 111) {
            KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
            if (keyDispatcherState == null) {
                return super.dispatchKeyEvent(event);
            }
            if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                keyDispatcherState.startTracking(event, this);
                return true;
            }
            if (event.getAction() == 1 && keyDispatcherState.isTracking(event) && !event.isCanceled()) {
                Function0<Unit> function0 = this.onDismissRequest;
                if (function0 != null) {
                    function0.invoke();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    public final void updateParameters(Function0<Unit> onDismissRequest, String testTag, LayoutDirection layoutDirection) {
        this.onDismissRequest = onDismissRequest;
        this.testTag = testTag;
        superSetLayoutDirection(layoutDirection);
    }

    public final void updatePosition() {
        IntSize intSizeM2681getPopupContentSizebOM6tXw;
        IntRect parentBounds = getParentBounds();
        if (parentBounds == null || (intSizeM2681getPopupContentSizebOM6tXw = m2681getPopupContentSizebOM6tXw()) == null) {
            return;
        }
        long jM9862unboximpl = intSizeM2681getPopupContentSizebOM6tXw.m9862unboximpl();
        Rect rect = this.previousWindowVisibleFrame;
        this.composeView.getWindowVisibleDisplayFrame(rect);
        IntRect intBounds = toIntBounds(rect);
        long jMo718calculatePositionllwVHH4 = this.positionProvider.mo718calculatePositionllwVHH4(parentBounds, IntSize.m9853constructorimpl((((long) intBounds.getWidth()) << 32) | (((long) intBounds.getHeight()) & 4294967295L)), this.parentLayoutDirection, jM9862unboximpl);
        this.params.x = IntOffset.m9815getXimpl(jMo718calculatePositionllwVHH4);
        this.params.y = IntOffset.m9816getYimpl(jMo718calculatePositionllwVHH4);
        this.windowManager.updateViewLayout(this, this.params);
    }

    public final void dismiss() {
        PopupLayout popupLayout = this;
        ViewTreeLifecycleOwner.set(popupLayout, null);
        this.composeView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.windowManager.removeViewImmediate(popupLayout);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x008a, code lost:
    
        if (r2.invoke(r1, r0).booleanValue() != false) goto L28;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L7
            boolean r10 = super.onTouchEvent(r11)
            return r10
        L7:
            int r0 = r11.getAction()
            r1 = 0
            if (r0 != 0) goto L38
            float r0 = r11.getX()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L3f
            float r0 = r11.getX()
            int r2 = r10.getWidth()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L3f
            float r0 = r11.getY()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L3f
            float r0 = r11.getY()
            int r2 = r10.getHeight()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L3f
        L38:
            int r0 = r11.getAction()
            r2 = 4
            if (r0 != r2) goto L95
        L3f:
            androidx.compose.ui.unit.IntRect r0 = r10.getParentBounds()
            if (r0 == 0) goto L8c
            kotlin.jvm.functions.Function2<androidx.compose.ui.geometry.Offset, androidx.compose.ui.unit.IntRect, java.lang.Boolean> r2 = r10.dismissOnOutsideClick
            float r3 = r11.getRawX()
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 != 0) goto L50
            goto L58
        L50:
            float r3 = r11.getRawY()
            int r1 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r1 != 0) goto L5a
        L58:
            r1 = 0
            goto L80
        L5a:
            float r1 = r11.getRawX()
            float r3 = r11.getRawY()
            int r1 = java.lang.Float.floatToRawIntBits(r1)
            long r4 = (long) r1
            int r1 = java.lang.Float.floatToRawIntBits(r3)
            long r6 = (long) r1
            r1 = 32
            long r3 = r4 << r1
            r8 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r5 = r6 & r8
            long r3 = r3 | r5
            long r3 = androidx.compose.ui.geometry.Offset.m6561constructorimpl(r3)
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m6558boximpl(r3)
        L80:
            java.lang.Object r0 = r2.invoke(r1, r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L95
        L8c:
            kotlin.jvm.functions.Function0<kotlin.Unit> r10 = r10.onDismissRequest
            if (r10 == 0) goto L93
            r10.invoke()
        L93:
            r10 = 1
            return r10
        L95:
            boolean r10 = super.onTouchEvent(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.internal.PopupLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private final void superSetLayoutDirection(LayoutDirection layoutDirection) {
        int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        super.setLayoutDirection(i2);
    }

    private final WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        layoutParams.flags = 393248;
        layoutParams.softInputMode = 1;
        layoutParams.type = 1000;
        layoutParams.token = this.composeView.getApplicationWindowToken();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.setTitle(this.composeView.getContext().getResources().getString(androidx.compose.ui.R.string.default_popup_window_title));
        return layoutParams;
    }

    private final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.composeView.getWindowVisibleDisplayFrame(this.tmpWindowVisibleFrame);
        if (Intrinsics.areEqual(this.tmpWindowVisibleFrame, this.previousWindowVisibleFrame)) {
            return;
        }
        updatePosition();
    }
}
