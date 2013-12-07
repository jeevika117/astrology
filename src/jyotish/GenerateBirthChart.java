package jyotish;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;

import jyotish.main.BirthData;
import jyotish.main.Chart;

public class GenerateBirthChart extends JFrame {

	private JPanel contentPane;

	private JTextField txt_day;
	private JTextField txt_mnth;
	private JTextField txt_year;
	private JTextField txt_hour;
	private JTextField txt_min;
	private JTextField txt_lon_deg;
	private JTextField txt_lon_min;
	private JTextField txt_lon_EW;
	private JTextField txt_lat_deg;
	private JTextField txt_lat_min;
	private JTextField txt_lat_NS;
	private JTextField txt_timezne;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateBirthChart frame = new GenerateBirthChart();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GenerateBirthChart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lbl_date = new JLabel("Date");
		GridBagConstraints gbc_lbl_date = new GridBagConstraints();
		gbc_lbl_date.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_date.gridx = 1;
		gbc_lbl_date.gridy = 1;
		getContentPane().add(lbl_date, gbc_lbl_date);
		
		txt_day = new JTextField();
		GridBagConstraints gbc_txt_day = new GridBagConstraints();
		
		gbc_txt_day.insets = new Insets(0, 0, 5, 5);
		gbc_txt_day.gridx = 3;
		gbc_txt_day.gridy = 1;
		getContentPane().add(txt_day, gbc_txt_day);
		txt_day.setColumns(10);
		
		txt_mnth = new JTextField();
		GridBagConstraints gbc_txt_mnth = new GridBagConstraints();
		gbc_txt_mnth.insets = new Insets(0, 0, 5, 5);
		gbc_txt_mnth.gridx = 4;
		gbc_txt_mnth.gridy = 1;
		getContentPane().add(txt_mnth, gbc_txt_mnth);
		txt_mnth.setColumns(10);
		
		txt_year = new JTextField();
		GridBagConstraints gbc_txt_year = new GridBagConstraints();
		gbc_txt_year.insets = new Insets(0, 0, 5, 0);
		gbc_txt_year.gridx = 5;
		gbc_txt_year.gridy = 1;
		getContentPane().add(txt_year, gbc_txt_year);
		txt_year.setColumns(10);
		
		JLabel lbl_time = new JLabel("Time");
		GridBagConstraints gbc_lbl_time = new GridBagConstraints();
		gbc_lbl_time.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_time.gridx = 1;
		gbc_lbl_time.gridy = 2;
		getContentPane().add(lbl_time, gbc_lbl_time);
		
		txt_hour = new JTextField();
		GridBagConstraints gbc_txt_hour = new GridBagConstraints();
		gbc_txt_hour.insets = new Insets(0, 0, 5, 5);
		gbc_txt_hour.gridx = 3;
		gbc_txt_hour.gridy = 2;
		getContentPane().add(txt_hour, gbc_txt_hour);
		txt_hour.setColumns(10);
		
		txt_min = new JTextField();
		GridBagConstraints gbc_txt_min = new GridBagConstraints();
		gbc_txt_min.insets = new Insets(0, 0, 5, 5);
		gbc_txt_min.gridx = 4;
		gbc_txt_min.gridy = 2;
		getContentPane().add(txt_min, gbc_txt_min);
		txt_min.setColumns(10);
		
		JLabel lbl_timezne = new JLabel("TimeZone");
		GridBagConstraints lbl_gbc_timezne = new GridBagConstraints();
		lbl_gbc_timezne.insets = new Insets(0, 0, 5, 5);
		lbl_gbc_timezne.gridx = 1;
		lbl_gbc_timezne.gridy = 3;
		getContentPane().add(lbl_timezne, lbl_gbc_timezne);
		
		txt_timezne = new JTextField();
		GridBagConstraints gbc_txt_timezne = new GridBagConstraints();
		gbc_txt_timezne.insets = new Insets(0, 0, 5, 5);
		gbc_txt_timezne.gridx = 3;
		gbc_txt_timezne.gridy = 3;
		getContentPane().add(txt_timezne, gbc_txt_timezne);
		txt_timezne.setColumns(10);
		
		JLabel lbl_lon = new JLabel("Longitude");
		GridBagConstraints gbc_lbl_long = new GridBagConstraints();
		gbc_lbl_long.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_long.gridx = 1;
		gbc_lbl_long.gridy = 4;
		getContentPane().add(lbl_lon, gbc_lbl_long);
		
