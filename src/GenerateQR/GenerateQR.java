/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GenerateQR;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 *
 * @author sonu
 */
public class GenerateQR {
    /**
	 * @param args
	 * @throws WriterException
	 * @throws IOException
	 */
    public static void GenerateQRC(String text) {
        try{
            start(text);
        }catch(Exception e) {
            System.out.print(e.toString());
        }
    }
    
    public static void start(String text) throws WriterException, IOException,
                    NotFoundException {
            String qrCodeData = text;
            String filePath = text+".png";
            String charset = "UTF-8"; 
            Map hintMap = new HashMap();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            createQRCode(qrCodeData, filePath, charset, hintMap, 100, 100);
            System.out.println("QR Code image created successfully!");
//            System.out.println("Data read from QR Code: " + readQRCode(filePath, charset, hintMap));

    }

    public static void createQRCode(String qrCodeData, String filePath,
                    String charset, Map hintMap, int qrCodeheight, int qrCodewidth)
                    throws WriterException, IOException {
            BitMatrix matrix = new MultiFormatWriter().encode(
                            new String(qrCodeData.getBytes(charset), charset),
                            BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                            .lastIndexOf('.') + 1), new File("QR/" + filePath));
    }

//    public static String readQRCode(String filePath, String charset, Map hintMap)
//                    throws FileNotFoundException, IOException, NotFoundException {
//            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
//                            new BufferedImageLuminanceSource(
//                                            ImageIO.read(new FileInputStream(filePath)))));
//            Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap,  hintMap);
//            return qrCodeResult.getText();
//    }
    
//    public static void main(String ar[]){
//        new GenerateQR("nk");
//    }

}
