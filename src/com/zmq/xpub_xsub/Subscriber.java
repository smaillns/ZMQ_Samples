package com.zmq.xpub_xsub;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import java.util.Random;

public class Subscriber {

    public static void main(String[] args) throws Exception
    {
        //  Prepare our context and Publisher
        try (ZContext context = new ZContext()) {
            ZMQ.Socket subscriber = context.createSocket(SocketType.SUB);
            subscriber.subscribe("topic1");     //Specify the topic to which subscribe
            String xpubAdress = "tcp://127.0.0.1:5678";

            subscriber.connect(xpubAdress);
            System.out.println("waiting for messages ..");

            String msg= "";
            while (true){
                msg = subscriber.recvStr();
                System.out.println("Message received .. > " + msg);

            }

        }
    }

}
