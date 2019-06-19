package com.zmq.xpub_xsub;

import com.zmq.xpub_xsub.Espresso.Espresso;
import org.zeromq.SocketType;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;
import org.zeromq.ZThread;

public class Intermediary {

    public static void main(String[] args) throws Exception
    {
        //  Prepare our context and Publisher
        try (ZContext context = new ZContext()) {
            ZMQ.Socket xpubSocket = context.createSocket(SocketType.XPUB);
            ZMQ.Socket xsubSocket = context.createSocket(SocketType.XSUB);

            String xsubAdress = "tcp://127.0.0.1:1234";
            String xpubAdress = "tcp://127.0.0.1:5678";

            xpubSocket.bind(xpubAdress);
            xsubSocket.bind(xsubAdress);

            System.out.println("Intermediary created and waiting for messages");
           // ZMQ.Socket listener = ZThread.fork(context, new Listener());
            ZMQ.proxy(xsubSocket, xpubSocket, null);




        }


    }


}
