package yifen_main;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class changInputStream {

	public changInputStream() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 将指定的字符流转换成指定编码方式的 String
	 * @param inputStream 字符流
	 * @param encode 指定是编码方式
	 * @return 返回String
	 */
	public static String changInput(InputStream inputStream, String encode) {
		ByteArrayOutputStream OutputStream = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int len = 0;
		String result = "";
		if (inputStream != null) {
			try {
				while ((len = inputStream.read(data)) != -1) {
					OutputStream.write(data, 0, len);
				}
				result = new String(OutputStream.toByteArray(), encode);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;

	}
}
