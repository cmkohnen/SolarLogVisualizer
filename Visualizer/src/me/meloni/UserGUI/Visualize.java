package me.meloni.UserGUI;

import com.github.lgooddatepicker.components.DatePicker;
import me.meloni.Tools.DateConverter;
import me.meloni.Tools.Nord;
import me.meloni.UserGUI.Graphtemplates.Daily;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Visualize {


    public static void visualize(Map<String, List<Integer>> data) throws IOException {
        List<JComponent> l = new ArrayList<>();

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 600);
        f.setTitle("Visualize - Graph");

        JPanel text = new JPanel();
        text.setBackground(Nord.n2());
        text.setBounds(300,40,2000,1000);




        JPanel sidebar = new JPanel();
        sidebar.setBackground(Nord.n1());
        sidebar.setBounds(0,40,300,1000);

        JPanel dateselectorbackground = new JPanel();
        dateselectorbackground.setBounds(10, 250, 270, 110);
        dateselectorbackground.setBackground(Nord.n2());

        JTextPane dateselectordescription = new JTextPane();
        dateselectordescription.setBounds(10,255,270,70);
        dateselectordescription.setText("Please select a Date you want to display.");
        dateselectordescription.setFont(new Font("Courier", Font.PLAIN, 20));
        dateselectordescription.setForeground(Nord.n6());
        dateselectordescription.setBackground(Nord.n2());
        dateselectordescription.setEditable(false);


        DatePicker picker = new DatePicker();
        picker.setBounds(20,330,250,25);
        picker.setBackground(Nord.n7());
        picker.addDateChangeListener(dateChangeEvent -> {
            String daystamp = DateConverter.dayfrompicker(dateChangeEvent.getNewDate().toString());
           // System.out.println(daystamp);
          //  System.out.println(data.get(daystamp + "000000"));
            if(data.containsKey(daystamp + "000000")){
                //System.out.println("hä?");
                List<String> timestamps = DateConverter.Timestampsperday(daystamp);

                List<List<Double>> graphdata = new ArrayList<>();




                for(int i = 0; i < 287; i++) {
                    List<Double> currentdata= new ArrayList<>();
                    int verbrauchw = data.get(timestamps.get(i)).get(0);
                    int verbrauchkwh = data.get(timestamps.get(i)).get(1);
                    int leistungw = data.get(timestamps.get(i)).get(2);
                    int ertragkwh = data.get(timestamps.get(i)).get(3);
                    int energieverbrauchw = data.get(timestamps.get(i)).get(4);

                    currentdata.add((double) verbrauchw);
                    currentdata.add((double) verbrauchkwh);
                    currentdata.add((double) leistungw);
                    currentdata.add((double) ertragkwh);
                    currentdata.add((double) energieverbrauchw);

                    graphdata.add(currentdata);
                }

                text.setVisible(false);
                l.forEach(s1 ->{
                    s1.setVisible(false);
                    f.remove(s1);
                });
                Daily cmp = new Daily(graphdata);
                f.setTitle("Visualize - "+DateConverter.day(daystamp));
                l.add(cmp);
                f.add(cmp);
                //System.out.println(daystamp);
            } else {
                //System.out.println("nö");
                if(!(dateChangeEvent.getOldDate() == null)){
                    picker.setDate(dateChangeEvent.getOldDate());
                }
            }

        });
        picker.setVisible(false);
        f.add(picker);


        String[] types = {"", "Day view"};

        JTextPane typeselectdescription = new JTextPane();
        typeselectdescription.setBounds(10,50,270,160);
        typeselectdescription.setText("Please select one of the following view types to display the information: daily, monthly, yearly.");
        typeselectdescription.setFont(new Font("Courier", Font.PLAIN, 20));
        typeselectdescription.setForeground(Nord.n6());
        typeselectdescription.setBackground(Nord.n2());
        typeselectdescription.setEditable(false);

        JComboBox viewtypeselectorbox = new JComboBox(types);
        viewtypeselectorbox.setSelectedIndex(0);
        viewtypeselectorbox.setBounds(20,175,250,25);
        viewtypeselectorbox.addActionListener(e->{
            JComboBox cb = (JComboBox)e.getSource();
            String str = (String)cb.getSelectedItem();

            assert str != null;
            if(str.equals("")){
                l.forEach(p->{
                    p.setVisible(false);
                    f.remove(p);
                        });
                dateselectordescription.setVisible(false);
                dateselectorbackground.setVisible(false);
                System.out.println("Test");
            }

            if(str.equals("Day view")){
                picker.setVisible(true);
                dateselectordescription.setVisible(true);
                dateselectorbackground.setVisible(true);
                System.out.println("Test2");
            }

        });


        f.add(dateselectordescription);
        f.add(viewtypeselectorbox);
        f.add(typeselectdescription);
        f.add(dateselectorbackground);

        f.add(MainWindow.header(1600));
        f.add(sidebar);
        f.add(text);

        dateselectordescription.setVisible(false);
        dateselectorbackground.setVisible(false);

        f.setBackground(new Color(76, 86, 106, 255));
        f.setSize(1600, 1000);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
}
