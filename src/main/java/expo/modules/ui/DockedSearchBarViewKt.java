package expo.modules.ui;

import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextFieldStateKt;
import androidx.compose.material3.SearchBarDefaults;
import androidx.compose.material3.SearchBarKt;
import androidx.compose.material3.SearchBarState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.media3.extractor.ts.PsExtractor;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DockedSearchBarView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"DockedSearchBarContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/DockedSearchBarProps;", "onQueryChange", "Lkotlin/Function1;", "Lexpo/modules/ui/GenericEventPayload1;", "", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/DockedSearchBarProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DockedSearchBarViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DockedSearchBarContent$lambda$3(FunctionalComposableScope functionalComposableScope, DockedSearchBarProps dockedSearchBarProps, Function1 function1, int i, Composer composer, int i2) {
        DockedSearchBarContent(functionalComposableScope, dockedSearchBarProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void DockedSearchBarContent(final FunctionalComposableScope functionalComposableScope, final DockedSearchBarProps props, final Function1<? super GenericEventPayload1<String>, Unit> onQueryChange, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onQueryChange, "onQueryChange");
        Composer composerStartRestartGroup = composer.startRestartGroup(726740923);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DockedSearchBarContent)P(1)26@964L24,27@1012L24,29@1061L116,29@1040L137,50@1707L83,37@1276L397,36@1243L2,34@1181L616:DockedSearchBarView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onQueryChange) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & Token.DOTQUERY) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(726740923, i3, -1, "expo.modules.ui.DockedSearchBarContent (DockedSearchBarView.kt:25)");
            }
            SearchBarState searchBarStateRememberSearchBarState = SearchBarKt.rememberSearchBarState(null, null, null, composerStartRestartGroup, 0, 7);
            TextFieldState textFieldStateM1832rememberTextFieldStateLepunE = TextFieldStateKt.m1832rememberTextFieldStateLepunE(null, 0L, composerStartRestartGroup, 0, 3);
            Unit unit = Unit.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DockedSearchBarView.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(textFieldStateM1832rememberTextFieldStateLepunE) | ((i3 & 896) == 256);
            DockedSearchBarViewKt$DockedSearchBarContent$1$1 dockedSearchBarViewKt$DockedSearchBarContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || dockedSearchBarViewKt$DockedSearchBarContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                dockedSearchBarViewKt$DockedSearchBarContent$1$1RememberedValue = new DockedSearchBarViewKt$DockedSearchBarContent$1$1(textFieldStateM1832rememberTextFieldStateLepunE, onQueryChange, null);
                composerStartRestartGroup.updateRememberedValue(dockedSearchBarViewKt$DockedSearchBarContent$1$1RememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) dockedSearchBarViewKt$DockedSearchBarContent$1$1RememberedValue, composerStartRestartGroup, 6);
            Modifier modifierApplyModifiers = ModifierRegistry.INSTANCE.applyModifiers(props.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composerStartRestartGroup, (ComposableScope.$stable << 6) | (AppContext.$stable << 3));
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-307730611, true, new AnonymousClass2(textFieldStateM1832rememberTextFieldStateLepunE, searchBarStateRememberSearchBarState, functionalComposableScope), composerStartRestartGroup, 54);
            composerStartRestartGroup.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):DockedSearchBarView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.DockedSearchBarViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DockedSearchBarViewKt.DockedSearchBarContent$lambda$2$lambda$1(((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            SearchBarKt.m4092DockedSearchBarEQC0FA8(composableLambdaRememberComposableLambda, false, (Function1) objRememberedValue, modifierApplyModifiers, null, null, 0.0f, 0.0f, ComposableSingletons$DockedSearchBarViewKt.INSTANCE.getLambda$304213221$expo_ui_release(), composerStartRestartGroup, 100663734, PsExtractor.VIDEO_STREAM_MASK);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.DockedSearchBarViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DockedSearchBarViewKt.DockedSearchBarContent$lambda$3(functionalComposableScope, props, onQueryChange, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: renamed from: expo.modules.ui.DockedSearchBarViewKt$DockedSearchBarContent$2, reason: invalid class name */
    /* JADX INFO: compiled from: DockedSearchBarView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ SearchBarState $searchBarState;
        final /* synthetic */ TextFieldState $textFieldState;
        final /* synthetic */ FunctionalComposableScope $this_DockedSearchBarContent;

        AnonymousClass2(TextFieldState textFieldState, SearchBarState searchBarState, FunctionalComposableScope functionalComposableScope) {
            this.$textFieldState = textFieldState;
            this.$searchBarState = searchBarState;
            this.$this_DockedSearchBarContent = functionalComposableScope;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            ComposerKt.sourceInformation(composer, "C41@1415L2,42@1441L97,45@1562L97,38@1302L365:DockedSearchBarView.kt#v15e7d");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-307730611, i, -1, "expo.modules.ui.DockedSearchBarContent.<anonymous> (DockedSearchBarView.kt:38)");
            }
            SearchBarDefaults searchBarDefaults = SearchBarDefaults.INSTANCE;
            TextFieldState textFieldState = this.$textFieldState;
            SearchBarState searchBarState = this.$searchBarState;
            composer.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation(composer, "CC(remember):DockedSearchBarView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.DockedSearchBarViewKt$DockedSearchBarContent$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DockedSearchBarViewKt.AnonymousClass2.invoke$lambda$1$lambda$0((String) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceGroup();
            searchBarDefaults.InputField(textFieldState, searchBarState, (Function1) objRememberedValue, null, false, false, null, ComposableLambdaKt.rememberComposableLambda(1645871153, true, new C03012(this.$this_DockedSearchBarContent), composer, 54), ComposableLambdaKt.rememberComposableLambda(-1139074318, true, new AnonymousClass3(this.$this_DockedSearchBarContent), composer, 54), null, null, null, null, null, null, null, null, null, null, null, composer, 113246592, 0, SearchBarDefaults.$stable, 1048184);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        /* JADX INFO: renamed from: expo.modules.ui.DockedSearchBarViewKt$DockedSearchBarContent$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DockedSearchBarView.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class C03012 implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ FunctionalComposableScope $this_DockedSearchBarContent;

            C03012(FunctionalComposableScope functionalComposableScope) {
                this.$this_DockedSearchBarContent = functionalComposableScope;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean invoke$lambda$1$lambda$0(ExpoComposeView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return SlotViewKt.isSlotWithName(it, ReactTextInputShadowNode.PROP_PLACEHOLDER);
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C43@1490L37,43@1453L75:DockedSearchBarView.kt#v15e7d");
                if ((i & 3) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1645871153, i, -1, "expo.modules.ui.DockedSearchBarContent.<anonymous>.<anonymous> (DockedSearchBarView.kt:43)");
                }
                FunctionalComposableScope functionalComposableScope = this.$this_DockedSearchBarContent;
                ComposableScope composableScope = new ComposableScope(null, null, null, null, 15, null);
                composer.startReplaceGroup(1849434622);
                ComposerKt.sourceInformation(composer, "CC(remember):DockedSearchBarView.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: expo.modules.ui.DockedSearchBarViewKt$DockedSearchBarContent$2$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(DockedSearchBarViewKt.AnonymousClass2.C03012.invoke$lambda$1$lambda$0((ExpoComposeView) obj));
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

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invoke$lambda$1$lambda$0(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: expo.modules.ui.DockedSearchBarViewKt$DockedSearchBarContent$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: DockedSearchBarView.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        static final class AnonymousClass3 implements Function2<Composer, Integer, Unit> {
            final /* synthetic */ FunctionalComposableScope $this_DockedSearchBarContent;

            AnonymousClass3(FunctionalComposableScope functionalComposableScope) {
                this.$this_DockedSearchBarContent = functionalComposableScope;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final boolean invoke$lambda$1$lambda$0(ExpoComposeView it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return SlotViewKt.isSlotWithName(it, "leadingIcon");
            }

            public final void invoke(Composer composer, int i) {
                ComposerKt.sourceInformation(composer, "C46@1611L37,46@1574L75:DockedSearchBarView.kt#v15e7d");
                if ((i & 3) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1139074318, i, -1, "expo.modules.ui.DockedSearchBarContent.<anonymous>.<anonymous> (DockedSearchBarView.kt:46)");
                }
                FunctionalComposableScope functionalComposableScope = this.$this_DockedSearchBarContent;
                ComposableScope composableScope = new ComposableScope(null, null, null, null, 15, null);
                composer.startReplaceGroup(1849434622);
                ComposerKt.sourceInformation(composer, "CC(remember):DockedSearchBarView.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: expo.modules.ui.DockedSearchBarViewKt$DockedSearchBarContent$2$3$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Boolean.valueOf(DockedSearchBarViewKt.AnonymousClass2.AnonymousClass3.invoke$lambda$1$lambda$0((ExpoComposeView) obj));
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DockedSearchBarContent$lambda$2$lambda$1(boolean z) {
        return Unit.INSTANCE;
    }
}
