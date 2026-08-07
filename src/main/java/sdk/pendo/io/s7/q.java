package sdk.pendo.io.s7;

import android.app.Activity;
import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0007J\"\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/s7/q;", "", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/app/Activity;", "currentActivity", "Lcom/google/android/play/core/review/ReviewManager;", "manager", "Lcom/google/android/play/core/review/ReviewInfo;", "reviewInfo", "Landroid/content/Context;", "context", "", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class q {
    public static final q a = new q();

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/s7/q$a;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/android/gms/tasks/OnCompleteListener;", "Lcom/google/android/gms/tasks/Task;", "task", "", "onComplete", "Lcom/google/android/play/core/review/ReviewManager;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Lcom/google/android/play/core/review/ReviewManager;", "getManager", "()Lcom/google/android/play/core/review/ReviewManager;", "manager", "<init>", "(Lcom/google/android/play/core/review/ReviewManager;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class a<T> implements OnCompleteListener<T> {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        private final ReviewManager manager;

        /* JADX INFO: renamed from: sdk.pendo.io.s7.q$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/t4/a;", "kotlin.jvm.PlatformType", "it", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "(Lsdk/pendo/io/t4/a;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
        static final class C0483a extends Lambda implements Function1<sdk.pendo.io.t4.a, Boolean> {
            final /* synthetic */ Activity a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0483a(Activity activity) {
                super(1);
                this.a = activity;
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(sdk.pendo.io.t4.a aVar) {
                return Boolean.valueOf(!Intrinsics.areEqual(this.a, sdk.pendo.io.d6.c.h().a()));
            }
        }

        public a(ReviewManager manager) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            this.manager = manager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean a(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return ((Boolean) tmp0.invoke(obj)).booleanValue();
        }

        @Override // com.google.android.gms.tasks.OnCompleteListener
        public void onComplete(Task<T> task) {
            Intrinsics.checkNotNullParameter(task, "task");
            if (!task.isSuccessful()) {
                PendoLogger.w("GoogleApiUtils Could not display in-app rating dialog. Make sure the user has Google Play Store app installed, and a logged in Google account", new Object[0]);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("GoogleApiUtils In App Rating error in task: %s", Arrays.copyOf(new Object[]{task.getException()}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                PendoLogger.w(str, new Object[0]);
                return;
            }
            T result = task.getResult();
            Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.google.android.play.core.review.ReviewInfo");
            final ReviewInfo reviewInfo = (ReviewInfo) result;
            Activity activityA = sdk.pendo.io.d6.c.h().a();
            PendoLogger.d("GoogleApiUtils in app rating: current activity is: " + (activityA != null ? activityA.getClass().getSimpleName() : null), new Object[0]);
            if (activityA == null || !(activityA instanceof PendoGuideVisualActivity)) {
                q.a.a(activityA, this.manager, reviewInfo);
                return;
            }
            sdk.pendo.io.k3.j<sdk.pendo.io.t4.a> jVarE = sdk.pendo.io.d6.c.h().e();
            final C0483a c0483a = new C0483a(activityA);
            jVarE.a(new sdk.pendo.io.q3.j() { // from class: sdk.pendo.io.s7.q$a$$ExternalSyntheticLambda0
                @Override // sdk.pendo.io.q3.j
                public final boolean test(Object obj) {
                    return q.a.a(c0483a, obj);
                }
            }).f().a(sdk.pendo.io.t6.c.a(new sdk.pendo.io.q3.e() { // from class: sdk.pendo.io.s7.q$a$$ExternalSyntheticLambda1
                @Override // sdk.pendo.io.q3.e
                public final void accept(Object obj) {
                    q.a.a(this.f$0, reviewInfo, (sdk.pendo.io.t4.a) obj);
                }
            }, "GoogleApiUtils observing the next onResume"));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(a this$0, ReviewInfo reviewInfo, sdk.pendo.io.t4.a aVar) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(reviewInfo, "$reviewInfo");
            q.a.a(sdk.pendo.io.d6.c.h().a(), this$0.manager, reviewInfo);
        }
    }

    private q() {
    }

    public final boolean a(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        int iIsGooglePlayServicesAvailable = GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context);
        if (iIsGooglePlayServicesAvailable == 0) {
            return true;
        }
        if (iIsGooglePlayServicesAvailable == 1) {
            str = "service missing";
        } else if (iIsGooglePlayServicesAvailable == 2) {
            str = "service version update required";
        } else if (iIsGooglePlayServicesAvailable != 3) {
            str = iIsGooglePlayServicesAvailable != 18 ? "service invalid" : "service updating";
        } else {
            str = "service disabled";
        }
        PendoLogger.w("GoogleApiUtils isGooglePlayServicesAvailable - ".concat(str), new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void a(Activity currentActivity, ReviewManager manager, ReviewInfo reviewInfo) {
        try {
            if (currentActivity == null) {
                PendoLogger.w("GoogleApiUtils In app rating - current activity is null. Will not display dialog", new Object[0]);
                return;
            }
            Task<Void> taskLaunchReviewFlow = manager.launchReviewFlow(currentActivity, reviewInfo);
            Intrinsics.checkNotNullExpressionValue(taskLaunchReviewFlow, "launchReviewFlow(...)");
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("GoogleApiUtils In app rating  - about to open the dialog. Passing in %s", Arrays.copyOf(new Object[]{currentActivity.getComponentName()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
            PendoLogger.d(str, new Object[0]);
            taskLaunchReviewFlow.addOnCompleteListener(new OnCompleteListener() { // from class: sdk.pendo.io.s7.q$$ExternalSyntheticLambda0
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    q.a(task);
                }
            });
            taskLaunchReviewFlow.addOnFailureListener(new OnFailureListener() { // from class: sdk.pendo.io.s7.q$$ExternalSyntheticLambda1
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    q.a(exc);
                }
            });
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Task it) {
        Intrinsics.checkNotNullParameter(it, "it");
        PendoLogger.d("GoogleApiUtils Finished the in app rating task", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Exception ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("Make sure the user has Google Play Store app installed, and a logged in Google account. Reason: %s", Arrays.copyOf(new Object[]{ex.getMessage()}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        PendoLogger.i("GoogleApiUtils Could not display in-app rating dialog. " + str, new Object[0]);
    }

    @JvmStatic
    public static final void a() {
        q qVar = a;
        Context contextO = PendoInternal.o();
        Intrinsics.checkNotNullExpressionValue(contextO, "getApplicationContext(...)");
        if (qVar.a(contextO)) {
            try {
                ReviewManager reviewManagerCreate = ReviewManagerFactory.create(PendoInternal.o());
                Intrinsics.checkNotNullExpressionValue(reviewManagerCreate, "create(...)");
                Task<ReviewInfo> taskRequestReviewFlow = reviewManagerCreate.requestReviewFlow();
                Intrinsics.checkNotNullExpressionValue(taskRequestReviewFlow, "requestReviewFlow(...)");
                taskRequestReviewFlow.addOnCompleteListener(new a(reviewManagerCreate));
            } catch (Exception e) {
                PendoLogger.i("GoogleApiUtils Could not display in-app rating dialog. Make sure the user has Google Play Store app installed, and a logged in Google account", new Object[0]);
                PendoLogger.e(e, "GoogleApiUtils In app rating error: " + e.getMessage(), new Object[0]);
            }
        }
    }
}
