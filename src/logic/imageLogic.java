package logic;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.ws.spi.http.HttpContext;


public class imageLogic {

	public static File archivo;

	public static void seleccionarFichero() {

	JFileChooser selectorArchivos = new JFileChooser();
	selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	selectorArchivos.showOpenDialog(null);
	
		try {
	
		archivo = selectorArchivos.getSelectedFile();
		
		BufferedImage img =  resize(loadImage(archivo.getAbsolutePath()),314,217);
		view.FormVehiculosCatalogo.lblLoadImg.setIcon(new ImageIcon(img));
		
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	
	public static void download(String pathName) {

	String path = "https://joseant1.000webhostapp.com/public/images/"+pathName+".jpg";

		try {
	
			URL url = new URL(path);
			BufferedImage image = ImageIO.read(url);
			
			BufferedImage img = resize(image, 314, 217);
			
			view.FormVehiculosCatalogo.lblLoadImg.setIcon(new ImageIcon(img));
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "La imagen no se ha descargado correctamente","UPLOAD",JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void upload(String id_vehiculo) {
		

	try {

	String filePath = archivo.getAbsolutePath();
	String fileName = archivo.getName();

	
	
	String path = "https://joseant1.000webhostapp.com/public/api/photo/photoCoche";

	//Establecer conexion

	URL url = new URL(path);
	URLConnection con = url.openConnection();
	HttpURLConnection http = (HttpURLConnection) con;
	http.setRequestMethod("POST");
	http.setDoOutput(true);

	//Parametros de envio

	Map<String,String> params = new HashMap<String, String>();
	//params.put("fileName", fileNameWithOutExt);
	params.put("fileData", encoderFileToBase64(filePath) );
	params.put("id_vehiculo",id_vehiculo);

	// Array de Bytes de envio
	StringJoiner sj = new StringJoiner("&");

	for (Map.Entry<String, String> entry : params.entrySet()) {
	sj.add( URLEncoder.encode(entry.getKey(),"UTF-8") + "=" + URLEncoder.encode(entry.getValue(),"UTF-8"));
	}

	byte[] out = sj.toString().getBytes(StandardCharsets.UTF_8);

	// ENVIAR EL ARRAY DE BYTES HACIA EL PATH (url del webservice)

	http.setFixedLengthStreamingMode(out.length);
	http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
	http.connect();
	http.getOutputStream().write(out);


	JOptionPane.showMessageDialog(null, "La imagen ha sido subida correctamente","UPLOAD",JOptionPane.INFORMATION_MESSAGE);


	} catch (Exception e) {

	JOptionPane.showMessageDialog(null, e.getMessage(),"UPLOAD",JOptionPane.ERROR_MESSAGE);
	}

	}

	
	
	
	
	
	private static String encoderFileToBase64(String filePath) {

		String base64Image = "";
		File file = new File(filePath);
	
			try(FileInputStream imageInFile = new FileInputStream(file)) {
		
			byte imageData[] = new byte[ (int) file.length()];
			imageInFile.read(imageData);
			base64Image = Base64.getEncoder().encodeToString(imageData);
		
			} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"FALLO",JOptionPane.ERROR_MESSAGE);
			}
			
		return base64Image;
	}
	
	
	 /*
    Este método se utiliza para redimensionar la imagen
    */
    public static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {
        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());
        Graphics2D g = bufim.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return bufim;
    }
    
    public static BufferedImage loadImage(String pathName) {
        BufferedImage bimage = null;
        try {
            bimage = ImageIO.read(new File(pathName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bimage;
    }
 
    
    
    public static String updateImage() {
    	
    	
    	try {
    		String filePath = archivo.getAbsolutePath();
       	 	return encoderFileToBase64(filePath);
       	 	 
		} catch (Exception e) {
			return "";
		}
    
    	 
    	 
    }

	
}
