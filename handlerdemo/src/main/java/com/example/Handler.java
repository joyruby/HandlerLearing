package com.example;

/**
 * Created by whrwhr446 on 11/05/2017.
 */

public  class Handler {

    public Handler() {
    }
    public void handlerMessage(Message msg){

    }

    public void sendMessage(Message msg){
        handlerMessage(msg);
    }
    public void multiThreadTest(){
        System.out.println("currentThread:"+Thread.currentThread().getName());
    }
}
