package tw.blackcat.controller;

import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RssController {
	private String result="";
	@GetMapping(path = "/ressreader.controller",produces = "application/xml;charset-UTF-8")
	public String processRssaction() throws InterruptedException {
		Thread t1 = new Thread() {
			public void run() {
				try {
					URL url = new URL("https://www.mohw.gov.tw/rss-16-1.html");
					HttpURLConnection conn = (HttpURLConnection)url.openConnection();
					conn.setDoInput(true);
					conn.connect();
					BufferedReader br1 = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String data="";
					result = "";
					while((data=br1.readLine())!=null) {
						result+=data;
					}
					br1.close();
					conn.disconnect();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		};
		t1.start();
		t1.join();
		System.out.println("result="+result);
		return result;
		}
	

}
