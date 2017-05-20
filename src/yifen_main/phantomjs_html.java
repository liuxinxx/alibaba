package yifen_main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class phantomjs_html {

	public phantomjs_html() {
		// TODO Auto-generated constructor stub
	}
	public static String js_html(String url)
	{
		Runtime rt = Runtime.getRuntime();
        Process process = null;
        try {
            process = rt.exec("K:/javacode/yifen/bin/ph_js/phantomjs-2.1.1-windows/bin/phantomjs.exe K:/javacode/yifen/bin/ph_js/testjs.js " +url);
            InputStream in = process.getInputStream();
            InputStreamReader reader = new InputStreamReader(in, "utf-8");
            BufferedReader br = new BufferedReader(reader);
            StringBuffer sbf = new StringBuffer();
            String tmp = "";
            while ((tmp = br.readLine()) != null) {
                sbf.append(tmp);
            }
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return "null";
	}

}
