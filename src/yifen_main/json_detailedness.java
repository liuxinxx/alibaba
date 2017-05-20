package yifen_main;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class json_detailedness {

	public json_detailedness() {
		// TODO Auto-generated constructor stub
	}

	public static void detailedness(DefaultHttpClient client, String good_Url, int list) {
		HttpGet gg = new HttpGet(good_Url);
		gg.setHeader("Connection", "keep-alive");
		gg.setHeader("Upgrade-Insecure-Requests", "1");
		gg.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36");
		gg.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		// gg.setHeader("Referer",
		// "https://shop1382633835710.1688.com/page/offerlist.htm?spm=a2615.2177701.0.0.xKNw7T");
		gg.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		gg.setHeader("Cookie",
				"cna=LJ/NEKII3ywCAX0uA+OgNNnu;ali_apache_track=\"c_ms=1|c_mid=b2b-823681060|c_lid=%E7%88%B1%E8%B4%AD%E4%BC%BC%E7%88%B1%E9%9D%9E%E7%88%B1\";_cn_slid_=pw5nInBnuk; last_mid=b2b-823681060; __last_loginid__=\"%E7%88%B1%E8%B4%AD%E4%BC%BC%E7%88%B1%E9%9D%9E%E7%88%B1\";ali_beacon_id=125.46.3.227.1483063734446.819736.9;JSESSIONID=9L78cidu1-ZuyW4V4smnfEMBpKhE-42bNU7Q-tz32;alicnweb=touch_tb_at%3D1483667987811%7Clastlogonid%3D%25E7%2588%25B1%25E8%25B4%25AD%25E4%25BC%25BC%25E7%2588%25B1%25E9%259D%259E%25E7%2588%25B1;_csrf_token=1483667984404; _tmp_ck_0=\"zmh4jzK0V3LpY7eHWfO%2Fi4r7sLzMLaORZsCQWcsek%2BvIaSXp9XJb2cCGD3qZPEBil8WU2J17DrkjPf%2FQTm76P8izh%2FMlzy2pUm6OdgJQtPlKyxZzKHJJT86c%2FmGQ847%2Bv31EsyxXoIx3%2F%2FaJ8%2BtwxquUuMR%2FrWTOY%2BPJCZ9ErPUPoEOGpz7VoDGu0VQ22mduDwFmZ8MZvynHh4UdWhHUwP3oupVfLPtDBUW%2BFan40tG%2F%2B0A3zY36cDRi38vXF1cTJFxIp%2BphOK7ytCUoFRCLUJKyPkCLkN5rC6OTE79%2BX0%2BGQaLW38YR8fHRYyHTPGYo4irO1224yScuHx3kHwcJSQ%3D%3D\";l=AoKCc5k/lQgJgmZ/nZUGiyqqUoLkK4Zt;isg=AvT0KlsGEEnwxIQ0sdyz6ByZxbL0eaeyFg_NZY5V-H8C-ZVDtt7yRhS_D4bb/");
		HttpResponse set1 = null;
		String New = "";
		try {
			set1 = client.execute(gg);
			New = changInputStream.changInput(set1.getEntity().getContent(), "GB2312");
		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		}
		downloadStr_img.xrstr("j:\\goodtest.txt", New);
		Document doc = Jsoup.parse(New);
		Elements url = doc.select("div.obj-content row1 span.value");
		Elements ur2 = doc.select("li[data-prop]");
		Elements ur3 = doc.select("li[data-prop]");
		String text = "";
		int i = 0;
		for (Element link : url) {
			
			String str = "";
			System.out.println(link.text());
		}
	}
}
