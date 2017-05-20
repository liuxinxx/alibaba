package yifen_main_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		Process process = null;
		System.out.println("¿ªÊ¼......	");
		try {
			process = rt
					.exec("K:/javacode/yifen/bin/ph_js/phantomjs-2.1.1-windows/bin/phantomjs.exe K:/javacode/yifen/bin/ph_js/testjs.js "
							+ "https://detail.1688.com/offer/45435505894.html?spm=");
			InputStream in = process.getInputStream();
			InputStreamReader reader = new InputStreamReader(in, "utf-8");
			BufferedReader br = new BufferedReader(reader);
			StringBuffer sbf = new StringBuffer();
			String tmp = "";
			while ((tmp = br.readLine()) != null) {
				sbf.append(tmp);
			}
			// System.out.println(sbf.toString());
			// "serverTime":1483699296578
			Document doc = Jsoup.parse(sbf.toString());
			// »ñÈ¡ÑÕÉ«
			Elements url4 = doc.select("ul.list-leading>li");
			// Elements url4 = doc.select("a.no-image");
			System.out.println("±¦±´ÑÕÉ«: ");

			for (Element link : url4) {
				String s1 = link.html();
				String regEx = "<div class=\"unit-detail-spec-operator\"(.*?)}";
				String regEx_or = "<div class=\"unit-detail-spec-operator active\"(.*?)}";
				Pattern pat1 = Pattern.compile(regEx_or);
				Pattern pat = Pattern.compile(regEx);
				Matcher mat = pat.matcher(s1);
				Matcher mat1 = pat1.matcher(s1);
				boolean rs = mat.find();
				boolean rs1 = mat1.find();
				if (rs) {
					String str = mat.group(0);
					String str2 = str.replaceAll("&quot;", "").replaceAll(" ", "");
					String colo = str2.substring(61, str2.length() - 1);
					System.out.println(str2 + "----" + colo);
				} else if (rs1) {
					String str1 = mat1.group(0);
					str1 = str1.replaceAll("&quot;", "").replaceAll(" ", "");
					String colo1 = str1.substring(67, str1.length() - 1);
					System.out.println(str1 + "----" + colo1);
				}
			}
			// »ñÈ¡±¦±´³ßÂë
			System.out.println("±¦±´³ßÂë:");
			System.out.println("\r\n±¦±´³ßÂë:	");
			Elements url21 = doc.select("td.name");
			for (Element link : url21) {

				String s = link.text();
				// if(s!="")
				System.out.println("\r\n	" + link.text());
				//System.out.println("\r\n	" + link.html());
				String s2 = link.html();
				String regEx = "title=\"(.*?)\"";

				Pattern pat = Pattern.compile(regEx);
				Matcher mat = pat.matcher(s2);

				boolean rs = mat.find();

				if (rs) {
					String str = mat.group(0);
					String str2 = str.replaceAll("&quot;", "").replaceAll(" ", "");
					String colo = str2.substring(7, str2.length() - 1);
					System.out.println(colo );
				}
			}
			// String regEx = "{&quot;contentUrl&quot;:&quot;(.*?)&quot";
			// Pattern pat = Pattern.compile(regEx);
			// Matcher mat = pat.matcher(ss);
			// boolean rs = mat.find();
			// if (rs) {
			// String str = mat.group(0);
			// String coloo = str.substring(13, str.length() - 1);
			// System.out.println(str);
			// } else {
			// System.out.println("±¦±´ÏêÇéÎª¿Õ£¡");
			//
			// }

		} catch (

		Exception s) {
		}
	}
}
