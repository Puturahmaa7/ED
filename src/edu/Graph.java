
package edu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.BarPainter;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleEdge;


public class Graph extends javax.swing.JFrame {

    public Graph() {
        initComponents();
        initChart();
    }
    private void initChart(){
        DefaultCategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel cPanel = new ChartPanel(chart);
        cPanel.setPreferredSize(new Dimension(800,600));
        //setContentPane(cPanel);
        setCustomChart(chart);
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(cPanel, BorderLayout.CENTER);
        jPanel1.validate();
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(10, "Waktu Belajar", "Hari 1");
        dataset.addValue(25, "Waktu Belajar", "Hari 2"); 
        dataset.addValue(39, "Waktu Belajar", "Hari 3");
        dataset.addValue(41, "Waktu Belajar", "Hari 4");
        dataset.addValue(53, "Waktu Belajar", "Hari 5");
        dataset.addValue(68, "Waktu Belajar", "Hari 6");
        dataset.addValue(77, "Waktu Belajar", "Hari 7");        
        return dataset;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset){
        JFreeChart barChart = ChartFactory.createBarChart(
            "Statistik Waktu Fokus", 
            "Hari", 
            "Waktu Belajar", 
            dataset);
        return barChart;
    }
    
    private void setCustomChart(JFreeChart chart){
        TextTitle title = new TextTitle(chart.getTitle().getText(), new Font ("Segoe UI", Font.BOLD, 14));
        title.setPaint(new java.awt.Color(0, 10, 153));
        chart.setTitle(title);
        
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLabelFont(new Font ("Segoe UI", Font.BOLD, 12));
        domainAxis.setTickLabelFont(new Font ("Segoe UI", Font.BOLD, 10));
        domainAxis.setLabelPaint(new java.awt.Color(0, 10, 153));
        domainAxis.setTickLabelPaint(new java.awt.Color(0, 10, 153));
        
        plot.setOutlineVisible(false);
        plot.setRangeGridlinesVisible(false);  
        
        ValueAxis rangeAxis = plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font ("Segoe UI", Font.BOLD, 12));
        rangeAxis.setTickLabelFont(new Font ("Segoe UI", Font.BOLD, 10));
        rangeAxis.setLabelPaint(new java.awt.Color(0, 10, 153));
        rangeAxis.setTickLabelPaint(new java.awt.Color(0, 10, 153));
        
        plot.setBackgroundPaint(new java.awt.Color(255, 252, 235));
        BarRenderer renderer =(BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new java.awt.Color(255,174,57));

        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 252, 235));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graph.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graph().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
