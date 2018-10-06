package it.therickys93.wikiserver.server;

import java.io.IOException;
import java.io.OutputStream;

import org.restlet.data.MediaType;
import org.restlet.representation.ObjectRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.google.zxing.WriterException;

import it.therickys93.wikiserver.utils.Configurations;
import it.therickys93.wikiserver.utils.QRCode;

public class QRCodeVersionOneResource extends ServerResource {

	private static final String url = "/v1/wiki";
	
	@Get
	public Representation qrcode() throws WriterException, IOException {
		getLogger().info("GET /v1/qrcode");
		byte[] data = QRCode.generateQRCode(Configurations.qrcodeUrl() + url);
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
