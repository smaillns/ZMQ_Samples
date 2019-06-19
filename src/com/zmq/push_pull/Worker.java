package com.zmq.push_pull;


import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Worker {

    public static void main(String[] args) throws Exception {
        try (ZContext context = new ZContext()) {
            ZMQ.Socket sock = context.createSocket(SocketType.PULL);
            sock.connect("tcp://127.0.0.1:1234");




            String msg = "";
            while(true){

                msg = sock.recvStr();
                System.out.println("message received : "+msg);

            }



        }
    }


}
