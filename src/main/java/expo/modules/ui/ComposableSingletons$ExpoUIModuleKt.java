package expo.modules.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import expo.modules.kotlin.views.FunctionalComposableScope;
import expo.modules.ui.button.ButtonProps;
import expo.modules.ui.button.IconButtonProps;
import expo.modules.ui.menu.ContextMenuProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ExpoUIModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public final class ComposableSingletons$ExpoUIModuleKt {
    public static final ComposableSingletons$ExpoUIModuleKt INSTANCE = new ComposableSingletons$ExpoUIModuleKt();
    private static Function4<FunctionalComposableScope, ModalBottomSheetProps, Composer, Integer, Unit> lambda$1665482278 = ComposableLambdaKt.composableLambdaInstance(1665482278, false, ComposableSingletons$ExpoUIModuleKt$lambda$1665482278$1.INSTANCE);
    private static Function4<FunctionalComposableScope, PickerProps, Composer, Integer, Unit> lambda$1368449064 = ComposableLambdaKt.composableLambdaInstance(1368449064, false, ComposableSingletons$ExpoUIModuleKt$lambda$1368449064$1.INSTANCE);
    private static Function4<FunctionalComposableScope, SwitchProps, Composer, Integer, Unit> lambda$661371041 = ComposableLambdaKt.composableLambdaInstance(661371041, false, ComposableSingletons$ExpoUIModuleKt$lambda$661371041$1.INSTANCE);

    /* JADX INFO: renamed from: lambda$-282984766, reason: not valid java name */
    private static Function4<FunctionalComposableScope, ButtonProps, Composer, Integer, Unit> f262lambda$282984766 = ComposableLambdaKt.composableLambdaInstance(-282984766, false, ComposableSingletons$ExpoUIModuleKt$lambda$282984766$1.INSTANCE);
    private static Function4<FunctionalComposableScope, IconButtonProps, Composer, Integer, Unit> lambda$1832413544 = ComposableLambdaKt.composableLambdaInstance(1832413544, false, ComposableSingletons$ExpoUIModuleKt$lambda$1832413544$1.INSTANCE);

    /* JADX INFO: renamed from: lambda$-873399247, reason: not valid java name */
    private static Function4<FunctionalComposableScope, SliderProps, Composer, Integer, Unit> f267lambda$873399247 = ComposableLambdaKt.composableLambdaInstance(-873399247, false, new Function4<FunctionalComposableScope, SliderProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$-873399247$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, SliderProps sliderProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, sliderProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, SliderProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C125@3927L20:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-873399247, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$-873399247.<anonymous> (ExpoUIModule.kt:125)");
            }
            SliderViewKt.SliderContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-1515444166, reason: not valid java name */
    private static Function4<FunctionalComposableScope, ShapeProps, Composer, Integer, Unit> f257lambda$1515444166 = ComposableLambdaKt.composableLambdaInstance(-1515444166, false, new Function4<FunctionalComposableScope, ShapeProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$-1515444166$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ShapeProps shapeProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, shapeProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, ShapeProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C129@4012L19:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1515444166, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$-1515444166.<anonymous> (ExpoUIModule.kt:129)");
            }
            ShapeViewKt.ShapeContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function4<FunctionalComposableScope, DividerProps, Composer, Integer, Unit> lambda$1530221537 = ComposableLambdaKt.composableLambdaInstance(1530221537, false, new Function4<FunctionalComposableScope, DividerProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$1530221537$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, DividerProps dividerProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, dividerProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, DividerProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C133@4100L21:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1530221537, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$1530221537.<anonymous> (ExpoUIModule.kt:133)");
            }
            DividerViewKt.DividerContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-1927449818, reason: not valid java name */
    private static Function4<FunctionalComposableScope, DateTimePickerProps, Composer, Integer, Unit> f259lambda$1927449818 = ComposableLambdaKt.composableLambdaInstance(-1927449818, false, ComposableSingletons$ExpoUIModuleKt$lambda$1927449818$1.INSTANCE);
    private static Function4<FunctionalComposableScope, ContextMenuProps, Composer, Integer, Unit> lambda$1585574314 = ComposableLambdaKt.composableLambdaInstance(1585574314, false, ComposableSingletons$ExpoUIModuleKt$lambda$1585574314$1.INSTANCE);
    private static Function4<FunctionalComposableScope, ProgressProps, Composer, Integer, Unit> lambda$68758547 = ComposableLambdaKt.composableLambdaInstance(68758547, false, new Function4<FunctionalComposableScope, ProgressProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$68758547$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ProgressProps progressProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, progressProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, ProgressProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C162@5144L22:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(68758547, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$68758547.<anonymous> (ExpoUIModule.kt:162)");
            }
            ProgressViewKt.ProgressContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-248019729, reason: not valid java name */
    private static Function4<FunctionalComposableScope, LayoutProps, Composer, Integer, Unit> f261lambda$248019729 = ComposableLambdaKt.composableLambdaInstance(-248019729, false, new Function4<FunctionalComposableScope, LayoutProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$-248019729$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, LayoutProps layoutProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, layoutProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, LayoutProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C166@5230L17:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-248019729, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$-248019729.<anonymous> (ExpoUIModule.kt:166)");
            }
            ComposeViewsKt.BoxContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-932250034, reason: not valid java name */
    private static Function4<FunctionalComposableScope, LayoutProps, Composer, Integer, Unit> f268lambda$932250034 = ComposableLambdaKt.composableLambdaInstance(-932250034, false, new Function4<FunctionalComposableScope, LayoutProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$-932250034$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, LayoutProps layoutProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, layoutProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, LayoutProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C170@5311L17:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-932250034, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$-932250034.<anonymous> (ExpoUIModule.kt:170)");
            }
            ComposeViewsKt.RowContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-1616480339, reason: not valid java name */
    private static Function4<FunctionalComposableScope, LayoutProps, Composer, Integer, Unit> f258lambda$1616480339 = ComposableLambdaKt.composableLambdaInstance(-1616480339, false, new Function4<FunctionalComposableScope, LayoutProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$-1616480339$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, LayoutProps layoutProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, layoutProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, LayoutProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C174@5396L21:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1616480339, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$-1616480339.<anonymous> (ExpoUIModule.kt:174)");
            }
            ComposeViewsKt.FlowRowContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function4<FunctionalComposableScope, LayoutProps, Composer, Integer, Unit> lambda$1994256652 = ComposableLambdaKt.composableLambdaInstance(1994256652, false, new Function4<FunctionalComposableScope, LayoutProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$1994256652$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, LayoutProps layoutProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, layoutProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, LayoutProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C178@5484L20:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1994256652, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$1994256652.<anonymous> (ExpoUIModule.kt:178)");
            }
            ComposeViewsKt.ColumnContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function4<FunctionalComposableScope, TextProps, Composer, Integer, Unit> lambda$804575342 = ComposableLambdaKt.composableLambdaInstance(804575342, false, new Function4<FunctionalComposableScope, TextProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$804575342$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, TextProps textProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, textProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, TextProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C182@5567L18:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(804575342, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$804575342.<anonymous> (ExpoUIModule.kt:182)");
            }
            TextViewKt.TextContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function4<FunctionalComposableScope, SearchBarProps, Composer, Integer, Unit> lambda$230995585 = ComposableLambdaKt.composableLambdaInstance(230995585, false, ComposableSingletons$ExpoUIModuleKt$lambda$230995585$1.INSTANCE);

    /* JADX INFO: renamed from: lambda$-42052306, reason: not valid java name */
    private static Function4<FunctionalComposableScope, DockedSearchBarProps, Composer, Integer, Unit> f263lambda$42052306 = ComposableLambdaKt.composableLambdaInstance(-42052306, false, ComposableSingletons$ExpoUIModuleKt$lambda$42052306$1.INSTANCE);

    /* JADX INFO: renamed from: lambda$-2070623419, reason: not valid java name */
    private static Function4<FunctionalComposableScope, HorizontalFloatingToolbarProps, Composer, Integer, Unit> f260lambda$2070623419 = ComposableLambdaKt.composableLambdaInstance(-2070623419, false, new Function4<FunctionalComposableScope, HorizontalFloatingToolbarProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$-2070623419$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, HorizontalFloatingToolbarProps horizontalFloatingToolbarProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, horizontalFloatingToolbarProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, HorizontalFloatingToolbarProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C200@6201L39:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2070623419, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$-2070623419.<anonymous> (ExpoUIModule.kt:200)");
            }
            HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function4<FunctionalComposableScope, PullToRefreshBoxProps, Composer, Integer, Unit> lambda$596787373 = ComposableLambdaKt.composableLambdaInstance(596787373, false, ComposableSingletons$ExpoUIModuleKt$lambda$596787373$1.INSTANCE);
    private static Function4<FunctionalComposableScope, CarouselProps, Composer, Integer, Unit> lambda$994123911 = ComposableLambdaKt.composableLambdaInstance(994123911, false, new Function4<FunctionalComposableScope, CarouselProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$994123911$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, CarouselProps carouselProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, carouselProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, CarouselProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C211@6552L22:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(994123911, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$994123911.<anonymous> (ExpoUIModule.kt:211)");
            }
            CarouselViewKt.CarouselContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function4<FunctionalComposableScope, AlertDialogProps, Composer, Integer, Unit> lambda$77819936 = ComposableLambdaKt.composableLambdaInstance(77819936, false, ComposableSingletons$ExpoUIModuleKt$lambda$77819936$1.INSTANCE);
    private static Function4<FunctionalComposableScope, ChipProps, Composer, Integer, Unit> lambda$1003922353 = ComposableLambdaKt.composableLambdaInstance(1003922353, false, ComposableSingletons$ExpoUIModuleKt$lambda$1003922353$1.INSTANCE);
    private static Function4<FunctionalComposableScope, FilterChipProps, Composer, Integer, Unit> lambda$256499432 = ComposableLambdaKt.composableLambdaInstance(256499432, false, ComposableSingletons$ExpoUIModuleKt$lambda$256499432$1.INSTANCE);

    /* JADX INFO: renamed from: lambda$-55812126, reason: not valid java name */
    private static Function4<FunctionalComposableScope, TextButtonProps, Composer, Integer, Unit> f265lambda$55812126 = ComposableLambdaKt.composableLambdaInstance(-55812126, false, ComposableSingletons$ExpoUIModuleKt$lambda$55812126$1.INSTANCE);
    private static Function4<FunctionalComposableScope, ToggleButtonProps, Composer, Integer, Unit> lambda$2043498664 = ComposableLambdaKt.composableLambdaInstance(2043498664, false, ComposableSingletons$ExpoUIModuleKt$lambda$2043498664$1.INSTANCE);

    /* JADX INFO: renamed from: lambda$-1035540239, reason: not valid java name */
    private static Function4<FunctionalComposableScope, CardProps, Composer, Integer, Unit> f255lambda$1035540239 = ComposableLambdaKt.composableLambdaInstance(-1035540239, false, new Function4<FunctionalComposableScope, CardProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$-1035540239$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, CardProps cardProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, cardProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, CardProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C262@8218L18:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1035540239, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$-1035540239.<anonymous> (ExpoUIModule.kt:262)");
            }
            CardViewKt.CardContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-1030307887, reason: not valid java name */
    private static Function4<FunctionalComposableScope, ListItemProps, Composer, Integer, Unit> f254lambda$1030307887 = ComposableLambdaKt.composableLambdaInstance(-1030307887, false, new Function4<FunctionalComposableScope, ListItemProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$-1030307887$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, ListItemProps listItemProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, listItemProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, ListItemProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C266@8307L22:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1030307887, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$-1030307887.<anonymous> (ExpoUIModule.kt:266)");
            }
            ListItemViewKt.ListItemContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-767778165, reason: not valid java name */
    private static Function4<FunctionalComposableScope, SpacerProps, Composer, Integer, Unit> f266lambda$767778165 = ComposableLambdaKt.composableLambdaInstance(-767778165, false, new Function4<FunctionalComposableScope, SpacerProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$-767778165$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, SpacerProps spacerProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, spacerProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, SpacerProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C270@8396L20:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-767778165, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$-767778165.<anonymous> (ExpoUIModule.kt:270)");
            }
            SpacerViewKt.SpacerContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });
    private static Function4<FunctionalComposableScope, BasicAlertDialogProps, Composer, Integer, Unit> lambda$2122913972 = ComposableLambdaKt.composableLambdaInstance(2122913972, false, ComposableSingletons$ExpoUIModuleKt$lambda$2122913972$1.INSTANCE);

    /* JADX INFO: renamed from: lambda$-1252238869, reason: not valid java name */
    private static Function4<FunctionalComposableScope, SurfaceProps, Composer, Integer, Unit> f256lambda$1252238869 = ComposableLambdaKt.composableLambdaInstance(-1252238869, false, new Function4<FunctionalComposableScope, SurfaceProps, Composer, Integer, Unit>() { // from class: expo.modules.ui.ComposableSingletons$ExpoUIModuleKt$lambda$-1252238869$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(FunctionalComposableScope functionalComposableScope, SurfaceProps surfaceProps, Composer composer, Integer num) {
            invoke(functionalComposableScope, surfaceProps, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(FunctionalComposableScope ExpoUIView, SurfaceProps props, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(ExpoUIView, "$this$ExpoUIView");
            Intrinsics.checkNotNullParameter(props, "props");
            ComposerKt.sourceInformation(composer, "C281@8747L21:ExpoUIModule.kt#v15e7d");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1252238869, i, -1, "expo.modules.ui.ComposableSingletons$ExpoUIModuleKt.lambda$-1252238869.<anonymous> (ExpoUIModule.kt:281)");
            }
            SurfaceViewKt.SurfaceContent(ExpoUIView, props, composer, FunctionalComposableScope.$stable | (i & 14) | (i & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* JADX INFO: renamed from: lambda$-504997846, reason: not valid java name */
    private static Function4<FunctionalComposableScope, RadioButtonProps, Composer, Integer, Unit> f264lambda$504997846 = ComposableLambdaKt.composableLambdaInstance(-504997846, false, ComposableSingletons$ExpoUIModuleKt$lambda$504997846$1.INSTANCE);

    /* JADX INFO: renamed from: getLambda$-1030307887$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, ListItemProps, Composer, Integer, Unit> m14626getLambda$1030307887$expo_ui_release() {
        return f254lambda$1030307887;
    }

    /* JADX INFO: renamed from: getLambda$-1035540239$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, CardProps, Composer, Integer, Unit> m14627getLambda$1035540239$expo_ui_release() {
        return f255lambda$1035540239;
    }

    /* JADX INFO: renamed from: getLambda$-1252238869$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, SurfaceProps, Composer, Integer, Unit> m14628getLambda$1252238869$expo_ui_release() {
        return f256lambda$1252238869;
    }

    /* JADX INFO: renamed from: getLambda$-1515444166$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, ShapeProps, Composer, Integer, Unit> m14629getLambda$1515444166$expo_ui_release() {
        return f257lambda$1515444166;
    }

    /* JADX INFO: renamed from: getLambda$-1616480339$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, LayoutProps, Composer, Integer, Unit> m14630getLambda$1616480339$expo_ui_release() {
        return f258lambda$1616480339;
    }

    /* JADX INFO: renamed from: getLambda$-1927449818$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, DateTimePickerProps, Composer, Integer, Unit> m14631getLambda$1927449818$expo_ui_release() {
        return f259lambda$1927449818;
    }

    /* JADX INFO: renamed from: getLambda$-2070623419$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, HorizontalFloatingToolbarProps, Composer, Integer, Unit> m14632getLambda$2070623419$expo_ui_release() {
        return f260lambda$2070623419;
    }

    /* JADX INFO: renamed from: getLambda$-248019729$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, LayoutProps, Composer, Integer, Unit> m14633getLambda$248019729$expo_ui_release() {
        return f261lambda$248019729;
    }

    /* JADX INFO: renamed from: getLambda$-282984766$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, ButtonProps, Composer, Integer, Unit> m14634getLambda$282984766$expo_ui_release() {
        return f262lambda$282984766;
    }

    /* JADX INFO: renamed from: getLambda$-42052306$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, DockedSearchBarProps, Composer, Integer, Unit> m14635getLambda$42052306$expo_ui_release() {
        return f263lambda$42052306;
    }

    /* JADX INFO: renamed from: getLambda$-504997846$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, RadioButtonProps, Composer, Integer, Unit> m14636getLambda$504997846$expo_ui_release() {
        return f264lambda$504997846;
    }

    /* JADX INFO: renamed from: getLambda$-55812126$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, TextButtonProps, Composer, Integer, Unit> m14637getLambda$55812126$expo_ui_release() {
        return f265lambda$55812126;
    }

    /* JADX INFO: renamed from: getLambda$-767778165$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, SpacerProps, Composer, Integer, Unit> m14638getLambda$767778165$expo_ui_release() {
        return f266lambda$767778165;
    }

    /* JADX INFO: renamed from: getLambda$-873399247$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, SliderProps, Composer, Integer, Unit> m14639getLambda$873399247$expo_ui_release() {
        return f267lambda$873399247;
    }

    /* JADX INFO: renamed from: getLambda$-932250034$expo_ui_release, reason: not valid java name */
    public final Function4<FunctionalComposableScope, LayoutProps, Composer, Integer, Unit> m14640getLambda$932250034$expo_ui_release() {
        return f268lambda$932250034;
    }

    public final Function4<FunctionalComposableScope, ChipProps, Composer, Integer, Unit> getLambda$1003922353$expo_ui_release() {
        return lambda$1003922353;
    }

    public final Function4<FunctionalComposableScope, PickerProps, Composer, Integer, Unit> getLambda$1368449064$expo_ui_release() {
        return lambda$1368449064;
    }

    public final Function4<FunctionalComposableScope, DividerProps, Composer, Integer, Unit> getLambda$1530221537$expo_ui_release() {
        return lambda$1530221537;
    }

    public final Function4<FunctionalComposableScope, ContextMenuProps, Composer, Integer, Unit> getLambda$1585574314$expo_ui_release() {
        return lambda$1585574314;
    }

    public final Function4<FunctionalComposableScope, ModalBottomSheetProps, Composer, Integer, Unit> getLambda$1665482278$expo_ui_release() {
        return lambda$1665482278;
    }

    public final Function4<FunctionalComposableScope, IconButtonProps, Composer, Integer, Unit> getLambda$1832413544$expo_ui_release() {
        return lambda$1832413544;
    }

    public final Function4<FunctionalComposableScope, LayoutProps, Composer, Integer, Unit> getLambda$1994256652$expo_ui_release() {
        return lambda$1994256652;
    }

    public final Function4<FunctionalComposableScope, ToggleButtonProps, Composer, Integer, Unit> getLambda$2043498664$expo_ui_release() {
        return lambda$2043498664;
    }

    public final Function4<FunctionalComposableScope, BasicAlertDialogProps, Composer, Integer, Unit> getLambda$2122913972$expo_ui_release() {
        return lambda$2122913972;
    }

    public final Function4<FunctionalComposableScope, SearchBarProps, Composer, Integer, Unit> getLambda$230995585$expo_ui_release() {
        return lambda$230995585;
    }

    public final Function4<FunctionalComposableScope, FilterChipProps, Composer, Integer, Unit> getLambda$256499432$expo_ui_release() {
        return lambda$256499432;
    }

    public final Function4<FunctionalComposableScope, PullToRefreshBoxProps, Composer, Integer, Unit> getLambda$596787373$expo_ui_release() {
        return lambda$596787373;
    }

    public final Function4<FunctionalComposableScope, SwitchProps, Composer, Integer, Unit> getLambda$661371041$expo_ui_release() {
        return lambda$661371041;
    }

    public final Function4<FunctionalComposableScope, ProgressProps, Composer, Integer, Unit> getLambda$68758547$expo_ui_release() {
        return lambda$68758547;
    }

    public final Function4<FunctionalComposableScope, AlertDialogProps, Composer, Integer, Unit> getLambda$77819936$expo_ui_release() {
        return lambda$77819936;
    }

    public final Function4<FunctionalComposableScope, TextProps, Composer, Integer, Unit> getLambda$804575342$expo_ui_release() {
        return lambda$804575342;
    }

    public final Function4<FunctionalComposableScope, CarouselProps, Composer, Integer, Unit> getLambda$994123911$expo_ui_release() {
        return lambda$994123911;
    }
}
