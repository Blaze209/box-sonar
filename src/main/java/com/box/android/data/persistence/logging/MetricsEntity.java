package com.box.android.data.persistence.logging;

import androidx.media3.common.C;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.models.observability.ApdexScore;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MetricsEntity.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0018\u0002\n\u0003\b\u0081\u0001\b\u0087\b\u0018\u00002\u00020\u0001BË\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u000106\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u00109\u001a\u00020\u0011\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b=\u0010>J\t\u0010}\u001a\u00020\u0003HÆ\u0003J\t\u0010~\u001a\u00020\u0005HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010LJ\n\u0010\u0088\u0001\u001a\u00020\u0011HÆ\u0003J\n\u0010\u0089\u0001\u001a\u00020\u0005HÆ\u0003J\n\u0010\u008a\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\n\u0010\u008d\u0001\u001a\u00020\u0005HÆ\u0003J\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010WJ\u0011\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010LJ\n\u0010\u0091\u0001\u001a\u00020\u000fHÆ\u0003J\f\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0002\u0010`J\f\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0002\u0010`J\f\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0099\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010LJ\u0011\u0010\u009a\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010LJ\f\u0010\u009b\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010\u009c\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010LJ\u0011\u0010\u009e\u0001\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0002\u0010jJ\f\u0010\u009f\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010 \u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¡\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¢\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010£\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010WJ\u0011\u0010¤\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010WJ\u0011\u0010¥\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010WJ\u0011\u0010¦\u0001\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010WJ\u0011\u0010§\u0001\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010LJ\u0011\u0010¨\u0001\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0002\u0010jJ\u0011\u0010©\u0001\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0002\u0010jJ\f\u0010ª\u0001\u001a\u0004\u0018\u000106HÆ\u0003J\u0011\u0010«\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0002\u0010`J\u0011\u0010¬\u0001\u001a\u0004\u0018\u00010\u001fHÆ\u0003¢\u0006\u0002\u0010`J\n\u0010\u00ad\u0001\u001a\u00020\u0011HÆ\u0003J\f\u0010®\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010¯\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\f\u0010°\u0001\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jê\u0004\u0010±\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u001a\u001a\u00020\u000f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u00103\u001a\u0004\u0018\u00010)2\n\b\u0002\u00104\u001a\u0004\u0018\u00010)2\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u00109\u001a\u00020\u00112\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0003\u0010²\u0001J\u0015\u0010³\u0001\u001a\u00020\u001f2\t\u0010´\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010µ\u0001\u001a\u00020\u000fHÖ\u0001J\n\u0010¶\u0001\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bC\u0010BR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010BR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bE\u0010BR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010BR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010BR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010BR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bI\u0010BR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010BR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010M\u001a\u0004\bK\u0010LR\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bN\u0010OR\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bP\u0010BR\u0016\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010BR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bR\u0010BR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bS\u0010BR\u0016\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bT\u0010BR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bU\u0010BR\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010X\u001a\u0004\bV\u0010WR\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010M\u001a\u0004\bY\u0010LR\u0016\u0010\u001a\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bZ\u0010[R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010BR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010BR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b^\u0010BR\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010a\u001a\u0004\b_\u0010`R\u0018\u0010 \u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010BR\u001a\u0010!\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010a\u001a\u0004\b!\u0010`R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bc\u0010BR\u001a\u0010#\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010M\u001a\u0004\bd\u0010LR\u001a\u0010$\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010M\u001a\u0004\be\u0010LR\u0018\u0010%\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bf\u0010BR\u0018\u0010&\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bg\u0010BR\u001a\u0010'\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010M\u001a\u0004\bh\u0010LR\u001a\u0010(\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010k\u001a\u0004\bi\u0010jR\u0018\u0010*\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bl\u0010BR\u0018\u0010+\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bm\u0010BR\u0018\u0010,\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bn\u0010BR\u0018\u0010-\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bo\u0010BR\u001a\u0010.\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010X\u001a\u0004\bp\u0010WR\u001a\u0010/\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010X\u001a\u0004\bq\u0010WR\u001a\u00100\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010X\u001a\u0004\br\u0010WR\u001a\u00101\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010X\u001a\u0004\bs\u0010WR\u001a\u00102\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010M\u001a\u0004\bt\u0010LR\u001a\u00103\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010k\u001a\u0004\bu\u0010jR\u001a\u00104\u001a\u0004\u0018\u00010)8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010k\u001a\u0004\bv\u0010jR\u0018\u00105\u001a\u0004\u0018\u0001068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010xR\u001a\u00107\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010a\u001a\u0004\b7\u0010`R\u001a\u00108\u001a\u0004\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010a\u001a\u0004\b8\u0010`R\u0016\u00109\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\by\u0010OR\u0018\u0010:\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bz\u0010BR\u0018\u0010;\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b{\u0010BR\u0018\u0010<\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b|\u0010B¨\u0006·\u0001"}, d2 = {"Lcom/box/android/data/persistence/logging/MetricsEntity;", "", "category", "Lcom/box/android/data/persistence/logging/MetricsCategory;", "eventType", "", OAuthActivity.USER_ID, "username", "enterpriseId", "message", "formattedMessage", "fileId", BoxCommonConstants.EXTRA_FILE_NAME, "methodName", "methodLine", "", "timestamp", "", RemoteConfigConstants.RequestFieldKey.APP_VERSION, RemoteConfigConstants.RequestFieldKey.APP_ID, "deviceModel", "osVersion", "platform", "status", "duration", "numItems", "count", "type", "milestone", "subtype", TelemetryEventStrings.Value.FAILED, "", "value", "isRecoverable", "jobManagerVersion", "numberOfAutomaticRetries", "numberOfManualRetries", "completionStatusString", "failReason", "errorCode", "sizeKB", "", "sizeBucket", "folderId", "testJobName", "testName", "timeToStart", "rate", "totalTime", "bytesUploaded", "numOfParallelChunks", "secondaryMeasurement", "magnitude", FirebaseAnalytics.Param.SCORE, "Lcom/box/android/domain/models/observability/ApdexScore;", "isNewVersionUpload", "isUserTriggeredJob", "id", "itemState", "sourceTab", "uiSource", "<init>", "(Lcom/box/android/data/persistence/logging/MetricsCategory;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Lcom/box/android/domain/models/observability/ApdexScore;Ljava/lang/Boolean;Ljava/lang/Boolean;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategory", "()Lcom/box/android/data/persistence/logging/MetricsCategory;", "getEventType", "()Ljava/lang/String;", "getUserId", "getUsername", "getEnterpriseId", "getMessage", "getFormattedMessage", "getFileId", "getFileName", "getMethodName", "getMethodLine", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTimestamp", "()J", "getAppVersion", "getAppId", "getDeviceModel", "getOsVersion", "getPlatform", "getStatus", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNumItems", "getCount", "()I", "getType", "getMilestone", "getSubtype", "getFailed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getValue", "getJobManagerVersion", "getNumberOfAutomaticRetries", "getNumberOfManualRetries", "getCompletionStatusString", "getFailReason", "getErrorCode", "getSizeKB", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSizeBucket", "getFolderId", "getTestJobName", "getTestName", "getTimeToStart", "getRate", "getTotalTime", "getBytesUploaded", "getNumOfParallelChunks", "getSecondaryMeasurement", "getMagnitude", "getScore", "()Lcom/box/android/domain/models/observability/ApdexScore;", "getId", "getItemState", "getSourceTab", "getUiSource", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "component43", "component44", "component45", "component46", "component47", "component48", "component49", "component50", "component51", "component52", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Lcom/box/android/data/persistence/logging/MetricsCategory;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;Lcom/box/android/domain/models/observability/ApdexScore;Ljava/lang/Boolean;Ljava/lang/Boolean;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/box/android/data/persistence/logging/MetricsEntity;", "equals", "other", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class MetricsEntity {
    private final String appId;
    private final String appVersion;
    private final Long bytesUploaded;
    private final MetricsCategory category;
    private final String completionStatusString;
    private final int count;
    private final String deviceModel;
    private final Long duration;
    private final String enterpriseId;
    private final Integer errorCode;
    private final String eventType;
    private final String failReason;
    private final Boolean failed;
    private final String fileId;
    private final String fileName;
    private final String folderId;
    private final String formattedMessage;
    private final long id;
    private final Boolean isNewVersionUpload;
    private final Boolean isRecoverable;
    private final Boolean isUserTriggeredJob;
    private final String itemState;
    private final String jobManagerVersion;
    private final Double magnitude;
    private final String message;
    private final Integer methodLine;
    private final String methodName;
    private final String milestone;
    private final Integer numItems;
    private final Integer numOfParallelChunks;
    private final Integer numberOfAutomaticRetries;
    private final Integer numberOfManualRetries;
    private final String osVersion;
    private final String platform;
    private final Long rate;
    private final ApdexScore score;
    private final Double secondaryMeasurement;
    private final String sizeBucket;
    private final Double sizeKB;
    private final String sourceTab;
    private final String status;
    private final String subtype;
    private final String testJobName;
    private final String testName;
    private final Long timeToStart;
    private final long timestamp;
    private final Long totalTime;
    private final String type;
    private final String uiSource;
    private final String userId;
    private final String username;
    private final String value;

    public static /* synthetic */ MetricsEntity copy$default(MetricsEntity metricsEntity, MetricsCategory metricsCategory, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, long j, String str10, String str11, String str12, String str13, String str14, String str15, Long l, Integer num2, int i, String str16, String str17, String str18, Boolean bool, String str19, Boolean bool2, String str20, Integer num3, Integer num4, String str21, String str22, Integer num5, Double d, String str23, String str24, String str25, String str26, Long l2, Long l3, Long l4, Long l5, Integer num6, Double d2, Double d3, ApdexScore apdexScore, Boolean bool3, Boolean bool4, long j2, String str27, String str28, String str29, int i2, int i3, Object obj) {
        String str30;
        String str31;
        MetricsCategory metricsCategory2 = (i2 & 1) != 0 ? metricsEntity.category : metricsCategory;
        String str32 = (i2 & 2) != 0 ? metricsEntity.eventType : str;
        String str33 = (i2 & 4) != 0 ? metricsEntity.userId : str2;
        String str34 = (i2 & 8) != 0 ? metricsEntity.username : str3;
        String str35 = (i2 & 16) != 0 ? metricsEntity.enterpriseId : str4;
        String str36 = (i2 & 32) != 0 ? metricsEntity.message : str5;
        String str37 = (i2 & 64) != 0 ? metricsEntity.formattedMessage : str6;
        String str38 = (i2 & 128) != 0 ? metricsEntity.fileId : str7;
        String str39 = (i2 & 256) != 0 ? metricsEntity.fileName : str8;
        String str40 = (i2 & 512) != 0 ? metricsEntity.methodName : str9;
        Integer num7 = (i2 & 1024) != 0 ? metricsEntity.methodLine : num;
        long j3 = (i2 & 2048) != 0 ? metricsEntity.timestamp : j;
        MetricsCategory metricsCategory3 = metricsCategory2;
        String str41 = (i2 & 4096) != 0 ? metricsEntity.appVersion : str10;
        String str42 = (i2 & 8192) != 0 ? metricsEntity.appId : str11;
        String str43 = (i2 & 16384) != 0 ? metricsEntity.deviceModel : str12;
        String str44 = (i2 & 32768) != 0 ? metricsEntity.osVersion : str13;
        String str45 = (i2 & 65536) != 0 ? metricsEntity.platform : str14;
        String str46 = (i2 & 131072) != 0 ? metricsEntity.status : str15;
        Long l6 = (i2 & 262144) != 0 ? metricsEntity.duration : l;
        Integer num8 = (i2 & 524288) != 0 ? metricsEntity.numItems : num2;
        int i4 = (i2 & 1048576) != 0 ? metricsEntity.count : i;
        String str47 = (i2 & 2097152) != 0 ? metricsEntity.type : str16;
        String str48 = (i2 & 4194304) != 0 ? metricsEntity.milestone : str17;
        String str49 = (i2 & 8388608) != 0 ? metricsEntity.subtype : str18;
        Boolean bool5 = (i2 & 16777216) != 0 ? metricsEntity.failed : bool;
        String str50 = (i2 & 33554432) != 0 ? metricsEntity.value : str19;
        Boolean bool6 = (i2 & 67108864) != 0 ? metricsEntity.isRecoverable : bool2;
        String str51 = (i2 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? metricsEntity.jobManagerVersion : str20;
        Integer num9 = (i2 & 268435456) != 0 ? metricsEntity.numberOfAutomaticRetries : num3;
        Integer num10 = (i2 & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? metricsEntity.numberOfManualRetries : num4;
        String str52 = (i2 & 1073741824) != 0 ? metricsEntity.completionStatusString : str21;
        String str53 = (i2 & Integer.MIN_VALUE) != 0 ? metricsEntity.failReason : str22;
        Integer num11 = (i3 & 1) != 0 ? metricsEntity.errorCode : num5;
        Double d4 = (i3 & 2) != 0 ? metricsEntity.sizeKB : d;
        String str54 = (i3 & 4) != 0 ? metricsEntity.sizeBucket : str23;
        String str55 = (i3 & 8) != 0 ? metricsEntity.folderId : str24;
        String str56 = (i3 & 16) != 0 ? metricsEntity.testJobName : str25;
        String str57 = (i3 & 32) != 0 ? metricsEntity.testName : str26;
        Long l7 = (i3 & 64) != 0 ? metricsEntity.timeToStart : l2;
        Long l8 = (i3 & 128) != 0 ? metricsEntity.rate : l3;
        Long l9 = (i3 & 256) != 0 ? metricsEntity.totalTime : l4;
        Long l10 = (i3 & 512) != 0 ? metricsEntity.bytesUploaded : l5;
        Integer num12 = (i3 & 1024) != 0 ? metricsEntity.numOfParallelChunks : num6;
        Double d5 = (i3 & 2048) != 0 ? metricsEntity.secondaryMeasurement : d2;
        Double d6 = (i3 & 4096) != 0 ? metricsEntity.magnitude : d3;
        ApdexScore apdexScore2 = (i3 & 8192) != 0 ? metricsEntity.score : apdexScore;
        Boolean bool7 = (i3 & 16384) != 0 ? metricsEntity.isNewVersionUpload : bool3;
        Boolean bool8 = (i3 & 32768) != 0 ? metricsEntity.isUserTriggeredJob : bool4;
        long j4 = (i3 & 65536) != 0 ? metricsEntity.id : j2;
        String str58 = (i3 & 131072) != 0 ? metricsEntity.itemState : str27;
        String str59 = (i3 & 262144) != 0 ? metricsEntity.sourceTab : str28;
        if ((i3 & 524288) != 0) {
            str31 = str58;
            str30 = metricsEntity.uiSource;
        } else {
            str30 = str29;
            str31 = str58;
        }
        return metricsEntity.copy(metricsCategory3, str32, str33, str34, str35, str36, str37, str38, str39, str40, num7, j3, str41, str42, str43, str44, str45, str46, l6, num8, i4, str47, str48, str49, bool5, str50, bool6, str51, num9, num10, str52, str53, num11, d4, str54, str55, str56, str57, l7, l8, l9, l10, num12, d5, d6, apdexScore2, bool7, bool8, j4, str31, str59, str30);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final MetricsCategory getCategory() {
        return this.category;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getMethodName() {
        return this.methodName;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getMethodLine() {
        return this.methodLine;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getEventType() {
        return this.eventType;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final Integer getNumItems() {
        return this.numItems;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getMilestone() {
        return this.milestone;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final String getSubtype() {
        return this.subtype;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final Boolean getFailed() {
        return this.failed;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component27, reason: from getter */
    public final Boolean getIsRecoverable() {
        return this.isRecoverable;
    }

    /* JADX INFO: renamed from: component28, reason: from getter */
    public final String getJobManagerVersion() {
        return this.jobManagerVersion;
    }

    /* JADX INFO: renamed from: component29, reason: from getter */
    public final Integer getNumberOfAutomaticRetries() {
        return this.numberOfAutomaticRetries;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final Integer getNumberOfManualRetries() {
        return this.numberOfManualRetries;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final String getCompletionStatusString() {
        return this.completionStatusString;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final Double getSizeKB() {
        return this.sizeKB;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final String getSizeBucket() {
        return this.sizeBucket;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final String getFolderId() {
        return this.folderId;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final String getTestJobName() {
        return this.testJobName;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final String getTestName() {
        return this.testName;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final Long getTimeToStart() {
        return this.timeToStart;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final Long getRate() {
        return this.rate;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final Long getTotalTime() {
        return this.totalTime;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final Long getBytesUploaded() {
        return this.bytesUploaded;
    }

    /* JADX INFO: renamed from: component43, reason: from getter */
    public final Integer getNumOfParallelChunks() {
        return this.numOfParallelChunks;
    }

    /* JADX INFO: renamed from: component44, reason: from getter */
    public final Double getSecondaryMeasurement() {
        return this.secondaryMeasurement;
    }

    /* JADX INFO: renamed from: component45, reason: from getter */
    public final Double getMagnitude() {
        return this.magnitude;
    }

    /* JADX INFO: renamed from: component46, reason: from getter */
    public final ApdexScore getScore() {
        return this.score;
    }

    /* JADX INFO: renamed from: component47, reason: from getter */
    public final Boolean getIsNewVersionUpload() {
        return this.isNewVersionUpload;
    }

    /* JADX INFO: renamed from: component48, reason: from getter */
    public final Boolean getIsUserTriggeredJob() {
        return this.isUserTriggeredJob;
    }

    /* JADX INFO: renamed from: component49, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getEnterpriseId() {
        return this.enterpriseId;
    }

    /* JADX INFO: renamed from: component50, reason: from getter */
    public final String getItemState() {
        return this.itemState;
    }

    /* JADX INFO: renamed from: component51, reason: from getter */
    public final String getSourceTab() {
        return this.sourceTab;
    }

    /* JADX INFO: renamed from: component52, reason: from getter */
    public final String getUiSource() {
        return this.uiSource;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getFormattedMessage() {
        return this.formattedMessage;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    public final MetricsEntity copy(MetricsCategory category, String eventType, String userId, String username, String enterpriseId, String message, String formattedMessage, String fileId, String fileName, String methodName, Integer methodLine, long timestamp, String appVersion, String appId, String deviceModel, String osVersion, String platform, String status, Long duration, Integer numItems, int count, String type, String milestone, String subtype, Boolean failed, String value, Boolean isRecoverable, String jobManagerVersion, Integer numberOfAutomaticRetries, Integer numberOfManualRetries, String completionStatusString, String failReason, Integer errorCode, Double sizeKB, String sizeBucket, String folderId, String testJobName, String testName, Long timeToStart, Long rate, Long totalTime, Long bytesUploaded, Integer numOfParallelChunks, Double secondaryMeasurement, Double magnitude, ApdexScore score, Boolean isNewVersionUpload, Boolean isUserTriggeredJob, long id, String itemState, String sourceTab, String uiSource) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(enterpriseId, "enterpriseId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(platform, "platform");
        return new MetricsEntity(category, eventType, userId, username, enterpriseId, message, formattedMessage, fileId, fileName, methodName, methodLine, timestamp, appVersion, appId, deviceModel, osVersion, platform, status, duration, numItems, count, type, milestone, subtype, failed, value, isRecoverable, jobManagerVersion, numberOfAutomaticRetries, numberOfManualRetries, completionStatusString, failReason, errorCode, sizeKB, sizeBucket, folderId, testJobName, testName, timeToStart, rate, totalTime, bytesUploaded, numOfParallelChunks, secondaryMeasurement, magnitude, score, isNewVersionUpload, isUserTriggeredJob, id, itemState, sourceTab, uiSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetricsEntity)) {
            return false;
        }
        MetricsEntity metricsEntity = (MetricsEntity) other;
        return this.category == metricsEntity.category && Intrinsics.areEqual(this.eventType, metricsEntity.eventType) && Intrinsics.areEqual(this.userId, metricsEntity.userId) && Intrinsics.areEqual(this.username, metricsEntity.username) && Intrinsics.areEqual(this.enterpriseId, metricsEntity.enterpriseId) && Intrinsics.areEqual(this.message, metricsEntity.message) && Intrinsics.areEqual(this.formattedMessage, metricsEntity.formattedMessage) && Intrinsics.areEqual(this.fileId, metricsEntity.fileId) && Intrinsics.areEqual(this.fileName, metricsEntity.fileName) && Intrinsics.areEqual(this.methodName, metricsEntity.methodName) && Intrinsics.areEqual(this.methodLine, metricsEntity.methodLine) && this.timestamp == metricsEntity.timestamp && Intrinsics.areEqual(this.appVersion, metricsEntity.appVersion) && Intrinsics.areEqual(this.appId, metricsEntity.appId) && Intrinsics.areEqual(this.deviceModel, metricsEntity.deviceModel) && Intrinsics.areEqual(this.osVersion, metricsEntity.osVersion) && Intrinsics.areEqual(this.platform, metricsEntity.platform) && Intrinsics.areEqual(this.status, metricsEntity.status) && Intrinsics.areEqual(this.duration, metricsEntity.duration) && Intrinsics.areEqual(this.numItems, metricsEntity.numItems) && this.count == metricsEntity.count && Intrinsics.areEqual(this.type, metricsEntity.type) && Intrinsics.areEqual(this.milestone, metricsEntity.milestone) && Intrinsics.areEqual(this.subtype, metricsEntity.subtype) && Intrinsics.areEqual(this.failed, metricsEntity.failed) && Intrinsics.areEqual(this.value, metricsEntity.value) && Intrinsics.areEqual(this.isRecoverable, metricsEntity.isRecoverable) && Intrinsics.areEqual(this.jobManagerVersion, metricsEntity.jobManagerVersion) && Intrinsics.areEqual(this.numberOfAutomaticRetries, metricsEntity.numberOfAutomaticRetries) && Intrinsics.areEqual(this.numberOfManualRetries, metricsEntity.numberOfManualRetries) && Intrinsics.areEqual(this.completionStatusString, metricsEntity.completionStatusString) && Intrinsics.areEqual(this.failReason, metricsEntity.failReason) && Intrinsics.areEqual(this.errorCode, metricsEntity.errorCode) && Intrinsics.areEqual((Object) this.sizeKB, (Object) metricsEntity.sizeKB) && Intrinsics.areEqual(this.sizeBucket, metricsEntity.sizeBucket) && Intrinsics.areEqual(this.folderId, metricsEntity.folderId) && Intrinsics.areEqual(this.testJobName, metricsEntity.testJobName) && Intrinsics.areEqual(this.testName, metricsEntity.testName) && Intrinsics.areEqual(this.timeToStart, metricsEntity.timeToStart) && Intrinsics.areEqual(this.rate, metricsEntity.rate) && Intrinsics.areEqual(this.totalTime, metricsEntity.totalTime) && Intrinsics.areEqual(this.bytesUploaded, metricsEntity.bytesUploaded) && Intrinsics.areEqual(this.numOfParallelChunks, metricsEntity.numOfParallelChunks) && Intrinsics.areEqual((Object) this.secondaryMeasurement, (Object) metricsEntity.secondaryMeasurement) && Intrinsics.areEqual((Object) this.magnitude, (Object) metricsEntity.magnitude) && Intrinsics.areEqual(this.score, metricsEntity.score) && Intrinsics.areEqual(this.isNewVersionUpload, metricsEntity.isNewVersionUpload) && Intrinsics.areEqual(this.isUserTriggeredJob, metricsEntity.isUserTriggeredJob) && this.id == metricsEntity.id && Intrinsics.areEqual(this.itemState, metricsEntity.itemState) && Intrinsics.areEqual(this.sourceTab, metricsEntity.sourceTab) && Intrinsics.areEqual(this.uiSource, metricsEntity.uiSource);
    }

    public int hashCode() {
        int iHashCode = ((((((((this.category.hashCode() * 31) + this.eventType.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.username.hashCode()) * 31) + this.enterpriseId.hashCode()) * 31;
        String str = this.message;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.formattedMessage;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.fileId;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.fileName;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.methodName;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.methodLine;
        int iHashCode7 = (((((((iHashCode6 + (num == null ? 0 : num.hashCode())) * 31) + Long.hashCode(this.timestamp)) * 31) + this.appVersion.hashCode()) * 31) + this.appId.hashCode()) * 31;
        String str6 = this.deviceModel;
        int iHashCode8 = (iHashCode7 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.osVersion;
        int iHashCode9 = (((iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.platform.hashCode()) * 31;
        String str8 = this.status;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Long l = this.duration;
        int iHashCode11 = (iHashCode10 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num2 = this.numItems;
        int iHashCode12 = (((iHashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31) + Integer.hashCode(this.count)) * 31;
        String str9 = this.type;
        int iHashCode13 = (iHashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.milestone;
        int iHashCode14 = (iHashCode13 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.subtype;
        int iHashCode15 = (iHashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Boolean bool = this.failed;
        int iHashCode16 = (iHashCode15 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str12 = this.value;
        int iHashCode17 = (iHashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Boolean bool2 = this.isRecoverable;
        int iHashCode18 = (iHashCode17 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str13 = this.jobManagerVersion;
        int iHashCode19 = (iHashCode18 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num3 = this.numberOfAutomaticRetries;
        int iHashCode20 = (iHashCode19 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.numberOfManualRetries;
        int iHashCode21 = (iHashCode20 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str14 = this.completionStatusString;
        int iHashCode22 = (iHashCode21 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.failReason;
        int iHashCode23 = (iHashCode22 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Integer num5 = this.errorCode;
        int iHashCode24 = (iHashCode23 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Double d = this.sizeKB;
        int iHashCode25 = (iHashCode24 + (d == null ? 0 : d.hashCode())) * 31;
        String str16 = this.sizeBucket;
        int iHashCode26 = (iHashCode25 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.folderId;
        int iHashCode27 = (iHashCode26 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.testJobName;
        int iHashCode28 = (iHashCode27 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.testName;
        int iHashCode29 = (iHashCode28 + (str19 == null ? 0 : str19.hashCode())) * 31;
        Long l2 = this.timeToStart;
        int iHashCode30 = (iHashCode29 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.rate;
        int iHashCode31 = (iHashCode30 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.totalTime;
        int iHashCode32 = (iHashCode31 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.bytesUploaded;
        int iHashCode33 = (iHashCode32 + (l5 == null ? 0 : l5.hashCode())) * 31;
        Integer num6 = this.numOfParallelChunks;
        int iHashCode34 = (iHashCode33 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Double d2 = this.secondaryMeasurement;
        int iHashCode35 = (iHashCode34 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Double d3 = this.magnitude;
        int iHashCode36 = (iHashCode35 + (d3 == null ? 0 : d3.hashCode())) * 31;
        ApdexScore apdexScore = this.score;
        int iHashCode37 = (iHashCode36 + (apdexScore == null ? 0 : apdexScore.hashCode())) * 31;
        Boolean bool3 = this.isNewVersionUpload;
        int iHashCode38 = (iHashCode37 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.isUserTriggeredJob;
        int iHashCode39 = (((iHashCode38 + (bool4 == null ? 0 : bool4.hashCode())) * 31) + Long.hashCode(this.id)) * 31;
        String str20 = this.itemState;
        int iHashCode40 = (iHashCode39 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.sourceTab;
        int iHashCode41 = (iHashCode40 + (str21 == null ? 0 : str21.hashCode())) * 31;
        String str22 = this.uiSource;
        return iHashCode41 + (str22 != null ? str22.hashCode() : 0);
    }

    public String toString() {
        return "MetricsEntity(category=" + this.category + ", eventType=" + this.eventType + ", userId=" + this.userId + ", username=" + this.username + ", enterpriseId=" + this.enterpriseId + ", message=" + this.message + ", formattedMessage=" + this.formattedMessage + ", fileId=" + this.fileId + ", fileName=" + this.fileName + ", methodName=" + this.methodName + ", methodLine=" + this.methodLine + ", timestamp=" + this.timestamp + ", appVersion=" + this.appVersion + ", appId=" + this.appId + ", deviceModel=" + this.deviceModel + ", osVersion=" + this.osVersion + ", platform=" + this.platform + ", status=" + this.status + ", duration=" + this.duration + ", numItems=" + this.numItems + ", count=" + this.count + ", type=" + this.type + ", milestone=" + this.milestone + ", subtype=" + this.subtype + ", failed=" + this.failed + ", value=" + this.value + ", isRecoverable=" + this.isRecoverable + ", jobManagerVersion=" + this.jobManagerVersion + ", numberOfAutomaticRetries=" + this.numberOfAutomaticRetries + ", numberOfManualRetries=" + this.numberOfManualRetries + ", completionStatusString=" + this.completionStatusString + ", failReason=" + this.failReason + ", errorCode=" + this.errorCode + ", sizeKB=" + this.sizeKB + ", sizeBucket=" + this.sizeBucket + ", folderId=" + this.folderId + ", testJobName=" + this.testJobName + ", testName=" + this.testName + ", timeToStart=" + this.timeToStart + ", rate=" + this.rate + ", totalTime=" + this.totalTime + ", bytesUploaded=" + this.bytesUploaded + ", numOfParallelChunks=" + this.numOfParallelChunks + ", secondaryMeasurement=" + this.secondaryMeasurement + ", magnitude=" + this.magnitude + ", score=" + this.score + ", isNewVersionUpload=" + this.isNewVersionUpload + ", isUserTriggeredJob=" + this.isUserTriggeredJob + ", id=" + this.id + ", itemState=" + this.itemState + ", sourceTab=" + this.sourceTab + ", uiSource=" + this.uiSource + ")";
    }

    public MetricsEntity(MetricsCategory category, String eventType, String userId, String username, String enterpriseId, String str, String str2, String str3, String str4, String str5, Integer num, long j, String appVersion, String appId, String str6, String str7, String platform, String str8, Long l, Integer num2, int i, String str9, String str10, String str11, Boolean bool, String str12, Boolean bool2, String str13, Integer num3, Integer num4, String str14, String str15, Integer num5, Double d, String str16, String str17, String str18, String str19, Long l2, Long l3, Long l4, Long l5, Integer num6, Double d2, Double d3, ApdexScore apdexScore, Boolean bool3, Boolean bool4, long j2, String str20, String str21, String str22) {
        Intrinsics.checkNotNullParameter(category, "category");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(enterpriseId, "enterpriseId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(platform, "platform");
        this.category = category;
        this.eventType = eventType;
        this.userId = userId;
        this.username = username;
        this.enterpriseId = enterpriseId;
        this.message = str;
        this.formattedMessage = str2;
        this.fileId = str3;
        this.fileName = str4;
        this.methodName = str5;
        this.methodLine = num;
        this.timestamp = j;
        this.appVersion = appVersion;
        this.appId = appId;
        this.deviceModel = str6;
        this.osVersion = str7;
        this.platform = platform;
        this.status = str8;
        this.duration = l;
        this.numItems = num2;
        this.count = i;
        this.type = str9;
        this.milestone = str10;
        this.subtype = str11;
        this.failed = bool;
        this.value = str12;
        this.isRecoverable = bool2;
        this.jobManagerVersion = str13;
        this.numberOfAutomaticRetries = num3;
        this.numberOfManualRetries = num4;
        this.completionStatusString = str14;
        this.failReason = str15;
        this.errorCode = num5;
        this.sizeKB = d;
        this.sizeBucket = str16;
        this.folderId = str17;
        this.testJobName = str18;
        this.testName = str19;
        this.timeToStart = l2;
        this.rate = l3;
        this.totalTime = l4;
        this.bytesUploaded = l5;
        this.numOfParallelChunks = num6;
        this.secondaryMeasurement = d2;
        this.magnitude = d3;
        this.score = apdexScore;
        this.isNewVersionUpload = bool3;
        this.isUserTriggeredJob = bool4;
        this.id = j2;
        this.itemState = str20;
        this.sourceTab = str21;
        this.uiSource = str22;
    }

    public final MetricsCategory getCategory() {
        return this.category;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUsername() {
        return this.username;
    }

    public final String getEnterpriseId() {
        return this.enterpriseId;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getFormattedMessage() {
        return this.formattedMessage;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final Integer getMethodLine() {
        return this.methodLine;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public /* synthetic */ MetricsEntity(MetricsCategory metricsCategory, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, long j, String str10, String str11, String str12, String str13, String str14, String str15, Long l, Integer num2, int i, String str16, String str17, String str18, Boolean bool, String str19, Boolean bool2, String str20, Integer num3, Integer num4, String str21, String str22, Integer num5, Double d, String str23, String str24, String str25, String str26, Long l2, Long l3, Long l4, Long l5, Integer num6, Double d2, Double d3, ApdexScore apdexScore, Boolean bool3, Boolean bool4, long j2, String str27, String str28, String str29, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(metricsCategory, str, str2, str3, str4, (i2 & 32) != 0 ? null : str5, (i2 & 64) != 0 ? null : str6, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? null : str8, (i2 & 512) != 0 ? null : str9, (i2 & 1024) != 0 ? null : num, j, str10, str11, str12, str13, str14, (i2 & 131072) != 0 ? "" : str15, (i2 & 262144) != 0 ? 0L : l, (i2 & 524288) != 0 ? null : num2, (1048576 & i2) != 0 ? 1 : i, (2097152 & i2) != 0 ? null : str16, (4194304 & i2) != 0 ? null : str17, (8388608 & i2) != 0 ? null : str18, (16777216 & i2) != 0 ? null : bool, (33554432 & i2) != 0 ? null : str19, (67108864 & i2) != 0 ? null : bool2, (134217728 & i2) != 0 ? null : str20, (268435456 & i2) != 0 ? null : num3, (536870912 & i2) != 0 ? null : num4, (1073741824 & i2) != 0 ? null : str21, (i2 & Integer.MIN_VALUE) != 0 ? null : str22, (i3 & 1) != 0 ? null : num5, (i3 & 2) != 0 ? null : d, (i3 & 4) != 0 ? null : str23, (i3 & 8) != 0 ? null : str24, (i3 & 16) != 0 ? null : str25, (i3 & 32) != 0 ? null : str26, (i3 & 64) != 0 ? null : l2, (i3 & 128) != 0 ? null : l3, (i3 & 256) != 0 ? null : l4, (i3 & 512) != 0 ? null : l5, (i3 & 1024) != 0 ? null : num6, (i3 & 2048) != 0 ? null : d2, (i3 & 4096) != 0 ? null : d3, (i3 & 8192) != 0 ? null : apdexScore, (i3 & 16384) != 0 ? null : bool3, (32768 & i3) != 0 ? null : bool4, (65536 & i3) != 0 ? 0L : j2, (i3 & 131072) != 0 ? null : str27, (i3 & 262144) != 0 ? null : str28, (i3 & 524288) != 0 ? null : str29);
    }

    public final String getStatus() {
        return this.status;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final Integer getNumItems() {
        return this.numItems;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getType() {
        return this.type;
    }

    public final String getMilestone() {
        return this.milestone;
    }

    public final String getSubtype() {
        return this.subtype;
    }

    public final Boolean getFailed() {
        return this.failed;
    }

    public final String getValue() {
        return this.value;
    }

    public final Boolean isRecoverable() {
        return this.isRecoverable;
    }

    public final String getJobManagerVersion() {
        return this.jobManagerVersion;
    }

    public final Integer getNumberOfAutomaticRetries() {
        return this.numberOfAutomaticRetries;
    }

    public final Integer getNumberOfManualRetries() {
        return this.numberOfManualRetries;
    }

    public final String getCompletionStatusString() {
        return this.completionStatusString;
    }

    public final String getFailReason() {
        return this.failReason;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final Double getSizeKB() {
        return this.sizeKB;
    }

    public final String getSizeBucket() {
        return this.sizeBucket;
    }

    public final String getFolderId() {
        return this.folderId;
    }

    public final String getTestJobName() {
        return this.testJobName;
    }

    public final String getTestName() {
        return this.testName;
    }

    public final Long getTimeToStart() {
        return this.timeToStart;
    }

    public final Long getRate() {
        return this.rate;
    }

    public final Long getTotalTime() {
        return this.totalTime;
    }

    public final Long getBytesUploaded() {
        return this.bytesUploaded;
    }

    public final Integer getNumOfParallelChunks() {
        return this.numOfParallelChunks;
    }

    public final Double getSecondaryMeasurement() {
        return this.secondaryMeasurement;
    }

    public final Double getMagnitude() {
        return this.magnitude;
    }

    public final ApdexScore getScore() {
        return this.score;
    }

    public final Boolean isNewVersionUpload() {
        return this.isNewVersionUpload;
    }

    public final Boolean isUserTriggeredJob() {
        return this.isUserTriggeredJob;
    }

    public final long getId() {
        return this.id;
    }

    public final String getItemState() {
        return this.itemState;
    }

    public final String getSourceTab() {
        return this.sourceTab;
    }

    public final String getUiSource() {
        return this.uiSource;
    }
}
