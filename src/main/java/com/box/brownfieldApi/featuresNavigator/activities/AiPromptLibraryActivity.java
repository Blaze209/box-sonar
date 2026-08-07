package com.box.brownfieldApi.featuresNavigator.activities;

import android.content.Intent;
import com.box.brownfieldApi.featuresNavigator.FeatureModule;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AiPromptLibraryActivity.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/box/brownfieldApi/featuresNavigator/activities/AiPromptLibraryActivity;", "Lcom/box/brownfieldApi/featuresNavigator/activities/ReactNativeFeatureActivity;", "<init>", "()V", "getFeatureModule", "Lcom/box/brownfieldApi/featuresNavigator/FeatureModule;", "onResultEvent", "", SemanticAttributes.MessagingDestinationKindValues.TOPIC, "", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "brownfieldApi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiPromptLibraryActivity extends ReactNativeFeatureActivity {
    public static final int $stable = 8;

    @Override // com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity
    public FeatureModule getFeatureModule() {
        return FeatureModule.AI_PROMPT_LIBRARY;
    }

    @Override // com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity
    public void onResultEvent(String topic, String result) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual(topic, "prompt_selected")) {
            Intent intent = new Intent();
            intent.putExtra(ReactNativeFeatureActivity.RESULT_EXTRA_KEY, result);
            setResult(-1, intent);
            finish();
            return;
        }
        if (Intrinsics.areEqual(topic, "prompt_cancelled")) {
            setResult(0);
            finish();
        }
    }
}
