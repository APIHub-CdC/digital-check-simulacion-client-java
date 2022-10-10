# digital-check-simulacion-client-java [![GitHub Packages](https://img.shields.io/badge/Maven&nbsp;package-Last&nbsp;version-lemon)](https://github.com/orgs/APIHub-CdC/packages?repo_name=digital-check-simulacion-client-java) 


API Digital Checks.
<br/><br/>
A través de datos como correo electrónico, número telefónico y dirección IP, proporciona un grade de riesgo de fraude de originación y a la vez obtiene información relevante para mejor conocimiento del perfil de riesgo del usuario.<br/><img src='https://github.com/APIHub-CdC/imagenes-cdc/blob/master/circulo_de_credito-apihub.png' height='37' width='160'/></p><br/>

## Requisitos

1. Java 1.7+
2. Maven >= 3.3

## Instalación

Para la instalación de las dependencias se deberá ejecutar el siguiente comando:
```shell
mvn install -Dmaven.test.skip=true
```

> **NOTA:** Este fragmento del comando *-Dmaven.test.skip=true* evitará que se lance la prueba unitaria.


## Guía de inicio

### Paso 1. Agregar el producto a la aplicación

Al iniciar sesión seguir los siguientes pasos:

 1. Dar clic en la sección "**Mis aplicaciones**".
 2. Seleccionar la aplicación.
 3. Ir a la pestaña de "**Editar '@tuApp**' ".
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/edit_applications.jpg" width="900">
    </p>
 4. Al abrirse la ventana emergente, seleccionar el producto.
 5. Dar clic en el botón "**Guardar App**":
    <p align="center">
      <img src="https://github.com/APIHub-CdC/imagenes-cdc/blob/master/selected_product.jpg" width="400">
    </p>

### Paso 2. Capturar los datos de la petición

Los siguientes datos a modificar se encuentran en ***cd src/test/java/mx/com/cdc/digitalcheck/api/DigitalCheckApi.java***

Es importante contar con el setUp() que se encargará de inicializar la url. Modificar la URL ***('the_url')***, como se muestra en el siguiente fragmento de código:

```java
private Logger logger = LoggerFactory.getLogger(DigitalCheckApi.class.getName());
private final DefaultApi api = new DefaultApi();
private ApiClient apiClient;
private String xApiKey = "your_api_key";
private String url = "the_url";

@Before()
public void setUp() {
    this.apiClient = api.getApiClient();
     this.apiClient.setBasePath(url);
     OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .readTimeout(30, TimeUnit.SECONDS)
            .build();
     apiClient.setHttpClient(okHttpClient);
}
```
De igual manera, en el archivo **DigitalCheckApi.java**, se deberá modificar el siguiente fragmento de código con los datos correspondientes:

> **NOTA:** Para más ejemplos de simulación, consulte la colección de Postman.

```java
@Test
public void getReporteTest() throws ApiException {

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
```

### Paso 3. Ejecutar la prueba unitaria

Teniendo los pasos anteriores ya solo falta ejecutar la prueba unitaria, con el siguiente comando:

```shell
mvn test -Dmaven.install.skip=true
```

