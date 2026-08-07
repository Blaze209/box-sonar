package com.pspdfkit.forms;

import android.util.Pair;
import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.annotations.WidgetAnnotation;
import com.pspdfkit.exceptions.InvalidNutrientLicenseException;
import com.pspdfkit.forms.exceptions.FormCreationFailedException;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.fm;
import com.pspdfkit.internal.jni.NativeAnnotation;
import com.pspdfkit.internal.jni.NativeFormField;
import com.pspdfkit.internal.jni.NativeFormFieldCreationResult;
import com.pspdfkit.internal.jni.NativeFormManager;
import com.pspdfkit.internal.jni.NativeFormRemovalResult;
import com.pspdfkit.internal.jni.NativeFormResetFlags;
import com.pspdfkit.internal.jni.NativeFormType;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import com.pspdfkit.internal.kh;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.mr;
import com.pspdfkit.internal.o3;
import com.pspdfkit.internal.zh;
import com.pspdfkit.signatures.DocumentSignatureInfo;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\r\u001a\u00020\f\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ=\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000f\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0013\u001a\u00020\f\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\f0\u000f\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\n0\u000fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\nH\u0016¢\u0006\u0004\b \u0010!J\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\"2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\u000fH\u0016¢\u0006\u0004\b'\u0010\u001fJ\u0015\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00170\nH\u0016¢\u0006\u0004\b(\u0010!J\u001d\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170\"2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b+\u0010,J\u0019\u0010-\u001a\u0004\u0018\u00010\u00172\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b-\u0010.J\u001d\u00100\u001a\b\u0012\u0004\u0012\u00020\u00170\"2\u0006\u0010/\u001a\u00020\bH\u0016¢\u0006\u0004\b0\u0010$J\u0019\u00101\u001a\u0004\u0018\u00010\u00172\u0006\u0010/\u001a\u00020\bH\u0016¢\u0006\u0004\b1\u00102J\u001b\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\n0\u000fH\u0016¢\u0006\u0004\b3\u0010\u001fJ\u0015\u00104\u001a\b\u0012\u0004\u0012\u00020\u00170\nH\u0016¢\u0006\u0004\b4\u0010!J\u0017\u00108\u001a\u0002072\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b8\u00109J\u0017\u0010:\u001a\u0002072\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b:\u00109J\u0017\u0010<\u001a\u0002072\u0006\u00106\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=J\u0017\u0010>\u001a\u0002072\u0006\u00106\u001a\u00020;H\u0016¢\u0006\u0004\b>\u0010=J\u0017\u0010@\u001a\u0002072\u0006\u00106\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u0002072\u0006\u00106\u001a\u00020?H\u0016¢\u0006\u0004\bB\u0010AJ\u0017\u0010D\u001a\u0002072\u0006\u00106\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u0002072\u0006\u00106\u001a\u00020CH\u0016¢\u0006\u0004\bF\u0010EJ\u0017\u0010H\u001a\u0002072\u0006\u00106\u001a\u00020GH\u0016¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u0002072\u0006\u00106\u001a\u00020GH\u0016¢\u0006\u0004\bJ\u0010IJ\u000f\u0010K\u001a\u00020\u0019H\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010N\u001a\u0002072\u0006\u0010M\u001a\u00020\u0019H\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u000207H\u0016¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\u0019H\u0016¢\u0006\u0004\bR\u0010LJ\u0010\u0010S\u001a\u000207H\u0096@¢\u0006\u0004\bS\u0010TJ%\u0010W\u001a\u0002072\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010V\u001a\u00020\u0019H\u0016¢\u0006\u0004\bW\u0010XJ#\u0010]\u001a\u0004\u0018\u00010\f2\b\b\u0001\u0010Z\u001a\u00020Y2\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\b]\u0010^J%\u0010a\u001a\u0002072\u0006\u0010_\u001a\u00020\f2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00170\nH\u0016¢\u0006\u0004\ba\u0010bJ\u001f\u0010c\u001a\u00020\f2\u0006\u0010Z\u001a\u00020Y2\u0006\u0010\\\u001a\u00020[H\u0016¢\u0006\u0004\bc\u0010^J\u001f\u0010d\u001a\u00020\u00172\u0006\u0010_\u001a\u00020\f2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\bd\u0010eJ'\u0010c\u001a\u00020\f2\u0006\u0010f\u001a\u00020Y2\u0006\u0010\\\u001a\u00020[2\u0006\u0010h\u001a\u00020gH\u0002¢\u0006\u0004\bc\u0010iJ\u000f\u0010j\u001a\u000207H\u0002¢\u0006\u0004\bj\u0010QR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010kR\u0014\u0010m\u001a\u00020l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u0014\u0010o\u001a\u00020Y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bo\u0010pR\u0017\u0010r\u001a\u00020q8\u0006¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u0018\u0010w\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0014\u0010M\u001a\u00020y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010zR&\u0010}\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020Y\u0012\u0004\u0012\u00020[0|0{8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u0016\u0010\u0081\u0001\u001a\u00020v8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u007f\u0010\u0080\u0001¨\u0006\u0082\u0001"}, d2 = {"Lcom/pspdfkit/forms/FormProviderImpl;", "Lcom/pspdfkit/internal/fm;", "Lcom/pspdfkit/internal/lm;", "document", "<init>", "(Lcom/pspdfkit/internal/lm;)V", "Lcom/pspdfkit/forms/FormElementConfiguration;", ExifInterface.GPS_DIRECTION_TRUE, "", "fullyQualifiedName", "", "formElementConfigurations", "Lcom/pspdfkit/forms/FormField;", "addFormElementsToPage", "(Ljava/lang/String;Ljava/util/List;)Lcom/pspdfkit/forms/FormField;", "Lio/reactivex/rxjava3/core/Single;", "addFormElementsToPageAsync", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/rxjava3/core/Single;", "formElementConfiguration", "addFormElementToPage", "(Ljava/lang/String;Lcom/pspdfkit/forms/FormElementConfiguration;)Lcom/pspdfkit/forms/FormField;", "addFormElementToPageAsync", "(Ljava/lang/String;Lcom/pspdfkit/forms/FormElementConfiguration;)Lio/reactivex/rxjava3/core/Single;", "Lcom/pspdfkit/forms/FormElement;", "formElement", "", "removeFormElementFromPage", "(Lcom/pspdfkit/forms/FormElement;)Z", "removeFormElementFromPageAsync", "(Lcom/pspdfkit/forms/FormElement;)Lio/reactivex/rxjava3/core/Single;", "getFormFieldsAsync", "()Lio/reactivex/rxjava3/core/Single;", "getFormFields", "()Ljava/util/List;", "Lio/reactivex/rxjava3/core/Maybe;", "getFormFieldWithFullyQualifiedNameAsync", "(Ljava/lang/String;)Lio/reactivex/rxjava3/core/Maybe;", "getFormFieldWithFullyQualifiedName", "(Ljava/lang/String;)Lcom/pspdfkit/forms/FormField;", "getFormElementsAsync", "getFormElements", "Lcom/pspdfkit/annotations/WidgetAnnotation;", "annotation", "getFormElementForAnnotationAsync", "(Lcom/pspdfkit/annotations/WidgetAnnotation;)Lio/reactivex/rxjava3/core/Maybe;", "getFormElementForAnnotation", "(Lcom/pspdfkit/annotations/WidgetAnnotation;)Lcom/pspdfkit/forms/FormElement;", "fieldName", "getFormElementWithNameAsync", "getFormElementWithName", "(Ljava/lang/String;)Lcom/pspdfkit/forms/FormElement;", "getTabOrderAsync", "getTabOrder", "Lcom/pspdfkit/forms/FormListeners$OnFormFieldUpdatedListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "addOnFormFieldUpdatedListener", "(Lcom/pspdfkit/forms/FormListeners$OnFormFieldUpdatedListener;)V", "removeOnFormFieldUpdatedListener", "Lcom/pspdfkit/forms/FormListeners$OnFormTabOrderUpdatedListener;", "addOnFormTabOrderUpdatedListener", "(Lcom/pspdfkit/forms/FormListeners$OnFormTabOrderUpdatedListener;)V", "removeOnFormTabOrderUpdatedListener", "Lcom/pspdfkit/forms/FormListeners$OnTextFormFieldUpdatedListener;", "addOnTextFormFieldUpdatedListener", "(Lcom/pspdfkit/forms/FormListeners$OnTextFormFieldUpdatedListener;)V", "removeOnTextFormFieldUpdatedListener", "Lcom/pspdfkit/forms/FormListeners$OnButtonFormFieldUpdatedListener;", "addOnButtonFormFieldUpdatedListener", "(Lcom/pspdfkit/forms/FormListeners$OnButtonFormFieldUpdatedListener;)V", "removeOnButtonFormFieldUpdatedListener", "Lcom/pspdfkit/forms/FormListeners$OnChoiceFormFieldUpdatedListener;", "addOnChoiceFormFieldUpdatedListener", "(Lcom/pspdfkit/forms/FormListeners$OnChoiceFormFieldUpdatedListener;)V", "removeOnChoiceFormFieldUpdatedListener", "hasUnsavedChanges", "()Z", "isDirty", "setDirty", "(Z)V", "markFormAsSavedToDisk", "()V", "hasFieldsCache", "prepareFieldsCache", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formFields", "shouldExcludeFormFields", "resetFormFields", "(Ljava/util/List;Z)V", "", "providerIndex", "Lcom/pspdfkit/internal/jni/NativeFormField;", "nativeFormField", "onFormFieldAdded", "(ILcom/pspdfkit/internal/jni/NativeFormField;)Lcom/pspdfkit/forms/FormField;", "formField", "formElements", "attachFormElement", "(Lcom/pspdfkit/forms/FormField;Ljava/util/List;)V", "createFormField", "createFormElement", "(Lcom/pspdfkit/forms/FormField;Lcom/pspdfkit/annotations/WidgetAnnotation;)Lcom/pspdfkit/forms/FormElement;", "documentProviderIndex", "Lcom/pspdfkit/forms/FormType;", "formType", "(ILcom/pspdfkit/internal/jni/NativeFormField;Lcom/pspdfkit/forms/FormType;)Lcom/pspdfkit/forms/FormField;", "checkFormsLicense", "Lcom/pspdfkit/internal/lm;", "Lcom/pspdfkit/internal/jni/NativeFormManager;", "nativeFormManager", "Lcom/pspdfkit/internal/jni/NativeFormManager;", "providersCount", "I", "Lcom/pspdfkit/internal/zh;", "formObserver", "Lcom/pspdfkit/internal/zh;", "getFormObserver", "()Lcom/pspdfkit/internal/zh;", "Lcom/pspdfkit/internal/kh;", "_formCache", "Lcom/pspdfkit/internal/kh;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "Landroid/util/Pair;", "encounteredFormFields", "Ljava/util/List;", "getFormCache", "()Lcom/pspdfkit/internal/kh;", "formCache", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FormProviderImpl implements fm {
    public static final int $stable = 8;
    private kh _formCache;
    private final lm document;
    private final List<Pair<Integer, NativeFormField>> encounteredFormFields;
    private final zh formObserver;
    private final AtomicBoolean isDirty;
    private final NativeFormManager nativeFormManager;
    private final int providersCount;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[FormType.values().length];
            try {
                iArr[FormType.CHECKBOX.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FormType.COMBOBOX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FormType.LISTBOX.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FormType.PUSHBUTTON.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[FormType.RADIOBUTTON.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[FormType.SIGNATURE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[FormType.TEXT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[FormType.UNDEFINED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NativeFormType.values().length];
            try {
                iArr2[NativeFormType.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[NativeFormType.PUSHBUTTON.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[NativeFormType.RADIOBUTTON.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[NativeFormType.CHECKBOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[NativeFormType.LISTBOX.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[NativeFormType.COMBOBOX.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[NativeFormType.SIGNATURE.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.forms.FormProviderImpl$addFormElementsToPage$6, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.forms.FormProviderImpl$addFormElementsToPage$6", f = "FormProviderImpl.kt", i = {}, l = {113}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WidgetAnnotation $annotation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(WidgetAnnotation widgetAnnotation, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$annotation = widgetAnnotation;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FormProviderImpl.this.new AnonymousClass6(this.$annotation, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3 annotationProvider = FormProviderImpl.this.document.getAnnotationProvider();
                WidgetAnnotation widgetAnnotation = this.$annotation;
                this.label = 1;
                if (annotationProvider.addAnnotationToPage(widgetAnnotation, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.forms.FormProviderImpl$prepareFieldsCache$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/pspdfkit/internal/kh;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/pspdfkit/internal/kh;"}, k = 3, mv = {2, 3, 0})
    @DebugMetadata(c = "com.pspdfkit.forms.FormProviderImpl$prepareFieldsCache$2", f = "FormProviderImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super kh>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FormProviderImpl.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return FormProviderImpl.this.getFormCache();
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super kh> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.pspdfkit.forms.FormProviderImpl$removeFormElementFromPage$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.pspdfkit.forms.FormProviderImpl$removeFormElementFromPage$1", f = "FormProviderImpl.kt", i = {}, l = {214}, m = "invokeSuspend", n = {}, nl = {-1}, s = {}, v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FormElement $formElement;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(FormElement formElement, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$formElement = formElement;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return FormProviderImpl.this.new AnonymousClass1(this.$formElement, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3 annotationProvider = FormProviderImpl.this.document.getAnnotationProvider();
                WidgetAnnotation annotation = this.$formElement.getAnnotation();
                annotation.getClass();
                this.label = 1;
                if (annotationProvider.removeAnnotationFromPage(annotation, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public FormProviderImpl(lm lmVar) {
        lmVar.getClass();
        this.document = lmVar;
        NativeFormManager nativeFormManagerCreate = NativeFormManager.create(lmVar.y);
        nativeFormManagerCreate.getClass();
        this.nativeFormManager = nativeFormManagerCreate;
        List listUnmodifiableList = Collections.unmodifiableList(lmVar.A);
        listUnmodifiableList.getClass();
        this.providersCount = listUnmodifiableList.size();
        zh zhVar = new zh(this, lmVar);
        this.formObserver = zhVar;
        this.isDirty = new AtomicBoolean(false);
        this.encounteredFormFields = new ArrayList();
        if (ar.b().a(NativeLicenseFeatures.ACRO_FORMS)) {
            nativeFormManagerCreate.registerFormObserver(zhVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FormField addFormElementToPageAsync$lambda$0(FormProviderImpl formProviderImpl, String str, FormElementConfiguration formElementConfiguration) {
        return formProviderImpl.addFormElementsToPage(str, CollectionsKt.listOf(formElementConfiguration));
    }

    private final void checkFormsLicense() {
        if (!ar.b().a(NativeLicenseFeatures.ACRO_FORMS)) {
            throw new InvalidNutrientLicenseException("Your license does not allow forms display and editing.");
        }
    }

    private final FormField createFormField(int documentProviderIndex, NativeFormField nativeFormField, FormType formType) {
        switch (WhenMappings.$EnumSwitchMapping$0[formType.ordinal()]) {
            case 1:
                return new CheckBoxFormField(documentProviderIndex, nativeFormField);
            case 2:
                return new ComboBoxFormField(documentProviderIndex, nativeFormField);
            case 3:
                return new ListBoxFormField(documentProviderIndex, nativeFormField);
            case 4:
                return new PushButtonFormField(documentProviderIndex, nativeFormField);
            case 5:
                return new RadioButtonFormField(documentProviderIndex, nativeFormField);
            case 6:
                return new SignatureFormField(this.document, documentProviderIndex, nativeFormField);
            case 7:
                return new TextFormField(documentProviderIndex, nativeFormField);
            case 8:
                throw new IllegalArgumentException("Cannot create a form field with an undefined type.");
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean removeFormElementFromPageAsync$lambda$0(FormProviderImpl formProviderImpl, FormElement formElement) {
        return Boolean.valueOf(formProviderImpl.removeFormElementFromPage(formElement));
    }

    @Override // com.pspdfkit.forms.FormProvider
    public <T extends FormElementConfiguration<?, ?>> FormField addFormElementToPage(String fullyQualifiedName, T formElementConfiguration) {
        fullyQualifiedName.getClass();
        formElementConfiguration.getClass();
        checkFormsLicense();
        return addFormElementsToPage(fullyQualifiedName, CollectionsKt.listOf(formElementConfiguration));
    }

    @Override // com.pspdfkit.forms.FormProvider
    public <T extends FormElementConfiguration<?, ?>> Single<FormField> addFormElementToPageAsync(final String fullyQualifiedName, final T formElementConfiguration) {
        fullyQualifiedName.getClass();
        formElementConfiguration.getClass();
        checkFormsLicense();
        Single<FormField> singleSubscribeOn = Single.fromCallable(new Callable() { // from class: com.pspdfkit.forms.FormProviderImpl$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FormProviderImpl.addFormElementToPageAsync$lambda$0(this.f$0, fullyQualifiedName, formElementConfiguration);
            }
        }).subscribeOn(this.document.b(5));
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public <T extends FormElementConfiguration<?, ?>> FormField addFormElementsToPage(String fullyQualifiedName, List<? extends T> formElementConfigurations) throws InterruptedException {
        fullyQualifiedName.getClass();
        formElementConfigurations.getClass();
        checkFormsLicense();
        if (formElementConfigurations.isEmpty()) {
            throw new IllegalArgumentException("Form element list must not be empty.");
        }
        int size = formElementConfigurations.size();
        for (int i = 0; i < size; i++) {
            FormType type = formElementConfigurations.get(i).getType();
            type.getClass();
            if (type == FormType.UNDEFINED) {
                throw new IllegalArgumentException("Form elements with an undefined type cannot create a form field.");
            }
            if (size > 1 && i > 0) {
                int i2 = i - 1;
                if (type != formElementConfigurations.get(i2).getType()) {
                    throw new IllegalArgumentException("Form elements children of the same form field need to be the same type.");
                }
                if (this.document.c(formElementConfigurations.get(i).pageIndex) != this.document.c(formElementConfigurations.get(i2).pageIndex)) {
                    throw new IllegalArgumentException("All form annotations to add must be in the same document provider");
                }
            }
        }
        if (getFormFieldWithFullyQualifiedName(fullyQualifiedName) != null) {
            throw new IllegalArgumentException(("Form element with this fully qualified name already exists: " + fullyQualifiedName).toString());
        }
        ArrayList<NativeAnnotation> arrayList = new ArrayList<>(size);
        ArrayList arrayList2 = new ArrayList(size);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            WidgetAnnotation widgetAnnotation = new WidgetAnnotation(formElementConfigurations.get(i3).pageIndex, formElementConfigurations.get(i3).boundingBox);
            BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass6(widgetAnnotation, null), 1, null);
            NativeAnnotation nativeAnnotation = widgetAnnotation.getInternal().getNativeAnnotation();
            if (nativeAnnotation != null) {
                arrayList.add(nativeAnnotation);
            }
            arrayList2.add(widgetAnnotation);
            String buttonValue = formElementConfigurations.get(i3).getButtonValue(i3);
            if (buttonValue == null) {
                buttonValue = "";
            }
            arrayList4.add(buttonValue);
        }
        FormType type2 = formElementConfigurations.get(0).getType();
        type2.getClass();
        NativeFormFieldCreationResult nativeFormFieldCreationResultCreateAndInsertFormField = this.nativeFormManager.createAndInsertFormField(mr.a(type2), fullyQualifiedName, arrayList, new ArrayList<>(arrayList4));
        nativeFormFieldCreationResultCreateAndInsertFormField.getClass();
        NativeFormField createdFormField = nativeFormFieldCreationResultCreateAndInsertFormField.getCreatedFormField();
        if (createdFormField == null) {
            throw new FormCreationFailedException(nativeFormFieldCreationResultCreateAndInsertFormField.getErrorMessage());
        }
        FormField formFieldCreateFormField = createFormField(this.document.c(formElementConfigurations.get(0).pageIndex), createdFormField, type2);
        for (int i4 = 0; i4 < size; i4++) {
            T t = formElementConfigurations.get(i4);
            t.getClass();
            FormElement formElementCreateFormElement = t.createFormElement(formFieldCreateFormField, (WidgetAnnotation) arrayList2.get(i4));
            formElementCreateFormElement.getClass();
            arrayList3.add(formElementCreateFormElement);
        }
        formFieldCreateFormField.attachFormElements(arrayList3);
        FormField formFieldOnFormFieldAdded = onFormFieldAdded(formFieldCreateFormField.getProviderIndex(), createdFormField);
        if (formFieldOnFormFieldAdded != null) {
            formFieldCreateFormField = formFieldOnFormFieldAdded;
        }
        this.formObserver.a(formFieldCreateFormField);
        return formFieldCreateFormField;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public <T extends FormElementConfiguration<?, ?>> Single<FormField> addFormElementsToPageAsync(final String fullyQualifiedName, final List<? extends T> formElementConfigurations) {
        fullyQualifiedName.getClass();
        formElementConfigurations.getClass();
        checkFormsLicense();
        Single<FormField> singleSubscribeOn = Single.fromCallable(new Callable() { // from class: com.pspdfkit.forms.FormProviderImpl$$ExternalSyntheticLambda8
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.addFormElementsToPage(fullyQualifiedName, formElementConfigurations);
            }
        }).subscribeOn(this.document.b(5));
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public void addOnButtonFormFieldUpdatedListener(FormListeners.OnButtonFormFieldUpdatedListener listener) {
        listener.getClass();
        zh zhVar = this.formObserver;
        zhVar.getClass();
        listener.getClass();
        zhVar.c.a(listener);
    }

    @Override // com.pspdfkit.forms.FormProvider
    public void addOnChoiceFormFieldUpdatedListener(FormListeners.OnChoiceFormFieldUpdatedListener listener) {
        listener.getClass();
        zh zhVar = this.formObserver;
        zhVar.getClass();
        listener.getClass();
        zhVar.d.a(listener);
    }

    @Override // com.pspdfkit.forms.FormProvider
    public void addOnFormFieldUpdatedListener(FormListeners.OnFormFieldUpdatedListener listener) {
        listener.getClass();
        zh zhVar = this.formObserver;
        zhVar.getClass();
        listener.getClass();
        zhVar.f.a(listener);
    }

    @Override // com.pspdfkit.forms.FormProvider
    public void addOnFormTabOrderUpdatedListener(FormListeners.OnFormTabOrderUpdatedListener listener) {
        listener.getClass();
        zh zhVar = this.formObserver;
        zhVar.getClass();
        listener.getClass();
        zhVar.g.a(listener);
    }

    @Override // com.pspdfkit.forms.FormProvider
    public void addOnTextFormFieldUpdatedListener(FormListeners.OnTextFormFieldUpdatedListener listener) {
        listener.getClass();
        zh zhVar = this.formObserver;
        zhVar.getClass();
        listener.getClass();
        zhVar.e.a(listener);
    }

    @Override // com.pspdfkit.internal.fm
    public void attachFormElement(FormField formField, List<? extends FormElement> formElements) {
        formField.getClass();
        formElements.getClass();
        formField.attachFormElements(formElements);
    }

    @Override // com.pspdfkit.internal.fm
    public FormElement createFormElement(FormField formField, WidgetAnnotation annotation) {
        formField.getClass();
        annotation.getClass();
        switch (WhenMappings.$EnumSwitchMapping$0[formField.getType().ordinal()]) {
            case 1:
                return new CheckBoxFormElement((CheckBoxFormField) formField, annotation);
            case 2:
                return new ComboBoxFormElement((ComboBoxFormField) formField, annotation);
            case 3:
                return new ListBoxFormElement((ListBoxFormField) formField, annotation);
            case 4:
                return new PushButtonFormElement((PushButtonFormField) formField, annotation);
            case 5:
                return new RadioButtonFormElement((RadioButtonFormField) formField, annotation);
            case 6:
                return new SignatureFormElement((SignatureFormField) formField, annotation);
            case 7:
                return new TextFormElement((TextFormField) formField, annotation);
            default:
                return new UnknownFormElement(formField, annotation);
        }
    }

    @Override // com.pspdfkit.internal.fm
    public kh getFormCache() {
        kh khVar;
        synchronized (this) {
            if (this._formCache == null) {
                this._formCache = new kh(this, this.document, this.nativeFormManager);
                this.document.l.a();
                for (Pair<Integer, NativeFormField> pair : this.encounteredFormFields) {
                    kh khVar2 = this._formCache;
                    khVar2.getClass();
                    Object obj = pair.first;
                    obj.getClass();
                    int iIntValue = ((Number) obj).intValue();
                    Object obj2 = pair.second;
                    obj2.getClass();
                    khVar2.a(iIntValue, (NativeFormField) obj2);
                }
            }
            khVar = this._formCache;
            khVar.getClass();
        }
        return khVar;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public FormElement getFormElementForAnnotation(WidgetAnnotation annotation) {
        FormElement formElement;
        annotation.getClass();
        checkFormsLicense();
        synchronized (this) {
            kh formCache = getFormCache();
            formCache.getClass();
            int iC = formCache.b.c(annotation.getPageIndex());
            formElement = (FormElement) ((SparseArray) formCache.g.get(iC)).get(annotation.getObjectNumber());
        }
        return formElement;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public Maybe<FormElement> getFormElementForAnnotationAsync(final WidgetAnnotation annotation) {
        annotation.getClass();
        checkFormsLicense();
        Maybe<FormElement> maybeSubscribeOn = Maybe.fromCallable(new Callable() { // from class: com.pspdfkit.forms.FormProviderImpl$$ExternalSyntheticLambda6
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.getFormElementForAnnotation(annotation);
            }
        }).subscribeOn(this.document.b(5));
        maybeSubscribeOn.getClass();
        return maybeSubscribeOn;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public FormElement getFormElementWithName(String fieldName) {
        fieldName.getClass();
        checkFormsLicense();
        for (FormElement formElement : getFormElements()) {
            if (Intrinsics.areEqual(fieldName, formElement.getName())) {
                return formElement;
            }
        }
        return null;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public Maybe<FormElement> getFormElementWithNameAsync(final String fieldName) {
        fieldName.getClass();
        checkFormsLicense();
        Maybe<FormElement> maybeSubscribeOn = Maybe.fromCallable(new Callable() { // from class: com.pspdfkit.forms.FormProviderImpl$$ExternalSyntheticLambda4
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.getFormElementWithName(fieldName);
            }
        }).subscribeOn(this.document.b(5));
        maybeSubscribeOn.getClass();
        return maybeSubscribeOn;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public List<FormElement> getFormElements() {
        List<FormElement> listUnmodifiableList;
        checkFormsLicense();
        synchronized (this) {
            listUnmodifiableList = Collections.unmodifiableList(getFormCache().h);
            listUnmodifiableList.getClass();
        }
        return listUnmodifiableList;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public Single<List<FormElement>> getFormElementsAsync() {
        checkFormsLicense();
        Single<List<FormElement>> singleSubscribeOn = Single.fromCallable(new Callable() { // from class: com.pspdfkit.forms.FormProviderImpl$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.getFormElements();
            }
        }).subscribeOn(this.document.b(5));
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public FormField getFormFieldWithFullyQualifiedName(String fullyQualifiedName) {
        fullyQualifiedName.getClass();
        checkFormsLicense();
        int i = this.providersCount;
        for (int i2 = 0; i2 < i; i2++) {
            kh formCache = getFormCache();
            formCache.getClass();
            FormField formField = (FormField) ((Map) formCache.e.get(i2)).get(fullyQualifiedName);
            if (formField != null) {
                return formField;
            }
        }
        return null;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public Maybe<FormField> getFormFieldWithFullyQualifiedNameAsync(final String fullyQualifiedName) {
        fullyQualifiedName.getClass();
        checkFormsLicense();
        Maybe<FormField> maybeSubscribeOn = Maybe.fromCallable(new Callable() { // from class: com.pspdfkit.forms.FormProviderImpl$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.getFormFieldWithFullyQualifiedName(fullyQualifiedName);
            }
        }).subscribeOn(this.document.b(5));
        maybeSubscribeOn.getClass();
        return maybeSubscribeOn;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public List<FormField> getFormFields() {
        List<FormField> listUnmodifiableList;
        checkFormsLicense();
        synchronized (this) {
            listUnmodifiableList = Collections.unmodifiableList(getFormCache().f);
            listUnmodifiableList.getClass();
        }
        return listUnmodifiableList;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public Single<List<FormField>> getFormFieldsAsync() {
        checkFormsLicense();
        Single<List<FormField>> singleSubscribeOn = Single.fromCallable(new Callable() { // from class: com.pspdfkit.forms.FormProviderImpl$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.getFormFields();
            }
        }).subscribeOn(this.document.b(5));
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    public final zh getFormObserver() {
        return this.formObserver;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public List<FormElement> getTabOrder() {
        List<FormElement> listFlatten;
        checkFormsLicense();
        synchronized (this) {
            listFlatten = CollectionsKt.flatten(getFormCache().i);
        }
        return listFlatten;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public Single<List<FormElement>> getTabOrderAsync() {
        checkFormsLicense();
        Single<List<FormElement>> singleSubscribeOn = Single.fromCallable(new Callable() { // from class: com.pspdfkit.forms.FormProviderImpl$$ExternalSyntheticLambda7
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.getTabOrder();
            }
        }).subscribeOn(this.document.b(5));
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    @Override // com.pspdfkit.internal.fm
    public boolean hasFieldsCache() {
        return this._formCache != null;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public boolean hasUnsavedChanges() {
        return this.isDirty.get();
    }

    @Override // com.pspdfkit.internal.fm
    public void markFormAsSavedToDisk() {
        setDirty(false);
    }

    @Override // com.pspdfkit.internal.fm
    public synchronized FormField onFormFieldAdded(int providerIndex, NativeFormField nativeFormField) {
        nativeFormField.getClass();
        kh khVar = this._formCache;
        if (khVar == null) {
            this.encounteredFormFields.add(new Pair<>(Integer.valueOf(providerIndex), nativeFormField));
            return null;
        }
        khVar.getClass();
        return khVar.a(providerIndex, nativeFormField);
    }

    @Override // com.pspdfkit.internal.fm
    public Object prepareFieldsCache(Continuation<? super Unit> continuation) {
        checkFormsLicense();
        Object objWithContext = BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
        return objWithContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWithContext : Unit.INSTANCE;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public boolean removeFormElementFromPage(FormElement formElement) throws InterruptedException {
        FormField formField;
        formElement.getClass();
        checkFormsLicense();
        FormField formField2 = formElement.getFormField();
        formField2.getClass();
        if (formElement.getType() == FormType.SIGNATURE) {
            SignatureFormField signatureFormField = (SignatureFormField) formField2;
            signatureFormField.removeSignature();
            DocumentSignatureInfo documentSignatureInfoBlockingGet = this.document.k.blockingGet();
            documentSignatureInfoBlockingGet.getClass();
            documentSignatureInfoBlockingGet.removeSignatureFormField(signatureFormField);
        }
        NativeFormField nativeFormField = formField2.getInternal().getNativeFormField();
        nativeFormField.getClass();
        BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(formElement, null), 1, null);
        NativeFormRemovalResult nativeFormRemovalResultRemoveFormFields = this.nativeFormManager.removeFormFields(CollectionsKt.arrayListOf(nativeFormField));
        nativeFormRemovalResultRemoveFormFields.getClass();
        kh khVar = this._formCache;
        if (khVar != null && (formField = (FormField) ((Map) khVar.e.get(formField2.getProviderIndex())).remove(nativeFormField.getFQN())) != null) {
            khVar.f.remove(formField);
        }
        this.formObserver.a(formField2);
        return !nativeFormRemovalResultRemoveFormFields.getHasError();
    }

    @Override // com.pspdfkit.forms.FormProvider
    public Single<Boolean> removeFormElementFromPageAsync(final FormElement formElement) {
        formElement.getClass();
        checkFormsLicense();
        Single<Boolean> singleSubscribeOn = Single.fromCallable(new Callable() { // from class: com.pspdfkit.forms.FormProviderImpl$$ExternalSyntheticLambda5
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FormProviderImpl.removeFormElementFromPageAsync$lambda$0(this.f$0, formElement);
            }
        }).subscribeOn(this.document.b(5));
        singleSubscribeOn.getClass();
        return singleSubscribeOn;
    }

    @Override // com.pspdfkit.forms.FormProvider
    public void removeOnButtonFormFieldUpdatedListener(FormListeners.OnButtonFormFieldUpdatedListener listener) {
        listener.getClass();
        zh zhVar = this.formObserver;
        zhVar.getClass();
        listener.getClass();
        zhVar.c.b(listener);
    }

    @Override // com.pspdfkit.forms.FormProvider
    public void removeOnChoiceFormFieldUpdatedListener(FormListeners.OnChoiceFormFieldUpdatedListener listener) {
        listener.getClass();
        zh zhVar = this.formObserver;
        zhVar.getClass();
        listener.getClass();
        zhVar.d.b(listener);
    }

    @Override // com.pspdfkit.forms.FormProvider
    public void removeOnFormFieldUpdatedListener(FormListeners.OnFormFieldUpdatedListener listener) {
        listener.getClass();
        zh zhVar = this.formObserver;
        zhVar.getClass();
        listener.getClass();
        zhVar.f.b(listener);
    }

    @Override // com.pspdfkit.forms.FormProvider
    public void removeOnFormTabOrderUpdatedListener(FormListeners.OnFormTabOrderUpdatedListener listener) {
        listener.getClass();
        zh zhVar = this.formObserver;
        zhVar.getClass();
        listener.getClass();
        zhVar.g.b(listener);
    }

    @Override // com.pspdfkit.forms.FormProvider
    public void removeOnTextFormFieldUpdatedListener(FormListeners.OnTextFormFieldUpdatedListener listener) {
        listener.getClass();
        zh zhVar = this.formObserver;
        zhVar.getClass();
        listener.getClass();
        zhVar.e.b(listener);
    }

    @Override // com.pspdfkit.internal.fm
    public void resetFormFields(List<? extends FormField> formFields, boolean shouldExcludeFormFields) {
        formFields.getClass();
        ArrayList<NativeFormField> arrayList = new ArrayList<>();
        Iterator<? extends FormField> it = formFields.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getInternal().getNativeFormField());
        }
        this.nativeFormManager.resetForm(arrayList, shouldExcludeFormFields ? EnumSet.of(NativeFormResetFlags.INCLUDE_EXCLUDE) : EnumSet.noneOf(NativeFormResetFlags.class));
    }

    @Override // com.pspdfkit.internal.fm
    public void setDirty(boolean isDirty) {
        this.isDirty.set(isDirty);
    }

    @Override // com.pspdfkit.internal.fm
    public FormField createFormField(int providerIndex, NativeFormField nativeFormField) {
        nativeFormField.getClass();
        switch (WhenMappings.$EnumSwitchMapping$1[nativeFormField.getType().ordinal()]) {
            case 1:
                return new TextFormField(providerIndex, nativeFormField);
            case 2:
                return new PushButtonFormField(providerIndex, nativeFormField);
            case 3:
                return new RadioButtonFormField(providerIndex, nativeFormField);
            case 4:
                return new CheckBoxFormField(providerIndex, nativeFormField);
            case 5:
                return new ListBoxFormField(providerIndex, nativeFormField);
            case 6:
                return new ComboBoxFormField(providerIndex, nativeFormField);
            case 7:
                return new SignatureFormField(this.document, providerIndex, nativeFormField);
            default:
                return new FormField(providerIndex, nativeFormField);
        }
    }
}
