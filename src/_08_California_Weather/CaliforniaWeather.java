package _08_California_Weather;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	JLabel label = new JLabel();
	JButton search = new JButton();
	JButton condition = new JButton();
	JButton tempature = new JButton();
	HashMap<String, WeatherData> weatherData = Utilities.getWeatherData();
	String cityName = "";

	void start() {
		
		
		
		frame.setVisible(true);
		frame.setSize(650, 275);
		frame.add(pane);
		pane.add(label);
		pane.add(search);
		pane.add(condition);
		pane.add(tempature);
		pane.setLayout(null);
		label.setBounds(50, 25, 500, 100);
		search.setBounds(50, 150, 150, 100);
		condition.setBounds(250, 150, 150, 100);
		tempature.setBounds(450, 150, 150, 100);
		search.setText("search");
		condition.setText("see conditions");
		tempature.setText("view tempature ranges");
		search.addActionListener(this);
		condition.addActionListener(this);
		tempature.addActionListener(this);
	

		// All city keys have the first letter capitalized of each word

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(search)) {
			cityName = JOptionPane.showInputDialog("what city would you like to view the weather of?");
			WeatherData datum = weatherData.get(cityName);
			label.setText(
					cityName + " is " + datum.weatherSummary + " with a temperature of " + datum.temperatureF + " F");
		} else if(e.getSource().equals(condition)) {
			String condition = JOptionPane.showInputDialog("what conditon do you want?");
			WeatherData datum = weatherData.get(cityName);
			for(String city : weatherData.keySet()) {
				WeatherData wd = weatherData.get(city);
				System.out.println(wd.weatherSummary);
				
			}
			label.setText(
					"all of these cities are " + datum.weatherSummary +  ": " + datum );
			
		} else {
			
		}
	}
}
