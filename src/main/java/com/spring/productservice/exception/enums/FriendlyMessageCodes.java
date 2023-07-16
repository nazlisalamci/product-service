package com.spring.productservice.exception.enums;

public enum FriendlyMessageCodes implements IFriendlyMessageCode {
    OK(1000),
    Error(1001),
    PRODUCT_NOT_CREATED_EXCEPTION(1500),
    SUCCESS(1002),
    PRODUCT_SUCCESSFULLY_CREATED(1501);
    private final int value;

    FriendlyMessageCodes(int value){
        this.value=value;
    }

    @Override
    public int getFriendlyMessageCode() {
        return value;
    }
    
}
