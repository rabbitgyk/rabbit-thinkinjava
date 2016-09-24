package com.rabbit.think.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 1. 变更通知（因为每个事件都需要一个监听者） 
 * 2. 选择器和异步IO：通过选择器来提高多路复用 
 * 3. 通道——承诺与现实
 * 4. 内存映射——好钢用在刀刃上 
 * 5. 字符编码和搜索
 * 
 * @author rabbit 2016年9月24日
 */
public class NIOMain {

	public static void main(String[] args) {
		// 1. 变更通知（因为每个事件都需要一个监听者） 
		Path path = Paths.get("E:\\logs");
		FileWatcher.watch(path);
		
	}
}
