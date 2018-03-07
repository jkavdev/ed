package br.com.jkavdev.ed.integrante;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class IntegranteConverter implements Converter {

	@Inject
	private IntegranteService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Integrante retorno = null;

		if (value != null) {
			retorno = service.peloId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Integrante) value).getId();
			String retorno = codigo == null ? null : codigo.toString();

			return retorno;
		}

		return "";
	}

}
