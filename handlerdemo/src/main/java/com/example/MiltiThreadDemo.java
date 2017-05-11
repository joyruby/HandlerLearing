package com.example;

public class MiltiThreadDemo {

    public static void main(String [] args){
        final Handler handler = new Handler(){

            @Override
            public void handlerMessage(Message msg) {
                super.handlerMessage(msg);
                if(msg != null){
                    switch (msg.what){
                        case 0:
                            multiThreadTest();
                    }
                }

            }
        };
        //在另外一个thread 调用handler
        compareInAnotherThread(handler);
        //在另外一个thread添加消息，通过looper调用handler
        compareWithLooperThread(handler);


    }
    public static void compareInAnotherThread(final Handler handler){
        new Thread(new Runnable(){

            @Override
            public void run() {
                handler.multiThreadTest();
                System.out.println("compareInAnotherThread:"+Thread.currentThread().getName());
            }
        }).start();
    }
    public static void compareWithLooperThread(final Handler handler){
        final MessageQueue q = new MessageQueue();
        new Thread(new Runnable(){

            @Override
            public void run() {
                q.enqueueMessage(new Message(0));
                System.out.println("compareLooperThread:"+Thread.currentThread().getName());
            }
        }).start();
        while (true){
            handler.sendMessage(q.next());
        }
    }
}
