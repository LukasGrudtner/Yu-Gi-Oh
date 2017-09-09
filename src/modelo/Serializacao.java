package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacao {
	
	public void salvaArquivo(Pontuacao pontuacao) {
		FileOutputStream arquivoGrav;
		try{
			arquivoGrav = new FileOutputStream("resources" + File.separator + "arquivo" + File.separator + "Dados");
			ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
			objGravar.writeObject(pontuacao);
			arquivoGrav.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Pontuacao abreArquivo() {
		Pontuacao pontuacao;
		try {
			FileInputStream arquivoLeitura;
			arquivoLeitura = new FileInputStream("resources" + File.separator + "arquivo" + File.separator + "Dados");
			ObjectInputStream objLeitura = new ObjectInputStream(arquivoLeitura);
			pontuacao = (Pontuacao) objLeitura.readObject();
			arquivoLeitura.close();
			return pontuacao;
		} catch (Exception e) {
			return new Pontuacao();
		}
	}

}
