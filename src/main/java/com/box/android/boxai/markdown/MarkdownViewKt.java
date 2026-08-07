package com.box.android.boxai.markdown;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.boxai.ui.BoxAITheme;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.Markwon;
import io.noties.markwon.core.CorePlugin;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.ext.strikethrough.StrikethroughPlugin;
import io.noties.markwon.ext.tables.TablePlugin;
import io.noties.markwon.ext.tables.TableTheme;
import io.noties.markwon.recycler.MarkwonAdapter;
import io.noties.markwon.recycler.table.TableEntryPlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.commonmark.ext.gfm.tables.TableBlock;

/* JADX INFO: compiled from: MarkdownView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000e\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u000f\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0013\"\u000e\u0010\u0015\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\u0003X\u008a\u0084\u0002"}, d2 = {"MarkdownView", "", "markdownText", "", "modifier", "Landroidx/compose/ui/Modifier;", "style", "Lcom/box/android/boxai/markdown/MarkdownStyle;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Lcom/box/android/boxai/markdown/MarkdownStyle;Landroidx/compose/runtime/Composer;II)V", "createMarkwon", "Lio/noties/markwon/Markwon;", "context", "Landroid/content/Context;", "createMarkwonThemePlugin", "com/box/android/boxai/markdown/MarkdownViewKt$createMarkwonThemePlugin$1", "(Landroid/content/Context;Lcom/box/android/boxai/markdown/MarkdownStyle;)Lcom/box/android/boxai/markdown/MarkdownViewKt$createMarkwonThemePlugin$1;", "createMarkwonAdapter", "Lio/noties/markwon/recycler/MarkwonAdapter;", "MarkdownViewPreview", "(Landroidx/compose/runtime/Composer;I)V", "MarkdownViewPreviewIncremental", "MARKDOWN_TEST", "boxai_generalProdRelease", "text"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MarkdownViewKt {
    private static final String MARKDOWN_TEST = "\n# h1 Heading\n## h2 Heading\n### h3 Heading\n#### h4 Heading\n##### h5 Heading\n###### h6 Heading\n\n---\n\n**bold text**   __bold text__   *italic text*   _italic text_ ~~strikethrough text~~\n\n> Blockquotes can also be nested...\n>> ...by using additional greater-than signs right next to each other...\n> > > ...or with spaces between arrows.\n\n+ Create a list by starting a line with `+`, `-`, or `*`\n+ Sub-lists are made by indenting 2 spaces:\n    - Marker character change forces new list start:\n        * Ac tristique libero volutpat at\n        + Facilisis in pretium nisl aliquet\n        - Nulla volutpat aliquam velit\n+ Very easy!\n\n1. Lorem ipsum dolor sit amet\n2. Consectetur adipiscing elit\n\n1. You can use sequential numbers...\n1. ...or keep all the numbers as `1.`\n\nStart numbering with offset:\n\n57. foo\n1. bar\n\n[link text](http://dev.nodeca.com)\n\n[link with title](http://nodeca.github.io/pica/demo/ \"title text!\")\n\nInline `code`\n\nIndented code\n\n    // Some comments\n    line 1 of code\n    line 2 of code\n    line 3 of code\n\n\nBlock code \"fences\"\n\n```\nSample text here...\n```\n\nSyntax highlighting\n\n``` js\nvar foo = function (bar) {\n  return bar++;\n};\n\nconsole.log(foo(5));\n```\n\nLeft aligned columns\n\n| Option | Description |\n| ------ | ----------- |\n| data   | path to data files to supply the data that will be passed into templates. |\n| engine | engine to be used for processing templates. Handlebars is the default. |\n| ext    | extension to be used for dest files. |\n\nCentered columns\n\n| Option | Description |\n|:------:|:-----------:|\n| data   | path to data files to supply the data that will be passed into templates. |\n| engine | engine to be used for processing templates. Handlebars is the default. |\n| ext    | extension to be used for dest files. |\n\nRight aligned columns\n\n| Option | Description |\n| ------:| -----------:|\n| data   | path to data files to supply the data that will be passed into templates. |\n| engine | engine to be used for processing templates. Handlebars is the default. |\n| ext    | extension to be used for dest files. |\n";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MarkdownView$lambda$4(String str, Modifier modifier, MarkdownStyle markdownStyle, int i, int i2, Composer composer, int i3) {
        MarkdownView(str, modifier, markdownStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MarkdownViewPreview$lambda$0(int i, Composer composer, int i2) {
        MarkdownViewPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MarkdownViewPreviewIncremental$lambda$3(int i, Composer composer, int i2) {
        MarkdownViewPreviewIncremental(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:25:0x004c  */
    /* JADX WARN: Code duplicated, block: B:27:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0067  */
    /* JADX WARN: Code duplicated, block: B:35:0x0069  */
    /* JADX WARN: Code duplicated, block: B:38:0x0072  */
    /* JADX WARN: Code duplicated, block: B:46:0x008f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x0091  */
    /* JADX WARN: Code duplicated, block: B:48:0x0096  */
    /* JADX WARN: Code duplicated, block: B:51:0x009b  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:59:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:62:0x0104  */
    /* JADX WARN: Code duplicated, block: B:65:0x0125  */
    /* JADX WARN: Code duplicated, block: B:67:0x012d  */
    /* JADX WARN: Code duplicated, block: B:70:0x014d  */
    /* JADX WARN: Code duplicated, block: B:73:0x0155  */
    /* JADX WARN: Code duplicated, block: B:75:0x015d  */
    /* JADX WARN: Code duplicated, block: B:78:0x0178  */
    /* JADX WARN: Code duplicated, block: B:80:0x017d  */
    /* JADX WARN: Code duplicated, block: B:83:0x0188  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void MarkdownView(final String markdownText, Modifier modifier, MarkdownStyle markdownStyle, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        MarkdownStyle markdownStyle2;
        boolean z;
        final MarkdownStyle markdownStyle3;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i4;
        MarkdownStyle markdownStyleDefaultStyle;
        final Context context;
        Object objRememberedValue;
        final Markwon markwon;
        Object objRememberedValue2;
        final MarkwonAdapter markwonAdapter;
        boolean zChangedInstance;
        Object objRememberedValue3;
        boolean zChangedInstance2;
        Object objRememberedValue4;
        Intrinsics.checkNotNullParameter(markdownText, "markdownText");
        Composer composerStartRestartGroup = composer.startRestartGroup(-508341117);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MarkdownView)N(markdownText,modifier,style)44@1919L7,46@1946L42,47@2007L40,51@2113L219,58@2351L109,49@2053L413:MarkdownView.kt#mkonuh");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(markdownText) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    markdownStyle2 = markdownStyle;
                    int i6 = composerStartRestartGroup.changed(markdownStyle2) ? 256 : 128;
                    i3 |= i6;
                } else {
                    markdownStyle2 = markdownStyle;
                }
                i3 |= i6;
            } else {
                markdownStyle2 = markdownStyle;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                markdownStyle3 = markdownStyle2;
            } else {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "43@1870L14");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 4) != 0) {
                        Modifier modifier4 = companion;
                        i4 = i3 & (-897);
                        markdownStyleDefaultStyle = MarkdownViewDefaults.INSTANCE.defaultStyle(composerStartRestartGroup, 6);
                        modifier2 = modifier4;
                    } else {
                        modifier2 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-508341117, i4, -1, "com.box.android.boxai.markdown.MarkdownView (MarkdownView.kt:43)");
                    }
                    ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localContext);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    context = (Context) objConsume;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1110464429, "CC(remember):MarkdownView.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = createMarkwon(context, markdownStyleDefaultStyle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    markwon = (Markwon) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1110466379, "CC(remember):MarkdownView.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = createMarkwonAdapter(markdownStyleDefaultStyle);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    markwonAdapter = (MarkwonAdapter) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1110469950, "CC(remember):MarkdownView.kt#9igjgp");
                    zChangedInstance = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(markwonAdapter);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MarkdownViewKt.MarkdownView$lambda$2$0(context, markwonAdapter, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    Function1 function1 = (Function1) objRememberedValue3;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1110477456, "CC(remember):MarkdownView.kt#9igjgp");
                    zChangedInstance2 = composerStartRestartGroup.changedInstance(markwonAdapter) | composerStartRestartGroup.changedInstance(markwon) | ((i4 & 14) == 4);
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return MarkdownViewKt.MarkdownView$lambda$3$0(markwonAdapter, markwon, markdownText, (NonScrollableRecyclerView) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidView_androidKt.AndroidView(function1, modifier2, (Function1) objRememberedValue4, composerStartRestartGroup, i4 & 112, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    markdownStyle3 = markdownStyleDefaultStyle;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                }
                i4 = i3;
                markdownStyleDefaultStyle = markdownStyle2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-508341117, i4, -1, "com.box.android.boxai.markdown.MarkdownView (MarkdownView.kt:43)");
                }
                ProvidableCompositionLocal<Context> localContext2 = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume2 = composerStartRestartGroup.consume(localContext2);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                context = (Context) objConsume2;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1110464429, "CC(remember):MarkdownView.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = createMarkwon(context, markdownStyleDefaultStyle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                markwon = (Markwon) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1110466379, "CC(remember):MarkdownView.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = createMarkwonAdapter(markdownStyleDefaultStyle);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                markwonAdapter = (MarkwonAdapter) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1110469950, "CC(remember):MarkdownView.kt#9igjgp");
                zChangedInstance = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(markwonAdapter);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MarkdownViewKt.MarkdownView$lambda$2$0(context, markwonAdapter, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MarkdownViewKt.MarkdownView$lambda$2$0(context, markwonAdapter, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function1 function2 = (Function1) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1110477456, "CC(remember):MarkdownView.kt#9igjgp");
                zChangedInstance2 = composerStartRestartGroup.changedInstance(markwonAdapter) | composerStartRestartGroup.changedInstance(markwon) | ((i4 & 14) == 4);
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MarkdownViewKt.MarkdownView$lambda$3$0(markwonAdapter, markwon, markdownText, (NonScrollableRecyclerView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                } else {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MarkdownViewKt.MarkdownView$lambda$3$0(markwonAdapter, markwon, markdownText, (NonScrollableRecyclerView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidView_androidKt.AndroidView(function2, modifier2, (Function1) objRememberedValue4, composerStartRestartGroup, i4 & 112, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                markdownStyle3 = markdownStyleDefaultStyle;
            }
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MarkdownViewKt.MarkdownView$lambda$4(markdownText, modifier3, markdownStyle3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                markdownStyle2 = markdownStyle;
                if (composerStartRestartGroup.changed(markdownStyle2)) {
                }
                i3 |= i6;
            } else {
                markdownStyle2 = markdownStyle;
            }
            i3 |= i6;
        } else {
            markdownStyle2 = markdownStyle;
        }
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            markdownStyle3 = markdownStyle2;
        } else {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "43@1870L14");
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    Modifier modifier5 = companion;
                    i4 = i3 & (-897);
                    markdownStyleDefaultStyle = MarkdownViewDefaults.INSTANCE.defaultStyle(composerStartRestartGroup, 6);
                    modifier2 = modifier5;
                } else {
                    modifier2 = companion;
                    i4 = i3;
                    markdownStyleDefaultStyle = markdownStyle2;
                }
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 4) != 0) {
                    Modifier modifier6 = companion;
                    i4 = i3 & (-897);
                    markdownStyleDefaultStyle = MarkdownViewDefaults.INSTANCE.defaultStyle(composerStartRestartGroup, 6);
                    modifier2 = modifier6;
                } else {
                    modifier2 = companion;
                    i4 = i3;
                    markdownStyleDefaultStyle = markdownStyle2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-508341117, i4, -1, "com.box.android.boxai.markdown.MarkdownView (MarkdownView.kt:43)");
            }
            ProvidableCompositionLocal<Context> localContext3 = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localContext3);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            context = (Context) objConsume3;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1110464429, "CC(remember):MarkdownView.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = createMarkwon(context, markdownStyleDefaultStyle);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            markwon = (Markwon) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1110466379, "CC(remember):MarkdownView.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = createMarkwonAdapter(markdownStyleDefaultStyle);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            markwonAdapter = (MarkwonAdapter) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1110469950, "CC(remember):MarkdownView.kt#9igjgp");
            zChangedInstance = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changedInstance(markwonAdapter);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MarkdownViewKt.MarkdownView$lambda$2$0(context, markwonAdapter, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MarkdownViewKt.MarkdownView$lambda$2$0(context, markwonAdapter, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function3 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1110477456, "CC(remember):MarkdownView.kt#9igjgp");
            zChangedInstance2 = composerStartRestartGroup.changedInstance(markwonAdapter) | composerStartRestartGroup.changedInstance(markwon) | ((i4 & 14) == 4);
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MarkdownViewKt.MarkdownView$lambda$3$0(markwonAdapter, markwon, markdownText, (NonScrollableRecyclerView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MarkdownViewKt.MarkdownView$lambda$3$0(markwonAdapter, markwon, markdownText, (NonScrollableRecyclerView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidView_androidKt.AndroidView(function3, modifier2, (Function1) objRememberedValue4, composerStartRestartGroup, i4 & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            markdownStyle3 = markdownStyleDefaultStyle;
        }
        modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MarkdownViewKt.MarkdownView$lambda$4(markdownText, modifier3, markdownStyle3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NonScrollableRecyclerView MarkdownView$lambda$2$0(Context context, MarkwonAdapter markwonAdapter, Context it) {
        Intrinsics.checkNotNullParameter(it, "it");
        NonScrollableRecyclerView nonScrollableRecyclerView = new NonScrollableRecyclerView(context);
        nonScrollableRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        nonScrollableRecyclerView.setAdapter(markwonAdapter);
        nonScrollableRecyclerView.setItemAnimator(null);
        return nonScrollableRecyclerView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MarkdownView$lambda$3$0(MarkwonAdapter markwonAdapter, Markwon markwon, String str, NonScrollableRecyclerView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        markwonAdapter.setMarkdown(markwon, str);
        markwonAdapter.notifyDataSetChanged();
        return Unit.INSTANCE;
    }

    private static final Markwon createMarkwon(final Context context, final MarkdownStyle markdownStyle) {
        Markwon markwonBuild = Markwon.builderNoCore(context).usePlugin(CorePlugin.create().hasExplicitMovementMethod(true)).usePlugin(StrikethroughPlugin.create()).usePlugin(TableEntryPlugin.create(new TablePlugin.ThemeConfigure() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda0
            @Override // io.noties.markwon.ext.tables.TablePlugin.ThemeConfigure
            public final void configureTheme(TableTheme.Builder builder) {
                MarkdownViewKt.createMarkwon$lambda$0(markdownStyle, context, builder);
            }
        })).usePlugin(createMarkwonThemePlugin(context, markdownStyle)).build();
        Intrinsics.checkNotNullExpressionValue(markwonBuild, "build(...)");
        return markwonBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createMarkwon$lambda$0(MarkdownStyle markdownStyle, Context context, TableTheme.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        MarkdownStyleKt.applyTo(markdownStyle.getTableStyle(), builder, context);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.box.android.boxai.markdown.MarkdownViewKt$createMarkwonThemePlugin$1] */
    private static final AnonymousClass1 createMarkwonThemePlugin(final Context context, final MarkdownStyle markdownStyle) {
        return new AbstractMarkwonPlugin() { // from class: com.box.android.boxai.markdown.MarkdownViewKt.createMarkwonThemePlugin.1
            @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
            public void configureTheme(MarkwonTheme.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                MarkdownStyleKt.applyTo(markdownStyle.getLinkStyle(), builder);
                MarkdownStyleKt.applyTo(markdownStyle.getBlockQuoteStyle(), builder, context);
                MarkdownStyleKt.applyTo(markdownStyle.getBulletListStyle(), builder, context);
                MarkdownStyleKt.applyTo(markdownStyle.getHeadingStyle(), builder, context);
                MarkdownStyleKt.applyTo(markdownStyle.getThematicBreakStyle(), builder, context);
            }
        };
    }

    private static final MarkwonAdapter createMarkwonAdapter(MarkdownStyle markdownStyle) {
        MarkwonAdapter markwonAdapterBuild = MarkwonAdapter.builder(new MarkwonTextEntry(markdownStyle)).include(TableBlock.class, new MarkwonTableEntry(markdownStyle)).build();
        Intrinsics.checkNotNullExpressionValue(markwonAdapterBuild, "build(...)");
        return markwonAdapterBuild;
    }

    private static final void MarkdownViewPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1809488349);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MarkdownViewPreview)148@5905L236:MarkdownView.kt#mkonuh");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1809488349, i, -1, "com.box.android.boxai.markdown.MarkdownViewPreview (MarkdownView.kt:147)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$MarkdownViewKt.INSTANCE.m11960getLambda$2066031058$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MarkdownViewKt.MarkdownViewPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void MarkdownViewPreviewIncremental(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(352293521);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MarkdownViewPreviewIncremental)162@6359L212,169@6597L23,170@6634L218,170@6625L227:MarkdownView.kt#mkonuh");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(352293521, i, -1, "com.box.android.boxai.markdown.MarkdownViewPreviewIncremental (MarkdownView.kt:161)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -748340635, "CC(remember):MarkdownView.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = FlowKt.onEach(FlowKt.runningFold(FlowKt.asFlow(StringsKt.split$default((CharSequence) SequencesKt.first(new LoremIpsum(50).getValues()), new char[]{' '}, false, 0, 6, (Object) null)), "", new MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$1(null)), new MarkdownViewKt$MarkdownViewPreviewIncremental$textFlow$1$2(null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final State stateCollectAsState = SnapshotStateKt.collectAsState((Flow) objRememberedValue, "Lorem", null, composerStartRestartGroup, 48, 2);
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(-1420741210, true, new Function2() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MarkdownViewKt.MarkdownViewPreviewIncremental$lambda$2(stateCollectAsState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.markdown.MarkdownViewKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MarkdownViewKt.MarkdownViewPreviewIncremental$lambda$3(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MarkdownViewPreviewIncremental$lambda$2(State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C171@6679L6,171@6644L202:MarkdownView.kt#mkonuh");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1420741210, i, -1, "com.box.android.boxai.markdown.MarkdownViewPreviewIncremental.<anonymous> (MarkdownView.kt:171)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxAITheme.INSTANCE.getColors(composer, 6).m12054getContainerBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM589backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1457294001, "C172@6722L114:MarkdownView.kt#mkonuh");
            MarkdownView(MarkdownViewPreviewIncremental$lambda$1(state), SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, composer, 48, 4);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final String MarkdownViewPreviewIncremental$lambda$1(State<String> state) {
        return state.getValue();
    }
}
