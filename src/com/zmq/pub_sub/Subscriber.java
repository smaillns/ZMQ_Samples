package com.zmq.pub_sub;


import org.zeromq.SocketType;
import org.zeromq.ZMQ;
import org.zeromq.ZContext;
public class Subscriber {



public static void main(String[] args)
    {
        try (ZContext context = new ZContext()) {

            System.out.println("Collecting updates");
            ZMQ.Socket subscriber = context.createSocket(SocketType.SUB);
            subscriber.subscribe("topic1");     //Specify the topic to which subscribe

            subscriber.connect("tcp://127.0.0.1:5678");


            String msg= "";
            while (true){
                msg = subscriber.recvStr();
                System.out.println("Message received .. > " + msg);

            }


        }
    }
}
