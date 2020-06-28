package java8_examples;

import java.util.HashSet;
import java.util.Set;

public class Employee {

	private String name;
	private Set<String> devices;
	
	Employee(String name, String[] devices){
		this.name=name;
		//push all devices to devices set
		this.devices=new HashSet<String>();
		for(String device:devices) {
			this.devices.add(device);
		}
	}
	
	Employee(String name){
		this.name=name;
	}
	
	public void addDevice(String deviceName) {
		if(devices==null) {
			this.devices=new HashSet<String>();
		}
		if(deviceName!=null) {
			this.devices.add(deviceName);
		}			
	}
	
	public Set getDevices() {
		return this.devices;
	}
	
}
