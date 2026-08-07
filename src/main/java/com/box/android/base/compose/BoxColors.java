package com.box.android.base.compose;

import androidx.compose.ui.graphics.Color;
import androidx.media3.common.C;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BoxColors.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0003\bç\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0005\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0003\u0012\u0006\u0010&\u001a\u00020\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0003\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0003\u0012\u0006\u0010,\u001a\u00020\u0003\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0003\u0012\u0006\u0010/\u001a\u00020\u0003\u0012\u0006\u00100\u001a\u00020\u0003\u0012\u0006\u00101\u001a\u00020\u0003\u0012\u0006\u00102\u001a\u00020\u0003\u0012\u0006\u00103\u001a\u00020\u0003\u0012\u0006\u00104\u001a\u00020\u0003\u0012\u0006\u00105\u001a\u00020\u0003\u0012\u0006\u00106\u001a\u00020\u0003\u0012\u0006\u00107\u001a\u00020\u0003\u0012\u0006\u00108\u001a\u00020\u0003\u0012\u0006\u00109\u001a\u00020\u0003\u0012\u0006\u0010:\u001a\u00020\u0003\u0012\u0006\u0010;\u001a\u00020\u0003\u0012\u0006\u0010<\u001a\u00020\u0003\u0012\u0006\u0010=\u001a\u00020\u0003\u0012\u0006\u0010>\u001a\u00020\u0003\u0012\u0006\u0010?\u001a\u00020\u0003\u0012\u0006\u0010@\u001a\u00020\u0003\u0012\u0006\u0010A\u001a\u00020\u0003\u0012\u0006\u0010B\u001a\u00020\u0003\u0012\u0006\u0010C\u001a\u00020\u0003\u0012\u0006\u0010D\u001a\u00020\u0003\u0012\u0006\u0010E\u001a\u00020\u0003\u0012\u0006\u0010F\u001a\u00020\u0003\u0012\u0006\u0010G\u001a\u00020\u0003\u0012\u0006\u0010H\u001a\u00020\u0003\u0012\u0006\u0010I\u001a\u00020\u0003\u0012\u0006\u0010J\u001a\u00020\u0003\u0012\u0006\u0010K\u001a\u00020\u0003\u0012\u0006\u0010L\u001a\u00020\u0003\u0012\u0006\u0010M\u001a\u00020\u0003\u0012\u0006\u0010N\u001a\u00020\u0003\u0012\u0006\u0010O\u001a\u00020\u0003\u0012\u0006\u0010P\u001a\u00020\u0003\u0012\u0006\u0010Q\u001a\u00020\u0003\u0012\u0006\u0010R\u001a\u00020\u0003\u0012\u0006\u0010S\u001a\u00020\u0003\u0012\u0006\u0010T\u001a\u00020\u0003\u0012\u0006\u0010U\u001a\u00020\u0003\u0012\u0006\u0010V\u001a\u00020\u0003\u0012\u0006\u0010W\u001a\u00020\u0003\u0012\u0006\u0010X\u001a\u00020\u0003\u0012\u0006\u0010Y\u001a\u00020\u0003\u0012\u0006\u0010Z\u001a\u00020\u0003¢\u0006\u0004\b[\u0010\\J\u0012\u0010·\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b¸\u0001\u0010^J\u0012\u0010¹\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bº\u0001\u0010^J\u0012\u0010»\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b¼\u0001\u0010^J\u0012\u0010½\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b¾\u0001\u0010^J\u0012\u0010¿\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÀ\u0001\u0010^J\u0012\u0010Á\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÂ\u0001\u0010^J\u0012\u0010Ã\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÄ\u0001\u0010^J\u0012\u0010Å\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÆ\u0001\u0010^J\u0012\u0010Ç\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÈ\u0001\u0010^J\u0012\u0010É\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÊ\u0001\u0010^J\u0012\u0010Ë\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÌ\u0001\u0010^J\u0012\u0010Í\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÎ\u0001\u0010^J\u0012\u0010Ï\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÐ\u0001\u0010^J\u0012\u0010Ñ\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÒ\u0001\u0010^J\u0012\u0010Ó\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÔ\u0001\u0010^J\u0012\u0010Õ\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÖ\u0001\u0010^J\u0012\u0010×\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bØ\u0001\u0010^J\u0012\u0010Ù\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÚ\u0001\u0010^J\u0012\u0010Û\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÜ\u0001\u0010^J\u0012\u0010Ý\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÞ\u0001\u0010^J\u0012\u0010ß\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bà\u0001\u0010^J\u0012\u0010á\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bâ\u0001\u0010^J\u0012\u0010ã\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bä\u0001\u0010^J\u0012\u0010å\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bæ\u0001\u0010^J\u0012\u0010ç\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bè\u0001\u0010^J\u0012\u0010é\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bê\u0001\u0010^J\u0012\u0010ë\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bì\u0001\u0010^J\u0012\u0010í\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bî\u0001\u0010^J\u0012\u0010ï\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bð\u0001\u0010^J\u0012\u0010ñ\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bò\u0001\u0010^J\u0012\u0010ó\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bô\u0001\u0010^J\u0012\u0010õ\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bö\u0001\u0010^J\u0012\u0010÷\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bø\u0001\u0010^J\u0012\u0010ù\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bú\u0001\u0010^J\u0012\u0010û\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bü\u0001\u0010^J\u0012\u0010ý\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bþ\u0001\u0010^J\u0012\u0010ÿ\u0001\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u0080\u0002\u0010^J\u0012\u0010\u0081\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u0082\u0002\u0010^J\u0012\u0010\u0083\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u0084\u0002\u0010^J\u0012\u0010\u0085\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u0086\u0002\u0010^J\u0012\u0010\u0087\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u0088\u0002\u0010^J\u0012\u0010\u0089\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u008a\u0002\u0010^J\u0012\u0010\u008b\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u008c\u0002\u0010^J\u0012\u0010\u008d\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u008e\u0002\u0010^J\u0012\u0010\u008f\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u0090\u0002\u0010^J\u0012\u0010\u0091\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u0092\u0002\u0010^J\u0012\u0010\u0093\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u0094\u0002\u0010^J\u0012\u0010\u0095\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u0096\u0002\u0010^J\u0012\u0010\u0097\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u0098\u0002\u0010^J\u0012\u0010\u0099\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u009a\u0002\u0010^J\u0012\u0010\u009b\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u009c\u0002\u0010^J\u0012\u0010\u009d\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b\u009e\u0002\u0010^J\u0012\u0010\u009f\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b \u0002\u0010^J\u0012\u0010¡\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b¢\u0002\u0010^J\u0012\u0010£\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b¤\u0002\u0010^J\u0012\u0010¥\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b¦\u0002\u0010^J\u0012\u0010§\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b¨\u0002\u0010^J\u0012\u0010©\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bª\u0002\u0010^J\u0012\u0010«\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b¬\u0002\u0010^J\u0012\u0010\u00ad\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b®\u0002\u0010^J\u0012\u0010¯\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b°\u0002\u0010^J\u0012\u0010±\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b²\u0002\u0010^J\u0012\u0010³\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b´\u0002\u0010^J\u0012\u0010µ\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b¶\u0002\u0010^J\u0012\u0010·\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b¸\u0002\u0010^J\u0012\u0010¹\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bº\u0002\u0010^J\u0012\u0010»\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b¼\u0002\u0010^J\u0012\u0010½\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\b¾\u0002\u0010^J\u0012\u0010¿\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÀ\u0002\u0010^J\u0012\u0010Á\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÂ\u0002\u0010^J\u0012\u0010Ã\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÄ\u0002\u0010^J\u0012\u0010Å\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÆ\u0002\u0010^J\u0012\u0010Ç\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÈ\u0002\u0010^J\u0012\u0010É\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÊ\u0002\u0010^J\u0012\u0010Ë\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÌ\u0002\u0010^J\u0012\u0010Í\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÎ\u0002\u0010^J\u0012\u0010Ï\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÐ\u0002\u0010^J\u0012\u0010Ñ\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÒ\u0002\u0010^J\u0012\u0010Ó\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÔ\u0002\u0010^J\u0012\u0010Õ\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÖ\u0002\u0010^J\u0012\u0010×\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bØ\u0002\u0010^J\u0012\u0010Ù\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÚ\u0002\u0010^J\u0012\u0010Û\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÜ\u0002\u0010^J\u0012\u0010Ý\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bÞ\u0002\u0010^J\u0012\u0010ß\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bà\u0002\u0010^J\u0012\u0010á\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bâ\u0002\u0010^J\u0012\u0010ã\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bä\u0002\u0010^J\u0012\u0010å\u0002\u001a\u00020\u0003HÆ\u0003¢\u0006\u0005\bæ\u0002\u0010^J\u0083\u0007\u0010ç\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00032\b\b\u0002\u0010&\u001a\u00020\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00032\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00032\b\b\u0002\u0010,\u001a\u00020\u00032\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\u00032\b\b\u0002\u00100\u001a\u00020\u00032\b\b\u0002\u00101\u001a\u00020\u00032\b\b\u0002\u00102\u001a\u00020\u00032\b\b\u0002\u00103\u001a\u00020\u00032\b\b\u0002\u00104\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u00032\b\b\u0002\u00107\u001a\u00020\u00032\b\b\u0002\u00108\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u00032\b\b\u0002\u0010:\u001a\u00020\u00032\b\b\u0002\u0010;\u001a\u00020\u00032\b\b\u0002\u0010<\u001a\u00020\u00032\b\b\u0002\u0010=\u001a\u00020\u00032\b\b\u0002\u0010>\u001a\u00020\u00032\b\b\u0002\u0010?\u001a\u00020\u00032\b\b\u0002\u0010@\u001a\u00020\u00032\b\b\u0002\u0010A\u001a\u00020\u00032\b\b\u0002\u0010B\u001a\u00020\u00032\b\b\u0002\u0010C\u001a\u00020\u00032\b\b\u0002\u0010D\u001a\u00020\u00032\b\b\u0002\u0010E\u001a\u00020\u00032\b\b\u0002\u0010F\u001a\u00020\u00032\b\b\u0002\u0010G\u001a\u00020\u00032\b\b\u0002\u0010H\u001a\u00020\u00032\b\b\u0002\u0010I\u001a\u00020\u00032\b\b\u0002\u0010J\u001a\u00020\u00032\b\b\u0002\u0010K\u001a\u00020\u00032\b\b\u0002\u0010L\u001a\u00020\u00032\b\b\u0002\u0010M\u001a\u00020\u00032\b\b\u0002\u0010N\u001a\u00020\u00032\b\b\u0002\u0010O\u001a\u00020\u00032\b\b\u0002\u0010P\u001a\u00020\u00032\b\b\u0002\u0010Q\u001a\u00020\u00032\b\b\u0002\u0010R\u001a\u00020\u00032\b\b\u0002\u0010S\u001a\u00020\u00032\b\b\u0002\u0010T\u001a\u00020\u00032\b\b\u0002\u0010U\u001a\u00020\u00032\b\b\u0002\u0010V\u001a\u00020\u00032\b\b\u0002\u0010W\u001a\u00020\u00032\b\b\u0002\u0010X\u001a\u00020\u00032\b\b\u0002\u0010Y\u001a\u00020\u00032\b\b\u0002\u0010Z\u001a\u00020\u0003HÆ\u0001¢\u0006\u0006\bè\u0002\u0010é\u0002J\u0016\u0010ê\u0002\u001a\u00030ë\u00022\t\u0010ì\u0002\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000b\u0010í\u0002\u001a\u00030î\u0002HÖ\u0001J\u000b\u0010ï\u0002\u001a\u00030ð\u0002HÖ\u0001R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\b]\u0010^R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\b`\u0010^R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\ba\u0010^R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bb\u0010^R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bc\u0010^R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bd\u0010^R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\be\u0010^R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bf\u0010^R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bg\u0010^R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bh\u0010^R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bi\u0010^R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bj\u0010^R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bk\u0010^R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bl\u0010^R\u0013\u0010\u0011\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bm\u0010^R\u0013\u0010\u0012\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bn\u0010^R\u0013\u0010\u0013\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bo\u0010^R\u0013\u0010\u0014\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bp\u0010^R\u0013\u0010\u0015\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bq\u0010^R\u0013\u0010\u0016\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\br\u0010^R\u0013\u0010\u0017\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bs\u0010^R\u0013\u0010\u0018\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bt\u0010^R\u0013\u0010\u0019\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bu\u0010^R\u0013\u0010\u001a\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bv\u0010^R\u0013\u0010\u001b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bw\u0010^R\u0013\u0010\u001c\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bx\u0010^R\u0013\u0010\u001d\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\by\u0010^R\u0013\u0010\u001e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\bz\u0010^R\u0013\u0010\u001f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\b{\u0010^R\u0013\u0010 \u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\b|\u0010^R\u0013\u0010!\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\b}\u0010^R\u0013\u0010\"\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\b~\u0010^R\u0013\u0010#\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010_\u001a\u0004\b\u007f\u0010^R\u0014\u0010$\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0080\u0001\u0010^R\u0014\u0010%\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0081\u0001\u0010^R\u0014\u0010&\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0082\u0001\u0010^R\u0014\u0010'\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0083\u0001\u0010^R\u0014\u0010(\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0084\u0001\u0010^R\u0014\u0010)\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0085\u0001\u0010^R\u0014\u0010*\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0086\u0001\u0010^R\u0014\u0010+\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0087\u0001\u0010^R\u0014\u0010,\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0088\u0001\u0010^R\u0014\u0010-\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0089\u0001\u0010^R\u0014\u0010.\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u008a\u0001\u0010^R\u0014\u0010/\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u008b\u0001\u0010^R\u0014\u00100\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u008c\u0001\u0010^R\u0014\u00101\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u008d\u0001\u0010^R\u0014\u00102\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u008e\u0001\u0010^R\u0014\u00103\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u008f\u0001\u0010^R\u0014\u00104\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0090\u0001\u0010^R\u0014\u00105\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0091\u0001\u0010^R\u0014\u00106\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0092\u0001\u0010^R\u0014\u00107\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0093\u0001\u0010^R\u0014\u00108\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0094\u0001\u0010^R\u0014\u00109\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0095\u0001\u0010^R\u0014\u0010:\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0096\u0001\u0010^R\u0014\u0010;\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0097\u0001\u0010^R\u0014\u0010<\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0098\u0001\u0010^R\u0014\u0010=\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u0099\u0001\u0010^R\u0014\u0010>\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u009a\u0001\u0010^R\u0014\u0010?\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u009b\u0001\u0010^R\u0014\u0010@\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u009c\u0001\u0010^R\u0014\u0010A\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u009d\u0001\u0010^R\u0014\u0010B\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u009e\u0001\u0010^R\u0014\u0010C\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u009f\u0001\u0010^R\u0014\u0010D\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b \u0001\u0010^R\u0014\u0010E\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b¡\u0001\u0010^R\u0014\u0010F\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b¢\u0001\u0010^R\u0014\u0010G\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b£\u0001\u0010^R\u0014\u0010H\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b¤\u0001\u0010^R\u0014\u0010I\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b¥\u0001\u0010^R\u0014\u0010J\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b¦\u0001\u0010^R\u0014\u0010K\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b§\u0001\u0010^R\u0014\u0010L\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b¨\u0001\u0010^R\u0014\u0010M\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b©\u0001\u0010^R\u0014\u0010N\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\bª\u0001\u0010^R\u0014\u0010O\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b«\u0001\u0010^R\u0014\u0010P\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b¬\u0001\u0010^R\u0014\u0010Q\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b\u00ad\u0001\u0010^R\u0014\u0010R\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b®\u0001\u0010^R\u0014\u0010S\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b¯\u0001\u0010^R\u0014\u0010T\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b°\u0001\u0010^R\u0014\u0010U\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b±\u0001\u0010^R\u0014\u0010V\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b²\u0001\u0010^R\u0014\u0010W\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b³\u0001\u0010^R\u0014\u0010X\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b´\u0001\u0010^R\u0014\u0010Y\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\bµ\u0001\u0010^R\u0014\u0010Z\u001a\u00020\u0003¢\u0006\u000b\n\u0002\u0010_\u001a\u0005\b¶\u0001\u0010^¨\u0006ñ\u0002"}, d2 = {"Lcom/box/android/base/compose/BoxColors;", "", "appBackground", "Landroidx/compose/ui/graphics/Color;", "appBackgroundAlt", "appPrimary", "contentBackground", "contentBackgroundSelectedSecondary", "contentSecondary", "contentSecondarySelected", "popupBackground", "popupSecondary", "topBarBackground", "topBarBackgroundSecondary", "topBarText", "topBarTextSecondary", "topBarControl", "topBarControlSecondary", "topbarTextTertiary", "topLayerBackground", "topLayerInteractiveBackground", "topLayerInteractiveBackgroundDisabled", "topLayerInteractiveSecondary", "mainActiveControl", "mainInactiveControl", "mainActiveControlBackground", "mainActiveControlContent", "defaultActionIconBackground", "tooltipBackground", "itemInfoTextSecondary", "itemInfoTextTertiary", "mentionsPopupBackground", "previewSearchHighlight", "previewCitationHighlight", "thumbnailFileIconBackgroundColor", "statusDone", "statusInProgress", "dialogContainer", "divider", "secondaryDivider", "notificationText", "notificationContainer", "textFieldText", "textFieldContainer", "textFieldCursor", "textFieldError", "textFieldIndicator", "textFieldLabel", "textFieldPlaceholder", "textFieldSupportingText", "textFieldSelection", "textFieldSelectionHandle", "textFieldSelectionAlt", "textFieldSelectionHandleAlt", "searchTextFieldPlaceholder", "snackbarContainer", "snackbarContent", "snackbarAction", "itemListingContentBackground", "itemListingContentBackgroundSelected", "itemListingDivider", "itemListingBadgeContent", "itemListingBadgeBackground", "fileActivityVersionItemBackground", "fileActivityContentBackgroundSelected", "fileActivityReplyIndicator", "fileActivityReplyIndicatorSelected", "previewBackground", "fabButtonBackground", "fabButtonContent", "favoriteIndicatorColor", "favoriteIndicatorSelectedColor", "noteUnreadIndicatorColor", "tabRowUnselectedContent", "navigationBarUnselectedContent", "collectionIconBackground", "collectionIcon", "collectionFavoritesIconBackground", "collectionFavoritesIcon", "searchBarCapsuleBackground", "searchBarCapsuleContent", "searchIconContent", "searchIconBackground", "searchFilterChipContent", "searchFilterChipBackground", "checkboxCheckedColor", "checkboxUncheckedColor", "checkboxCheckmarkColor", "boxAiLabelBackground", "boxAiGradientTextStart", "boxAiGradientTextEnd", "<init>", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAppBackground-0d7_KjU", "()J", "J", "getAppBackgroundAlt-0d7_KjU", "getAppPrimary-0d7_KjU", "getContentBackground-0d7_KjU", "getContentBackgroundSelectedSecondary-0d7_KjU", "getContentSecondary-0d7_KjU", "getContentSecondarySelected-0d7_KjU", "getPopupBackground-0d7_KjU", "getPopupSecondary-0d7_KjU", "getTopBarBackground-0d7_KjU", "getTopBarBackgroundSecondary-0d7_KjU", "getTopBarText-0d7_KjU", "getTopBarTextSecondary-0d7_KjU", "getTopBarControl-0d7_KjU", "getTopBarControlSecondary-0d7_KjU", "getTopbarTextTertiary-0d7_KjU", "getTopLayerBackground-0d7_KjU", "getTopLayerInteractiveBackground-0d7_KjU", "getTopLayerInteractiveBackgroundDisabled-0d7_KjU", "getTopLayerInteractiveSecondary-0d7_KjU", "getMainActiveControl-0d7_KjU", "getMainInactiveControl-0d7_KjU", "getMainActiveControlBackground-0d7_KjU", "getMainActiveControlContent-0d7_KjU", "getDefaultActionIconBackground-0d7_KjU", "getTooltipBackground-0d7_KjU", "getItemInfoTextSecondary-0d7_KjU", "getItemInfoTextTertiary-0d7_KjU", "getMentionsPopupBackground-0d7_KjU", "getPreviewSearchHighlight-0d7_KjU", "getPreviewCitationHighlight-0d7_KjU", "getThumbnailFileIconBackgroundColor-0d7_KjU", "getStatusDone-0d7_KjU", "getStatusInProgress-0d7_KjU", "getDialogContainer-0d7_KjU", "getDivider-0d7_KjU", "getSecondaryDivider-0d7_KjU", "getNotificationText-0d7_KjU", "getNotificationContainer-0d7_KjU", "getTextFieldText-0d7_KjU", "getTextFieldContainer-0d7_KjU", "getTextFieldCursor-0d7_KjU", "getTextFieldError-0d7_KjU", "getTextFieldIndicator-0d7_KjU", "getTextFieldLabel-0d7_KjU", "getTextFieldPlaceholder-0d7_KjU", "getTextFieldSupportingText-0d7_KjU", "getTextFieldSelection-0d7_KjU", "getTextFieldSelectionHandle-0d7_KjU", "getTextFieldSelectionAlt-0d7_KjU", "getTextFieldSelectionHandleAlt-0d7_KjU", "getSearchTextFieldPlaceholder-0d7_KjU", "getSnackbarContainer-0d7_KjU", "getSnackbarContent-0d7_KjU", "getSnackbarAction-0d7_KjU", "getItemListingContentBackground-0d7_KjU", "getItemListingContentBackgroundSelected-0d7_KjU", "getItemListingDivider-0d7_KjU", "getItemListingBadgeContent-0d7_KjU", "getItemListingBadgeBackground-0d7_KjU", "getFileActivityVersionItemBackground-0d7_KjU", "getFileActivityContentBackgroundSelected-0d7_KjU", "getFileActivityReplyIndicator-0d7_KjU", "getFileActivityReplyIndicatorSelected-0d7_KjU", "getPreviewBackground-0d7_KjU", "getFabButtonBackground-0d7_KjU", "getFabButtonContent-0d7_KjU", "getFavoriteIndicatorColor-0d7_KjU", "getFavoriteIndicatorSelectedColor-0d7_KjU", "getNoteUnreadIndicatorColor-0d7_KjU", "getTabRowUnselectedContent-0d7_KjU", "getNavigationBarUnselectedContent-0d7_KjU", "getCollectionIconBackground-0d7_KjU", "getCollectionIcon-0d7_KjU", "getCollectionFavoritesIconBackground-0d7_KjU", "getCollectionFavoritesIcon-0d7_KjU", "getSearchBarCapsuleBackground-0d7_KjU", "getSearchBarCapsuleContent-0d7_KjU", "getSearchIconContent-0d7_KjU", "getSearchIconBackground-0d7_KjU", "getSearchFilterChipContent-0d7_KjU", "getSearchFilterChipBackground-0d7_KjU", "getCheckboxCheckedColor-0d7_KjU", "getCheckboxUncheckedColor-0d7_KjU", "getCheckboxCheckmarkColor-0d7_KjU", "getBoxAiLabelBackground-0d7_KjU", "getBoxAiGradientTextStart-0d7_KjU", "getBoxAiGradientTextEnd-0d7_KjU", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "component6", "component6-0d7_KjU", "component7", "component7-0d7_KjU", "component8", "component8-0d7_KjU", "component9", "component9-0d7_KjU", "component10", "component10-0d7_KjU", "component11", "component11-0d7_KjU", "component12", "component12-0d7_KjU", "component13", "component13-0d7_KjU", "component14", "component14-0d7_KjU", "component15", "component15-0d7_KjU", "component16", "component16-0d7_KjU", "component17", "component17-0d7_KjU", "component18", "component18-0d7_KjU", "component19", "component19-0d7_KjU", "component20", "component20-0d7_KjU", "component21", "component21-0d7_KjU", "component22", "component22-0d7_KjU", "component23", "component23-0d7_KjU", "component24", "component24-0d7_KjU", "component25", "component25-0d7_KjU", "component26", "component26-0d7_KjU", "component27", "component27-0d7_KjU", "component28", "component28-0d7_KjU", "component29", "component29-0d7_KjU", "component30", "component30-0d7_KjU", "component31", "component31-0d7_KjU", "component32", "component32-0d7_KjU", "component33", "component33-0d7_KjU", "component34", "component34-0d7_KjU", "component35", "component35-0d7_KjU", "component36", "component36-0d7_KjU", "component37", "component37-0d7_KjU", "component38", "component38-0d7_KjU", "component39", "component39-0d7_KjU", "component40", "component40-0d7_KjU", "component41", "component41-0d7_KjU", "component42", "component42-0d7_KjU", "component43", "component43-0d7_KjU", "component44", "component44-0d7_KjU", "component45", "component45-0d7_KjU", "component46", "component46-0d7_KjU", "component47", "component47-0d7_KjU", "component48", "component48-0d7_KjU", "component49", "component49-0d7_KjU", "component50", "component50-0d7_KjU", "component51", "component51-0d7_KjU", "component52", "component52-0d7_KjU", "component53", "component53-0d7_KjU", "component54", "component54-0d7_KjU", "component55", "component55-0d7_KjU", "component56", "component56-0d7_KjU", "component57", "component57-0d7_KjU", "component58", "component58-0d7_KjU", "component59", "component59-0d7_KjU", "component60", "component60-0d7_KjU", "component61", "component61-0d7_KjU", "component62", "component62-0d7_KjU", "component63", "component63-0d7_KjU", "component64", "component64-0d7_KjU", "component65", "component65-0d7_KjU", "component66", "component66-0d7_KjU", "component67", "component67-0d7_KjU", "component68", "component68-0d7_KjU", "component69", "component69-0d7_KjU", "component70", "component70-0d7_KjU", "component71", "component71-0d7_KjU", "component72", "component72-0d7_KjU", "component73", "component73-0d7_KjU", "component74", "component74-0d7_KjU", "component75", "component75-0d7_KjU", "component76", "component76-0d7_KjU", "component77", "component77-0d7_KjU", "component78", "component78-0d7_KjU", "component79", "component79-0d7_KjU", "component80", "component80-0d7_KjU", "component81", "component81-0d7_KjU", "component82", "component82-0d7_KjU", "component83", "component83-0d7_KjU", "component84", "component84-0d7_KjU", "component85", "component85-0d7_KjU", "component86", "component86-0d7_KjU", "component87", "component87-0d7_KjU", "component88", "component88-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-b6m_y3s", "(JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ)Lcom/box/android/base/compose/BoxColors;", "equals", "", "other", "hashCode", "", "toString", "", "base_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class BoxColors {
    public static final int $stable = 0;
    private final long appBackground;
    private final long appBackgroundAlt;
    private final long appPrimary;
    private final long boxAiGradientTextEnd;
    private final long boxAiGradientTextStart;
    private final long boxAiLabelBackground;
    private final long checkboxCheckedColor;
    private final long checkboxCheckmarkColor;
    private final long checkboxUncheckedColor;
    private final long collectionFavoritesIcon;
    private final long collectionFavoritesIconBackground;
    private final long collectionIcon;
    private final long collectionIconBackground;
    private final long contentBackground;
    private final long contentBackgroundSelectedSecondary;
    private final long contentSecondary;
    private final long contentSecondarySelected;
    private final long defaultActionIconBackground;
    private final long dialogContainer;
    private final long divider;
    private final long fabButtonBackground;
    private final long fabButtonContent;
    private final long favoriteIndicatorColor;
    private final long favoriteIndicatorSelectedColor;
    private final long fileActivityContentBackgroundSelected;
    private final long fileActivityReplyIndicator;
    private final long fileActivityReplyIndicatorSelected;
    private final long fileActivityVersionItemBackground;
    private final long itemInfoTextSecondary;
    private final long itemInfoTextTertiary;
    private final long itemListingBadgeBackground;
    private final long itemListingBadgeContent;
    private final long itemListingContentBackground;
    private final long itemListingContentBackgroundSelected;
    private final long itemListingDivider;
    private final long mainActiveControl;
    private final long mainActiveControlBackground;
    private final long mainActiveControlContent;
    private final long mainInactiveControl;
    private final long mentionsPopupBackground;
    private final long navigationBarUnselectedContent;
    private final long noteUnreadIndicatorColor;
    private final long notificationContainer;
    private final long notificationText;
    private final long popupBackground;
    private final long popupSecondary;
    private final long previewBackground;
    private final long previewCitationHighlight;
    private final long previewSearchHighlight;
    private final long searchBarCapsuleBackground;
    private final long searchBarCapsuleContent;
    private final long searchFilterChipBackground;
    private final long searchFilterChipContent;
    private final long searchIconBackground;
    private final long searchIconContent;
    private final long searchTextFieldPlaceholder;
    private final long secondaryDivider;
    private final long snackbarAction;
    private final long snackbarContainer;
    private final long snackbarContent;
    private final long statusDone;
    private final long statusInProgress;
    private final long tabRowUnselectedContent;
    private final long textFieldContainer;
    private final long textFieldCursor;
    private final long textFieldError;
    private final long textFieldIndicator;
    private final long textFieldLabel;
    private final long textFieldPlaceholder;
    private final long textFieldSelection;
    private final long textFieldSelectionAlt;
    private final long textFieldSelectionHandle;
    private final long textFieldSelectionHandleAlt;
    private final long textFieldSupportingText;
    private final long textFieldText;
    private final long thumbnailFileIconBackgroundColor;
    private final long tooltipBackground;
    private final long topBarBackground;
    private final long topBarBackgroundSecondary;
    private final long topBarControl;
    private final long topBarControlSecondary;
    private final long topBarText;
    private final long topBarTextSecondary;
    private final long topLayerBackground;
    private final long topLayerInteractiveBackground;
    private final long topLayerInteractiveBackgroundDisabled;
    private final long topLayerInteractiveSecondary;
    private final long topbarTextTertiary;

    public /* synthetic */ BoxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48, long j49, long j50, long j51, long j52, long j53, long j54, long j55, long j56, long j57, long j58, long j59, long j60, long j61, long j62, long j63, long j64, long j65, long j66, long j67, long j68, long j69, long j70, long j71, long j72, long j73, long j74, long j75, long j76, long j77, long j78, long j79, long j80, long j81, long j82, long j83, long j84, long j85, long j86, long j87, long j88, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17, j18, j19, j20, j21, j22, j23, j24, j25, j26, j27, j28, j29, j30, j31, j32, j33, j34, j35, j36, j37, j38, j39, j40, j41, j42, j43, j44, j45, j46, j47, j48, j49, j50, j51, j52, j53, j54, j55, j56, j57, j58, j59, j60, j61, j62, j63, j64, j65, j66, j67, j68, j69, j70, j71, j72, j73, j74, j75, j76, j77, j78, j79, j80, j81, j82, j83, j84, j85, j86, j87, j88);
    }

    /* JADX INFO: renamed from: copy-b6m_y3s$default, reason: not valid java name */
    public static /* synthetic */ BoxColors m11408copyb6m_y3s$default(BoxColors boxColors, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48, long j49, long j50, long j51, long j52, long j53, long j54, long j55, long j56, long j57, long j58, long j59, long j60, long j61, long j62, long j63, long j64, long j65, long j66, long j67, long j68, long j69, long j70, long j71, long j72, long j73, long j74, long j75, long j76, long j77, long j78, long j79, long j80, long j81, long j82, long j83, long j84, long j85, long j86, long j87, long j88, int i, int i2, int i3, Object obj) {
        long j89;
        long j90;
        long j91 = (i & 1) != 0 ? boxColors.appBackground : j;
        long j92 = (i & 2) != 0 ? boxColors.appBackgroundAlt : j2;
        long j93 = (i & 4) != 0 ? boxColors.appPrimary : j3;
        long j94 = (i & 8) != 0 ? boxColors.contentBackground : j4;
        long j95 = (i & 16) != 0 ? boxColors.contentBackgroundSelectedSecondary : j5;
        long j96 = (i & 32) != 0 ? boxColors.contentSecondary : j6;
        long j97 = (i & 64) != 0 ? boxColors.contentSecondarySelected : j7;
        long j98 = (i & 128) != 0 ? boxColors.popupBackground : j8;
        long j99 = (i & 256) != 0 ? boxColors.popupSecondary : j9;
        long j100 = (i & 512) != 0 ? boxColors.topBarBackground : j10;
        long j101 = (i & 1024) != 0 ? boxColors.topBarBackgroundSecondary : j11;
        long j102 = (i & 2048) != 0 ? boxColors.topBarText : j12;
        long j103 = (i & 4096) != 0 ? boxColors.topBarTextSecondary : j13;
        long j104 = (i & 8192) != 0 ? boxColors.topBarControl : j14;
        long j105 = (i & 16384) != 0 ? boxColors.topBarControlSecondary : j15;
        long j106 = (i & 32768) != 0 ? boxColors.topbarTextTertiary : j16;
        long j107 = (i & 65536) != 0 ? boxColors.topLayerBackground : j17;
        long j108 = (i & 131072) != 0 ? boxColors.topLayerInteractiveBackground : j18;
        long j109 = (i & 262144) != 0 ? boxColors.topLayerInteractiveBackgroundDisabled : j19;
        long j110 = (i & 524288) != 0 ? boxColors.topLayerInteractiveSecondary : j20;
        long j111 = (i & 1048576) != 0 ? boxColors.mainActiveControl : j21;
        long j112 = (i & 2097152) != 0 ? boxColors.mainInactiveControl : j22;
        long j113 = (i & 4194304) != 0 ? boxColors.mainActiveControlBackground : j23;
        long j114 = (i & 8388608) != 0 ? boxColors.mainActiveControlContent : j24;
        long j115 = (i & 16777216) != 0 ? boxColors.defaultActionIconBackground : j25;
        long j116 = (i & 33554432) != 0 ? boxColors.tooltipBackground : j26;
        long j117 = (i & 67108864) != 0 ? boxColors.itemInfoTextSecondary : j27;
        long j118 = (i & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? boxColors.itemInfoTextTertiary : j28;
        long j119 = (i & 268435456) != 0 ? boxColors.mentionsPopupBackground : j29;
        long j120 = (i & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? boxColors.previewSearchHighlight : j30;
        long j121 = (i & 1073741824) != 0 ? boxColors.previewCitationHighlight : j31;
        long j122 = (i & Integer.MIN_VALUE) != 0 ? boxColors.thumbnailFileIconBackgroundColor : j32;
        long j123 = (i2 & 1) != 0 ? boxColors.statusDone : j33;
        long j124 = (i2 & 2) != 0 ? boxColors.statusInProgress : j34;
        long j125 = (i2 & 4) != 0 ? boxColors.dialogContainer : j35;
        long j126 = (i2 & 8) != 0 ? boxColors.divider : j36;
        long j127 = (i2 & 16) != 0 ? boxColors.secondaryDivider : j37;
        long j128 = (i2 & 32) != 0 ? boxColors.notificationText : j38;
        long j129 = (i2 & 64) != 0 ? boxColors.notificationContainer : j39;
        long j130 = (i2 & 128) != 0 ? boxColors.textFieldText : j40;
        long j131 = (i2 & 256) != 0 ? boxColors.textFieldContainer : j41;
        long j132 = (i2 & 512) != 0 ? boxColors.textFieldCursor : j42;
        long j133 = (i2 & 1024) != 0 ? boxColors.textFieldError : j43;
        long j134 = (i2 & 2048) != 0 ? boxColors.textFieldIndicator : j44;
        long j135 = (i2 & 4096) != 0 ? boxColors.textFieldLabel : j45;
        long j136 = (i2 & 8192) != 0 ? boxColors.textFieldPlaceholder : j46;
        long j137 = (i2 & 16384) != 0 ? boxColors.textFieldSupportingText : j47;
        long j138 = (i2 & 32768) != 0 ? boxColors.textFieldSelection : j48;
        long j139 = (i2 & 65536) != 0 ? boxColors.textFieldSelectionHandle : j49;
        long j140 = (i2 & 131072) != 0 ? boxColors.textFieldSelectionAlt : j50;
        long j141 = (i2 & 262144) != 0 ? boxColors.textFieldSelectionHandleAlt : j51;
        long j142 = (i2 & 524288) != 0 ? boxColors.searchTextFieldPlaceholder : j52;
        long j143 = (i2 & 1048576) != 0 ? boxColors.snackbarContainer : j53;
        long j144 = (i2 & 2097152) != 0 ? boxColors.snackbarContent : j54;
        long j145 = (i2 & 4194304) != 0 ? boxColors.snackbarAction : j55;
        long j146 = (i2 & 8388608) != 0 ? boxColors.itemListingContentBackground : j56;
        long j147 = (i2 & 16777216) != 0 ? boxColors.itemListingContentBackgroundSelected : j57;
        long j148 = (i2 & 33554432) != 0 ? boxColors.itemListingDivider : j58;
        long j149 = (i2 & 67108864) != 0 ? boxColors.itemListingBadgeContent : j59;
        long j150 = (i2 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? boxColors.itemListingBadgeBackground : j60;
        long j151 = (i2 & 268435456) != 0 ? boxColors.fileActivityVersionItemBackground : j61;
        long j152 = (i2 & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? boxColors.fileActivityContentBackgroundSelected : j62;
        long j153 = (i2 & 1073741824) != 0 ? boxColors.fileActivityReplyIndicator : j63;
        long j154 = (i2 & Integer.MIN_VALUE) != 0 ? boxColors.fileActivityReplyIndicatorSelected : j64;
        long j155 = (i3 & 1) != 0 ? boxColors.previewBackground : j65;
        long j156 = (i3 & 2) != 0 ? boxColors.fabButtonBackground : j66;
        long j157 = (i3 & 4) != 0 ? boxColors.fabButtonContent : j67;
        long j158 = (i3 & 8) != 0 ? boxColors.favoriteIndicatorColor : j68;
        long j159 = (i3 & 16) != 0 ? boxColors.favoriteIndicatorSelectedColor : j69;
        long j160 = (i3 & 32) != 0 ? boxColors.noteUnreadIndicatorColor : j70;
        long j161 = (i3 & 64) != 0 ? boxColors.tabRowUnselectedContent : j71;
        long j162 = (i3 & 128) != 0 ? boxColors.navigationBarUnselectedContent : j72;
        long j163 = (i3 & 256) != 0 ? boxColors.collectionIconBackground : j73;
        long j164 = (i3 & 512) != 0 ? boxColors.collectionIcon : j74;
        long j165 = (i3 & 1024) != 0 ? boxColors.collectionFavoritesIconBackground : j75;
        long j166 = (i3 & 2048) != 0 ? boxColors.collectionFavoritesIcon : j76;
        long j167 = (i3 & 4096) != 0 ? boxColors.searchBarCapsuleBackground : j77;
        long j168 = (i3 & 8192) != 0 ? boxColors.searchBarCapsuleContent : j78;
        long j169 = (i3 & 16384) != 0 ? boxColors.searchIconContent : j79;
        long j170 = (i3 & 32768) != 0 ? boxColors.searchIconBackground : j80;
        long j171 = (i3 & 65536) != 0 ? boxColors.searchFilterChipContent : j81;
        long j172 = (i3 & 131072) != 0 ? boxColors.searchFilterChipBackground : j82;
        long j173 = (i3 & 262144) != 0 ? boxColors.checkboxCheckedColor : j83;
        long j174 = (i3 & 524288) != 0 ? boxColors.checkboxUncheckedColor : j84;
        long j175 = (i3 & 1048576) != 0 ? boxColors.checkboxCheckmarkColor : j85;
        long j176 = (i3 & 2097152) != 0 ? boxColors.boxAiLabelBackground : j86;
        long j177 = (i3 & 4194304) != 0 ? boxColors.boxAiGradientTextStart : j87;
        if ((i3 & 8388608) != 0) {
            j90 = j177;
            j89 = boxColors.boxAiGradientTextEnd;
        } else {
            j89 = j88;
            j90 = j177;
        }
        return boxColors.m11497copyb6m_y3s(j91, j92, j93, j94, j95, j96, j97, j98, j99, j100, j101, j102, j103, j104, j105, j106, j107, j108, j109, j110, j111, j112, j113, j114, j115, j116, j117, j118, j119, j120, j121, j122, j123, j124, j125, j126, j127, j128, j129, j130, j131, j132, j133, j134, j135, j136, j137, j138, j139, j140, j141, j142, j143, j144, j145, j146, j147, j148, j149, j150, j151, j152, j153, j154, j155, j156, j157, j158, j159, j160, j161, j162, j163, j164, j165, j166, j167, j168, j169, j170, j171, j172, j173, j174, j175, j176, j90, j89);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
    public final long getAppBackground() {
        return this.appBackground;
    }

    /* JADX INFO: renamed from: component10-0d7_KjU, reason: not valid java name and from getter */
    public final long getTopBarBackground() {
        return this.topBarBackground;
    }

    /* JADX INFO: renamed from: component11-0d7_KjU, reason: not valid java name and from getter */
    public final long getTopBarBackgroundSecondary() {
        return this.topBarBackgroundSecondary;
    }

    /* JADX INFO: renamed from: component12-0d7_KjU, reason: not valid java name and from getter */
    public final long getTopBarText() {
        return this.topBarText;
    }

    /* JADX INFO: renamed from: component13-0d7_KjU, reason: not valid java name and from getter */
    public final long getTopBarTextSecondary() {
        return this.topBarTextSecondary;
    }

    /* JADX INFO: renamed from: component14-0d7_KjU, reason: not valid java name and from getter */
    public final long getTopBarControl() {
        return this.topBarControl;
    }

    /* JADX INFO: renamed from: component15-0d7_KjU, reason: not valid java name and from getter */
    public final long getTopBarControlSecondary() {
        return this.topBarControlSecondary;
    }

    /* JADX INFO: renamed from: component16-0d7_KjU, reason: not valid java name and from getter */
    public final long getTopbarTextTertiary() {
        return this.topbarTextTertiary;
    }

    /* JADX INFO: renamed from: component17-0d7_KjU, reason: not valid java name and from getter */
    public final long getTopLayerBackground() {
        return this.topLayerBackground;
    }

    /* JADX INFO: renamed from: component18-0d7_KjU, reason: not valid java name and from getter */
    public final long getTopLayerInteractiveBackground() {
        return this.topLayerInteractiveBackground;
    }

    /* JADX INFO: renamed from: component19-0d7_KjU, reason: not valid java name and from getter */
    public final long getTopLayerInteractiveBackgroundDisabled() {
        return this.topLayerInteractiveBackgroundDisabled;
    }

    /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    public final long getAppBackgroundAlt() {
        return this.appBackgroundAlt;
    }

    /* JADX INFO: renamed from: component20-0d7_KjU, reason: not valid java name and from getter */
    public final long getTopLayerInteractiveSecondary() {
        return this.topLayerInteractiveSecondary;
    }

    /* JADX INFO: renamed from: component21-0d7_KjU, reason: not valid java name and from getter */
    public final long getMainActiveControl() {
        return this.mainActiveControl;
    }

    /* JADX INFO: renamed from: component22-0d7_KjU, reason: not valid java name and from getter */
    public final long getMainInactiveControl() {
        return this.mainInactiveControl;
    }

    /* JADX INFO: renamed from: component23-0d7_KjU, reason: not valid java name and from getter */
    public final long getMainActiveControlBackground() {
        return this.mainActiveControlBackground;
    }

    /* JADX INFO: renamed from: component24-0d7_KjU, reason: not valid java name and from getter */
    public final long getMainActiveControlContent() {
        return this.mainActiveControlContent;
    }

    /* JADX INFO: renamed from: component25-0d7_KjU, reason: not valid java name and from getter */
    public final long getDefaultActionIconBackground() {
        return this.defaultActionIconBackground;
    }

    /* JADX INFO: renamed from: component26-0d7_KjU, reason: not valid java name and from getter */
    public final long getTooltipBackground() {
        return this.tooltipBackground;
    }

    /* JADX INFO: renamed from: component27-0d7_KjU, reason: not valid java name and from getter */
    public final long getItemInfoTextSecondary() {
        return this.itemInfoTextSecondary;
    }

    /* JADX INFO: renamed from: component28-0d7_KjU, reason: not valid java name and from getter */
    public final long getItemInfoTextTertiary() {
        return this.itemInfoTextTertiary;
    }

    /* JADX INFO: renamed from: component29-0d7_KjU, reason: not valid java name and from getter */
    public final long getMentionsPopupBackground() {
        return this.mentionsPopupBackground;
    }

    /* JADX INFO: renamed from: component3-0d7_KjU, reason: not valid java name and from getter */
    public final long getAppPrimary() {
        return this.appPrimary;
    }

    /* JADX INFO: renamed from: component30-0d7_KjU, reason: not valid java name and from getter */
    public final long getPreviewSearchHighlight() {
        return this.previewSearchHighlight;
    }

    /* JADX INFO: renamed from: component31-0d7_KjU, reason: not valid java name and from getter */
    public final long getPreviewCitationHighlight() {
        return this.previewCitationHighlight;
    }

    /* JADX INFO: renamed from: component32-0d7_KjU, reason: not valid java name and from getter */
    public final long getThumbnailFileIconBackgroundColor() {
        return this.thumbnailFileIconBackgroundColor;
    }

    /* JADX INFO: renamed from: component33-0d7_KjU, reason: not valid java name and from getter */
    public final long getStatusDone() {
        return this.statusDone;
    }

    /* JADX INFO: renamed from: component34-0d7_KjU, reason: not valid java name and from getter */
    public final long getStatusInProgress() {
        return this.statusInProgress;
    }

    /* JADX INFO: renamed from: component35-0d7_KjU, reason: not valid java name and from getter */
    public final long getDialogContainer() {
        return this.dialogContainer;
    }

    /* JADX INFO: renamed from: component36-0d7_KjU, reason: not valid java name and from getter */
    public final long getDivider() {
        return this.divider;
    }

    /* JADX INFO: renamed from: component37-0d7_KjU, reason: not valid java name and from getter */
    public final long getSecondaryDivider() {
        return this.secondaryDivider;
    }

    /* JADX INFO: renamed from: component38-0d7_KjU, reason: not valid java name and from getter */
    public final long getNotificationText() {
        return this.notificationText;
    }

    /* JADX INFO: renamed from: component39-0d7_KjU, reason: not valid java name and from getter */
    public final long getNotificationContainer() {
        return this.notificationContainer;
    }

    /* JADX INFO: renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
    public final long getContentBackground() {
        return this.contentBackground;
    }

    /* JADX INFO: renamed from: component40-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldText() {
        return this.textFieldText;
    }

    /* JADX INFO: renamed from: component41-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldContainer() {
        return this.textFieldContainer;
    }

    /* JADX INFO: renamed from: component42-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldCursor() {
        return this.textFieldCursor;
    }

    /* JADX INFO: renamed from: component43-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldError() {
        return this.textFieldError;
    }

    /* JADX INFO: renamed from: component44-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldIndicator() {
        return this.textFieldIndicator;
    }

    /* JADX INFO: renamed from: component45-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldLabel() {
        return this.textFieldLabel;
    }

    /* JADX INFO: renamed from: component46-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldPlaceholder() {
        return this.textFieldPlaceholder;
    }

    /* JADX INFO: renamed from: component47-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldSupportingText() {
        return this.textFieldSupportingText;
    }

    /* JADX INFO: renamed from: component48-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldSelection() {
        return this.textFieldSelection;
    }

    /* JADX INFO: renamed from: component49-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldSelectionHandle() {
        return this.textFieldSelectionHandle;
    }

    /* JADX INFO: renamed from: component5-0d7_KjU, reason: not valid java name and from getter */
    public final long getContentBackgroundSelectedSecondary() {
        return this.contentBackgroundSelectedSecondary;
    }

    /* JADX INFO: renamed from: component50-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldSelectionAlt() {
        return this.textFieldSelectionAlt;
    }

    /* JADX INFO: renamed from: component51-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldSelectionHandleAlt() {
        return this.textFieldSelectionHandleAlt;
    }

    /* JADX INFO: renamed from: component52-0d7_KjU, reason: not valid java name and from getter */
    public final long getSearchTextFieldPlaceholder() {
        return this.searchTextFieldPlaceholder;
    }

    /* JADX INFO: renamed from: component53-0d7_KjU, reason: not valid java name and from getter */
    public final long getSnackbarContainer() {
        return this.snackbarContainer;
    }

    /* JADX INFO: renamed from: component54-0d7_KjU, reason: not valid java name and from getter */
    public final long getSnackbarContent() {
        return this.snackbarContent;
    }

    /* JADX INFO: renamed from: component55-0d7_KjU, reason: not valid java name and from getter */
    public final long getSnackbarAction() {
        return this.snackbarAction;
    }

    /* JADX INFO: renamed from: component56-0d7_KjU, reason: not valid java name and from getter */
    public final long getItemListingContentBackground() {
        return this.itemListingContentBackground;
    }

    /* JADX INFO: renamed from: component57-0d7_KjU, reason: not valid java name and from getter */
    public final long getItemListingContentBackgroundSelected() {
        return this.itemListingContentBackgroundSelected;
    }

    /* JADX INFO: renamed from: component58-0d7_KjU, reason: not valid java name and from getter */
    public final long getItemListingDivider() {
        return this.itemListingDivider;
    }

    /* JADX INFO: renamed from: component59-0d7_KjU, reason: not valid java name and from getter */
    public final long getItemListingBadgeContent() {
        return this.itemListingBadgeContent;
    }

    /* JADX INFO: renamed from: component6-0d7_KjU, reason: not valid java name and from getter */
    public final long getContentSecondary() {
        return this.contentSecondary;
    }

    /* JADX INFO: renamed from: component60-0d7_KjU, reason: not valid java name and from getter */
    public final long getItemListingBadgeBackground() {
        return this.itemListingBadgeBackground;
    }

    /* JADX INFO: renamed from: component61-0d7_KjU, reason: not valid java name and from getter */
    public final long getFileActivityVersionItemBackground() {
        return this.fileActivityVersionItemBackground;
    }

    /* JADX INFO: renamed from: component62-0d7_KjU, reason: not valid java name and from getter */
    public final long getFileActivityContentBackgroundSelected() {
        return this.fileActivityContentBackgroundSelected;
    }

    /* JADX INFO: renamed from: component63-0d7_KjU, reason: not valid java name and from getter */
    public final long getFileActivityReplyIndicator() {
        return this.fileActivityReplyIndicator;
    }

    /* JADX INFO: renamed from: component64-0d7_KjU, reason: not valid java name and from getter */
    public final long getFileActivityReplyIndicatorSelected() {
        return this.fileActivityReplyIndicatorSelected;
    }

    /* JADX INFO: renamed from: component65-0d7_KjU, reason: not valid java name and from getter */
    public final long getPreviewBackground() {
        return this.previewBackground;
    }

    /* JADX INFO: renamed from: component66-0d7_KjU, reason: not valid java name and from getter */
    public final long getFabButtonBackground() {
        return this.fabButtonBackground;
    }

    /* JADX INFO: renamed from: component67-0d7_KjU, reason: not valid java name and from getter */
    public final long getFabButtonContent() {
        return this.fabButtonContent;
    }

    /* JADX INFO: renamed from: component68-0d7_KjU, reason: not valid java name and from getter */
    public final long getFavoriteIndicatorColor() {
        return this.favoriteIndicatorColor;
    }

    /* JADX INFO: renamed from: component69-0d7_KjU, reason: not valid java name and from getter */
    public final long getFavoriteIndicatorSelectedColor() {
        return this.favoriteIndicatorSelectedColor;
    }

    /* JADX INFO: renamed from: component7-0d7_KjU, reason: not valid java name and from getter */
    public final long getContentSecondarySelected() {
        return this.contentSecondarySelected;
    }

    /* JADX INFO: renamed from: component70-0d7_KjU, reason: not valid java name and from getter */
    public final long getNoteUnreadIndicatorColor() {
        return this.noteUnreadIndicatorColor;
    }

    /* JADX INFO: renamed from: component71-0d7_KjU, reason: not valid java name and from getter */
    public final long getTabRowUnselectedContent() {
        return this.tabRowUnselectedContent;
    }

    /* JADX INFO: renamed from: component72-0d7_KjU, reason: not valid java name and from getter */
    public final long getNavigationBarUnselectedContent() {
        return this.navigationBarUnselectedContent;
    }

    /* JADX INFO: renamed from: component73-0d7_KjU, reason: not valid java name and from getter */
    public final long getCollectionIconBackground() {
        return this.collectionIconBackground;
    }

    /* JADX INFO: renamed from: component74-0d7_KjU, reason: not valid java name and from getter */
    public final long getCollectionIcon() {
        return this.collectionIcon;
    }

    /* JADX INFO: renamed from: component75-0d7_KjU, reason: not valid java name and from getter */
    public final long getCollectionFavoritesIconBackground() {
        return this.collectionFavoritesIconBackground;
    }

    /* JADX INFO: renamed from: component76-0d7_KjU, reason: not valid java name and from getter */
    public final long getCollectionFavoritesIcon() {
        return this.collectionFavoritesIcon;
    }

    /* JADX INFO: renamed from: component77-0d7_KjU, reason: not valid java name and from getter */
    public final long getSearchBarCapsuleBackground() {
        return this.searchBarCapsuleBackground;
    }

    /* JADX INFO: renamed from: component78-0d7_KjU, reason: not valid java name and from getter */
    public final long getSearchBarCapsuleContent() {
        return this.searchBarCapsuleContent;
    }

    /* JADX INFO: renamed from: component79-0d7_KjU, reason: not valid java name and from getter */
    public final long getSearchIconContent() {
        return this.searchIconContent;
    }

    /* JADX INFO: renamed from: component8-0d7_KjU, reason: not valid java name and from getter */
    public final long getPopupBackground() {
        return this.popupBackground;
    }

    /* JADX INFO: renamed from: component80-0d7_KjU, reason: not valid java name and from getter */
    public final long getSearchIconBackground() {
        return this.searchIconBackground;
    }

    /* JADX INFO: renamed from: component81-0d7_KjU, reason: not valid java name and from getter */
    public final long getSearchFilterChipContent() {
        return this.searchFilterChipContent;
    }

    /* JADX INFO: renamed from: component82-0d7_KjU, reason: not valid java name and from getter */
    public final long getSearchFilterChipBackground() {
        return this.searchFilterChipBackground;
    }

    /* JADX INFO: renamed from: component83-0d7_KjU, reason: not valid java name and from getter */
    public final long getCheckboxCheckedColor() {
        return this.checkboxCheckedColor;
    }

    /* JADX INFO: renamed from: component84-0d7_KjU, reason: not valid java name and from getter */
    public final long getCheckboxUncheckedColor() {
        return this.checkboxUncheckedColor;
    }

    /* JADX INFO: renamed from: component85-0d7_KjU, reason: not valid java name and from getter */
    public final long getCheckboxCheckmarkColor() {
        return this.checkboxCheckmarkColor;
    }

    /* JADX INFO: renamed from: component86-0d7_KjU, reason: not valid java name and from getter */
    public final long getBoxAiLabelBackground() {
        return this.boxAiLabelBackground;
    }

    /* JADX INFO: renamed from: component87-0d7_KjU, reason: not valid java name and from getter */
    public final long getBoxAiGradientTextStart() {
        return this.boxAiGradientTextStart;
    }

    /* JADX INFO: renamed from: component88-0d7_KjU, reason: not valid java name and from getter */
    public final long getBoxAiGradientTextEnd() {
        return this.boxAiGradientTextEnd;
    }

    /* JADX INFO: renamed from: component9-0d7_KjU, reason: not valid java name and from getter */
    public final long getPopupSecondary() {
        return this.popupSecondary;
    }

    /* JADX INFO: renamed from: copy-b6m_y3s, reason: not valid java name */
    public final BoxColors m11497copyb6m_y3s(long appBackground, long appBackgroundAlt, long appPrimary, long contentBackground, long contentBackgroundSelectedSecondary, long contentSecondary, long contentSecondarySelected, long popupBackground, long popupSecondary, long topBarBackground, long topBarBackgroundSecondary, long topBarText, long topBarTextSecondary, long topBarControl, long topBarControlSecondary, long topbarTextTertiary, long topLayerBackground, long topLayerInteractiveBackground, long topLayerInteractiveBackgroundDisabled, long topLayerInteractiveSecondary, long mainActiveControl, long mainInactiveControl, long mainActiveControlBackground, long mainActiveControlContent, long defaultActionIconBackground, long tooltipBackground, long itemInfoTextSecondary, long itemInfoTextTertiary, long mentionsPopupBackground, long previewSearchHighlight, long previewCitationHighlight, long thumbnailFileIconBackgroundColor, long statusDone, long statusInProgress, long dialogContainer, long divider, long secondaryDivider, long notificationText, long notificationContainer, long textFieldText, long textFieldContainer, long textFieldCursor, long textFieldError, long textFieldIndicator, long textFieldLabel, long textFieldPlaceholder, long textFieldSupportingText, long textFieldSelection, long textFieldSelectionHandle, long textFieldSelectionAlt, long textFieldSelectionHandleAlt, long searchTextFieldPlaceholder, long snackbarContainer, long snackbarContent, long snackbarAction, long itemListingContentBackground, long itemListingContentBackgroundSelected, long itemListingDivider, long itemListingBadgeContent, long itemListingBadgeBackground, long fileActivityVersionItemBackground, long fileActivityContentBackgroundSelected, long fileActivityReplyIndicator, long fileActivityReplyIndicatorSelected, long previewBackground, long fabButtonBackground, long fabButtonContent, long favoriteIndicatorColor, long favoriteIndicatorSelectedColor, long noteUnreadIndicatorColor, long tabRowUnselectedContent, long navigationBarUnselectedContent, long collectionIconBackground, long collectionIcon, long collectionFavoritesIconBackground, long collectionFavoritesIcon, long searchBarCapsuleBackground, long searchBarCapsuleContent, long searchIconContent, long searchIconBackground, long searchFilterChipContent, long searchFilterChipBackground, long checkboxCheckedColor, long checkboxUncheckedColor, long checkboxCheckmarkColor, long boxAiLabelBackground, long boxAiGradientTextStart, long boxAiGradientTextEnd) {
        return new BoxColors(appBackground, appBackgroundAlt, appPrimary, contentBackground, contentBackgroundSelectedSecondary, contentSecondary, contentSecondarySelected, popupBackground, popupSecondary, topBarBackground, topBarBackgroundSecondary, topBarText, topBarTextSecondary, topBarControl, topBarControlSecondary, topbarTextTertiary, topLayerBackground, topLayerInteractiveBackground, topLayerInteractiveBackgroundDisabled, topLayerInteractiveSecondary, mainActiveControl, mainInactiveControl, mainActiveControlBackground, mainActiveControlContent, defaultActionIconBackground, tooltipBackground, itemInfoTextSecondary, itemInfoTextTertiary, mentionsPopupBackground, previewSearchHighlight, previewCitationHighlight, thumbnailFileIconBackgroundColor, statusDone, statusInProgress, dialogContainer, divider, secondaryDivider, notificationText, notificationContainer, textFieldText, textFieldContainer, textFieldCursor, textFieldError, textFieldIndicator, textFieldLabel, textFieldPlaceholder, textFieldSupportingText, textFieldSelection, textFieldSelectionHandle, textFieldSelectionAlt, textFieldSelectionHandleAlt, searchTextFieldPlaceholder, snackbarContainer, snackbarContent, snackbarAction, itemListingContentBackground, itemListingContentBackgroundSelected, itemListingDivider, itemListingBadgeContent, itemListingBadgeBackground, fileActivityVersionItemBackground, fileActivityContentBackgroundSelected, fileActivityReplyIndicator, fileActivityReplyIndicatorSelected, previewBackground, fabButtonBackground, fabButtonContent, favoriteIndicatorColor, favoriteIndicatorSelectedColor, noteUnreadIndicatorColor, tabRowUnselectedContent, navigationBarUnselectedContent, collectionIconBackground, collectionIcon, collectionFavoritesIconBackground, collectionFavoritesIcon, searchBarCapsuleBackground, searchBarCapsuleContent, searchIconContent, searchIconBackground, searchFilterChipContent, searchFilterChipBackground, checkboxCheckedColor, checkboxUncheckedColor, checkboxCheckmarkColor, boxAiLabelBackground, boxAiGradientTextStart, boxAiGradientTextEnd, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxColors)) {
            return false;
        }
        BoxColors boxColors = (BoxColors) other;
        return Color.m6815equalsimpl0(this.appBackground, boxColors.appBackground) && Color.m6815equalsimpl0(this.appBackgroundAlt, boxColors.appBackgroundAlt) && Color.m6815equalsimpl0(this.appPrimary, boxColors.appPrimary) && Color.m6815equalsimpl0(this.contentBackground, boxColors.contentBackground) && Color.m6815equalsimpl0(this.contentBackgroundSelectedSecondary, boxColors.contentBackgroundSelectedSecondary) && Color.m6815equalsimpl0(this.contentSecondary, boxColors.contentSecondary) && Color.m6815equalsimpl0(this.contentSecondarySelected, boxColors.contentSecondarySelected) && Color.m6815equalsimpl0(this.popupBackground, boxColors.popupBackground) && Color.m6815equalsimpl0(this.popupSecondary, boxColors.popupSecondary) && Color.m6815equalsimpl0(this.topBarBackground, boxColors.topBarBackground) && Color.m6815equalsimpl0(this.topBarBackgroundSecondary, boxColors.topBarBackgroundSecondary) && Color.m6815equalsimpl0(this.topBarText, boxColors.topBarText) && Color.m6815equalsimpl0(this.topBarTextSecondary, boxColors.topBarTextSecondary) && Color.m6815equalsimpl0(this.topBarControl, boxColors.topBarControl) && Color.m6815equalsimpl0(this.topBarControlSecondary, boxColors.topBarControlSecondary) && Color.m6815equalsimpl0(this.topbarTextTertiary, boxColors.topbarTextTertiary) && Color.m6815equalsimpl0(this.topLayerBackground, boxColors.topLayerBackground) && Color.m6815equalsimpl0(this.topLayerInteractiveBackground, boxColors.topLayerInteractiveBackground) && Color.m6815equalsimpl0(this.topLayerInteractiveBackgroundDisabled, boxColors.topLayerInteractiveBackgroundDisabled) && Color.m6815equalsimpl0(this.topLayerInteractiveSecondary, boxColors.topLayerInteractiveSecondary) && Color.m6815equalsimpl0(this.mainActiveControl, boxColors.mainActiveControl) && Color.m6815equalsimpl0(this.mainInactiveControl, boxColors.mainInactiveControl) && Color.m6815equalsimpl0(this.mainActiveControlBackground, boxColors.mainActiveControlBackground) && Color.m6815equalsimpl0(this.mainActiveControlContent, boxColors.mainActiveControlContent) && Color.m6815equalsimpl0(this.defaultActionIconBackground, boxColors.defaultActionIconBackground) && Color.m6815equalsimpl0(this.tooltipBackground, boxColors.tooltipBackground) && Color.m6815equalsimpl0(this.itemInfoTextSecondary, boxColors.itemInfoTextSecondary) && Color.m6815equalsimpl0(this.itemInfoTextTertiary, boxColors.itemInfoTextTertiary) && Color.m6815equalsimpl0(this.mentionsPopupBackground, boxColors.mentionsPopupBackground) && Color.m6815equalsimpl0(this.previewSearchHighlight, boxColors.previewSearchHighlight) && Color.m6815equalsimpl0(this.previewCitationHighlight, boxColors.previewCitationHighlight) && Color.m6815equalsimpl0(this.thumbnailFileIconBackgroundColor, boxColors.thumbnailFileIconBackgroundColor) && Color.m6815equalsimpl0(this.statusDone, boxColors.statusDone) && Color.m6815equalsimpl0(this.statusInProgress, boxColors.statusInProgress) && Color.m6815equalsimpl0(this.dialogContainer, boxColors.dialogContainer) && Color.m6815equalsimpl0(this.divider, boxColors.divider) && Color.m6815equalsimpl0(this.secondaryDivider, boxColors.secondaryDivider) && Color.m6815equalsimpl0(this.notificationText, boxColors.notificationText) && Color.m6815equalsimpl0(this.notificationContainer, boxColors.notificationContainer) && Color.m6815equalsimpl0(this.textFieldText, boxColors.textFieldText) && Color.m6815equalsimpl0(this.textFieldContainer, boxColors.textFieldContainer) && Color.m6815equalsimpl0(this.textFieldCursor, boxColors.textFieldCursor) && Color.m6815equalsimpl0(this.textFieldError, boxColors.textFieldError) && Color.m6815equalsimpl0(this.textFieldIndicator, boxColors.textFieldIndicator) && Color.m6815equalsimpl0(this.textFieldLabel, boxColors.textFieldLabel) && Color.m6815equalsimpl0(this.textFieldPlaceholder, boxColors.textFieldPlaceholder) && Color.m6815equalsimpl0(this.textFieldSupportingText, boxColors.textFieldSupportingText) && Color.m6815equalsimpl0(this.textFieldSelection, boxColors.textFieldSelection) && Color.m6815equalsimpl0(this.textFieldSelectionHandle, boxColors.textFieldSelectionHandle) && Color.m6815equalsimpl0(this.textFieldSelectionAlt, boxColors.textFieldSelectionAlt) && Color.m6815equalsimpl0(this.textFieldSelectionHandleAlt, boxColors.textFieldSelectionHandleAlt) && Color.m6815equalsimpl0(this.searchTextFieldPlaceholder, boxColors.searchTextFieldPlaceholder) && Color.m6815equalsimpl0(this.snackbarContainer, boxColors.snackbarContainer) && Color.m6815equalsimpl0(this.snackbarContent, boxColors.snackbarContent) && Color.m6815equalsimpl0(this.snackbarAction, boxColors.snackbarAction) && Color.m6815equalsimpl0(this.itemListingContentBackground, boxColors.itemListingContentBackground) && Color.m6815equalsimpl0(this.itemListingContentBackgroundSelected, boxColors.itemListingContentBackgroundSelected) && Color.m6815equalsimpl0(this.itemListingDivider, boxColors.itemListingDivider) && Color.m6815equalsimpl0(this.itemListingBadgeContent, boxColors.itemListingBadgeContent) && Color.m6815equalsimpl0(this.itemListingBadgeBackground, boxColors.itemListingBadgeBackground) && Color.m6815equalsimpl0(this.fileActivityVersionItemBackground, boxColors.fileActivityVersionItemBackground) && Color.m6815equalsimpl0(this.fileActivityContentBackgroundSelected, boxColors.fileActivityContentBackgroundSelected) && Color.m6815equalsimpl0(this.fileActivityReplyIndicator, boxColors.fileActivityReplyIndicator) && Color.m6815equalsimpl0(this.fileActivityReplyIndicatorSelected, boxColors.fileActivityReplyIndicatorSelected) && Color.m6815equalsimpl0(this.previewBackground, boxColors.previewBackground) && Color.m6815equalsimpl0(this.fabButtonBackground, boxColors.fabButtonBackground) && Color.m6815equalsimpl0(this.fabButtonContent, boxColors.fabButtonContent) && Color.m6815equalsimpl0(this.favoriteIndicatorColor, boxColors.favoriteIndicatorColor) && Color.m6815equalsimpl0(this.favoriteIndicatorSelectedColor, boxColors.favoriteIndicatorSelectedColor) && Color.m6815equalsimpl0(this.noteUnreadIndicatorColor, boxColors.noteUnreadIndicatorColor) && Color.m6815equalsimpl0(this.tabRowUnselectedContent, boxColors.tabRowUnselectedContent) && Color.m6815equalsimpl0(this.navigationBarUnselectedContent, boxColors.navigationBarUnselectedContent) && Color.m6815equalsimpl0(this.collectionIconBackground, boxColors.collectionIconBackground) && Color.m6815equalsimpl0(this.collectionIcon, boxColors.collectionIcon) && Color.m6815equalsimpl0(this.collectionFavoritesIconBackground, boxColors.collectionFavoritesIconBackground) && Color.m6815equalsimpl0(this.collectionFavoritesIcon, boxColors.collectionFavoritesIcon) && Color.m6815equalsimpl0(this.searchBarCapsuleBackground, boxColors.searchBarCapsuleBackground) && Color.m6815equalsimpl0(this.searchBarCapsuleContent, boxColors.searchBarCapsuleContent) && Color.m6815equalsimpl0(this.searchIconContent, boxColors.searchIconContent) && Color.m6815equalsimpl0(this.searchIconBackground, boxColors.searchIconBackground) && Color.m6815equalsimpl0(this.searchFilterChipContent, boxColors.searchFilterChipContent) && Color.m6815equalsimpl0(this.searchFilterChipBackground, boxColors.searchFilterChipBackground) && Color.m6815equalsimpl0(this.checkboxCheckedColor, boxColors.checkboxCheckedColor) && Color.m6815equalsimpl0(this.checkboxUncheckedColor, boxColors.checkboxUncheckedColor) && Color.m6815equalsimpl0(this.checkboxCheckmarkColor, boxColors.checkboxCheckmarkColor) && Color.m6815equalsimpl0(this.boxAiLabelBackground, boxColors.boxAiLabelBackground) && Color.m6815equalsimpl0(this.boxAiGradientTextStart, boxColors.boxAiGradientTextStart) && Color.m6815equalsimpl0(this.boxAiGradientTextEnd, boxColors.boxAiGradientTextEnd);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((Color.m6821hashCodeimpl(this.appBackground) * 31) + Color.m6821hashCodeimpl(this.appBackgroundAlt)) * 31) + Color.m6821hashCodeimpl(this.appPrimary)) * 31) + Color.m6821hashCodeimpl(this.contentBackground)) * 31) + Color.m6821hashCodeimpl(this.contentBackgroundSelectedSecondary)) * 31) + Color.m6821hashCodeimpl(this.contentSecondary)) * 31) + Color.m6821hashCodeimpl(this.contentSecondarySelected)) * 31) + Color.m6821hashCodeimpl(this.popupBackground)) * 31) + Color.m6821hashCodeimpl(this.popupSecondary)) * 31) + Color.m6821hashCodeimpl(this.topBarBackground)) * 31) + Color.m6821hashCodeimpl(this.topBarBackgroundSecondary)) * 31) + Color.m6821hashCodeimpl(this.topBarText)) * 31) + Color.m6821hashCodeimpl(this.topBarTextSecondary)) * 31) + Color.m6821hashCodeimpl(this.topBarControl)) * 31) + Color.m6821hashCodeimpl(this.topBarControlSecondary)) * 31) + Color.m6821hashCodeimpl(this.topbarTextTertiary)) * 31) + Color.m6821hashCodeimpl(this.topLayerBackground)) * 31) + Color.m6821hashCodeimpl(this.topLayerInteractiveBackground)) * 31) + Color.m6821hashCodeimpl(this.topLayerInteractiveBackgroundDisabled)) * 31) + Color.m6821hashCodeimpl(this.topLayerInteractiveSecondary)) * 31) + Color.m6821hashCodeimpl(this.mainActiveControl)) * 31) + Color.m6821hashCodeimpl(this.mainInactiveControl)) * 31) + Color.m6821hashCodeimpl(this.mainActiveControlBackground)) * 31) + Color.m6821hashCodeimpl(this.mainActiveControlContent)) * 31) + Color.m6821hashCodeimpl(this.defaultActionIconBackground)) * 31) + Color.m6821hashCodeimpl(this.tooltipBackground)) * 31) + Color.m6821hashCodeimpl(this.itemInfoTextSecondary)) * 31) + Color.m6821hashCodeimpl(this.itemInfoTextTertiary)) * 31) + Color.m6821hashCodeimpl(this.mentionsPopupBackground)) * 31) + Color.m6821hashCodeimpl(this.previewSearchHighlight)) * 31) + Color.m6821hashCodeimpl(this.previewCitationHighlight)) * 31) + Color.m6821hashCodeimpl(this.thumbnailFileIconBackgroundColor)) * 31) + Color.m6821hashCodeimpl(this.statusDone)) * 31) + Color.m6821hashCodeimpl(this.statusInProgress)) * 31) + Color.m6821hashCodeimpl(this.dialogContainer)) * 31) + Color.m6821hashCodeimpl(this.divider)) * 31) + Color.m6821hashCodeimpl(this.secondaryDivider)) * 31) + Color.m6821hashCodeimpl(this.notificationText)) * 31) + Color.m6821hashCodeimpl(this.notificationContainer)) * 31) + Color.m6821hashCodeimpl(this.textFieldText)) * 31) + Color.m6821hashCodeimpl(this.textFieldContainer)) * 31) + Color.m6821hashCodeimpl(this.textFieldCursor)) * 31) + Color.m6821hashCodeimpl(this.textFieldError)) * 31) + Color.m6821hashCodeimpl(this.textFieldIndicator)) * 31) + Color.m6821hashCodeimpl(this.textFieldLabel)) * 31) + Color.m6821hashCodeimpl(this.textFieldPlaceholder)) * 31) + Color.m6821hashCodeimpl(this.textFieldSupportingText)) * 31) + Color.m6821hashCodeimpl(this.textFieldSelection)) * 31) + Color.m6821hashCodeimpl(this.textFieldSelectionHandle)) * 31) + Color.m6821hashCodeimpl(this.textFieldSelectionAlt)) * 31) + Color.m6821hashCodeimpl(this.textFieldSelectionHandleAlt)) * 31) + Color.m6821hashCodeimpl(this.searchTextFieldPlaceholder)) * 31) + Color.m6821hashCodeimpl(this.snackbarContainer)) * 31) + Color.m6821hashCodeimpl(this.snackbarContent)) * 31) + Color.m6821hashCodeimpl(this.snackbarAction)) * 31) + Color.m6821hashCodeimpl(this.itemListingContentBackground)) * 31) + Color.m6821hashCodeimpl(this.itemListingContentBackgroundSelected)) * 31) + Color.m6821hashCodeimpl(this.itemListingDivider)) * 31) + Color.m6821hashCodeimpl(this.itemListingBadgeContent)) * 31) + Color.m6821hashCodeimpl(this.itemListingBadgeBackground)) * 31) + Color.m6821hashCodeimpl(this.fileActivityVersionItemBackground)) * 31) + Color.m6821hashCodeimpl(this.fileActivityContentBackgroundSelected)) * 31) + Color.m6821hashCodeimpl(this.fileActivityReplyIndicator)) * 31) + Color.m6821hashCodeimpl(this.fileActivityReplyIndicatorSelected)) * 31) + Color.m6821hashCodeimpl(this.previewBackground)) * 31) + Color.m6821hashCodeimpl(this.fabButtonBackground)) * 31) + Color.m6821hashCodeimpl(this.fabButtonContent)) * 31) + Color.m6821hashCodeimpl(this.favoriteIndicatorColor)) * 31) + Color.m6821hashCodeimpl(this.favoriteIndicatorSelectedColor)) * 31) + Color.m6821hashCodeimpl(this.noteUnreadIndicatorColor)) * 31) + Color.m6821hashCodeimpl(this.tabRowUnselectedContent)) * 31) + Color.m6821hashCodeimpl(this.navigationBarUnselectedContent)) * 31) + Color.m6821hashCodeimpl(this.collectionIconBackground)) * 31) + Color.m6821hashCodeimpl(this.collectionIcon)) * 31) + Color.m6821hashCodeimpl(this.collectionFavoritesIconBackground)) * 31) + Color.m6821hashCodeimpl(this.collectionFavoritesIcon)) * 31) + Color.m6821hashCodeimpl(this.searchBarCapsuleBackground)) * 31) + Color.m6821hashCodeimpl(this.searchBarCapsuleContent)) * 31) + Color.m6821hashCodeimpl(this.searchIconContent)) * 31) + Color.m6821hashCodeimpl(this.searchIconBackground)) * 31) + Color.m6821hashCodeimpl(this.searchFilterChipContent)) * 31) + Color.m6821hashCodeimpl(this.searchFilterChipBackground)) * 31) + Color.m6821hashCodeimpl(this.checkboxCheckedColor)) * 31) + Color.m6821hashCodeimpl(this.checkboxUncheckedColor)) * 31) + Color.m6821hashCodeimpl(this.checkboxCheckmarkColor)) * 31) + Color.m6821hashCodeimpl(this.boxAiLabelBackground)) * 31) + Color.m6821hashCodeimpl(this.boxAiGradientTextStart)) * 31) + Color.m6821hashCodeimpl(this.boxAiGradientTextEnd);
    }

    public String toString() {
        return "BoxColors(appBackground=" + Color.m6822toStringimpl(this.appBackground) + ", appBackgroundAlt=" + Color.m6822toStringimpl(this.appBackgroundAlt) + ", appPrimary=" + Color.m6822toStringimpl(this.appPrimary) + ", contentBackground=" + Color.m6822toStringimpl(this.contentBackground) + ", contentBackgroundSelectedSecondary=" + Color.m6822toStringimpl(this.contentBackgroundSelectedSecondary) + ", contentSecondary=" + Color.m6822toStringimpl(this.contentSecondary) + ", contentSecondarySelected=" + Color.m6822toStringimpl(this.contentSecondarySelected) + ", popupBackground=" + Color.m6822toStringimpl(this.popupBackground) + ", popupSecondary=" + Color.m6822toStringimpl(this.popupSecondary) + ", topBarBackground=" + Color.m6822toStringimpl(this.topBarBackground) + ", topBarBackgroundSecondary=" + Color.m6822toStringimpl(this.topBarBackgroundSecondary) + ", topBarText=" + Color.m6822toStringimpl(this.topBarText) + ", topBarTextSecondary=" + Color.m6822toStringimpl(this.topBarTextSecondary) + ", topBarControl=" + Color.m6822toStringimpl(this.topBarControl) + ", topBarControlSecondary=" + Color.m6822toStringimpl(this.topBarControlSecondary) + ", topbarTextTertiary=" + Color.m6822toStringimpl(this.topbarTextTertiary) + ", topLayerBackground=" + Color.m6822toStringimpl(this.topLayerBackground) + ", topLayerInteractiveBackground=" + Color.m6822toStringimpl(this.topLayerInteractiveBackground) + ", topLayerInteractiveBackgroundDisabled=" + Color.m6822toStringimpl(this.topLayerInteractiveBackgroundDisabled) + ", topLayerInteractiveSecondary=" + Color.m6822toStringimpl(this.topLayerInteractiveSecondary) + ", mainActiveControl=" + Color.m6822toStringimpl(this.mainActiveControl) + ", mainInactiveControl=" + Color.m6822toStringimpl(this.mainInactiveControl) + ", mainActiveControlBackground=" + Color.m6822toStringimpl(this.mainActiveControlBackground) + ", mainActiveControlContent=" + Color.m6822toStringimpl(this.mainActiveControlContent) + ", defaultActionIconBackground=" + Color.m6822toStringimpl(this.defaultActionIconBackground) + ", tooltipBackground=" + Color.m6822toStringimpl(this.tooltipBackground) + ", itemInfoTextSecondary=" + Color.m6822toStringimpl(this.itemInfoTextSecondary) + ", itemInfoTextTertiary=" + Color.m6822toStringimpl(this.itemInfoTextTertiary) + ", mentionsPopupBackground=" + Color.m6822toStringimpl(this.mentionsPopupBackground) + ", previewSearchHighlight=" + Color.m6822toStringimpl(this.previewSearchHighlight) + ", previewCitationHighlight=" + Color.m6822toStringimpl(this.previewCitationHighlight) + ", thumbnailFileIconBackgroundColor=" + Color.m6822toStringimpl(this.thumbnailFileIconBackgroundColor) + ", statusDone=" + Color.m6822toStringimpl(this.statusDone) + ", statusInProgress=" + Color.m6822toStringimpl(this.statusInProgress) + ", dialogContainer=" + Color.m6822toStringimpl(this.dialogContainer) + ", divider=" + Color.m6822toStringimpl(this.divider) + ", secondaryDivider=" + Color.m6822toStringimpl(this.secondaryDivider) + ", notificationText=" + Color.m6822toStringimpl(this.notificationText) + ", notificationContainer=" + Color.m6822toStringimpl(this.notificationContainer) + ", textFieldText=" + Color.m6822toStringimpl(this.textFieldText) + ", textFieldContainer=" + Color.m6822toStringimpl(this.textFieldContainer) + ", textFieldCursor=" + Color.m6822toStringimpl(this.textFieldCursor) + ", textFieldError=" + Color.m6822toStringimpl(this.textFieldError) + ", textFieldIndicator=" + Color.m6822toStringimpl(this.textFieldIndicator) + ", textFieldLabel=" + Color.m6822toStringimpl(this.textFieldLabel) + ", textFieldPlaceholder=" + Color.m6822toStringimpl(this.textFieldPlaceholder) + ", textFieldSupportingText=" + Color.m6822toStringimpl(this.textFieldSupportingText) + ", textFieldSelection=" + Color.m6822toStringimpl(this.textFieldSelection) + ", textFieldSelectionHandle=" + Color.m6822toStringimpl(this.textFieldSelectionHandle) + ", textFieldSelectionAlt=" + Color.m6822toStringimpl(this.textFieldSelectionAlt) + ", textFieldSelectionHandleAlt=" + Color.m6822toStringimpl(this.textFieldSelectionHandleAlt) + ", searchTextFieldPlaceholder=" + Color.m6822toStringimpl(this.searchTextFieldPlaceholder) + ", snackbarContainer=" + Color.m6822toStringimpl(this.snackbarContainer) + ", snackbarContent=" + Color.m6822toStringimpl(this.snackbarContent) + ", snackbarAction=" + Color.m6822toStringimpl(this.snackbarAction) + ", itemListingContentBackground=" + Color.m6822toStringimpl(this.itemListingContentBackground) + ", itemListingContentBackgroundSelected=" + Color.m6822toStringimpl(this.itemListingContentBackgroundSelected) + ", itemListingDivider=" + Color.m6822toStringimpl(this.itemListingDivider) + ", itemListingBadgeContent=" + Color.m6822toStringimpl(this.itemListingBadgeContent) + ", itemListingBadgeBackground=" + Color.m6822toStringimpl(this.itemListingBadgeBackground) + ", fileActivityVersionItemBackground=" + Color.m6822toStringimpl(this.fileActivityVersionItemBackground) + ", fileActivityContentBackgroundSelected=" + Color.m6822toStringimpl(this.fileActivityContentBackgroundSelected) + ", fileActivityReplyIndicator=" + Color.m6822toStringimpl(this.fileActivityReplyIndicator) + ", fileActivityReplyIndicatorSelected=" + Color.m6822toStringimpl(this.fileActivityReplyIndicatorSelected) + ", previewBackground=" + Color.m6822toStringimpl(this.previewBackground) + ", fabButtonBackground=" + Color.m6822toStringimpl(this.fabButtonBackground) + ", fabButtonContent=" + Color.m6822toStringimpl(this.fabButtonContent) + ", favoriteIndicatorColor=" + Color.m6822toStringimpl(this.favoriteIndicatorColor) + ", favoriteIndicatorSelectedColor=" + Color.m6822toStringimpl(this.favoriteIndicatorSelectedColor) + ", noteUnreadIndicatorColor=" + Color.m6822toStringimpl(this.noteUnreadIndicatorColor) + ", tabRowUnselectedContent=" + Color.m6822toStringimpl(this.tabRowUnselectedContent) + ", navigationBarUnselectedContent=" + Color.m6822toStringimpl(this.navigationBarUnselectedContent) + ", collectionIconBackground=" + Color.m6822toStringimpl(this.collectionIconBackground) + ", collectionIcon=" + Color.m6822toStringimpl(this.collectionIcon) + ", collectionFavoritesIconBackground=" + Color.m6822toStringimpl(this.collectionFavoritesIconBackground) + ", collectionFavoritesIcon=" + Color.m6822toStringimpl(this.collectionFavoritesIcon) + ", searchBarCapsuleBackground=" + Color.m6822toStringimpl(this.searchBarCapsuleBackground) + ", searchBarCapsuleContent=" + Color.m6822toStringimpl(this.searchBarCapsuleContent) + ", searchIconContent=" + Color.m6822toStringimpl(this.searchIconContent) + ", searchIconBackground=" + Color.m6822toStringimpl(this.searchIconBackground) + ", searchFilterChipContent=" + Color.m6822toStringimpl(this.searchFilterChipContent) + ", searchFilterChipBackground=" + Color.m6822toStringimpl(this.searchFilterChipBackground) + ", checkboxCheckedColor=" + Color.m6822toStringimpl(this.checkboxCheckedColor) + ", checkboxUncheckedColor=" + Color.m6822toStringimpl(this.checkboxUncheckedColor) + ", checkboxCheckmarkColor=" + Color.m6822toStringimpl(this.checkboxCheckmarkColor) + ", boxAiLabelBackground=" + Color.m6822toStringimpl(this.boxAiLabelBackground) + ", boxAiGradientTextStart=" + Color.m6822toStringimpl(this.boxAiGradientTextStart) + ", boxAiGradientTextEnd=" + Color.m6822toStringimpl(this.boxAiGradientTextEnd) + ")";
    }

    private BoxColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, long j45, long j46, long j47, long j48, long j49, long j50, long j51, long j52, long j53, long j54, long j55, long j56, long j57, long j58, long j59, long j60, long j61, long j62, long j63, long j64, long j65, long j66, long j67, long j68, long j69, long j70, long j71, long j72, long j73, long j74, long j75, long j76, long j77, long j78, long j79, long j80, long j81, long j82, long j83, long j84, long j85, long j86, long j87, long j88) {
        this.appBackground = j;
        this.appBackgroundAlt = j2;
        this.appPrimary = j3;
        this.contentBackground = j4;
        this.contentBackgroundSelectedSecondary = j5;
        this.contentSecondary = j6;
        this.contentSecondarySelected = j7;
        this.popupBackground = j8;
        this.popupSecondary = j9;
        this.topBarBackground = j10;
        this.topBarBackgroundSecondary = j11;
        this.topBarText = j12;
        this.topBarTextSecondary = j13;
        this.topBarControl = j14;
        this.topBarControlSecondary = j15;
        this.topbarTextTertiary = j16;
        this.topLayerBackground = j17;
        this.topLayerInteractiveBackground = j18;
        this.topLayerInteractiveBackgroundDisabled = j19;
        this.topLayerInteractiveSecondary = j20;
        this.mainActiveControl = j21;
        this.mainInactiveControl = j22;
        this.mainActiveControlBackground = j23;
        this.mainActiveControlContent = j24;
        this.defaultActionIconBackground = j25;
        this.tooltipBackground = j26;
        this.itemInfoTextSecondary = j27;
        this.itemInfoTextTertiary = j28;
        this.mentionsPopupBackground = j29;
        this.previewSearchHighlight = j30;
        this.previewCitationHighlight = j31;
        this.thumbnailFileIconBackgroundColor = j32;
        this.statusDone = j33;
        this.statusInProgress = j34;
        this.dialogContainer = j35;
        this.divider = j36;
        this.secondaryDivider = j37;
        this.notificationText = j38;
        this.notificationContainer = j39;
        this.textFieldText = j40;
        this.textFieldContainer = j41;
        this.textFieldCursor = j42;
        this.textFieldError = j43;
        this.textFieldIndicator = j44;
        this.textFieldLabel = j45;
        this.textFieldPlaceholder = j46;
        this.textFieldSupportingText = j47;
        this.textFieldSelection = j48;
        this.textFieldSelectionHandle = j49;
        this.textFieldSelectionAlt = j50;
        this.textFieldSelectionHandleAlt = j51;
        this.searchTextFieldPlaceholder = j52;
        this.snackbarContainer = j53;
        this.snackbarContent = j54;
        this.snackbarAction = j55;
        this.itemListingContentBackground = j56;
        this.itemListingContentBackgroundSelected = j57;
        this.itemListingDivider = j58;
        this.itemListingBadgeContent = j59;
        this.itemListingBadgeBackground = j60;
        this.fileActivityVersionItemBackground = j61;
        this.fileActivityContentBackgroundSelected = j62;
        this.fileActivityReplyIndicator = j63;
        this.fileActivityReplyIndicatorSelected = j64;
        this.previewBackground = j65;
        this.fabButtonBackground = j66;
        this.fabButtonContent = j67;
        this.favoriteIndicatorColor = j68;
        this.favoriteIndicatorSelectedColor = j69;
        this.noteUnreadIndicatorColor = j70;
        this.tabRowUnselectedContent = j71;
        this.navigationBarUnselectedContent = j72;
        this.collectionIconBackground = j73;
        this.collectionIcon = j74;
        this.collectionFavoritesIconBackground = j75;
        this.collectionFavoritesIcon = j76;
        this.searchBarCapsuleBackground = j77;
        this.searchBarCapsuleContent = j78;
        this.searchIconContent = j79;
        this.searchIconBackground = j80;
        this.searchFilterChipContent = j81;
        this.searchFilterChipBackground = j82;
        this.checkboxCheckedColor = j83;
        this.checkboxUncheckedColor = j84;
        this.checkboxCheckmarkColor = j85;
        this.boxAiLabelBackground = j86;
        this.boxAiGradientTextStart = j87;
        this.boxAiGradientTextEnd = j88;
    }

    /* JADX INFO: renamed from: getAppBackground-0d7_KjU, reason: not valid java name */
    public final long m11498getAppBackground0d7_KjU() {
        return this.appBackground;
    }

    /* JADX INFO: renamed from: getAppBackgroundAlt-0d7_KjU, reason: not valid java name */
    public final long m11499getAppBackgroundAlt0d7_KjU() {
        return this.appBackgroundAlt;
    }

    /* JADX INFO: renamed from: getAppPrimary-0d7_KjU, reason: not valid java name */
    public final long m11500getAppPrimary0d7_KjU() {
        return this.appPrimary;
    }

    /* JADX INFO: renamed from: getContentBackground-0d7_KjU, reason: not valid java name */
    public final long m11511getContentBackground0d7_KjU() {
        return this.contentBackground;
    }

    /* JADX INFO: renamed from: getContentBackgroundSelectedSecondary-0d7_KjU, reason: not valid java name */
    public final long m11512getContentBackgroundSelectedSecondary0d7_KjU() {
        return this.contentBackgroundSelectedSecondary;
    }

    /* JADX INFO: renamed from: getContentSecondary-0d7_KjU, reason: not valid java name */
    public final long m11513getContentSecondary0d7_KjU() {
        return this.contentSecondary;
    }

    /* JADX INFO: renamed from: getContentSecondarySelected-0d7_KjU, reason: not valid java name */
    public final long m11514getContentSecondarySelected0d7_KjU() {
        return this.contentSecondarySelected;
    }

    /* JADX INFO: renamed from: getPopupBackground-0d7_KjU, reason: not valid java name */
    public final long m11542getPopupBackground0d7_KjU() {
        return this.popupBackground;
    }

    /* JADX INFO: renamed from: getPopupSecondary-0d7_KjU, reason: not valid java name */
    public final long m11543getPopupSecondary0d7_KjU() {
        return this.popupSecondary;
    }

    /* JADX INFO: renamed from: getTopBarBackground-0d7_KjU, reason: not valid java name */
    public final long m11575getTopBarBackground0d7_KjU() {
        return this.topBarBackground;
    }

    /* JADX INFO: renamed from: getTopBarBackgroundSecondary-0d7_KjU, reason: not valid java name */
    public final long m11576getTopBarBackgroundSecondary0d7_KjU() {
        return this.topBarBackgroundSecondary;
    }

    /* JADX INFO: renamed from: getTopBarText-0d7_KjU, reason: not valid java name */
    public final long m11579getTopBarText0d7_KjU() {
        return this.topBarText;
    }

    /* JADX INFO: renamed from: getTopBarTextSecondary-0d7_KjU, reason: not valid java name */
    public final long m11580getTopBarTextSecondary0d7_KjU() {
        return this.topBarTextSecondary;
    }

    /* JADX INFO: renamed from: getTopBarControl-0d7_KjU, reason: not valid java name */
    public final long m11577getTopBarControl0d7_KjU() {
        return this.topBarControl;
    }

    /* JADX INFO: renamed from: getTopBarControlSecondary-0d7_KjU, reason: not valid java name */
    public final long m11578getTopBarControlSecondary0d7_KjU() {
        return this.topBarControlSecondary;
    }

    /* JADX INFO: renamed from: getTopbarTextTertiary-0d7_KjU, reason: not valid java name */
    public final long m11585getTopbarTextTertiary0d7_KjU() {
        return this.topbarTextTertiary;
    }

    /* JADX INFO: renamed from: getTopLayerBackground-0d7_KjU, reason: not valid java name */
    public final long m11581getTopLayerBackground0d7_KjU() {
        return this.topLayerBackground;
    }

    /* JADX INFO: renamed from: getTopLayerInteractiveBackground-0d7_KjU, reason: not valid java name */
    public final long m11582getTopLayerInteractiveBackground0d7_KjU() {
        return this.topLayerInteractiveBackground;
    }

    /* JADX INFO: renamed from: getTopLayerInteractiveBackgroundDisabled-0d7_KjU, reason: not valid java name */
    public final long m11583getTopLayerInteractiveBackgroundDisabled0d7_KjU() {
        return this.topLayerInteractiveBackgroundDisabled;
    }

    /* JADX INFO: renamed from: getTopLayerInteractiveSecondary-0d7_KjU, reason: not valid java name */
    public final long m11584getTopLayerInteractiveSecondary0d7_KjU() {
        return this.topLayerInteractiveSecondary;
    }

    /* JADX INFO: renamed from: getMainActiveControl-0d7_KjU, reason: not valid java name */
    public final long m11533getMainActiveControl0d7_KjU() {
        return this.mainActiveControl;
    }

    /* JADX INFO: renamed from: getMainInactiveControl-0d7_KjU, reason: not valid java name */
    public final long m11536getMainInactiveControl0d7_KjU() {
        return this.mainInactiveControl;
    }

    /* JADX INFO: renamed from: getMainActiveControlBackground-0d7_KjU, reason: not valid java name */
    public final long m11534getMainActiveControlBackground0d7_KjU() {
        return this.mainActiveControlBackground;
    }

    /* JADX INFO: renamed from: getMainActiveControlContent-0d7_KjU, reason: not valid java name */
    public final long m11535getMainActiveControlContent0d7_KjU() {
        return this.mainActiveControlContent;
    }

    /* JADX INFO: renamed from: getDefaultActionIconBackground-0d7_KjU, reason: not valid java name */
    public final long m11515getDefaultActionIconBackground0d7_KjU() {
        return this.defaultActionIconBackground;
    }

    /* JADX INFO: renamed from: getTooltipBackground-0d7_KjU, reason: not valid java name */
    public final long m11574getTooltipBackground0d7_KjU() {
        return this.tooltipBackground;
    }

    /* JADX INFO: renamed from: getItemInfoTextSecondary-0d7_KjU, reason: not valid java name */
    public final long m11526getItemInfoTextSecondary0d7_KjU() {
        return this.itemInfoTextSecondary;
    }

    /* JADX INFO: renamed from: getItemInfoTextTertiary-0d7_KjU, reason: not valid java name */
    public final long m11527getItemInfoTextTertiary0d7_KjU() {
        return this.itemInfoTextTertiary;
    }

    /* JADX INFO: renamed from: getMentionsPopupBackground-0d7_KjU, reason: not valid java name */
    public final long m11537getMentionsPopupBackground0d7_KjU() {
        return this.mentionsPopupBackground;
    }

    /* JADX INFO: renamed from: getPreviewSearchHighlight-0d7_KjU, reason: not valid java name */
    public final long m11546getPreviewSearchHighlight0d7_KjU() {
        return this.previewSearchHighlight;
    }

    /* JADX INFO: renamed from: getPreviewCitationHighlight-0d7_KjU, reason: not valid java name */
    public final long m11545getPreviewCitationHighlight0d7_KjU() {
        return this.previewCitationHighlight;
    }

    /* JADX INFO: renamed from: getThumbnailFileIconBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m11573getThumbnailFileIconBackgroundColor0d7_KjU() {
        return this.thumbnailFileIconBackgroundColor;
    }

    /* JADX INFO: renamed from: getStatusDone-0d7_KjU, reason: not valid java name */
    public final long m11558getStatusDone0d7_KjU() {
        return this.statusDone;
    }

    /* JADX INFO: renamed from: getStatusInProgress-0d7_KjU, reason: not valid java name */
    public final long m11559getStatusInProgress0d7_KjU() {
        return this.statusInProgress;
    }

    /* JADX INFO: renamed from: getDialogContainer-0d7_KjU, reason: not valid java name */
    public final long m11516getDialogContainer0d7_KjU() {
        return this.dialogContainer;
    }

    /* JADX INFO: renamed from: getDivider-0d7_KjU, reason: not valid java name */
    public final long m11517getDivider0d7_KjU() {
        return this.divider;
    }

    /* JADX INFO: renamed from: getSecondaryDivider-0d7_KjU, reason: not valid java name */
    public final long m11554getSecondaryDivider0d7_KjU() {
        return this.secondaryDivider;
    }

    /* JADX INFO: renamed from: getNotificationText-0d7_KjU, reason: not valid java name */
    public final long m11541getNotificationText0d7_KjU() {
        return this.notificationText;
    }

    /* JADX INFO: renamed from: getNotificationContainer-0d7_KjU, reason: not valid java name */
    public final long m11540getNotificationContainer0d7_KjU() {
        return this.notificationContainer;
    }

    /* JADX INFO: renamed from: getTextFieldText-0d7_KjU, reason: not valid java name */
    public final long m11572getTextFieldText0d7_KjU() {
        return this.textFieldText;
    }

    /* JADX INFO: renamed from: getTextFieldContainer-0d7_KjU, reason: not valid java name */
    public final long m11561getTextFieldContainer0d7_KjU() {
        return this.textFieldContainer;
    }

    /* JADX INFO: renamed from: getTextFieldCursor-0d7_KjU, reason: not valid java name */
    public final long m11562getTextFieldCursor0d7_KjU() {
        return this.textFieldCursor;
    }

    /* JADX INFO: renamed from: getTextFieldError-0d7_KjU, reason: not valid java name */
    public final long m11563getTextFieldError0d7_KjU() {
        return this.textFieldError;
    }

    /* JADX INFO: renamed from: getTextFieldIndicator-0d7_KjU, reason: not valid java name */
    public final long m11564getTextFieldIndicator0d7_KjU() {
        return this.textFieldIndicator;
    }

    /* JADX INFO: renamed from: getTextFieldLabel-0d7_KjU, reason: not valid java name */
    public final long m11565getTextFieldLabel0d7_KjU() {
        return this.textFieldLabel;
    }

    /* JADX INFO: renamed from: getTextFieldPlaceholder-0d7_KjU, reason: not valid java name */
    public final long m11566getTextFieldPlaceholder0d7_KjU() {
        return this.textFieldPlaceholder;
    }

    /* JADX INFO: renamed from: getTextFieldSupportingText-0d7_KjU, reason: not valid java name */
    public final long m11571getTextFieldSupportingText0d7_KjU() {
        return this.textFieldSupportingText;
    }

    /* JADX INFO: renamed from: getTextFieldSelection-0d7_KjU, reason: not valid java name */
    public final long m11567getTextFieldSelection0d7_KjU() {
        return this.textFieldSelection;
    }

    /* JADX INFO: renamed from: getTextFieldSelectionHandle-0d7_KjU, reason: not valid java name */
    public final long m11569getTextFieldSelectionHandle0d7_KjU() {
        return this.textFieldSelectionHandle;
    }

    /* JADX INFO: renamed from: getTextFieldSelectionAlt-0d7_KjU, reason: not valid java name */
    public final long m11568getTextFieldSelectionAlt0d7_KjU() {
        return this.textFieldSelectionAlt;
    }

    /* JADX INFO: renamed from: getTextFieldSelectionHandleAlt-0d7_KjU, reason: not valid java name */
    public final long m11570getTextFieldSelectionHandleAlt0d7_KjU() {
        return this.textFieldSelectionHandleAlt;
    }

    /* JADX INFO: renamed from: getSearchTextFieldPlaceholder-0d7_KjU, reason: not valid java name */
    public final long m11553getSearchTextFieldPlaceholder0d7_KjU() {
        return this.searchTextFieldPlaceholder;
    }

    /* JADX INFO: renamed from: getSnackbarContainer-0d7_KjU, reason: not valid java name */
    public final long m11556getSnackbarContainer0d7_KjU() {
        return this.snackbarContainer;
    }

    /* JADX INFO: renamed from: getSnackbarContent-0d7_KjU, reason: not valid java name */
    public final long m11557getSnackbarContent0d7_KjU() {
        return this.snackbarContent;
    }

    /* JADX INFO: renamed from: getSnackbarAction-0d7_KjU, reason: not valid java name */
    public final long m11555getSnackbarAction0d7_KjU() {
        return this.snackbarAction;
    }

    /* JADX INFO: renamed from: getItemListingContentBackground-0d7_KjU, reason: not valid java name */
    public final long m11530getItemListingContentBackground0d7_KjU() {
        return this.itemListingContentBackground;
    }

    /* JADX INFO: renamed from: getItemListingContentBackgroundSelected-0d7_KjU, reason: not valid java name */
    public final long m11531getItemListingContentBackgroundSelected0d7_KjU() {
        return this.itemListingContentBackgroundSelected;
    }

    /* JADX INFO: renamed from: getItemListingDivider-0d7_KjU, reason: not valid java name */
    public final long m11532getItemListingDivider0d7_KjU() {
        return this.itemListingDivider;
    }

    /* JADX INFO: renamed from: getItemListingBadgeContent-0d7_KjU, reason: not valid java name */
    public final long m11529getItemListingBadgeContent0d7_KjU() {
        return this.itemListingBadgeContent;
    }

    /* JADX INFO: renamed from: getItemListingBadgeBackground-0d7_KjU, reason: not valid java name */
    public final long m11528getItemListingBadgeBackground0d7_KjU() {
        return this.itemListingBadgeBackground;
    }

    /* JADX INFO: renamed from: getFileActivityVersionItemBackground-0d7_KjU, reason: not valid java name */
    public final long m11525getFileActivityVersionItemBackground0d7_KjU() {
        return this.fileActivityVersionItemBackground;
    }

    /* JADX INFO: renamed from: getFileActivityContentBackgroundSelected-0d7_KjU, reason: not valid java name */
    public final long m11522getFileActivityContentBackgroundSelected0d7_KjU() {
        return this.fileActivityContentBackgroundSelected;
    }

    /* JADX INFO: renamed from: getFileActivityReplyIndicator-0d7_KjU, reason: not valid java name */
    public final long m11523getFileActivityReplyIndicator0d7_KjU() {
        return this.fileActivityReplyIndicator;
    }

    /* JADX INFO: renamed from: getFileActivityReplyIndicatorSelected-0d7_KjU, reason: not valid java name */
    public final long m11524getFileActivityReplyIndicatorSelected0d7_KjU() {
        return this.fileActivityReplyIndicatorSelected;
    }

    /* JADX INFO: renamed from: getPreviewBackground-0d7_KjU, reason: not valid java name */
    public final long m11544getPreviewBackground0d7_KjU() {
        return this.previewBackground;
    }

    /* JADX INFO: renamed from: getFabButtonBackground-0d7_KjU, reason: not valid java name */
    public final long m11518getFabButtonBackground0d7_KjU() {
        return this.fabButtonBackground;
    }

    /* JADX INFO: renamed from: getFabButtonContent-0d7_KjU, reason: not valid java name */
    public final long m11519getFabButtonContent0d7_KjU() {
        return this.fabButtonContent;
    }

    /* JADX INFO: renamed from: getFavoriteIndicatorColor-0d7_KjU, reason: not valid java name */
    public final long m11520getFavoriteIndicatorColor0d7_KjU() {
        return this.favoriteIndicatorColor;
    }

    /* JADX INFO: renamed from: getFavoriteIndicatorSelectedColor-0d7_KjU, reason: not valid java name */
    public final long m11521getFavoriteIndicatorSelectedColor0d7_KjU() {
        return this.favoriteIndicatorSelectedColor;
    }

    /* JADX INFO: renamed from: getNoteUnreadIndicatorColor-0d7_KjU, reason: not valid java name */
    public final long m11539getNoteUnreadIndicatorColor0d7_KjU() {
        return this.noteUnreadIndicatorColor;
    }

    /* JADX INFO: renamed from: getTabRowUnselectedContent-0d7_KjU, reason: not valid java name */
    public final long m11560getTabRowUnselectedContent0d7_KjU() {
        return this.tabRowUnselectedContent;
    }

    /* JADX INFO: renamed from: getNavigationBarUnselectedContent-0d7_KjU, reason: not valid java name */
    public final long m11538getNavigationBarUnselectedContent0d7_KjU() {
        return this.navigationBarUnselectedContent;
    }

    /* JADX INFO: renamed from: getCollectionIconBackground-0d7_KjU, reason: not valid java name */
    public final long m11510getCollectionIconBackground0d7_KjU() {
        return this.collectionIconBackground;
    }

    /* JADX INFO: renamed from: getCollectionIcon-0d7_KjU, reason: not valid java name */
    public final long m11509getCollectionIcon0d7_KjU() {
        return this.collectionIcon;
    }

    /* JADX INFO: renamed from: getCollectionFavoritesIconBackground-0d7_KjU, reason: not valid java name */
    public final long m11508getCollectionFavoritesIconBackground0d7_KjU() {
        return this.collectionFavoritesIconBackground;
    }

    /* JADX INFO: renamed from: getCollectionFavoritesIcon-0d7_KjU, reason: not valid java name */
    public final long m11507getCollectionFavoritesIcon0d7_KjU() {
        return this.collectionFavoritesIcon;
    }

    /* JADX INFO: renamed from: getSearchBarCapsuleBackground-0d7_KjU, reason: not valid java name */
    public final long m11547getSearchBarCapsuleBackground0d7_KjU() {
        return this.searchBarCapsuleBackground;
    }

    /* JADX INFO: renamed from: getSearchBarCapsuleContent-0d7_KjU, reason: not valid java name */
    public final long m11548getSearchBarCapsuleContent0d7_KjU() {
        return this.searchBarCapsuleContent;
    }

    /* JADX INFO: renamed from: getSearchIconContent-0d7_KjU, reason: not valid java name */
    public final long m11552getSearchIconContent0d7_KjU() {
        return this.searchIconContent;
    }

    /* JADX INFO: renamed from: getSearchIconBackground-0d7_KjU, reason: not valid java name */
    public final long m11551getSearchIconBackground0d7_KjU() {
        return this.searchIconBackground;
    }

    /* JADX INFO: renamed from: getSearchFilterChipContent-0d7_KjU, reason: not valid java name */
    public final long m11550getSearchFilterChipContent0d7_KjU() {
        return this.searchFilterChipContent;
    }

    /* JADX INFO: renamed from: getSearchFilterChipBackground-0d7_KjU, reason: not valid java name */
    public final long m11549getSearchFilterChipBackground0d7_KjU() {
        return this.searchFilterChipBackground;
    }

    /* JADX INFO: renamed from: getCheckboxCheckedColor-0d7_KjU, reason: not valid java name */
    public final long m11504getCheckboxCheckedColor0d7_KjU() {
        return this.checkboxCheckedColor;
    }

    /* JADX INFO: renamed from: getCheckboxUncheckedColor-0d7_KjU, reason: not valid java name */
    public final long m11506getCheckboxUncheckedColor0d7_KjU() {
        return this.checkboxUncheckedColor;
    }

    /* JADX INFO: renamed from: getCheckboxCheckmarkColor-0d7_KjU, reason: not valid java name */
    public final long m11505getCheckboxCheckmarkColor0d7_KjU() {
        return this.checkboxCheckmarkColor;
    }

    /* JADX INFO: renamed from: getBoxAiLabelBackground-0d7_KjU, reason: not valid java name */
    public final long m11503getBoxAiLabelBackground0d7_KjU() {
        return this.boxAiLabelBackground;
    }

    /* JADX INFO: renamed from: getBoxAiGradientTextStart-0d7_KjU, reason: not valid java name */
    public final long m11502getBoxAiGradientTextStart0d7_KjU() {
        return this.boxAiGradientTextStart;
    }

    /* JADX INFO: renamed from: getBoxAiGradientTextEnd-0d7_KjU, reason: not valid java name */
    public final long m11501getBoxAiGradientTextEnd0d7_KjU() {
        return this.boxAiGradientTextEnd;
    }
}
