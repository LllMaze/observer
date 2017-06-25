package com.msdn.demo;

import java.util.ArrayList;

import com.msdn.util.Observer;

public class Test {
	public static void main(String[] args) {
		ArrayList<Observer> observers=new ArrayList<>();
		WeatherData weatherData=new WeatherData();
		StatisticsDisplay sDisplay=new StatisticsDisplay(weatherData);
		weatherData.setMeasurements(30.2f, 97.0f, 1004.0f);
		sDisplay.display();
		sDisplay.update(26.0f, 97.0f, 1004.0f);
		sDisplay.display();
		Observer o1=(Observer) new StatisticsDisplay(weatherData);
		weatherData.registerObserver(o1);
	}
}
