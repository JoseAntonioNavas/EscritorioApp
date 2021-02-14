package controller;

import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import model.numMarcas;

public class PrincipalController {

	
	
	public static ChartPanel grafica1() {
		
		List<numMarcas> nMarcas = service.GraficasService.getNumMarcasCatalogo();
		
		  DefaultPieDataset data = new DefaultPieDataset();
		  
		  for (numMarcas n: nMarcas) {
			
			  	data.setValue(n.getNombre_marca(), n.getNumMarca());
		       
		        
		  }
	      
	        // create a chart...
	        JFreeChart chart = ChartFactory.createPieChart(
	            "N�mero de veh�culos en Cat�logo por Marcas",
	            data,
	            true, // legend?
	            true, // tooltips?
	            false // URLs?
	        );
	        // create and display a frame...
	        ChartPanel frame = new ChartPanel(chart);
	        frame.setVisible(true);
	        
	        return frame;
	}
	
	   
	
	public static ChartPanel grafica2() {
		
		
		  JFreeChart barChart = ChartFactory.createBarChart(
			         "oa",           
			         "Category",            
			         "Score",            
			         createDataset(),          
			         PlotOrientation.VERTICAL,           
			         true, true, false);
			         
			      ChartPanel chartPanel = new ChartPanel( barChart );        
			      chartPanel.setVisible(true); 
		return chartPanel;
	}
	
	
	   private static CategoryDataset createDataset( ) {
		      final String fiat = "FIAT";        
		      final String audi = "AUDI";        
		      final String ford = "FORD";        
		      final String speed = "Speed";        
		      final String millage = "Millage";        
		      final String userrating = "User Rating";        
		      final String safety = "safety";        
		      final DefaultCategoryDataset dataset = 
		      new DefaultCategoryDataset( );  

		      dataset.addValue( 1.0 , fiat , speed );        
		      dataset.addValue( 3.0 , fiat , userrating );        
		      dataset.addValue( 5.0 , fiat , millage ); 
		      dataset.addValue( 5.0 , fiat , safety );           

		      dataset.addValue( 5.0 , audi , speed );        
		      dataset.addValue( 6.0 , audi , userrating );       
		      dataset.addValue( 10.0 , audi , millage );        
		      dataset.addValue( 4.0 , audi , safety );

		      dataset.addValue( 4.0 , ford , speed );        
		      dataset.addValue( 2.0 , ford , userrating );        
		      dataset.addValue( 3.0 , ford , millage );        
		      dataset.addValue( 6.0 , ford , safety );               

		      return dataset; 
		   }
		   



	
}


