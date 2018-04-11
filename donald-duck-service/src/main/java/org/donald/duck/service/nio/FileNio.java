package org.donald.duck.service.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileNio {
	public static void main(String[] args) throws IOException {

		FileInputStream stream = new FileInputStream("");
		FileChannel channel = stream.getChannel();
		ByteBuffer buf = ByteBuffer.allocate(1024);

		int read = 0;
		while ((read = channel.read(buf)) != -1) {

		}
	}
}
