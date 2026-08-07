package com.box.android.preview.previewtype.code;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.box.android.domain.models.item.FileModel;
import com.microsoft.intune.mam.client.widget.MAMWebView;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: CodePreviewer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aG\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0007¢\u0006\u0002\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"CODE_PREVIEW_WEB_VIEW_ID", "", "CodePreviewer", "", "codeFile", "Lcom/box/android/domain/models/item/FileModel;", "codeContent", "", "onLoaded", "Lkotlin/Function0;", "onScrolled", "onPressed", "(Lcom/box/android/domain/models/item/FileModel;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CodePreviewerKt {
    public static final int CODE_PREVIEW_WEB_VIEW_ID = 100;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CodePreviewer$lambda$3(FileModel fileModel, String str, Function0 function0, Function0 function1, Function0 function2, int i, Composer composer, int i2) {
        CodePreviewer(fileModel, str, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void CodePreviewer(final FileModel codeFile, final String codeContent, final Function0<Unit> onLoaded, final Function0<Unit> onScrolled, final Function0<Unit> onPressed, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(codeFile, "codeFile");
        Intrinsics.checkNotNullParameter(codeContent, "codeContent");
        Intrinsics.checkNotNullParameter(onLoaded, "onLoaded");
        Intrinsics.checkNotNullParameter(onScrolled, "onScrolled");
        Intrinsics.checkNotNullParameter(onPressed, "onPressed");
        Composer composerStartRestartGroup = composer.startRestartGroup(1857963748);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CodePreviewer)N(codeFile,codeContent,onLoaded,onScrolled,onPressed)27@877L63,28@972L7,34@1116L1259,72@2394L96,30@985L1511:CodePreviewer.kt#mz3i3y");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(codeFile) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(codeContent) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onLoaded) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onScrolled) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onPressed) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1857963748, i2, -1, "com.box.android.preview.previewtype.code.CodePreviewer (CodePreviewer.kt:26)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1203226845, "CC(remember):CodePreviewer.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new CodePreviewLoader(codeContent, codeFile.getExtension());
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CodePreviewLoader codePreviewLoader = (CodePreviewLoader) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Context context = (Context) objConsume;
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), "Preview:CodePreview");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1203218001, "CC(remember):CodePreviewer.kt#9igjgp");
            boolean zChangedInstance = ((57344 & i2) == 16384) | composerStartRestartGroup.changedInstance(context) | ((i2 & 7168) == 2048);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.preview.previewtype.code.CodePreviewerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CodePreviewerKt.CodePreviewer$lambda$1$0(context, codePreviewLoader, onPressed, onScrolled, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function1 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1203178268, "CC(remember):CodePreviewer.kt#9igjgp");
            boolean z = (i2 & 896) == 256;
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.preview.previewtype.code.CodePreviewerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CodePreviewerKt.CodePreviewer$lambda$2$0(codePreviewLoader, onLoaded, (WebView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidView_androidKt.AndroidView(function1, modifierTestTag, (Function1) objRememberedValue3, composerStartRestartGroup, 48, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previewtype.code.CodePreviewerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CodePreviewerKt.CodePreviewer$lambda$3(codeFile, codeContent, onLoaded, onScrolled, onPressed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WebView CodePreviewer$lambda$1$0(Context context, CodePreviewLoader codePreviewLoader, final Function0 function0, final Function0 function1, Context it) throws IOException {
        Intrinsics.checkNotNullParameter(it, "it");
        MAMWebView mAMWebView = new MAMWebView(context);
        mAMWebView.setId(100);
        codePreviewLoader.initWebView(mAMWebView);
        mAMWebView.setOverScrollMode(2);
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        mAMWebView.setOnTouchListener(new View.OnTouchListener() { // from class: com.box.android.preview.previewtype.code.CodePreviewerKt$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return CodePreviewerKt.CodePreviewer$lambda$1$0$0$0(booleanRef, function0, function1, view, motionEvent);
            }
        });
        mAMWebView.setLongClickable(true);
        mAMWebView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.box.android.preview.previewtype.code.CodePreviewerKt$$ExternalSyntheticLambda4
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return CodePreviewerKt.CodePreviewer$lambda$1$0$0$1(booleanRef, view);
            }
        });
        return mAMWebView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CodePreviewer$lambda$1$0$0$0(Ref.BooleanRef booleanRef, Function0 function0, Function0 function1, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            if (booleanRef.element) {
                booleanRef.element = false;
            } else {
                function0.invoke();
            }
        } else if (action == 2 && !booleanRef.element) {
            booleanRef.element = true;
            function1.invoke();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CodePreviewer$lambda$1$0$0$1(Ref.BooleanRef booleanRef, View view) {
        booleanRef.element = true;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CodePreviewer$lambda$2$0(CodePreviewLoader codePreviewLoader, Function0 function0, WebView webView) throws IOException {
        Intrinsics.checkNotNullParameter(webView, "webView");
        codePreviewLoader.loadContent(webView);
        function0.invoke();
        return Unit.INSTANCE;
    }
}
