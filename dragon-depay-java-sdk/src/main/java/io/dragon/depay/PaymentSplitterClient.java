package io.dragon.depay;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dragon.depay.exception.DepaySDKException;
import io.dragon.depay.model.*;
import io.dragon.depay.util.SignUtil;
import okhttp3.*;

import java.io.IOException;
import java.util.UUID;

public class PaymentSplitterClient {
    private final String baseUrl="https://dragonpro.cc/api/v1.0.0/deploy";
    private final String apiKey;
    private final OkHttpClient httpClient;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public PaymentSplitterClient(String apiKey) {
        this.apiKey=apiKey;
        this.httpClient = new OkHttpClient();
    }

    public DepayResponse<PlatformFee> queryPlatformFee(
            PlatformFeeDTO dto) throws DepaySDKException, JsonProcessingException {
        String url = baseUrl + "/queryPlatformFee";
        String jsonBody = objectMapper.writeValueAsString(dto);
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(jsonBody, MediaType.get("application/json")))
                .build();
        return executeRequest(request, new TypeReference<DepayResponse<PlatformFee>>() {});
    }

    public DepayResponse<PaymentSplitterConfig> queryPaymentSplitterConfig(
            PaymentSplitterConfigDTO dto) throws DepaySDKException, JsonProcessingException {
        String url = baseUrl + "/queryPaymentSplitterConfig";
        String jsonBody = objectMapper.writeValueAsString(dto);
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(jsonBody, MediaType.get("application/json")))
                .build();
        return executeRequest(request, new TypeReference<DepayResponse<PaymentSplitterConfig>>() {});
    }

    public DepayResponse<DeployInitCodeResultDTO> generateDeployInitCode(
            DeployInitCodeDTO dto) throws DepaySDKException, JsonProcessingException {

            String url = baseUrl + "/generateDeployInitCode";
            String jsonBody = objectMapper.writeValueAsString(dto);

            String uuid= UUID.randomUUID().toString();
            String timestamp=Long.toString(System.currentTimeMillis());
            String msg=jsonBody+":"+uuid+":"+timestamp;
            String sign= SignUtil.sign(apiKey,msg);

            Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(jsonBody, MediaType.get("application/json")))
                .addHeader("uuid", uuid)
                .addHeader("timestamp", timestamp)
                .addHeader("sign", sign)
                .build();

            return executeRequest(request,
                    new TypeReference<DepayResponse<DeployInitCodeResultDTO>>() {}
            );
    }
    
    private <T> T executeRequest(Request request, TypeReference<T> typeRef) throws DepaySDKException {
        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new DepaySDKException("HTTP error: " + response.code());
            }
            String responseBody = response.body().string();
            return objectMapper.readValue(responseBody, typeRef);
        } catch (IOException e) {
            throw new DepaySDKException("Network error", e);
        }
    }

    private <T, R> R executePostRequest(String url, T dto, TypeReference<R> typeRef)
            throws DepaySDKException, JsonProcessingException {

        String jsonBody = objectMapper.writeValueAsString(dto);
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(jsonBody, MediaType.get("application/json")))
                .build();

        return executeRequest(request, typeRef);
    }
}
