package com.box.android.boxai;

import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.analytics.BoxAnalyticsParams;
import com.box.android.domain.mappers.FileModelMapper;
import com.box.android.domain.models.item.FileModel;
import java.util.List;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiAnalytics.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\tJ\u0014\u0010\f\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0014\u0010\r\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0014\u0010\u000e\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0014\u0010\u000f\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0014\u0010\u0010\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001c\u0010\u0011\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0014\u0010\u0014\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u001e\u0010\u0015\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u001e\u0010\u0017\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0013J\u001e\u0010\u0018\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00192\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¨\u0006\u001b"}, d2 = {"Lcom/box/android/boxai/BoxAiAnalytics;", "", "<init>", "()V", "boxAiHomeScreenViewed", "", "boxAiLaunchedFromMultiselect", "fileModels", "", "Lcom/box/android/domain/models/item/FileModel;", "boxAiLaunchedFromQuickAction", "fileModel", "promptSubmitted", "answerReceived", "copyResponseClicked", "retryButtonClicked", "microphoneButtonClicked", "suggestedQuestionClicked", "question", "", "clearChatClicked", "positiveFeedbackSubmitted", "agentId", "negativeFeedbackSubmitted", "aiEventBuilder", "Lcom/box/android/domain/analytics/BoxAmplitudeAnalytics$BoxAiEventPropertyBuilder;", "kotlin.jvm.PlatformType", "boxai_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxAiAnalytics {
    public static final int $stable = 0;

    @Inject
    public BoxAiAnalytics() {
    }

    public final void boxAiHomeScreenViewed() {
        BoxAmplitudeAnalytics.createEventBuilder().logEvent(BoxAnalyticsParams.EVENT_BOX_AI_SCREEN_VIEWED);
    }

    public final void boxAiLaunchedFromMultiselect(List<FileModel> fileModels) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        aiEventBuilder(fileModels).logEvent(BoxAnalyticsParams.EVENT_MULTISELECT_BOX_AI_BUTTON_CLICKED);
    }

    public final void boxAiLaunchedFromQuickAction(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        aiEventBuilder(CollectionsKt.listOf(fileModel)).logEvent(BoxAnalyticsParams.EVENT_QUICK_ACTION_BOX_AI_BUTTON_CLICKED);
    }

    public final void promptSubmitted(List<FileModel> fileModels) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        aiEventBuilder(fileModels).logEvent(BoxAnalyticsParams.EVENT_PROMPT_SUBMITTED);
    }

    public final void answerReceived(List<FileModel> fileModels) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        aiEventBuilder(fileModels).logEvent(BoxAnalyticsParams.EVENT_ANSWER_RECEIVED);
    }

    public final void copyResponseClicked(List<FileModel> fileModels) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        aiEventBuilder(fileModels).logEvent(BoxAnalyticsParams.EVENT_COPY_RESPONSE_CLICKED);
    }

    public final void retryButtonClicked(List<FileModel> fileModels) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        aiEventBuilder(fileModels).logEvent(BoxAnalyticsParams.EVENT_RETRY_BUTTON_CLICKED);
    }

    public final void microphoneButtonClicked(List<FileModel> fileModels) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        aiEventBuilder(fileModels).logEvent(BoxAnalyticsParams.EVENT_MICROPHONE_BUTTON_CLICKED);
    }

    public final void suggestedQuestionClicked(List<FileModel> fileModels, String question) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        Intrinsics.checkNotNullParameter(question, "question");
        aiEventBuilder(fileModels).setCtaText(question).logEvent(BoxAnalyticsParams.EVENT_SUGGESTED_QUESTION_CLICKED);
    }

    public final void clearChatClicked(List<FileModel> fileModels) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        aiEventBuilder(fileModels).logEvent(BoxAnalyticsParams.EVENT_CLEAR_CHAT_CLICKED);
    }

    public final void positiveFeedbackSubmitted(List<FileModel> fileModels, String agentId) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        aiEventBuilder(fileModels).setAgentId(agentId).logEvent(BoxAnalyticsParams.EVENT_POSITIVE_FEEDBACK_CLICKED);
    }

    public final void negativeFeedbackSubmitted(List<FileModel> fileModels, String agentId) {
        Intrinsics.checkNotNullParameter(fileModels, "fileModels");
        aiEventBuilder(fileModels).setAgentId(agentId).logEvent(BoxAnalyticsParams.EVENT_NEGATIVE_FEEDBACK_CLICKED);
    }

    private final BoxAmplitudeAnalytics.BoxAiEventPropertyBuilder aiEventBuilder(List<FileModel> fileModels) {
        BoxAmplitudeAnalytics.BoxAiEventPropertyBuilder boxAiEventPropertyBuilderCreateBoxAiEventPropertyBuilder = BoxAmplitudeAnalytics.createBoxAiEventPropertyBuilder();
        boolean z = fileModels.size() != 1;
        List<FileModel> list = fileModels;
        boxAiEventPropertyBuilderCreateBoxAiEventPropertyBuilder.setFileIds(CollectionsKt.joinToString$default(list, ",", null, null, 0, null, new Function1() { // from class: com.box.android.boxai.BoxAiAnalytics$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxAiAnalytics.aiEventBuilder$lambda$0$0((FileModel) obj);
            }
        }, 30, null));
        boxAiEventPropertyBuilderCreateBoxAiEventPropertyBuilder.setFileExtensions(CollectionsKt.joinToString$default(list, ",", null, null, 0, null, new Function1() { // from class: com.box.android.boxai.BoxAiAnalytics$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxAiAnalytics.aiEventBuilder$lambda$0$1((FileModel) obj);
            }
        }, 30, null));
        boxAiEventPropertyBuilderCreateBoxAiEventPropertyBuilder.setFileTypes(CollectionsKt.joinToString$default(list, ",", null, null, 0, null, new Function1() { // from class: com.box.android.boxai.BoxAiAnalytics$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BoxAiAnalytics.aiEventBuilder$lambda$0$2((FileModel) obj);
            }
        }, 30, null));
        boxAiEventPropertyBuilderCreateBoxAiEventPropertyBuilder.setIsMultidoc(z);
        if (!z) {
            boxAiEventPropertyBuilderCreateBoxAiEventPropertyBuilder.setBoxItem(FileModelMapper.toBoxFile$default(FileModelMapper.INSTANCE, (FileModel) CollectionsKt.single((List) fileModels), false, 1, null));
        }
        return boxAiEventPropertyBuilderCreateBoxAiEventPropertyBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence aiEventBuilder$lambda$0$0(FileModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String strBoxIdOrNull = it.boxIdOrNull();
        return strBoxIdOrNull != null ? strBoxIdOrNull : it.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence aiEventBuilder$lambda$0$1(FileModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String lowerCase = it.getExtension().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence aiEventBuilder$lambda$0$2(FileModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        BoxAnalyticsParams boxAnalyticsParams = BoxAnalyticsParams.INSTANCE;
        String lowerCase = it.getExtension().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return boxAnalyticsParams.calculateFileType(lowerCase);
    }
}
