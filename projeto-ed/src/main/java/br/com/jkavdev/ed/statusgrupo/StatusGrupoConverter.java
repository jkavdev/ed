package br.com.jkavdev.ed.statusgrupo;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class StatusGrupoConverter implements Converter {

	@Inject
	private StatusGrupoService service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		StatusGrupo retorno = null;

		if (value != null) {
			retorno = service.peloId(new Long(value));
		}

		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((StatusGrupo) value).getId();
			String retorno = codigo == null ? null : codigo.toString();

			return retorno;
		}

		return "";
	}

}
