package _08_California_Weather;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
/*
 * OBJECTIVE:
 * 1. Create a program that allows the user to search for the weather
 * conditions of a given city in California. Use the example program below
 * and the Utilities class inside this project to get the temperature data
 * from a day in December 2020.
 * Example: User: Encinitas
 *          Program: Encinitas is Overcast with a tempeature of 59.01 �F
 * 
 * 2. Create a way for the user to specify the weather condition and then
 * list the cities that have those conditions.
 * Example: User: Mostly Cloudy
 *          Program: Long Beach, Pomona, Oceanside, ...
 * 
 * 3. Create a way for the user to enter a minimum and maximum temperature
 * and then list the cities that have temperatures within that range
 * Example: User: minimum temperature �F = 65.0, max temperature �F = 70.0
 *          Program: Fortana, Glendale, Escondido, Del Mar, ...
 * 
 * EXTRA:
 * Feel free to add pictures for specific weather conditions or a thermometer
 * for the temperature. Also If you want your program to get the current day's
 * temperature, you can get a free API key at: https://openweathermap.org/api
 */

public class CaliforniaWeather implements ActionListener {
	JFrame frame = new JFrame();
	JPanel pane = new JPanel();
	JTextArea label = new JTextArea();
	JButton search = new JButton();
	JButton condition = new JButton();
	JButton tempature = new JButton();
	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
	String cityName = "";

ArrayList<String> correctConditions = new ArrayList<>();
	
	void start() {
		
		
		
		frame.setVisible(true);
		frame.setSize(850, 300);
		frame.add(pane);
		pane.add(label);
		pane.add(search);
		pane.add(condition);
		pane.add(tempature);
		pane.setLayout(null);
		label.setBounds(0, 0, 850, 200);
		search.setBounds(150, 200, 150, 100);
		condition.setBounds(450, 200, 200, 100);
		tempature.setBounds(700, 200, 200, 100);
		search.setText("search");
		condition.setText("see conditions");
		tempature.setText("view tempature ranges");
		search.addActionListener(this);
		condition.addActionListener(this);
		tempature.addActionListener(this);
		System.out.println(weatherData.size());	
	

		// All city keys have the first letter capitalized of each word

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int c = weatherData.size();
		if (e.getSource().equals(search)) {
			cityName = JOptionPane.showInputDialog("what city would you like to view the weather of?");
			WeatherData datum = weatherData.get(cityName);
			label.setText(
					cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		} else if(e.getSource().equals(condition)) {
			correctConditions.clear();
			String condition = JOptionPane.showInputDialog("what conditon do you want?");
			WeatherData datum = weatherData.get(cityName);
			for(String city : weatherData.keySet()) {
				WeatherData wd = weatherData.get(city);
				System.out.println(wd.weatherSummary);
				if(wd.weatherSummary.equals(condition)) {
				correctConditions.add(city);
				}
				
			}
			int z = 0;
			String b = "";
			for(String i:correctConditions) {
					
				b+=i + ", ";
					z++;
					if(z%15==0) {
						b+= "\n";
					}
				}
			label.setText(
					"all of these cities are " + condition +  ": " + "\n"+ b);

		} else {
			String i = JOptionPane.showInputDialog("what minimum tempature do you want?");
			String x = JOptionPane.showInputDialog("what maximum tempature do you want?");
	
			int min = Integer.parseInt(i);
			int max = Integer.parseInt(x);
			WeatherData datum = weatherData.get(cityName);
			for(String city : weatherData.keySet()) {
				WeatherData wd = weatherData.get(city);
				
			if(min<wd.temperatureF && wd.temperatureF<max) {
			//	label.setText(text);
			}
				
			
		}
	}
	}
}
