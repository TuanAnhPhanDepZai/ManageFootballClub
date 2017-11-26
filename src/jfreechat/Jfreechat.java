package jfreechat;

import javax.swing.JDialog;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author TUNGDUONG
 */
public class Jfreechat extends JDialog {

    
    private CategoryDataset createDataset(String[] string) {
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int  i = 0 ; i < string.length ; i ++){
           String[] word = processData1(string[i]);
                int doanhthuquy1 = Integer.valueOf(word[0]);
                int doanhthuquy2 = Integer.valueOf(word[1]);
                int doanhthuquy3 = Integer.valueOf(word[2]);
                int doanhthuquy4 = Integer.valueOf(word[3]);
                dataset.addValue(doanhthuquy1, "Quy 1", word[4]);
                dataset.addValue(doanhthuquy2, "Quy 2", word[4]);
                dataset.addValue(doanhthuquy3, "Quy 3", word[4]);
                dataset.addValue(doanhthuquy4, "Quy 4", word[4]);
                
        }        

        return dataset;
    }

    public JFreeChart createBarChart(String[] string) {
        JFreeChart barChart = ChartFactory.createBarChart(
                "Biểu đồ doanh thu câu lạc bộ theo các năm va cac quý".toUpperCase(),
                "Nam", "Doanh thu (usd)",
                createDataset(string), PlotOrientation.VERTICAL, true, true, false);
        return barChart;
    }

    public Jfreechat(String[] string) {
        ChartPanel chartPanel = new ChartPanel(createBarChart(string));
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 600));
        this.setVisible(true);
       
        this.setLocation(100, 50);
        this.setSize(1100, 650);
        this.setResizable(false);
        this.add(chartPanel);
        this.setTitle("Biểu đồ doanh thu câu lạc bộ");
    }

    public static void main(String[] args) {

//        JFrame frame = new JFrame();
//        frame.add(chartPanel);
//        frame.setSize(600, 400);
//        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
//        frame.setVisible(true);
        //   new Jfreechat();
        String string[] = new String[3];
        new Jfreechat(string);
    }

    public String[] processData1(String string) {
        String[] data = string.split(",");
        return data;
    }
}
