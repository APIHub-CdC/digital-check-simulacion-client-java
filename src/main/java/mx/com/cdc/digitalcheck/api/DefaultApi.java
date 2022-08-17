package mx.com.cdc.digitalcheck.api;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import mx.com.cdc.digitalcheck.client.ApiCallback;
import mx.com.cdc.digitalcheck.client.ApiClient;
import mx.com.cdc.digitalcheck.client.ApiException;
import mx.com.cdc.digitalcheck.client.ApiResponse;
import mx.com.cdc.digitalcheck.client.Configuration;
import mx.com.cdc.digitalcheck.client.Pair;
import mx.com.cdc.digitalcheck.client.ProgressRequestBody;
import mx.com.cdc.digitalcheck.client.ProgressResponseBody;
import mx.com.cdc.digitalcheck.model.Otorgante;
import mx.com.cdc.digitalcheck.model.Response;
import mx.com.cdc.digitalcheck.model.ResponseError;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultApi {
    private ApiClient apiClient;
    public DefaultApi() {
        this(Configuration.getDefaultApiClient());
    }
    public DefaultApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    
    public okhttp3.Call fullfraudCall(String xApiKey, Otorgante body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        String localVarPath = "/fullfraud";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    @SuppressWarnings("rawtypes")
    private okhttp3.Call fullfraudValidateBeforeCall(String xApiKey, Otorgante body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling fullfraud(Async)");
        }
        
        okhttp3.Call call = fullfraudCall(xApiKey, body, progressListener, progressRequestListener);
        return call;
    }
    
    public Response fullfraud(String xApiKey, Otorgante body) throws ApiException {
        ApiResponse<Response> resp = fullfraudWithHttpInfo(xApiKey, body);
        return resp.getData();
    }
    
    public ApiResponse<Response> fullfraudWithHttpInfo(String xApiKey, Otorgante body) throws ApiException {
        okhttp3.Call call = fullfraudValidateBeforeCall(xApiKey, body, null, null);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
    
    public okhttp3.Call fullfraudAsync(String xApiKey, Otorgante body, final ApiCallback<Response> callback) throws ApiException {
        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;
        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };
            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }
        okhttp3.Call call = fullfraudValidateBeforeCall(xApiKey, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Response>(){}.getType();
        apiClient.execute(call, localVarReturnType);
        return call;
    }
}
