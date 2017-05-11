package com.example;

/**
 * Created by whrwhr446 on 11/05/2017.
 */

public class MessageQueue {

    public Message mMessage;
    //push the msg in last
    public void enqueueMessage(Message msg){
        synchronized (this){
            Message p = mMessage;
            if(p == null){
                msg.next = p;
                mMessage = msg;
            }else {
                Message prev = null;
                //get last message
                while (p != null){
                    prev = p;
                    p = p.next;
                }
                msg.next = prev.next;
                prev.next = msg;
            }
        }
    }
    public Message next(){
        if(mMessage == null) return null;
        Message first = mMessage;
        mMessage = mMessage.next;
        return first;
    }
}
