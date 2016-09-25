package com.rabbit.think.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * http://www.importnew.com/2000.html
 * @author rabbit
 * 2016年9月25日
 */
public class MemoryMapping {

	private int mem_map_size = 20 * 1024 * 1024;;

	public void map(String fn) {
		RandomAccessFile memoryMappedFile = null;
		MappedByteBuffer out = null;
		try {
			memoryMappedFile = new RandomAccessFile(fn, "rw");
			// Mapping a file into memory
			out = memoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, mem_map_size);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				memoryMappedFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// Writing into Memory Mapped File
		for (int i = 0; i < mem_map_size; i++) {
			out.put((byte) 'A');
		}
		System.out.println("File '" + fn + "' is now " + Integer.toString(mem_map_size) + " bytes full.");
		// Read from memory-mapped file.
		for (int i = 0; i < 30; i++) {
			System.out.print((char) out.get(i));
		}
		System.out.println("\nReading from memory-mapped file '" + fn + "' is complete.");
	}
}
