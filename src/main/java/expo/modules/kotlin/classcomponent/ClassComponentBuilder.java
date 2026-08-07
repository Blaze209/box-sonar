package expo.modules.kotlin.classcomponent;

import androidx.exifinterface.media.ExifInterface;
import com.microsoft.identity.common.internal.providers.oauth2.PasskeyWebListener;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ConcatIterator;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AnyFunction;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.FunctionBuilder;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis;
import expo.modules.kotlin.objects.PropertyComponentBuilderWithThis$get$1$1;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.sharedobjects.SharedObjectKt;
import expo.modules.kotlin.sharedobjects.SharedRefKt;
import expo.modules.kotlin.traits.Trait;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.ReturnType;
import expo.modules.kotlin.types.ReturnTypeProvider;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: ClassComponentBuilder.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B9\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u00103\u001a\u000204J\u0016\u00105\u001a\u0002062\u000e\u00107\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001cJ\u001c\u00108\u001a\u00020\u00152\u000e\b\u0004\u00109\u001a\b\u0012\u0004\u0012\u00028\u00000:H\u0086\bø\u0001\u0000J9\u00108\u001a\u00020\u0015\"\u0006\b\u0001\u0010;\u0018\u00012#\b\u0004\u00109\u001a\u001d\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0004\u0012\u00028\u00000<H\u0086\bø\u0001\u0000JV\u00108\u001a\u00020\u0015\"\u0006\b\u0001\u0010;\u0018\u0001\"\u0006\b\u0002\u0010?\u0018\u000128\b\u0004\u00109\u001a2\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0004\u0012\u00028\u00000@H\u0086\bø\u0001\u0000Js\u00108\u001a\u00020\u0015\"\u0006\b\u0001\u0010;\u0018\u0001\"\u0006\b\u0002\u0010?\u0018\u0001\"\u0006\b\u0003\u0010B\u0018\u00012M\b\u0004\u00109\u001aG\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0004\u0012\u00028\u00000CH\u0086\bø\u0001\u0000J\u0090\u0001\u00108\u001a\u00020\u0015\"\u0006\b\u0001\u0010;\u0018\u0001\"\u0006\b\u0002\u0010?\u0018\u0001\"\u0006\b\u0003\u0010B\u0018\u0001\"\u0006\b\u0004\u0010E\u0018\u00012b\b\u0004\u00109\u001a\\\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0004\u0012\u00028\u00000FH\u0086\bø\u0001\u0000J\u00ad\u0001\u00108\u001a\u00020\u0015\"\u0006\b\u0001\u0010;\u0018\u0001\"\u0006\b\u0002\u0010?\u0018\u0001\"\u0006\b\u0003\u0010B\u0018\u0001\"\u0006\b\u0004\u0010E\u0018\u0001\"\u0006\b\u0005\u0010H\u0018\u00012w\b\u0004\u00109\u001aq\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0004\u0012\u00028\u00000IH\u0086\bø\u0001\u0000JÌ\u0001\u00108\u001a\u00020\u0015\"\u0006\b\u0001\u0010;\u0018\u0001\"\u0006\b\u0002\u0010?\u0018\u0001\"\u0006\b\u0003\u0010B\u0018\u0001\"\u0006\b\u0004\u0010E\u0018\u0001\"\u0006\b\u0005\u0010H\u0018\u0001\"\u0006\b\u0006\u0010K\u0018\u00012\u008d\u0001\b\u0004\u00109\u001a\u0086\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0013\u0012\u0011HK¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(M\u0012\u0004\u0012\u00028\u00000LH\u0086\bø\u0001\u0000Jé\u0001\u00108\u001a\u00020\u0015\"\u0006\b\u0001\u0010;\u0018\u0001\"\u0006\b\u0002\u0010?\u0018\u0001\"\u0006\b\u0003\u0010B\u0018\u0001\"\u0006\b\u0004\u0010E\u0018\u0001\"\u0006\b\u0005\u0010H\u0018\u0001\"\u0006\b\u0006\u0010K\u0018\u0001\"\u0006\b\u0007\u0010N\u0018\u00012¢\u0001\b\u0004\u00109\u001a\u009b\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0013\u0012\u0011HK¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(M\u0012\u0013\u0012\u0011HN¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(P\u0012\u0004\u0012\u00028\u00000OH\u0086\bø\u0001\u0000J\u0086\u0002\u00108\u001a\u00020\u0015\"\u0006\b\u0001\u0010;\u0018\u0001\"\u0006\b\u0002\u0010?\u0018\u0001\"\u0006\b\u0003\u0010B\u0018\u0001\"\u0006\b\u0004\u0010E\u0018\u0001\"\u0006\b\u0005\u0010H\u0018\u0001\"\u0006\b\u0006\u0010K\u0018\u0001\"\u0006\b\u0007\u0010N\u0018\u0001\"\u0006\b\b\u0010Q\u0018\u00012·\u0001\b\u0004\u00109\u001a°\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0013\u0012\u0011HK¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(M\u0012\u0013\u0012\u0011HN¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(P\u0012\u0013\u0012\u0011HQ¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(S\u0012\u0004\u0012\u00028\u00000RH\u0086\bø\u0001\u0000JG\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000U\"\u0006\b\u0001\u0010V\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072#\b\u0004\u00109\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(W\u0012\u0004\u0012\u0002HV0<H\u0086\bø\u0001\u0000J\u0016\u0010T\u001a\b\u0012\u0004\u0012\u00028\u00000U2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010X\u001a\u00020(2\u0006\u0010\u0006\u001a\u00020\u0007J+\u0010X\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u00072\u0010\b\u0004\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020:H\u0087\bø\u0001\u0000¢\u0006\u0002\bYJ,\u0010X\u001a\u00020\u0015\"\u0006\b\u0001\u0010Z\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0004\u00109\u001a\b\u0012\u0004\u0012\u0002HZ0:H\u0086\bø\u0001\u0000JI\u0010X\u001a\u00020\u0015\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072#\b\u0004\u00109\u001a\u001d\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002HZ0<H\u0086\bø\u0001\u0000Jf\u0010X\u001a\u00020\u0015\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u000728\b\u0004\u00109\u001a2\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002HZ0@H\u0086\bø\u0001\u0000J\u0083\u0001\u0010X\u001a\u00020\u0015\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072M\b\u0004\u00109\u001aG\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002HZ0CH\u0086\bø\u0001\u0000J \u0001\u0010X\u001a\u00020\u0015\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072b\b\u0004\u00109\u001a\\\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0004\u0012\u0002HZ0FH\u0086\bø\u0001\u0000J½\u0001\u0010X\u001a\u00020\u0015\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u0001\"\u0006\b\u0006\u0010H\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072w\b\u0004\u00109\u001aq\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0004\u0012\u0002HZ0IH\u0086\bø\u0001\u0000JÜ\u0001\u0010X\u001a\u00020\u0015\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u0001\"\u0006\b\u0006\u0010H\u0018\u0001\"\u0006\b\u0007\u0010K\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u008d\u0001\b\u0004\u00109\u001a\u0086\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0013\u0012\u0011HK¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(M\u0012\u0004\u0012\u0002HZ0LH\u0086\bø\u0001\u0000Jù\u0001\u0010X\u001a\u00020\u0015\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u0001\"\u0006\b\u0006\u0010H\u0018\u0001\"\u0006\b\u0007\u0010K\u0018\u0001\"\u0006\b\b\u0010N\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072¢\u0001\b\u0004\u00109\u001a\u009b\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0013\u0012\u0011HK¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(M\u0012\u0013\u0012\u0011HN¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(P\u0012\u0004\u0012\u0002HZ0OH\u0086\bø\u0001\u0000J\u0096\u0002\u0010X\u001a\u00020\u0015\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u0001\"\u0006\b\u0006\u0010H\u0018\u0001\"\u0006\b\u0007\u0010K\u0018\u0001\"\u0006\b\b\u0010N\u0018\u0001\"\u0006\b\t\u0010Q\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072·\u0001\b\u0004\u00109\u001a°\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0013\u0012\u0011HK¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(M\u0012\u0013\u0012\u0011HN¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(P\u0012\u0013\u0012\u0011HQ¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(S\u0012\u0004\u0012\u0002HZ0RH\u0086\bø\u0001\u0000J\u000e\u0010[\u001a\u0002022\u0006\u0010\u0006\u001a\u00020\u0007J+\u0010[\u001a\u00020-2\u0006\u0010\u0006\u001a\u00020\u00072\u0010\b\u0004\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020:H\u0087\bø\u0001\u0000¢\u0006\u0002\b\\J,\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u000e\b\u0004\u00109\u001a\b\u0012\u0004\u0012\u0002HZ0:H\u0086\bø\u0001\u0000JI\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072#\b\u0004\u00109\u001a\u001d\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0004\u0012\u0002HZ0<H\u0086\bø\u0001\u0000Jf\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u000728\b\u0004\u00109\u001a2\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002HZ0@H\u0086\bø\u0001\u0000Jc\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u000728\b\u0004\u00109\u001a2\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u00110]¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0004\u0012\u0002HZ0@H\u0087\bø\u0001\u0000¢\u0006\u0002\b^J\u0083\u0001\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072M\b\u0004\u00109\u001aG\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002HZ0CH\u0086\bø\u0001\u0000J\u0080\u0001\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072M\b\u0004\u00109\u001aG\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110]¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002HZ0CH\u0087\bø\u0001\u0000¢\u0006\u0002\b^J \u0001\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072b\b\u0004\u00109\u001a\\\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0004\u0012\u0002HZ0FH\u0086\bø\u0001\u0000J\u009d\u0001\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072b\b\u0004\u00109\u001a\\\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110]¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0004\u0012\u0002HZ0FH\u0087\bø\u0001\u0000¢\u0006\u0002\b^J½\u0001\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u0001\"\u0006\b\u0006\u0010H\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072w\b\u0004\u00109\u001aq\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0004\u0012\u0002HZ0IH\u0086\bø\u0001\u0000Jº\u0001\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072w\b\u0004\u00109\u001aq\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110]¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0004\u0012\u0002HZ0IH\u0087\bø\u0001\u0000¢\u0006\u0002\b^JÜ\u0001\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u0001\"\u0006\b\u0006\u0010H\u0018\u0001\"\u0006\b\u0007\u0010K\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u008d\u0001\b\u0004\u00109\u001a\u0086\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0013\u0012\u0011HK¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(M\u0012\u0004\u0012\u0002HZ0LH\u0086\bø\u0001\u0000JÙ\u0001\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u0001\"\u0006\b\u0006\u0010H\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u008d\u0001\b\u0004\u00109\u001a\u0086\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110]¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(M\u0012\u0004\u0012\u0002HZ0LH\u0087\bø\u0001\u0000¢\u0006\u0002\b^Jù\u0001\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u0001\"\u0006\b\u0006\u0010H\u0018\u0001\"\u0006\b\u0007\u0010K\u0018\u0001\"\u0006\b\b\u0010N\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072¢\u0001\b\u0004\u00109\u001a\u009b\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0013\u0012\u0011HK¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(M\u0012\u0013\u0012\u0011HN¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(P\u0012\u0004\u0012\u0002HZ0OH\u0086\bø\u0001\u0000Jö\u0001\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u0001\"\u0006\b\u0006\u0010H\u0018\u0001\"\u0006\b\u0007\u0010K\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072¢\u0001\b\u0004\u00109\u001a\u009b\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0013\u0012\u0011HK¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110]¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(P\u0012\u0004\u0012\u0002HZ0OH\u0087\bø\u0001\u0000¢\u0006\u0002\b^J\u0096\u0002\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u0001\"\u0006\b\u0006\u0010H\u0018\u0001\"\u0006\b\u0007\u0010K\u0018\u0001\"\u0006\b\b\u0010N\u0018\u0001\"\u0006\b\t\u0010Q\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072·\u0001\b\u0004\u00109\u001a°\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0013\u0012\u0011HK¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(M\u0012\u0013\u0012\u0011HN¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(P\u0012\u0013\u0012\u0011HQ¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(S\u0012\u0004\u0012\u0002HZ0RH\u0086\bø\u0001\u0000J\u0093\u0002\u0010[\u001a\u00020-\"\u0006\b\u0001\u0010Z\u0018\u0001\"\u0006\b\u0002\u0010;\u0018\u0001\"\u0006\b\u0003\u0010?\u0018\u0001\"\u0006\b\u0004\u0010B\u0018\u0001\"\u0006\b\u0005\u0010E\u0018\u0001\"\u0006\b\u0006\u0010H\u0018\u0001\"\u0006\b\u0007\u0010K\u0018\u0001\"\u0006\b\b\u0010N\u0018\u00012\u0006\u0010\u0006\u001a\u00020\u00072·\u0001\b\u0004\u00109\u001a°\u0001\u0012\u0013\u0012\u0011H;¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(>\u0012\u0013\u0012\u0011H?¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(A\u0012\u0013\u0012\u0011HB¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(D\u0012\u0013\u0012\u0011HE¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(G\u0012\u0013\u0012\u0011HH¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(J\u0012\u0013\u0012\u0011HK¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(M\u0012\u0013\u0012\u0011HN¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(P\u0012\u0013\u0012\u00110]¢\u0006\f\b=\u0012\b\b\u0006\u0012\u0004\b\b(S\u0012\u0004\u0012\u0002HZ0RH\u0087\bø\u0001\u0000¢\u0006\u0002\b^R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001f\u0010\u001a\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001c0\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR0\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150 8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R0\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020(0 8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\"\u001a\u0004\b*\u0010$\"\u0004\b+\u0010&R0\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020-0 8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b.\u0010\"\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R\u001a\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u0002020 X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006_"}, d2 = {"Lexpo/modules/kotlin/classcomponent/ClassComponentBuilder;", "SharedObjectType", "", "Lexpo/modules/kotlin/objects/ObjectDefinitionBuilder;", "appContext", "Lexpo/modules/kotlin/AppContext;", "name", "", "ownerClass", "Lkotlin/reflect/KClass;", "ownerType", "Lexpo/modules/kotlin/types/AnyType;", "converters", "Lexpo/modules/kotlin/types/TypeConverterProvider;", "<init>", "(Lexpo/modules/kotlin/AppContext;Ljava/lang/String;Lkotlin/reflect/KClass;Lexpo/modules/kotlin/types/AnyType;Lexpo/modules/kotlin/types/TypeConverterProvider;)V", "getName", "()Ljava/lang/String;", "getOwnerType", "()Lexpo/modules/kotlin/types/AnyType;", "constructor", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getConstructor", "()Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "setConstructor", "(Lexpo/modules/kotlin/functions/SyncFunctionComponent;)V", "traits", "", "Lexpo/modules/kotlin/traits/Trait;", "getTraits", "()Ljava/util/List;", "staticSyncFunctions", "", "getStaticSyncFunctions$annotations", "()V", "getStaticSyncFunctions", "()Ljava/util/Map;", "setStaticSyncFunctions", "(Ljava/util/Map;)V", "staticSyncFunctionBuilder", "Lexpo/modules/kotlin/functions/FunctionBuilder;", "getStaticSyncFunctionBuilder$annotations", "getStaticSyncFunctionBuilder", "setStaticSyncFunctionBuilder", "staticAsyncFunctions", "Lexpo/modules/kotlin/functions/AsyncFunctionComponent;", "getStaticAsyncFunctions$annotations", "getStaticAsyncFunctions", "setStaticAsyncFunctions", "staticAsyncFunctionBuilders", "Lexpo/modules/kotlin/functions/AsyncFunctionBuilder;", "buildClass", "Lexpo/modules/kotlin/classcomponent/ClassDefinitionData;", "UseTrait", "", "trait", "Constructor", "body", "Lkotlin/Function0;", "P0", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "p0", "P1", "Lkotlin/Function2;", "p1", "P2", "Lkotlin/Function3;", "p2", "P3", "Lkotlin/Function4;", "p3", "P4", "Lkotlin/Function5;", "p4", "P5", "Lkotlin/Function6;", "p5", "P6", "Lkotlin/Function7;", "p6", "P7", "Lkotlin/Function8;", "p7", "Property", "Lexpo/modules/kotlin/objects/PropertyComponentBuilderWithThis;", ExifInterface.GPS_DIRECTION_TRUE, "owner", "StaticFunction", "StaticFunctionWithoutArgs", "R", "StaticAsyncFunction", "StaticAsyncFunctionWithoutArgs", "Lexpo/modules/kotlin/Promise;", "StaticAsyncFunctionWithPromise", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClassComponentBuilder<SharedObjectType> extends ObjectDefinitionBuilder {
    public static final int $stable = 8;
    private final AppContext appContext;
    private SyncFunctionComponent constructor;
    private final String name;
    private final KClass<SharedObjectType> ownerClass;
    private final AnyType ownerType;
    private Map<String, AsyncFunctionBuilder> staticAsyncFunctionBuilders;
    private Map<String, AsyncFunctionComponent> staticAsyncFunctions;
    private Map<String, FunctionBuilder> staticSyncFunctionBuilder;
    private Map<String, SyncFunctionComponent> staticSyncFunctions;
    private final List<Trait<? super SharedObjectType>> traits;

    public static /* synthetic */ void getStaticAsyncFunctions$annotations() {
    }

    public static /* synthetic */ void getStaticSyncFunctionBuilder$annotations() {
    }

    public static /* synthetic */ void getStaticSyncFunctions$annotations() {
    }

    public /* synthetic */ ClassComponentBuilder(AppContext appContext, String str, KClass kClass, AnyType anyType, TypeConverterProvider typeConverterProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(appContext, str, kClass, anyType, (i & 16) != 0 ? null : typeConverterProvider);
    }

    public final String getName() {
        return this.name;
    }

    public final AnyType getOwnerType() {
        return this.ownerType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClassComponentBuilder(AppContext appContext, String name, KClass<SharedObjectType> ownerClass, AnyType ownerType, TypeConverterProvider typeConverterProvider) {
        super(typeConverterProvider);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(ownerClass, "ownerClass");
        Intrinsics.checkNotNullParameter(ownerType, "ownerType");
        this.appContext = appContext;
        this.name = name;
        this.ownerClass = ownerClass;
        this.ownerType = ownerType;
        this.traits = new ArrayList();
        this.staticSyncFunctions = new LinkedHashMap();
        this.staticSyncFunctionBuilder = new LinkedHashMap();
        this.staticAsyncFunctions = new LinkedHashMap();
        this.staticAsyncFunctionBuilders = new LinkedHashMap();
    }

    public final SyncFunctionComponent getConstructor() {
        return this.constructor;
    }

    public final void setConstructor(SyncFunctionComponent syncFunctionComponent) {
        this.constructor = syncFunctionComponent;
    }

    public final List<Trait<? super SharedObjectType>> getTraits() {
        return this.traits;
    }

    public final Map<String, SyncFunctionComponent> getStaticSyncFunctions() {
        return this.staticSyncFunctions;
    }

    public final void setStaticSyncFunctions(Map<String, SyncFunctionComponent> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.staticSyncFunctions = map;
    }

    public final Map<String, FunctionBuilder> getStaticSyncFunctionBuilder() {
        return this.staticSyncFunctionBuilder;
    }

    public final void setStaticSyncFunctionBuilder(Map<String, FunctionBuilder> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.staticSyncFunctionBuilder = map;
    }

    public final Map<String, AsyncFunctionComponent> getStaticAsyncFunctions() {
        return this.staticAsyncFunctions;
    }

    public final void setStaticAsyncFunctions(Map<String, AsyncFunctionComponent> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.staticAsyncFunctions = map;
    }

    public final ClassDefinitionData buildClass() {
        boolean zAreEqual = Intrinsics.areEqual(this.ownerClass, Reflection.getOrCreateKotlinClass(Unit.class));
        boolean z = !zAreEqual && SharedObjectKt.isSharedObjectClass(this.ownerClass);
        boolean z2 = !zAreEqual && SharedRefKt.isSharedRefClass(this.ownerClass);
        Object next = null;
        if (getEventsDefinition() != null && z) {
            for (Pair pair : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to("__expo_onStartListeningToEvent", C18921.INSTANCE), TuplesKt.to("__expo_onStopListeningToEvent", C18932.INSTANCE)})) {
                String str = (String) pair.component1();
                final KFunction kFunction = (KFunction) pair.component2();
                AnyType[] anyTypeArr = new AnyType[2];
                anyTypeArr[0] = this.ownerType;
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$buildClass$lambda$2$$inlined$toAnyType$default$1
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }), null);
                }
                anyTypeArr[1] = anyType;
                ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
                ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
                if (returnType == null) {
                    returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                    returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType);
                }
                SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(str, anyTypeArr, returnType, new Function1() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ClassComponentBuilder.buildClass$lambda$2$lambda$0(kFunction, (Object[]) obj);
                    }
                });
                syncFunctionComponent.enumerable(false);
                getSyncFunctions().put(str, syncFunctionComponent);
            }
        }
        ObjectDefinitionData objectDefinitionDataBuildObject = buildObject();
        List<Trait<? super SharedObjectType>> list = this.traits;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((Trait) it.next()).export(this.appContext));
        }
        Iterator it2 = arrayList.iterator();
        if (it2.hasNext()) {
            next = it2.next();
            while (it2.hasNext()) {
                next = ((ObjectDefinitionData) next).plus((ObjectDefinitionData) it2.next());
            }
        }
        ObjectDefinitionData objectDefinitionDataPlus = objectDefinitionDataBuildObject.plus((ObjectDefinitionData) next);
        ConcatIterator<AnyFunction> functions = objectDefinitionDataPlus.getFunctions();
        while (functions.hasNext()) {
            AnyFunction next2 = functions.next();
            next2.setOwnerType(this.ownerType.getKType());
            next2.setCanTakeOwner(true);
        }
        if (!zAreEqual && this.constructor == null && !z2) {
            throw new IllegalArgumentException("constructor cannot be null");
        }
        SyncFunctionComponent syncFunctionComponent2 = this.constructor;
        if (syncFunctionComponent2 == null) {
            AnyType[] anyTypeArr2 = new AnyType[0];
            ReturnTypeProvider returnTypeProvider2 = ReturnTypeProvider.INSTANCE;
            ReturnType returnType2 = returnTypeProvider2.getTypes().get(Reflection.getOrCreateKotlinClass(Unit.class));
            if (returnType2 == null) {
                returnType2 = new ReturnType(Reflection.getOrCreateKotlinClass(Unit.class));
                returnTypeProvider2.getTypes().put(Reflection.getOrCreateKotlinClass(Unit.class), returnType2);
            }
            syncFunctionComponent2 = new SyncFunctionComponent("constructor", anyTypeArr2, returnType2, new Function1() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ClassComponentBuilder.buildClass$lambda$6((Object[]) obj);
                }
            });
        }
        SyncFunctionComponent syncFunctionComponent3 = syncFunctionComponent2;
        syncFunctionComponent3.setCanTakeOwner(true);
        syncFunctionComponent3.setOwnerType(this.ownerType.getKType());
        String str2 = this.name;
        Map<String, SyncFunctionComponent> map = this.staticSyncFunctions;
        Map<String, FunctionBuilder> map2 = this.staticSyncFunctionBuilder;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map2.size()));
        Iterator<T> it3 = map2.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            linkedHashMap.put(entry.getKey(), ((FunctionBuilder) entry.getValue()).build$expo_modules_core_release());
        }
        Map mapPlus = MapsKt.plus(map, linkedHashMap);
        Map<String, AsyncFunctionComponent> map3 = this.staticAsyncFunctions;
        Map<String, AsyncFunctionBuilder> map4 = this.staticAsyncFunctionBuilders;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(map4.size()));
        Iterator<T> it4 = map4.entrySet().iterator();
        while (it4.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it4.next();
            linkedHashMap2.put(entry2.getKey(), ((AsyncFunctionBuilder) entry2.getValue()).build$expo_modules_core_release());
        }
        return new ClassDefinitionData(str2, syncFunctionComponent3, mapPlus, MapsKt.plus(map3, linkedHashMap2), objectDefinitionDataPlus, z2);
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.classcomponent.ClassComponentBuilder$buildClass$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClassComponentBuilder.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class C18921 extends FunctionReferenceImpl implements Function2<SharedObject, String, Unit> {
        public static final C18921 INSTANCE = new C18921();

        C18921() {
            super(2, SharedObject.class, "onStartListeningToEvent", "onStartListeningToEvent(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(SharedObject sharedObject, String str) {
            invoke2(sharedObject, str);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SharedObject p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            p0.onStartListeningToEvent(p1);
        }
    }

    /* JADX INFO: renamed from: expo.modules.kotlin.classcomponent.ClassComponentBuilder$buildClass$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ClassComponentBuilder.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* synthetic */ class C18932 extends FunctionReferenceImpl implements Function2<SharedObject, String, Unit> {
        public static final C18932 INSTANCE = new C18932();

        C18932() {
            super(2, SharedObject.class, "onStopListeningToEvent", "onStopListeningToEvent(Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(SharedObject sharedObject, String str) {
            invoke2(sharedObject, str);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SharedObject p0, String p1) {
            Intrinsics.checkNotNullParameter(p0, "p0");
            Intrinsics.checkNotNullParameter(p1, "p1");
            p0.onStopListeningToEvent(p1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildClass$lambda$2$lambda$0(KFunction kFunction, Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
        ((Function2) kFunction).invoke(objArr[0], objArr[1]);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit buildClass$lambda$6(Object[] it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    public final void UseTrait(Trait<? super SharedObjectType> trait) {
        Intrinsics.checkNotNullParameter(trait, "trait");
        this.traits.add(trait);
    }

    public final SyncFunctionComponent Constructor(final Function0<? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        AnyType[] anyTypeArr = new AnyType[0];
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0> SyncFunctionComponent Constructor(final Function1<? super P0, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        AnyType[] anyTypeArr = new AnyType[1];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$1 classComponentBuilder$Constructor$$inlined$toArgsArray$default$1 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$1), converters);
        }
        anyTypeArr[0] = anyType;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.3
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1> SyncFunctionComponent Constructor(final Function2<? super P0, ? super P1, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$2 classComponentBuilder$Constructor$$inlined$toArgsArray$default$2 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$2), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$3 classComponentBuilder$Constructor$$inlined$toArgsArray$default$3 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$3), converters);
        }
        anyTypeArr[1] = anyType2;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.5
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2> SyncFunctionComponent Constructor(final Function3<? super P0, ? super P1, ? super P2, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        AnyType[] anyTypeArr = new AnyType[3];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$4 classComponentBuilder$Constructor$$inlined$toArgsArray$default$4 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$4), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$5 classComponentBuilder$Constructor$$inlined$toArgsArray$default$5 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$5), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$6 classComponentBuilder$Constructor$$inlined$toArgsArray$default$6 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$6), converters);
        }
        anyTypeArr[2] = anyType3;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.7
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3> SyncFunctionComponent Constructor(final Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        AnyType[] anyTypeArr = new AnyType[4];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$7 classComponentBuilder$Constructor$$inlined$toArgsArray$default$7 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$7), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$8 classComponentBuilder$Constructor$$inlined$toArgsArray$default$8 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$8), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$9 classComponentBuilder$Constructor$$inlined$toArgsArray$default$9 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$9), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$10 classComponentBuilder$Constructor$$inlined$toArgsArray$default$10 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$10), converters);
        }
        anyTypeArr[3] = anyType4;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.9
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4> SyncFunctionComponent Constructor(final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        AnyType[] anyTypeArr = new AnyType[5];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$11 classComponentBuilder$Constructor$$inlined$toArgsArray$default$11 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$11), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$12 classComponentBuilder$Constructor$$inlined$toArgsArray$default$12 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$12), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$13 classComponentBuilder$Constructor$$inlined$toArgsArray$default$13 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$13), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$14 classComponentBuilder$Constructor$$inlined$toArgsArray$default$14 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$14), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$15 classComponentBuilder$Constructor$$inlined$toArgsArray$default$15 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$15), converters);
        }
        anyTypeArr[4] = anyType5;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.11
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5> SyncFunctionComponent Constructor(final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends SharedObjectType> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        AnyType[] anyTypeArr = new AnyType[6];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$16 classComponentBuilder$Constructor$$inlined$toArgsArray$default$16 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$16), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$17 classComponentBuilder$Constructor$$inlined$toArgsArray$default$17 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$17), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$18 classComponentBuilder$Constructor$$inlined$toArgsArray$default$18 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$18), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$19 classComponentBuilder$Constructor$$inlined$toArgsArray$default$19 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$19), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$20 classComponentBuilder$Constructor$$inlined$toArgsArray$default$20 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$20), converters);
        }
        anyTypeArr[4] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$21 classComponentBuilder$Constructor$$inlined$toArgsArray$default$21 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$21), converters);
        }
        anyTypeArr[5] = anyType6;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.13
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6> SyncFunctionComponent Constructor(final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends SharedObjectType> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        AnyType[] anyTypeArr = new AnyType[7];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$22 classComponentBuilder$Constructor$$inlined$toArgsArray$default$22 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$22), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$23 classComponentBuilder$Constructor$$inlined$toArgsArray$default$23 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$23), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$24 classComponentBuilder$Constructor$$inlined$toArgsArray$default$24 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$24), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$25 classComponentBuilder$Constructor$$inlined$toArgsArray$default$25 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$25), converters);
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$26 classComponentBuilder$Constructor$$inlined$toArgsArray$default$26 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$26
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$26), converters);
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$27 classComponentBuilder$Constructor$$inlined$toArgsArray$default$27 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$27), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$28 classComponentBuilder$Constructor$$inlined$toArgsArray$default$28 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$28), converters);
        }
        anyTypeArr[6] = anyType7;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.15
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], (P6) objArr[6]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <P0, P1, P2, P3, P4, P5, P6, P7> SyncFunctionComponent Constructor(final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends SharedObjectType> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        Intrinsics.reifiedOperationMarker(4, "P7");
        AnyType[] anyTypeArr = new AnyType[8];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$29 classComponentBuilder$Constructor$$inlined$toArgsArray$default$29 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$29), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$30 classComponentBuilder$Constructor$$inlined$toArgsArray$default$30 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$30), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$31 classComponentBuilder$Constructor$$inlined$toArgsArray$default$31 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$31), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$32 classComponentBuilder$Constructor$$inlined$toArgsArray$default$32 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$32
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$32), converters);
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$33 classComponentBuilder$Constructor$$inlined$toArgsArray$default$33 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$33
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$33), converters);
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$34 classComponentBuilder$Constructor$$inlined$toArgsArray$default$34 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$34
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$34), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$35 classComponentBuilder$Constructor$$inlined$toArgsArray$default$35 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$35), converters);
        }
        anyTypeArr[6] = anyType7;
        AnyTypeProvider anyTypeProvider8 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType anyType8 = anyTypeProvider8.getTypesMap().get(new Pair(orCreateKotlinClass15, false));
        if (anyType8 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$36 classComponentBuilder$Constructor$$inlined$toArgsArray$default$36 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$Constructor$$inlined$toArgsArray$default$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P7");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P7");
            KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P7");
            anyType8 = new AnyType(new LazyKType(orCreateKotlinClass16, false, classComponentBuilder$Constructor$$inlined$toArgsArray$default$36), converters);
        }
        anyTypeArr[7] = anyType8;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent("constructor", anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.Constructor.17
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], (P6) objArr[6], (P7) objArr[7]);
            }
        });
        setConstructor(syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <T> PropertyComponentBuilderWithThis<SharedObjectType> Property(String name, Function1<? super SharedObjectType, ? extends T> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        PropertyComponentBuilderWithThis<SharedObjectType> propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis<>(getOwnerType().getKType(), name);
        AnyType[] anyTypeArr = {new AnyType(propertyComponentBuilderWithThis.getThisType(), null, 2, null)};
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(PasskeyWebListener.GET_UNIQUE_KEY, anyTypeArr, returnType, new PropertyComponentBuilderWithThis$get$1$1(body));
        syncFunctionComponent.setOwnerType(propertyComponentBuilderWithThis.getThisType());
        syncFunctionComponent.setCanTakeOwner(true);
        propertyComponentBuilderWithThis.setGetter(syncFunctionComponent);
        getProperties().put(name, propertyComponentBuilderWithThis);
        return propertyComponentBuilderWithThis;
    }

    @Override // expo.modules.kotlin.objects.ObjectDefinitionBuilder
    public PropertyComponentBuilderWithThis<SharedObjectType> Property(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        PropertyComponentBuilderWithThis<SharedObjectType> propertyComponentBuilderWithThis = new PropertyComponentBuilderWithThis<>(this.ownerType.getKType(), name);
        getProperties().put(name, propertyComponentBuilderWithThis);
        return propertyComponentBuilderWithThis;
    }

    public final FunctionBuilder StaticFunction(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        FunctionBuilder functionBuilder = new FunctionBuilder(name);
        this.staticSyncFunctionBuilder.put(name, functionBuilder);
        return functionBuilder;
    }

    public final SyncFunctionComponent StaticFunctionWithoutArgs(String name, final Function0<? extends Object> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        AnyType[] anyTypeArr = new AnyType[0];
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        ReturnType returnType = returnTypeProvider.getTypes().get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            returnTypeProvider.getTypes().put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticFunction.2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        getStaticSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R> SyncFunctionComponent StaticFunction(String name, final Function0<? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        AnyType[] anyTypeArr = new AnyType[0];
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticFunction.4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        getStaticSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> SyncFunctionComponent StaticFunction(String name, final Function1<? super P0, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        AnyType[] anyTypeArr = new AnyType[1];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$1 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$1 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$1), converters);
        }
        anyTypeArr[0] = anyType;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticFunction.6
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0]);
            }
        });
        getStaticSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> SyncFunctionComponent StaticFunction(String name, final Function2<? super P0, ? super P1, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$2 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$2 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$2), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$3 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$3 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$3), converters);
        }
        anyTypeArr[1] = anyType2;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticFunction.8
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1]);
            }
        });
        getStaticSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> SyncFunctionComponent StaticFunction(String name, final Function3<? super P0, ? super P1, ? super P2, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        AnyType[] anyTypeArr = new AnyType[3];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$4 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$4 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$4), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$5 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$5 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$5), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$6 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$6 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$6), converters);
        }
        anyTypeArr[2] = anyType3;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticFunction.10
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2]);
            }
        });
        getStaticSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> SyncFunctionComponent StaticFunction(String name, final Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        AnyType[] anyTypeArr = new AnyType[4];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$7 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$7 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$7), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$8 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$8 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$8), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$9 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$9 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$9), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$10 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$10 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$10), converters);
        }
        anyTypeArr[3] = anyType4;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticFunction.12
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3]);
            }
        });
        getStaticSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> SyncFunctionComponent StaticFunction(String name, final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        AnyType[] anyTypeArr = new AnyType[5];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$11 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$11 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$11), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$12 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$12 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$12), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$13 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$13 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$13), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$14 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$14 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$14), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$15 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$15 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$15), converters);
        }
        anyTypeArr[4] = anyType5;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticFunction.14
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4]);
            }
        });
        getStaticSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> SyncFunctionComponent StaticFunction(String name, final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        AnyType[] anyTypeArr = new AnyType[6];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$16 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$16 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$16), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$17 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$17 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$17), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$18 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$18 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$18), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$19 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$19 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$19), converters);
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$20 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$20 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$20), converters);
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$21 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$21 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$21), converters);
        }
        anyTypeArr[5] = anyType6;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticFunction.16
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5]);
            }
        });
        getStaticSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> SyncFunctionComponent StaticFunction(String name, final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        AnyType[] anyTypeArr = new AnyType[7];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$22 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$22 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$22), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$23 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$23 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$23), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$24 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$24 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$24), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$25 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$25 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$25), converters);
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$26 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$26 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$26
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$26), converters);
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$27 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$27 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$27), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$28 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$28 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$28), converters);
        }
        anyTypeArr[6] = anyType7;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticFunction.18
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], (P6) objArr[6]);
            }
        });
        getStaticSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> SyncFunctionComponent StaticFunction(String name, final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        Intrinsics.reifiedOperationMarker(4, "P7");
        AnyType[] anyTypeArr = new AnyType[8];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$29 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$29 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$29), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$30 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$30 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$30), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$31 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$31 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$31), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$32 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$32 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$32
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$32), converters);
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$33 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$33 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$33
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$33), converters);
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$34 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$34 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$34
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$34), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$35 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$35 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$35), converters);
        }
        anyTypeArr[6] = anyType7;
        AnyTypeProvider anyTypeProvider8 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType anyType8 = anyTypeProvider8.getTypesMap().get(new Pair(orCreateKotlinClass15, false));
        if (anyType8 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$36 classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$36 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticFunction$$inlined$toArgsArray$default$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P7");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P7");
            KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P7");
            anyType8 = new AnyType(new LazyKType(orCreateKotlinClass16, false, classComponentBuilder$StaticFunction$$inlined$toArgsArray$default$36), converters);
        }
        anyTypeArr[7] = anyType8;
        ReturnTypeProvider returnTypeProvider = ReturnTypeProvider.INSTANCE;
        Map<KClass<?>, ReturnType> types = returnTypeProvider.getTypes();
        Intrinsics.reifiedOperationMarker(4, "R");
        ReturnType returnType = types.get(Reflection.getOrCreateKotlinClass(Object.class));
        if (returnType == null) {
            Intrinsics.reifiedOperationMarker(4, "R");
            returnType = new ReturnType(Reflection.getOrCreateKotlinClass(Object.class));
            Map<KClass<?>, ReturnType> types2 = returnTypeProvider.getTypes();
            Intrinsics.reifiedOperationMarker(4, "R");
            types2.put(Reflection.getOrCreateKotlinClass(Object.class), returnType);
        }
        SyncFunctionComponent syncFunctionComponent = new SyncFunctionComponent(name, anyTypeArr, returnType, new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticFunction.20
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], (P6) objArr[6], (P7) objArr[7]);
            }
        });
        getStaticSyncFunctions().put(name, syncFunctionComponent);
        return syncFunctionComponent;
    }

    public final AsyncFunctionBuilder StaticAsyncFunction(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        AsyncFunctionBuilder asyncFunctionBuilder = new AsyncFunctionBuilder(name, getConverters());
        this.staticAsyncFunctionBuilders.put(name, asyncFunctionBuilder);
        return asyncFunctionBuilder;
    }

    public final AsyncFunctionComponent StaticAsyncFunctionWithoutArgs(String name, final Function0<? extends Object> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        });
        getStaticAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R> AsyncFunctionComponent StaticAsyncFunction(String name, final Function0<? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        AnyType[] anyTypeArr = new AnyType[0];
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.4
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return body.invoke();
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getStaticAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> AsyncFunctionComponent StaticAsyncFunction(String name, final Function1<? super P0, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.reifiedOperationMarker(4, "P0");
        if (!Intrinsics.areEqual(Object.class, Promise.class)) {
            TypeConverterProvider converters = getConverters();
            Intrinsics.reifiedOperationMarker(4, "P0");
            AnyType[] anyTypeArr = new AnyType[1];
            AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
            if (anyType == null) {
                Intrinsics.needClassReification();
                ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$1 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$1 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        Intrinsics.reifiedOperationMarker(6, "P0");
                        return null;
                    }
                };
                Intrinsics.reifiedOperationMarker(4, "P0");
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
                Intrinsics.reifiedOperationMarker(3, "P0");
                anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$1), converters);
            }
            anyTypeArr[0] = anyType;
            Intrinsics.needClassReification();
            Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.7
                /* JADX WARN: Type inference incomplete: some casts might be missing */
                @Override // kotlin.jvm.functions.Function1
                public final R invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    return body.invoke((P0) objArr[0]);
                }
            };
            Intrinsics.reifiedOperationMarker(3, "R");
            Intrinsics.reifiedOperationMarker(4, "R");
            if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
                untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
                untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
                untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, String.class)) {
                untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
            } else {
                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
            }
            asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
        } else {
            Intrinsics.needClassReification();
            asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.6
                /* JADX WARN: Type inference incomplete: some casts might be missing */
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Function1<P0, R> function2 = body;
                    Intrinsics.reifiedOperationMarker(1, "P0");
                    function2.invoke((P0) promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            });
        }
        getStaticAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunctionComponent StaticAsyncFunction(String name, final Function2<? super P0, ? super P1, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$2 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$2 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$2), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$3 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$3 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$3), converters);
        }
        anyTypeArr[1] = anyType2;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.9
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getStaticAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0> AsyncFunctionComponent StaticAsyncFunctionWithPromise(String name, final Function2<? super P0, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        AnyType[] anyTypeArr = new AnyType[1];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$4 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$4 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$4), converters);
        }
        anyTypeArr[0] = anyType;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.11
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        getStaticAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunctionComponent StaticAsyncFunction(String name, final Function3<? super P0, ? super P1, ? super P2, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        AnyType[] anyTypeArr = new AnyType[3];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$5 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$5 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$5), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$6 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$6 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$6), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$7 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$7 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$7), converters);
        }
        anyTypeArr[2] = anyType3;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.13
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getStaticAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1> AsyncFunctionComponent StaticAsyncFunctionWithPromise(String name, final Function3<? super P0, ? super P1, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        AnyType[] anyTypeArr = new AnyType[2];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$8 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$8 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$8), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$9 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$9 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$9), converters);
        }
        anyTypeArr[1] = anyType2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.15
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], (P1) objArr[1], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        getStaticAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunctionComponent StaticAsyncFunction(String name, final Function4<? super P0, ? super P1, ? super P2, ? super P3, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        AnyType[] anyTypeArr = new AnyType[4];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$10 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$10 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$10), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$11 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$11 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$11), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$12 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$12 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$12), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$13 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$13 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$13), converters);
        }
        anyTypeArr[3] = anyType4;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.17
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getStaticAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2> AsyncFunctionComponent StaticAsyncFunctionWithPromise(String name, final Function4<? super P0, ? super P1, ? super P2, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        AnyType[] anyTypeArr = new AnyType[3];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$14 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$14 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$14), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$15 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$15 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$15), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$16 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$16 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$16), converters);
        }
        anyTypeArr[2] = anyType3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.19
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        getStaticAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunctionComponent StaticAsyncFunction(String name, final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        AnyType[] anyTypeArr = new AnyType[5];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$17 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$17 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$17), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$18 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$18 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$18), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$19 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$19 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$19), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$20 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$20 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$20), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$21 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$21 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$21), converters);
        }
        anyTypeArr[4] = anyType5;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.21
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getStaticAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3> AsyncFunctionComponent StaticAsyncFunctionWithPromise(String name, final Function5<? super P0, ? super P1, ? super P2, ? super P3, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        AnyType[] anyTypeArr = new AnyType[4];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$22 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$22 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$22), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$23 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$23 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$23), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$24 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$24 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$24
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$24), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$25 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$25 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$25), converters);
        }
        anyTypeArr[3] = anyType4;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.23
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        getStaticAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunctionComponent StaticAsyncFunction(String name, final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? extends R> body) {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        AnyType[] anyTypeArr = new AnyType[6];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$26 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$26 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$26
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$26), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$27 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$27 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$27), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$28 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$28 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$28), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$29 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$29 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$29), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$30 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$30 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$30), converters);
        }
        anyTypeArr[4] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$31 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$31 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$31), converters);
        }
        anyTypeArr[5] = anyType6;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.25
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getStaticAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4> AsyncFunctionComponent StaticAsyncFunctionWithPromise(String name, final Function6<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super Promise, ? extends R> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        AnyType[] anyTypeArr = new AnyType[5];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$32 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$32 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$32
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$32), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$33 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$33 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$33
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$33), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$34 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$34 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$34
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$34), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$35 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$35 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$35), converters);
        }
        anyTypeArr[3] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$36 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$36 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$36
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$36), converters);
        }
        anyTypeArr[4] = anyType5;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.27
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], promise);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }
        });
        getStaticAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunctionComponent StaticAsyncFunction(String name, final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? extends R> body) {
        int i;
        int i2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        AnyType[] anyTypeArr = new AnyType[7];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$37 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$37 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$37
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$37), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$38 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$38 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$38
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$38), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$39 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$39 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$39
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$39), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$40 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$40 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$40
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$40), converters);
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$41 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$41 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$41
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$41), converters);
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$42 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$42 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$42
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$42), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$43 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$43 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$43
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$43), converters);
        }
        anyTypeArr[6] = anyType7;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.29
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], (P6) objArr[6]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
            untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(name, anyTypeArr, function1);
        } else if (Intrinsics.areEqual(Object.class, String.class)) {
            untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(name, anyTypeArr, function1);
        } else {
            untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(name, anyTypeArr, function1);
        }
        getStaticAsyncFunctions().put(name, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5> AsyncFunctionComponent StaticAsyncFunctionWithPromise(String name, final Function7<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super Promise, ? extends R> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        AnyType[] anyTypeArr = new AnyType[6];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$44 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$44 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$44
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$44), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$45 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$45 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$45
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$45), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$46 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$46 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$46
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$46), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$47 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$47 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$47
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$47), converters);
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$48 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$48 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$48
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$48), converters);
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$49 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$49 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$49
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$49), converters);
        }
        anyTypeArr[5] = anyType6;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.31
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], promise);
            }
        });
        getStaticAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6, P7> AsyncFunctionComponent StaticAsyncFunction(String name, final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super P7, ? extends R> body) {
        int i;
        int i2;
        String str;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        Intrinsics.reifiedOperationMarker(4, "P7");
        AnyType[] anyTypeArr = new AnyType[8];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$50 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$50 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$50
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$50), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$51 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$51 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$51
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$51), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$52 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$52 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$52
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$52), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$53 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$53 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$53
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$53), converters);
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$54 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$54 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$54
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$54), converters);
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$55 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$55 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$55
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$55), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$56 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$56 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$56
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$56), converters);
        }
        anyTypeArr[6] = anyType7;
        AnyTypeProvider anyTypeProvider8 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P7");
        KClass orCreateKotlinClass15 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P7");
        AnyType anyType8 = anyTypeProvider8.getTypesMap().get(new Pair(orCreateKotlinClass15, false));
        if (anyType8 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$57 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$57 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$57
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P7");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P7");
            KClass orCreateKotlinClass16 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P7");
            anyType8 = new AnyType(new LazyKType(orCreateKotlinClass16, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$57), converters);
        }
        anyTypeArr[7] = anyType8;
        Intrinsics.needClassReification();
        Function1<Object[], R> function1 = new Function1<Object[], R>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.33
            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // kotlin.jvm.functions.Function1
            public final R invoke(Object[] objArr) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                return body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], (P6) objArr[6], (P7) objArr[7]);
            }
        };
        Intrinsics.reifiedOperationMarker(3, "R");
        Intrinsics.reifiedOperationMarker(4, "R");
        if (Intrinsics.areEqual(Object.class, Integer.TYPE)) {
            str = name;
            untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(str, anyTypeArr, function1);
        } else {
            str = name;
            if (Intrinsics.areEqual(Object.class, Boolean.TYPE)) {
                untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(str, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, Double.TYPE)) {
                untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(str, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, Float.TYPE)) {
                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(str, anyTypeArr, function1);
            } else if (Intrinsics.areEqual(Object.class, String.class)) {
                untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(str, anyTypeArr, function1);
            } else {
                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(str, anyTypeArr, function1);
            }
        }
        getStaticAsyncFunctions().put(str, untypedAsyncFunctionComponent);
        return untypedAsyncFunctionComponent;
    }

    public final /* synthetic */ <R, P0, P1, P2, P3, P4, P5, P6> AsyncFunctionComponent StaticAsyncFunctionWithPromise(String name, final Function8<? super P0, ? super P1, ? super P2, ? super P3, ? super P4, ? super P5, ? super P6, ? super Promise, ? extends R> body) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        TypeConverterProvider converters = getConverters();
        Intrinsics.reifiedOperationMarker(4, "P0");
        Intrinsics.reifiedOperationMarker(4, "P1");
        Intrinsics.reifiedOperationMarker(4, "P2");
        Intrinsics.reifiedOperationMarker(4, "P3");
        Intrinsics.reifiedOperationMarker(4, "P4");
        Intrinsics.reifiedOperationMarker(4, "P5");
        Intrinsics.reifiedOperationMarker(4, "P6");
        AnyType[] anyTypeArr = new AnyType[7];
        AnyTypeProvider anyTypeProvider = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P0");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P0");
        AnyType anyType = anyTypeProvider.getTypesMap().get(new Pair(orCreateKotlinClass, false));
        if (anyType == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$58 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$58 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$58
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P0");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P0");
            KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P0");
            anyType = new AnyType(new LazyKType(orCreateKotlinClass2, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$58), converters);
        }
        anyTypeArr[0] = anyType;
        AnyTypeProvider anyTypeProvider2 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P1");
        KClass orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P1");
        AnyType anyType2 = anyTypeProvider2.getTypesMap().get(new Pair(orCreateKotlinClass3, false));
        if (anyType2 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$59 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$59 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$59
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P1");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P1");
            KClass orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P1");
            anyType2 = new AnyType(new LazyKType(orCreateKotlinClass4, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$59), converters);
        }
        anyTypeArr[1] = anyType2;
        AnyTypeProvider anyTypeProvider3 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P2");
        KClass orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P2");
        AnyType anyType3 = anyTypeProvider3.getTypesMap().get(new Pair(orCreateKotlinClass5, false));
        if (anyType3 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$60 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$60 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$60
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P2");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P2");
            KClass orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P2");
            anyType3 = new AnyType(new LazyKType(orCreateKotlinClass6, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$60), converters);
        }
        anyTypeArr[2] = anyType3;
        AnyTypeProvider anyTypeProvider4 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P3");
        KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P3");
        AnyType anyType4 = anyTypeProvider4.getTypesMap().get(new Pair(orCreateKotlinClass7, false));
        if (anyType4 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$61 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$61 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$61
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P3");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P3");
            KClass orCreateKotlinClass8 = Reflection.getOrCreateKotlinClass(Object.class);
            i = 3;
            Intrinsics.reifiedOperationMarker(3, "P3");
            anyType4 = new AnyType(new LazyKType(orCreateKotlinClass8, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$61), converters);
        } else {
            i = 3;
        }
        anyTypeArr[i] = anyType4;
        AnyTypeProvider anyTypeProvider5 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P4");
        KClass orCreateKotlinClass9 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(i, "P4");
        AnyType anyType5 = anyTypeProvider5.getTypesMap().get(new Pair(orCreateKotlinClass9, false));
        if (anyType5 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$62 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$62 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$62
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P4");
                    return null;
                }
            };
            i2 = 4;
            Intrinsics.reifiedOperationMarker(4, "P4");
            KClass orCreateKotlinClass10 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P4");
            anyType5 = new AnyType(new LazyKType(orCreateKotlinClass10, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$62), converters);
        } else {
            i2 = 4;
        }
        anyTypeArr[i2] = anyType5;
        AnyTypeProvider anyTypeProvider6 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(i2, "P5");
        KClass orCreateKotlinClass11 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P5");
        AnyType anyType6 = anyTypeProvider6.getTypesMap().get(new Pair(orCreateKotlinClass11, false));
        if (anyType6 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$63 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$63 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$63
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P5");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P5");
            KClass orCreateKotlinClass12 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P5");
            anyType6 = new AnyType(new LazyKType(orCreateKotlinClass12, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$63), converters);
        }
        anyTypeArr[5] = anyType6;
        AnyTypeProvider anyTypeProvider7 = AnyTypeProvider.INSTANCE;
        Intrinsics.reifiedOperationMarker(4, "P6");
        KClass orCreateKotlinClass13 = Reflection.getOrCreateKotlinClass(Object.class);
        Intrinsics.reifiedOperationMarker(3, "P6");
        AnyType anyType7 = anyTypeProvider7.getTypesMap().get(new Pair(orCreateKotlinClass13, false));
        if (anyType7 == null) {
            Intrinsics.needClassReification();
            ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$64 classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$64 = new Function0<KType>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$64
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    Intrinsics.reifiedOperationMarker(6, "P6");
                    return null;
                }
            };
            Intrinsics.reifiedOperationMarker(4, "P6");
            KClass orCreateKotlinClass14 = Reflection.getOrCreateKotlinClass(Object.class);
            Intrinsics.reifiedOperationMarker(3, "P6");
            anyType7 = new AnyType(new LazyKType(orCreateKotlinClass14, false, classComponentBuilder$StaticAsyncFunction$$inlined$toArgsArray$default$64), converters);
        }
        anyTypeArr[6] = anyType7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(name, anyTypeArr, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.kotlin.classcomponent.ClassComponentBuilder.StaticAsyncFunction.35
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                invoke2(objArr, promise);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object[] objArr, Promise promise) {
                Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                Intrinsics.checkNotNullParameter(promise, "promise");
                body.invoke((P0) objArr[0], (P1) objArr[1], (P2) objArr[2], (P3) objArr[3], (P4) objArr[4], (P5) objArr[5], (P6) objArr[6], promise);
            }
        });
        getStaticAsyncFunctions().put(name, asyncFunctionWithPromiseComponent);
        return asyncFunctionWithPromiseComponent;
    }
}
