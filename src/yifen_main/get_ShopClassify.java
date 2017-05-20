package yifen_main;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class get_ShopClassify {

	public get_ShopClassify() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取到商品页面
	 * 
	 * @param client
	 * @param main_url
	 *            提供的阿里商家入口
	 */
	public static String get_shopUrl(DefaultHttpClient client, String main_url) {
		HttpGet gg = new HttpGet(main_url);
		//gg.setHeader("Host", main_url);
		gg.setHeader("Connection", "keep-alive");
		gg.setHeader("Upgrade-Insecure-Requests", "1");
		gg.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36");
		gg.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		gg.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		//gg.setHeader("Cookie","cna=kO31ENU1Nh4CAX0uA+05AXvH; JSESSIONID=9L78ePpj1-4jwWWVWZtwwXyRBCS5-9OZTU7Q-94u4; ali_ab=125.46.3.237.1483669392735.6; __cn_logon__=false; _csrf_token=1483669444544; _tmp_ck_0=\"eCK34ftO3ha6%2FwOR3cEIJjQraNQuPSOG3GLn25qSs3%2BYvGbKgKIHPo5PjNHVkptOCkMB9RIexDUcUbRn5Rt6IQr%2F7K%2FCky0CnuAlnS5y8G2nmDFfzGSRPnxZPdjairw2mxMKJGqNnL0ETVpZQ7UfGk%2FzB44c0yDekmm%2Bk3c2Guzxc2VKDy%2FcHHLQ59JKfsMiIth71aq2claBbWJBeA3dROfzBTKPBAc0ukkwTqP96p16ARUaskuJTJtdlpUzaNcVmwWd7rbpOL8Zdv0q4mDNIC%2B4P%2BKbNokPTIN6SAzwAJJBcwLrm9NG9qxWVv3RTFB8RQPBbcmQXyg9cE79VLhCgRpqntP4Bg%2FlPQpVb3e7xw6q5IQLrRDHAHfO0A7dSc5AUEM3KhttnZI%3D\"; ali_beacon_id=125.46.3.237.1483672319733.002663.5; isg=Ap-fojqGOzm9-j8VroWoeSuALvO9DPOmQaaWBDHsO86VwL9COdSD9h2S9OdE; l=Ai0t/NtW8tk6K/mevnwBG-PjvcOnx2Fc; alicnweb=touch_tb_at%3D1483692792921");

		HttpResponse set1 = null;
		String New = "";
		try {
			set1 = client.execute(gg);
			New = changInputStream.changInput(set1.getEntity().getContent(), "GB2312");
		} catch (UnsupportedOperationException | IOException e) {
			e.printStackTrace();
		}
		//downloadStr_img.xrstr("j:\\tttest.txt", New);
		Document doc = Jsoup.parse(New);
		Elements url = doc.select(".show-category");
		String text = "";
		for (Element link : url) {

			System.out.println("---" + link.html() + "---");

			text = link.absUrl("href");
		}
		return text;
	}
}
