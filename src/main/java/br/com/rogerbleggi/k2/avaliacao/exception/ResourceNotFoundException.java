package br.com.rogerbleggi.k2.avaliacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
   
	private static final long serialVersionUID = 1L;

	private String apiResourceName;
    private String resourceFieldName;
    private Object resourceFieldValue;

    public ResourceNotFoundException( String apiResourceName, String resourceFieldName, Object resourceFieldValue) {
        super(String.format("%s não foi encontrado pesquisando pelo campo %s : '%s'", apiResourceName, resourceFieldName, resourceFieldValue));
        this.apiResourceName = apiResourceName;
        this.resourceFieldName = resourceFieldName;
        this.resourceFieldValue = resourceFieldValue;
    }

    public String getApiResourceName() {
        return apiResourceName;
    }

    public String getResourceFieldName() {
        return resourceFieldName;
    }

    public Object getResourceFieldValue() {
        return resourceFieldValue;
    }
}

