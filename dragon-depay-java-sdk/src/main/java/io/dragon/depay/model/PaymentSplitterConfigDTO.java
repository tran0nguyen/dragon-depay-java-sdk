package io.dragon.depay.model;

public class PaymentSplitterConfigDTO {
    private String chain;
    private Integer env;

    public String getChain() {
        return chain;
    }

    public void setChain(String chain) {
        this.chain = chain;
    }

    public Integer getEnv() {
        return env;
    }

    public void setEnv(Integer env) {
        this.env = env;
    }
}
