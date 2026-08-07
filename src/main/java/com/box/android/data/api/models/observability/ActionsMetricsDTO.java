package com.box.android.data.api.models.observability;

import androidx.core.provider.FontsContractCompat;
import androidx.media3.common.C;
import com.amplitude.api.AmplitudeClient;
import com.box.android.data.persistence.logging.MetricsCategory;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.SplitConfiguration;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionsMetricsDTO.kt */
/* JADX INFO: loaded from: classes11.dex */
@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\bv\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bí\u0003\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\f\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0003\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0001\u0010\u001f\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010#\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010%\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010'\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010(\u001a\u0004\u0018\u00010\f\u0012\n\b\u0001\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0001\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010,\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010-\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010.\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010/\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u00100\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b1\u00102J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\u0010\u0010j\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00108J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\t\u0010n\u001a\u00020\fHÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0007HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010w\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010IJ\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00108J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010}\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010~\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0002\u0010RJ\u0010\u0010\u007f\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010UJ\f\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010IJ\f\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00108J\u0011\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00108J\u0011\u0010\u0085\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010UJ\u0011\u0010\u0086\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010UJ\u0011\u0010\u0087\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010UJ\u0011\u0010\u0088\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010UJ\u0011\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u00108J\f\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010IJ\u0011\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u0010IJ\f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jö\u0003\u0010\u0091\u0001\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u00032\b\b\u0003\u0010\u000f\u001a\u00020\u00072\n\b\u0003\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0003\u0010\u0012\u001a\u00020\u00032\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0003\u0010\u001f\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010!\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010%\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010&\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010(\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010)\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010*\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010+\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010,\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010-\u001a\u0004\u0018\u00010\u00162\n\b\u0003\u0010.\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010/\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u0092\u0001J\u0016\u0010\u0093\u0001\u001a\u00020\u00162\n\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001HÖ\u0003J\n\u0010\u0096\u0001\u001a\u00020\u0007HÖ\u0001J\n\u0010\u0097\u0001\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u00104R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00109\u001a\u0004\b7\u00108R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u00104R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u00104R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u00104R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u00104R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u00104R\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u00104R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u00104R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u00104R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u00104R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u00104R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010J\u001a\u0004\bH\u0010IR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u00104R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u00104R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u00104R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00109\u001a\u0004\bN\u00108R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u00104R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u00104R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u001e¢\u0006\n\n\u0002\u0010S\u001a\u0004\bQ\u0010RR\u0015\u0010\u001f\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010V\u001a\u0004\bT\u0010UR\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u00104R\u0015\u0010!\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010J\u001a\u0004\b!\u0010IR\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bX\u00104R\u0015\u0010#\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00109\u001a\u0004\bY\u00108R\u0015\u0010$\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00109\u001a\u0004\bZ\u00108R\u0015\u0010%\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010V\u001a\u0004\b[\u0010UR\u0015\u0010&\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010V\u001a\u0004\b\\\u0010UR\u0015\u0010'\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010V\u001a\u0004\b]\u0010UR\u0015\u0010(\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010V\u001a\u0004\b^\u0010UR\u0015\u0010)\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u00109\u001a\u0004\b_\u00108R\u0013\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b`\u00104R\u0013\u0010+\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\ba\u00104R\u0015\u0010,\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010J\u001a\u0004\b,\u0010IR\u0015\u0010-\u001a\u0004\u0018\u00010\u0016¢\u0006\n\n\u0002\u0010J\u001a\u0004\b-\u0010IR\u001c\u0010.\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u00104\"\u0004\bc\u0010dR\u0013\u0010/\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\be\u00104R\u0013\u00100\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bf\u00104¨\u0006\u0098\u0001"}, d2 = {"Lcom/box/android/data/api/models/observability/ActionsMetricsDTO;", "Lcom/box/android/data/api/models/observability/MetricsDTO;", "fileId", "", "folderId", "eventType", "numItems", "", OAuthActivity.USER_ID, "username", "enterpriseId", "timestamp", "", RemoteConfigConstants.RequestFieldKey.APP_VERSION, RemoteConfigConstants.RequestFieldKey.APP_ID, "count", "deviceModel", "osVersion", "platform", "type", "subtype", TelemetryEventStrings.Value.FAILED, "", "value", "completionStatusString", "failReason", "errorCode", "message", "sizeBucket", "sizekB", "", "duration", "status", "isRecoverable", "jobManagerVersion", "numberAutomaticOfRetries", "numberOfManualRetries", "timeToStart", "rate", "totalTime", "bytesUploaded", "numOfParallelChunks", "testJob", "testCode", "isNewVersionUpload", "isUserTriggeredJob", "itemState", "sourceTab", "uiSource", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileId", "()Ljava/lang/String;", "getFolderId", "getEventType", "getNumItems", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUserId", "getUsername", "getEnterpriseId", "getTimestamp", "()J", "getAppVersion", "getAppId", "getCount", "()I", "getDeviceModel", "getOsVersion", "getPlatform", "getType", "getSubtype", "getFailed", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getValue", "getCompletionStatusString", "getFailReason", "getErrorCode", "getMessage", "getSizeBucket", "getSizekB", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatus", "getJobManagerVersion", "getNumberAutomaticOfRetries", "getNumberOfManualRetries", "getTimeToStart", "getRate", "getTotalTime", "getBytesUploaded", "getNumOfParallelChunks", "getTestJob", "getTestCode", "getItemState", "setItemState", "(Ljava/lang/String;)V", "getSourceTab", "getUiSource", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/box/android/data/api/models/observability/ActionsMetricsDTO;", "equals", "other", "", "hashCode", "toString", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final /* data */ class ActionsMetricsDTO extends MetricsDTO {
    private final String appId;
    private final String appVersion;
    private final Long bytesUploaded;
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
    private final String folderId;
    private final Boolean isNewVersionUpload;
    private final Boolean isRecoverable;
    private final Boolean isUserTriggeredJob;
    private String itemState;
    private final String jobManagerVersion;
    private final String message;
    private final Integer numItems;
    private final Integer numOfParallelChunks;
    private final Integer numberAutomaticOfRetries;
    private final Integer numberOfManualRetries;
    private final String osVersion;
    private final String platform;
    private final Long rate;
    private final String sizeBucket;
    private final Double sizekB;
    private final String sourceTab;
    private final String status;
    private final String subtype;
    private final String testCode;
    private final String testJob;
    private final Long timeToStart;
    private final long timestamp;
    private final Long totalTime;
    private final String type;
    private final String uiSource;
    private final String userId;
    private final String username;
    private final String value;

    public static /* synthetic */ ActionsMetricsDTO copy$default(ActionsMetricsDTO actionsMetricsDTO, String str, String str2, String str3, Integer num, String str4, String str5, String str6, long j, String str7, String str8, int i, String str9, String str10, String str11, String str12, String str13, Boolean bool, String str14, String str15, String str16, Integer num2, String str17, String str18, Double d, Long l, String str19, Boolean bool2, String str20, Integer num3, Integer num4, Long l2, Long l3, Long l4, Long l5, Integer num5, String str21, String str22, Boolean bool3, Boolean bool4, String str23, String str24, String str25, int i2, int i3, Object obj) {
        String str26 = (i2 & 1) != 0 ? actionsMetricsDTO.fileId : str;
        return actionsMetricsDTO.copy(str26, (i2 & 2) != 0 ? actionsMetricsDTO.folderId : str2, (i2 & 4) != 0 ? actionsMetricsDTO.eventType : str3, (i2 & 8) != 0 ? actionsMetricsDTO.numItems : num, (i2 & 16) != 0 ? actionsMetricsDTO.userId : str4, (i2 & 32) != 0 ? actionsMetricsDTO.username : str5, (i2 & 64) != 0 ? actionsMetricsDTO.enterpriseId : str6, (i2 & 128) != 0 ? actionsMetricsDTO.timestamp : j, (i2 & 256) != 0 ? actionsMetricsDTO.appVersion : str7, (i2 & 512) != 0 ? actionsMetricsDTO.appId : str8, (i2 & 1024) != 0 ? actionsMetricsDTO.count : i, (i2 & 2048) != 0 ? actionsMetricsDTO.deviceModel : str9, (i2 & 4096) != 0 ? actionsMetricsDTO.osVersion : str10, (i2 & 8192) != 0 ? actionsMetricsDTO.platform : str11, (i2 & 16384) != 0 ? actionsMetricsDTO.type : str12, (i2 & 32768) != 0 ? actionsMetricsDTO.subtype : str13, (i2 & 65536) != 0 ? actionsMetricsDTO.failed : bool, (i2 & 131072) != 0 ? actionsMetricsDTO.value : str14, (i2 & 262144) != 0 ? actionsMetricsDTO.completionStatusString : str15, (i2 & 524288) != 0 ? actionsMetricsDTO.failReason : str16, (i2 & 1048576) != 0 ? actionsMetricsDTO.errorCode : num2, (i2 & 2097152) != 0 ? actionsMetricsDTO.message : str17, (i2 & 4194304) != 0 ? actionsMetricsDTO.sizeBucket : str18, (i2 & 8388608) != 0 ? actionsMetricsDTO.sizekB : d, (i2 & 16777216) != 0 ? actionsMetricsDTO.duration : l, (i2 & 33554432) != 0 ? actionsMetricsDTO.status : str19, (i2 & 67108864) != 0 ? actionsMetricsDTO.isRecoverable : bool2, (i2 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? actionsMetricsDTO.jobManagerVersion : str20, (i2 & 268435456) != 0 ? actionsMetricsDTO.numberAutomaticOfRetries : num3, (i2 & C.BUFFER_FLAG_LAST_SAMPLE) != 0 ? actionsMetricsDTO.numberOfManualRetries : num4, (i2 & 1073741824) != 0 ? actionsMetricsDTO.timeToStart : l2, (i2 & Integer.MIN_VALUE) != 0 ? actionsMetricsDTO.rate : l3, (i3 & 1) != 0 ? actionsMetricsDTO.totalTime : l4, (i3 & 2) != 0 ? actionsMetricsDTO.bytesUploaded : l5, (i3 & 4) != 0 ? actionsMetricsDTO.numOfParallelChunks : num5, (i3 & 8) != 0 ? actionsMetricsDTO.testJob : str21, (i3 & 16) != 0 ? actionsMetricsDTO.testCode : str22, (i3 & 32) != 0 ? actionsMetricsDTO.isNewVersionUpload : bool3, (i3 & 64) != 0 ? actionsMetricsDTO.isUserTriggeredJob : bool4, (i3 & 128) != 0 ? actionsMetricsDTO.itemState : str23, (i3 & 256) != 0 ? actionsMetricsDTO.sourceTab : str24, (i3 & 512) != 0 ? actionsMetricsDTO.uiSource : str25);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getDeviceModel() {
        return this.deviceModel;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final String getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getSubtype() {
        return this.subtype;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Boolean getFailed() {
        return this.failed;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final String getCompletionStatusString() {
        return this.completionStatusString;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFolderId() {
        return this.folderId;
    }

    /* JADX INFO: renamed from: component20, reason: from getter */
    public final String getFailReason() {
        return this.failReason;
    }

    /* JADX INFO: renamed from: component21, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component22, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component23, reason: from getter */
    public final String getSizeBucket() {
        return this.sizeBucket;
    }

    /* JADX INFO: renamed from: component24, reason: from getter */
    public final Double getSizekB() {
        return this.sizekB;
    }

    /* JADX INFO: renamed from: component25, reason: from getter */
    public final Long getDuration() {
        return this.duration;
    }

    /* JADX INFO: renamed from: component26, reason: from getter */
    public final String getStatus() {
        return this.status;
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
    public final Integer getNumberAutomaticOfRetries() {
        return this.numberAutomaticOfRetries;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEventType() {
        return this.eventType;
    }

    /* JADX INFO: renamed from: component30, reason: from getter */
    public final Integer getNumberOfManualRetries() {
        return this.numberOfManualRetries;
    }

    /* JADX INFO: renamed from: component31, reason: from getter */
    public final Long getTimeToStart() {
        return this.timeToStart;
    }

    /* JADX INFO: renamed from: component32, reason: from getter */
    public final Long getRate() {
        return this.rate;
    }

    /* JADX INFO: renamed from: component33, reason: from getter */
    public final Long getTotalTime() {
        return this.totalTime;
    }

    /* JADX INFO: renamed from: component34, reason: from getter */
    public final Long getBytesUploaded() {
        return this.bytesUploaded;
    }

    /* JADX INFO: renamed from: component35, reason: from getter */
    public final Integer getNumOfParallelChunks() {
        return this.numOfParallelChunks;
    }

    /* JADX INFO: renamed from: component36, reason: from getter */
    public final String getTestJob() {
        return this.testJob;
    }

    /* JADX INFO: renamed from: component37, reason: from getter */
    public final String getTestCode() {
        return this.testCode;
    }

    /* JADX INFO: renamed from: component38, reason: from getter */
    public final Boolean getIsNewVersionUpload() {
        return this.isNewVersionUpload;
    }

    /* JADX INFO: renamed from: component39, reason: from getter */
    public final Boolean getIsUserTriggeredJob() {
        return this.isUserTriggeredJob;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getNumItems() {
        return this.numItems;
    }

    /* JADX INFO: renamed from: component40, reason: from getter */
    public final String getItemState() {
        return this.itemState;
    }

    /* JADX INFO: renamed from: component41, reason: from getter */
    public final String getSourceTab() {
        return this.sourceTab;
    }

    /* JADX INFO: renamed from: component42, reason: from getter */
    public final String getUiSource() {
        return this.uiSource;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getEnterpriseId() {
        return this.enterpriseId;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    public final ActionsMetricsDTO copy(@Json(name = FontsContractCompat.Columns.FILE_ID) String fileId, @Json(name = "folder_id") String folderId, @Json(name = "event_type") String eventType, @Json(name = "num_items") Integer numItems, @Json(name = AmplitudeClient.USER_ID_KEY) String userId, @Json(name = "az_name") String username, @Json(name = "enterprise_id") String enterpriseId, @Json(name = "timestamp") long timestamp, @Json(name = SplitConfiguration.SPLIT_ATTRIBUTE_APP_VERSION_KEY) String appVersion, @Json(name = "api_key") String appId, @Json(name = "count") int count, @Json(name = "human_readable_device_model") String deviceModel, @Json(name = "os") String osVersion, @Json(name = "platform") String platform, @Json(name = "type") String type, @Json(name = "subtype") String subtype, @Json(name = TelemetryEventStrings.Value.FAILED) Boolean failed, @Json(name = "value") String value, @Json(name = "completion_status") String completionStatusString, @Json(name = "fail_reason") String failReason, @Json(name = AuthenticationConstants.OAuth2.ERROR_CODE) Integer errorCode, @Json(name = "message") String message, @Json(name = "size") String sizeBucket, @Json(name = "size_raw") Double sizekB, @Json(name = "duration") Long duration, @Json(name = "status") String status, @Json(name = "is_recoverable") Boolean isRecoverable, @Json(name = "job_manager_version") String jobManagerVersion, @Json(name = "num_of_automatic_retries") Integer numberAutomaticOfRetries, @Json(name = "num_of_manual_retries") Integer numberOfManualRetries, @Json(name = "time_to_start") Long timeToStart, @Json(name = "execution") Long rate, @Json(name = "total_time") Long totalTime, @Json(name = "bytes_uploaded") Long bytesUploaded, @Json(name = "line") Integer numOfParallelChunks, @Json(name = "job") String testJob, @Json(name = "code") String testCode, @Json(name = "item_in_account") Boolean isNewVersionUpload, @Json(name = "submission") Boolean isUserTriggeredJob, @Json(name = "item_state") String itemState, @Json(name = "source_tab") String sourceTab, @Json(name = "ui_source") String uiSource) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(enterpriseId, "enterpriseId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(platform, "platform");
        return new ActionsMetricsDTO(fileId, folderId, eventType, numItems, userId, username, enterpriseId, timestamp, appVersion, appId, count, deviceModel, osVersion, platform, type, subtype, failed, value, completionStatusString, failReason, errorCode, message, sizeBucket, sizekB, duration, status, isRecoverable, jobManagerVersion, numberAutomaticOfRetries, numberOfManualRetries, timeToStart, rate, totalTime, bytesUploaded, numOfParallelChunks, testJob, testCode, isNewVersionUpload, isUserTriggeredJob, itemState, sourceTab, uiSource);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ActionsMetricsDTO)) {
            return false;
        }
        ActionsMetricsDTO actionsMetricsDTO = (ActionsMetricsDTO) other;
        return Intrinsics.areEqual(this.fileId, actionsMetricsDTO.fileId) && Intrinsics.areEqual(this.folderId, actionsMetricsDTO.folderId) && Intrinsics.areEqual(this.eventType, actionsMetricsDTO.eventType) && Intrinsics.areEqual(this.numItems, actionsMetricsDTO.numItems) && Intrinsics.areEqual(this.userId, actionsMetricsDTO.userId) && Intrinsics.areEqual(this.username, actionsMetricsDTO.username) && Intrinsics.areEqual(this.enterpriseId, actionsMetricsDTO.enterpriseId) && this.timestamp == actionsMetricsDTO.timestamp && Intrinsics.areEqual(this.appVersion, actionsMetricsDTO.appVersion) && Intrinsics.areEqual(this.appId, actionsMetricsDTO.appId) && this.count == actionsMetricsDTO.count && Intrinsics.areEqual(this.deviceModel, actionsMetricsDTO.deviceModel) && Intrinsics.areEqual(this.osVersion, actionsMetricsDTO.osVersion) && Intrinsics.areEqual(this.platform, actionsMetricsDTO.platform) && Intrinsics.areEqual(this.type, actionsMetricsDTO.type) && Intrinsics.areEqual(this.subtype, actionsMetricsDTO.subtype) && Intrinsics.areEqual(this.failed, actionsMetricsDTO.failed) && Intrinsics.areEqual(this.value, actionsMetricsDTO.value) && Intrinsics.areEqual(this.completionStatusString, actionsMetricsDTO.completionStatusString) && Intrinsics.areEqual(this.failReason, actionsMetricsDTO.failReason) && Intrinsics.areEqual(this.errorCode, actionsMetricsDTO.errorCode) && Intrinsics.areEqual(this.message, actionsMetricsDTO.message) && Intrinsics.areEqual(this.sizeBucket, actionsMetricsDTO.sizeBucket) && Intrinsics.areEqual((Object) this.sizekB, (Object) actionsMetricsDTO.sizekB) && Intrinsics.areEqual(this.duration, actionsMetricsDTO.duration) && Intrinsics.areEqual(this.status, actionsMetricsDTO.status) && Intrinsics.areEqual(this.isRecoverable, actionsMetricsDTO.isRecoverable) && Intrinsics.areEqual(this.jobManagerVersion, actionsMetricsDTO.jobManagerVersion) && Intrinsics.areEqual(this.numberAutomaticOfRetries, actionsMetricsDTO.numberAutomaticOfRetries) && Intrinsics.areEqual(this.numberOfManualRetries, actionsMetricsDTO.numberOfManualRetries) && Intrinsics.areEqual(this.timeToStart, actionsMetricsDTO.timeToStart) && Intrinsics.areEqual(this.rate, actionsMetricsDTO.rate) && Intrinsics.areEqual(this.totalTime, actionsMetricsDTO.totalTime) && Intrinsics.areEqual(this.bytesUploaded, actionsMetricsDTO.bytesUploaded) && Intrinsics.areEqual(this.numOfParallelChunks, actionsMetricsDTO.numOfParallelChunks) && Intrinsics.areEqual(this.testJob, actionsMetricsDTO.testJob) && Intrinsics.areEqual(this.testCode, actionsMetricsDTO.testCode) && Intrinsics.areEqual(this.isNewVersionUpload, actionsMetricsDTO.isNewVersionUpload) && Intrinsics.areEqual(this.isUserTriggeredJob, actionsMetricsDTO.isUserTriggeredJob) && Intrinsics.areEqual(this.itemState, actionsMetricsDTO.itemState) && Intrinsics.areEqual(this.sourceTab, actionsMetricsDTO.sourceTab) && Intrinsics.areEqual(this.uiSource, actionsMetricsDTO.uiSource);
    }

    public int hashCode() {
        String str = this.fileId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.folderId;
        int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.eventType.hashCode()) * 31;
        Integer num = this.numItems;
        int iHashCode3 = (((((((((((((((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.userId.hashCode()) * 31) + this.username.hashCode()) * 31) + this.enterpriseId.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + this.appVersion.hashCode()) * 31) + this.appId.hashCode()) * 31) + Integer.hashCode(this.count)) * 31;
        String str3 = this.deviceModel;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.osVersion;
        int iHashCode5 = (((iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.platform.hashCode()) * 31;
        String str5 = this.type;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.subtype;
        int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Boolean bool = this.failed;
        int iHashCode8 = (iHashCode7 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str7 = this.value;
        int iHashCode9 = (iHashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.completionStatusString;
        int iHashCode10 = (iHashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.failReason;
        int iHashCode11 = (iHashCode10 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num2 = this.errorCode;
        int iHashCode12 = (iHashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str10 = this.message;
        int iHashCode13 = (iHashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.sizeBucket;
        int iHashCode14 = (iHashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Double d = this.sizekB;
        int iHashCode15 = (iHashCode14 + (d == null ? 0 : d.hashCode())) * 31;
        Long l = this.duration;
        int iHashCode16 = (iHashCode15 + (l == null ? 0 : l.hashCode())) * 31;
        String str12 = this.status;
        int iHashCode17 = (iHashCode16 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Boolean bool2 = this.isRecoverable;
        int iHashCode18 = (iHashCode17 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str13 = this.jobManagerVersion;
        int iHashCode19 = (iHashCode18 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Integer num3 = this.numberAutomaticOfRetries;
        int iHashCode20 = (iHashCode19 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.numberOfManualRetries;
        int iHashCode21 = (iHashCode20 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Long l2 = this.timeToStart;
        int iHashCode22 = (iHashCode21 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.rate;
        int iHashCode23 = (iHashCode22 + (l3 == null ? 0 : l3.hashCode())) * 31;
        Long l4 = this.totalTime;
        int iHashCode24 = (iHashCode23 + (l4 == null ? 0 : l4.hashCode())) * 31;
        Long l5 = this.bytesUploaded;
        int iHashCode25 = (iHashCode24 + (l5 == null ? 0 : l5.hashCode())) * 31;
        Integer num5 = this.numOfParallelChunks;
        int iHashCode26 = (iHashCode25 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str14 = this.testJob;
        int iHashCode27 = (iHashCode26 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.testCode;
        int iHashCode28 = (iHashCode27 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Boolean bool3 = this.isNewVersionUpload;
        int iHashCode29 = (iHashCode28 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.isUserTriggeredJob;
        int iHashCode30 = (iHashCode29 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        String str16 = this.itemState;
        int iHashCode31 = (iHashCode30 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.sourceTab;
        int iHashCode32 = (iHashCode31 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.uiSource;
        return iHashCode32 + (str18 != null ? str18.hashCode() : 0);
    }

    public String toString() {
        return "ActionsMetricsDTO(fileId=" + this.fileId + ", folderId=" + this.folderId + ", eventType=" + this.eventType + ", numItems=" + this.numItems + ", userId=" + this.userId + ", username=" + this.username + ", enterpriseId=" + this.enterpriseId + ", timestamp=" + this.timestamp + ", appVersion=" + this.appVersion + ", appId=" + this.appId + ", count=" + this.count + ", deviceModel=" + this.deviceModel + ", osVersion=" + this.osVersion + ", platform=" + this.platform + ", type=" + this.type + ", subtype=" + this.subtype + ", failed=" + this.failed + ", value=" + this.value + ", completionStatusString=" + this.completionStatusString + ", failReason=" + this.failReason + ", errorCode=" + this.errorCode + ", message=" + this.message + ", sizeBucket=" + this.sizeBucket + ", sizekB=" + this.sizekB + ", duration=" + this.duration + ", status=" + this.status + ", isRecoverable=" + this.isRecoverable + ", jobManagerVersion=" + this.jobManagerVersion + ", numberAutomaticOfRetries=" + this.numberAutomaticOfRetries + ", numberOfManualRetries=" + this.numberOfManualRetries + ", timeToStart=" + this.timeToStart + ", rate=" + this.rate + ", totalTime=" + this.totalTime + ", bytesUploaded=" + this.bytesUploaded + ", numOfParallelChunks=" + this.numOfParallelChunks + ", testJob=" + this.testJob + ", testCode=" + this.testCode + ", isNewVersionUpload=" + this.isNewVersionUpload + ", isUserTriggeredJob=" + this.isUserTriggeredJob + ", itemState=" + this.itemState + ", sourceTab=" + this.sourceTab + ", uiSource=" + this.uiSource + ")";
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final String getFolderId() {
        return this.folderId;
    }

    @Override // com.box.android.data.api.models.observability.MetricsDTO
    public String getEventType() {
        return this.eventType;
    }

    public final Integer getNumItems() {
        return this.numItems;
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

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final int getCount() {
        return this.count;
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

    public final String getType() {
        return this.type;
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

    public final String getCompletionStatusString() {
        return this.completionStatusString;
    }

    public final String getFailReason() {
        return this.failReason;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getSizeBucket() {
        return this.sizeBucket;
    }

    public final Double getSizekB() {
        return this.sizekB;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getStatus() {
        return this.status;
    }

    public final Boolean isRecoverable() {
        return this.isRecoverable;
    }

    public final String getJobManagerVersion() {
        return this.jobManagerVersion;
    }

    public final Integer getNumberAutomaticOfRetries() {
        return this.numberAutomaticOfRetries;
    }

    public final Integer getNumberOfManualRetries() {
        return this.numberOfManualRetries;
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

    public final String getTestJob() {
        return this.testJob;
    }

    public final String getTestCode() {
        return this.testCode;
    }

    public final Boolean isNewVersionUpload() {
        return this.isNewVersionUpload;
    }

    public final Boolean isUserTriggeredJob() {
        return this.isUserTriggeredJob;
    }

    public final String getItemState() {
        return this.itemState;
    }

    public final void setItemState(String str) {
        this.itemState = str;
    }

    public final String getSourceTab() {
        return this.sourceTab;
    }

    public final String getUiSource() {
        return this.uiSource;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionsMetricsDTO(@Json(name = FontsContractCompat.Columns.FILE_ID) String str, @Json(name = "folder_id") String str2, @Json(name = "event_type") String eventType, @Json(name = "num_items") Integer num, @Json(name = AmplitudeClient.USER_ID_KEY) String userId, @Json(name = "az_name") String username, @Json(name = "enterprise_id") String enterpriseId, @Json(name = "timestamp") long j, @Json(name = SplitConfiguration.SPLIT_ATTRIBUTE_APP_VERSION_KEY) String appVersion, @Json(name = "api_key") String appId, @Json(name = "count") int i, @Json(name = "human_readable_device_model") String str3, @Json(name = "os") String str4, @Json(name = "platform") String platform, @Json(name = "type") String str5, @Json(name = "subtype") String str6, @Json(name = TelemetryEventStrings.Value.FAILED) Boolean bool, @Json(name = "value") String str7, @Json(name = "completion_status") String str8, @Json(name = "fail_reason") String str9, @Json(name = AuthenticationConstants.OAuth2.ERROR_CODE) Integer num2, @Json(name = "message") String str10, @Json(name = "size") String str11, @Json(name = "size_raw") Double d, @Json(name = "duration") Long l, @Json(name = "status") String str12, @Json(name = "is_recoverable") Boolean bool2, @Json(name = "job_manager_version") String str13, @Json(name = "num_of_automatic_retries") Integer num3, @Json(name = "num_of_manual_retries") Integer num4, @Json(name = "time_to_start") Long l2, @Json(name = "execution") Long l3, @Json(name = "total_time") Long l4, @Json(name = "bytes_uploaded") Long l5, @Json(name = "line") Integer num5, @Json(name = "job") String str14, @Json(name = "code") String str15, @Json(name = "item_in_account") Boolean bool3, @Json(name = "submission") Boolean bool4, @Json(name = "item_state") String str16, @Json(name = "source_tab") String str17, @Json(name = "ui_source") String str18) {
        super(MetricsCategory.ACTIONS, eventType);
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(enterpriseId, "enterpriseId");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(platform, "platform");
        this.fileId = str;
        this.folderId = str2;
        this.eventType = eventType;
        this.numItems = num;
        this.userId = userId;
        this.username = username;
        this.enterpriseId = enterpriseId;
        this.timestamp = j;
        this.appVersion = appVersion;
        this.appId = appId;
        this.count = i;
        this.deviceModel = str3;
        this.osVersion = str4;
        this.platform = platform;
        this.type = str5;
        this.subtype = str6;
        this.failed = bool;
        this.value = str7;
        this.completionStatusString = str8;
        this.failReason = str9;
        this.errorCode = num2;
        this.message = str10;
        this.sizeBucket = str11;
        this.sizekB = d;
        this.duration = l;
        this.status = str12;
        this.isRecoverable = bool2;
        this.jobManagerVersion = str13;
        this.numberAutomaticOfRetries = num3;
        this.numberOfManualRetries = num4;
        this.timeToStart = l2;
        this.rate = l3;
        this.totalTime = l4;
        this.bytesUploaded = l5;
        this.numOfParallelChunks = num5;
        this.testJob = str14;
        this.testCode = str15;
        this.isNewVersionUpload = bool3;
        this.isUserTriggeredJob = bool4;
        this.itemState = str16;
        this.sourceTab = str17;
        this.uiSource = str18;
    }
}
