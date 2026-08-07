package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.LargeIconButtonTokens;
import androidx.compose.material3.tokens.MediumIconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.material3.tokens.SmallIconButtonTokens;
import androidx.compose.material3.tokens.StandardIconButtonTokens;
import androidx.compose.material3.tokens.XLargeIconButtonTokens;
import androidx.compose.material3.tokens.XSmallIconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: IconButtonDefaults.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\bS\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002Ú\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0014\u0010\rJ\u0011\u0010\u0015\u001a\u00020\u0005*\u00020\u000fH\u0000¢\u0006\u0002\b\u0016J\r\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u0018*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010!\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b\"\u0010\u001dJ\u0011\u0010#\u001a\u00020\u0018*\u00020\u000fH\u0000¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010%\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b&\u0010\rJ\r\u0010*\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010*\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b+\u0010\u001dJ\r\u0010/\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010/\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b0\u0010\rJ\r\u00103\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u00103\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b4\u0010\u001dJ\r\u00107\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u00107\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b8\u0010\rJ\u001b\u00109\u001a\u00020\u0005*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\b:\u0010\u0012J\r\u0010;\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J7\u0010;\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\bH\u0007¢\u0006\u0004\b<\u0010\rJ\u0011\u0010=\u001a\u00020\u0005*\u00020\u000fH\u0000¢\u0006\u0002\b>J\r\u0010?\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010?\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\b@\u0010\u001dJ\u001b\u0010A\u001a\u00020\u0018*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0000¢\u0006\u0004\bB\u0010 J\r\u0010C\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019JK\u0010C\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\bH\u0007¢\u0006\u0004\bD\u0010\u001dJ\u0011\u0010E\u001a\u00020\u0018*\u00020\u000fH\u0000¢\u0006\u0002\bFJ\u001f\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0007¢\u0006\u0002\u0010LJ\u001f\u0010M\u001a\u0004\u0018\u00010H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020JH\u0007¢\u0006\u0002\u0010LJ\u0015\u0010N\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0007¢\u0006\u0002\u0010OJ\u0015\u0010P\u001a\u00020H2\u0006\u0010I\u001a\u00020JH\u0007¢\u0006\u0002\u0010OJ*\u0010¥\u0001\u001a\u00030¦\u00012\u000b\b\u0002\u0010§\u0001\u001a\u0004\u0018\u00010R2\u000b\b\u0002\u0010¨\u0001\u001a\u0004\u0018\u00010RH\u0007¢\u0006\u0003\u0010©\u0001J\u0010\u0010¥\u0001\u001a\u00030¦\u0001H\u0007¢\u0006\u0003\u0010ª\u0001J7\u0010±\u0001\u001a\u00030²\u00012\u000b\b\u0002\u0010§\u0001\u001a\u0004\u0018\u00010R2\u000b\b\u0002\u0010¨\u0001\u001a\u0004\u0018\u00010R2\u000b\b\u0002\u0010³\u0001\u001a\u0004\u0018\u00010RH\u0007¢\u0006\u0003\u0010´\u0001J\u0010\u0010±\u0001\u001a\u00030²\u0001H\u0007¢\u0006\u0003\u0010µ\u0001J\u001f\u0010Ì\u0001\u001a\u00030Í\u00012\n\b\u0002\u0010Î\u0001\u001a\u00030Ï\u0001H\u0007¢\u0006\u0006\bÐ\u0001\u0010Ñ\u0001J\u001f\u0010Ò\u0001\u001a\u00030Í\u00012\n\b\u0002\u0010Î\u0001\u001a\u00030Ï\u0001H\u0007¢\u0006\u0006\bÓ\u0001\u0010Ñ\u0001J\u001f\u0010Ô\u0001\u001a\u00030Í\u00012\n\b\u0002\u0010Î\u0001\u001a\u00030Ï\u0001H\u0007¢\u0006\u0006\bÕ\u0001\u0010Ñ\u0001J\u001f\u0010Ö\u0001\u001a\u00030Í\u00012\n\b\u0002\u0010Î\u0001\u001a\u00030Ï\u0001H\u0007¢\u0006\u0006\b×\u0001\u0010Ñ\u0001J\u001f\u0010Ø\u0001\u001a\u00030Í\u00012\n\b\u0002\u0010Î\u0001\u001a\u00030Ï\u0001H\u0007¢\u0006\u0006\bÙ\u0001\u0010Ñ\u0001R\u0018\u0010'\u001a\u00020\u0005*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0018\u0010,\u001a\u00020\u0018*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0018\u00101\u001a\u00020\u0005*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b2\u0010)R\u0018\u00105\u001a\u00020\u0018*\u00020\u000f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b6\u0010.R\u0011\u0010Q\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bS\u0010TR\u0011\u0010U\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0011\u0010W\u001a\u00020R8G¢\u0006\u0006\u001a\u0004\bX\u0010TR\u001a\u0010Y\u001a\u00020R8GX\u0087\u0004¢\u0006\f\u0012\u0004\bZ\u0010[\u001a\u0004\b\\\u0010TR\u001a\u0010]\u001a\u00020R8GX\u0087\u0004¢\u0006\f\u0012\u0004\b^\u0010[\u001a\u0004\b_\u0010TR\u001a\u0010`\u001a\u00020R8GX\u0087\u0004¢\u0006\f\u0012\u0004\ba\u0010[\u001a\u0004\bb\u0010TR\u001a\u0010c\u001a\u00020R8GX\u0087\u0004¢\u0006\f\u0012\u0004\bd\u0010[\u001a\u0004\be\u0010TR\u001a\u0010f\u001a\u00020R8GX\u0087\u0004¢\u0006\f\u0012\u0004\bg\u0010[\u001a\u0004\bh\u0010TR\u001a\u0010i\u001a\u00020R8GX\u0087\u0004¢\u0006\f\u0012\u0004\bj\u0010[\u001a\u0004\bk\u0010TR\u001a\u0010l\u001a\u00020R8GX\u0087\u0004¢\u0006\f\u0012\u0004\bm\u0010[\u001a\u0004\bn\u0010TR\u001a\u0010o\u001a\u00020R8GX\u0087\u0004¢\u0006\f\u0012\u0004\bp\u0010[\u001a\u0004\bq\u0010TR\u001a\u0010r\u001a\u00020R8GX\u0087\u0004¢\u0006\f\u0012\u0004\bs\u0010[\u001a\u0004\bt\u0010TR\u001a\u0010u\u001a\u00020R8GX\u0087\u0004¢\u0006\f\u0012\u0004\bv\u0010[\u001a\u0004\bw\u0010TR\u001a\u0010x\u001a\u00020R8GX\u0087\u0004¢\u0006\f\u0012\u0004\by\u0010[\u001a\u0004\bz\u0010TR\u001a\u0010{\u001a\u00020R8GX\u0087\u0004¢\u0006\f\u0012\u0004\b|\u0010[\u001a\u0004\b}\u0010TR\u001b\u0010~\u001a\u00020R8GX\u0087\u0004¢\u0006\r\u0012\u0004\b\u007f\u0010[\u001a\u0005\b\u0080\u0001\u0010TR\u001d\u0010\u0081\u0001\u001a\u00020R8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0082\u0001\u0010[\u001a\u0005\b\u0083\u0001\u0010TR\u001d\u0010\u0084\u0001\u001a\u00020R8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0085\u0001\u0010[\u001a\u0005\b\u0086\u0001\u0010TR\u001d\u0010\u0087\u0001\u001a\u00020R8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0088\u0001\u0010[\u001a\u0005\b\u0089\u0001\u0010TR\u001d\u0010\u008a\u0001\u001a\u00020R8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u008b\u0001\u0010[\u001a\u0005\b\u008c\u0001\u0010TR\u001d\u0010\u008d\u0001\u001a\u00020R8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u008e\u0001\u0010[\u001a\u0005\b\u008f\u0001\u0010TR\u001d\u0010\u0090\u0001\u001a\u00020R8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0091\u0001\u0010[\u001a\u0005\b\u0092\u0001\u0010TR\u001d\u0010\u0093\u0001\u001a\u00020R8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0094\u0001\u0010[\u001a\u0005\b\u0095\u0001\u0010TR\u001d\u0010\u0096\u0001\u001a\u00020R8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0097\u0001\u0010[\u001a\u0005\b\u0098\u0001\u0010TR\u001d\u0010\u0099\u0001\u001a\u00020R8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u009a\u0001\u0010[\u001a\u0005\b\u009b\u0001\u0010TR\u001d\u0010\u009c\u0001\u001a\u00020R8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u009d\u0001\u0010[\u001a\u0005\b\u009e\u0001\u0010TR\u001d\u0010\u009f\u0001\u001a\u00020R8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b \u0001\u0010[\u001a\u0005\b¡\u0001\u0010TR\u001d\u0010¢\u0001\u001a\u00020R8GX\u0087\u0004¢\u0006\u000e\u0012\u0005\b£\u0001\u0010[\u001a\u0005\b¤\u0001\u0010TR%\u0010«\u0001\u001a\u00030¦\u0001*\u00030¬\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b\u00ad\u0001\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001R%\u0010¶\u0001\u001a\u00030²\u0001*\u00030¬\u00018@X\u0080\u0004¢\u0006\u0010\u0012\u0006\b·\u0001\u0010®\u0001\u001a\u0006\b¸\u0001\u0010¹\u0001R$\u0010º\u0001\u001a\u00030»\u00018\u0006X\u0087\u0004¢\u0006\u0014\n\u0003\u0010¿\u0001\u0012\u0005\b¼\u0001\u0010\u0003\u001a\u0006\b½\u0001\u0010¾\u0001R$\u0010À\u0001\u001a\u00030»\u00018\u0006X\u0087\u0004¢\u0006\u0014\n\u0003\u0010¿\u0001\u0012\u0005\bÁ\u0001\u0010\u0003\u001a\u0006\bÂ\u0001\u0010¾\u0001R$\u0010Ã\u0001\u001a\u00030»\u00018\u0006X\u0087\u0004¢\u0006\u0014\n\u0003\u0010¿\u0001\u0012\u0005\bÄ\u0001\u0010\u0003\u001a\u0006\bÅ\u0001\u0010¾\u0001R$\u0010Æ\u0001\u001a\u00030»\u00018\u0006X\u0087\u0004¢\u0006\u0014\n\u0003\u0010¿\u0001\u0012\u0005\bÇ\u0001\u0010\u0003\u001a\u0006\bÈ\u0001\u0010¾\u0001R$\u0010É\u0001\u001a\u00030»\u00018\u0006X\u0087\u0004¢\u0006\u0014\n\u0003\u0010¿\u0001\u0012\u0005\bÊ\u0001\u0010\u0003\u001a\u0006\bË\u0001\u0010¾\u0001¨\u0006Û\u0001"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults;", "", "<init>", "()V", "iconButtonColors", "Landroidx/compose/material3/IconButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "iconButtonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonColors;", "defaultIconButtonColors", "Landroidx/compose/material3/ColorScheme;", "localContentColor", "defaultIconButtonColors-4WTKRHQ$material3", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconButtonColors;", "iconButtonVibrantColors", "iconButtonVibrantColors-ro_MJ88", "defaultIconButtonVibrantColors", "defaultIconButtonVibrantColors$material3", "iconToggleButtonColors", "Landroidx/compose/material3/IconToggleButtonColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconToggleButtonColors;", "checkedContainerColor", "checkedContentColor", "iconToggleButtonColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonColors;", "defaultIconToggleButtonColors", "defaultIconToggleButtonColors-4WTKRHQ$material3", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconToggleButtonColors;", "iconToggleButtonVibrantColors", "iconToggleButtonVibrantColors-5tl4gsc", "defaultIconToggleButtonVibrantColors", "defaultIconToggleButtonVibrantColors$material3", "filledIconButtonColors", "filledIconButtonColors-ro_MJ88", "defaultFilledIconButtonColors", "getDefaultFilledIconButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconButtonColors;", "filledIconToggleButtonColors", "filledIconToggleButtonColors-5tl4gsc", "defaultFilledIconToggleButtonColors", "getDefaultFilledIconToggleButtonColors$material3", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconToggleButtonColors;", "filledTonalIconButtonColors", "filledTonalIconButtonColors-ro_MJ88", "defaultFilledTonalIconButtonColors", "getDefaultFilledTonalIconButtonColors$material3", "filledTonalIconToggleButtonColors", "filledTonalIconToggleButtonColors-5tl4gsc", "defaultFilledTonalIconToggleButtonColors", "getDefaultFilledTonalIconToggleButtonColors$material3", "outlinedIconButtonColors", "outlinedIconButtonColors-ro_MJ88", "defaultOutlinedIconButtonColors", "defaultOutlinedIconButtonColors-4WTKRHQ$material3", "outlinedIconButtonVibrantColors", "outlinedIconButtonVibrantColors-ro_MJ88", "defaultOutlinedIconButtonVibrantColors", "defaultOutlinedIconButtonVibrantColors$material3", "outlinedIconToggleButtonColors", "outlinedIconToggleButtonColors-5tl4gsc", "defaultOutlinedIconToggleButtonColors", "defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3", "outlinedIconToggleButtonVibrantColors", "outlinedIconToggleButtonVibrantColors-5tl4gsc", "defaultOutlinedIconToggleButtonVibrantColors", "defaultOutlinedIconToggleButtonVibrantColors$material3", "outlinedIconToggleButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconToggleButtonVibrantBorder", "outlinedIconButtonBorder", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconButtonVibrantBorder", "standardShape", "Landroidx/compose/ui/graphics/Shape;", "getStandardShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "filledShape", "getFilledShape", "outlinedShape", "getOutlinedShape", "extraSmallRoundShape", "getExtraSmallRoundShape$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getExtraSmallRoundShape", "extraSmallSquareShape", "getExtraSmallSquareShape$annotations", "getExtraSmallSquareShape", "extraSmallPressedShape", "getExtraSmallPressedShape$annotations", "getExtraSmallPressedShape", "extraSmallSelectedRoundShape", "getExtraSmallSelectedRoundShape$annotations", "getExtraSmallSelectedRoundShape", "extraSmallSelectedSquareShape", "getExtraSmallSelectedSquareShape$annotations", "getExtraSmallSelectedSquareShape", "smallRoundShape", "getSmallRoundShape$annotations", "getSmallRoundShape", "smallSquareShape", "getSmallSquareShape$annotations", "getSmallSquareShape", "smallPressedShape", "getSmallPressedShape$annotations", "getSmallPressedShape", "smallSelectedRoundShape", "getSmallSelectedRoundShape$annotations", "getSmallSelectedRoundShape", "SmallSelectedSquareShape", "getSmallSelectedSquareShape$annotations", "getSmallSelectedSquareShape", "mediumRoundShape", "getMediumRoundShape$annotations", "getMediumRoundShape", "mediumSquareShape", "getMediumSquareShape$annotations", "getMediumSquareShape", "mediumPressedShape", "getMediumPressedShape$annotations", "getMediumPressedShape", "mediumSelectedRoundShape", "getMediumSelectedRoundShape$annotations", "getMediumSelectedRoundShape", "mediumSelectedSquareShape", "getMediumSelectedSquareShape$annotations", "getMediumSelectedSquareShape", "largeRoundShape", "getLargeRoundShape$annotations", "getLargeRoundShape", "largeSquareShape", "getLargeSquareShape$annotations", "getLargeSquareShape", "largePressedShape", "getLargePressedShape$annotations", "getLargePressedShape", "largeSelectedRoundShape", "getLargeSelectedRoundShape$annotations", "getLargeSelectedRoundShape", "largeSelectedSquareShape", "getLargeSelectedSquareShape$annotations", "getLargeSelectedSquareShape", "extraLargeRoundShape", "getExtraLargeRoundShape$annotations", "getExtraLargeRoundShape", "extraLargeSquareShape", "getExtraLargeSquareShape$annotations", "getExtraLargeSquareShape", "extraLargePressedShape", "getExtraLargePressedShape$annotations", "getExtraLargePressedShape", "extraLargeSelectedRoundShape", "getExtraLargeSelectedRoundShape$annotations", "getExtraLargeSelectedRoundShape", "extraLargeSelectedSquareShape", "getExtraLargeSelectedSquareShape$annotations", "getExtraLargeSelectedSquareShape", "shapes", "Landroidx/compose/material3/IconButtonShapes;", "shape", "pressedShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconButtonShapes;", "defaultIconButtonShapes", "Landroidx/compose/material3/Shapes;", "getDefaultIconButtonShapes$material3$annotations", "(Landroidx/compose/material3/Shapes;)V", "getDefaultIconButtonShapes$material3", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/IconButtonShapes;", "toggleableShapes", "Landroidx/compose/material3/IconToggleButtonShapes;", "checkedShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconToggleButtonShapes;", "defaultIconToggleButtonShapes", "getDefaultIconToggleButtonShapes$material3$annotations", "getDefaultIconToggleButtonShapes$material3", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/IconToggleButtonShapes;", "extraSmallIconSize", "Landroidx/compose/ui/unit/Dp;", "getExtraSmallIconSize-D9Ej5fM$annotations", "getExtraSmallIconSize-D9Ej5fM", "()F", "F", "smallIconSize", "getSmallIconSize-D9Ej5fM$annotations", "getSmallIconSize-D9Ej5fM", "mediumIconSize", "getMediumIconSize-D9Ej5fM$annotations", "getMediumIconSize-D9Ej5fM", "largeIconSize", "getLargeIconSize-D9Ej5fM$annotations", "getLargeIconSize-D9Ej5fM", "extraLargeIconSize", "getExtraLargeIconSize-D9Ej5fM$annotations", "getExtraLargeIconSize-D9Ej5fM", "extraSmallContainerSize", "Landroidx/compose/ui/unit/DpSize;", "widthOption", "Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "extraSmallContainerSize-N-wlBFI", "(I)J", "smallContainerSize", "smallContainerSize-N-wlBFI", "mediumContainerSize", "mediumContainerSize-N-wlBFI", "largeContainerSize", "largeContainerSize-N-wlBFI", "extraLargeContainerSize", "extraLargeContainerSize-N-wlBFI", "IconButtonWidthOption", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IconButtonDefaults {
    public static final int $stable = 0;
    public static final IconButtonDefaults INSTANCE = new IconButtonDefaults();
    private static final float extraSmallIconSize = XSmallIconButtonTokens.INSTANCE.m5971getIconSizeD9Ej5fM();
    private static final float smallIconSize = SmallIconButtonTokens.INSTANCE.m5775getIconSizeD9Ej5fM();
    private static final float mediumIconSize = MediumIconButtonTokens.INSTANCE.m5540getIconSizeD9Ej5fM();
    private static final float largeIconSize = LargeIconButtonTokens.INSTANCE.m5489getIconSizeD9Ej5fM();
    private static final float extraLargeIconSize = XLargeIconButtonTokens.INSTANCE.m5962getIconSizeD9Ej5fM();

    public static /* synthetic */ void getDefaultIconButtonShapes$material3$annotations(Shapes shapes) {
    }

    public static /* synthetic */ void getDefaultIconToggleButtonShapes$material3$annotations(Shapes shapes) {
    }

    /* JADX INFO: renamed from: getExtraLargeIconSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3522getExtraLargeIconSizeD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getExtraLargePressedShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getExtraLargeRoundShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getExtraLargeSelectedRoundShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getExtraLargeSelectedSquareShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getExtraLargeSquareShape$annotations(Composer composer, int i) {
    }

    /* JADX INFO: renamed from: getExtraSmallIconSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3523getExtraSmallIconSizeD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getExtraSmallPressedShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getExtraSmallRoundShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getExtraSmallSelectedRoundShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getExtraSmallSelectedSquareShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getExtraSmallSquareShape$annotations(Composer composer, int i) {
    }

    /* JADX INFO: renamed from: getLargeIconSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3524getLargeIconSizeD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getLargePressedShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getLargeRoundShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getLargeSelectedRoundShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getLargeSelectedSquareShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getLargeSquareShape$annotations(Composer composer, int i) {
    }

    /* JADX INFO: renamed from: getMediumIconSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3525getMediumIconSizeD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getMediumPressedShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getMediumRoundShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getMediumSelectedRoundShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getMediumSelectedSquareShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getMediumSquareShape$annotations(Composer composer, int i) {
    }

    /* JADX INFO: renamed from: getSmallIconSize-D9Ej5fM$annotations, reason: not valid java name */
    public static /* synthetic */ void m3526getSmallIconSizeD9Ej5fM$annotations() {
    }

    public static /* synthetic */ void getSmallPressedShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getSmallRoundShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getSmallSelectedRoundShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getSmallSelectedSquareShape$annotations(Composer composer, int i) {
    }

    public static /* synthetic */ void getSmallSquareShape$annotations(Composer composer, int i) {
    }

    private IconButtonDefaults() {
    }

    public final IconButtonColors iconButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1037266503, "C(iconButtonColors)49@2138L7,50@2181L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1037266503, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButtonDefaults.kt:48)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
        IconButtonColors iconButtonColorsM3530defaultIconButtonColors4WTKRHQ$material3 = m3530defaultIconButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6), jM6824unboximpl);
        if (!Color.m6815equalsimpl0(iconButtonColorsM3530defaultIconButtonColors4WTKRHQ$material3.getContentColor(), jM6824unboximpl)) {
            iconButtonColorsM3530defaultIconButtonColors4WTKRHQ$material3 = IconButtonColors.m3512copyjRlVdoo$default(iconButtonColorsM3530defaultIconButtonColors4WTKRHQ$material3, 0L, jM6824unboximpl, 0L, Color.m6813copywmQWz5c$default(jM6824unboximpl, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), 5, null);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM3530defaultIconButtonColors4WTKRHQ$material3;
    }

    /* JADX INFO: renamed from: iconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m3545iconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long jM6824unboximpl;
        long j5;
        long jM6813copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -1639168605, "C(iconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)79@3481L7,84@3716L11,85@3783L7:IconButtonDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
        } else {
            jM6824unboximpl = j2;
        }
        long jM6850getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j6 = jM6824unboximpl;
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j5 = j6;
        } else {
            j5 = jM6824unboximpl;
            jM6813copywmQWz5c$default = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1639168605, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButtonDefaults.kt:84)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonColors iconButtonColorsM3515copyjRlVdoo = m3530defaultIconButtonColors4WTKRHQ$material3(colorScheme, ((Color) objConsume2).m6824unboximpl()).m3515copyjRlVdoo(jM6850getUnspecified0d7_KjU, j5, jM6850getUnspecified0d7_KjU2, jM6813copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM3515copyjRlVdoo;
    }

    /* JADX INFO: renamed from: defaultIconButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconButtonColors m3530defaultIconButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconButtonColors defaultIconButtonColorsCached = colorScheme.getDefaultIconButtonColorsCached();
        if (defaultIconButtonColorsCached != null) {
            return defaultIconButtonColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.INSTANCE.m6849getTransparent0d7_KjU(), j, Color.INSTANCE.m6849getTransparent0d7_KjU(), Color.m6813copywmQWz5c$default(j, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultIconButtonColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconButtonColors iconButtonVibrantColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 111454247, "C(iconButtonVibrantColors)116@5047L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(111454247, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonVibrantColors (IconButtonDefaults.kt:116)");
        }
        IconButtonColors iconButtonColorsDefaultIconButtonVibrantColors$material3 = defaultIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsDefaultIconButtonVibrantColors$material3;
    }

    /* JADX INFO: renamed from: iconButtonVibrantColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m3546iconButtonVibrantColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long j5;
        long jM6813copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, 1036440437, "C(iconButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)138@6090L11:IconButtonDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j6 = jM6850getUnspecified0d7_KjU2;
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j5 = j6;
        } else {
            j5 = jM6850getUnspecified0d7_KjU2;
            jM6813copywmQWz5c$default = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1036440437, i, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonVibrantColors (IconButtonDefaults.kt:138)");
        }
        IconButtonColors iconButtonColorsM3515copyjRlVdoo = defaultIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3515copyjRlVdoo(jM6850getUnspecified0d7_KjU, j5, jM6850getUnspecified0d7_KjU3, jM6813copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM3515copyjRlVdoo;
    }

    public final IconButtonColors defaultIconButtonVibrantColors$material3(ColorScheme colorScheme) {
        IconButtonColors defaultIconButtonVibrantColorsCached = colorScheme.getDefaultIconButtonVibrantColorsCached();
        if (defaultIconButtonVibrantColorsCached != null) {
            return defaultIconButtonVibrantColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.INSTANCE.m6849getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getColor()), Color.INSTANCE.m6849getTransparent0d7_KjU(), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getDisabledColor()), StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultIconButtonVibrantColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors iconToggleButtonColors(Composer composer, int i) {
        composer.startReplaceGroup(-1355771567);
        ComposerKt.sourceInformation(composer, "C(iconToggleButtonColors)171@7577L7,172@7620L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1355771567, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButtonDefaults.kt:170)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
        IconToggleButtonColors iconToggleButtonColorsM3531defaultIconToggleButtonColors4WTKRHQ$material3 = m3531defaultIconToggleButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6), jM6824unboximpl);
        if (Color.m6815equalsimpl0(iconToggleButtonColorsM3531defaultIconToggleButtonColors4WTKRHQ$material3.getContentColor(), jM6824unboximpl)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return iconToggleButtonColorsM3531defaultIconToggleButtonColors4WTKRHQ$material3;
        }
        IconToggleButtonColors iconToggleButtonColorsM3578copytNS2XkQ$default = IconToggleButtonColors.m3578copytNS2XkQ$default(iconToggleButtonColorsM3531defaultIconToggleButtonColors4WTKRHQ$material3, 0L, jM6824unboximpl, 0L, Color.m6813copywmQWz5c$default(jM6824unboximpl, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 53, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconToggleButtonColorsM3578copytNS2XkQ$default;
    }

    /* JADX INFO: renamed from: iconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m3547iconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long jM6824unboximpl;
        long j7;
        long jM6813copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, 1402082449, "C(iconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)202@9061L7,209@9416L11,210@9489L7:IconButtonDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
        } else {
            jM6824unboximpl = j2;
        }
        long jM6850getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j8 = jM6824unboximpl;
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j8, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j7 = j8;
        } else {
            j7 = jM6824unboximpl;
            jM6813copywmQWz5c$default = j4;
        }
        long jM6850getUnspecified0d7_KjU3 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1402082449, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButtonDefaults.kt:209)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long j9 = jM6850getUnspecified0d7_KjU;
        IconToggleButtonColors iconToggleButtonColorsM3579copytNS2XkQ = m3531defaultIconToggleButtonColors4WTKRHQ$material3(colorScheme, ((Color) objConsume2).m6824unboximpl()).m3579copytNS2XkQ(j9, j7, jM6850getUnspecified0d7_KjU2, jM6813copywmQWz5c$default, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM3579copytNS2XkQ;
    }

    /* JADX INFO: renamed from: defaultIconToggleButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconToggleButtonColors m3531defaultIconToggleButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconToggleButtonColors defaultIconToggleButtonColorsCached = colorScheme.getDefaultIconToggleButtonColorsCached();
        if (defaultIconToggleButtonColorsCached != null) {
            return defaultIconToggleButtonColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(Color.INSTANCE.m6849getTransparent0d7_KjU(), j, Color.INSTANCE.m6849getTransparent0d7_KjU(), Color.m6813copywmQWz5c$default(j, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6849getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconToggleButtonColors iconToggleButtonVibrantColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1755001127, "C(iconToggleButtonVibrantColors)247@11160L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1755001127, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonVibrantColors (IconButtonDefaults.kt:247)");
        }
        IconToggleButtonColors iconToggleButtonColorsDefaultIconToggleButtonVibrantColors$material3 = defaultIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsDefaultIconToggleButtonVibrantColors$material3;
    }

    /* JADX INFO: renamed from: iconToggleButtonVibrantColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m3548iconToggleButtonVibrantColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long j7;
        long jM6813copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -1027328773, "C(iconToggleButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)273@12528L11:IconButtonDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j8 = jM6850getUnspecified0d7_KjU2;
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j8, StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j7 = j8;
        } else {
            j7 = jM6850getUnspecified0d7_KjU2;
            jM6813copywmQWz5c$default = j4;
        }
        long jM6850getUnspecified0d7_KjU4 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 32) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1027328773, i, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonVibrantColors (IconButtonDefaults.kt:273)");
        }
        IconToggleButtonColors iconToggleButtonColorsM3579copytNS2XkQ = defaultIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3579copytNS2XkQ(jM6850getUnspecified0d7_KjU, j7, jM6850getUnspecified0d7_KjU3, jM6813copywmQWz5c$default, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM3579copytNS2XkQ;
    }

    public final IconToggleButtonColors defaultIconToggleButtonVibrantColors$material3(ColorScheme colorScheme) {
        IconToggleButtonColors defaultIconToggleButtonVibrantColorsCached = colorScheme.getDefaultIconToggleButtonVibrantColorsCached();
        if (defaultIconToggleButtonVibrantColorsCached != null) {
            return defaultIconToggleButtonVibrantColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(Color.INSTANCE.m6849getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getUnselectedColor()), Color.INSTANCE.m6849getTransparent0d7_KjU(), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getDisabledColor()), StandardIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m6849getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, StandardIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultIconToggleButtonVibrantColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors filledIconButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -958304265, "C(filledIconButtonColors)306@14108L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-958304265, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButtonDefaults.kt:306)");
        }
        IconButtonColors defaultFilledIconButtonColors$material3 = getDefaultFilledIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledIconButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m3536filledIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -245481051, "C(filledIconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)319@14752L31,323@14949L11:IconButtonDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6850getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM3051contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(j5, composer, i & 14) : j2;
        long jM6850getUnspecified0d7_KjU = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-245481051, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButtonDefaults.kt:323)");
        }
        IconButtonColors iconButtonColorsM3515copyjRlVdoo = getDefaultFilledIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3515copyjRlVdoo(j5, jM3051contentColorForek8zF_U, jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM3515copyjRlVdoo;
    }

    public final IconButtonColors getDefaultFilledIconButtonColors$material3(ColorScheme colorScheme) {
        IconButtonColors defaultFilledIconButtonColorsCached = colorScheme.getDefaultFilledIconButtonColorsCached();
        if (defaultFilledIconButtonColorsCached != null) {
            return defaultFilledIconButtonColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledColor()), FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultFilledIconButtonColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors filledIconToggleButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1455160689, "C(filledIconToggleButtonColors)352@16351L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1455160689, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButtonDefaults.kt:352)");
        }
        IconToggleButtonColors defaultFilledIconToggleButtonColors$material3 = getDefaultFilledIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledIconToggleButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m3537filledIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1473292947, "C(filledIconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)374@17565L38,376@17659L11:IconButtonDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU5 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM3051contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(jM6850getUnspecified0d7_KjU5, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1473292947, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButtonDefaults.kt:376)");
        }
        IconToggleButtonColors iconToggleButtonColorsM3579copytNS2XkQ = getDefaultFilledIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3579copytNS2XkQ(jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM6850getUnspecified0d7_KjU5, jM3051contentColorForek8zF_U);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM3579copytNS2XkQ;
    }

    public final IconToggleButtonColors getDefaultFilledIconToggleButtonColors$material3(ColorScheme colorScheme) {
        IconToggleButtonColors defaultFilledIconToggleButtonColorsCached = colorScheme.getDefaultFilledIconToggleButtonColorsCached();
        if (defaultFilledIconToggleButtonColorsCached != null) {
            return defaultFilledIconToggleButtonColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getUnselectedColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledColor()), FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultFilledIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors filledTonalIconButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1145002745, "C(filledTonalIconButtonColors)413@19638L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1145002745, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButtonDefaults.kt:413)");
        }
        IconButtonColors defaultFilledTonalIconButtonColors$material3 = getDefaultFilledTonalIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledTonalIconButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledTonalIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m3538filledTonalIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 562762851, "C(filledTonalIconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)427@20304L31,431@20501L11:IconButtonDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            j = Color.INSTANCE.m6850getUnspecified0d7_KjU();
        }
        long j5 = j;
        long jM3051contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(j5, composer, i & 14) : j2;
        long jM6850getUnspecified0d7_KjU = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(562762851, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButtonDefaults.kt:431)");
        }
        IconButtonColors iconButtonColorsM3515copyjRlVdoo = getDefaultFilledTonalIconButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3515copyjRlVdoo(j5, jM3051contentColorForek8zF_U, jM6850getUnspecified0d7_KjU, jM6850getUnspecified0d7_KjU2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM3515copyjRlVdoo;
    }

    public final IconButtonColors getDefaultFilledTonalIconButtonColors$material3(ColorScheme colorScheme) {
        IconButtonColors defaultFilledTonalIconButtonColorsCached = colorScheme.getDefaultFilledTonalIconButtonColorsCached();
        if (defaultFilledTonalIconButtonColorsCached != null) {
            return defaultFilledTonalIconButtonColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultFilledTonalIconButtonColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors filledTonalIconToggleButtonColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 656374417, "C(filledTonalIconToggleButtonColors)460@21963L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(656374417, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButtonDefaults.kt:460)");
        }
        IconToggleButtonColors defaultFilledTonalIconToggleButtonColors$material3 = getDefaultFilledTonalIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultFilledTonalIconToggleButtonColors$material3;
    }

    /* JADX INFO: renamed from: filledTonalIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m3539filledTonalIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 2130748241, "C(filledTonalIconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)476@22829L31,480@23073L38,482@23167L11:IconButtonDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM3051contentColorForek8zF_U = (i2 & 2) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(jM6850getUnspecified0d7_KjU, composer, i & 14) : j2;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 8) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j4;
        long jM6850getUnspecified0d7_KjU4 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM3051contentColorForek8zF_U2 = (i2 & 32) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(jM6850getUnspecified0d7_KjU4, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2130748241, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButtonDefaults.kt:482)");
        }
        IconToggleButtonColors iconToggleButtonColorsM3579copytNS2XkQ = getDefaultFilledTonalIconToggleButtonColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3579copytNS2XkQ(jM6850getUnspecified0d7_KjU, jM3051contentColorForek8zF_U, jM6850getUnspecified0d7_KjU2, jM6850getUnspecified0d7_KjU3, jM6850getUnspecified0d7_KjU4, jM3051contentColorForek8zF_U2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM3579copytNS2XkQ;
    }

    public final IconToggleButtonColors getDefaultFilledTonalIconToggleButtonColors$material3(ColorScheme colorScheme) {
        IconToggleButtonColors defaultFilledTonalIconToggleButtonColorsCached = colorScheme.getDefaultFilledTonalIconToggleButtonColorsCached();
        if (defaultFilledTonalIconToggleButtonColorsCached != null) {
            return defaultFilledTonalIconToggleButtonColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getUnselectedColor()), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), 0.0f, 0.0f, 0.0f, 14, null), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor()), FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultFilledTonalIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconButtonColors outlinedIconButtonColors(Composer composer, int i) {
        composer.startReplaceGroup(1591384183);
        ComposerKt.sourceInformation(composer, "C(outlinedIconButtonColors)520@25258L7,521@25301L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1591384183, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButtonDefaults.kt:519)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
        IconButtonColors iconButtonColorsM3532defaultOutlinedIconButtonColors4WTKRHQ$material3 = m3532defaultOutlinedIconButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6), jM6824unboximpl);
        if (Color.m6815equalsimpl0(iconButtonColorsM3532defaultOutlinedIconButtonColors4WTKRHQ$material3.getContentColor(), jM6824unboximpl)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return iconButtonColorsM3532defaultOutlinedIconButtonColors4WTKRHQ$material3;
        }
        IconButtonColors iconButtonColorsM3512copyjRlVdoo$default = IconButtonColors.m3512copyjRlVdoo$default(iconButtonColorsM3532defaultOutlinedIconButtonColors4WTKRHQ$material3, 0L, jM6824unboximpl, 0L, Color.m6813copywmQWz5c$default(jM6824unboximpl, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), 5, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconButtonColorsM3512copyjRlVdoo$default;
    }

    /* JADX INFO: renamed from: outlinedIconButtonColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m3551outlinedIconButtonColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long jM6824unboximpl;
        long j5;
        long jM6813copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -1335916251, "C(outlinedIconButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)548@26448L7,553@26683L11,554@26758L7:IconButtonDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
        } else {
            jM6824unboximpl = j2;
        }
        long jM6850getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j6 = jM6824unboximpl;
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j5 = j6;
        } else {
            j5 = jM6824unboximpl;
            jM6813copywmQWz5c$default = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1335916251, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButtonDefaults.kt:553)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconButtonColors iconButtonColorsM3515copyjRlVdoo = m3532defaultOutlinedIconButtonColors4WTKRHQ$material3(colorScheme, ((Color) objConsume2).m6824unboximpl()).m3515copyjRlVdoo(jM6850getUnspecified0d7_KjU, j5, jM6850getUnspecified0d7_KjU2, jM6813copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM3515copyjRlVdoo;
    }

    /* JADX INFO: renamed from: defaultOutlinedIconButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconButtonColors m3532defaultOutlinedIconButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconButtonColors defaultOutlinedIconButtonColorsCached = colorScheme.getDefaultOutlinedIconButtonColorsCached();
        if (defaultOutlinedIconButtonColorsCached != null) {
            return defaultOutlinedIconButtonColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.INSTANCE.m6849getTransparent0d7_KjU(), j, Color.INSTANCE.m6849getTransparent0d7_KjU(), Color.m6813copywmQWz5c$default(j, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultOutlinedIconButtonColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconButtonColors outlinedIconButtonVibrantColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -899469399, "C(outlinedIconButtonVibrantColors)587@28065L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-899469399, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantColors (IconButtonDefaults.kt:587)");
        }
        IconButtonColors iconButtonColorsDefaultOutlinedIconButtonVibrantColors$material3 = defaultOutlinedIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsDefaultOutlinedIconButtonVibrantColors$material3;
    }

    /* JADX INFO: renamed from: outlinedIconButtonVibrantColors-ro_MJ88, reason: not valid java name */
    public final IconButtonColors m3552outlinedIconButtonVibrantColorsro_MJ88(long j, long j2, long j3, long j4, Composer composer, int i, int i2) {
        long j5;
        long jM6813copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -278201933, "C(outlinedIconButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color)609@29121L11:IconButtonDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j6 = jM6850getUnspecified0d7_KjU2;
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j6, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j5 = j6;
        } else {
            j5 = jM6850getUnspecified0d7_KjU2;
            jM6813copywmQWz5c$default = j4;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-278201933, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantColors (IconButtonDefaults.kt:609)");
        }
        IconButtonColors iconButtonColorsM3515copyjRlVdoo = defaultOutlinedIconButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3515copyjRlVdoo(jM6850getUnspecified0d7_KjU, j5, jM6850getUnspecified0d7_KjU3, jM6813copywmQWz5c$default);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonColorsM3515copyjRlVdoo;
    }

    public final IconButtonColors defaultOutlinedIconButtonVibrantColors$material3(ColorScheme colorScheme) {
        IconButtonColors defaultOutlinedIconButtonVibrantColorsCached = colorScheme.getDefaultOutlinedIconButtonVibrantColorsCached();
        if (defaultOutlinedIconButtonVibrantColorsCached != null) {
            return defaultOutlinedIconButtonVibrantColorsCached;
        }
        IconButtonColors iconButtonColors = new IconButtonColors(Color.INSTANCE.m6849getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getColor()), Color.INSTANCE.m6849getTransparent0d7_KjU(), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getDisabledColor()), OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.setDefaultOutlinedIconButtonVibrantColorsCached$material3(iconButtonColors);
        return iconButtonColors;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonColors(Composer composer, int i) {
        composer.startReplaceGroup(-834376945);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonColors)643@30665L7,644@30708L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-834376945, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButtonDefaults.kt:642)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
        IconToggleButtonColors iconToggleButtonColorsM3533defaultOutlinedIconToggleButtonColors4WTKRHQ$material3 = m3533defaultOutlinedIconToggleButtonColors4WTKRHQ$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6), jM6824unboximpl);
        if (Color.m6815equalsimpl0(iconToggleButtonColorsM3533defaultOutlinedIconToggleButtonColors4WTKRHQ$material3.getContentColor(), jM6824unboximpl)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return iconToggleButtonColorsM3533defaultOutlinedIconToggleButtonColors4WTKRHQ$material3;
        }
        IconToggleButtonColors iconToggleButtonColorsM3578copytNS2XkQ$default = IconToggleButtonColors.m3578copytNS2XkQ$default(iconToggleButtonColorsM3533defaultOutlinedIconToggleButtonColors4WTKRHQ$material3, 0L, jM6824unboximpl, 0L, Color.m6813copywmQWz5c$default(jM6824unboximpl, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, 53, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return iconToggleButtonColorsM3578copytNS2XkQ$default;
    }

    /* JADX INFO: renamed from: outlinedIconToggleButtonColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m3553outlinedIconToggleButtonColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long jM6824unboximpl;
        long j7;
        long jM6813copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -514625005, "C(outlinedIconToggleButtonColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)674@32132L7,679@32414L38,681@32508L11,682@32589L7:IconButtonDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        if ((i2 & 2) != 0) {
            ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composer.consume(localContentColor);
            ComposerKt.sourceInformationMarkerEnd(composer);
            jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
        } else {
            jM6824unboximpl = j2;
        }
        long jM6850getUnspecified0d7_KjU2 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j8 = jM6824unboximpl;
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j8, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j7 = j8;
        } else {
            j7 = jM6824unboximpl;
            jM6813copywmQWz5c$default = j4;
        }
        long jM6850getUnspecified0d7_KjU3 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM3051contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(jM6850getUnspecified0d7_KjU3, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-514625005, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButtonDefaults.kt:681)");
        }
        ColorScheme colorScheme = MaterialTheme.INSTANCE.getColorScheme(composer, 6);
        ProvidableCompositionLocal<Color> localContentColor2 = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume2 = composer.consume(localContentColor2);
        ComposerKt.sourceInformationMarkerEnd(composer);
        IconToggleButtonColors iconToggleButtonColorsM3579copytNS2XkQ = m3533defaultOutlinedIconToggleButtonColors4WTKRHQ$material3(colorScheme, ((Color) objConsume2).m6824unboximpl()).m3579copytNS2XkQ(jM6850getUnspecified0d7_KjU, j7, jM6850getUnspecified0d7_KjU2, jM6813copywmQWz5c$default, jM6850getUnspecified0d7_KjU3, jM3051contentColorForek8zF_U);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM3579copytNS2XkQ;
    }

    /* JADX INFO: renamed from: defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3, reason: not valid java name */
    public final IconToggleButtonColors m3533defaultOutlinedIconToggleButtonColors4WTKRHQ$material3(ColorScheme colorScheme, long j) {
        IconToggleButtonColors defaultIconToggleButtonColorsCached = colorScheme.getDefaultIconToggleButtonColorsCached();
        if (defaultIconToggleButtonColorsCached != null) {
            return defaultIconToggleButtonColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(Color.INSTANCE.m6849getTransparent0d7_KjU(), j, Color.INSTANCE.m6849getTransparent0d7_KjU(), Color.m6813copywmQWz5c$default(j, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.m3050contentColorFor4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor())), null);
        colorScheme.setDefaultOutlinedIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final IconToggleButtonColors outlinedIconToggleButtonVibrantColors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1236236887, "C(outlinedIconToggleButtonVibrantColors)725@34481L11:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1236236887, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantColors (IconButtonDefaults.kt:725)");
        }
        IconToggleButtonColors iconToggleButtonColorsDefaultOutlinedIconToggleButtonVibrantColors$material3 = defaultOutlinedIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsDefaultOutlinedIconToggleButtonVibrantColors$material3;
    }

    /* JADX INFO: renamed from: outlinedIconToggleButtonVibrantColors-5tl4gsc, reason: not valid java name */
    public final IconToggleButtonColors m3554outlinedIconToggleButtonVibrantColors5tl4gsc(long j, long j2, long j3, long j4, long j5, long j6, Composer composer, int i, int i2) {
        long j7;
        long jM6813copywmQWz5c$default;
        ComposerKt.sourceInformationMarkerStart(composer, -142016199, "C(outlinedIconToggleButtonVibrantColors)N(containerColor:c#ui.graphics.Color,contentColor:c#ui.graphics.Color,disabledContainerColor:c#ui.graphics.Color,disabledContentColor:c#ui.graphics.Color,checkedContainerColor:c#ui.graphics.Color,checkedContentColor:c#ui.graphics.Color)749@35790L38,751@35884L11:IconButtonDefaults.kt#uh7d8r");
        long jM6850getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j;
        long jM6850getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j2;
        long jM6850getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j3;
        if ((i2 & 8) != 0) {
            long j8 = jM6850getUnspecified0d7_KjU2;
            jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(j8, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
            j7 = j8;
        } else {
            j7 = jM6850getUnspecified0d7_KjU2;
            jM6813copywmQWz5c$default = j4;
        }
        long jM6850getUnspecified0d7_KjU4 = (i2 & 16) != 0 ? Color.INSTANCE.m6850getUnspecified0d7_KjU() : j5;
        long jM3051contentColorForek8zF_U = (i2 & 32) != 0 ? ColorSchemeKt.m3051contentColorForek8zF_U(jM6850getUnspecified0d7_KjU4, composer, (i >> 12) & 14) : j6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-142016199, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantColors (IconButtonDefaults.kt:751)");
        }
        IconToggleButtonColors iconToggleButtonColorsM3579copytNS2XkQ = defaultOutlinedIconToggleButtonVibrantColors$material3(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).m3579copytNS2XkQ(jM6850getUnspecified0d7_KjU, j7, jM6850getUnspecified0d7_KjU3, jM6813copywmQWz5c$default, jM6850getUnspecified0d7_KjU4, jM3051contentColorForek8zF_U);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonColorsM3579copytNS2XkQ;
    }

    public final IconToggleButtonColors defaultOutlinedIconToggleButtonVibrantColors$material3(ColorScheme colorScheme) {
        IconToggleButtonColors defaultOutlinedIconToggleButtonVibrantColorsCached = colorScheme.getDefaultOutlinedIconToggleButtonVibrantColorsCached();
        if (defaultOutlinedIconToggleButtonVibrantColorsCached != null) {
            return defaultOutlinedIconToggleButtonVibrantColorsCached;
        }
        IconToggleButtonColors iconToggleButtonColors = new IconToggleButtonColors(Color.INSTANCE.m6849getTransparent0d7_KjU(), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getUnselectedColor()), Color.INSTANCE.m6849getTransparent0d7_KjU(), Color.m6813copywmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getDisabledColor()), OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor()), ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedColor()), null);
        colorScheme.setDefaultOutlinedIconToggleButtonColorsCached$material3(iconToggleButtonColors);
        return iconToggleButtonColors;
    }

    public final BorderStroke outlinedIconToggleButtonBorder(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceGroup(1933433512);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonBorder)N(enabled,checked)796@37994L33:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1933433512, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonBorder (IconButtonDefaults.kt:792)");
        }
        if (z2) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return null;
        }
        BorderStroke borderStrokeOutlinedIconButtonBorder = outlinedIconButtonBorder(z, composer, (i & 14) | ((i >> 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return borderStrokeOutlinedIconButtonBorder;
    }

    public final BorderStroke outlinedIconToggleButtonVibrantBorder(boolean z, boolean z2, Composer composer, int i) {
        composer.startReplaceGroup(394022990);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonVibrantBorder)N(enabled,checked)811@38541L40:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(394022990, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonVibrantBorder (IconButtonDefaults.kt:807)");
        }
        if (z2) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return null;
        }
        BorderStroke borderStrokeOutlinedIconButtonVibrantBorder = outlinedIconButtonVibrantBorder(z, composer, (i & 14) | ((i >> 3) & 112));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return borderStrokeOutlinedIconButtonVibrantBorder;
    }

    public final BorderStroke outlinedIconButtonBorder(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1270640488, "C(outlinedIconButtonBorder)N(enabled)825@39102L7,832@39327L83:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1270640488, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonBorder (IconButtonDefaults.kt:824)");
        }
        ProvidableCompositionLocal<Color> localContentColor = ContentColorKt.getLocalContentColor();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localContentColor);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long jM6824unboximpl = ((Color) objConsume).m6824unboximpl();
        if (!z) {
            jM6824unboximpl = Color.m6813copywmQWz5c$default(jM6824unboximpl, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1314786165, "CC(remember):IconButtonDefaults.kt#9igjgp");
        boolean zChanged = composer.changed(jM6824unboximpl);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = BorderStrokeKt.m622BorderStrokecXLIe8U(SmallIconButtonTokens.INSTANCE.m5778getOutlinedOutlineWidthD9Ej5fM(), jM6824unboximpl);
            composer.updateRememberedValue(objRememberedValue);
        }
        BorderStroke borderStroke = (BorderStroke) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStroke;
    }

    public final BorderStroke outlinedIconButtonVibrantBorder(boolean z, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2139728858, "C(outlinedIconButtonVibrantBorder)N(enabled)843@39821L5,850@40044L83:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2139728858, i, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonVibrantBorder (IconButtonDefaults.kt:842)");
        }
        long value = ColorSchemeKt.getValue(OutlinedIconButtonTokens.INSTANCE.getOutlineColor(), composer, 6);
        if (!z) {
            value = Color.m6813copywmQWz5c$default(value, OutlinedIconButtonTokens.INSTANCE.getDisabledOpacity(), 0.0f, 0.0f, 0.0f, 14, null);
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1009913785, "CC(remember):IconButtonDefaults.kt#9igjgp");
        boolean zChanged = composer.changed(value);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = BorderStrokeKt.m622BorderStrokecXLIe8U(SmallIconButtonTokens.INSTANCE.m5778getOutlinedOutlineWidthD9Ej5fM(), value);
            composer.updateRememberedValue(objRememberedValue);
        }
        BorderStroke borderStroke = (BorderStroke) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return borderStroke;
    }

    public final Shape getStandardShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -377108005, "C(<get-standardShape>)855@40294L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-377108005, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-standardShape> (IconButtonDefaults.kt:855)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getFilledShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1542796069, "C(<get-filledShape>)859@40449L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1542796069, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-filledShape> (IconButtonDefaults.kt:859)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getOutlinedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1706356635, "C(<get-outlinedShape>)863@40609L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1706356635, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-outlinedShape> (IconButtonDefaults.kt:863)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1321634995, "C(<get-extraSmallRoundShape>)868@40827L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1321634995, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraSmallRoundShape> (IconButtonDefaults.kt:868)");
        }
        Shape value = ShapesKt.getValue(XSmallIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 219275465, "C(<get-extraSmallSquareShape>)873@41048L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(219275465, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraSmallSquareShape> (IconButtonDefaults.kt:873)");
        }
        Shape value = ShapesKt.getValue(XSmallIconButtonTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallPressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1061421875, "C(<get-extraSmallPressedShape>)878@41272L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1061421875, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraSmallPressedShape> (IconButtonDefaults.kt:878)");
        }
        Shape value = ShapesKt.getValue(XSmallIconButtonTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallSelectedRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 370391251, "C(<get-extraSmallSelectedRoundShape>)883@41509L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(370391251, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraSmallSelectedRoundShape> (IconButtonDefaults.kt:883)");
        }
        Shape value = ShapesKt.getValue(XSmallIconButtonTokens.INSTANCE.getSelectedContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraSmallSelectedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 814033279, "C(<get-extraSmallSelectedSquareShape>)888@41756L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(814033279, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraSmallSelectedSquareShape> (IconButtonDefaults.kt:888)");
        }
        Shape value = ShapesKt.getValue(XSmallIconButtonTokens.INSTANCE.getSelectedContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSmallRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2020124271, "C(<get-smallRoundShape>)893@41956L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2020124271, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-smallRoundShape> (IconButtonDefaults.kt:893)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSmallSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 309880915, "C(<get-smallSquareShape>)898@42165L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(309880915, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-smallSquareShape> (IconButtonDefaults.kt:898)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSmallPressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -915829737, "C(<get-smallPressedShape>)903@42377L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-915829737, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-smallPressedShape> (IconButtonDefaults.kt:903)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSmallSelectedRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1359654471, "C(<get-smallSelectedRoundShape>)908@42602L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1359654471, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-smallSelectedRoundShape> (IconButtonDefaults.kt:908)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getSelectedContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getSmallSelectedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1665942605, "C(<get-SmallSelectedSquareShape>)913@42837L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1665942605, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-SmallSelectedSquareShape> (IconButtonDefaults.kt:913)");
        }
        Shape value = ShapesKt.getValue(SmallIconButtonTokens.INSTANCE.getSelectedContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2111840525, "C(<get-mediumRoundShape>)918@43040L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2111840525, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-mediumRoundShape> (IconButtonDefaults.kt:918)");
        }
        Shape value = ShapesKt.getValue(MediumIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1471824891, "C(<get-mediumSquareShape>)923@43245L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1471824891, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-mediumSquareShape> (IconButtonDefaults.kt:923)");
        }
        Shape value = ShapesKt.getValue(MediumIconButtonTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumPressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 72043507, "C(<get-mediumPressedShape>)928@43460L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(72043507, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-mediumPressedShape> (IconButtonDefaults.kt:928)");
        }
        Shape value = ShapesKt.getValue(MediumIconButtonTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumSelectedRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1651572077, "C(<get-mediumSelectedRoundShape>)933@43688L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1651572077, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-mediumSelectedRoundShape> (IconButtonDefaults.kt:933)");
        }
        Shape value = ShapesKt.getValue(MediumIconButtonTokens.INSTANCE.getSelectedContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getMediumSelectedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1224712133, "C(<get-mediumSelectedSquareShape>)938@43926L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1224712133, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-mediumSelectedSquareShape> (IconButtonDefaults.kt:938)");
        }
        Shape value = ShapesKt.getValue(MediumIconButtonTokens.INSTANCE.getSelectedContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargeRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1926537991, "C(<get-largeRoundShape>)943@44126L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1926537991, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-largeRoundShape> (IconButtonDefaults.kt:943)");
        }
        Shape value = ShapesKt.getValue(LargeIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargeSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -137453869, "C(<get-largeSquareShape>)948@44328L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-137453869, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-largeSquareShape> (IconButtonDefaults.kt:948)");
        }
        Shape value = ShapesKt.getValue(LargeIconButtonTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargePressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1695211601, "C(<get-largePressedShape>)953@44540L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1695211601, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-largePressedShape> (IconButtonDefaults.kt:953)");
        }
        Shape value = ShapesKt.getValue(LargeIconButtonTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargeSelectedRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -987878831, "C(<get-largeSelectedRoundShape>)958@44765L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-987878831, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-largeSelectedRoundShape> (IconButtonDefaults.kt:958)");
        }
        Shape value = ShapesKt.getValue(LargeIconButtonTokens.INSTANCE.getSelectedContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getLargeSelectedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -577828301, "C(<get-largeSelectedSquareShape>)963@45000L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-577828301, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-largeSelectedSquareShape> (IconButtonDefaults.kt:963)");
        }
        Shape value = ShapesKt.getValue(LargeIconButtonTokens.INSTANCE.getSelectedContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargeRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1371354061, "C(<get-extraLargeRoundShape>)968@45212L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1371354061, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraLargeRoundShape> (IconButtonDefaults.kt:968)");
        }
        Shape value = ShapesKt.getValue(XLargeIconButtonTokens.INSTANCE.getContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargeSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1416839217, "C(<get-extraLargeSquareShape>)973@45426L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1416839217, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraLargeSquareShape> (IconButtonDefaults.kt:973)");
        }
        Shape value = ShapesKt.getValue(XLargeIconButtonTokens.INSTANCE.getContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargePressedShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 481568179, "C(<get-extraLargePressedShape>)978@45650L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(481568179, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraLargePressedShape> (IconButtonDefaults.kt:978)");
        }
        Shape value = ShapesKt.getValue(XLargeIconButtonTokens.INSTANCE.getPressedContainerShape(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargeSelectedRoundShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1450837075, "C(<get-extraLargeSelectedRoundShape>)983@45887L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1450837075, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraLargeSelectedRoundShape> (IconButtonDefaults.kt:983)");
        }
        Shape value = ShapesKt.getValue(XLargeIconButtonTokens.INSTANCE.getSelectedContainerShapeRound(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final Shape getExtraLargeSelectedSquareShape(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -116183833, "C(<get-extraLargeSelectedSquareShape>)988@46134L5:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-116183833, i, -1, "androidx.compose.material3.IconButtonDefaults.<get-extraLargeSelectedSquareShape> (IconButtonDefaults.kt:988)");
        }
        Shape value = ShapesKt.getValue(XLargeIconButtonTokens.INSTANCE.getSelectedContainerShapeSquare(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final IconButtonShapes shapes(Shape shape, Shape shape2, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 1165993094, "C(shapes)N(shape,pressedShape)1001@46662L6:IconButtonDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = null;
        }
        if ((i2 & 2) != 0) {
            shape2 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1165993094, i, -1, "androidx.compose.material3.IconButtonDefaults.shapes (IconButtonDefaults.kt:1001)");
        }
        IconButtonShapes iconButtonShapesCopy = getDefaultIconButtonShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6)).copy(shape, shape2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconButtonShapesCopy;
    }

    public final IconButtonShapes shapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1198298816, "C(shapes)1013@47123L6:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1198298816, i, -1, "androidx.compose.material3.IconButtonDefaults.shapes (IconButtonDefaults.kt:1013)");
        }
        IconButtonShapes defaultIconButtonShapes$material3 = getDefaultIconButtonShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultIconButtonShapes$material3;
    }

    public final IconButtonShapes getDefaultIconButtonShapes$material3(Shapes shapes) {
        IconButtonShapes defaultIconButtonShapesCached = shapes.getDefaultIconButtonShapesCached();
        if (defaultIconButtonShapesCached != null) {
            return defaultIconButtonShapesCached;
        }
        IconButtonShapes iconButtonShapes = new IconButtonShapes(ShapesKt.fromToken(shapes, SmallIconButtonTokens.INSTANCE.getContainerShapeRound()), ShapesKt.fromToken(shapes, SmallIconButtonTokens.INSTANCE.getPressedContainerShape()));
        shapes.setDefaultIconButtonShapesCached$material3(iconButtonShapes);
        return iconButtonShapes;
    }

    public final IconToggleButtonShapes toggleableShapes(Shape shape, Shape shape2, Shape shape3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1794821771, "C(toggleableShapes)N(shape,pressedShape,checkedShape)1042@48359L6:IconButtonDefaults.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = null;
        }
        if ((i2 & 2) != 0) {
            shape2 = null;
        }
        if ((i2 & 4) != 0) {
            shape3 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1794821771, i, -1, "androidx.compose.material3.IconButtonDefaults.toggleableShapes (IconButtonDefaults.kt:1042)");
        }
        IconToggleButtonShapes iconToggleButtonShapesCopy = getDefaultIconToggleButtonShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6)).copy(shape, shape2, shape3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return iconToggleButtonShapesCopy;
    }

    public final IconToggleButtonShapes toggleableShapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 2022759230, "C(toggleableShapes)1056@48909L6:IconButtonDefaults.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2022759230, i, -1, "androidx.compose.material3.IconButtonDefaults.toggleableShapes (IconButtonDefaults.kt:1056)");
        }
        IconToggleButtonShapes defaultIconToggleButtonShapes$material3 = getDefaultIconToggleButtonShapes$material3(MaterialTheme.INSTANCE.getShapes(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultIconToggleButtonShapes$material3;
    }

    public final IconToggleButtonShapes getDefaultIconToggleButtonShapes$material3(Shapes shapes) {
        IconToggleButtonShapes defaultIconToggleButtonShapesCached = shapes.getDefaultIconToggleButtonShapesCached();
        if (defaultIconToggleButtonShapesCached != null) {
            return defaultIconToggleButtonShapesCached;
        }
        IconToggleButtonShapes iconToggleButtonShapes = new IconToggleButtonShapes(ShapesKt.fromToken(shapes, SmallIconButtonTokens.INSTANCE.getContainerShapeRound()), ShapesKt.fromToken(shapes, SmallIconButtonTokens.INSTANCE.getPressedContainerShape()), ShapesKt.fromToken(shapes, SmallIconButtonTokens.INSTANCE.getSelectedContainerShapeRound()));
        shapes.setDefaultIconToggleButtonShapesCached$material3(iconToggleButtonShapes);
        return iconToggleButtonShapes;
    }

    /* JADX INFO: renamed from: getExtraSmallIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3541getExtraSmallIconSizeD9Ej5fM() {
        return extraSmallIconSize;
    }

    /* JADX INFO: renamed from: getSmallIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3544getSmallIconSizeD9Ej5fM() {
        return smallIconSize;
    }

    /* JADX INFO: renamed from: getMediumIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3543getMediumIconSizeD9Ej5fM() {
        return mediumIconSize;
    }

    /* JADX INFO: renamed from: getLargeIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3542getLargeIconSizeD9Ej5fM() {
        return largeIconSize;
    }

    /* JADX INFO: renamed from: getExtraLargeIconSize-D9Ej5fM, reason: not valid java name */
    public final float m3540getExtraLargeIconSizeD9Ej5fM() {
        return extraLargeIconSize;
    }

    /* JADX INFO: renamed from: extraSmallContainerSize-N-wlBFI$default, reason: not valid java name */
    public static /* synthetic */ long m3521extraSmallContainerSizeNwlBFI$default(IconButtonDefaults iconButtonDefaults, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = IconButtonWidthOption.INSTANCE.m3564getUniformrc6NtMs();
        }
        return iconButtonDefaults.m3535extraSmallContainerSizeNwlBFI(i);
    }

    /* JADX INFO: renamed from: extraSmallContainerSize-N-wlBFI, reason: not valid java name */
    public final long m3535extraSmallContainerSizeNwlBFI(int widthOption) {
        float fM9687constructorimpl;
        if (!IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3563getNarrowrc6NtMs())) {
            if (!IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3564getUniformrc6NtMs())) {
                if (IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3565getWiderc6NtMs())) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(XSmallIconButtonTokens.INSTANCE.m5975getWideLeadingSpaceD9Ej5fM() + XSmallIconButtonTokens.INSTANCE.m5976getWideTrailingSpaceD9Ej5fM());
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(XSmallIconButtonTokens.INSTANCE.m5969getDefaultLeadingSpaceD9Ej5fM() + XSmallIconButtonTokens.INSTANCE.m5969getDefaultLeadingSpaceD9Ej5fM());
            }
        } else {
            fM9687constructorimpl = Dp.m9687constructorimpl(XSmallIconButtonTokens.INSTANCE.m5972getNarrowLeadingSpaceD9Ej5fM() + XSmallIconButtonTokens.INSTANCE.m5973getNarrowTrailingSpaceD9Ej5fM());
        }
        return DpKt.m9709DpSizeYgX7TsA(Dp.m9687constructorimpl(XSmallIconButtonTokens.INSTANCE.m5971getIconSizeD9Ej5fM() + fM9687constructorimpl), XSmallIconButtonTokens.INSTANCE.m5968getContainerHeightD9Ej5fM());
    }

    /* JADX INFO: renamed from: smallContainerSize-N-wlBFI$default, reason: not valid java name */
    public static /* synthetic */ long m3529smallContainerSizeNwlBFI$default(IconButtonDefaults iconButtonDefaults, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = IconButtonWidthOption.INSTANCE.m3564getUniformrc6NtMs();
        }
        return iconButtonDefaults.m3555smallContainerSizeNwlBFI(i);
    }

    /* JADX INFO: renamed from: smallContainerSize-N-wlBFI, reason: not valid java name */
    public final long m3555smallContainerSizeNwlBFI(int widthOption) {
        float fM9687constructorimpl;
        if (!IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3563getNarrowrc6NtMs())) {
            if (!IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3564getUniformrc6NtMs())) {
                if (IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3565getWiderc6NtMs())) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(SmallIconButtonTokens.INSTANCE.m5779getWideLeadingSpaceD9Ej5fM() + SmallIconButtonTokens.INSTANCE.m5780getWideTrailingSpaceD9Ej5fM());
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(SmallIconButtonTokens.INSTANCE.m5773getDefaultLeadingSpaceD9Ej5fM() + SmallIconButtonTokens.INSTANCE.m5773getDefaultLeadingSpaceD9Ej5fM());
            }
        } else {
            fM9687constructorimpl = Dp.m9687constructorimpl(SmallIconButtonTokens.INSTANCE.m5776getNarrowLeadingSpaceD9Ej5fM() + SmallIconButtonTokens.INSTANCE.m5777getNarrowTrailingSpaceD9Ej5fM());
        }
        return DpKt.m9709DpSizeYgX7TsA(Dp.m9687constructorimpl(SmallIconButtonTokens.INSTANCE.m5775getIconSizeD9Ej5fM() + fM9687constructorimpl), SmallIconButtonTokens.INSTANCE.m5772getContainerHeightD9Ej5fM());
    }

    /* JADX INFO: renamed from: mediumContainerSize-N-wlBFI$default, reason: not valid java name */
    public static /* synthetic */ long m3528mediumContainerSizeNwlBFI$default(IconButtonDefaults iconButtonDefaults, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = IconButtonWidthOption.INSTANCE.m3564getUniformrc6NtMs();
        }
        return iconButtonDefaults.m3550mediumContainerSizeNwlBFI(i);
    }

    /* JADX INFO: renamed from: mediumContainerSize-N-wlBFI, reason: not valid java name */
    public final long m3550mediumContainerSizeNwlBFI(int widthOption) {
        float fM9687constructorimpl;
        if (!IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3563getNarrowrc6NtMs())) {
            if (!IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3564getUniformrc6NtMs())) {
                if (IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3565getWiderc6NtMs())) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(MediumIconButtonTokens.INSTANCE.m5544getWideLeadingSpaceD9Ej5fM() + MediumIconButtonTokens.INSTANCE.m5545getWideTrailingSpaceD9Ej5fM());
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(MediumIconButtonTokens.INSTANCE.m5538getDefaultLeadingSpaceD9Ej5fM() + MediumIconButtonTokens.INSTANCE.m5538getDefaultLeadingSpaceD9Ej5fM());
            }
        } else {
            fM9687constructorimpl = Dp.m9687constructorimpl(MediumIconButtonTokens.INSTANCE.m5541getNarrowLeadingSpaceD9Ej5fM() + MediumIconButtonTokens.INSTANCE.m5542getNarrowTrailingSpaceD9Ej5fM());
        }
        return DpKt.m9709DpSizeYgX7TsA(Dp.m9687constructorimpl(MediumIconButtonTokens.INSTANCE.m5540getIconSizeD9Ej5fM() + fM9687constructorimpl), MediumIconButtonTokens.INSTANCE.m5537getContainerHeightD9Ej5fM());
    }

    /* JADX INFO: renamed from: largeContainerSize-N-wlBFI$default, reason: not valid java name */
    public static /* synthetic */ long m3527largeContainerSizeNwlBFI$default(IconButtonDefaults iconButtonDefaults, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = IconButtonWidthOption.INSTANCE.m3564getUniformrc6NtMs();
        }
        return iconButtonDefaults.m3549largeContainerSizeNwlBFI(i);
    }

    /* JADX INFO: renamed from: largeContainerSize-N-wlBFI, reason: not valid java name */
    public final long m3549largeContainerSizeNwlBFI(int widthOption) {
        float fM9687constructorimpl;
        if (!IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3563getNarrowrc6NtMs())) {
            if (!IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3564getUniformrc6NtMs())) {
                if (IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3565getWiderc6NtMs())) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(LargeIconButtonTokens.INSTANCE.m5495getWideLeadingSpaceD9Ej5fM() + LargeIconButtonTokens.INSTANCE.m5496getWideTrailingSpaceD9Ej5fM());
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(LargeIconButtonTokens.INSTANCE.m5493getUniformLeadingSpaceD9Ej5fM() + LargeIconButtonTokens.INSTANCE.m5493getUniformLeadingSpaceD9Ej5fM());
            }
        } else {
            fM9687constructorimpl = Dp.m9687constructorimpl(LargeIconButtonTokens.INSTANCE.m5490getNarrowLeadingSpaceD9Ej5fM() + LargeIconButtonTokens.INSTANCE.m5491getNarrowTrailingSpaceD9Ej5fM());
        }
        return DpKt.m9709DpSizeYgX7TsA(Dp.m9687constructorimpl(LargeIconButtonTokens.INSTANCE.m5489getIconSizeD9Ej5fM() + fM9687constructorimpl), LargeIconButtonTokens.INSTANCE.m5488getContainerHeightD9Ej5fM());
    }

    /* JADX INFO: renamed from: extraLargeContainerSize-N-wlBFI$default, reason: not valid java name */
    public static /* synthetic */ long m3520extraLargeContainerSizeNwlBFI$default(IconButtonDefaults iconButtonDefaults, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = IconButtonWidthOption.INSTANCE.m3564getUniformrc6NtMs();
        }
        return iconButtonDefaults.m3534extraLargeContainerSizeNwlBFI(i);
    }

    /* JADX INFO: renamed from: extraLargeContainerSize-N-wlBFI, reason: not valid java name */
    public final long m3534extraLargeContainerSizeNwlBFI(int widthOption) {
        float fM9687constructorimpl;
        if (!IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3563getNarrowrc6NtMs())) {
            if (!IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3564getUniformrc6NtMs())) {
                if (IconButtonWidthOption.m3559equalsimpl0(widthOption, IconButtonWidthOption.INSTANCE.m3565getWiderc6NtMs())) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(XLargeIconButtonTokens.INSTANCE.m5966getWideLeadingSpaceD9Ej5fM() + XLargeIconButtonTokens.INSTANCE.m5967getWideTrailingSpaceD9Ej5fM());
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(XLargeIconButtonTokens.INSTANCE.m5960getDefaultLeadingSpaceD9Ej5fM() + XLargeIconButtonTokens.INSTANCE.m5960getDefaultLeadingSpaceD9Ej5fM());
            }
        } else {
            fM9687constructorimpl = Dp.m9687constructorimpl(XLargeIconButtonTokens.INSTANCE.m5963getNarrowLeadingSpaceD9Ej5fM() + XLargeIconButtonTokens.INSTANCE.m5964getNarrowTrailingSpaceD9Ej5fM());
        }
        return DpKt.m9709DpSizeYgX7TsA(Dp.m9687constructorimpl(XLargeIconButtonTokens.INSTANCE.m5962getIconSizeD9Ej5fM() + fM9687constructorimpl), XLargeIconButtonTokens.INSTANCE.m5959getContainerHeightD9Ej5fM());
    }

    /* JADX INFO: compiled from: IconButtonDefaults.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @JvmInline
    public static final class IconButtonWidthOption {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int Narrow = m3557constructorimpl(0);
        private static final int Uniform = m3557constructorimpl(1);
        private static final int Wide = m3557constructorimpl(2);
        private final int value;

        /* JADX INFO: renamed from: box-impl, reason: not valid java name */
        public static final /* synthetic */ IconButtonWidthOption m3556boximpl(int i) {
            return new IconButtonWidthOption(i);
        }

        /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
        private static int m3557constructorimpl(int i) {
            return i;
        }

        /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
        public static boolean m3558equalsimpl(int i, Object obj) {
            return (obj instanceof IconButtonWidthOption) && i == ((IconButtonWidthOption) obj).getValue();
        }

        /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m3559equalsimpl0(int i, int i2) {
            return i == i2;
        }

        /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
        public static int m3560hashCodeimpl(int i) {
            return Integer.hashCode(i);
        }

        public boolean equals(Object other) {
            return m3558equalsimpl(this.value, other);
        }

        public int hashCode() {
            return m3560hashCodeimpl(this.value);
        }

        /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
        public final /* synthetic */ int getValue() {
            return this.value;
        }

        /* JADX INFO: compiled from: IconButtonDefaults.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption$Companion;", "", "<init>", "()V", "Narrow", "Landroidx/compose/material3/IconButtonDefaults$IconButtonWidthOption;", "getNarrow-rc6NtMs", "()I", "I", "Uniform", "getUniform-rc6NtMs", "Wide", "getWide-rc6NtMs", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX INFO: renamed from: getNarrow-rc6NtMs, reason: not valid java name */
            public final int m3563getNarrowrc6NtMs() {
                return IconButtonWidthOption.Narrow;
            }

            /* JADX INFO: renamed from: getUniform-rc6NtMs, reason: not valid java name */
            public final int m3564getUniformrc6NtMs() {
                return IconButtonWidthOption.Uniform;
            }

            /* JADX INFO: renamed from: getWide-rc6NtMs, reason: not valid java name */
            public final int m3565getWiderc6NtMs() {
                return IconButtonWidthOption.Wide;
            }
        }

        private /* synthetic */ IconButtonWidthOption(int i) {
            this.value = i;
        }

        public String toString() {
            return m3561toStringimpl(this.value);
        }

        /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
        public static String m3561toStringimpl(int i) {
            if (m3559equalsimpl0(i, Narrow)) {
                return "Narrow";
            }
            if (m3559equalsimpl0(i, Uniform)) {
                return "Uniform";
            }
            return m3559equalsimpl0(i, Wide) ? "Wide" : "Unknown";
        }
    }
}
