//package reactordemo;
//
//import java.awt.*;
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.nio.channels.SelectableChannel;
//import java.nio.channels.SelectionKey;
//import java.nio.channels.Selector;
//import java.nio.channels.ServerSocketChannel;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.Callable;
//import java.util.concurrent.ConcurrentHashMap;
//
//
//public class Reactor {
//    private Map<Integer, EventHandler> registeredHandlers = new ConcurrentHashMap<>();
//    private Selector demultiplexer;
//
//    public Reactor() throws Exception {
//        demultiplexer = Selector.open();
//    }
//
//    public void registerEventHandler(
//        int eventType, EventHandler eventHandler) {
//        registeredHandlers.put(eventType, eventHandler);
//    }
//
//    public void registerChannel(int eventType, SelectableChannel channel) throws Exception {
//        channel.register(demultiplexer, eventType);
//    }
//
//    public void run() {
//        try {
//            while (true) { // Loop indefinitely
//                demultiplexer.select();
//                Set<SelectionKey> readyHandles = demultiplexer.selectedKeys();
//                Iterator<SelectionKey> handleIterator = readyHandles.iterator();
//                while (handleIterator.hasNext()) {
//                    SelectionKey handle = handleIterator.next();
//                    if (handle.isAcceptable()) {
//                        EventHandler handler = registeredHandlers.get(SelectionKey.OP_ACCEPT);
//                        handler.handleEvent(handle);
//                    }
//
//                    if (handle.isReadable()) {
//                        EventHandler handler = registeredHandlers.get(SelectionKey.OP_READ);
//                        handler.handleEvent(handle);
//                        handleIterator.remove();
//                    }
//
//                    if (handle.isWritable()) {
//                        EventHandler handler = registeredHandlers.get(SelectionKey.OP_WRITE);
//                        handler.handleEvent(handle);
//                        handleIterator.remove();
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        ServerSocketChannel server = ServerSocketChannel.open();
//        server.socket().bind(new InetSocketAddress(8080));
//        server.configureBlocking(false);
//        Reactor reactor = new Reactor();
//
//        reactor.registerChannel(SelectionKey.OP_ACCEPT, server);
//
//        reactor.registerEventHandler(
//                SelectionKey.OP_ACCEPT, new AcceptEventHandler());
//
//        reactor.registerEventHandler(
//                SelectionKey.OP_READ, new ReadEventHandler());
//
//        reactor.registerEventHandler(
//                SelectionKey.OP_WRITE, new WriteEventHandler());
//
//        reactor.run();
//    }
//}
//
//abstract class EventHandler implements Callable {
//    abstract public void handleEvent(SelectionKey event);
//}
