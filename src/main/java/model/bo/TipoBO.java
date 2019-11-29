package model.bo;

import java.util.ArrayList;

import model.dao.TipoDAO;
import model.vo.Tipo;

public class TipoBO {

	public ArrayList<Tipo> consultarTipoBO() {
		TipoDAO tipoDAO = new TipoDAO();
		ArrayList<Tipo> tipoVO = tipoDAO.consultarTodos();
		if (tipoVO.isEmpty()) {
			System.out.println("\n Lista de clientes está vazia.");
		}
		return tipoVO;
	}

}
