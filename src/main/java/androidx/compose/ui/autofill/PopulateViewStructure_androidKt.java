package androidx.compose.ui.autofill;

import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import androidx.collection.MutableScatterMap;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.compose.ui.platform.SemanticsUtils_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.semantics.SemanticsInfoKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.spatial.RectManager;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PopulateViewStructure.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0001¨\u0006\u000b"}, d2 = {"populate", "", "Landroid/view/ViewStructure;", "semanticsInfo", "Landroidx/compose/ui/semantics/SemanticsInfo;", "rootAutofillId", "Landroid/view/autofill/AutofillId;", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "", "rectManager", "Landroidx/compose/ui/spatial/RectManager;", "ui"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class PopulateViewStructure_androidKt {
    /* JADX WARN: Code duplicated, block: B:103:0x028f  */
    /* JADX WARN: Code duplicated, block: B:157:0x0378  */
    /* JADX WARN: Code duplicated, block: B:162:0x0380  */
    /* JADX WARN: Code duplicated, block: B:165:0x038a  */
    /* JADX WARN: Code duplicated, block: B:166:0x038c  */
    /* JADX WARN: Code duplicated, block: B:169:0x0392  */
    /* JADX WARN: Code duplicated, block: B:171:0x039e A[LOOP:4: B:170:0x039c->B:171:0x039e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:180:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:182:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:184:0x03fb  */
    /* JADX WARN: Code duplicated, block: B:211:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:212:? A[RETURN, SYNTHETIC] */
    public static final void populate(final ViewStructure viewStructure, SemanticsInfo semanticsInfo, AutofillId autofillId, String str, RectManager rectManager) {
        SemanticsProperties semanticsProperties;
        int i;
        long j;
        char c;
        long j2;
        ToggleableState toggleableState;
        ContentDataType contentDataType;
        boolean z;
        AnnotatedString annotatedString;
        AndroidFillableData androidFillableData;
        ContentType contentType;
        Boolean bool;
        Role role;
        boolean z2;
        boolean zBooleanValue;
        Integer num;
        List list;
        Integer numValueOf;
        boolean z3;
        boolean z4;
        boolean z5;
        int i2;
        String strM8806toLegacyClassNameV4PA4sw;
        int size;
        String str2;
        int i3;
        String[] contentHints;
        String[] contentHints2;
        MutableScatterMap<SemanticsPropertyKey<?>, Object> props$ui;
        MutableScatterMap<SemanticsPropertyKey<?>, Object> props$ui2;
        ToggleableState toggleableState2;
        SemanticsProperties semanticsProperties2;
        int i4;
        final AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
        SemanticsProperties semanticsProperties3 = SemanticsProperties.INSTANCE;
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        SemanticsConfiguration semanticsConfiguration = semanticsInfo.getSemanticsConfiguration();
        int i5 = 8;
        if (semanticsConfiguration == null || (props$ui2 = semanticsConfiguration.getProps$ui()) == null) {
            semanticsProperties = semanticsProperties3;
            i = 2;
            j = 255;
            c = 7;
            j2 = -9187201950435737472L;
            toggleableState = null;
            contentDataType = null;
            z = false;
            annotatedString = null;
            androidFillableData = null;
            contentType = null;
            bool = null;
            role = null;
            z2 = false;
            zBooleanValue = true;
            num = null;
        } else {
            MutableScatterMap<SemanticsPropertyKey<?>, Object> mutableScatterMap = props$ui2;
            Object[] objArr = mutableScatterMap.keys;
            j = 255;
            Object[] objArr2 = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                i = 2;
                int i6 = 0;
                c = 7;
                contentDataType = null;
                z = false;
                toggleableState2 = null;
                annotatedString = null;
                androidFillableData = null;
                contentType = null;
                bool = null;
                role = null;
                z2 = false;
                zBooleanValue = true;
                num = null;
                j2 = -9187201950435737472L;
                while (true) {
                    long j3 = jArr[i6];
                    if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i7 = 8 - ((~(i6 - length)) >>> 31);
                        int i8 = 0;
                        while (i8 < i7) {
                            if ((j3 & 255) < 128) {
                                int i9 = (i6 << 3) + i8;
                                Object obj = objArr[i9];
                                Object obj2 = objArr2[i9];
                                i4 = i5;
                                SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) obj;
                                if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties3.getContentDataType())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.ui.autofill.ContentDataType");
                                    contentDataType = (ContentDataType) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties3.getContentDescription())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                                    String str3 = (String) CollectionsKt.firstOrNull((List) obj2);
                                    if (str3 != null) {
                                        autofillApi26Helper.setContentDescription(viewStructure, str3);
                                    }
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties3.getContentType())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.ui.autofill.ContentType");
                                    contentType = (ContentType) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties3.getFillableData())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.ui.autofill.AndroidFillableData");
                                    androidFillableData = (AndroidFillableData) obj2;
                                } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties3.getEditableText())) {
                                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString");
                                    annotatedString = (AnnotatedString) obj2;
                                } else {
                                    semanticsProperties2 = semanticsProperties3;
                                    if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties3.getFocused())) {
                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                                        autofillApi26Helper.setFocused(viewStructure, ((Boolean) obj2).booleanValue());
                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties2.getMaxTextLength())) {
                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                                        num = (Integer) obj2;
                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties2.getPassword())) {
                                        z2 = true;
                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties2.getIsSensitiveData())) {
                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                                        zBooleanValue = ((Boolean) obj2).booleanValue();
                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties2.getRole())) {
                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.ui.semantics.Role");
                                        role = (Role) obj2;
                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties2.getSelected())) {
                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Boolean");
                                        bool = (Boolean) obj2;
                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties2.getToggleableState())) {
                                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.ui.state.ToggleableState");
                                        toggleableState2 = (ToggleableState) obj2;
                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsActions.getOnClick())) {
                                        autofillApi26Helper.setClickable(viewStructure, true);
                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsActions.getOnLongClick())) {
                                        autofillApi26Helper.setLongClickable(viewStructure, true);
                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsActions.getRequestFocus())) {
                                        autofillApi26Helper.setFocusable(viewStructure, true);
                                    } else if (Intrinsics.areEqual(semanticsPropertyKey, semanticsActions.getSetText())) {
                                        z = true;
                                    }
                                }
                                semanticsProperties2 = semanticsProperties3;
                            } else {
                                semanticsProperties2 = semanticsProperties3;
                                i4 = i5;
                            }
                            j3 >>= i4;
                            i8++;
                            i5 = i4;
                            semanticsProperties3 = semanticsProperties2;
                        }
                        semanticsProperties = semanticsProperties3;
                        if (i7 != i5) {
                            break;
                        }
                    } else {
                        semanticsProperties = semanticsProperties3;
                    }
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                    semanticsProperties3 = semanticsProperties;
                    i5 = 8;
                }
            } else {
                semanticsProperties = semanticsProperties3;
                i = 2;
                c = 7;
                j2 = -9187201950435737472L;
                contentDataType = null;
                z = false;
                toggleableState2 = null;
                annotatedString = null;
                androidFillableData = null;
                contentType = null;
                bool = null;
                role = null;
                z2 = false;
                zBooleanValue = true;
                num = null;
            }
            toggleableState = toggleableState2;
        }
        SemanticsConfiguration semanticsConfigurationMergedSemanticsConfiguration = SemanticsInfoKt.mergedSemanticsConfiguration(semanticsInfo);
        if (semanticsConfigurationMergedSemanticsConfiguration == null || (props$ui = semanticsConfigurationMergedSemanticsConfiguration.getProps$ui()) == null) {
            list = null;
        } else {
            MutableScatterMap<SemanticsPropertyKey<?>, Object> mutableScatterMap2 = props$ui;
            Object[] objArr3 = mutableScatterMap2.keys;
            Object[] objArr4 = mutableScatterMap2.values;
            long[] jArr2 = mutableScatterMap2.metadata;
            int length2 = jArr2.length - 2;
            if (length2 >= 0) {
                int i10 = 0;
                list = null;
                while (true) {
                    long j4 = jArr2[i10];
                    if ((((~j4) << c) & j4 & j2) != j2) {
                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                        for (int i12 = 0; i12 < i11; i12++) {
                            if ((j4 & j) < 128) {
                                int i13 = (i10 << 3) + i12;
                                Object obj3 = objArr3[i13];
                                Object obj4 = objArr4[i13];
                                SemanticsPropertyKey semanticsPropertyKey2 = (SemanticsPropertyKey) obj3;
                                if (Intrinsics.areEqual(semanticsPropertyKey2, semanticsProperties.getDisabled())) {
                                    autofillApi26Helper.setEnabled(viewStructure, false);
                                } else if (Intrinsics.areEqual(semanticsPropertyKey2, semanticsProperties.getText())) {
                                    Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString>");
                                    list = (List) obj4;
                                }
                            }
                            j4 >>= 8;
                        }
                        if (i11 != 8) {
                            break;
                        }
                    }
                    if (i10 == length2) {
                        break;
                    } else {
                        i10++;
                    }
                }
            } else {
                list = null;
            }
        }
        Integer numValueOf2 = Integer.valueOf(semanticsInfo.getSemanticsId());
        numValueOf2.intValue();
        if (semanticsInfo.getParentInfo() == null) {
            numValueOf2 = null;
        }
        int iIntValue = numValueOf2 != null ? numValueOf2.intValue() : -1;
        autofillApi26Helper.setAutofillId(viewStructure, autofillId, iIntValue);
        autofillApi26Helper.setId(viewStructure, iIntValue, str, null, null);
        if (contentDataType != null) {
            numValueOf = Integer.valueOf(ContentDataType_androidKt.getDataType(contentDataType));
        } else if (z) {
            numValueOf = 1;
        } else {
            numValueOf = toggleableState != null ? Integer.valueOf(i) : null;
        }
        if (numValueOf != null) {
            autofillApi26Helper.setAutofillType(viewStructure, numValueOf.intValue());
        }
        if (annotatedString != null) {
            autofillApi26Helper.setAutofillValue(viewStructure, autofillApi26Helper.getAutofillTextValue(annotatedString.getText()));
        }
        if (androidFillableData != null) {
            autofillApi26Helper.setAutofillValue(viewStructure, androidFillableData.getAutofillValue());
        }
        if (contentType != null && (contentHints2 = ContentType_androidKt.getContentHints(contentType)) != null) {
            autofillApi26Helper.setAutofillHints(viewStructure, contentHints2);
        }
        rectManager.getRects().withRect(semanticsInfo.getSemanticsId(), new Function4<Integer, Integer, Integer, Integer, Unit>() { // from class: androidx.compose.ui.autofill.PopulateViewStructure_androidKt.populate.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num2, Integer num3, Integer num4, Integer num5) {
                invoke(num2.intValue(), num3.intValue(), num4.intValue(), num5.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i14, int i15, int i16, int i17) {
                autofillApi26Helper.setDimens(viewStructure, i14, i15, 0, 0, i16 - i14, i17 - i15);
            }
        });
        if (bool != null) {
            autofillApi26Helper.setSelected(viewStructure, bool.booleanValue());
        }
        if (toggleableState != null) {
            autofillApi26Helper.setCheckable(viewStructure, true);
            autofillApi26Helper.setChecked(viewStructure, toggleableState == ToggleableState.On);
        } else if (bool != null) {
            if (!(role == null ? false : Role.m8828equalsimpl0(role.getValue(), Role.INSTANCE.m8839getTabo7Vup1c()))) {
                autofillApi26Helper.setCheckable(viewStructure, true);
                autofillApi26Helper.setChecked(viewStructure, bool.booleanValue());
            }
        }
        String str4 = (String) ArraysKt.first(ContentType_androidKt.getContentHints(ContentType.INSTANCE.getPassword()));
        if (contentType != null && (contentHints = ContentType_androidKt.getContentHints(contentType)) != null) {
            boolean zContains = ArraysKt.contains(contentHints, str4);
            z3 = true;
            boolean z6 = zContains;
            if (!z2 || z6) {
                z4 = z3;
            } else {
                z4 = false;
            }
            if (!z4 || zBooleanValue) {
                z5 = z3;
            } else {
                z5 = false;
            }
            autofillApi26Helper.setDataIsSensitive(viewStructure, z5);
            if (semanticsInfo.isTransparent()) {
                i2 = 4;
            } else {
                i2 = 0;
            }
            autofillApi26Helper.setVisibility(viewStructure, i2);
            if (list != null) {
                size = list.size();
                str2 = "";
                for (i3 = 0; i3 < size; i3++) {
                    str2 = str2 + ((AnnotatedString) list.get(i3)).getText() + '\n';
                }
                autofillApi26Helper.setText(viewStructure, str2);
                autofillApi26Helper.setClassName(viewStructure, AndroidComposeViewAccessibilityDelegateCompat.TextClassName);
            }
            if (semanticsInfo.getChildrenInfo().isEmpty() && role != null && (strM8806toLegacyClassNameV4PA4sw = SemanticsUtils_androidKt.m8806toLegacyClassNameV4PA4sw(role.getValue())) != null) {
                autofillApi26Helper.setClassName(viewStructure, strM8806toLegacyClassNameV4PA4sw);
            }
            if (z) {
                autofillApi26Helper.setClassName(viewStructure, AndroidComposeViewAccessibilityDelegateCompat.TextFieldClassName);
                if (num != null) {
                    AutofillApi28Helper.INSTANCE.setMaxTextLength(viewStructure, num.intValue());
                }
                if (z4) {
                    autofillApi26Helper.setInputType(viewStructure, 129);
                }
            }
        }
        z3 = true;
        if (z2) {
            z4 = z3;
        } else {
            z4 = z3;
        }
        if (z4) {
            z5 = z3;
        } else {
            z5 = z3;
        }
        autofillApi26Helper.setDataIsSensitive(viewStructure, z5);
        if (semanticsInfo.isTransparent()) {
            i2 = 4;
        } else {
            i2 = 0;
        }
        autofillApi26Helper.setVisibility(viewStructure, i2);
        if (list != null) {
            size = list.size();
            str2 = "";
            while (i3 < size) {
                str2 = str2 + ((AnnotatedString) list.get(i3)).getText() + '\n';
            }
            autofillApi26Helper.setText(viewStructure, str2);
            autofillApi26Helper.setClassName(viewStructure, AndroidComposeViewAccessibilityDelegateCompat.TextClassName);
        }
        if (semanticsInfo.getChildrenInfo().isEmpty()) {
            autofillApi26Helper.setClassName(viewStructure, strM8806toLegacyClassNameV4PA4sw);
        }
        if (z) {
            autofillApi26Helper.setClassName(viewStructure, AndroidComposeViewAccessibilityDelegateCompat.TextFieldClassName);
            if (num != null) {
                AutofillApi28Helper.INSTANCE.setMaxTextLength(viewStructure, num.intValue());
            }
            if (z4) {
                autofillApi26Helper.setInputType(viewStructure, 129);
            }
        }
    }
}
