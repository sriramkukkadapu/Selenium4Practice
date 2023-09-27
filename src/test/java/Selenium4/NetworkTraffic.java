package Selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.network.Network;

import java.util.Optional;

public class NetworkTraffic {

 public static void main(String[] args) {
 WebDriver driver = new ChromeDriver();
 DevTools chromeDevTools = ((ChromeDriver)driver).getDevTools();
 chromeDevTools.createSession();

 chromeDevTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
 chromeDevTools.addListener(Network.requestWillBeSent(),
 entry -> {
 System.out.println("Request URI : " + entry.getRequest().getUrl()+"\n"
 + " With method : "+entry.getRequest().getMethod() + "\n");
 entry.getRequest().getMethod();
 });

 driver.get("https://www.google.com");
 chromeDevTools.send(Network.disable());
 }
}
