package br.edu.unifei.si;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;

public class ConversorDeFormatos {
	public static InputStream byteToInputStream(byte[] bytes){
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

		return byteArrayInputStream;
	}

	public static byte[] fileItemToBytes(FileItem file){
		InputStream uploadedStream = null;
		byte[] bytes = null;

		try {
			uploadedStream = file.getInputStream();
			bytes = new byte[uploadedStream.available()];
			uploadedStream.read(bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bytes;
	}
}