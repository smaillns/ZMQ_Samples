package com.zmq.push_pull;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Manager {
    public static void main(String[] args) throws Exception {
        try (ZContext context = new ZContext()) {
            ZMQ.Socket sock = context.createSocket(SocketType.PUSH);
            sock.bind("tcp://127.0.0.1:1234");


            int id_msg = 1;
            while(true){
                    Thread.sleep(1000);
                    System.out.println("msg"+id_msg+" sent ..");
                    sock.send("msg"+id_msg++);

            }



        }
    }
}
