package yifen_main_test;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class test_img {

	public test_img() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String New = "asdasdas金卡世界大会上的qweqwe213123";
	
		String regq = "[\u4e00-\u9fa5]";  
        Pattern patq = Pattern.compile(regq);    
        Matcher matq = patq.matcher(New);   
        New = matq.replaceAll("");  
        System.out.println(New);
}
}
