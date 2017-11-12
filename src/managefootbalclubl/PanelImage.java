package managefootbalclubl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.prism.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelImage extends JPanel{

	private BufferedImage image;
    
	public PanelImage() {
		
		
		
            try {
                image = ImageIO.read(new File("download.jpg"));
                
                ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(900, 200,image.SCALE_SMOOTH));
                JLabel label = new JLabel();        
                label.setIcon(imageIcon);
                add(label);
                
                
                
               
                
                
            } catch (IOException ex) {
                Logger.getLogger(PanelImage.class.getName()).log(Level.SEVERE, null, ex);
            }
	
            this.setVisible(true);
	}

   public static void main(String[] args) {
	new PanelImage().setVisible(true);
}

}
