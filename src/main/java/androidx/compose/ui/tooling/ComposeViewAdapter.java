package androidx.compose.ui.tooling;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.runtime.tooling.CompositionInstance;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewRootForTest;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.tooling.animation.AnimationSearch;
import androidx.compose.ui.tooling.animation.PreviewAnimationClock;
import androidx.compose.ui.tooling.data.CompositionDataTreeKt;
import androidx.compose.ui.tooling.data.Group;
import androidx.compose.ui.tooling.data.NodeGroup;
import androidx.compose.ui.tooling.data.SlotTreeKt;
import androidx.compose.ui.tooling.data.SourceContext;
import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import androidx.compose.ui.unit.IntRect;
import androidx.core.app.ActivityOptionsCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.preview.wopi.WopiService;
import com.facebook.react.uimanager.ViewProps;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ComposeViewAdapter.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003*\u0004nqtw\b\u0001\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\f\u00105\u001a\u00020\u0010*\u00020/H\u0002J\f\u00106\u001a\u00020\u0010*\u00020/H\u0002J\f\u00107\u001a\u00020\u0014*\u00020/H\u0002J6\u00108\u001a\u00020\u00142\u0006\u00109\u001a\u00020:2\u0006\u0010\u0002\u001a\u00020;2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0002J\b\u0010>\u001a\u00020$H\u0002J0\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\t2\u0006\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\tH\u0014J\b\u0010E\u001a\u00020$H\u0014J\b\u0010F\u001a\u00020$H\u0002J\b\u0010G\u001a\u00020$H\u0002J\f\u0010H\u001a\u00020\u0010*\u00020/H\u0002J\u0016\u0010I\u001a\u0004\u0018\u00010\f*\u00020/2\u0006\u0010J\u001a\u00020KH\u0002J\u000e\u0010L\u001a\u0004\u0018\u00010M*\u00020NH\u0002J\u001e\u0010O\u001a\u0004\u0018\u00010\f*\u00020N2\u0006\u0010P\u001a\u00020\t2\u0006\u0010Q\u001a\u00020\tH\u0002J\u0010\u0010R\u001a\u00020$2\u0006\u0010S\u001a\u00020TH\u0014J \u0010]\u001a\u00020$2\u0011\u0010^\u001a\r\u0012\u0004\u0012\u00020$0#¢\u0006\u0002\b%H\u0003¢\u0006\u0002\u0010_J\u0093\u0001\u0010`\u001a\u00020$2\u0006\u0010a\u001a\u00020\f2\u0006\u0010b\u001a\u00020\f2\u0016\b\u0002\u0010c\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030e\u0018\u00010d2\b\b\u0002\u0010f\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010g\u001a\u00020h2\b\b\u0002\u0010'\u001a\u00020\u00102\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\f2\u000e\b\u0002\u0010i\u001a\b\u0012\u0004\u0012\u00020$0#2\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020$0#H\u0001¢\u0006\u0002\bjJ\r\u0010k\u001a\u00020$H\u0000¢\u0006\u0002\blJ\u0006\u0010\u001f\u001a\u00020\u0010J\u0010\u0010`\u001a\u00020$2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\r\u0012\u0004\u0012\u00020$0#¢\u0006\u0002\b%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020$0#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010.\u001a\u00020\f*\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0018\u00102\u001a\u00020\t*\u00020/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R$\u0010U\u001a\u00020V8\u0000@\u0000X\u0081.¢\u0006\u0014\n\u0000\u0012\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0012\u0010m\u001a\u00020n8\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010oR\u0010\u0010p\u001a\u00020qX\u0082\u0004¢\u0006\u0004\n\u0002\u0010rR\u0010\u0010s\u001a\u00020tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010uR\u0010\u0010v\u001a\u00020wX\u0082\u0004¢\u0006\u0004\n\u0002\u0010x¨\u0006y"}, d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "debugViewInfos", "", "debugPaintBounds", "viewInfos", "", "Landroidx/compose/ui/tooling/ViewInfo;", "getViewInfos$ui_tooling", "()Ljava/util/List;", "setViewInfos$ui_tooling", "(Ljava/util/List;)V", "designInfoList", "getDesignInfoList$ui_tooling", "setDesignInfoList$ui_tooling", "slotTableRecord", "Landroidx/compose/ui/tooling/CompositionDataRecord;", "composableName", "hasAnimations", "delayedException", "Landroidx/compose/ui/tooling/ThreadSafeException;", "previewComposition", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function2;", "lookForDesignInfoProviders", "designInfoProvidersArgument", "onDraw", "debugBoundsPaint", "Landroid/graphics/Paint;", "composition", "Landroidx/compose/runtime/Composition;", BoxCommonConstants.EXTRA_FILE_NAME, "Landroidx/compose/ui/tooling/data/Group;", "getFileName", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/String;", "lineNumber", "getLineNumber", "(Landroidx/compose/ui/tooling/data/Group;)I", "hasNullSourcePosition", "isNullGroup", "toViewInfo", "toViewInfoFactory", "group", "Landroidx/compose/runtime/tooling/CompositionGroup;", "Landroidx/compose/ui/tooling/data/SourceContext;", "children", "childrenToStitch", "processViewInfos", "onLayout", "changed", "left", ViewProps.TOP, "right", ViewProps.BOTTOM, "onAttachedToWindow", "findAndTrackAnimations", "findDesignInfoProviders", "hasDesignInfo", "getDesignInfoOrNull", WopiService.BOX, "Landroidx/compose/ui/unit/IntRect;", "getDesignInfoMethodOrNull", "Ljava/lang/reflect/Method;", "", "invokeGetDesignInfo", "x", "y", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "clock", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "getClock$ui_tooling$annotations", "()V", "getClock$ui_tooling", "()Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "setClock$ui_tooling", "(Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;)V", "WrapPreview", "content", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "init", "className", "methodName", "parameterProvider", "Ljava/lang/Class;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "parameterProviderIndex", "animationClockStartTime", "", "onCommit", "init$ui_tooling", "dispose", "dispose$ui_tooling", "FakeSavedStateRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1;", "FakeViewModelStoreOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeViewModelStoreOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeViewModelStoreOwner$1;", "FakeOnBackPressedDispatcherOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1;", "FakeActivityResultRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1;", "ui-tooling"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ComposeViewAdapter extends FrameLayout {
    public static final int $stable = 8;
    private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1 FakeActivityResultRegistryOwner;
    private final ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1 FakeOnBackPressedDispatcherOwner;
    private final ComposeViewAdapter$FakeSavedStateRegistryOwner$1 FakeSavedStateRegistryOwner;
    private final ComposeViewAdapter$FakeViewModelStoreOwner$1 FakeViewModelStoreOwner;
    private final String TAG;
    public PreviewAnimationClock clock;
    private String composableName;
    private final ComposeView composeView;
    private Composition composition;
    private final Paint debugBoundsPaint;
    private boolean debugPaintBounds;
    private boolean debugViewInfos;
    private final ThreadSafeException delayedException;
    private List<String> designInfoList;
    private String designInfoProvidersArgument;
    private boolean hasAnimations;
    private boolean lookForDesignInfoProviders;
    private Function0<Unit> onDraw;
    private Function2<? super Composer, ? super Integer, Unit> previewComposition;
    private final CompositionDataRecord slotTableRecord;
    private List<ViewInfo> viewInfos;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WrapPreview$lambda$1(ComposeViewAdapter composeViewAdapter, Function2 function2, int i, Composer composer, int i2) {
        composeViewAdapter.WrapPreview(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getClock$ui_tooling$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ViewInfo processViewInfos$lambda$1(CompositionInstance compositionInstance, ViewInfo viewInfo, List list) {
        return viewInfo;
    }

    public final List<ViewInfo> getViewInfos$ui_tooling() {
        return this.viewInfos;
    }

    public final void setViewInfos$ui_tooling(List<ViewInfo> list) {
        this.viewInfos = list;
    }

    public final List<String> getDesignInfoList$ui_tooling() {
        return this.designInfoList;
    }

    public final void setDesignInfoList$ui_tooling(List<String> list) {
        this.designInfoList = list;
    }

    /* JADX WARN: Type inference failed for: r7v11, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1] */
    /* JADX WARN: Type inference failed for: r7v12, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1] */
    public ComposeViewAdapter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "ComposeViewAdapter";
        this.composeView = new ComposeView(getContext(), null, 0, 6, null);
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.INSTANCE.create();
        this.composableName = "";
        this.delayedException = new ThreadSafeException();
        this.previewComposition = ComposableSingletons$ComposeViewAdapter_androidKt.INSTANCE.getLambda$2086912010$ui_tooling();
        this.designInfoProvidersArgument = "";
        this.onDraw = new Function0() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
        Paint paint = new Paint();
        paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ColorKt.m6868toArgb8_81llA(Color.INSTANCE.m6848getRed0d7_KjU()));
        this.debugBoundsPaint = paint;
        this.FakeSavedStateRegistryOwner = new ComposeViewAdapter$FakeSavedStateRegistryOwner$1();
        this.FakeViewModelStoreOwner = new ComposeViewAdapter$FakeViewModelStoreOwner$1();
        this.FakeOnBackPressedDispatcherOwner = new OnBackPressedDispatcherOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1
            private final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(null, 1, null);

            @Override // androidx.activity.OnBackPressedDispatcherOwner
            public OnBackPressedDispatcher getOnBackPressedDispatcher() {
                return this.onBackPressedDispatcher;
            }

            @Override // androidx.lifecycle.LifecycleOwner
            /* JADX INFO: renamed from: getLifecycle */
            public LifecycleRegistry getLifecycleRegistry() {
                return this.this$0.FakeSavedStateRegistryOwner.getLifecycleRegistry();
            }
        };
        this.FakeActivityResultRegistryOwner = new ActivityResultRegistryOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1
            private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1 activityResultRegistry = new ActivityResultRegistry() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1
                @Override // androidx.activity.result.ActivityResultRegistry
                public <I, O> void onLaunch(int requestCode, ActivityResultContract<I, O> contract, I input, ActivityOptionsCompat options) {
                    throw new IllegalStateException("Calling launch() is not supported in Preview");
                }
            };

            @Override // androidx.activity.result.ActivityResultRegistryOwner
            public ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1 getActivityResultRegistry() {
                return this.activityResultRegistry;
            }
        };
        init(attributeSet);
    }

    /* JADX WARN: Type inference failed for: r7v11, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1] */
    /* JADX WARN: Type inference failed for: r7v12, types: [androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1] */
    public ComposeViewAdapter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "ComposeViewAdapter";
        this.composeView = new ComposeView(getContext(), null, 0, 6, null);
        this.viewInfos = CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.INSTANCE.create();
        this.composableName = "";
        this.delayedException = new ThreadSafeException();
        this.previewComposition = ComposableSingletons$ComposeViewAdapter_androidKt.INSTANCE.getLambda$2086912010$ui_tooling();
        this.designInfoProvidersArgument = "";
        this.onDraw = new Function0() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        };
        Paint paint = new Paint();
        paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ColorKt.m6868toArgb8_81llA(Color.INSTANCE.m6848getRed0d7_KjU()));
        this.debugBoundsPaint = paint;
        this.FakeSavedStateRegistryOwner = new ComposeViewAdapter$FakeSavedStateRegistryOwner$1();
        this.FakeViewModelStoreOwner = new ComposeViewAdapter$FakeViewModelStoreOwner$1();
        this.FakeOnBackPressedDispatcherOwner = new OnBackPressedDispatcherOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1
            private final OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher(null, 1, null);

            @Override // androidx.activity.OnBackPressedDispatcherOwner
            public OnBackPressedDispatcher getOnBackPressedDispatcher() {
                return this.onBackPressedDispatcher;
            }

            @Override // androidx.lifecycle.LifecycleOwner
            /* JADX INFO: renamed from: getLifecycle */
            public LifecycleRegistry getLifecycleRegistry() {
                return this.this$0.FakeSavedStateRegistryOwner.getLifecycleRegistry();
            }
        };
        this.FakeActivityResultRegistryOwner = new ActivityResultRegistryOwner() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1
            private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1 activityResultRegistry = new ActivityResultRegistry() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1
                @Override // androidx.activity.result.ActivityResultRegistry
                public <I, O> void onLaunch(int requestCode, ActivityResultContract<I, O> contract, I input, ActivityOptionsCompat options) {
                    throw new IllegalStateException("Calling launch() is not supported in Preview");
                }
            };

            @Override // androidx.activity.result.ActivityResultRegistryOwner
            public ComposeViewAdapter$FakeActivityResultRegistryOwner$1$activityResultRegistry$1 getActivityResultRegistry() {
                return this.activityResultRegistry;
            }
        };
        init(attributeSet);
    }

    private final String getFileName(Group group) {
        String sourceFile;
        SourceLocation location = group.getLocation();
        return (location == null || (sourceFile = location.getSourceFile()) == null) ? "" : sourceFile;
    }

    private final int getLineNumber(Group group) {
        SourceLocation location = group.getLocation();
        if (location != null) {
            return location.getLineNumber();
        }
        return -1;
    }

    private final boolean hasNullSourcePosition(Group group) {
        return getFileName(group).length() == 0 && getLineNumber(group) == -1;
    }

    private final boolean isNullGroup(Group group) {
        if (!hasNullSourcePosition(group) || !group.getChildren().isEmpty()) {
            return false;
        }
        NodeGroup nodeGroup = group instanceof NodeGroup ? (NodeGroup) group : null;
        Object node = nodeGroup != null ? nodeGroup.getNode() : null;
        return (node instanceof LayoutInfo ? (LayoutInfo) node : null) == null;
    }

    private final ViewInfo toViewInfo(Group group) {
        String sourceFile;
        NodeGroup nodeGroup = group instanceof NodeGroup ? (NodeGroup) group : null;
        Object node = nodeGroup != null ? nodeGroup.getNode() : null;
        LayoutInfo layoutInfo = node instanceof LayoutInfo ? (LayoutInfo) node : null;
        if (group.getChildren().size() == 1 && hasNullSourcePosition(group) && layoutInfo == null) {
            return toViewInfo((Group) CollectionsKt.single(group.getChildren()));
        }
        Collection<Group> children = group.getChildren();
        ArrayList arrayList = new ArrayList();
        for (Object obj : children) {
            if (!isNullGroup((Group) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(toViewInfo((Group) it.next()));
        }
        ArrayList arrayList4 = arrayList3;
        SourceLocation location = group.getLocation();
        if (location == null || (sourceFile = location.getSourceFile()) == null) {
            sourceFile = "";
        }
        String str = sourceFile;
        SourceLocation location2 = group.getLocation();
        return new ViewInfo(str, location2 != null ? location2.getLineNumber() : -1, group.getBox(), group.getLocation(), arrayList4, layoutInfo, group.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewInfo toViewInfoFactory(CompositionGroup group, SourceContext context, List<ViewInfo> children, List<ViewInfo> childrenToStitch) {
        String sourceFile;
        if (childrenToStitch != null) {
            children = CollectionsKt.plus((Collection) children, (Iterable) childrenToStitch);
        }
        List<ViewInfo> list = children;
        SourceLocation location = context.getLocation();
        if (location == null || (sourceFile = location.getSourceFile()) == null) {
            sourceFile = "";
        }
        String str = sourceFile;
        SourceLocation location2 = context.getLocation();
        int lineNumber = location2 != null ? location2.getLineNumber() : -1;
        IntRect bounds = context.getBounds();
        SourceLocation location3 = context.getLocation();
        Object node = group.getNode();
        return new ViewInfo(str, lineNumber, bounds, location3, list, node instanceof LayoutInfo ? (LayoutInfo) node : null, context.getName());
    }

    private final void processViewInfos() {
        List<ViewInfo> listMakeTree$default = CompositionDataTreeKt.makeTree$default(this.slotTableRecord.getStore(), new Function1() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ComposeViewAdapter.processViewInfos$lambda$0((CompositionInstance) obj);
            }
        }, new C07782(this), new Function3() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ComposeViewAdapter.processViewInfos$lambda$1((CompositionInstance) obj, (ViewInfo) obj2, (List) obj3);
            }
        }, null, 8, null);
        this.viewInfos = listMakeTree$default;
        if (this.debugViewInfos) {
            Log.d(this.TAG, ViewInfoUtil_androidKt.toDebugString$default(listMakeTree$default, 0, null, 3, null));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.tooling.ComposeViewAdapter$processViewInfos$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ComposeViewAdapter.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final /* synthetic */ class C07782 extends FunctionReferenceImpl implements Function4<CompositionGroup, SourceContext, List<? extends ViewInfo>, List<? extends ViewInfo>, ViewInfo> {
        C07782(Object obj) {
            super(4, obj, ComposeViewAdapter.class, "toViewInfoFactory", "toViewInfoFactory(Landroidx/compose/runtime/tooling/CompositionGroup;Landroidx/compose/ui/tooling/data/SourceContext;Ljava/util/List;Ljava/util/List;)Landroidx/compose/ui/tooling/ViewInfo;", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final ViewInfo invoke2(CompositionGroup compositionGroup, SourceContext sourceContext, List<ViewInfo> list, List<ViewInfo> list2) {
            return ((ComposeViewAdapter) this.receiver).toViewInfoFactory(compositionGroup, sourceContext, list, list2);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ ViewInfo invoke(CompositionGroup compositionGroup, SourceContext sourceContext, List<? extends ViewInfo> list, List<? extends ViewInfo> list2) {
            return invoke2(compositionGroup, sourceContext, (List<ViewInfo>) list, (List<ViewInfo>) list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit processViewInfos$lambda$0(CompositionInstance compositionInstance) {
        return Unit.INSTANCE;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.delayedException.throwIfPresent();
        processViewInfos();
        if (this.composableName.length() > 0) {
            findAndTrackAnimations();
            if (this.lookForDesignInfoProviders) {
                findDesignInfoProviders();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        ViewTreeLifecycleOwner.set(this.composeView.getRootView(), this.FakeSavedStateRegistryOwner);
        super.onAttachedToWindow();
    }

    private final void findAndTrackAnimations() {
        Set<CompositionData> store = this.slotTableRecord.getStore();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(store, 10));
        Iterator<T> it = store.iterator();
        while (it.hasNext()) {
            arrayList.add(SlotTreeKt.asTree((CompositionData) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        boolean z = this.clock != null;
        AnimationSearch animationSearch = new AnimationSearch(new MutablePropertyReference0Impl(this) { // from class: androidx.compose.ui.tooling.ComposeViewAdapter.findAndTrackAnimations.1
            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
            public Object get() {
                return ((ComposeViewAdapter) this.receiver).getClock();
            }

            @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
            public void set(Object obj) {
                ((ComposeViewAdapter) this.receiver).setClock$ui_tooling((PreviewAnimationClock) obj);
            }
        }, new AnonymousClass2(this));
        ArrayList arrayList3 = arrayList2;
        boolean zSearchAny = animationSearch.searchAny(arrayList3);
        this.hasAnimations = zSearchAny;
        if (z && zSearchAny) {
            animationSearch.attachAllAnimations(arrayList3);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.tooling.ComposeViewAdapter$findAndTrackAnimations$2, reason: invalid class name */
    /* JADX INFO: compiled from: ComposeViewAdapter.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        AnonymousClass2(Object obj) {
            super(0, obj, ComposeViewAdapter.class, "requestLayout", "requestLayout()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((ComposeViewAdapter) this.receiver).requestLayout();
        }
    }

    private final void findDesignInfoProviders() {
        Set<CompositionData> store = this.slotTableRecord.getStore();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(store, 10));
        Iterator<T> it = store.iterator();
        while (it.hasNext()) {
            arrayList.add(SlotTreeKt.asTree((CompositionData) it.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            List<Group> listFindAll = PreviewUtils_androidKt.findAll((Group) it2.next(), new Function1() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(ComposeViewAdapter.findDesignInfoProviders$lambda$1$0(this.f$0, (Group) obj));
                }
            });
            ArrayList arrayList3 = new ArrayList();
            for (Group group : listFindAll) {
                String designInfoOrNull = getDesignInfoOrNull(group, group.getBox());
                if (designInfoOrNull == null) {
                    Iterator<T> it3 = group.getChildren().iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            designInfoOrNull = null;
                            break;
                        }
                        String designInfoOrNull2 = getDesignInfoOrNull((Group) it3.next(), group.getBox());
                        if (designInfoOrNull2 != null) {
                            designInfoOrNull = designInfoOrNull2;
                            break;
                        }
                    }
                }
                if (designInfoOrNull != null) {
                    arrayList3.add(designInfoOrNull);
                }
            }
            CollectionsKt.addAll(arrayList2, arrayList3);
        }
        this.designInfoList = arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean findDesignInfoProviders$lambda$1$0(ComposeViewAdapter composeViewAdapter, Group group) {
        if (!Intrinsics.areEqual(group.getName(), "remember") && composeViewAdapter.hasDesignInfo(group)) {
            return true;
        }
        Collection<Group> children = group.getChildren();
        if ((children instanceof Collection) && children.isEmpty()) {
            return false;
        }
        for (Group group2 : children) {
            if (Intrinsics.areEqual(group2.getName(), "remember") && composeViewAdapter.hasDesignInfo(group2)) {
                return true;
            }
        }
        return false;
    }

    private final boolean hasDesignInfo(Group group) {
        Collection<Object> data = group.getData();
        if ((data instanceof Collection) && data.isEmpty()) {
            return false;
        }
        Iterator<T> it = data.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if ((next != null ? getDesignInfoMethodOrNull(next) : null) != null) {
                return true;
            }
        }
        return false;
    }

    private final String getDesignInfoOrNull(Group group, IntRect intRect) {
        String strInvokeGetDesignInfo;
        Iterator<T> it = group.getData().iterator();
        do {
            strInvokeGetDesignInfo = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (next != null) {
                strInvokeGetDesignInfo = invokeGetDesignInfo(next, intRect.getLeft(), intRect.getRight());
            }
        } while (strInvokeGetDesignInfo == null);
        return strInvokeGetDesignInfo;
    }

    private final Method getDesignInfoMethodOrNull(Object obj) {
        try {
            return obj.getClass().getDeclaredMethod("getDesignInfo", Integer.TYPE, Integer.TYPE, String.class);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final String invokeGetDesignInfo(Object obj, int i, int i2) {
        Method designInfoMethodOrNull = getDesignInfoMethodOrNull(obj);
        if (designInfoMethodOrNull == null) {
            return null;
        }
        try {
            Object objInvoke = designInfoMethodOrNull.invoke(obj, Integer.valueOf(i), Integer.valueOf(i2), this.designInfoProvidersArgument);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.String");
            String str = (String) objInvoke;
            if (str.length() == 0) {
                str = null;
            }
            return str;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.onDraw.invoke();
        if (this.debugPaintBounds) {
            List<ViewInfo> list = this.viewInfos;
            ArrayList<ViewInfo> arrayList = new ArrayList();
            for (ViewInfo viewInfo : list) {
                CollectionsKt.addAll(arrayList, CollectionsKt.plus((Collection) CollectionsKt.listOf(viewInfo), (Iterable) viewInfo.allChildren()));
            }
            for (ViewInfo viewInfo2 : arrayList) {
                if (viewInfo2.hasBounds()) {
                    canvas.drawRect(new Rect(viewInfo2.getBounds().getLeft(), viewInfo2.getBounds().getTop(), viewInfo2.getBounds().getRight(), viewInfo2.getBounds().getBottom()), this.debugBoundsPaint);
                }
            }
        }
    }

    /* JADX INFO: renamed from: getClock$ui_tooling, reason: from getter */
    public final PreviewAnimationClock getClock() {
        return this.clock;
    }

    public final void setClock$ui_tooling(PreviewAnimationClock previewAnimationClock) {
        this.clock = previewAnimationClock;
    }

    private final void WrapPreview(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-265259911);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WrapPreview)N(content)415@16135L61,410@15768L428:ComposeViewAdapter.android.kt#hevd2p");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-265259911, i2, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview (ComposeViewAdapter.android.kt:405)");
            }
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{CompositionLocalsKt.getLocalFontLoader().provides(new LayoutlibFontResourceLoader(getContext())), CompositionLocalsKt.getLocalFontFamilyResolver().provides(FontFamilyResolver_androidKt.createFontFamilyResolver(getContext())), LocalOnBackPressedDispatcherOwner.INSTANCE.provides(this.FakeOnBackPressedDispatcherOwner), LocalActivityResultRegistryOwner.INSTANCE.provides(this.FakeActivityResultRegistryOwner)}, ComposableLambdaKt.rememberComposableLambda(-874838087, true, new Function2() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeViewAdapter.WrapPreview$lambda$0(this.f$0, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeViewAdapter.WrapPreview$lambda$1(this.f$0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WrapPreview$lambda$0(ComposeViewAdapter composeViewAdapter, Function2 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C416@16149L37:ComposeViewAdapter.android.kt#hevd2p");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-874838087, i, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.WrapPreview.<anonymous> (ComposeViewAdapter.android.kt:416)");
            }
            InspectableKt.Inspectable(composeViewAdapter.slotTableRecord, function2, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void init$ui_tooling$default(ComposeViewAdapter composeViewAdapter, String str, String str2, Class cls, int i, boolean z, boolean z2, long j, boolean z3, String str3, Function0 function0, Function0 function1, int i2, Object obj) {
        composeViewAdapter.init$ui_tooling(str, str2, (i2 & 4) != 0 ? null : cls, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? false : z, (i2 & 32) != 0 ? false : z2, (i2 & 64) != 0 ? -1L : j, (i2 & 128) != 0 ? false : z3, (i2 & 256) != 0 ? null : str3, (i2 & 512) != 0 ? new Function0() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        } : function0, (i2 & 1024) != 0 ? new Function0() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        } : function1);
    }

    public final void init$ui_tooling(final String className, final String methodName, final Class<? extends PreviewParameterProvider<?>> parameterProvider, final int parameterProviderIndex, boolean debugPaintBounds, boolean debugViewInfos, final long animationClockStartTime, boolean lookForDesignInfoProviders, String designInfoProvidersArgument, final Function0<Unit> onCommit, Function0<Unit> onDraw) {
        this.debugPaintBounds = debugPaintBounds;
        this.debugViewInfos = debugViewInfos;
        this.composableName = methodName;
        this.lookForDesignInfoProviders = lookForDesignInfoProviders;
        if (designInfoProvidersArgument == null) {
            designInfoProvidersArgument = "";
        }
        this.designInfoProvidersArgument = designInfoProvidersArgument;
        this.onDraw = onDraw;
        ComposableLambda composableLambdaComposableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(-658298446, true, new Function2() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ComposeViewAdapter.init$lambda$2(onCommit, this, className, methodName, parameterProvider, parameterProviderIndex, animationClockStartTime, (Composer) obj, ((Integer) obj2).intValue());
            }
        });
        this.previewComposition = composableLambdaComposableLambdaInstance;
        this.composeView.setContent(composableLambdaComposableLambdaInstance);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$2(Function0 function0, final ComposeViewAdapter composeViewAdapter, final String str, final String str2, final Class cls, final int i, final long j, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C465@18536L20,467@18586L2933,467@18574L2945:ComposeViewAdapter.android.kt#hevd2p");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-658298446, i2, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.init.<anonymous> (ComposeViewAdapter.android.kt:465)");
            }
            EffectsKt.SideEffect(function0, composer, 0);
            composeViewAdapter.WrapPreview(ComposableLambdaKt.rememberComposableLambda(-1310372571, true, new Function2() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeViewAdapter.init$lambda$2$0(str, str2, cls, i, composeViewAdapter, j, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$2$0(final String str, final String str2, final Class cls, final int i, final ComposeViewAdapter composeViewAdapter, long j, final Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C474@18975L1161:ComposeViewAdapter.android.kt#hevd2p");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1310372571, i2, -1, "androidx.compose.ui.tooling.ComposeViewAdapter.init.<anonymous>.<anonymous> (ComposeViewAdapter.android.kt:468)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -842609394, "CC(remember):ComposeViewAdapter.android.kt#9igjgp");
            boolean zChanged = composer.changed(str) | composer.changed(str2) | composer.changedInstance(composer) | composer.changedInstance(cls) | composer.changed(i) | composer.changedInstance(composeViewAdapter);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Function0 function0 = new Function0() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeViewAdapter.init$lambda$2$0$0$0(str, str2, composer, cls, i, composeViewAdapter);
                    }
                };
                composer.updateRememberedValue(function0);
                objRememberedValue = function0;
            }
            Function0 function1 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (j >= 0) {
                composer.startReplaceGroup(-349877568);
                ComposerKt.sourceInformation(composer, "503@20620L826");
                ComposerKt.sourceInformationMarkerStart(composer, -842557089, "CC(remember):ComposeViewAdapter.android.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(composeViewAdapter);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: androidx.compose.ui.tooling.ComposeViewAdapter$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ComposeViewAdapter.init$lambda$2$0$1$0(this.f$0);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                composeViewAdapter.setClock$ui_tooling(new PreviewAnimationClock((Function0) objRememberedValue2));
            } else {
                composer.startReplaceGroup(-369947619);
            }
            composer.endReplaceGroup();
            function1.invoke();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$2$0$0$0(String str, String str2, Composer composer, Class cls, int i, ComposeViewAdapter composeViewAdapter) {
        Throwable cause;
        try {
            ComposableInvoker composableInvoker = ComposableInvoker.INSTANCE;
            Object[] previewProviderParameters = PreviewUtils_androidKt.getPreviewProviderParameters(cls, i);
            composableInvoker.invokeComposable(str, str2, composer, Arrays.copyOf(previewProviderParameters, previewProviderParameters.length));
            return Unit.INSTANCE;
        } catch (Throwable th) {
            Throwable th2 = th;
            while ((th2 instanceof ReflectiveOperationException) && (cause = th2.getCause()) != null) {
                th2 = cause;
            }
            composeViewAdapter.delayedException.set(th2);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit init$lambda$2$0$1$0(ComposeViewAdapter composeViewAdapter) {
        View childAt = composeViewAdapter.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.compose.ui.platform.ComposeView");
        KeyEvent.Callback childAt2 = ((ComposeView) childAt).getChildAt(0);
        ViewRootForTest viewRootForTest = childAt2 instanceof ViewRootForTest ? (ViewRootForTest) childAt2 : null;
        if (viewRootForTest != null) {
            viewRootForTest.invalidateDescendants();
        }
        Snapshot.INSTANCE.sendApplyNotifications();
        return Unit.INSTANCE;
    }

    public final void dispose$ui_tooling() {
        this.composeView.disposeComposition();
        if (this.clock != null) {
            getClock().dispose();
        }
        this.FakeSavedStateRegistryOwner.getLifecycleRegistry().setCurrentState(Lifecycle.State.DESTROYED);
        this.FakeViewModelStoreOwner.getViewModelStore().clear();
    }

    /* JADX INFO: renamed from: hasAnimations, reason: from getter */
    public final boolean getHasAnimations() {
        return this.hasAnimations;
    }

    private final void init(AttributeSet attrs) {
        long j;
        ComposeViewAdapter composeViewAdapter = this;
        ViewTreeLifecycleOwner.set(composeViewAdapter, this.FakeSavedStateRegistryOwner);
        ViewTreeSavedStateRegistryOwner.set(composeViewAdapter, this.FakeSavedStateRegistryOwner);
        ViewTreeViewModelStoreOwner.set(composeViewAdapter, this.FakeViewModelStoreOwner);
        addView(this.composeView);
        String attributeValue = attrs.getAttributeValue("http://schemas.android.com/tools", "composableName");
        if (attributeValue == null) {
            return;
        }
        String strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(attributeValue, '.', (String) null, 2, (Object) null);
        String strSubstringAfterLast$default = StringsKt.substringAfterLast$default(attributeValue, '.', (String) null, 2, (Object) null);
        int attributeIntValue = attrs.getAttributeIntValue("http://schemas.android.com/tools", "parameterProviderIndex", 0);
        String attributeValue2 = attrs.getAttributeValue("http://schemas.android.com/tools", "parameterProviderClass");
        Class<? extends PreviewParameterProvider<?>> clsAsPreviewProviderClass = attributeValue2 != null ? PreviewUtils_androidKt.asPreviewProviderClass(attributeValue2) : null;
        try {
            j = Long.parseLong(attrs.getAttributeValue("http://schemas.android.com/tools", "animationClockStartTime"));
        } catch (Exception unused) {
            j = -1;
        }
        init$ui_tooling$default(this, strSubstringBeforeLast$default, strSubstringAfterLast$default, clsAsPreviewProviderClass, attributeIntValue, attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "paintBounds", this.debugPaintBounds), attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "printViewInfos", this.debugViewInfos), j, attrs.getAttributeBooleanValue("http://schemas.android.com/tools", "findDesignInfoProviders", this.lookForDesignInfoProviders), attrs.getAttributeValue("http://schemas.android.com/tools", "designInfoProvidersArgument"), null, null, 1536, null);
    }
}
