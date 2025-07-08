package io.dragon.depay;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.dragon.depay.constant.Constant;
import io.dragon.depay.exception.DepaySDKException;
import io.dragon.depay.model.*;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;

public class SdkExample {
    final String apiAddress="${your address}";
    final String apiKey="${your api key}";

    @Test
    public void queryPlatformFee(){
        PaymentSplitterClient client = new PaymentSplitterClient(apiKey);
        PlatformFeeDTO dto=new PlatformFeeDTO();
        dto.setChain("ETH");
        dto.setEnv(1);

        try{
            DepayResponse<PlatformFee> response=client.queryPlatformFee(dto);
            System.out.println("rate: " + response.data.getRate());
        }catch (DepaySDKException | JsonProcessingException e){
            System.err.println("SDK Error: " + e.getMessage());
        }
    }

    @Test
    public void queryPaymentSplitterConfig(){
        PaymentSplitterClient client = new PaymentSplitterClient(apiKey);
        PaymentSplitterConfigDTO dto=new PaymentSplitterConfigDTO();
        dto.setChain("ETH");
        dto.setEnv(1);

        try{
            DepayResponse<PaymentSplitterConfig> response=client.queryPaymentSplitterConfig(dto);
            System.out.println("logic: " + response.data.getLogic());
        }catch (DepaySDKException | JsonProcessingException e){
            System.err.println("SDK Error: " + e.getMessage());
        }
    }

    @Test
    public void generateDeployInitCode(){
        PaymentSplitterClient client = new PaymentSplitterClient(apiKey);

        DeployInitCodeDTO dto = new DeployInitCodeDTO();
        dto.setChain("ETH");
        dto.setEnv(1);
        dto.setApiAddress(apiAddress);
        dto.setNonce(System.currentTimeMillis());
        dto.setContractAlias("test");
        dto.setMerchantAddress("0xe1fd94f8874d698567e03f671a8c62e4e2e4be90");
        dto.setPayeeList(Arrays.asList(apiAddress,"0xe1fd94f8874d698567e03f671a8c62e4e2e4be90"));
        dto.setShareList(Arrays.asList(BigInteger.valueOf(20),BigInteger.valueOf(9980)));

        try {
            DepayResponse<DeployInitCodeResultDTO> response = client.generateDeployInitCode(dto);

            if (response.code== Constant.CODE_SUCCESS) {
                System.out.println("Deploy Bin: " + response.data.getBin());
                System.out.println("Payees: " + response.data.getPayees());
            } else {
                System.err.println("Error: " + response.msg);
            }
        } catch (DepaySDKException | JsonProcessingException e) {
            System.err.println("SDK Error: " + e.getMessage());
        }
    }

}