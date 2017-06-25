package com.msdn.demo;

import com.msdn.util.DisplayElement;
import com.msdn.util.Observer;
import com.msdn.util.Subject;

public class StatisticsDisplay implements Observer, DisplayElement {  
	  
    private float temperature; // ÎÂ¶È  
    private float humidity; // Êª¶È  
    private Subject weatherData = null;  
      
    public StatisticsDisplay(Subject weatherData) {  
        this.weatherData = weatherData;  
        weatherData.registerObserver(this);  
    }  
      
    @Override  
    public void display() {  
        System.out.println("Statistics: " + temperature + "F degrees and " + humidity + "% humidity");  
    }  
  
    @Override  
    public void update(float temperature, float humidity, float pressure) {  
        this.temperature = temperature;  
        this.humidity = humidity;  
        display();  
    }  
}  
