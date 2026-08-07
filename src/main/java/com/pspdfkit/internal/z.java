package com.pspdfkit.internal;

import android.content.Context;
import android.content.Intent;
import android.graphics.RectF;
import android.net.Uri;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelKt;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.box.androidsdk.content.models.BoxMetadata;
import com.pspdfkit.compose.theme.AiAssistantColorScheme;
import com.pspdfkit.compose.theme.UiTheme;
import io.nutrient.data.models.AdditionalContext;
import io.nutrient.data.models.AiAssistantConfiguration;
import io.nutrient.data.models.AiAssistantEvents;
import io.nutrient.data.models.CompletionResponse;
import io.nutrient.data.models.Document;
import io.nutrient.data.models.DocumentLinkResponse;
import io.nutrient.data.models.Issuer;
import io.nutrient.data.models.Link;
import io.nutrient.data.models.LinkRect;
import io.nutrient.data.models.Suggestion;
import io.nutrient.domain.ai.AiAssistant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KFunction;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.json.Json;

/* JADX INFO: loaded from: classes3.dex */
public final class z {

    @DebugMetadata(c = "io.nutrient.internal.ui.ai.AiAssistantScreenKt$AiAssistantContent$1$1", f = "AiAssistantScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ f0.a a;
        public final /* synthetic */ FocusRequester b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f0.a aVar, FocusRequester focusRequester, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = aVar;
            this.b = focusRequester;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new a(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            if (this.a.a.length() > 0) {
                FocusRequester.m6474requestFocus3ESFkO8$default(this.b, 0, 1, null);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "io.nutrient.internal.ui.ai.AiAssistantScreenKt$AiAssistantScreen$1$1", f = "AiAssistantScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ CoroutineScope a;
        public final /* synthetic */ f0 b;

        @DebugMetadata(c = "io.nutrient.internal.ui.ai.AiAssistantScreenKt$AiAssistantScreen$1$1$1", f = "AiAssistantScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            public final /* synthetic */ f0 a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(f0 f0Var, Continuation<? super a> continuation) {
                super(2, continuation);
                this.a = f0Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.a, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return new a(this.a, continuation).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                ResultKt.throwOnFailure(obj);
                f0 f0Var = this.a;
                int i = f0.i;
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(f0Var), null, null, new g0(f0Var, true, null), 3, null);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(CoroutineScope coroutineScope, f0 f0Var, Continuation<? super b> continuation) {
            super(2, continuation);
            this.a = coroutineScope;
            this.b = f0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.a, this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new b(this.a, this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            BuildersKt__Builders_commonKt.launch$default(this.a, null, null, new a(this.b, null), 3, null);
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<TextFieldValue, Unit> {
        public c(f0 f0Var) {
            super(1, f0Var, f0.class, "onMessageQueryChanged", "onMessageQueryChanged(Landroidx/compose/ui/text/input/TextFieldValue;)V", 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(TextFieldValue textFieldValue) {
            TextFieldValue textFieldValue2 = textFieldValue;
            textFieldValue2.getClass();
            f0 f0Var = (f0) this.receiver;
            f0Var.getClass();
            f0Var.e.setValue(new f0.a(textFieldValue2.getText(), TextRange.m9091getStartimpl(textFieldValue2.getSelection())));
            f0Var.c.set("message_query", (f0.a) f0Var.e.getValue());
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ class d extends FunctionReferenceImpl implements Function0<Unit> {
        public d(f0 f0Var) {
            super(0, f0Var, f0.class, "onSubmitMessage", "onSubmitMessage()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            ((f0) this.receiver).a();
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ class e extends FunctionReferenceImpl implements Function0<Unit> {
        public e(f0 f0Var) {
            super(0, f0Var, f0.class, "onRetryClick", "onRetryClick()V", 0);
        }

        /* JADX WARN: Type inference failed for: r2v11, types: [T, java.util.List] */
        /* JADX WARN: Type inference failed for: r2v4, types: [T, java.util.List] */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            b0 value;
            String content;
            f0 f0Var = (f0) this.receiver;
            if (f0Var.d.isConnectionAvailable()) {
                CompletionResponse completionResponse = (CompletionResponse) CollectionsKt.lastOrNull((List) f0Var.h.getValue().e);
                if ((completionResponse != null ? completionResponse.getState() : null) instanceof AiAssistantEvents.Error) {
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    ?? mutableList = CollectionsKt.toMutableList((Collection) f0Var.h.getValue().e);
                    mutableList.remove(f0Var.h.getValue().e.size() - 1);
                    objectRef.element = mutableList;
                    CompletionResponse completionResponse2 = (CompletionResponse) CollectionsKt.lastOrNull((List) mutableList);
                    if (completionResponse2 != null && (completionResponse2.getState() instanceof AiAssistantEvents.Loading) && Intrinsics.areEqual(completionResponse2.getSender(), Issuer.INSTANCE.value(Issuer.HUMAN)) && (content = completionResponse2.getContent()) != null) {
                        f0Var.f = content;
                        ?? mutableList2 = CollectionsKt.toMutableList((Collection) objectRef.element);
                        mutableList2.remove(((List) objectRef.element).size() - 1);
                        objectRef.element = mutableList2;
                    }
                    MutableStateFlow<b0> mutableStateFlow = f0Var.g;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, b0.a(value, false, false, false, false, ExtensionsKt.toImmutableList((Iterable) objectRef.element), null, 47)));
                }
                BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(f0Var), null, null, new g0(f0Var, false, null), 3, null);
            }
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ class f extends FunctionReferenceImpl implements Function1<Suggestion, Unit> {
        public f(f0 f0Var) {
            super(1, f0Var, f0.class, "onSuggestionClick", "onSuggestionClick(Lio/nutrient/data/models/Suggestion;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Unit invoke(Suggestion suggestion) {
            String str;
            b0 value;
            b0 value2;
            Suggestion suggestion2 = suggestion;
            suggestion2.getClass();
            f0 f0Var = (f0) this.receiver;
            f0Var.getClass();
            if (Intrinsics.areEqual(suggestion2.getAgent(), "ContextSpecificQA")) {
                AdditionalContext context = suggestion2.getParameters().getContext();
                String text = context != null ? context.getText() : null;
                if (text == null) {
                    text = "";
                }
                MutableStateFlow<b0> mutableStateFlow = f0Var.g;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, b0.a(value, false, false, false, false, null, new b0.a(text), 31)));
                if (Intrinsics.areEqual(suggestion2.getType(), "request")) {
                    String input = suggestion2.getParameters().getInput();
                    str = input != null ? input : "";
                    f0Var.e.setValue(new f0.a(str, str.length()));
                    BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(f0Var), null, null, new h0(f0Var, text, null), 3, null);
                    MutableStateFlow<b0> mutableStateFlow2 = f0Var.g;
                    do {
                        value2 = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value2, b0.a(value2, false, false, false, false, null, null, 31)));
                } else if (Intrinsics.areEqual(suggestion2.getType(), BoxMetadata.FIELD_TEMPLATE)) {
                    String template = suggestion2.getTemplate();
                    str = template != null ? template : "";
                    f0Var.e.setValue(new f0.a(str, str.length() - 1));
                }
            } else if (Intrinsics.areEqual(suggestion2.getType(), "request")) {
                String input2 = suggestion2.getParameters().getInput();
                str = input2 != null ? input2 : "";
                f0Var.e.setValue(new f0.a(str, str.length()));
                f0Var.a();
            }
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(Modifier modifier, Function0 function0, Function1 function1, Function0 function2, Function0 function3, b0 b0Var, f0.a aVar, boolean z, Function1 function4, Function1 function5, int i, int i2, Composer composer, int i3) {
        a(modifier, function0, function1, function2, function3, b0Var, aVar, z, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit a(AiAssistant aiAssistant, Modifier modifier, String str, Function3 function3, Function0 function0, int i, int i2, Composer composer, int i3) {
        a(aiAssistant, modifier, str, (Function3<? super List<? extends RectF>, ? super Integer, ? super Document, Unit>) function3, (Function0<Unit>) function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit a(f0.a aVar, b0 b0Var, AiAssistantColorScheme aiAssistantColorScheme, FocusRequester focusRequester, Function1 function1, Function0 function0, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1890834390, i, -1, "io.nutrient.internal.ui.ai.AiAssistantContent.<anonymous>.<anonymous> (AiAssistantScreen.kt:151)");
        }
        q.a(null, aVar, b0Var.d, aiAssistantColorScheme, focusRequester, function1, function0, composer, 24576, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(AiAssistantColorScheme aiAssistantColorScheme, b0 b0Var, Function0 function0, Function1 function1, Function1 function2, boolean z, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2113680691, i, -1, "io.nutrient.internal.ui.ai.AiAssistantContent.<anonymous>.<anonymous>.<anonymous> (AiAssistantScreen.kt:179)");
        }
        v8.a(null, aiAssistantColorScheme, b0Var.e, b0Var.c, function0, function1, function2, z, composer, 0, 1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(final b0 b0Var, final f0.a aVar, final AiAssistantColorScheme aiAssistantColorScheme, final FocusRequester focusRequester, final Function1 function1, final Function0 function0, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1747704830, i, -1, "io.nutrient.internal.ui.ai.AiAssistantContent.<anonymous> (AiAssistantScreen.kt:150)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(!b0Var.a, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-1890834390, true, new Function3() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return z.a(aVar, b0Var, aiAssistantColorScheme, focusRequester, function1, function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:102:0x01df  */
    /* JADX WARN: Code duplicated, block: B:105:0x0201  */
    /* JADX WARN: Code duplicated, block: B:106:0x0204  */
    /* JADX WARN: Code duplicated, block: B:110:0x020f  */
    /* JADX WARN: Code duplicated, block: B:113:0x0219  */
    /* JADX WARN: Code duplicated, block: B:115:0x021f  */
    /* JADX WARN: Code duplicated, block: B:118:0x0246  */
    /* JADX WARN: Code duplicated, block: B:120:0x024d  */
    /* JADX WARN: Code duplicated, block: B:122:0x0255  */
    /* JADX WARN: Code duplicated, block: B:125:0x0260  */
    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0053  */
    /* JADX WARN: Code duplicated, block: B:27:0x0056  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x0062  */
    /* JADX WARN: Code duplicated, block: B:32:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x007f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0085  */
    /* JADX WARN: Code duplicated, block: B:47:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x0094  */
    /* JADX WARN: Code duplicated, block: B:52:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:74:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:77:0x0128  */
    /* JADX WARN: Code duplicated, block: B:80:0x015a  */
    /* JADX WARN: Code duplicated, block: B:82:0x0160  */
    /* JADX WARN: Code duplicated, block: B:85:0x0178  */
    /* JADX WARN: Code duplicated, block: B:87:0x017e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0192  */
    /* JADX WARN: Code duplicated, block: B:92:0x0198  */
    /* JADX WARN: Code duplicated, block: B:95:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:97:0x01c5  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(final AiAssistant aiAssistant, Modifier modifier, String str, final Function3<? super List<? extends RectF>, ? super Integer, ? super Document, Unit> function3, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        String str2;
        int i5;
        boolean z;
        final Modifier modifier3;
        final String str3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        String str4;
        AiAssistantConfiguration configuration;
        String sessionId;
        e0 e0Var;
        ViewModelStoreOwner current;
        CreationExtras defaultViewModelCreationExtras;
        f0 f0Var;
        final Context context;
        Object objRememberedValue;
        Composer.Companion companion;
        CoroutineScope coroutineScope;
        boolean zChangedInstance;
        Object objRememberedValue2;
        boolean zChangedInstance2;
        Object objRememberedValue3;
        boolean zChangedInstance3;
        Object objRememberedValue4;
        boolean zChangedInstance4;
        Object objRememberedValue5;
        boolean zChangedInstance5;
        Object objRememberedValue6;
        boolean z2;
        boolean z3;
        Object objRememberedValue7;
        int i6;
        int i7;
        aiAssistant.getClass();
        function3.getClass();
        function0.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1461676289);
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(aiAssistant) : composerStartRestartGroup.changedInstance(aiAssistant) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    str2 = str;
                    if (composerStartRestartGroup.changed(str2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function0)) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                    i3 |= i6;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    if (i8 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        str4 = null;
                    } else {
                        str4 = str2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1461676289, i3, -1, "io.nutrient.internal.ui.ai.AiAssistantScreen (AiAssistantScreen.kt:57)");
                    }
                    configuration = aiAssistant.getConfiguration();
                    if (configuration != null) {
                        sessionId = configuration.getSessionId();
                    } else {
                        sessionId = null;
                    }
                    int i9 = f0.i;
                    Context context2 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    context2.getClass();
                    e0Var = new e0(context2, aiAssistant, str4);
                    current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                    if (current != null) {
                        if (current instanceof HasDefaultViewModelProviderFactory) {
                            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                        } else {
                            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                        }
                        String str5 = str4;
                        String str6 = sessionId;
                        f0Var = (f0) androidx.lifecycle.viewmodel.compose.ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(f0.class), current, sessionId, e0Var, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                        context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue;
                        State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(f0Var.h, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                        zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(f0Var);
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                            objRememberedValue2 = new b(coroutineScope, f0Var, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        EffectsKt.LaunchedEffect(str6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, 0);
                        zChangedInstance2 = composerStartRestartGroup.changedInstance(f0Var);
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance2 || objRememberedValue3 == companion.getEmpty()) {
                            objRememberedValue3 = new c(f0Var);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        KFunction kFunction = (KFunction) objRememberedValue3;
                        zChangedInstance3 = composerStartRestartGroup.changedInstance(f0Var);
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance3 || objRememberedValue4 == companion.getEmpty()) {
                            objRememberedValue4 = new d(f0Var);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                        }
                        KFunction kFunction2 = (KFunction) objRememberedValue4;
                        b0 b0Var = (b0) stateCollectAsStateWithLifecycle.getValue();
                        f0.a aVar = (f0.a) f0Var.e.getValue();
                        boolean zIsTextSelectionEnabled = aiAssistant.isTextSelectionEnabled();
                        zChangedInstance4 = composerStartRestartGroup.changedInstance(f0Var);
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance4 || objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = new e(f0Var);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        KFunction kFunction3 = (KFunction) objRememberedValue5;
                        zChangedInstance5 = composerStartRestartGroup.changedInstance(f0Var);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance5 || objRememberedValue6 == companion.getEmpty()) {
                            objRememberedValue6 = new f(f0Var);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        Function1 function1 = (Function1) kFunction;
                        Function0 function2 = (Function0) kFunction2;
                        Function0 function4 = (Function0) kFunction3;
                        Function1 function5 = (Function1) ((KFunction) objRememberedValue6);
                        boolean zChangedInstance6 = composerStartRestartGroup.changedInstance(context);
                        if ((i3 & 7168) == 2048) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        z3 = z2 | zChangedInstance6 | ((57344 & i3) == 16384);
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (!z3 || objRememberedValue7 == companion.getEmpty()) {
                            objRememberedValue7 = new Function1() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return z.a(context, function3, function0, (Link) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                        }
                        Modifier modifier5 = modifier4;
                        a(modifier5, function0, function1, function2, function4, b0Var, aVar, zIsTextSelectionEnabled, function5, (Function1) objRememberedValue7, composerStartRestartGroup, ((i3 >> 3) & 14) | ((i3 >> 9) & 112), 0);
                        composerStartRestartGroup = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier5;
                        str3 = str5;
                    } else {
                        throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    str3 = str2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return z.a(aiAssistant, modifier3, str3, function3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            str2 = str;
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                if (i8 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    str4 = null;
                } else {
                    str4 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1461676289, i3, -1, "io.nutrient.internal.ui.ai.AiAssistantScreen (AiAssistantScreen.kt:57)");
                }
                configuration = aiAssistant.getConfiguration();
                if (configuration != null) {
                    sessionId = configuration.getSessionId();
                } else {
                    sessionId = null;
                }
                int i10 = f0.i;
                Context context3 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                context3.getClass();
                e0Var = new e0(context3, aiAssistant, str4);
                current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current != null) {
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    String str7 = str4;
                    String str8 = sessionId;
                    f0Var = (f0) androidx.lifecycle.viewmodel.compose.ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(f0.class), current, sessionId, e0Var, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(f0Var.h, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(f0Var);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new b(coroutineScope, f0Var, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new b(coroutineScope, f0Var, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    EffectsKt.LaunchedEffect(str8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, 0);
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(f0Var);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue3 = new c(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new c(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    KFunction kFunction4 = (KFunction) objRememberedValue3;
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(f0Var);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance3) {
                        objRememberedValue4 = new d(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new d(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    KFunction kFunction5 = (KFunction) objRememberedValue4;
                    b0 b0Var2 = (b0) stateCollectAsStateWithLifecycle2.getValue();
                    f0.a aVar2 = (f0.a) f0Var.e.getValue();
                    boolean zIsTextSelectionEnabled2 = aiAssistant.isTextSelectionEnabled();
                    zChangedInstance4 = composerStartRestartGroup.changedInstance(f0Var);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance4) {
                        objRememberedValue5 = new e(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new e(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    KFunction kFunction6 = (KFunction) objRememberedValue5;
                    zChangedInstance5 = composerStartRestartGroup.changedInstance(f0Var);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance5) {
                        objRememberedValue6 = new f(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new f(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function6 = (Function1) kFunction4;
                    Function0 function7 = (Function0) kFunction5;
                    Function0 function8 = (Function0) kFunction6;
                    Function1 function9 = (Function1) ((KFunction) objRememberedValue6);
                    boolean zChangedInstance7 = composerStartRestartGroup.changedInstance(context);
                    if ((i3 & 7168) == 2048) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z2 | zChangedInstance7 | ((57344 & i3) == 16384);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        objRememberedValue7 = new Function1() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return z.a(context, function3, function0, (Link) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function1() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return z.a(context, function3, function0, (Link) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Modifier modifier6 = modifier4;
                    a(modifier6, function0, function6, function7, function8, b0Var2, aVar2, zIsTextSelectionEnabled2, function9, (Function1) objRememberedValue7, composerStartRestartGroup, ((i3 >> 3) & 14) | ((i3 >> 9) & 112), 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                    str3 = str7;
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return z.a(aiAssistant, modifier3, str3, function3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                str2 = str;
                if (composerStartRestartGroup.changed(str2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                if (i8 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    str4 = null;
                } else {
                    str4 = str2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1461676289, i3, -1, "io.nutrient.internal.ui.ai.AiAssistantScreen (AiAssistantScreen.kt:57)");
                }
                configuration = aiAssistant.getConfiguration();
                if (configuration != null) {
                    sessionId = configuration.getSessionId();
                } else {
                    sessionId = null;
                }
                int i11 = f0.i;
                Context context4 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                context4.getClass();
                e0Var = new e0(context4, aiAssistant, str4);
                current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
                if (current != null) {
                    if (current instanceof HasDefaultViewModelProviderFactory) {
                        defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                    } else {
                        defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                    }
                    String str9 = str4;
                    String str10 = sessionId;
                    f0Var = (f0) androidx.lifecycle.viewmodel.compose.ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(f0.class), current, sessionId, e0Var, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                    context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    State stateCollectAsStateWithLifecycle3 = FlowExtKt.collectAsStateWithLifecycle(f0Var.h, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(f0Var);
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue2 = new b(coroutineScope, f0Var, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new b(coroutineScope, f0Var, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    EffectsKt.LaunchedEffect(str10, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, 0);
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(f0Var);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2) {
                        objRememberedValue3 = new c(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new c(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    KFunction kFunction7 = (KFunction) objRememberedValue3;
                    zChangedInstance3 = composerStartRestartGroup.changedInstance(f0Var);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance3) {
                        objRememberedValue4 = new d(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    } else {
                        objRememberedValue4 = new d(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    KFunction kFunction8 = (KFunction) objRememberedValue4;
                    b0 b0Var3 = (b0) stateCollectAsStateWithLifecycle3.getValue();
                    f0.a aVar3 = (f0.a) f0Var.e.getValue();
                    boolean zIsTextSelectionEnabled3 = aiAssistant.isTextSelectionEnabled();
                    zChangedInstance4 = composerStartRestartGroup.changedInstance(f0Var);
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance4) {
                        objRememberedValue5 = new e(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    } else {
                        objRememberedValue5 = new e(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    KFunction kFunction9 = (KFunction) objRememberedValue5;
                    zChangedInstance5 = composerStartRestartGroup.changedInstance(f0Var);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance5) {
                        objRememberedValue6 = new f(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new f(f0Var);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    Function1 function10 = (Function1) kFunction7;
                    Function0 function11 = (Function0) kFunction8;
                    Function0 function12 = (Function0) kFunction9;
                    Function1 function13 = (Function1) ((KFunction) objRememberedValue6);
                    boolean zChangedInstance8 = composerStartRestartGroup.changedInstance(context);
                    if ((i3 & 7168) == 2048) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    z3 = z2 | zChangedInstance8 | ((57344 & i3) == 16384);
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (!z3) {
                        objRememberedValue7 = new Function1() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return z.a(context, function3, function0, (Link) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    } else {
                        objRememberedValue7 = new Function1() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return z.a(context, function3, function0, (Link) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    Modifier modifier7 = modifier4;
                    a(modifier7, function0, function10, function11, function12, b0Var3, aVar3, zIsTextSelectionEnabled3, function13, (Function1) objRememberedValue7, composerStartRestartGroup, ((i3 >> 3) & 14) | ((i3 >> 9) & 112), 0);
                    composerStartRestartGroup = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                    str3 = str9;
                } else {
                    throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                str3 = str2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return z.a(aiAssistant, modifier3, str3, function3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        str2 = str;
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i7 = 2048;
            } else {
                i7 = 1024;
            }
            i3 |= i7;
        }
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function0)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i3 |= i6;
        }
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i8 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                str4 = null;
            } else {
                str4 = str2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1461676289, i3, -1, "io.nutrient.internal.ui.ai.AiAssistantScreen (AiAssistantScreen.kt:57)");
            }
            configuration = aiAssistant.getConfiguration();
            if (configuration != null) {
                sessionId = configuration.getSessionId();
            } else {
                sessionId = null;
            }
            int i12 = f0.i;
            Context context5 = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            context5.getClass();
            e0Var = new e0(context5, aiAssistant, str4);
            current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composerStartRestartGroup, 6);
            if (current != null) {
                if (current instanceof HasDefaultViewModelProviderFactory) {
                    defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
                } else {
                    defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
                }
                String str11 = str4;
                String str12 = sessionId;
                f0Var = (f0) androidx.lifecycle.viewmodel.compose.ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(f0.class), current, sessionId, e0Var, defaultViewModelCreationExtras, composerStartRestartGroup, 0, 0);
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                State stateCollectAsStateWithLifecycle4 = FlowExtKt.collectAsStateWithLifecycle(f0Var.h, (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                zChangedInstance = composerStartRestartGroup.changedInstance(coroutineScope) | composerStartRestartGroup.changedInstance(f0Var);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue2 = new b(coroutineScope, f0Var, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new b(coroutineScope, f0Var, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                EffectsKt.LaunchedEffect(str12, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, 0);
                zChangedInstance2 = composerStartRestartGroup.changedInstance(f0Var);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue3 = new c(f0Var);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new c(f0Var);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                KFunction kFunction10 = (KFunction) objRememberedValue3;
                zChangedInstance3 = composerStartRestartGroup.changedInstance(f0Var);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance3) {
                    objRememberedValue4 = new d(f0Var);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new d(f0Var);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                KFunction kFunction11 = (KFunction) objRememberedValue4;
                b0 b0Var4 = (b0) stateCollectAsStateWithLifecycle4.getValue();
                f0.a aVar4 = (f0.a) f0Var.e.getValue();
                boolean zIsTextSelectionEnabled4 = aiAssistant.isTextSelectionEnabled();
                zChangedInstance4 = composerStartRestartGroup.changedInstance(f0Var);
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance4) {
                    objRememberedValue5 = new e(f0Var);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                } else {
                    objRememberedValue5 = new e(f0Var);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                KFunction kFunction12 = (KFunction) objRememberedValue5;
                zChangedInstance5 = composerStartRestartGroup.changedInstance(f0Var);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance5) {
                    objRememberedValue6 = new f(f0Var);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new f(f0Var);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                Function1 function14 = (Function1) kFunction10;
                Function0 function15 = (Function0) kFunction11;
                Function0 function16 = (Function0) kFunction12;
                Function1 function17 = (Function1) ((KFunction) objRememberedValue6);
                boolean zChangedInstance9 = composerStartRestartGroup.changedInstance(context);
                if ((i3 & 7168) == 2048) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2 | zChangedInstance9 | ((57344 & i3) == 16384);
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!z3) {
                    objRememberedValue7 = new Function1() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return z.a(context, function3, function0, (Link) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function1() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return z.a(context, function3, function0, (Link) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                Modifier modifier8 = modifier4;
                a(modifier8, function0, function14, function15, function16, b0Var4, aVar4, zIsTextSelectionEnabled4, function17, (Function1) objRememberedValue7, composerStartRestartGroup, ((i3 >> 3) & 14) | ((i3 >> 9) & 112), 0);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier8;
                str3 = str11;
            } else {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            str3 = str2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return z.a(aiAssistant, modifier3, str3, function3, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(Context context, Function3 function3, Function0 function0, Link link) {
        link.getClass();
        if (StringsKt.startsWith$default(link.getHref(), "http", false, 2, (Object) null)) {
            String href = link.getHref();
            context.getClass();
            href.getClass();
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(href)));
        } else if (StringsKt.startsWith$default(link.getHref(), "document", false, 2, (Object) null)) {
            String strReplace$default = StringsKt.replace$default(link.getHref(), "document://", "", false, 4, (Object) null);
            Json.Companion companion = Json.INSTANCE;
            companion.getSerializersModule();
            DocumentLinkResponse documentLinkResponse = (DocumentLinkResponse) CollectionsKt.first((List) companion.decodeFromString(new ArrayListSerializer(DocumentLinkResponse.INSTANCE.serializer()), strReplace$default));
            List<LinkRect> rects = documentLinkResponse.getRects();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(rects, 10));
            for (LinkRect linkRect : rects) {
                arrayList.add(new RectF((float) linkRect.getLeft(), (float) linkRect.getTop(), ((float) linkRect.getLeft()) + ((float) linkRect.getWidth()), ((float) linkRect.getTop()) + ((float) linkRect.getHeight())));
            }
            function3.invoke(arrayList, Integer.valueOf(documentLinkResponse.getPageIndex()), documentLinkResponse.getDocument());
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    public static final void a(Modifier modifier, final Function0<Unit> function0, final Function1<? super TextFieldValue, Unit> function1, final Function0<Unit> function2, final Function0<Unit> function3, final b0 b0Var, final f0.a aVar, boolean z, final Function1<? super Suggestion, Unit> function4, final Function1<? super Link, Unit> function5, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        boolean z2;
        Composer composer2;
        final boolean z3;
        function0.getClass();
        function1.getClass();
        function2.getClass();
        function3.getClass();
        b0Var.getClass();
        aVar.getClass();
        function4.getClass();
        function5.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-1166064089);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(b0Var) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= (i & 2097152) == 0 ? composerStartRestartGroup.changed(aVar) : composerStartRestartGroup.changedInstance(aVar) ? 1048576 : 524288;
        }
        int i6 = i2 & 128;
        if (i6 != 0) {
            i3 |= 12582912;
            i4 = 2097152;
            z2 = z;
        } else {
            i4 = 2097152;
            z2 = z;
            if ((i & 12582912) == 0) {
                i3 |= composerStartRestartGroup.changed(z2) ? 8388608 : 4194304;
            }
        }
        if ((i & 100663296) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function4) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function5) ? C.BUFFER_FLAG_LAST_SAMPLE : 268435456;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 306783379) != 306783378, i3 & 1)) {
            Modifier modifier2 = i5 != 0 ? Modifier.INSTANCE : modifier;
            final boolean z4 = i6 != 0 ? true : z2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1166064089, i3, -1, "io.nutrient.internal.ui.ai.AiAssistantContent (AiAssistantScreen.kt:127)");
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
            final AiAssistantColorScheme aiAssistantColorScheme = UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getAiAssistantColorScheme();
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            int i7 = i3;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new FocusRequester();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final FocusRequester focusRequester = (FocusRequester) objRememberedValue2;
            String str = aVar.a;
            boolean z5 = (i7 & 3670016) == 1048576 || ((i7 & i4) != 0 && composerStartRestartGroup.changedInstance(aVar));
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z5 || objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new a(aVar, focusRequester, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            EffectsKt.LaunchedEffect(str, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue3, composerStartRestartGroup, 0);
            modifier = modifier2;
            boolean z6 = z4;
            composer2 = composerStartRestartGroup;
            ScaffoldKt.m4038ScaffoldTvnljyQ(SizeKt.fillMaxSize$default(modifier2, 0.0f, 1, null), ComposableLambdaKt.rememberComposableLambda(-710694429, true, new Function2() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return z.a(aiAssistantColorScheme, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1747704830, true, new Function2() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return z.a(b0Var, aVar, aiAssistantColorScheme, focusRequester, function1, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(1510252065, true, new Function2() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return z.a(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(504724600, true, new Function3() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return z.a(aiAssistantColorScheme, b0Var, function3, function4, function5, z4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805309872, 496);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z3 = z6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z3 = z2;
        }
        final Modifier modifier3 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return z.a(modifier3, function0, function1, function2, function3, b0Var, aVar, z3, function4, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(AiAssistantColorScheme aiAssistantColorScheme, Function0 function0, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-710694429, i, -1, "io.nutrient.internal.ui.ai.AiAssistantContent.<anonymous> (AiAssistantScreen.kt:143)");
            }
            a0.a(null, aiAssistantColorScheme, function0, composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(SnackbarHostState snackbarHostState, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1510252065, i, -1, "io.nutrient.internal.ui.ai.AiAssistantContent.<anonymous> (AiAssistantScreen.kt:148)");
            }
            SnackbarHostKt.SnackbarHost(snackbarHostState, null, null, composer, 6, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(final AiAssistantColorScheme aiAssistantColorScheme, final b0 b0Var, final Function0 function0, final Function1 function1, final Function1 function2, final boolean z, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        paddingValues.getClass();
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(504724600, i2, -1, "io.nutrient.internal.ui.ai.AiAssistantContent.<anonymous> (AiAssistantScreen.kt:162)");
            }
            Modifier modifierPadding = PaddingKt.padding(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, aiAssistantColorScheme.m13906getContainerColor0d7_KjU(), null, 2, null), paddingValues);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            f2.a(companion, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            AnimatedVisibilityKt.AnimatedVisibility(b0Var.a, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-490388394, true, new Function3() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return z.a(aiAssistantColorScheme, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 30);
            AnimatedVisibilityKt.AnimatedVisibility(!b0Var.a, (Modifier) null, EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null), EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null), (String) null, ComposableLambdaKt.rememberComposableLambda(-2113680691, true, new Function3() { // from class: com.pspdfkit.internal.z$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return z.a(aiAssistantColorScheme, b0Var, function0, function1, function2, z, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 200064, 18);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(AiAssistantColorScheme aiAssistantColorScheme, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-490388394, i, -1, "io.nutrient.internal.ui.ai.AiAssistantContent.<anonymous>.<anonymous>.<anonymous> (AiAssistantScreen.kt:169)");
        }
        io.a(aiAssistantColorScheme.m13906getContainerColor0d7_KjU(), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}