		txt_lon_deg = new JTextField();
		GridBagConstraints gbc_txt_lon_deg = new GridBagConstraints();
		gbc_txt_lon_deg.insets = new Insets(0, 0, 5, 5);
		gbc_txt_lon_deg.gridx = 3;
		gbc_txt_lon_deg.gridy = 4;
		getContentPane().add(txt_lon_deg, gbc_txt_lon_deg);
		txt_lon_deg.setColumns(10);
		
		txt_lon_EW = new JTextField();
		GridBagConstraints gbc_txt_lon_EW = new GridBagConstraints();
		gbc_txt_lon_EW.insets = new Insets(0, 0, 5, 5);
		gbc_txt_lon_EW.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_lon_EW.gridx = 4;
		gbc_txt_lon_EW.gridy = 4;
		getContentPane().add(txt_lon_EW, gbc_txt_lon_EW);
		txt_lon_EW.setColumns(10);
		
		txt_lon_min = new JTextField();
		GridBagConstraints gbc_txt_lon_min = new GridBagConstraints();
		gbc_txt_lon_min.insets = new Insets(0, 0, 5, 0);
		gbc_txt_lon_min.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_lon_min.gridx = 5;
		gbc_txt_lon_min.gridy = 4;
		getContentPane().add(txt_lon_min, gbc_txt_lon_min);
		txt_lon_min.setColumns(10);
		
		JLabel lbl_lat = new JLabel("Lattitude");
		GridBagConstraints gbc_lbl_lat = new GridBagConstraints();
		gbc_lbl_lat.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_lat.gridx = 1;
		gbc_lbl_lat.gridy = 5;
		getContentPane().add(lbl_lat, gbc_lbl_lat);
		
		txt_lat_deg = new JTextField();
		GridBagConstraints gbc_txt_lat_deg = new GridBagConstraints();
		gbc_txt_lat_deg.insets = new Insets(0, 0, 5, 5);
		gbc_txt_lat_deg.gridx = 3;
		gbc_txt_lat_deg.gridy = 5;
		getContentPane().add(txt_lat_deg, gbc_txt_lat_deg);
		txt_lat_deg.setColumns(10);
		
		txt_lat_NS = new JTextField();
		GridBagConstraints gbc_txt_lat_NS = new GridBagConstraints();
		gbc_txt_lat_NS.insets = new Insets(0, 0, 5, 5);
		gbc_txt_lat_NS.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_lat_NS.gridx = 4;
		gbc_txt_lat_NS.gridy = 5;
		getContentPane().add(txt_lat_NS, gbc_txt_lat_NS);
		txt_lat_NS.setColumns(10);
		
		txt_lat_min = new JTextField();
		GridBagConstraints gbc_txt_lat_min = new GridBagConstraints();
		gbc_txt_lat_min.insets = new Insets(0, 0, 5, 0);
		gbc_txt_lat_min.fill = GridBagConstraints.HORIZONTAL;
		gbc_txt_lat_min.gridx = 5;
		gbc_txt_lat_min.gridy = 5;
		getContentPane().add(txt_lat_min, gbc_txt_lat_min);
		txt_lat_min.setColumns(10);
		
		JButton btn_generate = new JButton("Generate");
		btn_generate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Test test = new Test();
				BirthData birthdata = new BirthData();
				birthdata.setBirthDate(Integer.parseInt(txt_day.getText()));
				birthdata.setBirthMonth(Integer.parseInt(txt_mnth.getText()));
				birthdata.setBirthYear(Integer.parseInt(txt_year.getText()));
				birthdata.setBirthHour(Integer.parseInt(txt_hour.getText()));
				birthdata.setBirthMinute(Integer.parseInt(txt_min.getText()));
				birthdata.setBirthSecond(0);
				birthdata.setIsEast(txt_lon_EW.getText().contains("E"));
				birthdata.setIsNorth(txt_lat_NS.getText().contains("N"));
				birthdata.setLongitude_Deg(Integer.parseInt(txt_lon_deg.getText()));
				birthdata.setLongitude_Min(Integer.parseInt(txt_lon_min.getText()));
				birthdata.setLongitude_Sec(0);
				birthdata.setLatitude_Deg(Integer.parseInt(txt_lat_deg.getText()));
				birthdata.setLatitude_Min(Integer.parseInt(txt_lat_min.getText()));
				birthdata.setLongitude_Sec(0);
				birthdata.setTimeZoneOffset(Float.parseFloat(txt_timezne.getText()));
				
				Chart chart = test.generateBirthChart(birthdata);
			}
		});
		GridBagConstraints gbc_btn_generate = new GridBagConstraints();
		gbc_btn_generate.insets = new Insets(0, 0, 0, 5);
		gbc_btn_generate.gridx = 3;
		gbc_btn_generate.gridy = 6;
		getContentPane().add(btn_generate, gbc_btn_generate);

	}
}
