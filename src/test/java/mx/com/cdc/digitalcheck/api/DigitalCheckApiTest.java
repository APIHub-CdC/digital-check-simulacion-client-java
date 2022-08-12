package mx.com.cdc.digitalcheck.api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.cdc.digitalcheck.client.ApiClient;
import mx.com.cdc.digitalcheck.client.ApiException;
import mx.com.cdc.digitalcheck.model.Otorgante;
import mx.com.cdc.digitalcheck.model.Response;
import okhttp3.OkHttpClient;

public class DigitalCheckApiTest {
    private Logger logger = LoggerFactory.getLogger(DigitalCheckApiTest.class.getName());
    
    private final DefaultApi api = new DefaultApi();
    private ApiClient apiClient;
    private String xApiKey = "your_x_api_key";
    private String url = "the_url";
    
    @Before()
    public void Setup() {
    	 this.apiClient = api.getApiClient();
         this.apiClient.setBasePath(url);
         OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
         apiClient.setHttpClient(okHttpClient);
    }
    
    @Test
    public void fullfraudTest() throws  ApiException {
    	
    	Otorgante otorgante = new Otorgante();
    	
    	otorgante.setFolioOtorgante("386636546");
    	otorgante.setFolioConsulta("386636538");
    	otorgante.setEmail("ejemplo.ejemplo@gmail.com");
    	otorgante.setIp("1103.4.96.66");
    	otorgante.setPhone("525512345678");
    	
    	try {
    		Response response = api.fullfraud(xApiKey, otorgante);
    		
    		Assert.assertTrue(response != null);
            if(response != null) {
                logger.info(response.toString());
            }
    	} catch (ApiException e) {
    		logger.info(e.getResponseBody());
    	}
    }
    
}
