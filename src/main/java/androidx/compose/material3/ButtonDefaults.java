package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.BaselineButtonTokens;
import androidx.compose.material3.tokens.ButtonLargeTokens;
import androidx.compose.material3.tokens.ButtonMediumTokens;
import androidx.compose.material3.tokens.ButtonSmallTokens;
import androidx.compose.material3.tokens.ButtonXLargeTokens;
import androidx.compose.material3.tokens.ButtonXSmallTokens;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.ElevatedButtonTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.FilledTonalButtonTokens;
import androidx.compose.material3.tokens.OutlinedButtonTokens;
import androidx.compose.material3.tokens.TextButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bM\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010y\u001a\u00020zH\u0007¢\u0006\u0002\u0010{J%\u0010y\u001a\u00020z2\n\b\u0002\u0010o\u001a\u0004\u0018\u00010[2\n\b\u0002\u0010`\u001a\u0004\u0018\u00010[H\u0007¢\u0006\u0002\u0010|J\u0010\u0010\u0083\u0001\u001a\u00030\u0084\u0001H\u0007¢\u0006\u0003\u0010\u0085\u0001JC\u0010\u0083\u0001\u001a\u00030\u0084\u00012\n\b\u0002\u0010\u0086\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u0087\u0001H\u0007¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0010\u0010\u0091\u0001\u001a\u00030\u0084\u0001H\u0007¢\u0006\u0003\u0010\u0085\u0001JC\u0010\u0091\u0001\u001a\u00030\u0084\u00012\n\b\u0002\u0010\u0086\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u0087\u0001H\u0007¢\u0006\u0006\b\u0092\u0001\u0010\u008c\u0001J\u0010\u0010\u0095\u0001\u001a\u00030\u0084\u0001H\u0007¢\u0006\u0003\u0010\u0085\u0001JC\u0010\u0095\u0001\u001a\u00030\u0084\u00012\n\b\u0002\u0010\u0086\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u0087\u0001H\u0007¢\u0006\u0006\b\u0096\u0001\u0010\u008c\u0001J\u0010\u0010\u0099\u0001\u001a\u00030\u0084\u0001H\u0007¢\u0006\u0003\u0010\u0085\u0001JC\u0010\u0099\u0001\u001a\u00030\u0084\u00012\n\b\u0002\u0010\u0086\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u0087\u0001H\u0007¢\u0006\u0006\b\u009a\u0001\u0010\u008c\u0001J\u0010\u0010\u009d\u0001\u001a\u00030\u0084\u0001H\u0007¢\u0006\u0003\u0010\u0085\u0001JC\u0010\u009d\u0001\u001a\u00030\u0084\u00012\n\b\u0002\u0010\u0086\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0088\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u0089\u0001\u001a\u00030\u0087\u00012\n\b\u0002\u0010\u008a\u0001\u001a\u00030\u0087\u0001H\u0007¢\u0006\u0006\b\u009e\u0001\u0010\u008c\u0001JJ\u0010¡\u0001\u001a\u00030¢\u00012\t\b\u0002\u0010£\u0001\u001a\u00020\u00052\t\b\u0002\u0010¤\u0001\u001a\u00020\u00052\t\b\u0002\u0010¥\u0001\u001a\u00020\u00052\t\b\u0002\u0010¦\u0001\u001a\u00020\u00052\t\b\u0002\u0010§\u0001\u001a\u00020\u0005H\u0007¢\u0006\u0006\b¨\u0001\u0010©\u0001JJ\u0010ª\u0001\u001a\u00030¢\u00012\t\b\u0002\u0010£\u0001\u001a\u00020\u00052\t\b\u0002\u0010¤\u0001\u001a\u00020\u00052\t\b\u0002\u0010¥\u0001\u001a\u00020\u00052\t\b\u0002\u0010¦\u0001\u001a\u00020\u00052\t\b\u0002\u0010§\u0001\u001a\u00020\u0005H\u0007¢\u0006\u0006\b«\u0001\u0010©\u0001JJ\u0010¬\u0001\u001a\u00030¢\u00012\t\b\u0002\u0010£\u0001\u001a\u00020\u00052\t\b\u0002\u0010¤\u0001\u001a\u00020\u00052\t\b\u0002\u0010¥\u0001\u001a\u00020\u00052\t\b\u0002\u0010¦\u0001\u001a\u00020\u00052\t\b\u0002\u0010§\u0001\u001a\u00020\u0005H\u0007¢\u0006\u0006\b\u00ad\u0001\u0010©\u0001J\u001c\u0010®\u0001\u001a\u00030¯\u00012\n\b\u0002\u0010²\u0001\u001a\u00030³\u0001H\u0007¢\u0006\u0003\u0010´\u0001J\u001b\u0010µ\u0001\u001a\u00020z2\u0007\u0010¶\u0001\u001a\u00020\u0005H\u0007¢\u0006\u0006\b·\u0001\u0010¸\u0001J\u001b\u0010¹\u0001\u001a\u00020\r2\u0007\u0010¶\u0001\u001a\u00020\u0005H\u0007¢\u0006\u0006\bº\u0001\u0010»\u0001J\u001b\u0010¼\u0001\u001a\u00020\u00052\u0007\u0010¶\u0001\u001a\u00020\u0005H\u0007¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u001b\u0010¿\u0001\u001a\u00020\u00052\u0007\u0010¶\u0001\u001a\u00020\u0005H\u0007¢\u0006\u0006\bÀ\u0001\u0010¾\u0001J\u001c\u0010Á\u0001\u001a\u00030Â\u00012\u0007\u0010¶\u0001\u001a\u00020\u0005H\u0007¢\u0006\u0006\bÃ\u0001\u0010Ä\u0001R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0012\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u000fR\u001a\u0010\u0015\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u000fR\u001a\u0010\u0018\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u000fR\u001a\u0010\u001b\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u000fR\u001a\u0010\u001e\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0003\u001a\u0004\b \u0010\u000fR\u001a\u0010!\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u000fR\u0010\u0010$\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010%\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000fR\u0010\u0010'\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0011\u0010(\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u000fR\u0013\u0010*\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b.\u0010,R\u001e\u0010/\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b0\u0010\u0003\u001a\u0004\b1\u0010,R\u001e\u00102\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b3\u0010\u0003\u001a\u0004\b4\u0010,R\u001e\u00105\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b6\u0010\u0003\u001a\u0004\b7\u0010,R\u001e\u00108\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b9\u0010\u0003\u001a\u0004\b:\u0010,R\u0013\u0010;\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b<\u0010,R\u001e\u0010=\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\b>\u0010\u0003\u001a\u0004\b?\u0010,R\u001e\u0010@\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\bA\u0010\u0003\u001a\u0004\bB\u0010,R\u001e\u0010C\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\bD\u0010\u0003\u001a\u0004\bE\u0010,R\u001e\u0010F\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\bG\u0010\u0003\u001a\u0004\bH\u0010,R\u001e\u0010I\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\bJ\u0010\u0003\u001a\u0004\bK\u0010,R\u0013\u0010L\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\bM\u0010,R\u001e\u0010N\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\bO\u0010\u0003\u001a\u0004\bP\u0010,R\u001e\u0010Q\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\bR\u0010\u0003\u001a\u0004\bS\u0010,R\u001e\u0010T\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\bU\u0010\u0003\u001a\u0004\bV\u0010,R\u001e\u0010W\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\u0006\u0012\u0004\bX\u0010\u0003\u001a\u0004\bY\u0010,R\u001a\u0010Z\u001a\u00020[8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u001a\u0010`\u001a\u00020[8GX\u0087\u0004¢\u0006\f\u0012\u0004\ba\u0010]\u001a\u0004\bb\u0010_R\u001a\u0010c\u001a\u00020[8GX\u0087\u0004¢\u0006\f\u0012\u0004\bd\u0010]\u001a\u0004\be\u0010_R\u001a\u0010f\u001a\u00020[8GX\u0087\u0004¢\u0006\f\u0012\u0004\bg\u0010]\u001a\u0004\bh\u0010_R\u001a\u0010i\u001a\u00020[8GX\u0087\u0004¢\u0006\f\u0012\u0004\bj\u0010]\u001a\u0004\bk\u0010_R\u001a\u0010l\u001a\u00020[8GX\u0087\u0004¢\u0006\f\u0012\u0004\bm\u0010]\u001a\u0004\bn\u0010_R\u0011\u0010o\u001a\u00020[8G¢\u0006\u0006\u001a\u0004\bp\u0010_R\u0011\u0010q\u001a\u00020[8G¢\u0006\u0006\u001a\u0004\br\u0010_R\u0011\u0010s\u001a\u00020[8G¢\u0006\u0006\u001a\u0004\bt\u0010_R\u0011\u0010u\u001a\u00020[8G¢\u0006\u0006\u001a\u0004\bv\u0010_R\u0011\u0010w\u001a\u00020[8G¢\u0006\u0006\u001a\u0004\bx\u0010_R!\u0010}\u001a\u00020z*\u00020~8@X\u0080\u0004¢\u0006\u000f\u0012\u0005\b\u007f\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R\u001d\u0010\u008d\u0001\u001a\u00030\u0084\u0001*\u00030\u008e\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001d\u0010\u0093\u0001\u001a\u00030\u0084\u0001*\u00030\u008e\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0094\u0001\u0010\u0090\u0001R\u001d\u0010\u0097\u0001\u001a\u00030\u0084\u0001*\u00030\u008e\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0090\u0001R\u001d\u0010\u009b\u0001\u001a\u00030\u0084\u0001*\u00030\u008e\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u009c\u0001\u0010\u0090\u0001R\u001d\u0010\u009f\u0001\u001a\u00030\u0084\u0001*\u00030\u008e\u00018@X\u0080\u0004¢\u0006\b\u001a\u0006\b \u0001\u0010\u0090\u0001R\u0015\u0010®\u0001\u001a\u00030¯\u00018G¢\u0006\b\u001a\u0006\b°\u0001\u0010±\u0001¨\u0006Å\u0001"}, d2 = {"Landroidx/compose/material3/ButtonDefaults;", "", "<init>", "()V", "ButtonLeadingSpace", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonTrailingSpace", "ButtonWithIconStartpadding", "SmallStartPadding", "SmallEndPadding", "ButtonVerticalPadding", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ButtonWithIconContentPadding", "getButtonWithIconContentPadding", "SmallButtonContentPadding", "getSmallButtonContentPadding$annotations", "getSmallButtonContentPadding", "SmallContentPadding", "getSmallContentPadding$annotations", "getSmallContentPadding", "ExtraSmallContentPadding", "getExtraSmallContentPadding$annotations", "getExtraSmallContentPadding", "MediumContentPadding", "getMediumContentPadding$annotations", "getMediumContentPadding", "LargeContentPadding", "getLargeContentPadding$annotations", "getLargeContentPadding", "ExtraLargeContentPadding", "getExtraLargeContentPadding$annotations", "getExtraLargeContentPadding", "TextButtonHorizontalPadding", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonWithIconHorizontalEndPadding", "TextButtonWithIconContentPadding", "getTextButtonWithIconContentPadding", "MinWidth", "getMinWidth-D9Ej5fM", "()F", "MinHeight", "getMinHeight-D9Ej5fM", "ExtraSmallContainerHeight", "getExtraSmallContainerHeight-D9Ej5fM$annotations", "getExtraSmallContainerHeight-D9Ej5fM", "MediumContainerHeight", "getMediumContainerHeight-D9Ej5fM$annotations", "getMediumContainerHeight-D9Ej5fM", "LargeContainerHeight", "getLargeContainerHeight-D9Ej5fM$annotations", "getLargeContainerHeight-D9Ej5fM", "ExtraLargeContainerHeight", "getExtraLargeContainerHeight-D9Ej5fM$annotations", "getExtraLargeContainerHeight-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "ExtraSmallIconSize", "getExtraSmallIconSize-D9Ej5fM$annotations", "getExtraSmallIconSize-D9Ej5fM", "SmallIconSize", "getSmallIconSize-D9Ej5fM$annotations", "getSmallIconSize-D9Ej5fM", "MediumIconSize", "getMediumIconSize-D9Ej5fM$annotations", "getMediumIconSize-D9Ej5fM", "LargeIconSize", "getLargeIconSize-D9Ej5fM$annotations", "getLargeIconSize-D9Ej5fM", "ExtraLargeIconSize", "getExtraLargeIconSize-D9Ej5fM$annotations", "getExtraLargeIconSize-D9Ej5fM", "IconSpacing", "getIconSpacing-D9Ej5fM", "ExtraSmallIconSpacing", "getExtraSmallIconSpacing-D9Ej5fM$annotations", "getExtraSmallIconSpacing-D9Ej5fM", "MediumIconSpacing", "getMediumIconSpacing-D9Ej5fM$annotations", "getMediumIconSpacing-D9Ej5fM", "LargeIconSpacing", "getLargeIconSpacing-D9Ej5fM$annotations", "getLargeIconSpacing-D9Ej5fM", "ExtraLargeIconSpacing", "getExtraLargeIconSpacing-D9Ej5fM$annotations", "getExtraLargeIconSpacing-D9Ej5fM", "squareShape", "Landroidx/compose/ui/graphics/Shape;", "getSquareShape$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getSquareShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "pressedShape", "getPressedShape$annotations", "getPressedShape", "extraSmallPressedShape", "getExtraSmallPressedShape$annotations", "getExtraSmallPressedShape", "mediumPressedShape", "getMediumPressedShape$annotations", "getMediumPressedShape", "largePressedShape", "getLargePressedShape$annotations", "getLargePressedShape", "extraLargePressedShape", "getExtraLargePressedShape$annotations", "getExtraLargePressedShape", "shape", "getShape", "elevatedShape", "getElevatedShape", "filledTonalShape", "getFilledTonalShape", "outlinedShape", "getOutlinedShape", "textShape", "getTextShape", "shapes", "Landroidx/compose/material3/ButtonShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ButtonShapes;", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonShapes;", "defaultButtonShapes", "Landroidx/compose/material3/Shapes;", "getDefaultButtonShapes$material3$annotations", "(Landroidx/compose/material3/Shapes;)V", "getDefaultButtonShapes$material3", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/ButtonShapes;", "buttonColors", "Landroidx/compose/material3/ButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonColors;", "defaultButtonColors", "Landroidx/compose/material3/ColorScheme;", "getDefaultButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ButtonColors;", "elevatedButtonColors", "elevatedButtonColors-ro_MJ88", "defaultElevatedButtonColors", "getDefaultElevatedButtonColors$material3", "filledTonalButtonColors", "filledTonalButtonColors-ro_MJ88", "defaultFilledTonalButtonColors", "getDefaultFilledTonalButtonColors$material3", "outlinedButtonColors", "outlinedButtonColors-ro_MJ88", "defaultOutlinedButtonColors", "getDefaultOutlinedButtonColors$material3", "textButtonColors", "textButtonColors-ro_MJ88", "defaultTextButtonColors", "getDefaultTextButtonColors$material3", "buttonElevation", "Landroidx/compose/material3/ButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "buttonElevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonElevation;", "elevatedButtonElevation", "elevatedButtonElevation-R_JCAzs", "filledTonalButtonElevation", "filledTonalButtonElevation-R_JCAzs", "outlinedButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedButtonBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "shapesFor", "buttonHeight", "shapesFor-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ButtonShapes;", "contentPaddingFor", "contentPaddingFor-0680j_4", "(F)Landroidx/compose/foundation/layout/PaddingValues;", "iconSizeFor", "iconSizeFor-5rwHm24", "(F)F", "iconSpacingFor", "iconSpacingFor-5rwHm24", "textStyleFor", "Landroidx/compose/ui/text/TextStyle;", "textStyleFor-8Feqmps", "(FLandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ButtonDefaults {
    public static final int $stable = 0;
    private static final float ButtonLeadingSpace;
    private static final float ButtonTrailingSpace;
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ButtonWithIconContentPadding;
    private static final float ButtonWithIconStartpadding;
    private static final PaddingValues ContentPadding;
    private static final float ExtraLargeContainerHeight;
    private static final float ExtraLargeIconSize;
    private static final float ExtraLargeIconSpacing;
    private static final float ExtraSmallContainerHeight;
    private static final float ExtraSmallIconSize;
    private static final float ExtraSmallIconSpacing;
    public static final ButtonDefaults INSTANCE = new ButtonDefaults();
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float LargeContainerHeight;
    private static final float LargeIconSize;
    private static final float LargeIconSpacing;
    private static final float MediumContainerHeight;
    private static final float MediumIconSize;
    private static final float MediumIconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;
    private static final float SmallEndPadding;
    private static final float SmallIconSize;
    private static final float SmallStartPadding;
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;
    private static final PaddingValues TextButtonWithIconContentPadding;
    private static final float TextButtonWithIconHorizontalEndPadding;

    public static /* synthetic */ void getDefaultButtonShapes$material3$annotations(Shapes shapes) {
    }

    /* JADX INFO: renamed from: getExtraLargeContainerHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2837getExtraLargeContainerHeightD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getExtraLargeContentPadding$annotations() {
    }

    /* JADX INFO: renamed from: getExtraLargeIconSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2838getExtraLargeIconSizeD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getExtraLargeIconSpacing-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2839getExtraLargeIconSpacingD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getExtraLargePressedShape$annotations(Composer composer, int i) {
    }

    /* JADX INFO: renamed from: getExtraSmallContainerHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2840getExtraSmallContainerHeightD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getExtraSmallContentPadding$annotations() {
    }

    /* JADX INFO: renamed from: getExtraSmallIconSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2841getExtraSmallIconSizeD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getExtraSmallIconSpacing-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2842getExtraSmallIconSpacingD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getExtraSmallPressedShape$annotations(Composer composer, int i) {
    }

    /* JADX INFO: renamed from: getLargeContainerHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2843getLargeContainerHeightD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getLargeContentPadding$annotations() {
    }

    /* JADX INFO: renamed from: getLargeIconSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2844getLargeIconSizeD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getLargeIconSpacing-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2845getLargeIconSpacingD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getLargePressedShape$annotations(Composer composer, int i) {
    }

    /* JADX INFO: renamed from: getMediumContainerHeight-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2846getMediumContainerHeightD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getMediumContentPadding$annotations() {
    }

    /* JADX INFO: renamed from: getMediumIconSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2847getMediumIconSizeD9Ej5fM$annotations() {
    }

    /* JADX INFO: renamed from: getMediumIconSpacing-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2848getMediumIconSpacingD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getMediumPressedShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getPressedShape$annotations(Composer composer, int i) {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "For binary compatibility")
    public static /* synthetic */ void getSmallButtonContentPadding$annotations() {
    }

    public static /* synthetic */ void getSmallContentPadding$annotations() {
    }

    /* JADX INFO: renamed from: getSmallIconSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m2849getSmallIconSizeD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getSquareShape$annotations(Composer composer, int i) {
    }

    private ButtonDefaults() {
    }

    static {
        float fM5156getLeadingSpaceD9Ej5fM = BaselineButtonTokens.INSTANCE.m5156getLeadingSpaceD9Ej5fM();
        ButtonLeadingSpace = fM5156getLeadingSpaceD9Ej5fM;
        float fM5158getTrailingSpaceD9Ej5fM = BaselineButtonTokens.INSTANCE.m5158getTrailingSpaceD9Ej5fM();
        ButtonTrailingSpace = fM5158getTrailingSpaceD9Ej5fM;
        float f = 16;
        float fM9687constructorimpl = Dp.m9687constructorimpl(f);
        ButtonWithIconStartpadding = fM9687constructorimpl;
        SmallStartPadding = ButtonSmallTokens.INSTANCE.m5178getLeadingSpaceD9Ej5fM();
        SmallEndPadding = ButtonSmallTokens.INSTANCE.m5180getTrailingSpaceD9Ej5fM();
        float fM9687constructorimpl2 = Dp.m9687constructorimpl(8);
        ButtonVerticalPadding = fM9687constructorimpl2;
        PaddingValues paddingValuesM1214PaddingValuesa9UjIt4 = PaddingKt.m1214PaddingValuesa9UjIt4(fM5156getLeadingSpaceD9Ej5fM, fM9687constructorimpl2, fM5158getTrailingSpaceD9Ej5fM, fM9687constructorimpl2);
        ContentPadding = paddingValuesM1214PaddingValuesa9UjIt4;
        ButtonWithIconContentPadding = PaddingKt.m1214PaddingValuesa9UjIt4(fM9687constructorimpl, fM9687constructorimpl2, fM5158getTrailingSpaceD9Ej5fM, fM9687constructorimpl2);
        float fM9687constructorimpl3 = Dp.m9687constructorimpl(12);
        TextButtonHorizontalPadding = fM9687constructorimpl3;
        TextButtonContentPadding = PaddingKt.m1214PaddingValuesa9UjIt4(fM9687constructorimpl3, paddingValuesM1214PaddingValuesa9UjIt4.getTop(), fM9687constructorimpl3, paddingValuesM1214PaddingValuesa9UjIt4.getBottom());
        float fM9687constructorimpl4 = Dp.m9687constructorimpl(f);
        TextButtonWithIconHorizontalEndPadding = fM9687constructorimpl4;
        TextButtonWithIconContentPadding = PaddingKt.m1214PaddingValuesa9UjIt4(fM9687constructorimpl3, paddingValuesM1214PaddingValuesa9UjIt4.getTop(), fM9687constructorimpl4, paddingValuesM1214PaddingValuesa9UjIt4.getBottom());
        MinWidth = Dp.m9687constructorimpl(58);
        MinHeight = ButtonSmallTokens.INSTANCE.m5175getContainerHeightD9Ej5fM();
        ExtraSmallContainerHeight = ButtonXSmallTokens.INSTANCE.m5187getContainerHeightD9Ej5fM();
        MediumContainerHeight = ButtonMediumTokens.INSTANCE.m5169getContainerHeightD9Ej5fM();
        LargeContainerHeight = ButtonLargeTokens.INSTANCE.m5163getContainerHeightD9Ej5fM();
        ExtraLargeContainerHeight = ButtonXLargeTokens.INSTANCE.m5181getContainerHeightD9Ej5fM();
        IconSize = Dp.m9687constructorimpl(18);
        ExtraSmallIconSize = ButtonXSmallTokens.INSTANCE.m5189getIconSizeD9Ej5fM();
        SmallIconSize = ButtonSmallTokens.INSTANCE.m5177getIconSizeD9Ej5fM();
        MediumIconSize = ButtonMediumTokens.INSTANCE.m5171getIconSizeD9Ej5fM();
        LargeIconSize = ButtonLargeTokens.INSTANCE.m5165getIconSizeD9Ej5fM();
        ExtraLargeIconSize = ButtonXLargeTokens.INSTANCE.m5183getIconSizeD9Ej5fM();
        IconSpacing = ButtonSmallTokens.INSTANCE.m5176getIconLabelSpaceD9Ej5fM();
        ExtraSmallIconSpacing = Dp.m9687constructorimpl(4);
        MediumIconSpacing = ButtonMediumTokens.INSTANCE.m5170getIconLabelSpaceD9Ej5fM();
        LargeIconSpacing = ButtonLargeTokens.INSTANCE.m5164getIconLabelSpaceD9Ej5fM();
        ExtraLargeIconSpacing = ButtonXLargeTokens.INSTANCE.m5182getIconLabelSpaceD9Ej5fM();
    }

    public final PaddingValues getContentPadding() {
        return ContentPadding;
    }

    public final PaddingValues getButtonWithIconContentPadding() {
        return ButtonWithIconContentPadding;
    }

    public final /* synthetic */ PaddingValues getSmallButtonContentPadding() {
        float f = SmallStartPadding;
        float f2 = ButtonVerticalPadding;
        return PaddingKt.m1214PaddingValuesa9UjIt4(f, f2, SmallEndPadding, f2);
    }

    public final PaddingValues getSmallContentPadding() {
        float f = SmallStartPadding;
        float f2 = ButtonVerticalPadding;
        return PaddingKt.m1214PaddingValuesa9UjIt4(f, f2, SmallEndPadding, f2);
    }

    public final PaddingValues getMediumContentPadding() {
        float f = 16;
        return PaddingKt.m1214PaddingValuesa9UjIt4(ButtonMediumTokens.INSTANCE.m5172getLeadingSpaceD9Ej5fM(), Dp.m9687constructorimpl(f), ButtonMediumTokens.INSTANCE.m5174getTrailingSpaceD9Ej5fM(), Dp.m9687constructorimpl(f));
    }

    public final PaddingValues getLargeContentPadding() {
        float f = 32;
        return PaddingKt.m1214PaddingValuesa9UjIt4(ButtonLargeTokens.INSTANCE.m5166getLeadingSpaceD9Ej5fM(), Dp.m9687constructorimpl(f), ButtonLargeTokens.INSTANCE.m5168getTrailingSpaceD9Ej5fM(), Dp.m9687constructorimpl(f));
    }

    public final PaddingValues getExtraLargeContentPadding() {
        float f = 48;
        return PaddingKt.m1214PaddingValuesa9UjIt4(ButtonXLargeTokens.INSTANCE.m5184getLeadingSpaceD9Ej5fM(), Dp.m9687constructorimpl(f), ButtonXLargeTokens.INSTANCE.m5186getTrailingSpaceD9Ej5fM(), Dp.m9687constructorimpl(f));
    }

    public final PaddingValues getTextButtonContentPadding() {
        return TextButtonContentPadding;
    }

    public final PaddingValues getTextButtonWithIconContentPadding() {
        return TextButtonWithIconContentPadding;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m2872getMinWidthD9Ej5fM() {
        return MinWidth;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m2871getMinHeightD9Ej5fM() {
        return MinHeight;
    }

    /* JADX INFO: renamed from: getExtraSmallContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2860getExtraSmallContainerHeightD9Ej5fM() {
        return ExtraSmallContainerHeight;
    }

    /* JADX INFO: renamed from: getMediumContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2868getMediumContainerHeightD9Ej5fM() {
        return MediumContainerHeight;
    }

    /* JADX INFO: renamed from: getLargeContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2865getLargeContainerHeightD9Ej5fM() {
        return LargeContainerHeight;
    }

    /* JADX INFO: renamed from: getExtraLargeContainerHeight-D9Ej5fM, reason: not valid java name */
    public final float m2857getExtraLargeContainerHeightD9Ej5fM() {
        return ExtraLargeContainerHeight;
    }

    /* JADX INFO: renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2863getIconSizeD9Ej5fM() {
        return IconSize;
    }

    /* JADX INFO: renamed from: getExtraSmallIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2861getExtraSmallIconSizeD9Ej5fM() {
        return ExtraSmallIconSize;
    }

    /* JADX INFO: renamed from: getSmallIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2873getSmallIconSizeD9Ej5fM() {
        return SmallIconSize;
    }

    /* JADX INFO: renamed from: getMediumIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2869getMediumIconSizeD9Ej5fM() {
        return MediumIconSize;
    }

    /* JADX INFO: renamed from: getLargeIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2866getLargeIconSizeD9Ej5fM() {
        return LargeIconSize;
    }

    /* JADX INFO: renamed from: getExtraLargeIconSize-D9Ej5fM, reason: not valid java name */
    public final float m2858getExtraLargeIconSizeD9Ej5fM() {
        return ExtraLargeIconSize;
    }

    /* JADX INFO: renamed from: getIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m2864getIconSpacingD9Ej5fM() {
        return IconSpacing;
    }

    /* JADX INFO: renamed from: getExtraSmallIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m2862getExtraSmallIconSpacingD9Ej5fM() {
        return ExtraSmallIconSpacing;
    }

    /* JADX INFO: renamed from: getMediumIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m2870getMediumIconSpacingD9Ej5fM() {
        return MediumIconSpacing;
    }

    /* JADX INFO: renamed from: getLargeIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m2867getLargeIconSpacingD9Ej5fM() {
        return LargeIconSpacing;
    }

    /* JADX INFO: renamed from: getExtraLargeIconSpacing-D9Ej5fM, reason: not valid java name */
    public final float m2859getExtraLargeIconSpacingD9Ej5fM() {
        return ExtraLargeIconSpacing;
    }

    public final Shape getSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -61545427, "C(<get-squareShape>)1108@53848L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-61545427, i, -1, "androidx.compose.material3.ButtonDefaults.<get-squareShape> (Button.kt:1108)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getPressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1599095131, "C(<get-pressedShape>)1113@54037L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1599095131, i, -1, "androidx.compose.material3.ButtonDefaults.<get-pressedShape> (Button.kt:1113)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallPressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1220334917, "C(<get-extraSmallPressedShape>)1118@54241L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1220334917, i, -1, "androidx.compose.material3.ButtonDefaults.<get-extraSmallPressedShape> (Button.kt:1118)");
        }
        Shape value = ShapesKt.getValue(ButtonXSmallTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumPressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 955096581, "C(<get-mediumPressedShape>)1123@54436L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(955096581, i, -1, "androidx.compose.material3.ButtonDefaults.<get-mediumPressedShape> (Button.kt:1123)");
        }
        Shape value = ShapesKt.getValue(ButtonMediumTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargePressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1613862463, "C(<get-largePressedShape>)1128@54628L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1613862463, i, -1, "androidx.compose.material3.ButtonDefaults.<get-largePressedShape> (Button.kt:1128)");
        }
        Shape value = ShapesKt.getValue(ButtonLargeTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargePressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -339609659, "C(<get-extraLargePressedShape>)1133@54832L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-339609659, i, -1, "androidx.compose.material3.ButtonDefaults.<get-extraLargePressedShape> (Button.kt:1133)");
        }
        Shape value = ShapesKt.getValue(ButtonXLargeTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1234923021, "C(<get-shape>)1137@54965L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1234923021, i, -1, "androidx.compose.material3.ButtonDefaults.<get-shape> (Button.kt:1137)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getElevatedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2143958791, "C(<get-elevatedShape>)1141@55116L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2143958791, i, -1, "androidx.compose.material3.ButtonDefaults.<get-elevatedShape> (Button.kt:1141)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getFilledTonalShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -886584987, "C(<get-filledTonalShape>)1145@55273L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-886584987, i, -1, "androidx.compose.material3.ButtonDefaults.<get-filledTonalShape> (Button.kt:1145)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2045213065, "C(<get-outlinedShape>)1149@55424L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2045213065, i, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedShape> (Button.kt:1149)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getTextShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -349121587, "C(<get-textShape>)1153@55566L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-349121587, i, -1, "androidx.compose.material3.ButtonDefaults.<get-textShape> (Button.kt:1153)");
        }
        Shape value = ShapesKt.getValue(ButtonSmallTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final ButtonShapes shapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1554265461, "C(shapes)1161@55787L6:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1554265461, i, -1, "androidx.compose.material3.ButtonDefaults.shapes (Button.kt:1161)");
        }
        ButtonShapes defaultButtonShapes$material3 = getDefaultButtonShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultButtonShapes$material3;
    }

    public final ButtonShapes shapes(Shape shape, Shape shape2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1854268625, "C(shapes)N(shape,pressedShape)1173@56250L6:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = null;
        }
        if ((i2 & 2) != 0) {
            shape2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1854268625, i, -1, "androidx.compose.material3.ButtonDefaults.shapes (Button.kt:1173)");
        }
        ButtonShapes buttonShapesCopy = getDefaultButtonShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6)).copy(shape, shape2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonShapesCopy;
    }

    public final ButtonShapes getDefaultButtonShapes$material3(Shapes shapes) {
        ButtonShapes defaultButtonShapesCached = shapes.getDefaultButtonShapesCached();
        if (defaultButtonShapesCached != null) {
            return defaultButtonShapesCached;
        }
        ButtonShapes buttonShapes = new ButtonShapes(ShapesKt.fromToken(shapes, ButtonSmallTokens.INSTANCE.getContainerShapeRound()), ShapesKt.fromToken(shapes, ButtonSmallTokens.INSTANCE.getPressedContainerShape()));
        shapes.setDefaultButtonShapesCached$material3(buttonShapes);
        return buttonShapes;
    }

    public final ButtonColors buttonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1449248637, "C(buttonColors)1190@56983L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1449248637, i, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:1190)");
        }
        ButtonColors defaultButtonColors$material3 = getDefaultButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultButtonColors$material3;
    }

    /* JADX INFO: renamed from: buttonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m2850buttonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -339300779, "C(buttonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)1208@57789L11:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6850getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM6850getUnspecified0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-339300779, i, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:1208)");
        }
        ButtonColors buttonColorsM2832copyjRlVdoo = getDefaultButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2832copyjRlVdoo(j5, jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM2832copyjRlVdoo;
    }

    public final ButtonColors getDefaultButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors defaultButtonColorsCached = colorScheme.getDefaultButtonColorsCached();
        if (defaultButtonColorsCached != null) {
            return defaultButtonColorsCached;
        }
        ButtonColors buttonColors = new ButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getLabelTextColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getDisabledContainerColor()), FilledButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getDisabledLabelTextColor()), FilledButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultButtonColorsCached$material3(buttonColors);
        return buttonColors;
    }

    public final ButtonColors elevatedButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2025043443, "C(elevatedButtonColors)1235@59107L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2025043443, i, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:1235)");
        }
        ButtonColors defaultElevatedButtonColors$material3 = getDefaultElevatedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultElevatedButtonColors$material3;
    }

    /* JADX INFO: renamed from: elevatedButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m2853elevatedButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1507908383, "C(elevatedButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)1253@59966L11:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6850getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM6850getUnspecified0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1507908383, i, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:1253)");
        }
        ButtonColors buttonColorsM2832copyjRlVdoo = getDefaultElevatedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2832copyjRlVdoo(j5, jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM2832copyjRlVdoo;
    }

    public final ButtonColors getDefaultElevatedButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors defaultElevatedButtonColorsCached = colorScheme.getDefaultElevatedButtonColorsCached();
        if (defaultElevatedButtonColorsCached != null) {
            return defaultElevatedButtonColorsCached;
        }
        ButtonColors buttonColors = new ButtonColors(ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getLabelTextColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getDisabledContainerColor()), ElevatedButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getDisabledLabelTextColor()), ElevatedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultElevatedButtonColorsCached$material3(buttonColors);
        return buttonColors;
    }

    public final ButtonColors filledTonalButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 824987837, "C(filledTonalButtonColors)1281@61338L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(824987837, i, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:1281)");
        }
        ButtonColors defaultFilledTonalButtonColors$material3 = getDefaultFilledTonalButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledTonalButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledTonalButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m2855filledTonalButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1670757653, "C(filledTonalButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)1300@62227L11:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6850getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM6850getUnspecified0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1670757653, i, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:1300)");
        }
        ButtonColors buttonColorsM2832copyjRlVdoo = getDefaultFilledTonalButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2832copyjRlVdoo(j5, jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM2832copyjRlVdoo;
    }

    public final ButtonColors getDefaultFilledTonalButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors defaultFilledTonalButtonColorsCached = colorScheme.getDefaultFilledTonalButtonColorsCached();
        if (defaultFilledTonalButtonColorsCached != null) {
            return defaultFilledTonalButtonColorsCached;
        }
        ButtonColors buttonColors = new ButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledTonalButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTonalButtonTokens.INSTANCE.getLabelTextColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalButtonTokens.INSTANCE.getDisabledContainerColor()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalButtonTokens.INSTANCE.getDisabledLabelTextColor()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultFilledTonalButtonColorsCached$material3(buttonColors);
        return buttonColors;
    }

    public final ButtonColors outlinedButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1344886725, "C(outlinedButtonColors)1327@63619L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1344886725, i, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:1327)");
        }
        ButtonColors defaultOutlinedButtonColors$material3 = getDefaultOutlinedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultOutlinedButtonColors$material3;
    }

    /* JADX INFO: renamed from: outlinedButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m2876outlinedButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1778526249, "C(outlinedButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)1345@64478L11:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6850getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM6850getUnspecified0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1778526249, i, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:1345)");
        }
        ButtonColors buttonColorsM2832copyjRlVdoo = getDefaultOutlinedButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2832copyjRlVdoo(j5, jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM2832copyjRlVdoo;
    }

    public final ButtonColors getDefaultOutlinedButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors defaultOutlinedButtonColorsCached = colorScheme.getDefaultOutlinedButtonColorsCached();
        if (defaultOutlinedButtonColorsCached != null) {
            return defaultOutlinedButtonColorsCached;
        }
        ButtonColors buttonColors = new ButtonColors(Color.INSTANCE.m6849getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, OutlinedButtonTokens.INSTANCE.getLabelTextColor()), Color.INSTANCE.m6849getTransparent0d7_KjU(), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedButtonTokens.INSTANCE.getDisabledLabelTextColor()), OutlinedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultOutlinedButtonColorsCached$material3(buttonColors);
        return buttonColors;
    }

    public final ButtonColors textButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1880341584, "C(textButtonColors)1370@65644L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1880341584, i, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:1370)");
        }
        ButtonColors defaultTextButtonColors$material3 = getDefaultTextButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultTextButtonColors$material3;
    }

    /* JADX INFO: renamed from: textButtonColors-ro_MJ88, reason: not valid java name */
    public final ButtonColors m2878textButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1402274782, "C(textButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)1388@66474L11:Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6850getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM6850getUnspecified0d7_KjU = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1402274782, i, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:1388)");
        }
        ButtonColors buttonColorsM2832copyjRlVdoo = getDefaultTextButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m2832copyjRlVdoo(j5, jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonColorsM2832copyjRlVdoo;
    }

    public final ButtonColors getDefaultTextButtonColors$material3(ColorScheme colorScheme) {
        ButtonColors defaultTextButtonColorsCached = colorScheme.getDefaultTextButtonColorsCached();
        if (defaultTextButtonColorsCached != null) {
            return defaultTextButtonColorsCached;
        }
        ButtonColors buttonColors = new ButtonColors(Color.INSTANCE.m6849getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, ColorSchemeKeyTokens.Primary), Color.INSTANCE.m6849getTransparent0d7_KjU(), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, TextButtonTokens.INSTANCE.getDisabledLabelColor()), TextButtonTokens.INSTANCE.getDisabledLabelOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultTextButtonColorsCached$material3(buttonColors);
        return buttonColors;
    }

    /* JADX INFO: renamed from: buttonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m2851buttonElevationR_JCAzs(float f, float f2, float f3, float f4, float f5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1827791191, "C(buttonElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FilledButtonTokens.INSTANCE.m5433getContainerElevationD9Ej5fM();
        }
        float f6 = f;
        if ((i2 & 2) != 0) {
            f2 = FilledButtonTokens.INSTANCE.m5437getPressedContainerElevationD9Ej5fM();
        }
        float f7 = f2;
        if ((i2 & 4) != 0) {
            f3 = FilledButtonTokens.INSTANCE.m5435getFocusedContainerElevationD9Ej5fM();
        }
        float f8 = f3;
        if ((i2 & 8) != 0) {
            f4 = FilledButtonTokens.INSTANCE.m5436getHoveredContainerElevationD9Ej5fM();
        }
        float f9 = f4;
        if ((i2 & 16) != 0) {
            f5 = FilledButtonTokens.INSTANCE.m5434getDisabledContainerElevationD9Ej5fM();
        }
        float f10 = f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1827791191, i, -1, "androidx.compose.material3.ButtonDefaults.buttonElevation (Button.kt:1429)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(f6, f7, f8, f9, f10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonElevation;
    }

    /* JADX INFO: renamed from: elevatedButtonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m2854elevatedButtonElevationR_JCAzs(float f, float f2, float f3, float f4, float f5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1065482445, "C(elevatedButtonElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = ElevatedButtonTokens.INSTANCE.m5351getContainerElevationD9Ej5fM();
        }
        float f6 = f;
        if ((i2 & 2) != 0) {
            f2 = ElevatedButtonTokens.INSTANCE.m5355getPressedContainerElevationD9Ej5fM();
        }
        float f7 = f2;
        if ((i2 & 4) != 0) {
            f3 = ElevatedButtonTokens.INSTANCE.m5353getFocusedContainerElevationD9Ej5fM();
        }
        float f8 = f3;
        if ((i2 & 8) != 0) {
            f4 = ElevatedButtonTokens.INSTANCE.m5354getHoveredContainerElevationD9Ej5fM();
        }
        float f9 = f4;
        if ((i2 & 16) != 0) {
            f5 = ElevatedButtonTokens.INSTANCE.m5352getDisabledContainerElevationD9Ej5fM();
        }
        float f10 = f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1065482445, i, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonElevation (Button.kt:1456)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(f6, f7, f8, f9, f10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonElevation;
    }

    /* JADX INFO: renamed from: filledTonalButtonElevation-R_JCAzs, reason: not valid java name */
    public final ButtonElevation m2856filledTonalButtonElevationR_JCAzs(float f, float f2, float f3, float f4, float f5, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 5982871, "C(filledTonalButtonElevation)N(defaultElevation:c#ui.unit.Dp,pressedElevation:c#ui.unit.Dp,focusedElevation:c#ui.unit.Dp,hoveredElevation:c#ui.unit.Dp,disabledElevation:c#ui.unit.Dp):Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            f = FilledTonalButtonTokens.INSTANCE.m5451getContainerElevationD9Ej5fM();
        }
        float f6 = f;
        if ((i2 & 2) != 0) {
            f2 = FilledTonalButtonTokens.INSTANCE.m5457getPressedContainerElevationD9Ej5fM();
        }
        float f7 = f2;
        if ((i2 & 4) != 0) {
            f3 = FilledTonalButtonTokens.INSTANCE.m5454getFocusContainerElevationD9Ej5fM();
        }
        float f8 = f3;
        if ((i2 & 8) != 0) {
            f4 = FilledTonalButtonTokens.INSTANCE.m5455getHoverContainerElevationD9Ej5fM();
        }
        float f9 = f4;
        if ((i2 & 16) != 0) {
            f5 = Dp.m9687constructorimpl(0);
        }
        float f10 = f5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(5982871, i, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonElevation (Button.kt:1486)");
        }
        ButtonElevation buttonElevation = new ButtonElevation(f6, f7, f8, f9, f10, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonElevation;
    }

    @Deprecated(message = "Please use the version that takes an `enabled` param to get the `BorderStroke` with the correct opacity", replaceWith = @ReplaceWith(expression = "outlinedButtonBorder(enabled)", imports = {}))
    public final BorderStroke getOutlinedButtonBorder(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -563957672, "C(<get-outlinedButtonBorder>)1506@72340L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-563957672, i, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedButtonBorder> (Button.kt:1504)");
        }
        BorderStroke borderStrokeM622BorderStrokecXLIe8U = BorderStrokeKt.m622BorderStrokecXLIe8U(ButtonSmallTokens.INSTANCE.m5179getOutlinedOutlineWidthD9Ej5fM(), ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStrokeM622BorderStrokecXLIe8U;
    }

    public final BorderStroke outlinedButtonBorder(boolean z, Composer composer, int i, int i2) {
        long jM6813copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -626854767, "C(outlinedButtonBorder)N(enabled):Button.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            z = true;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-626854767, i, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonBorder (Button.kt:1516)");
        }
        float fM5179getOutlinedOutlineWidthD9Ej5fM = ButtonSmallTokens.INSTANCE.m5179getOutlinedOutlineWidthD9Ej5fM();
        if (z) {
            composer.startReplaceGroup(-112362814);
            ComposerKt.sourceInformation(composer, "1520@72770L5");
            jM6813copywmQWz5c$default = ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), composer, 6);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-112275208);
            ComposerKt.sourceInformation(composer, "1522@72855L5");
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), composer, 6), OutlinedButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            composer.endReplaceGroup();
        }
        BorderStroke borderStrokeM622BorderStrokecXLIe8U = BorderStrokeKt.m622BorderStrokecXLIe8U(fM5179getOutlinedOutlineWidthD9Ej5fM, jM6813copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStrokeM622BorderStrokecXLIe8U;
    }

    /* JADX INFO: renamed from: shapesFor-8Feqmps, reason: not valid java name */
    public final ButtonShapes m2877shapesFor8Feqmps(float f, Composer composer, int i) {
        Composer composer2;
        ButtonShapes buttonShapesShapes;
        ComposerKt.sourceInformationMarkerStart(composer, 1262605294, "C(shapesFor)N(buttonHeight:c#ui.unit.Dp):Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1262605294, i, -1, "androidx.compose.material3.ButtonDefaults.shapesFor (Button.kt:1535)");
        }
        float f2 = ExtraSmallContainerHeight;
        float f3 = MinHeight;
        float f4 = MediumContainerHeight;
        float f5 = LargeContainerHeight;
        float f6 = ExtraLargeContainerHeight;
        float f7 = 2;
        if (Dp.m9686compareTo0680j_4(f, Dp.m9687constructorimpl(Dp.m9687constructorimpl(f2 + f3) / f7)) <= 0) {
            composer.startReplaceGroup(-2112044758);
            ComposerKt.sourceInformation(composer, "1543@73599L5,1543@73621L22,1543@73584L60");
            int i2 = (i >> 3) & 14;
            composer2 = composer;
            buttonShapesShapes = shapes(getShape(composer, i2), getExtraSmallPressedShape(composer, i2), composer2, (i << 3) & 896, 0);
            composer.endReplaceGroup();
        } else if (Dp.m9686compareTo0680j_4(f, Dp.m9687constructorimpl(Dp.m9687constructorimpl(f3 + f4) / f7)) <= 0) {
            composer.startReplaceGroup(-2112040810);
            ComposerKt.sourceInformation(composer, "1544@73709L8");
            buttonShapesShapes = shapes(composer, (i >> 3) & 14);
            composer.endReplaceGroup();
            composer2 = composer;
        } else if (Dp.m9686compareTo0680j_4(f, Dp.m9687constructorimpl(Dp.m9687constructorimpl(f4 + f5) / f7)) <= 0) {
            composer.startReplaceGroup(-2112037914);
            ComposerKt.sourceInformation(composer, "1546@73813L5,1546@73835L18,1546@73798L56");
            int i3 = (i >> 3) & 14;
            composer2 = composer;
            buttonShapesShapes = shapes(getShape(composer, i3), getMediumPressedShape(composer, i3), composer2, (i << 3) & 896, 0);
            composer.endReplaceGroup();
        } else if (Dp.m9686compareTo0680j_4(f, Dp.m9687constructorimpl(Dp.m9687constructorimpl(f5 + f6) / f7)) <= 0) {
            composer.startReplaceGroup(-2112033531);
            ComposerKt.sourceInformation(composer, "1548@73950L5,1548@73972L17,1548@73935L55");
            int i4 = (i >> 3) & 14;
            composer2 = composer;
            buttonShapesShapes = shapes(getShape(composer, i4), getLargePressedShape(composer, i4), composer2, (i << 3) & 896, 0);
            composer2.endReplaceGroup();
        } else {
            composer2 = composer;
            composer2.startReplaceGroup(-2112031094);
            ComposerKt.sourceInformation(composer2, "1549@74026L5,1549@74048L22,1549@74011L60");
            int i5 = (i >> 3) & 14;
            buttonShapesShapes = shapes(getShape(composer2, i5), getExtraLargePressedShape(composer2, i5), composer2, (i << 3) & 896, 0);
            composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        return buttonShapesShapes;
    }

    /* JADX INFO: renamed from: contentPaddingFor-0680j_4, reason: not valid java name */
    public final PaddingValues m2852contentPaddingFor0680j_4(float buttonHeight) {
        float f = MinHeight;
        float f2 = MediumContainerHeight;
        float f3 = LargeContainerHeight;
        float f4 = ExtraLargeContainerHeight;
        if (Dp.m9686compareTo0680j_4(buttonHeight, f) < 0) {
            return getExtraSmallContentPadding();
        }
        if (Dp.m9686compareTo0680j_4(buttonHeight, f2) < 0) {
            return getSmallContentPadding();
        }
        if (Dp.m9686compareTo0680j_4(buttonHeight, f3) < 0) {
            return getMediumContentPadding();
        }
        return Dp.m9686compareTo0680j_4(buttonHeight, f4) < 0 ? getLargeContentPadding() : getExtraLargeContentPadding();
    }

    /* JADX INFO: renamed from: iconSizeFor-5rwHm24, reason: not valid java name */
    public final float m2874iconSizeFor5rwHm24(float buttonHeight) {
        float f = MinHeight;
        float f2 = MediumContainerHeight;
        float f3 = LargeContainerHeight;
        float f4 = ExtraLargeContainerHeight;
        if (Dp.m9686compareTo0680j_4(buttonHeight, f) < 0) {
            return ExtraSmallIconSize;
        }
        if (Dp.m9686compareTo0680j_4(buttonHeight, f2) < 0) {
            return SmallIconSize;
        }
        if (Dp.m9686compareTo0680j_4(buttonHeight, f3) < 0) {
            return MediumIconSize;
        }
        return Dp.m9686compareTo0680j_4(buttonHeight, f4) < 0 ? LargeIconSize : ExtraLargeIconSize;
    }

    /* JADX INFO: renamed from: iconSpacingFor-5rwHm24, reason: not valid java name */
    public final float m2875iconSpacingFor5rwHm24(float buttonHeight) {
        float f = MinHeight;
        float f2 = MediumContainerHeight;
        float f3 = LargeContainerHeight;
        float f4 = ExtraLargeContainerHeight;
        if (Dp.m9686compareTo0680j_4(buttonHeight, f) < 0) {
            return ExtraSmallIconSpacing;
        }
        if (Dp.m9686compareTo0680j_4(buttonHeight, f2) < 0) {
            return IconSpacing;
        }
        if (Dp.m9686compareTo0680j_4(buttonHeight, f3) < 0) {
            return MediumIconSpacing;
        }
        return Dp.m9686compareTo0680j_4(buttonHeight, f4) < 0 ? LargeIconSpacing : ExtraLargeIconSpacing;
    }

    /* JADX INFO: renamed from: textStyleFor-8Feqmps, reason: not valid java name */
    public final TextStyle m2879textStyleFor8Feqmps(float f, Composer composer, int i) {
        TextStyle headlineLarge;
        ComposerKt.sourceInformationMarkerStart(composer, -2034166092, "C(textStyleFor)N(buttonHeight:c#ui.unit.Dp):Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2034166092, i, -1, "androidx.compose.material3.ButtonDefaults.textStyleFor (Button.kt:1620)");
        }
        float f2 = MediumContainerHeight;
        float f3 = LargeContainerHeight;
        float f4 = ExtraLargeContainerHeight;
        if (Dp.m9686compareTo0680j_4(f, f2) < 0) {
            composer.startReplaceGroup(-623485538);
            ComposerKt.sourceInformation(composer, "1625@76789L10");
            headlineLarge = MaterialTheme.INSTANCE.getTypography(composer, 6).getLabelLarge();
            composer.endReplaceGroup();
        } else if (Dp.m9686compareTo0680j_4(f, f3) < 0) {
            composer.startReplaceGroup(-623483041);
            ComposerKt.sourceInformation(composer, "1626@76867L10");
            headlineLarge = MaterialTheme.INSTANCE.getTypography(composer, 6).getTitleMedium();
            composer.endReplaceGroup();
        } else if (Dp.m9686compareTo0680j_4(f, f4) < 0) {
            composer.startReplaceGroup(-623480479);
            ComposerKt.sourceInformation(composer, "1627@76947L10");
            headlineLarge = MaterialTheme.INSTANCE.getTypography(composer, 6).getHeadlineSmall();
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(-623478591);
            ComposerKt.sourceInformation(composer, "1628@77006L10");
            headlineLarge = MaterialTheme.INSTANCE.getTypography(composer, 6).getHeadlineLarge();
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return headlineLarge;
    }

    public final PaddingValues getExtraSmallContentPadding() {
        float f = 12;
        float f2 = 6;
        return PaddingKt.m1214PaddingValuesa9UjIt4(Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2));
    }
}
