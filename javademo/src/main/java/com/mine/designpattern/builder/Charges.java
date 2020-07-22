package com.mine.designpattern.builder;

/**
 * Created by jiayq24996 on 2020-05-19
 */
public class Charges {
    /**
     * 参数类
     */
    private static class ChargesParams {

        String id;
        String crete;
        String channel;
        String orderId;
        String amount;
        String clienIp;
        String body;

    }

    public static class Builder {
        private ChargesParams params;

        public Builder id(String id) {
            this.params.id = id;
            return this;
        }
    }

    public static void main(String[] args) {
        new Charges.Builder().id("");
    }
}
