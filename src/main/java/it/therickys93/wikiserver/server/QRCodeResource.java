package it.therickys93.wikiserver.server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.security.auth.login.Configuration;

import org.restlet.data.MediaType;
import org.restlet.representation.ObjectRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import it.therickys93.wikiserver.utils.Configurations;

public class QRCodeResource extends ServerResource {
	
	private static int QRCODE_WIDTH  = 350;
	private static int QRCODE_HEIGHT = 350;
	
	private byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
	    QRCodeWriter qrCodeWriter = new QRCodeWriter();
	    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
	    
	    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
	    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
	    byte[] pngData = pngOutputStream.toByteArray(); 
	    return pngData;
	}
	
	private byte[] generateQRCode(String text) throws WriterException, IOException {
		return getQRCodeImage(text, QRCODE_WIDTH, QRCODE_HEIGHT);
	}
	
	@Get
	public Representation qrcode() throws WriterException, IOException {
		getLogger().info("GET /qrcode");
		byte[] data = generateQRCode(Configurations.qrcodeUrl());
		ObjectRepresentation<byte []> or = new ObjectRepresentation<byte[]>(data, MediaType.IMAGE_PNG){
			@Override
			public void write(OutputStream outputStream) throws IOException {
				super.write(outputStream);
				outputStream.write(this.getObject());
			}
		};
		return or;
		
	}

}
