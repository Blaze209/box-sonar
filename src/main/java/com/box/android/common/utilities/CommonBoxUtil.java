package com.box.android.common.utilities;

import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.biometric.BiometricManager;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.box.android.common.R;
import com.box.androidsdk.content.auth.OAuthActivity;
import com.box.androidsdk.content.models.BoxFile;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.broker.SerializedNames;
import com.microsoft.identity.common.java.jwt.AbstractJwtRequest;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import com.microsoft.intune.mam.client.media.MAMMediaMetadataRetriever;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;

/* JADX INFO: compiled from: CommonBoxUtil.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\bD\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u000eH\u0007J\u0010\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0007J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u000eH\u0007J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0006H\u0007J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0006H\u0007J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0006H\u0007J\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020\u000eH\u0007J\f\u0010!\u001a\u00020\u001e*\u00020\u001fH\u0007J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010#\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010$\u001a\u00020%H\u0007J\b\u0010&\u001a\u00020%H\u0007J\b\u0010'\u001a\u00020%H\u0007J\u001a\u0010(\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u00062\u0006\u0010*\u001a\u00020\u0006H\u0007J\u0016\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-J \u0010/\u001a\u00020%2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u000eH\u0007J\u0012\u00105\u001a\u00020%2\b\u00106\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u00107\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000eH\u0007J\u0018\u0010:\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000eH\u0007J\u0018\u0010;\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000eH\u0007J1\u0010;\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000e2\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u000eH\u0007J\u001a\u0010@\u001a\u00020\u001e2\u0006\u0010A\u001a\u00020B2\b\u0010C\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010D\u001a\u00020\u00062\u0006\u0010E\u001a\u00020\u000eH\u0007J\u0010\u0010F\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u000eH\u0007J)\u0010F\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\u000e2\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007¢\u0006\u0002\u0010HJ\u0010\u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u00020KH\u0007J\u0012\u0010L\u001a\u00020%2\b\u00106\u001a\u0004\u0018\u00010\u0006H\u0007J \u0010M\u001a\u00020N2\u0016\u0010O\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060PH\u0007J\u0010\u0010Q\u001a\u00020-2\u0006\u0010R\u001a\u00020\u0006H\u0007J$\u0010S\u001a\u0004\u0018\u00010B2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010A\u001a\u00020B2\b\u0010T\u001a\u0004\u0018\u00010\u0006H\u0007J5\u0010U\u001a\u00020%2\b\u0010V\u001a\u0004\u0018\u00010N2\b\u0010W\u001a\u0004\u0018\u00010N2\u0012\u0010X\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007¢\u0006\u0002\u0010YJ)\u0010Z\u001a\u00020N2\u0006\u0010[\u001a\u00020N2\u0012\u0010X\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u0007¢\u0006\u0002\u0010\\J\b\u0010]\u001a\u00020\u001eH\u0007J\u0010\u0010i\u001a\u00020K2\u0006\u0010j\u001a\u00020\u0006H\u0007J\u0018\u0010i\u001a\u00020K2\u0006\u0010j\u001a\u00020\u00062\u0006\u0010k\u001a\u00020KH\u0007J\u0010\u0010o\u001a\u00020\u001e2\u0006\u0010p\u001a\u00020-H\u0007J\u001c\u0010q\u001a\u00020\u001e2\b\u0010r\u001a\u0004\u0018\u00010-2\b\u0010s\u001a\u0004\u0018\u00010\u0006H\u0007J\u0018\u0010t\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010A\u001a\u00020BH\u0007J\u0012\u0010u\u001a\u00020%2\b\u0010v\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010w\u001a\u00020\u00062\b\u0010v\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010x\u001a\u00020%2\u0006\u0010y\u001a\u00020-H\u0007J\u0010\u0010z\u001a\u00020K2\u0006\u0010r\u001a\u00020-H\u0007J5\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000e2\u0016\u0010{\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010|J>\u0010}\u001a\u00020\u00062\u0006\u0010~\u001a\u00020\u000e2\u0006\u0010\u007f\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000e2\u0016\u0010{\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u0080\u0001JH\u0010\u0081\u0001\u001a\u00020\u00062\u0006\u0010~\u001a\u00020\u000e2\u0007\u0010\u0082\u0001\u001a\u00020\u000e2\u0006\u0010\u007f\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\u000e2\u0016\u0010{\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0005\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0003\u0010\u0083\u0001J \u0010\u0084\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0007\u0010\u0085\u0001\u001a\u00020\u0006H\u0007¢\u0006\u0003\u0010\u0086\u0001J\u0016\u0010\u0087\u0001\u001a\u0004\u0018\u00010-2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010-H\u0007J\u0012\u0010\u0089\u0001\u001a\u00020%2\u0007\u0010\u008a\u0001\u001a\u00020\u0006H\u0003J\u0014\u0010\u008b\u0001\u001a\u00020\u00062\t\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u0006H\u0007J\t\u0010\u008d\u0001\u001a\u00020-H\u0007J\u001a\u0010\u008e\u0001\u001a\u00020\u000e2\u0007\u0010\u008f\u0001\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u001a\u0010\u0090\u0001\u001a\u00020\u00132\u0007\u0010\u0091\u0001\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0011\u0010\u0092\u0001\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u001c\u0010\u0093\u0001\u001a\u00020\u001e2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u001fH\u0007J\u001c\u0010\u0097\u0001\u001a\u00020\u001e2\b\u0010\u0094\u0001\u001a\u00030\u0095\u00012\u0007\u0010\u0096\u0001\u001a\u00020\u001fH\u0007J1\u0010\u009b\u0001\u001a\u00020\u001e2\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010-2\t\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010\u009e\u0001\u001a\u00020%2\u0007\u0010\u009f\u0001\u001a\u00020%H\u0007J\u001f\u0010 \u0001\u001a\u00020%2\u0006\u0010?\u001a\u00020\u000e2\f\u0010¡\u0001\u001a\u00030¢\u0001\"\u00020\u000eH\u0007J)\u0010£\u0001\u001a\u0005\u0018\u00010¤\u00012\t\u0010\u009c\u0001\u001a\u0004\u0018\u00010-2\u0007\u0010¥\u0001\u001a\u00020\u000e2\u0007\u0010¦\u0001\u001a\u00020\u000eH\u0007J%\u0010§\u0001\u001a\u00020\u000e2\b\u0010¨\u0001\u001a\u00030©\u00012\u0007\u0010¥\u0001\u001a\u00020\u000e2\u0007\u0010¦\u0001\u001a\u00020\u000eH\u0003J\u001d\u0010ª\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010)\u001a\u00020\u0006H\u0007¢\u0006\u0003\u0010\u0086\u0001J\u0012\u0010«\u0001\u001a\u00020%2\u0007\u0010¬\u0001\u001a\u00020\u0006H\u0007J\u001b\u0010\u00ad\u0001\u001a\u00020%2\u0007\u0010¬\u0001\u001a\u00020\u00062\u0007\u0010®\u0001\u001a\u00020KH\u0007J\t\u0010¯\u0001\u001a\u00020\u000eH\u0007J$\u0010°\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00060±\u0001j\t\u0012\u0004\u0012\u00020\u0006`²\u00012\u0007\u0010³\u0001\u001a\u00020\u0006H\u0007J\u0012\u0010´\u0001\u001a\u00020\u00062\u0007\u0010µ\u0001\u001a\u00020\u0006H\u0007J \u0010¶\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060P2\t\u0010·\u0001\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010¸\u0001\u001a\u00020%2\u0007\u0010¹\u0001\u001a\u00020\u0010H\u0007J\u0011\u0010º\u0001\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0017\u0010»\u0001\u001a\u0004\u0018\u00010\u00062\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u0001H\u0007J\u0013\u0010¾\u0001\u001a\u00020%2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\u001c\u0010¿\u0001\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0007\u0010À\u0001\u001a\u00020BH\u0007J \u0010Á\u0001\u001a\u0005\u0018\u00010¤\u00012\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u00062\t\b\u0002\u0010Ã\u0001\u001a\u00020\u000eJ8\u0010Å\u0001\u001a\u00020\u00062\u000b\b\u0002\u0010Æ\u0001\u001a\u0004\u0018\u00010\u00062\u000b\b\u0002\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00062\u0007\u0010È\u0001\u001a\u00020\u00062\n\b\u0002\u0010É\u0001\u001a\u00030Ê\u0001H\u0007J1\u0010Ë\u0001\u001a\u00030¤\u00012\u0007\u0010Ì\u0001\u001a\u00020\u00172\u000b\b\u0002\u0010Í\u0001\u001a\u0004\u0018\u00010\u000e2\u000b\b\u0002\u0010Î\u0001\u001a\u0004\u0018\u00010\u000e¢\u0006\u0003\u0010Ï\u0001J\u0012\u0010Ð\u0001\u001a\u00020%2\u0007\u0010Ñ\u0001\u001a\u00020\u000eH\u0007R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010^\u001a\u0004\u0018\u00010-8FX\u0087\u0004¢\u0006\f\u0012\u0004\b_\u0010\u0003\u001a\u0004\b`\u0010aR\u001a\u0010b\u001a\u00020%8FX\u0087\u0004¢\u0006\f\u0012\u0004\bc\u0010\u0003\u001a\u0004\bb\u0010dR\u001a\u0010e\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\bf\u0010\u0003\u001a\u0004\bg\u0010hR\u001a\u0010l\u001a\u00020-8FX\u0087\u0004¢\u0006\f\u0012\u0004\bm\u0010\u0003\u001a\u0004\bn\u0010aR\u001d\u0010\u0098\u0001\u001a\u00020\u00068FX\u0087\u0004¢\u0006\u000e\u0012\u0005\b\u0099\u0001\u0010\u0003\u001a\u0005\b\u009a\u0001\u0010hR\u000f\u0010Ä\u0001\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006Ò\u0001"}, d2 = {"Lcom/box/android/common/utilities/CommonBoxUtil;", "", "<init>", "()V", "RESERVED_CHARS", "", "", "[Ljava/lang/String;", "isRunningTest", "Ljava/util/concurrent/atomic/AtomicBoolean;", "allowListedDomain", "", "Lkotlin/text/Regex;", "getColorFromAttribute", "", "context", "Landroid/content/Context;", "attrId", "getDimen", "", "dimensId", "getDimenPixel", "getDrawable", "Landroid/graphics/drawable/Drawable;", "drawableId", "getDrawableResIdByName", "resName", "getStringResIdByName", "getIdResIdByName", "addPaddingTop", "", "Landroid/view/View;", "addedPaddingTop", "addStatusBarPaddingTop", "getStatusBarHeight", "getNavigationBarHeight", "isRunningAutomatedTest", "", "isRunningAndroidJUnit4Test", "isRunningAndroidJUnitTest", "getFileExtension", BoxCommonConstants.EXTRA_FILE_NAME, "defaultValue", "compressAndSave", "src", "Ljava/io/File;", "dst", "scaleAndSaveImage", "inputStream", "Ljava/io/InputStream;", "outputStream", "Ljava/io/OutputStream;", "maxSize", "isAllowListedDomain", "url", "plural", "resourceID", FirebaseAnalytics.Param.QUANTITY, "pluralFormat", "pluralNative", "formatArgs", "(II[Ljava/lang/String;)Ljava/lang/String;", "pluralIndex", "value", "dumpIntent", "intent", "Landroid/content/Intent;", "tag", "getUSLocaleString", "resId", "LS", "resourceId", "(I[Ljava/lang/String;)Ljava/lang/String;", "getDuration", "durationMilliseconds", "", "launchURL", "convertMapToBundle", "Landroid/os/Bundle;", "map", "", "getAvatarFile", OAuthActivity.USER_ID, "getExplicitBroadcastIntent", "optionalStartingPackage", "compareBundles", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "b", "desiredFields", "(Landroid/os/Bundle;Landroid/os/Bundle;[Ljava/lang/String;)Z", "copyBundle", "target", "(Landroid/os/Bundle;[Ljava/lang/String;)Landroid/os/Bundle;", "cancelAllNotifications", "defaultLocalDirectory", "getDefaultLocalDirectory$annotations", "getDefaultLocalDirectory", "()Ljava/io/File;", "isOnWifi", "isOnWifi$annotations", "()Z", "connectionType", "getConnectionType$annotations", "getConnectionType", "()Ljava/lang/String;", "parseLong", "string", "fallBack", "crashReportFile", "getCrashReportFile$annotations", "getCrashReportFile", "deleteFilesFolders", "fileFolder", "deleteFilesFromDirectoryWithPrefix", KeyManagementAlgorithmIdentifiers.DIRECT, "filePrefix", "isIntentAvailable", "isFilenameValidForSD", "filename", "getUnsupportedCharacters", "deleteFolderRecursive", "f", "getDirSize", SerializedNames.PARAMS, "(II[Ljava/lang/Object;)Ljava/lang/String;", "quantityWithZero", "zeroStringResId", "pluralStringResId", "(III[Ljava/lang/Object;)Ljava/lang/String;", "quantityWithZeroAndSingular", "singularStringResId", "(IIII[Ljava/lang/Object;)Ljava/lang/String;", "getNameExtensionPath", "unparsedName", "(Ljava/lang/String;)[Ljava/lang/String;", "getEscapedFileForSD", "unfilteredFile", "isTempCreatable", "tempFileName", "escapeFileNameForSD", "unfilteredName", "getInternalPreviewDirectory", "convertDpToPixel", "dp", "convertPixelToDp", "pixel", "getScreenDensity", "hideKeyboard", "activity", "Landroidx/fragment/app/FragmentActivity;", "bindingView", "showKeyboard", "deviceName", "getDeviceName$annotations", "getDeviceName", "writeToFile", "file", "stringToWrite", "append", "newLine", "valuePresentInSet", "checkAgainstList", "", "decodeSampledBitmapFromFile", "Landroid/graphics/Bitmap;", "reqWidth", "reqHeight", "calculateInSampleSize", "options", "Landroid/graphics/BitmapFactory$Options;", "getFileNameAndExt", "doesPackageExist", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "doesPackageExistWithMinimumVersionCode", "minVersion", "getCurrentVersionNumber", "createWrapperList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "id", "getContentProviderAuthority", "postfix", "parseCookies", "cookieString", "isBiometricHardwareAvailable", AbstractJwtRequest.ClaimNames.CTX, "isAppNotificationsEnabled", "getUtmMedium", "uri", "Landroid/net/Uri;", "isSendEmailIntentAvailable", "getDirectoryFromDocProviderResult", "data", "getScaledBitmap", "filePath", "size", "DATE_FORMAT", "getTimestampedName", "prefix", "suffix", BoxFile.FIELD_EXTENSION, "dateToTimeStamp", "Ljava/util/Date;", "drawableToBitmap", "drawable", "width", "height", "(Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Ljava/lang/Integer;)Landroid/graphics/Bitmap;", "isAtLeastVersion", "versionCode", "common_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CommonBoxUtil {
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final CommonBoxUtil INSTANCE = new CommonBoxUtil();
    private static final String[] RESERVED_CHARS = {"\\", "/"};
    private static final List<Regex> allowListedDomain;
    private static AtomicBoolean isRunningTest;

    @JvmStatic
    public static /* synthetic */ void getConnectionType$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getCrashReportFile$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDefaultLocalDirectory$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getDeviceName$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void isOnWifi$annotations() {
    }

    @JvmStatic
    public static final int pluralIndex(int value) {
        if (value == 0) {
            return 0;
        }
        return value == 1 ? 1 : 2;
    }

    private CommonBoxUtil() {
    }

    static {
        Set of = SetsKt.setOf(".+([.](box|box-gov)[.](com|net))$");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(of, 10));
        Iterator it = of.iterator();
        while (it.hasNext()) {
            arrayList.add(new Regex((String) it.next()));
        }
        allowListedDomain = arrayList;
    }

    @JvmStatic
    public static final int getColorFromAttribute(Context context, int attrId) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(attrId, typedValue, true);
        int i = typedValue.type;
        if (i == 28 || i == 29) {
            return typedValue.data;
        }
        return context.getColorStateList(typedValue.resourceId).getDefaultColor();
    }

    @JvmStatic
    public static final float getDimen(Context context, int dimensId) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(dimensId, typedValue, true);
        return typedValue.getFloat();
    }

    @JvmStatic
    public static final int getDimenPixel(int dimensId) {
        return ApplicationProvider.getApplication().getResources().getDimensionPixelSize(dimensId);
    }

    @JvmStatic
    public static final Drawable getDrawable(Context context, int drawableId) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ResourcesCompat.getDrawable(context.getResources(), drawableId, context.getTheme());
    }

    @JvmStatic
    public static final int getDrawableResIdByName(String resName) {
        Intrinsics.checkNotNullParameter(resName, "resName");
        return ApplicationProvider.getApplication().getResources().getIdentifier(resName, "drawable", ApplicationProvider.getApplication().getPackageName());
    }

    @JvmStatic
    public static final int getStringResIdByName(String resName) {
        Intrinsics.checkNotNullParameter(resName, "resName");
        return ApplicationProvider.getApplication().getResources().getIdentifier(resName, "string", ApplicationProvider.getApplication().getPackageName());
    }

    @JvmStatic
    public static final int getIdResIdByName(String resName) {
        Intrinsics.checkNotNullParameter(resName, "resName");
        return ApplicationProvider.getApplication().getResources().getIdentifier(resName, "id", ApplicationProvider.getApplication().getPackageName());
    }

    @JvmStatic
    public static final void addPaddingTop(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + i, view.getPaddingRight(), view.getPaddingBottom());
    }

    @JvmStatic
    public static final void addStatusBarPaddingTop(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        addPaddingTop(view, getStatusBarHeight(context));
    }

    @JvmStatic
    public static final int getStatusBarHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final int getNavigationBarHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    @JvmStatic
    public static final synchronized boolean isRunningAutomatedTest() {
        return isRunningAndroidJUnitTest() || isRunningAndroidJUnit4Test();
    }

    @JvmStatic
    public static final synchronized boolean isRunningAndroidJUnit4Test() {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2 = isRunningTest;
        boolean z = true;
        if (atomicBoolean2 == null || !atomicBoolean2.get()) {
            try {
                Class.forName("androidx.test.ext.junit.runners.AndroidJUnit4");
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            isRunningTest = new AtomicBoolean(z);
        }
        atomicBoolean = isRunningTest;
        Intrinsics.checkNotNull(atomicBoolean);
        return atomicBoolean.get();
    }

    @JvmStatic
    public static final synchronized boolean isRunningAndroidJUnitTest() {
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2 = isRunningTest;
        boolean z = true;
        if (atomicBoolean2 == null || !atomicBoolean2.get()) {
            try {
                Class.forName("android.support.test.runner.AndroidJUnitRunner");
            } catch (ClassNotFoundException unused) {
                z = false;
            }
            isRunningTest = new AtomicBoolean(z);
        }
        atomicBoolean = isRunningTest;
        Intrinsics.checkNotNull(atomicBoolean);
        return atomicBoolean.get();
    }

    @JvmStatic
    public static final String getFileExtension(String fileName, String defaultValue) {
        String strSubstringAfterLast;
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return (fileName == null || (strSubstringAfterLast = StringsKt.substringAfterLast(fileName, ".", defaultValue)) == null) ? defaultValue : strSubstringAfterLast;
    }

    public final boolean compressAndSave(File src, File dst) throws IOException {
        String attribute;
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        FileOutputStream fileOutputStream = new FileOutputStream(dst);
        Bitmap scaledBitmap$default = getScaledBitmap$default(this, src.getPath(), 0, 2, null);
        if (scaledBitmap$default == null) {
            return false;
        }
        boolean zCompress = scaledBitmap$default.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
        fileOutputStream.close();
        if (zCompress && (attribute = new ExifInterface(src.getPath()).getAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION)) != null) {
            ExifInterface exifInterface = new ExifInterface(dst.getPath());
            exifInterface.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, attribute);
            exifInterface.saveAttributes();
        }
        return zCompress;
    }

    @JvmStatic
    public static final boolean scaleAndSaveImage(InputStream inputStream, OutputStream outputStream, int maxSize) {
        Pair pair;
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream);
        if (bitmapDecodeStream == null) {
            return false;
        }
        if (maxSize > 0 && (bitmapDecodeStream.getWidth() > maxSize || bitmapDecodeStream.getHeight() > maxSize)) {
            float width = bitmapDecodeStream.getWidth() / bitmapDecodeStream.getHeight();
            if (bitmapDecodeStream.getWidth() > bitmapDecodeStream.getHeight()) {
                pair = TuplesKt.to(Integer.valueOf(maxSize), Integer.valueOf((int) (maxSize / width)));
            } else {
                pair = TuplesKt.to(Integer.valueOf((int) (maxSize * width)), Integer.valueOf(maxSize));
            }
            bitmapDecodeStream = Bitmap.createScaledBitmap(bitmapDecodeStream, ((Number) pair.component1()).intValue(), ((Number) pair.component2()).intValue(), true);
        }
        return bitmapDecodeStream.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
    }

    @JvmStatic
    public static final boolean isAllowListedDomain(String url) {
        if (url != null) {
            URI uri = new URI(url);
            boolean z = Intrinsics.areEqual(uri.getScheme(), "http") || Intrinsics.areEqual(uri.getScheme(), "https");
            if (uri.getHost() != null && z) {
                List<Regex> list = allowListedDomain;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    for (Regex regex : list) {
                        List<Regex> list2 = allowListedDomain;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            for (Regex regex2 : list2) {
                                String host = uri.getHost();
                                Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
                                if (regex2.matches(host)) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @JvmStatic
    public static final String plural(int resourceID, int quantity) {
        String str = ApplicationProvider.getApplication().getResources().getStringArray(resourceID)[pluralIndex(quantity)];
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        return str;
    }

    @JvmStatic
    public static final String pluralFormat(int resourceID, int quantity) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = ApplicationProvider.getApplication().getResources().getStringArray(resourceID)[pluralIndex(quantity)];
        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
        String str2 = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(quantity)}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    @JvmStatic
    public static final String pluralNative(int resourceID, int quantity) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String quantityString = ApplicationProvider.getApplication().getResources().getQuantityString(resourceID, quantity);
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        String str = String.format(quantityString, Arrays.copyOf(new Object[]{Integer.valueOf(quantity)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @JvmStatic
    public static final String pluralNative(int resourceID, int quantity, String... formatArgs) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        String quantityString = ApplicationProvider.getApplication().getResources().getQuantityString(resourceID, quantity, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        return quantityString;
    }

    @JvmStatic
    public static final void dumpIntent(Intent intent, String tag) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            Log.d(tag, "ACTION: " + intent.getAction());
            Log.d(tag, "DATA: " + intent.getDataString());
            Log.d(tag, "TYPE: " + intent.getType());
            Log.d(tag, "PACKAGE: " + intent.getPackage());
            if (intent.getExtras() == null) {
                return;
            }
            Bundle extras = intent.getExtras();
            Intrinsics.checkNotNull(extras);
            for (String str : extras.keySet()) {
                Bundle extras2 = intent.getExtras();
                Intrinsics.checkNotNull(extras2);
                Object obj = extras2.get(str);
                Log.v(tag, "EXTRA: " + str + "  =>  " + obj + (obj == null ? " " : " (" + obj.getClass() + ")"));
            }
        }
    }

    @JvmStatic
    public static final String getUSLocaleString(int resId) {
        String string = ApplicationProvider.getApplication().createConfigurationContext(new Configuration(ApplicationProvider.getApplication().getResources().getConfiguration())).getString(resId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @JvmStatic
    public static final String LS(int resourceId) {
        String string = ApplicationProvider.getApplication().getResources().getString(resourceId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @JvmStatic
    public static final String LS(int resourceId, String... formatArgs) {
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        String string = ApplicationProvider.getApplication().getResources().getString(resourceId, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @JvmStatic
    public static final String getDuration(long durationMilliseconds) {
        if (durationMilliseconds <= 0) {
            return LS(R.string.Never);
        }
        long j = 60;
        long j2 = j * 1000;
        long j3 = j * j2;
        long j4 = ((long) 24) * j3;
        long j5 = ((long) 7) * j4;
        long j6 = durationMilliseconds / (((long) 30) * j4);
        if (j6 >= 1) {
            return pluralFormat(R.array.x_months, MathKt.roundToInt(j6));
        }
        long j7 = durationMilliseconds / j5;
        if (j7 >= 1) {
            return pluralFormat(R.array.x_weeks, MathKt.roundToInt(j7));
        }
        long j8 = durationMilliseconds / j4;
        if (j8 >= 1) {
            return pluralFormat(R.array.x_days, MathKt.roundToInt(j8));
        }
        long j9 = durationMilliseconds / j3;
        if (j9 >= 1) {
            return pluralFormat(R.array.x_hours, MathKt.roundToInt(j9));
        }
        long j10 = durationMilliseconds / j2;
        if (j10 >= 1) {
            return pluralFormat(R.array.x_minutes, MathKt.roundToInt(j10));
        }
        return pluralFormat(R.array.x_seconds, MathKt.roundToInt(durationMilliseconds / 1000));
    }

    @JvmStatic
    public static final boolean launchURL(String url) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
            intent.setFlags(268435456);
            ApplicationProvider.getApplication().startActivity(intent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    public static final Bundle convertMapToBundle(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        Bundle bundle = new Bundle();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            bundle.putString(entry.getKey(), entry.getValue());
        }
        return bundle;
    }

    @JvmStatic
    public static final File getAvatarFile(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        return new File(ApplicationProvider.getApplication().getFilesDir(), userId + "/avatar/avatar_" + userId + ".jpg");
    }

    @JvmStatic
    public static final Intent getExplicitBroadcastIntent(Context context, Intent intent, String optionalStartingPackage) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        List<ResolveInfo> listQueryBroadcastReceivers = MAMPackageManagement.queryBroadcastReceivers(context.getPackageManager(), intent, 0);
        Intrinsics.checkNotNullExpressionValue(listQueryBroadcastReceivers, "queryBroadcastReceivers(...)");
        if (listQueryBroadcastReceivers.size() <= 0) {
            return null;
        }
        if (optionalStartingPackage != null) {
            for (ResolveInfo resolveInfo : listQueryBroadcastReceivers) {
                String packageName = resolveInfo.activityInfo.packageName;
                Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                if (StringsKt.startsWith$default(packageName, optionalStartingPackage, false, 2, (Object) null)) {
                    intent.setPackage(resolveInfo.activityInfo.packageName);
                    break;
                }
            }
            return intent;
        }
        Intrinsics.checkNotNull(intent.setPackage(listQueryBroadcastReceivers.get(0).activityInfo.packageName));
        return intent;
    }

    @JvmStatic
    public static final boolean compareBundles(Bundle a, Bundle b, String... desiredFields) {
        Intrinsics.checkNotNullParameter(desiredFields, "desiredFields");
        if (a == null && b == null) {
            return true;
        }
        if ((a != null && b == null) || (a == null && b != null)) {
            return false;
        }
        for (String str : desiredFields) {
            Intrinsics.checkNotNull(a);
            Object obj = a.get(str);
            Intrinsics.checkNotNull(b);
            Object obj2 = b.get(str);
            if ((obj == null && obj2 != null) || (obj != null && obj2 == null)) {
                return false;
            }
            if (obj != null && !Intrinsics.areEqual(obj, obj2)) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final Bundle copyBundle(Bundle target, String... desiredFields) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(desiredFields, "desiredFields");
        Bundle bundle = new Bundle(target);
        HashSet hashSet = new HashSet();
        for (String str : desiredFields) {
            hashSet.add(str);
        }
        for (String str2 : bundle.keySet()) {
            if (!hashSet.contains(str2)) {
                bundle.remove(str2);
            }
        }
        return bundle;
    }

    @JvmStatic
    public static final void cancelAllNotifications() {
        Object systemService = ApplicationProvider.getApplication().getSystemService("notification");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancelAll();
    }

    public static final File getDefaultLocalDirectory() {
        File[] fileArrListFiles;
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (!externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory = Environment.getExternalStorageDirectory();
        }
        if (!externalStoragePublicDirectory.exists()) {
            externalStoragePublicDirectory = null;
        }
        if (externalStoragePublicDirectory == null || !externalStoragePublicDirectory.exists()) {
            return externalStoragePublicDirectory;
        }
        File parentFile = externalStoragePublicDirectory.getParentFile();
        final String name = externalStoragePublicDirectory.getName();
        return (parentFile == null || (fileArrListFiles = parentFile.listFiles(new FilenameFilter() { // from class: com.box.android.common.utilities.CommonBoxUtil$$ExternalSyntheticLambda1
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return CommonBoxUtil._get_defaultLocalDirectory_$lambda$0(name, file, str);
            }
        })) == null || fileArrListFiles.length <= 0) ? externalStoragePublicDirectory : fileArrListFiles[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_defaultLocalDirectory_$lambda$0(String str, File file, String str2) {
        return StringsKt.equals(str2, str, true);
    }

    public static final boolean isOnWifi() {
        Object systemService = ApplicationProvider.getApplication().getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 9;
    }

    public static final String getConnectionType() {
        if (!Connectivity.isConnected()) {
            return "no_connection";
        }
        if (Connectivity.isConnectedWifi()) {
            return SemanticAttributes.NetHostConnectionTypeValues.WIFI;
        }
        if (Connectivity.isConnectedMobile()) {
            return "mobile";
        }
        if (Connectivity.isConnectedFast()) {
            return "fast";
        }
        return "slow";
    }

    @JvmStatic
    public static final long parseLong(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return parseLong(string, 0L);
    }

    @JvmStatic
    public static final long parseLong(String string, long fallBack) {
        Intrinsics.checkNotNullParameter(string, "string");
        try {
            return Long.parseLong(string);
        } catch (Exception unused) {
            return fallBack;
        }
    }

    public static final File getCrashReportFile() {
        File file = new File(new StringBuffer(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Android/data/").append(ApplicationProvider.getApplication().getPackageName()).append("/cache/").toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, "boxdiagnosticinfo.log");
    }

    @JvmStatic
    public static final void deleteFilesFolders(File fileFolder) {
        Intrinsics.checkNotNullParameter(fileFolder, "fileFolder");
        File[] fileArrListFiles = fileFolder.listFiles();
        if (fileArrListFiles == null) {
            fileFolder.delete();
        } else {
            for (File file : fileArrListFiles) {
                Intrinsics.checkNotNull(file);
                deleteFilesFolders(file);
            }
        }
        fileFolder.delete();
    }

    @JvmStatic
    public static final void deleteFilesFromDirectoryWithPrefix(File dir, final String filePrefix) {
        if (dir == null || TextUtils.isEmpty(filePrefix)) {
            return;
        }
        File[] fileArrListFiles = dir.listFiles(new FilenameFilter() { // from class: com.box.android.common.utilities.CommonBoxUtil$$ExternalSyntheticLambda0
            @Override // java.io.FilenameFilter
            public final boolean accept(File file, String str) {
                return CommonBoxUtil.deleteFilesFromDirectoryWithPrefix$lambda$0(filePrefix, file, str);
            }
        });
        Intrinsics.checkNotNull(fileArrListFiles);
        for (File file : fileArrListFiles) {
            file.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean deleteFilesFromDirectoryWithPrefix$lambda$0(String str, File file, String str2) {
        Intrinsics.checkNotNull(str2);
        Intrinsics.checkNotNull(str);
        return StringsKt.startsWith$default(str2, str, false, 2, (Object) null);
    }

    @JvmStatic
    public static final boolean isIntentAvailable(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        List<ResolveInfo> listQueryIntentActivities = MAMPackageManagement.queryIntentActivities(context.getPackageManager(), intent, 65536);
        Intrinsics.checkNotNullExpressionValue(listQueryIntentActivities, "queryIntentActivities(...)");
        return listQueryIntentActivities.size() > 0;
    }

    @JvmStatic
    public static final boolean isFilenameValidForSD(String filename) {
        if (filename != null) {
            String str = filename;
            if (str.length() != 0) {
                for (String str2 : RESERVED_CHARS) {
                    if (StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final String getUnsupportedCharacters(String filename) {
        StringBuilder sb = new StringBuilder();
        if (filename != null) {
            String str = filename;
            if (str.length() > 0) {
                for (String str2 : RESERVED_CHARS) {
                    if (StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null)) {
                        sb.append(str2);
                    }
                }
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    public static final boolean deleteFolderRecursive(File f) {
        Intrinsics.checkNotNullParameter(f, "f");
        if (f.isDirectory()) {
            File[] fileArrListFiles = f.listFiles();
            if (fileArrListFiles == null) {
                return false;
            }
            for (File file : fileArrListFiles) {
                Intrinsics.checkNotNull(file);
                deleteFolderRecursive(file);
            }
        }
        return f.delete();
    }

    @JvmStatic
    public static final long getDirSize(File dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        long length = 0;
        if (!dir.isDirectory()) {
            return 0L;
        }
        Stack stack = new Stack();
        stack.clear();
        stack.push(dir);
        while (!stack.isEmpty()) {
            File[] fileArrListFiles = ((File) stack.pop()).listFiles();
            if (fileArrListFiles != null) {
                int length2 = fileArrListFiles.length;
                for (int i = 0; i < length2; i++) {
                    if (fileArrListFiles[i].isDirectory()) {
                        stack.push(fileArrListFiles[i]);
                    } else {
                        length += fileArrListFiles[i].length();
                    }
                }
            }
        }
        return length;
    }

    @Deprecated(message = "Use {@link #QuantityWithZeroAndSingular(int, int, int, int, Object...)} if you want to handle 0 or 1 specially.", replaceWith = @ReplaceWith(expression = "QuantityWithZeroAndSingular(int, int, int, int, Object...)", imports = {}))
    @JvmStatic
    public static final String quantity(int resourceID, int quantity, Object... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        String quantityString = ApplicationProvider.getApplication().getResources().getQuantityString(resourceID, quantity, Arrays.copyOf(params, params.length));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        return quantityString;
    }

    @JvmStatic
    public static final String quantityWithZero(int zeroStringResId, int pluralStringResId, int quantity, Object... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (quantity == 0) {
            String string = ApplicationProvider.getApplication().getResources().getString(zeroStringResId, Arrays.copyOf(params, params.length));
            Intrinsics.checkNotNull(string);
            return string;
        }
        String quantityString = ApplicationProvider.getApplication().getResources().getQuantityString(pluralStringResId, quantity, Arrays.copyOf(params, params.length));
        Intrinsics.checkNotNull(quantityString);
        return quantityString;
    }

    @JvmStatic
    public static final String quantityWithZeroAndSingular(int zeroStringResId, int singularStringResId, int pluralStringResId, int quantity, Object... params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (quantity == 0) {
            String string = ApplicationProvider.getApplication().getResources().getString(zeroStringResId, Arrays.copyOf(params, params.length));
            Intrinsics.checkNotNull(string);
            return string;
        }
        if (quantity == 1) {
            String string2 = ApplicationProvider.getApplication().getResources().getString(singularStringResId, Arrays.copyOf(params, params.length));
            Intrinsics.checkNotNull(string2);
            return string2;
        }
        String quantityString = ApplicationProvider.getApplication().getResources().getQuantityString(pluralStringResId, quantity, Arrays.copyOf(params, params.length));
        Intrinsics.checkNotNull(quantityString);
        return quantityString;
    }

    @JvmStatic
    public static final String[] getNameExtensionPath(String unparsedName) {
        Intrinsics.checkNotNullParameter(unparsedName, "unparsedName");
        String[] strArr = new String[3];
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) unparsedName, "/", 0, false, 6, (Object) null);
        if (iLastIndexOf$default > 0) {
            String strSubstring = unparsedName.substring(iLastIndexOf$default + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            strArr[0] = strSubstring;
            String strSubstring2 = unparsedName.substring(0, iLastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            strArr[2] = strSubstring2;
        } else {
            strArr[0] = unparsedName;
            strArr[2] = "";
        }
        String str = strArr[0];
        Intrinsics.checkNotNull(str);
        int iLastIndexOf$default2 = StringsKt.lastIndexOf$default((CharSequence) str, '.', 0, false, 6, (Object) null);
        if (iLastIndexOf$default2 >= 0) {
            String str2 = strArr[0];
            Intrinsics.checkNotNull(str2);
            String strSubstring3 = str2.substring(iLastIndexOf$default2);
            Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
            strArr[1] = strSubstring3;
            String str3 = strArr[0];
            Intrinsics.checkNotNull(str3);
            String strSubstring4 = str3.substring(0, iLastIndexOf$default2);
            Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
            strArr[0] = strSubstring4;
        }
        if (strArr[1] == null) {
            strArr[1] = "";
        }
        String str4 = strArr[1];
        Intrinsics.checkNotNull(str4);
        if (str4.length() > 1) {
            String str5 = strArr[1];
            Intrinsics.checkNotNull(str5);
            String strSubstring5 = str5.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
            strArr[1] = strSubstring5;
        }
        return strArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0018, code lost:
    
        if (isTempCreatable(r2) != false) goto L10;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.io.File getEscapedFileForSD(java.io.File r4) throws java.io.IOException {
        /*
            java.lang.String r0 = "getName(...)"
            r1 = 0
            if (r4 != 0) goto L6
            return r1
        L6:
            boolean r2 = r4.exists()
            if (r2 == 0) goto Ld
            goto L1a
        Ld:
            java.lang.String r2 = r4.getName()     // Catch: java.io.IOException -> L1b
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch: java.io.IOException -> L1b
            boolean r2 = isTempCreatable(r2)     // Catch: java.io.IOException -> L1b
            if (r2 == 0) goto L1b
        L1a:
            return r4
        L1b:
            java.lang.String r2 = r4.getName()
            java.lang.String r2 = escapeFileNameForSD(r2)
            java.lang.String r3 = r4.getParent()
            if (r3 == 0) goto L48
            java.io.File r3 = new java.io.File
            java.lang.String r4 = r4.getParent()
            r3.<init>(r4, r2)
            boolean r4 = r3.exists()
            if (r4 == 0) goto L39
            return r3
        L39:
            java.lang.String r4 = r3.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
            boolean r4 = isTempCreatable(r4)
            if (r4 == 0) goto L47
            r1 = r3
        L47:
            return r1
        L48:
            java.io.IOException r4 = new java.io.IOException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.common.utilities.CommonBoxUtil.getEscapedFileForSD(java.io.File):java.io.File");
    }

    @JvmStatic
    private static final boolean isTempCreatable(String tempFileName) throws IOException {
        File file = new File(new StringBuffer(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Android/data/").append(ApplicationProvider.getApplication().getPackageName()).append("/cache/temp/").toString());
        if (!file.exists() && !file.mkdirs()) {
            return false;
        }
        File file2 = new File(file, tempFileName);
        if (!file2.createNewFile()) {
            return false;
        }
        file2.delete();
        return true;
    }

    @JvmStatic
    public static final String escapeFileNameForSD(String unfilteredName) {
        if (unfilteredName != null) {
            String str = unfilteredName;
            if (str.length() != 0) {
                String strReplace = new Regex("[:\\?\\\\/<>\\*\"]").replace(str, "_");
                Intrinsics.checkNotNull(strReplace, "null cannot be cast to non-null type kotlin.String");
                return strReplace;
            }
        }
        return "_";
    }

    @JvmStatic
    public static final File getInternalPreviewDirectory() {
        File filesDir = ApplicationProvider.getApplication().getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "getFilesDir(...)");
        File file = new File(filesDir + "/previews/");
        file.mkdirs();
        return file;
    }

    @JvmStatic
    public static final int convertDpToPixel(float dp, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) (dp * (context.getResources().getDisplayMetrics().densityDpi / 160.0f));
    }

    @JvmStatic
    public static final float convertPixelToDp(float pixel, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return pixel / getScreenDensity(context);
    }

    @JvmStatic
    public static final float getScreenDensity(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDisplayMetrics().density;
    }

    @JvmStatic
    public static final void hideKeyboard(FragmentActivity activity, View bindingView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bindingView, "bindingView");
        Object systemService = activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(bindingView.getWindowToken(), 0);
    }

    @JvmStatic
    public static final void showKeyboard(FragmentActivity activity, View bindingView) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bindingView, "bindingView");
        Object systemService = activity.getSystemService("input_method");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(bindingView, 0);
    }

    public static final String getDeviceName() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        Intrinsics.checkNotNull(str2);
        Intrinsics.checkNotNull(str);
        return StringsKt.startsWith$default(str2, str, false, 2, (Object) null) ? str2 : str + " " + str2;
    }

    @JvmStatic
    public static final void writeToFile(File file, String stringToWrite, boolean append, boolean newLine) throws IOException {
        if (file != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, append));
        bufferedWriter.write(stringToWrite);
        if (newLine) {
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    @JvmStatic
    public static final boolean valuePresentInSet(int value, int... checkAgainstList) {
        Intrinsics.checkNotNullParameter(checkAgainstList, "checkAgainstList");
        for (int i : checkAgainstList) {
            if (value == i) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final Bitmap decodeSampledBitmapFromFile(File file, int reqWidth, int reqHeight) throws FileNotFoundException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(file)), null, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(file)), null, options);
    }

    @JvmStatic
    private static final int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int i = options.outHeight;
        int i2 = options.outWidth;
        if (i <= reqHeight && i2 <= reqWidth) {
            return 1;
        }
        int iRoundToInt = MathKt.roundToInt(i / reqHeight);
        int iRoundToInt2 = MathKt.roundToInt(i2 / reqWidth);
        return iRoundToInt < iRoundToInt2 ? iRoundToInt : iRoundToInt2;
    }

    @JvmStatic
    public static final String[] getFileNameAndExt(String fileName) {
        String string;
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        int iLastIndexOf$default = StringsKt.lastIndexOf$default((CharSequence) fileName, ".", 0, false, 6, (Object) null);
        if (iLastIndexOf$default < 0) {
            string = "";
        } else {
            String strSubstring = fileName.substring(iLastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String str = strSubstring;
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            string = str.subSequence(i, length + 1).toString();
            fileName = fileName.substring(0, iLastIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(fileName, "substring(...)");
        }
        return new String[]{fileName, string};
    }

    @JvmStatic
    public static final boolean doesPackageExist(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        try {
            ApplicationInfo applicationInfo = MAMPackageManagement.getApplicationInfo(ApplicationProvider.getApplication().getPackageManager(), packageName, 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            return applicationInfo.enabled;
        } catch (Exception unused) {
            return false;
        }
    }

    @JvmStatic
    public static final boolean doesPackageExistWithMinimumVersionCode(String packageName, long minVersion) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        try {
            PackageManager packageManager = ApplicationProvider.getApplication().getPackageManager();
            PackageInfo packageInfo = MAMPackageManagement.getPackageInfo(packageManager, packageName, 128);
            ApplicationInfo applicationInfo = MAMPackageManagement.getApplicationInfo(packageManager, packageName, 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "getApplicationInfo(...)");
            return packageInfo.getLongVersionCode() > minVersion && applicationInfo.enabled;
        } catch (Exception unused) {
        }
    }

    @JvmStatic
    public static final int getCurrentVersionNumber() {
        try {
            return MAMPackageManagement.getPackageInfo(ApplicationProvider.getApplication().getPackageManager(), ApplicationProvider.getApplication().getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    @JvmStatic
    public static final ArrayList<String> createWrapperList(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        ArrayList<String> arrayList = new ArrayList<>(1);
        arrayList.add(id);
        return arrayList;
    }

    @JvmStatic
    public static final String getContentProviderAuthority(String postfix) {
        Intrinsics.checkNotNullParameter(postfix, "postfix");
        return ApplicationProvider.getApplication().getPackageName() + postfix;
    }

    @JvmStatic
    public static final Map<String, String> parseCookies(String cookieString) {
        HashMap map = new HashMap();
        if (cookieString != null) {
            for (String str : (String[]) StringsKt.split$default((CharSequence) cookieString, new String[]{AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER}, false, 0, 6, (Object) null).toArray(new String[0])) {
                String[] strArr = (String[]) StringsKt.split$default((CharSequence) str, new String[]{SimpleComparison.EQUAL_TO_OPERATION}, false, 2, 2, (Object) null).toArray(new String[0]);
                if (strArr.length == 2) {
                    map.put(StringsKt.trim((CharSequence) strArr[0]).toString(), strArr[1]);
                }
            }
        }
        return map;
    }

    @JvmStatic
    public static final boolean isBiometricHardwareAvailable(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return BiometricManager.from(ctx).canAuthenticate(15) == 0;
    }

    @JvmStatic
    public static final boolean isAppNotificationsEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    @JvmStatic
    public static final String getUtmMedium(Uri uri) {
        if (uri != null) {
            return uri.getQueryParameter("utm_medium");
        }
        return null;
    }

    @JvmStatic
    public static final boolean isSendEmailIntentAvailable(Context context) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setFlags(intent.getFlags() | 268435456);
        intent.setType(BoxCommonConstants.EMAIL_MIME_TYPE);
        intent.putExtra("android.intent.extra.TEXT", BoxCommonConstants.BODY_OF_EMAIL);
        intent.putExtra("android.intent.extra.EMAIL", new String[]{BoxCommonConstants.ANDROID_SUPPORT_EMAIL});
        Intrinsics.checkNotNull(context);
        return isIntentAvailable(context, intent);
    }

    @JvmStatic
    public static final String getDirectoryFromDocProviderResult(Context context, Intent data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Uri data2 = data.getData();
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics.checkNotNull(data2);
        contentResolver.takePersistableUriPermission(data2, 3);
        return FileUtil.getFullPathFromTreeUri(data2, context);
    }

    public static /* synthetic */ Bitmap getScaledBitmap$default(CommonBoxUtil commonBoxUtil, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 96;
        }
        return commonBoxUtil.getScaledBitmap(str, i);
    }

    public final Bitmap getScaledBitmap(String filePath, int size) {
        if (filePath == null) {
            return null;
        }
        try {
            Bitmap bitmapDecodeSampledBitmapFromFile = decodeSampledBitmapFromFile(new File(filePath), size, size);
            if (bitmapDecodeSampledBitmapFromFile != null) {
                return bitmapDecodeSampledBitmapFromFile;
            }
            CommonBoxUtil commonBoxUtil = this;
            MAMMediaMetadataRetriever mAMMediaMetadataRetriever = new MAMMediaMetadataRetriever();
            mAMMediaMetadataRetriever.setDataSource(filePath);
            Bitmap scaledFrameAtTime = mAMMediaMetadataRetriever.getScaledFrameAtTime(0L, 0, size, size);
            mAMMediaMetadataRetriever.release();
            return scaledFrameAtTime;
        } catch (Exception unused) {
            return null;
        }
    }

    public static /* synthetic */ String getTimestampedName$default(String str, String str2, String str3, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 8) != 0) {
            date = new Date();
        }
        return getTimestampedName(str, str2, str3, date);
    }

    @JvmStatic
    public static final String getTimestampedName(String prefix, String suffix, String extension, Date dateToTimeStamp) {
        Intrinsics.checkNotNullParameter(extension, "extension");
        Intrinsics.checkNotNullParameter(dateToTimeStamp, "dateToTimeStamp");
        StringBuilder sb = new StringBuilder();
        if (prefix != null) {
            sb.append(prefix + "_");
        }
        sb.append(new SimpleDateFormat(DATE_FORMAT, Locale.US).format(dateToTimeStamp).toString());
        if (suffix != null) {
            sb.append("_" + suffix);
        }
        if (extension.length() > 0) {
            sb.append("." + extension);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static /* synthetic */ Bitmap drawableToBitmap$default(CommonBoxUtil commonBoxUtil, Drawable drawable, Integer num, Integer num2, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            num2 = null;
        }
        return commonBoxUtil.drawableToBitmap(drawable, num, num2);
    }

    public final Bitmap drawableToBitmap(Drawable drawable, Integer width, Integer height) {
        Bitmap bitmapCreateBitmap;
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        int iIntValue = width != null ? width.intValue() : drawable.getIntrinsicWidth();
        int iIntValue2 = height != null ? height.intValue() : drawable.getIntrinsicHeight();
        BitmapDrawable bitmapDrawable = drawable instanceof BitmapDrawable ? (BitmapDrawable) drawable : null;
        if (bitmapDrawable == null || (bitmapCreateBitmap = bitmapDrawable.getBitmap()) == null) {
            if (iIntValue <= 0 || iIntValue2 <= 0) {
                bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            } else {
                bitmapCreateBitmap = Bitmap.createBitmap(iIntValue, iIntValue2, Bitmap.Config.ARGB_8888);
            }
        }
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    @JvmStatic
    public static final boolean isAtLeastVersion(int versionCode) {
        return Build.VERSION.SDK_INT >= versionCode;
    }
}
