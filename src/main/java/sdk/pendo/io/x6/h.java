package sdk.pendo.io.x6;

import android.app.Activity;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.box.androidsdk.content.models.BoxRepresentation;
import com.facebook.react.devsupport.StackTraceHelper;
import com.google.android.gms.maps.MapView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.pspdfkit.BuildConfig;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.events.IdentificationData;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.s7.b1;
import sdk.pendo.io.s7.e1;
import sdk.pendo.io.s7.t;
import sdk.pendo.io.s7.y0;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.views.custom.PendoFloatingVisualGuideView;
import sdk.pendo.io.views.listener.FloatingListenerButton;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 I2\u00020\u0001:\u0003\u0010 .BU\u0012\"\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002000/j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000200`1\u0012\b\u00106\u001a\u0004\u0018\u000104\u0012\u0006\u00108\u001a\u00020\u0017\u0012\u0006\u0010:\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010=\u001a\u00020\u0017¢\u0006\u0004\bG\u0010HJS\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0015J(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\rH\u0002J \u0010 \u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002J \u0010\u0010\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0002JO\u0010\u0010\u001a\u00020$2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010%J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0003H\u0007J\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00122\u0006\u0010'\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010(J\u0019\u0010\u0010\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0000¢\u0006\u0004\b\u0010\u0010)J3\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010*J\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0000¢\u0006\u0004\b\u0010\u0010,J\u0012\u0010.\u001a\u0004\u0018\u00010\b2\u0006\u0010-\u001a\u00020\u0006H\u0004J4\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u00062\"\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002000/j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000200`1J\u0012\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u0006H\u0004R0\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002000/j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u000200`18\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u00103R\u0016\u00106\u001a\u0004\u0018\u0001048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u00105R\u0014\u00108\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u00107R\u0014\u0010:\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00107R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00107R\u0014\u0010=\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u00107RP\u0010B\u001a>\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@0/j\u001e\u0012\u0004\u0012\u00020\r\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@`18\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u00103R\u001c\u0010F\u001a\n C*\u0004\u0018\u00010\u00170\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010E\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006J"}, d2 = {"Lsdk/pendo/io/x6/h;", "", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "activityRef", "", "Landroid/view/View;", "rootViews", "Lorg/json/JSONObject;", "screenData", "Lorg/json/JSONArray;", "textsWithElementsInfo", "identifiersWithElementsInfo", "", "currentScreenId", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Ljava/lang/ref/WeakReference;Ljava/util/Set;Lorg/json/JSONObject;Lorg/json/JSONArray;Lorg/json/JSONArray;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/x6/f;", "rootPendoNode", "specialElementsJsonArray", "(Lsdk/pendo/io/x6/f;Lorg/json/JSONArray;Lorg/json/JSONArray;Lorg/json/JSONArray;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "view", "", "includeText", "viewElement", "", "selectedIndex", "viewType", "Landroid/graphics/Rect;", "windowVisibleDisplayRect", "rectOfVisibleView", "b", "Lsdk/pendo/io/x6/b;", "fragmentHelper", Pendo.PendoOptions.USE_MODIFIED_SCREEN_DATA_FOR_NATIVE_TRANSIENT_UI_COMPONENT, "Lsdk/pendo/io/x6/h$b;", "(Ljava/lang/String;Ljava/lang/ref/WeakReference;Ljava/util/Set;Lsdk/pendo/io/x6/b;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "activity", "rootView", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroid/view/View;)Z", "(Landroid/view/View;Lorg/json/JSONArray;Lorg/json/JSONArray;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "identifiers", "(Lorg/json/JSONArray;)Lorg/json/JSONArray;", "element", "c", "Ljava/util/HashMap;", "Lsdk/pendo/io/x6/c;", "Lkotlin/collections/HashMap;", "fragmentsInfoHashMap", "Ljava/util/HashMap;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "viewPagerOnPageSelectedListener", "Z", "isRespondToScrollChangeEventsForScreenId", "d", "includeNestedText", "e", "f", "isForCapture", "Ljava/util/ArrayList;", "Lsdk/pendo/io/x6/h$c;", "Lkotlin/collections/ArrayList;", "g", "specialViewsMap", "kotlin.jvm.PlatformType", CmcdData.STREAMING_FORMAT_HLS, "Ljava/lang/Boolean;", "isGoogleMapsAvailable", "<init>", "(Ljava/util/HashMap;Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;ZZZZ)V", "i", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class h {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    private final HashMap<Integer, sdk.pendo.io.x6.c> fragmentsInfoHashMap;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    private final ViewPager.OnPageChangeListener viewPagerOnPageSelectedListener;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    private final boolean isRespondToScrollChangeEventsForScreenId;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    private final boolean includeNestedText;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    private final boolean includeText;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    private final boolean isForCapture;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    private final HashMap<String, ArrayList<c>> specialViewsMap;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    private final Boolean isGoogleMapsAvailable;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\t\u0012\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00110\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR3\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00110\u000e8\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/x6/h$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/json/JSONObject;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "screenDataJson", "", "Ljava/util/ArrayList;", "Lsdk/pendo/io/x6/h$c;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "specialViewMap", "<init>", "(Lorg/json/JSONObject;Ljava/util/Map;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final /* data */ class b {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final JSONObject screenDataJson;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final Map<String, ArrayList<c>> specialViewMap;

        /* JADX WARN: Multi-variable type inference failed */
        public b(JSONObject screenDataJson, Map<String, ? extends ArrayList<c>> specialViewMap) {
            Intrinsics.checkNotNullParameter(screenDataJson, "screenDataJson");
            Intrinsics.checkNotNullParameter(specialViewMap, "specialViewMap");
            this.screenDataJson = screenDataJson;
            this.specialViewMap = specialViewMap;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final JSONObject getScreenDataJson() {
            return this.screenDataJson;
        }

        public final Map<String, ArrayList<c>> b() {
            return this.specialViewMap;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            return Intrinsics.areEqual(this.screenDataJson, bVar.screenDataJson) && Intrinsics.areEqual(this.specialViewMap, bVar.specialViewMap);
        }

        public int hashCode() {
            return (this.screenDataJson.hashCode() * 31) + this.specialViewMap.hashCode();
        }

        public String toString() {
            return "ScreenData(screenDataJson=" + this.screenDataJson + ", specialViewMap=" + this.specialViewMap + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/x6/h$c;", "", "", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "I", "b", "()I", "viewId", "lastKnownSelectedIndex", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "c", "Ljava/lang/ref/WeakReference;", "()Ljava/lang/ref/WeakReference;", "viewWeakRef", "<init>", "(IILjava/lang/ref/WeakReference;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final /* data */ class c {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final int viewId;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        private final int lastKnownSelectedIndex;

        /* JADX INFO: renamed from: c, reason: from kotlin metadata */
        private final WeakReference<View> viewWeakRef;

        public c(int i, int i2, WeakReference<View> viewWeakRef) {
            Intrinsics.checkNotNullParameter(viewWeakRef, "viewWeakRef");
            this.viewId = i;
            this.lastKnownSelectedIndex = i2;
            this.viewWeakRef = viewWeakRef;
        }

        /* JADX INFO: renamed from: a, reason: from getter */
        public final int getLastKnownSelectedIndex() {
            return this.lastKnownSelectedIndex;
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getViewId() {
            return this.viewId;
        }

        public final WeakReference<View> c() {
            return this.viewWeakRef;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            return this.viewId == cVar.viewId && this.lastKnownSelectedIndex == cVar.lastKnownSelectedIndex && Intrinsics.areEqual(this.viewWeakRef, cVar.viewWeakRef);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.viewId) * 31) + Integer.hashCode(this.lastKnownSelectedIndex)) * 31) + this.viewWeakRef.hashCode();
        }

        public String toString() {
            return "SpecialViewItem(viewId=" + this.viewId + ", lastKnownSelectedIndex=" + this.lastKnownSelectedIndex + ", viewWeakRef=" + this.viewWeakRef + ")";
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenDataHelper", f = "ScreenDataHelper.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {252}, m = "collectDataForVisibleViewsIterative", n = {"this", "specialElementsJsonArray", "textsWithElementsInfo", "identifiersWithElementsInfo", "currentScreenId", StackTraceHelper.STACK_KEY, "pendoNode", "parentSpecialElement", "specialElementJson", "it"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9"})
    static final class d extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        Object h;
        Object i;
        Object j;
        /* synthetic */ Object k;
        int m;

        d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.k = obj;
            this.m |= Integer.MIN_VALUE;
            return h.this.a((sdk.pendo.io.x6.f) null, (JSONArray) null, (JSONArray) null, (JSONArray) null, (String) null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenDataHelper", f = "ScreenDataHelper.kt", i = {0, 0, 0, 0}, l = {86}, m = "getScreenData", n = {"this", "screenData", "textsWithElementsInfo", "identifiersWithElementsInfo"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class e extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        Object d;
        /* synthetic */ Object e;
        int g;

        e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return h.this.a((String) null, (WeakReference<Activity>) null, (Set<? extends View>) null, (sdk.pendo.io.x6.b) null, false, (Continuation<? super b>) this);
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenDataHelper", f = "ScreenDataHelper.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {122, 124}, m = "retrieveScreenInfoAndTexts", n = {"this", "screenData", "textsWithElementsInfo", "identifiersWithElementsInfo", "currentScreenId", "childElements", "this", "screenData", "textsWithElementsInfo", "identifiersWithElementsInfo", "currentScreenId", "childElements"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    static final class f extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        /* synthetic */ Object h;
        int j;

        f(Continuation<? super f> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return h.this.a((WeakReference<Activity>) null, (Set<? extends View>) null, (JSONObject) null, (JSONArray) null, (JSONArray) null, (String) null, this);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lsdk/pendo/io/x6/f;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.sdk.manager.screenmanager.ScreenDataHelper$scanHierarchyAndGeneratePendoNodeTree$2", f = "ScreenDataHelper.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {193}, m = "invokeSuspend", n = {"$this$withContext", "rectOfVisibleView", "windowVisibleDisplayRect", StackTraceHelper.STACK_KEY, "rootPendoNode", "view", "parentPendoNode", "counter", "isParentVisibleOnScreen"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "Z$0"})
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super sdk.pendo.io.x6.f>, Object> {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        int g;
        boolean h;
        int i;
        private /* synthetic */ Object j;
        final /* synthetic */ View k;
        final /* synthetic */ h l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(View view, h hVar, Continuation<? super g> continuation) {
            super(2, continuation);
            this.k = view;
            this.l = hVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super sdk.pendo.io.x6.f> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            g gVar = new g(this.k, this.l, continuation);
            gVar.j = obj;
            return gVar;
        }

        /* JADX WARN: Code duplicated, block: B:42:0x0126 A[LOOP:0: B:40:0x010d->B:42:0x0126, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:43:0x012c  */
        /* JADX WARN: Code duplicated, block: B:51:0x012e A[EDGE_INSN: B:51:0x012e->B:44:0x012e BREAK  A[LOOP:0: B:40:0x010d->B:42:0x0126], SYNTHETIC] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v15, types: [T, sdk.pendo.io.x6.f] */
        /* JADX WARN: Type inference failed for: r7v14 */
        /* JADX WARN: Type inference failed for: r7v15 */
        /* JADX WARN: Type inference failed for: r7v4, types: [T, sdk.pendo.io.x6.f] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00b4 -> B:19:0x00b7). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:40:0x010d
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r18) {
            /*
                Method dump skipped, instruction units count: 346
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x6.h.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public h(HashMap<Integer, sdk.pendo.io.x6.c> fragmentsInfoHashMap, ViewPager.OnPageChangeListener onPageChangeListener, boolean z, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(fragmentsInfoHashMap, "fragmentsInfoHashMap");
        this.fragmentsInfoHashMap = fragmentsInfoHashMap;
        this.viewPagerOnPageSelectedListener = onPageChangeListener;
        this.isRespondToScrollChangeEventsForScreenId = z;
        this.includeNestedText = z2;
        this.includeText = z3;
        this.isForCapture = z4;
        this.specialViewsMap = new HashMap<>();
        this.isGoogleMapsAvailable = y0.b("com.google.android.gms.maps.MapView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean b(View view, Rect windowVisibleDisplayRect, Rect rectOfVisibleView) {
        return !a(view, windowVisibleDisplayRect, rectOfVisibleView);
    }

    protected final JSONObject c(View element) throws JSONException {
        Intrinsics.checkNotNullParameter(element, "element");
        JSONObject jSONObjectA = a(element, this.fragmentsInfoHashMap);
        return jSONObjectA != null ? jSONObjectA : b(element);
    }

    protected final JSONObject b(final View viewElement) throws JSONException {
        int size;
        final ViewPager.OnPageChangeListener onPageChangeListener;
        Intrinsics.checkNotNullParameter(viewElement, "viewElement");
        JSONObject jSONObject = new JSONObject();
        if (viewElement instanceof TabLayout) {
            jSONObject.put("kind", "TabLayout");
            TabLayout tabLayout = (TabLayout) viewElement;
            int selectedTabPosition = tabLayout.getSelectedTabPosition();
            if (this.includeText) {
                sdk.pendo.io.v7.a aVar = sdk.pendo.io.v7.a.a;
                TabLayout.Tab tabAt = tabLayout.getTabAt(selectedTabPosition);
                jSONObject.put("selectedTitle", aVar.b(String.valueOf(tabAt != null ? tabAt.getText() : null)));
                if (this.isForCapture) {
                    TabLayout.Tab tabAt2 = tabLayout.getTabAt(selectedTabPosition);
                    jSONObject.put("selectedTitleText", y0.a(String.valueOf(tabAt2 != null ? tabAt2.getText() : null)));
                }
            }
            jSONObject.put("selectedIndex", selectedTabPosition);
            size = tabLayout.getTabCount();
            a(viewElement, selectedTabPosition, "TabLayout");
        } else if (viewElement instanceof ViewPager) {
            jSONObject.put("kind", "ViewPager");
            ViewPager viewPager = (ViewPager) viewElement;
            jSONObject.put("selectedIndex", viewPager.getCurrentItem());
            PagerAdapter adapter = viewPager.getAdapter();
            size = adapter != null ? adapter.getCount() : -1;
            if (!this.isRespondToScrollChangeEventsForScreenId && (onPageChangeListener = this.viewPagerOnPageSelectedListener) != null) {
                viewElement.post(new Runnable() { // from class: sdk.pendo.io.x6.h$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.a(viewElement, onPageChangeListener);
                    }
                });
            }
        } else {
            if (!(viewElement instanceof BottomNavigationView)) {
                Boolean isGoogleMapsAvailable = this.isGoogleMapsAvailable;
                Intrinsics.checkNotNullExpressionValue(isGoogleMapsAvailable, "isGoogleMapsAvailable");
                if (isGoogleMapsAvailable.booleanValue() && (viewElement instanceof MapView)) {
                    a(viewElement, -1, "MapView");
                }
                return null;
            }
            jSONObject.put("kind", "BottomNavigationView");
            BottomNavigationView bottomNavigationView = (BottomNavigationView) viewElement;
            int selectedItemId = bottomNavigationView.getSelectedItemId();
            if (this.includeText) {
                sdk.pendo.io.v7.a aVar2 = sdk.pendo.io.v7.a.a;
                MenuItem menuItemFindItem = bottomNavigationView.getMenu().findItem(selectedItemId);
                jSONObject.put("selectedTitle", aVar2.b(String.valueOf(menuItemFindItem != null ? menuItemFindItem.getTitle() : null)));
                if (this.isForCapture) {
                    MenuItem menuItemFindItem2 = bottomNavigationView.getMenu().findItem(selectedItemId);
                    jSONObject.put("selectedTitleText", y0.a(String.valueOf(menuItemFindItem2 != null ? menuItemFindItem2.getTitle() : null)));
                }
            }
            jSONObject.put("selectedId", selectedItemId);
            size = bottomNavigationView.getMenu().size();
            a(viewElement, selectedItemId, "BottomNavigationView");
        }
        jSONObject.put("numberOfIndexes", size);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("name", viewElement.getClass().getSimpleName());
        jSONObject2.put(BoxRepresentation.FIELD_INFO, jSONObject);
        return jSONObject2;
    }

    public final void a(JSONObject screenData, Activity activity) throws JSONException {
        Intrinsics.checkNotNullParameter(screenData, "screenData");
        Intrinsics.checkNotNullParameter(activity, "activity");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("kind", "activity");
        screenData.put("name", activity.getClass().getSimpleName());
        screenData.put(BoxRepresentation.FIELD_INFO, jSONObject);
    }

    private final void a(View viewElement, int selectedIndex, String viewType) {
        if (viewElement.getId() == -1) {
            viewElement.setId(View.generateViewId());
        }
        c cVar = new c(viewElement.getId(), selectedIndex, new WeakReference(viewElement));
        if (!this.specialViewsMap.containsKey(viewType)) {
            ArrayList<c> arrayList = new ArrayList<>();
            arrayList.add(cVar);
            this.specialViewsMap.put(viewType, arrayList);
        } else {
            ArrayList<c> arrayList2 = this.specialViewsMap.get(viewType);
            if (arrayList2 != null) {
                arrayList2.add(cVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0078  */
    /* JADX WARN: Code duplicated, block: B:19:0x0096  */
    /* JADX WARN: Code duplicated, block: B:21:0x00b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:22:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:35:0x0111  */
    /* JADX WARN: Code duplicated, block: B:37:0x011b  */
    /* JADX WARN: Code duplicated, block: B:38:0x0121  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r9v6, types: [T, java.lang.Object, org.json.JSONObject] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0094 -> B:32:0x0103). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x00b3 -> B:23:0x00c1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(sdk.pendo.io.x6.f r10, org.json.JSONArray r11, org.json.JSONArray r12, org.json.JSONArray r13, java.lang.String r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            Method dump skipped, instruction units count: 303
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x6.h.a(sdk.pendo.io.x6.f, org.json.JSONArray, org.json.JSONArray, org.json.JSONArray, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void a(View view, JSONArray textsWithElementsInfo, JSONArray identifiersWithElementsInfo, boolean includeText) {
        String strCreateTextRetroElementIdentifier;
        String strA;
        IdentificationData identificationDataA = sdk.pendo.io.c6.b.a(view);
        if (identificationDataA == null) {
            return;
        }
        String viewTagBase64 = identificationDataA.getViewTagBase64();
        if (viewTagBase64 != null && (strA = t.a.a(viewTagBase64, false)) != null && !StringsKt.isBlank(strA)) {
            identifiersWithElementsInfo.put(strA);
        }
        if (!includeText || (strCreateTextRetroElementIdentifier = identificationDataA.createTextRetroElementIdentifier()) == null || strCreateTextRetroElementIdentifier.length() == 0) {
            return;
        }
        PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
        if (platformStateManager.isNotReactNativeApp() || (platformStateManager.isReactNativeAnalyticsEnabled() && identificationDataA.getTextBase64() != null)) {
            textsWithElementsInfo.put(sdk.pendo.io.v7.a.a.a(strCreateTextRetroElementIdentifier));
        }
    }

    public final JSONArray a(JSONArray identifiers) {
        Intrinsics.checkNotNullParameter(identifiers, "identifiers");
        if (identifiers.length() <= 1) {
            return identifiers;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int length = identifiers.length();
        for (int i = 0; i < length; i++) {
            String strOptString = identifiers.optString(i);
            Intrinsics.checkNotNull(strOptString);
            if (!StringsKt.isBlank(strOptString)) {
                linkedHashSet.add(strOptString);
            }
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = CollectionsKt.sorted(linkedHashSet).iterator();
        while (it.hasNext()) {
            jSONArray.put((String) it.next());
        }
        return jSONArray;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(String str, WeakReference<Activity> weakReference, Set<? extends View> set, sdk.pendo.io.x6.b bVar, boolean z, Continuation<? super b> continuation) {
        e eVar;
        JSONArray jSONArray;
        h hVar;
        JSONObject jSONObject;
        JSONArray jSONArray2;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i = eVar.g;
            if ((i & Integer.MIN_VALUE) != 0) {
                eVar.g = i - Integer.MIN_VALUE;
            } else {
                eVar = new e(continuation);
            }
        } else {
            eVar = new e(continuation);
        }
        e eVar2 = eVar;
        Object obj = eVar2.e;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = eVar2.g;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            JSONObject jSONObjectPut = new JSONObject().put("retroactiveScreenId", str);
            if (PlatformStateManager.INSTANCE.isNativeFramework() && z && i.INSTANCE.a(str)) {
                String strA = sdk.pendo.io.x6.b.a(bVar, this.fragmentsInfoHashMap, false, 2, null);
                if (strA.length() > 0) {
                    jSONObjectPut.put("fragmentList", strA);
                }
                String strA2 = sdk.pendo.io.b8.b.a.a();
                if (strA2 != null && strA2.length() != 0) {
                    jSONObjectPut.put("targetElement", strA2);
                }
            }
            JSONArray jSONArray3 = new JSONArray();
            jSONArray = new JSONArray();
            Intrinsics.checkNotNull(jSONObjectPut);
            eVar2.a = this;
            eVar2.b = jSONObjectPut;
            eVar2.c = jSONArray3;
            eVar2.d = jSONArray;
            eVar2.g = 1;
            if (a(weakReference, set, jSONObjectPut, jSONArray3, jSONArray, str, eVar2) == coroutine_suspended) {
                return coroutine_suspended;
            }
            hVar = this;
            jSONObject = jSONObjectPut;
            jSONArray2 = jSONArray3;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            JSONArray jSONArray4 = (JSONArray) eVar2.d;
            jSONArray2 = (JSONArray) eVar2.c;
            jSONObject = (JSONObject) eVar2.b;
            h hVar2 = (h) eVar2.a;
            ResultKt.throwOnFailure(obj);
            jSONArray = jSONArray4;
            hVar = hVar2;
        }
        jSONObject.put("texts", jSONArray2);
        jSONObject.put("identifiers", hVar.a(jSONArray));
        Intrinsics.checkNotNull(jSONObject);
        return new b(jSONObject, hVar.specialViewsMap);
    }

    private final boolean a(View view, Rect windowVisibleDisplayRect, Rect rectOfVisibleView) {
        if (e1.a(view, windowVisibleDisplayRect, rectOfVisibleView, 0)) {
            return PlatformStateManager.INSTANCE.isReactNativeAnalyticsEnabled() && view.getVisibility() != 0;
        }
        return true;
    }

    public final boolean a(View view) {
        if (view == null) {
            return true;
        }
        if (view instanceof PendoFloatingVisualGuideView) {
            PendoLogger.d("ScreenDataHelper", "View is of type PendoFloatingVisualGuideView, return from scan");
            return true;
        }
        if (!(view instanceof FloatingListenerButton)) {
            return false;
        }
        PendoLogger.d("ScreenDataHelper", "View is of type FloatingListenerButton, return from scan");
        return true;
    }

    public final JSONObject a(View viewElement, HashMap<Integer, sdk.pendo.io.x6.c> fragmentsInfoHashMap) throws JSONException {
        Intrinsics.checkNotNullParameter(viewElement, "viewElement");
        Intrinsics.checkNotNullParameter(fragmentsInfoHashMap, "fragmentsInfoHashMap");
        sdk.pendo.io.x6.c cVar = fragmentsInfoHashMap.get(Integer.valueOf(viewElement.hashCode()));
        if (cVar == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("kind", BuildConfig.FLAVOR);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("name", cVar.getFragmentName());
        jSONObject2.put(BoxRepresentation.FIELD_INFO, jSONObject);
        return jSONObject2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(View viewElement, ViewPager.OnPageChangeListener it) {
        Intrinsics.checkNotNullParameter(viewElement, "$viewElement");
        Intrinsics.checkNotNullParameter(it, "$it");
        ViewPager viewPager = (ViewPager) viewElement;
        viewPager.removeOnPageChangeListener(it);
        viewPager.addOnPageChangeListener(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:26:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:29:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:32:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:33:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object a(java.lang.ref.WeakReference<android.app.Activity> r8, java.util.Set<? extends android.view.View> r9, org.json.JSONObject r10, org.json.JSONArray r11, org.json.JSONArray r12, java.lang.String r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x6.h.a(java.lang.ref.WeakReference, java.util.Set, org.json.JSONObject, org.json.JSONArray, org.json.JSONArray, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object a(View view, Continuation<? super sdk.pendo.io.x6.f> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new g(view, this, null), continuation);
    }

    public final Object a(View view, JSONArray jSONArray, JSONArray jSONArray2, String str, Continuation<? super Unit> continuation) {
        b1 b1Var = b1.a;
        sdk.pendo.io.s7.i iVarA = b1Var.a();
        if (iVarA == null || !iVarA.d(view)) {
            a(view, jSONArray, jSONArray2, this.includeText);
        } else {
            sdk.pendo.io.s7.i iVarA2 = b1Var.a();
            if (iVarA2 != null) {
                Object objA = iVarA2.a(view, jSONArray, jSONArray2, this.includeText, this.isForCapture, str, continuation);
                return objA == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objA : Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }
}
