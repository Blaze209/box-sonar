package expo.modules.ui;

import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.material3.SearchBarDefaults;
import androidx.compose.material3.SearchBarState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import expo.modules.kotlin.views.FunctionalComposableScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBarView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final class SearchBarViewKt$SearchBarContent$inputField$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ Function1<GenericEventPayload1<String>, Unit> $onSearch;
    final /* synthetic */ SearchBarState $searchBarState;
    final /* synthetic */ TextFieldState $textFieldState;
    final /* synthetic */ FunctionalComposableScope $this_SearchBarContent;

    /* JADX WARN: Multi-variable type inference failed */
    SearchBarViewKt$SearchBarContent$inputField$1(TextFieldState textFieldState, SearchBarState searchBarState, Function1<? super GenericEventPayload1<String>, Unit> function1, FunctionalComposableScope functionalComposableScope) {
        this.$textFieldState = textFieldState;
        this.$searchBarState = searchBarState;
        this.$onSearch = function1;
        this.$this_SearchBarContent = functionalComposableScope;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C29@1106L57,30@1187L97,26@993L299:SearchBarView.kt#v15e7d");
        if ((i & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-316915073, i, -1, "expo.modules.ui.SearchBarContent.<anonymous> (SearchBarView.kt:26)");
        }
        SearchBarDefaults searchBarDefaults = SearchBarDefaults.INSTANCE;
        TextFieldState textFieldState = this.$textFieldState;
        SearchBarState searchBarState = this.$searchBarState;
        composer.startReplaceGroup(5004770);
        ComposerKt.sourceInformation(composer, "CC(remember):SearchBarView.kt#9igjgp");
        boolean zChanged = composer.changed(this.$onSearch);
        final Function1<GenericEventPayload1<String>, Unit> function1 = this.$onSearch;
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: expo.modules.ui.SearchBarViewKt$SearchBarContent$inputField$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SearchBarViewKt$SearchBarContent$inputField$1.invoke$lambda$1$lambda$0(function1, (String) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceGroup();
        searchBarDefaults.InputField(textFieldState, searchBarState, (Function1) objRememberedValue, null, false, false, null, ComposableLambdaKt.rememberComposableLambda(-853294493, true, new AnonymousClass2(this.$this_SearchBarContent), composer, 54), null, null, null, null, null, null, null, null, null, null, null, null, composer, 12582912, 0, SearchBarDefaults.$stable, 1048440);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }

    /* JADX INFO: renamed from: expo.modules.ui.SearchBarViewKt$SearchBarContent$inputField$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBarView.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    static final class AnonymousClass2 implements Function2<Composer, Integer, Unit> {
        final /* synthetic */ FunctionalComposableScope $this_SearchBarContent;

        AnonymousClass2(FunctionalComposableScope functionalComposableScope) {
            this.$this_SearchBarContent = functionalComposableScope;
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
            ComposerKt.sourceInformation(composer, "C31@1236L37,31@1199L75:SearchBarView.kt#v15e7d");
            if ((i & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-853294493, i, -1, "expo.modules.ui.SearchBarContent.<anonymous>.<anonymous> (SearchBarView.kt:31)");
            }
            FunctionalComposableScope functionalComposableScope = this.$this_SearchBarContent;
            ComposableScope composableScope = new ComposableScope(null, null, null, null, 15, null);
            composer.startReplaceGroup(1849434622);
            ComposerKt.sourceInformation(composer, "CC(remember):SearchBarView.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.SearchBarViewKt$SearchBarContent$inputField$1$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(SearchBarViewKt$SearchBarContent$inputField$1.AnonymousClass2.invoke$lambda$1$lambda$0((ExpoComposeView) obj));
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
    public static final Unit invoke$lambda$1$lambda$0(Function1 function1, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        function1.invoke(new GenericEventPayload1(value));
        return Unit.INSTANCE;
    }
}
