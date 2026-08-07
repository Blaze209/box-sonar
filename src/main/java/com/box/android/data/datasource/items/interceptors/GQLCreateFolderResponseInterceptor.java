package com.box.android.data.datasource.items.interceptors;

import com.apollographql.apollo3.api.Error;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.data.CreateFolderMutation;
import com.box.android.data.datasource.ItemRemoteDataSource;
import com.box.android.data.datasource.errors.CreateFolderRemoteError;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.data.datasource.gql.GQLBaseInterceptor;
import com.box.android.data.datasource.gql.GQLRequestParser;
import com.box.android.data.mappers.GQLCreateFolderToFolderDTOMapper;
import com.box.android.data.mappers.GraphQLMapper;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.android.domain.utils.result.Result;
import com.squareup.moshi.Moshi;
import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: GQLCreateFolderResponseInterceptor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J,\u0010\u0010\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/box/android/data/datasource/items/interceptors/GQLCreateFolderResponseInterceptor;", "Lcom/box/android/data/datasource/gql/GQLBaseInterceptor;", "itemRemoteDataSource", "Lcom/box/android/data/datasource/ItemRemoteDataSource;", "requestParser", "Lcom/box/android/data/datasource/gql/GQLRequestParser;", "moshi", "Lcom/squareup/moshi/Moshi;", "<init>", "(Lcom/box/android/data/datasource/ItemRemoteDataSource;Lcom/box/android/data/datasource/gql/GQLRequestParser;Lcom/squareup/moshi/Moshi;)V", "getMoshi", "()Lcom/squareup/moshi/Moshi;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "createFolder", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/data/CreateFolderMutation$Value;", "Lcom/box/android/data/datasource/errors/RemoteError;", BoxCommonConstants.EXTRA_FOLDER_NAME, "", "parentFolderId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GQLCreateFolderResponseInterceptor extends GQLBaseInterceptor {
    private final ItemRemoteDataSource itemRemoteDataSource;
    private final Moshi moshi;
    private final GQLRequestParser requestParser;

    /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLCreateFolderResponseInterceptor$createFolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: GQLCreateFolderResponseInterceptor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLCreateFolderResponseInterceptor", f = "GQLCreateFolderResponseInterceptor.kt", i = {0, 0}, l = {69}, m = "createFolder", n = {BoxCommonConstants.EXTRA_FOLDER_NAME, "parentFolderId"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GQLCreateFolderResponseInterceptor.this.createFolder(null, null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public GQLCreateFolderResponseInterceptor(ItemRemoteDataSource itemRemoteDataSource, GQLRequestParser requestParser, Moshi moshi) {
        super(moshi);
        Intrinsics.checkNotNullParameter(itemRemoteDataSource, "itemRemoteDataSource");
        Intrinsics.checkNotNullParameter(requestParser, "requestParser");
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        this.itemRemoteDataSource = itemRemoteDataSource;
        this.requestParser = requestParser;
        this.moshi = moshi;
    }

    @Override // com.box.android.data.datasource.gql.GQLBaseInterceptor
    public Moshi getMoshi() {
        return this.moshi;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws InterruptedException, IOException {
        String str;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        String parentId = this.requestParser.parseParentId(request);
        String name = this.requestParser.parseName(request);
        String str2 = parentId;
        if (str2 == null || StringsKt.isBlank(str2) || (str = name) == null || StringsKt.isBlank(str)) {
            throw new IOException("unexpected value for parentId or name (null)");
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 200;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        BuildersKt__BuildersKt.runBlocking$default(null, new C11681(name, parentId, objectRef, intRef, objectRef2, null), 1, null);
        return getResponse(intRef.element, chain.request(), (Error) objectRef2.element, new CreateFolderMutation.Data(new CreateFolderMutation.CreateFolder((CreateFolderMutation.Value) objectRef.element)));
    }

    /* JADX INFO: renamed from: com.box.android.data.datasource.items.interceptors.GQLCreateFolderResponseInterceptor$intercept$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: GQLCreateFolderResponseInterceptor.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.datasource.items.interceptors.GQLCreateFolderResponseInterceptor$intercept$1", f = "GQLCreateFolderResponseInterceptor.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class C11681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit, ? extends Unit>>, Object> {
        final /* synthetic */ Ref.ObjectRef<CreateFolderMutation.Value> $mutation;
        final /* synthetic */ String $name;
        final /* synthetic */ String $parentId;
        final /* synthetic */ Ref.ObjectRef<Error> $responseError;
        final /* synthetic */ Ref.IntRef $statusCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11681(String str, String str2, Ref.ObjectRef<CreateFolderMutation.Value> objectRef, Ref.IntRef intRef, Ref.ObjectRef<Error> objectRef2, Continuation<? super C11681> continuation) {
            super(2, continuation);
            this.$name = str;
            this.$parentId = str2;
            this.$mutation = objectRef;
            this.$statusCode = intRef;
            this.$responseError = objectRef2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GQLCreateFolderResponseInterceptor.this.new C11681(this.$name, this.$parentId, this.$mutation, this.$statusCode, this.$responseError, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Unit, ? extends Unit>> continuation) {
            return invoke2(coroutineScope, (Continuation<? super Result<Unit, Unit>>) continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<Unit, Unit>> continuation) {
            return ((C11681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r5v4, types: [T, com.apollographql.apollo3.api.Error] */
        /* JADX WARN: Type inference failed for: r6v17, types: [T, com.box.android.data.CreateFolderMutation$Value] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = GQLCreateFolderResponseInterceptor.this.createFolder(this.$name, this.$parentId, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.Success success = (Result) obj;
            Ref.ObjectRef<CreateFolderMutation.Value> objectRef = this.$mutation;
            if (success instanceof Result.Success) {
                objectRef.element = (CreateFolderMutation.Value) ((Result.Success) success).getValue();
                success = new Result.Success(Unit.INSTANCE);
            } else if (!(success instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            Ref.IntRef intRef = this.$statusCode;
            Ref.ObjectRef<Error> objectRef2 = this.$responseError;
            GQLCreateFolderResponseInterceptor gQLCreateFolderResponseInterceptor = GQLCreateFolderResponseInterceptor.this;
            if (success instanceof Result.Success) {
                return success;
            }
            if (success instanceof Result.Error) {
                RemoteError remoteError = (RemoteError) ((Result.Error) success).getValue();
                intRef.element = remoteError.getCode();
                if ((remoteError instanceof CreateFolderRemoteError) || intRef.element == 409) {
                    objectRef2.element = gQLCreateFolderResponseInterceptor.getError(remoteError);
                    return new Result.Error(Unit.INSTANCE);
                }
                throw new IOException(remoteError + " Code: " + remoteError.getCode());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object createFolder(String str, String str2, Continuation<? super Result<CreateFolderMutation.Value, ? extends RemoteError>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objCreateFolder = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objCreateFolder);
            ItemRemoteDataSource itemRemoteDataSource = this.itemRemoteDataSource;
            ItemId.Remote remote = new ItemId.Remote(str2, ItemType.FOLDER);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(str2);
            anonymousClass1.label = 1;
            objCreateFolder = itemRemoteDataSource.createFolder(str, remote, anonymousClass1);
            if (objCreateFolder == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objCreateFolder);
        }
        Result result = (Result) objCreateFolder;
        if (result instanceof Result.Success) {
            return new Result.Success(GraphQLMapper.toGraphQL$default(GQLCreateFolderToFolderDTOMapper.INSTANCE, ((Result.Success) result).getValue(), null, 2, null));
        }
        if (result instanceof Result.Error) {
            return new Result.Error(((Result.Error) result).getValue());
        }
        throw new NoWhenBranchMatchedException();
    }
}
