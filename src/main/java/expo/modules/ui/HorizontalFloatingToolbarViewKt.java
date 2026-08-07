package expo.modules.ui;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.FloatingToolbarColors;
import androidx.compose.material3.FloatingToolbarDefaults;
import androidx.compose.material3.FloatingToolbarKt;
import androidx.compose.material3.FloatingToolbarScrollBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HorizontalFloatingToolbarView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"HorizontalFloatingToolbarContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/HorizontalFloatingToolbarProps;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/HorizontalFloatingToolbarProps;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HorizontalFloatingToolbarViewKt {

    /* JADX INFO: compiled from: HorizontalFloatingToolbarView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HorizontalFloatingToolbarVariant.values().length];
            try {
                iArr[HorizontalFloatingToolbarVariant.VIBRANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HorizontalFloatingToolbarContent$lambda$2(FunctionalComposableScope functionalComposableScope, HorizontalFloatingToolbarProps horizontalFloatingToolbarProps, int i, Composer composer, int i2) {
        HorizontalFloatingToolbarContent(functionalComposableScope, horizontalFloatingToolbarProps, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void HorizontalFloatingToolbarContent(final FunctionalComposableScope functionalComposableScope, final HorizontalFloatingToolbarProps props, Composer composer, final int i) {
        int i2;
        FloatingToolbarColors floatingToolbarColorsStandardFloatingToolbarColors;
        Composer composer2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Composer composerStartRestartGroup = composer.startRestartGroup(1356050480);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(HorizontalFloatingToolbarContent)34@1387L48,38@1478L474,57@2190L83,59@2327L67,53@2052L342:HorizontalFloatingToolbarView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1356050480, i2, -1, "expo.modules.ui.HorizontalFloatingToolbarContent (HorizontalFloatingToolbarView.kt:26)");
            }
            HorizontalFloatingToolbarVariant variant = props.getVariant();
            if ((variant != null ? WhenMappings.$EnumSwitchMapping$0[variant.ordinal()] : -1) == 1) {
                composerStartRestartGroup.startReplaceGroup(1789427854);
                ComposerKt.sourceInformation(composerStartRestartGroup, "28@1129L30");
                floatingToolbarColorsStandardFloatingToolbarColors = FloatingToolbarDefaults.INSTANCE.vibrantFloatingToolbarColors(composerStartRestartGroup, FloatingToolbarDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(1789429999);
                ComposerKt.sourceInformation(composerStartRestartGroup, "29@1196L31");
                floatingToolbarColorsStandardFloatingToolbarColors = FloatingToolbarDefaults.INSTANCE.standardFloatingToolbarColors(composerStartRestartGroup, FloatingToolbarDefaults.$stable);
                composerStartRestartGroup.endReplaceGroup();
            }
            FloatingToolbarColors floatingToolbarColors = floatingToolbarColorsStandardFloatingToolbarColors;
            final SlotView slotViewFindChildSlotView = SlotViewKt.findChildSlotView(functionalComposableScope.getView(), "floatingActionButton");
            composerStartRestartGroup.startReplaceGroup(5004770);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):HorizontalFloatingToolbarView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(slotViewFindChildSlotView);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent$lambda$1$lambda$0(slotViewFindChildSlotView);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final Function0 function0 = (Function0) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1570128376, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1

                /* JADX INFO: compiled from: HorizontalFloatingToolbarView.kt */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[HorizontalFloatingToolbarVariant.values().length];
                        try {
                            iArr[HorizontalFloatingToolbarVariant.VIBRANT.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: HorizontalFloatingToolbarView.kt */
                @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                static final class AnonymousClass1 implements Function2<Composer, Integer, Unit> {
                    final /* synthetic */ FunctionalComposableScope $this_HorizontalFloatingToolbarContent;

                    AnonymousClass1(FunctionalComposableScope functionalComposableScope) {
                        this.$this_HorizontalFloatingToolbarContent = functionalComposableScope;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final boolean invoke$lambda$1$lambda$0(ExpoComposeView it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return SlotViewKt.isSlotWithName(it, "floatingActionButton");
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C43@1694L46,43@1657L84:HorizontalFloatingToolbarView.kt#v15e7d");
                        if ((i & 3) == 2 && composer.getSkipping()) {
                            composer.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(443807521, i, -1, "expo.modules.ui.HorizontalFloatingToolbarContent.<anonymous>.<anonymous> (HorizontalFloatingToolbarView.kt:43)");
                        }
                        FunctionalComposableScope functionalComposableScope = this.$this_HorizontalFloatingToolbarContent;
                        ComposableScope composableScope = new ComposableScope(null, null, null, null, 15, null);
                        composer.startReplaceGroup(1849434622);
                        ComposerKt.sourceInformation(composer, "CC(remember):HorizontalFloatingToolbarView.kt#9igjgp");
                        Object objRememberedValue = composer.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = 
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: CONSTRUCTOR (r9v6 'objRememberedValue' java.lang.Object) =  A[MD:():void (m)] (LINE:67) call: expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1$1$$ExternalSyntheticLambda0.<init>():void type: CONSTRUCTOR in method: expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1.1.invoke(androidx.compose.runtime.Composer, int):void, file: classes4.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1$1$$ExternalSyntheticLambda0, state: NOT_LOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                	... 102 more
                                */
                            /*
                                this = this;
                                java.lang.String r0 = "C43@1694L46,43@1657L84:HorizontalFloatingToolbarView.kt#v15e7d"
                                androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
                                r0 = r9 & 3
                                r1 = 2
                                if (r0 != r1) goto L15
                                boolean r0 = r8.getSkipping()
                                if (r0 != 0) goto L11
                                goto L15
                            L11:
                                r8.skipToGroupEnd()
                                return
                            L15:
                                boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r0 == 0) goto L24
                                r0 = -1
                                java.lang.String r1 = "expo.modules.ui.HorizontalFloatingToolbarContent.<anonymous>.<anonymous> (HorizontalFloatingToolbarView.kt:43)"
                                r2 = 443807521(0x1a73f721, float:5.045085E-23)
                                androidx.compose.runtime.ComposerKt.traceEventStart(r2, r9, r0, r1)
                            L24:
                                expo.modules.kotlin.views.FunctionalComposableScope r7 = r7.$this_HorizontalFloatingToolbarContent
                                expo.modules.kotlin.views.ComposableScope r0 = new expo.modules.kotlin.views.ComposableScope
                                r5 = 15
                                r6 = 0
                                r1 = 0
                                r2 = 0
                                r3 = 0
                                r4 = 0
                                r0.<init>(r1, r2, r3, r4, r5, r6)
                                r9 = 1849434622(0x6e3c21fe, float:1.4556069E28)
                                r8.startReplaceGroup(r9)
                                java.lang.String r9 = "CC(remember):HorizontalFloatingToolbarView.kt#9igjgp"
                                androidx.compose.runtime.ComposerKt.sourceInformation(r8, r9)
                                java.lang.Object r9 = r8.rememberedValue()
                                androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.INSTANCE
                                java.lang.Object r1 = r1.getEmpty()
                                if (r9 != r1) goto L51
                                expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1$1$$ExternalSyntheticLambda0 r9 = new expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1$1$$ExternalSyntheticLambda0
                                r9.<init>()
                                r8.updateRememberedValue(r9)
                            L51:
                                kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
                                r8.endReplaceGroup()
                                int r1 = expo.modules.kotlin.views.ComposableScope.$stable
                                r1 = r1 | 48
                                int r2 = expo.modules.kotlin.views.FunctionalComposableScope.$stable
                                int r2 = r2 << 6
                                r1 = r1 | r2
                                r7.Children(r0, r9, r8, r1)
                                boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                if (r7 == 0) goto L6b
                                androidx.compose.runtime.ComposerKt.traceEventEnd()
                            L6b:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1.AnonymousClass1.invoke(androidx.compose.runtime.Composer, int):void");
                        }
                    }

                    /* JADX INFO: renamed from: expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1$2, reason: invalid class name */
                    /* JADX INFO: compiled from: HorizontalFloatingToolbarView.kt */
                    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
                    static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
                        final /* synthetic */ FunctionalComposableScope $this_HorizontalFloatingToolbarContent;

                        AnonymousClass2(FunctionalComposableScope functionalComposableScope) {
                            this.$this_HorizontalFloatingToolbarContent = functionalComposableScope;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: Access modifiers changed from: private */
                        public static final boolean invoke$lambda$1$lambda$0(ExpoComposeView it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            return SlotViewKt.isSlotWithName(it, "floatingActionButton");
                        }

                        public final void invoke(Composer composer, int i) {
                            ComposerKt.sourceInformation(composer, "C47@1887L46,47@1850L84:HorizontalFloatingToolbarView.kt#v15e7d");
                            if ((i & 3) == 2 && composer.getSkipping()) {
                                composer.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1784730855, i, -1, "expo.modules.ui.HorizontalFloatingToolbarContent.<anonymous>.<anonymous> (HorizontalFloatingToolbarView.kt:47)");
                            }
                            FunctionalComposableScope functionalComposableScope = this.$this_HorizontalFloatingToolbarContent;
                            ComposableScope composableScope = new ComposableScope(null, null, null, null, 15, null);
                            composer.startReplaceGroup(1849434622);
                            ComposerKt.sourceInformation(composer, "CC(remember):HorizontalFloatingToolbarView.kt#9igjgp");
                            Object objRememberedValue = composer.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = 
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004b: CONSTRUCTOR (r9v6 'objRememberedValue' java.lang.Object) =  A[MD:():void (m)] (LINE:67) call: expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1$2$$ExternalSyntheticLambda0.<init>():void type: CONSTRUCTOR in method: expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1.2.invoke(androidx.compose.runtime.Composer, int):void, file: classes4.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                    	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                                    	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                                    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                                    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                                    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                                    	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                                    	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                                    	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                                    	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1$2$$ExternalSyntheticLambda0, state: NOT_LOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                                    	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                                    	... 102 more
                                    */
                                /*
                                    this = this;
                                    java.lang.String r0 = "C47@1887L46,47@1850L84:HorizontalFloatingToolbarView.kt#v15e7d"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r8, r0)
                                    r0 = r9 & 3
                                    r1 = 2
                                    if (r0 != r1) goto L15
                                    boolean r0 = r8.getSkipping()
                                    if (r0 != 0) goto L11
                                    goto L15
                                L11:
                                    r8.skipToGroupEnd()
                                    return
                                L15:
                                    boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r0 == 0) goto L24
                                    r0 = -1
                                    java.lang.String r1 = "expo.modules.ui.HorizontalFloatingToolbarContent.<anonymous>.<anonymous> (HorizontalFloatingToolbarView.kt:47)"
                                    r2 = 1784730855(0x6a60d4e7, float:6.7951197E25)
                                    androidx.compose.runtime.ComposerKt.traceEventStart(r2, r9, r0, r1)
                                L24:
                                    expo.modules.kotlin.views.FunctionalComposableScope r7 = r7.$this_HorizontalFloatingToolbarContent
                                    expo.modules.kotlin.views.ComposableScope r0 = new expo.modules.kotlin.views.ComposableScope
                                    r5 = 15
                                    r6 = 0
                                    r1 = 0
                                    r2 = 0
                                    r3 = 0
                                    r4 = 0
                                    r0.<init>(r1, r2, r3, r4, r5, r6)
                                    r9 = 1849434622(0x6e3c21fe, float:1.4556069E28)
                                    r8.startReplaceGroup(r9)
                                    java.lang.String r9 = "CC(remember):HorizontalFloatingToolbarView.kt#9igjgp"
                                    androidx.compose.runtime.ComposerKt.sourceInformation(r8, r9)
                                    java.lang.Object r9 = r8.rememberedValue()
                                    androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.INSTANCE
                                    java.lang.Object r1 = r1.getEmpty()
                                    if (r9 != r1) goto L51
                                    expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1$2$$ExternalSyntheticLambda0 r9 = new expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1$2$$ExternalSyntheticLambda0
                                    r9.<init>()
                                    r8.updateRememberedValue(r9)
                                L51:
                                    kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
                                    r8.endReplaceGroup()
                                    int r1 = expo.modules.kotlin.views.ComposableScope.$stable
                                    r1 = r1 | 48
                                    int r2 = expo.modules.kotlin.views.FunctionalComposableScope.$stable
                                    int r2 = r2 << 6
                                    r1 = r1 | r2
                                    r7.Children(r0, r9, r8, r1)
                                    boolean r7 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
                                    if (r7 == 0) goto L6b
                                    androidx.compose.runtime.ComposerKt.traceEventEnd()
                                L6b:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$floatingActionButton$1.AnonymousClass2.invoke(androidx.compose.runtime.Composer, int):void");
                            }
                        }

                        public final void invoke(Composer composer3, int i3) {
                            ComposerKt.sourceInformation(composer3, "C:HorizontalFloatingToolbarView.kt#v15e7d");
                            if ((i3 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1570128376, i3, -1, "expo.modules.ui.HorizontalFloatingToolbarContent.<anonymous> (HorizontalFloatingToolbarView.kt:39)");
                            }
                            HorizontalFloatingToolbarVariant variant2 = props.getVariant();
                            if ((variant2 != null ? WhenMappings.$EnumSwitchMapping$0[variant2.ordinal()] : -1) == 1) {
                                composer3.startReplaceGroup(-1359844976);
                                ComposerKt.sourceInformation(composer3, "42@1647L102,40@1581L168");
                                FloatingToolbarDefaults.INSTANCE.m3422VibrantFloatingActionButtonvRFhKjU(function0, null, null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(443807521, true, new AnonymousClass1(functionalComposableScope), composer3, 54), composer3, (FloatingToolbarDefaults.$stable << 21) | 1572864, 62);
                                composer3.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(-1359838335);
                                ComposerKt.sourceInformation(composer3, "46@1840L102,46@1789L153");
                                FloatingToolbarDefaults.INSTANCE.m3421StandardFloatingActionButtonvRFhKjU(function0, null, null, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(1784730855, true, new AnonymousClass2(functionalComposableScope), composer3, 54), composer3, (FloatingToolbarDefaults.$stable << 21) | 1572864, 62);
                                composer3.endReplaceGroup();
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composerStartRestartGroup, 54);
                    NestedScrollConnection nestedScrollConnection = functionalComposableScope.getComposableScope().getNestedScrollConnection();
                    composer2 = composerStartRestartGroup;
                    FloatingToolbarKt.m3477HorizontalFloatingToolbarekznXB8(true, composableLambdaRememberComposableLambda, ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (AppContext.$stable << 3) | (ComposableScope.$stable << 6)), floatingToolbarColors, null, nestedScrollConnection instanceof FloatingToolbarScrollBehavior ? (FloatingToolbarScrollBehavior) nestedScrollConnection : null, null, 0, null, 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(1909086202, true, new AnonymousClass1(functionalComposableScope), composerStartRestartGroup, 54), composer2, 54, 48, 2000);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    composer2 = composerStartRestartGroup;
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return HorizontalFloatingToolbarViewKt.HorizontalFloatingToolbarContent$lambda$2(functionalComposableScope, props, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit HorizontalFloatingToolbarContent$lambda$1$lambda$0(SlotView slotView) {
                ViewEventCallback<Unit> onSlotEvent$expo_ui_release;
                if (slotView != null && (onSlotEvent$expo_ui_release = slotView.getOnSlotEvent$expo_ui_release()) != null) {
                    onSlotEvent$expo_ui_release.invoke(Unit.INSTANCE);
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$1, reason: invalid class name */
            /* JADX INFO: compiled from: HorizontalFloatingToolbarView.kt */
            @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
            static final class AnonymousClass1 implements Function3<RowScope, Composer, Integer, Unit> {
                final /* synthetic */ FunctionalComposableScope $this_HorizontalFloatingToolbarContent;

                AnonymousClass1(FunctionalComposableScope functionalComposableScope) {
                    this.$this_HorizontalFloatingToolbarContent = functionalComposableScope;
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
                    invoke(rowScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final boolean invoke$lambda$1$lambda$0(ExpoComposeView it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return !SlotViewKt.isSlotView(it);
                }

                public final void invoke(RowScope HorizontalFloatingToolbar, Composer composer, int i) {
                    Intrinsics.checkNotNullParameter(HorizontalFloatingToolbar, "$this$HorizontalFloatingToolbar");
                    ComposerKt.sourceInformation(composer, "C60@2370L19,60@2333L57:HorizontalFloatingToolbarView.kt#v15e7d");
                    if ((i & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1909086202, i, -1, "expo.modules.ui.HorizontalFloatingToolbarContent.<anonymous> (HorizontalFloatingToolbarView.kt:60)");
                    }
                    FunctionalComposableScope functionalComposableScope = this.$this_HorizontalFloatingToolbarContent;
                    ComposableScope composableScope = new ComposableScope(null, null, null, null, 15, null);
                    composer.startReplaceGroup(1849434622);
                    ComposerKt.sourceInformation(composer, "CC(remember):HorizontalFloatingToolbarView.kt#9igjgp");
                    Object objRememberedValue = composer.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: expo.modules.ui.HorizontalFloatingToolbarViewKt$HorizontalFloatingToolbarContent$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Boolean.valueOf(HorizontalFloatingToolbarViewKt.AnonymousClass1.invoke$lambda$1$lambda$0((ExpoComposeView) obj));
                            }
                        };
                        composer.updateRememberedValue(objRememberedValue);
                    }
                    composer.endReplaceGroup();
                    functionalComposableScope.Children(composableScope, (Function1) objRememberedValue, composer, ComposableScope.$stable | 48 | (FunctionalComposableScope.$stable << 6));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }
        }
