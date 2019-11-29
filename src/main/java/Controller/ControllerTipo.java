package Controller;

import java.util.ArrayList;

import model.bo.TipoBO;
import model.vo.Tipo;

public class ControllerTipo {

	public ArrayList<Tipo> consultarTodosTiposController() {
		TipoBO tipoBO = new TipoBO();
		return tipoBO.consultarTipoBO();
	}

}
