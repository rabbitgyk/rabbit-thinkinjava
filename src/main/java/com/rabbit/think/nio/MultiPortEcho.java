package com.rabbit.think.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * http://www.importnew.com/2000.html
 * @author rabbit
 * 2016年9月25日
 */
public class MultiPortEcho {
	private int ports[];
	private ByteBuffer echoBuffer = ByteBuffer.allocate(1024);

	public MultiPortEcho(int ports[]) throws IOException {
		this.ports = ports;
		configureSelector();
	}

	private void configureSelector() throws IOException {
		// Create a new selector
		Selector selector = Selector.open();
		// Open a listener on each port, and register each one with the selector
		for (int i = 0; i < ports.length; ++i) {
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);
			ssc.socket().bind(new InetSocketAddress(ports[i]));
			ssc.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("Going to listen on " + ports[i]);
		}

		while (true) {
			selector.select();
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			Iterator<SelectionKey> it = selectedKeys.iterator();
			while (it.hasNext()) {
				SelectionKey key = (SelectionKey) it.next();
				if ((key.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
					// Accept the new connection
					ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
					SocketChannel sc = ssc.accept();
					sc.configureBlocking(false);
					// Add the new connection to the selector
					sc.register(selector, SelectionKey.OP_READ);
					it.remove();
					System.out.println("Got connection from " + sc);
				} else if ((key.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {
					// Read the data
					SocketChannel sc = (SocketChannel) key.channel();
					// Echo data
					int bytesEchoed = 0;
					while (true) {
						echoBuffer.clear();
						int number_of_bytes = sc.read(echoBuffer);
						if (number_of_bytes <= 0) {
							break;
						}
						echoBuffer.flip();
						sc.write(echoBuffer);
						bytesEchoed += number_of_bytes;
					}
					System.out.println("Echoed " + bytesEchoed + " from " + sc);
					it.remove();
				}

			}
		}
	}
}