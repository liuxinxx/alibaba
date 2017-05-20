package yifen_main;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class json_good {

	public json_good() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取宝贝详情页地址
	 * 
	 * @param shop_Url
	 *            商品列表页面
	 */
	public static Map<String, String> good_List(DefaultHttpClient client, String shop_Url) {
		Map<String, String> good_Map = new HashMap<String, String>();
		HttpGet gg = new HttpGet(shop_Url);
		gg.setHeader("Connection", "keep-alive");
		gg.setHeader("Upgrade-Insecure-Requests", "1");
		gg.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36");
		gg.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
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
		downloadStr_img.xrstr("j:\\ttjjjtest.txt", New);
		Document doc = Jsoup.parse(New);
		Elements url = doc.select("li[data-prop]");
		String text = "";
		int i = 0;
		for (Element link : url) {
			i++;
			System.out.println("第" + i + "个数据：");
			Elements a = link.select("div");
			int k = 0;
			String str = "";
			for (Element link1 : a) {
				k++;
				if (k == 1) {
					String regEx = "href=\"(.*?)\"";
					Pattern pat = Pattern.compile(regEx);
					Matcher mat = pat.matcher(link1.html());
					boolean rs = mat.find();
					str = mat.group(0);
					str = str.substring(6, str.length() - 1) + "?spm=&sk=consign";
					good_Map.put(i + "", str);
				} else {
					str = link1.text();
					str = str.replace(Jsoup.parse("&yen;").text(), "");
					str = str.replace(" ", "");
				}
				System.out.println("	" + k + "-->" + str);
			}
			k = 0;
			text = link.text().replace(Jsoup.parse("&yen;").text(), "");
			// System.out.println(text);
		}
		return good_Map;
	}

	public static boolean isHave(String[] strs, String s) {
		/*
		 * 此方法有两个参数，第一个是要查找的字符串数组，第二个是要查找的字符或字符串
		 */
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].indexOf(s) != -1) {// 循环查找字符串数组中的每个字符串中是否包含所有查找的内容
				return true;// 查找到了就返回真，不在继续查询
			}
		}
		return false;// 没找到返回false
	}

	public static void good_info_mm(DefaultHttpClient client, String info_url, String info_goodfname) {
		HttpGet gg = new HttpGet(info_url);
		HttpResponse set1 = null;
		String New = "";
		try {
			set1 = client.execute(gg);

			New = changInputStream.changInput(set1.getEntity().getContent(), "GB2312");
			// //正则表达过滤掉中文
			// String regq = "[\u4e00-\u9fa5]";
			// Pattern patq = Pattern.compile(regq);
			// Matcher matq = patq.matcher(New);
			// New = matq.replaceAll("");
			//
			// System.out.println("正则表达过滤掉中文后的:\r\n "+New);
			System.out.println("JSON:\r\n	" + New);
			String regEx = "<img(.*?)</p>\"}";
			Pattern pat = Pattern.compile(regEx);
			Matcher mat = pat.matcher(New);
			boolean rs = mat.find();
			if (rs) {
				String str = mat.group(0);
				str = str.replaceAll("\\\\", "").replaceAll("width", "").replaceAll("height", "").replaceAll("src=\"//",
						"src=\"http:");
				System.out.println("good_info_mm---方法1:获取商品详情:\r\n" + str);
				downloadStr_img.xrstr(info_goodfname, str);
			} else {
				// <p><strong>
				String regEx1 = "<img(.*?)</p>';";
				Pattern pat1 = Pattern.compile(regEx1);
				Matcher mat1 = pat1.matcher(New);
				boolean rs1 = mat1.find();
				if (rs1) {
					String str = mat1.group(0);
					str = str.replaceAll("\\\\", "").replaceAll("width", "").replaceAll("height", "")
							.replaceAll("src=\"//", "src=\"https://");
					System.out.println("good_info_mm---方法2:获取商品详情:\r\n" + str);
					downloadStr_img.xrstr(info_goodfname, str);
				} else {
					// var offer_details={"content":"</div>"};
					String regEx11 = "<img(.*?)</span>";
					Pattern pat11 = Pattern.compile(regEx11);
					Matcher mat11 = pat11.matcher(New);
					boolean rs11 = mat11.find();

					if (rs11) {
						String str = mat11.group(0);
						str = str.replaceAll("\\\\", "").replaceAll("width", "").replaceAll("height", "")
								.replaceAll("src=\"//", "src=\"https://");
						System.out.println("good_info_mm---方法3:获取商品详情:\r\n	" + str);
						downloadStr_img.xrstr(info_goodfname, str);
					} else {
						// var offer_details={"content":"</div>"};
						String regEx111 = "<img(.*?)</div>\"};";
						Pattern pat111 = Pattern.compile(regEx111);
						Matcher mat111 = pat111.matcher(New);
						boolean rs111 = mat111.find();

						if (rs111) {
							String str = mat111.group(0);
							str = str.replaceAll("\\\\", "").replaceAll("width", "").replaceAll("height", "")
									.replaceAll("src=\"//", "src=\"https://");
							System.out.println("good_info_mm---方法4:获取商品详情:\r\n	" + str);
							downloadStr_img.xrstr(info_goodfname, str);
						} else {

						}

					}
					System.out.print("无商品详情页~~~~");
				}
			}

		} catch (UnsupportedOperationException | IOException e) {
			System.out.print("获取商品详情页异常");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static boolean good_info(DefaultHttpClient client, String url, int good_num) {
		String shop_name = "";
		HttpGet gg = new HttpGet(url);
		gg.setHeader("Connection", "keep-alive");
		gg.setHeader("Upgrade-Insecure-Requests", "1");
		gg.setHeader("User-Agent",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.75 Safari/537.36");
		gg.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
		gg.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
		HttpResponse set1 = null;
		String New = "";
		try {
			set1 = client.execute(gg);
			// System.out.println(set1);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			// System.out.println("1");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			New = changInputStream.changInput(set1.getEntity().getContent(), "GB2312");
		} catch (UnsupportedOperationException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String info = "";
		New = phantomjs_html.js_html(url);
		Document doc = Jsoup.parse(New);

		// 货号
		String col = "";
		System.out.println("宝贝货号: ");
		String Num = "货号:(.*?),";
		Pattern pat1 = Pattern.compile(Num);
		Matcher mat1 = pat1.matcher(New);
		boolean rs1 = mat1.find();
		if (rs1) {
			String str = mat1.group(0);
			int n = str.indexOf("，");
			col = str.substring(3, n);
			info += "宝贝货号:	" + col + "\r\n";
			System.out.println("	" + col);
		} else {
			System.out.println("未找到宝贝货号！");

		}
		info += "宝贝链接:	" + url + "\r\n";
		// if (isHave(good_hu, col))
		{// 宝贝名字
			System.out.println("宝贝名字: 	");
			Elements url11 = doc.select("h1.d-title");
			for (Element link : url11) {
				try {
					info += "宝贝名字:	" + link.text() + "\r\n";
					System.out.println(link.text());
				} catch (Exception e) {
				}
			}
			// 获取店家名称
			System.out.println("店家名称:");
			info += "\r\n店家名称:	";
			int y = 0;
			Elements url2 = doc.select("div.company-name");
			for (Element link : url2) {
				y++;
				if (y == 1) {
					String s = link.text();
					// if(s!="")
					info += "\r\n	" + link.attr("title");
					shop_name = s;
					System.out.println("	" + s);
				}
			}
			// 获取代销价
			Elements url1 = doc.select("span.value");
			info += "\r\n宝贝代销价:	";
			for (Element link : url1) {
				try {
					Double ss = Double.parseDouble(link.text());

					if (ss > 0) {
						info += "\r\n	" + link.text() + "\r\n两倍：	" + ss * 2 + "\r\n1.5倍：	" + ss * 1.5
								+ "\r\n---------------------\r\n";
						System.out.println("代销价:\n	" + link.text() + "\r\n两倍：	" + ss * 2 + "\r\n1.5倍：	" + ss * 1.5
								+ "\r\n---------------------\r\n");
					}

				} catch (Exception e) {
				}
			}
			// 获取颜色
			Elements url4 = doc.select("ul.list-leading>li");
			// Elements url4 = doc.select("a.no-image");
			System.out.println("宝贝颜色: ");
			info += "\r\n宝贝颜色:	";
			for (Element link : url4) {
				String s1 = link.html();
				String regEx = "<div class=\"unit-detail-spec-operator\"(.*?)}";
				String regEx_or = "<div class=\"unit-detail-spec-operator active\"(.*?)}";
				Pattern pat11 = Pattern.compile(regEx_or);
				Pattern pat = Pattern.compile(regEx);
				Matcher mat = pat.matcher(s1);
				Matcher mat11 = pat11.matcher(s1);
				boolean rs = mat.find();
				boolean rs11 = mat11.find();
				if (rs) {
					String str = mat.group(0);
					String str2 = str.replaceAll("&quot;", "").replaceAll(" ", "");
					String colo = str2.substring(61, str2.length() - 1);
					info += "\r\n	" + colo;
					System.out.println(colo);
				} else if (rs11) {
					String str1 = mat11.group(0);
					str1 = str1.replaceAll("&quot;", "").replaceAll(" ", "");
					String colo1 = str1.substring(67, str1.length() - 1);
					info += "\r\n	" + colo1;
					System.out.println(colo1);
				} else {
					System.out.println("颜色为空！");
				}
			}

			// // 获取宝贝尺码
			// System.out.println("宝贝尺码:");
			// info += "\r\n宝贝尺码: ";
			// Elements url21 = doc.select("td.name");
			// for (Element link : url21) {
			// String s = link.text();
			// // if(s!="")
			// info += "\r\n " + link.text();
			// System.out.println(" " + s);
			// }
			// 获取宝贝尺码
			System.out.println("宝贝尺码:");
			info += "\r\n宝贝尺码:	";
			Elements url21 = doc.select("td.name");
			for (Element link : url21) {

				String s = link.text();
				info += "\r\n	" + link.text();
				//如果尺码为图片
				if (link.text() != "") {
					String s2 = link.html();
					String regEx = "title=\"(.*?)\"";

					Pattern pat = Pattern.compile(regEx);
					Matcher mat = pat.matcher(s2);

					boolean rs = mat.find();

					if (rs) {
						String str = mat.group(0);
						String str2 = str.replaceAll("&quot;", "").replaceAll(" ", "");
						String colo = str2.substring(7, str2.length() - 1);
						info += "\r\n	" + colo;
					}
				}
			}
			// 获取宝贝详情
			// <p><img(.*?)p>"
			String file = "";
			System.out.println("获取宝贝详情: ");
			Elements url3 = doc.select("div.desc-lazyload-container");
			for (Element link : url3) {
				String info_url = link.attr("data-tfs-url");
				// 创建文件夹
				file = "j:\\淘宝\\" + shop_name + "\\" + good_num + "###" + col + "\\";
				File txt = new File(file);
				if (!txt.exists()) {
					txt.mkdirs();
				}
				String info_goodfname = file + col + "详情页.txt";
				json_good.good_info_mm(client, info_url, info_goodfname);
				System.out.println(info_url);

			}
			try {
				System.out.println("写入图片的入口:\r\n" + url);
				downloadStr_img.dlimg(url, file);
				System.out.println("图片写入成功！");
				downloadStr_img.xrstr(file + col + ".txt", info);
				System.out.println("商品信息写入成功！");
				return true;
			} catch (Exception s) {
				return false;
			}
		}
	}

}
