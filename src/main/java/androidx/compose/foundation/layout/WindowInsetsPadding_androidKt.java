package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WindowInsetsPadding.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0001\u001a>\u0010\r\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0002\b\u00122\u0017\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u000f¢\u0006\u0002\b\u0012H\u0003¨\u0006\u0016"}, d2 = {"safeDrawingPadding", "Landroidx/compose/ui/Modifier;", "safeGesturesPadding", "safeContentPadding", "systemBarsPadding", "displayCutoutPadding", "statusBarsPadding", "imePadding", "navigationBarsPadding", "captionBarPadding", "waterfallPadding", "systemGesturesPadding", "mandatorySystemGesturesPadding", "windowInsetsPadding", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "insetsCalculation", "Landroidx/compose/foundation/layout/WindowInsetsHolder;", "Landroidx/compose/foundation/layout/WindowInsets;", "foundation-layout"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class WindowInsetsPadding_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets systemBarsPadding$lambda$1(WindowInsetsHolder windowInsetsHolder) {
        return windowInsetsHolder.getSystemBars();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets displayCutoutPadding$lambda$1(WindowInsetsHolder windowInsetsHolder) {
        return windowInsetsHolder.getDisplayCutout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets statusBarsPadding$lambda$1(WindowInsetsHolder windowInsetsHolder) {
        return windowInsetsHolder.getStatusBars();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets imePadding$lambda$1(WindowInsetsHolder windowInsetsHolder) {
        return windowInsetsHolder.getIme();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets navigationBarsPadding$lambda$1(WindowInsetsHolder windowInsetsHolder) {
        return windowInsetsHolder.getNavigationBars();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets captionBarPadding$lambda$1(WindowInsetsHolder windowInsetsHolder) {
        return windowInsetsHolder.getCaptionBar();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets waterfallPadding$lambda$1(WindowInsetsHolder windowInsetsHolder) {
        return windowInsetsHolder.getWaterfall();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets systemGesturesPadding$lambda$1(WindowInsetsHolder windowInsetsHolder) {
        return windowInsetsHolder.getSystemGestures();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsets mandatorySystemGesturesPadding$lambda$1(WindowInsetsHolder windowInsetsHolder) {
        return windowInsetsHolder.getMandatorySystemGestures();
    }

    private static final Modifier windowInsetsPadding(Modifier modifier, Function1<? super InspectorInfo, Unit> function1, Function1<? super WindowInsetsHolder, ? extends WindowInsets> function2) {
        return modifier.then(new SystemInsetsPaddingModifierElement(function1, function2));
    }

    public static final Modifier safeDrawingPadding(Modifier modifier) {
        return windowInsetsPadding(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeDrawingPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("safeDrawingPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ((WindowInsetsHolder) obj).getSafeDrawing();
            }
        });
    }

    public static final Modifier safeGesturesPadding(Modifier modifier) {
        return windowInsetsPadding(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeGesturesPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("safeGesturesPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ((WindowInsetsHolder) obj).getSafeGestures();
            }
        });
    }

    public static final Modifier safeContentPadding(Modifier modifier) {
        return windowInsetsPadding(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$safeContentPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("safeContentPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ((WindowInsetsHolder) obj).getSafeContent();
            }
        });
    }

    public static final Modifier systemBarsPadding(Modifier modifier) {
        return windowInsetsPadding(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$systemBarsPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("systemBarsPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WindowInsetsPadding_androidKt.systemBarsPadding$lambda$1((WindowInsetsHolder) obj);
            }
        });
    }

    public static final Modifier displayCutoutPadding(Modifier modifier) {
        return windowInsetsPadding(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$displayCutoutPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("displayCutoutPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WindowInsetsPadding_androidKt.displayCutoutPadding$lambda$1((WindowInsetsHolder) obj);
            }
        });
    }

    public static final Modifier statusBarsPadding(Modifier modifier) {
        return windowInsetsPadding(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$statusBarsPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("statusBarsPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WindowInsetsPadding_androidKt.statusBarsPadding$lambda$1((WindowInsetsHolder) obj);
            }
        });
    }

    public static final Modifier imePadding(Modifier modifier) {
        return windowInsetsPadding(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$imePadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("imePadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WindowInsetsPadding_androidKt.imePadding$lambda$1((WindowInsetsHolder) obj);
            }
        });
    }

    public static final Modifier navigationBarsPadding(Modifier modifier) {
        return windowInsetsPadding(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$navigationBarsPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("navigationBarsPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WindowInsetsPadding_androidKt.navigationBarsPadding$lambda$1((WindowInsetsHolder) obj);
            }
        });
    }

    public static final Modifier captionBarPadding(Modifier modifier) {
        return windowInsetsPadding(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$captionBarPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("captionBarPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WindowInsetsPadding_androidKt.captionBarPadding$lambda$1((WindowInsetsHolder) obj);
            }
        });
    }

    public static final Modifier waterfallPadding(Modifier modifier) {
        return windowInsetsPadding(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$waterfallPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("waterfallPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WindowInsetsPadding_androidKt.waterfallPadding$lambda$1((WindowInsetsHolder) obj);
            }
        });
    }

    public static final Modifier systemGesturesPadding(Modifier modifier) {
        return windowInsetsPadding(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("systemGesturesPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WindowInsetsPadding_androidKt.systemGesturesPadding$lambda$1((WindowInsetsHolder) obj);
            }
        });
    }

    public static final Modifier mandatorySystemGesturesPadding(Modifier modifier) {
        return windowInsetsPadding(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$$inlined$debugInspectorInfo$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("mandatorySystemGesturesPadding");
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function1() { // from class: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WindowInsetsPadding_androidKt.mandatorySystemGesturesPadding$lambda$1((WindowInsetsHolder) obj);
            }
        });
    }
}
