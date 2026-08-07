package com.pspdfkit.compose.theme;

import androidx.compose.ui.graphics.Color;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.pspdfkit.internal.r;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010#\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b$\u0010\u0014J\u0010\u0010%\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b&\u0010\u0014J\u0010\u0010'\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b(\u0010\u0014J\u0010\u0010)\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b*\u0010\u0014J\u0010\u0010+\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b,\u0010\u0014J\u0010\u0010-\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b.\u0010\u0014J\u0010\u0010/\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b0\u0010\u0014J\u0010\u00101\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b2\u0010\u0014J\u0010\u00103\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b4\u0010\u0014J\u0010\u00105\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b6\u0010\u0014J\u0010\u00107\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b8\u0010\u0014J\u0010\u00109\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b:\u0010\u0014J\u0010\u0010;\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b<\u0010\u0014J\u0010\u0010=\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b>\u0010\u0014J\u009c\u0001\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0003HÆ\u0001¢\u0006\u0004\b@\u0010AJ\u0014\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010E\u001a\u00020FHÖ\u0081\u0004J\n\u0010G\u001a\u00020HHÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0005\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0006\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\u0007\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001a\u0010\u0014R\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\n\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\r\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u001f\u0010\u0014R\u0013\u0010\u000e\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b \u0010\u0014R\u0013\u0010\u000f\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b!\u0010\u0014R\u0013\u0010\u0010\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\"\u0010\u0014¨\u0006I"}, d2 = {"Lcom/pspdfkit/compose/theme/AiAssistantColorScheme;", "", "containerColor", "Landroidx/compose/ui/graphics/Color;", "chatBackground", "mineChatBackground", "mineChatTextColor", "innerChatBackground", "innerChatTextColor", "textFieldBackgroundColor", "textFieldTextColor", "textFieldHintColor", "retryButtonBackgroundColor", "toolbarTextColor", "textColor", "iconColor", "submitButtonEnabledColor", "<init>", "(JJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getContainerColor-0d7_KjU", "()J", "J", "getChatBackground-0d7_KjU", "getMineChatBackground-0d7_KjU", "getMineChatTextColor-0d7_KjU", "getInnerChatBackground-0d7_KjU", "getInnerChatTextColor-0d7_KjU", "getTextFieldBackgroundColor-0d7_KjU", "getTextFieldTextColor-0d7_KjU", "getTextFieldHintColor-0d7_KjU", "getRetryButtonBackgroundColor-0d7_KjU", "getToolbarTextColor-0d7_KjU", "getTextColor-0d7_KjU", "getIconColor-0d7_KjU", "getSubmitButtonEnabledColor-0d7_KjU", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component3-0d7_KjU", "component4", "component4-0d7_KjU", "component5", "component5-0d7_KjU", "component6", "component6-0d7_KjU", "component7", "component7-0d7_KjU", "component8", "component8-0d7_KjU", "component9", "component9-0d7_KjU", "component10", "component10-0d7_KjU", "component11", "component11-0d7_KjU", "component12", "component12-0d7_KjU", "component13", "component13-0d7_KjU", "component14", "component14-0d7_KjU", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "copy-dVHXu7A", "(JJJJJJJJJJJJJJ)Lcom/pspdfkit/compose/theme/AiAssistantColorScheme;", "equals", "", "other", "hashCode", "", "toString", "", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class AiAssistantColorScheme {
    public static final int $stable = 0;
    private final long chatBackground;
    private final long containerColor;
    private final long iconColor;
    private final long innerChatBackground;
    private final long innerChatTextColor;
    private final long mineChatBackground;
    private final long mineChatTextColor;
    private final long retryButtonBackgroundColor;
    private final long submitButtonEnabledColor;
    private final long textColor;
    private final long textFieldBackgroundColor;
    private final long textFieldHintColor;
    private final long textFieldTextColor;
    private final long toolbarTextColor;

    public /* synthetic */ AiAssistantColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14);
    }

    /* JADX INFO: renamed from: copy-dVHXu7A$default, reason: not valid java name */
    public static /* synthetic */ AiAssistantColorScheme m13889copydVHXu7A$default(AiAssistantColorScheme aiAssistantColorScheme, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, int i, Object obj) {
        long j15;
        long j16;
        long j17 = (i & 1) != 0 ? aiAssistantColorScheme.containerColor : j;
        long j18 = (i & 2) != 0 ? aiAssistantColorScheme.chatBackground : j2;
        long j19 = (i & 4) != 0 ? aiAssistantColorScheme.mineChatBackground : j3;
        long j20 = (i & 8) != 0 ? aiAssistantColorScheme.mineChatTextColor : j4;
        long j21 = (i & 16) != 0 ? aiAssistantColorScheme.innerChatBackground : j5;
        long j22 = (i & 32) != 0 ? aiAssistantColorScheme.innerChatTextColor : j6;
        long j23 = (i & 64) != 0 ? aiAssistantColorScheme.textFieldBackgroundColor : j7;
        long j24 = j17;
        long j25 = (i & 128) != 0 ? aiAssistantColorScheme.textFieldTextColor : j8;
        long j26 = (i & 256) != 0 ? aiAssistantColorScheme.textFieldHintColor : j9;
        long j27 = (i & 512) != 0 ? aiAssistantColorScheme.retryButtonBackgroundColor : j10;
        long j28 = (i & 1024) != 0 ? aiAssistantColorScheme.toolbarTextColor : j11;
        long j29 = (i & 2048) != 0 ? aiAssistantColorScheme.textColor : j12;
        long j30 = (i & 4096) != 0 ? aiAssistantColorScheme.iconColor : j13;
        if ((i & 8192) != 0) {
            j16 = j30;
            j15 = aiAssistantColorScheme.submitButtonEnabledColor;
        } else {
            j15 = j14;
            j16 = j30;
        }
        return aiAssistantColorScheme.m13904copydVHXu7A(j24, j18, j19, j20, j21, j22, j23, j25, j26, j27, j28, j29, j16, j15);
    }

    /* JADX INFO: renamed from: component1-0d7_KjU, reason: not valid java name and from getter */
    public final long getContainerColor() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: component10-0d7_KjU, reason: not valid java name and from getter */
    public final long getRetryButtonBackgroundColor() {
        return this.retryButtonBackgroundColor;
    }

    /* JADX INFO: renamed from: component11-0d7_KjU, reason: not valid java name and from getter */
    public final long getToolbarTextColor() {
        return this.toolbarTextColor;
    }

    /* JADX INFO: renamed from: component12-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextColor() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: component13-0d7_KjU, reason: not valid java name and from getter */
    public final long getIconColor() {
        return this.iconColor;
    }

    /* JADX INFO: renamed from: component14-0d7_KjU, reason: not valid java name and from getter */
    public final long getSubmitButtonEnabledColor() {
        return this.submitButtonEnabledColor;
    }

    /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name and from getter */
    public final long getChatBackground() {
        return this.chatBackground;
    }

    /* JADX INFO: renamed from: component3-0d7_KjU, reason: not valid java name and from getter */
    public final long getMineChatBackground() {
        return this.mineChatBackground;
    }

    /* JADX INFO: renamed from: component4-0d7_KjU, reason: not valid java name and from getter */
    public final long getMineChatTextColor() {
        return this.mineChatTextColor;
    }

    /* JADX INFO: renamed from: component5-0d7_KjU, reason: not valid java name and from getter */
    public final long getInnerChatBackground() {
        return this.innerChatBackground;
    }

    /* JADX INFO: renamed from: component6-0d7_KjU, reason: not valid java name and from getter */
    public final long getInnerChatTextColor() {
        return this.innerChatTextColor;
    }

    /* JADX INFO: renamed from: component7-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldBackgroundColor() {
        return this.textFieldBackgroundColor;
    }

    /* JADX INFO: renamed from: component8-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldTextColor() {
        return this.textFieldTextColor;
    }

    /* JADX INFO: renamed from: component9-0d7_KjU, reason: not valid java name and from getter */
    public final long getTextFieldHintColor() {
        return this.textFieldHintColor;
    }

    /* JADX INFO: renamed from: copy-dVHXu7A, reason: not valid java name */
    public final AiAssistantColorScheme m13904copydVHXu7A(long containerColor, long chatBackground, long mineChatBackground, long mineChatTextColor, long innerChatBackground, long innerChatTextColor, long textFieldBackgroundColor, long textFieldTextColor, long textFieldHintColor, long retryButtonBackgroundColor, long toolbarTextColor, long textColor, long iconColor, long submitButtonEnabledColor) {
        return new AiAssistantColorScheme(containerColor, chatBackground, mineChatBackground, mineChatTextColor, innerChatBackground, innerChatTextColor, textFieldBackgroundColor, textFieldTextColor, textFieldHintColor, retryButtonBackgroundColor, toolbarTextColor, textColor, iconColor, submitButtonEnabledColor, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AiAssistantColorScheme)) {
            return false;
        }
        AiAssistantColorScheme aiAssistantColorScheme = (AiAssistantColorScheme) other;
        return Color.m6815equalsimpl0(this.containerColor, aiAssistantColorScheme.containerColor) && Color.m6815equalsimpl0(this.chatBackground, aiAssistantColorScheme.chatBackground) && Color.m6815equalsimpl0(this.mineChatBackground, aiAssistantColorScheme.mineChatBackground) && Color.m6815equalsimpl0(this.mineChatTextColor, aiAssistantColorScheme.mineChatTextColor) && Color.m6815equalsimpl0(this.innerChatBackground, aiAssistantColorScheme.innerChatBackground) && Color.m6815equalsimpl0(this.innerChatTextColor, aiAssistantColorScheme.innerChatTextColor) && Color.m6815equalsimpl0(this.textFieldBackgroundColor, aiAssistantColorScheme.textFieldBackgroundColor) && Color.m6815equalsimpl0(this.textFieldTextColor, aiAssistantColorScheme.textFieldTextColor) && Color.m6815equalsimpl0(this.textFieldHintColor, aiAssistantColorScheme.textFieldHintColor) && Color.m6815equalsimpl0(this.retryButtonBackgroundColor, aiAssistantColorScheme.retryButtonBackgroundColor) && Color.m6815equalsimpl0(this.toolbarTextColor, aiAssistantColorScheme.toolbarTextColor) && Color.m6815equalsimpl0(this.textColor, aiAssistantColorScheme.textColor) && Color.m6815equalsimpl0(this.iconColor, aiAssistantColorScheme.iconColor) && Color.m6815equalsimpl0(this.submitButtonEnabledColor, aiAssistantColorScheme.submitButtonEnabledColor);
    }

    /* JADX INFO: renamed from: getChatBackground-0d7_KjU, reason: not valid java name */
    public final long m13905getChatBackground0d7_KjU() {
        return this.chatBackground;
    }

    /* JADX INFO: renamed from: getContainerColor-0d7_KjU, reason: not valid java name */
    public final long m13906getContainerColor0d7_KjU() {
        return this.containerColor;
    }

    /* JADX INFO: renamed from: getIconColor-0d7_KjU, reason: not valid java name */
    public final long m13907getIconColor0d7_KjU() {
        return this.iconColor;
    }

    /* JADX INFO: renamed from: getInnerChatBackground-0d7_KjU, reason: not valid java name */
    public final long m13908getInnerChatBackground0d7_KjU() {
        return this.innerChatBackground;
    }

    /* JADX INFO: renamed from: getInnerChatTextColor-0d7_KjU, reason: not valid java name */
    public final long m13909getInnerChatTextColor0d7_KjU() {
        return this.innerChatTextColor;
    }

    /* JADX INFO: renamed from: getMineChatBackground-0d7_KjU, reason: not valid java name */
    public final long m13910getMineChatBackground0d7_KjU() {
        return this.mineChatBackground;
    }

    /* JADX INFO: renamed from: getMineChatTextColor-0d7_KjU, reason: not valid java name */
    public final long m13911getMineChatTextColor0d7_KjU() {
        return this.mineChatTextColor;
    }

    /* JADX INFO: renamed from: getRetryButtonBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m13912getRetryButtonBackgroundColor0d7_KjU() {
        return this.retryButtonBackgroundColor;
    }

    /* JADX INFO: renamed from: getSubmitButtonEnabledColor-0d7_KjU, reason: not valid java name */
    public final long m13913getSubmitButtonEnabledColor0d7_KjU() {
        return this.submitButtonEnabledColor;
    }

    /* JADX INFO: renamed from: getTextColor-0d7_KjU, reason: not valid java name */
    public final long m13914getTextColor0d7_KjU() {
        return this.textColor;
    }

    /* JADX INFO: renamed from: getTextFieldBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m13915getTextFieldBackgroundColor0d7_KjU() {
        return this.textFieldBackgroundColor;
    }

    /* JADX INFO: renamed from: getTextFieldHintColor-0d7_KjU, reason: not valid java name */
    public final long m13916getTextFieldHintColor0d7_KjU() {
        return this.textFieldHintColor;
    }

    /* JADX INFO: renamed from: getTextFieldTextColor-0d7_KjU, reason: not valid java name */
    public final long m13917getTextFieldTextColor0d7_KjU() {
        return this.textFieldTextColor;
    }

    /* JADX INFO: renamed from: getToolbarTextColor-0d7_KjU, reason: not valid java name */
    public final long m13918getToolbarTextColor0d7_KjU() {
        return this.toolbarTextColor;
    }

    public int hashCode() {
        return Color.m6821hashCodeimpl(this.submitButtonEnabledColor) + r.a(this.iconColor, r.a(this.textColor, r.a(this.toolbarTextColor, r.a(this.retryButtonBackgroundColor, r.a(this.textFieldHintColor, r.a(this.textFieldTextColor, r.a(this.textFieldBackgroundColor, r.a(this.innerChatTextColor, r.a(this.innerChatBackground, r.a(this.mineChatTextColor, r.a(this.mineChatBackground, r.a(this.chatBackground, Color.m6821hashCodeimpl(this.containerColor) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        return "AiAssistantColorScheme(containerColor=" + Color.m6822toStringimpl(this.containerColor) + ", chatBackground=" + Color.m6822toStringimpl(this.chatBackground) + ", mineChatBackground=" + Color.m6822toStringimpl(this.mineChatBackground) + ", mineChatTextColor=" + Color.m6822toStringimpl(this.mineChatTextColor) + ", innerChatBackground=" + Color.m6822toStringimpl(this.innerChatBackground) + ", innerChatTextColor=" + Color.m6822toStringimpl(this.innerChatTextColor) + ", textFieldBackgroundColor=" + Color.m6822toStringimpl(this.textFieldBackgroundColor) + ", textFieldTextColor=" + Color.m6822toStringimpl(this.textFieldTextColor) + ", textFieldHintColor=" + Color.m6822toStringimpl(this.textFieldHintColor) + ", retryButtonBackgroundColor=" + Color.m6822toStringimpl(this.retryButtonBackgroundColor) + ", toolbarTextColor=" + Color.m6822toStringimpl(this.toolbarTextColor) + ", textColor=" + Color.m6822toStringimpl(this.textColor) + ", iconColor=" + Color.m6822toStringimpl(this.iconColor) + ", submitButtonEnabledColor=" + Color.m6822toStringimpl(this.submitButtonEnabledColor) + ")";
    }

    private AiAssistantColorScheme(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14) {
        this.containerColor = j;
        this.chatBackground = j2;
        this.mineChatBackground = j3;
        this.mineChatTextColor = j4;
        this.innerChatBackground = j5;
        this.innerChatTextColor = j6;
        this.textFieldBackgroundColor = j7;
        this.textFieldTextColor = j8;
        this.textFieldHintColor = j9;
        this.retryButtonBackgroundColor = j10;
        this.toolbarTextColor = j11;
        this.textColor = j12;
        this.iconColor = j13;
        this.submitButtonEnabledColor = j14;
    }
}
