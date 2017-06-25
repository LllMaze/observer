package com.msdn.demo;

import java.util.ArrayList;

import com.msdn.util.Observer;
import com.msdn.util.Subject;

public class WeatherData implements Subject {  
	  
    private ArrayList observers = null; // �۲����б�  
      
    private float temperature; // �¶�  
    private float humidity; // ʪ��  
    private float pressure; // ��ѹ  
      
    public WeatherData() {  
        observers = new ArrayList();  
    }  
      
    @Override  
    public void registerObserver(Observer o) {  
        observers.add(o);  
    }  
  
    @Override  
    public void removeObserver(Observer o) {  
        int i = observers.indexOf(o);  
        if (i >= 0) {  
            observers.remove(i);  
        }  
    }  
  
    /** 
     * ����֪ͨ���еĹ۲��� 
     */  
    @Override  
    public void notifyObservers() {  
        for (int i = 0; i < observers.size(); i++) {  
            Observer observer = (Observer) observers.get(i);  
            observer.update(temperature, humidity, pressure);  
        }  
    }  
  
    public void measurementsChanged() {  
        notifyObservers();  
    }  
      
    public void setMeasurements(float temperature, float humidity, float pressure) {  
        this.temperature = temperature;  
        this.humidity = humidity;  
        this.pressure = pressure;  
        measurementsChanged();  
    }  
}  