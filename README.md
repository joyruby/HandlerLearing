# HandlerLearing
This is a project generated by AS, so there are two dir in the project:

App and handlerdemo where App is empty that can be ignore;


---
## Introduction
**It is just a demo to show how the handler can update ui when get a message from another thread;**

---

## Directories
![image](https://github.com/joyruby/HandlerLearing/blob/master/readmeLoge/directory.png)


## Flow
![image](https://github.com/joyruby/HandlerLearing/blob/master/readmeLoge/handlerMap.png)
MultiThreadDemo is the entry;

Two comparision to show the key of the Handler;

###One comparision:

In another thread, handler's multiThreadTest is invoked. The result is obvious;

```
public static void compareInAnotherThread(final Handler handler){
        new Thread(new Runnable(){

            @Override
            public void run() {
                handler.multiThreadTest();
                System.out.println("compareInAnotherThread:"+Thread.currentThread().getName());
            }
        }).start();
    }
```


###The other comparision:

A while without interruption is used to get the message from messagequeue; It is what we called looper;

```
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
```

