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
		
		List<numMarcas> nMarcas = service.GraficasService.getNumMarcasCarrito();
		
		  DefaultPieDataset data = new DefaultPieDataset();
		  
		  
		  if(nMarcas.size() > 0) {
			  for (numMarcas n: nMarcas) {
					
				  	data.setValue(n.getNombre_marca(), n.getNumMarca());
			          
			  }
		  }else{
			  
		  }

	      
	        // create a chart...
	        JFreeChart chart = ChartFactory.createPieChart(
	            "Número de Marcas en Carrito",
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
			         "Número de vehículos en Catálogo por Marcas",           
			         "Marcas",            
			         "Unidades",            
			         createDataset(),          
			         PlotOrientation.VERTICAL,           
			         true, true, false);
			         
			      ChartPanel chartPanel = new ChartPanel( barChart );        
			      chartPanel.setVisible(true); 
		return chartPanel;
	}
	
	
	   private static CategoryDataset createDataset( ) {
			List<numMarcas> nMarcas = service.GraficasService.getNumMarcasCatalogo();
		      final DefaultCategoryDataset dataset = 
		      new DefaultCategoryDataset( );  

		      for (numMarcas numMarcas : nMarcas) {
		          dataset.addValue( numMarcas.getNumMarca() , numMarcas.getNombre_marca() , "Marcas" );   
			}
		      
		 
		      return dataset; 
		   }
		   



	
}


