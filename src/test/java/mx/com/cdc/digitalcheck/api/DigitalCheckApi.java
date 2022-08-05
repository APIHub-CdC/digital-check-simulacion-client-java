package mx.com.cdc.digitalcheck.api;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mx.com.cdc.digitalcheck.api.DefaultApi;
import mx.com.cdc.digitalcheck.client.ApiClient;
import mx.com.cdc.digitalcheck.client.ApiException;
import mx.com.cdc.digitalcheck.model.Otorgante;
import mx.com.cdc.digitalcheck.model.Response;
import okhttp3.OkHttpClient;

public class DigitalCheckApi {
    private Logger logger = LoggerFactory.getLogger(DigitalCheckApi.class.getName());
    
    private final DefaultApi api = new DefaultApi();
    private ApiClient apiClient;
    private String xApiKey = "WMroAp3ByBDWFGtk5AD24wagIiR4RFvI";
    private String url = "https://circulodecredito-dev.apigee.net/sandbox/v1/fullfraud";
    
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
    	
    	otorgante.setFolioOtorgante("94762");
    	otorgante.setFolioConsulta("X");
    	otorgante.setEmail("nombre.apellido@gmail.com");
    	otorgante.setIp("104.28.11.164");
    	otorgante.setPhone("525510176606");
    	
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
