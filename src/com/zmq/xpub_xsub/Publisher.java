package com.zmq.xpub_xsub;



import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZThread;

import java.util.Random;

public class Publisher {


    public static void main(String[] args) throws Exception
    {
        //  Prepare our context and Publisher
        try (ZContext context = new ZContext()) {
            ZMQ.Socket publisher = context.createSocket(SocketType.PUB);

            String xsubAdress = "tcp://127.0.0.1:1234";


            publisher.connect(xsubAdress);


            int id = 1;
            String msg = "";
            while (true){
                Thread.sleep(1000);


                Random rand = new Random(System.currentTimeMillis());
                if (rand.nextInt(10)<5){
                    msg = "topic1- msg"+id ;
                    System.out.println("Sending message for topic 1 ..");
                    publisher.send(msg);

                /*msg = "topic1- msg"+id ;
                System.out.println("Sending message for topic 1 ..");
                publisher.sendMore("topic1");
                publisher.send(msg);*/

                }
                else {
                    msg = "topic2- msg"+id ;
                    System.out.println("Sending message for topic 2 ..");
                    publisher.send(msg);
                }




                id++;

            }


        }
    }

}
