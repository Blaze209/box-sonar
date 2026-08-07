package expo.modules.nativeelementsexpo.promptinput;

import android.content.Context;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt;
import com.box.android.observability.DiagnosisParams;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.viewevent.ViewEventDelegateKt;
import expo.modules.kotlin.views.ExpoView;
import expo.modules.nativeelementsexpo.promptinput.tag.EntityTag;
import expo.modules.nativeelementsexpo.promptinput.tag.TagInserter;
import expo.modules.nativeelementsexpo.promptinput.tag.TagSpan;
import expo.modules.nativeelementsexpo.promptinput.tag.TagType;
import expo.modules.nativeelementsexpo.promptinput.trackeditem.TrackedItemHandler;
import expo.modules.nativeelementsexpo.promptinput.trackeditem.TrackedItemTextWatcher;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: PromptInputView.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u001a\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u0083\u00012\u00020\u0001:\u0002\u0083\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010i\u001a\u00020jH\u0014J\u0018\u0010k\u001a\u00020j2\u0006\u0010l\u001a\u00020\u00152\u0006\u0010m\u001a\u00020\u0015H\u0002J\b\u0010n\u001a\u00020jH\u0002J\u0006\u0010o\u001a\u00020\tJ\u0006\u0010p\u001a\u00020\tJ\u0006\u0010q\u001a\u00020jJ\u000e\u0010r\u001a\u00020j2\u0006\u0010s\u001a\u00020\tJ \u0010t\u001a\u00020j2\u0006\u0010u\u001a\u00020\t2\u0006\u0010v\u001a\u00020\t2\b\u0010w\u001a\u0004\u0018\u00010xJ&\u0010y\u001a\u00020j2\u0006\u0010u\u001a\u00020\t2\u0006\u0010v\u001a\u00020\t2\u0006\u0010w\u001a\u00020\t2\u0006\u0010z\u001a\u00020\tJ\u000e\u0010{\u001a\u00020j2\u0006\u0010z\u001a\u00020\tJ\b\u0010|\u001a\u00020jH\u0002J\b\u0010}\u001a\u00020jH\u0002J\u0006\u0010~\u001a\u00020jJ\b\u0010\u007f\u001a\u00020jH\u0002J\t\u0010\u0080\u0001\u001a\u00020jH\u0002J\t\u0010\u0081\u0001\u001a\u00020jH\u0002J\t\u0010\u0082\u0001\u001a\u00020\u000fH\u0002R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u0015@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00158\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR&\u0010\u001e\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00158\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR&\u0010!\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00158\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR&\u0010$\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00158\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR&\u0010'\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00158\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR&\u0010*\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00158\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR0\u0010/\u001a\b\u0012\u0004\u0012\u00020.0-2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020.0-@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R0\u00104\u001a\b\u0012\u0004\u0012\u00020\t0-2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0-@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R-\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:09088FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b;\u0010<R-\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:09088FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u0010>\u001a\u0004\b@\u0010<R-\u0010B\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:09088FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u0010>\u001a\u0004\bC\u0010<R-\u0010E\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:09088FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u0010>\u001a\u0004\bF\u0010<R-\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:09088FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bJ\u0010>\u001a\u0004\bI\u0010<R-\u0010K\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:09088FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bM\u0010>\u001a\u0004\bL\u0010<R-\u0010N\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:09088FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010>\u001a\u0004\bO\u0010<R-\u0010Q\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020:09088FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bS\u0010>\u001a\u0004\bR\u0010<R\u000e\u0010T\u001a\u00020UX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010X\u001a\u00020YX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010[\u001a\u00020\\¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u0011\u0010_\u001a\u00020`¢\u0006\b\n\u0000\u001a\u0004\ba\u0010bR\u0011\u0010c\u001a\u00020d¢\u0006\b\n\u0000\u001a\u0004\be\u0010fR\u000e\u0010g\u001a\u00020hX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0084\u0001"}, d2 = {"Lexpo/modules/nativeelementsexpo/promptinput/PromptInputView;", "Lexpo/modules/kotlin/views/ExpoView;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "value", "", ReactTextInputShadowNode.PROP_PLACEHOLDER, "getPlaceholder", "()Ljava/lang/String;", "setPlaceholder", "(Ljava/lang/String;)V", "", "disabled", "getDisabled", "()Z", "setDisabled", "(Z)V", "", ViewProps.MAX_HEIGHT, "getMaxHeight", "()I", "setMaxHeight", "(I)V", "tokenBackgroundColor", "getTokenBackgroundColor", "setTokenBackgroundColor", "tokenTextColor", "getTokenTextColor", "setTokenTextColor", "pendingTokenBackgroundColor", "getPendingTokenBackgroundColor", "setPendingTokenBackgroundColor", "pendingTokenTextColor", "getPendingTokenTextColor", "setPendingTokenTextColor", "textColor", "getTextColor", "setTextColor", "placeholderColor", "getPlaceholderColor", "setPlaceholderColor", "", "Lexpo/modules/nativeelementsexpo/promptinput/TriggerConfig;", "triggerConfigs", "getTriggerConfigs", "()Ljava/util/List;", "setTriggerConfigs", "(Ljava/util/List;)V", "trackedItems", "getTrackedItems", "setTrackedItems", "onSubmit", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "", "", "getOnSubmit", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onSubmit$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "onHeightChange", "getOnHeightChange", "onHeightChange$delegate", "onDirtyChange", "getOnDirtyChange", "onDirtyChange$delegate", "onFocusChange", "getOnFocusChange", "onFocusChange$delegate", "onMentionShow", "getOnMentionShow", "onMentionShow$delegate", "onMentionHide", "getOnMentionHide", "onMentionHide$delegate", "onMentionFilter", "getOnMentionFilter", "onMentionFilter$delegate", "onItemTracked", "getOnItemTracked", "onItemTracked$delegate", "lastReportedHeight", "", "lastReportedDirty", "suppressFocusOnAttach", "density", "", "isProgrammaticChange", "tagInserter", "Lexpo/modules/nativeelementsexpo/promptinput/tag/TagInserter;", "getTagInserter", "()Lexpo/modules/nativeelementsexpo/promptinput/tag/TagInserter;", "triggerHandler", "Lexpo/modules/nativeelementsexpo/promptinput/TriggerStringHandler;", "getTriggerHandler", "()Lexpo/modules/nativeelementsexpo/promptinput/TriggerStringHandler;", "trackedItemHandler", "Lexpo/modules/nativeelementsexpo/promptinput/trackeditem/TrackedItemHandler;", "getTrackedItemHandler", "()Lexpo/modules/nativeelementsexpo/promptinput/trackeditem/TrackedItemHandler;", "editText", "Lexpo/modules/nativeelementsexpo/promptinput/MentionEditText;", "onAttachedToWindow", "", "applyPendingStyleNow", "start", "end", "removePendingStyleNow", "getValue", "getPlainText", DiagnosisParams.CLEAR_ON_LOGOUT, "setText", "text", "insertMention", "id", "name", "type", "Lexpo/modules/nativeelementsexpo/promptinput/tag/TagType;", "insertItem", "uuid", "cancelTrackedItem", "calculateAndReportHeight", "scrollToCursor", "blur", "reportDirtyChange", "updateExistingTagSpans", "updateExistingPendingSpans", "getIsDirty", "Companion", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PromptInputView extends ExpoView {
    private static final int DEFAULT_PENDING_TOKEN_BACKGROUND_COLOR = -330242;
    private static final int DEFAULT_PENDING_TOKEN_TEXT_COLOR = -14540254;
    private static final int DEFAULT_TOKEN_BACKGROUND_COLOR = -330242;
    private static final int DEFAULT_TOKEN_TEXT_COLOR = -6275091;
    private static final String LOG_TAG = "PromptInputView";
    private static final int TEXT_COLOR_HINT = -9474193;
    private static final int TEXT_COLOR_PRIMARY = -14540254;
    private final float density;
    private boolean disabled;
    private final MentionEditText editText;
    private boolean isProgrammaticChange;
    private boolean lastReportedDirty;
    private double lastReportedHeight;
    private int maxHeight;

    /* JADX INFO: renamed from: onDirtyChange$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onDirtyChange;

    /* JADX INFO: renamed from: onFocusChange$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onFocusChange;

    /* JADX INFO: renamed from: onHeightChange$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onHeightChange;

    /* JADX INFO: renamed from: onItemTracked$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onItemTracked;

    /* JADX INFO: renamed from: onMentionFilter$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onMentionFilter;

    /* JADX INFO: renamed from: onMentionHide$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onMentionHide;

    /* JADX INFO: renamed from: onMentionShow$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onMentionShow;

    /* JADX INFO: renamed from: onSubmit$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onSubmit;
    private int pendingTokenBackgroundColor;
    private int pendingTokenTextColor;
    private String placeholder;
    private int placeholderColor;
    private boolean suppressFocusOnAttach;
    private final TagInserter tagInserter;
    private int textColor;
    private int tokenBackgroundColor;
    private int tokenTextColor;
    private final TrackedItemHandler trackedItemHandler;
    private List<String> trackedItems;
    private List<TriggerConfig> triggerConfigs;
    private final TriggerStringHandler triggerHandler;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(PromptInputView.class, "onSubmit", "getOnSubmit()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(PromptInputView.class, "onHeightChange", "getOnHeightChange()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(PromptInputView.class, "onDirtyChange", "getOnDirtyChange()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(PromptInputView.class, "onFocusChange", "getOnFocusChange()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(PromptInputView.class, "onMentionShow", "getOnMentionShow()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(PromptInputView.class, "onMentionHide", "getOnMentionHide()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(PromptInputView.class, "onMentionFilter", "getOnMentionFilter()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(PromptInputView.class, "onItemTracked", "getOnItemTracked()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromptInputView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.placeholder = "";
        this.maxHeight = 200;
        this.tokenBackgroundColor = -330242;
        this.tokenTextColor = DEFAULT_TOKEN_TEXT_COLOR;
        this.pendingTokenBackgroundColor = -330242;
        this.pendingTokenTextColor = -14540254;
        this.textColor = -14540254;
        this.placeholderColor = TEXT_COLOR_HINT;
        this.triggerConfigs = CollectionsKt.listOf(new TriggerConfig(CommentBarInputBoxKt.MENTION_SYMBOL, 0, 2, null));
        this.trackedItems = CollectionsKt.emptyList();
        PromptInputView promptInputView = this;
        this.onSubmit = ViewEventDelegateKt.MapEventDispatcher$default(promptInputView, null, 1, null);
        this.onHeightChange = ViewEventDelegateKt.MapEventDispatcher$default(promptInputView, null, 1, null);
        this.onDirtyChange = ViewEventDelegateKt.MapEventDispatcher$default(promptInputView, null, 1, null);
        this.onFocusChange = ViewEventDelegateKt.MapEventDispatcher$default(promptInputView, null, 1, null);
        this.onMentionShow = ViewEventDelegateKt.MapEventDispatcher$default(promptInputView, null, 1, null);
        this.onMentionHide = ViewEventDelegateKt.MapEventDispatcher$default(promptInputView, null, 1, null);
        this.onMentionFilter = ViewEventDelegateKt.MapEventDispatcher$default(promptInputView, null, 1, null);
        this.onItemTracked = ViewEventDelegateKt.MapEventDispatcher$default(promptInputView, null, 1, null);
        float f = context.getResources().getDisplayMetrics().density;
        this.density = f;
        TagInserter tagInserter = new TagInserter(context);
        this.tagInserter = tagInserter;
        TriggerStringHandler triggerStringHandler = new TriggerStringHandler(this.tokenBackgroundColor, this.pendingTokenBackgroundColor, this.tokenTextColor, this.pendingTokenTextColor, tagInserter);
        this.triggerHandler = triggerStringHandler;
        this.trackedItemHandler = new TrackedItemHandler(tagInserter);
        final MentionEditText mentionEditText = new MentionEditText(context);
        mentionEditText.setBackground(null);
        mentionEditText.setTextSize(2, 16.0f);
        int i = (int) (4 * f);
        int i2 = (int) (8 * f);
        mentionEditText.setPaddingRelative(i, i2, i, i2);
        mentionEditText.setImeOptions(4);
        mentionEditText.setInputType(147457);
        mentionEditText.setIncludeFontPadding(false);
        mentionEditText.setHintTextColor(TEXT_COLOR_HINT);
        mentionEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$$ExternalSyntheticLambda8
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
                return PromptInputView.editText$lambda$7$lambda$1(this.f$0, textView, i3, keyEvent);
            }
        });
        mentionEditText.addTextChangedListener(new TrackedItemTextWatcher(new Function0() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(this.f$0.isProgrammaticChange);
            }
        }));
        mentionEditText.addTextChangedListener(new PromptInputView$editText$1$3(this, mentionEditText));
        mentionEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$$ExternalSyntheticLambda10
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                PromptInputView.editText$lambda$7$lambda$3(this.f$0, view, z);
            }
        });
        mentionEditText.setOnSelectionChangedListener(new Function2() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PromptInputView.editText$lambda$7$lambda$4(this.f$0, mentionEditText, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
            }
        });
        mentionEditText.setOnPasteListener(new Function3() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return PromptInputView.editText$lambda$7$lambda$6(this.f$0, mentionEditText, (String) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
            }
        });
        this.editText = mentionEditText;
        triggerStringHandler.setDelegate(new TriggerTrackingDelegate() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView.1
            @Override // expo.modules.nativeelementsexpo.promptinput.TriggerTrackingDelegate
            public void beginTracking(char trigger) {
                try {
                    PromptInputView.this.getOnMentionShow().invoke(MapsKt.mapOf(TuplesKt.to("trigger", String.valueOf(trigger))));
                } catch (ClassCastException e) {
                    Log.e(PromptInputView.LOG_TAG, "ClassCastException in event dispatch", e);
                }
            }

            @Override // expo.modules.nativeelementsexpo.promptinput.TriggerTrackingDelegate
            public void endTracking() {
                PromptInputView.this.removePendingStyleNow();
                try {
                    PromptInputView.this.getOnMentionHide().invoke(MapsKt.emptyMap());
                } catch (ClassCastException e) {
                    Log.e(PromptInputView.LOG_TAG, "ClassCastException in event dispatch", e);
                }
            }

            @Override // expo.modules.nativeelementsexpo.promptinput.TriggerTrackingDelegate
            public void filterForPrefix(char trigger, String prefix) {
                Intrinsics.checkNotNullParameter(prefix, "prefix");
                try {
                    PromptInputView.this.getOnMentionFilter().invoke(MapsKt.mapOf(TuplesKt.to("trigger", String.valueOf(trigger)), TuplesKt.to("prefix", prefix)));
                } catch (ClassCastException e) {
                    Log.e(PromptInputView.LOG_TAG, "ClassCastException in event dispatch", e);
                }
            }

            @Override // expo.modules.nativeelementsexpo.promptinput.TriggerTrackingDelegate
            public void updateSelection(int selStart, int selEnd) {
                PromptInputView.this.isProgrammaticChange = true;
                try {
                    PromptInputView.this.editText.setSelection(RangesKt.coerceIn(selStart, 0, PromptInputView.this.editText.getText().length()), RangesKt.coerceIn(selEnd, 0, PromptInputView.this.editText.getText().length()));
                } finally {
                    PromptInputView.this.isProgrammaticChange = false;
                }
            }

            @Override // expo.modules.nativeelementsexpo.promptinput.TriggerTrackingDelegate
            public void applyPendingStyle(int start, int end) {
                PromptInputView.this.applyPendingStyleNow(start, end);
            }

            @Override // expo.modules.nativeelementsexpo.promptinput.TriggerTrackingDelegate
            public void removePendingStyle() {
                PromptInputView.this.removePendingStyleNow();
            }
        });
        setOrientation(1);
        addView(mentionEditText, new LinearLayout.LayoutParams(-1, -1));
        mentionEditText.post(new Runnable() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.calculateAndReportHeight();
            }
        });
        mentionEditText.setTag("prompt-input");
        setTag(null);
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final void setPlaceholder(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.placeholder = value;
        this.editText.setHint(value);
    }

    public final boolean getDisabled() {
        return this.disabled;
    }

    public final void setDisabled(boolean z) {
        this.disabled = z;
        this.editText.setEnabled(!z);
        this.editText.setAlpha(z ? 0.5f : 1.0f);
    }

    public final int getMaxHeight() {
        return this.maxHeight;
    }

    public final void setMaxHeight(int i) {
        this.maxHeight = i;
        this.editText.post(new Runnable() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.calculateAndReportHeight();
            }
        });
    }

    public final int getTokenBackgroundColor() {
        return this.tokenBackgroundColor;
    }

    public final void setTokenBackgroundColor(int i) {
        this.tokenBackgroundColor = i;
        this.triggerHandler.updateColors(i, this.pendingTokenBackgroundColor, this.tokenTextColor, this.pendingTokenTextColor);
        updateExistingTagSpans();
    }

    public final int getTokenTextColor() {
        return this.tokenTextColor;
    }

    public final void setTokenTextColor(int i) {
        this.tokenTextColor = i;
        this.triggerHandler.updateColors(this.tokenBackgroundColor, this.pendingTokenBackgroundColor, i, this.pendingTokenTextColor);
        updateExistingTagSpans();
    }

    public final int getPendingTokenBackgroundColor() {
        return this.pendingTokenBackgroundColor;
    }

    public final void setPendingTokenBackgroundColor(int i) {
        this.pendingTokenBackgroundColor = i;
        this.triggerHandler.updateColors(this.tokenBackgroundColor, i, this.tokenTextColor, this.pendingTokenTextColor);
        updateExistingPendingSpans();
    }

    public final int getPendingTokenTextColor() {
        return this.pendingTokenTextColor;
    }

    public final void setPendingTokenTextColor(int i) {
        this.pendingTokenTextColor = i;
        this.triggerHandler.updateColors(this.tokenBackgroundColor, this.pendingTokenBackgroundColor, this.tokenTextColor, i);
        updateExistingPendingSpans();
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final void setTextColor(int i) {
        this.textColor = i;
        this.editText.setTextColor(i);
    }

    public final int getPlaceholderColor() {
        return this.placeholderColor;
    }

    public final void setPlaceholderColor(int i) {
        this.placeholderColor = i;
        this.editText.setHintTextColor(i);
    }

    public final List<TriggerConfig> getTriggerConfigs() {
        return this.triggerConfigs;
    }

    public final void setTriggerConfigs(List<TriggerConfig> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.triggerConfigs = value;
        this.triggerHandler.setTriggerConfigs(value);
    }

    public final List<String> getTrackedItems() {
        return this.trackedItems;
    }

    public final void setTrackedItems(List<String> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.trackedItems = value;
        this.trackedItemHandler.setTrackedPatterns(value);
    }

    public final ViewEventCallback<Map<String, Object>> getOnSubmit() {
        return this.onSubmit.getValue(this, $$delegatedProperties[0]);
    }

    public final ViewEventCallback<Map<String, Object>> getOnHeightChange() {
        return this.onHeightChange.getValue(this, $$delegatedProperties[1]);
    }

    public final ViewEventCallback<Map<String, Object>> getOnDirtyChange() {
        return this.onDirtyChange.getValue(this, $$delegatedProperties[2]);
    }

    public final ViewEventCallback<Map<String, Object>> getOnFocusChange() {
        return this.onFocusChange.getValue(this, $$delegatedProperties[3]);
    }

    public final ViewEventCallback<Map<String, Object>> getOnMentionShow() {
        return this.onMentionShow.getValue(this, $$delegatedProperties[4]);
    }

    public final ViewEventCallback<Map<String, Object>> getOnMentionHide() {
        return this.onMentionHide.getValue(this, $$delegatedProperties[5]);
    }

    public final ViewEventCallback<Map<String, Object>> getOnMentionFilter() {
        return this.onMentionFilter.getValue(this, $$delegatedProperties[6]);
    }

    public final ViewEventCallback<Map<String, Object>> getOnItemTracked() {
        return this.onItemTracked.getValue(this, $$delegatedProperties[7]);
    }

    public final TagInserter getTagInserter() {
        return this.tagInserter;
    }

    public final TriggerStringHandler getTriggerHandler() {
        return this.triggerHandler;
    }

    public final TrackedItemHandler getTrackedItemHandler() {
        return this.trackedItemHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean editText$lambda$7$lambda$1(PromptInputView promptInputView, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return false;
        }
        try {
            promptInputView.getOnSubmit().invoke(MapsKt.emptyMap());
            return true;
        } catch (ClassCastException e) {
            Log.e(LOG_TAG, "ClassCastException in event dispatch", e);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void editText$lambda$7$lambda$3(PromptInputView promptInputView, View view, boolean z) {
        try {
            promptInputView.getOnFocusChange().invoke(MapsKt.mapOf(TuplesKt.to("isFocused", Boolean.valueOf(z))));
        } catch (ClassCastException e) {
            Log.e(LOG_TAG, "ClassCastException in event dispatch", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit editText$lambda$7$lambda$4(PromptInputView promptInputView, MentionEditText mentionEditText, int i, int i2) {
        if (!promptInputView.isProgrammaticChange) {
            Editable text = mentionEditText.getText();
            Editable editable = text instanceof Spannable ? text : null;
            if (editable == null) {
                return Unit.INSTANCE;
            }
            promptInputView.triggerHandler.selectionDidChange(editable, i, i2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit editText$lambda$7$lambda$6(final PromptInputView promptInputView, MentionEditText mentionEditText, String pastedText, int i, int i2) {
        Intrinsics.checkNotNullParameter(pastedText, "pastedText");
        promptInputView.trackedItemHandler.checkAndFireTrackedItem(pastedText, mentionEditText.getText(), i, i2, new Function2() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return PromptInputView.editText$lambda$7$lambda$6$lambda$5(this.f$0, (String) obj, (String) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit editText$lambda$7$lambda$6$lambda$5(PromptInputView promptInputView, String matchedText, String uuid) {
        Intrinsics.checkNotNullParameter(matchedText, "matchedText");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        try {
            promptInputView.getOnItemTracked().invoke(MapsKt.mapOf(TuplesKt.to("trigger", matchedText), TuplesKt.to("uuid", uuid)));
        } catch (ClassCastException e) {
            Log.e(LOG_TAG, "ClassCastException in event dispatch", e);
        }
        return Unit.INSTANCE;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.suppressFocusOnAttach) {
            this.suppressFocusOnAttach = false;
        } else if (getIsDirty()) {
            this.editText.post(new Runnable() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    PromptInputView.onAttachedToWindow$lambda$9(this.f$0);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAttachedToWindow$lambda$9(PromptInputView promptInputView) {
        promptInputView.editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyPendingStyleNow(int start, int end) {
        Editable text = this.editText.getText();
        if (text == null) {
            return;
        }
        Object[] spans = text.getSpans(0, text.length(), PendingMentionSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        for (Object obj : spans) {
            text.removeSpan((PendingMentionSpan) obj);
        }
        if (start < 0 || end <= start || start >= text.length() || end > text.length()) {
            return;
        }
        text.setSpan(new PendingMentionSpan(this.pendingTokenBackgroundColor, this.pendingTokenTextColor), start, end, 33);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removePendingStyleNow() {
        Editable text = this.editText.getText();
        if (text == null) {
            return;
        }
        Object[] spans = text.getSpans(0, text.length(), PendingMentionSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        for (Object obj : spans) {
            text.removeSpan((PendingMentionSpan) obj);
        }
    }

    public final String getValue() {
        Editable text = this.editText.getText();
        Editable editable = text instanceof Spannable ? text : null;
        return editable == null ? this.editText.getText().toString() : this.triggerHandler.buildTaggedMessageResult(editable);
    }

    public final String getPlainText() {
        String string;
        Editable text = this.editText.getText();
        return (text == null || (string = text.toString()) == null) ? "" : string;
    }

    public final void clear() {
        this.triggerHandler.resetTracking();
        this.editText.setText("");
        this.editText.post(new Runnable() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PromptInputView.clear$lambda$12(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clear$lambda$12(PromptInputView promptInputView) {
        promptInputView.calculateAndReportHeight();
        promptInputView.reportDirtyChange();
    }

    public final void setText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.triggerHandler.resetTracking();
        this.isProgrammaticChange = true;
        try {
            this.editText.setText(text);
            this.editText.setSelection(text.length());
            this.isProgrammaticChange = false;
            this.editText.post(new Runnable() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    PromptInputView.setText$lambda$13(this.f$0);
                }
            });
        } catch (Throwable th) {
            this.isProgrammaticChange = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setText$lambda$13(PromptInputView promptInputView) {
        promptInputView.calculateAndReportHeight();
        promptInputView.reportDirtyChange();
    }

    public final void insertMention(String id, String name, TagType type) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Editable text = this.editText.getText();
        if (text == null) {
            return;
        }
        int iCoerceAtLeast = RangesKt.coerceAtLeast(this.editText.getSelectionStart(), 0);
        TriggerTrackingState currentState = this.triggerHandler.getCurrentState();
        this.isProgrammaticChange = true;
        try {
            this.triggerHandler.insert(new EntityTag(name, id, type), text, iCoerceAtLeast, currentState);
            this.isProgrammaticChange = false;
            post(new Runnable() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    PromptInputView.insertMention$lambda$14(this.f$0);
                }
            });
        } catch (Throwable th) {
            this.isProgrammaticChange = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertMention$lambda$14(PromptInputView promptInputView) {
        promptInputView.calculateAndReportHeight();
        promptInputView.reportDirtyChange();
    }

    public final void insertItem(String id, String name, String type, String uuid) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.isProgrammaticChange = true;
        try {
            if (!this.trackedItemHandler.insertTrackedItem(this.editText, uuid, new EntityTag(name, id, TagType.INSTANCE.fromString(type)), this.tokenBackgroundColor, this.tokenTextColor)) {
                this.isProgrammaticChange = false;
            } else {
                this.isProgrammaticChange = false;
                post(new Runnable() { // from class: expo.modules.nativeelementsexpo.promptinput.PromptInputView$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        PromptInputView.insertItem$lambda$15(this.f$0);
                    }
                });
            }
        } catch (Throwable th) {
            this.isProgrammaticChange = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertItem$lambda$15(PromptInputView promptInputView) {
        promptInputView.calculateAndReportHeight();
        promptInputView.reportDirtyChange();
    }

    public final void cancelTrackedItem(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Editable text = this.editText.getText();
        if (text == null) {
            return;
        }
        this.trackedItemHandler.cancelTrackedItem(text, uuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void calculateAndReportHeight() {
        double dCeil = Math.ceil(RangesKt.coerceAtMost((((RangesKt.coerceAtLeast(this.editText.getLineCount(), 1) * this.editText.getLineHeight()) + this.editText.getPaddingTop()) + this.editText.getPaddingBottom()) / this.density, this.maxHeight));
        if (dCeil == this.lastReportedHeight) {
            return;
        }
        this.lastReportedHeight = dCeil;
        try {
            getOnHeightChange().invoke(MapsKt.mapOf(TuplesKt.to("height", Double.valueOf(dCeil))));
        } catch (ClassCastException e) {
            Log.e(LOG_TAG, "ClassCastException in event dispatch", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scrollToCursor() {
        Layout layout;
        int selectionEnd = this.editText.getSelectionEnd();
        if (selectionEnd >= 0 && (layout = this.editText.getLayout()) != null) {
            int lineForOffset = layout.getLineForOffset(selectionEnd);
            int lineTop = layout.getLineTop(lineForOffset);
            int lineBottom = layout.getLineBottom(lineForOffset);
            int scrollY = this.editText.getScrollY();
            int iCoerceAtLeast = RangesKt.coerceAtLeast((((int) (this.maxHeight * this.density)) - this.editText.getPaddingTop()) - this.editText.getPaddingBottom(), 0);
            int iCoerceAtLeast2 = RangesKt.coerceAtLeast(layout.getHeight() - iCoerceAtLeast, 0);
            if (scrollY > iCoerceAtLeast2) {
                this.editText.scrollTo(0, iCoerceAtLeast2);
            } else if (lineBottom > scrollY + iCoerceAtLeast) {
                this.editText.scrollTo(0, lineBottom - iCoerceAtLeast);
            } else if (lineTop < scrollY) {
                this.editText.scrollTo(0, lineTop);
            }
        }
    }

    public final void blur() {
        this.suppressFocusOnAttach = true;
        this.editText.clearFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportDirtyChange() {
        boolean isDirty = getIsDirty();
        if (isDirty != this.lastReportedDirty) {
            this.lastReportedDirty = isDirty;
            try {
                getOnDirtyChange().invoke(MapsKt.mapOf(TuplesKt.to("isDirty", Boolean.valueOf(isDirty))));
            } catch (ClassCastException e) {
                Log.e(LOG_TAG, "ClassCastException in event dispatch", e);
            }
        }
    }

    private final void updateExistingTagSpans() {
        Editable text = this.editText.getText();
        Editable editable = text instanceof Spannable ? text : null;
        if (editable == null) {
            return;
        }
        TagSpan[] tagSpanArr = (TagSpan[]) editable.getSpans(0, editable.length(), TagSpan.class);
        Intrinsics.checkNotNull(tagSpanArr);
        for (TagSpan tagSpan : tagSpanArr) {
            TagInserter tagInserter = this.tagInserter;
            Intrinsics.checkNotNull(tagSpan);
            tagInserter.updateTag(editable, tagSpan, this.tokenBackgroundColor, this.tokenTextColor);
        }
    }

    private final void updateExistingPendingSpans() {
        Editable text = this.editText.getText();
        Editable editable = text instanceof Spannable ? text : null;
        if (editable == null) {
            return;
        }
        PendingMentionSpan[] pendingMentionSpanArr = (PendingMentionSpan[]) editable.getSpans(0, editable.length(), PendingMentionSpan.class);
        Intrinsics.checkNotNull(pendingMentionSpanArr);
        for (PendingMentionSpan pendingMentionSpan : pendingMentionSpanArr) {
            int spanStart = editable.getSpanStart(pendingMentionSpan);
            int spanEnd = editable.getSpanEnd(pendingMentionSpan);
            if (spanStart >= 0 && spanEnd >= 0 && spanStart < spanEnd) {
                editable.removeSpan(pendingMentionSpan);
                editable.setSpan(new PendingMentionSpan(this.pendingTokenBackgroundColor, this.pendingTokenTextColor), spanStart, spanEnd, 33);
            }
        }
    }

    private final boolean getIsDirty() {
        Editable text = this.editText.getText();
        Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
        return text.length() > 0;
    }
}
