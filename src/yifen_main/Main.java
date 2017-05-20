package yifen_main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.http.impl.client.DefaultHttpClient;

public class Main {

	public static void main(String[] a) {
		// https://hanyan.1688.com/page/offerlist.htm?spm=&pageNum=3#search-bar

		String hu = "";
		String main_url = "";
		Scanner in = new Scanner(System.in); // Scanner类
		String YN = "";
		while (!YN.equals("Y")) {
			System.out.print("请输入阿里商家地址：");
			main_url = in.next();
			System.out.print("请确认该网址是否正确" + "(Y/N)");
			YN = in.next();
		}
		System.out.print("请输入要爬的页数：");
		int page = in.nextInt();
		System.out.print("开始爬取数据：");
		//main_url = "https://shop1382633835710.1688.com";// https://caiyunxuanfushi.1688.com
		String shop_Url = main_url + "/page/offerlist.htm";
		int good_num = 0;
		for (int k = 1; k < page; k++) {
			if (k > 1) {
				shop_Url = main_url + "/page/offerlist.htm";
				shop_Url = shop_Url + "?spm=&pageNum=" + k + "#search-bar";
			}
			Map<String, String> good_Map = new HashMap<String, String>();
			DefaultHttpClient client = new DefaultHttpClient();
			// 获取到商品列表页面
			// String shop_Url = get_ShopClassify.get_shopUrl(client, main_url);

			System.out.println("shop_Url-->" + shop_Url);
			// 解析获得商品列表内商品链接
			good_Map = json_good.good_List(client, shop_Url);

			for (Map.Entry<String, String> entry : good_Map.entrySet()) {
				good_num++;
				String url = entry.setValue(good_num + "");
				System.out.println("正在获取第" + good_num + "商品信息！\n	" + url);
				if (json_good.good_info(client, url,good_num)) {
					System.out.println("\n获取成功！");
				} else {
					System.out.println("\n获取失败");
				}

			}

		}
	}

}
