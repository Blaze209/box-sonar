package com.box.android.boxai.ui;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.boxai.R;
import com.box.android.boxai.qa.BoxAiQaReducer;
import com.box.android.domain.models.item.FileModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiWelcomeMessage.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001aM\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\n\u001ab\u0010\u0000\u001a\u00020\u00012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013¨\u0006\u0015"}, d2 = {"BoxAiWelcomeMessage", "", "state", "Lcom/box/android/boxai/qa/BoxAiQaReducer$State;", "onFileCountClicked", "Lkotlin/Function0;", "submitSuggestedQuestion", "Lkotlin/Function1;", "", "submitPromptLibraryPrompt", "(Lcom/box/android/boxai/qa/BoxAiQaReducer$State;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "suggestedQuestions", "", "fileIndicatorContent", "Landroidx/compose/runtime/Composable;", "showPromptLibraryButton", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "BoxAiWelcomeMessageSingleFilePreview", "(Landroidx/compose/runtime/Composer;I)V", "BoxAiWelcomeMessageMultipleFilesPreview", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiWelcomeMessageKt {

    /* JADX INFO: compiled from: BoxAiWelcomeMessage.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BoxAiQaReducer.SuggestedQuestionSet.values().length];
            try {
                iArr[BoxAiQaReducer.SuggestedQuestionSet.DOCUMENT_QUESTIONS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BoxAiQaReducer.SuggestedQuestionSet.IMAGE_QUESTIONS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BoxAiQaReducer.SuggestedQuestionSet.MULTIDOC_QUESTIONS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiWelcomeMessage$lambda$2(BoxAiQaReducer.State state, Function0 function0, Function1 function1, Function1 function2, int i, int i2, Composer composer, int i3) {
        BoxAiWelcomeMessage(state, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiWelcomeMessage$lambda$5(List list, Function1 function1, Function2 function2, boolean z, Function1 function3, int i, int i2, Composer composer, int i3) {
        BoxAiWelcomeMessage(list, function1, function2, z, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiWelcomeMessageMultipleFilesPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiWelcomeMessageMultipleFilesPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiWelcomeMessageSingleFilePreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiWelcomeMessageSingleFilePreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiWelcomeMessage$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0076  */
    /* JADX WARN: Code duplicated, block: B:38:0x0078  */
    /* JADX WARN: Code duplicated, block: B:41:0x0081 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0083  */
    /* JADX WARN: Code duplicated, block: B:44:0x0097  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x00c2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:57:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:60:0x0143  */
    /* JADX WARN: Code duplicated, block: B:61:0x0147  */
    /* JADX WARN: Code duplicated, block: B:64:0x0151  */
    /* JADX WARN: Code duplicated, block: B:66:? A[RETURN, SYNTHETIC] */
    public static final void BoxAiWelcomeMessage(final BoxAiQaReducer.State state, final Function0<Unit> onFileCountClicked, final Function1<? super String, Unit> submitSuggestedQuestion, Function1<? super String, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Function1<? super String, Unit> function2;
        boolean z;
        final Function1<? super String, Unit> function3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i4;
        String[] strArrStringArrayResource;
        Object objRememberedValue;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onFileCountClicked, "onFileCountClicked");
        Intrinsics.checkNotNullParameter(submitSuggestedQuestion, "submitSuggestedQuestion");
        Composer composerStartRestartGroup = composer.startRestartGroup(-93888869);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiWelcomeMessage)N(state,onFileCountClicked,submitSuggestedQuestion,submitPromptLibraryPrompt)34@1453L2,45@2047L789,42@1887L1083:BoxAiWelcomeMessage.kt#bwxcym");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onFileCountClicked) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(submitSuggestedQuestion) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                function2 = function1;
                i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -32883779, "CC(remember):BoxAiWelcomeMessage.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$0$0((String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function2 = (Function1) objRememberedValue;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-93888869, i3, -1, "com.box.android.boxai.ui.BoxAiWelcomeMessage (BoxAiWelcomeMessage.kt:35)");
                }
                i4 = WhenMappings.$EnumSwitchMapping$0[state.getSuggestedQuestionSet().ordinal()];
                if (i4 != 1) {
                    composerStartRestartGroup.startReplaceGroup(-32879781);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "37@1576L64");
                    strArrStringArrayResource = StringResources_androidKt.stringArrayResource(R.array.box_ai_suggested_questions_document, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else if (i4 != 2) {
                    composerStartRestartGroup.startReplaceGroup(-32876168);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "38@1689L61");
                    strArrStringArrayResource = StringResources_androidKt.stringArrayResource(R.array.box_ai_suggested_questions_image, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (i4 == 3) {
                        composerStartRestartGroup.startReplaceGroup(-32882246);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(-32872549);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "39@1802L64");
                    strArrStringArrayResource = StringResources_androidKt.stringArrayResource(R.array.box_ai_suggested_questions_multidoc, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                BoxAiWelcomeMessage(ArraysKt.toList(strArrStringArrayResource), submitSuggestedQuestion, ComposableLambdaKt.rememberComposableLambda(-1592113050, true, new Function2() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$1(state, onFileCountClicked, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), state.getShowPromptLibraryButton(), function2, composerStartRestartGroup, ((i3 >> 3) & 112) | 384 | ((i3 << 3) & 57344), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            function3 = function2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$2(state, onFileCountClicked, submitSuggestedQuestion, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function2 = function1;
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -32883779, "CC(remember):BoxAiWelcomeMessage.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$0$0((String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function2 = (Function1) objRememberedValue;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-93888869, i3, -1, "com.box.android.boxai.ui.BoxAiWelcomeMessage (BoxAiWelcomeMessage.kt:35)");
            }
            i4 = WhenMappings.$EnumSwitchMapping$0[state.getSuggestedQuestionSet().ordinal()];
            if (i4 != 1) {
                composerStartRestartGroup.startReplaceGroup(-32879781);
                ComposerKt.sourceInformation(composerStartRestartGroup, "37@1576L64");
                strArrStringArrayResource = StringResources_androidKt.stringArrayResource(R.array.box_ai_suggested_questions_document, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i4 != 2) {
                composerStartRestartGroup.startReplaceGroup(-32876168);
                ComposerKt.sourceInformation(composerStartRestartGroup, "38@1689L61");
                strArrStringArrayResource = StringResources_androidKt.stringArrayResource(R.array.box_ai_suggested_questions_image, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (i4 == 3) {
                    composerStartRestartGroup.startReplaceGroup(-32882246);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(-32872549);
                ComposerKt.sourceInformation(composerStartRestartGroup, "39@1802L64");
                strArrStringArrayResource = StringResources_androidKt.stringArrayResource(R.array.box_ai_suggested_questions_multidoc, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            BoxAiWelcomeMessage(ArraysKt.toList(strArrStringArrayResource), submitSuggestedQuestion, ComposableLambdaKt.rememberComposableLambda(-1592113050, true, new Function2() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$1(state, onFileCountClicked, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), state.getShowPromptLibraryButton(), function2, composerStartRestartGroup, ((i3 >> 3) & 112) | 384 | ((i3 << 3) & 57344), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        function3 = function2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$2(state, onFileCountClicked, submitSuggestedQuestion, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiWelcomeMessage$lambda$1(BoxAiQaReducer.State state, Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:BoxAiWelcomeMessage.kt#bwxcym");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1592113050, i, -1, "com.box.android.boxai.ui.BoxAiWelcomeMessage.<anonymous> (BoxAiWelcomeMessage.kt:46)");
            }
            if (state.getTotalFileCount() == 1 && !state.getHasUnsupportedFiles()) {
                composer.startReplaceGroup(-1315917265);
                ComposerKt.sourceInformation(composer, "53@2447L6,47@2140L429");
                TextKt.m4494TextNvy7gAk(((FileModel) CollectionsKt.single((List) state.getFileModels())).getName(), PaddingKt.m1220paddingVpY3zN4$default(TestTagKt.testTag(Modifier.INSTANCE, "BoxAi:FileName"), 0.0f, Dp.m9687constructorimpl(4), 1, null), BoxAITheme.INSTANCE.getColors(composer, 6).m12060getTextSecondary0d7_KjU(), null, 0L, null, null, null, TextUnitKt.getSp(0.1d), null, null, TextUnitKt.getSp(20), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxMedium14(), composer, 100663344, 48, 128760);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1315477809);
                ComposerKt.sourceInformation(composer, "58@2607L205");
                BoxAiFileCountKt.BoxAiFileCount(state.getTotalFileCount(), state.getHasUnsupportedFiles(), function0, null, composer, 0, 8);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiWelcomeMessage$lambda$3$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x0066  */
    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:40:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:52:0x0091 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x009c  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:67:0x0137  */
    /* JADX WARN: Code duplicated, block: B:70:0x0143  */
    /* JADX WARN: Code duplicated, block: B:71:0x0147  */
    /* JADX WARN: Code duplicated, block: B:74:0x0234  */
    /* JADX WARN: Code duplicated, block: B:75:0x0257  */
    /* JADX WARN: Code duplicated, block: B:79:0x027a  */
    /* JADX WARN: Code duplicated, block: B:81:0x028a  */
    /* JADX WARN: Code duplicated, block: B:82:0x028d  */
    /* JADX WARN: Code duplicated, block: B:85:0x0299  */
    /* JADX WARN: Code duplicated, block: B:87:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:91:0x031a  */
    /* JADX WARN: Code duplicated, block: B:93:0x0320  */
    /* JADX WARN: Code duplicated, block: B:96:0x032b  */
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
    private static final void BoxAiWelcomeMessage(final List<String> list, final Function1<? super String, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function2, boolean z, Function1<? super String, Unit> function3, Composer composer, final int i, final int i2) {
        boolean z2;
        int i3;
        Function1<? super String, Unit> function4;
        int i4;
        boolean z3;
        final boolean z4;
        final Function1<? super String, Unit> function5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        Function1<? super String, Unit> function6;
        float f;
        Function0<ComposeUiNode> constructor;
        int i5;
        int i6;
        boolean z6;
        boolean z7;
        boolean zChanged;
        Object objRememberedValue;
        Object objRememberedValue2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-872125005);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiWelcomeMessage)N(suggestedQuestions,submitSuggestedQuestion,fileIndicatorContent,showPromptLibraryButton,submitPromptLibraryPrompt)76@3250L2,78@3261L1143:BoxAiWelcomeMessage.kt#bwxcym");
        int i7 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i7 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        int i8 = i2 & 8;
        if (i8 == 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                i7 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
            }
            i3 = i2 & 16;
            if (i3 != 0) {
                if ((i & 24576) == 0) {
                    function4 = function3;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i4 = 16384;
                    } else {
                        i4 = 8192;
                    }
                    i7 |= i4;
                }
                if ((i7 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i7 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z2;
                    function5 = function4;
                } else {
                    if (i8 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i3 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -593498891, "CC(remember):BoxAiWelcomeMessage.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$3$0((String) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        function6 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function6 = function4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-872125005, i7, -1, "com.box.android.boxai.ui.BoxAiWelcomeMessage (BoxAiWelcomeMessage.kt:77)");
                    }
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    float f2 = 24;
                    float fM9687constructorimpl = Dp.m9687constructorimpl(f2);
                    float fM9687constructorimpl2 = Dp.m9687constructorimpl(f2);
                    f = 8;
                    Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(modifierFillMaxWidth$default, fM9687constructorimpl, 0.0f, fM9687constructorimpl2, Dp.m9687constructorimpl(f), 2, null);
                    Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composerStartRestartGroup.startReusableNode();
                    if (composerStartRestartGroup.getInserting()) {
                        composerStartRestartGroup.createNode(constructor);
                    } else {
                        composerStartRestartGroup.useNode();
                    }
                    Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -741129311, "C85@3490L49,87@3623L6,84@3465L217,90@3691L40,91@3740L22,92@3771L41:BoxAiWelcomeMessage.kt#bwxcym");
                    i5 = 32;
                    function5 = function6;
                    TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai_welcome_to_box_ai, composerStartRestartGroup, 0), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, TextUnitKt.getSp(28), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal22(), composerStartRestartGroup, 0, 48, 129018);
                    composerStartRestartGroup = composerStartRestartGroup;
                    i6 = 6;
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composerStartRestartGroup, 6);
                    function2.invoke(composerStartRestartGroup, Integer.valueOf((i7 >> 6) & 14));
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(20)), composerStartRestartGroup, 6);
                    if (z5) {
                        composerStartRestartGroup.startReplaceGroup(-740770921);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "95@3865L65,96@3943L40");
                        z6 = false;
                        BoxAIPromptLibraryButtonKt.PromptLibraryButton(function5, composerStartRestartGroup, (i7 >> 12) & 14, 0);
                        SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                    } else {
                        z6 = false;
                        composerStartRestartGroup.startReplaceGroup(-744596507);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    composerStartRestartGroup.startReplaceGroup(-855174123);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*102@4114L67,106@4285L6,105@4223L109,100@4044L302,109@4359L29");
                    for (final String str : list) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 74292272, "CC(remember):BoxAiWelcomeMessage.kt#9igjgp");
                        if ((i7 & 112) == i5) {
                            z7 = true;
                        } else {
                            z7 = z6;
                        }
                        zChanged = composerStartRestartGroup.changed(str) | z7;
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$4$0$0$0(function1, str);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        Composer composer2 = composerStartRestartGroup;
                        int i9 = i6;
                        boolean z8 = z6;
                        ButtonColors buttonColorsM2850buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, i6).m12047getAccentButtonBackground0d7_KjU(), 0L, 0L, 0L, composer2, ButtonDefaults.$stable << 12, 14);
                        composerStartRestartGroup = composer2;
                        BoxAiTextButtonKt.BoxAiTextButton(str, (Function0) objRememberedValue, buttonColorsM2850buttonColorsro_MJ88, composerStartRestartGroup, 0, 0);
                        SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i9);
                        i6 = i9;
                        z6 = z8;
                        i5 = 32;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$5(list, function1, function2, z4, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i7 |= 24576;
            function4 = function3;
            if ((i7 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i7 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
                function5 = function4;
            } else {
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i3 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -593498891, "CC(remember):BoxAiWelcomeMessage.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$3$0((String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function6 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function6 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-872125005, i7, -1, "com.box.android.boxai.ui.BoxAiWelcomeMessage (BoxAiWelcomeMessage.kt:77)");
                }
                Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                float f3 = 24;
                float fM9687constructorimpl3 = Dp.m9687constructorimpl(f3);
                float fM9687constructorimpl4 = Dp.m9687constructorimpl(f3);
                f = 8;
                Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(modifierFillMaxWidth$default2, fM9687constructorimpl3, 0.0f, fM9687constructorimpl4, Dp.m9687constructorimpl(f), 2, null);
                Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally2, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -741129311, "C85@3490L49,87@3623L6,84@3465L217,90@3691L40,91@3740L22,92@3771L41:BoxAiWelcomeMessage.kt#bwxcym");
                i5 = 32;
                function5 = function6;
                TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai_welcome_to_box_ai, composerStartRestartGroup, 0), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, TextUnitKt.getSp(28), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal22(), composerStartRestartGroup, 0, 48, 129018);
                composerStartRestartGroup = composerStartRestartGroup;
                i6 = 6;
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composerStartRestartGroup, 6);
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i7 >> 6) & 14));
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(20)), composerStartRestartGroup, 6);
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(-740770921);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@3865L65,96@3943L40");
                    z6 = false;
                    BoxAIPromptLibraryButtonKt.PromptLibraryButton(function5, composerStartRestartGroup, (i7 >> 12) & 14, 0);
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                } else {
                    z6 = false;
                    composerStartRestartGroup.startReplaceGroup(-744596507);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-855174123);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*102@4114L67,106@4285L6,105@4223L109,100@4044L302,109@4359L29");
                while (r19.hasNext()) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 74292272, "CC(remember):BoxAiWelcomeMessage.kt#9igjgp");
                    if ((i7 & 112) == i5) {
                        z7 = true;
                    } else {
                        z7 = z6;
                    }
                    zChanged = composerStartRestartGroup.changed(str) | z7;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$4$0$0$0(function1, str);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$4$0$0$0(function1, str);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Composer composer3 = composerStartRestartGroup;
                    int i10 = i6;
                    boolean z9 = z6;
                    ButtonColors buttonColorsM2850buttonColorsro_MJ89 = ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, i6).m12047getAccentButtonBackground0d7_KjU(), 0L, 0L, 0L, composer3, ButtonDefaults.$stable << 12, 14);
                    composerStartRestartGroup = composer3;
                    BoxAiTextButtonKt.BoxAiTextButton(str, (Function0) objRememberedValue, buttonColorsM2850buttonColorsro_MJ89, composerStartRestartGroup, 0, 0);
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i10);
                    i6 = i10;
                    z6 = z9;
                    i5 = 32;
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$5(list, function1, function2, z4, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i7 |= 3072;
        z2 = z;
        i3 = i2 & 16;
        if (i3 != 0) {
            if ((i & 24576) == 0) {
                function4 = function3;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i4 = 16384;
                } else {
                    i4 = 8192;
                }
                i7 |= i4;
            }
            if ((i7 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i7 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
                function5 = function4;
            } else {
                if (i8 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i3 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -593498891, "CC(remember):BoxAiWelcomeMessage.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$3$0((String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    function6 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function6 = function4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-872125005, i7, -1, "com.box.android.boxai.ui.BoxAiWelcomeMessage (BoxAiWelcomeMessage.kt:77)");
                }
                Modifier modifierFillMaxWidth$default3 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                float f4 = 24;
                float fM9687constructorimpl5 = Dp.m9687constructorimpl(f4);
                float fM9687constructorimpl6 = Dp.m9687constructorimpl(f4);
                f = 8;
                Modifier modifierM1222paddingqDBjuR0$default3 = PaddingKt.m1222paddingqDBjuR0$default(modifierFillMaxWidth$default3, fM9687constructorimpl5, 0.0f, fM9687constructorimpl6, Dp.m9687constructorimpl(f), 2, null);
                Alignment.Horizontal centerHorizontally3 = Alignment.INSTANCE.getCenterHorizontally();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally3, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default3);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -741129311, "C85@3490L49,87@3623L6,84@3465L217,90@3691L40,91@3740L22,92@3771L41:BoxAiWelcomeMessage.kt#bwxcym");
                i5 = 32;
                function5 = function6;
                TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai_welcome_to_box_ai, composerStartRestartGroup, 0), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, TextUnitKt.getSp(28), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal22(), composerStartRestartGroup, 0, 48, 129018);
                composerStartRestartGroup = composerStartRestartGroup;
                i6 = 6;
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composerStartRestartGroup, 6);
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i7 >> 6) & 14));
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(20)), composerStartRestartGroup, 6);
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(-740770921);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "95@3865L65,96@3943L40");
                    z6 = false;
                    BoxAIPromptLibraryButtonKt.PromptLibraryButton(function5, composerStartRestartGroup, (i7 >> 12) & 14, 0);
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                } else {
                    z6 = false;
                    composerStartRestartGroup.startReplaceGroup(-744596507);
                }
                composerStartRestartGroup.endReplaceGroup();
                composerStartRestartGroup.startReplaceGroup(-855174123);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*102@4114L67,106@4285L6,105@4223L109,100@4044L302,109@4359L29");
                while (r19.hasNext()) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 74292272, "CC(remember):BoxAiWelcomeMessage.kt#9igjgp");
                    if ((i7 & 112) == i5) {
                        z7 = true;
                    } else {
                        z7 = z6;
                    }
                    zChanged = composerStartRestartGroup.changed(str) | z7;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChanged) {
                        objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$4$0$0$0(function1, str);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$4$0$0$0(function1, str);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Composer composer4 = composerStartRestartGroup;
                    int i11 = i6;
                    boolean z10 = z6;
                    ButtonColors buttonColorsM2850buttonColorsro_MJ810 = ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, i6).m12047getAccentButtonBackground0d7_KjU(), 0L, 0L, 0L, composer4, ButtonDefaults.$stable << 12, 14);
                    composerStartRestartGroup = composer4;
                    BoxAiTextButtonKt.BoxAiTextButton(str, (Function0) objRememberedValue, buttonColorsM2850buttonColorsro_MJ810, composerStartRestartGroup, 0, 0);
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i11);
                    i6 = i11;
                    z6 = z10;
                    i5 = 32;
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$5(list, function1, function2, z4, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i7 |= 24576;
        function4 = function3;
        if ((i7 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i7 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z4 = z2;
            function5 = function4;
        } else {
            if (i8 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -593498891, "CC(remember):BoxAiWelcomeMessage.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$3$0((String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                function6 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function6 = function4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-872125005, i7, -1, "com.box.android.boxai.ui.BoxAiWelcomeMessage (BoxAiWelcomeMessage.kt:77)");
            }
            Modifier modifierFillMaxWidth$default4 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            float f5 = 24;
            float fM9687constructorimpl7 = Dp.m9687constructorimpl(f5);
            float fM9687constructorimpl8 = Dp.m9687constructorimpl(f5);
            f = 8;
            Modifier modifierM1222paddingqDBjuR0$default4 = PaddingKt.m1222paddingqDBjuR0$default(modifierFillMaxWidth$default4, fM9687constructorimpl7, 0.0f, fM9687constructorimpl8, Dp.m9687constructorimpl(f), 2, null);
            Alignment.Horizontal centerHorizontally4 = Alignment.INSTANCE.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally4, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default4);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -741129311, "C85@3490L49,87@3623L6,84@3465L217,90@3691L40,91@3740L22,92@3771L41:BoxAiWelcomeMessage.kt#bwxcym");
            i5 = 32;
            function5 = function6;
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.box_ai_welcome_to_box_ai, composerStartRestartGroup, 0), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, TextUnitKt.getSp(28), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal22(), composerStartRestartGroup, 0, 48, 129018);
            composerStartRestartGroup = composerStartRestartGroup;
            i6 = 6;
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composerStartRestartGroup, 6);
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i7 >> 6) & 14));
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(20)), composerStartRestartGroup, 6);
            if (z5) {
                composerStartRestartGroup.startReplaceGroup(-740770921);
                ComposerKt.sourceInformation(composerStartRestartGroup, "95@3865L65,96@3943L40");
                z6 = false;
                BoxAIPromptLibraryButtonKt.PromptLibraryButton(function5, composerStartRestartGroup, (i7 >> 12) & 14, 0);
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
            } else {
                z6 = false;
                composerStartRestartGroup.startReplaceGroup(-744596507);
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-855174123);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*102@4114L67,106@4285L6,105@4223L109,100@4044L302,109@4359L29");
            while (r19.hasNext()) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 74292272, "CC(remember):BoxAiWelcomeMessage.kt#9igjgp");
                if ((i7 & 112) == i5) {
                    z7 = true;
                } else {
                    z7 = z6;
                }
                zChanged = composerStartRestartGroup.changed(str) | z7;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$4$0$0$0(function1, str);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$4$0$0$0(function1, str);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Composer composer5 = composerStartRestartGroup;
                int i12 = i6;
                boolean z11 = z6;
                ButtonColors buttonColorsM2850buttonColorsro_MJ811 = ButtonDefaults.INSTANCE.m2850buttonColorsro_MJ88(BoxAITheme.INSTANCE.getColors(composerStartRestartGroup, i6).m12047getAccentButtonBackground0d7_KjU(), 0L, 0L, 0L, composer5, ButtonDefaults.$stable << 12, 14);
                composerStartRestartGroup = composer5;
                BoxAiTextButtonKt.BoxAiTextButton(str, (Function0) objRememberedValue, buttonColorsM2850buttonColorsro_MJ811, composerStartRestartGroup, 0, 0);
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, i12);
                i6 = i12;
                z6 = z11;
                i5 = 32;
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiWelcomeMessageKt.BoxAiWelcomeMessage$lambda$5(list, function1, function2, z4, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiWelcomeMessage$lambda$4$0$0$0(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    private static final void BoxAiWelcomeMessageSingleFilePreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-636822800);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiWelcomeMessageSingleFilePreview)120@4575L466:BoxAiWelcomeMessage.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-636822800, i, -1, "com.box.android.boxai.ui.BoxAiWelcomeMessageSingleFilePreview (BoxAiWelcomeMessage.kt:119)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiWelcomeMessageKt.INSTANCE.m12122getLambda$1683716549$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiWelcomeMessageKt.BoxAiWelcomeMessageSingleFilePreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiWelcomeMessageMultipleFilesPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1301011071);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiWelcomeMessageMultipleFilesPreview)139@5162L639:BoxAiWelcomeMessage.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1301011071, i, -1, "com.box.android.boxai.ui.BoxAiWelcomeMessageMultipleFilesPreview (BoxAiWelcomeMessage.kt:138)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiWelcomeMessageKt.INSTANCE.m12123getLambda$953129132$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiWelcomeMessageKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiWelcomeMessageKt.BoxAiWelcomeMessageMultipleFilesPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
