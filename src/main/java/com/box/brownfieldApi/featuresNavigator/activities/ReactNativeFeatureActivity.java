package com.box.brownfieldApi.featuresNavigator.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.box.brownfieldApi.featuresNavigator.FeatureModule;
import com.box.brownfieldApi.featuresNavigator.RecipientIdGeneratorKt;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactActivityDelegate;
import expo.modules.ReactActivityDelegateWrapper;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: ReactNativeFeatureActivity.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0014J\u0012\u0010\u0016\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0012H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/activities/ReactNativeFeatureActivity;", "Lcom/facebook/react/ReactActivity;", "<init>", "()V", "recipientId", "", "getRecipientId", "()Ljava/lang/String;", "resultJobs", "", "Lkotlinx/coroutines/Job;", "getFeatureModule", "Lcom/box/brownfieldApi/featuresNavigator/FeatureModule;", "getLaunchOptions", "Landroid/os/Bundle;", "intent", "Landroid/content/Intent;", "onResultEvent", "", SemanticAttributes.MessagingDestinationKindValues.TOPIC, ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "getMainComponentName", "onCreate", "savedInstanceState", "setupResultListeners", "prepareActivityDelegateLaunchOptions", "createReactActivityDelegate", "Lcom/facebook/react/ReactActivityDelegate;", "onDestroy", "Companion", "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ReactNativeFeatureActivity extends ReactActivity {
    public static final String RESULT_EXTRA_KEY = "result";
    private final String recipientId = RecipientIdGeneratorKt.generateRecipientId();
    private List<? extends Job> resultJobs = CollectionsKt.emptyList();
    public static final int $stable = 8;

    public abstract FeatureModule getFeatureModule();

    public void onResultEvent(String topic, String result) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(result, "result");
    }

    protected final String getRecipientId() {
        return this.recipientId;
    }

    public Bundle getLaunchOptions(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        return extras == null ? new Bundle() : extras;
    }

    @Override // com.facebook.react.ReactActivity
    protected String getMainComponentName() {
        return getFeatureModule().getModuleName();
    }

    @Override // com.facebook.react.ReactActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        super.onMAMCreate(null);
        setupResultListeners();
    }

    private final void setupResultListeners() {
        FeatureModule featureModule = getFeatureModule();
        if (featureModule.hasTopics()) {
            List<String> topics = featureModule.getTopics();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(topics, 10));
            Iterator<T> it = topics.iterator();
            while (it.hasNext()) {
                arrayList.add(BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ReactNativeFeatureActivity$setupResultListeners$1$1(this, (String) it.next(), null), 3, null));
            }
            this.resultJobs = arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle prepareActivityDelegateLaunchOptions() {
        FeatureModule featureModule = getFeatureModule();
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        Bundle launchOptions = getLaunchOptions(intent);
        if (featureModule.hasTopics()) {
            launchOptions.putString("recipientId", this.recipientId);
        }
        return launchOptions;
    }

    @Override // com.facebook.react.ReactActivity
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegateWrapper(this, DefaultNewArchitectureEntryPoint.getFabricEnabled(), new DefaultReactActivityDelegate(getMainComponentName(), DefaultNewArchitectureEntryPoint.getFabricEnabled()) { // from class: com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity.createReactActivityDelegate.1
            {
                ReactNativeFeatureActivity reactNativeFeatureActivity = ReactNativeFeatureActivity.this;
            }

            @Override // com.facebook.react.ReactActivityDelegate
            protected Bundle getLaunchOptions() {
                return ReactNativeFeatureActivity.this.prepareActivityDelegateLaunchOptions();
            }
        });
    }

    @Override // com.facebook.react.ReactActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMDestroy() {
        Iterator<T> it = this.resultJobs.iterator();
        while (it.hasNext()) {
            Job.DefaultImpls.cancel$default((Job) it.next(), (CancellationException) null, 1, (Object) null);
        }
        super.onMAMDestroy();
    }
}
