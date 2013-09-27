

import java.util.Arrays;
import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.learning.DataSet;
import org.neuroph.core.learning.DataSetRow;
import org.neuroph.nnet.MultiLayerPerceptron;
import org.neuroph.nnet.learning.MomentumBackpropagation;
import org.neuroph.util.TransferFunctionType;

public class ClassificacaoVinhos {

  
    public static void main(String[] args) {

    	
    	long t0 = System.currentTimeMillis();
    	
         CrossCreate data = new CrossCreate(20);
        // criando o perceptron
        System.out.println("Criando a rede neural");
        MultiLayerPerceptron neuralNet = new MultiLayerPerceptron(TransferFunctionType.SIGMOID, 13, 2, 3);

        // setando os parametros de aprendizado
        MomentumBackpropagation learningRule = (MomentumBackpropagation) neuralNet.getLearningRule();
        learningRule.setLearningRate(0.2);
        learningRule.setMomentum(0.7);
        
        
        // treinando a rede
        System.out.println("Treinando a rede Neural...");
        neuralNet.learn(data.getTreino());
       

        // teste
        System.out.println("Testando a rede Neural");
        teste(neuralNet, data.getTeste());
        
        long tf = System.currentTimeMillis();
        System.out.print("Tempo total: ");
        System.out.println(tf-t0);

    }

    public static void teste(NeuralNetwork nnet, DataSet dset) {
        for (DataSetRow trainingElement : dset.getRows()) {
            nnet.setInput(trainingElement.getInput());
            nnet.calculate();
            double[] networkOutput = nnet.getOutput();
            System.out.print("Input: " + Arrays.toString(trainingElement.getInput()));
            System.out.println(" Output: " + Tradutor.classe(networkOutput));
        }



    }
}