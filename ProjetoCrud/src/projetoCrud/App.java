package projetoCrud;

import javax.swing.*;

import projetoCrud.dao.IOrdemDeServicoDAO;
import projetoCrud.dao.OrdemDeServicoMapDAO;
import projetoCrud.domain.OrdemDeServico;

public class App {
	
	private static IOrdemDeServicoDAO iOrdemDeServicoDAO;

	public static void main(String[] args) {
		iOrdemDeServicoDAO = new OrdemDeServicoMapDAO();
		
		String opcao = JOptionPane.showInputDialog(null,
				"Digite 1 para CADASTRO, 2 para CONSULTA, 3 para ALTERAÇÃO, 4 para EXCLUSÃO e 5 para SAIR.",
				"MENU",
				JOptionPane.INFORMATION_MESSAGE);
		
		int opcaoInt = Integer.parseInt(opcao);
		
		while (opcaoInt >= 0 && opcaoInt <= 5) {
			if (opcaoInt == 1) {
				String dados = JOptionPane.showInputDialog(null,
						"Digite os dados separados por ',' neste formato: OS,equipamento,defeito,solucao",
						"MENU",
						JOptionPane.INFORMATION_MESSAGE);
				cadastro(dados);
				
				} else if (opcaoInt == 2) {
					String dados = JOptionPane.showInputDialog(null,
							"Digite a OS para ser consultada: ",
							"Consultar",
							JOptionPane.INFORMATION_MESSAGE);
					consulta(dados);
					
				} else if (opcaoInt == 3) {
					String dados = JOptionPane.showInputDialog(null,
							"Digite os dados separados por ',' neste formato: OS,equipamento,defeito,solucao",
							"ALTERAR",
							JOptionPane.INFORMATION_MESSAGE);
					atualizar(dados);
					
				}else if (opcaoInt == 4) {
					String dados = JOptionPane.showInputDialog(null,
							"Digite a OS para ser deletada: ",
							"Excluir",
							JOptionPane.INFORMATION_MESSAGE);
					excluir(dados);
					
				}else if (opcaoInt == 5) {
					sair();
				}
			}
		
		validaOpcaoDiferente(opcao);
	
		}
	
	private static void consulta(String dados) {
		
		OrdemDeServico ordemdeservico = iOrdemDeServicoDAO.consultar(Long.parseLong(dados));
		if (ordemdeservico != null) {
			JOptionPane.showMessageDialog(null, "OS: " + ordemdeservico.toString(), "Consulta", JOptionPane.INFORMATION_MESSAGE);
			main(null);
		} else {
			JOptionPane.showMessageDialog(null, "OS não encontrada. " , "Consulta", JOptionPane.INFORMATION_MESSAGE);
			main(null);
		}
		
	} 

	private static void validaOpcaoDiferente(String opcao) {
		int opcaoInt = Integer.parseInt(opcao);
		while (opcaoInt > 5 || opcaoInt < 0) {
			opcao = JOptionPane.showInputDialog(null,
					//Digite 1 para CADASTRO, 2 para CONSULTA, 3 para ALTERAÇÃO, 4 para EXCLUSÃO e 5 para SAIR.
					"OPÇÃO INVÁLIDA. Digite 0 para volta.",
					"MENU",
					JOptionPane.INFORMATION_MESSAGE);
			 opcaoInt = Integer.parseInt(opcao);
		} main(null);
	}

	private static void sair() {
		JOptionPane.showMessageDialog(null, "Fechando", "Sair", JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);
		
	}
	
	private static void cadastro(String dados) {
		String[] separaDados = dados.split(",");
		OrdemDeServico ordemdeservico = new OrdemDeServico(separaDados[0], separaDados[1], separaDados[2], separaDados[3]);
		Boolean cadastrado = iOrdemDeServicoDAO.cadastrar(ordemdeservico);
		if(cadastrado) {
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "OS em uso", "ALERTA", JOptionPane.INFORMATION_MESSAGE);
		} 
		main(null);

	}
	
	private static void atualizar(String dados) {
        String[] separaDados = dados.split(",");
        OrdemDeServico ordemdeservico = new OrdemDeServico(separaDados[0], separaDados[1], separaDados[2], separaDados[3]);
        iOrdemDeServicoDAO.alterar(ordemdeservico);
    }

    private static void excluir(String dados) {
    	iOrdemDeServicoDAO.excluir(Long.parseLong(dados));
        JOptionPane.showMessageDialog(null, "OS excluída com sucesso: ", "Sucesso",JOptionPane.INFORMATION_MESSAGE);
    }

	
}
	
	
