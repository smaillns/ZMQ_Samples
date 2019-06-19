package com.zmq.router_dealer;

import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

public class Serveur {

    public static void main(String[] args) throws Exception {
        try (ZContext context = new ZContext()) {
            //  Socket to talk to Server
            ZMQ.Socket responder = context.createSocket(SocketType.REP);
            responder.connect("tcp://localhost:5560");

            while (!Thread.currentThread().isInterrupted()) {
                //  Wait for next request from Client
                String string = responder.recvStr(0);
                System.out.printf("Received request: [%s]\n", string);

                //  Do some 'work'
                Thread.sleep(1000);

                //  Send reply back to Client
                responder.send("World");
            }
        }

    }

}
