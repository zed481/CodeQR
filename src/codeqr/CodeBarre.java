package codeqr;

import java.awt.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * Création d'un Code QR
 *
 * https://github.com/zxing/zxing
 * https://repo1.maven.org/maven2/com/google/zxing/core/3.3.0/core-3.3.0.jar
 * https://repo1.maven.org/maven2/com/google/zxing/javase/3.3.0/javase-3.3.0.jar
 *
 * @author (2020-01)
 */
public class CodeBarre {

    /**
     * Création d'une image contenant le code QR
     *
     * @param strToEncode String à encoder dans le code QR
     * @param intTaille Taille du codeQR
     * @return Image
     * @throws WriterException
     * @throws HeadlessException
     */
    public static BufferedImage getCodeQR( final String strToEncode, final int intTaille ) throws WriterException, HeadlessException {

        final Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<>();
        hintMap.put( EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L );

        final QRCodeWriter qrCodeWriter = new QRCodeWriter();
        final BitMatrix byteMatrix = qrCodeWriter.encode( strToEncode, BarcodeFormat.QR_CODE, intTaille, intTaille, hintMap );
        final int Width = byteMatrix.getWidth();
        final BufferedImage imgCodeQR = new BufferedImage( Width, Width, BufferedImage.TYPE_INT_RGB );
        imgCodeQR.createGraphics();

        final Graphics2D graphics = ( Graphics2D ) imgCodeQR.getGraphics();
        graphics.setColor( Color.WHITE );
        graphics.fillRect( 0, 0, Width, Width );
        graphics.setColor( Color.BLACK );

        for ( int i = 0; i < Width; i++ ) {
            for ( int j = 0; j < Width; j++ ) {
                if ( byteMatrix.get( i, j ) ) {
                    graphics.fillRect( i, j, 1, 1 );
                }
            }
        }
        return imgCodeQR;
    }
}
