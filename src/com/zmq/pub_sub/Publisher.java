package com.zmq.pub_sub;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;



public class Publisher {

        public static void main(String[] args) throws Exception
        {
            //  Prepare our context and Publisher
            try (ZContext context = new ZContext()) {
                ZMQ.Socket publisher = context.createSocket(SocketType.PUB);
                publisher.bind("tcp://127.0.0.1:5678");


            int id = 1;
            String msg = "";
            while (true){
                Thread.sleep(1000);

                msg = "topic1- msg"+id ;
                publisher.send(msg);

                msg = "topic2- msg"+id ;
                publisher.send(msg);


                id++;

            }


            }
        }
    }