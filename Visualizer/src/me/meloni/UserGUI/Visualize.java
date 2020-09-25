package me.meloni.UserGUI;

import com.github.lgooddatepicker.components.DatePicker;
import me.meloni.Tools.DateConverter;
import me.meloni.Tools.Nord;
import me.meloni.UserGUI.Graphtemplates.Daily;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class for visualizing the data provided.
 *
 * @author ChaosMelone9
 *
 * @since 0.0.1
 */
public class Visualize {

    //FRAME
    static JFrame f = new JFrame();

    static String[] types = {"", "Day view"};
    static List<JComponent> l = new ArrayList<>();


    //Components
    static JPanel text = new JPanel();
    static JPanel sidebar = new JPanel();
    static JPanel dateselectorbackground = new JPanel();
    static JPanel valuesbackground = new JPanel();
    static JTextPane dateselectordescription = new JTextPane();
    static JTextPane values = new JTextPane();
    static DatePicker picker = new DatePicker();
    static JTextPane typeselectdescription = new JTextPane();
    static JComboBox<String> viewtypeselectorbox = new JComboBox<>(types);

    static String daystamp="000000";

    static Map<String, List<Integer>> data;

    /**
     * Visualizes given datamap.
     *
     * @since 0.0.5
     */
    public static void visualize(Map<String, List<Integer>> givendata) {
        data = givendata;

        setupframe();
        setupevents();



    }

    public static void setupframe(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000, 600);
        f.setTitle("Visualize - Graph");

        setupcomponents();
        addcomponents();



        f.setBackground(new Color(76, 86, 106, 255));
        f.setSize(1600, 1000);
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }

    private static void setupevents() {
        viewtypeselectorbox.addActionListener(e->{
            String str = (String) ((JComboBox<String>)e.getSource()).getSelectedItem();

            assert str != null;
            if(str.equals("")){
                l.forEach(p->{
                    p.setVisible(false);
                    f.remove(p);
                });
                dateselectordescription.setVisible(false);
                dateselectorbackground.setVisible(false);
            }

            if(str.equals("Day view")){
                dateselectordescription.setVisible(true);
                dateselectorbackground.setVisible(true);
                picker.setVisible(true);
            }

        });

        picker.addDateChangeListener(dateChangeEvent -> {
            daystamp = DateConverter.dayfrompicker(dateChangeEvent.getNewDate().toString());
            if(data.containsKey(daystamp + "000000")){

                text.setVisible(false);
                l.forEach(s1 ->{
                    s1.setVisible(false);
                    f.remove(s1);
                });


                Daily cmp = new Daily(graphdata(data));
                f.setTitle("Visualize - "+DateConverter.day(daystamp));
                l.add(cmp);
                f.add(cmp);
            } else {
                if(!(dateChangeEvent.getOldDate() == null)){
                    picker.setDate(dateChangeEvent.getOldDate());
                }
            }

        });

    }

    private static void setupcomponents() {
        text.setBackground(Nord.n2());
        text.setBounds(300,40,2000,1000);

        sidebar.setBackground(Nord.n1());
        sidebar.setBounds(0,40,300,1000);

        dateselectorbackground.setBounds(10, 250, 270, 110);
        dateselectorbackground.setBackground(Nord.n2());

        valuesbackground.setBounds(10, 750, 270, 610);
        valuesbackground.setBackground(Nord.n2());

        values.setBounds(10, 750,270, 610);
        values.setFont(new Font("Courier", Font.PLAIN, 20));
        values.setForeground(Nord.n6());
        values.setBackground(Nord.n2());
        values.setEditable(false);

        dateselectordescription.setBounds(10,255,270,70);
        dateselectordescription.setText("Please select a Date you want to display.");
        dateselectordescription.setFont(new Font("Courier", Font.PLAIN, 20));
        dateselectordescription.setForeground(Nord.n6());
        dateselectordescription.setBackground(Nord.n2());
        dateselectordescription.setEditable(false);

        picker.setBounds(20,330,250,25);
        picker.setBackground(Nord.n7());
        picker.setVisible(false);

        typeselectdescription.setBounds(10,50,270,160);
        typeselectdescription.setText("Please select one of the following view types to display the information: daily, monthly, yearly.");
        typeselectdescription.setFont(new Font("Courier", Font.PLAIN, 20));
        typeselectdescription.setForeground(Nord.n6());
        typeselectdescription.setBackground(Nord.n2());
        typeselectdescription.setEditable(false);


        viewtypeselectorbox.setSelectedIndex(0);
        viewtypeselectorbox.setBounds(20,175,250,25);

    }

    private static void addcomponents(){
        f.add(dateselectordescription);
        f.add(viewtypeselectorbox);
        f.add(typeselectdescription);
        f.add(dateselectorbackground);
        f.add(valuesbackground);
        f.add(values);


        f.add(MainWindow.header(1600));
        f.add(sidebar);
        f.add(picker);
        f.add(text);


        dateselectordescription.setVisible(false);
        dateselectorbackground.setVisible(false);
    }

    public static void repaint(){
        l.forEach(c->{
            c.setVisible(false);
            c.repaint();
            c.setVisible(true);
                });
    }

    public static void showvalues(boolean showing,List<String> MouseValues){
        if(showing){
            values.setVisible(true);
            values.setText("verbrauchw: " + MouseValues.get(0) + "\nverbrauchkwh: " + MouseValues.get(1) + "\nleistungw: " + MouseValues.get(2) + "\nertragkwh: " + MouseValues.get(3) + "\nenergieverbrauchw: " + MouseValues.get(4));



        } else {
            values.setVisible(false);
        }

    }

    private static List<List<Double>> graphdata(Map<String, List<Integer>> data){
        List<List<Double>> graphdata = new ArrayList<>();
        List<String> timestamps = DateConverter.Timestampsperday(daystamp);

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

        return graphdata;
    }
}
