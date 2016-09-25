package com.rabbit.think.nio;

import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

/**
 * http://www.importnew.com/2000.html
 * 变更通知（因为每个事件都需要一个监听者）
 * 
 * @author rabbit 2016年9月25日
 */
public class FileWatcher {

	public static void watch(Path path) {
		System.out.println("Now watching the directory " + path.toUri().getPath() + " ...");
		try {
			WatchService watcher = path.getFileSystem().newWatchService();
			path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE);

			WatchKey watckKey = watcher.take();
			List<WatchEvent<?>> events = watckKey.pollEvents();
			for (WatchEvent<?> event : events) {
				System.out.println(
						"Someone just " + event.kind().name() + " the file '" + event.context().toString() + "'.");
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}
}
