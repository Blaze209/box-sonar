package com.box.android.jobsui;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.FolderOpenKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.CompositionSource;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.RawConstraintSet;
import com.box.android.base.compose.BoxCheckBoxKt;
import com.box.android.base.compose.BoxItemThumbnailKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ItemThumbnail;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: compiled from: ConstraintLayout.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "invoke", "(Landroidx/compose/runtime/Composer;I)V", "androidx/constraintlayout/compose/ConstraintLayoutKt$ConstraintLayout$contentDelegate$1"}, k = 3, mv = {2, 2, 0}, xi = 48)
public final class JobListingScreenKt$JobItem$lambda$9$$inlined$ConstraintLayout$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Channel $channel;
    final /* synthetic */ Ref $compositionSource;
    final /* synthetic */ MutableState $contentTracker;
    final /* synthetic */ MutableState $end;
    final /* synthetic */ boolean $isActionMode$inlined;
    final /* synthetic */ boolean $isRedesignedVersion$inlined;
    final /* synthetic */ State $jobState$delegate$inlined;
    final /* synthetic */ State $progressState$delegate$inlined;
    final /* synthetic */ ConstraintLayoutScope $scope;
    final /* synthetic */ MutableState $start;
    final /* synthetic */ Store $store$inlined;
    final /* synthetic */ State $thumbnail$delegate$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobListingScreenKt$JobItem$lambda$9$$inlined$ConstraintLayout$1(MutableState mutableState, Ref ref, ConstraintLayoutScope constraintLayoutScope, Channel channel, MutableState mutableState2, MutableState mutableState3, boolean z, Store store, boolean z2, State state, State state2, State state3) {
        super(2);
        this.$contentTracker = mutableState;
        this.$compositionSource = ref;
        this.$scope = constraintLayoutScope;
        this.$channel = channel;
        this.$start = mutableState2;
        this.$end = mutableState3;
        this.$isActionMode$inlined = z;
        this.$store$inlined = store;
        this.$isRedesignedVersion$inlined = z2;
        this.$jobState$delegate$inlined = state;
        this.$thumbnail$delegate$inlined = state2;
        this.$progressState$delegate$inlined = state3;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ConstrainedLayoutReference constrainedLayoutReference;
        ConstraintLayoutScope constraintLayoutScope;
        ComposerKt.sourceInformation(composer, "C381@17480L14,383@17562L681,383@17551L692:ConstraintLayout.kt#fysre8");
        if ((i & 3) != 2 || !composer.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-74958949, i, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:371)");
            }
            this.$contentTracker.setValue(Unit.INSTANCE);
            if (this.$compositionSource.getValue() == CompositionSource.Unknown) {
                this.$compositionSource.setValue(CompositionSource.Content);
            }
            this.$scope.reset();
            ConstraintLayoutScope constraintLayoutScope2 = this.$scope;
            composer.startReplaceGroup(-470151899);
            ComposerKt.sourceInformation(composer, "C271@10725L33,272@10816L6,275@10963L270,270@10692L555,287@11412L218,283@11261L383,297@11781L290,306@12243L6,294@11658L616,309@12344L294,339@13653L169:JobListingScreen.kt#6w6mzd");
            ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesCreateRefs = constraintLayoutScope2.createRefs();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent1 = constrainedLayoutReferencesCreateRefs.component1();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent2 = constrainedLayoutReferencesCreateRefs.component2();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent3 = constrainedLayoutReferencesCreateRefs.component3();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent4 = constrainedLayoutReferencesCreateRefs.component4();
            ConstrainedLayoutReference constrainedLayoutReferenceComponent5 = constrainedLayoutReferencesCreateRefs.component5();
            Painter painterPainterResource = PainterResources_androidKt.painterResource(JobListingScreenKt.JobItem$lambda$1(this.$jobState$delegate$inlined).getIconRes(), composer, 0);
            ColorFilter colorFilterM6855tintxETnrds$default = ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), 0, 2, null);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 400483825, "CC(remember):JobListingScreen.kt#9igjgp");
            JobListingScreenKt$JobItem$3$1$1$1 jobListingScreenKt$JobItem$3$1$1$1RememberedValue = composer.rememberedValue();
            if (jobListingScreenKt$JobItem$3$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                jobListingScreenKt$JobItem$3$1$1$1RememberedValue = JobListingScreenKt$JobItem$3$1$1$1.INSTANCE;
                composer.updateRememberedValue(jobListingScreenKt$JobItem$3$1$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ImageKt.Image(painterPainterResource, (String) null, constraintLayoutScope2.constrainAs(companion, constrainedLayoutReferenceComponent1, (Function1) jobListingScreenKt$JobItem$3$1$1$1RememberedValue), (Alignment) null, (ContentScale) null, 0.0f, colorFilterM6855tintxETnrds$default, composer, Painter.$stable | 48, 56);
            ItemThumbnail itemThumbnailJobItem$lambda$2 = JobListingScreenKt.JobItem$lambda$2(this.$thumbnail$delegate$inlined);
            Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(40));
            ComposerKt.sourceInformationMarkerStart(composer, 400498141, "CC(remember):JobListingScreen.kt#9igjgp");
            boolean zChanged = composer.changed(constrainedLayoutReferenceComponent1);
            JobListingScreenKt$JobItem$3$1$2$1 jobListingScreenKt$JobItem$3$1$2$1RememberedValue = composer.rememberedValue();
            if (zChanged || jobListingScreenKt$JobItem$3$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                jobListingScreenKt$JobItem$3$1$2$1RememberedValue = new JobListingScreenKt$JobItem$3$1$2$1(constrainedLayoutReferenceComponent1);
                composer.updateRememberedValue(jobListingScreenKt$JobItem$3$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxItemThumbnailKt.m11589BoxItemThumbnailTN_CM5M(itemThumbnailJobItem$lambda$2, constraintLayoutScope2.constrainAs(modifierM1266size3ABfNKs, constrainedLayoutReferenceComponent2, (Function1) jobListingScreenKt$JobItem$3$1$2$1RememberedValue), 0.0f, null, null, composer, ItemThumbnail.$stable, 28);
            String title = JobListingScreenKt.JobItem$lambda$1(this.$jobState$delegate$inlined).getTitle();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 400510021, "CC(remember):JobListingScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(constrainedLayoutReferenceComponent2) | composer.changed(constrainedLayoutReferenceComponent5);
            JobListingScreenKt$JobItem$3$1$3$1 jobListingScreenKt$JobItem$3$1$3$1RememberedValue = composer.rememberedValue();
            if (zChanged2 || jobListingScreenKt$JobItem$3$1$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                jobListingScreenKt$JobItem$3$1$3$1RememberedValue = new JobListingScreenKt$JobItem$3$1$3$1(constrainedLayoutReferenceComponent2, constrainedLayoutReferenceComponent5);
                composer.updateRememberedValue(jobListingScreenKt$JobItem$3$1$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            TextKt.m4494TextNvy7gAk(title, constraintLayoutScope2.constrainAs(companion2, constrainedLayoutReferenceComponent3, (Function1) jobListingScreenKt$JobItem$3$1$3$1RememberedValue), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer, 0, 24960, 110584);
            Composer composer2 = composer;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 400528041, "CC(remember):JobListingScreen.kt#9igjgp");
            boolean zChanged3 = composer2.changed(constrainedLayoutReferenceComponent3) | composer2.changed(constrainedLayoutReferenceComponent5);
            JobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1 jobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1RememberedValue = composer2.rememberedValue();
            if (zChanged3 || jobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                jobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1RememberedValue = new JobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1(constrainedLayoutReferenceComponent3, constrainedLayoutReferenceComponent5);
                composer2.updateRememberedValue(jobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierConstrainAs = constraintLayoutScope2.constrainAs(companion3, constrainedLayoutReferenceComponent4, (Function1) jobListingScreenKt$JobItem$3$1$jobDescriptionModifier$1$1RememberedValue);
            String errorText = JobListingScreenKt.JobItem$lambda$3(this.$progressState$delegate$inlined).getErrorText();
            if (errorText == null || errorText.length() == 0) {
                String description = JobListingScreenKt.JobItem$lambda$1(this.$jobState$delegate$inlined).getDescription();
                if (description == null || description.length() == 0) {
                    constrainedLayoutReference = constrainedLayoutReferenceComponent5;
                    constraintLayoutScope = constraintLayoutScope2;
                    composer2.startReplaceGroup(-480787969);
                } else {
                    composer2.startReplaceGroup(-468028524);
                    ComposerKt.sourceInformation(composer2, "320@12857L683");
                    ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierConstrainAs);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, 1068833180, "C324@13080L6,321@12918L207,333@13477L6,327@13147L375:JobListingScreen.kt#6w6mzd");
                    IconKt.m3576Iconww6aTOc(FolderOpenKt.getFolderOpen(Icons.Outlined.INSTANCE), (String) null, (Modifier) null, BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), composer, 48, 4);
                    String description2 = JobListingScreenKt.JobItem$lambda$1(this.$jobState$delegate$inlined).getDescription();
                    Intrinsics.checkNotNull(description2);
                    constraintLayoutScope = constraintLayoutScope2;
                    constrainedLayoutReference = constrainedLayoutReferenceComponent5;
                    TextKt.m4494TextNvy7gAk(description2, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(4), 0.0f, 0.0f, 0.0f, 14, null), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal14(), composer, 48, 24960, 110584);
                    composer2 = composer;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                }
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-468187709);
                ComposerKt.sourceInformation(composer2, "318@12716L60");
                String errorText2 = JobListingScreenKt.JobItem$lambda$3(this.$progressState$delegate$inlined).getErrorText();
                Intrinsics.checkNotNull(errorText2);
                JobListingScreenKt.ErrorText(modifierConstrainAs, errorText2, composer2, 0);
                composer2.endReplaceGroup();
                constrainedLayoutReference = constrainedLayoutReferenceComponent5;
                constraintLayoutScope = constraintLayoutScope2;
            }
            Modifier.Companion companion4 = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, 400569804, "CC(remember):JobListingScreen.kt#9igjgp");
            JobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1 jobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1RememberedValue = composer2.rememberedValue();
            if (jobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                jobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1RememberedValue = JobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1.INSTANCE;
                composer2.updateRememberedValue(jobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            Modifier modifierConstrainAs2 = constraintLayoutScope.constrainAs(companion4, constrainedLayoutReference, (Function1) jobListingScreenKt$JobItem$3$1$secondaryActionModifier$1$1RememberedValue);
            if (this.$isActionMode$inlined) {
                composer2.startReplaceGroup(-467022729);
                ComposerKt.sourceInformation(composer2, "345@13871L136");
                BoxCheckBoxKt.BoxCheckbox(modifierConstrainAs2, JobListingScreenKt.JobItem$lambda$1(this.$jobState$delegate$inlined).isSelected(), null, false, composer2, 0, 12);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(-466862397);
                ComposerKt.sourceInformation(composer2, "353@14195L53,350@14045L284");
                JobStatusUIState jobStatusUIStateJobItem$lambda$3 = JobListingScreenKt.JobItem$lambda$3(this.$progressState$delegate$inlined);
                ComposerKt.sourceInformationMarkerStart(composer2, 400587032, "CC(remember):JobListingScreen.kt#9igjgp");
                boolean zChanged4 = composer2.changed(this.$store$inlined);
                JobListingScreenKt$JobItem$3$1$5$1 jobListingScreenKt$JobItem$3$1$5$1RememberedValue = composer2.rememberedValue();
                if (zChanged4 || jobListingScreenKt$JobItem$3$1$5$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    jobListingScreenKt$JobItem$3$1$5$1RememberedValue = new JobListingScreenKt$JobItem$3$1$5$1(this.$store$inlined);
                    composer2.updateRememberedValue(jobListingScreenKt$JobItem$3$1$5$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                JobStatusIndicatorKt.JobStatusIndicator(jobStatusUIStateJobItem$lambda$3, modifierConstrainAs2, (Function0) jobListingScreenKt$JobItem$3$1$5$1RememberedValue, this.$isRedesignedVersion$inlined, composer2, 0, 0);
                composer2.endReplaceGroup();
            }
            composer2.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composer2, -1730039667, "CC(remember):ConstraintLayout.kt#9igjgp");
            boolean zChangedInstance = composer2.changedInstance(this.$scope) | composer2.changedInstance(this.$channel);
            final ConstraintLayoutScope constraintLayoutScope3 = this.$scope;
            final MutableState mutableState = this.$start;
            final MutableState mutableState2 = this.$end;
            final Channel channel = this.$channel;
            Object objRememberedValue = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.box.android.jobsui.JobListingScreenKt$JobItem$lambda$9$$inlined$ConstraintLayout$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        RawConstraintSet rawConstraintSet = new RawConstraintSet(constraintLayoutScope3.getContainerObject().mo10168clone());
                        if (mutableState.getValue() == null || mutableState2.getValue() == null) {
                            mutableState.setValue(rawConstraintSet);
                            mutableState2.setValue(mutableState.getValue());
                        } else {
                            channel.mo11206trySendJP2dKIU(rawConstraintSet);
                        }
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.SideEffect((Function0) objRememberedValue, composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
                return;
            }
            return;
        }
        composer.skipToGroupEnd();
    }
}
