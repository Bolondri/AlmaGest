/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.almasoft.almagest.utils;

/**
 *
 * @author amdel
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

    private static final long serialVersionUID = 3813223397371003521L;

    private Image image;
    private int imageWidth;
    private int imageHeight;

    public ImagePanel(String resourceLocation) {
        Image image = ImageUtils.loadImageFromResource(resourceLocation, this);
        setImage(image);
    }

    public ImagePanel(Image image) {
        setImage(image);
    }

    private void setImage(Image image) {
        this.image = image;
        this.imageWidth = this.image.getWidth(null);
        this.imageHeight = this.image.getHeight(null);
        Dimension imageSize = new Dimension(this.imageWidth, this.imageHeight);
        this.setSize(imageSize);
        this.setPreferredSize(imageSize);
    }

    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);
        if (this.image != null) {
            gr.drawImage(image, 0, 0, this.imageWidth, this.imageHeight, this);
        }
    }
}
