package com.box.android.boxai.markdown;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.boxai.ui.BoxAITheme;
import kotlin.Metadata;

/* JADX INFO: compiled from: MarkdownView.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/boxai/markdown/MarkdownViewDefaults;", "", "<init>", "()V", "defaultStyle", "Lcom/box/android/boxai/markdown/MarkdownStyle;", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/boxai/markdown/MarkdownStyle;", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MarkdownViewDefaults {
    public static final int $stable = 0;
    public static final MarkdownViewDefaults INSTANCE = new MarkdownViewDefaults();

    private MarkdownViewDefaults() {
    }

    public final MarkdownStyle defaultStyle(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 14931263, "C(defaultStyle)105@4287L6,112@4543L6,116@4703L6,127@5092L6,132@5264L6,133@5330L6:MarkdownView.kt#mkonuh");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(14931263, i, -1, "com.box.android.boxai.markdown.MarkdownViewDefaults.defaultStyle (MarkdownView.kt:103)");
        }
        float f = 8;
        float f2 = 1;
        MarkdownStyle markdownStyle = new MarkdownStyle(new MarkdownStyle.TextStyle(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), TextUnitKt.getSp(14), TextUnitKt.getSp(20), FontWeight.INSTANCE.getNormal(), Dp.m9687constructorimpl(f), null), new MarkdownStyle.LinkStyle(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), null), new MarkdownStyle.BlockQuoteStyle(Dp.m9687constructorimpl(2), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11517getDivider0d7_KjU(), null), new MarkdownStyle.BulletListStyle(Dp.INSTANCE.m9705getHairlineD9Ej5fM(), Dp.m9687constructorimpl(6), null), new MarkdownStyle.HeadingStyle(Dp.m9687constructorimpl(0), null), new MarkdownStyle.ThematicBreakStyle(Dp.m9687constructorimpl(f2), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11517getDivider0d7_KjU(), null), new MarkdownStyle.TableStyle(Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11517getDivider0d7_KjU(), BoxAITheme.INSTANCE.getColors(composer, 6).m12058getResponseTableHeaderBackground0d7_KjU(), Color.m6813copywmQWz5c$default(Color.INSTANCE.m6851getWhite0d7_KjU(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(Color.INSTANCE.m6851getWhite0d7_KjU(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null), null));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return markdownStyle;
    }
}
