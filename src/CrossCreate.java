import java.io.FileNotFoundException;
import java.io.IOException;

import org.neuroph.core.learning.DataSet;
import org.neuroph.util.TrainingSetImport;

public class CrossCreate {

	private DataSet teste;
	private DataSet treino;

	CrossCreate(int porcentagem) {

		String trainingSetFileName = "WineClassification.txt";
		int inputsCount = 13;
		int outputsCount = 3;

		System.out.println("Usando o Conjunto de Treino : "
				+ trainingSetFileName);

		
		DataSet dataSet = null;
		try {
			dataSet = TrainingSetImport.importFromFile(trainingSetFileName,
					inputsCount, outputsCount, ",");
		} catch (FileNotFoundException ex) {
			System.out.println("Arquivo n�o encontrado");
		} catch (IOException | NumberFormatException ex) {
			System.out.println("Erro de leitura de Arquivo");
		}

		int amostra = (int) (porcentagem * dataSet.size()) / 100;

		treino = new DataSet(inputsCount);
		teste = new DataSet(inputsCount);

		for (int i = 0; i < amostra; i++) {

			treino.addRow(dataSet.getRowAt(i));

		}

		for (int j = amostra; j < dataSet.size(); j++) {

			teste.addRow(dataSet.getRowAt(j));

		}

		System.out.println(treino.size());
		System.out.println(teste.size());

	}

	public DataSet getTeste() {
		
		return teste;
		
	}

	public DataSet getTreino() {
		
		return treino;
		
	}

}
